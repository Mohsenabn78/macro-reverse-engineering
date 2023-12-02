package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgc extends zzfy {
    @Nullable
    private zzgj zza;
    @Nullable
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgc() {
        super(false);
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
        byte[] bArr2 = this.zzb;
        int i7 = zzfj.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i4, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws IOException {
        zzi(zzgjVar);
        this.zza = zzgjVar;
        Uri normalizeScheme = zzgjVar.zza.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        zzdy.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        int i4 = zzfj.zza;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length == 2) {
            String str = split[1];
            if (split[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str, 0);
                } catch (IllegalArgumentException e4) {
                    throw zzcd.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e4);
                }
            } else {
                this.zzb = URLDecoder.decode(str, zzfot.zza.name()).getBytes(zzfot.zzc);
            }
            long j4 = zzgjVar.zzf;
            int length = this.zzb.length;
            if (j4 <= length) {
                int i5 = (int) j4;
                this.zzc = i5;
                int i6 = length - i5;
                this.zzd = i6;
                long j5 = zzgjVar.zzg;
                if (j5 != -1) {
                    this.zzd = (int) Math.min(i6, j5);
                }
                zzj(zzgjVar);
                long j6 = zzgjVar.zzg;
                if (j6 != -1) {
                    return j6;
                }
                return this.zzd;
            }
            this.zzb = null;
            throw new zzgf(2008);
        }
        throw zzcd.zzb("Unexpected URI format: ".concat(String.valueOf(normalizeScheme)), null);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        zzgj zzgjVar = this.zza;
        if (zzgjVar != null) {
            return zzgjVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
