package com.google.firebase.firestore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PreviewApi;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.FirebaseAppCheckTokenProvider;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.remote.FirestoreChannel;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ByteBufferInputStream;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.inject.Deferred;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class FirebaseFirestore {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30159a;

    /* renamed from: b  reason: collision with root package name */
    private final DatabaseId f30160b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30161c;

    /* renamed from: d  reason: collision with root package name */
    private final CredentialsProvider<User> f30162d;

    /* renamed from: e  reason: collision with root package name */
    private final CredentialsProvider<String> f30163e;

    /* renamed from: f  reason: collision with root package name */
    private final AsyncQueue f30164f;

    /* renamed from: g  reason: collision with root package name */
    private final FirebaseApp f30165g;

    /* renamed from: h  reason: collision with root package name */
    private final UserDataReader f30166h;

    /* renamed from: i  reason: collision with root package name */
    private final InstanceRegistry f30167i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private EmulatedServiceSettings f30168j;

    /* renamed from: k  reason: collision with root package name */
    private FirebaseFirestoreSettings f30169k = new FirebaseFirestoreSettings.Builder().build();

    /* renamed from: l  reason: collision with root package name */
    private volatile FirestoreClient f30170l;

    /* renamed from: m  reason: collision with root package name */
    private final GrpcMetadataProvider f30171m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private PersistentCacheIndexManager f30172n;

    /* loaded from: classes5.dex */
    public interface InstanceRegistry {
        void remove(@NonNull String str);
    }

    @VisibleForTesting
    FirebaseFirestore(Context context, DatabaseId databaseId, String str, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, AsyncQueue asyncQueue, @Nullable FirebaseApp firebaseApp, InstanceRegistry instanceRegistry, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.f30159a = (Context) Preconditions.checkNotNull(context);
        this.f30160b = (DatabaseId) Preconditions.checkNotNull((DatabaseId) Preconditions.checkNotNull(databaseId));
        this.f30166h = new UserDataReader(databaseId);
        this.f30161c = (String) Preconditions.checkNotNull(str);
        this.f30162d = (CredentialsProvider) Preconditions.checkNotNull(credentialsProvider);
        this.f30163e = (CredentialsProvider) Preconditions.checkNotNull(credentialsProvider2);
        this.f30164f = (AsyncQueue) Preconditions.checkNotNull(asyncQueue);
        this.f30165g = firebaseApp;
        this.f30167i = instanceRegistry;
        this.f30171m = grpcMetadataProvider;
    }

    private ListenerRegistration g(Executor executor, @Nullable Activity activity, @NonNull final Runnable runnable) {
        h();
        final AsyncEventListener asyncEventListener = new AsyncEventListener(executor, new EventListener() { // from class: com.google.firebase.firestore.g
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                FirebaseFirestore.m(runnable, (Void) obj, firebaseFirestoreException);
            }
        });
        this.f30170l.addSnapshotsInSyncListener(asyncEventListener);
        return ActivityScope.bind(activity, new ListenerRegistration() { // from class: com.google.firebase.firestore.h
            @Override // com.google.firebase.firestore.ListenerRegistration
            public final void remove() {
                FirebaseFirestore.this.n(asyncEventListener);
            }
        });
    }

    @NonNull
    public static FirebaseFirestore getInstance() {
        return getInstance(k(), "(default)");
    }

    private void h() {
        if (this.f30170l != null) {
            return;
        }
        synchronized (this.f30160b) {
            if (this.f30170l != null) {
                return;
            }
            this.f30170l = new FirestoreClient(this.f30159a, new DatabaseInfo(this.f30160b, this.f30161c, this.f30169k.getHost(), this.f30169k.isSslEnabled()), this.f30169k, this.f30162d, this.f30163e, this.f30164f, this.f30171m);
        }
    }

    @NonNull
    private static FirebaseApp k() {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        if (firebaseApp != null) {
            return firebaseApp;
        }
        throw new IllegalStateException("You must call FirebaseApp.initializeApp first.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(Runnable runnable, Void r22, FirebaseFirestoreException firebaseFirestoreException) {
        boolean z3;
        if (firebaseFirestoreException == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "snapshots-in-sync listeners should never get errors.", new Object[0]);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(AsyncEventListener asyncEventListener) {
        asyncEventListener.mute();
        this.f30170l.removeSnapshotsInSyncListener(asyncEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(TaskCompletionSource taskCompletionSource) {
        try {
            if (this.f30170l != null && !this.f30170l.isTerminated()) {
                throw new FirebaseFirestoreException("Persistence cannot be cleared while the firestore instance is running.", FirebaseFirestoreException.Code.FAILED_PRECONDITION);
            }
            SQLitePersistence.clearPersistence(this.f30159a, this.f30160b, this.f30161c);
            taskCompletionSource.setResult(null);
        } catch (FirebaseFirestoreException e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Query p(Task task) throws Exception {
        com.google.firebase.firestore.core.Query query = (com.google.firebase.firestore.core.Query) task.getResult();
        if (query != null) {
            return new Query(query, this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Transaction.Function function, com.google.firebase.firestore.core.Transaction transaction) throws Exception {
        return function.apply(new Transaction(transaction, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task r(Executor executor, final Transaction.Function function, final com.google.firebase.firestore.core.Transaction transaction) {
        return Tasks.call(executor, new Callable() { // from class: com.google.firebase.firestore.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object q4;
                q4 = FirebaseFirestore.this.q(function, transaction);
                return q4;
            }
        });
    }

    private FirebaseFirestoreSettings s(@NonNull FirebaseFirestoreSettings firebaseFirestoreSettings, @Nullable EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings == null) {
            return firebaseFirestoreSettings;
        }
        if (!FirebaseFirestoreSettings.DEFAULT_HOST.equals(firebaseFirestoreSettings.getHost())) {
            Logger.warn("FirebaseFirestore", "Host has been set in FirebaseFirestoreSettings and useEmulator, emulator host will be used.", new Object[0]);
        }
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder(firebaseFirestoreSettings);
        return builder.setHost(emulatedServiceSettings.getHost() + ":" + emulatedServiceSettings.getPort()).setSslEnabled(false).build();
    }

    @Keep
    static void setClientLanguage(@NonNull String str) {
        FirestoreChannel.setClientLanguage(str);
    }

    public static void setLoggingEnabled(boolean z3) {
        if (z3) {
            Logger.setLogLevel(Logger.Level.DEBUG);
        } else {
            Logger.setLogLevel(Logger.Level.WARN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static FirebaseFirestore t(@NonNull Context context, @NonNull FirebaseApp firebaseApp, @NonNull Deferred<InternalAuthProvider> deferred, @NonNull Deferred<InteropAppCheckTokenProvider> deferred2, @NonNull String str, @NonNull InstanceRegistry instanceRegistry, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        String projectId = firebaseApp.getOptions().getProjectId();
        if (projectId != null) {
            DatabaseId forDatabase = DatabaseId.forDatabase(projectId, str);
            AsyncQueue asyncQueue = new AsyncQueue();
            return new FirebaseFirestore(context, forDatabase, firebaseApp.getName(), new FirebaseAuthCredentialsProvider(deferred), new FirebaseAppCheckTokenProvider(deferred2), asyncQueue, firebaseApp, instanceRegistry, grpcMetadataProvider);
        }
        throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
    }

    private <ResultT> Task<ResultT> u(TransactionOptions transactionOptions, final Transaction.Function<ResultT> function, final Executor executor) {
        h();
        return this.f30170l.transaction(transactionOptions, new Function() { // from class: com.google.firebase.firestore.f
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Task r4;
                r4 = FirebaseFirestore.this.r(executor, function, (com.google.firebase.firestore.core.Transaction) obj);
                return r4;
            }
        });
    }

    @NonNull
    public ListenerRegistration addSnapshotsInSyncListener(@NonNull Runnable runnable) {
        return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, runnable);
    }

    @NonNull
    public WriteBatch batch() {
        h();
        return new WriteBatch(this);
    }

    @NonNull
    public Task<Void> clearPersistence() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f30164f.enqueueAndForgetEvenAfterShutdown(new Runnable() { // from class: com.google.firebase.firestore.i
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseFirestore.this.o(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    public CollectionReference collection(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided collection path must not be null.");
        h();
        return new CollectionReference(ResourcePath.fromString(str), this);
    }

    @NonNull
    public Query collectionGroup(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided collection ID must not be null.");
        if (!str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            h();
            return new Query(new com.google.firebase.firestore.core.Query(ResourcePath.EMPTY, str), this);
        }
        throw new IllegalArgumentException(String.format("Invalid collectionId '%s'. Collection IDs must not contain '/'.", str));
    }

    @NonNull
    public Task<Void> disableNetwork() {
        h();
        return this.f30170l.disableNetwork();
    }

    @NonNull
    public DocumentReference document(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided document path must not be null.");
        h();
        return DocumentReference.f(ResourcePath.fromString(str), this);
    }

    @NonNull
    public Task<Void> enableNetwork() {
        h();
        return this.f30170l.enableNetwork();
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.f30165g;
    }

    @NonNull
    public FirebaseFirestoreSettings getFirestoreSettings() {
        return this.f30169k;
    }

    @NonNull
    @SuppressLint({"TaskMainThread"})
    public Task<Query> getNamedQuery(@NonNull String str) {
        h();
        return this.f30170l.getNamedQuery(str).continueWith(new Continuation() { // from class: com.google.firebase.firestore.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Query p4;
                p4 = FirebaseFirestore.this.p(task);
                return p4;
            }
        });
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public synchronized PersistentCacheIndexManager getPersistentCacheIndexManager() {
        h();
        if (this.f30172n == null && (this.f30169k.isPersistenceEnabled() || (this.f30169k.getCacheSettings() instanceof PersistentCacheSettings))) {
            this.f30172n = new PersistentCacheIndexManager(this.f30170l);
        }
        return this.f30172n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirestoreClient i() {
        return this.f30170l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatabaseId j() {
        return this.f30160b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserDataReader l() {
        return this.f30166h;
    }

    @NonNull
    public LoadBundleTask loadBundle(@NonNull InputStream inputStream) {
        h();
        LoadBundleTask loadBundleTask = new LoadBundleTask();
        this.f30170l.loadBundle(inputStream, loadBundleTask);
        return loadBundleTask;
    }

    @NonNull
    public Task<Void> runBatch(@NonNull WriteBatch.Function function) {
        WriteBatch batch = batch();
        function.apply(batch);
        return batch.commit();
    }

    @NonNull
    public <TResult> Task<TResult> runTransaction(@NonNull Transaction.Function<TResult> function) {
        return runTransaction(TransactionOptions.f30238b, function);
    }

    public void setFirestoreSettings(@NonNull FirebaseFirestoreSettings firebaseFirestoreSettings) {
        FirebaseFirestoreSettings s3 = s(firebaseFirestoreSettings, this.f30168j);
        synchronized (this.f30160b) {
            Preconditions.checkNotNull(s3, "Provided settings must not be null.");
            if (this.f30170l != null && !this.f30169k.equals(s3)) {
                throw new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
            }
            this.f30169k = s3;
        }
    }

    @NonNull
    @PreviewApi
    public Task<Void> setIndexConfiguration(@NonNull String str) {
        h();
        Preconditions.checkState(this.f30169k.isPersistenceEnabled(), "Cannot enable indexes when persistence is disabled");
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("indexes")) {
                JSONArray jSONArray = jSONObject.getJSONArray("indexes");
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    String string = jSONObject2.getString("collectionGroup");
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray optJSONArray = jSONObject2.optJSONArray("fields");
                    for (int i5 = 0; optJSONArray != null && i5 < optJSONArray.length(); i5++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i5);
                        com.google.firebase.firestore.model.FieldPath fromServerFormat = com.google.firebase.firestore.model.FieldPath.fromServerFormat(jSONObject3.getString("fieldPath"));
                        if ("CONTAINS".equals(jSONObject3.optString("arrayConfig"))) {
                            arrayList2.add(FieldIndex.Segment.create(fromServerFormat, FieldIndex.Segment.Kind.CONTAINS));
                        } else if ("ASCENDING".equals(jSONObject3.optString("order"))) {
                            arrayList2.add(FieldIndex.Segment.create(fromServerFormat, FieldIndex.Segment.Kind.ASCENDING));
                        } else {
                            arrayList2.add(FieldIndex.Segment.create(fromServerFormat, FieldIndex.Segment.Kind.DESCENDING));
                        }
                    }
                    arrayList.add(FieldIndex.create(-1, string, arrayList2, FieldIndex.INITIAL_STATE));
                }
            }
            return this.f30170l.configureFieldIndexes(arrayList);
        } catch (JSONException e4) {
            throw new IllegalArgumentException("Failed to parse index configuration", e4);
        }
    }

    @NonNull
    public Task<Void> terminate() {
        this.f30167i.remove(j().getDatabaseId());
        h();
        return this.f30170l.terminate();
    }

    public void useEmulator(@NonNull String str, int i4) {
        if (this.f30170l == null) {
            EmulatedServiceSettings emulatedServiceSettings = new EmulatedServiceSettings(str, i4);
            this.f30168j = emulatedServiceSettings;
            this.f30169k = s(this.f30169k, emulatedServiceSettings);
            return;
        }
        throw new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(DocumentReference documentReference) {
        Preconditions.checkNotNull(documentReference, "Provided DocumentReference must not be null.");
        if (documentReference.getFirestore() == this) {
            return;
        }
        throw new IllegalArgumentException("Provided document reference is from a different Cloud Firestore instance.");
    }

    @NonNull
    public Task<Void> waitForPendingWrites() {
        h();
        return this.f30170l.waitForPendingWrites();
    }

    @NonNull
    public static FirebaseFirestore getInstance(@NonNull FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, "(default)");
    }

    @NonNull
    public ListenerRegistration addSnapshotsInSyncListener(@NonNull Activity activity, @NonNull Runnable runnable) {
        return g(Executors.DEFAULT_CALLBACK_EXECUTOR, activity, runnable);
    }

    @NonNull
    public <TResult> Task<TResult> runTransaction(@NonNull TransactionOptions transactionOptions, @NonNull Transaction.Function<TResult> function) {
        Preconditions.checkNotNull(function, "Provided transaction update function must not be null.");
        return u(transactionOptions, function, com.google.firebase.firestore.core.Transaction.getDefaultExecutor());
    }

    @NonNull
    public static FirebaseFirestore getInstance(@NonNull String str) {
        return getInstance(k(), str);
    }

    @NonNull
    public ListenerRegistration addSnapshotsInSyncListener(@NonNull Executor executor, @NonNull Runnable runnable) {
        return g(executor, null, runnable);
    }

    @NonNull
    public static FirebaseFirestore getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        Preconditions.checkNotNull(firebaseApp, "Provided FirebaseApp must not be null.");
        Preconditions.checkNotNull(str, "Provided database name must not be null.");
        FirestoreMultiDbComponent firestoreMultiDbComponent = (FirestoreMultiDbComponent) firebaseApp.get(FirestoreMultiDbComponent.class);
        Preconditions.checkNotNull(firestoreMultiDbComponent, "Firestore component is not present.");
        return firestoreMultiDbComponent.a(str);
    }

    @NonNull
    public LoadBundleTask loadBundle(@NonNull byte[] bArr) {
        return loadBundle(new ByteArrayInputStream(bArr));
    }

    @NonNull
    public LoadBundleTask loadBundle(@NonNull ByteBuffer byteBuffer) {
        return loadBundle(new ByteBufferInputStream(byteBuffer));
    }
}
