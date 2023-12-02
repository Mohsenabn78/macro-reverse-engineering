package com.google.firebase.storage.network;

import androidx.annotation.NonNull;
import com.google.common.net.HttpHeaders;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes5.dex */
public class GetNetworkRequest extends NetworkRequest {
    public GetNetworkRequest(@NonNull StorageReferenceUri storageReferenceUri, @NonNull FirebaseApp firebaseApp, long j4) {
        super(storageReferenceUri, firebaseApp);
        if (j4 != 0) {
            super.setCustomHeader(HttpHeaders.RANGE, "bytes=" + j4 + "-");
        }
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected String d() {
        return "GET";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected Map<String, String> k() {
        return Collections.singletonMap("alt", "media");
    }
}
