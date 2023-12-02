package com.firebase.ui.auth.util;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.credentials.CredentialsOptions;
import com.google.android.gms.common.GoogleApiAvailability;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class GoogleApiUtils {
    private GoogleApiUtils() {
        throw new AssertionError("No instance for you!");
    }

    @NonNull
    public static CredentialsClient getCredentialsClient(@NonNull Context context) {
        CredentialsOptions zze = new CredentialsOptions.Builder().forceEnableSaveDialog().zze();
        if (context instanceof Activity) {
            return Credentials.getClient((Activity) context, zze);
        }
        return Credentials.getClient(context, zze);
    }

    public static boolean isPlayServicesAvailable(@NonNull Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            return true;
        }
        return false;
    }
}
