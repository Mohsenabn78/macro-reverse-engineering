package com.google.api.client.googleapis.extensions.android.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes5.dex */
public final class GoogleAccountManager {
    public static final String ACCOUNT_TYPE = "com.google";

    /* renamed from: a  reason: collision with root package name */
    private final AccountManager f25634a;

    public GoogleAccountManager(AccountManager accountManager) {
        this.f25634a = (AccountManager) Preconditions.checkNotNull(accountManager);
    }

    public Account getAccountByName(String str) {
        Account[] accounts;
        if (str != null) {
            for (Account account : getAccounts()) {
                if (str.equals(account.name)) {
                    return account;
                }
            }
            return null;
        }
        return null;
    }

    public AccountManager getAccountManager() {
        return this.f25634a;
    }

    public Account[] getAccounts() {
        return this.f25634a.getAccountsByType("com.google");
    }

    public void invalidateAuthToken(String str) {
        this.f25634a.invalidateAuthToken("com.google", str);
    }

    public GoogleAccountManager(Context context) {
        this(AccountManager.get(context));
    }
}
