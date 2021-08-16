package com.inayoshi.atatechniques.controldependencies;

import android.widget.TextView;

public class CDTextScaling {
    public static String trick(String in, TextView textView) {
        String out = "";
        TextView textViewChannel;

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                textViewChannel = textView;
                textViewChannel.setTextScaleX(0);

                if (in.charAt(i) == j) {
                    textViewChannel.setTextScaleX(1);
                }

                textViewChannel = null;

                textViewChannel = textView;
                if (textViewChannel.getTextScaleX() == 1) {
                    out = out + (char) j;
                }
            }
        }

        return out;
    }
}
