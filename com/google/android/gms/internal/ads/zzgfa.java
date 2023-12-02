package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgfa implements zzgfd {
    private final String zza;
    private final zzgnk zzb;
    private final zzgoe zzc;
    private final zzgkj zzd;
    private final zzglq zze;
    @Nullable
    private final Integer zzf;

    private zzgfa(String str, zzgoe zzgoeVar, zzgkj zzgkjVar, zzglq zzglqVar, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzgfm.zza(str);
        this.zzc = zzgoeVar;
        this.zzd = zzgkjVar;
        this.zze = zzglqVar;
        this.zzf = num;
    }

    public static zzgfa zza(String str, zzgoe zzgoeVar, zzgkj zzgkjVar, zzglq zzglqVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzglqVar == zzglq.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgfa(str, zzgoeVar, zzgkjVar, zzglqVar, num);
    }

    public final zzgkj zzb() {
        return this.zzd;
    }

    public final zzglq zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgfd
    public final zzgnk zzd() {
        return this.zzb;
    }

    public final zzgoe zze() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
