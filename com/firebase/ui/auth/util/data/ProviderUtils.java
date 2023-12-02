package com.firebase.ui.auth.util.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.android.gms.auth.api.credentials.IdentityProviders;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class ProviderUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements Continuation<SignInMethodQueryResult, Task<List<String>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlowParameters f18226a;

        a(FlowParameters flowParameters) {
            this.f18226a = flowParameters;
        }

        private void a(List<String> list, String str, boolean z3) {
            if (list.remove(str)) {
                if (z3) {
                    list.add(0, str);
                } else {
                    list.add(str);
                }
            }
        }

        private void b(List<String> list) {
            a(list, "password", true);
            a(list, "google.com", true);
            a(list, "emailLink", false);
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: c */
        public Task<List<String>> then(@NonNull Task<SignInMethodQueryResult> task) {
            List<String> signInMethods = task.getResult().getSignInMethods();
            if (signInMethods == null) {
                signInMethods = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList(this.f18226a.providers.size());
            for (AuthUI.IdpConfig idpConfig : this.f18226a.providers) {
                arrayList.add(idpConfig.getProviderId());
            }
            ArrayList arrayList2 = new ArrayList(signInMethods.size());
            for (String str : signInMethods) {
                String signInMethodToProviderId = ProviderUtils.signInMethodToProviderId(str);
                if (arrayList.contains(signInMethodToProviderId)) {
                    arrayList2.add(0, signInMethodToProviderId);
                }
            }
            if (arrayList.contains("emailLink") && signInMethods.contains("password") && !signInMethods.contains("emailLink")) {
                arrayList2.add(0, ProviderUtils.signInMethodToProviderId("emailLink"));
            }
            if (task.isSuccessful() && arrayList2.isEmpty() && !signInMethods.isEmpty()) {
                return Tasks.forException(new FirebaseUiException(3));
            }
            b(arrayList2);
            return Tasks.forResult(arrayList2);
        }
    }

    /* loaded from: classes3.dex */
    static class b implements Continuation<List<String>, Task<String>> {
        b() {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Task<String> then(@NonNull Task<List<String>> task) {
            if (!task.isSuccessful()) {
                return Tasks.forException(task.getException());
            }
            List<String> result = task.getResult();
            if (result.isEmpty()) {
                return Tasks.forResult(null);
            }
            return Tasks.forResult(result.get(0));
        }
    }

    private ProviderUtils() {
        throw new AssertionError("No instance for you!");
    }

    public static String accountTypeToProviderId(@NonNull String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1534095099:
                if (str.equals("https://github.com")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1294469354:
                if (str.equals("https://phone.firebase")) {
                    c4 = 1;
                    break;
                }
                break;
            case -376862683:
                if (str.equals(IdentityProviders.GOOGLE)) {
                    c4 = 2;
                    break;
                }
                break;
            case 746549591:
                if (str.equals(IdentityProviders.TWITTER)) {
                    c4 = 3;
                    break;
                }
                break;
            case 1721158175:
                if (str.equals(IdentityProviders.FACEBOOK)) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "github.com";
            case 1:
                return "phone";
            case 2:
                return "google.com";
            case 3:
                return "twitter.com";
            case 4:
                return "facebook.com";
            default:
                return null;
        }
    }

    public static Task<List<String>> fetchSortedProviders(@NonNull FirebaseAuth firebaseAuth, @NonNull FlowParameters flowParameters, @NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new NullPointerException("Email cannot be empty"));
        }
        return firebaseAuth.fetchSignInMethodsForEmail(str).continueWithTask(new a(flowParameters));
    }

    public static Task<String> fetchTopProvider(@NonNull FirebaseAuth firebaseAuth, @NonNull FlowParameters flowParameters, @NonNull String str) {
        return fetchSortedProviders(firebaseAuth, flowParameters, str).continueWithTask(new b());
    }

    @Nullable
    public static AuthCredential getAuthCredential(IdpResponse idpResponse) {
        if (idpResponse.hasCredentialForLinking()) {
            return idpResponse.getCredentialForLinking();
        }
        String providerType = idpResponse.getProviderType();
        providerType.hashCode();
        if (!providerType.equals("google.com")) {
            if (!providerType.equals("facebook.com")) {
                return null;
            }
            return FacebookAuthProvider.getCredential(idpResponse.getIdpToken());
        }
        return GoogleAuthProvider.getCredential(idpResponse.getIdpToken(), null);
    }

    @Nullable
    public static AuthUI.IdpConfig getConfigFromIdps(List<AuthUI.IdpConfig> list, String str) {
        for (AuthUI.IdpConfig idpConfig : list) {
            if (idpConfig.getProviderId().equals(str)) {
                return idpConfig;
            }
        }
        return null;
    }

    @NonNull
    public static AuthUI.IdpConfig getConfigFromIdpsOrThrow(List<AuthUI.IdpConfig> list, String str) {
        AuthUI.IdpConfig configFromIdps = getConfigFromIdps(list, str);
        if (configFromIdps != null) {
            return configFromIdps;
        }
        throw new IllegalStateException("Provider " + str + " not found.");
    }

    @Nullable
    public static String idpResponseToAccountType(@Nullable IdpResponse idpResponse) {
        if (idpResponse == null) {
            return null;
        }
        return providerIdToAccountType(idpResponse.getProviderType());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String providerIdToAccountType(@NonNull String str) {
        char c4;
        switch (str.hashCode()) {
            case -1830313082:
                if (str.equals("twitter.com")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -1536293812:
                if (str.equals("google.com")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -364826023:
                if (str.equals("facebook.com")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 1216985755:
                if (str.equals("password")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 1985010934:
                if (str.equals("github.com")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 != 2) {
                    if (c4 != 3) {
                        if (c4 != 4) {
                            return null;
                        }
                        return "https://phone.firebase";
                    }
                    return "https://github.com";
                }
                return IdentityProviders.TWITTER;
            }
            return IdentityProviders.FACEBOOK;
        }
        return IdentityProviders.GOOGLE;
    }

    public static String providerIdToProviderName(@NonNull String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1830313082:
                if (str.equals("twitter.com")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1536293812:
                if (str.equals("google.com")) {
                    c4 = 1;
                    break;
                }
                break;
            case -364826023:
                if (str.equals("facebook.com")) {
                    c4 = 2;
                    break;
                }
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals("password")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1985010934:
                if (str.equals("github.com")) {
                    c4 = 5;
                    break;
                }
                break;
            case 2120171958:
                if (str.equals("emailLink")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_twitter);
            case 1:
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_google);
            case 2:
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_facebook);
            case 3:
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_phone);
            case 4:
            case 6:
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_email);
            case 5:
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_github);
            default:
                return null;
        }
    }

    @NonNull
    public static String signInMethodToProviderId(@NonNull String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1830313082:
                if (str.equals("twitter.com")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1536293812:
                if (str.equals("google.com")) {
                    c4 = 1;
                    break;
                }
                break;
            case -364826023:
                if (str.equals("facebook.com")) {
                    c4 = 2;
                    break;
                }
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals("password")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1985010934:
                if (str.equals("github.com")) {
                    c4 = 5;
                    break;
                }
                break;
            case 2120171958:
                if (str.equals("emailLink")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "twitter.com";
            case 1:
                return "google.com";
            case 2:
                return "facebook.com";
            case 3:
                return "phone";
            case 4:
                return "password";
            case 5:
                return "github.com";
            case 6:
                return "emailLink";
            default:
                return str;
        }
    }
}
