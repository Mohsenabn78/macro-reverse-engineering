package com.google.firebase.storage.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.http.HttpMethods;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class UpdateMetadataNetworkRequest extends NetworkRequest {

    /* renamed from: m  reason: collision with root package name */
    private final JSONObject f32400m;

    public UpdateMetadataNetworkRequest(@NonNull StorageReferenceUri storageReferenceUri, @NonNull FirebaseApp firebaseApp, @Nullable JSONObject jSONObject) {
        super(storageReferenceUri, firebaseApp);
        this.f32400m = jSONObject;
        setCustomHeader(MethodOverride.HEADER, HttpMethods.PATCH);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected String d() {
        return "PUT";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @Nullable
    protected JSONObject f() {
        return this.f32400m;
    }
}
