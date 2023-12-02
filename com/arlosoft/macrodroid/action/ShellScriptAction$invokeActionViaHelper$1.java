package com.arlosoft.macrodroid.action;

import android.os.Handler;
import android.os.Looper;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShellScriptAction.kt */
/* loaded from: classes2.dex */
public final class ShellScriptAction$invokeActionViaHelper$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TriggerContextInfo $contextInfo;
    final /* synthetic */ boolean $forceEvenIfNotEnabled;
    final /* synthetic */ boolean $isTest;
    final /* synthetic */ int $nextAction;
    final /* synthetic */ int $requestId;
    final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
    final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
    int label;
    final /* synthetic */ ShellScriptAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShellScriptAction$invokeActionViaHelper$1(ShellScriptAction shellScriptAction, int i4, TriggerContextInfo triggerContextInfo, boolean z3, int i5, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super ShellScriptAction$invokeActionViaHelper$1> continuation) {
        super(2, continuation);
        this.this$0 = shellScriptAction;
        this.$requestId = i4;
        this.$contextInfo = triggerContextInfo;
        this.$isTest = z3;
        this.$nextAction = i5;
        this.$forceEvenIfNotEnabled = z4;
        this.$skipEndifIndexStack = stack;
        this.$resumeMacroInfo = resumeMacroInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ShellScriptAction shellScriptAction, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack stack, ResumeMacroInfo resumeMacroInfo) {
        boolean z5;
        Long macroGuid = shellScriptAction.getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Shell script timed out", macroGuid.longValue());
        z5 = shellScriptAction.blockNextAction;
        if (z5 && !z3) {
            shellScriptAction.getMacro().invokeActions(shellScriptAction.getMacro().getActions(), i4, triggerContextInfo, z4, stack, resumeMacroInfo);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShellScriptAction$invokeActionViaHelper$1(this.this$0, this.$requestId, this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i4;
        Object withTimeoutOrNull;
        coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 != 0) {
            if (i5 == 1) {
                ResultKt.throwOnFailure(obj);
                withTimeoutOrNull = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            i4 = this.this$0.timeoutSeconds;
            ShellScriptAction$invokeActionViaHelper$1$result$1 shellScriptAction$invokeActionViaHelper$1$result$1 = new ShellScriptAction$invokeActionViaHelper$1$result$1(this.this$0, this.$requestId, this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, null);
            this.label = 1;
            withTimeoutOrNull = TimeoutKt.withTimeoutOrNull((i4 + 2) * 1000, shellScriptAction$invokeActionViaHelper$1$result$1, this);
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((Unit) withTimeoutOrNull) == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            final ShellScriptAction shellScriptAction = this.this$0;
            final boolean z3 = this.$isTest;
            final int i6 = this.$nextAction;
            final TriggerContextInfo triggerContextInfo = this.$contextInfo;
            final boolean z4 = this.$forceEvenIfNotEnabled;
            final Stack<Integer> stack = this.$skipEndifIndexStack;
            final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
            handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.vn
                @Override // java.lang.Runnable
                public final void run() {
                    ShellScriptAction$invokeActionViaHelper$1.b(ShellScriptAction.this, z3, i6, triggerContextInfo, z4, stack, resumeMacroInfo);
                }
            });
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShellScriptAction$invokeActionViaHelper$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
