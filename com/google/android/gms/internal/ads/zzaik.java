package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaik {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;

    public zzaik(int i4) {
    }

    public final void zza(byte[] bArr, int i4, int i5) {
        if (!this.zze) {
            return;
        }
        int i6 = i5 - i4;
        byte[] bArr2 = this.zzc;
        int length = bArr2.length;
        int i7 = this.zza + i6;
        if (length < i7) {
            this.zzc = Arrays.copyOf(bArr2, i7 + i7);
        }
        System.arraycopy(bArr, i4, this.zzc, this.zza, i6);
        this.zza += i6;
    }

    public final void zzb() {
        this.zze = false;
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzc(int i4, int i5) {
        if (this.zze) {
            int i6 = this.zza - i5;
            this.zza = i6;
            if (this.zzb == 0 && i4 == 181) {
                this.zzb = i6;
            } else {
                this.zze = false;
                return true;
            }
        } else if (i4 == 179) {
            this.zze = true;
        }
        zza(zzd, 0, 3);
        return false;
    }
}
