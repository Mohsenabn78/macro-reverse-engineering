package com.araujo.jordan.excuseme;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.e;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AutoPermissionHandler.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\rR$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/araujo/jordan/excuseme/AutoPermissionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Landroidx/lifecycle/LifecycleObserver;", "", "trowable", "Lkotlinx/coroutines/Job;", "a", "Ljava/lang/Thread;", "thread", "", "uncaughtException", "onDestroy", "Landroid/app/Activity;", "Landroid/app/Activity;", "activity", "Lkotlin/Function1;", "", "b", "Lkotlin/jvm/functions/Function1;", "afterPermissionRequest", "Landroidx/lifecycle/Lifecycle;", "lifecycle", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;)V", "excuseme_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AutoPermissionHandler implements Thread.UncaughtExceptionHandler, LifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1913a;

    /* renamed from: b  reason: collision with root package name */
    private Function1<? super Boolean, Unit> f1914b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoPermissionHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.araujo.jordan.excuseme.AutoPermissionHandler$handlePermission$1", f = "AutoPermissionHandler.kt", i = {0, 0, 0}, l = {92}, m = "invokeSuspend", n = {"$this$launch", "permissions", TranslateLanguage.ITALIAN}, s = {"L$0", "L$1", "L$2"})
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Throwable $trowable;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Throwable th, Continuation continuation) {
            super(2, continuation);
            this.$trowable = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            a aVar = new a(this.$trowable, completion);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public final Object mo1invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
            r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r4, new java.lang.String[]{com.fasterxml.jackson.core.util.MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR}, false, 0, 6, (java.lang.Object) null);
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 235
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.araujo.jordan.excuseme.AutoPermissionHandler.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public AutoPermissionHandler(@Nullable Activity activity, @Nullable Lifecycle lifecycle, @Nullable Function1<? super Boolean, Unit> function1) {
        this.f1913a = activity;
        this.f1914b = function1;
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    private final Job a(Throwable th) {
        Job e4;
        e4 = e.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new a(th, null), 3, null);
        return e4;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f1913a = null;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        currentThread.setUncaughtExceptionHandler(null);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NotNull Thread thread, @NotNull Throwable trowable) {
        String message;
        boolean contains;
        Intrinsics.checkParameterIsNotNull(thread, "thread");
        Intrinsics.checkParameterIsNotNull(trowable, "trowable");
        if ((trowable instanceof SecurityException) && (message = trowable.getMessage()) != null) {
            contains = StringsKt__StringsKt.contains((CharSequence) message, (CharSequence) "Permission Denial", true);
            if (contains) {
                a(trowable);
                return;
            }
        }
        System.out.println((Object) trowable.getMessage());
        Activity activity = this.f1913a;
        if (activity != null) {
            activity.finish();
        }
    }

    public /* synthetic */ AutoPermissionHandler(Activity activity, Lifecycle lifecycle, Function1 function1, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : activity, lifecycle, function1);
    }
}
