package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzap implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f28992a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f28993b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.f28992a = taskCompletionSource;
        this.f28993b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f28992a.setException(exc);
        zzax.d(this.f28993b);
    }
}
