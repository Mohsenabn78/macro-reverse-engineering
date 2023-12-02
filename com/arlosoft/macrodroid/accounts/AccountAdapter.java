package com.arlosoft.macrodroid.accounts;

import android.accounts.Account;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accounts.AccountAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AccountAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final AccountSelectionListener f2057a;

    /* renamed from: b  reason: collision with root package name */
    private List<Account> f2058b;

    /* renamed from: c  reason: collision with root package name */
    private Map<Account, String> f2059c;

    /* renamed from: d  reason: collision with root package name */
    private PackageManager f2060d;

    /* loaded from: classes2.dex */
    public interface AccountSelectionListener {
        void accountSelected(Account account, String str);
    }

    public AccountAdapter(@NonNull Activity activity, @NonNull Map<Account, String> map, @Nullable AccountSelectionListener accountSelectionListener) {
        this.f2057a = accountSelectionListener;
        this.f2059c = map;
        this.f2058b = new ArrayList(map.keySet());
        this.f2060d = activity.getApplicationContext().getPackageManager();
    }

    private void b(int i4, View view) {
        CharSequence charSequence;
        final Account account = (Account) getItem(i4);
        TextView textView = (TextView) view.findViewById(R.id.app_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.app_icon);
        ((TextView) view.findViewById(R.id.account_name)).setText(account.name);
        final String str = this.f2059c.get(account);
        final String str2 = null;
        ApplicationInfo applicationInfo = null;
        if (str != null) {
            try {
                applicationInfo = this.f2060d.getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (applicationInfo != null) {
                charSequence = this.f2060d.getApplicationLabel(applicationInfo);
            } else {
                charSequence = str;
            }
            str2 = (String) charSequence;
            textView.setText(str2);
            e(imageView, str);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: q.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountAdapter.this.c(account, str2, str, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Account account, String str, String str2, View view) {
        AccountSelectionListener accountSelectionListener = this.f2057a;
        if (accountSelectionListener != null) {
            if (str == null) {
                str = str2;
            }
            accountSelectionListener.accountSelected(account, str);
        }
    }

    private View d(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_account, viewGroup, false);
    }

    private void e(ImageView imageView, String str) {
        try {
            imageView.setImageDrawable(this.f2060d.getApplicationIcon(str));
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2058b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return this.f2058b.get(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = d(viewGroup);
        }
        b(i4, view);
        return view;
    }
}
