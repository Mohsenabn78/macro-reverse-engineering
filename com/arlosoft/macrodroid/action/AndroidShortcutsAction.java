package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.AndroidShortcutsActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityServiceJellyBean;

/* loaded from: classes2.dex */
public class AndroidShortcutsAction extends Action {
    private static final int ACCESSIBILITY_TOGGLE = 4;
    public static final Parcelable.Creator<AndroidShortcutsAction> CREATOR = new a();
    private static final int GLOBAL_ACTION_RECENTS = 2;
    private static final int POWER_DIALOG = 1;
    private static final int QUICK_SETTINGS = 0;
    private static final int SHOW_ALL_APPS = 3;
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AndroidShortcutsAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AndroidShortcutsAction createFromParcel(Parcel parcel) {
            return new AndroidShortcutsAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AndroidShortcutsAction[] newArray(int i4) {
            return new AndroidShortcutsAction[i4];
        }
    }

    /* synthetic */ AndroidShortcutsAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return Build.VERSION.SDK_INT < 31 ? new String[]{SelectableItem.r(R.string.action_android_shortcuts_settings), SelectableItem.r(R.string.action_android_shortcuts_options), SelectableItem.r(R.string.action_android_shortcuts_recent)} : new String[]{SelectableItem.r(R.string.action_android_shortcuts_settings), SelectableItem.r(R.string.action_android_shortcuts_options), SelectableItem.r(R.string.action_android_shortcuts_recent), SelectableItem.r(R.string.action_android_shortcuts_all_apps), SelectableItem.r(R.string.action_android_shortcuts_accessibility_toggle)};
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
    public String getExtendedDetail() {
        try {
            return getOptions()[this.m_option];
        } catch (Exception unused) {
            return getOptions()[0];
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AndroidShortcutsActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Intent intent = new Intent(getContext(), MacroDroidAccessibilityServiceJellyBean.class);
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            SystemLog.logError("Invalid option: " + this.m_option, getMacroGuid().longValue());
                        } else {
                            intent.setAction(MacroDroidAccessibilityServiceJellyBean.ACTION_GLOBAL_CONTROL);
                            intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 13);
                        }
                    } else {
                        intent.setAction(MacroDroidAccessibilityServiceJellyBean.ACTION_GLOBAL_CONTROL);
                        intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 14);
                    }
                } else {
                    intent.setAction(MacroDroidAccessibilityServiceJellyBean.ACTION_GLOBAL_CONTROL);
                    intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 3);
                }
            } else {
                intent.setAction(MacroDroidAccessibilityServiceJellyBean.ACTION_GLOBAL_CONTROL);
                intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 6);
            }
        } else {
            intent.setAction(MacroDroidAccessibilityServiceJellyBean.ACTION_GLOBAL_CONTROL);
            intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 5);
        }
        getContext().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessibility() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public AndroidShortcutsAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AndroidShortcutsAction() {
    }

    private AndroidShortcutsAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
