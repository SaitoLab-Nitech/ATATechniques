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

package com.inayoshi.atatechniques.controldependencies;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CDDirectBuffer {
    public static String trick(String in) {
        String out = "";
        byte data;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(256).order(ByteOrder.BIG_ENDIAN);

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                byteBuffer.put(10, (byte) 0);
                if (in.charAt(i) == j) {
                    byteBuffer.put(10, (byte) 1);
                }

                data = byteBuffer.get(10);
                if (data == 1) {
                    out = out + (char) j;
                }
            }
        }

        return out;
    }

}
