package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetDataActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.RootHelper;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class SetDataAction extends Action {
    public static final Parcelable.Creator<SetDataAction> CREATOR = new a();
    private int m_state;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetDataAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetDataAction createFromParcel(Parcel parcel) {
            return new SetDataAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetDataAction[] newArray(int i4) {
            return new SetDataAction[i4];
        }
    }

    /* synthetic */ SetDataAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(DialogInterface dialogInterface, int i4) {
        super.handleItemSelected();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void O(boolean r7) {
        /*
            r6 = this;
            r0 = 0
            android.content.Context r1 = r6.getContext()     // Catch: java.lang.Exception -> L3d
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L3d
            java.lang.String r2 = "mobile_data"
            r3 = 1
            if (r7 == 0) goto L10
            r4 = 1
            goto L11
        L10:
            r4 = 0
        L11:
            boolean r1 = android.provider.Settings.Global.putInt(r1, r2, r4)     // Catch: java.lang.Exception -> L3d
            android.content.Context r2 = r6.getContext()     // Catch: java.lang.Exception -> L3a
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Exception -> L3a
            java.lang.String r4 = "mobile_data1"
            if (r7 == 0) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = 0
        L24:
            boolean r1 = android.provider.Settings.Global.putInt(r2, r4, r5)     // Catch: java.lang.Exception -> L3a
            android.content.Context r2 = r6.getContext()     // Catch: java.lang.Exception -> L3a
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Exception -> L3a
            java.lang.String r4 = "mobile_data2"
            if (r7 == 0) goto L35
            r0 = 1
        L35:
            boolean r7 = android.provider.Settings.Global.putInt(r2, r4, r0)     // Catch: java.lang.Exception -> L3a
            goto L3f
        L3a:
            r0 = r1
            goto L3e
        L3d:
        L3e:
            r7 = r0
        L3f:
            if (r7 != 0) goto L4e
            java.lang.Long r7 = r6.getMacroGuid()
            long r0 = r7.longValue()
            java.lang.String r7 = "Could not set mobile data, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS"
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r7, r0)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetDataAction.O(boolean):void");
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_data_on), SelectableItem.r(R.string.action_set_data_off), SelectableItem.r(R.string.action_set_data_toggle)};
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
        return SetDataActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_data);
        builder.setMessage(R.string.action_set_data_help);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetDataAction.this.N(dialogInterface, i4);
            }
        });
        builder.show();
        Settings.setShownNotificationLightWarning(getContext(), true);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        int i4 = this.m_state;
        if (i4 != 0) {
            if (i4 == 2) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
                try {
                    Method declaredMethod = Class.forName(connectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                    declaredMethod.setAccessible(true);
                    z3 = !((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
                } catch (Exception unused) {
                }
            }
            z3 = false;
        } else {
            z3 = true;
        }
        if (!RootToolsHelper.isAccessGiven()) {
            O(z3);
            return;
        }
        int idForMethodInClass = RootHelper.getIdForMethodInClass("com.android.internal.telephony.ITelephony", "setDataEnabled");
        int i5 = Build.VERSION.SDK_INT;
        String str = "enable";
        String str2 = "1";
        if (i5 >= 23) {
            String[] strArr = new String[1];
            StringBuilder sb = new StringBuilder();
            sb.append("service call phone ");
            sb.append(idForMethodInClass);
            sb.append(" i32 0 i32 ");
            if (!z3) {
                str2 = "0";
            }
            sb.append(str2);
            strArr[0] = sb.toString();
            Util.runAsRoot(strArr);
            String[] strArr2 = new String[1];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("svc data ");
            if (!z3) {
                str = "disable";
            }
            sb2.append(str);
            strArr2[0] = sb2.toString();
            Util.runAsRoot(strArr2);
        } else if (i5 >= 22) {
            String[] strArr3 = new String[1];
            StringBuilder sb3 = new StringBuilder();
            sb3.append("service call phone ");
            sb3.append(idForMethodInClass);
            sb3.append(" i32 0 i32 ");
            if (!z3) {
                str2 = "0";
            }
            sb3.append(str2);
            strArr3[0] = sb3.toString();
            Util.runAsRoot(strArr3);
            String[] strArr4 = new String[1];
            StringBuilder sb4 = new StringBuilder();
            sb4.append("svc data ");
            if (!z3) {
                str = "disable";
            }
            sb4.append(str);
            strArr4[0] = sb4.toString();
            Util.runAsRoot(strArr4);
        } else {
            String[] strArr5 = new String[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("service call phone ");
            sb5.append(idForMethodInClass);
            sb5.append(" i32 ");
            if (!z3) {
                str2 = "0";
            }
            sb5.append(str2);
            strArr5[0] = sb5.toString();
            Util.runAsRoot(strArr5);
        }
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

    public SetDataAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetDataAction() {
        this.m_state = 0;
    }

    private SetDataAction(Parcel parcel) {
        super(parcel);
        this.m_state = parcel.readInt();
    }
}
