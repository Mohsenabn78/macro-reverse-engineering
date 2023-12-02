package com.arlosoft.macrodroid.constraint.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.ConstraintInfo;
import com.arlosoft.macrodroid.constraint.WifiConstraint;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes3.dex */
public class WifiConstraintInfo extends ConstraintInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f10433g;

    public static SelectableItemInfo getInstance() {
        if (f10433g == null) {
            f10433g = new WifiConstraintInfo();
        }
        return f10433g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new WifiConstraint(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.constraint_wifi_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_wifi_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.constraint_wifi;
    }
}
