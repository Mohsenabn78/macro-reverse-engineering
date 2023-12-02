package com.pollfish.internal;

import android.webkit.JavascriptInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public interface s2 {
    @JavascriptInterface
    void close();

    @JavascriptInterface
    void closeAndNoShow();

    @JavascriptInterface
    @NotNull
    String getDeviceInfo();

    @JavascriptInterface
    @NotNull
    String getFromServer();

    @JavascriptInterface
    void hideMediationViews();

    @JavascriptInterface
    void noSurveyFound();

    @JavascriptInterface
    void notifyVideoEnd();

    @JavascriptInterface
    void openWeb();

    @JavascriptInterface
    void openWebsite(@NotNull String str);

    @JavascriptInterface
    void openWebsiteInWebview(@NotNull String str);

    @JavascriptInterface
    void sendToServer(@NotNull String str, @NotNull String str2, boolean z3);

    @JavascriptInterface
    void sentDataOfUserConsentToServer(@NotNull String str, @NotNull String str2);

    @JavascriptInterface
    void sentDataOfUserConsentToServer(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @JavascriptInterface
    void setSurveyCompleted();

    @JavascriptInterface
    void setSurveyCompleted(@Nullable String str);

    @JavascriptInterface
    void showToastMsg(@NotNull String str);

    @JavascriptInterface
    void textFieldFocus();

    @JavascriptInterface
    void textFieldUnFocus();

    @JavascriptInterface
    void userNotEligible();

    @JavascriptInterface
    void userRejectedSurvey();

    @JavascriptInterface
    void webViewLoaded();
}
