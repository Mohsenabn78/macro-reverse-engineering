package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.TakeScreenshotAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes2.dex */
public class TakeScreenshotActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f4034g;

    public static SelectableItemInfo getInstance() {
        if (f4034g == null) {
            f4034g = new TakeScreenshotActionInfo();
        }
        return f4034g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new TakeScreenshotAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        if (Build.VERSION.SDK_INT >= 28) {
            return R.string.action_take_screenshot_help_android_pie;
        }
        return R.string.action_take_screenshot_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_cellphone_android_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_take_screenshot;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public boolean isRootOnly() {
        if (Build.VERSION.SDK_INT < 28) {
            return true;
        }
        return false;
    }
}
