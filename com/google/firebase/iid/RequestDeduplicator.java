package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes5.dex */
class RequestDeduplicator {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f31487a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private final Map<Pair<String, String>, Task<InstanceIdResult>> f31488b = new ArrayMap();

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    /* loaded from: classes5.dex */
    interface GetTokenRequest {
        Task<InstanceIdResult> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestDeduplicator(Executor executor) {
        this.f31487a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<InstanceIdResult> a(String str, String str2, GetTokenRequest getTokenRequest) {
        final Pair pair = new Pair(str, str2);
        Task<InstanceIdResult> task = this.f31488b.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(valueOf.length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
        }
        Task continueWithTask = getTokenRequest.start().continueWithTask(this.f31487a, new Continuation(this, pair) { // from class: com.google.firebase.iid.RequestDeduplicator$$Lambda$0

            /* renamed from: a  reason: collision with root package name */
            private final RequestDeduplicator f31489a;

            /* renamed from: b  reason: collision with root package name */
            private final Pair f31490b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f31489a = this;
                this.f31490b = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                this.f31489a.b(this.f31490b, task2);
                return task2;
            }
        });
        this.f31488b.put(pair, continueWithTask);
        return continueWithTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task b(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.f31488b.remove(pair);
        }
        return task;
    }
}
