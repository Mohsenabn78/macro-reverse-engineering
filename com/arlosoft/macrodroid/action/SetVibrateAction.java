package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetVibrateActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;

/* loaded from: classes2.dex */
public class SetVibrateAction extends Action {
    public static final Parcelable.Creator<SetVibrateAction> CREATOR = new a();
    private static final int OPTION_DISABLE_VIBRATE_WHEN_RINGING = 3;
    private static final int OPTION_ENABLE_VIBRATE_WHEN_RINGING = 2;
    private static final int OPTION_SILENT_VIBRATE_ON = 0;
    private static final int OPTION_TOGGLE_VIBRATE_WHEN_RINGING = 4;
    private static final int OPTION_VIBRATE_ENABLE = 1;
    private String m_option;
    private int m_optionInt;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetVibrateAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetVibrateAction createFromParcel(Parcel parcel) {
            return new SetVibrateAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetVibrateAction[] newArray(int i4) {
            return new SetVibrateAction[i4];
        }
    }

    /* synthetic */ SetVibrateAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private int M() {
        String[] options = getOptions();
        for (int i4 = 0; i4 < options.length; i4++) {
            if (this.m_option.equals(options[i4])) {
                return i4;
            }
        }
        return 0;
    }

    private static String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_vibrate_silent_on), SelectableItem.r(R.string.action_set_vibrate_normal_off), SelectableItem.r(R.string.action_set_vibrate_enable_ringing), SelectableItem.r(R.string.action_set_vibrate_disable_ringing), SelectableItem.r(R.string.action_set_vibrate_toggle_ringing)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_optionInt = i4;
        this.m_option = getOptions()[i4];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4 = this.m_optionInt;
        if (i4 >= 0) {
            return i4;
        }
        return M();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_optionInt < 0) {
            this.m_optionInt = M();
        }
        return getOptions()[this.m_optionInt];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetVibrateActionInfo.getInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (android.provider.Settings.System.getInt(getContext().getContentResolver(), "vibrate_when_ringing", 0) == 0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0085  */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r6) {
        /*
            r5 = this;
            java.lang.String r6 = "vibrate_when_ringing"
            android.content.Context r0 = r5.getContext()
            java.lang.String r1 = "audio"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            if (r0 != 0) goto L1c
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r0 = "SetVibrateAction - audioManager is null"
            r6.<init>(r0)
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r6)
            return
        L1c:
            int r1 = r5.m_optionInt
            r2 = -1
            if (r1 != r2) goto L27
            int r1 = r5.M()
            r5.m_optionInt = r1
        L27:
            r1 = 0
            int r2 = r5.m_optionInt     // Catch: java.lang.SecurityException -> L67
            r3 = 1
            if (r2 == 0) goto L5d
            r4 = 2
            if (r2 == r3) goto L53
            if (r2 == r4) goto L51
            r0 = 3
            if (r2 == r0) goto L73
            r0 = 4
            if (r2 == r0) goto L43
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.SecurityException -> L67
            java.lang.String r2 = "Invalid vibrate option"
            r0.<init>(r2)     // Catch: java.lang.SecurityException -> L67
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r0)     // Catch: java.lang.SecurityException -> L67
            goto L73
        L43:
            android.content.Context r0 = r5.getContext()     // Catch: java.lang.SecurityException -> L67
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.SecurityException -> L67
            int r0 = android.provider.Settings.System.getInt(r0, r6, r1)     // Catch: java.lang.SecurityException -> L67
            if (r0 != 0) goto L73
        L51:
            r1 = 1
            goto L73
        L53:
            r0.setRingerMode(r4)     // Catch: java.lang.SecurityException -> L67
            r0.setVibrateSetting(r1, r1)     // Catch: java.lang.SecurityException -> L67
            r0.setVibrateSetting(r3, r1)     // Catch: java.lang.SecurityException -> L67
            return
        L5d:
            r0.setRingerMode(r3)     // Catch: java.lang.SecurityException -> L67
            r0.setVibrateSetting(r1, r3)     // Catch: java.lang.SecurityException -> L67
            r0.setVibrateSetting(r3, r3)     // Catch: java.lang.SecurityException -> L67
            return
        L67:
            android.content.Context r0 = r5.getContext()
            java.lang.String r2 = r5.getConfiguredName()
            r3 = 7
            com.arlosoft.macrodroid.permissions.PermissionsHelper.showNeedsSpecialPermission(r0, r2, r3)
        L73:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 != r2) goto L85
            android.content.Context r0 = r5.getContext()
            java.lang.String r2 = r5.getMacroName()
            com.arlosoft.macrodroid.utils.LegacySystemCommands.sendSystemCommandInt(r0, r6, r1, r2)
            goto L90
        L85:
            android.content.Context r0 = r5.getContext()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.provider.Settings.System.putInt(r0, r6, r1)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetVibrateAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.action_set_vibrate_set);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessNotificationPolicy() {
        if (Settings.getIgnoreDoNotDisturb(getContext()) || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLegacyHelperFile() {
        if (Build.VERSION.SDK_INT == 23 && this.m_optionInt > 1) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        if (Build.VERSION.SDK_INT > 23 && this.m_optionInt > 1) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_option);
        parcel.writeInt(this.m_optionInt);
    }

    public SetVibrateAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_optionInt = -1;
    }

    private SetVibrateAction() {
        this.m_option = getOptions()[0];
    }

    private SetVibrateAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readString();
        this.m_optionInt = parcel.readInt();
    }
}
