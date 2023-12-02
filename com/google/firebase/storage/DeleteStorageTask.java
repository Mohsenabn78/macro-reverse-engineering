package com.google.firebase.storage;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.DeleteNetworkRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class DeleteStorageTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private StorageReference f32182a;

    /* renamed from: b  reason: collision with root package name */
    private TaskCompletionSource<Void> f32183b;

    /* renamed from: c  reason: collision with root package name */
    private ExponentialBackoffSender f32184c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DeleteStorageTask(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.f32182a = storageReference;
        this.f32183b = taskCompletionSource;
        FirebaseStorage storage = storageReference.getStorage();
        this.f32184c = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.b(), storage.a(), storage.getMaxDownloadRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        DeleteNetworkRequest deleteNetworkRequest = new DeleteNetworkRequest(this.f32182a.c(), this.f32182a.b());
        this.f32184c.sendWithExponentialBackoff(deleteNetworkRequest);
        deleteNetworkRequest.completeTask(this.f32183b, null);
    }
}
