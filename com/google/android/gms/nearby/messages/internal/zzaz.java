package com.google.android.gms.nearby.messages.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzaz implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f22433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaz(zzbh zzbhVar, TaskCompletionSource taskCompletionSource) {
        this.f22433a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(@NonNull Task task) {
        if (task.isSuccessful()) {
            this.f22433a.setResult(null);
        } else {
            this.f22433a.setException((Exception) Preconditions.checkNotNull(task.getException()));
        }
    }
}
