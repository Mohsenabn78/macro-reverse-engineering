package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class AbtComponent {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseABTesting> f28740a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f28741b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AnalyticsConnector> f28742c;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public AbtComponent(Context context, Provider<AnalyticsConnector> provider) {
        this.f28741b = context;
        this.f28742c = provider;
    }

    @VisibleForTesting
    protected FirebaseABTesting a(String str) {
        return new FirebaseABTesting(this.f28741b, this.f28742c, str);
    }

    public synchronized FirebaseABTesting get(String str) {
        if (!this.f28740a.containsKey(str)) {
            this.f28740a.put(str, a(str));
        }
        return this.f28740a.get(str);
    }
}
