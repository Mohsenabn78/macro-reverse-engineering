package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaat {
    @Nullable
    private String zza;
    @Nullable
    private String zzb;

    private zzaat() {
    }

    public static zzaat zza(String str) {
        zzaat zzaatVar = new zzaat();
        zzaatVar.zza = str;
        return zzaatVar;
    }

    public static zzaat zzb(String str) {
        zzaat zzaatVar = new zzaat();
        zzaatVar.zzb = str;
        return zzaatVar;
    }

    @Nullable
    public final String zzc() {
        return this.zza;
    }

    @Nullable
    public final String zzd() {
        return this.zzb;
    }
}
