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

/* compiled from: DrawerTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class DrawerTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12453c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12454d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12455e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12456f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12457g;

    public DrawerTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12453c = homeScreenNavigator;
        String string = activity.getString(R.string.macrodroid_drawer_options);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…acrodroid_drawer_options)");
        this.f12454d = string;
        this.f12455e = R.drawable.ic_drawer_right;
        this.f12456f = 14L;
        this.f12457g = ContextCompat.getColor(activity, R.color.drawer_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12457g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12455e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12456f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12454d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12453c.showDrawerSettings();
    }
}
