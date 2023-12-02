package com.google.firebase.auth;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadu;
import com.google.firebase.auth.internal.zzbx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@VisibleForTesting
/* loaded from: classes5.dex */
public final class zzad implements zzbx {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29123a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(FirebaseAuth firebaseAuth) {
        this.f29123a = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzadu zzaduVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzaduVar);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzaduVar);
        FirebaseAuth.g(this.f29123a, firebaseUser, zzaduVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        if (status.getStatusCode() != 17011 && status.getStatusCode() != 17021 && status.getStatusCode() != 17005 && status.getStatusCode() != 17091) {
            return;
        }
        this.f29123a.signOut();
    }
}
