package com.google.mlkit.nl.translate.internal;

import java.io.File;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(File file) throws IOException {
        synchronized (zzd.class) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    throw new IOException(String.valueOf(file).concat(" exists, but is not a directory"));
                }
            } else if (!file.mkdirs()) {
                throw new IOException("Can not create directory ".concat(String.valueOf(file)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, boolean z3) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                c(file2, true);
            }
        }
        if (z3 && !file.delete()) {
            return false;
        }
        return true;
    }
}
