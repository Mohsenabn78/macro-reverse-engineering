package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    @NonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Nullable
    @Deprecated
    public static Dialog getErrorDialog(int i4, @NonNull Activity activity, int i5) {
        return getErrorDialog(i4, activity, i5, null);
    }

    @NonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i4, @NonNull Context context, int i5) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(i4, context, i5);
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    public static String getErrorString(int i4) {
        return GooglePlayServicesUtilLight.getErrorString(i4);
    }

    @NonNull
    public static Context getRemoteContext(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    @NonNull
    public static Resources getRemoteResource(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @ResultIgnorabilityUnspecified
    @HideFirstParty
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i4) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i4);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static boolean showErrorDialogFragment(int i4, @NonNull Activity activity, int i5) {
        return showErrorDialogFragment(i4, activity, i5, null);
    }

    @Deprecated
    public static void showErrorNotification(int i4, @NonNull Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (!GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i4) && !GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i4)) {
            googleApiAvailability.showErrorNotification(context, i4);
        } else {
            googleApiAvailability.d(context);
        }
    }

    @Nullable
    @Deprecated
    public static Dialog getErrorDialog(int i4, @NonNull Activity activity, int i5, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i4)) {
            i4 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i4, i5, onCancelListener);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i4) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i4);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static boolean showErrorDialogFragment(int i4, @NonNull Activity activity, int i5, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i4, activity, null, i5, onCancelListener);
    }

    @ResultIgnorabilityUnspecified
    public static boolean showErrorDialogFragment(int i4, @NonNull Activity activity, @Nullable Fragment fragment, int i5, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        int i6 = true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i4) ? 18 : i4;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, i6, i5, onCancelListener);
        }
        Dialog a4 = googleApiAvailability.a(activity, i6, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i6, "d"), i5), onCancelListener, null);
        if (a4 == null) {
            return false;
        }
        googleApiAvailability.b(activity, a4, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
