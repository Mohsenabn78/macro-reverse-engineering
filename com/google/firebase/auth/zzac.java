package com.google.firebase.auth;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@VisibleForTesting
/* loaded from: classes5.dex */
public class zzac implements com.google.firebase.auth.internal.zzg {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(FirebaseAuth firebaseAuth) {
        this.f29122a = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzadu zzaduVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzaduVar);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzaduVar);
        this.f29122a.zzQ(firebaseUser, zzaduVar, true);
    }
}
