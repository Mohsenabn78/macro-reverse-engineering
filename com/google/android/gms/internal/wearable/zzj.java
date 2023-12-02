package com.google.android.gms.internal.wearable;

import android.os.ParcelFileDescriptor;
import androidx.work.Data;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzj {
    public static File zza(ParcelFileDescriptor parcelFileDescriptor, File file) throws IOException {
        FileOutputStream fileOutputStream;
        IOException e4;
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        try {
            file.mkdirs();
            File createTempFile = File.createTempFile("asset", ".tmp", file);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(createTempFile);
            } catch (IOException e5) {
                fileOutputStream = null;
                e4 = e5;
            } catch (Throwable th) {
                th = th;
                zzb(autoCloseInputStream);
                zzb(fileOutputStream2);
                createTempFile.delete();
                throw th;
            }
            try {
                try {
                    byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                    while (true) {
                        int read = autoCloseInputStream.read(bArr);
                        if (read < 0) {
                            zzb(autoCloseInputStream);
                            zzb(fileOutputStream);
                            return createTempFile;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Throwable th2) {
                    FileOutputStream fileOutputStream3 = fileOutputStream;
                    th = th2;
                    fileOutputStream2 = fileOutputStream3;
                    zzb(autoCloseInputStream);
                    zzb(fileOutputStream2);
                    createTempFile.delete();
                    throw th;
                }
            } catch (IOException e6) {
                e4 = e6;
                throw new RuntimeException(e4);
            }
        } finally {
            zzb(autoCloseInputStream);
        }
    }

    private static void zzb(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
