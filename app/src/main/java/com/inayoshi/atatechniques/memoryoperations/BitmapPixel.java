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

import android.graphics.Bitmap;

public class BitmapPixel {
    public static String trick(String in) {
        String out = "";
        int y;
        Bitmap bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < in.length(); i++) {
            y = in.charAt(i) ^ 0xFFFF0000;
            bitmap.setPixel(10, 10, y);

            out = out + (char) (bitmap.getPixel(10, 10) ^ 0xFFFF0000);
        }

        return out;
    }
}
