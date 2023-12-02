package com.google.firebase.storage.internal;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes5.dex */
public class Util {
    public static final String ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final int NETWORK_UNAVAILABLE = -2;

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equal(obj, obj2);
    }

    @Nullable
    public static String getCurrentAppCheckToken(@Nullable InteropAppCheckTokenProvider interopAppCheckTokenProvider) {
        if (interopAppCheckTokenProvider == null) {
            return null;
        }
        try {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) Tasks.await(interopAppCheckTokenProvider.getToken(false), 30000L, TimeUnit.MILLISECONDS);
            if (appCheckTokenResult.getError() != null) {
                Log.w("StorageUtil", "Error getting App Check token; using placeholder token instead. Error: " + appCheckTokenResult.getError());
            }
            return appCheckTokenResult.getToken();
        } catch (InterruptedException | ExecutionException | TimeoutException e4) {
            Log.e("StorageUtil", "Unexpected error getting App Check token: " + e4);
            return null;
        }
    }

    @Nullable
    public static String getCurrentAuthToken(@Nullable InternalAuthProvider internalAuthProvider) {
        String str;
        if (internalAuthProvider != null) {
            try {
                str = ((GetTokenResult) Tasks.await(internalAuthProvider.getAccessToken(false), 30000L, TimeUnit.MILLISECONDS)).getToken();
            } catch (InterruptedException | ExecutionException | TimeoutException e4) {
                Log.e("StorageUtil", "error getting token " + e4);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Log.w("StorageUtil", "no auth token for request");
        return null;
    }

    @Nullable
    public static Uri normalize(@NonNull FirebaseApp firebaseApp, @Nullable String str) throws UnsupportedEncodingException {
        String substring;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = NetworkRequest.PROD_BASE_URL;
        if (str.toLowerCase().startsWith("gs://")) {
            String preserveSlashEncode = Slashes.preserveSlashEncode(Slashes.normalizeSlashes(str.substring(5)));
            return Uri.parse("gs://" + preserveSlashEncode);
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme != null && (equals(scheme.toLowerCase(), "http") || equals(scheme.toLowerCase(), ProxyConfig.MATCH_HTTPS))) {
            int indexOf = parse.getAuthority().toLowerCase().indexOf(uri.getAuthority());
            String slashize = Slashes.slashize(parse.getEncodedPath());
            if (indexOf == 0 && slashize.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                int indexOf2 = slashize.indexOf("/b/", 0);
                int i4 = indexOf2 + 3;
                int indexOf3 = slashize.indexOf(RemoteSettings.FORWARD_SLASH_STRING, i4);
                int indexOf4 = slashize.indexOf("/o/", 0);
                if (indexOf2 != -1 && indexOf3 != -1) {
                    substring = slashize.substring(i4, indexOf3);
                    if (indexOf4 != -1) {
                        str2 = slashize.substring(indexOf4 + 3);
                    } else {
                        str2 = "";
                    }
                    slashize = str2;
                } else {
                    Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                    throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                }
            } else if (indexOf > 1) {
                substring = parse.getAuthority().substring(0, indexOf - 1);
            } else {
                Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
            }
            Preconditions.checkNotEmpty(substring, "No bucket specified");
            return new Uri.Builder().scheme("gs").authority(substring).encodedPath(slashize).build();
        }
        Log.w("StorageUtil", "FirebaseStorage is unable to support the scheme:" + scheme);
        throw new IllegalArgumentException("Uri scheme");
    }

    public static long parseDateTime(@Nullable String str) {
        if (str == null) {
            return 0L;
        }
        String replaceAll = str.replaceAll("Z$", "-0000");
        try {
            return new SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault()).parse(replaceAll).getTime();
        } catch (ParseException e4) {
            Log.w("StorageUtil", "unable to parse datetime:" + replaceAll, e4);
            return 0L;
        }
    }
}
