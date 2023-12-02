package com.google.firebase.storage;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class StorageTaskManager {

    /* renamed from: c  reason: collision with root package name */
    private static final StorageTaskManager f32272c = new StorageTaskManager();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WeakReference<StorageTask<?>>> f32273a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Object f32274b = new Object();

    StorageTaskManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StorageTaskManager c() {
        return f32272c;
    }

    public void a(StorageTask<?> storageTask) {
        synchronized (this.f32274b) {
            this.f32273a.put(storageTask.q().toString(), new WeakReference<>(storageTask));
        }
    }

    public List<FileDownloadTask> b(@NonNull StorageReference storageReference) {
        List<FileDownloadTask> unmodifiableList;
        synchronized (this.f32274b) {
            ArrayList arrayList = new ArrayList();
            String storageReference2 = storageReference.toString();
            for (Map.Entry<String, WeakReference<StorageTask<?>>> entry : this.f32273a.entrySet()) {
                if (entry.getKey().startsWith(storageReference2)) {
                    StorageTask<?> storageTask = entry.getValue().get();
                    if (storageTask instanceof FileDownloadTask) {
                        arrayList.add((FileDownloadTask) storageTask);
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public List<UploadTask> d(@NonNull StorageReference storageReference) {
        List<UploadTask> unmodifiableList;
        synchronized (this.f32274b) {
            ArrayList arrayList = new ArrayList();
            String storageReference2 = storageReference.toString();
            for (Map.Entry<String, WeakReference<StorageTask<?>>> entry : this.f32273a.entrySet()) {
                if (entry.getKey().startsWith(storageReference2)) {
                    StorageTask<?> storageTask = entry.getValue().get();
                    if (storageTask instanceof UploadTask) {
                        arrayList.add((UploadTask) storageTask);
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public void e(StorageTask<?> storageTask) {
        StorageTask<?> storageTask2;
        synchronized (this.f32274b) {
            String storageReference = storageTask.q().toString();
            WeakReference<StorageTask<?>> weakReference = this.f32273a.get(storageReference);
            if (weakReference != null) {
                storageTask2 = weakReference.get();
            } else {
                storageTask2 = null;
            }
            if (storageTask2 == null || storageTask2 == storageTask) {
                this.f32273a.remove(storageReference);
            }
        }
    }
}
