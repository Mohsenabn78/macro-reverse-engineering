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

/* compiled from: SettingsTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SettingsTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12523c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12524d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12525e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12526f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12527g;

    public SettingsTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12523c = homeScreenNavigator;
        String string = activity.getString(R.string.settings);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.settings)");
        this.f12524d = string;
        this.f12525e = R.drawable.ic_settings_white_48px;
        this.f12526f = 4L;
        this.f12527g = ContextCompat.getColor(activity, R.color.settings_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12527g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12525e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12526f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12524d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12523c.showSettings();
    }
}
