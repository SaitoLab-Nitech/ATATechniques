package com.inayoshi.atatechniques.controldependencies;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.inayoshi.atatechniques.MainActivity;

public class CDShellCommand {
    public static String trick(String in) {
        String out = "";
        String[] cmd = new String[]{"/system/bin/sh", "-c", "echo 0"};
        Runtime runtime = Runtime.getRuntime();
        BufferedReader bufferedReader;

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                try {
                    cmd[2] = "echo 0";

                    if (in.charAt(i) == j) {
                        cmd[2] = "echo 1";
                    }

                    bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream()));
                    if (bufferedReader.readLine().contains("1")) {
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
