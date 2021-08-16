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

import android.graphics.Bitmap;

public class CDBitmapPixel {
    public static String trick(String in) {
        String out = "";
        int color;
        Bitmap bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                bitmap.setPixel(10, 10, 0xFFFF0000);

                if (in.charAt(i) == j) {
                    bitmap.setPixel(10, 10, 1 ^ 0xFFFF0000);
                }

                color = bitmap.getPixel(10, 10) ^ 0xFFFF0000;
                if (color == 1) {
                    out = out + (char) j;
                }
            }
        }

        return out;
    }
}
