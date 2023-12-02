package com.arlosoft.macrodroid.action;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;

/* compiled from: ActionInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public abstract class ActionInfo extends SelectableItemInfo {
    public static final int $stable = 0;

    /* renamed from: f  reason: collision with root package name */
    private final int f2070f = 1;

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @ColorRes
    public int getCategoryColor() {
        return R.color.actions_category;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @DrawableRes
    public int getIconBgDrawable(boolean z3) {
        if (z3) {
            return R.drawable.circular_icon_background_action_dark;
        }
        return R.drawable.circular_icon_background_action;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @ColorRes
    public int getItemColor(boolean z3) {
        if (z3) {
            return R.color.actions_primary_dark;
        }
        return R.color.actions_primary;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getItemType() {
        return this.f2070f;
    }
}
