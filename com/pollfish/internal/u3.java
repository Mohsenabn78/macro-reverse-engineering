package com.pollfish.internal;

import com.google.firebase.appindexing.builders.AlarmInstanceBuilder;
import com.pollfish.callback.SurveyInfo;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public interface u3 {

    /* loaded from: classes6.dex */
    public static abstract class a {

        /* renamed from: com.pollfish.internal.u3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0215a extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public final y2 f37262a;

            public C0215a(@NotNull y2 y2Var) {
                super(0);
                this.f37262a = y2Var;
            }

            @NotNull
            public final y2 a() {
                return this.f37262a;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof C0215a) && Intrinsics.areEqual(this.f37262a, ((C0215a) obj).f37262a)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37262a.hashCode();
            }

            @Override // com.pollfish.internal.u3.a
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("DataReceived(data=");
                a4.append(this.f37262a);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class b extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final b f37263a = new b();

            public b() {
                super(0);
            }
        }

        /* loaded from: classes6.dex */
        public static final class c extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final c f37264a = new c();

            public c() {
                super(0);
            }
        }

        /* loaded from: classes6.dex */
        public static final class d extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final d f37265a = new d();

            public d() {
                super(0);
            }
        }

        /* loaded from: classes6.dex */
        public static final class e extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public final y2 f37266a;

            public e(@NotNull y2 y2Var) {
                super(0);
                this.f37266a = y2Var;
            }

            @NotNull
            public final y2 a() {
                return this.f37266a;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof e) && Intrinsics.areEqual(this.f37266a, ((e) obj).f37266a)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37266a.hashCode();
            }

            @Override // com.pollfish.internal.u3.a
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("Ready(data=");
                a4.append(this.f37266a);
                a4.append(')');
                return a4.toString();
            }
        }

        public a() {
        }

        public /* synthetic */ a(int i4) {
            this();
        }

        @NotNull
        public String toString() {
            if (this instanceof e) {
                StringBuilder a4 = u4.a("Ready: ");
                a4.append(((e) this).a());
                return a4.toString();
            } else if (this instanceof C0215a) {
                StringBuilder a5 = u4.a("Data Received: ");
                a5.append(((C0215a) this).a());
                return a5.toString();
            } else if (Intrinsics.areEqual(this, d.f37265a)) {
                return "Loading";
            } else {
                if (Intrinsics.areEqual(this, b.f37263a)) {
                    return AlarmInstanceBuilder.DISMISSED;
                }
                if (Intrinsics.areEqual(this, c.f37264a)) {
                    return "Finished";
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @NotNull
    a a();

    void a(@NotNull f4.a aVar, @NotNull l4.a aVar2);

    void a(@NotNull j3 j3Var);

    void a(@NotNull l4.a.d0 d0Var);

    void a(@NotNull x4 x4Var);

    void a(@NotNull String str, @NotNull String str2);

    void b();

    boolean c();

    @Nullable
    g2 d();

    @NotNull
    u1<Boolean> e();

    void f();

    void g();

    @Nullable
    i0 getDeviceInfo();

    void h();

    void hideMediationViews();

    boolean i();

    void j();

    @NotNull
    u1<j3> k();

    void l();

    @NotNull
    u1<Boolean> m();

    void n();

    void o();

    void onPollfishOpened();

    void onPollfishSurveyCompleted(@Nullable SurveyInfo surveyInfo);

    void p();

    @NotNull
    u1<Boolean> q();

    void r();

    void s();

    void t();

    void u();

    void v();

    void w();

    void x();

    void y();
}
