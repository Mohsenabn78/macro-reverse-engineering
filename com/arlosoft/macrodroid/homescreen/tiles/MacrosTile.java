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

/* compiled from: MacrosTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MacrosTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12491c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12492d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12493e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12494f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12495g;

    public MacrosTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12491c = homeScreenNavigator;
        String string = activity.getString(R.string.list_macros);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.list_macros)");
        this.f12492d = string;
        this.f12493e = R.drawable.active_icon_new;
        this.f12494f = 1L;
        this.f12495g = ContextCompat.getColor(activity, R.color.primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12495g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12493e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12494f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12492d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12491c.showMacros();
    }
}
