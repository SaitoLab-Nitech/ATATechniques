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

package com.inayoshi.atatechniques.timingchannels;

import android.util.Log;
import com.inayoshi.atatechniques.MainActivity;

public class Timekeeper {
    public static String trick(String in) {
        String out = "";
        long start;
        long end;

        try {
            for (int i = 0; i < in.length(); i++) {
                start = System.currentTimeMillis();
                Thread.sleep(100 * in.charAt(i));
                end = System.currentTimeMillis();

                out = out + (char) ((end - start) / 100);
            }
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
