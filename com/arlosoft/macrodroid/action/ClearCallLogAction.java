package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ClearCallLogActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ClearCallLogAction extends Action {
    public static final Parcelable.Creator<ClearCallLogAction> CREATOR = new a();
    private static final int TYPE_ALL = 0;
    private static final int TYPE_BLOCKED = 6;
    private static final int TYPE_INCOMING = 1;
    private static final int TYPE_MISSED = 3;
    private static final int TYPE_OUTGOING = 2;
    private static final int TYPE_REJECTED = 5;
    private static final int TYPE_VOICEMAIL = 4;
    private Contact m_contact;
    private boolean m_nonContact;
    private boolean m_specificContact;
    private int m_type;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ClearCallLogAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ClearCallLogAction createFromParcel(Parcel parcel) {
            return new ClearCallLogAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ClearCallLogAction[] newArray(int i4) {
            return new ClearCallLogAction[i4];
        }
    }

    /* synthetic */ ClearCallLogAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T() {
        if (!this.m_specificContact) {
            itemComplete();
            return;
        }
        final List<Contact> contacts = Util.getContacts(getContext());
        String[] strArr = new String[contacts.size()];
        int i4 = 0;
        for (int i5 = 0; i5 < contacts.size(); i5++) {
            strArr[i5] = contacts.get(i5).getName();
            Contact contact = this.m_contact;
            if (contact != null && contact.getName().equals(contacts.get(i5).getName())) {
                i4 = i5;
            }
        }
        if (i4 == 0 && contacts.size() > 0) {
            this.m_contact = contacts.get(0);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(getContext().getString(R.string.action_clear_call_log_clear_log_for_contact));
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.l2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ClearCallLogAction.this.a0(contacts, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.m2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ClearCallLogAction.this.b0(dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.getListView().setFastScrollEnabled(true);
    }

    private String[] U() {
        return new String[]{SelectableItem.r(R.string.call_type_all), SelectableItem.r(R.string.call_type_incoming), SelectableItem.r(R.string.call_type_outgoing), SelectableItem.r(R.string.call_type_missed), SelectableItem.r(R.string.call_type_voicemail), SelectableItem.r(R.string.call_type_rejected), SelectableItem.r(R.string.call_type_blocked)};
    }

    private boolean V(String str) {
        boolean z3 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor query = getContext().getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID}, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() > 0) {
                    z3 = true;
                }
            } finally {
                query.close();
            }
        }
        if (query != null) {
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        boolean z3;
        boolean z4 = true;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_specificContact = z3;
        if (i4 != 2) {
            z4 = false;
        }
        this.m_nonContact = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i4) {
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(List list, DialogInterface dialogInterface, int i4) {
        if (list.size() > 0) {
            this.m_contact = (Contact) list.get(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_clear_call_log_specific_contact), SelectableItem.r(R.string.action_clear_call_log_all_entries), SelectableItem.r(R.string.non_contact)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_type = i4;
    }

    protected AlertDialog S() {
        int i4;
        String[] o4 = o();
        if (o4 != null && o4.length != 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(R.string.action_clear_call_log_clear_logs_for);
            String[] options = getOptions();
            if (this.m_specificContact) {
                i4 = 0;
            } else if (this.m_nonContact) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            builder.setSingleChoiceItems(options, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    ClearCallLogAction.this.W(dialogInterface, i5);
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.i2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    ClearCallLogAction.this.X(dialogInterface, i5);
                }
            });
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.j2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    ClearCallLogAction.this.Y(dialogInterface, i5);
                }
            });
            AlertDialog create = builder.create();
            create.show();
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.k2
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    ClearCallLogAction.this.Z(dialogInterface);
                }
            });
            return create;
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        List<Contact> contacts = Util.getContacts(getContext());
        boolean z3 = false;
        contacts.add(0, new Contact(Util.ANY_CONTACT_ID, Util.getAnyContactString(), Util.ANY_CONTACT_ID));
        contacts.add(0, new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
        contacts.add(0, new Contact(Util.NON_CONTACT_ID, Util.getNonContactString(), Util.NON_CONTACT_ID));
        if (contacts.size() <= 0) {
            return true;
        }
        Iterator<Contact> it = contacts.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Contact next = it.next();
            if (next != null && this.m_contact != null && next.getName() != null && next.getName().equals(this.m_contact.getName())) {
                this.m_contact = next;
                z3 = true;
                break;
            }
        }
        if (!z3) {
            this.m_contact = new Contact(Contact.SELECT_CONTACT_ID, Contact.getSelectContactString(), Contact.SELECT_CONTACT_ID);
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_type;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = "(" + U()[this.m_type] + ") ";
        if (this.m_nonContact) {
            return str + SelectableItem.r(R.string.non_contacts);
        } else if (this.m_specificContact) {
            if (this.m_contact != null) {
                return str + SelectableItem.r(R.string.action_clear_call_log_contact) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_contact.getName();
            }
            return str + SelectableItem.r(R.string.action_clear_call_log_contact) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.invalid_contact);
        } else {
            return str + getContext().getString(R.string.action_clear_call_log_contact_all_entries);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ClearCallLogActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (this.m_nonContact) {
            try {
                Cursor query = getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
                List<Contact> contacts = Util.getContacts(getContext());
                if (contacts != null && contacts.size() != 0) {
                    HashSet<String> hashSet = new HashSet();
                    while (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex("number"));
                        if (!V(string)) {
                            hashSet.add(string);
                        }
                    }
                    query.close();
                    for (String str : hashSet) {
                        try {
                            if (this.m_type == 0) {
                                ContentResolver contentResolver = getContext().getContentResolver();
                                Uri uri = CallLog.Calls.CONTENT_URI;
                                contentResolver.delete(uri, "number='" + str + "'", null);
                            } else {
                                ContentResolver contentResolver2 = getContext().getContentResolver();
                                Uri uri2 = CallLog.Calls.CONTENT_URI;
                                contentResolver2.delete(uri2, "number='" + str + "' AND type=" + this.m_type, null);
                            }
                        } catch (Exception e4) {
                            SystemLog.logError("Clear call log failed: " + e4.toString(), getMacroGuid().longValue());
                        }
                    }
                    return;
                }
                SystemLog.logError("No contacts found", getMacroGuid().longValue());
            } catch (Exception e5) {
                SystemLog.logError("Clear call log failed: " + e5.toString(), getMacroGuid().longValue());
            }
        } else if (!this.m_specificContact) {
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_CALL_LOG") != 0) {
                PermissionsHelper.showNeedsPermission(getContext(), "android.permission.WRITE_CALL_LOG", SelectableItem.r(R.string.action_clear_call_log), true, false);
                return;
            }
            try {
                if (this.m_type == 0) {
                    getContext().getContentResolver().delete(CallLog.Calls.CONTENT_URI, null, null);
                } else {
                    ContentResolver contentResolver3 = getContext().getContentResolver();
                    Uri uri3 = CallLog.Calls.CONTENT_URI;
                    contentResolver3.delete(uri3, "type=" + this.m_type, null);
                }
            } catch (Exception e6) {
                SystemLog.logError("Clear call log failed: " + e6.toString(), getMacroGuid().longValue());
            }
        } else if (this.m_contact != null) {
            List<String> numbersForContact = Util.getNumbersForContact(getContext(), this.m_contact);
            Cursor query2 = getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
            if (query2 != null) {
                while (true) {
                    if (!query2.moveToNext()) {
                        break;
                    }
                    String string2 = query2.getString(query2.getColumnIndex("number"));
                    if (Util.compareNumbers(string2, numbersForContact)) {
                        try {
                            if (this.m_type == 0) {
                                ContentResolver contentResolver4 = getContext().getContentResolver();
                                Uri uri4 = CallLog.Calls.CONTENT_URI;
                                contentResolver4.delete(uri4, "number='" + string2 + "'", null);
                            } else {
                                ContentResolver contentResolver5 = getContext().getContentResolver();
                                Uri uri5 = CallLog.Calls.CONTENT_URI;
                                contentResolver5.delete(uri5, "number='" + string2 + "' AND type=" + this.m_type, null);
                            }
                        } catch (Exception e7) {
                            SystemLog.logError("Clear call log failed: " + e7.toString(), getMacroGuid().longValue());
                        }
                    }
                }
                query2.close();
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (!this.m_specificContact) {
            return true;
        }
        Contact contact = this.m_contact;
        if (contact == null) {
            return false;
        }
        if (contact.getName() == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("The contact name is null? The id is: " + this.m_contact.getId() + " The number is: " + this.m_contact.getNumber()));
            return false;
        }
        return !this.m_contact.getName().equals(Contact.getSelectContactString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_clear_call_log_clear_logs_for);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        S();
    }

    public void setContact(Contact contact) {
        this.m_contact = contact;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_specificContact ? 1 : 0);
        parcel.writeParcelable(this.m_contact, i4);
        parcel.writeInt(this.m_nonContact ? 1 : 0);
        parcel.writeInt(this.m_type);
    }

    public ClearCallLogAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ClearCallLogAction() {
        this.m_specificContact = true;
    }

    private ClearCallLogAction(Parcel parcel) {
        super(parcel);
        this.m_specificContact = parcel.readInt() != 0;
        this.m_contact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.m_nonContact = parcel.readInt() != 0;
        this.m_type = parcel.readInt();
    }
}
