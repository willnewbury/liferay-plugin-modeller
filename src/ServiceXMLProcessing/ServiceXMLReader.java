/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package ServiceXMLProcessing;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceXMLReader {

	public static List<Entity> readFile(File file) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document doc = documentBuilder.parse(file);

		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList entityNodeList = doc.getElementsByTagName("entity");

		List<Entity> entities = new ArrayList<Entity>();

		populatePrimaryKeys(entityNodeList);

		populateColumnsAndRels(entityNodeList, entities);

		return entities;
	}

	private static void populateColumnsAndRels(NodeList entityNodeList, List<Entity> entities) throws Exception {
		for (int i = 0; i < entityNodeList.getLength(); i++) {
			Node node = entityNodeList.item(i);

			Element entityElement = (Element)node;

			String entityName = entityElement.getAttribute("name");

			NodeList childNodeList = node.getChildNodes();

			List<Column> columns = new ArrayList<Column>();
			List<Rel> relations = new ArrayList<Rel>();

			for (int j = 0; j < childNodeList.getLength(); j++) {
				Node childNode = childNodeList.item(j);

				if (childNode.getNodeType() == Node.ELEMENT_NODE) {
					Element childElement = (Element)childNode;

					Boolean mappingTable = childElement.hasAttribute("mapping_table");

					if (childElement.hasAttribute("by")) {
						continue;
					}

					String name = childElement.getAttribute("name");
					Boolean primary = Boolean.parseBoolean(childElement.getAttribute("primary"));

					if (mappingTable) {
						String mappingTableEntityName = childElement.getAttribute("entity");

						Rel rel = new Rel(mappingTableEntityName, Rel.TYPE_MAPPING);

						relations.add(rel);
					}
					else if (primaryKeyEntityMap.containsKey(name) && !primary) {
						String linkedEntityName = primaryKeyEntityMap.get(name);

						Rel rel = new Rel(linkedEntityName, Rel.TYPE_DIRECT);

						relations.add(rel);
					}

					String type = childElement.getAttribute("type");

					Column column = new Column(primary, name, type);

					columns.add(column);
				}
			}

			Entity entity = new Entity(columns, entityName, relations);

			entities.add(entity);
		}
	}

	private static void populatePrimaryKeys(NodeList entityNodeList) throws Exception {
		for (int i = 0; i < entityNodeList.getLength(); i++) {
			Node node = entityNodeList.item(i);

			Element entityElement = (Element)node;

			NodeList childNodeList = node.getChildNodes();

			for (int j = 0; j < childNodeList.getLength(); j++) {
				Node childNode = childNodeList.item(j);

				if (childNode.getNodeType() == Node.ELEMENT_NODE) {
					Element childElement = (Element)childNode;

					String name = childElement.getAttribute("name");
					Boolean primary = Boolean.parseBoolean(childElement.getAttribute("primary"));

					if (primary) {
						primaryKeyEntityMap.put(name, entityElement.getAttribute("name"));
					}
				}
			}
		}
	}

	private static Map<String, String> primaryKeyEntityMap = new HashMap<String, String>();

}