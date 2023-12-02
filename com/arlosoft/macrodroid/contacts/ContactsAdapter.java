package com.arlosoft.macrodroid.contacts;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.glide.GlideLoader;
import com.arlosoft.macrodroid.common.Contact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class ContactsAdapter extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private final ContactSelectionListener f10685a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Contact> f10686b;

    /* renamed from: c  reason: collision with root package name */
    private List<Contact> f10687c;

    /* renamed from: d  reason: collision with root package name */
    private List<Contact> f10688d;

    /* renamed from: e  reason: collision with root package name */
    private Context f10689e;

    /* renamed from: f  reason: collision with root package name */
    private PackageManager f10690f;

    /* renamed from: g  reason: collision with root package name */
    private GlideLoader f10691g = new GlideLoader();

    /* loaded from: classes3.dex */
    public interface ContactSelectionListener {
        void contactSelected(Contact contact);
    }

    /* loaded from: classes3.dex */
    class a extends Filter {

        /* renamed from: a  reason: collision with root package name */
        boolean f10692a = false;

        a() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            int size = ContactsAdapter.this.f10687c.size();
            for (int i4 = 0; i4 < size; i4++) {
                Contact contact = (Contact) ContactsAdapter.this.f10687c.get(i4);
                if (charSequence == null || charSequence.toString().length() == 0 || contact.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                    arrayList.add(contact);
                }
            }
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ContactsAdapter.this.f10688d = (List) filterResults.values;
            ContactsAdapter.this.notifyDataSetChanged();
        }
    }

    public ContactsAdapter(@NonNull Activity activity, @NonNull List<Contact> list, @Nullable List<Boolean> list2, @Nullable ContactSelectionListener contactSelectionListener) {
        this.f10685a = contactSelectionListener;
        this.f10689e = activity.getApplicationContext();
        if (list2 != null) {
            this.f10686b = new HashSet();
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (list2.get(i4).booleanValue()) {
                    this.f10686b.add(list.get(i4));
                }
            }
        } else {
            this.f10686b = null;
        }
        this.f10690f = this.f10689e.getPackageManager();
        this.f10687c = list;
        this.f10688d = new ArrayList(this.f10687c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c9, code lost:
        if (r7.equals(com.arlosoft.macrodroid.common.Util.ANY_CONTACT_ID) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(int r7, android.view.View r8) {
        /*
            r6 = this;
            java.lang.Object r7 = r6.getItem(r7)
            com.arlosoft.macrodroid.common.Contact r7 = (com.arlosoft.macrodroid.common.Contact) r7
            r0 = 2131362437(0x7f0a0285, float:1.8344655E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131362436(0x7f0a0284, float:1.8344653E38)
            android.view.View r1 = r8.findViewById(r1)
            com.arlosoft.macrodroid.avatar.views.AvatarView r1 = (com.arlosoft.macrodroid.avatar.views.AvatarView) r1
            r2 = 2131364093(0x7f0a08fd, float:1.8348013E38)
            android.view.View r2 = r8.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r3 = 2131362268(0x7f0a01dc, float:1.8344312E38)
            android.view.View r3 = r8.findViewById(r3)
            android.widget.CheckBox r3 = (android.widget.CheckBox) r3
            r4 = 2131363072(0x7f0a0500, float:1.8345942E38)
            android.view.View r4 = r8.findViewById(r4)
            android.widget.ViewFlipper r4 = (android.widget.ViewFlipper) r4
            java.util.Set<com.arlosoft.macrodroid.common.Contact> r5 = r6.f10686b
            if (r5 != 0) goto L45
            r5 = 8
            r3.setVisibility(r5)
            y.a r3 = new y.a
            r3.<init>()
            r8.setOnClickListener(r3)
            goto L62
        L45:
            r5 = 0
            r3.setOnCheckedChangeListener(r5)
            java.util.Set<com.arlosoft.macrodroid.common.Contact> r5 = r6.f10686b
            boolean r5 = r5.contains(r7)
            r3.setChecked(r5)
            y.b r5 = new y.b
            r5.<init>()
            r3.setOnCheckedChangeListener(r5)
            y.c r5 = new y.c
            r5.<init>()
            r8.setOnClickListener(r5)
        L62:
            java.lang.String r8 = r7.getName()
            r0.setText(r8)
            java.lang.String r8 = r7.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r8 = r8.intValue()
            r0 = 0
            if (r8 <= 0) goto L8d
            r4.setDisplayedChild(r0)
            java.lang.String r8 = r7.getId()
            android.net.Uri r8 = r6.getContactImageUri(r8)
            com.arlosoft.macrodroid.avatar.glide.GlideLoader r0 = r6.f10691g
            java.lang.String r7 = r7.getName()
            r0.loadImage(r1, r8, r7)
            goto Leb
        L8d:
            r8 = 1
            r4.setDisplayedChild(r8)
            java.lang.String r7 = r7.getId()
            r7.hashCode()
            int r1 = r7.hashCode()
            r3 = -1
            switch(r1) {
                case 1444: goto Lc3;
                case 1445: goto Lb8;
                case 1446: goto Lad;
                case 1447: goto La2;
                default: goto La0;
            }
        La0:
            r0 = -1
            goto Lcc
        La2:
            java.lang.String r8 = "-4"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto Lab
            goto La0
        Lab:
            r0 = 3
            goto Lcc
        Lad:
            java.lang.String r8 = "-3"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto Lb6
            goto La0
        Lb6:
            r0 = 2
            goto Lcc
        Lb8:
            java.lang.String r0 = "-2"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto Lc1
            goto La0
        Lc1:
            r0 = 1
            goto Lcc
        Lc3:
            java.lang.String r8 = "-1"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto Lcc
            goto La0
        Lcc:
            switch(r0) {
                case 0: goto Le5;
                case 1: goto Lde;
                case 2: goto Ld7;
                case 3: goto Ld0;
                default: goto Lcf;
            }
        Lcf:
            goto Leb
        Ld0:
            r7 = 2131231151(0x7f0801af, float:1.8078375E38)
            r2.setImageResource(r7)
            goto Leb
        Ld7:
            r7 = 2131233521(0x7f080af1, float:1.8083182E38)
            r2.setImageResource(r7)
            goto Leb
        Lde:
            r7 = 2131230879(0x7f08009f, float:1.8077823E38)
            r2.setImageResource(r7)
            goto Leb
        Le5:
            r7 = 2131232427(0x7f0806ab, float:1.8080963E38)
            r2.setImageResource(r7)
        Leb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.contacts.ContactsAdapter.f(int, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Contact contact, View view) {
        ContactSelectionListener contactSelectionListener = this.f10685a;
        if (contactSelectionListener != null) {
            contactSelectionListener.contactSelected(contact);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Contact contact, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.f10686b.add(contact);
        } else {
            this.f10686b.remove(contact);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(CheckBox checkBox, View view) {
        checkBox.setChecked(!checkBox.isChecked());
    }

    private View j(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_item, viewGroup, false);
    }

    public List<Contact> getCheckedItems() {
        return new ArrayList(this.f10686b);
    }

    public Uri getContactImageUri(String str) {
        return ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.valueOf(str).longValue());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10688d.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new a();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return this.f10688d.get(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = j(viewGroup);
        }
        f(i4, view);
        return view;
    }
}
