package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.BluetoothTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;

/* loaded from: classes3.dex */
public class BluetoothTriggerInfo extends TriggerInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f14942g;

    public static SelectableItemInfo getInstance() {
        if (f14942g == null) {
            f14942g = new BluetoothTriggerInfo();
        }
        return f14942g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public boolean allowedOnDevice() {
        if (super.allowedOnDevice() && BluetoothAdapter.getDefaultAdapter() != null) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new BluetoothTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.trigger_bluetooth_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_bluetooth_connect_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.trigger_bluetooth;
    }
}
