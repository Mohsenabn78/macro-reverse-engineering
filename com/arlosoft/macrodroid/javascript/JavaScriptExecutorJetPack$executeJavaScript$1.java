package com.arlosoft.macrodroid.javascript;

import android.os.Handler;
import android.os.Looper;
import androidx.javascriptengine.JavaScriptSandbox;
import com.arlosoft.macrodroid.javascript.JavaScripResult;
import com.google.common.util.concurrent.FutureCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaScriptExecutorJetPack.kt */
/* loaded from: classes3.dex */
public final class JavaScriptExecutorJetPack$executeJavaScript$1 implements FutureCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<JavaScriptSandbox> f12589a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<JavaScripResult, Unit> f12590b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public JavaScriptExecutorJetPack$executeJavaScript$1(Ref.ObjectRef<JavaScriptSandbox> objectRef, Function1<? super JavaScripResult, Unit> function1) {
        this.f12589a = objectRef;
        this.f12590b = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 resultCallback, Throwable t3) {
        Intrinsics.checkNotNullParameter(resultCallback, "$resultCallback");
        Intrinsics.checkNotNullParameter(t3, "$t");
        resultCallback.invoke(new JavaScripResult.Failure(t3));
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onFailure(@NotNull final Throwable t3) {
        Intrinsics.checkNotNullParameter(t3, "t");
        JavaScriptSandbox javaScriptSandbox = this.f12589a.element;
        if (javaScriptSandbox != null) {
            javaScriptSandbox.close();
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final Function1<JavaScripResult, Unit> function1 = this.f12590b;
        handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.javascript.c
            @Override // java.lang.Runnable
            public final void run() {
                JavaScriptExecutorJetPack$executeJavaScript$1.b(Function1.this, t3);
            }
        });
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onSuccess(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        JavaScriptSandbox javaScriptSandbox = this.f12589a.element;
        if (javaScriptSandbox != null) {
            javaScriptSandbox.close();
        }
        this.f12590b.invoke(new JavaScripResult.Success(result));
    }
}
