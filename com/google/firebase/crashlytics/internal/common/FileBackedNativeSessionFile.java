package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes5.dex */
class FileBackedNativeSessionFile implements NativeSessionFile {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final File f29524a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f29525b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f29526c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f29525b = str;
        this.f29526c = str2;
        this.f29524a = file;
    }

    @Nullable
    private byte[] d() {
        byte[] bArr = new byte[8192];
        try {
            InputStream b4 = b();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            if (b4 == null) {
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                if (b4 != null) {
                    b4.close();
                }
                return null;
            }
            while (true) {
                try {
                    int read = b4.read(bArr);
                    if (read > 0) {
                        gZIPOutputStream.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        b4.close();
                        return byteArray;
                    }
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @NonNull
    public String a() {
        return this.f29526c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    public InputStream b() {
        if (this.f29524a.exists() && this.f29524a.isFile()) {
            try {
                return new FileInputStream(this.f29524a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    public CrashlyticsReport.FilesPayload.File c() {
        byte[] d4 = d();
        if (d4 != null) {
            return CrashlyticsReport.FilesPayload.File.builder().setContents(d4).setFilename(this.f29525b).build();
        }
        return null;
    }
}
