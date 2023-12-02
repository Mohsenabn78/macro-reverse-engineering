package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Supplier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class MemoryPersistence extends Persistence {

    /* renamed from: h  reason: collision with root package name */
    private ReferenceDelegate f30675h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f30676i;

    /* renamed from: b  reason: collision with root package name */
    private final Map<User, MemoryMutationQueue> f30669b = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final MemoryIndexManager f30671d = new MemoryIndexManager();

    /* renamed from: e  reason: collision with root package name */
    private final MemoryTargetCache f30672e = new MemoryTargetCache(this);

    /* renamed from: f  reason: collision with root package name */
    private final MemoryBundleCache f30673f = new MemoryBundleCache();

    /* renamed from: g  reason: collision with root package name */
    private final MemoryRemoteDocumentCache f30674g = new MemoryRemoteDocumentCache();

    /* renamed from: c  reason: collision with root package name */
    private final Map<User, MemoryDocumentOverlayCache> f30670c = new HashMap();

    private MemoryPersistence() {
    }

    public static MemoryPersistence createEagerGcMemoryPersistence() {
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        memoryPersistence.n(new MemoryEagerReferenceDelegate(memoryPersistence));
        return memoryPersistence;
    }

    public static MemoryPersistence createLruGcMemoryPersistence(LruGarbageCollector.Params params, LocalSerializer localSerializer) {
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        memoryPersistence.n(new MemoryLruReferenceDelegate(memoryPersistence, params, localSerializer));
        return memoryPersistence;
    }

    private void n(ReferenceDelegate referenceDelegate) {
        this.f30675h = referenceDelegate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public BundleCache a() {
        return this.f30673f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public DocumentOverlayCache b(User user) {
        MemoryDocumentOverlayCache memoryDocumentOverlayCache = this.f30670c.get(user);
        if (memoryDocumentOverlayCache == null) {
            MemoryDocumentOverlayCache memoryDocumentOverlayCache2 = new MemoryDocumentOverlayCache();
            this.f30670c.put(user, memoryDocumentOverlayCache2);
            return memoryDocumentOverlayCache2;
        }
        return memoryDocumentOverlayCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public MutationQueue d(User user, IndexManager indexManager) {
        MemoryMutationQueue memoryMutationQueue = this.f30669b.get(user);
        if (memoryMutationQueue == null) {
            MemoryMutationQueue memoryMutationQueue2 = new MemoryMutationQueue(this, user);
            this.f30669b.put(user, memoryMutationQueue2);
            return memoryMutationQueue2;
        }
        return memoryMutationQueue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public OverlayMigrationManager e() {
        return new MemoryOverlayMigrationManager();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public ReferenceDelegate getReferenceDelegate() {
        return this.f30675h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public <T> T h(String str, Supplier<T> supplier) {
        this.f30675h.c();
        try {
            return supplier.get();
        } finally {
            this.f30675h.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public void i(String str, Runnable runnable) {
        this.f30675h.c();
        try {
            runnable.run();
        } finally {
            this.f30675h.b();
        }
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public boolean isStarted() {
        return this.f30676i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    /* renamed from: j */
    public MemoryIndexManager c(User user) {
        return this.f30671d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterable<MemoryMutationQueue> k() {
        return this.f30669b.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    /* renamed from: l */
    public MemoryRemoteDocumentCache f() {
        return this.f30674g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    /* renamed from: m */
    public MemoryTargetCache g() {
        return this.f30672e;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void shutdown() {
        Assert.hardAssert(this.f30676i, "MemoryPersistence shutdown without start", new Object[0]);
        this.f30676i = false;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void start() {
        Assert.hardAssert(!this.f30676i, "MemoryPersistence double-started!", new Object[0]);
        this.f30676i = true;
    }
}
