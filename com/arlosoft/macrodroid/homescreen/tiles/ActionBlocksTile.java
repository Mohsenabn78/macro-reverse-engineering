package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActionBlocksTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ActionBlocksTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12417c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12418d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12419e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12420f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12421g;

    public ActionBlocksTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12417c = activity;
        String string = activity.getString(R.string.action_blocks);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.action_blocks)");
        this.f12418d = string;
        this.f12419e = R.drawable.text_box_multiple;
        this.f12420f = 23L;
        this.f12421g = ContextCompat.getColor(activity, R.color.actions_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12417c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12421g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12419e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12420f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12418d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        ActionBlockListActivity.Companion.launch(this.f12417c, false, 0);
    }
}
