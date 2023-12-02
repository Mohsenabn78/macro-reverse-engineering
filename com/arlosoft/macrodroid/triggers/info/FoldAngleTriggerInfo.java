package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.FoldAngleTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FoldAngleTriggerInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FoldAngleTriggerInfo extends TriggerInfo {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final SelectableItemInfo f14970j = new FoldAngleTriggerInfo();
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f14971g = R.string.trigger_fold_angle;

    /* renamed from: h  reason: collision with root package name */
    private final int f14972h = R.drawable.ic_fold_angle;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f14973i = R.string.trigger_fold_angle_help;

    @NotNull
    public static final SelectableItemInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new FoldAngleTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f14973i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f14972h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f14971g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 30;
    }

    /* compiled from: FoldAngleTriggerInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableItemInfo getInstance() {
            return FoldAngleTriggerInfo.f14970j;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
