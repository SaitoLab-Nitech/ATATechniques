package com.inayoshi.atatechniques.controldependencies;

public class CountToX {
    public static String trick(String in) {
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            int y = 0;
            for (int j = 0; j < (int) in.charAt(i); j++) {
                y += 1;
            }
            out = out + (char) y;
        }

        return out;
    }
}
