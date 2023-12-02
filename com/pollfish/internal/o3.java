package com.pollfish.internal;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class o3 extends c3 {
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    public final ViewGroup f37140w;

    public o3(@NotNull ViewGroup viewGroup, @NotNull u3 u3Var, @NotNull x0 x0Var, @NotNull d2 d2Var) {
        super(viewGroup.getContext(), u3Var, x0Var, d2Var);
        this.f37140w = viewGroup;
        k();
        if (Intrinsics.areEqual(u3Var.q().a(), Boolean.TRUE)) {
            i();
        }
    }

    @Override // com.pollfish.internal.c3
    public int getHeightPercentage() {
        return 100;
    }

    @Override // com.pollfish.internal.c3
    public int getWidthPercentage() {
        return 100;
    }

    @Override // com.pollfish.internal.c3
    public final void h() {
        super.h();
        getViewModel().q().b(getVisibilityObserver());
    }

    @Override // com.pollfish.internal.c3
    public final void i() {
        super.i();
        if (getVisibility() != 0) {
            this.f37140w.addView(this, new RelativeLayout.LayoutParams(-1, -1));
            setVisibility(0);
            b4 webView = getWebView();
            if (webView != null) {
                webView.a("javascript:Pollfish.mobile.interface.panelOpened();");
            }
            getViewModel().onPollfishOpened();
            this.f37140w.requestLayout();
        }
    }

    @Override // com.pollfish.internal.c3
    public final void j() {
        super.j();
        getViewModel().q().c(getVisibilityObserver());
    }

    public final void k() {
        removeView(getSurveyPanelContainer());
        addView(getSurveyPanelContainer());
    }
}
