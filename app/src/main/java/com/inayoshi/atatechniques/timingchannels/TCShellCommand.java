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

public class TCShellCommand {
    public static String trick(String in) {
        String out = "";
        long start;
        long end;
        String[] sleep_command;
        Runtime runtime = Runtime.getRuntime();

        try {
            for (int i = 0; i < in.length(); i++) {
                sleep_command = new String[]{"sleep", String.valueOf(in.charAt(i))};

                start = System.currentTimeMillis();
                Process p = runtime.exec(sleep_command);
                p.waitFor();
                end = System.currentTimeMillis();

                out = out + ((end - start)/1000);
            }
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
