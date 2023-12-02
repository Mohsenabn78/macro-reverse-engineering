package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzns  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzns {
    public static final zzns zza = new zzns("SHA1");
    public static final zzns zzb = new zzns("SHA224");
    public static final zzns zzc = new zzns("SHA256");
    public static final zzns zzd = new zzns("SHA384");
    public static final zzns zze = new zzns("SHA512");
    private final String zzf;

    private zzns(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
