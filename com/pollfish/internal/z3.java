package com.pollfish.internal;

import android.webkit.JavascriptInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public interface z3 extends s2 {
    void b();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void close();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void closeAndNoShow();

    void d();

    void e();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    @NotNull
    /* synthetic */ String getDeviceInfo();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    @NotNull
    /* synthetic */ String getFromServer();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void hideMediationViews();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void noSurveyFound();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void notifyVideoEnd();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void openWeb();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void openWebsite(@NotNull String str);

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void openWebsiteInWebview(@NotNull String str);

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void sendToServer(@NotNull String str, @NotNull String str2, boolean z3);

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void sentDataOfUserConsentToServer(@NotNull String str, @NotNull String str2);

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void sentDataOfUserConsentToServer(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void setSurveyCompleted();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void setSurveyCompleted(@Nullable String str);

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void showToastMsg(@NotNull String str);

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void textFieldFocus();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void textFieldUnFocus();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void userNotEligible();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void userRejectedSurvey();

    @Override // com.pollfish.internal.s2
    @JavascriptInterface
    /* synthetic */ void webViewLoaded();
}
