package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.CallLog;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.MakeCallActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MakeCallAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<MakeCallAction> CREATOR = new b();
    private Contact m_contact;
    private transient List<Contact> m_contactsList;
    private String m_number;
    private int slotId;

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<MakeCallAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MakeCallAction createFromParcel(Parcel parcel) {
            return new MakeCallAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MakeCallAction[] newArray(int i4) {
            return new MakeCallAction[i4];
        }
    }

    /* synthetic */ MakeCallAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void W() {
        boolean z3;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.enter_number_dialog);
        appCompatDialog.setTitle(SelectableItem.r(R.string.trigger_dial_number_title));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_number_dialog_phone_number);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.enter_number_dialog_magic_text_button);
        String str = this.m_number;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeCallAction.this.Z(editText, appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.hb
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                MakeCallAction.b0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ib
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeCallAction.this.c0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private void X(List<PhoneAccountHandle> list) {
        String[] strArr = new String[list.size() + 1];
        strArr[0] = SelectableItem.r(R.string.system_default);
        int i4 = 1;
        for (PhoneAccountHandle phoneAccountHandle : list) {
            strArr[i4] = String.valueOf(i4);
            i4++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.sim_card);
        builder.setSingleChoiceItems(strArr, this.slotId + 1, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MakeCallAction.this.d0(dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.nb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MakeCallAction.e0(dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.eb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MakeCallAction.this.f0(dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    private void Y() {
        List<PhoneAccountHandle> callCapablePhoneAccounts;
        if (Build.VERSION.SDK_INT < 23) {
            itemComplete();
        } else if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_PHONE_STATE") == 0) {
            callCapablePhoneAccounts = ((TelecomManager) getContext().getSystemService("telecom")).getCallCapablePhoneAccounts();
            if (callCapablePhoneAccounts.size() < 2) {
                itemComplete();
            } else {
                X(callCapablePhoneAccounts);
            }
        } else {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.cell_connection_type), true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.m_number = editText.getText().toString();
        appCompatDialog.cancel();
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface, int i4) {
        this.slotId = i4 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(List list, DialogInterface dialogInterface, int i4) {
        this.m_number = (String) list.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DialogInterface dialogInterface, int i4) {
        Y();
    }

    private void j0(final List<String> list) {
        int i4 = 0;
        if (this.m_number == null) {
            this.m_number = list.get(0);
        } else {
            int i5 = 0;
            while (true) {
                if (i5 >= list.size()) {
                    break;
                } else if (this.m_number.equals(list.get(i5))) {
                    i4 = i5;
                    break;
                } else {
                    i5++;
                }
            }
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_number);
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MakeCallAction.this.g0(list, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MakeCallAction.h0(dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.lb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MakeCallAction.this.i0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        try {
            this.m_contact = this.m_contactsList.get(i4);
        } catch (IndexOutOfBoundsException unused) {
            Log.w(this.m_classType, "No contacts on device");
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        if (!this.m_contact.getId().equals(Contact.INCOMING_CONTACT_ID) && !this.m_contact.getId().equals(Contact.LAST_NUMBER_CALLED_CONTACT_ID)) {
            this.m_contact = new Contact(Contact.SELECT_CONTACT_ID, Contact.getSelectContactString(), Contact.SELECT_CONTACT_ID);
            String str = this.m_number;
            if (str == null || (!str.startsWith("[") && !this.m_number.startsWith("{"))) {
                this.m_number = null;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        boolean z3 = true;
        if (this.m_contact.getName().equals(Contact.getIncomingSmsContactName()) || this.m_contact.getId().equals(Contact.HARDWIRED_NUMBER_CONTACT_ID)) {
            return true;
        }
        List<Contact> contacts = Util.getContacts(getContext(), false);
        if (contacts.size() > 0) {
            Iterator<Contact> it = contacts.iterator();
            while (true) {
                if (it.hasNext()) {
                    Contact next = it.next();
                    if (next.getName().equals(this.m_contact.getName())) {
                        this.m_contact = next;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3) {
                this.m_contact = new Contact(Contact.SELECT_CONTACT_ID, Contact.getSelectContactString(), Contact.SELECT_CONTACT_ID);
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        Contact contact = this.m_contact;
        if (contact != null) {
            if (contact.getId().equals(Contact.LAST_NUMBER_CALLED_CONTACT_ID)) {
                return 1;
            }
            for (int i4 = 0; i4 < this.m_contactsList.size(); i4++) {
                if (this.m_contactsList.get(i4).getName().equals(this.m_contact.getName())) {
                    return i4;
                }
            }
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        Contact contact = this.m_contact;
        if (contact != null && contact.getId() != null) {
            if (this.m_contact.getId().equals(Contact.HARDWIRED_NUMBER_CONTACT_ID)) {
                return SelectableItem.r(R.string.action_make_call_call) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_number;
            }
            return SelectableItem.r(R.string.action_make_call_call) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_contact.getName();
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Make Call Action: Contact is invalid"));
        return SelectableItem.r(R.string.action_make_call_call) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.invalid_contact);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MakeCallActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 26) {
            return new String[]{"android.permission.READ_CONTACTS", "android.permission.CALL_PHONE", "android.permission.WRITE_CALL_LOG", "android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE"};
        }
        return new String[]{"android.permission.READ_CONTACTS", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_number};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        List callCapablePhoneAccounts;
        List callCapablePhoneAccounts2;
        List callCapablePhoneAccounts3;
        TelecomManager telecomManager = (TelecomManager) getContext().getSystemService("telecom");
        String str2 = null;
        if (this.m_number != null) {
            str = MagicText.replaceMagicText(getContext(), this.m_number, triggerContextInfo, getMacro());
        } else {
            str = null;
        }
        Contact contact = this.m_contact;
        if (contact != null && !contact.getId().equals(Contact.SELECT_CONTACT_ID)) {
            if (this.m_contact.getId().equals(Contact.INCOMING_CONTACT_ID) && triggerContextInfo != null) {
                if (triggerContextInfo.getIncomingSMSData() != null) {
                    str = triggerContextInfo.getIncomingSMSData().getFromNumber();
                } else if (triggerContextInfo.getTextData() != null) {
                    str = triggerContextInfo.getTextData();
                } else if (triggerContextInfo.getContactData() != null) {
                    str = triggerContextInfo.getContactData().getNumber();
                }
            }
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CALL_PHONE") != 0) {
                PermissionsHelper.showNeedsPermission(getContext(), "android.permission.CALL_PHONE", getName(), true, false);
                return;
            } else if (this.m_contact.getId().equals(Contact.LAST_NUMBER_CALLED_CONTACT_ID)) {
                try {
                    str2 = CallLog.Calls.getLastOutgoingCall(getContext().getApplicationContext());
                } catch (SecurityException unused) {
                    SystemLog.logError("Could not access last outgoing called, requires READ_CALL_LOG permission", getMacroGuid().longValue());
                }
                if (str2 != null) {
                    Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + Uri.encode(str2)));
                    if (Build.VERSION.SDK_INT >= 23 && this.slotId >= 0) {
                        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_PHONE_STATE") == 0) {
                            callCapablePhoneAccounts = telecomManager.getCallCapablePhoneAccounts();
                            if (callCapablePhoneAccounts.size() > 1 && this.slotId < callCapablePhoneAccounts.size()) {
                                intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", (Parcelable) callCapablePhoneAccounts.get(this.slotId));
                            }
                        } else {
                            SystemLog.logError("Could not access phone state, requires READ_PHONE_STATE permission", getMacroGuid().longValue());
                        }
                    }
                    intent.addFlags(268435456);
                    getContext().startActivity(intent);
                    return;
                }
                return;
            } else if (str != null) {
                Intent intent2 = new Intent("android.intent.action.CALL", Uri.parse("tel:" + Uri.encode(str)));
                if (Build.VERSION.SDK_INT >= 23 && this.slotId >= 0) {
                    if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_PHONE_STATE") == 0) {
                        callCapablePhoneAccounts3 = telecomManager.getCallCapablePhoneAccounts();
                        if (callCapablePhoneAccounts3.size() > 1 && this.slotId < callCapablePhoneAccounts3.size()) {
                            intent2.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", (Parcelable) callCapablePhoneAccounts3.get(this.slotId));
                        }
                    } else {
                        SystemLog.logError("Could not access phone state, requires READ_PHONE_STATE permission", getMacroGuid().longValue());
                    }
                }
                intent2.addFlags(268435456);
                getContext().startActivity(intent2);
                return;
            } else {
                String preferredNumberForContact = Util.getPreferredNumberForContact(getContext(), this.m_contact);
                if (preferredNumberForContact != null) {
                    Intent intent3 = new Intent("android.intent.action.CALL", Uri.parse("tel:" + Uri.encode(preferredNumberForContact)));
                    if (Build.VERSION.SDK_INT >= 23 && this.slotId >= 0) {
                        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_PHONE_STATE") == 0) {
                            callCapablePhoneAccounts2 = telecomManager.getCallCapablePhoneAccounts();
                            if (callCapablePhoneAccounts2.size() > 1 && this.slotId < callCapablePhoneAccounts2.size()) {
                                intent3.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", (Parcelable) callCapablePhoneAccounts2.get(this.slotId));
                            }
                        } else {
                            SystemLog.logError("Could not set SIM card slot for call, requires READ_PHONE_STATE permission");
                        }
                    }
                    intent3.addFlags(268435456);
                    getContext().startActivity(intent3);
                    return;
                }
                return;
            }
        }
        SystemLog.logError("Make Call Action: Contact is invalid");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Contact contact = this.m_contact;
        if (contact == null) {
            return false;
        }
        if (contact.getId().equals(Contact.INCOMING_CONTACT_ID) && !this.m_macro.hasOnlyTrigger(IncomingSMSTrigger.class)) {
            return false;
        }
        return !this.m_contact.getId().equals(Contact.SELECT_CONTACT_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        this.m_contactsList = Util.getContacts(getContext());
        this.m_contactsList.add(0, new Contact(Contact.LAST_NUMBER_CALLED_CONTACT_ID, Contact.getLastNumberCalledContactName(), Contact.LAST_NUMBER_CALLED_CONTACT_ID));
        this.m_contactsList.add(0, new Contact(Contact.HARDWIRED_NUMBER_CONTACT_ID, Contact.getHardwiredContactName(), Contact.HARDWIRED_NUMBER_CONTACT_ID));
        if (this.m_macro.hasOnlyTrigger(IncomingSMSTrigger.class)) {
            this.m_contactsList.add(0, new Contact(Contact.INCOMING_CONTACT_ID, Contact.getIncomingSmsContactName(), Contact.INCOMING_CONTACT_ID));
        }
        if (this.m_contact == null) {
            this.m_contact = this.m_contactsList.get(0);
        }
        try {
            Contact[] contactArr = new Contact[this.m_contactsList.size()];
            this.m_contactsList.toArray(contactArr);
            int size = this.m_contactsList.size();
            String[] strArr = new String[size];
            for (int i4 = 0; i4 < size; i4++) {
                strArr[i4] = contactArr[i4].getName();
            }
            return strArr;
        } catch (IndexOutOfBoundsException unused) {
            return new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.select_contact);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Contact contact = this.m_contact;
        if (contact != null) {
            if (!contact.getId().equals(Contact.HARDWIRED_NUMBER_CONTACT_ID) && !this.m_contact.getId().equals(Contact.SELECT_CONTACT_ID)) {
                this.m_number = null;
                if (!this.m_contact.getId().equals(Contact.INCOMING_CONTACT_ID) && !this.m_contact.getId().equals(Contact.LAST_NUMBER_CALLED_CONTACT_ID)) {
                    List<String> numbersForContact = Util.getNumbersForContact(getContext(), this.m_contact);
                    if (numbersForContact.size() > 1) {
                        j0(numbersForContact);
                        return;
                    } else {
                        Y();
                        return;
                    }
                }
                Y();
                return;
            }
            this.m_contact = new Contact(Contact.HARDWIRED_NUMBER_CONTACT_ID, Contact.getHardwiredContactName(), Contact.HARDWIRED_NUMBER_CONTACT_ID);
            W();
            return;
        }
        super.secondaryItemConfirmed();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_number = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_contact, i4);
        parcel.writeString(this.m_number);
        parcel.writeInt(this.slotId);
    }

    public MakeCallAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MakeCallAction() {
        this.slotId = -1;
    }

    private MakeCallAction(Parcel parcel) {
        super(parcel);
        this.slotId = -1;
        this.m_contact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.m_number = parcel.readString();
        this.slotId = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2311a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2312b;

        a(Button button, EditText editText) {
            this.f2311a = button;
            this.f2312b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2311a;
            if (this.f2312b.getText().length() > 0) {
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
