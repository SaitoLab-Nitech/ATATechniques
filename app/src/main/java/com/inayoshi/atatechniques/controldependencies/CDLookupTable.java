package com.inayoshi.atatechniques.controldependencies;

public class CDLookupTable {
    public static String trick(String in) {
        String out = "";
        char table[] = new char[256];
        int index = 10;

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                table[index] = 0;

                if (in.charAt(i) == j) {
                    table[index] = 1;
                }

                if (table[index] == 1) {
                    out = out + (char) j;
                }
            }
        }

        return out;
    }
}
