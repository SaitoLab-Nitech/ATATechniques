package com.inayoshi.atatechniques.memoryoperations;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ReverseDirectBuffer {
    public static String trick(String in) {
        String out = "";
        byte mark = 'a';

        for (int i = 0; i < in.length(); i++) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(256).order(ByteOrder.BIG_ENDIAN);
            
            byteBuffer.put(in.charAt(i), mark);

            for (int j = 0; j < 256; j++) {
                if (byteBuffer.get(j) == mark) {
                    out = out + (char) j;
                    break;
                }
            }
        }

        return out;
    }
}
