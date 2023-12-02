package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.ActionCodeSettings;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwq {
    private final String zza;
    private final ActionCodeSettings zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final String zzd;

    public zzwq(String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3) {
        this.zza = str;
        this.zzb = actionCodeSettings;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final ActionCodeSettings zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzc;
    }
}
