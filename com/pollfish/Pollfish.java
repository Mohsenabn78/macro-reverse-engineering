package com.pollfish;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.pollfish.Pollfish;
import com.pollfish.builder.Params;
import com.pollfish.callback.PollfishClosedListener;
import com.pollfish.callback.PollfishOpenedListener;
import com.pollfish.callback.PollfishSurveyCompletedListener;
import com.pollfish.callback.PollfishSurveyNotAvailableListener;
import com.pollfish.callback.PollfishSurveyReceivedListener;
import com.pollfish.callback.PollfishUserNotEligibleListener;
import com.pollfish.callback.PollfishUserRejectedSurveyListener;
import com.pollfish.callback.SurveyInfo;
import com.pollfish.internal.b2;
import com.pollfish.internal.m5;
import com.pollfish.internal.r1;
import com.pollfish.internal.t2;
import com.pollfish.internal.w5;
import com.pollfish.internal.y;
import com.pollfish.internal.z1;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/pollfish/Pollfish;", "", "Lcom/pollfish/internal/y;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Lcom/pollfish/internal/y;", "getCompositionRoot$pollfish_googleplayRelease", "()Lcom/pollfish/internal/y;", "compositionRoot", "Companion", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class Pollfish {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public static volatile Pollfish f36581d;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f36582a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public t2 f36583b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final y f36584c;

    public /* synthetic */ Pollfish(Params params, Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, params);
    }

    public static final void access$dismiss(Pollfish pollfish) {
        pollfish.f36583b = null;
        pollfish.f36584c.k().n();
    }

    public static final void access$onHide(Pollfish pollfish) {
        pollfish.f36584c.k().w();
    }

    public static final boolean access$onIsPollfishPanelOpen(Pollfish pollfish) {
        return pollfish.f36584c.k().c();
    }

    public static final boolean access$onIsPollfishPresent(Pollfish pollfish) {
        return pollfish.f36584c.k().i();
    }

    public static final void access$onLifecycleEvent(Pollfish pollfish, r1 r1Var) {
        pollfish.getClass();
        if (r1Var != null) {
            if (r1Var instanceof r1.c) {
                pollfish.a(((r1.c) r1Var).a());
            } else if (r1Var instanceof r1.e) {
                pollfish.b(((r1.e) r1Var).a());
            } else if (Intrinsics.areEqual(r1Var, r1.d.f37189a)) {
                pollfish.c();
            } else if (Intrinsics.areEqual(r1Var, r1.f.f37191a)) {
                pollfish.d();
            } else if (Intrinsics.areEqual(r1Var, r1.g.f37192a)) {
                pollfish.e();
            } else if (Intrinsics.areEqual(r1Var, r1.b.f37187a)) {
                pollfish.b();
            } else if (Intrinsics.areEqual(r1Var, r1.a.f37186a)) {
                pollfish.a();
            }
        }
    }

    public static final void access$onShow(Pollfish pollfish, Activity activity) {
        if (activity != null) {
            pollfish.f36584c.f37331a.a(activity);
            pollfish.f36584c.a(activity);
            pollfish.f36582a = new WeakReference<>(activity);
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null) {
                t2Var.a(activity);
            }
        }
        if (pollfish.f36582a.get() != null) {
            pollfish.f36584c.k().f();
        }
    }

    public static final void access$startFlow(Pollfish pollfish) {
        pollfish.f36584c.k().b();
    }

    public static final void access$updateParams(Pollfish pollfish, Params params, Context context) {
        pollfish.f36584c.a(params, context);
    }

    @JvmStatic
    public static final void hide() {
        Companion.hide();
    }

    @JvmStatic
    public static final void initWith(@NotNull Activity activity, @NotNull Params params) {
        Companion.initWith(activity, params);
    }

    @JvmStatic
    public static final boolean isPollfishPanelOpen() {
        return Companion.isPollfishPanelOpen();
    }

    @JvmStatic
    public static final boolean isPollfishPresent() {
        return Companion.isPollfishPresent();
    }

    @JvmStatic
    public static final void show() {
        Companion.show();
    }

    public final void a(SurveyInfo surveyInfo) {
        final SurveyInfo surveyInfo2 = new SurveyInfo(surveyInfo != null ? surveyInfo.getSurveyCPA() : null, surveyInfo != null ? surveyInfo.getSurveyIR() : null, surveyInfo != null ? surveyInfo.getSurveyLOI() : null, surveyInfo != null ? surveyInfo.getSurveyClass() : null, surveyInfo != null ? surveyInfo.getRewardName() : null, surveyInfo != null ? surveyInfo.getRewardValue() : null, surveyInfo != null ? surveyInfo.getRemainingCompletes() : null);
        final Activity activity = this.f36582a.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: j1.e
                @Override // java.lang.Runnable
                public final void run() {
                    Pollfish.a(Pollfish.this, surveyInfo2, activity);
                }
            });
        }
    }

    public final void b(final SurveyInfo surveyInfo) {
        final Activity activity = this.f36582a.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: j1.d
                @Override // java.lang.Runnable
                public final void run() {
                    Pollfish.b(Pollfish.this, surveyInfo, activity);
                }
            });
        }
    }

    public final void c() {
        final Activity activity = this.f36582a.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: j1.c
                @Override // java.lang.Runnable
                public final void run() {
                    Pollfish.c(Pollfish.this, activity);
                }
            });
        }
    }

    public final void d() {
        final Activity activity = this.f36582a.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: j1.b
                @Override // java.lang.Runnable
                public final void run() {
                    Pollfish.d(Pollfish.this, activity);
                }
            });
        }
    }

    public final void e() {
        final Activity activity = this.f36582a.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: j1.a
                @Override // java.lang.Runnable
                public final void run() {
                    Pollfish.e(Pollfish.this, activity);
                }
            });
        }
    }

    @NotNull
    public final y getCompositionRoot$pollfish_googleplayRelease() {
        return this.f36584c;
    }

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\f\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/pollfish/Pollfish$Companion;", "", "Lcom/pollfish/Pollfish;", "getInstance$pollfish_googleplayRelease", "()Lcom/pollfish/Pollfish;", "getInstance", "Landroid/app/Activity;", "activity", "Lcom/pollfish/builder/Params;", "params", "", "initWith", "show", "hide", "", "isPollfishPresent", "isPollfishPanelOpen", "instance", "Lcom/pollfish/Pollfish;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Pollfish getInstance$pollfish_googleplayRelease() {
            return Pollfish.f36581d;
        }

        @JvmStatic
        public final void hide() {
            try {
                Pollfish instance$pollfish_googleplayRelease = getInstance$pollfish_googleplayRelease();
                if (instance$pollfish_googleplayRelease != null) {
                    Pollfish.access$onHide(instance$pollfish_googleplayRelease);
                }
            } catch (IllegalArgumentException e4) {
                Log.e("Pollfish", e4.getMessage());
            }
        }

        @JvmStatic
        public final void initWith(@NotNull Activity activity, @NotNull Params params) {
            Context context;
            ViewGroup userLayout = params.getUserLayout();
            if (userLayout != null) {
                context = userLayout.getContext();
            } else {
                context = null;
            }
            if (context != null && !(params.getUserLayout().getContext() instanceof Activity)) {
                Log.w("Pollfish", "Passing a View that does not belong to an Activity is not supported. Please make sure the ViewGroup.context is an Activity instance.");
                return;
            }
            if (Pollfish.f36581d == null) {
                Pollfish.f36581d = new Pollfish(params, activity, null);
            } else {
                Pollfish pollfish = Pollfish.f36581d;
                if (pollfish != null) {
                    Pollfish.access$dismiss(pollfish);
                    w5 w5Var = pollfish.getCompositionRoot$pollfish_googleplayRelease().f37331a;
                    w5Var.f37284a.q().c(w5Var.f37290g);
                    w5Var.f37285b.b(w5Var.f37291h);
                    m5.f37084b.getClass();
                    m5.a.a().f37087a.shutdown();
                    pollfish.f36582a = new WeakReference(activity);
                    Pollfish.access$updateParams(pollfish, params, activity);
                    pollfish.f36583b = z1.a(params);
                }
            }
            Pollfish pollfish2 = Pollfish.f36581d;
            if (pollfish2 != null) {
                Pollfish.access$startFlow(pollfish2);
            }
        }

        @JvmStatic
        public final boolean isPollfishPanelOpen() {
            try {
                Pollfish instance$pollfish_googleplayRelease = getInstance$pollfish_googleplayRelease();
                if (instance$pollfish_googleplayRelease == null) {
                    return false;
                }
                return Pollfish.access$onIsPollfishPanelOpen(instance$pollfish_googleplayRelease);
            } catch (IllegalArgumentException e4) {
                Log.e("Pollfish", e4.getMessage());
                return false;
            }
        }

        @JvmStatic
        public final boolean isPollfishPresent() {
            try {
                Pollfish instance$pollfish_googleplayRelease = getInstance$pollfish_googleplayRelease();
                if (instance$pollfish_googleplayRelease == null) {
                    return false;
                }
                return Pollfish.access$onIsPollfishPresent(instance$pollfish_googleplayRelease);
            } catch (IllegalArgumentException e4) {
                Log.e("Pollfish", e4.getMessage());
                return false;
            }
        }

        @JvmStatic
        public final void show(@NotNull Activity activity) {
            try {
                Pollfish instance$pollfish_googleplayRelease = getInstance$pollfish_googleplayRelease();
                if (instance$pollfish_googleplayRelease != null) {
                    Pollfish.access$onShow(instance$pollfish_googleplayRelease, activity);
                }
            } catch (IllegalArgumentException e4) {
                Log.e("Pollfish", e4.getMessage());
            }
        }

        @JvmStatic
        public final void show() {
            try {
                Pollfish instance$pollfish_googleplayRelease = getInstance$pollfish_googleplayRelease();
                if (instance$pollfish_googleplayRelease != null) {
                    Pollfish.access$onShow(instance$pollfish_googleplayRelease, null);
                }
            } catch (IllegalArgumentException e4) {
                Log.e("Pollfish", e4.getMessage());
            }
        }
    }

    public Pollfish(Activity activity, Params params) {
        y yVar = new y(params, activity);
        this.f36584c = yVar;
        yVar.g().a(new b2(this));
        this.f36583b = z1.a(params);
        this.f36582a = new WeakReference<>(activity);
    }

    @JvmStatic
    public static final void show(@NotNull Activity activity) {
        Companion.show(activity);
    }

    public static final void b(Pollfish pollfish, SurveyInfo surveyInfo, Activity activity) {
        PollfishSurveyReceivedListener e4;
        try {
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null && (e4 = t2Var.e()) != null) {
                e4.onPollfishSurveyReceived(surveyInfo);
            }
        } catch (Exception unused) {
            pollfish.f36583b = null;
        }
        if (activity instanceof PollfishSurveyReceivedListener) {
            t2 t2Var2 = pollfish.f36583b;
            if (Intrinsics.areEqual(activity, t2Var2 != null ? t2Var2.e() : null)) {
                return;
            }
            ((PollfishSurveyReceivedListener) activity).onPollfishSurveyReceived(surveyInfo);
        }
    }

    public static final void c(Pollfish pollfish, Activity activity) {
        PollfishSurveyNotAvailableListener d4;
        try {
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null && (d4 = t2Var.d()) != null) {
                d4.onPollfishSurveyNotAvailable();
            }
        } catch (Exception unused) {
            pollfish.f36583b = null;
        }
        if (activity instanceof PollfishSurveyNotAvailableListener) {
            t2 t2Var2 = pollfish.f36583b;
            if (Intrinsics.areEqual(activity, t2Var2 != null ? t2Var2.d() : null)) {
                return;
            }
            ((PollfishSurveyNotAvailableListener) activity).onPollfishSurveyNotAvailable();
        }
    }

    public static final void d(Pollfish pollfish, Activity activity) {
        PollfishUserNotEligibleListener f4;
        try {
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null && (f4 = t2Var.f()) != null) {
                f4.onUserNotEligible();
            }
        } catch (Exception unused) {
            pollfish.f36583b = null;
        }
        if (activity instanceof PollfishUserNotEligibleListener) {
            t2 t2Var2 = pollfish.f36583b;
            if (Intrinsics.areEqual(activity, t2Var2 != null ? t2Var2.f() : null)) {
                return;
            }
            ((PollfishUserNotEligibleListener) activity).onUserNotEligible();
        }
    }

    public static final void e(Pollfish pollfish, Activity activity) {
        PollfishUserRejectedSurveyListener g4;
        try {
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null && (g4 = t2Var.g()) != null) {
                g4.onUserRejectedSurvey();
            }
        } catch (Exception unused) {
            pollfish.f36583b = null;
        }
        if (activity instanceof PollfishUserRejectedSurveyListener) {
            t2 t2Var2 = pollfish.f36583b;
            if (Intrinsics.areEqual(activity, t2Var2 != null ? t2Var2.g() : null)) {
                return;
            }
            ((PollfishUserRejectedSurveyListener) activity).onUserRejectedSurvey();
        }
    }

    public final void b() {
        final Activity activity = this.f36582a.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: j1.f
                @Override // java.lang.Runnable
                public final void run() {
                    Pollfish.b(Pollfish.this, activity);
                }
            });
        }
    }

    public static final void b(Pollfish pollfish, Activity activity) {
        PollfishOpenedListener b4;
        try {
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null && (b4 = t2Var.b()) != null) {
                b4.onPollfishOpened();
            }
        } catch (Exception unused) {
            pollfish.f36583b = null;
        }
        if (activity instanceof PollfishOpenedListener) {
            t2 t2Var2 = pollfish.f36583b;
            if (Intrinsics.areEqual(activity, t2Var2 != null ? t2Var2.b() : null)) {
                return;
            }
            ((PollfishOpenedListener) activity).onPollfishOpened();
        }
    }

    public static final void a(Pollfish pollfish, SurveyInfo surveyInfo, Activity activity) {
        PollfishSurveyCompletedListener c4;
        try {
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null && (c4 = t2Var.c()) != null) {
                c4.onPollfishSurveyCompleted(surveyInfo);
            }
        } catch (Exception unused) {
            pollfish.f36583b = null;
        }
        if (activity instanceof PollfishSurveyCompletedListener) {
            t2 t2Var2 = pollfish.f36583b;
            if (Intrinsics.areEqual(activity, t2Var2 != null ? t2Var2.c() : null)) {
                return;
            }
            ((PollfishSurveyCompletedListener) activity).onPollfishSurveyCompleted(surveyInfo);
        }
    }

    public final void a() {
        final Activity activity = this.f36582a.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: j1.g
                @Override // java.lang.Runnable
                public final void run() {
                    Pollfish.a(Pollfish.this, activity);
                }
            });
        }
    }

    public static final void a(Pollfish pollfish, Activity activity) {
        PollfishClosedListener a4;
        try {
            t2 t2Var = pollfish.f36583b;
            if (t2Var != null && (a4 = t2Var.a()) != null) {
                a4.onPollfishClosed();
            }
        } catch (Exception unused) {
            pollfish.f36583b = null;
        }
        if (activity instanceof PollfishClosedListener) {
            t2 t2Var2 = pollfish.f36583b;
            if (Intrinsics.areEqual(activity, t2Var2 != null ? t2Var2.a() : null)) {
                return;
            }
            ((PollfishClosedListener) activity).onPollfishClosed();
        }
    }
}
