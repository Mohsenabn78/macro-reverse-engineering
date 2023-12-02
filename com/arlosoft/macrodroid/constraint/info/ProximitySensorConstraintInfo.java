package com.arlosoft.macrodroid.constraint.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.ConstraintInfo;
import com.arlosoft.macrodroid.constraint.ProximitySensorConstraint;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes3.dex */
public class ProximitySensorConstraintInfo extends ConstraintInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f10418g;

    public static SelectableItemInfo getInstance() {
        if (f10418g == null) {
            f10418g = new ProximitySensorConstraintInfo();
        }
        return f10418g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new ProximitySensorConstraint(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.constraint_proximity_sensor_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_phonelink_ring_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.constraint_proximity_sensor;
    }
}