package com.twofortyfouram.spackle.power;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.log.Lumberjack;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import net.jcip.annotations.ThreadSafe;

@SuppressLint({"Wakelock"})
@ThreadSafe
/* loaded from: classes6.dex */
public final class PartialWakeLock {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private static final ConcurrentHashMap<String, AtomicLong> f38122f = new ConcurrentHashMap<>();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f38123a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38124b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager.WakeLock f38125c;

    /* renamed from: d  reason: collision with root package name */
    private int f38126d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f38127e = 0;

    private PartialWakeLock(@NonNull Context context, @NonNull String str, boolean z3) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, "lockName");
        this.f38123a = str;
        this.f38124b = z3;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        this.f38125c = newWakeLock;
        newWakeLock.setReferenceCounted(z3);
    }

    private long a() {
        long j4;
        synchronized (this.f38125c) {
            long j5 = this.f38127e;
            j4 = 0;
            if (0 != j5) {
                j4 = SystemClock.elapsedRealtime() - j5;
            }
        }
        return j4;
    }

    @NonNull
    public static Map<String, Long> dumpWakeLockUsage() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, AtomicLong> entry : f38122f.entrySet()) {
            hashMap.put(entry.getKey(), Long.valueOf(entry.getValue().get()));
        }
        return hashMap;
    }

    @NonNull
    public static PartialWakeLock newInstance(@NonNull Context context, @NonNull String str, boolean z3) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, "lockName");
        f38122f.putIfAbsent(str, new AtomicLong(0L));
        return new PartialWakeLock(context, str, z3);
    }

    @RequiresPermission("android.permission.WAKE_LOCK")
    public void acquireLock() {
        synchronized (this.f38125c) {
            boolean isHeld = isHeld();
            if (!isHeld) {
                this.f38127e = SystemClock.elapsedRealtime();
            }
            if (this.f38124b || !isHeld) {
                this.f38126d++;
            }
            this.f38125c.acquire();
        }
    }

    @RequiresPermission("android.permission.WAKE_LOCK")
    public void acquireLockIfNotHeld() {
        synchronized (this.f38125c) {
            if (!this.f38125c.isHeld()) {
                acquireLock();
            }
        }
    }

    public boolean isHeld() {
        boolean isHeld;
        synchronized (this.f38125c) {
            isHeld = this.f38125c.isHeld();
        }
        return isHeld;
    }

    public void releaseLock() {
        synchronized (this.f38125c) {
            if (isHeld()) {
                this.f38126d--;
                this.f38125c.release();
                if (!isHeld()) {
                    f38122f.get(this.f38123a).addAndGet(a());
                    this.f38127e = 0L;
                }
            } else {
                throw new IllegalStateException(Lumberjack.formatMessage("Lock \"%s\" was not held", this.f38123a));
            }
        }
    }

    public void releaseLockIfHeld() {
        synchronized (this.f38125c) {
            if (isHeld()) {
                releaseLock();
            }
        }
    }

    public String toString() {
        return String.format(Locale.US, "PartialWakeLock [mLockName=%s, mIsReferenceCounted=%s, mReferenceCount=%s, durationHeldMillis=%d, mWakeLock=%s]", this.f38123a, Boolean.valueOf(this.f38124b), Integer.valueOf(this.f38126d), Long.valueOf(a()), this.f38125c);
    }
}
