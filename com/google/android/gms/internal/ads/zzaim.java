package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaim {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;
    private int zzf;

    public zzaim(int i4) {
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
        this.zzf = 0;
    }

    public final boolean zzc(int i4, int i5) {
        int i6 = this.zzf;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i4 == 179 || i4 == 181) {
                            this.zza -= i5;
                            this.zze = false;
                            return true;
                        }
                    } else if ((i4 & 240) != 32) {
                        zzer.zzf("H263Reader", "Unexpected start code value");
                        zzb();
                    } else {
                        this.zzb = this.zza;
                        this.zzf = 4;
                    }
                } else if (i4 > 31) {
                    zzer.zzf("H263Reader", "Unexpected start code value");
                    zzb();
                } else {
                    this.zzf = 3;
                }
            } else if (i4 != 181) {
                zzer.zzf("H263Reader", "Unexpected start code value");
                zzb();
            } else {
                this.zzf = 2;
            }
        } else if (i4 == 176) {
            this.zzf = 1;
            this.zze = true;
        }
        zza(zzd, 0, 3);
        return false;
    }
}
