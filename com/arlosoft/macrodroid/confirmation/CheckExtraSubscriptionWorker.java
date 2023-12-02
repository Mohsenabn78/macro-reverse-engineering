package com.arlosoft.macrodroid.confirmation;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckExtraSubscriptionWorker.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CheckExtraSubscriptionWorker extends Worker {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f10098a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final WorkerParameters f10099b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: CheckExtraSubscriptionWorker.kt */
    @SourceDebugExtension({"SMAP\nCheckExtraSubscriptionWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckExtraSubscriptionWorker.kt\ncom/arlosoft/macrodroid/confirmation/CheckExtraSubscriptionWorker$Companion\n+ 2 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequestKt\n*L\n1#1,146:1\n203#2:147\n*S KotlinDebug\n*F\n+ 1 CheckExtraSubscriptionWorker.kt\ncom/arlosoft/macrodroid/confirmation/CheckExtraSubscriptionWorker$Companion\n*L\n48#1:147\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void cancel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            workManager.cancelUniqueWork("schk");
        }

        @JvmStatic
        public final void scheduleSubscriptionCheck(@NotNull Context context, @NotNull String skuId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(skuId, "skuId");
            Data build = new Data.Builder().putString("skuId", skuId).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
            TimeUnit timeUnit = TimeUnit.MINUTES;
            SystemLog.logDebug("Scheduling StopClub subscription check for 1440 minutes");
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            workManager.enqueueUniquePeriodicWork("schk", ExistingPeriodicWorkPolicy.REPLACE, new PeriodicWorkRequest.Builder(CheckExtraSubscriptionWorker.class, 1440L, timeUnit).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 5L, timeUnit).setInitialDelay(5L, timeUnit).setInputData(build).build());
        }
    }

    /* compiled from: CheckExtraSubscriptionWorker.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $skuId;
        int label;
        final /* synthetic */ CheckExtraSubscriptionWorker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, CheckExtraSubscriptionWorker checkExtraSubscriptionWorker, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$skuId = str;
            this.this$0 = checkExtraSubscriptionWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$skuId, this.this$0, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0072 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0205  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 612
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CheckExtraSubscriptionWorker.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckExtraSubscriptionWorker.this.b(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckExtraSubscriptionWorker(@NotNull Context context, @NotNull WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f10098a = context;
        this.f10099b = params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str) {
        return "StopClub";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker.b
            if (r0 == 0) goto L13
            r0 = r9
            com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker$b r0 = (com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker$b r0 = new com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker$b
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r8 = r4.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r4.L$0
            com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker r0 = (com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L59
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.arlosoft.macrodroid.app.MacroDroidApplication$Companion r9 = com.arlosoft.macrodroid.app.MacroDroidApplication.Companion
            com.arlosoft.macrodroid.app.MacroDroidApplication r9 = r9.getInstance()
            com.arlosoft.macrodroid.extras.ui.management.ExtrasManager r1 = r9.getExtrasManager()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r7
            r4.L$1 = r8
            r4.label = r2
            r2 = r8
            java.lang.Object r9 = com.arlosoft.macrodroid.extras.ui.management.ExtrasManager.removeExtraPackage$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L58
            return r0
        L58:
            r0 = r7
        L59:
            android.content.Context r9 = r0.f10098a
            com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptions r9 = com.arlosoft.macrodroid.settings.Settings.getExtraSubscriptions(r9)
            if (r9 == 0) goto L6c
            java.util.Map r9 = r9.getMap()
            if (r9 == 0) goto L6c
            java.util.Map r9 = kotlin.collections.MapsKt.toMutableMap(r9)
            goto L6d
        L6c:
            r9 = 0
        L6d:
            if (r9 == 0) goto L75
            java.lang.Object r8 = r9.remove(r8)
            com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptionData r8 = (com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptionData) r8
        L75:
            android.content.Context r8 = r0.f10098a
            com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptions r0 = new com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptions
            if (r9 != 0) goto L7f
            java.util.Map r9 = kotlin.collections.MapsKt.emptyMap()
        L7f:
            r0.<init>(r9)
            com.arlosoft.macrodroid.settings.Settings.setExtraSubscriptions(r8, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @JvmStatic
    public static final void cancel(@NotNull Context context) {
        Companion.cancel(context);
    }

    @JvmStatic
    public static final void scheduleSubscriptionCheck(@NotNull Context context, @NotNull String str) {
        Companion.scheduleSubscriptionCheck(context, str);
    }

    @Override // androidx.work.Worker
    @NotNull
    public ListenableWorker.Result doWork() {
        SystemLog.logDebug("Performing StopClub subscription check");
        String string = this.f10099b.getInputData().getString("skuId");
        if (string != null) {
            e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(string, this, null), 2, null);
            ListenableWorker.Result success = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success, "success()");
            return success;
        }
        SystemLog.logDebug("skuId was null when trying to check subscription status");
        ListenableWorker.Result success2 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success2, "success()");
        return success2;
    }
}
