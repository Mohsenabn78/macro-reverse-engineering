package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.NotificationPresentConstraintInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NotificationPresentConstraint extends Constraint implements GetAppListTask.AppListListener, SupportsMagicText {
    private static final String ALL_APPLICATIONS_PACKAGE = "allApplications";
    public static final Parcelable.Creator<NotificationPresentConstraint> CREATOR = new c();
    private static final int OPTION_NOT_PRESENT = 1;
    private static final int OPTION_PRESENT = 0;
    private boolean enableRegex;
    private boolean ignoreCase;
    private boolean ignoreOngoing;
    private ArrayList<String> m_applicationNameList;
    private boolean m_exactMatch;
    private boolean m_excludes;
    private int m_excludesApps;
    private int m_option;
    private ArrayList<String> m_packageNameList;
    private String m_textContent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f10213a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f10214b;

        a(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f10213a = applicationAdapter;
            this.f10214b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f10213a.getFilter().filter(str, this.f10214b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<NotificationPresentConstraint> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotificationPresentConstraint createFromParcel(Parcel parcel) {
            return new NotificationPresentConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotificationPresentConstraint[] newArray(int i4) {
            return new NotificationPresentConstraint[i4];
        }
    }

    /* synthetic */ NotificationPresentConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void d0() {
        int i4;
        if (this.m_applicationNameList.size() > 0 && this.m_packageNameList.contains(ALL_APPLICATIONS_PACKAGE)) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(f0(), i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.l3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                NotificationPresentConstraint.this.k0(dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.constraint.m3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                NotificationPresentConstraint.this.l0(dialogInterface);
            }
        });
    }

    private void e0() {
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
        CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.notification_text_dialog_supress_multiples);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        if (this.m_option == 1) {
            radioButton4.setVisibility(8);
            if (this.m_excludes) {
                this.m_excludes = false;
            }
        }
        checkBox2.setEnabled(!this.enableRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox.setChecked(this.enableRegex);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.p3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                NotificationPresentConstraint.o0(checkBox2, compoundButton, z3);
            }
        });
        checkBox4.setVisibility(8);
        editText.setEnabled(false);
        checkBox3.setChecked(this.ignoreOngoing);
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
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.q3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                NotificationPresentConstraint.p0(editText, button, radioButton2, radioButton3, radioButton4, compoundButton, z3);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.r3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                NotificationPresentConstraint.q0(radioButton, radioButton3, radioButton4, compoundButton, z3);
            }
        });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.s3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                NotificationPresentConstraint.r0(radioButton2, radioButton, radioButton4, compoundButton, z3);
            }
        });
        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.t3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                NotificationPresentConstraint.s0(radioButton2, radioButton3, radioButton, compoundButton, z3);
            }
        });
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.u3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationPresentConstraint.this.t0(radioButton, editText, radioButton4, radioButton2, checkBox, checkBox2, checkBox3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.v3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.j3
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationPresentConstraint.m0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.k3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationPresentConstraint.this.n0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private String[] f0() {
        return new String[]{SelectableItem.r(R.string.select_applications), SelectableItem.r(R.string.trigger_notification_any_application)};
    }

    private boolean g0() {
        int i4 = this.m_excludesApps;
        if (i4 != -1) {
            if (i4 != 0) {
                return true;
            }
            return false;
        }
        return this.m_excludes;
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.constraint_notification_present), SelectableItem.r(R.string.constraint_notification_not_present)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(ApplicationAdapter applicationAdapter, RadioButton radioButton, AppCompatDialog appCompatDialog, View view) {
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
            this.m_excludesApps = radioButton.isChecked() ? 1 : 0;
            appCompatDialog.dismiss();
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(DialogInterface dialogInterface, int i4) {
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            this.m_packageNameList.removeAll(Collections.singletonList(ALL_APPLICATIONS_PACKAGE));
            this.m_applicationNameList.removeAll(Collections.singletonList(SelectableItem.r(R.string.all_applications)));
            v0();
            return;
        }
        this.m_packageNameList.clear();
        this.m_applicationNameList.clear();
        this.m_packageNameList.add(ALL_APPLICATIONS_PACKAGE);
        this.m_applicationNameList.add(SelectableItem.r(R.string.all_applications));
        e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, getDialogTheme(), isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        checkBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(EditText editText, Button button, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
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
    public static /* synthetic */ void q0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(RadioButton radioButton, EditText editText, RadioButton radioButton2, RadioButton radioButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, AppCompatDialog appCompatDialog, View view) {
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
        this.enableRegex = checkBox.isChecked();
        this.ignoreCase = checkBox2.isChecked();
        this.ignoreOngoing = checkBox3.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    private void v0() {
        new GetAppListTask(this, getActivity(), true, false, J()).execute((Object[]) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        if (checkActivityAlive() && z3) {
            c0(list);
        }
    }

    protected void c0(List<AppInfo> list) {
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
                ((RadioButton) appCompatDialog.findViewById(R.id.radio_include)).setChecked(true ^ g0());
                radioButton.setChecked(g0());
                final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, reorderSelectedAppsToTop, arrayList, null);
                ((ListView) appCompatDialog.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
                applicationAdapter.getFilter().filter((CharSequence) "", false);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.i3
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        NotificationPresentConstraint.h0(ApplicationAdapter.this, searchView, compoundButton, z4);
                    }
                });
                searchView.setOnQueryTextListener(new a(applicationAdapter, checkBox));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.n3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppCompatDialog.this.dismiss();
                    }
                });
                ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.o3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NotificationPresentConstraint.this.j0(applicationAdapter, radioButton, appCompatDialog, view);
                    }
                });
                appCompatDialog.show();
                appCompatDialog.getWindow().setAttributes(layoutParams);
                return;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        for (NotificationService.NotificationInfo notificationInfo : NotificationService.getNotifications(0, this.ignoreOngoing)) {
            Iterator<String> it = this.m_packageNameList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.equals(ALL_APPLICATIONS_PACKAGE) || notificationInfo.packageName.equals(next)) {
                    if (TextUtils.isEmpty(this.m_textContent)) {
                        if (this.m_option != 0) {
                            return false;
                        }
                        return true;
                    }
                    String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_textContent, triggerContextInfo, getMacro());
                    String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, this.enableRegex, this.ignoreCase);
                    String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, this.enableRegex, this.ignoreCase);
                    if (this.m_excludes) {
                        if (!WildCardHelper.matches(notificationInfo.title, regexContainsPattern, this.enableRegex, this.ignoreCase) && !WildCardHelper.matches(notificationInfo.text, regexContainsPattern, this.enableRegex, this.ignoreCase)) {
                            if (this.m_option != 0) {
                                return false;
                            }
                            return true;
                        }
                    } else if (this.m_exactMatch) {
                        if (WildCardHelper.matches(notificationInfo.title, regexPattern, this.enableRegex, this.ignoreCase) || WildCardHelper.matches(notificationInfo.text, regexPattern, this.enableRegex, this.ignoreCase)) {
                            if (this.m_option != 0) {
                                return false;
                            }
                            return true;
                        }
                    } else if (WildCardHelper.matches(notificationInfo.title, regexContainsPattern, this.enableRegex, this.ignoreCase) || WildCardHelper.matches(notificationInfo.text, regexContainsPattern, this.enableRegex, this.ignoreCase)) {
                        if (this.m_option != 0) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        if (this.m_option != 1) {
            return false;
        }
        return true;
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
        String replace;
        if (this.m_applicationNameList.size() > 0) {
            if (this.m_packageNameList.contains(ALL_APPLICATIONS_PACKAGE)) {
                replace = SelectableItem.r(R.string.all_applications);
            } else {
                replace = this.m_applicationNameList.toString().replace("[", "").replace("]", "");
            }
            String str = this.m_textContent;
            String str2 = " !(";
            if (str != null && str.length() != 0) {
                if (this.m_excludes) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(SelectableItem.r(R.string.trigger_notification_excludes));
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb.append(this.m_textContent);
                    if (!g0()) {
                        str2 = " (";
                    }
                    sb.append(str2);
                    sb.append(replace);
                    sb.append(")");
                    return sb.toString();
                } else if (this.m_exactMatch) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(SelectableItem.r(R.string.trigger_notification_matches));
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(this.m_textContent);
                    if (!g0()) {
                        str2 = " (";
                    }
                    sb2.append(str2);
                    sb2.append(replace);
                    sb2.append(")");
                    return sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(SelectableItem.r(R.string.trigger_notification_contains));
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb3.append(this.m_textContent);
                    if (!g0()) {
                        str2 = " (";
                    }
                    sb3.append(str2);
                    sb3.append(replace);
                    sb3.append(")");
                    return sb3.toString();
                }
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(SelectableItem.r(R.string.trigger_notification_any_content));
            if (!g0()) {
                str2 = " (";
            }
            sb4.append(str2);
            sb4.append(replace);
            sb4.append(")");
            return sb4.toString();
        }
        return SelectableItem.r(R.string.select_applications);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return NotificationPresentConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_textContent};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public boolean isIgnoreOngoing() {
        return this.ignoreOngoing;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.m_applicationNameList.size() != 0) {
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
    public boolean requiresNotificationAccess() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        d0();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_textContent = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeString(this.m_textContent);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeInt(this.m_exactMatch ? 1 : 0);
        parcel.writeInt(this.m_excludes ? 1 : 0);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.m_excludesApps);
        parcel.writeInt(this.ignoreOngoing ? 1 : 0);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public NotificationPresentConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private NotificationPresentConstraint() {
        this.ignoreCase = true;
        this.m_excludesApps = -1;
        this.ignoreOngoing = false;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        this.m_option = 0;
    }

    private NotificationPresentConstraint(Parcel parcel) {
        super(parcel);
        this.ignoreCase = true;
        this.m_excludesApps = -1;
        this.ignoreOngoing = false;
        this.m_option = parcel.readInt();
        this.m_textContent = parcel.readString();
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.m_exactMatch = parcel.readInt() != 0;
        this.m_excludes = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.m_excludesApps = parcel.readInt();
        this.ignoreOngoing = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f10216a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f10217b;

        b(Button button, EditText editText) {
            this.f10216a = button;
            this.f10217b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f10216a;
            if (this.f10217b.getText().length() > 0) {
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
