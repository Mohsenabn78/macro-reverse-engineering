package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.ExpandCollapseStatusBarAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes2.dex */
public class ExpandCollapseStatusBarActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f3870g;

    public static SelectableItemInfo getInstance() {
        if (f3870g == null) {
            f3870g = new ExpandCollapseStatusBarActionInfo();
        }
        return f3870g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new ExpandCollapseStatusBarAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_expand_collapse_status_bar_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_swap_vertical_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_expand_collapse_status_bar;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 17;
    }
}
