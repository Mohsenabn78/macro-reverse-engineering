package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzau implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f29002a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f29003b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.f29002a = taskCompletionSource;
        this.f29003b = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        this.f29002a.setResult((AuthResult) obj);
        zzax.d(this.f29003b);
    }
}
