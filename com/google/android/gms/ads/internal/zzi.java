package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzaql;
import com.google.android.gms.internal.ads.zzaqo;
import com.google.android.gms.internal.ads.zzaqr;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzfjb;
import com.google.android.gms.internal.ads.zzfkd;
import com.google.android.gms.internal.ads.zzfkx;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import org.joni.constants.internal.NodeType;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzi implements Runnable, zzaqo {
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    protected boolean f19383d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f19384e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19385f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f19386g;

    /* renamed from: h  reason: collision with root package name */
    private final zzfjb f19387h;

    /* renamed from: i  reason: collision with root package name */
    private Context f19388i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f19389j;

    /* renamed from: k  reason: collision with root package name */
    private zzbzx f19390k;

    /* renamed from: l  reason: collision with root package name */
    private final zzbzx f19391l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f19392m;

    /* renamed from: o  reason: collision with root package name */
    private int f19394o;

    /* renamed from: a  reason: collision with root package name */
    private final List f19380a = new Vector();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference f19381b = new AtomicReference();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference f19382c = new AtomicReference();

    /* renamed from: n  reason: collision with root package name */
    final CountDownLatch f19393n = new CountDownLatch(1);

    public zzi(Context context, zzbzx zzbzxVar) {
        this.f19388i = context;
        this.f19389j = context;
        this.f19390k = zzbzxVar;
        this.f19391l = zzbzxVar;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.f19386g = newCachedThreadPool;
        boolean booleanValue = ((Boolean) zzba.zzc().zzb(zzbbm.zzcb)).booleanValue();
        this.f19392m = booleanValue;
        this.f19387h = zzfjb.zza(context, newCachedThreadPool, booleanValue);
        this.f19384e = ((Boolean) zzba.zzc().zzb(zzbbm.zzbX)).booleanValue();
        this.f19385f = ((Boolean) zzba.zzc().zzb(zzbbm.zzcc)).booleanValue();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzca)).booleanValue()) {
            this.f19394o = 2;
        } else {
            this.f19394o = 1;
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzdd)).booleanValue()) {
            this.f19383d = c();
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcW)).booleanValue()) {
            zzcae.zza.execute(this);
            return;
        }
        zzay.zzb();
        if (zzbzk.zzu()) {
            zzcae.zza.execute(this);
        } else {
            run();
        }
    }

    @Nullable
    private final zzaqo e() {
        if (d() == 2) {
            return (zzaqo) this.f19382c.get();
        }
        return (zzaqo) this.f19381b.get();
    }

    private final void f() {
        zzaqo e4 = e();
        if (!this.f19380a.isEmpty() && e4 != null) {
            for (Object[] objArr : this.f19380a) {
                int length = objArr.length;
                if (length == 1) {
                    e4.zzk((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    e4.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f19380a.clear();
        }
    }

    private final void g(boolean z3) {
        this.f19381b.set(zzaqr.zzu(this.f19390k.zza, h(this.f19388i), z3, this.f19394o));
    }

    private static final Context h(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        return applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(boolean z3) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzaql.zza(this.f19391l.zza, h(this.f19389j), z3, this.f19392m).zzp();
        } catch (NullPointerException e4) {
            this.f19387h.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e4);
        }
    }

    protected final boolean c() {
        Context context = this.f19388i;
        zzfjb zzfjbVar = this.f19387h;
        zzh zzhVar = new zzh(this);
        return new zzfkx(this.f19388i, zzfkd.zzb(context, zzfjbVar), zzhVar, ((Boolean) zzba.zzc().zzb(zzbbm.zzbY)).booleanValue()).zzd(1);
    }

    protected final int d() {
        if (this.f19384e && !this.f19383d) {
            return 1;
        }
        return this.f19394o;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.google.android.gms.internal.ads.zzbzx] */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdd)).booleanValue()) {
                this.f19383d = c();
            }
            boolean z3 = this.f19390k.zzd;
            final boolean z4 = false;
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzaT)).booleanValue() && z3) {
                z4 = true;
            }
            if (d() == 1) {
                g(z4);
                if (this.f19394o == 2) {
                    this.f19386g.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.zzg
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzi.this.b(z4);
                        }
                    });
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    zzaql zza = zzaql.zza(this.f19390k.zza, h(this.f19388i), z4, this.f19392m);
                    this.f19382c.set(zza);
                    if (this.f19385f && !zza.zzr()) {
                        this.f19394o = 1;
                        g(z4);
                    }
                } catch (NullPointerException e4) {
                    this.f19394o = 1;
                    g(z4);
                    this.f19387h.zzc(NodeType.ALLOWED_IN_LB, System.currentTimeMillis() - currentTimeMillis, e4);
                }
            }
        } finally {
            this.f19393n.countDown();
            this.f19388i = null;
            this.f19390k = null;
        }
    }

    public final boolean zzd() {
        try {
            this.f19393n.await();
            return true;
        } catch (InterruptedException e4) {
            zzbzr.zzk("Interrupted during GADSignals creation.", e4);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zzf(Context context, String str, View view, Activity activity) {
        if (zzd()) {
            zzaqo e4 = e();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjn)).booleanValue()) {
                zzt.zzp();
                com.google.android.gms.ads.internal.util.zzs.zzF(view, 4, null);
            }
            if (e4 != null) {
                f();
                return e4.zzf(h(context), str, view, activity);
            }
            return "";
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zzg(Context context) {
        zzaqo e4;
        if (zzd() && (e4 = e()) != null) {
            f();
            return e4.zzg(h(context));
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zzh(Context context, View view, Activity activity) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjm)).booleanValue()) {
            if (zzd()) {
                zzaqo e4 = e();
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzjn)).booleanValue()) {
                    zzt.zzp();
                    com.google.android.gms.ads.internal.util.zzs.zzF(view, 2, null);
                }
                if (e4 != null) {
                    return e4.zzh(context, view, activity);
                }
                return "";
            }
            return "";
        }
        zzaqo e5 = e();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjn)).booleanValue()) {
            zzt.zzp();
            com.google.android.gms.ads.internal.util.zzs.zzF(view, 2, null);
        }
        if (e5 != null) {
            return e5.zzh(context, view, activity);
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzk(MotionEvent motionEvent) {
        zzaqo e4 = e();
        if (e4 != null) {
            f();
            e4.zzk(motionEvent);
            return;
        }
        this.f19380a.add(new Object[]{motionEvent});
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzl(int i4, int i5, int i6) {
        zzaqo e4 = e();
        if (e4 != null) {
            f();
            e4.zzl(i4, i5, i6);
            return;
        }
        this.f19380a.add(new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzaqo e4;
        if (zzd() && (e4 = e()) != null) {
            e4.zzn(stackTraceElementArr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzo(View view) {
        zzaqo e4 = e();
        if (e4 != null) {
            e4.zzo(view);
        }
    }
}
