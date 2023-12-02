package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import crashguard.android.library.CrashGuard;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AddEmptyMacroTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AddEmptyMacroTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12422c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final RemoteConfig f12423d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final PremiumStatusHandler f12424e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f12425f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12426g;

    /* renamed from: h  reason: collision with root package name */
    private final long f12427h;

    /* renamed from: i  reason: collision with root package name */
    private final int f12428i;

    public AddEmptyMacroTile(@NotNull Activity activity, @NotNull RemoteConfig remoteConfig, @NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        this.f12422c = activity;
        this.f12423d = remoteConfig;
        this.f12424e = premiumStatusHandler;
        String string = activity.getString(R.string.add_macro);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.add_macro)");
        this.f12425f = string;
        this.f12426g = R.drawable.ic_plus_circle_white_48dp;
        this.f12427h = 2L;
        this.f12428i = ContextCompat.getColor(activity, R.color.primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12422c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12428i;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12426g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12427h;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        return this.f12424e;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        return this.f12423d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12425f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        CrashGuard.getInstance(this.f12422c).sendTestCrash();
        int size = MacroStore.getInstance().getAllCompletedMacros().size();
        int freeMacros = Settings.getFreeMacros(this.f12422c.getApplicationContext());
        if (!this.f12424e.getPremiumStatus().isPro() && size >= freeMacros) {
            Util.showMacroLimitReached(this.f12422c, this.f12423d);
            return;
        }
        Macro macro = new Macro();
        macro.setCompleted(false);
        macro.setName("");
        MacroStore.getInstance().addMacro(macro);
        Intent intent = new Intent(this.f12422c, EditMacroActivity.class);
        intent.putExtra("MacroId", macro.getId());
        intent.putExtra(EditMacroActivity.ADDING_NEW_MACRO_EXTRA, true);
        this.f12422c.startActivity(intent);
    }
}
