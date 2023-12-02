package com.arlosoft.macrodroid.constraint.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.ConstraintInfo;
import com.arlosoft.macrodroid.constraint.WifiHotSpotConstraint;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes3.dex */
public class WifiHotSpotConstraintInfo extends ConstraintInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f10434g;

    public static SelectableItemInfo getInstance() {
        if (f10434g == null) {
            f10434g = new WifiHotSpotConstraintInfo();
        }
        return f10434g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new WifiHotSpotConstraint(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.constraint_wifi_hotspot_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_wifi_tethering_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.constraint_wifi_hotspot;
    }
}
