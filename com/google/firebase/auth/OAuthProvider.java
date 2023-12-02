package com.google.firebase.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzabe;
import com.google.android.gms.internal.p002firebaseauthapi.zzacq;
import com.google.firebase.auth.internal.GenericIdpActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public class OAuthProvider extends FederatedAuthProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f28900a;

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final FirebaseAuth f28901a;
        @VisibleForTesting

        /* renamed from: b  reason: collision with root package name */
        final Bundle f28902b;

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f28903c;

        /* synthetic */ Builder(String str, FirebaseAuth firebaseAuth, zzan zzanVar) {
            Bundle bundle = new Bundle();
            this.f28902b = bundle;
            Bundle bundle2 = new Bundle();
            this.f28903c = bundle2;
            this.f28901a = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", zzabe.zza().zzb());
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            bundle.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
        }

        @NonNull
        public Builder addCustomParameter(@NonNull String str, @NonNull String str2) {
            this.f28903c.putString(str, str2);
            return this;
        }

        @NonNull
        public Builder addCustomParameters(@NonNull Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f28903c.putString(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @NonNull
        public OAuthProvider build() {
            return new OAuthProvider(this.f28902b, null);
        }

        @NonNull
        @KeepForSdk
        public List<String> getScopes() {
            ArrayList<String> stringArrayList = this.f28902b.getStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
            if (stringArrayList != null) {
                return stringArrayList;
            }
            return Collections.emptyList();
        }

        @NonNull
        public Builder setScopes(@NonNull List<String> list) {
            this.f28902b.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList<>(list));
            return this;
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    /* loaded from: classes5.dex */
    public static class CredentialBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final String f28904a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private String f28905b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f28906c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private String f28907d;

        /* synthetic */ CredentialBuilder(String str, zzao zzaoVar) {
            this.f28904a = str;
        }

        @NonNull
        public AuthCredential build() {
            String str = this.f28904a;
            String str2 = this.f28905b;
            String str3 = this.f28906c;
            String str4 = this.f28907d;
            Parcelable.Creator<zze> creator = zze.CREATOR;
            Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
            }
            return new zze(str, str2, str3, null, null, null, str4);
        }

        @Nullable
        @KeepForSdk
        public String getAccessToken() {
            return this.f28906c;
        }

        @Nullable
        @KeepForSdk
        public String getIdToken() {
            return this.f28905b;
        }

        @NonNull
        public CredentialBuilder setAccessToken(@NonNull String str) {
            this.f28906c = str;
            return this;
        }

        @NonNull
        public CredentialBuilder setIdToken(@NonNull String str) {
            this.f28905b = str;
            return this;
        }

        @NonNull
        public CredentialBuilder setIdTokenWithRawNonce(@NonNull String str, @Nullable String str2) {
            this.f28905b = str;
            this.f28907d = str2;
            return this;
        }
    }

    /* synthetic */ OAuthProvider(Bundle bundle, zzap zzapVar) {
        this.f28900a = bundle;
    }

    @NonNull
    @Deprecated
    public static AuthCredential getCredential(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return zze.zzc(str, str2, str3, null, null);
    }

    @NonNull
    public static Builder newBuilder(@NonNull String str) {
        return newBuilder(str, FirebaseAuth.getInstance());
    }

    @NonNull
    public static CredentialBuilder newCredentialBuilder(@NonNull String str) {
        return new CredentialBuilder(Preconditions.checkNotEmpty(str), null);
    }

    @Nullable
    public String getProviderId() {
        return this.f28900a.getString("com.google.firebase.auth.KEY_PROVIDER_ID");
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zza(@NonNull Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f28900a);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzb(@NonNull Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f28900a);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzc(@NonNull Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f28900a);
        activity.startActivity(intent);
    }

    @NonNull
    public static Builder newBuilder(@NonNull String str, @NonNull FirebaseAuth firebaseAuth) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseAuth);
        if ("facebook.com".equals(str) && !zzacq.zzg(firebaseAuth.getApp())) {
            throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
        }
        return new Builder(str, firebaseAuth, null);
    }
}
