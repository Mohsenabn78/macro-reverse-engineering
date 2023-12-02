package com.google.firebase.appindexing.internal;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@VisibleForTesting
/* loaded from: classes5.dex */
public final class zzn {

    /* renamed from: a  reason: collision with root package name */
    private final zzz f28827a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<Void> f28828b = new TaskCompletionSource<>();

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzo f28829c;

    public zzn(zzo zzoVar, zzz zzzVar) {
        this.f28829c = zzoVar;
        this.f28827a = zzzVar;
    }

    public final Task<Void> a() {
        return this.f28828b.getTask();
    }

    public final void b() {
        Queue queue;
        int i4;
        boolean z3;
        GoogleApi googleApi;
        queue = this.f28829c.f28832c;
        synchronized (queue) {
            i4 = this.f28829c.f28833d;
            if (i4 == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            this.f28829c.f28833d = 1;
        }
        googleApi = this.f28829c.f28830a;
        googleApi.doWrite(new zzm(this, null)).addOnFailureListener(this.f28829c, new OnFailureListener(this) { // from class: com.google.firebase.appindexing.internal.zzk

            /* renamed from: a  reason: collision with root package name */
            private final zzn f28823a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f28823a = this;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f28823a.c(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(Exception exc) {
        Queue queue;
        Queue queue2;
        zzn zznVar;
        Queue queue3;
        Queue queue4;
        queue = this.f28829c.f28832c;
        synchronized (queue) {
            queue2 = this.f28829c.f28832c;
            if (queue2.peek() == this) {
                queue3 = this.f28829c.f28832c;
                queue3.remove();
                this.f28829c.f28833d = 0;
                queue4 = this.f28829c.f28832c;
                zznVar = (zzn) queue4.peek();
            } else {
                zznVar = null;
            }
        }
        this.f28828b.trySetException(exc);
        if (zznVar != null) {
            zznVar.b();
        }
    }
}
