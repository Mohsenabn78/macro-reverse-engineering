package com.arlosoft.macrodroid.javascript;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.javascript.JavaScripResult;
import com.hippo.quickjs.android.JSContext;
import com.hippo.quickjs.android.JSRuntime;
import com.hippo.quickjs.android.QuickJS;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaScriptExecutorQuickJs.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class JavaScriptExecutorQuickJs {
    public static final int $stable = 0;
    @NotNull
    public static final JavaScriptExecutorQuickJs INSTANCE = new JavaScriptExecutorQuickJs();

    private JavaScriptExecutorQuickJs() {
    }

    public final void executeJavaScript(@NotNull Context context, @NotNull String script, @NotNull Function1<? super String, Unit> consoleCallback, @NotNull Function1<? super JavaScripResult, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(consoleCallback, "consoleCallback");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        try {
            JSRuntime createJSRuntime = new QuickJS.Builder().build().createJSRuntime();
            JSContext createJSContext = createJSRuntime.createJSContext();
            try {
                String str = (String) createJSContext.evaluate(script, "macrodroid.js", String.class);
                if (str == null) {
                    resultCallback.invoke(new JavaScripResult.Success(""));
                } else {
                    resultCallback.invoke(new JavaScripResult.Success(str));
                }
            } catch (Exception e4) {
                resultCallback.invoke(new JavaScripResult.Failure(e4));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(createJSContext, null);
            CloseableKt.closeFinally(createJSRuntime, null);
        } catch (Exception e5) {
            resultCallback.invoke(new JavaScripResult.Failure(e5));
        }
    }
}
