package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: com.google.android.gms:play-services-stats@@17.0.1 */
@ShowFirstParty
@ThreadSafe
@KeepForSdk
/* loaded from: classes4.dex */
public class WakeLock {

    /* renamed from: r  reason: collision with root package name */
    private static final long f22594r = TimeUnit.DAYS.toMillis(366);

    /* renamed from: s  reason: collision with root package name */
    private static volatile ScheduledExecutorService f22595s = null;

    /* renamed from: t  reason: collision with root package name */
    private static final Object f22596t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static volatile zzd f22597u = new zzb();

    /* renamed from: a  reason: collision with root package name */
    private final Object f22598a;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f22599b;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: c  reason: collision with root package name */
    private int f22600c;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: d  reason: collision with root package name */
    private Future<?> f22601d;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: e  reason: collision with root package name */
    private long f22602e;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: f  reason: collision with root package name */
    private final Set<zze> f22603f;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: g  reason: collision with root package name */
    private boolean f22604g;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: h  reason: collision with root package name */
    private int f22605h;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: i  reason: collision with root package name */
    com.google.android.gms.internal.stats.zzb f22606i;

    /* renamed from: j  reason: collision with root package name */
    private Clock f22607j;

    /* renamed from: k  reason: collision with root package name */
    private WorkSource f22608k;

    /* renamed from: l  reason: collision with root package name */
    private final String f22609l;

    /* renamed from: m  reason: collision with root package name */
    private final String f22610m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f22611n;
    @GuardedBy("acquireReleaseLock")

    /* renamed from: o  reason: collision with root package name */
    private final Map<String, zzc> f22612o;

    /* renamed from: p  reason: collision with root package name */
    private AtomicInteger f22613p;

    /* renamed from: q  reason: collision with root package name */
    private final ScheduledExecutorService f22614q;

    @KeepForSdk
    public WakeLock(@NonNull Context context, int i4, @NonNull String str) {
        String str2;
        String packageName = context.getPackageName();
        this.f22598a = new Object();
        this.f22600c = 0;
        this.f22603f = new HashSet();
        this.f22604g = true;
        this.f22607j = DefaultClock.getInstance();
        this.f22612o = new HashMap();
        this.f22613p = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.f22611n = context.getApplicationContext();
        this.f22610m = str;
        this.f22606i = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "*gcore*:".concat(valueOf);
            } else {
                str2 = new String("*gcore*:");
            }
            this.f22609l = str2;
        } else {
            this.f22609l = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i4, str);
            this.f22599b = newWakeLock;
            if (WorkSourceUtil.hasWorkSourcePermission(context)) {
                WorkSource fromPackage = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(packageName) ? context.getPackageName() : packageName);
                this.f22608k = fromPackage;
                if (fromPackage != null) {
                    d(newWakeLock, fromPackage);
                }
            }
            ScheduledExecutorService scheduledExecutorService = f22595s;
            if (scheduledExecutorService == null) {
                synchronized (f22596t) {
                    scheduledExecutorService = f22595s;
                    if (scheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f22595s = scheduledExecutorService;
                    }
                }
            }
            this.f22614q = scheduledExecutorService;
            return;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append((CharSequence) "expected a non-null reference", 0, 29);
        throw new zzi(sb.toString());
    }

    @GuardedBy("acquireReleaseLock")
    private final String a(String str) {
        if (this.f22604g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    @GuardedBy("acquireReleaseLock")
    private final void b() {
        if (this.f22603f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f22603f);
        this.f22603f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        zze zzeVar = (zze) arrayList.get(0);
        throw null;
    }

    private final void c(int i4) {
        synchronized (this.f22598a) {
            if (!isHeld()) {
                return;
            }
            if (this.f22604g) {
                int i5 = this.f22600c - 1;
                this.f22600c = i5;
                if (i5 > 0) {
                    return;
                }
            } else {
                this.f22600c = 0;
            }
            b();
            for (zzc zzcVar : this.f22612o.values()) {
                zzcVar.f22615a = 0;
            }
            this.f22612o.clear();
            Future<?> future = this.f22601d;
            if (future != null) {
                future.cancel(false);
                this.f22601d = null;
                this.f22602e = 0L;
            }
            this.f22605h = 0;
            if (this.f22599b.isHeld()) {
                try {
                    this.f22599b.release();
                    if (this.f22606i != null) {
                        this.f22606i = null;
                    }
                } catch (RuntimeException e4) {
                    if (e4.getClass().equals(RuntimeException.class)) {
                        Log.e("WakeLock", String.valueOf(this.f22609l).concat(" failed to release!"), e4);
                        if (this.f22606i != null) {
                            this.f22606i = null;
                        }
                    } else {
                        throw e4;
                    }
                }
            } else {
                Log.e("WakeLock", String.valueOf(this.f22609l).concat(" should be held!"));
            }
        }
    }

    private static void d(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e4) {
            Log.wtf("WakeLock", e4.toString());
        }
    }

    public static /* synthetic */ void zza(@NonNull WakeLock wakeLock) {
        synchronized (wakeLock.f22598a) {
            if (!wakeLock.isHeld()) {
                return;
            }
            Log.e("WakeLock", String.valueOf(wakeLock.f22609l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
            wakeLock.b();
            if (!wakeLock.isHeld()) {
                return;
            }
            wakeLock.f22600c = 1;
            wakeLock.c(0);
        }
    }

    @KeepForSdk
    public void acquire(long j4) {
        this.f22613p.incrementAndGet();
        long j5 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, f22594r), 1L);
        if (j4 > 0) {
            max = Math.min(j4, max);
        }
        synchronized (this.f22598a) {
            if (!isHeld()) {
                this.f22606i = com.google.android.gms.internal.stats.zzb.zza(false, null);
                this.f22599b.acquire();
                this.f22607j.elapsedRealtime();
            }
            this.f22600c++;
            this.f22605h++;
            a(null);
            zzc zzcVar = this.f22612o.get(null);
            if (zzcVar == null) {
                zzcVar = new zzc(null);
                this.f22612o.put(null, zzcVar);
            }
            zzcVar.f22615a++;
            long elapsedRealtime = this.f22607j.elapsedRealtime();
            if (Long.MAX_VALUE - elapsedRealtime > max) {
                j5 = elapsedRealtime + max;
            }
            if (j5 > this.f22602e) {
                this.f22602e = j5;
                Future<?> future = this.f22601d;
                if (future != null) {
                    future.cancel(false);
                }
                this.f22601d = this.f22614q.schedule(new Runnable() { // from class: com.google.android.gms.stats.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        WakeLock.zza(WakeLock.this);
                    }
                }, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @KeepForSdk
    public boolean isHeld() {
        boolean z3;
        synchronized (this.f22598a) {
            if (this.f22600c > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    @KeepForSdk
    public void release() {
        if (this.f22613p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f22609l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f22598a) {
            a(null);
            if (this.f22612o.containsKey(null)) {
                zzc zzcVar = this.f22612o.get(null);
                if (zzcVar != null) {
                    int i4 = zzcVar.f22615a - 1;
                    zzcVar.f22615a = i4;
                    if (i4 == 0) {
                        this.f22612o.remove(null);
                    }
                }
            } else {
                Log.w("WakeLock", String.valueOf(this.f22609l).concat(" counter does not exist"));
            }
            c(0);
        }
    }

    @KeepForSdk
    public void setReferenceCounted(boolean z3) {
        synchronized (this.f22598a) {
            this.f22604g = z3;
        }
    }
}
