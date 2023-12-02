package com.pollfish.internal;

import com.pollfish.callback.SurveyInfo;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public abstract class r1 implements w0 {

    /* loaded from: classes6.dex */
    public static final class a extends r1 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f37186a = new a();

        public a() {
            super(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends r1 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final b f37187a = new b();

        public b() {
            super(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends r1 {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final SurveyInfo f37188a;

        public c(@Nullable SurveyInfo surveyInfo) {
            super(0);
            this.f37188a = surveyInfo;
        }

        @Nullable
        public final SurveyInfo a() {
            return this.f37188a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof c) && Intrinsics.areEqual(this.f37188a, ((c) obj).f37188a)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            SurveyInfo surveyInfo = this.f37188a;
            if (surveyInfo == null) {
                return 0;
            }
            return surveyInfo.hashCode();
        }

        @Override // com.pollfish.internal.r1
        @NotNull
        public final String toString() {
            StringBuilder a4 = u4.a("PollfishSurveyCompleted(surveyInfo=");
            a4.append(this.f37188a);
            a4.append(')');
            return a4.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends r1 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final d f37189a = new d();

        public d() {
            super(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends r1 {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final SurveyInfo f37190a;

        public e(@Nullable SurveyInfo surveyInfo) {
            super(0);
            this.f37190a = surveyInfo;
        }

        @Nullable
        public final SurveyInfo a() {
            return this.f37190a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof e) && Intrinsics.areEqual(this.f37190a, ((e) obj).f37190a)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            SurveyInfo surveyInfo = this.f37190a;
            if (surveyInfo == null) {
                return 0;
            }
            return surveyInfo.hashCode();
        }

        @Override // com.pollfish.internal.r1
        @NotNull
        public final String toString() {
            StringBuilder a4 = u4.a("PollfishSurveyReceived(surveyInfo=");
            a4.append(this.f37190a);
            a4.append(')');
            return a4.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends r1 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final f f37191a = new f();

        public f() {
            super(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends r1 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final g f37192a = new g();

        public g() {
            super(0);
        }
    }

    public r1() {
    }

    public /* synthetic */ r1(int i4) {
        this();
    }

    @NotNull
    public String toString() {
        if (this instanceof e) {
            StringBuilder a4 = u4.a("Pollfish Survey Received : [\n");
            a4.append(((e) this).a());
            a4.append("\n]");
            return a4.toString();
        } else if (this instanceof c) {
            StringBuilder a5 = u4.a("Pollfish Survey Completed : [\n");
            a5.append(((c) this).a());
            a5.append("\n]");
            return a5.toString();
        } else if (Intrinsics.areEqual(this, b.f37187a)) {
            return "Pollfish Opened";
        } else {
            if (Intrinsics.areEqual(this, a.f37186a)) {
                return "Pollfish Closed";
            }
            if (Intrinsics.areEqual(this, f.f37191a)) {
                return "Pollfish User Not Eligible";
            }
            if (Intrinsics.areEqual(this, g.f37192a)) {
                return "Pollfish User Rejected Survey";
            }
            if (Intrinsics.areEqual(this, d.f37189a)) {
                return "Pollfish Survey Not Available";
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
