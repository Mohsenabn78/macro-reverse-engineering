package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzw implements zzaa {
    final /* synthetic */ zzj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(zzj zzjVar) {
        this.zza = zzjVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaa
    public final /* synthetic */ Iterator zza(zzab zzabVar, CharSequence charSequence) {
        return new zzv(this, zzabVar, charSequence);
    }
}
