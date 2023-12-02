package com.araujo.jordan.excuseme.view.dialog;

import androidx.appcompat.app.AlertDialog;
import com.araujo.jordan.excuseme.view.InvisibleActivity;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.e;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExcuseMeDialog.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\"\u0010$J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0004R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/araujo/jordan/excuseme/view/dialog/ExcuseMeDialog;", "", "Lcom/araujo/jordan/excuseme/view/InvisibleActivity;", "act", "", "showDialogForPermission", "(Lcom/araujo/jordan/excuseme/view/InvisibleActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chanelAns", "", "a", "", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "b", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "setReason", "reason", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "channel", "Landroidx/appcompat/app/AlertDialog;", "Landroidx/appcompat/app/AlertDialog;", "()Landroidx/appcompat/app/AlertDialog;", "e", "(Landroidx/appcompat/app/AlertDialog;)V", "alertDialog", "Z", "getShowDialog", "()Z", "showDialog", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Z)V", "(Ljava/lang/String;Ljava/lang/String;)V", "excuseme_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class ExcuseMeDialog {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f1926a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f1927b;

    /* renamed from: c  reason: collision with root package name */
    private Channel<Boolean> f1928c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private AlertDialog f1929d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1930e;

    /* compiled from: ExcuseMeDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog$channelAns$1", f = "ExcuseMeDialog.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $chanelAns;
        Object L$0;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z3, Continuation continuation) {
            super(2, continuation);
            this.$chanelAns = z3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            a aVar = new a(this.$chanelAns, completion);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public final Object mo1invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = this.p$;
                Channel channel = ExcuseMeDialog.this.f1928c;
                if (channel != null) {
                    Boolean boxBoolean = Boxing.boxBoolean(this.$chanelAns);
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (channel.send(boxBoolean, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            AlertDialog b4 = ExcuseMeDialog.this.b();
            if (b4 != null) {
                b4.dismiss();
            }
            ExcuseMeDialog.this.e(null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExcuseMeDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {"Lcom/araujo/jordan/excuseme/view/InvisibleActivity;", "act", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "showDialogForPermission"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog", f = "ExcuseMeDialog.kt", i = {0, 0}, l = {55}, m = "showDialogForPermission$suspendImpl", n = {"this", "act"}, s = {"L$0", "L$1"})
    /* loaded from: classes2.dex */
    public static final class b extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExcuseMeDialog.f(ExcuseMeDialog.this, null, this);
        }
    }

    public ExcuseMeDialog(boolean z3) {
        this.f1930e = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object f(com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog r6, com.araujo.jordan.excuseme.view.InvisibleActivity r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog.b
            if (r0 == 0) goto L13
            r0 = r8
            com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog$b r0 = (com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog$b r0 = new com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 != r5) goto L33
            java.lang.Object r6 = r0.L$1
            com.araujo.jordan.excuseme.view.InvisibleActivity r6 = (com.araujo.jordan.excuseme.view.InvisibleActivity) r6
            java.lang.Object r6 = r0.L$0
            com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog r6 = (com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.Channel<java.lang.Boolean> r8 = r6.f1928c
            if (r8 != 0) goto L48
            kotlinx.coroutines.channels.Channel r8 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r4, r5, r3)
            r6.f1928c = r8
        L48:
            kotlinx.coroutines.channels.Channel<java.lang.Boolean> r8 = r6.f1928c
            if (r8 == 0) goto L61
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r8.receive(r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L61
            boolean r4 = r8.booleanValue()
        L61:
            r6.f1928c = r3
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog.f(com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog, com.araujo.jordan.excuseme.view.InvisibleActivity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z3) {
        e.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new a(z3, null), 3, null);
    }

    @Nullable
    protected final AlertDialog b() {
        return this.f1929d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String c() {
        return this.f1927b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String d() {
        return this.f1926a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(@Nullable AlertDialog alertDialog) {
        this.f1929d = alertDialog;
    }

    public final boolean getShowDialog() {
        return this.f1930e;
    }

    @Nullable
    public Object showDialogForPermission(@NotNull InvisibleActivity invisibleActivity, @NotNull Continuation<? super Boolean> continuation) {
        return f(this, invisibleActivity, continuation);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExcuseMeDialog(@NotNull String title, @NotNull String reason) {
        this(true);
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        this.f1926a = title;
        this.f1927b = reason;
    }
}
