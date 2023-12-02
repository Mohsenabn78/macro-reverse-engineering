package com.arlosoft.macrodroid.action;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SyncAdapterType;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accounts.AccountAdapter;
import com.arlosoft.macrodroid.action.info.SyncAccountActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SyncAccountAction extends Action {
    public static final Parcelable.Creator<SyncAccountAction> CREATOR = new a();
    private static int REQUEST_CODE_GET_ACCOUNTS = 2;
    private Account m_account;
    private String m_accountName;
    private List<String> m_authorities;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SyncAccountAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SyncAccountAction createFromParcel(Parcel parcel) {
            return new SyncAccountAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SyncAccountAction[] newArray(int i4) {
            return new SyncAccountAction[i4];
        }
    }

    /* synthetic */ SyncAccountAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void P(final Account account, List<String> list, final String str) {
        int i4;
        final String[] strArr = (String[]) list.toArray(new String[0]);
        boolean[] zArr = new boolean[list.size()];
        if (account.equals(this.m_account)) {
            i4 = 0;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                for (String str2 : this.m_authorities) {
                    if (str2.equals(strArr[i5])) {
                        zArr[i5] = true;
                        i4++;
                    }
                }
            }
        } else {
            i4 = 0;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Action_SmallerText);
        builder.setTitle(account.name);
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.action.yo
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i6, boolean z3) {
                SyncAccountAction.R(dialogInterface, i6, z3);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SyncAccountAction.this.S(strArr, account, str, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        if (i4 == 0) {
            create.getButton(-1).setEnabled(false);
        }
    }

    private Pair<Map<Account, List<String>>, Map<Account, String>> Q() {
        AuthenticatorDescription[] authenticatorDescriptionArr;
        Iterator<ApplicationInfo> it;
        Account[] accountArr;
        AccountManager accountManager = AccountManager.get(getContext());
        List<ApplicationInfo> installedApplications = getContext().getPackageManager().getInstalledApplications(128);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Account[] accounts = accountManager.getAccounts();
        AuthenticatorDescription[] authenticatorTypes = accountManager.getAuthenticatorTypes();
        SyncAdapterType[] syncAdapterTypes = ContentResolver.getSyncAdapterTypes();
        Iterator<ApplicationInfo> it2 = installedApplications.iterator();
        while (it2.hasNext()) {
            try {
                PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(it2.next().packageName, 8);
                if (packageInfo.providers != null) {
                    int i4 = 0;
                    while (true) {
                        ProviderInfo[] providerInfoArr = packageInfo.providers;
                        if (i4 >= providerInfoArr.length) {
                            break;
                        }
                        ProviderInfo providerInfo = providerInfoArr[i4];
                        int i5 = 0;
                        while (i5 < syncAdapterTypes.length) {
                            SyncAdapterType syncAdapterType = syncAdapterTypes[i5];
                            if (providerInfo.authority.equals(syncAdapterType.authority)) {
                                int length = accounts.length;
                                int i6 = 0;
                                while (i6 < length) {
                                    Account account = accounts[i6];
                                    if (syncAdapterType.accountType.equals(account.type)) {
                                        if (hashMap.get(account) == null) {
                                            try {
                                                hashMap.put(account, new ArrayList());
                                            } catch (Exception unused) {
                                            }
                                        }
                                        ((List) hashMap.get(account)).add(providerInfo.authority);
                                        int length2 = authenticatorTypes.length;
                                        int i7 = 0;
                                        while (i7 < length2) {
                                            it = it2;
                                            try {
                                                AuthenticatorDescription authenticatorDescription = authenticatorTypes[i7];
                                                authenticatorDescriptionArr = authenticatorTypes;
                                                try {
                                                    accountArr = accounts;
                                                } catch (Exception unused2) {
                                                    accountArr = accounts;
                                                    it2 = it;
                                                    authenticatorTypes = authenticatorDescriptionArr;
                                                    accounts = accountArr;
                                                }
                                                try {
                                                    if (authenticatorDescription.type.equals(account.type)) {
                                                        if (account.type.equals("com.google")) {
                                                            hashMap2.put(account, "com.google.android.googlequicksearchbox");
                                                        } else {
                                                            hashMap2.put(account, authenticatorDescription.packageName);
                                                        }
                                                        i6++;
                                                        it2 = it;
                                                        authenticatorTypes = authenticatorDescriptionArr;
                                                        accounts = accountArr;
                                                    } else {
                                                        i7++;
                                                        it2 = it;
                                                        authenticatorTypes = authenticatorDescriptionArr;
                                                        accounts = accountArr;
                                                    }
                                                } catch (Exception unused3) {
                                                    it2 = it;
                                                    authenticatorTypes = authenticatorDescriptionArr;
                                                    accounts = accountArr;
                                                }
                                            } catch (Exception unused4) {
                                                authenticatorDescriptionArr = authenticatorTypes;
                                            }
                                        }
                                    }
                                    authenticatorDescriptionArr = authenticatorTypes;
                                    it = it2;
                                    accountArr = accounts;
                                    i6++;
                                    it2 = it;
                                    authenticatorTypes = authenticatorDescriptionArr;
                                    accounts = accountArr;
                                }
                                continue;
                            }
                            i5++;
                            it2 = it2;
                            authenticatorTypes = authenticatorTypes;
                            accounts = accounts;
                        }
                        i4++;
                    }
                }
                authenticatorDescriptionArr = authenticatorTypes;
                it = it2;
                accountArr = accounts;
            } catch (Exception unused5) {
                authenticatorDescriptionArr = authenticatorTypes;
                it = it2;
            }
            it2 = it;
            authenticatorTypes = authenticatorDescriptionArr;
            accounts = accountArr;
        }
        return new Pair<>(hashMap, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(DialogInterface dialogInterface, int i4, boolean z3) {
        boolean z4;
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        int size = alertDialog.getListView().getCheckedItemPositions().size();
        Button button = alertDialog.getButton(-1);
        if (size > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(String[] strArr, Account account, String str, DialogInterface dialogInterface, int i4) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.getListView().getCheckedItemPositions();
        SparseBooleanArray checkedItemPositions = alertDialog.getListView().getCheckedItemPositions();
        this.m_authorities.clear();
        for (int i5 = 0; i5 < checkedItemPositions.size(); i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                this.m_authorities.add(strArr[checkedItemPositions.keyAt(i5)]);
            }
        }
        this.m_account = account;
        this.m_accountName = str;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(AppCompatDialog appCompatDialog, Pair pair, Account account, String str) {
        appCompatDialog.dismiss();
        List<String> list = (List) ((Map) pair.first).get(account);
        if (list.size() > 1) {
            P(account, list, str);
            return;
        }
        this.m_authorities = list;
        this.m_account = account;
        this.m_accountName = str;
        itemComplete();
    }

    private void U(final Pair<Map<Account, List<String>>, Map<Account, String>> pair) {
        if (pair.first.keySet().size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_accounts_found, 0).show();
            return;
        }
        Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_account_chooser);
        appCompatDialog.setTitle(R.string.action_sync_account_select_account);
        ((ListView) appCompatDialog.findViewById(R.id.accounts_list)).setAdapter((ListAdapter) new AccountAdapter(activity, pair.second, new AccountAdapter.AccountSelectionListener() { // from class: com.arlosoft.macrodroid.action.xo
            @Override // com.arlosoft.macrodroid.accounts.AccountAdapter.AccountSelectionListener
            public final void accountSelected(Account account, String str) {
                SyncAccountAction.this.T(appCompatDialog, pair, account, str);
            }
        }));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = this.m_accountName;
        if (str != null) {
            return str;
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SyncAccountActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        if (TextUtils.isEmpty(this.m_accountName)) {
            str = "";
        } else {
            str = " (" + this.m_accountName + ")";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.GET_ACCOUNTS"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE_GET_ACCOUNTS && i5 == -1) {
            U(Q());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Intent newChooseAccountIntent;
        if (!checkActivityAlive()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            SyncAdapterType[] syncAdapterTypes = ContentResolver.getSyncAdapterTypes();
            ArrayList arrayList = new ArrayList();
            for (SyncAdapterType syncAdapterType : syncAdapterTypes) {
                arrayList.add(syncAdapterType.accountType);
            }
            newChooseAccountIntent = AccountManager.newChooseAccountIntent(null, null, (String[]) arrayList.toArray(new String[0]), null, null, null, null);
            getActivity().startActivityForResult(newChooseAccountIntent, REQUEST_CODE_GET_ACCOUNTS);
            return;
        }
        U(Q());
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        for (String str : this.m_authorities) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            bundle.putBoolean("expedited", true);
            ContentResolver.requestSync(this.m_account, str, bundle);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_account, i4);
        parcel.writeStringList(this.m_authorities);
        parcel.writeString(this.m_accountName);
    }

    public SyncAccountAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SyncAccountAction() {
        this.m_authorities = new ArrayList();
    }

    private SyncAccountAction(Parcel parcel) {
        super(parcel);
        this.m_account = (Account) parcel.readParcelable(Account.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.m_authorities = arrayList;
        parcel.readStringList(arrayList);
        this.m_accountName = parcel.readString();
    }
}
