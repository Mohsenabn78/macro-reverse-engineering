package com.google.firebase.messaging;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class RequestDeduplicator {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f31712a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Task<String>> f31713b = new ArrayMap();

    /* loaded from: classes5.dex */
    interface GetTokenRequest {
        Task<String> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestDeduplicator(Executor executor) {
        this.f31712a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task c(String str, Task task) throws Exception {
        synchronized (this) {
            this.f31713b.remove(str);
        }
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<String> b(final String str, GetTokenRequest getTokenRequest) {
        Task<String> task = this.f31713b.get(str);
        if (task != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Joining ongoing request for: ");
                sb.append(str);
            }
            return task;
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Making new request for: ");
            sb2.append(str);
        }
        Task continueWithTask = getTokenRequest.start().continueWithTask(this.f31712a, new Continuation() { // from class: com.google.firebase.messaging.b0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Task c4;
                c4 = RequestDeduplicator.this.c(str, task2);
                return c4;
            }
        });
        this.f31713b.put(str, continueWithTask);
        return continueWithTask;
    }
}
