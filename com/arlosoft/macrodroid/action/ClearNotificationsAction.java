package com.arlosoft.macrodroid.action;

import android.app.Activity;
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
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ClearNotificationsActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ClearNotificationsAction extends Action implements GetAppListTask.AppListListener, SupportsMagicText {
    public static final Parcelable.Creator<ClearNotificationsAction> CREATOR = new d();
    private static final int OPTION_CLEAR_ALL = 0;
    private static final int OPTION_CONTAINS = 2;
    private static final int OPTION_EXACT_MATCH = 1;
    private static final int OPTION_EXCLUDES = 3;
    private static final int OPTION_MATCH_ALL = 0;
    private static final int OPTION_SELECT_APPS = 1;
    private boolean enableRegex;
    private boolean ignoreCase;
    private int m_ageInSeconds;
    private ArrayList<String> m_applicationNameList;
    private boolean m_clearPersistent;
    private boolean m_excludes;
    private int m_matchOption;
    private String m_matchText;
    private int m_option;
    private ArrayList<String> m_packageNameList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f2132a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f2133b;

        a(ApplicationAdapter applicationAdapter, CheckBox checkBox) {
            this.f2132a = applicationAdapter;
            this.f2133b = checkBox;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f2132a.getFilter().filter(str, this.f2133b.isChecked());
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CheckBox f2135a;

        b(CheckBox checkBox) {
            this.f2135a = checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f2135a.setEnabled(!z3);
        }
    }

    /* loaded from: classes2.dex */
    class d implements Parcelable.Creator<ClearNotificationsAction> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ClearNotificationsAction createFromParcel(Parcel parcel) {
            return new ClearNotificationsAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ClearNotificationsAction[] newArray(int i4) {
            return new ClearNotificationsAction[i4];
        }
    }

    /* synthetic */ ClearNotificationsAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void X(NotificationService.NotificationInfo notificationInfo, TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_matchText, triggerContextInfo, getMacro());
        String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, this.enableRegex, this.ignoreCase);
        String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, this.enableRegex, this.ignoreCase);
        int i4 = this.m_matchOption;
        if (i4 == 0) {
            NotificationService.clearActiveNotification(getContext(), notificationInfo, this.m_clearPersistent);
        } else if (i4 == 1) {
            if (WildCardHelper.matches(notificationInfo.title, regexPattern, this.enableRegex, this.ignoreCase) || WildCardHelper.matches(notificationInfo.text, regexPattern, this.enableRegex, this.ignoreCase)) {
                NotificationService.clearActiveNotification(getContext(), notificationInfo, this.m_clearPersistent);
            }
        } else if (i4 == 2) {
            if (WildCardHelper.matches(notificationInfo.title, regexContainsPattern, this.enableRegex, this.ignoreCase) || WildCardHelper.matches(notificationInfo.text, regexContainsPattern, this.enableRegex, this.ignoreCase)) {
                NotificationService.clearActiveNotification(getContext(), notificationInfo, this.m_clearPersistent);
            }
        } else if (i4 == 3 && !WildCardHelper.matches(notificationInfo.title, regexContainsPattern, this.enableRegex, this.ignoreCase) && !WildCardHelper.matches(notificationInfo.text, regexContainsPattern, this.enableRegex, this.ignoreCase)) {
            NotificationService.clearActiveNotification(getContext(), notificationInfo, this.m_clearPersistent);
        }
    }

    private void Y(List<AppInfo> list) {
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
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.p2
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        ClearNotificationsAction.a0(ApplicationAdapter.this, searchView, compoundButton, z4);
                    }
                });
                searchView.setOnQueryTextListener(new a(applicationAdapter, checkBox));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppCompatDialog.this.dismiss();
                    }
                });
                ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.s2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClearNotificationsAction.this.c0(applicationAdapter, radioButton, appCompatDialog, view);
                    }
                });
                appCompatDialog.show();
                appCompatDialog.getWindow().setAttributes(layoutParams);
                return;
            }
        }
    }

    private void Z() {
        int i4;
        Button button;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.notification_text_dialog);
        appCompatDialog.setTitle(R.string.action_clear_notifications);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.notification_text_dialog_text_content);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_any_radio_button);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_matches_radio_button);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_contains_radio_button);
        final RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_excludes_radio_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.ignore_case);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.notification_text_dialog_exclude_ongoing);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.hour_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.minute_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.second_picker);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        ((ViewGroup) appCompatDialog.findViewById(R.id.older_than_container)).setVisibility(0);
        int i5 = this.m_ageInSeconds;
        int i6 = i5 / 3600;
        int i7 = i6 * 3600;
        int i8 = (i5 - i7) / 60;
        numberPicker3.setValue((i5 - i7) - (i8 * 60));
        numberPicker2.setValue(i8);
        numberPicker.setValue(i6);
        numberPicker3.setMaximum(59);
        numberPicker2.setMaximum(59);
        numberPicker.setMaximum(999999);
        if (Build.VERSION.SDK_INT >= 26) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkBox3.setVisibility(i4);
        checkBox3.setChecked(!this.m_clearPersistent);
        editText.setText(this.m_matchText);
        checkBox2.setEnabled(!this.enableRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox.setChecked(this.enableRegex);
        checkBox.setOnCheckedChangeListener(new b(checkBox2));
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);
        radioButton.setChecked(false);
        int i9 = this.m_matchOption;
        if (i9 != 0) {
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        button = button2;
                    } else {
                        radioButton4.setChecked(true);
                        editText.setEnabled(true);
                        button = button2;
                        if (editText.length() > 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        button.setEnabled(z6);
                    }
                } else {
                    button = button2;
                    radioButton3.setChecked(true);
                    editText.setEnabled(true);
                    if (editText.length() > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    button.setEnabled(z5);
                }
            } else {
                button = button2;
                radioButton2.setChecked(true);
                editText.setEnabled(true);
                if (editText.length() > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                button.setEnabled(z4);
            }
        } else {
            button = button2;
            radioButton.setChecked(true);
            editText.setEnabled(false);
            button.setEnabled(false);
        }
        final Button button5 = button;
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.t2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                ClearNotificationsAction.e0(editText, button5, radioButton2, radioButton3, radioButton4, compoundButton, z7);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.u2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                ClearNotificationsAction.f0(radioButton, radioButton3, radioButton4, compoundButton, z7);
            }
        });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.v2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                ClearNotificationsAction.g0(radioButton2, radioButton, radioButton4, compoundButton, z7);
            }
        });
        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.w2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                ClearNotificationsAction.h0(radioButton2, radioButton3, radioButton, compoundButton, z7);
            }
        });
        editText.addTextChangedListener(new c(button, editText));
        Button button6 = button;
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearNotificationsAction.this.i0(radioButton, radioButton2, radioButton3, radioButton4, checkBox3, editText, numberPicker3, numberPicker2, numberPicker, checkBox, checkBox2, appCompatDialog, view);
            }
        });
        if (this.m_matchOption != 0 && radioButton.length() <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        button6.setEnabled(z3);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.z2
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ClearNotificationsAction.k0(editText, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearNotificationsAction.this.d0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(ApplicationAdapter applicationAdapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        applicationAdapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(ApplicationAdapter applicationAdapter, RadioButton radioButton, AppCompatDialog appCompatDialog, View view) {
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
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(EditText editText, Button button, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
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
    public static /* synthetic */ void f0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_clear_notifications_clear_all), MacroDroidApplication.getInstance().getString(R.string.select_applications)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, CheckBox checkBox, EditText editText, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, CheckBox checkBox2, CheckBox checkBox3, AppCompatDialog appCompatDialog, View view) {
        if (radioButton.isChecked()) {
            this.m_matchOption = 0;
        } else if (radioButton2.isChecked()) {
            this.m_matchOption = 1;
        } else if (radioButton3.isChecked()) {
            this.m_matchOption = 2;
        } else if (radioButton4.isChecked()) {
            this.m_matchOption = 3;
        }
        this.m_clearPersistent = !checkBox.isChecked();
        this.m_matchText = editText.getText().toString();
        this.m_ageInSeconds = numberPicker.getValue() + (numberPicker2.getValue() * 60) + (numberPicker3.getValue() * 3600);
        this.enableRegex = checkBox2.isChecked();
        this.ignoreCase = checkBox3.isChecked();
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        if (checkActivityAlive() && z3) {
            Y(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String replace;
        if (this.m_option == 0) {
            replace = SelectableItem.r(R.string.all_applications);
        } else {
            replace = this.m_applicationNameList.toString().replace("[", "").replace("]", "");
        }
        int i4 = this.m_matchOption;
        if (i4 == 0) {
            return SelectableItem.r(R.string.trigger_notification_any_content) + " (" + replace + ")";
        } else if (i4 == 3) {
            return SelectableItem.r(R.string.trigger_notification_excludes) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_matchText + " (" + replace + ")";
        } else if (i4 == 1) {
            return SelectableItem.r(R.string.trigger_notification_matches) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_matchText + " (" + replace + ")";
        } else {
            return SelectableItem.r(R.string.trigger_notification_contains) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_matchText + " (" + replace + ")";
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ClearNotificationsActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_matchText};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (this.m_option == 0) {
            if (!this.m_excludes) {
                for (NotificationService.NotificationInfo notificationInfo : NotificationService.getNotifications(this.m_ageInSeconds, false)) {
                    X(notificationInfo, triggerContextInfo);
                }
                return;
            }
            for (NotificationService.NotificationInfo notificationInfo2 : NotificationService.getNotifications(this.m_ageInSeconds, false)) {
                X(notificationInfo2, triggerContextInfo);
            }
            return;
        }
        List<NotificationService.NotificationInfo> notifications = NotificationService.getNotifications(this.m_ageInSeconds, false);
        ArrayList<NotificationService.NotificationInfo> arrayList = new ArrayList(notifications);
        Iterator<String> it = this.m_packageNameList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (NotificationService.NotificationInfo notificationInfo3 : notifications) {
                if (notificationInfo3.packageName.equals(next)) {
                    if (!this.m_excludes) {
                        X(notificationInfo3, triggerContextInfo);
                    } else {
                        arrayList.remove(notificationInfo3);
                    }
                }
            }
        }
        if (this.m_excludes) {
            for (NotificationService.NotificationInfo notificationInfo4 : arrayList) {
                X(notificationInfo4, triggerContextInfo);
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
            Z();
        } else {
            new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getActivity(), R.color.actions_accent)).execute((Object[]) null);
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_matchText = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeStringList(this.m_packageNameList);
        parcel.writeStringList(this.m_applicationNameList);
        parcel.writeInt(this.m_matchOption);
        parcel.writeString(this.m_matchText);
        parcel.writeInt(this.m_excludes ? 1 : 0);
        parcel.writeInt(this.m_ageInSeconds);
        parcel.writeInt(this.m_clearPersistent ? 1 : 0);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public ClearNotificationsAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ClearNotificationsAction() {
        this.ignoreCase = true;
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
    }

    private ClearNotificationsAction(Parcel parcel) {
        super(parcel);
        this.ignoreCase = true;
        this.m_option = parcel.readInt();
        this.m_packageNameList = new ArrayList<>();
        this.m_applicationNameList = new ArrayList<>();
        parcel.readStringList(this.m_packageNameList);
        parcel.readStringList(this.m_applicationNameList);
        this.m_matchOption = parcel.readInt();
        this.m_matchText = parcel.readString();
        this.m_excludes = parcel.readInt() != 0;
        this.m_ageInSeconds = parcel.readInt();
        this.m_clearPersistent = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2137a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2138b;

        c(Button button, EditText editText) {
            this.f2137a = button;
            this.f2138b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2137a;
            if (this.f2138b.getText().length() > 0) {
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
