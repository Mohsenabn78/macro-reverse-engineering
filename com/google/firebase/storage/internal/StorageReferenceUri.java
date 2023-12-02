package com.google.firebase.storage.internal;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.network.NetworkRequest;

/* loaded from: classes5.dex */
public class StorageReferenceUri {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f32369a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f32370b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f32371c;

    public StorageReferenceUri(@NonNull Uri uri) {
        this(uri, null);
    }

    @NonNull
    public Uri getGsUri() {
        return this.f32371c;
    }

    @NonNull
    public Uri getHttpBaseUri() {
        return this.f32369a;
    }

    @NonNull
    public Uri getHttpUri() {
        return this.f32370b;
    }

    public StorageReferenceUri(@NonNull Uri uri, @Nullable EmulatedServiceSettings emulatedServiceSettings) {
        Uri parse;
        this.f32371c = uri;
        if (emulatedServiceSettings == null) {
            parse = NetworkRequest.PROD_BASE_URL;
        } else {
            parse = Uri.parse("http://" + emulatedServiceSettings.getHost() + ":" + emulatedServiceSettings.getPort() + "/v0");
        }
        this.f32369a = parse;
        Uri.Builder appendEncodedPath = parse.buildUpon().appendPath("b").appendEncodedPath(uri.getAuthority());
        String normalizeSlashes = Slashes.normalizeSlashes(uri.getPath());
        if (normalizeSlashes.length() > 0 && !RemoteSettings.FORWARD_SLASH_STRING.equals(normalizeSlashes)) {
            appendEncodedPath = appendEncodedPath.appendPath("o").appendPath(normalizeSlashes);
        }
        this.f32370b = appendEncodedPath.build();
    }
}
