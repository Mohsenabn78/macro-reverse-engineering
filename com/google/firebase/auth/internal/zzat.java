package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzat implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f29000a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f29001b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.f29000a = taskCompletionSource;
        this.f29001b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f29000a.setException(exc);
        zzax.d(this.f29001b);
    }
}
