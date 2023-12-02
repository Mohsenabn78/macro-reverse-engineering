package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.RestoreNotificationsActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.arlosoft.macrodroid.utils.AppUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class RestoreNotificationsAction extends Action implements GetAppListTask.AppListListener {
    public static final Parcelable.Creator<RestoreNotificationsAction> CREATOR = new b();
    private static final int OPTION_CONTAINS = 2;
    private static final int OPTION_EXACT_MATCH = 1;
    private static final int OPTION_EXCLUDES = 3;
    private static final int OPTION_MATCH_ALL = 0;
    private static final int OPTION_RESTORE_ALL = 0;
    private static final int OPTION_SELECT_APPS = 1;
    private ArrayList<String> m_applicationNameList;
    private boolean m_excludes;
    private int m_option;
    private ArrayList<String> m_packageNameList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f2446a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f2447b;

        a(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f2446a = applicationAdapter;
            this.f2447b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f2446a.getFilter().filter(str, this.f2447b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<RestoreNotificationsAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RestoreNotificationsAction createFromParcel(Parcel parcel) {
            return new RestoreNotificationsAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RestoreNotificationsAction[] newArray(int i4) {
            return new RestoreNotificationsAction[i4];
        }
    }

    /* synthetic */ RestoreNotificationsAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void P(List<AppInfo> list) {
        List<AppInfo> reorderSelectedAppsToTop = AppUtils.reorderSelectedAppsToTop(list, this.m_packageNameList);
        ArrayList arrayList = new ArrayList(reorderSelectedAppsToTop.size());
        int i4 = 0;
        while (true) {
            boolean z3 = true;
            if (i4 < reorderSelectedAppsToTop.size()) {
                int i5 = 0;
                while (true) {
                    if (i5 < this.m_packageNameList.size()) {
                        if (this.m_packageNameList.get(i5).equals(reorderSelectedAppsToTop.get(i4).packageName)) {
                            break;
                        }
                        i5++;
                    } else {
                        z3 = false;
                        break;
                    }
                }
                arrayList.add(Boolean.valueOf(z3));
                i4++;
            } else {
                Activity activity = getActivity();
                final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
                appCompatDialog.setContentView(R.layout.dialog_app_chooser);
                appCompatDialog.setTitle(R.string.select_applications);
                final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.radio_exclude);
                CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.non_launchable_checkbox);
                final SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
                ((ViewGroup) appCompatDialog.findViewById(R.id.include_exclude_options)).setVisibility(0);
                ((RadioButton) appCompatDialog.findViewById(R.id.radio_include)).setChecked(true ^ this.m_excludes);
                radioButton.setChecked(this.m_excludes);
                final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, reorderSelectedAppsToTop, arrayList, null);
                ((ListView) appCompatDialog.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
                applicationAdapter.getFilter().filter((CharSequence) "", false);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.yg
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        RestoreNotificationsAction.Q(ApplicationAdapter.this, searchView, compoundButton, z4);
                    }
                });
                searchView.setOnQueryTextListener(new a(applicationAdapter, checkBox));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zg
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppCompatDialog.this.dismiss();
                    }
                });
                ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ah
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RestoreNotificationsAction.this.S(applicationAdapter, radioButton, appCompatDialog, view);
                    }
                });
                appCompatDialog.show();
                appCompatDialog.getWindow().setAttributes(layoutParams);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(ApplicationAdapter applicationAdapter, RadioButton radioButton, AppCompatDialog appCompatDialog, View view) {
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        List<AppInfo> checkedItems = applicationAdapter.getCheckedItems();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < checkedItems.size()) {
            AppInfo appInfo = checkedItems.get(i4);
            this.m_packageNameList.add(appInfo.packageName);
            this.m_applicationNameList.add(appInfo.applicationName);
            i4++;
            z3 = true;
        }
        if (z3) {
            this.m_excludes = radioButton.isChecked();
            appCompatDialog.dismiss();
            itemComplete();
        }
    }

    private void T(StatusBarNotification statusBarNotification) {
        NotificationService.restoreHiddenNotification(getContext(), statusBarNotification.getKey());
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_restore_hidden_notifications_restore_all), MacroDroidApplication.getInstance().getString(R.string.select_applications)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        if (checkActivityAlive() && z3) {
            P(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_option == 0) {
            return SelectableItem.r(R.string.all_applications);
        }
        return this.m_applicationNameList.toString().replace("[", "").replace("]", "");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return RestoreNotificationsActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    @RequiresApi(api = 26)
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4 = 0;
        if (this.m_option == 0) {
            if (!this.m_excludes) {
                StatusBarNotification[] hiddenNotifications = NotificationService.getHiddenNotifications();
                int length = hiddenNotifications.length;
                while (i4 < length) {
                    T(hiddenNotifications[i4]);
                    i4++;
                }
                return;
            }
            StatusBarNotification[] hiddenNotifications2 = NotificationService.getHiddenNotifications();
            int length2 = hiddenNotifications2.length;
            while (i4 < length2) {
                T(hiddenNotifications2[i4]);
                i4++;
            }
            return;
        }
        StatusBarNotification[] hiddenNotifications3 = NotificationService.getHiddenNotifications();
        ArrayList<StatusBarNotification> arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : hiddenNotifications3) {
            arrayList.add(statusBarNotification);
        }
        Iterator<String> it = this.m_packageNameList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (StatusBarNotification statusBarNotification2 : hiddenNotifications3) {
                if (statusBarNotification2.getPackageName().equals(next)) {
                    if (!this.m_excludes) {
                        T(statusBarNotification2);
                    } else {
                        arrayList.remove(statusBarNotification2);
                    }
                }
            }
        }
        if (this.m_excludes) {
            for (StatusBarNotification statusBarNotification3 : arrayList) {
                T(statusBarNotification3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresNotificationAccess() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_option == 0) {
            itemComplete();
        } else {
            new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getActivity(), R.color.actions_accent)).execute((Object[]) null);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeInt(this.m_excludes ? 1 : 0);
    }

    public RestoreNotificationsAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private RestoreNotificationsAction() {
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
    }

    private RestoreNotificationsAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.m_excludes = parcel.readInt() != 0;
    }
}
