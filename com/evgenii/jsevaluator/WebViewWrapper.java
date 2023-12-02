package com.evgenii.jsevaluator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.evgenii.jsevaluator.interfaces.CallJavaResultInterface;
import com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface;
import java.io.UnsupportedEncodingException;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes3.dex */
public class WebViewWrapper implements WebViewWrapperInterface {

    /* renamed from: a  reason: collision with root package name */
    protected WebView f17604a;

    public WebViewWrapper(Context context, CallJavaResultInterface callJavaResultInterface) {
        WebView webView = new WebView(context);
        this.f17604a = webView;
        webView.setWillNotDraw(true);
        WebSettings settings = this.f17604a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        this.f17604a.addJavascriptInterface(new JavaScriptInterface(callJavaResultInterface), JsEvaluator.JS_NAMESPACE);
    }

    @Override // com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface
    public void destroy() {
        WebView webView = this.f17604a;
        if (webView != null) {
            webView.removeJavascriptInterface(JsEvaluator.JS_NAMESPACE);
            this.f17604a.loadUrl("about:blank");
            this.f17604a.stopLoading();
            this.f17604a.clearHistory();
            this.f17604a.removeAllViews();
            this.f17604a.destroyDrawingCache();
            this.f17604a.destroy();
            this.f17604a = null;
        }
    }

    @Override // com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface
    public WebView getWebView() {
        return this.f17604a;
    }

    @Override // com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface
    public void loadJavaScript(String str) {
        try {
            String encodeToString = Base64.encodeToString(("<script>" + str + "</script>").getBytes("UTF-8"), 0);
            WebView webView = this.f17604a;
            webView.loadUrl("data:text/html;charset=utf-8;base64," + encodeToString);
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
    }
}
