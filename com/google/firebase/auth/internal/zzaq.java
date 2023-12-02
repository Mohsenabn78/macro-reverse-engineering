package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzaq implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f28994a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f28995b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.f28994a = taskCompletionSource;
        this.f28995b = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        this.f28994a.setResult((AuthResult) obj);
        zzax.d(this.f28995b);
    }
}
