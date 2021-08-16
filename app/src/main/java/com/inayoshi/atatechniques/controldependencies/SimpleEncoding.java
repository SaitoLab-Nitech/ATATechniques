package com.inayoshi.atatechniques.controldependencies;

public class SimpleEncoding {
    public static String trick(String in) {
        String out = "";
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ~`!@#$%^&*()-=_+[]{}" +
                "\\|;',./:\"<>?";

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < symbols.length(); j++) {
                if (in.charAt(i) == symbols.charAt(j)) {
                    out = out + symbols.charAt(j);
                }
            }
        }

        return out;
    }
}
