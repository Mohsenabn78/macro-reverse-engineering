package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.BatteryTemperatureTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;

/* loaded from: classes3.dex */
public class BatteryTemperatureTriggerInfo extends TriggerInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f14936g;

    public static SelectableItemInfo getInstance() {
        if (f14936g == null) {
            f14936g = new BatteryTemperatureTriggerInfo();
        }
        return f14936g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new BatteryTemperatureTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.trigger_battery_temp_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.temperature_celsius;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.trigger_battery_temp;
    }
}
