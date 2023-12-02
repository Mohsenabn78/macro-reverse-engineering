package com.firebase.ui.auth.util.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailLinkPersistenceManager {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f18214b = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.firebase.ui.auth.data.client.email", "com.firebase.ui.auth.data.client.provider", "com.firebase.ui.auth.data.client.idpToken", "com.firebase.ui.auth.data.client.idpSecret")));

    /* renamed from: c  reason: collision with root package name */
    private static final EmailLinkPersistenceManager f18215c = new EmailLinkPersistenceManager();

    /* renamed from: a  reason: collision with root package name */
    private AuthCredential f18216a;

    /* loaded from: classes3.dex */
    public static class SessionRecord {

        /* renamed from: a  reason: collision with root package name */
        private String f18217a;

        /* renamed from: b  reason: collision with root package name */
        private String f18218b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f18219c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private IdpResponse f18220d;

        public SessionRecord(@NonNull String str, @Nullable String str2) {
            Preconditions.checkNotNull(str);
            this.f18217a = str;
            this.f18219c = str2;
        }

        @Nullable
        public String getAnonymousUserId() {
            return this.f18219c;
        }

        public String getEmail() {
            return this.f18218b;
        }

        @Nullable
        public IdpResponse getIdpResponseForLinking() {
            return this.f18220d;
        }

        public String getSessionId() {
            return this.f18217a;
        }

        public SessionRecord setEmail(@NonNull String str) {
            this.f18218b = str;
            return this;
        }

        public SessionRecord setIdpResponseForLinking(@NonNull IdpResponse idpResponse) {
            this.f18220d = idpResponse;
            return this;
        }
    }

    public static EmailLinkPersistenceManager getInstance() {
        return f18215c;
    }

    public void clearAllData(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0).edit();
        for (String str : f18214b) {
            edit.remove(str);
        }
        edit.apply();
    }

    @Nullable
    public SessionRecord retrieveSessionRecord(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0);
        String string = sharedPreferences.getString("com.firebase.ui.auth.data.client.email", null);
        String string2 = sharedPreferences.getString("com.firebase.ui.auth.data.client.sid", null);
        if (string == null || string2 == null) {
            return null;
        }
        String string3 = sharedPreferences.getString("com.firebase.ui.auth.data.client.auid", null);
        String string4 = sharedPreferences.getString("com.firebase.ui.auth.data.client.provider", null);
        String string5 = sharedPreferences.getString("com.firebase.ui.auth.data.client.idpToken", null);
        String string6 = sharedPreferences.getString("com.firebase.ui.auth.data.client.idpSecret", null);
        SessionRecord email = new SessionRecord(string2, string3).setEmail(string);
        if (string4 != null && (string5 != null || this.f18216a != null)) {
            email.setIdpResponseForLinking(new IdpResponse.Builder(new User.Builder(string4, string).build()).setPendingCredential(this.f18216a).setToken(string5).setSecret(string6).setNewUser(false).build());
        }
        this.f18216a = null;
        return email;
    }

    public void saveEmail(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable String str3) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0).edit();
        edit.putString("com.firebase.ui.auth.data.client.email", str);
        edit.putString("com.firebase.ui.auth.data.client.auid", str3);
        edit.putString("com.firebase.ui.auth.data.client.sid", str2);
        edit.apply();
    }

    public void saveIdpResponseForLinking(@NonNull Context context, @NonNull IdpResponse idpResponse) {
        if (idpResponse.hasCredentialForLinking()) {
            this.f18216a = idpResponse.getCredentialForLinking();
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(idpResponse);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0).edit();
        edit.putString("com.firebase.ui.auth.data.client.email", idpResponse.getEmail());
        edit.putString("com.firebase.ui.auth.data.client.provider", idpResponse.getProviderType());
        edit.putString("com.firebase.ui.auth.data.client.idpToken", idpResponse.getIdpToken());
        edit.putString("com.firebase.ui.auth.data.client.idpSecret", idpResponse.getIdpSecret());
        edit.apply();
    }
}
