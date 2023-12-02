package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.contacts.ContactSelectionListener;
import com.arlosoft.macrodroid.contacts.ContactsHelper;
import com.arlosoft.macrodroid.data.ContactGroup;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class CallBasedTrigger extends Trigger {
    public static final int OPTIONS_ANY_NUMBER = 3;
    public static final int OPTIONS_SELECT_GROUP = 1;
    public static final int OPTIONS_SPECIFY_NUMBER = 2;
    private static final int OPTION_SELECT_CONTACT = 0;
    private boolean isExclude;
    private List<String> m_groupIdList;
    private List<String> m_groupNameList;
    private int m_option;
    private String m_phoneNumber;
    private boolean m_phoneNumberExclude;
    private transient int workingOption;

    /* loaded from: classes3.dex */
    class a implements ContactSelectionListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.contacts.ContactSelectionListener
        public void contactsSelected(@NonNull List<? extends Contact> list, boolean z3) {
            CallBasedTrigger.this.setContact(null);
            CallBasedTrigger.this.isExclude = z3;
            CallBasedTrigger callBasedTrigger = CallBasedTrigger.this;
            callBasedTrigger.m_option = callBasedTrigger.workingOption;
            List<Contact> contactList = CallBasedTrigger.this.getContactList();
            contactList.clear();
            contactList.addAll(list);
            CallBasedTrigger.this.itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallBasedTrigger() {
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(DialogInterface dialogInterface, int i4, boolean z3) {
        boolean z4;
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        Button button = alertDialog.getButton(-1);
        if (alertDialog.getListView().getCheckedItemCount() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(List list, DialogInterface dialogInterface, int i4) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.getListView().getCheckedItemPositions();
        SparseBooleanArray checkedItemPositions = alertDialog.getListView().getCheckedItemPositions();
        this.m_groupIdList.clear();
        this.m_groupNameList.clear();
        for (int i5 = 0; i5 < checkedItemPositions.size(); i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                this.m_groupIdList.add(((ContactGroup) list.get(checkedItemPositions.keyAt(i5))).id);
                this.m_groupNameList.add(((ContactGroup) list.get(checkedItemPositions.keyAt(i5))).name);
            }
        }
        this.m_option = this.workingOption;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(EditText editText, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        this.m_phoneNumber = editText.getText().toString();
        this.m_phoneNumberExclude = checkBox.isChecked();
        appCompatDialog.dismiss();
        this.m_option = this.workingOption;
        itemComplete();
    }

    private void b0() {
        final List<ContactGroup> contactGroups = Util.getContactGroups(getContext());
        boolean[] zArr = new boolean[contactGroups.size()];
        String[] strArr = new String[contactGroups.size()];
        boolean z3 = false;
        for (int i4 = 0; i4 < contactGroups.size(); i4++) {
            if (contactGroups.get(i4).name != null) {
                strArr[i4] = contactGroups.get(i4).name;
                if (this.m_groupIdList.contains(contactGroups.get(i4).id)) {
                    z3 = true;
                    zArr[i4] = true;
                }
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_groups);
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.triggers.r1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i5, boolean z4) {
                CallBasedTrigger.V(dialogInterface, i5, z4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                CallBasedTrigger.this.W(contactGroups, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        if (!z3) {
            create.getButton(-1).setEnabled(false);
        }
    }

    private void c0() {
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
        checkBox.setChecked(this.m_phoneNumberExclude);
        String str = this.m_phoneNumber;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        editText.addTextChangedListener(new b(button, editText));
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.t1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CallBasedTrigger.X(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallBasedTrigger.this.Y(activity, magicTextListener, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallBasedTrigger.this.Z(editText, checkBox, appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.select_contacts), SelectableItem.r(R.string.select_groups), SelectableItem.r(R.string.select_number), SelectableItem.r(R.string.any_number)};
    }

    private void init() {
        this.m_groupIdList = new ArrayList();
        this.m_groupNameList = new ArrayList();
        this.workingOption = this.m_option;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.workingOption = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        this.m_groupIdList = new ArrayList();
        this.m_groupNameList = new ArrayList();
        String str = this.m_phoneNumber;
        if (str == null || (!str.startsWith("[") && !this.m_phoneNumber.startsWith("{"))) {
            this.m_phoneNumber = "123456789";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkOnImport() {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.CallBasedTrigger.checkOnImport():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.workingOption == 0) {
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

    abstract Contact getContact();

    public abstract List<Contact> getContactList();

    public boolean getExcludeNumber() {
        return this.m_phoneNumberExclude;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_option;
        if (i4 == 3) {
            return SelectableItem.r(R.string.any_number);
        }
        String str = "";
        if (i4 == 0) {
            if (this.isExclude) {
                str = SelectableItem.r(R.string.excludes) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            if (getContact() != null) {
                return str + getContact().getName();
            } else if (getContactList().size() == 1) {
                return str + getContactList().get(0).getName();
            } else if (getContactList().size() == 0) {
                return Contact.getSelectContactString();
            } else {
                return str + getContactList().toString();
            }
        } else if (i4 == 1) {
            if (this.m_groupNameList.size() == 1) {
                return this.m_groupNameList.get(0);
            }
            return this.m_groupNameList.toString();
        } else if (i4 != 2) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            if (this.m_phoneNumberExclude) {
                str = SelectableItem.r(R.string.excludes) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            sb.append(str);
            sb.append(this.m_phoneNumber);
            return sb.toString();
        }
    }

    public List<String> getGroupIds() {
        return this.m_groupIdList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateListIfRequired(getExtendedDetail(), 15) + ")";
    }

    public String getNumber() {
        return this.m_phoneNumber;
    }

    public int getOptionType() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + MDTextUtils.truncateListIfRequired(getExtendedDetail(), 150) + ")";
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, "01234567890");
    }

    public boolean isExclude() {
        return this.isExclude;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        int i4 = this.m_option;
        if (i4 == 0) {
            if (getContact() == null && getContactList().size() == 0) {
                return false;
            }
            return true;
        } else if (i4 == 1 && this.m_groupIdList.size() == 0) {
            return false;
        } else {
            return true;
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
                        this.m_option = i4;
                        itemComplete();
                        return;
                    }
                    return;
                }
                c0();
                return;
            }
            b0();
            return;
        }
        ContactsHelper.displayContactChooser(getActivity(), getDialogTheme(), getContactList(), getContact(), this.isExclude, true, false, new a());
    }

    abstract void setContact(Contact contact);

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeStringList(this.m_groupIdList);
        parcel.writeStringList(this.m_groupNameList);
        parcel.writeString(this.m_phoneNumber);
        parcel.writeInt(this.m_phoneNumberExclude ? 1 : 0);
        parcel.writeInt(this.isExclude ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallBasedTrigger(Parcel parcel) {
        super(parcel);
        init();
        this.m_option = parcel.readInt();
        parcel.readStringList(this.m_groupIdList);
        parcel.readStringList(this.m_groupNameList);
        this.m_phoneNumber = parcel.readString();
        this.m_phoneNumberExclude = parcel.readInt() != 0;
        this.isExclude = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14341a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14342b;

        b(Button button, EditText editText) {
            this.f14341a = button;
            this.f14342b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14341a;
            if (this.f14342b.getText().length() > 0) {
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
