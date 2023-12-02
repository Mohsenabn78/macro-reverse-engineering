package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.AndroidShortcutsAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AndroidShortcutsActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f3760g;

    public static SelectableItemInfo getInstance() {
        if (f3760g == null) {
            f3760g = new AndroidShortcutsActionInfo();
        }
        return f3760g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new AndroidShortcutsAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    protected List<Integer> getAdditionalSearchTerms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) R.string.action_android_shortcuts_settings));
        arrayList.add(Integer.valueOf((int) R.string.action_android_shortcuts_options));
        arrayList.add(Integer.valueOf((int) R.string.action_android_shortcuts_recent));
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_android_shortcuts_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_android_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_android_shortcuts;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 17;
    }
}
