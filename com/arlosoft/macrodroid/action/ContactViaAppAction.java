package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ContactViaAppActionInfo;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tbruyelle.rxpermissions2.RxPermissions;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactViaAppAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nContactViaAppAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactViaAppAction.kt\ncom/arlosoft/macrodroid/action/ContactViaAppAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,239:1\n1549#2:240\n1620#2,3:241\n1549#2:246\n1620#2,3:247\n1549#2:252\n1620#2,3:253\n37#3,2:244\n37#3,2:250\n*S KotlinDebug\n*F\n+ 1 ContactViaAppAction.kt\ncom/arlosoft/macrodroid/action/ContactViaAppAction\n*L\n98#1:240\n98#1:241,3\n101#1:246\n101#1:247,3\n184#1:252\n184#1:253,3\n98#1:244,2\n178#1:250,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ContactViaAppAction extends Action {
    @Nullable
    private String appName;
    @Nullable
    private String appPackage;
    @Nullable
    private Contact contact;
    @Nullable
    private String id;
    @Nullable
    private String mimeType;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ContactViaAppAction> CREATOR = new Parcelable.Creator<ContactViaAppAction>() { // from class: com.arlosoft.macrodroid.action.ContactViaAppAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ContactViaAppAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContactViaAppAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ContactViaAppAction[] newArray(int i4) {
            return new ContactViaAppAction[i4];
        }
    };

    /* compiled from: ContactViaAppAction.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class ContactMimeInfo {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f2154a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f2155b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final String f2156c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final String f2157d;

        public ContactMimeInfo(@NotNull String mimeType, @NotNull String id, @NotNull String packageName, @NotNull String appName) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(appName, "appName");
            this.f2154a = mimeType;
            this.f2155b = id;
            this.f2156c = packageName;
            this.f2157d = appName;
        }

        public static /* synthetic */ ContactMimeInfo copy$default(ContactMimeInfo contactMimeInfo, String str, String str2, String str3, String str4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = contactMimeInfo.f2154a;
            }
            if ((i4 & 2) != 0) {
                str2 = contactMimeInfo.f2155b;
            }
            if ((i4 & 4) != 0) {
                str3 = contactMimeInfo.f2156c;
            }
            if ((i4 & 8) != 0) {
                str4 = contactMimeInfo.f2157d;
            }
            return contactMimeInfo.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.f2154a;
        }

        @NotNull
        public final String component2() {
            return this.f2155b;
        }

        @NotNull
        public final String component3() {
            return this.f2156c;
        }

        @NotNull
        public final String component4() {
            return this.f2157d;
        }

        @NotNull
        public final ContactMimeInfo copy(@NotNull String mimeType, @NotNull String id, @NotNull String packageName, @NotNull String appName) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(appName, "appName");
            return new ContactMimeInfo(mimeType, id, packageName, appName);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ContactMimeInfo)) {
                return false;
            }
            ContactMimeInfo contactMimeInfo = (ContactMimeInfo) obj;
            if (Intrinsics.areEqual(this.f2154a, contactMimeInfo.f2154a) && Intrinsics.areEqual(this.f2155b, contactMimeInfo.f2155b) && Intrinsics.areEqual(this.f2156c, contactMimeInfo.f2156c) && Intrinsics.areEqual(this.f2157d, contactMimeInfo.f2157d)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getAppName() {
            return this.f2157d;
        }

        @NotNull
        public final String getId() {
            return this.f2155b;
        }

        @NotNull
        public final String getMimeType() {
            return this.f2154a;
        }

        @NotNull
        public final String getPackageName() {
            return this.f2156c;
        }

        public int hashCode() {
            return (((((this.f2154a.hashCode() * 31) + this.f2155b.hashCode()) * 31) + this.f2156c.hashCode()) * 31) + this.f2157d.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.f2154a;
            String str2 = this.f2155b;
            String str3 = this.f2156c;
            String str4 = this.f2157d;
            return "ContactMimeInfo(mimeType=" + str + ", id=" + str2 + ", packageName=" + str3 + ", appName=" + str4 + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ContactViaAppAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ArrayAdapter<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Context context, @LayoutRes int i4, @NotNull String[] objects) {
            super(context, i4, objects);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(objects, "objects");
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NotNull
        public View getView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view2 = super.getView(i4, view, parent);
            Intrinsics.checkNotNullExpressionValue(view2, "super.getView(position, convertView, parent)");
            TextView textView = (TextView) view2.findViewById(16908308);
            if (textView != null) {
                textView.setText(Html.fromHtml((String) getItem(i4)));
            }
            return view2;
        }
    }

    /* compiled from: ContactViaAppAction.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<Boolean, Unit> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            if (z3) {
                ContactViaAppAction.this.X();
            }
        }
    }

    public /* synthetic */ ContactViaAppAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void T(final Contact contact) {
        boolean z3;
        int collectionSizeOrDefault;
        int indexOf;
        ApplicationInfo applicationInfo;
        CharSequence charSequence;
        int indexOf$default;
        PackageManager packageManager = getContext().getPackageManager();
        ContentResolver contentResolver = getContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        Cursor query = contentResolver.query(ContactsContract.Data.CONTENT_URI, null, null, null, "display_name");
        ArrayList arrayList = new ArrayList();
        final ArrayList<ContactMimeInfo> arrayList2 = new ArrayList();
        if (query != null) {
            while (query.moveToNext()) {
                String id = query.getString(query.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID));
                String string = query.getString(query.getColumnIndex("lookup"));
                String accountType = query.getString(query.getColumnIndex("account_type_and_data_set"));
                String mimeType = query.getString(query.getColumnIndex("mimetype"));
                if (Intrinsics.areEqual(string, contact.getLookupKey())) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setDataAndType(Uri.parse("content://com.android.contacts/data/" + id), mimeType);
                    ComponentName componentName = intent.resolveActivity(packageManager);
                    if (componentName != null) {
                        Intrinsics.checkNotNullExpressionValue(componentName, "componentName");
                        try {
                            applicationInfo = packageManager.getApplicationInfo(componentName.getPackageName(), 0);
                        } catch (PackageManager.NameNotFoundException unused) {
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            charSequence = packageManager.getApplicationLabel(applicationInfo);
                        } else {
                            charSequence = null;
                        }
                        if (charSequence != null) {
                            Intrinsics.checkNotNullExpressionValue(mimeType, "mimeType");
                            Intrinsics.checkNotNullExpressionValue(id, "id");
                            Intrinsics.checkNotNullExpressionValue(accountType, "accountType");
                            ContactMimeInfo contactMimeInfo = new ContactMimeInfo(mimeType, id, accountType, charSequence.toString());
                            if (!arrayList2.contains(contactMimeInfo)) {
                                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) mimeType, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null);
                                String substring = mimeType.substring(indexOf$default + 1);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                arrayList.add("<b>" + ((Object) charSequence) + "</b><br/><i><small>" + substring + "</small></i>");
                                arrayList2.add(contactMimeInfo);
                            }
                        }
                    }
                }
            }
            query.close();
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (strArr.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (ContactMimeInfo contactMimeInfo2 : arrayList2) {
                arrayList3.add(contactMimeInfo2.getMimeType());
            }
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends String>) ((List<? extends Object>) arrayList3), this.mimeType);
            int max = Math.max(indexOf, 0);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            a aVar = new a(activity, R.layout.single_choice_list_item, strArr);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(p());
            builder.setSingleChoiceItems(aVar, max, (DialogInterface.OnClickListener) null);
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ContactViaAppAction.U(ContactViaAppAction.this, dialogInterface, i4);
                }
            });
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.p4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ContactViaAppAction.V(arrayList2, this, contact, dialogInterface, i4);
                }
            });
            AlertDialog create = builder.create();
            Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
            create.show();
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.q4
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    ContactViaAppAction.W(ContactViaAppAction.this, dialogInterface);
                }
            });
            return;
        }
        ToastCompat.makeText(getContext(), (int) R.string.no_app_available, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ContactViaAppAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(List contactMimeInfoList, ContactViaAppAction this$0, Contact contact, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(contactMimeInfoList, "$contactMimeInfoList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        ContactMimeInfo contactMimeInfo = (ContactMimeInfo) contactMimeInfoList.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
        this$0.mimeType = contactMimeInfo.getMimeType();
        this$0.contact = contact;
        this$0.appPackage = contactMimeInfo.getPackageName();
        this$0.id = contactMimeInfo.getId();
        this$0.appName = contactMimeInfo.getAppName();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(ContactViaAppAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        int collectionSizeOrDefault;
        boolean z3;
        int collectionSizeOrDefault2;
        String str;
        final List<Contact> contacts = Util.getContacts(getContext());
        Intrinsics.checkNotNullExpressionValue(contacts, "contacts");
        List<Contact> list = contacts;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Contact contact : list) {
            arrayList.add(contact.getName());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (strArr.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (Contact contact2 : list) {
                arrayList2.add(contact2.getLookupKey());
            }
            Contact contact3 = this.contact;
            if (contact3 != null) {
                str = contact3.getLookupKey();
            } else {
                str = null;
            }
            int max = Math.max(arrayList2.indexOf(str), 0);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(p());
            builder.setSingleChoiceItems(strArr, max, (DialogInterface.OnClickListener) null);
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.k4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ContactViaAppAction.Y(ContactViaAppAction.this, dialogInterface, i4);
                }
            });
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.l4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ContactViaAppAction.Z(ContactViaAppAction.this, contacts, dialogInterface, i4);
                }
            });
            AlertDialog create = builder.create();
            Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
            create.show();
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.m4
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    ContactViaAppAction.a0(ContactViaAppAction.this, dialogInterface);
                }
            });
            if (strArr.length > 50) {
                ListView listView = create.getListView();
                listView.setFastScrollEnabled(true);
                listView.setPadding(0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.fast_scroll_padding), 0);
                listView.setScrollBarStyle(33554432);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ContactViaAppAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ContactViaAppAction this$0, List list, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        Object obj = list.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
        Intrinsics.checkNotNullExpressionValue(obj, "contacts[position]");
        this$0.T((Contact) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ContactViaAppAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str;
        Contact contact = this.contact;
        if (contact != null) {
            str = contact.getName();
        } else {
            str = null;
        }
        String str2 = this.appName;
        return str + " (" + str2 + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ContactViaAppActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String str;
        String configuredName = getConfiguredName();
        Contact contact = this.contact;
        if (contact != null) {
            str = contact.getName();
        } else {
            str = null;
        }
        return configuredName + " (" + str + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_CONTACTS", "android.permission.CALL_PHONE"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        Observable<Boolean> observeOn = new RxPermissions((FragmentActivity) activity).request("android.permission.READ_CONTACTS").observeOn(AndroidSchedulers.mainThread());
        final b bVar = new b();
        observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.action.n4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactViaAppAction.b0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.parse("content://com.android.contacts/data/" + this.id), this.mimeType);
            intent.putExtra("android.intent.extra.TEXT", "This is some test text");
            getContext().startActivity(intent);
        } catch (Exception e4) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Contact via app failed: " + e4, macroGuid.longValue());
            ToastCompat.makeText(getContext(), (CharSequence) (SelectableItem.r(R.string.error) + ": " + e4), 0).show();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.mimeType);
        out.writeParcelable(this.contact, i4);
        out.writeString(this.appPackage);
        out.writeString(this.appName);
        out.writeString(this.id);
    }

    public ContactViaAppAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ContactViaAppAction() {
    }

    private ContactViaAppAction(Parcel parcel) {
        super(parcel);
        this.mimeType = parcel.readString();
        this.contact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.appPackage = parcel.readString();
        this.appName = parcel.readString();
        this.id = parcel.readString();
    }

    /* compiled from: ContactViaAppAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
