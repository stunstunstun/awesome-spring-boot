package com.stunstun.spring;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author minhyeok
 */
public class FileUtils {

    public static final int FILE_BUFFER_SIZE = 1024;

    public static byte[] getByteArray(Class clazz, String fileName) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[FILE_BUFFER_SIZE];
        try (InputStream inputStream = clazz.getResourceAsStream(fileName)) {
            int n;
            while ((n = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, n);
            }
        } finally {
            if (bos != null)
                bos.close();
        }
        return bos.toByteArray();
    }
}
