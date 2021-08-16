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

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import com.inayoshi.atatechniques.MainActivity;

public class FileLength {
    public static String trick(String in, File filesDir) {
        String out = "";
        String filename = "secret.txt";

        for (int i = 0; i < in.length(); i++) {
            String string = TextUtils.join("", Collections.nCopies(in.charAt(i), "A"));

            try {
                File file = new File(filesDir, filename);

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(string.getBytes());

                file = null;

                file = new File(filesDir, filename);

                out += (char) file.length();
                file.delete();
            } catch (Exception e) {
                Log.i(MainActivity.TAG, Log.getStackTraceString(e));
            }
        }
        return out;
    }
}
