package com.arlosoft.macrodroid.analytics;

import android.app.Activity;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.freeversion.DataSharingService;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import com.google.firebase.analytics.ktx.ParametersBuilder;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FirebaseAnalyticsEventLogger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFirebaseAnalyticsEventLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirebaseAnalyticsEventLogger.kt\ncom/arlosoft/macrodroid/analytics/FirebaseAnalyticsEventLogger\n+ 2 com.google.firebase:firebase-analytics-ktx@@21.3.0\ncom/google/firebase/analytics/ktx/AnalyticsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,448:1\n10#2,4:449\n10#2,4:453\n1#3:457\n*S KotlinDebug\n*F\n+ 1 FirebaseAnalyticsEventLogger.kt\ncom/arlosoft/macrodroid/analytics/FirebaseAnalyticsEventLogger\n*L\n118#1:449,4\n125#1:453,4\n*E\n"})
/* loaded from: classes.dex */
public final class FirebaseAnalyticsEventLogger {
    @NotNull
    public static final FirebaseAnalyticsEventLogger INSTANCE = new FirebaseAnalyticsEventLogger();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final FirebaseAnalytics f5665a = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
    public static final int $stable = 8;

    private FirebaseAnalyticsEventLogger() {
    }

    private final void a(String str, Bundle bundle) {
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        if (!Settings.getHasLoggedOneTime(companion.getInstance(), str)) {
            f5665a.logEvent(str, null);
            Settings.setHasLoggedOneTime(companion.getInstance(), str, true);
        }
    }

    @JvmStatic
    public static final void log(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        FirebaseCrashlytics.getInstance().log(msg);
    }

    @JvmStatic
    public static final void logActivationLimitReached(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        f5665a.logEvent("activation_limit_reached", bundle);
    }

    @JvmStatic
    public static final void logAdvertClicked() {
        f5665a.logEvent("advert_clicked", null);
    }

    @JvmStatic
    public static final void logAdvertFailedToLoad(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundle = new Bundle();
        bundle.putString("reason", reason);
        f5665a.logEvent("advert_failed_to_load", bundle);
    }

    @JvmStatic
    public static final void logAdvertFailedToShow() {
        f5665a.logEvent("advert_failed_to_show", null);
    }

    @JvmStatic
    public static final void logAdvertImpression(long j4) {
        Bundle bundle = new Bundle();
        bundle.putLong("minutes_after_load", (j4 / 1000) / 60);
        f5665a.logEvent("advert_shown", bundle);
    }

    @JvmStatic
    public static final void logAdvertLoaded() {
        f5665a.logEvent("advert_loaded", null);
    }

    @JvmStatic
    public static final void logAnonymousSignInFailed() {
        f5665a.logEvent("anonymous_sign_in_failed", null);
    }

    @JvmStatic
    public static final void logAppBrainApiCall(int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_index", i4);
        f5665a.logEvent("app_brain_api_call_made", bundle);
    }

    @JvmStatic
    public static final void logAppBrainCallsExceeded() {
        f5665a.logEvent("app_brain_calls_exceeded", null);
    }

    @JvmStatic
    public static final void logBannerShown(@NotNull String bannerType) {
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        Bundle bundle = new Bundle();
        bundle.putString("type", bannerType);
        f5665a.logEvent("banner_shown", bundle);
    }

    @JvmStatic
    public static final void logCheckingExtra() {
        f5665a.logEvent("extra_subscription_check", null);
    }

    @JvmStatic
    public static final void logCheckingPro() {
        f5665a.logEvent("pro_version_check", null);
    }

    @JvmStatic
    public static final void logFirebaseProCheckFailed(@NotNull String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Bundle bundle = new Bundle();
        bundle.putString("package", pkg);
        f5665a.logEvent("fb_pro_check_failed", bundle);
    }

    @JvmStatic
    public static final void logFirebaseProCheckOk(@NotNull String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Bundle bundle = new Bundle();
        bundle.putString("package", pkg);
        f5665a.logEvent("fb_pro_check_ok", bundle);
    }

