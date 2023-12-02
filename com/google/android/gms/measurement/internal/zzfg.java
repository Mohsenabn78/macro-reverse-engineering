package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfg {

    /* renamed from: a  reason: collision with root package name */
    final String f21581a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21582b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21583c;

    /* renamed from: d  reason: collision with root package name */
    private final long f21584d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzfi f21585e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfg(zzfi zzfiVar, String str, long j4, zzff zzffVar) {
        boolean z3;
        this.f21585e = zzfiVar;
        Preconditions.checkNotEmpty("health_monitor");
        if (j4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f21581a = "health_monitor:start";
        this.f21582b = "health_monitor:count";
        this.f21583c = "health_monitor:value";
        this.f21584d = j4;
    }

    @WorkerThread
    private final long a() {
        return this.f21585e.d().getLong(this.f21581a, 0L);
    }

    @WorkerThread
    private final void b() {
        this.f21585e.zzg();
        long currentTimeMillis = this.f21585e.f21734a.zzax().currentTimeMillis();
        SharedPreferences.Editor edit = this.f21585e.d().edit();
        edit.remove(this.f21582b);
        edit.remove(this.f21583c);
        edit.putLong(this.f21581a, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    public final Pair zza() {
        long abs;
        this.f21585e.zzg();
        this.f21585e.zzg();
        long a4 = a();
        if (a4 == 0) {
            b();
            abs = 0;
        } else {
            abs = Math.abs(a4 - this.f21585e.f21734a.zzax().currentTimeMillis());
        }
        long j4 = this.f21584d;
        if (abs < j4) {
            return null;
        }
        if (abs > j4 + j4) {
            b();
            return null;
        }
        String string = this.f21585e.d().getString(this.f21583c, null);
        long j5 = this.f21585e.d().getLong(this.f21582b, 0L);
        b();
        if (string != null && j5 > 0) {
            return new Pair(string, Long.valueOf(j5));
        }
        return zzfi.f21590y;
    }

    @WorkerThread
    public final void zzb(String str, long j4) {
        this.f21585e.zzg();
        if (a() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        long j5 = this.f21585e.d().getLong(this.f21582b, 0L);
        if (j5 <= 0) {
            SharedPreferences.Editor edit = this.f21585e.d().edit();
            edit.putString(this.f21583c, str);
            edit.putLong(this.f21582b, 1L);
            edit.apply();
            return;
        }
        long j6 = j5 + 1;
        SharedPreferences.Editor edit2 = this.f21585e.d().edit();
        if ((this.f21585e.f21734a.zzv().h().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j6) {
            edit2.putString(this.f21583c, str);
        }
        edit2.putLong(this.f21582b, j6);
        edit2.apply();
    }
}
