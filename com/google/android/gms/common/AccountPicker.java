package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class AccountPicker {

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes4.dex */
    public static class AccountChooserOptions {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f19930a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f19931b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private ArrayList f19932c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private ArrayList f19933d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f19934e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private String f19935f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private Bundle f19936g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f19937h;

        /* renamed from: i  reason: collision with root package name */
        private int f19938i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private String f19939j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f19940k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private zza f19941l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private String f19942m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f19943n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f19944o;

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        /* loaded from: classes4.dex */
        public static class Builder {
            @Nullable

            /* renamed from: a  reason: collision with root package name */
            private Account f19945a;
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            private ArrayList f19946b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private ArrayList f19947c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f19948d = false;
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            private String f19949e;
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            private Bundle f19950f;

            @NonNull
            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                accountChooserOptions.f19933d = this.f19947c;
                accountChooserOptions.f19932c = this.f19946b;
                accountChooserOptions.f19934e = this.f19948d;
                accountChooserOptions.f19941l = null;
                accountChooserOptions.f19939j = null;
                accountChooserOptions.f19936g = this.f19950f;
                accountChooserOptions.f19930a = this.f19945a;
                accountChooserOptions.f19931b = false;
                accountChooserOptions.f19937h = false;
                accountChooserOptions.f19942m = null;
                accountChooserOptions.f19938i = 0;
                accountChooserOptions.f19935f = this.f19949e;
                accountChooserOptions.f19940k = false;
                accountChooserOptions.f19943n = false;
                accountChooserOptions.f19944o = false;
                return accountChooserOptions;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAllowableAccounts(@Nullable List<Account> list) {
                ArrayList arrayList;
                if (list == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(list);
                }
                this.f19946b = arrayList;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAllowableAccountsTypes(@Nullable List<String> list) {
                ArrayList arrayList;
                if (list == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(list);
                }
                this.f19947c = arrayList;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAlwaysShowAccountPicker(boolean z3) {
                this.f19948d = z3;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setOptionsForAddingAccount(@Nullable Bundle bundle) {
                this.f19950f = bundle;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setSelectedAccount(@Nullable Account account) {
                this.f19945a = account;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setTitleOverrideText(@Nullable String str) {
                this.f19949e = str;
                return this;
            }
        }

        static /* bridge */ /* synthetic */ boolean D(AccountChooserOptions accountChooserOptions) {
            boolean z3 = accountChooserOptions.f19943n;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean a(AccountChooserOptions accountChooserOptions) {
            boolean z3 = accountChooserOptions.f19944o;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean b(AccountChooserOptions accountChooserOptions) {
            boolean z3 = accountChooserOptions.f19931b;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean c(AccountChooserOptions accountChooserOptions) {
            boolean z3 = accountChooserOptions.f19937h;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean d(AccountChooserOptions accountChooserOptions) {
            boolean z3 = accountChooserOptions.f19940k;
            return false;
        }

        static /* bridge */ /* synthetic */ int e(AccountChooserOptions accountChooserOptions) {
            int i4 = accountChooserOptions.f19938i;
            return 0;
        }

        static /* bridge */ /* synthetic */ zza h(AccountChooserOptions accountChooserOptions) {
            zza zzaVar = accountChooserOptions.f19941l;
            return null;
        }

        static /* bridge */ /* synthetic */ String i(AccountChooserOptions accountChooserOptions) {
            String str = accountChooserOptions.f19939j;
            return null;
        }

        static /* bridge */ /* synthetic */ String j(AccountChooserOptions accountChooserOptions) {
            String str = accountChooserOptions.f19942m;
            return null;
        }
    }

    private AccountPicker() {
    }

    @NonNull
    @Deprecated
    public static Intent newChooseAccountIntent(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z3, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z3);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    @NonNull
    public static Intent newChooseAccountIntent(@NonNull AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        AccountChooserOptions.d(accountChooserOptions);
        AccountChooserOptions.i(accountChooserOptions);
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        AccountChooserOptions.h(accountChooserOptions);
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        AccountChooserOptions.b(accountChooserOptions);
        Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
        AccountChooserOptions.d(accountChooserOptions);
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.f19932c);
        if (accountChooserOptions.f19933d != null) {
            intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.f19933d.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.f19936g);
        intent.putExtra("selectedAccount", accountChooserOptions.f19930a);
        AccountChooserOptions.b(accountChooserOptions);
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.f19934e);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.f19935f);
        AccountChooserOptions.c(accountChooserOptions);
        intent.putExtra("setGmsCoreAccount", false);
        AccountChooserOptions.j(accountChooserOptions);
        intent.putExtra("realClientPackage", (String) null);
        AccountChooserOptions.e(accountChooserOptions);
        intent.putExtra("overrideTheme", 0);
        AccountChooserOptions.d(accountChooserOptions);
        intent.putExtra("overrideCustomTheme", 0);
        AccountChooserOptions.i(accountChooserOptions);
        intent.putExtra("hostedDomainFilter", (String) null);
        Bundle bundle = new Bundle();
        AccountChooserOptions.d(accountChooserOptions);
        AccountChooserOptions.h(accountChooserOptions);
        AccountChooserOptions.D(accountChooserOptions);
        AccountChooserOptions.a(accountChooserOptions);
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
