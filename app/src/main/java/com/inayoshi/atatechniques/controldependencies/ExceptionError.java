package com.inayoshi.atatechniques.controldependencies;

public class ExceptionError {
	public static String trick(String in) {
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            int k = 0;
            while (true) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    k = k + 1;
                    if (k == in.charAt(i)) {
                        break;
                    }
                }
            }
            out = out + (char) k;
        }

        return out;
    }
}
