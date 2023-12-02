package com.arlosoft.macrodroid.triggers;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;

/* compiled from: TriggerInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class TriggerInfo extends SelectableItemInfo {
    public static final int $stable = 0;

    /* renamed from: f  reason: collision with root package name */
    private final int f14432f;

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @ColorRes
    public int getCategoryColor() {
        return R.color.trigger_category;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @DrawableRes
    public int getIconBgDrawable(boolean z3) {
        if (z3) {
            return R.drawable.circular_icon_background_trigger_dark;
        }
        return R.drawable.circular_icon_background_trigger;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @ColorRes
    public int getItemColor(boolean z3) {
        if (z3) {
            return R.color.trigger_primary_dark;
        }
        return R.color.trigger_primary;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getItemType() {
        return this.f14432f;
    }
}
