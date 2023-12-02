package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.SetScreenTimeoutAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes2.dex */
public class SetScreenTimeoutActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f4013g;

    public static SelectableItemInfo getInstance() {
        if (f4013g == null) {
            f4013g = new SetScreenTimeoutActionInfo();
        }
        return f4013g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new SetScreenTimeoutAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_set_screen_timeout_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.not_icon_displaybright;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_set_screen_timeout;
    }
}
