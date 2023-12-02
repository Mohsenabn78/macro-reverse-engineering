package com.android.dex.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class FileUtils {
    private FileUtils() {
    }

    public static boolean hasArchiveSuffix(String str) {
        if (!str.endsWith(".zip") && !str.endsWith(".jar") && !str.endsWith(".apk")) {
            return false;
        }
        return true;
    }

    public static byte[] readFile(String str) {
        return readFile(new File(str));
    }

    public static byte[] readFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    long length = file.length();
                    int i4 = (int) length;
                    if (i4 == length) {
                        byte[] bArr = new byte[i4];
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            int i5 = 0;
                            while (i4 > 0) {
                                int read = fileInputStream.read(bArr, i5, i4);
                                if (read == -1) {
                                    throw new RuntimeException(file + ": unexpected EOF");
                                }
                                i5 += read;
                                i4 -= read;
                            }
                            fileInputStream.close();
                            return bArr;
                        } catch (IOException e4) {
                            throw new RuntimeException(file + ": trouble reading", e4);
                        }
                    }
                    throw new RuntimeException(file + ": file too long");
                }
                throw new RuntimeException(file + ": file not readable");
            }
            throw new RuntimeException(file + ": not a file");
        }
        throw new RuntimeException(file + ": file not found");
    }
}
