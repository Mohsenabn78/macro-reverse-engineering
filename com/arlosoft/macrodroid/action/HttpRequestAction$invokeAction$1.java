package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Stack;
import javax.net.ssl.SSLSession;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestAction.kt */
@SourceDebugExtension({"SMAP\nHttpRequestAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestAction.kt\ncom/arlosoft/macrodroid/action/HttpRequestAction$invokeAction$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,452:1\n2624#2,3:453\n*S KotlinDebug\n*F\n+ 1 HttpRequestAction.kt\ncom/arlosoft/macrodroid/action/HttpRequestAction$invokeAction$1\n*L\n215#1:453,3\n*E\n"})
/* loaded from: classes2.dex */
final class HttpRequestAction$invokeAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TriggerContextInfo $contextInfo;
    final /* synthetic */ boolean $forceEvenIfNotEnabled;
    final /* synthetic */ boolean $isTest;
    final /* synthetic */ int $nextAction;
    final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
    final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
    Object L$0;
    int label;
    final /* synthetic */ HttpRequestAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        int label;
        final /* synthetic */ HttpRequestAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(HttpRequestAction httpRequestAction, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super a> continuation) {
            super(2, continuation);
            this.this$0 = httpRequestAction;
            this.$isTest = z3;
            this.$nextAction = i4;
            this.$contextInfo = triggerContextInfo;
            this.$forceEvenIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.this$0, this.$isTest, this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            HttpRequestConfig httpRequestConfig;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                httpRequestConfig = this.this$0.requestConfig;
                if (httpRequestConfig.getBlockNextAction() && !this.$isTest) {
                    this.this$0.getMacro().invokeActions(this.this$0.getMacro().getActions(), this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestAction$invokeAction$1(HttpRequestAction httpRequestAction, TriggerContextInfo triggerContextInfo, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super HttpRequestAction$invokeAction$1> continuation) {
        super(2, continuation);
        this.this$0 = httpRequestAction;
        this.$contextInfo = triggerContextInfo;
        this.$isTest = z3;
        this.$nextAction = i4;
        this.$forceEvenIfNotEnabled = z4;
        this.$skipEndifIndexStack = stack;
        this.$resumeMacroInfo = resumeMacroInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, SSLSession sSLSession) {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HttpRequestAction$invokeAction$1(this.this$0, this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f7, code lost:
        if (r8 == null) goto L186;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0411 A[Catch: all -> 0x02c9, TryCatch #2 {all -> 0x02c9, blocks: (B:81:0x02f6, B:90:0x0309, B:92:0x0350, B:95:0x035f, B:116:0x0405, B:118:0x0411, B:120:0x041d, B:122:0x042d, B:124:0x0442, B:127:0x044c, B:126:0x0448, B:128:0x0468, B:96:0x0368, B:98:0x0375, B:100:0x0381, B:102:0x0391, B:104:0x0397, B:106:0x039d, B:108:0x03b2, B:111:0x03bc, B:114:0x03d2, B:110:0x03b8, B:115:0x03d9, B:91:0x032d, B:68:0x02c5), top: B:185:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0504 A[Catch: all -> 0x0608, TryCatch #1 {all -> 0x0608, blocks: (B:138:0x04ce, B:140:0x0504, B:142:0x0510, B:144:0x0520), top: B:183:0x04ce }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x056c A[Catch: all -> 0x0606, TryCatch #0 {all -> 0x0606, blocks: (B:146:0x052a, B:149:0x0560, B:151:0x056c, B:153:0x0578, B:155:0x0588, B:156:0x059d, B:147:0x0531), top: B:182:0x0502 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0602 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0309 A[Catch: all -> 0x02c9, TRY_ENTER, TryCatch #2 {all -> 0x02c9, blocks: (B:81:0x02f6, B:90:0x0309, B:92:0x0350, B:95:0x035f, B:116:0x0405, B:118:0x0411, B:120:0x041d, B:122:0x042d, B:124:0x0442, B:127:0x044c, B:126:0x0448, B:128:0x0468, B:96:0x0368, B:98:0x0375, B:100:0x0381, B:102:0x0391, B:104:0x0397, B:106:0x039d, B:108:0x03b2, B:111:0x03bc, B:114:0x03d2, B:110:0x03b8, B:115:0x03d9, B:91:0x032d, B:68:0x02c5), top: B:185:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x032d A[Catch: all -> 0x02c9, TryCatch #2 {all -> 0x02c9, blocks: (B:81:0x02f6, B:90:0x0309, B:92:0x0350, B:95:0x035f, B:116:0x0405, B:118:0x0411, B:120:0x041d, B:122:0x042d, B:124:0x0442, B:127:0x044c, B:126:0x0448, B:128:0x0468, B:96:0x0368, B:98:0x0375, B:100:0x0381, B:102:0x0391, B:104:0x0397, B:106:0x039d, B:108:0x03b2, B:111:0x03bc, B:114:0x03d2, B:110:0x03b8, B:115:0x03d9, B:91:0x032d, B:68:0x02c5), top: B:185:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x035f A[Catch: all -> 0x02c9, TRY_ENTER, TryCatch #2 {all -> 0x02c9, blocks: (B:81:0x02f6, B:90:0x0309, B:92:0x0350, B:95:0x035f, B:116:0x0405, B:118:0x0411, B:120:0x041d, B:122:0x042d, B:124:0x0442, B:127:0x044c, B:126:0x0448, B:128:0x0468, B:96:0x0368, B:98:0x0375, B:100:0x0381, B:102:0x0391, B:104:0x0397, B:106:0x039d, B:108:0x03b2, B:111:0x03bc, B:114:0x03d2, B:110:0x03b8, B:115:0x03d9, B:91:0x032d, B:68:0x02c5), top: B:185:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0368 A[Catch: all -> 0x02c9, TryCatch #2 {all -> 0x02c9, blocks: (B:81:0x02f6, B:90:0x0309, B:92:0x0350, B:95:0x035f, B:116:0x0405, B:118:0x0411, B:120:0x041d, B:122:0x042d, B:124:0x0442, B:127:0x044c, B:126:0x0448, B:128:0x0468, B:96:0x0368, B:98:0x0375, B:100:0x0381, B:102:0x0391, B:104:0x0397, B:106:0x039d, B:108:0x03b2, B:111:0x03bc, B:114:0x03d2, B:110:0x03b8, B:115:0x03d9, B:91:0x032d, B:68:0x02c5), top: B:185:0x02c5 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 1642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.HttpRequestAction$invokeAction$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HttpRequestAction$invokeAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
