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

    public Rel (Entity entity, String type) {
        setEntity(entity);
        setType(type);
    }

    public Entity getEntity() {
        return _entity;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public void setEntity(Entity entity) {
        _entity = entity;
    }

    private Entity _entity = null;
    private String _type = "";

}
