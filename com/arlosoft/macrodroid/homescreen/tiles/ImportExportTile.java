package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.ExportImportActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ImportExportTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ImportExportTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12478c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12479d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12480e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12481f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12482g;

    public ImportExportTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12478c = activity;
        String string = activity.getString(R.string.export_import);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.export_import)");
        this.f12479d = string;
        this.f12480e = R.drawable.material_ic_save_24px_svg;
        this.f12481f = 6L;
        this.f12482g = ContextCompat.getColor(activity, R.color.export_import_primary);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12482g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12480e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12481f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12479d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12478c.startActivity(new Intent(this.f12478c, ExportImportActivity.class));
    }
}
