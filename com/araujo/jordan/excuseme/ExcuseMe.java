package com.araujo.jordan.excuseme;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.araujo.jordan.excuseme.model.PermissionStatus;
import com.araujo.jordan.excuseme.view.dialog.DialogType;
import com.araujo.jordan.excuseme.view.dialog.PosPermissionDialog;
import com.araujo.jordan.excuseme.view.dialog.PrePermissionDialog;
import com.arlosoft.macrodroid.permissions.PermissionRequestActivity;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.e;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExcuseMe.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Lcom/araujo/jordan/excuseme/ExcuseMe;", "", "()V", "Companion", "excuseme_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ExcuseMe {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<Context> f1915a;

    /* renamed from: c  reason: collision with root package name */
    private static Channel<Boolean> f1917c;
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static PermissionStatus f1916b = new PermissionStatus(null, null, 3, null);

    /* renamed from: d  reason: collision with root package name */
    private static PrePermissionDialog f1918d = new PrePermissionDialog();

    /* renamed from: e  reason: collision with root package name */
    private static PosPermissionDialog f1919e = new PosPermissionDialog();

    /* compiled from: ExcuseMe.kt */
    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u0010AJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fJ)\u0010\u0015\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u000bJD\u0010#\u001a\u00020\"2\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u00132!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b#\u0010$J\u0016\u0010'\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013J&\u0010'\u001a\u00020\u00002\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0004\u0012\u00020\u000b0\tJ&\u0010-\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0013J;\u0010-\u001a\u00020\u000023\u00101\u001a/\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(0\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0004\u0012\u00020\u000b0.J'\u0010#\u001a\u00020\u000f2\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0004\b#\u00102J\u001b\u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0004\b#\u00103J'\u00104\u001a\u00020\u000f2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H\u0082@ø\u0001\u0000¢\u0006\u0004\b4\u00102R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00108R\u0016\u00109\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/araujo/jordan/excuseme/ExcuseMe$Companion;", "", "Landroid/app/Activity;", "activity", "couldYouGive", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "", "afterPermissionRequest", "couldYouHandlePermissionsForMe", "afterPermissionsRequest", "Lcom/araujo/jordan/excuseme/model/PermissionStatus;", "permissionResult", "onPermissionResult", "", "", "permissions", "doWeHavePermissionFor", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Lcom/araujo/jordan/excuseme/view/dialog/PrePermissionDialog;", "getPreDialog", "clearPreDialog", "Lcom/araujo/jordan/excuseme/view/dialog/PosPermissionDialog;", "getPosDialog", "clearPosDialog", PermissionRequestActivity.EXTRA_PERMISSION, "Lkotlin/ParameterName;", "name", "permissionStatus", "completion", "Lkotlinx/coroutines/Job;", "permissionFor", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "title", "explanation", "gently", "customGentlyRequest", "explainAgainTitle", "explainAgainExplanation", "showSettingsTitle", "showSettingsExplanation", "please", "Lkotlin/Function2;", "Lcom/araujo/jordan/excuseme/view/dialog/DialogType;", "type", "customDialogRequest", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/araujo/jordan/excuseme/model/PermissionStatus;", "posDialog", "Lcom/araujo/jordan/excuseme/view/dialog/PosPermissionDialog;", "preDialog", "Lcom/araujo/jordan/excuseme/view/dialog/PrePermissionDialog;", "Ljava/lang/ref/WeakReference;", "weakContext", "Ljava/lang/ref/WeakReference;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "excuseme_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExcuseMe.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
        @DebugMetadata(c = "com.araujo.jordan.excuseme.ExcuseMe$Companion$onPermissionResult$1", f = "ExcuseMe.kt", i = {0}, l = {131}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            int label;
            private CoroutineScope p$;

            a(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                Intrinsics.checkParameterIsNotNull(completion, "completion");
                a aVar = new a(completion);
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
                    Channel channel = ExcuseMe.f1917c;
                    if (channel != null) {
                        Boolean boxBoolean = Boxing.boxBoolean(true);
                        this.L$0 = coroutineScope2;
                        this.label = 1;
                        if (channel.send(boxBoolean, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                WeakReference weakReference = ExcuseMe.f1915a;
                if (weakReference != null) {
                    weakReference.clear();
                }
                ExcuseMe.f1915a = null;
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExcuseMe.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
        @DebugMetadata(c = "com.araujo.jordan.excuseme.ExcuseMe$Companion$permissionFor$1", f = "ExcuseMe.kt", i = {0}, l = {190}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
        /* loaded from: classes2.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1 $completion;
            final /* synthetic */ String[] $permission;
            Object L$0;
            int label;
            private CoroutineScope p$;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String[] strArr, Function1 function1, Continuation continuation) {
                super(2, continuation);
                this.$permission = strArr;
                this.$completion = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                Intrinsics.checkParameterIsNotNull(completion, "completion");
                b bVar = new b(this.$permission, this.$completion, completion);
                bVar.p$ = (CoroutineScope) obj;
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo1invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    Companion companion = ExcuseMe.Companion;
                    String[] strArr = this.$permission;
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    obj = companion.a((String[]) Arrays.copyOf(strArr, strArr.length), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.$completion.invoke((PermissionStatus) obj);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExcuseMe.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, d2 = {"", PermissionRequestActivity.EXTRA_PERMISSION, "Lkotlin/coroutines/Continuation;", "", "continuation", "", "permissionFor"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "com.araujo.jordan.excuseme.ExcuseMe$Companion", f = "ExcuseMe.kt", i = {0, 0}, l = {305}, m = "permissionFor", n = {"this", PermissionRequestActivity.EXTRA_PERMISSION}, s = {"L$0", "L$1"})
        /* loaded from: classes2.dex */
        public static final class c extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            c(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return Companion.this.permissionFor((String) null, this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExcuseMe.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000\"\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@"}, d2 = {"", "", "permissions", "Lkotlin/coroutines/Continuation;", "Lcom/araujo/jordan/excuseme/model/PermissionStatus;", "continuation", "", "runPermissionRequest"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "com.araujo.jordan.excuseme.ExcuseMe$Companion", f = "ExcuseMe.kt", i = {0, 0, 0, 0}, l = {328}, m = "runPermissionRequest", n = {"this", "permissions", "context", "deniedPerm"}, s = {"L$0", "L$1", "L$2", "L$3"})
        /* loaded from: classes2.dex */
        public static final class d extends ContinuationImpl {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;

            d(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return Companion.this.a(null, this);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final /* synthetic */ java.lang.Object a(@org.jetbrains.annotations.NotNull java.lang.String[] r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.araujo.jordan.excuseme.model.PermissionStatus> r13) {
            /*
                Method dump skipped, instructions count: 260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.araujo.jordan.excuseme.ExcuseMe.Companion.a(java.lang.String[], kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void clearPosDialog() {
            ExcuseMe.f1919e = new PosPermissionDialog();
        }

        public final void clearPreDialog() {
            ExcuseMe.f1918d = new PrePermissionDialog();
        }

        @NotNull
        public final Companion couldYouGive(@NotNull Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            ExcuseMe.f1915a = new WeakReference(activity);
            return this;
        }

        public final void couldYouHandlePermissionsForMe(@NotNull Activity activity, @NotNull Function1<? super Boolean, Unit> afterPermissionRequest) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(afterPermissionRequest, "afterPermissionRequest");
            try {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                AppCompatActivity appCompatActivity = (AppCompatActivity) (!(activity instanceof AppCompatActivity) ? null : activity);
                currentThread.setUncaughtExceptionHandler(new AutoPermissionHandler(activity, appCompatActivity != null ? appCompatActivity.getLifecycle() : null, afterPermissionRequest));
            } catch (Exception e4) {
                System.out.println((Object) ("Can't do it automatically: " + e4.getMessage()));
            }
        }

        public final boolean doWeHavePermissionFor(@NotNull Context context, @NotNull String... permissions) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(permissions, "permissions");
            for (String str : permissions) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return false;
                }
            }
            return true;
        }

        @NotNull
        public final Companion gently(@NotNull String title, @NotNull String explanation) {
            Intrinsics.checkParameterIsNotNull(title, "title");
            Intrinsics.checkParameterIsNotNull(explanation, "explanation");
            ExcuseMe.f1918d = new PrePermissionDialog(title, explanation);
            return this;
        }

        @NotNull
        public final PosPermissionDialog getPosDialog() {
            return ExcuseMe.f1919e;
        }

        @NotNull
        public final PrePermissionDialog getPreDialog() {
            return ExcuseMe.f1918d;
        }

        public final void onPermissionResult(@NotNull PermissionStatus permissionResult) {
            Intrinsics.checkParameterIsNotNull(permissionResult, "permissionResult");
            ExcuseMe.f1916b = permissionResult;
            e.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new a(null), 3, null);
        }

        @NotNull
        public final Job permissionFor(@NotNull String[] permission, @NotNull Function1<? super PermissionStatus, Unit> completion) {
            Job e4;
            Intrinsics.checkParameterIsNotNull(permission, "permission");
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            e4 = e.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new b(permission, completion, null), 3, null);
            return e4;
        }

        @NotNull
        public final Companion please(@NotNull String explainAgainTitle, @NotNull String explainAgainExplanation, @NotNull String showSettingsTitle, @NotNull String showSettingsExplanation) {
            Intrinsics.checkParameterIsNotNull(explainAgainTitle, "explainAgainTitle");
            Intrinsics.checkParameterIsNotNull(explainAgainExplanation, "explainAgainExplanation");
            Intrinsics.checkParameterIsNotNull(showSettingsTitle, "showSettingsTitle");
            Intrinsics.checkParameterIsNotNull(showSettingsExplanation, "showSettingsExplanation");
            ExcuseMe.f1919e = new PosPermissionDialog(explainAgainTitle, explainAgainExplanation, showSettingsTitle, showSettingsExplanation);
            return this;
        }

        @NotNull
        public final Companion couldYouGive(@NotNull Fragment fragment) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            ExcuseMe.f1915a = new WeakReference(fragment.requireActivity());
            return this;
        }

        @NotNull
        public final Companion gently(@NotNull Function1<? super Function1<? super Boolean, Unit>, Unit> customGentlyRequest) {
            Intrinsics.checkParameterIsNotNull(customGentlyRequest, "customGentlyRequest");
            ExcuseMe.f1918d = new PrePermissionDialog(customGentlyRequest);
            return this;
        }

        @Nullable
        public final Object permissionFor(@NotNull String[] strArr, @NotNull Continuation<? super PermissionStatus> continuation) {
            return a((String[]) Arrays.copyOf(strArr, strArr.length), continuation);
        }

        @NotNull
        public final Companion please(@NotNull Function2<? super DialogType, ? super Function1<? super Boolean, Unit>, Unit> customDialogRequest) {
            Intrinsics.checkParameterIsNotNull(customDialogRequest, "customDialogRequest");
            ExcuseMe.f1919e = new PosPermissionDialog(customDialogRequest);
            return this;
        }

        @NotNull
        public final Companion couldYouGive(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            ExcuseMe.f1915a = new WeakReference(context);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object permissionFor(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.araujo.jordan.excuseme.ExcuseMe.Companion.c
                if (r0 == 0) goto L13
                r0 = r6
                com.araujo.jordan.excuseme.ExcuseMe$Companion$c r0 = (com.araujo.jordan.excuseme.ExcuseMe.Companion.c) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.araujo.jordan.excuseme.ExcuseMe$Companion$c r0 = new com.araujo.jordan.excuseme.ExcuseMe$Companion$c
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r5 = r0.L$1
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r0 = r0.L$0
                com.araujo.jordan.excuseme.ExcuseMe$Companion r0 = (com.araujo.jordan.excuseme.ExcuseMe.Companion) r0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L4e
            L31:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L39:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.String[] r6 = new java.lang.String[r3]
                r2 = 0
                r6[r2] = r5
                r0.L$0 = r4
                r0.L$1 = r5
                r0.label = r3
                java.lang.Object r6 = r4.a(r6, r0)
                if (r6 != r1) goto L4e
                return r1
            L4e:
                com.araujo.jordan.excuseme.model.PermissionStatus r6 = (com.araujo.jordan.excuseme.model.PermissionStatus) r6
                java.util.List r6 = r6.getGranted()
                boolean r5 = r6.contains(r5)
                java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.araujo.jordan.excuseme.ExcuseMe.Companion.permissionFor(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void couldYouHandlePermissionsForMe(@NotNull Fragment fragment, @NotNull Function1<? super Boolean, Unit> afterPermissionsRequest) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            Intrinsics.checkParameterIsNotNull(afterPermissionsRequest, "afterPermissionsRequest");
            try {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                currentThread.setUncaughtExceptionHandler(new AutoPermissionHandler(fragment.requireActivity(), fragment.getLifecycle(), afterPermissionsRequest));
            } catch (Exception e4) {
                System.out.println((Object) ("Can't do it automatically: " + e4.getMessage()));
            }
        }
    }
}
