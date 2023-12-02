package com.twofortyfouram.spackle;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.spackle.ThreadUtil;
import com.twofortyfouram.spackle.power.PartialWakeLock;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class AlarmManagerCompat {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private static final Object f38110e = new Object();
    @Nullable
    @GuardedBy("INITIALIZATION_INTRINSIC_LOCK")

    /* renamed from: f  reason: collision with root package name */
    private static volatile AlarmManagerCompat f38111f;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f38112a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final AlarmManager f38113b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager f38114c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Handler f38115d;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface AlarmType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public static final class b implements Runnable {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final PendingIntent f38118a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final PartialWakeLock f38119b;

        public b(@NonNull PendingIntent pendingIntent, @NonNull PartialWakeLock partialWakeLock) {
            Assertions.assertNotNull(pendingIntent, BaseGmsClient.KEY_PENDING_INTENT);
            Assertions.assertNotNull(partialWakeLock, "partialWakeLock");
            this.f38118a = pendingIntent;
            this.f38119b = partialWakeLock;
        }

        private static void a(@NonNull PendingIntent pendingIntent) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a(this.f38118a);
            } finally {
                this.f38119b.releaseLockIfHeld();
            }
        }
    }

    private AlarmManagerCompat(@NonNull Context context) {
        Context cleanContext = ContextUtil.cleanContext(context);
        this.f38112a = cleanContext;
        this.f38113b = (AlarmManager) cleanContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f38114c = (PowerManager) cleanContext.getSystemService("power");
        this.f38115d = new Handler(ThreadUtil.newHandlerThread(AlarmManagerCompat.class.getName() + ".handler", ThreadUtil.ThreadPriority.DEFAULT).getLooper());
    }

    @RequiresPermission("android.permission.WAKE_LOCK")
    private AlarmToken a(long j4, @NonNull PendingIntent pendingIntent) {
        PartialWakeLock newInstance = PartialWakeLock.newInstance(this.f38112a, AlarmManagerCompat.class.getName(), false);
        newInstance.acquireLock();
        AlarmToken alarmToken = new AlarmToken(newInstance);
        if (!this.f38115d.postAtTime(new b(pendingIntent, newInstance), alarmToken, j4)) {
            newInstance.releaseLock();
        }
        return alarmToken;
    }

    @NonNull
    @TargetApi(19)
    private AlarmToken b(int i4, long j4, @NonNull PendingIntent pendingIntent) {
        this.f38113b.setExact(i4, j4, pendingIntent);
        return new AlarmToken(pendingIntent);
    }

    @NonNull
    @RequiresPermission("android.permission.WAKE_LOCK")
    @TargetApi(21)
    private AlarmToken c(int i4, long j4, @NonNull PendingIntent pendingIntent, long j5, long j6) {
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                throw new AssertionError();
            }
            long j7 = j4 - j6;
            if (j7 > 5000) {
                return b(i4, j4, pendingIntent);
            }
            return a(SystemClock.uptimeMillis() + j7, pendingIntent);
        }
        long j8 = j4 - j5;
        if (j8 > 5000) {
            return b(i4, j4, pendingIntent);
        }
        return a(SystemClock.uptimeMillis() + j8, pendingIntent);
    }

    @NonNull
    @RequiresPermission("android.permission.WAKE_LOCK")
    @TargetApi(23)
    private AlarmToken d(int i4, long j4, @NonNull PendingIntent pendingIntent, long j5, long j6) {
        boolean isIgnoringBatteryOptimizations;
        isIgnoringBatteryOptimizations = this.f38114c.isIgnoringBatteryOptimizations(this.f38112a.getPackageName());
        if (!isIgnoringBatteryOptimizations) {
            this.f38113b.setAndAllowWhileIdle(i4, j4, pendingIntent);
            return new AlarmToken(pendingIntent);
        }
        return c(i4, j4, pendingIntent, j5, j6);
    }

    @NonNull
    public static AlarmManagerCompat getInstance(@NonNull Context context) {
        Context cleanContext = ContextUtil.cleanContext(context);
        AlarmManagerCompat alarmManagerCompat = f38111f;
        if (alarmManagerCompat == null) {
            synchronized (f38110e) {
                alarmManagerCompat = f38111f;
                if (alarmManagerCompat == null) {
                    alarmManagerCompat = new AlarmManagerCompat(cleanContext);
                    f38111f = alarmManagerCompat;
                }
            }
        }
        return alarmManagerCompat;
    }

    public void cancel(@NonNull AlarmToken alarmToken) {
        Assertions.assertNotNull(alarmToken, "alarmToken");
        if (alarmToken.f38117b == null) {
            PartialWakeLock partialWakeLock = alarmToken.f38116a;
            this.f38115d.removeCallbacksAndMessages(alarmToken.f38116a);
            partialWakeLock.releaseLockIfHeld();
            return;
        }
        this.f38113b.cancel(alarmToken.f38117b);
    }

    @NonNull
    @RequiresPermission("android.permission.WAKE_LOCK")
    public AlarmToken setExact(@NonNull Context context, int i4, @IntRange(from = 0) long j4, @NonNull PendingIntent pendingIntent, long j5, long j6) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertInRangeInclusive(i4, 0, 3, "type");
        Assertions.assertNotNull(pendingIntent, BaseGmsClient.KEY_PENDING_INTENT);
        if (AndroidSdkVersion.isAtLeastSdk(23)) {
            return d(i4, j4, pendingIntent, j5, j6);
        }
        if (AndroidSdkVersion.isAtLeastSdk(21)) {
            return c(i4, j4, pendingIntent, j5, j6);
        }
        if (AndroidSdkVersion.isAtLeastSdk(19)) {
            return b(i4, j4, pendingIntent);
        }
        this.f38113b.set(i4, j4, pendingIntent);
        return new AlarmToken(pendingIntent);
    }

    @Immutable
    /* loaded from: classes6.dex */
    public static final class AlarmToken {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final PartialWakeLock f38116a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final PendingIntent f38117b;

        private AlarmToken(@NonNull PendingIntent pendingIntent) {
            this.f38117b = pendingIntent;
            this.f38116a = null;
        }

        private AlarmToken(@NonNull PartialWakeLock partialWakeLock) {
            this.f38116a = partialWakeLock;
            this.f38117b = null;
        }
    }
}
