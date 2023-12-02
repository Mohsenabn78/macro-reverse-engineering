package com.evgenii.jsevaluator;

import android.webkit.JavascriptInterface;
import com.evgenii.jsevaluator.interfaces.CallJavaResultInterface;

/* loaded from: classes3.dex */
public class JavaScriptInterface {

    /* renamed from: a  reason: collision with root package name */
    private final CallJavaResultInterface f17596a;

    public JavaScriptInterface(CallJavaResultInterface callJavaResultInterface) {
        this.f17596a = callJavaResultInterface;
    }

    @JavascriptInterface
    public void returnResultToJava(String str) {
        this.f17596a.jsCallFinished(str);
    }
}
