package com.google.android.gms.auth.api;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.p001authapi.zzj;
import com.google.android.gms.internal.p001authapi.zzq;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
    public static final CredentialsApi CredentialsApi;
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
    public static final GoogleSignInApi GoogleSignInApi;
    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static final Api<AuthProxyOptions> PROXY_API;
    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static final ProxyApi ProxyApi;

    /* renamed from: a  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzq, AuthCredentialsOptions> f19624a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzf, GoogleSignInOptions> f19625b;
    public static final Api.ClientKey<zzq> zzg;
    public static final Api.ClientKey<zzf> zzh;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        public static final AuthCredentialsOptions zzk = new Builder().zze();

        /* renamed from: a  reason: collision with root package name */
        private final String f19626a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f19627b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f19628c;

        public AuthCredentialsOptions(Builder builder) {
            this.f19626a = builder.f19629a;
            this.f19627b = builder.f19630b.booleanValue();
            this.f19628c = builder.f19631c;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthCredentialsOptions)) {
                return false;
            }
            AuthCredentialsOptions authCredentialsOptions = (AuthCredentialsOptions) obj;
            if (Objects.equal(this.f19626a, authCredentialsOptions.f19626a) && this.f19627b == authCredentialsOptions.f19627b && Objects.equal(this.f19628c, authCredentialsOptions.f19628c)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getLogSessionId() {
            return this.f19628c;
        }

        public int hashCode() {
            return Objects.hashCode(this.f19626a, Boolean.valueOf(this.f19627b), this.f19628c);
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.f19626a);
            bundle.putBoolean("force_save_dialog", this.f19627b);
            bundle.putString("log_session_id", this.f19628c);
            return bundle;
        }

        @Nullable
        public final String zzd() {
            return this.f19626a;
        }

        /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
        @Deprecated
        /* loaded from: classes4.dex */
        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            protected String f19629a;

            /* renamed from: b  reason: collision with root package name */
            protected Boolean f19630b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            protected String f19631c;

            public Builder() {
                this.f19630b = Boolean.FALSE;
            }

            public Builder forceEnableSaveDialog() {
                this.f19630b = Boolean.TRUE;
                return this;
            }

            @ShowFirstParty
            public Builder zzc(String str) {
                this.f19631c = str;
                return this;
            }

            @ShowFirstParty
            public AuthCredentialsOptions zze() {
                return new AuthCredentialsOptions(this);
            }

            @ShowFirstParty
            public Builder(AuthCredentialsOptions authCredentialsOptions) {
                this.f19630b = Boolean.FALSE;
                this.f19629a = authCredentialsOptions.f19626a;
                this.f19630b = Boolean.valueOf(authCredentialsOptions.f19627b);
                this.f19631c = authCredentialsOptions.f19628c;
            }
        }
    }

    static {
        Api.ClientKey<zzq> clientKey = new Api.ClientKey<>();
        zzg = clientKey;
        Api.ClientKey<zzf> clientKey2 = new Api.ClientKey<>();
        zzh = clientKey2;
        zzc zzcVar = new zzc();
        f19624a = zzcVar;
        zzd zzdVar = new zzd();
        f19625b = zzdVar;
        PROXY_API = AuthProxy.API;
        CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zzcVar, clientKey);
        GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zzdVar, clientKey2);
        ProxyApi = AuthProxy.ProxyApi;
        CredentialsApi = new zzj();
        GoogleSignInApi = new zzg();
    }

    private Auth() {
    }
}
