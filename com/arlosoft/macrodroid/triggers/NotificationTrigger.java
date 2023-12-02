package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.data.NotificationContextInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.NotificationTriggerInfo;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class NotificationTrigger extends Trigger implements GetAppListTask.AppListListener, SupportsMagicText {
    public static final String ANY_APPLICATION_FIXED = "Any Application";
    private static final int IGNORE_MULTIPLES_MS = 800;
    public static final int NOTIFICATION_CLEARED = 1;
    public static final int NOTIFICATION_RECEIVED = 0;
    public static final int SOUND_OPTION_ANY = 0;
    public static final int SOUND_OPTION_HAS_SOUND = 1;
    public static final int SOUND_OPTION_NONE = 2;
    private boolean enableRegex;
    private boolean ignoreCase;
    private transient long lastInvocation;
    private String m_applicationName;
    private ArrayList<String> m_applicationNameList;
    private boolean m_exactMatch;
    private boolean m_excludeApps;
    private boolean m_excludes;
    private boolean m_ignoreOngoing;
    private int m_option;
    private String m_packageName;
    private ArrayList<String> m_packageNameList;
    private int m_soundOption;
    private boolean m_supressMultiples;
    private String m_textContent;
    public static final String ANY_APPLICATION = SelectableItem.r(R.string.trigger_notification_any_application);
    public static final Parcelable.Creator<NotificationTrigger> CREATOR = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f14393a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f14394b;

        a(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f14393a = applicationAdapter;
            this.f14394b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f14393a.getFilter().filter(str, this.f14394b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CheckBox f14396a;

        b(CheckBox checkBox) {
            this.f14396a = checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f14396a.setEnabled(!z3);
        }
    }

    /* loaded from: classes3.dex */
    class d implements Parcelable.Creator<NotificationTrigger> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotificationTrigger createFromParcel(Parcel parcel) {
            return new NotificationTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotificationTrigger[] newArray(int i4) {
            return new NotificationTrigger[i4];
        }
    }

    /* synthetic */ NotificationTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void a0() {
        int i4;
        if (this.m_applicationNameList.size() > 0 && (this.m_packageNameList.contains(ANY_APPLICATION) || this.m_packageNameList.contains(ANY_APPLICATION_FIXED))) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(c0(), i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.x5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                NotificationTrigger.this.h0(dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.y5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                NotificationTrigger.this.i0(dialogInterface);
            }
        });
    }

    private void b0(final ArrayList<String> arrayList, final ArrayList<String> arrayList2, final boolean z3) {
        int i4;
        int i5;
        int i6;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.notification_text_dialog);
        appCompatDialog.setTitle(getOptions()[this.m_option]);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.notification_text_dialog_text_content);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_any_radio_button);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_matches_radio_button);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_contains_radio_button);
        final RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_excludes_radio_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.ignore_case);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.notification_text_dialog_exclude_ongoing);
        final CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.notification_text_dialog_supress_multiples);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.sound_options_container);
        final AppCompatSpinner appCompatSpinner = (AppCompatSpinner) appCompatDialog.findViewById(R.id.sound_option_spinner);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        if (this.m_option == 0) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkBox3.setVisibility(i4);
        checkBox3.setChecked(this.m_ignoreOngoing);
        if (this.m_option == 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        checkBox4.setVisibility(i5);
        checkBox4.setChecked(this.m_supressMultiples);
        checkBox2.setEnabled(!this.enableRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox.setChecked(this.enableRegex);
        checkBox.setOnCheckedChangeListener(new b(checkBox2));
        if (this.m_option == 0) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        viewGroup.setVisibility(i6);
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367048, new String[]{SelectableItem.r(R.string.notification_sound_any_value), SelectableItem.r(R.string.has_sound), SelectableItem.r(R.string.has_no_sound)});
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        appCompatSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        appCompatSpinner.setSelection(this.m_soundOption, false);
        editText.setEnabled(false);
        String str = this.m_textContent;
        if (str != null && str.length() > 0) {
            radioButton.setChecked(false);
            editText.setText(this.m_textContent);
            editText.setSelection(editText.length());
            editText.setEnabled(true);
            if (this.m_excludes) {
                radioButton4.setChecked(true);
            } else if (this.m_exactMatch) {
                radioButton2.setChecked(true);
            } else {
                radioButton3.setChecked(true);
            }
        } else {
            radioButton.setChecked(true);
        }
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.b6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                NotificationTrigger.k0(editText, button, radioButton2, radioButton3, radioButton4, compoundButton, z4);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.c6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                NotificationTrigger.l0(radioButton, radioButton3, radioButton4, compoundButton, z4);
            }
        });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.d6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                NotificationTrigger.m0(radioButton2, radioButton, radioButton4, compoundButton, z4);
            }
        });
        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.e6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                NotificationTrigger.n0(radioButton2, radioButton3, radioButton, compoundButton, z4);
            }
        });
        editText.addTextChangedListener(new c(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.f6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationTrigger.this.o0(radioButton, editText, radioButton4, radioButton2, checkBox4, z3, arrayList, arrayList2, checkBox3, appCompatSpinner, checkBox, checkBox2, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.g6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.h6
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationTrigger.q0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.w5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationTrigger.this.j0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private String[] c0() {
        return new String[]{SelectableItem.r(R.string.select_applications), SelectableItem.r(R.string.trigger_notification_any_application)};
    }

    private String d0(boolean z3) {
        int i4;
        String str = "!";
        if (!this.m_packageNameList.contains(ANY_APPLICATION) && !this.m_packageNameList.contains(ANY_APPLICATION_FIXED)) {
            if (this.m_applicationNameList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getConfiguredName());
                sb.append(" (");
                if (!this.m_excludeApps) {
                    str = "";
                }
                sb.append(str);
                String obj = this.m_applicationNameList.toString();
                if (z3) {
                    i4 = 150;
                } else {
                    i4 = 15;
                }
                sb.append(MDTextUtils.truncateListIfRequired(obj, i4));
                sb.append(")");
                return sb.toString();
            }
            return getConfiguredName() + " (" + SelectableItem.r(R.string.select_applications) + ")";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getConfiguredName());
        sb2.append(" (");
        if (!this.m_excludeApps) {
            str = "";
        }
        sb2.append(str);
        sb2.append(SelectableItem.r(R.string.all_applications));
        sb2.append(")");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(ApplicationAdapter applicationAdapter, AppCompatDialog appCompatDialog, RadioButton radioButton, View view) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        List<AppInfo> checkedItems = applicationAdapter.getCheckedItems();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < checkedItems.size()) {
            AppInfo appInfo = checkedItems.get(i4);
            arrayList.add(appInfo.packageName);
            arrayList2.add(appInfo.applicationName);
            i4++;
            z3 = true;
        }
        if (z3) {
            appCompatDialog.dismiss();
            b0(arrayList, arrayList2, radioButton.isChecked());
        }
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_notification_received), SelectableItem.r(R.string.trigger_notification_cleared)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            arrayList.addAll(this.m_packageNameList);
            arrayList2.addAll(this.m_applicationNameList);
            String str = ANY_APPLICATION;
            arrayList.removeAll(Collections.singletonList(str));
            arrayList2.removeAll(Collections.singletonList(str));
            arrayList.removeAll(Collections.singletonList(ANY_APPLICATION_FIXED));
            arrayList2.removeAll(Collections.singletonList(ANY_APPLICATION_FIXED));
            r0();
            return;
        }
        arrayList.add(ANY_APPLICATION_FIXED);
        arrayList2.add(ANY_APPLICATION_FIXED);
        b0(arrayList, arrayList2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private void init() {
        this.m_applicationName = null;
        this.m_packageName = null;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        this.m_ignoreOngoing = true;
        this.m_supressMultiples = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(EditText editText, Button button, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        editText.setEnabled(!z3);
        boolean z4 = true;
        if (!z3) {
            if (editText.getText().length() <= 0) {
                z4 = false;
            }
            button.setEnabled(z4);
            return;
        }
        button.setEnabled(true);
        radioButton.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(RadioButton radioButton, EditText editText, RadioButton radioButton2, RadioButton radioButton3, CheckBox checkBox, boolean z3, ArrayList arrayList, ArrayList arrayList2, CheckBox checkBox2, AppCompatSpinner appCompatSpinner, CheckBox checkBox3, CheckBox checkBox4, AppCompatDialog appCompatDialog, View view) {
        if (radioButton.isChecked()) {
            this.m_textContent = "";
            this.m_excludes = false;
        } else {
            this.m_textContent = editText.getText().toString().trim();
            if (radioButton2.isChecked()) {
                this.m_excludes = true;
            } else {
                this.m_exactMatch = radioButton3.isChecked();
                this.m_excludes = false;
            }
        }
        this.m_supressMultiples = checkBox.isChecked();
        this.m_excludeApps = z3;
        this.m_packageNameList = arrayList;
        this.m_applicationNameList = arrayList2;
        this.m_ignoreOngoing = checkBox2.isChecked();
        this.m_soundOption = appCompatSpinner.getSelectedItemPosition();
        this.enableRegex = checkBox3.isChecked();
        this.ignoreCase = checkBox4.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    private void r0() {
        new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getActivity(), R.color.trigger_accent)).execute((Object[]) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    protected void Z(List<AppInfo> list) {
        String str = this.m_packageName;
        if (str != null && this.m_applicationName != null) {
            this.m_packageNameList.add(str);
            this.m_applicationNameList.add(this.m_applicationName);
        }
        this.m_packageName = null;
        this.m_applicationName = null;
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
                ((RadioButton) appCompatDialog.findViewById(R.id.radio_include)).setChecked(true ^ this.m_excludeApps);
                radioButton.setChecked(this.m_excludeApps);
                final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, reorderSelectedAppsToTop, arrayList, null);
                ((ListView) appCompatDialog.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
                applicationAdapter.getFilter().filter((CharSequence) "", false);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.v5
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        NotificationTrigger.e0(ApplicationAdapter.this, searchView, compoundButton, z4);
                    }
                });
                searchView.setOnQueryTextListener(new a(applicationAdapter, checkBox));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.z5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppCompatDialog.this.dismiss();
                    }
                });
                ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.a6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NotificationTrigger.this.g0(applicationAdapter, appCompatDialog, radioButton, view);
                    }
                });
                appCompatDialog.show();
                appCompatDialog.getWindow().setAttributes(layoutParams);
                return;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        if (checkActivityAlive() && z3) {
            Z(list);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean constraintsMet(TriggerContextInfo triggerContextInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.m_supressMultiples && this.lastInvocation + 800 > currentTimeMillis) {
            return false;
        }
        return super.constraintsMet(triggerContextInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        String sb;
        String str2;
        if (this.m_applicationNameList.size() == 0 && (str2 = this.m_applicationName) != null) {
            this.m_applicationNameList.add(str2);
        }
        if (this.m_applicationNameList.size() > 0) {
            String str3 = "!";
            if (!this.m_packageNameList.contains(ANY_APPLICATION) && !this.m_packageNameList.contains(ANY_APPLICATION_FIXED)) {
                sb = this.m_applicationNameList.toString().replace("[", "").replace("]", "");
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (this.m_excludeApps) {
                    str = "!";
                } else {
                    str = "";
                }
                sb2.append(str);
                sb2.append(SelectableItem.r(R.string.all_applications));
                sb = sb2.toString();
            }
            String str4 = this.m_textContent;
            String str5 = "(";
            if (str4 != null && str4.length() != 0) {
                if (this.m_excludes) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(SelectableItem.r(R.string.trigger_notification_excludes));
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb3.append(this.m_textContent);
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (this.m_excludeApps) {
                        str5 = "!(";
                    }
                    sb3.append(str5);
                    sb3.append(sb);
                    sb3.append(")");
                    return sb3.toString();
                } else if (this.m_exactMatch) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(SelectableItem.r(R.string.trigger_notification_matches));
                    sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb4.append(this.m_textContent);
                    sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (this.m_excludeApps) {
                        str5 = "!(";
                    }
                    sb4.append(str5);
                    sb4.append(sb);
                    sb4.append(")");
                    return sb4.toString();
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(SelectableItem.r(R.string.trigger_notification_contains));
                    sb5.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb5.append(this.m_textContent);
                    sb5.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (this.m_excludeApps) {
                        str5 = "!(";
                    }
                    sb5.append(str5);
                    sb5.append(sb);
                    sb5.append(")");
                    return sb5.toString();
                }
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append(SelectableItem.r(R.string.trigger_notification_any_content));
            sb6.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (!this.m_excludeApps) {
                str3 = "";
            }
            sb6.append(str3);
            sb6.append("(");
            sb6.append(sb);
            sb6.append(")");
            return sb6.toString();
        }
        return SelectableItem.r(R.string.select_applications);
    }

    public boolean getIgnoreOngoing() {
        return this.m_ignoreOngoing;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return NotificationTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return d0(false);
    }

    public int getOption() {
        return this.m_option;
    }

    public List<String> getPackageNameList() {
        String str;
        if (this.m_packageNameList.size() == 0 && (str = this.m_packageName) != null) {
            this.m_packageNameList.add(str);
        }
        return this.m_packageNameList;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_textContent};
    }

    public int getSoundOption() {
        return this.m_soundOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return d0(true);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, new NotificationContextInfo("test body", "test app name", "test app package", "test app title", "test app text", "test big text", "test app lines", "test action names", "test subtitle", "test_key"));
    }

    public String getTextContent() {
        return this.m_textContent;
    }

    public boolean isEnableRegex() {
        return this.enableRegex;
    }

    public boolean isExactMatch() {
        return this.m_exactMatch;
    }

    public boolean isExclude() {
        return this.m_excludeApps;
    }

    public boolean isExcludes() {
        return this.m_excludes;
    }

    public boolean isIgnoreCase() {
        return this.ignoreCase;
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
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        a0();
    }

    public void setLastInvocationNow() {
        this.lastInvocation = System.currentTimeMillis();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_textContent = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    public void setTextContent(String str) {
        this.m_textContent = str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_textContent);
        parcel.writeInt(this.m_exactMatch ? 1 : 0);
        parcel.writeString(this.m_applicationName);
        parcel.writeString(this.m_packageName);
        parcel.writeInt(this.m_excludes ? 1 : 0);
        parcel.writeInt(this.m_ignoreOngoing ? 1 : 0);
        parcel.writeInt(this.m_option);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeInt(this.m_excludeApps ? 1 : 0);
        parcel.writeInt(this.m_soundOption);
        parcel.writeInt(this.m_supressMultiples ? 1 : 0);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public NotificationTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public NotificationTrigger() {
        this.ignoreCase = true;
        init();
    }

    private NotificationTrigger(Parcel parcel) {
        super(parcel);
        this.ignoreCase = true;
        init();
        this.m_textContent = parcel.readString();
        this.m_exactMatch = parcel.readInt() != 0;
        this.m_applicationName = parcel.readString();
        this.m_packageName = parcel.readString();
        this.m_excludes = parcel.readInt() != 0;
        this.m_ignoreOngoing = parcel.readInt() != 0;
        this.m_option = parcel.readInt();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.m_excludeApps = parcel.readInt() != 0;
        this.m_soundOption = parcel.readInt();
        this.m_supressMultiples = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14398a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14399b;

        c(Button button, EditText editText) {
            this.f14398a = button;
            this.f14399b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14398a;
            if (this.f14399b.getText().length() > 0) {
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
