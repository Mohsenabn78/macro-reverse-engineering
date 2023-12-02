package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.StreamDownloadTask;
import com.google.firebase.storage.internal.Slashes;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class StorageReference implements Comparable<StorageReference> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f32245a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseStorage f32246b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageReference(@NonNull Uri uri, @NonNull FirebaseStorage firebaseStorage) {
        boolean z3;
        if (uri != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "storageUri cannot be null");
        Preconditions.checkArgument(firebaseStorage != null, "FirebaseApp cannot be null");
        this.f32245a = uri;
        this.f32246b = firebaseStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<ListResult> d(@Nullable Integer num, @Nullable String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new ListTask(this, num, str, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public FirebaseApp b() {
        return getStorage().getApp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public StorageReferenceUri c() {
        return new StorageReferenceUri(this.f32245a, this.f32246b.d());
    }

    @NonNull
    public StorageReference child(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "childName cannot be null or empty");
        return new StorageReference(this.f32245a.buildUpon().appendEncodedPath(Slashes.preserveSlashEncode(Slashes.normalizeSlashes(str))).build(), this.f32246b);
    }

    @NonNull
    public Task<Void> delete() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new DeleteStorageTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StorageReference)) {
            return false;
        }
        return ((StorageReference) obj).toString().equals(toString());
    }

    @NonNull
    public List<FileDownloadTask> getActiveDownloadTasks() {
        return StorageTaskManager.c().b(this);
    }

    @NonNull
    public List<UploadTask> getActiveUploadTasks() {
        return StorageTaskManager.c().d(this);
    }

    @NonNull
    public String getBucket() {
        return this.f32245a.getAuthority();
    }

    @NonNull
    public Task<byte[]> getBytes(final long j4) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.X(new StreamDownloadTask.StreamProcessor() { // from class: com.google.firebase.storage.StorageReference.3
            @Override // com.google.firebase.storage.StreamDownloadTask.StreamProcessor
            public void doInBackground(StreamDownloadTask.TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[16384];
                    int i4 = 0;
                    while (true) {
                        int read = inputStream.read(bArr, 0, 16384);
                        if (read != -1) {
                            i4 += read;
                            if (i4 <= j4) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                Log.e("StorageReference", "the maximum allowed buffer size was exceeded.");
                                throw new IndexOutOfBoundsException("the maximum allowed buffer size was exceeded.");
                            }
                        } else {
                            byteArrayOutputStream.flush();
                            taskCompletionSource.setResult(byteArrayOutputStream.toByteArray());
                            return;
                        }
                    }
                } finally {
                    inputStream.close();
                }
            }
        }).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<StreamDownloadTask.TaskSnapshot>() { // from class: com.google.firebase.storage.StorageReference.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                if (!taskCompletionSource.getTask().isComplete()) {
                    Log.e("StorageReference", "getBytes 'succeeded', but failed to set a Result.");
                    taskCompletionSource.setException(StorageException.fromErrorStatus(Status.RESULT_INTERNAL_ERROR));
                }
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.firebase.storage.StorageReference.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(@NonNull Exception exc) {
                taskCompletionSource.setException(StorageException.fromExceptionAndHttpCode(exc, 0));
            }
        });
        streamDownloadTask.G();
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Uri> getDownloadUrl() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new GetDownloadUrlTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull Uri uri) {
        FileDownloadTask fileDownloadTask = new FileDownloadTask(this, uri);
        fileDownloadTask.G();
        return fileDownloadTask;
    }

    @NonNull
    public Task<StorageMetadata> getMetadata() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new GetMetadataTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public String getName() {
        String path = this.f32245a.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf != -1) {
            return path.substring(lastIndexOf + 1);
        }
        return path;
    }

    @Nullable
    public StorageReference getParent() {
        String path = this.f32245a.getPath();
        if (!TextUtils.isEmpty(path)) {
            String str = RemoteSettings.FORWARD_SLASH_STRING;
            if (!path.equals(RemoteSettings.FORWARD_SLASH_STRING)) {
                int lastIndexOf = path.lastIndexOf(47);
                if (lastIndexOf != -1) {
                    str = path.substring(0, lastIndexOf);
                }
                return new StorageReference(this.f32245a.buildUpon().path(str).build(), this.f32246b);
            }
            return null;
        }
        return null;
    }

    @NonNull
    public String getPath() {
        return this.f32245a.getPath();
    }

    @NonNull
    public StorageReference getRoot() {
        return new StorageReference(this.f32245a.buildUpon().path("").build(), this.f32246b);
    }

    @NonNull
    public FirebaseStorage getStorage() {
        return this.f32246b;
    }

    @NonNull
    public StreamDownloadTask getStream() {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.G();
        return streamDownloadTask;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public Task<ListResult> list(int i4) {
        Preconditions.checkArgument(i4 > 0, "maxResults must be greater than zero");
        Preconditions.checkArgument(i4 <= 1000, "maxResults must be at most 1000");
        return d(Integer.valueOf(i4), null);
    }

    @NonNull
    public Task<ListResult> listAll() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final Executor commandPoolExecutor = StorageTaskScheduler.getInstance().getCommandPoolExecutor();
        d(null, null).continueWithTask(commandPoolExecutor, new Continuation<ListResult, Task<Void>>() { // from class: com.google.firebase.storage.StorageReference.4
            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public Task<Void> then(@NonNull Task<ListResult> task) {
                if (task.isSuccessful()) {
                    ListResult result = task.getResult();
                    arrayList.addAll(result.getPrefixes());
                    arrayList2.addAll(result.getItems());
                    if (result.getPageToken() != null) {
                        StorageReference.this.d(null, result.getPageToken()).continueWithTask(commandPoolExecutor, this);
                    } else {
                        taskCompletionSource.setResult(new ListResult(arrayList, arrayList2, null));
                    }
                } else {
                    taskCompletionSource.setException(task.getException());
                }
                return Tasks.forResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr) {
        Preconditions.checkArgument(bArr != null, "bytes cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, bArr);
        uploadTask.G();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri) {
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        UploadTask uploadTask = new UploadTask(this, null, uri, null);
        uploadTask.G();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream) {
        Preconditions.checkArgument(inputStream != null, "stream cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, inputStream);
        uploadTask.G();
        return uploadTask;
    }

    public String toString() {
        return "gs://" + this.f32245a.getAuthority() + this.f32245a.getEncodedPath();
    }

    @NonNull
    public Task<StorageMetadata> updateMetadata(@NonNull StorageMetadata storageMetadata) {
        Preconditions.checkNotNull(storageMetadata);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new UpdateMetadataTask(this, taskCompletionSource, storageMetadata));
        return taskCompletionSource.getTask();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull StorageReference storageReference) {
        return this.f32245a.compareTo(storageReference.f32245a);
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull File file) {
        return getFile(Uri.fromFile(file));
    }

    @NonNull
    public StreamDownloadTask getStream(@NonNull StreamDownloadTask.StreamProcessor streamProcessor) {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.X(streamProcessor);
        streamDownloadTask.G();
        return streamDownloadTask;
    }

    @NonNull
    public Task<ListResult> list(int i4, @NonNull String str) {
        Preconditions.checkArgument(i4 > 0, "maxResults must be greater than zero");
        Preconditions.checkArgument(i4 <= 1000, "maxResults must be at most 1000");
        Preconditions.checkArgument(str != null, "pageToken must be non-null to resume a previous list() operation");
        return d(Integer.valueOf(i4), str);
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr, @NonNull StorageMetadata storageMetadata) {
        Preconditions.checkArgument(bArr != null, "bytes cannot be null");
        Preconditions.checkArgument(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, bArr);
        uploadTask.G();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @NonNull StorageMetadata storageMetadata) {
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        Preconditions.checkArgument(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, null);
        uploadTask.G();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream, @NonNull StorageMetadata storageMetadata) {
        Preconditions.checkArgument(inputStream != null, "stream cannot be null");
        Preconditions.checkArgument(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, inputStream);
        uploadTask.G();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @Nullable StorageMetadata storageMetadata, @Nullable Uri uri2) {
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        Preconditions.checkArgument(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, uri2);
        uploadTask.G();
        return uploadTask;
    }
}
