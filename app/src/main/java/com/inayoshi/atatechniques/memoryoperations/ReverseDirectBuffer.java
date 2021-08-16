/*
    Test suite with anti-taint-analysis techniques.
    Copyright (C) 2021  Nagoya Institute of Technology, Hiroki Inayoshi

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package com.inayoshi.atatechniques.memoryoperations;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ReverseDirectBuffer {
    public static String trick(String in) {
        String out = "";
        byte mark = 'a';

        for (int i = 0; i < in.length(); i++) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(256).order(ByteOrder.BIG_ENDIAN);
            
            byteBuffer.put(in.charAt(i), mark);

            for (int j = 0; j < 256; j++) {
                if (byteBuffer.get(j) == mark) {
                    out = out + (char) j;
                    break;
                }
            }
        }

        return out;
    }
}
