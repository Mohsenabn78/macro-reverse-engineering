package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.TextManipulationAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class TextManipulationActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f4035g;

    public static SelectableItemInfo getInstance() {
        if (f4035g == null) {
            f4035g = new TextManipulationActionInfo();
        }
        return f4035g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new TextManipulationAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    protected List<Integer> getAdditionalSearchTerms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_substring));
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_replace_all));
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_extract_text));
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_uppercase));
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_lowercase));
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_trim_whitespace));
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_split_to_array));
        arrayList.add(Integer.valueOf((int) R.string.text_manipulation_remove_text));
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_text_manipulation_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_code_string_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_text_manipulation;
    }
}
