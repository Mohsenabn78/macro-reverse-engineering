package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zze;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwx {
    private final Status zza;
    private final zze zzb;
    private final String zzc;
    private final String zzd;

    @SafeParcelable.Constructor
    public zzwx(Status status, zze zzeVar, String str, @Nullable String str2) {
        this.zza = status;
        this.zzb = zzeVar;
        this.zzc = str;
        this.zzd = str2;
    }

    public final Status zza() {
        return this.zza;
    }

    public final zze zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
