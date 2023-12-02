package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.internal.zzbc;
import com.google.firebase.auth.zze;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwy  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwy {
    @SafeParcelable.Field(getter = "getMfaPendingCredential", id = 1)
    final String zza;
    @SafeParcelable.Field(getter = "getMfaInfoList", id = 2)
    final List zzb;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 3)
    final zze zzc;

    @SafeParcelable.Constructor
    public zzwy(String str, List list, @Nullable zze zzeVar) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzeVar;
    }

    public final zze zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List zzc() {
        return zzbc.zzb(this.zzb);
    }
}
