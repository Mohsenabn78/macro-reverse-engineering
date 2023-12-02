package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.BatterySaverActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class BatterySaverAction extends Action {
    public static final Parcelable.Creator<BatterySaverAction> CREATOR = new a();
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<BatterySaverAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BatterySaverAction createFromParcel(Parcel parcel) {
            return new BatterySaverAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BatterySaverAction[] newArray(int i4) {
            return new BatterySaverAction[i4];
        }
    }

    /* synthetic */ BatterySaverAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_battery_saver_on), SelectableItem.r(R.string.action_battery_saver_off), SelectableItem.r(R.string.toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_option < 2) {
            return getOptions()[this.m_option];
        }
        return SelectableItem.r(R.string.action_battery_saver) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.toggle);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BatterySaverActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    @SuppressLint({"NewApi"})
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        boolean isPowerSaveMode = ((PowerManager) getContext().getSystemService("power")).isPowerSaveMode();
        int i4 = this.m_option;
        boolean z4 = false;
        int i5 = 1;
        if (i4 != 1) {
            if (i4 != 2) {
                z3 = true;
            } else {
                z3 = !isPowerSaveMode;
            }
        } else {
            z3 = false;
        }
        try {
            ContentResolver contentResolver = getContext().getContentResolver();
            if (!z3) {
                i5 = 0;
            }
            z4 = Settings.Global.putInt(contentResolver, "low_power", i5);
        } catch (Exception unused) {
            if (RootToolsHelper.isAccessGiven()) {
                if (z3) {
                    Util.runAsRoot(new String[]{"settings put global low_power 1"});
                    return;
                } else {
                    Util.runAsRoot(new String[]{"settings put global low_power 0"});
                    return;
                }
            }
        }
        if (!z4) {
            SystemLog.logError("Could not set battery saver, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", getMacroGuid().longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public BatterySaverAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BatterySaverAction() {
        this.m_option = 0;
    }

    private BatterySaverAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
