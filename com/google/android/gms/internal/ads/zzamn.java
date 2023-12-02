package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzamn extends ByteArrayOutputStream {
    private final zzamb zza;

    public zzamn(zzamb zzambVar, int i4) {
        this.zza = zzambVar;
        ((ByteArrayOutputStream) this).buf = zzambVar.zzb(Math.max(i4, 256));
    }

    private final void zza(int i4) {
        int i5 = ((ByteArrayOutputStream) this).count;
        if (i5 + i4 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        int i6 = i5 + i4;
        byte[] zzb = this.zza.zzb(i6 + i6);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, zzb, 0, ((ByteArrayOutputStream) this).count);
        this.zza.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = zzb;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zza(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i4) {
        zza(1);
        super.write(i4);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i4, int i5) {
        zza(i5);
        super.write(bArr, i4, i5);
    }
}
