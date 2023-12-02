package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class ListNetworkRequest extends NetworkRequest {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final Integer f32377m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final String f32378n;

    public ListNetworkRequest(@NonNull StorageReferenceUri storageReferenceUri, @NonNull FirebaseApp firebaseApp, @Nullable Integer num, @Nullable String str) {
        super(storageReferenceUri, firebaseApp);
        this.f32377m = num;
        this.f32378n = str;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected String d() {
        return "GET";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    public Uri getURL() {
        String authority = l().getGsUri().getAuthority();
        return Uri.parse(l().getHttpBaseUri() + "/b/" + authority + "/o");
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected Map<String, String> k() {
        HashMap hashMap = new HashMap();
        String i4 = i();
        if (!i4.isEmpty()) {
            hashMap.put("prefix", i4 + RemoteSettings.FORWARD_SLASH_STRING);
        }
        hashMap.put("delimiter", RemoteSettings.FORWARD_SLASH_STRING);
        Integer num = this.f32377m;
        if (num != null) {
            hashMap.put("maxResults", Integer.toString(num.intValue()));
        }
        if (!TextUtils.isEmpty(this.f32378n)) {
            hashMap.put("pageToken", this.f32378n);
        }
        return hashMap;
    }
}
