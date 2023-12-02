package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.USBTetheringActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class USBTetheringAction extends Action {
    public static final Parcelable.Creator<USBTetheringAction> CREATOR = new a();
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<USBTetheringAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public USBTetheringAction createFromParcel(Parcel parcel) {
            return new USBTetheringAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public USBTetheringAction[] newArray(int i4) {
            return new USBTetheringAction[i4];
        }
    }

    /* synthetic */ USBTetheringAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.on), SelectableItem.r(R.string.off), SelectableItem.r(R.string.toggle)};
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
        return SelectableItem.r(R.string.action_usb_tethering) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return USBTetheringActionInfo.getInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (((java.lang.String[]) r2.invoke(r6, new java.lang.Object[0])).length == 0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r6) {
        /*
            r5 = this;
            int r6 = r5.m_option
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L50
            r2 = 2
            if (r6 == r2) goto La
            goto L4e
        La:
            android.content.Context r6 = r5.getContext()
            java.lang.String r2 = "connectivity"
            java.lang.Object r6 = r6.getSystemService(r2)
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Exception -> L39
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L39
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Exception -> L39
            java.lang.String r3 = "getTetheredIfaces"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L39
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.Exception -> L39
            r2.setAccessible(r0)     // Catch: java.lang.Exception -> L39
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L39
            java.lang.Object r6 = r2.invoke(r6, r3)     // Catch: java.lang.Exception -> L39
            java.lang.String[] r6 = (java.lang.String[]) r6     // Catch: java.lang.Exception -> L39
            int r6 = r6.length     // Catch: java.lang.Exception -> L39
            if (r6 != 0) goto L4e
            goto L50
        L39:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "USB Tethering - could not determing if should enabled: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r6)
        L4e:
            r6 = 0
            goto L51
        L50:
            r6 = 1
        L51:
            java.lang.String r2 = "android.net.IConnectivityManager"
            java.lang.String r3 = "setUsbTethering"
            int r2 = com.arlosoft.macrodroid.utils.RootHelper.getIdForMethodInClass(r2, r3)
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "service call connectivity "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " i32 "
            r3.append(r2)
            if (r6 == 0) goto L72
            java.lang.String r6 = "1"
            goto L74
        L72:
            java.lang.String r6 = "0"
        L74:
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r0[r1] = r6
            com.arlosoft.macrodroid.common.Util.runAsRoot(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.USBTetheringAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void setState(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public USBTetheringAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public USBTetheringAction() {
        this.m_option = 0;
    }

    private USBTetheringAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
