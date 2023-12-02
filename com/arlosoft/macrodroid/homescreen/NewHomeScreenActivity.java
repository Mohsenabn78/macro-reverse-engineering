package com.arlosoft.macrodroid.homescreen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.ui.BottomNavigationViewKt;
import com.android.billingclient.api.BillingClient;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.advert.AdvertActivity;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.celltowers.CellTowerListActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.confirmation.PremiumStatus;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.confirmation.validation.ConfirmActionActivity;
import com.arlosoft.macrodroid.confirmation.validation.PremiumValidator;
import com.arlosoft.macrodroid.databinding.ActivityNewHomeScreenBinding;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.extensions.LongExtensionsKt;
import com.arlosoft.macrodroid.geofences.GeofenceListActivity;
import com.arlosoft.macrodroid.homescreen.favourites.FavouritesDialogActivity;
import com.arlosoft.macrodroid.homescreen.quickrun.QuickRunMacroDialogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.DamnYouPirates;
import com.arlosoft.macrodroid.plugins.PluginsActivity;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsActivity;
import com.arlosoft.macrodroid.settings.EditCategoriesActivity;
import com.arlosoft.macrodroid.settings.EditModesActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.settings.drawer.DrawerPreferencesActivity;
import com.arlosoft.macrodroid.settings.notificationbar.NotificationBarPreferencesActivity;
import com.arlosoft.macrodroid.templatestore.events.TemplateStoreRefreshEvent;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.m;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.format.DateTimeFormatter;

/* compiled from: NewHomeScreenActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nNewHomeScreenActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewHomeScreenActivity.kt\ncom/arlosoft/macrodroid/homescreen/NewHomeScreenActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,392:1\n1#2:393\n*E\n"})
/* loaded from: classes3.dex */
public final class NewHomeScreenActivity extends AdvertActivity implements HomeScreenNavigator {
    @Inject
    public BillingDataSource billingDataSource;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private BillingClient f12317l;

    /* renamed from: m  reason: collision with root package name */
    private NavController f12318m;

