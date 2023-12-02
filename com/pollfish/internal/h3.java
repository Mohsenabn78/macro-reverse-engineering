package com.pollfish.internal;

import android.widget.RelativeLayout;
import com.pollfish.internal.l4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class h3 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f36896a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h3(c3 c3Var) {
        super(0);
        this.f36896a = c3Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        try {
            RelativeLayout surveyPanelContainer = this.f36896a.getSurveyPanelContainer();
            if (surveyPanelContainer != null) {
                c3.a(this.f36896a, surveyPanelContainer);
            }
            b4 webView = this.f36896a.getWebView();
            if (webView != null) {
                this.f36896a.a(webView);
            }
            RelativeLayout surveyPanelContainer2 = this.f36896a.getSurveyPanelContainer();
            if (surveyPanelContainer2 != null) {
                surveyPanelContainer2.requestLayout();
            }
        } catch (Exception e4) {
            this.f36896a.getViewModel().a(new l4.a.d0(e4));
        }
        return Unit.INSTANCE;
    }
}
