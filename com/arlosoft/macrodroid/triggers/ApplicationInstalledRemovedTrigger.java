package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.ApplicationInstalledRemovedTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.ApplicationInstalledRemovedTriggerReceiver;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ApplicationInstalledRemovedTrigger extends Trigger implements GetAppListTask.AppListListener {
    private static ApplicationInstalledRemovedTriggerReceiver s_appInstallRemoveTriggerReceiver;
    private static int s_triggerCounter;
    private ArrayList<String> m_applicationNameList;
    private int m_applicationOption;
    private boolean m_installed;
    private ArrayList<String> m_packageNameList;
    private boolean m_updated;
    private static final String[] s_optionsApplications = {SelectableItem.r(R.string.trigger_notification_any_application), SelectableItem.r(R.string.select_applications)};
    public static final Parcelable.Creator<ApplicationInstalledRemovedTrigger> CREATOR = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f14318a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f14319b;

        a(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f14318a = applicationAdapter;
            this.f14319b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f14318a.getFilter().filter(str, this.f14319b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<ApplicationInstalledRemovedTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApplicationInstalledRemovedTrigger createFromParcel(Parcel parcel) {
            return new ApplicationInstalledRemovedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ApplicationInstalledRemovedTrigger[] newArray(int i4) {
            return new ApplicationInstalledRemovedTrigger[i4];
        }
    }

    /* synthetic */ ApplicationInstalledRemovedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(s_optionsApplications, this.m_applicationOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ApplicationInstalledRemovedTrigger.X(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ApplicationInstalledRemovedTrigger.this.Y(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.h
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ApplicationInstalledRemovedTrigger.this.Z(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(ApplicationAdapter applicationAdapter, AppCompatDialog appCompatDialog, View view) {
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
            appCompatDialog.dismiss();
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i4) {
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            this.m_applicationOption = 0;
            itemComplete();
            return;
        }
        this.m_applicationOption = 1;
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private void a0() {
        new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getActivity(), R.color.trigger_accent)).execute((Object[]) null);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_application_installed_removed_installed), SelectableItem.r(R.string.trigger_application_installed_removed_updated), SelectableItem.r(R.string.trigger_application_installed_removed_removed)};
    }

    private void init() {
        this.m_installed = true;
        this.m_updated = false;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        boolean z4 = false;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_installed = z3;
        if (i4 == 1) {
            z4 = true;
        }
        this.m_updated = z4;
    }

    protected void S(List<AppInfo> list) {
        boolean z3;
        List<AppInfo> reorderSelectedAppsToTop = AppUtils.reorderSelectedAppsToTop(list, this.m_packageNameList);
        ArrayList arrayList = new ArrayList(reorderSelectedAppsToTop.size());
        for (int i4 = 0; i4 < reorderSelectedAppsToTop.size(); i4++) {
            int i5 = 0;
            while (true) {
                if (i5 < this.m_packageNameList.size()) {
                    if (this.m_packageNameList.get(i5).equals(reorderSelectedAppsToTop.get(i4).packageName)) {
                        z3 = true;
                        break;
                    }
                    i5++;
                } else {
                    z3 = false;
                    break;
                }
            }
            arrayList.add(Boolean.valueOf(z3));
        }
        Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_app_chooser);
        appCompatDialog.setTitle(R.string.select_applications);
        CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.non_launchable_checkbox);
        final SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
        ((ViewGroup) appCompatDialog.findViewById(R.id.include_exclude_options)).setVisibility(0);
        ((RadioGroup) appCompatDialog.findViewById(R.id.radio_options)).setVisibility(8);
        final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, reorderSelectedAppsToTop, arrayList, null);
        ((ListView) appCompatDialog.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
        applicationAdapter.getFilter().filter((CharSequence) "", false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                ApplicationInstalledRemovedTrigger.U(ApplicationAdapter.this, searchView, compoundButton, z4);
            }
        });
        searchView.setOnQueryTextListener(new a(applicationAdapter, checkBox));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplicationInstalledRemovedTrigger.this.W(applicationAdapter, appCompatDialog, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        Iterator<AppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AppInfo next = it.next();
            if (next.packageName.equals(BuildConfig.APPLICATION_ID)) {
                list.remove(next);
                break;
            }
        }
        if (checkActivityAlive() && z3) {
            S(list);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_appInstallRemoveTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_appInstallRemoveTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_appInstallRemoveTriggerReceiver = new ApplicationInstalledRemovedTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            MacroDroidApplication.getInstance().registerReceiver(s_appInstallRemoveTriggerReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    public boolean getAnyApplication() {
        if (this.m_applicationOption == 0) {
            return true;
        }
        return false;
    }

    public boolean getApplicationInstalled() {
        return this.m_installed;
    }

    public boolean getApplicationUpdated() {
        return this.m_updated;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_updated) {
            return 1;
        }
        if (this.m_installed) {
            return 0;
        }
        return 2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_updated) {
            return getOptions()[1];
        }
        if (this.m_installed) {
            return getOptions()[0];
        }
        return getOptions()[2];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_applicationOption == 0) {
            return SelectableItem.r(R.string.trigger_notification_any_application);
        }
        return this.m_applicationNameList.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ApplicationInstalledRemovedTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String truncateListIfRequired;
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        sb.append(" (");
        if (this.m_applicationOption == 0) {
            truncateListIfRequired = SelectableItem.r(R.string.trigger_notification_any_application);
        } else {
            truncateListIfRequired = MDTextUtils.truncateListIfRequired(this.m_applicationNameList.toString(), 15);
        }
        sb.append(truncateListIfRequired);
        sb.append(")");
        return sb.toString();
    }

    public List<String> getPackageNameList() {
        return this.m_packageNameList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        String obj;
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        sb.append(" (");
        if (this.m_applicationOption == 0) {
            obj = SelectableItem.r(R.string.trigger_notification_any_application);
        } else {
            obj = this.m_applicationNameList.toString();
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, "com.test.package.name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        T();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_installed ? 1 : 0);
        parcel.writeInt(this.m_updated ? 1 : 0);
        parcel.writeInt(this.m_applicationOption);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
    }

    public ApplicationInstalledRemovedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ApplicationInstalledRemovedTrigger() {
        init();
    }

    private ApplicationInstalledRemovedTrigger(Parcel parcel) {
        super(parcel);
        init();
        this.m_installed = parcel.readInt() != 0;
        this.m_updated = parcel.readInt() != 0;
        this.m_applicationOption = parcel.readInt();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(DialogInterface dialogInterface, int i4) {
    }
}
