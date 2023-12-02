package com.pollfish.internal;

import android.widget.RelativeLayout;
import com.pollfish.internal.l4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class f3 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f36815a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f3(c3 c3Var) {
        super(0);
        this.f36815a = c3Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        RelativeLayout topMediationContainer;
        RelativeLayout bottomMediationContainer;
        RelativeLayout surveyPanelContainer;
        RelativeLayout surveyPanelContainer2;
        try {
            topMediationContainer = this.f36815a.getTopMediationContainer();
            if (topMediationContainer != null && (surveyPanelContainer2 = this.f36815a.getSurveyPanelContainer()) != null) {
                surveyPanelContainer2.removeView(topMediationContainer);
            }
            bottomMediationContainer = this.f36815a.getBottomMediationContainer();
            if (bottomMediationContainer != null && (surveyPanelContainer = this.f36815a.getSurveyPanelContainer()) != null) {
                surveyPanelContainer.removeView(bottomMediationContainer);
            }
            b4 webView = this.f36815a.getWebView();
            if (webView != null) {
                this.f36815a.a(webView);
            }
            RelativeLayout surveyPanelContainer3 = this.f36815a.getSurveyPanelContainer();
            if (surveyPanelContainer3 != null) {
                surveyPanelContainer3.requestLayout();
            }
        } catch (Exception e4) {
            this.f36815a.getViewModel().a(new l4.a.d0(e4));
        }
        return Unit.INSTANCE;
    }
}
