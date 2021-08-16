package com.inayoshi.atatechniques.controldependencies;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CDDirectBuffer {
    public static String trick(String in) {
        String out = "";
        byte data;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(256).order(ByteOrder.BIG_ENDIAN);

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                byteBuffer.put(10, (byte) 0);
                if (in.charAt(i) == j) {
                    byteBuffer.put(10, (byte) 1);
                }

                data = byteBuffer.get(10);
                if (data == 1) {
                    out = out + (char) j;
                }
            }
        }

        return out;
    }

}
