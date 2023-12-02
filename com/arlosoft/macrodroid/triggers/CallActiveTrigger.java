package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
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
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.contacts.ContactSelectionListener;
import com.arlosoft.macrodroid.contacts.ContactsHelper;
import com.arlosoft.macrodroid.data.ContactGroup;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.info.CallActiveTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.IncomingCallMonitor;
import com.arlosoft.macrodroid.triggers.receivers.OutgoingCallMonitor;
import com.arlosoft.macrodroid.triggers.services.PhoneStateMonitorService;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CallActiveTrigger extends SignalOnOffTrigger {
    public static final Parcelable.Creator<CallActiveTrigger> CREATOR = new c();
    public static final int OPTIONS_ANY_NUMBER = 3;
    public static final int OPTIONS_SELECT_GROUP = 1;
    public static final int OPTIONS_SPECIFY_NUMBER = 2;
    private static final int OPTION_SELECT_CONTACT = 0;
    private static int s_callActiveTriggerCounter;
    private static IncomingCallMonitor s_incomingCallMonitor;
    private static OutgoingCallMonitor s_outgoingCallMonitor;
    private boolean isExclude;
    private List<Contact> m_contactList;
    private List<String> m_groupIdList;
    private List<String> m_groupNameList;
    private int m_option;
    private String m_phoneNumber;
    private boolean m_phoneNumberExclude;
    protected String m_secondaryClassType;
    private transient int workingOption;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ContactSelectionListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.contacts.ContactSelectionListener
        public void contactsSelected(@NonNull List<? extends Contact> list, boolean z3) {
            CallActiveTrigger.this.isExclude = z3;
            CallActiveTrigger callActiveTrigger = CallActiveTrigger.this;
            callActiveTrigger.m_option = callActiveTrigger.workingOption;
            List<Contact> contactList = CallActiveTrigger.this.getContactList();
            contactList.clear();
            contactList.addAll(list);
            CallActiveTrigger.this.itemComplete();
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<CallActiveTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CallActiveTrigger createFromParcel(Parcel parcel) {
            return new CallActiveTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CallActiveTrigger[] newArray(int i4) {
            return new CallActiveTrigger[i4];
        }
    }

    /* synthetic */ CallActiveTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y() {
        s_outgoingCallMonitor = new OutgoingCallMonitor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z() {
        s_incomingCallMonitor = new IncomingCallMonitor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        Binder.clearCallingIdentity();
        try {
            ((TelephonyManager) getContext().getSystemService("phone")).listen(s_incomingCallMonitor, 32);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_call_active), true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(DialogInterface dialogInterface, int i4, boolean z3) {
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
    public /* synthetic */ void c0(List list, DialogInterface dialogInterface, int i4) {
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
    public static /* synthetic */ void d0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(EditText editText, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        this.m_phoneNumber = editText.getText().toString();
        this.m_phoneNumberExclude = checkBox.isChecked();
        appCompatDialog.dismiss();
        this.m_option = this.workingOption;
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.select_contacts), SelectableItem.r(R.string.select_groups), SelectableItem.r(R.string.select_number), SelectableItem.r(R.string.any_number)};
    }

    private void h0() {
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
        builder.setTitle(R.string.select_groups);
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.triggers.l1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i5, boolean z4) {
                CallActiveTrigger.b0(dialogInterface, i5, z4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.m1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                CallActiveTrigger.this.c0(contactGroups, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        if (!z3) {
            create.getButton(-1).setEnabled(false);
        }
    }

    private void i0() {
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
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.n1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CallActiveTrigger.d0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallActiveTrigger.this.e0(activity, magicTextListener, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallActiveTrigger.this.f0(editText, checkBox, appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private void init() {
        this.m_groupIdList = new ArrayList();
        this.m_groupNameList = new ArrayList();
        this.workingOption = this.m_option;
    }

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.common.SelectableItem
    protected void C(int i4) {
        this.workingOption = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        ArrayList arrayList = new ArrayList();
        for (Contact contact : this.m_contactList) {
            if (contact.getId().equals(Util.ANY_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.ANY_CONTACT_ID, Util.getAnyContactString(), Util.ANY_CONTACT_ID));
            } else if (contact.getId().equals(Util.ANY_NUMBER_ID)) {
                arrayList.add(0, new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
            } else if (contact.getId().equals(Util.NON_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.NON_CONTACT_ID, Util.getNonContactString(), Util.NON_CONTACT_ID));
            } else if (contact.getId().equals(Util.UNKNOWN_CALLER_ID)) {
                arrayList.add(0, new Contact(Util.UNKNOWN_CALLER_ID, Util.getUnkownCallerString(), Util.UNKNOWN_CALLER_ID));
            }
        }
        this.m_contactList = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        int i4 = this.m_option;
        int i5 = 0;
        if (i4 == 0) {
            getContactList();
            List<Contact> contacts = Util.getContacts(getContext());
            contacts.add(0, new Contact(Util.UNKNOWN_CALLER_ID, Util.getUnkownCallerString(), Util.UNKNOWN_CALLER_ID));
            contacts.add(0, new Contact(Util.ANY_CONTACT_ID, Util.getAnyContactString(), Util.ANY_CONTACT_ID));
            contacts.add(0, new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
            contacts.add(0, new Contact(Util.NON_CONTACT_ID, Util.getNonContactString(), Util.NON_CONTACT_ID));
            for (Contact contact : contacts) {
                Iterator<Contact> it = this.m_contactList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (contact.getName().equals(it.next().getName())) {
                            i5 = 1;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (i5 == 0) {
                this.m_contactList.clear();
            }
            return i5;
        } else if (i4 != 1) {
            return true;
        } else {
            List<ContactGroup> contactGroups = Util.getContactGroups(getContext());
            if (contactGroups.size() > 0) {
                boolean z3 = false;
                while (i5 < this.m_groupIdList.size()) {
                    String str = this.m_groupIdList.get(i5);
                    String str2 = this.m_groupNameList.get(i5);
                    for (ContactGroup contactGroup : contactGroups) {
                        if (str.equals(contactGroup.id) && str2.equals(contactGroup.name)) {
                            z3 = true;
                        }
                    }
                    i5++;
                }
                if (!z3) {
                    this.m_groupNameList.clear();
                    this.m_groupIdList.clear();
                }
                return z3;
            }
            return false;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_callActiveTriggerCounter - 1;
        s_callActiveTriggerCounter = i4;
        if (i4 == 0) {
            try {
                if (s_outgoingCallMonitor != null) {
                    getContext().unregisterReceiver(s_outgoingCallMonitor);
                }
                if (s_incomingCallMonitor != null) {
                    try {
                        ((TelephonyManager) getContext().getSystemService("phone")).listen(s_incomingCallMonitor, 0);
                    } catch (SecurityException unused) {
                        PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_call_active), true, false);
                    }
                }
                MacroDroidApplication.getInstance().stopService(new Intent(getContext(), PhoneStateMonitorService.class));
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_callActiveTriggerCounter == 0) {
            if (s_outgoingCallMonitor == null) {
                try {
                    s_outgoingCallMonitor = new OutgoingCallMonitor();
                } catch (Exception unused) {
                    new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.i1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CallActiveTrigger.Y();
                        }
                    });
                }
            }
            if (s_incomingCallMonitor == null) {
                try {
                    s_incomingCallMonitor = new IncomingCallMonitor();
                } catch (Exception unused2) {
                    new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.j1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CallActiveTrigger.Z();
                        }
                    });
                }
            }
            MacroDroidApplication.getInstance().startService(new Intent(getContext(), PhoneStateMonitorService.class));
            getContext().registerReceiver(s_outgoingCallMonitor, new IntentFilter("android.intent.action.NEW_OUTGOING_CALL"));
            new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.k1
                @Override // java.lang.Runnable
                public final void run() {
                    CallActiveTrigger.this.a0();
                }
            });
        }
        s_callActiveTriggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.common.SelectableItem
    protected int getCheckedItemIndex() {
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

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.trigger_call_active);
    }

    public List<Contact> getContactList() {
        return this.m_contactList;
    }

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
            if (getContactList().size() == 1) {
                return str + this.m_contactList.get(0).getName();
            } else if (getContactList().size() == 0) {
                return Contact.getSelectContactString();
            } else {
                return str + this.m_contactList.toString();
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

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CallActiveTriggerInfo.getInstance();
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
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.READ_CALL_LOG"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
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
            if (getContactList().size() == 0) {
                return false;
            }
            return true;
        } else if (i4 == 1 && this.m_groupIdList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.common.SelectableItem
    protected String[] o() {
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
                i0();
                return;
            }
            h0();
            return;
        }
        ContactsHelper.displayContactChooser(getActivity(), getDialogTheme(), getContactList(), null, this.isExclude, true, false, new a());
    }

    public void setDefaultContactAnyNumber() {
        ArrayList arrayList = new ArrayList();
        this.m_contactList = arrayList;
        arrayList.add(new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
    }

    @Override // com.arlosoft.macrodroid.triggers.SignalOnOffTrigger, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        Contact[] contactArr = new Contact[this.m_contactList.size()];
        this.m_contactList.toArray(contactArr);
        parcel.writeParcelableArray(contactArr, i4);
        parcel.writeInt(this.m_option);
        parcel.writeString(this.m_phoneNumber);
        parcel.writeInt(this.m_phoneNumberExclude ? 1 : 0);
        parcel.writeStringList(this.m_groupIdList);
        parcel.writeStringList(this.m_groupNameList);
        parcel.writeInt(this.isExclude ? 1 : 0);
    }

    public CallActiveTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public CallActiveTrigger() {
        this.m_secondaryClassType = "CallActiveTrigger";
        init();
        this.m_contactList = new ArrayList();
    }

    private CallActiveTrigger(Parcel parcel) {
        super(parcel);
        this.m_secondaryClassType = "CallActiveTrigger";
        init();
        Parcelable[] readParcelableArray = parcel.readParcelableArray(Contact.class.getClassLoader());
        if (readParcelableArray != null) {
            ArrayList arrayList = new ArrayList();
            this.m_contactList = arrayList;
            Collections.addAll(arrayList, (Contact[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, Contact[].class));
        }
        this.m_option = parcel.readInt();
        this.m_phoneNumber = parcel.readString();
        this.m_phoneNumberExclude = parcel.readInt() != 0;
        parcel.readStringList(this.m_groupIdList);
        parcel.readStringList(this.m_groupNameList);
        this.isExclude = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14337a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14338b;

        b(Button button, EditText editText) {
            this.f14337a = button;
            this.f14338b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14337a;
            if (this.f14338b.getText().length() > 0) {
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
