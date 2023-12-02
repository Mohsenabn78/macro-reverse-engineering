package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzal implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final String f28982a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzam f28983b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzam zzamVar, String str) {
        this.f28983b = zzamVar;
        this.f28982a = Preconditions.checkNotEmpty(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.f28982a));
        if (firebaseAuth.getCurrentUser() != null) {
            Task accessToken = firebaseAuth.getAccessToken(true);
            logger = zzam.f28984h;
            logger.v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzak(this));
        }
    }
}
