package com.arlosoft.macrodroid.constraint;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;

/* compiled from: ConstraintInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class ConstraintInfo extends SelectableItemInfo {
    public static final int $stable = 0;

    /* renamed from: f  reason: collision with root package name */
    private final int f10187f = 2;

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @ColorRes
    public int getCategoryColor() {
        return R.color.constraints_category;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @DrawableRes
    public int getIconBgDrawable(boolean z3) {
        if (z3) {
            return R.drawable.circular_icon_background_constraint_dark;
        }
        return R.drawable.circular_icon_background_constraint;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @ColorRes
    public int getItemColor(boolean z3) {
        if (z3) {
            return R.color.constraints_primary_dark;
        }
        return R.color.constraints_primary;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getItemType() {
        return this.f10187f;
    }
}
