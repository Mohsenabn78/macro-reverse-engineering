package com.evgenii.jsevaluator.interfaces;

import android.webkit.WebView;

/* loaded from: classes3.dex */
public interface WebViewWrapperInterface {
    void destroy();

    WebView getWebView();

    void loadJavaScript(String str);
}
