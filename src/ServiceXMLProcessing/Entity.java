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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timothy Bell
 */
public class Entity {

    public Entity(List<Column> columns, String name, List<Rel> rels) {
        setColumns(columns);
        setName(name);
        setRels(rels);
    }

    public List<Column> getColumns() {
        return _columns;
    }

    public String getName() {
        return _name;
    }

    public List<Rel> getRels() {
        return _rels;
    }

    public void setColumns(List<Column> columns) {
        _columns = columns;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setRels(List<Rel> rels) {
        _rels = rels;
    }

    private List<Column> _columns = new ArrayList<Column>();
    private String _name = "";
    private List<Rel> _rels = new ArrayList<Rel>();
}