    /* renamed from: n  reason: collision with root package name */
    private ActivityNewHomeScreenBinding f12319n;
    @Inject
    public NotificationChannelUtil notificationChannleUtil;
    @Inject
    public PremiumValidator premiumValidator;
    @Inject
    public PurchaseValidator purchaseValidator;
    @Inject
    public ScreenLoader screenLoader;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NewHomeScreenActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent createMacroListIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, NewHomeScreenActivity.class);
            intent.putExtra("tab_to_load", 1);
            return intent;
        }

        @JvmStatic
        @NotNull
        public final Intent createReloadTemplateIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, NewHomeScreenActivity.class);
            intent.putExtra("reload_template", true);
            return intent;
        }

        @JvmStatic
        @NotNull
        public final Intent createSettingsIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, NewHomeScreenActivity.class);
            intent.putExtra("tab_to_load", 3);
            return intent;
        }

        @JvmStatic
        @NotNull
        public final Intent createTemplateListIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, NewHomeScreenActivity.class);
            intent.putExtra("reload_template", 2);
            return intent;
        }
    }

    /* compiled from: NewHomeScreenActivity.kt */
    /* loaded from: classes3.dex */
    public interface ProVersionStateLister {
        void onProVersionUpdate(@NotNull PremiumStatus premiumStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NewHomeScreenActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $checkProFrequencyDays;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j4, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$checkProFrequencyDays = j4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$checkProFrequencyDays, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r5)
                goto L93
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L49
            L1f:
                kotlin.ResultKt.throwOnFailure(r5)
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                java.lang.String r5 = com.arlosoft.macrodroid.settings.Settings.getUpgradeSerial(r5)
                if (r5 != 0) goto L84
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                java.lang.String r5 = com.arlosoft.macrodroid.settings.Settings.getPurchaseSku(r5)
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r1 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                java.lang.String r1 = com.arlosoft.macrodroid.settings.Settings.getPurchaseToken(r1)
                if (r5 == 0) goto Lb5
                if (r1 == 0) goto Lb5
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r2 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                com.arlosoft.macrodroid.confirmation.PurchaseValidator r2 = r2.getPurchaseValidator()
                r4.label = r3
                java.lang.Object r5 = r2.validateProUpgrade(r5, r1, r4)
                if (r5 != r0) goto L49
                return r0
            L49:
                com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode r5 = (com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode) r5
                com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode r0 = com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode.PRO_USER_PLAY_STORE_INVALID
                if (r5 != r0) goto L63
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                com.arlosoft.macrodroid.remoteconfig.RemoteConfig r5 = r5.getRemoteConfig()
                boolean r5 = r5.getEnableInAppPurchaseCheck()
                if (r5 == 0) goto Lb5
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                java.lang.String r0 = "Cannot validate purchase"
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.access$handleFailedProStatusCheck(r5, r0)
                goto Lb5
            L63:
                com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode r0 = com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode.PRO_USER_PLAY_STORE_VALID
                if (r5 != r0) goto L78
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                long r0 = java.lang.System.currentTimeMillis()
                long r2 = r4.$checkProFrequencyDays
                long r2 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.getDaysToMilli(r2)
                long r0 = r0 + r2
                com.arlosoft.macrodroid.settings.Settings.setNextProUserCheckTimeStamp(r5, r0)
                goto Lb5
            L78:
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                long r0 = r4.$checkProFrequencyDays
                long r0 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.getDaysToMilli(r0)
                com.arlosoft.macrodroid.settings.Settings.setNextProUserCheckTimeStamp(r5, r0)
                goto Lb5
            L84:
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                com.arlosoft.macrodroid.confirmation.validation.PremiumValidator r5 = r5.getPremiumValidator()
                r4.label = r2
                java.lang.Object r5 = r5.checkProWithServer(r4)
                if (r5 != r0) goto L93
                return r0
            L93:
                com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode r5 = (com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode) r5
                com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode r0 = com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode.PRO_USER_SERIAL_NOT_VERIFIED
                if (r5 != r0) goto La1
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                java.lang.String r0 = "Serial not verified"
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.access$handleFailedProStatusCheck(r5, r0)
                goto Lb5
            La1:
                com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode r0 = com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode.PRO_USER_SERIAL_VALID
                if (r5 != r0) goto Lb5
                com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity r5 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.this
                long r0 = java.lang.System.currentTimeMillis()
                long r2 = r4.$checkProFrequencyDays
                long r2 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.getDaysToMilli(r2)
                long r0 = r0 + r2
                com.arlosoft.macrodroid.settings.Settings.setNextProUserCheckTimeStamp(r5, r0)
            Lb5:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @JvmStatic
    @NotNull
    public static final Intent createMacroListIntent(@NotNull Context context) {
        return Companion.createMacroListIntent(context);
    }

    @JvmStatic
    @NotNull
    public static final Intent createReloadTemplateIntent(@NotNull Context context) {
        return Companion.createReloadTemplateIntent(context);
    }

    @JvmStatic
    @NotNull
    public static final Intent createSettingsIntent(@NotNull Context context) {
        return Companion.createSettingsIntent(context);
    }

    @JvmStatic
    @NotNull
    public static final Intent createTemplateListIntent(@NotNull Context context) {
        return Companion.createTemplateListIntent(context);
    }

    private final void t(Intent intent) {
        int intExtra = intent.getIntExtra("tab_to_load", -1);
        if (intExtra != 0) {
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra == 3) {
                        showSettings();
                        return;
                    }
                    return;
                }
                showTemplates();
                return;
            }
            showMacros();
            return;
        }
        showHome();
    }

    private final void u() {
        long validatePurchaseFrequencyDays = getRemoteConfig().getValidatePurchaseFrequencyDays();
        SystemLog.logDebug("Validate purchases is enabled with frequency: " + validatePurchaseFrequencyDays + " days");
        if (System.currentTimeMillis() > Settings.getNextProUserCheckTimeStamp(this)) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(validatePurchaseFrequencyDays, null), 2, null);
            return;
        }
        String format = LongExtensionsKt.toLocalDateTime(Settings.getNextProUserCheckTimeStamp(this)).format(DateTimeFormatter.ISO_DATE_TIME);
        SystemLog.logDebug("Next purchase validation at: " + format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String str) {
        Settings.setPurchaseInvalidated(this, true);
        Settings.setShowValidationWarning(this, true);
        Settings.setUpgradeSerial(this, null);
        Settings.setSecondaryProEnabled(this, false);
        finish();
        ConfirmActionActivity.Companion.showActivity(this);
        FirebaseAnalyticsEventLogger.logProVersionCheckFailed(str);
    }

    private final boolean w(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private final boolean x() {
        try {
            if (getPackageManager().getPackageInfo(getPackageName(), 0).firstInstallTime == getPackageManager().getPackageInfo(getPackageName(), 0).lastUpdateTime) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(NewHomeScreenActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDestroyedOrFinishing()) {
            UpgradeActivity2.Companion.animateInUpgradeSceen(this$0);
        }
    }

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
    public final NotificationChannelUtil getNotificationChannleUtil() {
        NotificationChannelUtil notificationChannelUtil = this.notificationChannleUtil;
        if (notificationChannelUtil != null) {
            return notificationChannelUtil;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationChannleUtil");
        return null;
    }

    @NotNull
    public final PremiumValidator getPremiumValidator() {
        PremiumValidator premiumValidator = this.premiumValidator;
        if (premiumValidator != null) {
            return premiumValidator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumValidator");
        return null;
    }

    @NotNull
    public final PurchaseValidator getPurchaseValidator() {
        PurchaseValidator purchaseValidator = this.purchaseValidator;
        if (purchaseValidator != null) {
            return purchaseValidator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("purchaseValidator");
        return null;
    }

    @NotNull
    public final ScreenLoader getScreenLoader() {
        ScreenLoader screenLoader = this.screenLoader;
        if (screenLoader != null) {
            return screenLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenLoader");
        return null;
    }

    @Override // com.arlosoft.macrodroid.advert.AdvertActivity, com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        boolean endsWith$default;
        super.onCreate(bundle);
        ActivityNewHomeScreenBinding inflate = ActivityNewHomeScreenBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12319n = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        if (getIntent().getBooleanExtra(Constants.EXIT_APP, false)) {
            finish();
            return;
        }
        this.f12318m = ActivityKt.findNavController(this, R.id.navHostFragment);
        ActivityNewHomeScreenBinding activityNewHomeScreenBinding = this.f12319n;
        if (activityNewHomeScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNewHomeScreenBinding = null;
        }
        BottomNavigationView bottomNavigationView = activityNewHomeScreenBinding.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(bottomNavigationView, "binding.bottomNavigation");
        NavController navController = this.f12318m;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        BottomNavigationViewKt.setupWithNavController(bottomNavigationView, navController);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        t(intent);
        if (!Settings.getMacroDroidEnabled(getApplicationContext())) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.macrodroid_disabled, 0).show();
        }
        SystemLog.logVerbose("Home Screen Created");
        String name = getApplication().getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "application.javaClass.name");
        endsWith$default = m.endsWith$default(name, "MacroDroidApplication", false, 2, null);
        if (!endsWith$default) {
            finish();
        }
        if (w("com.google.android.gms.common.URET")) {
            finish();
        }
        if (DamnYouPirates.isPirate(MacroDroidApplication.Companion.getInstance())) {
            v("Wrong Key");
        }
        EventBusUtils.getEventBus().register(this);
        if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBusUtils.getEventBus().unregister(this);
    }

    public final void onEventMainThread(@NotNull TemplateStoreRefreshEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        NavController navController = this.f12318m;
        NavController navController2 = null;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.navigation_home);
        NavController navController3 = this.f12318m;
        if (navController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
        } else {
            navController2 = navController3;
        }
        navController2.navigate(R.id.navigation_templates);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        t(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            BillingClient billingClient = this.f12317l;
            boolean z3 = false;
            if (billingClient != null && billingClient.isReady()) {
                z3 = true;
            }
            if (z3) {
                BillingClient billingClient2 = this.f12317l;
                if (billingClient2 != null) {
                    billingClient2.endConnection();
                }
                this.f12317l = null;
            }
        } catch (Exception e4) {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            firebaseCrashlytics.recordException(new Exception("NewHomeScreenActivity failed onPause: " + e4));
        }
    }

    @Override // com.arlosoft.macrodroid.advert.AdvertActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (Settings.getShowValidationWarning(this)) {
            ConfirmActionActivity.Companion.showActivity(this);
            finish();
        } else if (Settings.getCanShowUpgradeOnLaunch(getApplicationContext()) && x()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.homescreen.j
                @Override // java.lang.Runnable
                public final void run() {
                    NewHomeScreenActivity.y(NewHomeScreenActivity.this);
                }
            }, 500L);
        }
    }

    public final void setBillingDataSource(@NotNull BillingDataSource billingDataSource) {
        Intrinsics.checkNotNullParameter(billingDataSource, "<set-?>");
        this.billingDataSource = billingDataSource;
    }

    public final void setNotificationChannleUtil(@NotNull NotificationChannelUtil notificationChannelUtil) {
        Intrinsics.checkNotNullParameter(notificationChannelUtil, "<set-?>");
        this.notificationChannleUtil = notificationChannelUtil;
    }

    public final void setPremiumValidator(@NotNull PremiumValidator premiumValidator) {
        Intrinsics.checkNotNullParameter(premiumValidator, "<set-?>");
        this.premiumValidator = premiumValidator;
    }

    public final void setPurchaseValidator(@NotNull PurchaseValidator purchaseValidator) {
        Intrinsics.checkNotNullParameter(purchaseValidator, "<set-?>");
        this.purchaseValidator = purchaseValidator;
    }

    public final void setScreenLoader(@NotNull ScreenLoader screenLoader) {
        Intrinsics.checkNotNullParameter(screenLoader, "<set-?>");
        this.screenLoader = screenLoader;
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showCategories() {
        startActivity(new Intent(this, EditCategoriesActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showCellTowers() {
        Intent intent = new Intent(this, CellTowerListActivity.class);
        intent.putExtra(CellTowerListActivity.EXTRA_EDIT_MODE_ON, true);
        startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showDrawerSettings() {
        startActivity(new Intent(this, DrawerPreferencesActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showEditMacroScreen(int i4) {
        Intent intent = new Intent(this, EditMacroActivity.class);
        intent.putExtra("MacroId", i4);
        startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showFavouritesDialog(@NotNull View tileView, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(tileView, "tileView");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        Intent intent = new Intent(this, FavouritesDialogActivity.class);
        Pair create = Pair.create(tileView, "tileContainer");
        Intrinsics.checkNotNullExpressionValue(create, "create<View, String>(tileView, \"tileContainer\")");
        Pair create2 = Pair.create(iconView, com.getpebble.android.kit.Constants.CUST_ICON);
        Intrinsics.checkNotNullExpressionValue(create2, "create<View, String>(iconView, \"icon\")");
        ActivityOptionsCompat makeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(this, create, create2);
        Intrinsics.checkNotNullExpressionValue(makeSceneTransitionAnimation, "makeSceneTransitionAnima…this, cardPair, iconPair)");
        startActivity(intent, makeSceneTransitionAnimation.toBundle());
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showGeofences() {
        startActivity(new Intent(this, GeofenceListActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showHome() {
        NavController navController = this.f12318m;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.navigation_home);
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showMacroDroidModes() {
        startActivity(new Intent(this, EditModesActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showMacros() {
        NavController navController = this.f12318m;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.navigation_macro_list);
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showNotificationBarOptions() {
        startActivity(new Intent(this, NotificationBarPreferencesActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showPlugins() {
        startActivity(new Intent(this, PluginsActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showQuickRunMacroDialog(@NotNull View tileView, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(tileView, "tileView");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        Intent intent = new Intent(this, QuickRunMacroDialogActivity.class);
        Pair create = Pair.create(tileView, "tileContainer");
        Intrinsics.checkNotNullExpressionValue(create, "create<View, String>(tileView, \"tileContainer\")");
        Pair create2 = Pair.create(iconView, com.getpebble.android.kit.Constants.CUST_ICON);
        Intrinsics.checkNotNullExpressionValue(create2, "create<View, String>(iconView, \"icon\")");
        ActivityOptionsCompat makeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(this, create, create2);
        Intrinsics.checkNotNullExpressionValue(makeSceneTransitionAnimation, "makeSceneTransitionAnima…this, cardPair, iconPair)");
        startActivity(intent, makeSceneTransitionAnimation.toBundle());
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showQuickSettingsConfig() {
        startActivity(new Intent(this, QuickSettingsActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showSettings() {
        NavController navController = this.f12318m;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.navigation_settings);
    }

    @Override // com.arlosoft.macrodroid.homescreen.HomeScreenNavigator
    public void showTemplates() {
        NavController navController = this.f12318m;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.navigation_templates);
    }
}
