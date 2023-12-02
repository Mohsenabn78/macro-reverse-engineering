package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.OpenMacroDroidLogAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes2.dex */
public class OpenMacroDroidLogActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f3953g;

    public static SelectableItemInfo getInstance() {
        if (f3953g == null) {
            f3953g = new OpenMacroDroidLogActionInfo();
        }
        return f3953g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new OpenMacroDroidLogAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_open_macrodroid_log_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_file_document_box_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_open_macrodroid_log;
    }
}
