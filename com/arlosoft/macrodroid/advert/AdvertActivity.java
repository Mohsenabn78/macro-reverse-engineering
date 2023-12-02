package com.arlosoft.macrodroid.advert;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Random;
import javax.inject.Inject;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: AdvertActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public abstract class AdvertActivity extends MacroDroidDaggerBaseActivity {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static Intent f5634i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f5635j;

    /* renamed from: k  reason: collision with root package name */
    private static long f5636k;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private InterstitialAd f5637f;

    /* renamed from: g  reason: collision with root package name */
    private long f5638g;

    /* renamed from: h  reason: collision with root package name */
    private int f5639h;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public RemoteConfig remoteConfig;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AdvertActivity.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void setShowAdvertOnNextResume(@Nullable Intent intent) {
            AdvertActivity.f5635j = true;
            AdvertActivity.f5634i = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        AdRequest build = new AdRequest.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
        String string = getString(R.string.fullscreen_ad_id);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.fullscreen_ad_id)");
        try {
            InterstitialAd.load(this, string, build, new InterstitialAdLoadCallback() { // from class: com.arlosoft.macrodroid.advert.AdvertActivity$initialiseAdmob$1
                @Override // com.google.android.gms.ads.AdLoadCallback
                public void onAdFailedToLoad(@NotNull LoadAdError loadAdError) {
                    Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
                    String message = loadAdError.getMessage();
                    Timber.d("Advert Failed to load: " + message, new Object[0]);
                    String message2 = loadAdError.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message2, "loadAdError.message");
                    FirebaseAnalyticsEventLogger.logAdvertFailedToLoad(message2);
                    AdvertActivity.this.f5637f = null;
                }

                @Override // com.google.android.gms.ads.AdLoadCallback
                public void onAdLoaded(@NotNull InterstitialAd interstitialAd) {
                    Intrinsics.checkNotNullParameter(interstitialAd, "interstitialAd");
                    Timber.d("Advert Loaded", new Object[0]);
                    AdvertActivity.this.f5638g = System.currentTimeMillis();
                    FirebaseAnalyticsEventLogger.logAdvertLoaded();
                    AdvertActivity.this.f5637f = interstitialAd;
                }
            });
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        Intent intent = f5634i;
        if (intent != null) {
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e4) {
                FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
                String action = intent.getAction();
                Uri data = intent.getData();
                firebaseCrashlytics.log("Intent, action = " + action + ", data=" + data);
                FirebaseCrashlytics.getInstance().recordException(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        if (this.f5639h > 2) {
            Object systemService = getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            ((AudioManager) systemService).setStreamVolume(3, this.f5639h, 0);
        }
    }

    private final void p() {
        InterstitialAd interstitialAd = this.f5637f;
        if (interstitialAd != null) {
            if (interstitialAd != null) {
                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.arlosoft.macrodroid.advert.AdvertActivity$showAdmob$1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        FirebaseAnalyticsEventLogger.logAdvertClicked();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        InterstitialAd interstitialAd2;
                        InterstitialAd interstitialAd3;
                        AdvertActivity.this.o();
                        AdvertActivity.this.n();
                        interstitialAd2 = AdvertActivity.this.f5637f;
                        if (interstitialAd2 != null) {
                            interstitialAd3 = AdvertActivity.this.f5637f;
                            if (interstitialAd3 != null) {
                                interstitialAd3.setFullScreenContentCallback(null);
                            }
                            AdvertActivity.this.f5637f = null;
                        }
                        AdvertActivity.this.m();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(@NotNull AdError adError) {
                        Intrinsics.checkNotNullParameter(adError, "adError");
                        String message = adError.getMessage();
                        Timber.d("The ad failed to show: " + message, new Object[0]);
                        AdvertActivity.this.o();
                        AdvertActivity.this.n();
                        AdvertActivity.this.m();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        long j4;
                        long currentTimeMillis = System.currentTimeMillis();
                        j4 = AdvertActivity.this.f5638g;
                        FirebaseAnalyticsEventLogger.logAdvertImpression(currentTimeMillis - j4);
                    }
                });
            }
            try {
                Object systemService = getSystemService("audio");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                AudioManager audioManager = (AudioManager) systemService;
                this.f5639h = audioManager.getStreamVolume(3);
                int streamMaxVolume = (int) (audioManager.getStreamMaxVolume(3) * 0.4d);
                if (this.f5639h > streamMaxVolume) {
                    try {
                        audioManager.setStreamVolume(3, streamMaxVolume, 0);
                    } catch (Exception unused) {
                    }
                }
                InterstitialAd interstitialAd2 = this.f5637f;
                if (interstitialAd2 != null) {
                    interstitialAd2.show(this);
                    return;
                }
                return;
            } catch (Throwable th) {
                FirebaseAnalyticsEventLogger.logHandledException(th);
                n();
                m();
                return;
            }
        }
        Timber.d("Interstitial advert is not loaded", new Object[0]);
        if (new Random().nextDouble() <= getRemoteConfig().getAdvertsBlockedShowOwnAdPercent() / 100.0d) {
            r(false, f5634i);
        } else {
            n();
        }
    }

    private final void q() {
        if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
            n();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f5636k < 75000) {
            n();
            return;
        }
        boolean z3 = false;
        if (new Random().nextDouble() < getRemoteConfig().getShowProUpgradeAdvertPercent() / 100.0d) {
            Timber.d("Forcing in house advert", new Object[0]);
            z3 = true;
        }
        f5636k = currentTimeMillis;
        if (z3) {
            r(true, f5634i);
        } else {
            p();
        }
    }

    private final void r(boolean z3, Intent intent) {
        MacroDroidProAdvertActivity2.Companion.showProAdvert(this, z3, intent);
    }

    @JvmStatic
    public static final void setShowAdvertOnNextResume(@Nullable Intent intent) {
        Companion.setShowAdvertOnNextResume(intent);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!getPremiumStatusHandler().getPremiumStatus().isPro() && f5635j) {
            f5635j = false;
            q();
        }
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }
}
