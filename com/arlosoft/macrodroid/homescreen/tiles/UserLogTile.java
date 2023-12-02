package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.logging.LogActivity;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserLogTile.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUserLogTile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserLogTile.kt\ncom/arlosoft/macrodroid/homescreen/tiles/UserLogTile\n+ 2 CustomServices.kt\norg/jetbrains/anko/CustomServicesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n26#2:29\n1#3:30\n*S KotlinDebug\n*F\n+ 1 UserLogTile.kt\ncom/arlosoft/macrodroid/homescreen/tiles/UserLogTile\n*L\n21#1:29\n*E\n"})
/* loaded from: classes3.dex */
public final class UserLogTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12538c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12539d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12540e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12541f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12542g;

    public UserLogTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12538c = activity;
        String string = activity.getString(R.string.user_log);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.user_log)");
        this.f12539d = string;
        this.f12540e = R.drawable.ic_file_document_edit;
        this.f12541f = 12L;
        this.f12542g = ContextCompat.getColor(activity, R.color.user_log_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12538c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12542g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12540e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12541f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12539d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        Activity activity = this.f12538c;
        Intent intent = new Intent(this.f12538c, LogActivity.class);
        intent.putExtra(LogActivity.EXTRA_IS_USER_LOG, true);
        activity.startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void setCustomViewContents(@NotNull FrameLayout view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            ((LayoutInflater) systemService).inflate(R.layout.home_tile_custom_log, (ViewGroup) view, true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
