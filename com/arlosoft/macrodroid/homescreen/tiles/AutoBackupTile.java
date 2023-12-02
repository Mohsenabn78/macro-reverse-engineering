package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.autobackup.ui.AutoBackupActivity;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AutoBackupTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AutoBackupTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12436c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12437d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12438e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12439f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12440g;

    public AutoBackupTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12436c = activity;
        String string = activity.getString(R.string.auto_backup);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.auto_backup)");
        this.f12437d = string;
        this.f12438e = R.drawable.ic_content_save_all;
        this.f12439f = 13L;
        this.f12440g = ContextCompat.getColor(activity, R.color.auto_backup_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12436c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12440g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12438e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12439f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12437d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12436c.startActivity(new Intent(this.f12436c, AutoBackupActivity.class));
    }
}
