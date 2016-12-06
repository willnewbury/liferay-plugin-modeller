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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Will Newbury
 */
public class ServiceXMLProcessor {

	public static void main(String[] args) throws IOException {
		String baseDir = args[0];

		ServiceXMLFileVisitor serviceXMLFileVisitor = new ServiceXMLFileVisitor();

		Files.walkFileTree(Paths.get(baseDir), serviceXMLFileVisitor);
	}

}