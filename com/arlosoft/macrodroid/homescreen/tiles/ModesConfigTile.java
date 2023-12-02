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

/* compiled from: ModesConfigTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ModesConfigTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12496c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12497d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12498e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12499f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12500g;

    public ModesConfigTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12496c = homeScreenNavigator;
        String string = activity.getString(R.string.edit_macrodroid_modes);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.edit_macrodroid_modes)");
        this.f12497d = string;
        this.f12498e = R.drawable.active_icon_new;
        this.f12499f = 19L;
        this.f12500g = ContextCompat.getColor(activity, R.color.modes_config_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12500g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12498e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12499f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12497d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12496c.showMacroDroidModes();
    }
}
