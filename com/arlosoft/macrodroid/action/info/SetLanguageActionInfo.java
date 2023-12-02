package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.SetLanguageAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class SetLanguageActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f4002g;

    public static SelectableItemInfo getInstance() {
        if (f4002g == null) {
            f4002g = new SetLanguageActionInfo();
        }
        return f4002g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new SetLanguageAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public List<String> getAdbHackPermissionRequired() {
        return Collections.singletonList("android.permission.WRITE_SECURE_SETTINGS");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_set_language_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_format_color_text_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_set_language;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getRootLevel() {
        return 1;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public boolean isExperimental() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    protected int maxSDKVersion() {
        return 25;
    }
}
