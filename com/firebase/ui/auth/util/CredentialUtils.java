package com.firebase.ui.auth.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.firebase.auth.FirebaseUser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class CredentialUtils {
    private CredentialUtils() {
        throw new AssertionError("No instance for you!");
    }

    @Nullable
    public static Credential buildCredential(@NonNull FirebaseUser firebaseUser, @Nullable String str, @Nullable String str2) {
        Uri parse;
        String email = firebaseUser.getEmail();
        String phoneNumber = firebaseUser.getPhoneNumber();
        if (firebaseUser.getPhotoUrl() == null) {
            parse = null;
        } else {
            parse = Uri.parse(firebaseUser.getPhotoUrl().toString());
        }
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(phoneNumber)) {
            Log.w("CredentialUtils", "User (accountType=" + str2 + ") has no email or phone number, cannot build credential.");
            return null;
        } else if (str == null && str2 == null) {
            Log.w("CredentialUtils", "User has no accountType or password, cannot build credential.");
            return null;
        } else {
            if (TextUtils.isEmpty(email)) {
                email = phoneNumber;
            }
            Credential.Builder profilePictureUri = new Credential.Builder(email).setName(firebaseUser.getDisplayName()).setProfilePictureUri(parse);
            if (TextUtils.isEmpty(str)) {
                profilePictureUri.setAccountType(str2);
            } else {
                profilePictureUri.setPassword(str);
            }
            return profilePictureUri.build();
        }
    }

    @NonNull
    public static Credential buildCredentialOrThrow(@NonNull FirebaseUser firebaseUser, @Nullable String str, @Nullable String str2) {
        Credential buildCredential = buildCredential(firebaseUser, str, str2);
        if (buildCredential != null) {
            return buildCredential;
        }
        throw new IllegalStateException("Unable to build credential");
    }
}
