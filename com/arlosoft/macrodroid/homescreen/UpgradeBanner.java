package com.arlosoft.macrodroid.homescreen;

import android.content.Context;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.settings.Settings;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UpgradeBanner.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UpgradeBanner {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12328a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Integer[] f12329b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: UpgradeBanner.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UpgradeBanner(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f12328a = context;
        this.f12329b = new Integer[]{Integer.valueOf((int) R.string.unlimited_number_of_macros), Integer.valueOf((int) R.string.no_adverts), Integer.valueOf((int) R.string.cloud_backup), Integer.valueOf((int) R.string.upgrade_unlimited_no_template_store_title), Integer.valueOf((int) R.string.upgrade_unlimited_support_us_title)};
    }

    @StringRes
    public final int getUpgradeReasonText() {
        long upgradeBannerLastUpdateTime = Settings.getUpgradeBannerLastUpdateTime(this.f12328a);
        int currentUpgradeBanner = Settings.getCurrentUpgradeBanner(this.f12328a);
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = 0;
        if (upgradeBannerLastUpdateTime == 0) {
            Settings.setUpgradeBannerLastUpdateTime(this.f12328a, currentTimeMillis);
            return this.f12329b[0].intValue();
        } else if (currentTimeMillis - upgradeBannerLastUpdateTime > 3600000) {
            Settings.setUpgradeBannerLastUpdateTime(this.f12328a, currentTimeMillis);
            int i5 = currentUpgradeBanner + 1;
            if (i5 < this.f12329b.length) {
                i4 = i5;
            }
            Settings.setCurrentUpgradeBanner(this.f12328a, i4);
            return this.f12329b[i4].intValue();
        } else {
            return this.f12329b[currentUpgradeBanner].intValue();
        }
    }

    @NotNull
    public final Integer[] getUpgradeReasons() {
        return this.f12329b;
    }
}
