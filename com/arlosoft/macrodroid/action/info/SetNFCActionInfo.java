package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.SetNFCAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class SetNFCActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f4007g;

    public static SelectableItemInfo getInstance() {
        if (f4007g == null) {
            f4007g = new SetNFCActionInfo();
        }
        return f4007g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new SetNFCAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public List<String> getAdbHackPermissionRequired() {
        return Collections.singletonList("android.permission.WRITE_SECURE_SETTINGS");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_set_nfc_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_nfc_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_set_nfc;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getRootLevel() {
        return 1;
    }
}
