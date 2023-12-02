package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzbv extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f22716a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile zzbe f22717b;

    public zzbv(OutputStream outputStream) {
        this.f22716a = (OutputStream) Preconditions.checkNotNull(outputStream);
    }

    private final IOException c(IOException iOException) {
        zzbe zzbeVar = this.f22717b;
        if (zzbeVar != null) {
            Log.isLoggable("ChannelOutputStream", 2);
            return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzbeVar.f22685a, zzbeVar.f22686b);
        }
        return iOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzbe zzbeVar) {
        this.f22717b = zzbeVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            this.f22716a.close();
        } catch (IOException e4) {
            throw c(e4);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            this.f22716a.flush();
        } catch (IOException e4) {
            throw c(e4);
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i4) throws IOException {
        try {
            this.f22716a.write(i4);
        } catch (IOException e4) {
            throw c(e4);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        try {
            this.f22716a.write(bArr);
        } catch (IOException e4) {
            throw c(e4);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i4, int i5) throws IOException {
        try {
            this.f22716a.write(bArr, i4, i5);
        } catch (IOException e4) {
            throw c(e4);
        }
    }
}
