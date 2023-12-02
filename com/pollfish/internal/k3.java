package com.pollfish.internal;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.pollfish.internal.PollfishOverlayActivity;
import com.pollfish.internal.f4;
import com.pollfish.internal.k3;
import com.pollfish.internal.l4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class k3 extends c3 {
    public final int A;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    public final int f36978w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public a f36979x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    public View f36980y;

    /* renamed from: z  reason: collision with root package name */
    public final int f36981z;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function0<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f36982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k3 f36983b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f36984c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k3 k3Var, boolean z3, boolean z4) {
            super(0);
            this.f36982a = z3;
            this.f36983b = k3Var;
            this.f36984c = z4;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            if (this.f36982a) {
                k3.a(this.f36983b);
                k3 k3Var = this.f36983b;
                k3Var.a(new n3(k3Var, this.f36984c));
            } else {
                k3.a(this.f36983b, false, this.f36984c);
            }
            return Unit.INSTANCE;
        }
    }

    public k3(@NotNull Context context, @NotNull u3 u3Var, @NotNull x0 x0Var, @NotNull int i4, @NotNull d2 d2Var) {
        super(context, u3Var, x0Var, d2Var);
        int i5;
        this.f36978w = i4;
        g2 d4 = u3Var.d();
        int i6 = 100;
        if (d4 != null) {
            i5 = d4.q();
        } else {
            u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
            i5 = 100;
        }
        this.f36981z = i5;
        g2 d5 = u3Var.d();
        if (d5 != null) {
            i6 = d5.f();
        } else {
            u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
        }
        this.A = i6;
        o();
    }

    public static final void a(k3 k3Var, View view) {
        k3Var.g();
    }

    public static final void b(k3 k3Var, Function0 function0) {
        s5.a(k3Var, new m3(function0));
    }

    private final float getEndHorizontalPosition() {
        if (this.f36978w == 2) {
            return getWidth() - ((getWidth() * getWidthPercentage()) / 100);
        }
        return 0.0f;
    }

    private final float getStartHorizontalPosition() {
        if (this.f36978w == 2) {
            return getWidth();
        }
        return ((-getWidth()) * getWidthPercentage()) / 100;
    }

    private final View getTranslucentView() {
        View view = this.f36980y;
        if (view == null) {
            View l4 = l();
            this.f36980y = l4;
            return l4;
        }
        return view;
    }

    @Override // com.pollfish.internal.c3
    public int getHeightPercentage() {
        return this.A;
    }

    @Nullable
    public final a getLifecycleCallback() {
        return this.f36979x;
    }

    @Override // com.pollfish.internal.c3
    public int getWidthPercentage() {
        return this.f36981z;
    }

    public final void k() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator alpha;
        View translucentView = getTranslucentView();
        if (translucentView != null && (animate = translucentView.animate()) != null && (duration = animate.setDuration(500L)) != null && (alpha = duration.alpha(0.5f)) != null) {
            alpha.start();
        }
    }

    public final View l() {
        View view = new View(getContext());
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setAlpha(0.0f);
        view.setClickable(true);
        view.setFocusable(true);
        g2 d4 = getViewModel().d();
        Unit unit = null;
        View.OnClickListener onClickListener = null;
        if (d4 != null) {
            view.setBackgroundColor(Color.parseColor(d4.b()));
            if (d4.d()) {
                onClickListener = new View.OnClickListener() { // from class: k1.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        k3.a(k3.this, view2);
                    }
                };
            }
            view.setOnClickListener(onClickListener);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            getViewModel().a(f4.a.ERROR, new l4.a.u(getViewModel().toString()));
        }
        return view;
    }

    public final void m() {
        g();
    }

    public final void n() {
        getViewModel().onPollfishOpened();
        b4 webView = getWebView();
        if (webView != null) {
            webView.a("javascript:Pollfish.mobile.interface.panelOpened();");
        }
    }

    public final void o() {
        removeView(getTranslucentView());
        removeView(getSurveyPanelContainer());
        addView(getTranslucentView());
        addView(getSurveyPanelContainer());
    }

    public final void setLifecycleCallback(@Nullable a aVar) {
        this.f36979x = aVar;
    }

    public static final void a(k3 k3Var) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        View translucentView = k3Var.getTranslucentView();
        if (translucentView == null || (animate = translucentView.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(500L)) == null) {
            return;
        }
        duration.start();
    }

    public final void a(@NotNull final PollfishOverlayActivity.a aVar) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator x3;
        ViewPropertyAnimator withEndAction;
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.setX(getStartHorizontalPosition());
        }
        RelativeLayout surveyPanelContainer2 = getSurveyPanelContainer();
        if (surveyPanelContainer2 == null || (animate = surveyPanelContainer2.animate()) == null || (duration = animate.setDuration(700L)) == null || (x3 = duration.x(getEndHorizontalPosition())) == null || (withEndAction = x3.withEndAction(new Runnable() { // from class: k1.n
            @Override // java.lang.Runnable
            public final void run() {
                k3.a(k3.this, aVar);
            }
        })) == null) {
            return;
        }
        withEndAction.start();
    }

    public static final void a(k3 k3Var, Function0 function0) {
        s5.a(k3Var, new l3(function0));
    }

    public final void a(final n3 n3Var) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator x3;
        ViewPropertyAnimator withEndAction;
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer == null || (animate = surveyPanelContainer.animate()) == null || (duration = animate.setDuration(700L)) == null || (x3 = duration.x(getStartHorizontalPosition())) == null || (withEndAction = x3.withEndAction(new Runnable() { // from class: k1.o
            @Override // java.lang.Runnable
            public final void run() {
                k3.b(k3.this, n3Var);
            }
        })) == null) {
            return;
        }
        withEndAction.start();
    }

    public static final void a(k3 k3Var, boolean z3, boolean z4) {
        a aVar = k3Var.f36979x;
        if (aVar != null) {
            aVar.a();
        }
        k3Var.f36979x = null;
        super.a(z3, z4);
    }

    @Override // com.pollfish.internal.c3
    public final void a(boolean z3, boolean z4) {
        s5.a(this, new b(this, z3, z4));
    }
}
