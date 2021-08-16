package com.inayoshi.atatechniques.directassignments;

import android.widget.TextView;

public class TextScaling {
    public static String trick(String in, TextView textView) {
        String out = "";
        TextView textViewChannel;

        for (int i = 0; i < in.length(); i++) {
            textViewChannel = textView;
            textViewChannel.setTextScaleX(in.charAt(i));

            textViewChannel = null;

            textViewChannel = textView;
            out = out + (char) textViewChannel.getTextScaleX();
        }

        return out;
    }

}
