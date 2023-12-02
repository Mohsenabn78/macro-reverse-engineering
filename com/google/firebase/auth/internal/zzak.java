package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzak implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzal f28981a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzal zzalVar) {
        this.f28981a = zzalVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Logger logger;
        if (exc instanceof FirebaseNetworkException) {
            logger = zzam.f28984h;
            logger.v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f28981a.f28983b.b();
        }
    }
}
