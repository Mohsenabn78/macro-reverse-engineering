package com.google.firebase.firestore.remote;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.auto.value.AutoValue;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.remote.WatchChangeAggregator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes5.dex */
public final class TestingHooks {

    /* renamed from: b  reason: collision with root package name */
    private static final TestingHooks f31173b = new TestingHooks();

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<AtomicReference<ExistenceFilterMismatchListener>> f31174a = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @AutoValue
    /* loaded from: classes5.dex */
    public static abstract class ExistenceFilterBloomFilterInfo {
        static ExistenceFilterBloomFilterInfo d(@Nullable BloomFilter bloomFilter, boolean z3, int i4, int i5, int i6) {
            return new AutoValue_TestingHooks_ExistenceFilterBloomFilterInfo(bloomFilter, z3, i4, i5, i6);
        }

        @Nullable
        static ExistenceFilterBloomFilterInfo e(@Nullable BloomFilter bloomFilter, WatchChangeAggregator.BloomFilterApplicationStatus bloomFilterApplicationStatus, ExistenceFilter existenceFilter) {
            boolean z3;
            com.google.firestore.v1.BloomFilter unchangedNames = existenceFilter.getUnchangedNames();
            if (unchangedNames == null) {
                return null;
            }
            if (bloomFilterApplicationStatus == WatchChangeAggregator.BloomFilterApplicationStatus.SUCCESS) {
                z3 = true;
            } else {
                z3 = false;
            }
            return d(bloomFilter, z3, unchangedNames.getHashCount(), unchangedNames.getBits().getBitmap().size(), unchangedNames.getBits().getPadding());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int b();

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public abstract BloomFilter c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int f();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @AutoValue
    /* loaded from: classes5.dex */
    public static abstract class ExistenceFilterMismatchInfo {
        static ExistenceFilterMismatchInfo b(int i4, int i5, String str, String str2, @Nullable ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo) {
            return new AutoValue_TestingHooks_ExistenceFilterMismatchInfo(i4, i5, str, str2, existenceFilterBloomFilterInfo);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static ExistenceFilterMismatchInfo e(int i4, ExistenceFilter existenceFilter, DatabaseId databaseId, @Nullable BloomFilter bloomFilter, WatchChangeAggregator.BloomFilterApplicationStatus bloomFilterApplicationStatus) {
            return b(i4, existenceFilter.getCount(), databaseId.getProjectId(), databaseId.getDatabaseId(), ExistenceFilterBloomFilterInfo.e(bloomFilter, bloomFilterApplicationStatus, existenceFilter));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public abstract ExistenceFilterBloomFilterInfo a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int d();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int f();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface ExistenceFilterMismatchListener {
        @AnyThread
        void a(@NonNull ExistenceFilterMismatchInfo existenceFilterMismatchInfo);
    }

    private TestingHooks() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static TestingHooks a() {
        return f31173b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull ExistenceFilterMismatchInfo existenceFilterMismatchInfo) {
        Iterator<AtomicReference<ExistenceFilterMismatchListener>> it = this.f31174a.iterator();
        while (it.hasNext()) {
            ExistenceFilterMismatchListener existenceFilterMismatchListener = it.next().get();
            if (existenceFilterMismatchListener != null) {
                existenceFilterMismatchListener.a(existenceFilterMismatchInfo);
            }
        }
    }
}
