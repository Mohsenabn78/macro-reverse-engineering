package com.arlosoft.macrodroid.homescreen.tiles.base;

import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HomeScreenTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class HomeScreenTile {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f12562a = true;

    /* renamed from: b  reason: collision with root package name */
    private final int f12563b;

    public abstract int getBackgroundColor();

    public abstract int getIconRes();

    public abstract long getId();

    public int getMinSdkVersion() {
        return this.f12563b;
    }

    public boolean getSupportsBasicLayout() {
        return this.f12562a;
    }

    @NotNull
    public abstract String getTitle();

    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
    }

    public void setCustomViewContents(@NotNull FrameLayout view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
