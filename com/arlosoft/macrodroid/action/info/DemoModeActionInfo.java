package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.DemoModeAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DemoModeActionInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class DemoModeActionInfo extends ActionInfo {
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f3837g = R.string.action_demo_mode;

    /* renamed from: h  reason: collision with root package name */
    private final int f3838h = R.drawable.ic_alpha_d_box_white_24dp;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f3839i = R.string.action_demo_mode_help;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final List<String> f3840j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f3841k;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final SelectableItemInfo f3836l = new DemoModeActionInfo();

    public DemoModeActionInfo() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.WRITE_SECURE_SETTINGS", "android.permission.DUMP"});
        this.f3840j = listOf;
        this.f3841k = true;
    }

    @NotNull
    public static final SelectableItemInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new DemoModeAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public List<String> getAdbHackPermissionRequired() {
        return this.f3840j;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f3839i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f3838h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f3837g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public boolean isRootOnly() {
        return this.f3841k;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 23;
    }

    /* compiled from: DemoModeActionInfo.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableItemInfo getInstance() {
            return DemoModeActionInfo.f3836l;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
