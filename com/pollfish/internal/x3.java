package com.pollfish.internal;

import com.pollfish.callback.SurveyInfo;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import com.pollfish.internal.r1;
import com.pollfish.internal.u3;
import com.pollfish.internal.y5;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class x3 implements u3 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final n1 f37298a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public x4 f37299b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final x0 f37300c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public u3.a f37301d = u3.a.d.f37265a;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final u1<Boolean> f37302e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final u1<Boolean> f37303f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final u1<Boolean> f37304g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final u1<j3> f37305h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37306i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37307j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f37308k;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function1<l4<? extends y2>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(l4<? extends y2> l4Var) {
            l4<? extends y2> l4Var2 = l4Var;
            if (l4Var2 instanceof l4.b) {
                x3.a(x3.this, (y2) ((l4.b) l4Var2).a());
            } else if (l4Var2 instanceof l4.a.p) {
                x3.this.n();
            } else if (l4Var2 instanceof l4.a) {
                x3.b(x3.this, (l4.a) l4Var2);
            }
            return Unit.INSTANCE;
        }
    }

    public x3(@NotNull n1 n1Var, @NotNull x4 x4Var, @NotNull x0 x0Var) {
        this.f37298a = n1Var;
        this.f37299b = x4Var;
        this.f37300c = x0Var;
        Boolean bool = Boolean.FALSE;
        this.f37302e = new u1<>(bool);
        this.f37303f = new u1<>(bool);
        this.f37304g = new u1<>();
        this.f37305h = new u1<>();
    }

    public static final void a(x3 x3Var, y2 y2Var) {
        x3Var.getClass();
        try {
            x3Var.a(new u3.a.C0215a(y2Var));
            x3Var.f37300c.a(y5.b.f37366a);
        } catch (Exception e4) {
            x3Var.a(new l4.a.d0(e4));
        }
    }

    public static final void b(x3 x3Var, l4.a aVar) {
        x3Var.f37300c.a(r1.d.f37189a);
        f4.a aVar2 = aVar.f37010b;
        if (aVar2 != null) {
            j4 j4Var = new j4(aVar2, aVar);
            if (!(aVar instanceof l4.a.p)) {
                x3Var.f37298a.f37121c.a(j4Var, v3.f37274a);
            }
        }
        x3Var.n();
    }

    public final Unit A() {
        u3.a.e eVar;
        u3.a aVar = this.f37301d;
        if (aVar instanceof u3.a.e) {
            eVar = (u3.a.e) aVar;
        } else {
            eVar = null;
        }
        if (eVar == null) {
            return null;
        }
        Boolean a4 = this.f37303f.a();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(a4, bool) || Intrinsics.areEqual(this.f37302e.a(), bool)) {
            return null;
        }
        if (this.f37299b.l()) {
            this.f37303f.a((u1<Boolean>) bool);
            return null;
        }
        if (eVar.a().a().s()) {
            this.f37300c.a(y5.a.f37365a);
            this.f37302e.a((u1<Boolean>) bool);
        } else {
            this.f37303f.a((u1<Boolean>) bool);
        }
        return Unit.INSTANCE;
    }

    @Override // com.pollfish.internal.u3
    public final boolean c() {
        Boolean bool = this.f37303f.f37260a;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.pollfish.internal.u3
    @Nullable
    public final g2 d() {
        u3.a.e eVar;
        u3.a.C0215a c0215a;
        y2 y2Var;
        y2 y2Var2;
        g2 g2Var;
        u3.a aVar = this.f37301d;
        if (aVar instanceof u3.a.e) {
            eVar = (u3.a.e) aVar;
        } else {
            eVar = null;
        }
        if (eVar != null && (y2Var2 = eVar.f37266a) != null && (g2Var = y2Var2.f37360a) != null) {
            return g2Var;
        }
        if (aVar instanceof u3.a.C0215a) {
            c0215a = (u3.a.C0215a) aVar;
        } else {
            c0215a = null;
        }
        if (c0215a == null || (y2Var = c0215a.f37262a) == null) {
            return null;
        }
        return y2Var.f37360a;
    }

    @Override // com.pollfish.internal.u3
    @NotNull
    public final u1<Boolean> e() {
        return this.f37304g;
    }

    @Override // com.pollfish.internal.u3
    public final void f() {
        try {
            if (this.f37301d instanceof u3.a.e) {
                A();
            }
            this.f37306i = false;
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void g() {
        this.f37300c.a(r1.g.f37192a);
    }

    @Override // com.pollfish.internal.u3
    @Nullable
    public final i0 getDeviceInfo() {
        u3.a.e eVar;
        u3.a.C0215a c0215a;
        y2 y2Var;
        y2 y2Var2;
        i0 i0Var;
        u3.a aVar = this.f37301d;
        if (aVar instanceof u3.a.e) {
            eVar = (u3.a.e) aVar;
        } else {
            eVar = null;
        }
        if (eVar != null && (y2Var2 = eVar.f37266a) != null && (i0Var = y2Var2.f37361b) != null) {
            return i0Var;
        }
        if (aVar instanceof u3.a.C0215a) {
            c0215a = (u3.a.C0215a) aVar;
        } else {
            c0215a = null;
        }
        if (c0215a == null || (y2Var = c0215a.f37262a) == null) {
            return null;
        }
        return y2Var.f37361b;
    }

    @Override // com.pollfish.internal.u3
    public final void h() {
        if (this.f37307j) {
            return;
        }
        this.f37307j = true;
        z();
    }

    @Override // com.pollfish.internal.u3
    public final void hideMediationViews() {
        try {
            this.f37305h.a((u1<j3>) null);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final boolean i() {
        return this.f37301d instanceof u3.a.e;
    }

    @Override // com.pollfish.internal.u3
    public final void j() {
        try {
            this.f37304g.a((u1<Boolean>) Boolean.TRUE);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    @NotNull
    public final u1<j3> k() {
        return this.f37305h;
    }

    @Override // com.pollfish.internal.u3
    public final void l() {
        try {
            this.f37303f.a((u1<Boolean>) Boolean.FALSE);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    @NotNull
    public final u1<Boolean> m() {
        return this.f37302e;
    }

    @Override // com.pollfish.internal.u3
    public final void n() {
        a(u3.a.b.f37263a);
        this.f37305h.b();
        this.f37304g.b();
        this.f37302e.b();
        this.f37303f.b();
        this.f37300c.a(y5.c.f37367a);
        u1<Boolean> u1Var = this.f37304g;
        Boolean bool = Boolean.FALSE;
        u1Var.a((u1<Boolean>) bool);
        this.f37303f.a((u1<Boolean>) bool);
        this.f37302e.a((u1<Boolean>) bool);
    }

    @Override // com.pollfish.internal.u3
    public final void o() {
        if (this.f37308k) {
            return;
        }
        this.f37308k = true;
        z();
    }

    @Override // com.pollfish.internal.u3
    public final void onPollfishOpened() {
        Integer num;
        x4 x4Var = this.f37299b;
        g2 d4 = d();
        if (d4 != null) {
            num = Integer.valueOf(d4.f36855f);
        } else {
            num = null;
        }
        this.f37298a.f37120b.a(new h5(x4Var, num), new w3(this));
        this.f37300c.a(r1.b.f37187a);
    }

    @Override // com.pollfish.internal.u3
    public final void onPollfishSurveyCompleted(@Nullable SurveyInfo surveyInfo) {
        this.f37300c.a(new r1.c(surveyInfo));
        if (!this.f37299b.f37314e) {
            a(u3.a.c.f37264a);
        }
    }

    @Override // com.pollfish.internal.u3
    public final void p() {
        this.f37300c.a(r1.f.f37191a);
        if (!this.f37299b.f37314e) {
            a(u3.a.c.f37264a);
        }
    }

    @Override // com.pollfish.internal.u3
    @NotNull
    public final u1<Boolean> q() {
        return this.f37303f;
    }

    @Override // com.pollfish.internal.u3
    public final void r() {
        n();
        this.f37300c.a(r1.d.f37189a);
    }

    @Override // com.pollfish.internal.u3
    public final void s() {
        try {
            this.f37302e.a((u1<Boolean>) Boolean.FALSE);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void t() {
        if (this.f37301d instanceof u3.a.e) {
            b();
        }
    }

    @NotNull
    public final String toString() {
        String trimMargin$default;
        StringBuilder a4 = u4.a("\n            state: ");
        a4.append(this.f37301d);
        a4.append(",\n            indicatorVisibility: ");
        a4.append(this.f37302e.a());
        a4.append(",\n            surveyPanelVisibility: ");
        a4.append(this.f37303f.a());
        a4.append(",\n            fullscreenPanelVisibility: ");
        a4.append(this.f37304g.a());
        a4.append(",\n            mediationParams: ");
        a4.append(this.f37305h.a());
        a4.append(",\n            webViewLoaded: ");
        a4.append(this.f37307j);
        a4.append(",\n            webViewFinished: ");
        a4.append(this.f37308k);
        a4.append("\n        ");
        trimMargin$default = kotlin.text.f.trimMargin$default(a4.toString(), null, 1, null);
        return trimMargin$default;
    }

    @Override // com.pollfish.internal.u3
    public final void u() {
        try {
            this.f37298a.f37120b.a(new f5(this.f37299b), new w3(this));
            this.f37300c.a(r1.a.f37186a);
            if (!Intrinsics.areEqual(this.f37301d, u3.a.b.f37263a) && !Intrinsics.areEqual(this.f37301d, u3.a.c.f37264a)) {
                if ((this.f37301d instanceof u3.a.e) && !this.f37299b.l() && !this.f37306i && Intrinsics.areEqual(this.f37302e.a(), Boolean.FALSE)) {
                    this.f37300c.a(y5.a.f37365a);
                    this.f37302e.a((u1<Boolean>) Boolean.TRUE);
                    return;
                }
                return;
            }
            n();
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void v() {
        try {
            a(u3.a.b.f37263a);
            this.f37303f.a((u1<Boolean>) Boolean.FALSE);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void w() {
        try {
            this.f37306i = true;
            this.f37300c.a(y5.d.f37368a);
            u1<Boolean> u1Var = this.f37303f;
            Boolean bool = Boolean.FALSE;
            u1Var.a((u1<Boolean>) bool);
            this.f37302e.a((u1<Boolean>) bool);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void x() {
        try {
            if (!this.f37306i) {
                this.f37303f.a((u1<Boolean>) Boolean.TRUE);
            }
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void y() {
        try {
            this.f37304g.a((u1<Boolean>) Boolean.FALSE);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    public final void z() {
        u3.a.C0215a c0215a;
        u3.a aVar = this.f37301d;
        Unit unit = null;
        if (aVar instanceof u3.a.C0215a) {
            c0215a = (u3.a.C0215a) aVar;
        } else {
            c0215a = null;
        }
        if (c0215a != null) {
            try {
                if (this.f37307j && this.f37308k) {
                    a(new u3.a.e(c0215a.a()));
                    if (!this.f37299b.l() && !this.f37306i) {
                        unit = A();
                    }
                    return;
                }
                return;
            } catch (Exception e4) {
                a(new l4.a.d0(e4));
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            n();
        }
    }

    public static final void a(x3 x3Var, l4.a aVar) {
        x3Var.getClass();
        f4.a aVar2 = aVar.f37010b;
        if (aVar2 != null) {
            j4 j4Var = new j4(aVar2, aVar);
            if (aVar instanceof l4.a.p) {
                return;
            }
            x3Var.f37298a.f37121c.a(j4Var, v3.f37274a);
        }
    }

    @Override // com.pollfish.internal.u3
    public final void b() {
        a(u3.a.d.f37265a);
        this.f37308k = false;
        this.f37307j = false;
        this.f37305h.b();
        this.f37304g.b();
        this.f37302e.b();
        this.f37303f.b();
        u1<Boolean> u1Var = this.f37304g;
        Boolean bool = Boolean.FALSE;
        u1Var.a((u1<Boolean>) bool);
        this.f37303f.a((u1<Boolean>) bool);
        this.f37302e.a((u1<Boolean>) bool);
        this.f37298a.f37119a.a(this.f37299b, new a());
    }

    @Override // com.pollfish.internal.u3
    @NotNull
    public final u3.a a() {
        return this.f37301d;
    }

    public final void a(@NotNull u3.a aVar) {
        this.f37301d = aVar;
        if (Intrinsics.areEqual(aVar, u3.a.d.f37265a)) {
            this.f37300c.a(y5.c.f37367a);
        } else if (aVar instanceof u3.a.e) {
            if (this.f37299b.g()) {
                this.f37300c.a(new r1.e(null));
                return;
            }
            this.f37300c.a(new r1.e(((u3.a.e) aVar).a().a().r()));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void a(@NotNull j3 j3Var) {
        try {
            this.f37305h.a((u1<j3>) j3Var);
        } catch (Exception e4) {
            a(new l4.a.d0(e4));
        }
    }

    @Override // com.pollfish.internal.u3
    public final void a(@NotNull x4 x4Var) {
        this.f37299b = x4Var;
    }

    @Override // com.pollfish.internal.u3
    public final void a(@NotNull String str, @NotNull String str2) {
        this.f37298a.f37120b.a(new k1(str, str2, this.f37299b), new w3(this));
    }

    @Override // com.pollfish.internal.u3
    public final void a(@NotNull l4.a.d0 d0Var) {
        a(f4.a.FATAL, d0Var);
        n();
    }

    @Override // com.pollfish.internal.u3
    public final void a(@NotNull f4.a aVar, @NotNull l4.a aVar2) {
        j4 j4Var = new j4(aVar, aVar2);
        if (aVar2 instanceof l4.a.p) {
            return;
        }
        this.f37298a.f37121c.a(j4Var, v3.f37274a);
    }
}
