package com.google.firebase.storage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import org.json.JSONException;

/* loaded from: classes5.dex */
class GetMetadataTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private StorageReference f32213a;

    /* renamed from: b  reason: collision with root package name */
    private TaskCompletionSource<StorageMetadata> f32214b;

    /* renamed from: c  reason: collision with root package name */
    private StorageMetadata f32215c;

    /* renamed from: d  reason: collision with root package name */
    private ExponentialBackoffSender f32216d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetMetadataTask(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<StorageMetadata> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.f32213a = storageReference;
        this.f32214b = taskCompletionSource;
        if (!storageReference.getRoot().getName().equals(storageReference.getName())) {
            FirebaseStorage storage = this.f32213a.getStorage();
            this.f32216d = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.b(), storage.a(), storage.getMaxDownloadRetryTimeMillis());
            return;
        }
        throw new IllegalArgumentException("getMetadata() is not supported at the root of the bucket.");
    }

    @Override // java.lang.Runnable
    public void run() {
        GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.f32213a.c(), this.f32213a.b());
        this.f32216d.sendWithExponentialBackoff(getMetadataNetworkRequest);
        if (getMetadataNetworkRequest.isResultSuccess()) {
            try {
                this.f32215c = new StorageMetadata.Builder(getMetadataNetworkRequest.getResultBody(), this.f32213a).build();
            } catch (JSONException e4) {
                Log.e("GetMetadataTask", "Unable to parse resulting metadata. " + getMetadataNetworkRequest.getRawResult(), e4);
                this.f32214b.setException(StorageException.fromException(e4));
                return;
            }
        }
        TaskCompletionSource<StorageMetadata> taskCompletionSource = this.f32214b;
        if (taskCompletionSource != null) {
            getMetadataNetworkRequest.completeTask(taskCompletionSource, this.f32215c);
        }
    }
}
