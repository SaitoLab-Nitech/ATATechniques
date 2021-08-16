package com.inayoshi.atatechniques.timingchannels;

public class TCExceptionError {
    public static String trick(String in) {
        String out = "";
        int x;
        long start;
        long end;
        long elapsed;

        for (int i = 0; i < in.length(); i++) {
            x = in.charAt(i) * 100;
            start = System.currentTimeMillis();

            while (true) {
                end = System.currentTimeMillis();
                if ((end - start) >= x) { break; }
            }

            elapsed = (end - start) / 100;
            out = out + (char) elapsed;
        }

        return out;
    }
}
