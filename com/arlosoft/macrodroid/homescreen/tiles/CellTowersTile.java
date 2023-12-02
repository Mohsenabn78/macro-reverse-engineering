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

/* compiled from: CellTowersTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CellTowersTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12447c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final HomeScreenNavigator f12448d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final String f12449e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12450f;

    /* renamed from: g  reason: collision with root package name */
    private final long f12451g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12452h;

    public CellTowersTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12447c = activity;
        this.f12448d = homeScreenNavigator;
        String string = activity.getString(R.string.constraint_cell_towers);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…g.constraint_cell_towers)");
        this.f12449e = string;
        this.f12450f = R.drawable.ic_radio_tower;
        this.f12451g = 10L;
        this.f12452h = ContextCompat.getColor(activity, R.color.cell_towers_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12452h;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12450f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12451g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12449e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12448d.showCellTowers();
    }
}
