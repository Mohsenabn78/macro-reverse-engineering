package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzadu;
import com.google.firebase.auth.internal.zzbx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzx implements zzbx {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(FirebaseAuth firebaseAuth) {
        this.f29167a = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzadu zzaduVar, FirebaseUser firebaseUser) {
        FirebaseAuth.g(this.f29167a, firebaseUser, zzaduVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode != 17011 && statusCode != 17021 && statusCode != 17005) {
            return;
        }
        this.f29167a.signOut();
    }
}
