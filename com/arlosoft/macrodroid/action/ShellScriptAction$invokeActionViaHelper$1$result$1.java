package com.arlosoft.macrodroid.action;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.helper.data.HelperResult;
import com.arlosoft.macrodroid.helper.data.ShellScriptResult;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.List;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShellScriptAction.kt */
@SourceDebugExtension({"SMAP\nShellScriptAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShellScriptAction.kt\ncom/arlosoft/macrodroid/action/ShellScriptAction$invokeActionViaHelper$1$result$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,564:1\n20#2:565\n22#2:569\n50#3:566\n55#3:568\n106#4:567\n*S KotlinDebug\n*F\n+ 1 ShellScriptAction.kt\ncom/arlosoft/macrodroid/action/ShellScriptAction$invokeActionViaHelper$1$result$1\n*L\n229#1:565\n229#1:569\n229#1:566\n229#1:568\n229#1:567\n*E\n"})
/* loaded from: classes2.dex */
final class ShellScriptAction$invokeActionViaHelper$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
    /* compiled from: ShellScriptAction.kt */
    /* loaded from: classes2.dex */
    public static final class a implements FlowCollector<HelperResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShellScriptAction f2597a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TriggerContextInfo f2598b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2599c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2600d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f2601e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Stack<Integer> f2602f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ResumeMacroInfo f2603g;

        a(ShellScriptAction shellScriptAction, TriggerContextInfo triggerContextInfo, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
            this.f2597a = shellScriptAction;
            this.f2598b = triggerContextInfo;
            this.f2599c = z3;
            this.f2600d = i4;
            this.f2601e = z4;
            this.f2602f = stack;
            this.f2603g = resumeMacroInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ShellScriptAction this$0, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack skipEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
            boolean z5;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
            z5 = this$0.blockNextAction;
            if (z5 && !z3) {
                this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z4, skipEndifIndexStack, resumeMacroInfo);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: b */
        public final Object emit(@NotNull HelperResult helperResult, @NotNull Continuation<? super Unit> continuation) {
            MacroDroidVariable macroDroidVariable;
            MacroDroidVariable macroDroidVariable2;
            MacroDroidVariable macroDroidVariable3;
            DictionaryKeys dictionaryKeys;
            List<String> emptyList;
            Intrinsics.checkNotNull(helperResult, "null cannot be cast to non-null type com.arlosoft.macrodroid.helper.data.ShellScriptResult");
            ShellScriptResult shellScriptResult = (ShellScriptResult) helperResult;
            if (!shellScriptResult.getDidTimeout()) {
                macroDroidVariable = this.f2597a.m_variableToSaveResponse;
                if (macroDroidVariable != null) {
                    ShellScriptAction shellScriptAction = this.f2597a;
                    macroDroidVariable2 = shellScriptAction.m_variableToSaveResponse;
                    Intrinsics.checkNotNull(macroDroidVariable2);
                    MacroDroidVariable variableByName = shellScriptAction.getVariableByName(macroDroidVariable2.getName());
                    if (variableByName == null) {
                        macroDroidVariable3 = this.f2597a.m_variableToSaveResponse;
                        Intrinsics.checkNotNull(macroDroidVariable3);
                        Long macroGuid = this.f2597a.getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                        SystemLog.logError("Failed to save command line output to variable: " + macroDroidVariable3.getName() + " not found", macroGuid.longValue());
                    } else {
                        Context context = this.f2597a.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        dictionaryKeys = this.f2597a.varDictionaryKeys;
                        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                        }
                        this.f2597a.variableUpdate(variableByName, new VariableValue.StringValue(shellScriptResult.getResultString(), VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, this.f2598b, this.f2597a.getMacro())));
                    }
                }
            } else {
                Long macroGuid2 = this.f2597a.getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                SystemLog.logError("Shell script timed out", macroGuid2.longValue());
            }
            Handler handler = new Handler(Looper.getMainLooper());
            final ShellScriptAction shellScriptAction2 = this.f2597a;
            final boolean z3 = this.f2599c;
            final int i4 = this.f2600d;
            final TriggerContextInfo triggerContextInfo = this.f2598b;
            final boolean z4 = this.f2601e;
            final Stack<Integer> stack = this.f2602f;
            final ResumeMacroInfo resumeMacroInfo = this.f2603g;
            handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.wn
                @Override // java.lang.Runnable
                public final void run() {
                    ShellScriptAction$invokeActionViaHelper$1$result$1.a.c(ShellScriptAction.this, z3, i4, triggerContextInfo, z4, stack, resumeMacroInfo);
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShellScriptAction$invokeActionViaHelper$1$result$1(ShellScriptAction shellScriptAction, int i4, TriggerContextInfo triggerContextInfo, boolean z3, int i5, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super ShellScriptAction$invokeActionViaHelper$1$result$1> continuation) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShellScriptAction$invokeActionViaHelper$1$result$1(this.this$0, this.$requestId, this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
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
            final Flow<HelperResult> resultsFlow = this.this$0.getHelperResultHandler().getResultsFlow();
            final int i5 = this.$requestId;
            Flow take = FlowKt.take(new Flow<HelperResult>() { // from class: com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ShellScriptAction.kt\ncom/arlosoft/macrodroid/action/ShellScriptAction$invokeActionViaHelper$1$result$1\n*L\n1#1,222:1\n21#2:223\n22#2:225\n229#3:224\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f2582a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ int f2583b;

                    /* compiled from: Emitters.kt */
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                    /* renamed from: com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
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
                        this.f2582a = flowCollector;
                        this.f2583b = i4;
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
                            boolean r0 = r7 instanceof com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1$2$1
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
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.f2582a
                            r2 = r6
                            com.arlosoft.macrodroid.helper.data.HelperResult r2 = (com.arlosoft.macrodroid.helper.data.HelperResult) r2
                            int r2 = r2.getId()
                            int r4 = r5.f2583b
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
                        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ShellScriptAction$invokeActionViaHelper$1$result$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super HelperResult> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, i5), continuation);
                    coroutine_suspended2 = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            }, 1);
            a aVar = new a(this.this$0, this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
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
        return ((ShellScriptAction$invokeActionViaHelper$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
