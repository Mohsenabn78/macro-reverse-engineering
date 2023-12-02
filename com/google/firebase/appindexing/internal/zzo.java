package com.google.firebase.appindexing.internal;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.icing.zzar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@VisibleForTesting
/* loaded from: classes5.dex */
public final class zzo implements OnCompleteListener<Void>, Executor {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final GoogleApi<?> f28830a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f28831b;
    @GuardedBy("pendingCalls")

    /* renamed from: c  reason: collision with root package name */
    private final Queue<zzn> f28832c = new ArrayDeque();
    @GuardedBy("pendingCalls")

    /* renamed from: d  reason: collision with root package name */
    private int f28833d = 0;

    public zzo(@NonNull GoogleApi<?> googleApi) {
        this.f28830a = googleApi;
        this.f28831b = new zzar(googleApi.getLooper());
    }

    public final Task<Void> a(zzz zzzVar) {
        boolean isEmpty;
        zzn zznVar = new zzn(this, zzzVar);
        Task<Void> a4 = zznVar.a();
        a4.addOnCompleteListener(this, this);
        synchronized (this.f28832c) {
            isEmpty = this.f28832c.isEmpty();
            this.f28832c.add(zznVar);
        }
        if (isEmpty) {
            zznVar.b();
        }
        return a4;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f28831b.post(runnable);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(@NonNull Task<Void> task) {
        zzn zznVar;
        boolean z3;
        synchronized (this.f28832c) {
            if (this.f28833d == 2) {
                zznVar = this.f28832c.peek();
                if (zznVar != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3);
            } else {
                zznVar = null;
            }
            this.f28833d = 0;
        }
        if (zznVar != null) {
            zznVar.b();
        }
    }
}
