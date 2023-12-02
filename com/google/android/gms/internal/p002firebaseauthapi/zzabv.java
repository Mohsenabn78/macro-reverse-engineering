package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabv  reason: invalid package */
/* loaded from: classes4.dex */
public class zzabv {
    zzaar zza;
    Executor zzb;

    public final Task zzU(final zzabu zzabuVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzabt
            @Override // java.lang.Runnable
            public final void run() {
                zzabuVar.zzc(taskCompletionSource, zzabv.this.zza);
            }
        });
        return taskCompletionSource.getTask();
    }
}
