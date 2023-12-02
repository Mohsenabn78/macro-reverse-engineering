package com.google.firebase.storage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.UpdateMetadataNetworkRequest;
import org.json.JSONException;

/* loaded from: classes5.dex */
class UpdateMetadataTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final StorageReference f32306a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<StorageMetadata> f32307b;

    /* renamed from: c  reason: collision with root package name */
    private final StorageMetadata f32308c;

    /* renamed from: d  reason: collision with root package name */
    private StorageMetadata f32309d = null;

    /* renamed from: e  reason: collision with root package name */
    private ExponentialBackoffSender f32310e;

    public UpdateMetadataTask(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<StorageMetadata> taskCompletionSource, @NonNull StorageMetadata storageMetadata) {
        this.f32306a = storageReference;
        this.f32307b = taskCompletionSource;
        this.f32308c = storageMetadata;
        FirebaseStorage storage = storageReference.getStorage();
        this.f32310e = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.b(), storage.a(), storage.getMaxOperationRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateMetadataNetworkRequest updateMetadataNetworkRequest = new UpdateMetadataNetworkRequest(this.f32306a.c(), this.f32306a.b(), this.f32308c.v());
        this.f32310e.sendWithExponentialBackoff(updateMetadataNetworkRequest);
        if (updateMetadataNetworkRequest.isResultSuccess()) {
            try {
                this.f32309d = new StorageMetadata.Builder(updateMetadataNetworkRequest.getResultBody(), this.f32306a).build();
            } catch (JSONException e4) {
                Log.e("UpdateMetadataTask", "Unable to parse a valid JSON object from resulting metadata:" + updateMetadataNetworkRequest.getRawResult(), e4);
                this.f32307b.setException(StorageException.fromException(e4));
                return;
            }
        }
        TaskCompletionSource<StorageMetadata> taskCompletionSource = this.f32307b;
        if (taskCompletionSource != null) {
            updateMetadataNetworkRequest.completeTask(taskCompletionSource, this.f32309d);
        }
    }
}
