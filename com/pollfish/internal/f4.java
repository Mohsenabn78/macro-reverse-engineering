package com.pollfish.internal;

import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class f4 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36816a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36817b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final int f36818c = 2;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final a f36819d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f36820e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final String f36821f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f36822g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final g0 f36823h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final v1 f36824i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public final i f36825j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public final y1 f36826k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public final e1 f36827l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public final j5 f36828m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public final p5 f36829n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final z0 f36830o;

    /* loaded from: classes6.dex */
    public enum a {
        INFO("info"),
        DEBUG("debug"),
        ERROR(Constants.IPC_BUNDLE_KEY_SEND_ERROR),
        FATAL("fatal"),
        WARNING("warning");
        
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final String f36837a;

        a(String str) {
            this.f36837a = str;
        }

        @NotNull
        public final String a() {
            return this.f36837a;
        }
    }

    public f4(@NotNull String str, @NotNull String str2, @NotNull a aVar, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull g0 g0Var, @NotNull v1 v1Var, @NotNull i iVar, @NotNull y1 y1Var, @NotNull e1 e1Var, @NotNull j5 j5Var, @NotNull p5 p5Var, @NotNull z0 z0Var) {
        this.f36816a = str;
        this.f36817b = str2;
        this.f36819d = aVar;
        this.f36820e = str3;
        this.f36821f = str4;
        this.f36822g = str5;
        this.f36823h = g0Var;
        this.f36824i = v1Var;
        this.f36825j = iVar;
        this.f36826k = y1Var;
        this.f36827l = e1Var;
        this.f36828m = j5Var;
        this.f36829n = p5Var;
        this.f36830o = z0Var;
    }

    @NotNull
    public final i a() {
        return this.f36825j;
    }

    @NotNull
    public final String b() {
        return this.f36816a;
    }

    @NotNull
    public final g0 c() {
        return this.f36823h;
    }

    @NotNull
    public final String d() {
        return this.f36821f;
    }

    @NotNull
    public final int e() {
        return this.f36818c;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f4)) {
            return false;
        }
        f4 f4Var = (f4) obj;
        if (Intrinsics.areEqual(this.f36816a, f4Var.f36816a) && Intrinsics.areEqual(this.f36817b, f4Var.f36817b) && this.f36818c == f4Var.f36818c && this.f36819d == f4Var.f36819d && Intrinsics.areEqual(this.f36820e, f4Var.f36820e) && Intrinsics.areEqual(this.f36821f, f4Var.f36821f) && Intrinsics.areEqual(this.f36822g, f4Var.f36822g) && Intrinsics.areEqual(this.f36823h, f4Var.f36823h) && Intrinsics.areEqual(this.f36824i, f4Var.f36824i) && Intrinsics.areEqual(this.f36825j, f4Var.f36825j) && Intrinsics.areEqual(this.f36826k, f4Var.f36826k) && Intrinsics.areEqual(this.f36827l, f4Var.f36827l) && Intrinsics.areEqual(this.f36828m, f4Var.f36828m) && Intrinsics.areEqual(this.f36829n, f4Var.f36829n) && Intrinsics.areEqual(this.f36830o, f4Var.f36830o)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final e1 f() {
        return this.f36827l;
    }

    @NotNull
    public final z0 g() {
        return this.f36830o;
    }

    @NotNull
    public final a h() {
        return this.f36819d;
    }

    public final int hashCode() {
        int a4 = m4.a(this.f36817b, this.f36816a.hashCode() * 31, 31);
        int hashCode = this.f36819d.hashCode();
        int a5 = m4.a(this.f36822g, m4.a(this.f36821f, m4.a(this.f36820e, (hashCode + ((v0.a(this.f36818c) + a4) * 31)) * 31, 31), 31), 31);
        int hashCode2 = this.f36824i.hashCode();
        int hashCode3 = this.f36825j.hashCode();
        int hashCode4 = this.f36826k.hashCode();
        int a6 = m4.a(this.f36827l.f36782a, (hashCode4 + ((hashCode3 + ((hashCode2 + ((this.f36823h.hashCode() + a5) * 31)) * 31)) * 31)) * 31, 31);
        int hashCode5 = this.f36829n.hashCode();
        return this.f36830o.f37369a.hashCode() + ((hashCode5 + ((this.f36828m.hashCode() + a6) * 31)) * 31);
    }

    @NotNull
    public final String i() {
        return this.f36817b;
    }

    @NotNull
    public final v1 j() {
        return this.f36824i;
    }

    @NotNull
    public final y1 k() {
        return this.f36826k;
    }

    @NotNull
    public final String l() {
        return this.f36820e;
    }

    @NotNull
    public final j5 m() {
        return this.f36828m;
    }

    @NotNull
    public final String n() {
        return this.f36822g;
    }

    @NotNull
    public final p5 o() {
        return this.f36829n;
    }

    @NotNull
    public final String toString() {
        return "Report(culprit=" + this.f36816a + ", message=" + this.f36817b + ", environment=" + u0.c(this.f36818c) + ", level=" + this.f36819d + ", release=" + this.f36820e + ", dist=" + this.f36821f + ", timestamp=" + this.f36822g + ", device=" + this.f36823h + ", os=" + this.f36824i + ", app=" + this.f36825j + ", params=" + this.f36826k + ", exception=" + this.f36827l + ", tags=" + this.f36828m + ", user=" + this.f36829n + ", exceptionEntry=" + this.f36830o + ')';
    }
}
