package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaad {

    /* renamed from: a  reason: collision with root package name */
    private final Map f20131a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final Map f20132b = Collections.synchronizedMap(new WeakHashMap());

    private final void g(boolean z3, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f20131a) {
            hashMap = new HashMap(this.f20131a);
        }
        synchronized (this.f20132b) {
            hashMap2 = new HashMap(this.f20132b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z3 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z3 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(BasePendingResult basePendingResult, boolean z3) {
        this.f20131a.put(basePendingResult, Boolean.valueOf(z3));
        basePendingResult.addStatusListener(new zaab(this, basePendingResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(TaskCompletionSource taskCompletionSource, boolean z3) {
        this.f20132b.put(taskCompletionSource, Boolean.valueOf(z3));
        taskCompletionSource.getTask().addOnCompleteListener(new zaac(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(int i4, @Nullable String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i4 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i4 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        g(true, new Status(20, sb.toString()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        if (this.f20131a.isEmpty() && this.f20132b.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void zaf() {
        g(false, GoogleApiManager.zaa);
    }
}
