package com.facebook.stetho.common;

import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class ProcessUtil {
    private static final int CMDLINE_BUFFER_SIZE = 64;
    private static String sProcessName;
    private static boolean sProcessNameRead;

    @Nullable
    public static synchronized String getProcessName() {
        String str;
        synchronized (ProcessUtil.class) {
            if (!sProcessNameRead) {
                sProcessNameRead = true;
                try {
                    sProcessName = readProcessName();
                } catch (IOException unused) {
                }
            }
            str = sProcessName;
        }
        return str;
    }

    private static int indexOf(byte[] bArr, int i4, int i5, byte b4) {
        for (int i6 = 0; i6 < bArr.length; i6++) {
            if (bArr[i6] == b4) {
                return i6;
            }
        }
        return -1;
    }

    private static String readProcessName() throws IOException {
        int read;
        byte[] bArr = new byte[64];
        FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
        boolean z3 = false;
        try {
            read = fileInputStream.read(bArr);
        } catch (Throwable th) {
            th = th;
        }
        try {
            int indexOf = indexOf(bArr, 0, read, (byte) 0);
            if (indexOf > 0) {
                read = indexOf;
            }
            String str = new String(bArr, 0, read);
            Util.close(fileInputStream, false);
            return str;
        } catch (Throwable th2) {
            th = th2;
            z3 = true;
            Util.close(fileInputStream, true ^ z3);
            throw th;
        }
    }
}
