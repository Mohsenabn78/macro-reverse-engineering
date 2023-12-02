package com.google.android.gms.internal.mlkit_translate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzav {
    private static final OutputStream zza = new zzau();

    public static long zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j4;
            }
            outputStream.write(bArr, 0, read);
            j4 += read;
        }
    }
}
