package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetPriorityModeInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.NotificationService;

/* loaded from: classes2.dex */
public class SetPriorityMode extends Action {
    public static final Parcelable.Creator<SetPriorityMode> CREATOR = new a();
    private static final int OPTION_PRIORITY_MODE_ALARM_ONLY = 3;
    private static final int OPTION_PRIORITY_MODE_ALL = 0;
    private static final int OPTION_PRIORITY_MODE_NONE = 2;
    private static final int OPTION_PRIORITY_MODE_PRIORITY = 1;
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetPriorityMode> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetPriorityMode createFromParcel(Parcel parcel) {
            return new SetPriorityMode(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetPriorityMode[] newArray(int i4) {
            return new SetPriorityMode[i4];
        }
    }

    /* synthetic */ SetPriorityMode(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] M() {
        return new String[]{SelectableItem.r(R.string.action_set_priority_mode_all), SelectableItem.r(R.string.action_set_priority_mode_priority), SelectableItem.r(R.string.action_set_priority_mode_none), SelectableItem.r(R.string.action_set_priority_mode_alarm_only)};
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_priority_mode_all), SelectableItem.r(R.string.action_set_priority_mode_priority), SelectableItem.r(R.string.action_set_priority_mode_none)};
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
        return M()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetPriorityModeInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                int i4 = this.m_option;
                if (i4 == 0) {
                    notificationManager.setInterruptionFilter(1);
                } else if (i4 == 1) {
                    notificationManager.setInterruptionFilter(2);
                } else if (i4 == 2) {
                    notificationManager.setInterruptionFilter(3);
                } else if (i4 == 3) {
                    notificationManager.setInterruptionFilter(4);
                }
                return;
            } catch (SecurityException unused) {
                PermissionsHelper.showNeedsSpecialPermission(getContext(), getConfiguredName(), 7);
                return;
            }
        }
        int i5 = this.m_option;
        if (i5 == 0) {
            Intent intent = new Intent(NotificationService.BROADCAST_SET_PRIORITY_MODE);
            intent.putExtra(NotificationService.EXTRA_INTERRUPTION_FILTER_TYPE, 1);
            getContext().sendBroadcast(intent);
        } else if (i5 == 1) {
            Intent intent2 = new Intent(NotificationService.BROADCAST_SET_PRIORITY_MODE);
            intent2.putExtra(NotificationService.EXTRA_INTERRUPTION_FILTER_TYPE, 2);
            getContext().sendBroadcast(intent2);
        } else if (i5 == 2) {
            Intent intent3 = new Intent(NotificationService.BROADCAST_SET_PRIORITY_MODE);
            intent3.putExtra(NotificationService.EXTRA_INTERRUPTION_FILTER_TYPE, 3);
            getContext().sendBroadcast(intent3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        if (Build.VERSION.SDK_INT >= 23) {
            return M();
        }
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessNotificationPolicy() {
        if (Settings.getIgnoreDoNotDisturb(getContext()) || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresNotificationAccess() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public SetPriorityMode(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetPriorityMode() {
    }

    private SetPriorityMode(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
