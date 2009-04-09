/*
 * Copyright (C) 2007-2009 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.zlibrary.text.model;

import java.util.*;
import org.geometerplus.zlibrary.core.util.*;

final class SimpleCharStorage implements CharStorage {
	private final int myBlockSize;
	private final ArrayList<char[]> myArray = new ArrayList<char[]>(1024);

	SimpleCharStorage(int blockSize) {
		myBlockSize = blockSize;
	}

	public int size() {
		return myArray.size();
	}

	public char[] block(int index) {
		return myArray.get(index);
	}

	public char[] createNewBlock(int minimumLength) {
		int blockSize = myBlockSize;
		if (minimumLength > blockSize) {
			blockSize = minimumLength;
		}
		char[] block = new char[blockSize];
		myArray.add(block);
		return block;
	}

	public void freezeLastBlock() {
	}

	public void clear() {
		myArray.clear();
	}
}