package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsOriginAnalyticsEventLogger f29371a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29372b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeUnit f29373c;

    /* renamed from: e  reason: collision with root package name */
    private CountDownLatch f29375e;

    /* renamed from: d  reason: collision with root package name */
    private final Object f29374d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f29376f = false;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i4, TimeUnit timeUnit) {
        this.f29371a = crashlyticsOriginAnalyticsEventLogger;
        this.f29372b = i4;
        this.f29373c = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.f29374d) {
            Logger logger = Logger.getLogger();
            logger.v("Logging event " + str + " to Firebase Analytics with params " + bundle);
            this.f29375e = new CountDownLatch(1);
            this.f29376f = false;
            this.f29371a.logEvent(str, bundle);
            Logger.getLogger().v("Awaiting app exception callback from Analytics...");
            try {
                if (this.f29375e.await(this.f29372b, this.f29373c)) {
                    this.f29376f = true;
                    Logger.getLogger().v("App exception callback received from Analytics listener.");
                } else {
                    Logger.getLogger().w("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                }
            } catch (InterruptedException unused) {
                Logger.getLogger().e("Interrupted while awaiting app exception callback from Analytics listener.");
            }
            this.f29375e = null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.f29375e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
