package com.arlosoft.macrodroid.constraint.info;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.BluetoothConstraint;
import com.arlosoft.macrodroid.constraint.ConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes3.dex */
public class BluetoothConstraintInfo extends ConstraintInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f10372g;

    public static SelectableItemInfo getInstance() {
        if (f10372g == null) {
            f10372g = new BluetoothConstraintInfo();
        }
        return f10372g;
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
        return new BluetoothConstraint(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.constraint_bluetooth_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_bluetooth_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.constraint_bluetooth;
    }
}