    @JvmStatic
    public static final void logFirebaseProCheckUnavailable(@NotNull String pkg, @NotNull String exception) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Bundle bundle = new Bundle();
        bundle.putString("package", pkg);
        bundle.putString("exception", exception);
        f5665a.logEvent("fb_pro_check_unavailable", bundle);
    }

    @JvmStatic
    public static final void logFirstMacroOneTime() {
        if (Settings.getHasLoggedOneTime(MacroDroidApplication.Companion.getInstance(), "funnel_onboarding_start")) {
            INSTANCE.a("funnel_macro_added_one", null);
        }
    }

    @JvmStatic
    public static final void logFiveMacrosOneTime() {
        if (Settings.getHasLoggedOneTime(MacroDroidApplication.Companion.getInstance(), "funnel_macro_added_one")) {
            INSTANCE.a("funnel_macro_added_five", null);
        }
    }

    @JvmStatic
    public static final void logFlashSaleEnabled(long j4) {
        Bundle bundle = new Bundle();
        bundle.putLong("days_installed", j4);
        bundle.putString("days_installed_string", String.valueOf(j4));
        f5665a.logEvent("flash_sale_enabled", bundle);
    }

    @JvmStatic
    public static final void logGetPurchaseFailed(int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i4);
        f5665a.logEvent("pro_version_check_get_purchase_failed", bundle);
    }

    @JvmStatic
    public static final void logHandledException(@Nullable Throwable th) {
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        Intrinsics.checkNotNull(th);
        firebaseCrashlytics.recordException(th);
    }

    @JvmStatic
    public static final void logHomeScreenUpgradeButtonClicked() {
        f5665a.logEvent("upgrade_button_home_screen_clicked", null);
    }

    @JvmStatic
    public static final void logHotSpotMethods(@NotNull String methods) {
        Intrinsics.checkNotNullParameter(methods, "methods");
        Bundle bundle = new Bundle();
        bundle.putString("methods", methods);
        f5665a.logEvent("hotspot_methods", bundle);
    }

    @JvmStatic
    public static final void logInvitationSent() {
        f5665a.logEvent("invite_sent", null);
    }

    @JvmStatic
    public static final void logLegacyProUpgradeNotApplied() {
        f5665a.logEvent("legacy_pro_not_applied", null);
    }

    @JvmStatic
    public static final void logLoadedVariabledFromAtomicBackup() {
        f5665a.logEvent("loaded_variables_from_atomic_backup", null);
    }

    @JvmStatic
    public static final void logLuckyPatcherInstalledOnUpgrade() {
        f5665a.logEvent("upgrade_with_lucky_patcher", null);
    }

    @JvmStatic
    public static final void logMainSwitchToggle(boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_on", z3);
        f5665a.logEvent("main_switch_toggle", bundle);
    }

    @JvmStatic
    public static final void logNewPurchase(int i4, int i5, @NotNull String screenName, boolean z3) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Bundle bundle = new Bundle();
        bundle.putInt("days_installed", i4);
        bundle.putString("days_installed_string", String.valueOf(i4));
        bundle.putInt("num_macros", i5);
        bundle.putString("num_macros_string", String.valueOf(i5));
        bundle.putString("screen_type", screenName);
        bundle.putBoolean("flash_sale", z3);
        f5665a.logEvent("new_purchase", bundle);
    }

    public static /* synthetic */ void logNewPurchase$default(int i4, int i5, String str, boolean z3, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            z3 = false;
        }
        logNewPurchase(i4, i5, str, z3);
    }

    @JvmStatic
    public static final void logNewPurchasePiracyCheckFail(@NotNull String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Bundle bundle = new Bundle();
        bundle.putString("app_name", appName);
        f5665a.logEvent("new_purchase_from_pirate", bundle);
    }

    @JvmStatic
    public static final void logNoAdvertAvailable() {
        f5665a.logEvent("no_advert_available", null);
    }

    @JvmStatic
    public static final void logOnboardingComplete() {
        f5665a.logEvent("funnel_onboarding_complete", null);
    }

    @JvmStatic
    public static final void logOnboardingSkipped() {
        f5665a.logEvent("funnel_onboarding_skipped", null);
    }

    @JvmStatic
    public static final void logOnboardingStartOneTime() {
        INSTANCE.a("funnel_onboarding_start", null);
    }

    @JvmStatic
    public static final void logPiratePurchase() {
        f5665a.logEvent("pirate_purchase", null);
    }

    @JvmStatic
    public static final void logPirateUser() {
        f5665a.logEvent("pirate_user", null);
    }

    @JvmStatic
    public static final void logPollfishSurveyAvailable() {
        f5665a.logEvent("pollfish_survey_available", null);
    }

    @JvmStatic
    public static final void logPollfishSurveyNotAvailable() {
        f5665a.logEvent("pollfish_survey_not_available", null);
    }

    @JvmStatic
    public static final void logProAdvertPurchase() {
        f5665a.logEvent("pro_advert_purchase", null);
    }

    @JvmStatic
    public static final void logProVersionCheckException(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundle = new Bundle();
        bundle.putString("failure_reason", reason);
        f5665a.logEvent("pro_version_check_exception", bundle);
    }

    @JvmStatic
    public static final void logProVersionCheckFailed(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundle = new Bundle();
        bundle.putString("failure_reason", reason);
        f5665a.logEvent("pro_version_check_failed", bundle);
    }

    @JvmStatic
    public static final void logProVersionCheckUnknown() {
        f5665a.logEvent("pro_version_check_unknown", null);
    }

    @JvmStatic
    public static final void logProVersionCheckValid() {
        f5665a.logEvent("pro_version_check_valid", null);
    }

    @JvmStatic
    public static final void logReviewPromptAnswer(@NotNull String response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundle = new Bundle();
        bundle.putString("response", response);
        f5665a.logEvent("review_prompt_answer", bundle);
    }

    @JvmStatic
    public static final void logReviewPromptShown() {
        f5665a.logEvent("review_prompt_shown", null);
    }

    @JvmStatic
    public static final void logScreenView(@NotNull Activity activity, @NotNull String screenName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        f5665a.setCurrentScreen(activity, screenName, null);
    }

    @JvmStatic
    public static final void logSubscriptionCheckExpired(@NotNull String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Bundle bundle = new Bundle();
        bundle.putString("package", pkg);
        f5665a.logEvent("extra_subscription_check_expired", bundle);
    }

    @JvmStatic
    public static final void logSubscriptionCheckFail(@NotNull String pkg, int i4) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Bundle bundle = new Bundle();
        bundle.putString("package", pkg);
        bundle.putString("reason", String.valueOf(i4));
        f5665a.logEvent("extra_subscription_check_fail", bundle);
    }

    @JvmStatic
    public static final void logSubscriptionCheckOk(@NotNull String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Bundle bundle = new Bundle();
        bundle.putString("package", pkg);
        f5665a.logEvent("extra_subscription_check_ok", bundle);
    }

    @JvmStatic
    public static final void logSubscriptionCheckUnavailable(@NotNull String pkg, @NotNull String exception) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Bundle bundle = new Bundle();
        bundle.putString("pkg", pkg);
        bundle.putString("exception", exception);
        f5665a.logEvent("extra_subscription_check_unavailable", bundle);
    }

    @JvmStatic
    public static final void logTranslationInfoBarShown(@NotNull String languageCode) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Bundle bundle = new Bundle();
        bundle.putString("language_code", languageCode);
        f5665a.logEvent("translation_info_bar_shown", bundle);
    }

    @JvmStatic
    public static final void logUnableToPurchase(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        Bundle bundle = new Bundle();
        bundle.putString("sku", sku);
        f5665a.logEvent("unable_to_purchase", bundle);
    }

    @JvmStatic
    public static final void logUpgradedViaSerial(@NotNull String id, @NotNull String serial) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(serial, "serial");
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("serial", serial);
        f5665a.logEvent("updgraded_via_serial", bundle);
    }

    @JvmStatic
    public static final void logUserHasNoMacroDroidPurchases() {
        f5665a.logEvent("pro_version_check_no_md_purchases", null);
    }

    @JvmStatic
    public static final void logUserHasNoPurchases() {
        f5665a.logEvent("pro_version_check_no_purchases", null);
    }

    @JvmStatic
    public static final void logUserHasPurchasedViaSerial() {
        f5665a.logEvent("pro_version_user_purchased_via_serial", null);
    }

    @JvmStatic
    public static final void logVerifyPurchaseFailed() {
        f5665a.logEvent("verify_purchase_failed", null);
    }

    @JvmStatic
    public static final void logVerifyPurchaseScreenShown() {
        f5665a.logEvent("validate_purchase_screen_shown", null);
    }

    public final void logDataSharingServiceDisabled(@NotNull DataSharingService dataSharingService, boolean z3) {
        Intrinsics.checkNotNullParameter(dataSharingService, "dataSharingService");
        FirebaseAnalytics firebaseAnalytics = f5665a;
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        parametersBuilder.param("data_partner", dataSharingService.getServiceName());
        parametersBuilder.param("by_premium_upgrade", String.valueOf(z3));
        String country = MacroDroidApplication.Companion.getInstance().getResources().getConfiguration().locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "MacroDroidApplication.in…figuration.locale.country");
        parametersBuilder.param("country", country);
        firebaseAnalytics.logEvent("data_sharing_disabled", parametersBuilder.getBundle());
    }

    public final void logDataSharingServiceEnabled(@NotNull DataSharingService dataSharingService) {
        Intrinsics.checkNotNullParameter(dataSharingService, "dataSharingService");
        FirebaseAnalytics firebaseAnalytics = f5665a;
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        parametersBuilder.param("data_partner", dataSharingService.getServiceName());
        String country = MacroDroidApplication.Companion.getInstance().getResources().getConfiguration().locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "MacroDroidApplication.in…figuration.locale.country");
        parametersBuilder.param("country", country);
        firebaseAnalytics.logEvent("data_sharing_enabled", parametersBuilder.getBundle());
    }

    public final void logMacroDroidProAdvertShown(boolean z3) {
        String str;
        Bundle bundle = new Bundle();
        if (z3) {
            str = "replacement_advert";
        } else {
            str = "no_advert_available";
        }
        bundle.putString("advert_status", str);
        f5665a.logEvent("pro_advert_shown", bundle);
    }

    public final void logRewardAdvertClicked() {
        f5665a.logEvent("reward_advert_clicked", null);
    }

    public final void logRewardAdvertCompleted(boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_house_advert", z3);
        f5665a.logEvent("reward_advert_complete", bundle);
    }

    public final void logSurveyClicked() {
        f5665a.logEvent("survey_clicked", null);
    }

    @JvmStatic
    public static final void logAnonymousSignInFailed(@NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Bundle bundle = new Bundle();
        bundle.putString(Constants.IPC_BUNDLE_KEY_SEND_ERROR, errorMessage);
        f5665a.logEvent("anonymous_sign_in_failed_no_block", bundle);
    }
}
