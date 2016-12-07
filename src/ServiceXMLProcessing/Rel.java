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

/**
 * @author Timothy Bell
 */
public class Rel {

	public Rel(String entityName, Integer type) {
		_entityName = entityName;
		_type = type;
	}

	public String getEntityName() {
		return _entityName;
	}

	public Integer getType() {
		return _type;
	}

	public void setType(Integer type) {
		_type = type;
	}

	public void setEntityName(String entityName) {
		_entityName = entityName;
	}

	private String _entityName = null;
	private Integer _type = 0;

	public static int TYPE_DIRECT = 0;
	public static int TYPE_MAPPING = 1;
	public static int TYPE_MANUAL = 2;


}
