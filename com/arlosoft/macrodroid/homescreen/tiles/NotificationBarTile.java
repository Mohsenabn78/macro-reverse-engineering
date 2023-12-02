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

/* compiled from: NotificationBarTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NotificationBarTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final HomeScreenNavigator f12501c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12502d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12503e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12504f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12505g;

    public NotificationBarTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12501c = homeScreenNavigator;
        String string = activity.getString(R.string.notification_bar_options);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…notification_bar_options)");
        this.f12502d = string;
        this.f12503e = R.drawable.ic_checkbook;
        this.f12504f = 17L;
        this.f12505g = ContextCompat.getColor(activity, R.color.notification_bar_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12505g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12503e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12504f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12502d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12501c.showNotificationBarOptions();
    }
}
