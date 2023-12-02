package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.SetKeyguardAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes2.dex */
public class SetKeyguardActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f4001g;

    public static SelectableItemInfo getInstance() {
        if (f4001g == null) {
            f4001g = new SetKeyguardActionInfo();
        }
        return f4001g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new SetKeyguardAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_set_keyguard_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_lock_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_set_keyguard;
    }
}
