package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzh {
    private long A;
    private long B;
    private long C;
    private long D;
    @Nullable
    private String E;
    private boolean F;
    private long G;
    private long H;

    /* renamed from: a  reason: collision with root package name */
    private final zzgd f21736a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21737b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f21738c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f21739d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f21740e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f21741f;

    /* renamed from: g  reason: collision with root package name */
    private long f21742g;

    /* renamed from: h  reason: collision with root package name */
    private long f21743h;

    /* renamed from: i  reason: collision with root package name */
    private long f21744i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private String f21745j;

    /* renamed from: k  reason: collision with root package name */
    private long f21746k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f21747l;

    /* renamed from: m  reason: collision with root package name */
    private long f21748m;

    /* renamed from: n  reason: collision with root package name */
    private long f21749n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f21750o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21751p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private String f21752q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private Boolean f21753r;

    /* renamed from: s  reason: collision with root package name */
    private long f21754s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private List f21755t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private String f21756u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f21757v;

    /* renamed from: w  reason: collision with root package name */
    private long f21758w;

    /* renamed from: x  reason: collision with root package name */
    private long f21759x;

    /* renamed from: y  reason: collision with root package name */
    private long f21760y;

    /* renamed from: z  reason: collision with root package name */
    private long f21761z;

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public zzh(zzgd zzgdVar, String str) {
        Preconditions.checkNotNull(zzgdVar);
        Preconditions.checkNotEmpty(str);
        this.f21736a = zzgdVar;
        this.f21737b = str;
        zzgdVar.zzaB().zzg();
    }

    @WorkerThread
    public final long A() {
        this.f21736a.zzaB().zzg();
        return 0L;
    }

    @WorkerThread
    public final void B(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.E, str);
        this.E = str;
    }

    @WorkerThread
    public final void C(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21744i != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21744i = j4;
    }

    @WorkerThread
    public final void D(long j4) {
        boolean z3;
        boolean z4 = true;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f21736a.zzaB().zzg();
        boolean z5 = this.F;
        if (this.f21742g == j4) {
            z4 = false;
        }
        this.F = z5 | z4;
        this.f21742g = j4;
    }

    @WorkerThread
    public final void E(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21743h != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21743h = j4;
    }

    @WorkerThread
    public final void F(boolean z3) {
        boolean z4;
        this.f21736a.zzaB().zzg();
        boolean z5 = this.F;
        if (this.f21750o != z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.F = z5 | z4;
        this.f21750o = z3;
    }

    @WorkerThread
    public final void G(@Nullable Boolean bool) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.f21753r, bool);
        this.f21753r = bool;
    }

    @WorkerThread
    public final void H(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.f21740e, str);
        this.f21740e = str;
    }

    @WorkerThread
    public final void I(@Nullable List list) {
        ArrayList arrayList;
        this.f21736a.zzaB().zzg();
        if (!zzg.zza(this.f21755t, list)) {
            this.F = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.f21755t = arrayList;
        }
    }

    @WorkerThread
    public final void J(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.f21756u, str);
        this.f21756u = str;
    }

    @WorkerThread
    public final void K(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21759x != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21759x = j4;
    }

    @WorkerThread
    public final void L(boolean z3) {
        boolean z4;
        this.f21736a.zzaB().zzg();
        boolean z5 = this.F;
        if (this.f21757v != z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.F = z5 | z4;
        this.f21757v = z3;
    }

    @WorkerThread
    public final void M(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21758w != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21758w = j4;
    }

    @WorkerThread
    public final boolean N() {
        this.f21736a.zzaB().zzg();
        return this.f21751p;
    }

    @WorkerThread
    public final boolean O() {
        this.f21736a.zzaB().zzg();
        return this.f21750o;
    }

    @WorkerThread
    public final boolean P() {
        this.f21736a.zzaB().zzg();
        return this.F;
    }

    @WorkerThread
    public final boolean Q() {
        this.f21736a.zzaB().zzg();
        return this.f21757v;
    }

    @WorkerThread
    public final long R() {
        this.f21736a.zzaB().zzg();
        return this.f21746k;
    }

    @WorkerThread
    public final long S() {
        this.f21736a.zzaB().zzg();
        return this.G;
    }

    @WorkerThread
    public final long T() {
        this.f21736a.zzaB().zzg();
        return this.B;
    }

    @WorkerThread
    public final long U() {
        this.f21736a.zzaB().zzg();
        return this.C;
    }

    @WorkerThread
    public final long V() {
        this.f21736a.zzaB().zzg();
        return this.A;
    }

    @WorkerThread
    public final long W() {
        this.f21736a.zzaB().zzg();
        return this.f21761z;
    }

    @WorkerThread
    public final long X() {
        this.f21736a.zzaB().zzg();
        return this.D;
    }

    @WorkerThread
    public final long Y() {
        this.f21736a.zzaB().zzg();
        return this.f21760y;
    }

    @WorkerThread
    public final long Z() {
        this.f21736a.zzaB().zzg();
        return this.f21749n;
    }

    @Nullable
    @WorkerThread
    public final String a() {
        this.f21736a.zzaB().zzg();
        return this.f21739d;
    }

    @WorkerThread
    public final long a0() {
        this.f21736a.zzaB().zzg();
        return this.f21754s;
    }

    @Nullable
    @WorkerThread
    public final String b() {
        this.f21736a.zzaB().zzg();
        return this.E;
    }

    @WorkerThread
    public final long b0() {
        this.f21736a.zzaB().zzg();
        return this.H;
    }

    @Nullable
    @WorkerThread
    public final String c() {
        this.f21736a.zzaB().zzg();
        return this.f21740e;
    }

    @WorkerThread
    public final long c0() {
        this.f21736a.zzaB().zzg();
        return this.f21748m;
    }

    @Nullable
    @WorkerThread
    public final String d() {
        this.f21736a.zzaB().zzg();
        return this.f21756u;
    }

    @WorkerThread
    public final long d0() {
        this.f21736a.zzaB().zzg();
        return this.f21744i;
    }

    @Nullable
    @WorkerThread
    public final List e() {
        this.f21736a.zzaB().zzg();
        return this.f21755t;
    }

    @WorkerThread
    public final long e0() {
        this.f21736a.zzaB().zzg();
        return this.f21742g;
    }

    @WorkerThread
    public final void f() {
        this.f21736a.zzaB().zzg();
        this.F = false;
    }

    @WorkerThread
    public final long f0() {
        this.f21736a.zzaB().zzg();
        return this.f21743h;
    }

    @WorkerThread
    public final void g() {
        this.f21736a.zzaB().zzg();
        long j4 = this.f21742g + 1;
        if (j4 > 2147483647L) {
            this.f21736a.zzaA().zzk().zzb("Bundle index overflow. appId", zzet.f(this.f21737b));
            j4 = 0;
        }
        this.F = true;
        this.f21742g = j4;
    }

    @WorkerThread
    public final long g0() {
        this.f21736a.zzaB().zzg();
        return this.f21759x;
    }

    @WorkerThread
    public final void h(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ zzg.zza(this.f21752q, str);
        this.f21752q = str;
    }

    @WorkerThread
    public final long h0() {
        this.f21736a.zzaB().zzg();
        return this.f21758w;
    }

    @WorkerThread
    public final void i(boolean z3) {
        boolean z4;
        this.f21736a.zzaB().zzg();
        boolean z5 = this.F;
        if (this.f21751p != z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.F = z5 | z4;
        this.f21751p = z3;
    }

    @Nullable
    @WorkerThread
    public final Boolean i0() {
        this.f21736a.zzaB().zzg();
        return this.f21753r;
    }

    @WorkerThread
    public final void j(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.f21738c, str);
        this.f21738c = str;
    }

    @Nullable
    @WorkerThread
    public final String j0() {
        this.f21736a.zzaB().zzg();
        return this.f21752q;
    }

    @WorkerThread
    public final void k(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.f21747l, str);
        this.f21747l = str;
    }

    @Nullable
    @WorkerThread
    public final String k0() {
        this.f21736a.zzaB().zzg();
        String str = this.E;
        B(null);
        return str;
    }

    @WorkerThread
    public final void l(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.f21745j, str);
        this.f21745j = str;
    }

    @WorkerThread
    public final String l0() {
        this.f21736a.zzaB().zzg();
        return this.f21737b;
    }

    @WorkerThread
    public final void m(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21746k != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21746k = j4;
    }

    @Nullable
    @WorkerThread
    public final String m0() {
        this.f21736a.zzaB().zzg();
        return this.f21738c;
    }

    @WorkerThread
    public final void n(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.G != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.G = j4;
    }

    @Nullable
    @WorkerThread
    public final String n0() {
        this.f21736a.zzaB().zzg();
        return this.f21747l;
    }

    @WorkerThread
    public final void o(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.B != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.B = j4;
    }

    @Nullable
    @WorkerThread
    public final String o0() {
        this.f21736a.zzaB().zzg();
        return this.f21745j;
    }

    @WorkerThread
    public final void p(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.C != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.C = j4;
    }

    @Nullable
    @WorkerThread
    public final String p0() {
        this.f21736a.zzaB().zzg();
        return this.f21741f;
    }

    @WorkerThread
    public final void q(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.A != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.A = j4;
    }

    @WorkerThread
    public final void r(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21761z != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21761z = j4;
    }

    @WorkerThread
    public final void s(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.D != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.D = j4;
    }

    @WorkerThread
    public final void t(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21760y != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21760y = j4;
    }

    @WorkerThread
    public final void u(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21749n != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21749n = j4;
    }

    @WorkerThread
    public final void v(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21754s != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21754s = j4;
    }

    @WorkerThread
    public final void w(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.H != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.H = j4;
    }

    @WorkerThread
    public final void x(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        this.F |= !zzg.zza(this.f21741f, str);
        this.f21741f = str;
    }

    @WorkerThread
    public final void y(@Nullable String str) {
        this.f21736a.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ zzg.zza(this.f21739d, str);
        this.f21739d = str;
    }

    @WorkerThread
    public final void z(long j4) {
        boolean z3;
        this.f21736a.zzaB().zzg();
        boolean z4 = this.F;
        if (this.f21748m != j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.F = z4 | z3;
        this.f21748m = j4;
    }
}
