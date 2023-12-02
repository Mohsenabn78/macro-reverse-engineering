package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.VerifyMutation;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class Transaction {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f30428g = c();

    /* renamed from: a  reason: collision with root package name */
    private final Datastore f30429a;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30432d;

    /* renamed from: e  reason: collision with root package name */
    private FirebaseFirestoreException f30433e;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<DocumentKey, SnapshotVersion> f30430b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Mutation> f30431c = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private Set<DocumentKey> f30434f = new HashSet();

    public Transaction(Datastore datastore) {
        this.f30429a = datastore;
    }

    private static Executor c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    private void d() {
        Assert.hardAssert(!this.f30432d, "A transaction object cannot be used after its update callback has been invoked.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task e(Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        return Tasks.forException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task f(Task task) throws Exception {
        if (task.isSuccessful()) {
            for (MutableDocument mutableDocument : (List) task.getResult()) {
                i(mutableDocument);
            }
        }
        return task;
    }

    private Precondition g(DocumentKey documentKey) {
        SnapshotVersion snapshotVersion = this.f30430b.get(documentKey);
        if (!this.f30434f.contains(documentKey) && snapshotVersion != null) {
            if (snapshotVersion.equals(SnapshotVersion.NONE)) {
                return Precondition.exists(false);
            }
            return Precondition.updateTime(snapshotVersion);
        }
        return Precondition.NONE;
    }

    public static Executor getDefaultExecutor() {
        return f30428g;
    }

    private Precondition h(DocumentKey documentKey) throws FirebaseFirestoreException {
        SnapshotVersion snapshotVersion = this.f30430b.get(documentKey);
        if (!this.f30434f.contains(documentKey) && snapshotVersion != null) {
            if (!snapshotVersion.equals(SnapshotVersion.NONE)) {
                return Precondition.updateTime(snapshotVersion);
            }
            throw new FirebaseFirestoreException("Can't update a document that doesn't exist.", FirebaseFirestoreException.Code.INVALID_ARGUMENT);
        }
        return Precondition.exists(true);
    }

    private void i(MutableDocument mutableDocument) throws FirebaseFirestoreException {
        SnapshotVersion snapshotVersion;
        if (mutableDocument.isFoundDocument()) {
            snapshotVersion = mutableDocument.getVersion();
        } else if (mutableDocument.isNoDocument()) {
            snapshotVersion = SnapshotVersion.NONE;
        } else {
            throw Assert.fail("Unexpected document type in transaction: " + mutableDocument, new Object[0]);
        }
        if (this.f30430b.containsKey(mutableDocument.getKey())) {
            if (!this.f30430b.get(mutableDocument.getKey()).equals(mutableDocument.getVersion())) {
                throw new FirebaseFirestoreException("Document version changed between two reads.", FirebaseFirestoreException.Code.ABORTED);
            }
            return;
        }
        this.f30430b.put(mutableDocument.getKey(), snapshotVersion);
    }

    private void j(List<Mutation> list) {
        d();
        this.f30431c.addAll(list);
    }

    public Task<Void> commit() {
        d();
        FirebaseFirestoreException firebaseFirestoreException = this.f30433e;
        if (firebaseFirestoreException != null) {
            return Tasks.forException(firebaseFirestoreException);
        }
        HashSet hashSet = new HashSet(this.f30430b.keySet());
        Iterator<Mutation> it = this.f30431c.iterator();
        while (it.hasNext()) {
            hashSet.remove(it.next().getKey());
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            DocumentKey documentKey = (DocumentKey) it2.next();
            this.f30431c.add(new VerifyMutation(documentKey, g(documentKey)));
        }
        this.f30432d = true;
        return this.f30429a.commit(this.f30431c).continueWithTask(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.core.f0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task e4;
                e4 = Transaction.e(task);
                return e4;
            }
        });
    }

    public void delete(DocumentKey documentKey) {
        j(Collections.singletonList(new DeleteMutation(documentKey, g(documentKey))));
        this.f30434f.add(documentKey);
    }

    public Task<List<MutableDocument>> lookup(List<DocumentKey> list) {
        d();
        if (this.f30431c.size() != 0) {
            return Tasks.forException(new FirebaseFirestoreException("Firestore transactions require all reads to be executed before all writes.", FirebaseFirestoreException.Code.INVALID_ARGUMENT));
        }
        return this.f30429a.lookup(list).continueWithTask(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.core.e0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task f4;
                f4 = Transaction.this.f(task);
                return f4;
            }
        });
    }

    public void set(DocumentKey documentKey, UserData.ParsedSetData parsedSetData) {
        j(Collections.singletonList(parsedSetData.toMutation(documentKey, g(documentKey))));
        this.f30434f.add(documentKey);
    }

    public void update(DocumentKey documentKey, UserData.ParsedUpdateData parsedUpdateData) {
        try {
            j(Collections.singletonList(parsedUpdateData.toMutation(documentKey, h(documentKey))));
        } catch (FirebaseFirestoreException e4) {
            this.f30433e = e4;
        }
        this.f30434f.add(documentKey);
    }
}
