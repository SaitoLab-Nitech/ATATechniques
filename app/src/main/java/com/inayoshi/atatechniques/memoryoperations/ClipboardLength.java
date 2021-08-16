package com.inayoshi.atatechniques.memoryoperations;

import android.content.ClipboardManager;
import android.text.TextUtils;

import java.util.Collections;

public class ClipboardLength {
    public static String trick(String in, ClipboardManager clipboardManager) {
        String out = "";
        ClipboardManager clipboardChannel = clipboardManager;

        for (int i = 0; i < in.length(); i++) {
            String string = TextUtils.join("", Collections.nCopies(in.charAt(i), "A"));

            clipboardChannel.setText(string);
            clipboardChannel = null;

            clipboardChannel = clipboardManager;

            String data = (String) clipboardChannel.getText();
            out = out + (char) data.length();
        }
        return out;
    }
}
