package com.arlosoft.macrodroid.triggers.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: QueryUiService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class QueryUiService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15523a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15524b;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: QueryUiService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueryUiService.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
            if (r4 >= 2000) goto L32;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0085 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0086  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0083 -> B:11:0x0020). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L1c
            Lf:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L17:
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r8
                goto L49
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r8
            L20:
                com.arlosoft.macrodroid.triggers.services.QueryUiService r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.this
                boolean r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.access$isActive$p(r1)
                if (r1 == 0) goto L86
                com.arlosoft.macrodroid.triggers.services.QueryUiService r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.this
                boolean r1 = com.arlosoft.macrodroid.settings.Settings.getPreventScreenContentWhenMDForeground(r1)
                if (r1 == 0) goto L3c
                com.arlosoft.macrodroid.app.MacroDroidApplication$Companion r1 = com.arlosoft.macrodroid.app.MacroDroidApplication.Companion
                com.arlosoft.macrodroid.app.MacroDroidApplication r1 = r1.getInstance()
                boolean r1 = r1.isForeground()
                if (r1 != 0) goto L49
            L3c:
                com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$Companion r1 = com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.Companion
                com.arlosoft.macrodroid.triggers.services.QueryUiService r4 = com.arlosoft.macrodroid.triggers.services.QueryUiService.this
                r9.label = r3
                java.lang.Object r1 = r1.checkUiQuery(r4, r9)
                if (r1 != r0) goto L49
                return r0
            L49:
                com.arlosoft.macrodroid.triggers.services.QueryUiService r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.this
                int r1 = com.arlosoft.macrodroid.settings.Settings.getReadScreenContentsUpdateRateMs(r1)
                long r4 = (long) r1
                com.arlosoft.macrodroid.triggers.services.QueryUiService r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.this
                com.arlosoft.macrodroid.confirmation.PremiumStatusHandler r1 = r1.getPremiumStatusHandler()
                com.arlosoft.macrodroid.confirmation.PremiumStatus r1 = r1.getPremiumStatus()
                boolean r1 = r1.isPro()
                if (r1 != 0) goto L66
                r6 = 2000(0x7d0, double:9.88E-321)
                int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r1 < 0) goto L67
            L66:
                r6 = r4
            L67:
                com.arlosoft.macrodroid.triggers.services.QueryUiService r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.this
                boolean r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.access$getHasShowTimeWarning$p(r1)
                if (r1 != 0) goto L7d
                int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r1 <= 0) goto L7d
                java.lang.String r1 = "Screen Content trigger requires pro version for lower than 2 second update rate. (Forcing update rate to 2 seconds)"
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logWarning(r1)
                com.arlosoft.macrodroid.triggers.services.QueryUiService r1 = com.arlosoft.macrodroid.triggers.services.QueryUiService.this
                com.arlosoft.macrodroid.triggers.services.QueryUiService.access$setHasShowTimeWarning$p(r1, r3)
            L7d:
                r9.label = r2
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r6, r9)
                if (r1 != r0) goto L20
                return r0
            L86:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.QueryUiService.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public QueryUiService() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    private final void a() {
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new a(null), 3, null);
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f15524b = true;
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f15524b = false;
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        return 1;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }
}
