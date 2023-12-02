package com.arlosoft.macrodroid.extras.ui;

import android.app.Dialog;
import android.view.View;
import com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState;
import com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtrasActivity.kt */
/* loaded from: classes3.dex */
final class ExtrasActivity$handlePurchaseClick$1 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
    final /* synthetic */ ExtraPackageClickListener.PurchasePeriod $purchasePeriod;
    int label;
    final /* synthetic */ ExtrasActivity this$0;

    /* compiled from: ExtrasActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExtraPackageClickListener.PurchasePeriod.values().length];
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.WEEKLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.MONTHLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.YEARLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.WEEKLY_PREPAID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.MONTHLY_PREPAID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.YEARLY_PREPAID.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtrasActivity$handlePurchaseClick$1(ExtraPackageClickListener.PurchasePeriod purchasePeriod, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, ExtrasActivity extrasActivity, Dialog dialog, Continuation<? super ExtrasActivity$handlePurchaseClick$1> continuation) {
        super(3, continuation);
        this.$purchasePeriod = purchasePeriod;
        this.$extraPackage = extraPackageWithPriceAndState;
        this.this$0 = extrasActivity;
        this.$dialog = dialog;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    /* renamed from: a */
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
        return new ExtrasActivity$handlePurchaseClick$1(this.$purchasePeriod, this.$extraPackage, this.this$0, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String weeklySubscriptionId;
        kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            switch (WhenMappings.$EnumSwitchMapping$0[this.$purchasePeriod.ordinal()]) {
                case 1:
                    if (this.$extraPackage.getUsedTrial()) {
                        weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getWeeklySubscriptionIdNoTrial();
                        break;
                    } else {
                        weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getWeeklySubscriptionId();
                        break;
                    }
                case 2:
                    if (this.$extraPackage.getUsedTrial()) {
                        weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getMonthlySubscriptionIdNoTrial();
                        break;
                    } else {
                        weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getMonthlySubscriptionId();
                        break;
                    }
                case 3:
                    if (this.$extraPackage.getUsedTrial()) {
                        weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getYearlySubscriptionIdNoTrial();
                        break;
                    } else {
                        weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getYearlySubscriptionId();
                        break;
                    }
                case 4:
                    weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getWeeklySubscriptionIdPrePaid();
                    break;
                case 5:
                    weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getMonthlySubscriptionIdPrePaid();
                    break;
                case 6:
                    weeklySubscriptionId = this.$extraPackage.getExtra().getSubscriptionData().getYearlySubscriptionIdPrePaid();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            String str = weeklySubscriptionId;
            if (str != null) {
                BillingDataSource.launchBillingFlow$default(this.this$0.getBillingDataSource(), this.this$0, str, new String[0], false, 8, null);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            ExtraPackageClickListener.PurchasePeriod purchasePeriod = this.$purchasePeriod;
            throw new IllegalStateException("No subscription ID for purchase period " + purchasePeriod);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
