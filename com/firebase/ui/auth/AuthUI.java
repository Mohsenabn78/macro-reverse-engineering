package com.firebase.ui.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.facebook.login.LoginManager;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.CredentialUtils;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.GoogleApiUtils;
import com.firebase.ui.auth.util.Preconditions;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import com.firebase.ui.auth.util.data.ProviderAvailability;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public final class AuthUI {
    public static final String EMAIL_LINK_PROVIDER = "emailLink";
    public static final int NO_LOGO = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String TAG = "AuthUI";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String UNCONFIGURED_CONFIG_VALUE = "CHANGE-ME";

    /* renamed from: f  reason: collision with root package name */
    private static Context f17915f;

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f17916a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseAuth f17917b;

    /* renamed from: c  reason: collision with root package name */
    private String f17918c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f17919d = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String ANONYMOUS_PROVIDER = "anonymous";
    public static final Set<String> SUPPORTED_PROVIDERS = Collections.unmodifiableSet(new HashSet(Arrays.asList("google.com", "facebook.com", "twitter.com", "github.com", "password", "phone", ANONYMOUS_PROVIDER, "emailLink")));
    public static final String MICROSOFT_PROVIDER = "microsoft.com";
    public static final String YAHOO_PROVIDER = "yahoo.com";
    public static final String APPLE_PROVIDER = "apple.com";
    public static final Set<String> SUPPORTED_OAUTH_PROVIDERS = Collections.unmodifiableSet(new HashSet(Arrays.asList(MICROSOFT_PROVIDER, YAHOO_PROVIDER, APPLE_PROVIDER, "twitter.com", "github.com")));
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Set<String> SOCIAL_PROVIDERS = Collections.unmodifiableSet(new HashSet(Arrays.asList("google.com", "facebook.com")));

    /* renamed from: e  reason: collision with root package name */
    private static final IdentityHashMap<FirebaseApp, AuthUI> f17914e = new IdentityHashMap<>();

    /* loaded from: classes3.dex */
    public static final class IdpConfig implements Parcelable {
        public static final Parcelable.Creator<IdpConfig> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f17920a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f17921b;

        /* loaded from: classes3.dex */
        public static final class AnonymousBuilder extends Builder {
            public AnonymousBuilder() {
                super(AuthUI.ANONYMOUS_PROVIDER);
            }
        }

        /* loaded from: classes3.dex */
        public static final class AppleBuilder extends GenericOAuthProviderBuilder {
            public AppleBuilder() {
                super(AuthUI.APPLE_PROVIDER, "Apple", R.layout.fui_idp_button_apple);
            }
        }

        /* loaded from: classes3.dex */
        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final Bundle f17922a = new Bundle();

            /* renamed from: b  reason: collision with root package name */
            private String f17923b;

            protected Builder(@NonNull String str) {
                if (!AuthUI.SUPPORTED_PROVIDERS.contains(str) && !AuthUI.SUPPORTED_OAUTH_PROVIDERS.contains(str)) {
                    throw new IllegalArgumentException("Unknown provider: " + str);
                }
                this.f17923b = str;
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            protected final Bundle b() {
                return this.f17922a;
            }

            @NonNull
            @CallSuper
            public IdpConfig build() {
                return new IdpConfig(this.f17923b, this.f17922a, null);
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            protected void c(@NonNull String str) {
                this.f17923b = str;
            }
        }

        /* loaded from: classes3.dex */
        public static final class EmailBuilder extends Builder {
            public EmailBuilder() {
                super("password");
            }

            @Override // com.firebase.ui.auth.AuthUI.IdpConfig.Builder
            public IdpConfig build() {
                if (((Builder) this).f17923b.equals("emailLink")) {
                    ActionCodeSettings actionCodeSettings = (ActionCodeSettings) b().getParcelable(ExtraConstants.ACTION_CODE_SETTINGS);
                    Preconditions.checkNotNull(actionCodeSettings, "ActionCodeSettings cannot be null when using email link sign in.", new Object[0]);
                    if (!actionCodeSettings.canHandleCodeInApp()) {
                        throw new IllegalStateException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
                    }
                }
                return super.build();
            }

            @NonNull
            public EmailBuilder enableEmailLinkSignIn() {
                c("emailLink");
                return this;
            }

            @NonNull
            public EmailBuilder setActionCodeSettings(ActionCodeSettings actionCodeSettings) {
                b().putParcelable(ExtraConstants.ACTION_CODE_SETTINGS, actionCodeSettings);
                return this;
            }

            @NonNull
            public EmailBuilder setAllowNewAccounts(boolean z3) {
                b().putBoolean(ExtraConstants.ALLOW_NEW_EMAILS, z3);
                return this;
            }

            @NonNull
            public EmailBuilder setDefaultEmail(String str) {
                b().putString(ExtraConstants.DEFAULT_EMAIL, str);
                return this;
            }

            @NonNull
            public EmailBuilder setForceSameDevice() {
                b().putBoolean(ExtraConstants.FORCE_SAME_DEVICE, true);
                return this;
            }

            @NonNull
            public EmailBuilder setRequireName(boolean z3) {
                b().putBoolean(ExtraConstants.REQUIRE_NAME, z3);
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static final class FacebookBuilder extends Builder {
            public FacebookBuilder() {
                super("facebook.com");
                if (ProviderAvailability.IS_FACEBOOK_AVAILABLE) {
                    Preconditions.checkConfigured(AuthUI.getApplicationContext(), "Facebook provider unconfigured. Make sure to add a `facebook_application_id` string. See the docs for more info: https://github.com/firebase/FirebaseUI-Android/blob/master/auth/README.md#facebook", R.string.facebook_application_id);
                    if (AuthUI.getApplicationContext().getString(R.string.facebook_login_protocol_scheme).equals("fbYOUR_APP_ID")) {
                        Log.w("FacebookBuilder", "Facebook provider unconfigured for Chrome Custom Tabs.");
                        return;
                    }
                    return;
                }
                throw new RuntimeException("Facebook provider cannot be configured without dependency. Did you forget to add 'com.facebook.android:facebook-login:VERSION' dependency?");
            }

            @NonNull
            public FacebookBuilder setPermissions(@NonNull List<String> list) {
                b().putStringArrayList(ExtraConstants.FACEBOOK_PERMISSIONS, new ArrayList<>(list));
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static class GenericOAuthProviderBuilder extends Builder {
            public GenericOAuthProviderBuilder(@NonNull String str, @NonNull String str2, int i4) {
                super(str);
                Preconditions.checkNotNull(str, "The provider ID cannot be null.", new Object[0]);
                Preconditions.checkNotNull(str2, "The provider name cannot be null.", new Object[0]);
                b().putString(ExtraConstants.GENERIC_OAUTH_PROVIDER_ID, str);
                b().putString(ExtraConstants.GENERIC_OAUTH_PROVIDER_NAME, str2);
                b().putInt(ExtraConstants.GENERIC_OAUTH_BUTTON_ID, i4);
            }

            @NonNull
            public GenericOAuthProviderBuilder setCustomParameters(@NonNull Map<String, String> map) {
                b().putSerializable(ExtraConstants.GENERIC_OAUTH_CUSTOM_PARAMETERS, new HashMap(map));
                return this;
            }

            @NonNull
            public GenericOAuthProviderBuilder setScopes(@NonNull List<String> list) {
                b().putStringArrayList(ExtraConstants.GENERIC_OAUTH_SCOPES, new ArrayList<>(list));
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static final class GitHubBuilder extends GenericOAuthProviderBuilder {
            public GitHubBuilder() {
                super("github.com", "Github", R.layout.fui_idp_button_github);
            }

            @NonNull
            @Deprecated
            public GitHubBuilder setPermissions(@NonNull List<String> list) {
                setScopes(list);
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static final class GoogleBuilder extends Builder {
            public GoogleBuilder() {
                super("google.com");
            }

            private void d() {
                Preconditions.checkConfigured(AuthUI.getApplicationContext(), "Check your google-services plugin configuration, the default_web_client_id string wasn't populated.", R.string.default_web_client_id);
            }

            @Override // com.firebase.ui.auth.AuthUI.IdpConfig.Builder
            @NonNull
            public IdpConfig build() {
                if (!b().containsKey(ExtraConstants.GOOGLE_SIGN_IN_OPTIONS)) {
                    d();
                    setScopes(Collections.emptyList());
                }
                return super.build();
            }

            @NonNull
            public GoogleBuilder setScopes(@NonNull List<String> list) {
                GoogleSignInOptions.Builder requestEmail = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail();
                for (String str : list) {
                    requestEmail.requestScopes(new Scope(str), new Scope[0]);
                }
                return setSignInOptions(requestEmail.build());
            }

            @NonNull
            public GoogleBuilder setSignInOptions(@NonNull GoogleSignInOptions googleSignInOptions) {
                boolean z3;
                Preconditions.checkUnset(b(), "Cannot overwrite previously set sign-in options.", ExtraConstants.GOOGLE_SIGN_IN_OPTIONS);
                GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(googleSignInOptions);
                String serverClientId = googleSignInOptions.getServerClientId();
                if (serverClientId == null) {
                    d();
                    serverClientId = AuthUI.getApplicationContext().getString(R.string.default_web_client_id);
                }
                Iterator<Scope> it = googleSignInOptions.getScopes().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("email".equals(it.next().getScopeUri())) {
                            z3 = true;
                            break;
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (!z3) {
                    Log.w(AuthUI.TAG, "The GoogleSignInOptions passed to setSignInOptions does not request the 'email' scope. In most cases this is a mistake! Call requestEmail() on the GoogleSignInOptions object.");
                }
                builder.requestIdToken(serverClientId);
                b().putParcelable(ExtraConstants.GOOGLE_SIGN_IN_OPTIONS, builder.build());
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static final class MicrosoftBuilder extends GenericOAuthProviderBuilder {
            public MicrosoftBuilder() {
                super(AuthUI.MICROSOFT_PROVIDER, "Microsoft", R.layout.fui_idp_button_microsoft);
            }
        }

        /* loaded from: classes3.dex */
        public static final class TwitterBuilder extends GenericOAuthProviderBuilder {
            public TwitterBuilder() {
                super("twitter.com", UploadService.UPLOAD_TWITTER, R.layout.fui_idp_button_twitter);
            }
        }

        /* loaded from: classes3.dex */
        public static final class YahooBuilder extends GenericOAuthProviderBuilder {
            public YahooBuilder() {
                super(AuthUI.YAHOO_PROVIDER, "Yahoo", R.layout.fui_idp_button_yahoo);
            }
        }

        /* loaded from: classes3.dex */
        static class a implements Parcelable.Creator<IdpConfig> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public IdpConfig createFromParcel(Parcel parcel) {
                return new IdpConfig(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public IdpConfig[] newArray(int i4) {
                return new IdpConfig[i4];
            }
        }

        /* synthetic */ IdpConfig(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && IdpConfig.class == obj.getClass()) {
                return this.f17920a.equals(((IdpConfig) obj).f17920a);
            }
            return false;
        }

        @NonNull
        public Bundle getParams() {
            return new Bundle(this.f17921b);
        }

        @NonNull
        public String getProviderId() {
            return this.f17920a;
        }

        public final int hashCode() {
            return this.f17920a.hashCode();
        }

        public String toString() {
            return "IdpConfig{mProviderId='" + this.f17920a + "', mParams=" + this.f17921b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f17920a);
            parcel.writeBundle(this.f17921b);
        }

        /* synthetic */ IdpConfig(String str, Bundle bundle, a aVar) {
            this(str, bundle);
        }

        private IdpConfig(@NonNull String str, @NonNull Bundle bundle) {
            this.f17920a = str;
            this.f17921b = new Bundle(bundle);
        }

        /* loaded from: classes3.dex */
        public static final class PhoneBuilder extends Builder {
            public PhoneBuilder() {
                super("phone");
            }

            private void d(List<String> list, String str) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (String str2 : list) {
                    arrayList.add(str2.toUpperCase(Locale.getDefault()));
                }
                b().putStringArrayList(str, arrayList);
            }

            private boolean e(List<String> list, String str) {
                String upperCase = str.toUpperCase(Locale.getDefault());
                for (String str2 : list) {
                    if (PhoneNumberUtils.isValidIso(str2)) {
                        if (str2.equals(upperCase)) {
                            return true;
                        }
                    } else if (PhoneNumberUtils.getCountryIsosFromCountryCode(str2).contains(upperCase)) {
                        return true;
                    }
                }
                return false;
            }

            private String f() {
                if (b().containsKey(ExtraConstants.COUNTRY_ISO)) {
                    return b().getString(ExtraConstants.COUNTRY_ISO);
                }
                return null;
            }

            private List<String> g() {
                ArrayList arrayList = new ArrayList();
                String string = b().getString(ExtraConstants.PHONE);
                if (string != null && string.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    List<String> countryIsosFromCountryCode = PhoneNumberUtils.getCountryIsosFromCountryCode(Marker.ANY_NON_NULL_MARKER + PhoneNumberUtils.getPhoneNumber(string).getCountryCode());
                    if (countryIsosFromCountryCode != null) {
                        arrayList.addAll(countryIsosFromCountryCode);
                    }
                }
                return arrayList;
            }

            private boolean h(List<String> list, String str, boolean z3) {
                if (str == null) {
                    return true;
                }
                boolean e4 = e(list, str);
                if (e4 && z3) {
                    return true;
                }
                if (!e4 && !z3) {
                    return true;
                }
                return false;
            }

            private void i(List<String> list) {
                for (String str : list) {
                    if (!PhoneNumberUtils.isValidIso(str) && !PhoneNumberUtils.isValid(str)) {
                        throw new IllegalArgumentException("Invalid input: You must provide a valid country iso (alpha-2) or code (e-164). e.g. 'us' or '+1'.");
                    }
                }
            }

            private void j(List<String> list, boolean z3) {
                if (b().containsKey(ExtraConstants.COUNTRY_ISO) || b().containsKey(ExtraConstants.PHONE)) {
                    if (k(list, z3) && l(list, z3)) {
                        return;
                    }
                    throw new IllegalArgumentException("Invalid default country iso. Make sure it is either part of the allowed list or that you haven't blocked it.");
                }
            }

            private boolean k(List<String> list, boolean z3) {
                return h(list, f(), z3);
            }

            private boolean l(List<String> list, boolean z3) {
                List<String> g4 = g();
                for (String str : g4) {
                    if (h(list, str, z3)) {
                        return true;
                    }
                }
                return g4.isEmpty();
            }

            private void m() {
                ArrayList<String> stringArrayList = b().getStringArrayList(ExtraConstants.ALLOWLISTED_COUNTRIES);
                ArrayList<String> stringArrayList2 = b().getStringArrayList(ExtraConstants.BLOCKLISTED_COUNTRIES);
                if (stringArrayList != null && stringArrayList2 != null) {
                    throw new IllegalStateException("You can either allowlist or blocked country codes for phone authentication.");
                }
                if (stringArrayList != null) {
                    n(stringArrayList, true);
                } else if (stringArrayList2 != null) {
                    n(stringArrayList2, false);
                }
            }

            private void n(List<String> list, boolean z3) {
                i(list);
                j(list, z3);
            }

            @Override // com.firebase.ui.auth.AuthUI.IdpConfig.Builder
            public IdpConfig build() {
                m();
                return super.build();
            }

            public PhoneBuilder setBlacklistedCountries(@NonNull List<String> list) {
                if (!b().containsKey(ExtraConstants.ALLOWLISTED_COUNTRIES)) {
                    Preconditions.checkNotNull(list, String.format("Invalid argument: Only non-%s blocklists are valid. To specify no blacklist, do not call this method.", "null"), new Object[0]);
                    Preconditions.checkArgument(!list.isEmpty(), String.format("Invalid argument: Only non-%s blocklists are valid. To specify no blacklist, do not call this method.", "empty"));
                    d(list, ExtraConstants.BLOCKLISTED_COUNTRIES);
                    return this;
                }
                throw new IllegalStateException("You can either allowlist or blocklist country codes for phone authentication.");
            }

            @NonNull
            public PhoneBuilder setDefaultCountryIso(@NonNull String str) {
                Preconditions.checkUnset(b(), "Cannot overwrite previously set phone number", ExtraConstants.PHONE, ExtraConstants.COUNTRY_ISO, ExtraConstants.NATIONAL_NUMBER);
                if (PhoneNumberUtils.isValidIso(str)) {
                    b().putString(ExtraConstants.COUNTRY_ISO, str.toUpperCase(Locale.getDefault()));
                    return this;
                }
                throw new IllegalStateException("Invalid country iso: " + str);
            }

            @NonNull
            public PhoneBuilder setDefaultNumber(@NonNull String str) {
                Preconditions.checkUnset(b(), "Cannot overwrite previously set phone number", ExtraConstants.PHONE, ExtraConstants.COUNTRY_ISO, ExtraConstants.NATIONAL_NUMBER);
                if (PhoneNumberUtils.isValid(str)) {
                    b().putString(ExtraConstants.PHONE, str);
                    return this;
                }
                throw new IllegalStateException("Invalid phone number: " + str);
            }

            public PhoneBuilder setWhitelistedCountries(@NonNull List<String> list) {
                if (!b().containsKey(ExtraConstants.BLOCKLISTED_COUNTRIES)) {
                    Preconditions.checkNotNull(list, String.format("Invalid argument: Only non-%s allowlists are valid. To specify no allowlist, do not call this method.", "null"), new Object[0]);
                    Preconditions.checkArgument(!list.isEmpty(), String.format("Invalid argument: Only non-%s allowlists are valid. To specify no allowlist, do not call this method.", "empty"));
                    d(list, ExtraConstants.ALLOWLISTED_COUNTRIES);
                    return this;
                }
                throw new IllegalStateException("You can either allowlist or blocklist country codes for phone authentication.");
            }

            @NonNull
            public PhoneBuilder setDefaultNumber(@NonNull String str, @NonNull String str2) {
                Preconditions.checkUnset(b(), "Cannot overwrite previously set phone number", ExtraConstants.PHONE, ExtraConstants.COUNTRY_ISO, ExtraConstants.NATIONAL_NUMBER);
                if (PhoneNumberUtils.isValidIso(str)) {
                    b().putString(ExtraConstants.COUNTRY_ISO, str);
                    b().putString(ExtraConstants.NATIONAL_NUMBER, str2);
                    return this;
                }
                throw new IllegalStateException("Invalid country iso: " + str);
            }
        }

        private IdpConfig(Parcel parcel) {
            this.f17920a = parcel.readString();
            this.f17921b = parcel.readBundle(IdpConfig.class.getClassLoader());
        }
    }

    /* loaded from: classes3.dex */
    public final class SignInIntentBuilder extends f<SignInIntentBuilder> {

        /* renamed from: n  reason: collision with root package name */
        private String f17924n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f17925o;

        /* synthetic */ SignInIntentBuilder(AuthUI authUI, a aVar) {
            this();
        }

        private void b() {
            for (int i4 = 0; i4 < this.f17939a.size(); i4++) {
                IdpConfig idpConfig = this.f17939a.get(i4);
                if (idpConfig.getProviderId().equals("emailLink") && !idpConfig.getParams().getBoolean(ExtraConstants.FORCE_SAME_DEVICE, true)) {
                    throw new IllegalStateException("You must force the same device flow when using email link sign in with anonymous user upgrade");
                }
            }
        }

        @Override // com.firebase.ui.auth.AuthUI.f
        protected FlowParameters a() {
            return new FlowParameters(AuthUI.this.f17916a.getName(), this.f17939a, this.f17940b, this.f17942d, this.f17941c, this.f17943e, this.f17944f, this.f17947i, this.f17948j, this.f17925o, this.f17945g, this.f17946h, this.f17924n, this.f17950l, this.f17949k);
        }

        @Override // com.firebase.ui.auth.AuthUI.f
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent build() {
            return super.build();
        }

        @NonNull
        public SignInIntentBuilder enableAnonymousUsersAutoUpgrade() {
            this.f17925o = true;
            b();
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.firebase.ui.auth.AuthUI$SignInIntentBuilder, com.firebase.ui.auth.AuthUI$f] */
        @Override // com.firebase.ui.auth.AuthUI.f
        @NonNull
        public /* bridge */ /* synthetic */ SignInIntentBuilder setAlwaysShowSignInMethodScreen(boolean z3) {
            return super.setAlwaysShowSignInMethodScreen(z3);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.firebase.ui.auth.AuthUI$SignInIntentBuilder, com.firebase.ui.auth.AuthUI$f] */
        @Override // com.firebase.ui.auth.AuthUI.f
        @NonNull
        public /* bridge */ /* synthetic */ SignInIntentBuilder setAvailableProviders(@NonNull List list) {
            return super.setAvailableProviders(list);
        }

        @NonNull
        public SignInIntentBuilder setEmailLink(@NonNull String str) {
            this.f17924n = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.firebase.ui.auth.AuthUI$SignInIntentBuilder, com.firebase.ui.auth.AuthUI$f] */
        @Override // com.firebase.ui.auth.AuthUI.f
        @NonNull
        public /* bridge */ /* synthetic */ SignInIntentBuilder setIsSmartLockEnabled(boolean z3) {
            return super.setIsSmartLockEnabled(z3);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.firebase.ui.auth.AuthUI$SignInIntentBuilder, com.firebase.ui.auth.AuthUI$f] */
        @Override // com.firebase.ui.auth.AuthUI.f
        @NonNull
        public /* bridge */ /* synthetic */ SignInIntentBuilder setLogo(@DrawableRes int i4) {
            return super.setLogo(i4);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.firebase.ui.auth.AuthUI$SignInIntentBuilder, com.firebase.ui.auth.AuthUI$f] */
        @Override // com.firebase.ui.auth.AuthUI.f
        @NonNull
        public /* bridge */ /* synthetic */ SignInIntentBuilder setTheme(@StyleRes int i4) {
            return super.setTheme(i4);
        }

        private SignInIntentBuilder() {
            super(AuthUI.this, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SupportedProvider {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Continuation<CredentialRequestResponse, Task<AuthResult>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f17927a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GoogleSignInOptions f17928b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.firebase.ui.auth.AuthUI$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0146a implements Continuation<GoogleSignInAccount, Task<AuthResult>> {
            C0146a() {
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public Task<AuthResult> then(@NonNull Task<GoogleSignInAccount> task) {
                return AuthUI.this.f17917b.signInWithCredential(GoogleAuthProvider.getCredential(task.getResult().getIdToken(), null));
            }
        }

        a(Context context, GoogleSignInOptions googleSignInOptions) {
            this.f17927a = context;
            this.f17928b = googleSignInOptions;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<AuthResult> then(@NonNull Task<CredentialRequestResponse> task) {
            Credential credential = task.getResult().getCredential();
            String id = credential.getId();
            String password = credential.getPassword();
            if (TextUtils.isEmpty(password)) {
                return GoogleSignIn.getClient(this.f17927a, new GoogleSignInOptions.Builder(this.f17928b).setAccountName(id).build()).silentSignIn().continueWithTask(new C0146a());
            }
            return AuthUI.this.f17917b.signInWithEmailAndPassword(id, password);
        }
    }

    /* loaded from: classes3.dex */
    class b implements Continuation<Void, Void> {
        b() {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Void then(@NonNull Task<Void> task) {
            Exception exception = task.getException();
            if ((exception instanceof ApiException) && ((ApiException) exception).getStatusCode() == 16) {
                Log.w(AuthUI.TAG, "Could not disable auto-sign in, maybe there are no SmartLock accounts available?", exception);
                return null;
            }
            return task.getResult();
        }
    }

    /* loaded from: classes3.dex */
    class c implements Continuation<Void, Void> {
        c() {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Void then(@NonNull Task<Void> task) {
            task.getResult();
            AuthUI.this.f17917b.signOut();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class d implements Continuation<Void, Task<Void>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FirebaseUser f17933a;

        d(FirebaseUser firebaseUser) {
            this.f17933a = firebaseUser;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<Void> then(@NonNull Task<Void> task) {
            task.getResult();
            return this.f17933a.delete();
        }
    }

    /* loaded from: classes3.dex */
    class e implements Continuation<Void, Task<Void>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f17935a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f17936b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements Continuation<Void, Void> {
            a() {
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public Void then(@NonNull Task<Void> task) {
                Throwable cause;
                Exception exception = task.getException();
                if (exception == null) {
                    cause = null;
                } else {
                    cause = exception.getCause();
                }
                if ((cause instanceof ApiException) && ((ApiException) cause).getStatusCode() == 16) {
                    return null;
                }
                return task.getResult();
            }
        }

        e(Context context, List list) {
            this.f17935a = context;
            this.f17936b = list;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<Void> then(@NonNull Task<Void> task) {
            task.getResult();
            if (!GoogleApiUtils.isPlayServicesAvailable(this.f17935a)) {
                Log.w(AuthUI.TAG, "Google Play services not available during delete");
                return Tasks.forResult(null);
            }
            CredentialsClient credentialsClient = GoogleApiUtils.getCredentialsClient(this.f17935a);
            ArrayList arrayList = new ArrayList();
            for (Credential credential : this.f17936b) {
                arrayList.add(credentialsClient.delete(credential));
            }
            return Tasks.whenAll(arrayList).continueWith(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public abstract class f<T extends f> {

        /* renamed from: a  reason: collision with root package name */
        final List<IdpConfig> f17939a;

        /* renamed from: b  reason: collision with root package name */
        IdpConfig f17940b;

        /* renamed from: c  reason: collision with root package name */
        int f17941c;

        /* renamed from: d  reason: collision with root package name */
        int f17942d;

        /* renamed from: e  reason: collision with root package name */
        String f17943e;

        /* renamed from: f  reason: collision with root package name */
        String f17944f;

        /* renamed from: g  reason: collision with root package name */
        boolean f17945g;

        /* renamed from: h  reason: collision with root package name */
        boolean f17946h;

        /* renamed from: i  reason: collision with root package name */
        boolean f17947i;

        /* renamed from: j  reason: collision with root package name */
        boolean f17948j;

        /* renamed from: k  reason: collision with root package name */
        AuthMethodPickerLayout f17949k;

        /* renamed from: l  reason: collision with root package name */
        ActionCodeSettings f17950l;

        private f() {
            this.f17939a = new ArrayList();
            this.f17940b = null;
            this.f17941c = -1;
            this.f17942d = AuthUI.getDefaultTheme();
            this.f17945g = false;
            this.f17946h = false;
            this.f17947i = true;
            this.f17948j = true;
            this.f17949k = null;
            this.f17950l = null;
        }

        protected abstract FlowParameters a();

        @NonNull
        @CallSuper
        public Intent build() {
            if (this.f17939a.isEmpty()) {
                this.f17939a.add(new IdpConfig.EmailBuilder().build());
            }
            return KickoffActivity.createIntent(AuthUI.this.f17916a.getApplicationContext(), a());
        }

        @NonNull
        public T setAlwaysShowSignInMethodScreen(boolean z3) {
            if (z3 && this.f17940b != null) {
                throw new IllegalStateException("Can't show provider choice with a default provider.");
            }
            this.f17945g = z3;
            return this;
        }

        @NonNull
        public T setAuthMethodPickerLayout(@NonNull AuthMethodPickerLayout authMethodPickerLayout) {
            this.f17949k = authMethodPickerLayout;
            return this;
        }

        @NonNull
        public T setAvailableProviders(@NonNull List<IdpConfig> list) {
            Preconditions.checkNotNull(list, "idpConfigs cannot be null", new Object[0]);
            if (list.size() == 1 && list.get(0).getProviderId().equals(AuthUI.ANONYMOUS_PROVIDER)) {
                throw new IllegalStateException("Sign in as guest cannot be the only sign in method. In this case, sign the user in anonymously your self; no UI is needed.");
            }
            this.f17939a.clear();
            for (IdpConfig idpConfig : list) {
                if (!this.f17939a.contains(idpConfig)) {
                    this.f17939a.add(idpConfig);
                } else {
                    throw new IllegalArgumentException("Each provider can only be set once. " + idpConfig.getProviderId() + " was set twice.");
                }
            }
            return this;
        }

        @NonNull
        public T setDefaultProvider(@Nullable IdpConfig idpConfig) {
            if (idpConfig != null) {
                if (this.f17939a.contains(idpConfig)) {
                    if (this.f17945g) {
                        throw new IllegalStateException("Can't set default provider and always show provider choice.");
                    }
                } else {
                    throw new IllegalStateException("Default provider not in available providers list.");
                }
            }
            this.f17940b = idpConfig;
            return this;
        }

        @NonNull
        public T setIsSmartLockEnabled(boolean z3) {
            return setIsSmartLockEnabled(z3, z3);
        }

        @NonNull
        public T setLockOrientation(boolean z3) {
            this.f17946h = z3;
            return this;
        }

        @NonNull
        public T setLogo(@DrawableRes int i4) {
            this.f17941c = i4;
            return this;
        }

        @NonNull
        @Deprecated
        public T setPrivacyPolicyUrl(@Nullable String str) {
            this.f17944f = str;
            return this;
        }

        @NonNull
        public T setResetPasswordSettings(ActionCodeSettings actionCodeSettings) {
            this.f17950l = actionCodeSettings;
            return this;
        }

        @NonNull
        public T setTheme(@StyleRes int i4) {
            this.f17942d = Preconditions.checkValidStyle(AuthUI.this.f17916a.getApplicationContext(), i4, "theme identifier is unknown or not a style definition", new Object[0]);
            return this;
        }

        @NonNull
        public T setTosAndPrivacyPolicyUrls(@NonNull String str, @NonNull String str2) {
            Preconditions.checkNotNull(str, "tosUrl cannot be null", new Object[0]);
            Preconditions.checkNotNull(str2, "privacyPolicyUrl cannot be null", new Object[0]);
            this.f17943e = str;
            this.f17944f = str2;
            return this;
        }

        @NonNull
        @Deprecated
        public T setTosUrl(@Nullable String str) {
            this.f17943e = str;
            return this;
        }

        @NonNull
        public T setIsSmartLockEnabled(boolean z3, boolean z4) {
            this.f17947i = z3;
            this.f17948j = z4;
            return this;
        }

        /* synthetic */ f(AuthUI authUI, a aVar) {
            this();
        }
    }

    private AuthUI(FirebaseApp firebaseApp) {
        this.f17916a = firebaseApp;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
        this.f17917b = firebaseAuth;
        try {
            firebaseAuth.setFirebaseUIVersion(BuildConfig.VERSION_NAME);
        } catch (Exception e4) {
            Log.e(TAG, "Couldn't set the FUI version.", e4);
        }
        this.f17917b.useAppLanguage();
    }

    private static List<Credential> c(@NonNull FirebaseUser firebaseUser) {
        if (TextUtils.isEmpty(firebaseUser.getEmail()) && TextUtils.isEmpty(firebaseUser.getPhoneNumber())) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (UserInfo userInfo : firebaseUser.getProviderData()) {
            if (!"firebase".equals(userInfo.getProviderId())) {
                String providerIdToAccountType = ProviderUtils.providerIdToAccountType(userInfo.getProviderId());
                if (providerIdToAccountType == null) {
                    arrayList.add(CredentialUtils.buildCredentialOrThrow(firebaseUser, "pass", null));
                } else {
                    arrayList.add(CredentialUtils.buildCredentialOrThrow(firebaseUser, null, providerIdToAccountType));
                }
            }
        }
        return arrayList;
    }

    public static boolean canHandleIntent(@NonNull Intent intent) {
        if (intent != null && intent.getData() != null) {
            return FirebaseAuth.getInstance().isSignInWithEmailLink(intent.getData().toString());
        }
        return false;
    }

    private Task<Void> d(@NonNull Context context) {
        if (ProviderAvailability.IS_FACEBOOK_AVAILABLE) {
            LoginManager.getInstance().logOut();
        }
        if (GoogleApiUtils.isPlayServicesAvailable(context)) {
            return GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_SIGN_IN).signOut();
        }
        return Tasks.forResult(null);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Context getApplicationContext() {
        return f17915f;
    }

    @StyleRes
    public static int getDefaultTheme() {
        return R.style.FirebaseUI;
    }

    @NonNull
    public static AuthUI getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setApplicationContext(@NonNull Context context) {
        f17915f = ((Context) Preconditions.checkNotNull(context, "App context cannot be null.", new Object[0])).getApplicationContext();
    }

    @NonNull
    public SignInIntentBuilder createSignInIntentBuilder() {
        return new SignInIntentBuilder(this, null);
    }

    @NonNull
    public Task<Void> delete(@NonNull Context context) {
        FirebaseUser currentUser = this.f17917b.getCurrentUser();
        if (currentUser == null) {
            return Tasks.forException(new FirebaseAuthInvalidUserException(String.valueOf(4), "No currently signed in user."));
        }
        return d(context).continueWithTask(new e(context, c(currentUser))).continueWithTask(new d(currentUser));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FirebaseApp getApp() {
        return this.f17916a;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FirebaseAuth getAuth() {
        return this.f17917b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getEmulatorHost() {
        return this.f17918c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmulatorPort() {
        return this.f17919d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isUseEmulator() {
        if (this.f17918c != null && this.f17919d >= 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public Task<Void> signOut(@NonNull Context context) {
        Task<Void> forResult;
        boolean isPlayServicesAvailable = GoogleApiUtils.isPlayServicesAvailable(context);
        if (!isPlayServicesAvailable) {
            Log.w(TAG, "Google Play services not available during signOut");
        }
        if (isPlayServicesAvailable) {
            forResult = GoogleApiUtils.getCredentialsClient(context).disableAutoSignIn();
        } else {
            forResult = Tasks.forResult(null);
        }
        forResult.continueWith(new b());
        return Tasks.whenAll(d(context), forResult).continueWith(new c());
    }

    @NonNull
    public Task<AuthResult> silentSignIn(@NonNull Context context, @NonNull List<IdpConfig> list) {
        GoogleSignInOptions googleSignInOptions;
        boolean z3;
        if (this.f17917b.getCurrentUser() == null) {
            Context applicationContext = context.getApplicationContext();
            IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(list, "google.com");
            IdpConfig configFromIdps2 = ProviderUtils.getConfigFromIdps(list, "password");
            if (configFromIdps == null && configFromIdps2 == null) {
                throw new IllegalArgumentException("No supported providers were supplied. Add either Google or email support.");
            }
            String str = null;
            if (configFromIdps == null) {
                googleSignInOptions = null;
            } else {
                GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(applicationContext);
                if (lastSignedInAccount != null && lastSignedInAccount.getIdToken() != null) {
                    return this.f17917b.signInWithCredential(GoogleAuthProvider.getCredential(lastSignedInAccount.getIdToken(), null));
                }
                googleSignInOptions = (GoogleSignInOptions) configFromIdps.getParams().getParcelable(ExtraConstants.GOOGLE_SIGN_IN_OPTIONS);
            }
            if (!GoogleApiUtils.isPlayServicesAvailable(context)) {
                return Tasks.forException(new FirebaseUiException(2));
            }
            CredentialsClient credentialsClient = GoogleApiUtils.getCredentialsClient(context);
            CredentialRequest.Builder builder = new CredentialRequest.Builder();
            if (configFromIdps2 != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            CredentialRequest.Builder passwordLoginSupported = builder.setPasswordLoginSupported(z3);
            String[] strArr = new String[1];
            if (configFromIdps != null) {
                str = ProviderUtils.providerIdToAccountType("google.com");
            }
            strArr[0] = str;
            return credentialsClient.request(passwordLoginSupported.setAccountTypes(strArr).build()).continueWithTask(new a(applicationContext, googleSignInOptions));
        }
        throw new IllegalArgumentException("User already signed in!");
    }

    public void useEmulator(@NonNull String str, int i4) {
        boolean z3;
        boolean z4 = true;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Port must be >= 0");
        if (i4 > 65535) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Port must be <= 65535");
        this.f17918c = str;
        this.f17919d = i4;
        this.f17917b.useEmulator(str, i4);
    }

    @NonNull
    public static AuthUI getInstance(@NonNull String str) {
        return getInstance(FirebaseApp.getInstance(str));
    }

    @NonNull
    public static AuthUI getInstance(@NonNull FirebaseApp firebaseApp) {
        AuthUI authUI;
        if (ProviderAvailability.IS_TWITTER_AVAILABLE) {
            Log.w(TAG, String.format("Beginning with FirebaseUI 6.2.0 you no longer need to include %s to sign in with %s. Go to %s for more information", "the TwitterKit SDK", UploadService.UPLOAD_TWITTER, "https://github.com/firebase/FirebaseUI-Android/releases/tag/6.2.0"));
        }
        if (ProviderAvailability.IS_GITHUB_AVAILABLE) {
            Log.w(TAG, String.format("Beginning with FirebaseUI 6.2.0 you no longer need to include %s to sign in with %s. Go to %s for more information", "com.firebaseui:firebase-ui-auth-github", "GitHub", "https://github.com/firebase/FirebaseUI-Android/releases/tag/6.2.0"));
        }
        IdentityHashMap<FirebaseApp, AuthUI> identityHashMap = f17914e;
        synchronized (identityHashMap) {
            authUI = identityHashMap.get(firebaseApp);
            if (authUI == null) {
                authUI = new AuthUI(firebaseApp);
                identityHashMap.put(firebaseApp, authUI);
            }
        }
        return authUI;
    }
}
