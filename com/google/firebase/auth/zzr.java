package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzr implements com.google.firebase.auth.internal.zzan {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseUser f29157a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29158b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.f29158b = firebaseAuth;
        this.f29157a = firebaseUser;
    }

    @Override // com.google.firebase.auth.internal.zzan
    public final void zza() {
        FirebaseUser firebaseUser;
        FirebaseUser firebaseUser2;
        FirebaseAuth firebaseAuth = this.f29158b;
        firebaseUser = firebaseAuth.f28876f;
        if (firebaseUser != null) {
            firebaseUser2 = firebaseAuth.f28876f;
            if (firebaseUser2.getUid().equalsIgnoreCase(this.f29157a.getUid())) {
                this.f29158b.zzO();
            }
        }
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        if (status.getStatusCode() != 17011 && status.getStatusCode() != 17021 && status.getStatusCode() != 17005) {
            return;
        }
        this.f29158b.signOut();
    }
}
