package com.arlosoft.macrodroid.upgrade.base;

import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LifecycleOwnerKt;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivityKt;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BasePurchaseActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class BasePurchaseActivity extends MacroDroidDaggerBaseActivity {
    public static final int $stable = 8;
    @Inject
    public BillingDataSource billingDataSource;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15905f;
    @Inject
    public FlashSaleManager flashSaleManager;
    @Inject
    public FreeVersionHelper freeVersionHelper;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f15906g;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public RemoteConfig remoteConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePurchaseActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean isPro) {
            Intrinsics.checkNotNullExpressionValue(isPro, "isPro");
            if (isPro.booleanValue()) {
                BasePurchaseActivity.this.m();
            }
        }
    }

    /* compiled from: BasePurchaseActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(continuation);
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
                BasePurchaseActivity basePurchaseActivity = BasePurchaseActivity.this;
                this.label = 1;
                if (basePurchaseActivity.querySkuPrice(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePurchaseActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BasePurchaseActivity.this.querySkuPrice(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePurchaseActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d implements FlowCollector<String> {
        d() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
            BasePurchaseActivity.this.setWasPriceText(str);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePurchaseActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e implements FlowCollector<String> {
        e() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
            BasePurchaseActivity.this.u(str);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.pro_upgrade_applied), 1).show();
        FirebaseAnalyticsEventLogger.logNewPurchase((int) ((System.currentTimeMillis() - Settings.getInstallDate(this)) / 86400000), MacroStore.getInstance().getAllCompletedMacros().size(), getAnalyticsPuchaseSource(), r());
        getFreeVersionHelper().getEnabledDataSharingService().getDataPartner().disableDataSharing(true);
        logSpecificPurchaseAnalytics();
        finish();
    }

    private final String o() {
        if (r()) {
            return getRemoteConfig().upgradeFlashSalePackageName();
        }
        return getRemoteConfig().upgradePackageName();
    }

    private final String p() {
        return getRemoteConfig().upgradePackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String str) {
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.only_this_price);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.only_this_price)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            setPriceText(format);
        } catch (Exception unused) {
            setPriceText(str);
        }
    }

    @NotNull
    public abstract String getAnalyticsPuchaseSource();

    @NotNull
    public final BillingDataSource getBillingDataSource() {
        BillingDataSource billingDataSource = this.billingDataSource;
        if (billingDataSource != null) {
            return billingDataSource;
        }
        Intrinsics.throwUninitializedPropertyAccessException("billingDataSource");
        return null;
    }

    @NotNull
    public final FlashSaleManager getFlashSaleManager() {
        FlashSaleManager flashSaleManager = this.flashSaleManager;
        if (flashSaleManager != null) {
            return flashSaleManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flashSaleManager");
        return null;
    }

    @NotNull
    public final FreeVersionHelper getFreeVersionHelper() {
        FreeVersionHelper freeVersionHelper = this.freeVersionHelper;
        if (freeVersionHelper != null) {
            return freeVersionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("freeVersionHelper");
        return null;
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

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig != null) {
            return remoteConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
        return null;
    }

    public boolean getSupportsFlashSale() {
        return this.f15906g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 0 && i5 == -1) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        getPremiumStatusHandler().isProLiveStatus().observe(this, new BasePurchaseActivityKt.a(new a()));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object querySkuPrice(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity.c
            if (r0 == 0) goto L13
            r0 = r7
            com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity$c r0 = (com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity$c r0 = new com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L87
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.L$0
            com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity r2 = (com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L66
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.r()
            if (r7 == 0) goto L65
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r7 = r6.getBillingDataSource()
            java.lang.String r2 = r6.p()
            kotlinx.coroutines.flow.Flow r7 = r7.getSkuPrice(r2)
            kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.take(r7, r4)
            com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity$d r2 = new com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity$d
            r2.<init>()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.collect(r2, r0)
            if (r7 != r1) goto L65
            return r1
        L65:
            r2 = r6
        L66:
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r7 = r2.getBillingDataSource()
            java.lang.String r5 = r2.o()
            kotlinx.coroutines.flow.Flow r7 = r7.getSkuPrice(r5)
            kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.take(r7, r4)
            com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity$e r4 = new com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity$e
            r4.<init>()
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.collect(r4, r0)
            if (r7 != r1) goto L87
            return r1
        L87:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity.querySkuPrice(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean r() {
        if (getSupportsFlashSale() && getFlashSaleManager().isFlashSaleActive() && !this.f15905f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s() {
        BillingDataSource.launchBillingFlow$default(getBillingDataSource(), this, o(), new String[0], false, 8, null);
    }

    public final void setBillingDataSource(@NotNull BillingDataSource billingDataSource) {
        Intrinsics.checkNotNullParameter(billingDataSource, "<set-?>");
        this.billingDataSource = billingDataSource;
    }

    public final void setFlashSaleManager(@NotNull FlashSaleManager flashSaleManager) {
        Intrinsics.checkNotNullParameter(flashSaleManager, "<set-?>");
        this.flashSaleManager = flashSaleManager;
    }

    public final void setFreeVersionHelper(@NotNull FreeVersionHelper freeVersionHelper) {
        Intrinsics.checkNotNullParameter(freeVersionHelper, "<set-?>");
        this.freeVersionHelper = freeVersionHelper;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public abstract void setPriceText(@NotNull String str);

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }

    public void setWasPriceText(@NotNull String priceText) {
        Intrinsics.checkNotNullParameter(priceText, "priceText");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(boolean z3) {
        this.f15905f = z3;
    }

    public void logSpecificPurchaseAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
    }
}
