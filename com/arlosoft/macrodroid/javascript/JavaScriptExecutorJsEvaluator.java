package com.arlosoft.macrodroid.javascript;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.javascript.JavaScripResult;
import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaScriptExecutorJsEvaluator.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class JavaScriptExecutorJsEvaluator {
    public static final int $stable = 0;
    @NotNull
    public static final JavaScriptExecutorJsEvaluator INSTANCE = new JavaScriptExecutorJsEvaluator();

    private JavaScriptExecutorJsEvaluator() {
    }

    public final void executeJavaScript(@NotNull Context context, @NotNull String script, @NotNull Function1<? super String, Unit> consoleCallback, @NotNull final Function1<? super JavaScripResult, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(consoleCallback, "consoleCallback");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        new JsEvaluator(context).evaluate(script, new JsCallback() { // from class: com.arlosoft.macrodroid.javascript.JavaScriptExecutorJsEvaluator$executeJavaScript$1
            @Override // com.evgenii.jsevaluator.interfaces.JsCallback
            public void onError(@Nullable String str) {
                resultCallback.invoke(new JavaScripResult.Failure(new Throwable(str)));
            }

            @Override // com.evgenii.jsevaluator.interfaces.JsCallback
            public void onResult(@Nullable String str) {
                Function1<JavaScripResult, Unit> function1 = resultCallback;
                if (str == null) {
                    str = "";
                }
                function1.invoke(new JavaScripResult.Success(str));
            }
        });
    }
}
