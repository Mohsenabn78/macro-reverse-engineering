package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzbt extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f22713a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile zzbe f22714b;

    public zzbt(InputStream inputStream) {
        this.f22713a = (InputStream) Preconditions.checkNotNull(inputStream);
    }

    private final int c(int i4) throws ChannelIOException {
        if (i4 == -1) {
            zzbe zzbeVar = this.f22714b;
            if (zzbeVar == null) {
                return -1;
            }
            throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzbeVar.f22685a, zzbeVar.f22686b);
        }
        return i4;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f22713a.available();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzbe zzbeVar) {
        this.f22714b = (zzbe) Preconditions.checkNotNull(zzbeVar);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f22713a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i4) {
        this.f22713a.mark(i4);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f22713a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int read = this.f22713a.read();
        c(read);
        return read;
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        this.f22713a.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j4) throws IOException {
        return this.f22713a.skip(j4);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int read = this.f22713a.read(bArr);
        c(read);
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i4, int i5) throws IOException {
        int read = this.f22713a.read(bArr, i4, i5);
        c(read);
        return read;
    }
}
