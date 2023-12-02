package com.google.firebase.appindexing;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import java.util.List;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class AndroidAppUri {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f28784a;

    private AndroidAppUri(Uri uri) {
        this.f28784a = uri;
    }

    @NonNull
    public static AndroidAppUri newAndroidAppUri(@NonNull Uri uri) {
        AndroidAppUri androidAppUri = new AndroidAppUri(uri);
        if ("android-app".equals(androidAppUri.f28784a.getScheme())) {
            if (!TextUtils.isEmpty(androidAppUri.getPackageName())) {
                return androidAppUri;
            }
            throw new IllegalArgumentException("Package name is empty.");
        }
        throw new IllegalArgumentException("android-app scheme is required.");
    }

    public boolean equals(@NonNull Object obj) {
        if (obj instanceof AndroidAppUri) {
            return this.f28784a.equals(((AndroidAppUri) obj).f28784a);
        }
        return false;
    }

    @NonNull
    public Uri getDeepLinkUri() {
        List<String> pathSegments = this.f28784a.getPathSegments();
        if (pathSegments.size() > 0) {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(pathSegments.get(0));
            if (pathSegments.size() > 1) {
                builder.authority(pathSegments.get(1));
                for (int i4 = 2; i4 < pathSegments.size(); i4++) {
                    builder.appendPath(pathSegments.get(i4));
                }
            }
            builder.encodedQuery(this.f28784a.getEncodedQuery());
            builder.encodedFragment(this.f28784a.getEncodedFragment());
            return builder.build();
        }
        return null;
    }

    @NonNull
    public String getPackageName() {
        return this.f28784a.getAuthority();
    }

    public int hashCode() {
        return Objects.hashCode(this.f28784a);
    }

    @NonNull
    public String toString() {
        return this.f28784a.toString();
    }
}
