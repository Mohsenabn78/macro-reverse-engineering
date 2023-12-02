package com.arlosoft.macrodroid.action;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1;
import com.arlosoft.macrodroid.action.UiInteractionConfiguration;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.uiinteraction.UIInteractionResult;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UIInteractionAction.kt */
@SourceDebugExtension({"SMAP\nUIInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$runAction$1$result$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,2410:1\n20#2:2411\n22#2:2415\n50#3:2412\n55#3:2414\n106#4:2413\n*S KotlinDebug\n*F\n+ 1 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$runAction$1$result$1\n*L\n499#1:2411\n499#1:2415\n499#1:2412\n499#1:2414\n499#1:2413\n*E\n"})
/* loaded from: classes2.dex */
public final class UIInteractionAction$runAction$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UiInteractionConfiguration.Click $config;
    final /* synthetic */ TriggerContextInfo $contextInfo;
    final /* synthetic */ int $expectedId;
    final /* synthetic */ Function0<Unit> $invokeOtherActions;
    final /* synthetic */ boolean $isTest;
    int label;
    final /* synthetic */ UIInteractionAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class a implements FlowCollector<UIInteractionResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UiInteractionConfiguration.Click f2729a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UIInteractionAction f2730b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TriggerContextInfo f2731c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f2732d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f2733e;

        a(UiInteractionConfiguration.Click click, UIInteractionAction uIInteractionAction, TriggerContextInfo triggerContextInfo, boolean z3, Function0<Unit> function0) {
            this.f2729a = click;
            this.f2730b = uIInteractionAction;
            this.f2731c = triggerContextInfo;
            this.f2732d = z3;
            this.f2733e = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(boolean z3, Function0 invokeOtherActions) {
            Intrinsics.checkNotNullParameter(invokeOtherActions, "$invokeOtherActions");
            if (!z3) {
                invokeOtherActions.invoke();
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: b */
        public final Object emit(@NotNull UIInteractionResult uIInteractionResult, @NotNull Continuation<? super Unit> continuation) {
            MacroDroidVariable variableByName;
            if (this.f2729a.getBlocking() && this.f2729a.getReturnVariable() != null && (variableByName = this.f2730b.getVariableByName(this.f2729a.getReturnVariable().getVariableName())) != null) {
                Context context = this.f2730b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.f2730b.variableUpdate(variableByName, new VariableValue.BooleanValue(uIInteractionResult.getResult(), VariableHelper.applyMagicTextToDictionaryKeys(context, this.f2729a.getReturnVariable().getKeys().getKeys(), this.f2731c, this.f2730b.getMacro())));
            }
            Long macroGuid = this.f2730b.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logVerbose("UI Interaction click returned: " + uIInteractionResult, macroGuid.longValue());
            if (this.f2729a.getBlocking()) {
                Handler handler = new Handler(Looper.getMainLooper());
                final boolean z3 = this.f2732d;
                final Function0<Unit> function0 = this.f2733e;
                handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.st
                    @Override // java.lang.Runnable
                    public final void run() {
                        UIInteractionAction$runAction$1$result$1.a.c(z3, function0);
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIInteractionAction$runAction$1$result$1(UIInteractionAction uIInteractionAction, int i4, UiInteractionConfiguration.Click click, TriggerContextInfo triggerContextInfo, boolean z3, Function0<Unit> function0, Continuation<? super UIInteractionAction$runAction$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = uIInteractionAction;
        this.$expectedId = i4;
        this.$config = click;
        this.$contextInfo = triggerContextInfo;
        this.$isTest = z3;
        this.$invokeOtherActions = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UIInteractionAction$runAction$1$result$1(this.this$0, this.$expectedId, this.$config, this.$contextInfo, this.$isTest, this.$invokeOtherActions, continuation);
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
            final SharedFlow<UIInteractionResult> resultDataFlow = this.this$0.getUiInteractionResultCache().getResultDataFlow();
            final int i5 = this.$expectedId;
            Flow take = FlowKt.take(new Flow<UIInteractionResult>() { // from class: com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 UIInteractionAction.kt\ncom/arlosoft/macrodroid/action/UIInteractionAction$runAction$1$result$1\n*L\n1#1,222:1\n21#2:223\n22#2:225\n499#3:224\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f2724a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ int f2725b;

                    /* compiled from: Emitters.kt */
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                    /* renamed from: com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, int i4) {
                        this.f2724a = flowCollector;
                        this.f2725b = i4;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L4f
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            kotlin.ResultKt.throwOnFailure(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.f2724a
                            r2 = r6
                            com.arlosoft.macrodroid.uiinteraction.UIInteractionResult r2 = (com.arlosoft.macrodroid.uiinteraction.UIInteractionResult) r2
                            int r2 = r2.getRequestId()
                            int r4 = r5.f2725b
                            if (r2 != r4) goto L43
                            r2 = 1
                            goto L44
                        L43:
                            r2 = 0
                        L44:
                            if (r2 == 0) goto L4f
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r6, r0)
                            if (r6 != r1) goto L4f
                            return r1
                        L4f:
                            kotlin.Unit r6 = kotlin.Unit.INSTANCE
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.UIInteractionAction$runAction$1$result$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super UIInteractionResult> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, i5), continuation);
                    coroutine_suspended2 = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            }, 1);
            a aVar = new a(this.$config, this.this$0, this.$contextInfo, this.$isTest, this.$invokeOtherActions);
            this.label = 1;
            if (take.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UIInteractionAction$runAction$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
