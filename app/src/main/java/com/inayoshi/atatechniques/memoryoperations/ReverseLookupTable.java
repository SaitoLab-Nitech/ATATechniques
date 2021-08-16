package com.inayoshi.atatechniques.memoryoperations;

public class ReverseLookupTable {
    public static String trick(String in) {
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            char symbolTable[] = new char[256];

            symbolTable[in.charAt(i)] = 'a';

            for (int j = 0; j < symbolTable.length; j++) {
                if (symbolTable[j] == 'a') {
                    out = out + (char) j;
                    break;
                }
            }
        }

        return out;
    }
}
