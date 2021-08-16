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

public class ExceptionError {
	public static String trick(String in) {
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            int k = 0;
            while (true) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    k = k + 1;
                    if (k == in.charAt(i)) {
                        break;
                    }
                }
            }
            out = out + (char) k;
        }

        return out;
    }
}
