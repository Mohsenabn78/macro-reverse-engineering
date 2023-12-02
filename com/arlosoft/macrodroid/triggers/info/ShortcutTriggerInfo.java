package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.ShortcutTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ShortcutTriggerInfo extends TriggerInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f15048g;

    public static SelectableItemInfo getInstance() {
        if (f15048g == null) {
            f15048g = new ShortcutTriggerInfo();
        }
        return f15048g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new ShortcutTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public List<Integer> getAdditionalSearchTerms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) R.string.action_disable_macro_macro));
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.trigger_shortcut_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_share_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.trigger_shortcut;
    }
}
