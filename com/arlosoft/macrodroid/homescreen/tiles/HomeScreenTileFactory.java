package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.BasicTile;
import com.arlosoft.macrodroid.data.HomeTile;
import com.arlosoft.macrodroid.homescreen.HomeScreenNavigator;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HomeScreenTileFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HomeScreenTileFactory {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f12474a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final HomeScreenNavigator f12475b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final RemoteConfig f12476c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final PremiumStatusHandler f12477d;

    public HomeScreenTileFactory(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator, @NotNull RemoteConfig remoteConfig, @NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        this.f12474a = activity;
        this.f12475b = homeScreenNavigator;
        this.f12476c = remoteConfig;
        this.f12477d = premiumStatusHandler;
    }

    @NotNull
    public final HomeScreenTile createHomeScreenTile(@NotNull HomeTile tile) {
        Intrinsics.checkNotNullParameter(tile, "tile");
        if (tile instanceof BasicTile) {
            long tileId = tile.getTileId();
            if (tileId == 1) {
                Activity activity = this.f12474a;
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.arlosoft.macrodroid.homescreen.HomeScreenNavigator");
                return new MacrosTile(activity, (HomeScreenNavigator) activity);
            } else if (tileId == 2) {
                return new AddEmptyMacroTile(this.f12474a, this.f12476c, this.f12477d);
            } else {
                if (tileId == 4) {
                    Activity activity2 = this.f12474a;
                    Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.arlosoft.macrodroid.homescreen.HomeScreenNavigator");
                    return new SettingsTile(activity2, (HomeScreenNavigator) activity2);
                } else if (tileId == 5) {
                    return new ForumTile(this.f12474a);
                } else {
                    if (tileId == 6) {
                        return new ImportExportTile(this.f12474a);
                    }
                    if (tileId == 7) {
                        return new VariablesTile(this.f12474a);
                    }
                    if (tileId == 8) {
                        return new StopWatchesTile(this.f12474a);
                    }
                    if (tileId == 9) {
                        return new GeofencesTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 10) {
                        return new CellTowersTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 11) {
                        return new SystemLogTile(this.f12474a);
                    }
                    if (tileId == 12) {
                        return new UserLogTile(this.f12474a);
                    }
                    if (tileId == 13) {
                        return new AutoBackupTile(this.f12474a);
                    }
                    if (tileId == 14) {
                        return new DrawerTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 15) {
                        return new QuickSettingsConfigTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 16) {
                        return new CategoriesTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 17) {
                        return new NotificationBarTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 18) {
                        return new AddWizardMacroTile(this.f12474a, this.f12476c, this.f12477d);
                    }
                    if (tileId == 19) {
                        return new ModesConfigTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 20) {
                        return new PluginsTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 21) {
                        return new LastEditedMacroTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 22) {
                        return new QuickRunMacroTile(this.f12474a, this.f12475b);
                    }
                    if (tileId == 23) {
                        return new ActionBlocksTile(this.f12474a);
                    }
                    if (tileId == 24) {
                        return new VideosTile(this.f12474a);
                    }
                    if (tileId == 25) {
                        return new FavouritesTile(this.f12474a, this.f12475b);
                    }
                    long tileId2 = tile.getTileId();
                    throw new IllegalArgumentException("Illegal tileid: " + tileId2);
                }
            }
        }
        throw new IllegalArgumentException("Unkown tile: " + tile);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12474a;
    }

    @NotNull
    public final HomeScreenNavigator getHomeScreenNavigator() {
        return this.f12475b;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        return this.f12477d;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        return this.f12476c;
    }
}
