package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@VisibleForTesting
@KeepForSdk
/* loaded from: classes4.dex */
public final class ClientSettings {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Account f20423a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f20424b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f20425c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f20426d;

    /* renamed from: e  reason: collision with root package name */
    private final int f20427e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final View f20428f;

    /* renamed from: g  reason: collision with root package name */
    private final String f20429g;

    /* renamed from: h  reason: collision with root package name */
    private final String f20430h;

    /* renamed from: i  reason: collision with root package name */
    private final SignInOptions f20431i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f20432j;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f20433a;

        /* renamed from: b  reason: collision with root package name */
        private ArraySet f20434b;

        /* renamed from: c  reason: collision with root package name */
        private String f20435c;

        /* renamed from: d  reason: collision with root package name */
        private String f20436d;

        /* renamed from: e  reason: collision with root package name */
        private final SignInOptions f20437e = SignInOptions.zaa;

        @NonNull
        @KeepForSdk
        public ClientSettings build() {
            return new ClientSettings(this.f20433a, this.f20434b, null, 0, null, this.f20435c, this.f20436d, this.f20437e, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder setRealClientPackageName(@NonNull String str) {
            this.f20435c = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zaa(@NonNull Collection collection) {
            if (this.f20434b == null) {
                this.f20434b = new ArraySet();
            }
            this.f20434b.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zab(@Nullable Account account) {
            this.f20433a = account;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zac(@NonNull String str) {
            this.f20436d = str;
            return this;
        }
    }

    @KeepForSdk
    public ClientSettings(@NonNull Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, zab> map, int i4, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions) {
        this(account, set, map, i4, view, str, str2, signInOptions, false);
    }

    @NonNull
    @KeepForSdk
    public static ClientSettings createDefault(@NonNull Context context) {
        return new GoogleApiClient.Builder(context).zaa();
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    public Account getAccount() {
        return this.f20423a;
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    @Deprecated
    public String getAccountName() {
        Account account = this.f20423a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public Account getAccountOrDefault() {
        Account account = this.f20423a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getAllRequestedScopes() {
        return this.f20425c;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getApplicableScopes(@NonNull Api<?> api) {
        zab zabVar = (zab) this.f20426d.get(api);
        if (zabVar != null && !zabVar.zaa.isEmpty()) {
            HashSet hashSet = new HashSet(this.f20424b);
            hashSet.addAll(zabVar.zaa);
            return hashSet;
        }
        return this.f20424b;
    }

    @KeepForSdk
    public int getGravityForPopups() {
        return this.f20427e;
    }

    @NonNull
    @KeepForSdk
    public String getRealClientPackageName() {
        return this.f20429g;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequiredScopes() {
        return this.f20424b;
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    public View getViewForPopups() {
        return this.f20428f;
    }

    @NonNull
    public final SignInOptions zaa() {
        return this.f20431i;
    }

    @androidx.annotation.Nullable
    public final Integer zab() {
        return this.f20432j;
    }

    @androidx.annotation.Nullable
    public final String zac() {
        return this.f20430h;
    }

    @NonNull
    public final Map zad() {
        return this.f20426d;
    }

    public final void zae(@NonNull Integer num) {
        this.f20432j = num;
    }

    public ClientSettings(@Nullable Account account, @NonNull Set set, @NonNull Map map, int i4, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions, boolean z3) {
        this.f20423a = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f20424b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f20426d = map;
        this.f20428f = view;
        this.f20427e = i4;
        this.f20429g = str;
        this.f20430h = str2;
        this.f20431i = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(emptySet);
        for (zab zabVar : map.values()) {
            hashSet.addAll(zabVar.zaa);
        }
        this.f20425c = Collections.unmodifiableSet(hashSet);
    }
}
