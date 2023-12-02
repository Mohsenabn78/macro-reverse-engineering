package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AddWizardMacroTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AddWizardMacroTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12429c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final RemoteConfig f12430d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final PremiumStatusHandler f12431e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f12432f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12433g;

    /* renamed from: h  reason: collision with root package name */
    private final long f12434h;

    /* renamed from: i  reason: collision with root package name */
    private final int f12435i;

    public AddWizardMacroTile(@NotNull Activity activity, @NotNull RemoteConfig remoteConfig, @NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        this.f12429c = activity;
        this.f12430d = remoteConfig;
        this.f12431e = premiumStatusHandler;
        String string = activity.getString(R.string.add_macro_wizard);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.add_macro_wizard)");
        this.f12432f = string;
        this.f12433g = R.drawable.ic_wizard;
        this.f12434h = 18L;
        this.f12435i = ContextCompat.getColor(activity, R.color.trigger_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12429c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12435i;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12433g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12434h;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        return this.f12431e;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        return this.f12430d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12432f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        int size = MacroStore.getInstance().getAllCompletedMacros().size();
        int freeMacros = Settings.getFreeMacros(this.f12429c.getApplicationContext());
        if (!this.f12431e.getPremiumStatus().isPro() && size >= freeMacros) {
            Util.showMacroLimitReached(this.f12429c, this.f12430d);
            return;
        }
        this.f12429c.startActivity(new Intent(this.f12429c, WizardActivity.class));
    }
}
