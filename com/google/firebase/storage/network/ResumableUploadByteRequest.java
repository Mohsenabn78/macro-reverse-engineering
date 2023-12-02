package com.google.firebase.storage.network;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;

/* loaded from: classes5.dex */
public class ResumableUploadByteRequest extends ResumableNetworkRequest {

    /* renamed from: m  reason: collision with root package name */
    private final Uri f32391m;

    /* renamed from: n  reason: collision with root package name */
    private final byte[] f32392n;

    /* renamed from: o  reason: collision with root package name */
    private final long f32393o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f32394p;

    /* renamed from: q  reason: collision with root package name */
    private final int f32395q;

    public ResumableUploadByteRequest(@NonNull StorageReferenceUri storageReferenceUri, @NonNull FirebaseApp firebaseApp, @NonNull Uri uri, @Nullable byte[] bArr, long j4, int i4, boolean z3) {
        super(storageReferenceUri, firebaseApp);
        if (bArr == null && i4 != -1) {
            this.f32381a = new IllegalArgumentException("contentType is null or empty");
        }
        if (j4 < 0) {
            this.f32381a = new IllegalArgumentException("offset cannot be negative");
        }
        this.f32395q = i4;
        this.f32391m = uri;
        this.f32392n = i4 <= 0 ? null : bArr;
        this.f32393o = j4;
        this.f32394p = z3;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        if (z3 && i4 > 0) {
            super.setCustomHeader("X-Goog-Upload-Command", "upload, finalize");
        } else if (z3) {
            super.setCustomHeader("X-Goog-Upload-Command", "finalize");
        } else {
            super.setCustomHeader("X-Goog-Upload-Command", "upload");
        }
        super.setCustomHeader("X-Goog-Upload-Offset", Long.toString(j4));
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    protected String d() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @Nullable
    protected byte[] g() {
        return this.f32392n;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    @NonNull
    public Uri getURL() {
        return this.f32391m;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected int h() {
        int i4 = this.f32395q;
        if (i4 <= 0) {
            return 0;
        }
        return i4;
    }
}
