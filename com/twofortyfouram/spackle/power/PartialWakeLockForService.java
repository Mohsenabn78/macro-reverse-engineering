package com.twofortyfouram.spackle.power;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.twofortyfouram.annotation.VisibleForTesting;
import com.twofortyfouram.assertion.Assertions;
import java.util.Locale;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class PartialWakeLockForService {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f38129b;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Object f38128a = new Object();
    @Nullable
    @GuardedBy("mIntrinsicLock")

    /* renamed from: c  reason: collision with root package name */
    private volatile PartialWakeLock f38130c = null;

    public PartialWakeLockForService(@NonNull String str) {
        Assertions.assertNotEmpty(str, "name");
        this.f38129b = str;
    }

    @NonNull
    @VisibleForTesting(VisibleForTesting.Visibility.PRIVATE)
    PartialWakeLock a(@NonNull Context context) {
        Assertions.assertNotNull(context, "context");
        PartialWakeLock partialWakeLock = this.f38130c;
        if (partialWakeLock == null) {
            synchronized (this.f38128a) {
                partialWakeLock = this.f38130c;
                if (partialWakeLock == null) {
                    PartialWakeLock newInstance = PartialWakeLock.newInstance(context, this.f38129b, true);
                    this.f38130c = newInstance;
                    partialWakeLock = newInstance;
                }
            }
        }
        return partialWakeLock;
    }

    @RequiresPermission("android.permission.WAKE_LOCK")
    public void afterDoingWork(@NonNull Context context) {
        a(context).releaseLockIfHeld();
    }

    @RequiresPermission("android.permission.WAKE_LOCK")
    public void beforeDoingWork(@NonNull Context context) {
        a(context).acquireLockIfNotHeld();
    }

    @RequiresPermission("android.permission.WAKE_LOCK")
    public void beforeStartingService(@NonNull Context context) {
        a(context).acquireLock();
    }

    public String toString() {
        return String.format(Locale.US, "PartialWakeLockForService [mWakeLockName=%s, mWakeLock=%s]", this.f38129b, this.f38130c);
    }
}
