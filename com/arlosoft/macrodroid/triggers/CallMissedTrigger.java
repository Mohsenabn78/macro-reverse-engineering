package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
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
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
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
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.CallMissedTrigger;
import com.arlosoft.macrodroid.triggers.info.CallMissedTriggerInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CallMissedTrigger extends Trigger {
    public static final Parcelable.Creator<CallMissedTrigger> CREATOR = new c();
    public static final int OPTIONS_ANY_NUMBER = 3;
    public static final int OPTIONS_SELECT_GROUP = 1;
    public static final int OPTIONS_SPECIFY_NUMBER = 2;
    private static final int OPTION_SELECT_CONTACT = 0;
    private static int s_callActiveTriggerCounter;
    private static ContentObserver s_contentObserver;
    private static long s_timestamp;
    private boolean isExclude;
    private List<Contact> m_contactList;
    private List<String> m_groupIdList;
    private List<String> m_groupNameList;
    private int m_option;
    private String m_phoneNumber;
    private boolean m_phoneNumberExclude;
    private transient int workingOption;

    /* loaded from: classes3.dex */
    public static class MissedCallsContentObserver extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private final Context f14344a;

        /* synthetic */ MissedCallsContentObserver(Context context, a aVar) {
            this(context);
        }

        private void b(String str, CallMissedTrigger callMissedTrigger, Macro macro, List<Macro> list) {
            List<String> groupIds = callMissedTrigger.getGroupIds();
            if (groupIds.size() > 0) {
                StringBuilder sb = new StringBuilder("(");
                for (int i4 = 0; i4 < groupIds.size(); i4++) {
                    sb.append(groupIds.get(i4));
                    if (i4 < groupIds.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(")");
                ContentResolver contentResolver = this.f14344a.getContentResolver();
                Cursor query = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"data1", "contact_id"}, "data1 IN " + sb.toString(), null, null);
                ArrayList<String> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("contact_id"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                    }
                }
                query.close();
                for (String str2 : arrayList) {
                    if (Util.compareNumbers(str, Util.getNumbersForContactId(MacroDroidApplication.getInstance(), str2)) && callMissedTrigger.constraintsMet()) {
                        macro.setTriggerThatInvoked(callMissedTrigger);
                        macro.setTriggerContextInfo(new TriggerContextInfo(callMissedTrigger, str));
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            list.add(macro);
                            return;
                        }
                        return;
                    }
                }
            }
        }

        private void c(String str, CallMissedTrigger callMissedTrigger, Macro macro, List<Macro> list) {
            if (str == null) {
                return;
            }
            String number = callMissedTrigger.getNumber();
            boolean compare = PhoneNumberUtils.compare(number, str);
            if (!compare && WildCardHelper.matches(str, WildCardHelper.getRegexPattern(MagicText.replaceMagicText(this.f14344a, number, null, macro), false, true), false, true)) {
                compare = true;
            }
            if (compare != callMissedTrigger.getExcludeNumber() && callMissedTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(callMissedTrigger);
                macro.setTriggerContextInfo(new TriggerContextInfo(callMissedTrigger, str));
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    list.add(macro);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(ArrayList arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Macro macro = (Macro) it.next();
                macro.invokeActions(macro.getTriggerContextInfo());
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            int i4;
            boolean z4;
            boolean z5;
            if (ContextCompat.checkSelfPermission(this.f14344a, "android.permission.READ_CALL_LOG") != 0) {
                PermissionsHelper.showNeedsPermission(this.f14344a, "android.permission.READ_CALL_LOG", null, true, false);
                return;
            }
            int i5 = 3;
            int i6 = 2;
            Cursor query = this.f14344a.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number"}, "type = ? AND new = ? AND date > ?", new String[]{Integer.toString(3), "1", String.valueOf(CallMissedTrigger.s_timestamp)}, "date DESC ");
            if (query != null) {
                i4 = query.getCount();
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                long unused = CallMissedTrigger.s_timestamp = System.currentTimeMillis();
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("number"));
                final ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Trigger next = it.next();
                            if (next instanceof CallMissedTrigger) {
                                CallMissedTrigger callMissedTrigger = (CallMissedTrigger) next;
                                boolean z6 = callMissedTrigger.isExclude;
                                if (callMissedTrigger.getOptionType() == i5) {
                                    if (callMissedTrigger.constraintsMet()) {
                                        macro.setTriggerThatInvoked(next);
                                        macro.setTriggerContextInfo(new TriggerContextInfo(macro.getTriggerThatInvoked(), string));
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                    }
                                } else if (callMissedTrigger.getOptionType() == i6) {
                                    c(string, callMissedTrigger, macro, arrayList);
                                } else if (callMissedTrigger.getOptionType() == 1) {
                                    b(string, callMissedTrigger, macro, arrayList);
                                } else {
                                    for (Contact contact : callMissedTrigger.getContactList()) {
                                        String id = contact.getId();
                                        id.hashCode();
                                        char c4 = 65535;
                                        switch (id.hashCode()) {
                                            case 1444:
                                                if (id.equals(Util.ANY_CONTACT_ID)) {
                                                    c4 = 0;
                                                    break;
                                                }
                                                break;
                                            case 1445:
                                                if (id.equals(Util.ANY_NUMBER_ID)) {
                                                    c4 = 1;
                                                    break;
                                                }
                                                break;
                                            case 1446:
                                                if (id.equals(Util.NON_CONTACT_ID)) {
                                                    c4 = 2;
                                                    break;
                                                }
                                                break;
                                            case 1447:
                                                if (id.equals(Util.UNKNOWN_CALLER_ID)) {
                                                    c4 = 3;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (c4) {
                                            case 0:
                                            case 2:
                                                boolean equals = contact.getId().equals(Util.ANY_CONTACT_ID);
                                                Iterator<Contact> it2 = Util.getContacts(MacroDroidApplication.getInstance()).iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        if (Util.compareNumbers(string, Util.getNumbersForContact(MacroDroidApplication.getInstance(), it2.next()))) {
                                                            z5 = true;
                                                        }
                                                    } else {
                                                        z5 = false;
                                                    }
                                                }
                                                if (z5 == equals) {
                                                    z4 = callMissedTrigger.isExclude;
                                                    z6 = !z4;
                                                    break;
                                                }
                                            case 1:
                                                z4 = callMissedTrigger.isExclude;
                                                z6 = !z4;
                                                break;
                                            case 3:
                                                if (string == null) {
                                                    z4 = callMissedTrigger.isExclude;
                                                    z6 = !z4;
                                                    break;
                                                }
                                            default:
                                                if (Util.compareNumbers(string, Util.getNumbersForContact(MacroDroidApplication.getInstance(), contact))) {
                                                    z4 = callMissedTrigger.isExclude;
                                                    z6 = !z4;
                                                    break;
                                                }
                                        }
                                    }
                                }
                                if (z6 && next.constraintsMet()) {
                                    macro.setTriggerThatInvoked(next);
                                    macro.setTriggerContextInfo(new TriggerContextInfo(macro.getTriggerThatInvoked(), string));
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            }
                            i5 = 3;
                            i6 = 2;
                        }
                    }
                    i5 = 3;
                    i6 = 2;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.e2
                    @Override // java.lang.Runnable
                    public final void run() {
                        CallMissedTrigger.MissedCallsContentObserver.d(arrayList);
                    }
                });
            }
            query.close();
        }

        private MissedCallsContentObserver(Context context) {
            super(null);
            this.f14344a = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ContactSelectionListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.contacts.ContactSelectionListener
        public void contactsSelected(@NonNull List<? extends Contact> list, boolean z3) {
            CallMissedTrigger.this.isExclude = z3;
            CallMissedTrigger callMissedTrigger = CallMissedTrigger.this;
            callMissedTrigger.m_option = callMissedTrigger.workingOption;
            List contactList = CallMissedTrigger.this.getContactList();
            contactList.clear();
            contactList.addAll(list);
            CallMissedTrigger.this.itemComplete();
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<CallMissedTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CallMissedTrigger createFromParcel(Parcel parcel) {
            return new CallMissedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CallMissedTrigger[] newArray(int i4) {
            return new CallMissedTrigger[i4];
        }
    }

    /* synthetic */ CallMissedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(DialogInterface dialogInterface, int i4, boolean z3) {
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
    public /* synthetic */ void a0(List list, DialogInterface dialogInterface, int i4) {
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
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(EditText editText, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        this.m_phoneNumber = editText.getText().toString();
        this.m_phoneNumberExclude = checkBox.isChecked();
        appCompatDialog.dismiss();
        this.m_option = this.workingOption;
        itemComplete();
    }

    private void f0() {
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
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.triggers.y1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i5, boolean z4) {
                CallMissedTrigger.Z(dialogInterface, i5, z4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.z1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                CallMissedTrigger.this.a0(contactGroups, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        if (!z3) {
            create.getButton(-1).setEnabled(false);
        }
    }

    private void g0() {
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
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.a2
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CallMissedTrigger.b0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallMissedTrigger.this.c0(activity, magicTextListener, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallMissedTrigger.this.d0(editText, checkBox, appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Contact> getContactList() {
        if (this.m_contactList == null) {
            this.m_contactList = new ArrayList();
        }
        return this.m_contactList;
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

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_callActiveTriggerCounter - 1;
        s_callActiveTriggerCounter = i4;
        if (i4 == 0 && s_contentObserver != null) {
            getContext().getContentResolver().unregisterContentObserver(s_contentObserver);
            s_contentObserver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_callActiveTriggerCounter == 0) {
            s_timestamp = System.currentTimeMillis();
            s_contentObserver = new MissedCallsContentObserver(getContext(), null);
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_CALL_LOG") != 0) {
                PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_CALL_LOG", null, true, false);
                return;
            }
            getContext().getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, true, s_contentObserver);
        }
        s_callActiveTriggerCounter++;
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
            } else if (this.m_contactList.size() == 0) {
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

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CallMissedTriggerInfo.getInstance();
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
                g0();
                return;
            }
            f0();
            return;
        }
        ContactsHelper.displayContactChooser(getActivity(), getDialogTheme(), getContactList(), null, this.isExclude, true, false, new a());
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
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

    public CallMissedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public CallMissedTrigger() {
        init();
        this.m_contactList = new ArrayList();
    }

    private CallMissedTrigger(Parcel parcel) {
        super(parcel);
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
        final /* synthetic */ Button f14346a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14347b;

        b(Button button, EditText editText) {
            this.f14346a = button;
            this.f14347b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14346a;
            if (this.f14347b.getText().length() > 0) {
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
