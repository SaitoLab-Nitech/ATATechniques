package com.inayoshi.atatechniques.controldependencies;

import android.content.ClipboardManager;

public class CDClipboardLength {
    public static String trick(String in, ClipboardManager clipboardManager) {
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            String string = "";
            for (int j = 0; j < in.charAt(i); j++) {
                string = string + "A";
            }

            clipboardManager.setText(string);
            String data = (String) clipboardManager.getText();
            out = out + (char) data.length();
        }

        return out;
    }
}
