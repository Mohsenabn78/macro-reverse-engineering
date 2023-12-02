package com.google.firebase.firestore;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class DocumentReference {

    /* renamed from: a  reason: collision with root package name */
    private final DocumentKey f30138a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseFirestore f30139b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentReference(DocumentKey documentKey, FirebaseFirestore firebaseFirestore) {
        this.f30138a = (DocumentKey) Preconditions.checkNotNull(documentKey);
        this.f30139b = firebaseFirestore;
    }

    private ListenerRegistration d(Executor executor, EventManager.ListenOptions listenOptions, @Nullable Activity activity, final EventListener<DocumentSnapshot> eventListener) {
        AsyncEventListener asyncEventListener = new AsyncEventListener(executor, new EventListener() { // from class: com.google.firebase.firestore.d
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                DocumentReference.this.j(eventListener, (ViewSnapshot) obj, firebaseFirestoreException);
            }
        });
        return ActivityScope.bind(activity, new ListenerRegistrationImpl(this.f30139b.i(), this.f30139b.i().listen(e(), listenOptions, asyncEventListener), asyncEventListener));
    }

    private com.google.firebase.firestore.core.Query e() {
        return com.google.firebase.firestore.core.Query.atPath(this.f30138a.getPath());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DocumentReference f(ResourcePath resourcePath, FirebaseFirestore firebaseFirestore) {
        if (resourcePath.length() % 2 == 0) {
            return new DocumentReference(DocumentKey.fromPath(resourcePath), firebaseFirestore);
        }
        throw new IllegalArgumentException("Invalid document reference. Document references must have an even number of segments, but " + resourcePath.canonicalString() + " has " + resourcePath.length());
    }

    @NonNull
    private Task<DocumentSnapshot> h(final Source source) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        listenOptions.includeDocumentMetadataChanges = true;
        listenOptions.includeQueryMetadataChanges = true;
        listenOptions.waitForSyncWhenOnline = true;
        taskCompletionSource2.setResult(d(Executors.DIRECT_EXECUTOR, listenOptions, null, new EventListener() { // from class: com.google.firebase.firestore.e
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                DocumentReference.l(TaskCompletionSource.this, taskCompletionSource2, source, (DocumentSnapshot) obj, firebaseFirestoreException);
            }
        }));
        return taskCompletionSource.getTask();
    }

    private static EventManager.ListenOptions i(MetadataChanges metadataChanges) {
        boolean z3;
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        MetadataChanges metadataChanges2 = MetadataChanges.INCLUDE;
        boolean z4 = true;
        if (metadataChanges == metadataChanges2) {
            z3 = true;
        } else {
            z3 = false;
        }
        listenOptions.includeDocumentMetadataChanges = z3;
        if (metadataChanges != metadataChanges2) {
            z4 = false;
        }
        listenOptions.includeQueryMetadataChanges = z4;
        listenOptions.waitForSyncWhenOnline = false;
        return listenOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(EventListener eventListener, ViewSnapshot viewSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        boolean z3;
        DocumentSnapshot c4;
        if (firebaseFirestoreException != null) {
            eventListener.onEvent(null, firebaseFirestoreException);
            return;
        }
        boolean z4 = true;
        if (viewSnapshot != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Got event without value or error set", new Object[0]);
        if (viewSnapshot.getDocuments().size() > 1) {
            z4 = false;
        }
        Assert.hardAssert(z4, "Too many documents returned on a document query", new Object[0]);
        Document document = viewSnapshot.getDocuments().getDocument(this.f30138a);
        if (document != null) {
            c4 = DocumentSnapshot.b(this.f30139b, document, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document.getKey()));
        } else {
            c4 = DocumentSnapshot.c(this.f30139b, this.f30138a, viewSnapshot.isFromCache());
        }
        eventListener.onEvent(c4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DocumentSnapshot k(Task task) throws Exception {
        boolean z3;
        Document document = (Document) task.getResult();
        if (document != null && document.hasLocalMutations()) {
            z3 = true;
        } else {
            z3 = false;
        }
        return new DocumentSnapshot(this.f30139b, this.f30138a, document, true, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source, DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            taskCompletionSource.setException(firebaseFirestoreException);
            return;
        }
        try {
            ((ListenerRegistration) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (!documentSnapshot.exists() && documentSnapshot.getMetadata().isFromCache()) {
                taskCompletionSource.setException(new FirebaseFirestoreException("Failed to get document because the client is offline.", FirebaseFirestoreException.Code.UNAVAILABLE));
            } else if (documentSnapshot.exists() && documentSnapshot.getMetadata().isFromCache() && source == Source.SERVER) {
                taskCompletionSource.setException(new FirebaseFirestoreException("Failed to get document from server. (However, this document does exist in the local cache. Run again without setting source to SERVER to retrieve the cached document.)", FirebaseFirestoreException.Code.UNAVAILABLE));
            } else {
                taskCompletionSource.setResult(documentSnapshot);
            }
        } catch (InterruptedException e4) {
            Thread.currentThread().interrupt();
            throw Assert.fail(e4, "Failed to register a listener for a single document", new Object[0]);
        } catch (ExecutionException e5) {
            throw Assert.fail(e5, "Failed to register a listener for a single document", new Object[0]);
        }
    }

    private Task<Void> m(@NonNull UserData.ParsedUpdateData parsedUpdateData) {
        return this.f30139b.i().write(Collections.singletonList(parsedUpdateData.toMutation(this.f30138a, Precondition.exists(true)))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public CollectionReference collection(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided collection path must not be null.");
        return new CollectionReference(this.f30138a.getPath().append(ResourcePath.fromString(str)), this.f30139b);
    }

    @NonNull
    public Task<Void> delete() {
        return this.f30139b.i().write(Collections.singletonList(new DeleteMutation(this.f30138a, Precondition.NONE))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentReference)) {
            return false;
        }
        DocumentReference documentReference = (DocumentReference) obj;
        if (this.f30138a.equals(documentReference.f30138a) && this.f30139b.equals(documentReference.f30139b)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentKey g() {
        return this.f30138a;
    }

    @NonNull
    public Task<DocumentSnapshot> get() {
        return get(Source.DEFAULT);
    }

    @NonNull
    public FirebaseFirestore getFirestore() {
        return this.f30139b;
    }

    @NonNull
    public String getId() {
        return this.f30138a.getDocumentId();
    }

    @NonNull
    public CollectionReference getParent() {
        return new CollectionReference(this.f30138a.getCollectionPath(), this.f30139b);
    }

    @NonNull
    public String getPath() {
        return this.f30138a.getPath().canonicalString();
    }

    public int hashCode() {
        return (this.f30138a.hashCode() * 31) + this.f30139b.hashCode();
    }

    @NonNull
    public Task<Void> set(@NonNull Object obj) {
        return set(obj, SetOptions.f30229c);
    }

    @NonNull
    public Task<Void> update(@NonNull Map<String, Object> map) {
        return m(this.f30139b.l().parseUpdateData(map));
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(executor, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public Task<DocumentSnapshot> get(@NonNull Source source) {
        if (source == Source.CACHE) {
            return this.f30139b.i().getDocumentFromLocalCache(this.f30138a).continueWith(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.c
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    DocumentSnapshot k4;
                    k4 = DocumentReference.this.k(task);
                    return k4;
                }
            });
        }
        return h(source);
    }

    @NonNull
    public Task<Void> set(@NonNull Object obj, @NonNull SetOptions setOptions) {
        UserData.ParsedSetData parseSetData;
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions, "Provided options must not be null.");
        if (setOptions.a()) {
            parseSetData = this.f30139b.l().parseMergeData(obj, setOptions.getFieldMask());
        } else {
            parseSetData = this.f30139b.l().parseSetData(obj);
        }
        return this.f30139b.i().write(Collections.singletonList(parseSetData.toMutation(this.f30138a, Precondition.NONE))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(activity, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public Task<Void> update(@NonNull String str, @Nullable Object obj, Object... objArr) {
        return m(this.f30139b.l().parseUpdateData(Util.collectUpdateArguments(1, str, obj, objArr)));
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull MetadataChanges metadataChanges, @NonNull EventListener<DocumentSnapshot> eventListener) {
        return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, metadataChanges, eventListener);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<DocumentSnapshot> eventListener) {
        Preconditions.checkNotNull(executor, "Provided executor must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return d(executor, i(metadataChanges), null, eventListener);
    }

    @NonNull
    public Task<Void> update(@NonNull FieldPath fieldPath, @Nullable Object obj, Object... objArr) {
        return m(this.f30139b.l().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, obj, objArr)));
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<DocumentSnapshot> eventListener) {
        Preconditions.checkNotNull(activity, "Provided activity must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return d(Executors.DEFAULT_CALLBACK_EXECUTOR, i(metadataChanges), activity, eventListener);
    }
}
