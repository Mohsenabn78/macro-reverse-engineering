package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.R;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zac {
    @GuardedBy("sCache")

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleArrayMap f20505a = new SimpleArrayMap();
    @Nullable
    @GuardedBy("sCache")

    /* renamed from: b  reason: collision with root package name */
    private static Locale f20506b;

    private static String a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String b4 = b(context, str);
        if (b4 == null) {
            b4 = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, b4, str2);
    }

    @Nullable
    private static String b(Context context, String str) {
        SimpleArrayMap simpleArrayMap = f20505a;
        synchronized (simpleArrayMap) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(f20506b)) {
                simpleArrayMap.clear();
                f20506b = locale;
            }
            String str2 = (String) simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", "Missing resource: " + str);
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            }
            simpleArrayMap.put(str, string);
            return string;
        }
    }

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
    }

    @NonNull
    public static String zac(Context context, int i4) {
        Resources resources = context.getResources();
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return resources.getString(17039370);
                }
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_button);
            }
            return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_button);
        }
        return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_button);
    }

    @NonNull
    public static String zad(Context context, int i4) {
        Resources resources = context.getResources();
        String zaa = zaa(context);
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 5) {
                        if (i4 != 7) {
                            if (i4 != 9) {
                                if (i4 != 20) {
                                    switch (i4) {
                                        case 16:
                                            return a(context, "common_google_play_services_api_unavailable_text", zaa);
                                        case 17:
                                            return a(context, "common_google_play_services_sign_in_failed_text", zaa);
                                        case 18:
                                            return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_updating_text, zaa);
                                        default:
                                            return resources.getString(R.string.common_google_play_services_unknown_issue, zaa);
                                    }
                                }
                                return a(context, "common_google_play_services_restricted_profile_text", zaa);
                            }
                            return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_unsupported_text, zaa);
                        }
                        return a(context, "common_google_play_services_network_error_text", zaa);
                    }
                    return a(context, "common_google_play_services_invalid_account_text", zaa);
                }
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_text, zaa);
            } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_wear_update_text);
            } else {
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_text, zaa);
            }
        }
        return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_text, zaa);
    }

    @NonNull
    public static String zae(Context context, int i4) {
        if (i4 != 6 && i4 != 19) {
            return zad(context, i4);
        }
        return a(context, "common_google_play_services_resolution_required_text", zaa(context));
    }

    @NonNull
    public static String zaf(Context context, int i4) {
        String zag;
        if (i4 == 6) {
            zag = b(context, "common_google_play_services_resolution_required_title");
        } else {
            zag = zag(context, i4);
        }
        if (zag == null) {
            return context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker);
        }
        return zag;
    }

    @Nullable
    public static String zag(Context context, int i4) {
        Resources resources = context.getResources();
        switch (i4) {
            case 1:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return b(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return b(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i4);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return b(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return b(context, "common_google_play_services_restricted_profile_title");
        }
    }
}
