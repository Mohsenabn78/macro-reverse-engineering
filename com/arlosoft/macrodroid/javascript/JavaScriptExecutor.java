package com.arlosoft.macrodroid.javascript;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.javascript.JavaScripResult;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaScriptExecutor.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class JavaScriptExecutor {
    public static final int $stable = 0;
    @NotNull
    public static final String ENGINE_JETPACK = "JetPack JavascriptEngine";
    @NotNull
    public static final String ENGINE_JSEVALUATOR = "JSEvaluator";
    @NotNull
    public static final String ENGINE_QUICKJS = "QuickJS";
    @NotNull
    public static final JavaScriptExecutor INSTANCE = new JavaScriptExecutor();

    private JavaScriptExecutor() {
    }

    public final void executeJavaScript(@NotNull Context context, @NotNull String engine, @Nullable Macro macro, @NotNull String script, @NotNull Function1<? super String, Unit> consoleCallback, @NotNull Function1<? super JavaScripResult, Unit> resultCallback) {
        long j4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(consoleCallback, "consoleCallback");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        try {
            int hashCode = engine.hashCode();
            if (hashCode != -1971978282) {
                if (hashCode != -757410723) {
                    if (hashCode == -531734298 && engine.equals(ENGINE_JSEVALUATOR)) {
                        JavaScriptExecutorJsEvaluator.INSTANCE.executeJavaScript(context, script, consoleCallback, resultCallback);
                        return;
                    }
                } else if (engine.equals("JetPack JavascriptEngine")) {
                    JavaScriptExecutorJetPack.INSTANCE.executeJavaScript(context, macro, script, consoleCallback, resultCallback);
                    return;
                }
            } else if (engine.equals(ENGINE_QUICKJS)) {
                JavaScriptExecutorQuickJs.INSTANCE.executeJavaScript(context, script, consoleCallback, resultCallback);
                return;
            }
            resultCallback.invoke(new JavaScripResult.Failure(new IllegalArgumentException("Invalid JavaScript engine: " + engine)));
            String str = "Invalid JavaScript engine: " + engine;
            if (macro != null) {
                j4 = macro.getGUID();
            } else {
                j4 = 0;
            }
            SystemLog.logError(str, j4);
        } catch (Throwable th) {
            resultCallback.invoke(new JavaScripResult.Failure(th));
            SystemLog.logError("JavaScrip failure: " + th);
        }
    }
}
