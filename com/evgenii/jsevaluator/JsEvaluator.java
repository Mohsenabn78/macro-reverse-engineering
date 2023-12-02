package com.evgenii.jsevaluator;

import android.content.Context;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.evgenii.jsevaluator.interfaces.CallJavaResultInterface;
import com.evgenii.jsevaluator.interfaces.HandlerWrapperInterface;
import com.evgenii.jsevaluator.interfaces.JsCallback;
import com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface;
import com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class JsEvaluator implements CallJavaResultInterface, JsEvaluatorInterface {
    public static final String JS_NAMESPACE = "evgeniiJsEvaluator";

    /* renamed from: a  reason: collision with root package name */
    protected WebViewWrapperInterface f17597a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17598b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicReference<JsCallback> f17599c = new AtomicReference<>(null);

    /* renamed from: d  reason: collision with root package name */
    private HandlerWrapperInterface f17600d = new HandlerWrapper();

    /* loaded from: classes3.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17601a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JsCallback f17602b;

        a(String str, JsCallback jsCallback) {
            this.f17601a = str;
            this.f17602b = jsCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f17601a;
            if (str != null && str.startsWith("evgeniiJsEvaluatorException")) {
                this.f17602b.onError(this.f17601a.substring(27));
            } else {
                this.f17602b.onResult(this.f17601a);
            }
        }
    }

    public JsEvaluator(Context context) {
        this.f17598b = context;
    }

    public static String escapeCarriageReturn(String str) {
        return str.replace("\r", "\\r");
    }

    public static String escapeClosingScript(String str) {
        return str.replace("</", "<\\/");
    }

    public static String escapeNewLines(String str) {
        return str.replace("\n", "\\n");
    }

    public static String escapeSingleQuotes(String str) {
        return str.replace("'", "\\'");
    }

    public static String escapeSlash(String str) {
        return str.replace("\\", "\\\\");
    }

    public static String getJsForEval(String str) {
        return String.format("%s.returnResultToJava(eval('try{%s}catch(e){\"%s\"+e}'));", JS_NAMESPACE, escapeCarriageReturn(escapeNewLines(escapeClosingScript(escapeSingleQuotes(escapeSlash(str))))), "evgeniiJsEvaluatorException");
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void callFunction(String str, JsCallback jsCallback, String str2, Object... objArr) {
        evaluate(str + "; " + JsFunctionCallFormatter.toString(str2, objArr), jsCallback);
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void destroy() {
        getWebViewWrapper().destroy();
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void evaluate(String str) {
        evaluate(str, null);
    }

    @VisibleForTesting
    public JsCallback getCallback() {
        return this.f17599c.get();
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public WebView getWebView() {
        return getWebViewWrapper().getWebView();
    }

    public WebViewWrapperInterface getWebViewWrapper() {
        if (this.f17597a == null) {
            this.f17597a = new WebViewWrapper(this.f17598b, this);
        }
        return this.f17597a;
    }

    @Override // com.evgenii.jsevaluator.interfaces.CallJavaResultInterface
    public void jsCallFinished(String str) {
        JsCallback andSet = this.f17599c.getAndSet(null);
        if (andSet == null) {
            return;
        }
        this.f17600d.post(new a(str, andSet));
    }

    @VisibleForTesting
    public void setHandler(HandlerWrapperInterface handlerWrapperInterface) {
        this.f17600d = handlerWrapperInterface;
    }

    @VisibleForTesting
    public void setWebViewWrapper(WebViewWrapperInterface webViewWrapperInterface) {
        this.f17597a = webViewWrapperInterface;
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void evaluate(String str, JsCallback jsCallback) {
        String jsForEval = getJsForEval(str);
        this.f17599c.set(jsCallback);
        getWebViewWrapper().loadJavaScript(jsForEval);
    }
}
