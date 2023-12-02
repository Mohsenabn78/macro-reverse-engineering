package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class GetDownloadUrlTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private StorageReference f32210a;

    /* renamed from: b  reason: collision with root package name */
    private TaskCompletionSource<Uri> f32211b;

    /* renamed from: c  reason: collision with root package name */
    private ExponentialBackoffSender f32212c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetDownloadUrlTask(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<Uri> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.f32210a = storageReference;
        this.f32211b = taskCompletionSource;
        if (!storageReference.getRoot().getName().equals(storageReference.getName())) {
            FirebaseStorage storage = this.f32210a.getStorage();
            this.f32212c = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.b(), storage.a(), storage.getMaxOperationRetryTimeMillis());
            return;
        }
        throw new IllegalArgumentException("getDownloadUrl() is not supported at the root of the bucket.");
    }

    private Uri a(JSONObject jSONObject) {
        String optString = jSONObject.optString("downloadTokens");
        if (!TextUtils.isEmpty(optString)) {
            String str = optString.split(",", -1)[0];
            Uri.Builder buildUpon = this.f32210a.c().getHttpUri().buildUpon();
            buildUpon.appendQueryParameter("alt", "media");
            buildUpon.appendQueryParameter("token", str);
            return buildUpon.build();
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Uri uri;
        GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.f32210a.c(), this.f32210a.b());
        this.f32212c.sendWithExponentialBackoff(getMetadataNetworkRequest);
        if (getMetadataNetworkRequest.isResultSuccess()) {
            uri = a(getMetadataNetworkRequest.getResultBody());
        } else {
            uri = null;
        }
        TaskCompletionSource<Uri> taskCompletionSource = this.f32211b;
        if (taskCompletionSource != null) {
            getMetadataNetworkRequest.completeTask(taskCompletionSource, uri);
        }
    }
}
