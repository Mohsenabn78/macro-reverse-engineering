package com.arlosoft.macrodroid.javascript;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.javascriptengine.JavaScriptConsoleCallback;
import androidx.javascriptengine.JavaScriptIsolate;
import androidx.javascriptengine.JavaScriptSandbox;
import androidx.javascriptengine.s;
import com.arlosoft.macrodroid.extensions.ContextExtensionsKt;
import com.arlosoft.macrodroid.javascript.JavaScripResult;
import com.arlosoft.macrodroid.javascript.JavaScriptExecutorJetPack;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaScriptExecutorJetPack.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class JavaScriptExecutorJetPack {
    public static final int $stable = 0;
    @NotNull
    public static final JavaScriptExecutorJetPack INSTANCE = new JavaScriptExecutorJetPack();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaScriptExecutorJetPack.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<JavaScriptSandbox, JavaScriptIsolate> {
        final /* synthetic */ Ref.ObjectRef<JavaScriptSandbox> $jsSandBox;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.ObjectRef<JavaScriptSandbox> objectRef) {
            super(1);
            this.$jsSandBox = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public final JavaScriptIsolate invoke(@NotNull JavaScriptSandbox input) {
            Intrinsics.checkNotNullParameter(input, "input");
            this.$jsSandBox.element = input;
            return input.createIsolate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaScriptExecutorJetPack.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<JavaScriptIsolate, ListenableFuture<String>> {
        final /* synthetic */ Function1<String, Unit> $consoleCallback;
        final /* synthetic */ String $script;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function1<? super String, Unit> function1) {
            super(1);
            this.$script = str;
            this.$consoleCallback = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function1 consoleCallback, JavaScriptConsoleCallback.ConsoleMessage it) {
            Intrinsics.checkNotNullParameter(consoleCallback, "$consoleCallback");
            Intrinsics.checkNotNullParameter(it, "it");
            String message = it.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "it.message");
            consoleCallback.invoke(message);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final ListenableFuture<String> invoke(@NotNull JavaScriptIsolate isolate) {
            Intrinsics.checkNotNullParameter(isolate, "isolate");
            final Function1<String, Unit> function1 = this.$consoleCallback;
            isolate.setConsoleCallback(new JavaScriptConsoleCallback() { // from class: com.arlosoft.macrodroid.javascript.d
                @Override // androidx.javascriptengine.JavaScriptConsoleCallback
                public /* synthetic */ void onConsoleClear() {
                    s.a(this);
                }

                @Override // androidx.javascriptengine.JavaScriptConsoleCallback
                public final void onConsoleMessage(JavaScriptConsoleCallback.ConsoleMessage consoleMessage) {
                    JavaScriptExecutorJetPack.b.c(Function1.this, consoleMessage);
                }
            });
            return isolate.evaluateJavaScriptAsync(this.$script);
        }
    }

    private JavaScriptExecutorJetPack() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JavaScriptIsolate c(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (JavaScriptIsolate) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ListenableFuture d(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (ListenableFuture) tmp0.invoke(obj);
    }

    public final void executeJavaScript(@NotNull Context context, @Nullable Macro macro, @NotNull String script, @NotNull Function1<? super String, Unit> consoleCallback, @NotNull Function1<? super JavaScripResult, Unit> resultCallback) {
        long j4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(consoleCallback, "consoleCallback");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ListenableFuture<JavaScriptSandbox> createConnectedInstanceAsync = JavaScriptSandbox.createConnectedInstanceAsync(context);
            Intrinsics.checkNotNullExpressionValue(createConnectedInstanceAsync, "createConnectedInstanceAsync(context)");
            final a aVar = new a(objectRef);
            ListenableFuture transform = Futures.transform(createConnectedInstanceAsync, new Function() { // from class: com.arlosoft.macrodroid.javascript.a
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    JavaScriptIsolate c4;
                    c4 = JavaScriptExecutorJetPack.c(Function1.this, obj);
                    return c4;
                }
            }, ContextExtensionsKt.theMainExecutor(context));
            final b bVar = new b(script, consoleCallback);
            Futures.addCallback(Futures.transformAsync(transform, new AsyncFunction() { // from class: com.arlosoft.macrodroid.javascript.b
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    ListenableFuture d4;
                    d4 = JavaScriptExecutorJetPack.d(Function1.this, obj);
                    return d4;
                }
            }, ContextExtensionsKt.theMainExecutor(context)), new JavaScriptExecutorJetPack$executeJavaScript$1(objectRef, resultCallback), ContextExtensionsKt.theMainExecutor(context));
        } catch (Exception e4) {
            resultCallback.invoke(new JavaScripResult.Failure(e4));
            if (macro != null) {
                j4 = macro.getGUID();
            } else {
                j4 = 0;
            }
            SystemLog.logError("This device does not support the Jetpack Javascript Engine", j4);
        }
    }
}
