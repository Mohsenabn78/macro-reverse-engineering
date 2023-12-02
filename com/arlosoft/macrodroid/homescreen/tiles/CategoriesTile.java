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

/* compiled from: CategoriesTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CategoriesTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12441c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12442d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12443e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12444f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12445g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12446h;

    public CategoriesTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12441c = homeScreenNavigator;
        String string = activity.getString(R.string.categories);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.categories)");
        this.f12442d = string;
        this.f12443e = R.drawable.ic_categories;
        this.f12444f = 16L;
        this.f12445g = ContextCompat.getColor(activity, R.color.categories_primary);
        this.f12446h = 24;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12445g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12443e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12444f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getMinSdkVersion() {
        return this.f12446h;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12442d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12441c.showCategories();
    }
}
