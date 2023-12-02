package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.DataOnOffTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;

/* loaded from: classes3.dex */
public class DataOnOffTriggerInfo extends TriggerInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f14954g;

    public static SelectableItemInfo getInstance() {
        if (f14954g == null) {
            f14954g = new DataOnOffTriggerInfo();
        }
        return f14954g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new DataOnOffTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.trigger_data_on_off_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_swap_vertical_circle_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.trigger_data_on_off;
    }
}
