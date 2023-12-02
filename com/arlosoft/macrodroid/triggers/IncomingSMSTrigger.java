package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.IncomingSMS;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.contacts.ContactSelectionListener;
import com.arlosoft.macrodroid.contacts.ContactsHelper;
import com.arlosoft.macrodroid.data.ContactGroup;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.IncomingSMSTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.IncomingSMSTriggerReceiver;
import com.arlosoft.macrodroid.triggers.services.SMSReceivedDetectService;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class IncomingSMSTrigger extends Trigger implements SupportsMagicText {
    public static final Parcelable.Creator<IncomingSMSTrigger> CREATOR = new d();
    public static final int OPTIONS_ANY_NUMBER = 3;
    public static final int OPTIONS_SELECT_GROUP = 1;
    public static final int OPTIONS_SELECT_NUMBER = 2;
    public static final int OPTION_SELECT_CONTACT = 0;
    private static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    public static final int SUBSCRIPTION_ID_ANY = -1;
    private static IncomingSMSTriggerReceiver s_incomingSMSTriggerReceiver;
    private static int s_triggerCounter;
    private boolean enableRegex;
    private boolean ignoreCase;
    private boolean isExcludeContact;
    private transient boolean lastValidCheck;
    private boolean m_exactMatch;
    private boolean m_excludes;
    private List<String> m_groupIdList;
    private List<String> m_groupNameList;
    private int m_option;
    private String m_smsContent;
    private Contact m_smsFrom;
    private List<Contact> m_smsFromList;
    private String m_smsNumber;
    private boolean m_smsNumberExclude;
    private int subscriptionId;
    private transient int workingOption;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ContactSelectionListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.contacts.ContactSelectionListener
        public void contactsSelected(@NonNull List<? extends Contact> list, boolean z3) {
            IncomingSMSTrigger.this.setContact(null);
            IncomingSMSTrigger.this.isExcludeContact = z3;
            IncomingSMSTrigger.this.m_smsFromList.clear();
            IncomingSMSTrigger.this.m_smsFromList.addAll(list);
            IncomingSMSTrigger.this.m_smsFrom = null;
            IncomingSMSTrigger.this.A0();
        }
    }

    /* loaded from: classes3.dex */
    class d implements Parcelable.Creator<IncomingSMSTrigger> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IncomingSMSTrigger createFromParcel(Parcel parcel) {
            return new IncomingSMSTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IncomingSMSTrigger[] newArray(int i4) {
            return new IncomingSMSTrigger[i4];
        }
    }

    /* synthetic */ IncomingSMSTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.IncomingSMSTrigger.A0():void");
    }

    private void B0() {
        List<Macro> enabledMacros = MacroStore.getInstance().getEnabledMacros();
        ArrayList<Trigger> arrayList = new ArrayList();
        for (Macro macro : enabledMacros) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof IncomingSMSTrigger) && next.f14431b) {
                    next.disableTriggerThreadSafe();
                    arrayList.add(next);
                }
            }
        }
        for (Trigger trigger : arrayList) {
            trigger.enableTriggerThreadSafe();
        }
    }

    private void C0() {
        new RxPermissions((FragmentActivity) getActivity()).request("android.permission.READ_CONTACTS").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.triggers.w3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingSMSTrigger.this.s0((Boolean) obj);
            }
        });
    }

    private void D0() {
        final List<ContactGroup> contactGroups = Util.getContactGroups(getContext());
        boolean[] zArr = new boolean[contactGroups.size()];
        String[] strArr = new String[contactGroups.size()];
        boolean z3 = false;
        for (int i4 = 0; i4 < contactGroups.size(); i4++) {
            strArr[i4] = contactGroups.get(i4).name;
            if (this.m_groupIdList.contains(contactGroups.get(i4).id)) {
                z3 = true;
                zArr[i4] = true;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_incoming_sms_from);
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.triggers.x3
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i5, boolean z4) {
                IncomingSMSTrigger.this.t0(contactGroups, dialogInterface, i5, z4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.y3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                IncomingSMSTrigger.this.u0(contactGroups, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        if (!z3) {
            create.getButton(-1).setEnabled(false);
        }
    }

    private void E0() {
        new RxPermissions((FragmentActivity) getActivity()).request("android.permission.READ_CONTACTS").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.triggers.z3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingSMSTrigger.this.v0((Boolean) obj);
            }
        });
    }

    private void F0() {
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.enter_number_dialog);
        appCompatDialog.setTitle(SelectableItem.r(R.string.select_number));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_number_dialog_phone_number);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.enter_number_dialog_magic_text_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.exclude_number);
        boolean z3 = false;
        checkBox.setVisibility(0);
        ((TextView) appCompatDialog.findViewById(R.id.wildcard_Text)).setVisibility(0);
        checkBox.setChecked(this.m_smsNumberExclude);
        String str = this.m_smsNumber;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        editText.addTextChangedListener(new b(button, editText));
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.a4
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                IncomingSMSTrigger.w0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.b4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IncomingSMSTrigger.this.x0(activity, magicTextListener, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.c4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IncomingSMSTrigger.this.y0(editText, checkBox, appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private int getOption() {
        int i4 = this.m_option;
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.select_contacts), SelectableItem.r(R.string.select_groups), SelectableItem.r(R.string.select_number), SelectableItem.r(R.string.any_number)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            super.handleItemSelected();
        }
    }

    private void init() {
        this.m_smsFromList = new ArrayList();
        this.m_groupIdList = new ArrayList();
        this.m_groupNameList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(EditText editText, Button button, Button button2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        editText.setEnabled(!z3);
        button.setEnabled(!z3);
        boolean z4 = false;
        if (!z3) {
            if (editText.getText().length() > 0) {
                z4 = true;
            }
            button2.setEnabled(z4);
            return;
        }
        button2.setEnabled(true);
        radioButton.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
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
    public /* synthetic */ void n0(RadioButton radioButton, EditText editText, RadioButton radioButton2, RadioButton radioButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, List list, Spinner spinner, AppCompatDialog appCompatDialog, View view) {
        if (radioButton.isChecked()) {
            this.m_smsContent = "";
            this.m_excludes = false;
        } else {
            this.m_smsContent = editText.getText().toString().trim();
            if (radioButton2.isChecked()) {
                this.m_excludes = true;
            } else {
                this.m_exactMatch = radioButton3.isChecked();
                this.m_excludes = false;
            }
        }
        this.enableRegex = checkBox.isChecked();
        this.ignoreCase = checkBox2.isChecked();
        if (Settings.getUseInboxIncomingSMS(getContext()) != checkBox3.isChecked()) {
            Settings.setUseInboxIncomingSMS(getContext(), checkBox3.isChecked());
            B0();
        }
        if (list.size() >= 1) {
            int selectedItemPosition = spinner.getSelectedItemPosition();
            if (selectedItemPosition == 0) {
                this.subscriptionId = -1;
            } else {
                this.subscriptionId = ((Integer) list.get(selectedItemPosition - 1)).intValue();
            }
        } else {
            this.subscriptionId = -1;
        }
        int i4 = this.workingOption;
        this.m_option = i4;
        if (i4 != 1) {
            this.m_groupIdList.clear();
            this.m_groupNameList.clear();
        }
        appCompatDialog.dismiss();
        itemComplete();
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
    public /* synthetic */ void q0(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(getActivity(), magicTextListener, getMacro(), false, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        checkBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            ContactsHelper.displayContactChooser(getActivity(), getDialogTheme(), getContactList(), this.m_smsFrom, this.isExcludeContact, false, false, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(List list, DialogInterface dialogInterface, int i4, boolean z3) {
        boolean z4;
        if (z3) {
            this.m_groupIdList.add(((ContactGroup) list.get(i4)).id);
            this.m_groupNameList.add(((ContactGroup) list.get(i4)).name);
        } else {
            this.m_groupIdList.remove(((ContactGroup) list.get(i4)).id);
            this.m_groupNameList.remove(((ContactGroup) list.get(i4)).name);
        }
        Button button = ((AlertDialog) dialogInterface).getButton(-1);
        if (this.m_groupIdList.size() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(List list, DialogInterface dialogInterface, int i4) {
        SparseBooleanArray checkedItemPositions = ((AlertDialog) dialogInterface).getListView().getCheckedItemPositions();
        this.m_groupIdList.clear();
        this.m_groupNameList.clear();
        for (int i5 = 0; i5 < checkedItemPositions.size(); i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                ContactGroup contactGroup = (ContactGroup) list.get(checkedItemPositions.keyAt(i5));
                this.m_groupIdList.add(contactGroup.id);
                this.m_groupNameList.add(contactGroup.name);
            }
        }
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            D0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(EditText editText, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        this.m_smsNumber = editText.getText().toString();
        this.m_smsNumberExclude = checkBox.isChecked();
        appCompatDialog.dismiss();
        A0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.workingOption = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @CallSuper
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        this.m_groupIdList = new ArrayList();
        this.m_groupNameList = new ArrayList();
        String str = this.m_smsNumber;
        if (str == null || (!str.startsWith("[") && !this.m_smsNumber.startsWith("{"))) {
            this.m_smsNumber = "123456789";
        }
        ArrayList arrayList = new ArrayList();
        for (Contact contact : this.m_smsFromList) {
            if (contact.getId().equals(Util.ANY_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.ANY_CONTACT_ID, Util.getAnyContactString(), Util.ANY_CONTACT_ID));
            } else if (contact.getId().equals(Util.ANY_NUMBER_ID)) {
                arrayList.add(0, new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
            } else if (contact.getId().equals(Util.NON_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.NON_CONTACT_ID, Util.getNonContactString(), Util.NON_CONTACT_ID));
            }
        }
        this.m_smsFromList = arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0119, code lost:
        r0 = ((android.telephony.SubscriptionManager) getContext().getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkOnImport() {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.IncomingSMSTrigger.checkOnImport():boolean");
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            MacroDroidApplication.getInstance().stopService(new Intent(getContext(), SMSReceivedDetectService.class));
            try {
                if (s_incomingSMSTriggerReceiver != null) {
                    MacroDroidApplication.getInstance().unregisterReceiver(s_incomingSMSTriggerReceiver);
                    s_incomingSMSTriggerReceiver = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            if (Settings.getUseInboxIncomingSMS(getContext())) {
                MacroDroidApplication.getInstance().startService(new Intent(getContext(), SMSReceivedDetectService.class));
            } else {
                s_incomingSMSTriggerReceiver = new IncomingSMSTriggerReceiver();
                IntentFilter intentFilter = new IntentFilter(SMS_RECEIVED_ACTION);
                intentFilter.setPriority(Integer.MAX_VALUE);
                MacroDroidApplication.getInstance().registerReceiver(s_incomingSMSTriggerReceiver, intentFilter);
            }
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int option = getOption();
        this.workingOption = option;
        if (option == 0) {
            List<Contact> contactList = getContactList();
            int i4 = 0;
            while (true) {
                if (i4 < contactList.size()) {
                    if (contactList.get(i4).getId().equals(Util.ANY_NUMBER_ID)) {
                        break;
                    }
                    i4++;
                } else {
                    i4 = -1;
                    break;
                }
            }
            if (i4 >= 0) {
                contactList.remove(i4);
                this.workingOption = 3;
                return 3;
            }
        }
        return this.workingOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int option = getOption();
        if (option == 3) {
            return SelectableItem.r(R.string.trigger_incoming_sms_from) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.any_number);
        }
        String str = "";
        if (option == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(SelectableItem.r(R.string.trigger_incoming_sms_from));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (this.m_smsNumberExclude) {
                str = "(" + SelectableItem.r(R.string.excludes) + ") ";
            }
            sb.append(str);
            sb.append(this.m_smsNumber);
            return sb.toString();
        } else if (option == 1) {
            if (this.m_groupNameList.size() == 1) {
                return SelectableItem.r(R.string.trigger_incoming_sms_from) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_groupNameList.get(0);
            }
            return SelectableItem.r(R.string.trigger_incoming_sms_from) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_groupNameList.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.groups);
        } else {
            String str2 = "!(";
            if (this.m_smsFrom != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(SelectableItem.r(R.string.trigger_incoming_sms_from));
                sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (!this.isExcludeContact) {
                    str2 = "";
                }
                sb2.append(str2);
                sb2.append(this.m_smsFrom.getName());
                if (this.isExcludeContact) {
                    str = ")";
                }
                sb2.append(str);
                return sb2.toString();
            } else if (this.m_smsFromList.size() == 1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(SelectableItem.r(R.string.trigger_incoming_sms_from));
                sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (!this.isExcludeContact) {
                    str2 = "";
                }
                sb3.append(str2);
                sb3.append(this.m_smsFromList.get(0).getName());
                if (this.isExcludeContact) {
                    str = ")";
                }
                sb3.append(str);
                return sb3.toString();
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(SelectableItem.r(R.string.trigger_incoming_sms_from));
                sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (!this.isExcludeContact) {
                    str2 = "";
                }
                sb4.append(str2);
                sb4.append(this.m_smsFromList.size());
                sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb4.append(SelectableItem.r(R.string.contacts));
                if (this.isExcludeContact) {
                    str = ")";
                }
                sb4.append(str);
                return sb4.toString();
            }
        }
    }

    public List<Contact> getContactList() {
        Contact contact;
        if (this.m_smsFromList.size() == 0 && (contact = this.m_smsFrom) != null) {
            this.m_smsFromList.add(contact);
        }
        return this.m_smsFromList;
    }

    public String getContent() {
        return this.m_smsContent;
    }

    public boolean getExcludeNumber() {
        return this.m_smsNumberExclude;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = this.m_smsContent;
        if (str != null && str.length() != 0) {
            if (this.m_excludes) {
                return SelectableItem.r(R.string.trigger_incoming_sms_excludes) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_smsContent;
            } else if (this.m_exactMatch) {
                return SelectableItem.r(R.string.trigger_incoming_sms_matches) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_smsContent;
            } else {
                return SelectableItem.r(R.string.trigger_incoming_sms_contains) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_smsContent;
            }
        }
        return SelectableItem.r(R.string.trigger_incoming_sms_any_content);
    }

    public List<String> getGroupIds() {
        return this.m_groupIdList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return IncomingSMSTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    public String getNumber() {
        return this.m_smsNumber;
    }

    public int getOptionType() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        int i4 = this.m_option;
        if (i4 != 0 && i4 != 1) {
            return new String[]{"android.permission.RECEIVE_SMS"};
        }
        return new String[]{"android.permission.RECEIVE_SMS", "android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        int i4 = this.m_option;
        if (i4 != 0 && i4 != 1) {
            return new String[0];
        }
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_smsContent};
    }

    public int getSubscriptionId() {
        return this.subscriptionId;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getTemplateConfiguredName() {
        return getName();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, new IncomingSMS("test contact name", "test message", "test from number"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int phoneCount;
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 23) {
            phoneCount = telephonyManager.getPhoneCount();
            if (phoneCount > 1) {
                new RxPermissions((FragmentActivity) getActivity()).request("android.permission.READ_PHONE_STATE").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.triggers.q3
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        IncomingSMSTrigger.this.i0((Boolean) obj);
                    }
                });
                return;
            }
        }
        super.handleItemSelected();
    }

    public boolean isEnableRegex() {
        return this.enableRegex;
    }

    public boolean isExactMatch() {
        return this.m_exactMatch;
    }

    public boolean isExcludeContact() {
        return this.isExcludeContact;
    }

    public boolean isExcludes() {
        return this.m_excludes;
    }

    public boolean isIgnoreCase() {
        return this.ignoreCase;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        int option = getOption();
        if (option == 0) {
            if (this.m_smsFrom == null && this.m_smsFromList.size() == 0) {
                return false;
            }
            Contact contact = this.m_smsFrom;
            if (contact != null && contact.getId().equals(Contact.SELECT_CONTACT_ID)) {
                return false;
            }
            return true;
        } else if (option != 1) {
            return true;
        } else {
            if (this.m_groupIdList.size() == 1) {
                boolean doesContactGroupExist = Util.doesContactGroupExist(getContext(), this.m_groupIdList.get(0));
                this.lastValidCheck = doesContactGroupExist;
                return doesContactGroupExist;
            } else if (this.m_groupIdList.size() == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.workingOption;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        A0();
                        return;
                    }
                    return;
                }
                F0();
                return;
            }
            E0();
            return;
        }
        C0();
    }

    public void setContact(Contact contact) {
        this.m_smsFrom = contact;
    }

    public void setExactMatch(boolean z3) {
        this.m_exactMatch = z3;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_smsContent = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    public void setSMSContent(String str) {
        this.m_smsContent = str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_smsFrom, i4);
        parcel.writeString(this.m_smsContent);
        parcel.writeInt(!this.m_exactMatch ? 1 : 0);
        Contact[] contactArr = new Contact[this.m_smsFromList.size()];
        this.m_smsFromList.toArray(contactArr);
        parcel.writeParcelableArray(contactArr, i4);
        parcel.writeInt(!this.m_excludes ? 1 : 0);
        parcel.writeInt(getOption());
        parcel.writeStringList(this.m_groupIdList);
        parcel.writeStringList(this.m_groupNameList);
        parcel.writeString(this.m_smsNumber);
        parcel.writeInt(this.m_smsNumberExclude ? 1 : 0);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.isExcludeContact ? 1 : 0);
        parcel.writeInt(this.subscriptionId);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public IncomingSMSTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public IncomingSMSTrigger() {
        this.workingOption = 0;
        this.m_option = -1;
        this.ignoreCase = true;
        this.subscriptionId = -1;
        this.lastValidCheck = true;
        this.m_smsFrom = null;
        init();
    }

    private IncomingSMSTrigger(Parcel parcel) {
        super(parcel);
        this.workingOption = 0;
        this.m_option = -1;
        this.ignoreCase = true;
        this.subscriptionId = -1;
        this.lastValidCheck = true;
        init();
        this.m_smsFrom = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.m_smsContent = parcel.readString();
        this.m_exactMatch = parcel.readInt() == 0;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(Contact.class.getClassLoader());
        if (readParcelableArray != null) {
            ArrayList arrayList = new ArrayList();
            this.m_smsFromList = arrayList;
            Collections.addAll(arrayList, (Contact[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, Contact[].class));
        }
        this.m_excludes = parcel.readInt() == 0;
        this.m_option = parcel.readInt();
        parcel.readStringList(this.m_groupIdList);
        parcel.readStringList(this.m_groupNameList);
        this.m_smsNumber = parcel.readString();
        this.m_smsNumberExclude = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.isExcludeContact = parcel.readInt() != 0;
        this.subscriptionId = parcel.readInt();
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14371a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14372b;

        b(Button button, EditText editText) {
            this.f14371a = button;
            this.f14372b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14371a;
            if (this.f14372b.getText().length() > 0) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14374a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14375b;

        c(Button button, EditText editText) {
            this.f14374a = button;
            this.f14375b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14374a;
            if (this.f14375b.getText().length() > 0) {
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
