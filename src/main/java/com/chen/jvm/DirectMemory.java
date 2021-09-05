package com.chen.jvm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DirectMemory {

    public static final String FROM = "";
    public static final String TO = "";
    public static final int _1MB = 1024 * 1024;

    private static void directBuffer() {
        long start = System.currentTimeMillis();
        try {
            FileChannel from = new FileInputStream(FROM).getChannel();
            FileChannel to = new FileOutputStream(TO).getChannel();
            ByteBuffer bb = ByteBuffer.allocate(_1MB);
            while (true) {
                int len = from.read(bb);
                if (len == -1) {
                    break;
                }
                bb.flip();
                to.write(bb);
                bb.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("directBuffer 用时: " + System.currentTimeMillis());
    }

    private static void io() {
        long start = System.currentTimeMillis();
        try (FileInputStream from = new FileInputStream(FROM);
             FileOutputStream to = new FileOutputStream(TO);
        ) {
            byte[] buf = new byte[_1MB];
            while (true) {
                int len = from.read(buf);
                if (len == -1) {
                    break;
                }
                to.write(buf, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("io 用时：" + (end-start));
    }

}
