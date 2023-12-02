package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.homescreen.HomeScreenNavigator;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: QuickSettingsConfigTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class QuickSettingsConfigTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12517c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12518d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12519e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12520f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12521g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12522h;

    public QuickSettingsConfigTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12517c = homeScreenNavigator;
        String string = activity.getString(R.string.quick_settings_tiles);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.quick_settings_tiles)");
        this.f12518d = string;
        this.f12519e = R.drawable.ic_cog_box;
        this.f12520f = 15L;
        this.f12521g = ContextCompat.getColor(activity, R.color.quick_settings_config_primary);
        this.f12522h = 24;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12521g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12519e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12520f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getMinSdkVersion() {
        return this.f12522h;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12518d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12517c.showQuickSettingsConfig();
    }
}
