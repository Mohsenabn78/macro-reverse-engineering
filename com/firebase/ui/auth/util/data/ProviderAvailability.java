package com.firebase.ui.auth.util.data;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class ProviderAvailability {
    public static final boolean IS_GITHUB_AVAILABLE = a("com.firebase.ui.auth.data.remote.GitHubSignInHandler");
    public static final boolean IS_FACEBOOK_AVAILABLE = a("com.facebook.login.LoginManager");
    public static final boolean IS_TWITTER_AVAILABLE = a("com.twitter.sdk.android.core.identity.TwitterAuthClient");

    private ProviderAvailability() {
        throw new AssertionError("No instance for you!");
    }

    private static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
