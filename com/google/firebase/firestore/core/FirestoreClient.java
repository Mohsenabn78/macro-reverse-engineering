package com.google.firebase.firestore.core;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.LoadBundleTask;
import com.google.firebase.firestore.TransactionOptions;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleReader;
import com.google.firebase.firestore.bundle.BundleSerializer;
import com.google.firebase.firestore.bundle.NamedQuery;
import com.google.firebase.firestore.core.ComponentProvider;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.firestore.util.Logger;
import com.google.firestore.v1.Value;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class FirestoreClient {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseInfo f30348a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialsProvider<User> f30349b;

    /* renamed from: c  reason: collision with root package name */
    private final CredentialsProvider<String> f30350c;

    /* renamed from: d  reason: collision with root package name */
    private final AsyncQueue f30351d;

    /* renamed from: e  reason: collision with root package name */
    private final BundleSerializer f30352e;

    /* renamed from: f  reason: collision with root package name */
    private final GrpcMetadataProvider f30353f;

    /* renamed from: g  reason: collision with root package name */
    private Persistence f30354g;

    /* renamed from: h  reason: collision with root package name */
    private LocalStore f30355h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteStore f30356i;

    /* renamed from: j  reason: collision with root package name */
    private SyncEngine f30357j;

    /* renamed from: k  reason: collision with root package name */
    private EventManager f30358k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private Scheduler f30359l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Scheduler f30360m;

    public FirestoreClient(final Context context, DatabaseInfo databaseInfo, final FirebaseFirestoreSettings firebaseFirestoreSettings, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, final AsyncQueue asyncQueue, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.f30348a = databaseInfo;
        this.f30349b = credentialsProvider;
        this.f30350c = credentialsProvider2;
        this.f30351d = asyncQueue;
        this.f30353f = grpcMetadataProvider;
        this.f30352e = new BundleSerializer(new RemoteSerializer(databaseInfo.getDatabaseId()));
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        asyncQueue.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.p
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.L(taskCompletionSource, context, firebaseFirestoreSettings);
            }
        });
        credentialsProvider.setChangeListener(new Listener() { // from class: com.google.firebase.firestore.core.r
            @Override // com.google.firebase.firestore.util.Listener
            public final void onValue(Object obj) {
                FirestoreClient.this.N(atomicBoolean, taskCompletionSource, asyncQueue, (User) obj);
            }
        });
        credentialsProvider2.setChangeListener(new Listener() { // from class: com.google.firebase.firestore.core.s
            @Override // com.google.firebase.firestore.util.Listener
            public final void onValue(Object obj) {
                FirestoreClient.O((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(EventListener eventListener) {
        this.f30358k.addSnapshotsInSyncListener(eventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(List list) {
        this.f30355h.configureFieldIndexes(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.f30355h.deleteAllFieldIndexes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        this.f30356i.disableNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f30356i.enableNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Document F(Task task) throws Exception {
        Document document = (Document) task.getResult();
        if (document.isFoundDocument()) {
            return document;
        }
        if (document.isNoDocument()) {
            return null;
        }
        throw new FirebaseFirestoreException("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", FirebaseFirestoreException.Code.UNAVAILABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Document G(DocumentKey documentKey) throws Exception {
        return this.f30355h.readDocument(documentKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ViewSnapshot H(Query query) throws Exception {
        QueryResult executeQuery = this.f30355h.executeQuery(query, true);
        View view = new View(query, executeQuery.getRemoteKeys());
        return view.applyChanges(view.computeDocChanges(executeQuery.getDocuments())).getSnapshot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str, TaskCompletionSource taskCompletionSource) {
        NamedQuery namedQuery = this.f30355h.getNamedQuery(str);
        if (namedQuery != null) {
            Target target = namedQuery.getBundledQuery().getTarget();
            taskCompletionSource.setResult(new Query(target.getPath(), target.getCollectionGroup(), target.getFilters(), target.getOrderBy(), target.getLimit(), namedQuery.getBundledQuery().getLimitType(), target.getStartAt(), target.getEndAt()));
            return;
        }
        taskCompletionSource.setResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(QueryListener queryListener) {
        this.f30358k.addQueryListener(queryListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(BundleReader bundleReader, LoadBundleTask loadBundleTask) {
        this.f30357j.loadBundle(bundleReader, loadBundleTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(TaskCompletionSource taskCompletionSource, Context context, FirebaseFirestoreSettings firebaseFirestoreSettings) {
        try {
            z(context, (User) Tasks.await(taskCompletionSource.getTask()), firebaseFirestoreSettings);
        } catch (InterruptedException | ExecutionException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(User user) {
        boolean z3;
        if (this.f30357j != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "SyncEngine not yet initialized", new Object[0]);
        Logger.debug("FirestoreClient", "Credential changed. Current user: %s", user.getUid());
        this.f30357j.handleCredentialChange(user);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, AsyncQueue asyncQueue, final User user) {
        if (atomicBoolean.compareAndSet(false, true)) {
            Assert.hardAssert(!taskCompletionSource.getTask().isComplete(), "Already fulfilled first user task", new Object[0]);
            taskCompletionSource.setResult(user);
            return;
        }
        asyncQueue.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.v
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.M(user);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(EventListener eventListener) {
        this.f30358k.removeSnapshotsInSyncListener(eventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(Query query, List list, final TaskCompletionSource taskCompletionSource) {
        this.f30357j.runAggregateQuery(query, list).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.firebase.firestore.core.t
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                TaskCompletionSource.this.setResult((Map) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.firebase.firestore.core.u
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TaskCompletionSource.this.setException(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(boolean z3) {
        this.f30355h.setIndexAutoCreationEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(QueryListener queryListener) {
        this.f30358k.removeQueryListener(queryListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f30356i.shutdown();
        this.f30354g.shutdown();
        Scheduler scheduler = this.f30360m;
        if (scheduler != null) {
            scheduler.stop();
        }
        Scheduler scheduler2 = this.f30359l;
        if (scheduler2 != null) {
            scheduler2.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task W(TransactionOptions transactionOptions, Function function) throws Exception {
        return this.f30357j.transaction(this.f30351d, transactionOptions, function);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(TaskCompletionSource taskCompletionSource) {
        this.f30357j.registerPendingWritesTask(taskCompletionSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(List list, TaskCompletionSource taskCompletionSource) {
        this.f30357j.writeMutations(list, taskCompletionSource);
    }

    private void Z() {
        if (!isTerminated()) {
            return;
        }
        throw new IllegalStateException("The client has already been terminated");
    }

    private void z(Context context, User user, FirebaseFirestoreSettings firebaseFirestoreSettings) {
        ComponentProvider memoryComponentProvider;
        Logger.debug("FirestoreClient", "Initializing. user=%s", user.getUid());
        ComponentProvider.Configuration configuration = new ComponentProvider.Configuration(context, this.f30351d, this.f30348a, new Datastore(this.f30348a, this.f30351d, this.f30349b, this.f30350c, context, this.f30353f), user, 100, firebaseFirestoreSettings);
        if (firebaseFirestoreSettings.isPersistenceEnabled()) {
            memoryComponentProvider = new SQLiteComponentProvider();
        } else {
            memoryComponentProvider = new MemoryComponentProvider();
        }
        memoryComponentProvider.initialize(configuration);
        this.f30354g = memoryComponentProvider.getPersistence();
        this.f30360m = memoryComponentProvider.getGarbageCollectionScheduler();
        this.f30355h = memoryComponentProvider.getLocalStore();
        this.f30356i = memoryComponentProvider.getRemoteStore();
        this.f30357j = memoryComponentProvider.getSyncEngine();
        this.f30358k = memoryComponentProvider.getEventManager();
        IndexBackfiller indexBackfiller = memoryComponentProvider.getIndexBackfiller();
        Scheduler scheduler = this.f30360m;
        if (scheduler != null) {
            scheduler.start();
        }
        if (indexBackfiller != null) {
            IndexBackfiller.Scheduler scheduler2 = indexBackfiller.getScheduler();
            this.f30359l = scheduler2;
            scheduler2.start();
        }
    }

    public void addSnapshotsInSyncListener(final EventListener<Void> eventListener) {
        Z();
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.x
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.A(eventListener);
            }
        });
    }

    public Task<Void> configureFieldIndexes(final List<FieldIndex> list) {
        Z();
        return this.f30351d.enqueue(new Runnable() { // from class: com.google.firebase.firestore.core.q
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.B(list);
            }
        });
    }

    public void deleteAllFieldIndexes() {
        Z();
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.w
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.C();
            }
        });
    }

    public Task<Void> disableNetwork() {
        Z();
        return this.f30351d.enqueue(new Runnable() { // from class: com.google.firebase.firestore.core.o
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.D();
            }
        });
    }

    public Task<Void> enableNetwork() {
        Z();
        return this.f30351d.enqueue(new Runnable() { // from class: com.google.firebase.firestore.core.k
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.E();
            }
        });
    }

    @SuppressLint({"TaskMainThread"})
    public Task<Document> getDocumentFromLocalCache(final DocumentKey documentKey) {
        Z();
        return this.f30351d.enqueue(new Callable() { // from class: com.google.firebase.firestore.core.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Document G;
                G = FirestoreClient.this.G(documentKey);
                return G;
            }
        }).continueWith(new Continuation() { // from class: com.google.firebase.firestore.core.b0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Document F;
                F = FirestoreClient.F(task);
                return F;
            }
        });
    }

    public Task<ViewSnapshot> getDocumentsFromLocalCache(final Query query) {
        Z();
        return this.f30351d.enqueue(new Callable() { // from class: com.google.firebase.firestore.core.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ViewSnapshot H;
                H = FirestoreClient.this.H(query);
                return H;
            }
        });
    }

    public Task<Query> getNamedQuery(final String str) {
        Z();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.c0
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.I(str, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public boolean isTerminated() {
        return this.f30351d.isShuttingDown();
    }

    public QueryListener listen(Query query, EventManager.ListenOptions listenOptions, EventListener<ViewSnapshot> eventListener) {
        Z();
        final QueryListener queryListener = new QueryListener(query, listenOptions, eventListener);
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.h
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.J(queryListener);
            }
        });
        return queryListener;
    }

    public void loadBundle(InputStream inputStream, final LoadBundleTask loadBundleTask) {
        Z();
        final BundleReader bundleReader = new BundleReader(this.f30352e, inputStream);
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.y
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.K(bundleReader, loadBundleTask);
            }
        });
    }

    public void removeSnapshotsInSyncListener(final EventListener<Void> eventListener) {
        if (isTerminated()) {
            return;
        }
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.n
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.P(eventListener);
            }
        });
    }

    @SuppressLint({"TaskMainThread"})
    public Task<Map<String, Value>> runAggregateQuery(final Query query, final List<AggregateField> list) {
        Z();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.z
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.S(query, list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void setIndexAutoCreationEnabled(final boolean z3) {
        Z();
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.l
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.T(z3);
            }
        });
    }

    public void stopListening(final QueryListener queryListener) {
        if (isTerminated()) {
            return;
        }
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.m
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.U(queryListener);
            }
        });
    }

    public Task<Void> terminate() {
        this.f30349b.removeChangeListener();
        this.f30350c.removeChangeListener();
        return this.f30351d.enqueueAndInitiateShutdown(new Runnable() { // from class: com.google.firebase.firestore.core.i
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.V();
            }
        });
    }

    public <TResult> Task<TResult> transaction(final TransactionOptions transactionOptions, final Function<Transaction, Task<TResult>> function) {
        Z();
        return AsyncQueue.callTask(this.f30351d.getExecutor(), new Callable() { // from class: com.google.firebase.firestore.core.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Task W;
                W = FirestoreClient.this.W(transactionOptions, function);
                return W;
            }
        });
    }

    public Task<Void> waitForPendingWrites() {
        Z();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.f
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.X(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task<Void> write(final List<Mutation> list) {
        Z();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f30351d.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.core.j
            @Override // java.lang.Runnable
            public final void run() {
                FirestoreClient.this.Y(list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(String str) {
    }
}
