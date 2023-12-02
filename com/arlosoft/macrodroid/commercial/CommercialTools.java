package com.arlosoft.macrodroid.commercial;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.commercial.api.CommercialApi;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CommercialTools.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CommercialTools {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f9819a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CommercialApi f9820b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommercialTools.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommercialTools.this.registerCommercial(this);
        }
    }

    @Inject
    public CommercialTools(@ApplicationContext @NotNull Context context, @NotNull CommercialApi commercialApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(commercialApi, "commercialApi");
        this.f9819a = context;
        this.f9820b = commercialApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object registerCommercial(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.arlosoft.macrodroid.commercial.CommercialTools.a
            if (r0 == 0) goto L13
            r0 = r7
            com.arlosoft.macrodroid.commercial.CommercialTools$a r0 = (com.arlosoft.macrodroid.commercial.CommercialTools.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.commercial.CommercialTools$a r0 = new com.arlosoft.macrodroid.commercial.CommercialTools$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            com.arlosoft.macrodroid.commercial.CommercialTools r0 = (com.arlosoft.macrodroid.commercial.CommercialTools) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L2d
            goto L70
        L2d:
            r7 = move-exception
            goto L7e
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = com.arlosoft.macrodroid.settings.Defaults.REGISTER_COMMERCIAL_DEVICE_COMPANY_ID
            if (r7 != 0) goto L41
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L41:
            android.content.Context r2 = r6.f9819a
            boolean r2 = com.arlosoft.macrodroid.settings.Settings.getHasRegisteredCommercially(r2)
            if (r2 == 0) goto L4c
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L4c:
            android.content.Context r2 = r6.f9819a     // Catch: java.lang.Exception -> L7c
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Exception -> L7c
            java.lang.String r4 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r4)     // Catch: java.lang.Exception -> L7c
            com.arlosoft.macrodroid.commercial.api.CommercialApi r4 = r6.f9820b     // Catch: java.lang.Exception -> L7c
            java.lang.String r5 = "REGISTER_COMMERCIAL_DEVICE_COMPANY_ID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)     // Catch: java.lang.Exception -> L7c
            java.lang.String r5 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch: java.lang.Exception -> L7c
            r0.L$0 = r6     // Catch: java.lang.Exception -> L7c
            r0.label = r3     // Catch: java.lang.Exception -> L7c
            java.lang.Object r7 = r4.registerDevice(r7, r2, r0)     // Catch: java.lang.Exception -> L7c
            if (r7 != r1) goto L6f
            return r1
        L6f:
            r0 = r6
        L70:
            android.content.Context r7 = r0.f9819a     // Catch: java.lang.Exception -> L2d
            r1 = 0
            com.arlosoft.macrodroid.settings.Settings.setCommercialPurchasesRequired(r7, r1)     // Catch: java.lang.Exception -> L2d
            android.content.Context r7 = r0.f9819a     // Catch: java.lang.Exception -> L2d
            com.arlosoft.macrodroid.settings.Settings.setHasRegisteredCommercially(r7, r3)     // Catch: java.lang.Exception -> L2d
            goto L98
        L7c:
            r7 = move-exception
            r0 = r6
        L7e:
            boolean r1 = r7 instanceof retrofit2.HttpException
            if (r1 == 0) goto L95
            r1 = r7
            retrofit2.HttpException r1 = (retrofit2.HttpException) r1
            int r1 = r1.code()
            r2 = 402(0x192, float:5.63E-43)
            if (r1 != r2) goto L95
            android.content.Context r7 = r0.f9819a
            com.arlosoft.macrodroid.settings.Settings.setCommercialPurchasesRequired(r7, r3)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L95:
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r7)
        L98:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.commercial.CommercialTools.registerCommercial(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
