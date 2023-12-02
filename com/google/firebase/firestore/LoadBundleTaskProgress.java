package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.firestore.bundle.BundleMetadata;

/* loaded from: classes5.dex */
public final class LoadBundleTaskProgress {

    /* renamed from: g  reason: collision with root package name */
    static final LoadBundleTaskProgress f30201g = new LoadBundleTaskProgress(0, 0, 0, 0, null, TaskState.SUCCESS);

    /* renamed from: a  reason: collision with root package name */
    private final int f30202a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30203b;

    /* renamed from: c  reason: collision with root package name */
    private final long f30204c;

    /* renamed from: d  reason: collision with root package name */
    private final long f30205d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TaskState f30206e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Exception f30207f;

    /* loaded from: classes5.dex */
    public enum TaskState {
        ERROR,
        RUNNING,
        SUCCESS
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public LoadBundleTaskProgress(int i4, int i5, long j4, long j5, @Nullable Exception exc, @NonNull TaskState taskState) {
        this.f30202a = i4;
        this.f30203b = i5;
        this.f30204c = j4;
        this.f30205d = j5;
        this.f30206e = taskState;
        this.f30207f = exc;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static LoadBundleTaskProgress forInitial(@NonNull BundleMetadata bundleMetadata) {
        return new LoadBundleTaskProgress(0, bundleMetadata.getTotalDocuments(), 0L, bundleMetadata.getTotalBytes(), null, TaskState.RUNNING);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static LoadBundleTaskProgress forSuccess(@NonNull BundleMetadata bundleMetadata) {
        return new LoadBundleTaskProgress(bundleMetadata.getTotalDocuments(), bundleMetadata.getTotalDocuments(), bundleMetadata.getTotalBytes(), bundleMetadata.getTotalBytes(), null, TaskState.SUCCESS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LoadBundleTaskProgress.class != obj.getClass()) {
            return false;
        }
        LoadBundleTaskProgress loadBundleTaskProgress = (LoadBundleTaskProgress) obj;
        if (this.f30202a != loadBundleTaskProgress.f30202a || this.f30203b != loadBundleTaskProgress.f30203b || this.f30204c != loadBundleTaskProgress.f30204c || this.f30205d != loadBundleTaskProgress.f30205d || this.f30206e != loadBundleTaskProgress.f30206e) {
            return false;
        }
        Exception exc = this.f30207f;
        Exception exc2 = loadBundleTaskProgress.f30207f;
        if (exc != null) {
            return exc.equals(exc2);
        }
        if (exc2 == null) {
            return true;
        }
        return false;
    }

    public long getBytesLoaded() {
        return this.f30204c;
    }

    public int getDocumentsLoaded() {
        return this.f30202a;
    }

    @Nullable
    public Exception getException() {
        return this.f30207f;
    }

    @NonNull
    public TaskState getTaskState() {
        return this.f30206e;
    }

    public long getTotalBytes() {
        return this.f30205d;
    }

    public int getTotalDocuments() {
        return this.f30203b;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f30204c;
        long j5 = this.f30205d;
        int hashCode = ((((((((this.f30202a * 31) + this.f30203b) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f30206e.hashCode()) * 31;
        Exception exc = this.f30207f;
        if (exc != null) {
            i4 = exc.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }
}
