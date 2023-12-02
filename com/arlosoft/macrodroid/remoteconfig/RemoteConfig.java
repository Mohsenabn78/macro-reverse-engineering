package com.arlosoft.macrodroid.remoteconfig;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.gson.Gson;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RemoteConfig.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class RemoteConfig {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseRemoteConfig f13284a;

    /* renamed from: b  reason: collision with root package name */
    private final Gson f13285b;

    /* compiled from: RemoteConfig.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FirebaseRemoteConfigSettings build = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(86400L).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
                RemoteConfig.this.f13284a.setDefaultsAsync(R.xml.remote_config_defaults);
                RemoteConfig.this.f13284a.setConfigSettingsAsync(build);
                RemoteConfig.this.f13284a.fetchAndActivate();
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

    @Inject
    public RemoteConfig() {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance()");
        this.f13284a = firebaseRemoteConfig;
        this.f13285b = GsonUtils.getGsonBuilder().create();
        try {
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
        } catch (Exception unused) {
        }
    }

    @NotNull
    public final String flashSalePackageName() {
        return BillingModuleKt.SKU_PREMIUM_FLASH_SALE;
    }

    public final long getAdvertsBlockedShowOwnAdPercent() {
        return this.f13284a.getLong("adverts_blocked_show_own_ad_percent");
    }

    @NotNull
    public final List<String> getBlockScreenReadPackages() {
        String string = this.f13284a.getString("blockedScreenReadPackages");
        Intrinsics.checkNotNullExpressionValue(string, "firebaseRemoteConfig.get…KED_SCREEN_READ_PACKAGES)");
        return StringsKt.split$default((CharSequence) string, new String[]{","}, false, 0, 6, (Object) null);
    }

    public final boolean getDataSharingEnabledHuq() {
        return this.f13284a.getBoolean("dataSharingEnabledHuq");
    }

    public final boolean getEnableInAppPurchaseCheck() {
        return this.f13284a.getBoolean("enableInAppPurchaseCheck");
    }

    public final long getEncourageUpgradeMessageDaysToWait() {
        return this.f13284a.getLong("encourageUpgradeMessageDaysToWait");
    }

    public final long getEncourageUpgradeMessageVariant() {
        return this.f13284a.getLong("encourageUpgradeMessageVariant");
    }

    @NotNull
    public final ExtraMinVersion getExtraMinVersion(@NotNull String extraPackage) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        try {
            ExtraMinVersion extraMinVersion = ((ExtraMinVersions) this.f13285b.fromJson(this.f13284a.getString("extraMinVersions"), (Class<Object>) ExtraMinVersions.class)).getMinVersions().get(extraPackage);
            if (extraMinVersion == null) {
                return new ExtraMinVersion("0", 0);
            }
            return extraMinVersion;
        } catch (Exception unused) {
            return new ExtraMinVersion("0", 0);
        }
    }

    public final boolean getExtrasShowStandardSubscriptions() {
        return this.f13284a.getBoolean("extrasShowStandardSubscriptions");
    }

    public final long getFlashSaleDayWait() {
        return this.f13284a.getLong("flashSaleDayWait");
    }

    public final boolean getForceUpdateToLatest() {
        return this.f13284a.getBoolean("forceUpdateToLatest");
    }

    public final boolean getFreeUsageAppAnnieEnabled() {
        return this.f13284a.getBoolean("limitFreeUseEnabled");
    }

    @NotNull
    public final String getHelpTranslateMessage() {
        String string = this.f13284a.getString("helpTranslateMessage");
        Intrinsics.checkNotNullExpressionValue(string, "firebaseRemoteConfig.get…Y_HELP_TRANSLATE_MESSAGE)");
        return string;
    }

    public final long getHolidayReturnTimestamp() {
        return this.f13284a.getLong("holidayReturnTimestamp");
    }

    public final boolean getLimitedFreeUsageEnabledState() {
        return this.f13284a.getBoolean("limitFreeUseEnabled");
    }

    public final long getPollFishSurveyAdditionalDays() {
        return this.f13284a.getLong("pollfishSurveyAdditionalDays");
    }

    public final boolean getPollFishSurveysEnabled() {
        return this.f13284a.getBoolean("pollfishSurveysEnabled");
    }

    @NotNull
    public final String getPrivacyPolicyLink() {
        String string = this.f13284a.getString("privacyPolicyLink");
        Intrinsics.checkNotNullExpressionValue(string, "firebaseRemoteConfig.get…(KEY_PRIVACY_POLICY_LINK)");
        return string;
    }

    public final long getProAdvertCountDownSeconds() {
        return this.f13284a.getLong("proAdvertCountDownSeconds");
    }

    @NotNull
    public final String getProAdvertImageType() {
        String string = this.f13284a.getString("proAdvertImageType");
        Intrinsics.checkNotNullExpressionValue(string, "firebaseRemoteConfig.get…EY_PRO_ADVERT_IMAGE_TYPE)");
        return string;
    }

    public final boolean getProValveEnabled() {
        return this.f13284a.getBoolean("proValveEnabled");
    }

    public final long getRewardAdvertAdditionalDays() {
        return this.f13284a.getLong("rewardAdvertAdditionalDays");
    }

    public final boolean getShowAnimatedUpgradeBar() {
        return this.f13284a.getBoolean("showAnimatedUpgradeBar");
    }

    public final boolean getShowExtras() {
        return this.f13284a.getBoolean("showExtras");
    }

    public final long getShowProUpgradeAdvertPercent() {
        return this.f13284a.getLong("show_pro_upgrade_advert_percent");
    }

    public final boolean getShowStopClub() {
        return this.f13284a.getBoolean("showStopClub");
    }

    @Nullable
    public final String getStopClubMenuEntryName() {
        boolean z3;
        String string = this.f13284a.getString("stopclubMenuEntryName");
        Intrinsics.checkNotNullExpressionValue(string, "firebaseRemoteConfig.get…TOP_CLUB_MENU_ENTRY_NAME)");
        if (string.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return null;
        }
        return string;
    }

    public final long getValidatePurchaseFrequencyDays() {
        return this.f13284a.getLong("validatePurchasesFrequencyDays");
    }

    public final boolean getValidatePurchasesEnabled() {
        return this.f13284a.getBoolean("validatePurchasesEnabled");
    }

    public final boolean piracyChecksEnabled() {
        return this.f13284a.getBoolean("piracyChecksEnabled");
    }

    public final boolean shouldAutoShowUpgradeScreen() {
        return true;
    }

    public final boolean shouldShowUpgradeButtonShimmer() {
        return this.f13284a.getBoolean("upgradeButtonShimmer");
    }

    public final boolean shouldShowUpgradeOnFirstLaunch() {
        return true;
    }

    @NotNull
    public final String upgradeFlashSalePackageName() {
        String string = this.f13284a.getString("iapIdFlashSale");
        Intrinsics.checkNotNullExpressionValue(string, "firebaseRemoteConfig.get…ng(KEY_IAP_FLASH_SALE_ID)");
        return string;
    }

    @NotNull
    public final String upgradePackageName() {
        String string = this.f13284a.getString("iapId");
        Intrinsics.checkNotNullExpressionValue(string, "firebaseRemoteConfig.getString(KEY_IAP_ID)");
        return string;
    }
}
