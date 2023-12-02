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

/* compiled from: FavouritesTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FavouritesTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12458c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12459d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12460e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12461f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12462g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12463h;

    public FavouritesTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12458c = homeScreenNavigator;
        String string = activity.getString(R.string.favourite_macros);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.favourite_macros)");
        this.f12459d = string;
        this.f12460e = R.drawable.ic_star_white_24dp;
        this.f12461f = 25L;
        this.f12462g = ContextCompat.getColor(activity, R.color.favourites_primary);
        this.f12463h = 24;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12462g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12460e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12461f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getMinSdkVersion() {
        return this.f12463h;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12459d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12458c.showFavouritesDialog(view, iconView);
    }
}
