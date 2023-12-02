package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgob extends OutputStream {
    private static final byte[] zza = new byte[0];
    private int zzd;
    private int zzf;
    private final int zzb = 128;
    private final ArrayList zzc = new ArrayList();
    private byte[] zze = new byte[128];

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgob(int i4) {
    }

    private final void zzd(int i4) {
        this.zzc.add(new zzgoa(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i4, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza()));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i4) {
        if (this.zzf == this.zze.length) {
            zzd(1);
        }
        byte[] bArr = this.zze;
        int i5 = this.zzf;
        this.zzf = i5 + 1;
        bArr[i5] = (byte) i4;
    }

    public final synchronized int zza() {
        return this.zzd + this.zzf;
    }

    public final synchronized zzgoe zzb() {
        int i4 = this.zzf;
        byte[] bArr = this.zze;
        if (i4 < bArr.length) {
            if (i4 > 0) {
                this.zzc.add(new zzgoa(Arrays.copyOf(bArr, i4)));
            }
        } else {
            this.zzc.add(new zzgoa(this.zze));
            this.zze = zza;
        }
        this.zzd += this.zzf;
        this.zzf = 0;
        return zzgoe.zzu(this.zzc);
    }

    public final synchronized void zzc() {
        this.zzc.clear();
        this.zzd = 0;
        this.zzf = 0;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i6 = this.zzf;
        int i7 = length - i6;
        if (i5 <= i7) {
            System.arraycopy(bArr, i4, bArr2, i6, i5);
            this.zzf += i5;
            return;
        }
        System.arraycopy(bArr, i4, bArr2, i6, i7);
        int i8 = i5 - i7;
        zzd(i8);
        System.arraycopy(bArr, i4 + i7, this.zze, 0, i8);
        this.zzf = i8;
    }
}
