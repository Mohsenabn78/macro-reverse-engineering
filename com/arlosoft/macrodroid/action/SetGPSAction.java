package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetGPSActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes2.dex */
public class SetGPSAction extends Action {
    public static final Parcelable.Creator<SetGPSAction> CREATOR = new a();
    private static final int OPTION_GPS_OFF = 1;
    private static final int OPTION_GPS_ON = 0;
    private static final int OPTION_GPS_TOGGLE = 2;
    private int m_state;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetGPSAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetGPSAction createFromParcel(Parcel parcel) {
            return new SetGPSAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetGPSAction[] newArray(int i4) {
            return new SetGPSAction[i4];
        }
    }

    /* synthetic */ SetGPSAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(DialogInterface dialogInterface, int i4) {
        super.handleItemSelected();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_gps_on), SelectableItem.r(R.string.action_set_gps_off), SelectableItem.r(R.string.action_set_gps_toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetGPSActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.gps_action_deprecated);
        builder.setMessage(R.string.gps_action_use_set_location_mode);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.hj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetGPSAction.this.N(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        int i4;
        String str;
        int i5 = 3;
        if (!Settings.getForceRootHelper(getContext())) {
            if (this.m_state == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            try {
                i4 = Settings.Secure.getInt(getContext().getContentResolver(), "location_mode");
                try {
                    if (this.m_state == 2 && i4 != 3 && i4 != 1) {
                        z3 = true;
                    }
                } catch (Settings.SettingNotFoundException unused) {
                }
            } catch (Settings.SettingNotFoundException unused2) {
                i4 = 0;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (z3) {
                    Util.runAsRoot(new String[]{"settings put secure location_providers_allowed +gps"});
                    return;
                } else {
                    Util.runAsRoot(new String[]{"settings put secure location_providers_allowed -gps"});
                    return;
                }
            }
            String string = Settings.Secure.getString(getContext().getContentResolver(), "location_providers_allowed");
            String str2 = "network";
            if (z3) {
                String[] strArr = new String[2];
                strArr[0] = "settings put secure location_mode " + i4;
                StringBuilder sb = new StringBuilder();
                sb.append("settings put secure location_providers_allowed gps");
                if (string.contains("network")) {
                    str = ",network";
                } else {
                    str = "";
                }
                sb.append(str);
                strArr[1] = sb.toString();
                Util.runAsRoot(strArr);
                return;
            }
            String[] strArr2 = new String[2];
            strArr2[0] = "settings put secure location_mode " + i4;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("settings put secure location_providers_allowed ");
            if (!string.contains("network")) {
                str2 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            sb2.append(str2);
            strArr2[1] = sb2.toString();
            Util.runAsRoot(strArr2);
            return;
        }
        int i6 = this.m_state;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    i5 = 0;
                }
            } else {
                i5 = 2;
            }
        } else {
            i5 = 1;
        }
        Intent intent = new Intent("com.arlosoft.macrodroid.SYSTEM_COMMAND");
        intent.putExtra("Command", i5);
        getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
    }

    public SetGPSAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetGPSAction() {
        this.m_state = 0;
    }

    private SetGPSAction(Parcel parcel) {
        super(parcel);
        this.m_state = parcel.readInt();
    }
}
