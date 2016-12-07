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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author Timothy Bell
 */
public class ERDAdaptor {

	public static void processEntities(List<Entity> entities)
		throws IOException {

		File file = new File(_fileName);

		BufferedWriter writer = new BufferedWriter(
			new OutputStreamWriter(new FileOutputStream(file), "utf-8"));

		try {
			for (Entity entity: entities) {
				writer.write("[" + entity.getName() + "]\n");

				for (Column column: entity.getColumns()) {
					writer.write("\t");

					if (column.isPrimary()) {
						writer.write("*");
					}

					writer.write(column.getName());
					writer.write(" {label:\"" + column.getType() + "\"}\n");
				}
			}

			for (Entity entity: entities) {
				for (Rel rel: entity.getRels()) {
					if (rel.getType() == Rel.TYPE_MAPPING) {
						writer.write(entity.getName() + " *--* ");
					}
					else {
						writer.write(entity.getName() + " *--1 ");
					}

					writer.write(rel.getEntityName() + "\n");
				}
			}

			writer.flush();
		}
		finally {
			writer.close();
		}

	}

	private static String _fileName = "output/ServiceXMLProcessing.er";
}