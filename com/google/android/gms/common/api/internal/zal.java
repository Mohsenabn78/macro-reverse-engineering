package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zal {

    /* renamed from: d  reason: collision with root package name */
    private int f20320d;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap f20318b = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f20319c = new TaskCompletionSource();

    /* renamed from: e  reason: collision with root package name */
    private boolean f20321e = false;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap f20317a = new ArrayMap();

    public zal(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f20317a.put(((HasApiKey) it.next()).getApiKey(), null);
        }
        this.f20320d = this.f20317a.keySet().size();
    }

    public final Task zaa() {
        return this.f20319c.getTask();
    }

    public final Set zab() {
        return this.f20317a.keySet();
    }

    public final void zac(ApiKey apiKey, ConnectionResult connectionResult, @Nullable String str) {
        this.f20317a.put(apiKey, connectionResult);
        this.f20318b.put(apiKey, str);
        this.f20320d--;
        if (!connectionResult.isSuccess()) {
            this.f20321e = true;
        }
        if (this.f20320d == 0) {
            if (this.f20321e) {
                this.f20319c.setException(new AvailabilityException(this.f20317a));
                return;
            }
            this.f20319c.setResult(this.f20318b);
        }
    }
}
