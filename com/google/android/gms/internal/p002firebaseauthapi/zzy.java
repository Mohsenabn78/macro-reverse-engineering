package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzy  reason: invalid package */
/* loaded from: classes4.dex */
final class zzy implements zzaa {
    final /* synthetic */ zzm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzm zzmVar) {
        this.zza = zzmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaa
    public final /* bridge */ /* synthetic */ Iterator zza(zzab zzabVar, CharSequence charSequence) {
        return new zzx(this, zzabVar, charSequence, this.zza.zza(charSequence));
    }
}
