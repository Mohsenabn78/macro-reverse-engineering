package com.arlosoft.macrodroid.action;

import android.app.Activity;
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
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ClearAppDataActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
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
public class ClearAppDataAction extends Action implements GetAppListTask.AppListListener, SupportsMagicText {
    public static final Parcelable.Creator<ClearAppDataAction> CREATOR = new c();
    private static final int OPTION_CLEAR_BY_PACKAGE_NAME = 1;
    private static final int OPTION_LAUNCH_BY_APP_CHOOSER = 0;
    private String clearByPackageName;
    private ArrayList<String> m_applicationNameList;
    private ArrayList<String> m_packageNameList;
    private int option;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f2120a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f2121b;

        a(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f2120a = applicationAdapter;
            this.f2121b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f2120a.getFilter().filter(str, this.f2121b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<ClearAppDataAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ClearAppDataAction createFromParcel(Parcel parcel) {
            return new ClearAppDataAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ClearAppDataAction[] newArray(int i4) {
            return new ClearAppDataAction[i4];
        }
    }

    /* synthetic */ ClearAppDataAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T(List<AppInfo> list) {
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
        ((ViewGroup) appCompatDialog.findViewById(R.id.radio_options)).setVisibility(8);
        checkBox.setVisibility(0);
        final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, reorderSelectedAppsToTop, arrayList, null);
        ((ListView) appCompatDialog.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
        applicationAdapter.getFilter().filter((CharSequence) "", false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.a2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                ClearAppDataAction.V(ApplicationAdapter.this, searchView, compoundButton, z4);
            }
        });
        searchView.setOnQueryTextListener(new a(applicationAdapter, checkBox));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearAppDataAction.this.X(applicationAdapter, appCompatDialog, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    private String[] U() {
        return new String[]{SelectableItem.r(R.string.select_application), SelectableItem.r(R.string.action_launch_activity_option_enter_package_name)};
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
        this.clearByPackageName = editText.getText().toString();
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
        String str = this.clearByPackageName;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(this.clearByPackageName.length());
        }
        if (editText.getText().length() > 0) {
            button.setEnabled(true);
        }
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearAppDataAction.this.Y(appCompatDialog, editText, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.f2
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ClearAppDataAction.a0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearAppDataAction.this.b0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
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
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.option == 1) {
            return this.clearByPackageName;
        }
        return this.m_applicationNameList.toString().replace("[", "").replace("]", "");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ClearAppDataActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.clearByPackageName};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (this.option == 1) {
            String replaceMagicText = MagicText.replaceMagicText(getContext(), this.clearByPackageName, triggerContextInfo, getMacro());
            Util.runAsRoot(new String[]{"pm clear " + replaceMagicText});
            return;
        }
        Iterator<String> it = this.m_packageNameList.iterator();
        while (it.hasNext()) {
            Util.runAsRoot(new String[]{"pm clear " + it.next()});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.option == 0) {
            new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getActivity(), R.color.actions_accent)).execute((Object[]) null);
        } else {
            c0();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.clearByPackageName = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeInt(this.option);
        parcel.writeString(this.clearByPackageName);
    }

    public ClearAppDataAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ClearAppDataAction() {
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
    }

    private ClearAppDataAction(Parcel parcel) {
        super(parcel);
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.option = parcel.readInt();
        this.clearByPackageName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2123a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2124b;

        b(Button button, EditText editText) {
            this.f2123a = button;
            this.f2124b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2123a;
            if (this.f2124b.getText().length() > 0) {
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
