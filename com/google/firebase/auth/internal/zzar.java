package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzar implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f28996a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f28997b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.f28996a = taskCompletionSource;
        this.f28997b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f28996a.setException(exc);
        zzax.d(this.f28997b);
    }
}
