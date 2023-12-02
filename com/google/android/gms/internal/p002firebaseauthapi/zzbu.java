package com.google.android.gms.internal.p002firebaseauthapi;

import com.arlosoft.macrodroid.common.Constants;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzbu {
    public static final zzbu zza = new zzbu(Constants.ENABLED_LOG_PREFIX);
    public static final zzbu zzb = new zzbu(Constants.DISABLED_LOG_PREFIX);
    public static final zzbu zzc = new zzbu("DESTROYED");
    private final String zzd;

    private zzbu(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
