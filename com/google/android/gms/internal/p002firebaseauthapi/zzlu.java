package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzlu implements zzlz {
    private final String zza;
    private final zzwi zzb;
    private final zzafy zzc;
    private final zztb zzd;
    private final zzui zze;
    @Nullable
    private final Integer zzf;

    private zzlu(String str, zzafy zzafyVar, zztb zztbVar, zzui zzuiVar, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzmj.zzb(str);
        this.zzc = zzafyVar;
        this.zzd = zztbVar;
        this.zze = zzuiVar;
        this.zzf = num;
    }

    public static zzlu zza(String str, zzafy zzafyVar, zztb zztbVar, zzui zzuiVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzuiVar == zzui.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzlu(str, zzafyVar, zztbVar, zzuiVar, num);
    }

    public final zztb zzb() {
        return this.zzd;
    }

    public final zzui zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlz
    public final zzwi zzd() {
        return this.zzb;
    }

    public final zzafy zze() {
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
