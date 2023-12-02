package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.contacts.ContactSelectionListener;
import com.arlosoft.macrodroid.contacts.ContactsHelper;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.SMSSentTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.SMSSentDetectService;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SMSSentTrigger extends Trigger {
    public static final Parcelable.Creator<SMSSentTrigger> CREATOR = new c();
    private static int s_triggerCounter;
    private boolean ignoreCase;
    private boolean isExcludeContact;
    private Contact m_contact;
    private List<Contact> m_contactList;
    private boolean m_exactMatch;
    private boolean m_excludes;
    private String m_smsContent;
    private boolean useRegex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ContactSelectionListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.contacts.ContactSelectionListener
        public void contactsSelected(@NonNull List<? extends Contact> list, boolean z3) {
            SMSSentTrigger.this.setContact(null);
            SMSSentTrigger.this.isExcludeContact = z3;
            SMSSentTrigger.this.m_contactList.clear();
            SMSSentTrigger.this.m_contactList.addAll(list);
            SMSSentTrigger.this.m_contact = null;
            SMSSentTrigger.this.e0();
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<SMSSentTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SMSSentTrigger createFromParcel(Parcel parcel) {
            return new SMSSentTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SMSSentTrigger[] newArray(int i4) {
            return new SMSSentTrigger[i4];
        }
    }

    /* synthetic */ SMSSentTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        checkBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(EditText editText, Button button, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
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
    public static /* synthetic */ void Z(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(RadioButton radioButton, EditText editText, RadioButton radioButton2, RadioButton radioButton3, CheckBox checkBox, CheckBox checkBox2, AppCompatDialog appCompatDialog, View view) {
        if (radioButton.isChecked()) {
            this.m_smsContent = "";
        } else {
            this.m_smsContent = editText.getText().toString().trim();
            if (radioButton2.isChecked()) {
                this.m_excludes = true;
            } else {
                this.m_exactMatch = radioButton3.isChecked();
                this.m_excludes = false;
            }
        }
        this.useRegex = checkBox.isChecked();
        this.ignoreCase = checkBox2.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.sms_content_dialog);
        appCompatDialog.setTitle(R.string.trigger_incoming_sms_title);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.sms_content_dialog_text_content);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.sms_content_dialog_any_radio_button);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.sms_content_dialog_matches_radio_button);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.sms_content_dialog_contains_radio_button);
        final RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.sms_content_dialog_excludes_radio_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.ignore_case);
        editText.setEnabled(false);
        checkBox2.setEnabled(!this.useRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox.setChecked(this.useRegex);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.y6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SMSSentTrigger.X(checkBox2, compoundButton, z3);
            }
        });
        String str = this.m_smsContent;
        if (str != null && str.length() > 0) {
            radioButton.setChecked(false);
            editText.setText(this.m_smsContent);
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
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.z6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SMSSentTrigger.Y(editText, button, radioButton2, radioButton3, radioButton4, compoundButton, z3);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.a7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SMSSentTrigger.Z(radioButton, radioButton3, radioButton4, compoundButton, z3);
            }
        });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.b7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SMSSentTrigger.a0(radioButton2, radioButton, radioButton4, compoundButton, z3);
            }
        });
        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.c7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SMSSentTrigger.b0(radioButton2, radioButton3, radioButton, compoundButton, z3);
            }
        });
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.d7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SMSSentTrigger.this.c0(radioButton, editText, radioButton4, radioButton2, checkBox, checkBox2, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.e7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @CallSuper
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        ArrayList arrayList = new ArrayList();
        this.m_contact = null;
        for (Contact contact : this.m_contactList) {
            if (contact.getId().equals(Util.ANY_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.ANY_CONTACT_ID, Util.getAnyContactString(), Util.ANY_CONTACT_ID));
            } else if (contact.getId().equals(Util.ANY_NUMBER_ID)) {
                arrayList.add(0, new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
            } else if (contact.getId().equals(Util.NON_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.NON_CONTACT_ID, Util.getNonContactString(), Util.NON_CONTACT_ID));
            }
        }
        this.m_contactList = arrayList;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            MacroDroidApplication.getInstance().stopService(new Intent(getContext(), SMSSentDetectService.class));
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            MacroDroidApplication.getInstance().startService(new Intent(getContext(), SMSSentDetectService.class));
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str = ")";
        String str2 = " !(";
        if (this.m_contactList.size() == 0 && this.m_contact != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(SelectableItem.r(R.string.trigger_sms_sent_to));
            if (!this.isExcludeContact) {
                str2 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            sb.append(str2);
            sb.append(this.m_contact.getName());
            if (!this.isExcludeContact) {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        } else if (this.m_contactList.size() == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SelectableItem.r(R.string.trigger_sms_sent_to));
            if (!this.isExcludeContact) {
                str2 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            sb2.append(str2);
            sb2.append(this.m_contactList.get(0).getName());
            if (!this.isExcludeContact) {
                str = "";
            }
            sb2.append(str);
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(SelectableItem.r(R.string.trigger_sms_sent_to));
            if (!this.isExcludeContact) {
                str2 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            sb3.append(str2);
            sb3.append(this.m_contactList.size());
            sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb3.append(SelectableItem.r(R.string.contacts));
            if (!this.isExcludeContact) {
                str = "";
            }
            sb3.append(str);
            return sb3.toString();
        }
    }

    public List<Contact> getContactList() {
        Contact contact;
        if (this.m_contactList.size() == 0 && (contact = this.m_contact) != null) {
            this.m_contactList.add(contact);
        }
        return this.m_contactList;
    }

    public String getContent() {
        return this.m_smsContent;
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

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SMSSentTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_SMS"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        ContactsHelper.displayContactChooser(getActivity(), m(), getContactList(), this.m_contact, this.isExcludeContact, false, true, new a());
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

    public boolean isUseRegex() {
        return this.useRegex;
    }

    public void setContact(Contact contact) {
        this.m_contact = contact;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_contact, i4);
        parcel.writeString(this.m_smsContent);
        parcel.writeInt(this.m_exactMatch ? 1 : 0);
        parcel.writeInt(this.m_excludes ? 1 : 0);
        parcel.writeList(this.m_contactList);
        parcel.writeInt(this.isExcludeContact ? 1 : 0);
        parcel.writeInt(this.useRegex ? 1 : 0);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public SMSSentTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SMSSentTrigger() {
        this.ignoreCase = true;
        this.m_contactList = new ArrayList();
    }

    private SMSSentTrigger(Parcel parcel) {
        super(parcel);
        this.ignoreCase = true;
        this.m_contact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.m_smsContent = parcel.readString();
        this.m_exactMatch = parcel.readInt() != 0;
        this.m_excludes = parcel.readInt() != 0;
        ArrayList arrayList = new ArrayList();
        this.m_contactList = arrayList;
        parcel.readList(arrayList, Contact.class.getClassLoader());
        this.isExcludeContact = parcel.readInt() != 0;
        this.useRegex = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14411b;

        b(Button button, EditText editText) {
            this.f14410a = button;
            this.f14411b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14410a;
            if (this.f14411b.getText().length() > 0) {
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
