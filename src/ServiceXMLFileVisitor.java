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
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author wnewbury
 */
public class ServiceXMLFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult visitFile(
		Path filePath, BasicFileAttributes attrs)
		throws IOException {

		String path = filePath.toString();

		if (!path.matches(".*service.*\\.xml")) {
			return FileVisitResult.CONTINUE;
		}

		System.out.println("########################## Found Service XML: " + path);

		return FileVisitResult.CONTINUE;
	}

}