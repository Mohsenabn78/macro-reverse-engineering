package com.evgenii.jsevaluator.interfaces;

import android.webkit.WebView;

/* loaded from: classes3.dex */
public interface JsEvaluatorInterface {
    void callFunction(String str, JsCallback jsCallback, String str2, Object... objArr);

    void destroy();

    void evaluate(String str);

    void evaluate(String str, JsCallback jsCallback);

    WebView getWebView();
}
