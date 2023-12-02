package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.AmbientDisplayAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class AmbientDisplayActionInfo extends ActionInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f3759g;

    public static SelectableItemInfo getInstance() {
        if (f3759g == null) {
            f3759g = new AmbientDisplayActionInfo();
        }
        return f3759g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new AmbientDisplayAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public List<String> getAdbHackPermissionRequired() {
        return Collections.singletonList("android.permission.WRITE_SECURE_SETTINGS");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.action_ambient_display_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_brightness_4_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.action_ambient_display;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getRootLevel() {
        return 1;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 21;
    }
}
