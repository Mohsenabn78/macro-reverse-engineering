package com.arlosoft.macrodroid.contacts;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.contacts.ContactsAdapter;
import com.arlosoft.macrodroid.contacts.ContactsHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactsHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ContactsHelper {
    public static final int $stable = 0;
    @NotNull
    public static final ContactsHelper INSTANCE = new ContactsHelper();

    private ContactsHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ContactsAdapter adapter, ContactSelectionListener contactSelectionListener, RadioButton radioExclude, AppCompatDialog dialog, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(contactSelectionListener, "$contactSelectionListener");
        Intrinsics.checkNotNullParameter(radioExclude, "$radioExclude");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        List<Contact> checkedItems = adapter.getCheckedItems();
        Intrinsics.checkNotNullExpressionValue(checkedItems, "checkedItems");
        if (!checkedItems.isEmpty()) {
            contactSelectionListener.contactsSelected(checkedItems, radioExclude.isChecked());
            dialog.dismiss();
            return;
        }
        ToastCompat.makeText(activity, (int) R.string.select_contacts, 1).show();
    }

    @JvmStatic
    public static final void displayContactChooser(@NotNull final Activity activity, int i4, @NotNull List<? extends Contact> contactList, @Nullable Contact contact, boolean z3, boolean z4, boolean z5, @NotNull final ContactSelectionListener contactSelectionListener) {
        boolean z6;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        Intrinsics.checkNotNullParameter(contactSelectionListener, "contactSelectionListener");
        if (((MacroDroidBaseActivity) activity).isDestroyedOrFinishing()) {
            return;
        }
        List<Contact> contacts = Util.getContacts(activity);
        if (z4) {
            contacts.add(0, new Contact(Util.UNKNOWN_CALLER_ID, Util.getUnkownCallerString(), Util.UNKNOWN_CALLER_ID));
        }
        if (z5) {
            contacts.add(0, new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
        }
        contacts.add(0, new Contact(Util.NON_CONTACT_ID, Util.getNonContactString(), Util.NON_CONTACT_ID));
        contacts.add(0, new Contact(Util.ANY_CONTACT_ID, Util.getAnyContactString(), Util.ANY_CONTACT_ID));
        ArrayList arrayList = new ArrayList();
        int size = contacts.size();
        for (int i5 = 0; i5 < size; i5++) {
            boolean z7 = true;
            if (contact != null && Intrinsics.areEqual(contacts.get(i5).getName(), contact.getName())) {
                z6 = true;
            } else {
                z6 = false;
            }
            Iterator<? extends Contact> it = contactList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(contacts.get(i5).getName(), it.next().getName())) {
                        break;
                    }
                } else {
                    z7 = z6;
                    break;
                }
            }
            arrayList.add(Boolean.valueOf(z7));
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
        appCompatDialog.setContentView(R.layout.dialog_contact_chooser);
        appCompatDialog.setTitle(R.string.select_contacts);
        ListView listView = (ListView) appCompatDialog.findViewById(R.id.contacts_list);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = appCompatDialog.findViewById(R.id.radio_include);
        Intrinsics.checkNotNull(findViewById3);
        View findViewById4 = appCompatDialog.findViewById(R.id.radio_exclude);
        Intrinsics.checkNotNull(findViewById4);
        final RadioButton radioButton = (RadioButton) findViewById4;
        SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
        final ContactsAdapter contactsAdapter = new ContactsAdapter(activity, contacts, arrayList, null);
        Intrinsics.checkNotNull(listView);
        listView.setAdapter((ListAdapter) contactsAdapter);
        contactsAdapter.getFilter().filter("");
        Intrinsics.checkNotNull(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.contacts.ContactsHelper$displayContactChooser$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@NotNull String newText) {
                Intrinsics.checkNotNullParameter(newText, "newText");
                ContactsAdapter.this.getFilter().filter(newText);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@NotNull String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return false;
            }
        });
        ((RadioButton) findViewById3).setChecked(!z3);
        radioButton.setChecked(z3);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: y.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsHelper.c(AppCompatDialog.this, view);
            }
        });
        ((Button) findViewById).setOnClickListener(new View.OnClickListener() { // from class: y.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsHelper.d(ContactsAdapter.this, contactSelectionListener, radioButton, appCompatDialog, activity, view);
            }
        });
        appCompatDialog.show();
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
    }
}
