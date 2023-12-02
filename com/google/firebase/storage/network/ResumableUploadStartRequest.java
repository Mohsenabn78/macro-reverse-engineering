package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ResumableUploadStartRequest extends ResumableNetworkRequest {

    /* renamed from: m  reason: collision with root package name */
    private final JSONObject f32398m;

    /* renamed from: n  reason: collision with root package name */
    private final String f32399n;

    public ResumableUploadStartRequest(@NonNull StorageReferenceUri storageReferenceUri, @NonNull FirebaseApp firebaseApp, @Nullable JSONObject jSONObject, @NonNull String str) {
        super(storageReferenceUri, firebaseApp);
        this.f32398m = jSONObject;
        this.f32399n = str;
        if (TextUtils.isEmpty(str)) {
            this.f32381a = new IllegalArgumentException("mContentType is null or empty");
        }
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", "start");
        super.setCustomHeader("X-Goog-Upload-Header-Content-Type", str);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected String d() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @Nullable
    protected JSONObject f() {
        return this.f32398m;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    public Uri getURL() {
        String authority = l().getGsUri().getAuthority();
        Uri.Builder buildUpon = l().getHttpBaseUri().buildUpon();
        buildUpon.appendPath("b");
        buildUpon.appendPath(authority);
        buildUpon.appendPath("o");
        return buildUpon.build();
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected Map<String, String> k() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", i());
        hashMap.put("uploadType", "resumable");
        return hashMap;
    }
}
