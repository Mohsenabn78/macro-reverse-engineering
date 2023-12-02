package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwv {
    private final PhoneMultiFactorInfo zza;
    private final String zzb;
    @Nullable
    private final String zzc;
    private final long zzd;
    private final boolean zze;
    @Nullable
    private final String zzf;
    @Nullable
    private final String zzg;
    private final boolean zzh;

    public zzwv(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, @Nullable String str2, long j4, boolean z3, boolean z4, @Nullable String str3, @Nullable String str4, boolean z5) {
        this.zza = phoneMultiFactorInfo;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j4;
        this.zze = z3;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = z5;
    }

    public final long zza() {
        return this.zzd;
    }

    public final PhoneMultiFactorInfo zzb() {
        return this.zza;
    }

    @Nullable
    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    @Nullable
    public final String zze() {
        return this.zzg;
    }

    @Nullable
    public final String zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final boolean zzh() {
        return this.zzh;
    }
}
