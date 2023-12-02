package com.arlosoft.macrodroid.action;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.arlosoft.macrodroid.action.UiInteractionConfiguration;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIInteractionAction.kt */
/* loaded from: classes2.dex */
final class UIInteractionAction$runAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UiInteractionConfiguration.Click $config;
    final /* synthetic */ TriggerContextInfo $contextInfo;
    final /* synthetic */ int $expectedId;
    final /* synthetic */ Function0<Unit> $invokeOtherActions;
    final /* synthetic */ boolean $isTest;
    int label;
    final /* synthetic */ UIInteractionAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIInteractionAction$runAction$1(UiInteractionConfiguration.Click click, UIInteractionAction uIInteractionAction, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Function0<Unit> function0, Continuation<? super UIInteractionAction$runAction$1> continuation) {
        super(2, continuation);
        this.$config = click;
        this.this$0 = uIInteractionAction;
        this.$expectedId = i4;
        this.$contextInfo = triggerContextInfo;
        this.$isTest = z3;
        this.$invokeOtherActions = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UiInteractionConfiguration.Click click, UIInteractionAction uIInteractionAction, TriggerContextInfo triggerContextInfo, boolean z3, Function0 function0) {
        MacroDroidVariable variableByName;
        if (click.getReturnVariable() != null && (variableByName = uIInteractionAction.getVariableByName(click.getReturnVariable().getVariableName())) != null) {
            Context context = uIInteractionAction.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            uIInteractionAction.variableUpdate(variableByName, new VariableValue.BooleanValue(false, VariableHelper.applyMagicTextToDictionaryKeys(context, click.getReturnVariable().getKeys().getKeys(), triggerContextInfo, uIInteractionAction.getMacro())));
        }
        Long macroGuid = uIInteractionAction.getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("UI Interaction click timed out", macroGuid.longValue());
        if (!z3) {
            function0.invoke();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UIInteractionAction$runAction$1(this.$config, this.this$0, this.$expectedId, this.$contextInfo, this.$isTest, this.$invokeOtherActions, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 != 0) {
            if (i4 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            UIInteractionAction$runAction$1$result$1 uIInteractionAction$runAction$1$result$1 = new UIInteractionAction$runAction$1$result$1(this.this$0, this.$expectedId, this.$config, this.$contextInfo, this.$isTest, this.$invokeOtherActions, null);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(1500L, uIInteractionAction$runAction$1$result$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((Unit) obj) == null && this.$config.getBlocking()) {
            Handler handler = new Handler(Looper.getMainLooper());
            final UiInteractionConfiguration.Click click = this.$config;
            final UIInteractionAction uIInteractionAction = this.this$0;
            final TriggerContextInfo triggerContextInfo = this.$contextInfo;
            final boolean z3 = this.$isTest;
            final Function0<Unit> function0 = this.$invokeOtherActions;
            handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.rt
                @Override // java.lang.Runnable
                public final void run() {
                    UIInteractionAction$runAction$1.b(UiInteractionConfiguration.Click.this, uIInteractionAction, triggerContextInfo, z3, function0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UIInteractionAction$runAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
