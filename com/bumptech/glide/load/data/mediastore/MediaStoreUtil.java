package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes3.dex */
public final class MediaStoreUtil {
    private MediaStoreUtil() {
    }

    private static boolean a(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        if (isMediaStoreUri(uri) && !a(uri)) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        if (uri != null && FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        if (isMediaStoreUri(uri) && a(uri)) {
            return true;
        }
        return false;
    }

    public static boolean isThumbnailSize(int i4, int i5) {
        if (i4 != Integer.MIN_VALUE && i5 != Integer.MIN_VALUE && i4 <= 512 && i5 <= 384) {
            return true;
        }
        return false;
    }
}
