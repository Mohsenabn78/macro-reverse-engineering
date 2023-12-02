package com.google.android.gms.appindexing;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
public final class AndroidAppUri {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f19591a;

    private AndroidAppUri(Uri uri) {
        this.f19591a = uri;
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    public static AndroidAppUri newAndroidAppUri(@NonNull Uri uri) {
        AndroidAppUri androidAppUri = new AndroidAppUri(uri);
        if ("android-app".equals(androidAppUri.f19591a.getScheme())) {
            if (!TextUtils.isEmpty(androidAppUri.getPackageName())) {
                if (androidAppUri.f19591a.equals(newAndroidAppUri(androidAppUri.getPackageName(), androidAppUri.getDeepLinkUri()).toUri())) {
                    return androidAppUri;
                }
                throw new IllegalArgumentException("URI is not canonical.");
            }
            throw new IllegalArgumentException("Package name is empty.");
        }
        throw new IllegalArgumentException("android-app scheme is required.");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof AndroidAppUri) {
            return this.f19591a.equals(((AndroidAppUri) obj).f19591a);
        }
        return false;
    }

    @androidx.annotation.Nullable
    @VisibleForTesting
    public Uri getDeepLinkUri() {
        List<String> pathSegments = this.f19591a.getPathSegments();
        if (pathSegments.size() > 0) {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(pathSegments.get(0));
            if (pathSegments.size() > 1) {
                builder.authority(pathSegments.get(1));
                for (int i4 = 2; i4 < pathSegments.size(); i4++) {
                    builder.appendPath(pathSegments.get(i4));
                }
            }
            builder.encodedQuery(this.f19591a.getEncodedQuery());
            builder.encodedFragment(this.f19591a.getEncodedFragment());
            return builder.build();
        }
        return null;
    }

    @androidx.annotation.Nullable
    @VisibleForTesting
    public String getPackageName() {
        return this.f19591a.getAuthority();
    }

    public int hashCode() {
        return Objects.hashCode(this.f19591a);
    }

    @NonNull
    public String toString() {
        return this.f19591a.toString();
    }

    @NonNull
    @VisibleForTesting
    public Uri toUri() {
        return this.f19591a;
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    public static AndroidAppUri newAndroidAppUri(@Nullable String str, @Nullable Uri uri) {
        Uri.Builder authority = new Uri.Builder().scheme("android-app").authority(str);
        if (uri != null) {
            String scheme = uri.getScheme();
            if (scheme != null) {
                authority.appendPath(scheme);
            }
            String authority2 = uri.getAuthority();
            if (authority2 != null) {
                authority.appendPath(authority2);
            }
            for (String str2 : uri.getPathSegments()) {
                authority.appendPath(str2);
            }
            authority.encodedQuery(uri.getEncodedQuery()).encodedFragment(uri.getEncodedFragment());
        }
        return new AndroidAppUri(authority.build());
    }
}
