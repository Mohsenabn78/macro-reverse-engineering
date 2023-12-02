package com.arlosoft.macrodroid.constraint.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.ConstraintInfo;
import com.arlosoft.macrodroid.constraint.FoldAngleConstraint;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FoldAngleConstraintInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FoldAngleConstraintInfo extends ConstraintInfo {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final FoldAngleConstraintInfo f10389g = new FoldAngleConstraintInfo();

    @NotNull
    public static final FoldAngleConstraintInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new FoldAngleConstraint(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.constraint_fold_state_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_fold_angle;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.constraint_fold_state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 30;
    }

    /* compiled from: FoldAngleConstraintInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FoldAngleConstraintInfo getInstance() {
            return FoldAngleConstraintInfo.f10389g;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
