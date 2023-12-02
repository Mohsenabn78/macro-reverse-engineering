package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfz extends zzfy {
    private final byte[] zza;
    @Nullable
    private Uri zzb;
    private int zzc;
    private int zzd;
    private boolean zze;

    public zzfz(byte[] bArr) {
        super(false);
        zzdy.zzd(bArr.length > 0);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        int i6 = this.zzd;
        if (i6 == 0) {
            return -1;
        }
        int min = Math.min(i5, i6);
        System.arraycopy(this.zza, this.zzc, bArr, i4, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws IOException {
        this.zzb = zzgjVar.zza;
        zzi(zzgjVar);
        long j4 = zzgjVar.zzf;
        int length = this.zza.length;
        if (j4 <= length) {
            int i4 = (int) j4;
            this.zzc = i4;
            int i5 = length - i4;
            this.zzd = i5;
            long j5 = zzgjVar.zzg;
            if (j5 != -1) {
                this.zzd = (int) Math.min(i5, j5);
            }
            this.zze = true;
            zzj(zzgjVar);
            long j6 = zzgjVar.zzg;
            if (j6 != -1) {
                return j6;
            }
            return this.zzd;
        }
        throw new zzgf(2008);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zzb = null;
    }
}
