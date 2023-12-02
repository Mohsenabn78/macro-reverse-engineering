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

/* compiled from: QuickRunMacroTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class QuickRunMacroTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12511c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final HomeScreenNavigator f12512d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final String f12513e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12514f;

    /* renamed from: g  reason: collision with root package name */
    private final long f12515g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12516h;

    public QuickRunMacroTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12511c = activity;
        this.f12512d = homeScreenNavigator;
        String string = activity.getString(R.string.home_screen_tile_quick_run_macro);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…een_tile_quick_run_macro)");
        this.f12513e = string;
        this.f12514f = R.drawable.ic_run_fast;
        this.f12515g = 22L;
        this.f12516h = ContextCompat.getColor(activity, R.color.home_screen_tile_quick_run_macro);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12516h;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12514f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12515g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12513e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12512d.showQuickRunMacroDialog(view, iconView);
    }
}
