package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.BatteryLevelTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;

/* loaded from: classes3.dex */
public class BatteryLevelTriggerInfo extends TriggerInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f14934g;

    public static SelectableItemInfo getInstance() {
        if (f14934g == null) {
            f14934g = new BatteryLevelTriggerInfo();
        }
        return f14934g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new BatteryLevelTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.trigger_battery_level_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_battery_60_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.trigger_battery_level;
    }
}
