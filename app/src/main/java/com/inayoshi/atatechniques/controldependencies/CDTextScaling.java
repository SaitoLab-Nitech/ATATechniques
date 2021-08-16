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

import android.widget.TextView;

public class CDTextScaling {
    public static String trick(String in, TextView textView) {
        String out = "";
        TextView textViewChannel;

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                textViewChannel = textView;
                textViewChannel.setTextScaleX(0);

                if (in.charAt(i) == j) {
                    textViewChannel.setTextScaleX(1);
                }

                textViewChannel = null;

                textViewChannel = textView;
                if (textViewChannel.getTextScaleX() == 1) {
                    out = out + (char) j;
                }
            }
        }

        return out;
    }
}
