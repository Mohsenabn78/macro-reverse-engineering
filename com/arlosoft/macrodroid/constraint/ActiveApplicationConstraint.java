package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
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
import android.widget.RadioGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.ConfirmDialogActivity;
import com.arlosoft.macrodroid.action.activities.MessageDialogActivity;
import com.arlosoft.macrodroid.action.activities.OptionDialogActivity;
import com.arlosoft.macrodroid.action.activities.TakePictureActivity;
import com.arlosoft.macrodroid.action.activities.TorchActivity;
import com.arlosoft.macrodroid.action.activities.UpdateBrightnessActivity;
import com.arlosoft.macrodroid.action.activities.VariableValuePrompt;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.info.ActiveApplicationConstraintInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class ActiveApplicationConstraint extends Constraint implements GetAppListTask.AppListListener {
    public static final Parcelable.Creator<ActiveApplicationConstraint> CREATOR;
    public static final Set<String> EXCLUDE_CLASSES;
    private static final int OPTION_BY_APP_CHOOSER = 0;
    private static final int OPTION_BY_PACKAGE_NAME = 1;
    private static String cameraPackage;
    private String customPackageName;
    private boolean m_active;
    private String m_applicationName;
    private ArrayList<String> m_applicationNameList;
    private boolean m_foreground;
    private String m_packageName;
    private ArrayList<String> m_packageNameList;
    private transient int transientPackageNameOption;
    private int usePackageNameOption;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ComponentName resolveActivity = new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(MacroDroidApplication.getInstance().getPackageManager());
            if (resolveActivity != null) {
                String unused = ActiveApplicationConstraint.cameraPackage = resolveActivity.getPackageName();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f10147a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f10148b;

        c(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f10147a = applicationAdapter;
            this.f10148b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f10147a.getFilter().filter(str, this.f10148b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class d implements Parcelable.Creator<ActiveApplicationConstraint> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActiveApplicationConstraint createFromParcel(Parcel parcel) {
            return new ActiveApplicationConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ActiveApplicationConstraint[] newArray(int i4) {
            return new ActiveApplicationConstraint[i4];
        }
    }

    static {
        HashSet hashSet = new HashSet();
        EXCLUDE_CLASSES = hashSet;
        hashSet.add(UpdateBrightnessActivity.class.getCanonicalName());
        hashSet.add(VariableValuePrompt.class.getCanonicalName());
        hashSet.add(ConfirmDialogActivity.class.getCanonicalName());
        hashSet.add(MessageDialogActivity.class.getCanonicalName());
        hashSet.add(OptionDialogActivity.class.getCanonicalName());
        hashSet.add(TakePictureActivity.class.getCanonicalName());
        hashSet.add(TorchActivity.class.getCanonicalName());
        cameraPackage = "camera";
        new a().start();
        CREATOR = new d();
    }

    /* synthetic */ ActiveApplicationConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private boolean a0() {
        boolean z3;
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) getContext().getSystemService("activity")).getRunningServices(1000);
        try {
            if (Build.VERSION.SDK_INT < 24) {
                Process exec = Runtime.getRuntime().exec("/system/bin/ps");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                char[] cArr = new char[5000];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
                bufferedReader.close();
                exec.waitFor();
                String sb2 = sb.toString();
                if (sb2 != null) {
                    Iterator<String> it = this.m_packageNameList.iterator();
                    while (it.hasNext()) {
                        if (sb2.contains(it.next())) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
            } else {
                boolean z4 = false;
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    Iterator<String> it2 = this.m_packageNameList.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        String str = runningServiceInfo.process;
                        if (str != null && str.contains(next)) {
                            z4 = true;
                        }
                    }
                }
                z3 = z4;
            }
            if (z3 != this.m_active) {
                return false;
            }
            return true;
        } catch (IOException | InterruptedException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009e, code lost:
        if (r2.contains(r0.getPackageName()) != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @android.annotation.TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b0() {
        /*
            r8 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.Context r2 = r8.getContext()
            java.lang.String r3 = "usagestats"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.app.usage.UsageStatsManager r2 = (android.app.usage.UsageStatsManager) r2
            r3 = 43200000(0x2932e00, double:2.1343636E-316)
            long r3 = r0 - r3
            r5 = 0
            android.app.usage.UsageEvents r0 = r2.queryEvents(r3, r0)     // Catch: java.lang.Exception -> L1b
            goto L27
        L1b:
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r3 = r0 - r3
            android.app.usage.UsageEvents r0 = r2.queryEvents(r3, r0)     // Catch: java.lang.Exception -> L25
            goto L27
        L25:
            r0 = r5
        L27:
            r1 = 0
            if (r0 != 0) goto L2b
            return r1
        L2b:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L30:
            boolean r3 = r0.hasNextEvent()
            r4 = 1
            if (r3 == 0) goto L55
            android.app.usage.UsageEvents$Event r3 = new android.app.usage.UsageEvents$Event
            r3.<init>()
            r0.getNextEvent(r3)
            java.util.Set<java.lang.String> r6 = com.arlosoft.macrodroid.constraint.ActiveApplicationConstraint.EXCLUDE_CLASSES
            java.lang.String r7 = r3.getClassName()
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L30
            int r6 = r3.getEventType()
            if (r6 != r4) goto L30
            r2.add(r3)
            goto L30
        L55:
            int r0 = r2.size()
            if (r0 <= 0) goto L7f
            int r0 = r2.size()
            int r0 = r0 - r4
            java.lang.Object r0 = r2.get(r0)
            android.app.usage.UsageEvents$Event r0 = (android.app.usage.UsageEvents.Event) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Current active app package: "
            r2.append(r3)
            java.lang.String r3 = r0.getPackageName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logVerbose(r2)
            goto L80
        L7f:
            r0 = r5
        L80:
            if (r0 == 0) goto Ld5
            int r2 = r8.usePackageNameOption
            if (r2 != r4) goto La1
            com.arlosoft.macrodroid.app.MacroDroidApplication r2 = com.arlosoft.macrodroid.app.MacroDroidApplication.getInstance()
            java.lang.String r3 = r8.customPackageName
            com.arlosoft.macrodroid.macro.Macro r6 = r8.getMacro()
            java.lang.String r2 = com.arlosoft.macrodroid.common.MagicText.replaceMagicText(r2, r3, r5, r6)
            if (r2 == 0) goto Ld5
            java.lang.String r0 = r0.getPackageName()
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto Ld5
            goto Ld3
        La1:
            java.util.ArrayList<java.lang.String> r2 = r8.m_packageNameList
            java.util.Iterator r2 = r2.iterator()
        La7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Ld5
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto La7
            java.lang.String r5 = r0.getPackageName()
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto Ld3
            java.lang.String r5 = "com.android.camera"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto La7
            java.lang.String r3 = r0.getPackageName()
            java.lang.String r5 = com.arlosoft.macrodroid.constraint.ActiveApplicationConstraint.cameraPackage
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto La7
        Ld3:
            r0 = 1
            goto Ld6
        Ld5:
            r0 = 0
        Ld6:
            boolean r2 = r8.m_active
            if (r0 != r2) goto Ldb
            r1 = 1
        Ldb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.ActiveApplicationConstraint.b0():boolean");
    }

    private void d0() {
        this.transientPackageNameOption = this.usePackageNameOption;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(e0(), this.usePackageNameOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActiveApplicationConstraint.this.j0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActiveApplicationConstraint.this.k0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActiveApplicationConstraint.this.l0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.constraint.h
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ActiveApplicationConstraint.this.m0(dialogInterface);
            }
        });
    }

    private String[] e0() {
        return new String[]{SelectableItem.r(R.string.select_applications), SelectableItem.r(R.string.action_launch_activity_option_enter_package_name)};
    }

    private void f0() {
        new GetAppListTask(this, getActivity(), true, false, J()).execute((Object[]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(ApplicationAdapter applicationAdapter, AppCompatDialog appCompatDialog, View view) {
        int i4 = 0;
        this.usePackageNameOption = 0;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        List<AppInfo> checkedItems = applicationAdapter.getCheckedItems();
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

    private String[] getOptions() {
        String str;
        String[] strArr = new String[4];
        strArr[0] = MacroDroidApplication.getInstance().getString(R.string.constraint_active_application_running_in_foreground);
        strArr[1] = MacroDroidApplication.getInstance().getString(R.string.constraint_active_application_not_in_foreground);
        StringBuilder sb = new StringBuilder();
        sb.append(SelectableItem.r(R.string.constraint_active_application_alive_in_background));
        int i4 = Build.VERSION.SDK_INT;
        String str2 = "";
        if (i4 < 26) {
            str = "";
        } else {
            str = " (" + SelectableItem.r(R.string.not_functional_on_android_oreo) + ")";
        }
        sb.append(str);
        strArr[2] = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(MacroDroidApplication.getInstance().getString(R.string.constraint_active_application_not_running));
        if (i4 >= 26) {
            str2 = " (" + SelectableItem.r(R.string.not_functional_on_android_oreo) + ")";
        }
        sb2.append(str2);
        strArr[3] = sb2.toString();
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    private void init() {
        this.m_active = true;
        this.m_foreground = true;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(DialogInterface dialogInterface, int i4) {
        this.transientPackageNameOption = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i4) {
        if (this.transientPackageNameOption == 1) {
            r0();
        } else {
            f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(EditText editText, Activity activity, AppCompatDialog appCompatDialog, View view) {
        this.usePackageNameOption = 1;
        this.customPackageName = editText.getText().toString();
        if (PermissionsHelper.checkForSpecialPermissions(activity, this, true, false)) {
            appCompatDialog.dismiss();
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    private void r0() {
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
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveApplicationConstraint.this.n0(editText, activity, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.k
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ActiveApplicationConstraint.p0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveApplicationConstraint.this.q0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        boolean z4 = false;
        if (i4 != 0 && i4 != 2) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.m_active = z3;
        if (i4 < 2) {
            z4 = true;
        }
        this.m_foreground = z4;
    }

    public void addApplication(String str, String str2) {
        this.m_applicationNameList.add(str);
        this.m_packageNameList.add(str2);
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        if (checkActivityAlive() && z3) {
            c0(list);
        }
    }

    protected void c0(List<AppInfo> list) {
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
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                ActiveApplicationConstraint.h0(ApplicationAdapter.this, searchView, compoundButton, z4);
            }
        });
        searchView.setOnQueryTextListener(new c(applicationAdapter, checkBox));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveApplicationConstraint.this.g0(applicationAdapter, appCompatDialog, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        ActivityManager activityManager = (ActivityManager) getContext().getSystemService("activity");
        if (this.m_packageName != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.m_packageNameList = arrayList;
            arrayList.add(this.m_packageName);
        }
        if (this.m_foreground) {
            return b0();
        }
        return a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_foreground) {
            return !this.m_active ? 1 : 0;
        }
        if (this.m_active) {
            return 2;
        }
        return 3;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_foreground) {
            if (this.m_active) {
                return getContext().getString(R.string.constraint_active_application_extended_app_forground);
            }
            return getContext().getString(R.string.constraint_active_application_extended_not_forground);
        } else if (this.m_active) {
            return getContext().getString(R.string.constraint_active_application_extended_alive_bg);
        } else {
            return getContext().getString(R.string.constraint_active_application_extended_inactive);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.usePackageNameOption == 1) {
            return this.customPackageName;
        }
        String str = this.m_applicationName;
        if (str != null) {
            return str;
        }
        if (this.m_applicationNameList.size() > 1) {
            return this.m_applicationNameList.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.action_configure_app_notifications_apps);
        } else if (this.m_applicationNameList.size() == 1) {
            return this.m_applicationNameList.get(0);
        } else {
            return Util.SELECT_APP_NAME;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ActiveApplicationConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if ((this.usePackageNameOption == 1 && this.customPackageName != null) || this.m_applicationName != null || this.m_applicationNameList.size() != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUsageAccess() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        d0();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_active ? 1 : 0);
        parcel.writeInt(this.m_foreground ? 1 : 0);
        parcel.writeString(this.m_packageName);
        parcel.writeString(this.m_applicationName);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeString(this.customPackageName);
        parcel.writeInt(this.usePackageNameOption);
    }

    public ActiveApplicationConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ActiveApplicationConstraint() {
        init();
    }

    private ActiveApplicationConstraint(Parcel parcel) {
        super(parcel);
        init();
        this.m_active = parcel.readInt() != 0;
        this.m_foreground = parcel.readInt() != 0;
        this.m_packageName = parcel.readString();
        this.m_applicationName = parcel.readString();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.customPackageName = parcel.readString();
        this.usePackageNameOption = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f10144a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f10145b;

        b(Button button, EditText editText) {
            this.f10144a = button;
            this.f10145b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f10144a;
            if (this.f10145b.getText().length() > 0) {
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
