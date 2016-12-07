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
public class Column {

	public Column (boolean isPrimary, String name, String type) {
		_isPrimary = isPrimary;
		_name = name;
		_type = type;
	}
	public boolean isPrimary() {
		return _isPrimary;
	}

	public String getName() {
		return _name;
	}

	public String getType() {
		return _type;
	}

	public void setIsPrimary(boolean isPrimary) {
		_isPrimary = isPrimary;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setType(String type) {
		_type = type;
	}

	private boolean _isPrimary = false;
	private String _name = "";
	private String _type = "";
}
