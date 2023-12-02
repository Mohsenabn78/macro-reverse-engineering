package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ImmersiveModeActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class ImmersiveModeAction extends Action {
    public static final Parcelable.Creator<ImmersiveModeAction> CREATOR = new a();
    private static final int OPTION_FULL_IMMERSIVE = 3;
    private static final int OPTION_HIDE_NAV_BAR = 1;
    private static final int OPTION_HIDE_STATUS_BAR = 2;
    private static final int OPTION_OFF = 0;
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ImmersiveModeAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ImmersiveModeAction createFromParcel(Parcel parcel) {
            return new ImmersiveModeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ImmersiveModeAction[] newArray(int i4) {
            return new ImmersiveModeAction[i4];
        }
    }

    /* synthetic */ ImmersiveModeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_immersive_mode_off), SelectableItem.r(R.string.action_immersive_mode_hide_nave_bar), SelectableItem.r(R.string.action_immersive_hide_status_bar), SelectableItem.r(R.string.action_immersive_mode_full)};
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
        if (this.m_option == 0) {
            return getOptions()[0];
        }
        return getName();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_option == 0) {
            return "";
        }
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ImmersiveModeActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        str = "";
                    } else {
                        str = "immersive.full=*";
                    }
                } else {
                    str = "immersive.status=*";
                }
            } else {
                str = "immersive.navigation=*";
            }
        } else {
            str = "immersive.preconfirms=*";
        }
        boolean z3 = false;
        if (!RootToolsHelper.isAccessGiven()) {
            try {
                z3 = Settings.Global.putString(getContext().getContentResolver(), "policy_control", str);
            } catch (Exception unused) {
            }
            if (!z3) {
                SystemLog.logError("Could not set immersive mode, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", getMacroGuid().longValue());
                return;
            }
            return;
        }
        Util.runAsRoot(new String[]{"settings put global policy_control " + str});
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

    public ImmersiveModeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ImmersiveModeAction() {
    }

    private ImmersiveModeAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
