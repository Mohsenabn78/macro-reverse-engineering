package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.HeadsUpNotificationsActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class HeadsUpNotificationsAction extends Action {
    public static final Parcelable.Creator<HeadsUpNotificationsAction> CREATOR = new a();
    private int option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<HeadsUpNotificationsAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public HeadsUpNotificationsAction createFromParcel(Parcel parcel) {
            return new HeadsUpNotificationsAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public HeadsUpNotificationsAction[] newArray(int i4) {
            return new HeadsUpNotificationsAction[i4];
        }
    }

    /* synthetic */ HeadsUpNotificationsAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.enable), SelectableItem.r(R.string.disable), SelectableItem.r(R.string.toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.action_heads_up) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getOptions()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return HeadsUpNotificationsActionInfo.getInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r6) {
        /*
            r5 = this;
            java.lang.String r6 = "heads_up_notifications_enabled"
            r0 = 1
            r1 = 0
            android.content.Context r2 = r5.getContext()     // Catch: android.provider.Settings.SettingNotFoundException -> L14
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: android.provider.Settings.SettingNotFoundException -> L14
            int r2 = android.provider.Settings.Global.getInt(r2, r6)     // Catch: android.provider.Settings.SettingNotFoundException -> L14
            if (r2 == 0) goto L14
            r2 = 1
            goto L15
        L14:
            r2 = 0
        L15:
            int r3 = r5.option
            if (r3 == r0) goto L20
            r4 = 2
            if (r3 == r4) goto L1e
            r2 = 1
            goto L21
        L1e:
            r2 = r2 ^ r0
            goto L21
        L20:
            r2 = 0
        L21:
            boolean r3 = com.arlosoft.macrodroid.root.RootToolsHelper.isAccessGiven()
            if (r3 != 0) goto L49
            android.content.Context r3 = r5.getContext()     // Catch: java.lang.Exception -> L38
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Exception -> L38
            if (r2 == 0) goto L32
            goto L33
        L32:
            r0 = 0
        L33:
            boolean r1 = android.provider.Settings.Global.putInt(r3, r6, r0)     // Catch: java.lang.Exception -> L38
            goto L39
        L38:
        L39:
            if (r1 != 0) goto L48
            java.lang.Long r6 = r5.getMacroGuid()
            long r0 = r6.longValue()
            java.lang.String r6 = "Could not set heads up status, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS"
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r6, r0)
        L48:
            return
        L49:
            if (r2 == 0) goto L55
            java.lang.String r6 = "settings put global heads_up_notifications_enabled 1"
            java.lang.String[] r6 = new java.lang.String[]{r6}
            com.arlosoft.macrodroid.common.Util.runAsRoot(r6)
            goto L5e
        L55:
            java.lang.String r6 = "settings put global heads_up_notifications_enabled 0"
            java.lang.String[] r6 = new java.lang.String[]{r6}
            com.arlosoft.macrodroid.common.Util.runAsRoot(r6)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.HeadsUpNotificationsAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.option);
    }

    public HeadsUpNotificationsAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private HeadsUpNotificationsAction() {
        this.option = 0;
    }

    private HeadsUpNotificationsAction(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }
}
