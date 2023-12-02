package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzte implements zzge {
    private final zzge zza;
    private final int zzb;
    private final zztd zzc;
    private final byte[] zzd;
    private int zze;

    public zzte(zzge zzgeVar, int i4, zztd zztdVar) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        this.zza = zzgeVar;
        this.zzb = i4;
        this.zzc = zztdVar;
        this.zzd = new byte[1];
        this.zze = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.zze;
        if (i6 == 0) {
            int i7 = 0;
            if (this.zza.zza(this.zzd, 0, 1) != -1) {
                int i8 = (this.zzd[0] & 255) << 4;
                if (i8 != 0) {
                    byte[] bArr2 = new byte[i8];
                    int i9 = i8;
                    while (i9 > 0) {
                        int zza = this.zza.zza(bArr2, i7, i9);
                        if (zza != -1) {
                            i7 += zza;
                            i9 -= zza;
                        }
                    }
                    while (i8 > 0) {
                        int i10 = i8 - 1;
                        if (bArr2[i10] != 0) {
                            break;
                        }
                        i8 = i10;
                    }
                    if (i8 > 0) {
                        this.zzc.zza(new zzfa(bArr2, i8));
                    }
                }
                i6 = this.zzb;
                this.zze = i6;
            }
            return -1;
        }
        int zza2 = this.zza.zza(bArr, i4, Math.min(i6, i5));
        if (zza2 != -1) {
            this.zze -= zza2;
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Map zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhg zzhgVar) {
        zzhgVar.getClass();
        this.zza.zzf(zzhgVar);
    }
}
