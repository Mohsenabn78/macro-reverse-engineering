package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.variables.MacroDroidVariablesActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: VariablesTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VariablesTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12543c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12544d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12545e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12546f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12547g;

    public VariablesTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12543c = activity;
        String string = activity.getString(R.string.variables);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.variables)");
        this.f12544d = string;
        this.f12545e = R.drawable.ic_help_box;
        this.f12546f = 7L;
        this.f12547g = ContextCompat.getColor(activity, R.color.variables_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12543c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12547g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12545e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12546f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12544d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12543c.startActivity(new Intent(this.f12543c, MacroDroidVariablesActivity.class));
    }
}
