package com.google.firebase.storage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.ListNetworkRequest;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ListTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final StorageReference f32220a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<ListResult> f32221b;

    /* renamed from: c  reason: collision with root package name */
    private final ExponentialBackoffSender f32222c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f32223d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Integer f32224e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListTask(@NonNull StorageReference storageReference, @Nullable Integer num, @Nullable String str, @NonNull TaskCompletionSource<ListResult> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.f32220a = storageReference;
        this.f32224e = num;
        this.f32223d = str;
        this.f32221b = taskCompletionSource;
        FirebaseStorage storage = storageReference.getStorage();
        this.f32222c = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.b(), storage.a(), storage.getMaxDownloadRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        ListResult a4;
        ListNetworkRequest listNetworkRequest = new ListNetworkRequest(this.f32220a.c(), this.f32220a.b(), this.f32224e, this.f32223d);
        this.f32222c.sendWithExponentialBackoff(listNetworkRequest);
        if (listNetworkRequest.isResultSuccess()) {
            try {
                a4 = ListResult.a(this.f32220a.getStorage(), listNetworkRequest.getResultBody());
            } catch (JSONException e4) {
                Log.e("ListTask", "Unable to parse response body. " + listNetworkRequest.getRawResult(), e4);
                this.f32221b.setException(StorageException.fromException(e4));
                return;
            }
        } else {
            a4 = null;
        }
        TaskCompletionSource<ListResult> taskCompletionSource = this.f32221b;
        if (taskCompletionSource != null) {
            listNetworkRequest.completeTask(taskCompletionSource, a4);
        }
    }
}
