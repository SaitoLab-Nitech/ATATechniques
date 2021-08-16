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

package com.inayoshi.atatechniques.directassignments;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import com.inayoshi.atatechniques.MainActivity;

public class FileShellHybrid {
    public static String trick(String in, File filesDir) {
        String out = "";
        String filename = "secret.txt";
        File file = new File(filesDir, filename);
        String filepath = file.getAbsolutePath();

        String[] cmd = new String[]{"cat", filepath};
        Runtime runtime = Runtime.getRuntime();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(in.getBytes());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream()));
            out = bufferedReader.readLine();
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
