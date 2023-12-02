package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.FingerprintGestureTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;

/* loaded from: classes3.dex */
public class FingerprintGestureTriggerInfo extends TriggerInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f14967g;

    public static SelectableItemInfo getInstance() {
        if (f14967g == null) {
            f14967g = new FingerprintGestureTriggerInfo();
        }
        return f14967g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public boolean allowedOnDevice() {
        if (super.allowedOnDevice() && MacroDroidApplication.getInstance().getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new FingerprintGestureTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.trigger_fingerprint_gesture_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_fingerprint_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.trigger_fingerprint_gesture;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 26;
    }
}
