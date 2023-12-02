package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes5.dex */
class BytesBackedNativeSessionFile implements NativeSessionFile {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f29393a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f29394b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f29395c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BytesBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.f29394b = str;
        this.f29395c = str2;
        this.f29393a = bArr;
    }

    @Nullable
    private byte[] d() {
        if (e()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(this.f29393a);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean e() {
        byte[] bArr = this.f29393a;
        if (bArr != null && bArr.length != 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @NonNull
    public String a() {
        return this.f29395c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    public InputStream b() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f29393a);
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    public CrashlyticsReport.FilesPayload.File c() {
        byte[] d4 = d();
        if (d4 == null) {
            return null;
        }
        return CrashlyticsReport.FilesPayload.File.builder().setContents(d4).setFilename(this.f29394b).build();
    }
}
