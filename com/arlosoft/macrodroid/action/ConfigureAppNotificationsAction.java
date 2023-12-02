package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.ConfigureNotificationsStateActivity;
import com.arlosoft.macrodroid.action.info.ConfigureAppNotificationsActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.AppNotificationState;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.RootHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ConfigureAppNotificationsAction extends Action {
    public static final Parcelable.Creator<ConfigureAppNotificationsAction> CREATOR = new a();
    private static final int REQUEST_CODE_CONFIGURE_NOTIFICATIONS = 4422532;
    private final ArrayList<AppNotificationState> m_appList;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ConfigureAppNotificationsAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ConfigureAppNotificationsAction createFromParcel(Parcel parcel) {
            return new ConfigureAppNotificationsAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ConfigureAppNotificationsAction[] newArray(int i4) {
            return new ConfigureAppNotificationsAction[i4];
        }
    }

    /* synthetic */ ConfigureAppNotificationsAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(DialogInterface dialogInterface, int i4) {
        C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(DialogInterface dialogInterface, int i4) {
        secondaryItemConfirmed();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        Context context;
        int i4;
        if (this.m_appList.size() == 1) {
            StringBuilder sb = new StringBuilder();
            if (this.m_appList.get(0).getAppNotificationState() == 1) {
                context = getContext();
                i4 = R.string.enable;
            } else {
                context = getContext();
                i4 = R.string.disable;
            }
            sb.append(context.getString(i4));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.m_appList.get(0).getAppName());
            return sb.toString();
        }
        return this.m_appList.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.action_configure_app_notifications_apps);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ConfigureAppNotificationsActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE_CONFIGURE_NOTIFICATIONS && i5 != 0) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ConfigureNotificationsStateActivity.APP_NOTIFICATION_STATES_EXTRA);
            this.m_appList.clear();
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                AppNotificationState appNotificationState = (AppNotificationState) ((Parcelable) it.next());
                if (appNotificationState.getAppNotificationState() != 0) {
                    this.m_appList.add(appNotificationState);
                }
            }
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, ConfigureNotificationsStateActivity.class);
        intent.putExtra(ConfigureNotificationsStateActivity.APP_NOTIFICATION_STATES_EXTRA, this.m_appList);
        activity.startActivityForResult(intent, REQUEST_CODE_CONFIGURE_NOTIFICATIONS);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        try {
            int idForMethodInClass = RootHelper.getIdForMethodInClass("android.app.INotificationManager", "setNotificationsEnabledForPackage");
            Iterator<AppNotificationState> it = this.m_appList.iterator();
            while (it.hasNext()) {
                AppNotificationState next = it.next();
                if (next.getAppNotificationState() != 0) {
                    ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(next.getPackageName(), 0);
                    if (next.getAppNotificationState() == 2) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    Util.runAsRoot(new String[]{"service call notification " + idForMethodInClass + " s16 " + next.getPackageName() + " i32 " + applicationInfo.uid + " i32 " + str});
                }
            }
        } catch (Exception e4) {
            if (RootToolsHelper.isAccessGiven()) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Error invoking app notification on rooted device: " + e4.toString()));
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected AlertDialog l() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(getContext().getString(R.string.action_configure_app_notifications_configure));
        builder.setSingleChoiceItems(o(), getCheckedItemIndex(), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.w3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ConfigureAppNotificationsAction.this.x(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.x3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ConfigureAppNotificationsAction.this.y(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.y3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ConfigureAppNotificationsAction.this.z(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.z3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ConfigureAppNotificationsAction.this.A(dialogInterface);
            }
        });
        return create;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.m_appList);
    }

    public ConfigureAppNotificationsAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ConfigureAppNotificationsAction() {
        this.m_appList = new ArrayList<>();
    }

    private ConfigureAppNotificationsAction(Parcel parcel) {
        super(parcel);
        ArrayList<AppNotificationState> arrayList = new ArrayList<>();
        this.m_appList = arrayList;
        parcel.readTypedList(arrayList, AppNotificationState.CREATOR);
    }
}
