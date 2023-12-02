package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.ApplicationLaunchedTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.RunningApplicationServiceV21;
import com.arlosoft.macrodroid.triggers.services.RunningApplicationServiceV22;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ApplicationLaunchedTrigger extends Trigger implements GetAppListTask.AppListListener, SupportsMagicText {
    private static final String MACRODROID_PACKAGE = "com.arlosoft.macrodroid";
    private static final int OPTION_BY_APP_CHOOSER = 0;
    private static final int OPTION_BY_PACKAGE_NAME = 1;
    private static final String PACKAGE_ANDROID_SYSTEM_UI = "com.android.systemui";
    private static final String PACKAGE_GOOGLE_QUICK_SEARCH_BOX = "com.google.android.googlequicksearchbox";
    private static boolean s_api21HackEnabled = false;
    private static int s_triggerCounter;
    private String customPackageName;
    private boolean isAllApps;
    private String m_applicationName;
    private ArrayList<String> m_applicationNameList;
    private transient boolean m_editing;
    private boolean m_launched;
    private String m_packageName;
    private ArrayList<String> m_packageNameList;
    private transient int transientPackageNameOption;
    private int usePackageNameOption;
    public static final Parcelable.Creator<ApplicationLaunchedTrigger> CREATOR = new c();
    private static PackageManager packageManager = MacroDroidApplication.getInstance().getPackageManager();
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f14324a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f14325b;

        b(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f14324a = applicationAdapter;
            this.f14325b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f14324a.getFilter().filter(str, this.f14325b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<ApplicationLaunchedTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApplicationLaunchedTrigger createFromParcel(Parcel parcel) {
            return new ApplicationLaunchedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ApplicationLaunchedTrigger[] newArray(int i4) {
            return new ApplicationLaunchedTrigger[i4];
        }
    }

    /* synthetic */ ApplicationLaunchedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A0(Macro macro) {
        macro.invokeActions(macro.getTriggerContextInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(EditText editText, Activity activity, AppCompatDialog appCompatDialog, View view) {
        this.m_editing = false;
        this.usePackageNameOption = 1;
        this.customPackageName = editText.getText().toString();
        if (PermissionsHelper.checkForSpecialPermissions(activity, this, true, false)) {
            appCompatDialog.dismiss();
            itemComplete();
        }
    }

    private void F0() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_package_name);
        appCompatDialog.setTitle(getContext().getString(R.string.action_launch_activity_option_enter_package_name));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!activity.getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.packageText);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magicTextButton);
        String str = this.customPackageName;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(this.customPackageName.length());
        }
        if (editText.getText().length() > 0) {
            button.setEnabled(true);
        }
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplicationLaunchedTrigger.this.D0(editText, activity, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.p
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ApplicationLaunchedTrigger.B0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplicationLaunchedTrigger.this.C0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private static void e0(boolean z3) {
        ArrayList<Macro> arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof ApplicationLaunchedTrigger) {
                    ApplicationLaunchedTrigger applicationLaunchedTrigger = (ApplicationLaunchedTrigger) next;
                    Iterator<String> it2 = applicationLaunchedTrigger.getPackageNameList().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (applicationLaunchedTrigger.getLaunched() == z3 && next2.equals(PACKAGE_GOOGLE_QUICK_SEARCH_BOX)) {
                                TriggerContextInfo m02 = m0(next, PACKAGE_GOOGLE_QUICK_SEARCH_BOX);
                                if (next.constraintsMet(m02)) {
                                    macro.setTriggerThatInvoked(next);
                                    macro.setTriggerContextInfo(m02);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Settings.setCurrentFgPackage(MacroDroidApplication.getInstance(), PACKAGE_GOOGLE_QUICK_SEARCH_BOX);
        if (arrayList.size() > 0) {
            for (final Macro macro2 : arrayList) {
                mainThreadHandler.post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApplicationLaunchedTrigger.n0(Macro.this);
                    }
                });
            }
        }
    }

    private static boolean f0(String str, String str2) {
        if (str2.contains(".")) {
            return str.contains(str2);
        }
        return str.matches(str2);
    }

    private void g0() {
        if (s_triggerCounter == 0) {
            if (Build.VERSION.SDK_INT == 21) {
                if (s_api21HackEnabled) {
                    getContext().stopService(new Intent(getContext(), RunningApplicationServiceV22.class));
                    return;
                } else {
                    getContext().stopService(new Intent(getContext(), RunningApplicationServiceV21.class));
                    return;
                }
            }
            getContext().stopService(new Intent(getContext(), RunningApplicationServiceV22.class));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ea, code lost:
        if (r7.getLaunched() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01f0, code lost:
        if (f0(r9, r3) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01f4, code lost:
        if (r7.isAllApps == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01f6, code lost:
        r9 = m0(r6, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01fe, code lost:
        if (r6.constraintsMet(r9) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0200, code lost:
        r4.setTriggerThatInvoked(r6);
        r4.setTriggerContextInfo(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x020e, code lost:
        if (r4.canInvoke(r4.getTriggerContextInfo()) == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0210, code lost:
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x01ab, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x01ab, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void handleWindowChanged(java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger.handleWindowChanged(java.lang.String, java.lang.String):void");
    }

    private void i0() {
        this.transientPackageNameOption = this.usePackageNameOption;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(k0(), this.usePackageNameOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ApplicationLaunchedTrigger.this.v0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ApplicationLaunchedTrigger.this.w0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ApplicationLaunchedTrigger.this.x0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ApplicationLaunchedTrigger.this.y0(dialogInterface);
            }
        });
    }

    private void j0() {
        int i4 = Build.VERSION.SDK_INT;
        if (s_triggerCounter == 0) {
            if (i4 == 21) {
                if (Settings.getAPI22AppLaunchTrigger(getContext())) {
                    getContext().startService(new Intent(getContext(), RunningApplicationServiceV22.class));
                    s_api21HackEnabled = true;
                    return;
                }
                getContext().startService(new Intent(getContext(), RunningApplicationServiceV21.class));
                s_api21HackEnabled = false;
                return;
            }
            getContext().startService(new Intent(getContext(), RunningApplicationServiceV22.class));
        }
    }

    private String[] k0() {
        return new String[]{SelectableItem.r(R.string.select_applications), SelectableItem.r(R.string.action_launch_activity_option_enter_package_name)};
    }

    private void l0() {
        new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getActivity(), R.color.trigger_accent)).execute((Object[]) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.arlosoft.macrodroid.triggers.TriggerContextInfo m0(com.arlosoft.macrodroid.triggers.Trigger r2, java.lang.String r3) {
        /*
            if (r3 == 0) goto La
            android.content.pm.PackageManager r0 = com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger.packageManager     // Catch: android.content.pm.PackageManager.NameNotFoundException -> La
            r1 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r3, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> La
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == 0) goto L14
            android.content.pm.PackageManager r1 = com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger.packageManager
            java.lang.CharSequence r0 = r1.getApplicationLabel(r0)
            goto L1b
        L14:
            r0 = 2131956013(0x7f13112d, float:1.954857E38)
            java.lang.String r0 = com.arlosoft.macrodroid.common.SelectableItem.r(r0)
        L1b:
            java.lang.String r0 = (java.lang.String) r0
            com.arlosoft.macrodroid.triggers.TriggerContextInfo r1 = new com.arlosoft.macrodroid.triggers.TriggerContextInfo
            r1.<init>(r2, r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger.m0(com.arlosoft.macrodroid.triggers.Trigger, java.lang.String):com.arlosoft.macrodroid.triggers.TriggerContextInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(Macro macro) {
        macro.invokeActions(macro.getTriggerContextInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(ApplicationAdapter applicationAdapter, Activity activity, AppCompatDialog appCompatDialog, View view) {
        this.m_editing = false;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        List<AppInfo> checkedItems = applicationAdapter.getCheckedItems();
        this.isAllApps = false;
        int i4 = 0;
        boolean z3 = false;
        while (i4 < checkedItems.size()) {
            AppInfo appInfo = checkedItems.get(i4);
            this.m_packageNameList.add(appInfo.packageName);
            this.m_applicationNameList.add(appInfo.applicationName);
            i4++;
            z3 = true;
        }
        if (z3 && PermissionsHelper.checkForSpecialPermissions(activity, this, true, false)) {
            this.usePackageNameOption = 0;
            appCompatDialog.dismiss();
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(AppCompatDialog appCompatDialog, View view) {
        this.m_editing = false;
        this.isAllApps = true;
        this.usePackageNameOption = 0;
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0(View view, CompoundButton compoundButton, boolean z3) {
        int i4;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(AppCompatDialog appCompatDialog, CheckBox checkBox, RadioButton radioButton, CheckBox checkBox2, View view) {
        Settings.setAppLaunchPreventNotifications(appCompatDialog.getContext(), checkBox.isChecked());
        this.m_launched = radioButton.isChecked();
        if (Settings.getForceLegacyAppLaunchTrigger(getContext()) != checkBox2.isChecked()) {
            ArrayList<Macro> arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next() instanceof ApplicationLaunchedTrigger) {
                            arrayList.add(macro);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            for (Macro macro2 : arrayList) {
                macro2.setEnabled(false);
            }
            Settings.setForceLegacyAppLaunchTrigger(getContext(), checkBox2.isChecked());
            for (Macro macro3 : arrayList) {
                macro3.setEnabled(true);
            }
            checkAllPermissions();
        }
        appCompatDialog.dismiss();
        secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(DialogInterface dialogInterface, int i4) {
        this.transientPackageNameOption = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(DialogInterface dialogInterface, int i4) {
        if (this.transientPackageNameOption == 1) {
            F0();
        } else {
            l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(DialogInterface dialogInterface, int i4) {
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_launched = z3;
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        if (checkActivityAlive() && z3) {
            h0(list);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            Settings.setCurrentFgPackage(MacroDroidApplication.getInstance(), "none");
        }
        if (Settings.getForceLegacyAppLaunchTrigger(getContext())) {
            g0();
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (Settings.getForceLegacyAppLaunchTrigger(getContext())) {
            j0();
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_launched ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_launched) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    public String getCustomPackageName() {
        return this.customPackageName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.usePackageNameOption == 1) {
            return this.customPackageName;
        }
        if (this.isAllApps) {
            return SelectableItem.r(R.string.all_applications);
        }
        String str = this.m_applicationName;
        if (str != null) {
            return str;
        }
        if (this.m_applicationNameList.size() > 1) {
            return this.m_applicationNameList.toString();
        }
        if (this.m_applicationNameList.size() == 1) {
            return this.m_applicationNameList.get(0);
        }
        return SelectableItem.r(R.string.select_app);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ApplicationLaunchedTriggerInfo.getInstance();
    }

    public boolean getIsAllApps() {
        return this.isAllApps;
    }

    public boolean getLaunched() {
        return this.m_launched;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        if (this.usePackageNameOption == 1) {
            return getConfiguredName() + " (" + this.customPackageName + ")";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        String str = this.m_applicationName;
        if (str == null) {
            if (this.m_applicationNameList.size() > 0) {
                str = " (" + MDTextUtils.truncateListIfRequired(this.m_applicationNameList.toString(), 15) + ")";
            } else {
                str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.select_app);
            }
        }
        sb.append(str);
        return sb.toString();
    }

    public String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_application_launched_app_launched), SelectableItem.r(R.string.trigger_application_launched_app_closed)};
    }

    public ArrayList<String> getPackageNameList() {
        if (this.m_packageName != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.m_packageName);
            return arrayList;
        }
        return this.m_packageNameList;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.customPackageName};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        if (this.usePackageNameOption == 1) {
            return getConfiguredName() + " (" + this.customPackageName + ")";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        String str = this.m_applicationName;
        if (str == null) {
            if (this.m_applicationNameList.size() > 0) {
                str = " (" + this.m_applicationNameList.toString() + ")";
            } else {
                str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.select_app);
            }
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean getUseCustomPackage() {
        if (this.usePackageNameOption == 1) {
            return true;
        }
        return false;
    }

    protected void h0(List<AppInfo> list) {
        boolean z3;
        if (!checkActivityAlive()) {
            return;
        }
        String str = this.m_packageName;
        if (str != null && this.m_applicationName != null) {
            this.m_packageNameList.add(str);
            this.m_applicationNameList.add(this.m_applicationName);
        }
        this.m_packageName = null;
        this.m_applicationName = null;
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
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_app_chooser);
        appCompatDialog.setTitle(R.string.select_applications);
        Button button = (Button) appCompatDialog.findViewById(R.id.allAppsButton);
        CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.non_launchable_checkbox);
        final SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
        button.setVisibility(0);
        ((ViewGroup) appCompatDialog.findViewById(R.id.include_exclude_options)).setVisibility(0);
        ((RadioGroup) appCompatDialog.findViewById(R.id.radio_options)).setVisibility(8);
        final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, reorderSelectedAppsToTop, arrayList, null);
        ((ListView) appCompatDialog.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
        applicationAdapter.getFilter().filter((CharSequence) "", false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.r
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                ApplicationLaunchedTrigger.o0(ApplicationAdapter.this, searchView, compoundButton, z4);
            }
        });
        searchView.setOnQueryTextListener(new b(applicationAdapter, checkBox));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplicationLaunchedTrigger.this.q0(applicationAdapter, activity, appCompatDialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplicationLaunchedTrigger.this.r0(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Build.VERSION.SDK_INT == 21 && Settings.getForceLegacyAppLaunchTrigger(getContext()) && !Settings.hasShown5_0AppLaunchWarning(getContext())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(R.string.trigger_application_launched);
            builder.setMessage(R.string.app_launched_5_0_warning);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.v
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ApplicationLaunchedTrigger.this.z0(dialogInterface, i4);
                }
            });
            builder.show();
            Settings.setShown5_0AppLaunchWarning(getContext(), true);
            return;
        }
        super.handleItemSelected();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if ((this.usePackageNameOption == 1 && this.customPackageName != null) || getPackageNameList().size() > 0 || this.isAllApps) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected AlertDialog l() {
        Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_app_launched_options);
        appCompatDialog.setTitle(R.string.select_option);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.app_launched_radio);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.app_closed_radio);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.force_legacy_setting);
        final View findViewById = appCompatDialog.findViewById(R.id.legacy_settings_view);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.prevent_notification_interrupt);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.prevent_notification_interrupt_description);
        int i4 = 8;
        if (Build.VERSION.SDK_INT == 21 && !Settings.getAPI22AppLaunchTrigger(activity)) {
            textView.setVisibility(8);
            checkBox2.setVisibility(8);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ApplicationLaunchedTrigger.s0(findViewById, compoundButton, z3);
            }
        });
        checkBox.setChecked(Settings.getForceLegacyAppLaunchTrigger(getContext()));
        if (Settings.getForceLegacyAppLaunchTrigger(getContext())) {
            i4 = 0;
        }
        findViewById.setVisibility(i4);
        checkBox2.setChecked(Settings.getAppLaunchPreventNotifications(activity));
        radioButton.setChecked(this.m_launched);
        radioButton2.setChecked(!this.m_launched);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplicationLaunchedTrigger.this.t0(appCompatDialog, checkBox2, radioButton, checkBox, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        this.m_editing = true;
        super.onItemSelected();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessibility() {
        if (!this.m_editing) {
            return !Settings.getForceLegacyAppLaunchTrigger(getContext());
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUsageAccess() {
        if (this.m_editing || !Settings.getForceLegacyAppLaunchTrigger(getContext())) {
            return false;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 22 && (i4 != 21 || !Settings.getAPI22AppLaunchTrigger(getContext()))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        i0();
    }

    public void setLaunched(boolean z3) {
        this.m_launched = z3;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.customPackageName = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_launched ? 1 : 0);
        parcel.writeString(this.m_packageName);
        parcel.writeString(this.m_applicationName);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeString(this.customPackageName);
        parcel.writeInt(this.usePackageNameOption);
        parcel.writeInt(this.isAllApps ? 1 : 0);
    }

    public ApplicationLaunchedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ApplicationLaunchedTrigger() {
        this.m_launched = true;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
    }

    private ApplicationLaunchedTrigger(Parcel parcel) {
        super(parcel);
        this.m_launched = parcel.readInt() != 0;
        this.m_packageName = parcel.readString();
        this.m_applicationName = parcel.readString();
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.customPackageName = parcel.readString();
        this.usePackageNameOption = parcel.readInt();
        this.isAllApps = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14321a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14322b;

        a(Button button, EditText editText) {
            this.f14321a = button;
            this.f14322b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14321a;
            if (this.f14322b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
