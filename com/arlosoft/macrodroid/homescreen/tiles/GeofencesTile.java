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

/* compiled from: GeofencesTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class GeofencesTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12469c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12470d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12471e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12472f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12473g;

    public GeofencesTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12469c = homeScreenNavigator;
        String string = activity.getString(R.string.geofences);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.geofences)");
        this.f12470d = string;
        this.f12471e = R.drawable.ic_map_marker_radius;
        this.f12472f = 9L;
        this.f12473g = ContextCompat.getColor(activity, R.color.geofences_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12473g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12471e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12472f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12470d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12469c.showGeofences();
    }
}
