package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcea implements zzge {
    private final zzge zza;
    private final long zzb;
    private final zzge zzc;
    private long zzd;
    private Uri zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcea(zzge zzgeVar, int i4, zzge zzgeVar2) {
        this.zza = zzgeVar;
        this.zzb = i4;
        this.zzc = zzgeVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws IOException {
        int i6;
        long j4 = this.zzd;
        long j5 = this.zzb;
        if (j4 < j5) {
            int zza = this.zza.zza(bArr, i4, (int) Math.min(i5, j5 - j4));
            long j6 = this.zzd + zza;
            this.zzd = j6;
            i6 = zza;
            j4 = j6;
        } else {
            i6 = 0;
        }
        if (j4 >= this.zzb) {
            int zza2 = this.zzc.zza(bArr, i4 + i6, i5 - i6);
            int i7 = i6 + zza2;
            this.zzd += zza2;
            return i7;
        }
        return i6;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws IOException {
        long j4;
        zzgj zzgjVar2;
        long j5;
        long j6;
        this.zze = zzgjVar.zza;
        long j7 = zzgjVar.zzf;
        long j8 = this.zzb;
        zzgj zzgjVar3 = null;
        if (j7 >= j8) {
            zzgjVar2 = null;
        } else {
            long j9 = zzgjVar.zzg;
            if (j9 != -1) {
                j4 = Math.min(j9, j8 - j7);
            } else {
                j4 = j8 - j7;
            }
            zzgjVar2 = new zzgj(zzgjVar.zza, null, j7, j7, j4, null, 0);
        }
        long j10 = zzgjVar.zzg;
        if (j10 == -1 || zzgjVar.zzf + j10 > this.zzb) {
            long max = Math.max(this.zzb, zzgjVar.zzf);
            long j11 = zzgjVar.zzg;
            if (j11 != -1) {
                j5 = Math.min(j11, (zzgjVar.zzf + j11) - this.zzb);
            } else {
                j5 = -1;
            }
            zzgjVar3 = new zzgj(zzgjVar.zza, null, max, max, j5, null, 0);
        }
        long j12 = 0;
        if (zzgjVar2 != null) {
            j6 = this.zza.zzb(zzgjVar2);
        } else {
            j6 = 0;
        }
        if (zzgjVar3 != null) {
            j12 = this.zzc.zzb(zzgjVar3);
        }
        this.zzd = zzgjVar.zzf;
        if (j6 == -1 || j12 == -1) {
            return -1L;
        }
        return j6 + j12;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Map zze() {
        return zzfsf.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhg zzhgVar) {
    }
}
