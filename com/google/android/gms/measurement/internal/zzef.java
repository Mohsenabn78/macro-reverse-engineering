package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzef {

    /* renamed from: h  reason: collision with root package name */
    private static final Object f21494h = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final String f21495a;

    /* renamed from: b  reason: collision with root package name */
    private final zzec f21496b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f21497c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f21498d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f21499e = new Object();
    @GuardedBy("overrideLock")

    /* renamed from: f  reason: collision with root package name */
    private volatile Object f21500f = null;
    @GuardedBy("cachingLock")

    /* renamed from: g  reason: collision with root package name */
    private volatile Object f21501g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzef(String str, Object obj, Object obj2, zzec zzecVar, zzee zzeeVar) {
        this.f21495a = str;
        this.f21497c = obj;
        this.f21498d = obj2;
        this.f21496b = zzecVar;
    }

    public final Object zza(Object obj) {
        List<zzef> list;
        Object obj2;
        synchronized (this.f21499e) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzed.f21493a == null) {
            return this.f21497c;
        }
        synchronized (f21494h) {
            if (!zzab.zza()) {
                try {
                    list = zzeg.f21502a;
                    for (zzef zzefVar : list) {
                        if (!zzab.zza()) {
                            Object obj3 = null;
                            try {
                                zzec zzecVar = zzefVar.f21496b;
                                if (zzecVar != null) {
                                    obj3 = zzecVar.zza();
                                }
                            } catch (IllegalStateException unused) {
                            }
                            synchronized (f21494h) {
                                zzefVar.f21501g = obj3;
                            }
                        } else {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                    }
                } catch (SecurityException unused2) {
                }
                zzec zzecVar2 = this.f21496b;
                if (zzecVar2 == null) {
                    return this.f21497c;
                }
                try {
                    return zzecVar2.zza();
                } catch (IllegalStateException unused3) {
                    return this.f21497c;
                } catch (SecurityException unused4) {
                    return this.f21497c;
                }
            }
            if (this.f21501g == null) {
                obj2 = this.f21497c;
            } else {
                obj2 = this.f21501g;
            }
            return obj2;
        }
    }

    public final String zzb() {
        return this.f21495a;
    }
}
