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

/* compiled from: PluginsTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginsTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12506c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12507d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12508e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12509f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12510g;

    public PluginsTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12506c = homeScreenNavigator;
        String string = activity.getString(R.string.home_screen_tile_plugins);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…home_screen_tile_plugins)");
        this.f12507d = string;
        this.f12508e = R.drawable.ic_power_plug_white_24dp;
        this.f12509f = 20L;
        this.f12510g = ContextCompat.getColor(activity, R.color.plugins_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12510g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12508e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12509f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12507d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12506c.showPlugins();
    }
}
