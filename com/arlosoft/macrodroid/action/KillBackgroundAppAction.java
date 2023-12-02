package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.ActivityManager;
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
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.KillBackgroundAppActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.AppUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class KillBackgroundAppAction extends Action implements GetAppListTask.AppListListener, SupportsMagicText {
    private static final String ALL_APPLICATIONS_PACKAGE = "all.applications";
    public static final Parcelable.Creator<KillBackgroundAppAction> CREATOR = new d();
    private static final int OPTION_KILL_ALL_APPS = 1;
    private static final int OPTION_KILL_BY_APP_CHOOSER = 0;
    private static final int OPTION_LAUNCH_BY_PACKAGE_NAME = 2;
    private String killByPackageName;
    private String m_applicationName;
    private ArrayList<String> m_applicationNameList;
    private ArrayList<String> m_packageNameList;
    private String m_packageToClose;
    private int option;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityManager f2276a;

        a(ActivityManager activityManager) {
            this.f2276a = activityManager;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            for (AppInfo appInfo : Util.getInstalledAppList(KillBackgroundAppAction.this.getContext(), false)) {
                if (appInfo != null && (str = appInfo.packageName) != null) {
                    try {
                        this.f2276a.killBackgroundProcesses(str);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f2278a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f2279b;

        b(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f2278a = applicationAdapter;
            this.f2279b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f2278a.getFilter().filter(str, this.f2279b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class d implements Parcelable.Creator<KillBackgroundAppAction> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public KillBackgroundAppAction createFromParcel(Parcel parcel) {
            return new KillBackgroundAppAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public KillBackgroundAppAction[] newArray(int i4) {
            return new KillBackgroundAppAction[i4];
        }
    }

    /* synthetic */ KillBackgroundAppAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T(List<AppInfo> list) {
        boolean z3;
        if (!checkActivityAlive()) {
            return;
        }
        String str = this.m_packageToClose;
        if (str != null && this.m_applicationName != null) {
            this.m_packageNameList.add(str);
            this.m_applicationNameList.add(this.m_applicationName);
        }
        List<AppInfo> reorderSelectedAppsToTop = AppUtils.reorderSelectedAppsToTop(list, this.m_packageNameList);
        this.m_packageToClose = null;
        this.m_applicationName = null;
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
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.p8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                KillBackgroundAppAction.V(ApplicationAdapter.this, searchView, compoundButton, z4);
            }
        });
        searchView.setOnQueryTextListener(new b(applicationAdapter, checkBox));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KillBackgroundAppAction.this.X(applicationAdapter, appCompatDialog, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    private static final String U() {
        return "[" + SelectableItem.r(R.string.all_applications) + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(ApplicationAdapter applicationAdapter, AppCompatDialog appCompatDialog, View view) {
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
    public /* synthetic */ void Y(AppCompatDialog appCompatDialog, EditText editText, View view) {
        appCompatDialog.dismiss();
        this.killByPackageName = editText.getText().toString();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    private void c0() {
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
        String str = this.killByPackageName;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(this.killByPackageName.length());
        }
        if (editText.getText().length() > 0) {
            button.setEnabled(true);
        }
        editText.addTextChangedListener(new c(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.s8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KillBackgroundAppAction.this.Y(appCompatDialog, editText, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.t8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.u8
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                KillBackgroundAppAction.a0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.v8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KillBackgroundAppAction.this.b0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private static final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.select_applications), SelectableItem.r(R.string.all_applications), SelectableItem.r(R.string.action_launch_activity_option_enter_package_name)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        if (checkActivityAlive() && z3) {
            T(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        Iterator<String> it = this.m_packageNameList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(ALL_APPLICATIONS_PACKAGE)) {
                return 1;
            }
        }
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.option == 2) {
            return this.killByPackageName;
        }
        String str = this.m_applicationName;
        if (str != null) {
            return str;
        }
        if (this.m_applicationNameList.size() > 1) {
            return this.m_applicationNameList.size() + " Apps";
        } else if (this.m_applicationNameList.size() == 1) {
            return this.m_applicationNameList.get(0);
        } else {
            return Util.SELECT_APP_NAME;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return KillBackgroundAppActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.killByPackageName};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        ActivityManager activityManager = (ActivityManager) MacroDroidApplication.getInstance().getSystemService("activity");
        if (this.option == 2) {
            try {
                activityManager.killBackgroundProcesses(MagicText.replaceMagicText(getContext(), this.killByPackageName, triggerContextInfo, getMacro()));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (this.m_packageToClose != null && this.m_packageNameList.size() == 0) {
            this.m_packageNameList.add(this.m_packageToClose);
            this.m_applicationNameList.add(this.m_applicationName);
            this.m_packageToClose = null;
            this.m_applicationName = null;
        }
        Iterator<String> it = this.m_packageNameList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (activityManager != null && next != null) {
                if (next.equals(ALL_APPLICATIONS_PACKAGE)) {
                    new a(activityManager).start();
                    return;
                }
                try {
                    activityManager.killBackgroundProcesses(next);
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        this.option = getCheckedItemIndex();
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.option;
        if (i4 == 1) {
            this.m_packageNameList.clear();
            this.m_applicationNameList.clear();
            this.m_packageNameList.add(ALL_APPLICATIONS_PACKAGE);
            this.m_applicationNameList.add(U());
            itemComplete();
        } else if (i4 == 0) {
            this.m_packageNameList.remove(ALL_APPLICATIONS_PACKAGE);
            this.m_applicationNameList.remove(U());
            new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getActivity(), R.color.actions_accent)).execute((Object[]) null);
        } else {
            c0();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.killByPackageName = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_packageToClose);
        parcel.writeString(this.m_applicationName);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeInt(this.option);
        parcel.writeString(this.killByPackageName);
    }

    public KillBackgroundAppAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private KillBackgroundAppAction() {
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
    }

    private KillBackgroundAppAction(Parcel parcel) {
        super(parcel);
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        this.m_packageToClose = parcel.readString();
        this.m_applicationName = parcel.readString();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.option = parcel.readInt();
        this.killByPackageName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2281a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2282b;

        c(Button button, EditText editText) {
            this.f2281a = button;
            this.f2282b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2281a;
            if (this.f2282b.getText().length() > 0) {
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
