package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.stopwatch.StopWatchesActivity;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: StopwatchesTile.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nStopwatchesTile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StopwatchesTile.kt\ncom/arlosoft/macrodroid/homescreen/tiles/StopWatchesTile\n+ 2 CustomServices.kt\norg/jetbrains/anko/CustomServicesKt\n*L\n1#1,43:1\n26#2:44\n*S KotlinDebug\n*F\n+ 1 StopwatchesTile.kt\ncom/arlosoft/macrodroid/homescreen/tiles/StopWatchesTile\n*L\n27#1:44\n*E\n"})
/* loaded from: classes3.dex */
public final class StopWatchesTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12528c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12529d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12530e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12531f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12532g;

    public StopWatchesTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12528c = activity;
        String string = activity.getString(R.string.stopwatches);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.stopwatches)");
        this.f12529d = string;
        this.f12530e = R.drawable.ic_timer_outline;
        this.f12531f = 8L;
        this.f12532g = ContextCompat.getColor(activity, R.color.stopwatches_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12528c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12532g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12530e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12531f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12529d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12528c.startActivity(new Intent(this.f12528c, StopWatchesActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void setCustomViewContents(@NotNull FrameLayout view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            ((LayoutInflater) systemService).inflate(R.layout.home_tile_custom_stopwatch, (ViewGroup) view, true);
            View findViewById = view.findViewById(R.id.stopwatch1);
            Intrinsics.checkNotNull(findViewById);
            ViewGroup viewGroup = (ViewGroup) findViewById;
            View findViewById2 = view.findViewById(R.id.stopwatch2);
            Intrinsics.checkNotNull(findViewById2);
            ViewGroup viewGroup2 = (ViewGroup) findViewById2;
            View findViewById3 = view.findViewById(R.id.stopwatch3);
            Intrinsics.checkNotNull(findViewById3);
            ViewGroup viewGroup3 = (ViewGroup) findViewById3;
            View findViewById4 = view.findViewById(R.id.stopwatch4);
            Intrinsics.checkNotNull(findViewById4);
            ViewGroup viewGroup4 = (ViewGroup) findViewById4;
            View findViewById5 = viewGroup.findViewById(R.id.stopwatchName);
            Intrinsics.checkNotNull(findViewById5);
            ((TextView) findViewById5).setText("Test2");
            View findViewById6 = viewGroup.findViewById(R.id.stopwatchTime);
            Intrinsics.checkNotNull(findViewById6);
            ((TextView) findViewById6).setText("0:00");
            View findViewById7 = viewGroup2.findViewById(R.id.stopwatchName);
            Intrinsics.checkNotNull(findViewById7);
            ((TextView) findViewById7).setText("Test1");
            View findViewById8 = viewGroup2.findViewById(R.id.stopwatchTime);
            Intrinsics.checkNotNull(findViewById8);
            ((TextView) findViewById8).setText("12:00");
            View findViewById9 = viewGroup3.findViewById(R.id.stopwatchName);
            Intrinsics.checkNotNull(findViewById9);
            ((TextView) findViewById9).setText("Test1");
            View findViewById10 = viewGroup3.findViewById(R.id.stopwatchTime);
            Intrinsics.checkNotNull(findViewById10);
            ((TextView) findViewById10).setText("0:00");
            View findViewById11 = viewGroup4.findViewById(R.id.stopwatchName);
            Intrinsics.checkNotNull(findViewById11);
            ((TextView) findViewById11).setText("Test1");
            View findViewById12 = viewGroup4.findViewById(R.id.stopwatchTime);
            Intrinsics.checkNotNull(findViewById12);
            ((TextView) findViewById12).setText("0:00");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
