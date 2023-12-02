package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.videos.VideosActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: VideosTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VideosTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12548c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12549d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12550e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12551f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12552g;

    public VideosTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12548c = activity;
        String string = activity.getString(R.string.tile_videos_title);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.tile_videos_title)");
        this.f12549d = string;
        this.f12550e = R.drawable.material_ic_videocam_24px_svg;
        this.f12551f = 24L;
        this.f12552g = ContextCompat.getColor(activity, R.color.videos_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12548c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12552g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12550e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12551f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12549d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        VideosActivity.Companion.launch(this.f12548c);
    }
}
