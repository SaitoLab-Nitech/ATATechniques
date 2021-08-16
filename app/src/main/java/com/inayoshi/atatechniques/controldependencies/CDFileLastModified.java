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

import android.util.Log;

import java.io.File;
import com.inayoshi.atatechniques.MainActivity;

public class CDFileLastModified {
    public static String trick(String in, File filesDir) {
        String out = "";

        String filename = "secret.txt";
        long time = 1310198774000L;
        File file = new File(filesDir, filename);

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                try {
                    file.createNewFile();
                    file.setLastModified(time);

                    if (in.charAt(i) == j) {
                        file.setLastModified(time + 1000);
                    }

                    if (file.lastModified() != time) {
                        out = out + (char) j;
                    }
                } catch (Exception e) {
                    Log.i(MainActivity.TAG, Log.getStackTraceString(e));
                }
            }
        }

        return out;
    }
}
