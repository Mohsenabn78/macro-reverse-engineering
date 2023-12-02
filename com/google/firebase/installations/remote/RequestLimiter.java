package com.google.firebase.installations.remote;

import androidx.annotation.GuardedBy;
import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
class RequestLimiter {

    /* renamed from: d  reason: collision with root package name */
    private static final long f31592d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e  reason: collision with root package name */
    private static final long f31593e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final Utils f31594a = Utils.getInstance();
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private long f31595b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private int f31596c;

    private synchronized long a(int i4) {
        if (!c(i4)) {
            return f31592d;
        }
        return (long) Math.min(Math.pow(2.0d, this.f31596c) + this.f31594a.getRandomDelayForSyncPrevention(), f31593e);
    }

    private static boolean c(int i4) {
        if (i4 != 429 && (i4 < 500 || i4 >= 600)) {
            return false;
        }
        return true;
    }

    private static boolean d(int i4) {
        if ((i4 < 200 || i4 >= 300) && i4 != 401 && i4 != 404) {
            return false;
        }
        return true;
    }

    private synchronized void e() {
        this.f31596c = 0;
    }

    public synchronized boolean b() {
        boolean z3;
        if (this.f31596c != 0) {
            if (this.f31594a.currentTimeInMillis() <= this.f31595b) {
                z3 = false;
            }
        }
        z3 = true;
        return z3;
    }

    public synchronized void f(int i4) {
        if (d(i4)) {
            e();
            return;
        }
        this.f31596c++;
        this.f31595b = this.f31594a.currentTimeInMillis() + a(i4);
    }
}
