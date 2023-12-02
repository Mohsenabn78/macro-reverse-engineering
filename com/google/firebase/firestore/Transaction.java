package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes5.dex */
public class Transaction {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.firestore.core.Transaction f30236a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseFirestore f30237b;

    /* loaded from: classes5.dex */
    public interface Function<TResult> {
        @Nullable
        TResult apply(@NonNull Transaction transaction) throws FirebaseFirestoreException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transaction(com.google.firebase.firestore.core.Transaction transaction, FirebaseFirestore firebaseFirestore) {
        this.f30236a = (com.google.firebase.firestore.core.Transaction) Preconditions.checkNotNull(transaction);
        this.f30237b = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    private Task<DocumentSnapshot> b(DocumentReference documentReference) {
        return this.f30236a.lookup(Collections.singletonList(documentReference.g())).continueWith(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.s
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                DocumentSnapshot c4;
                c4 = Transaction.this.c(task);
                return c4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DocumentSnapshot c(Task task) throws Exception {
        if (task.isSuccessful()) {
            List list = (List) task.getResult();
            if (list.size() == 1) {
                MutableDocument mutableDocument = (MutableDocument) list.get(0);
                if (mutableDocument.isFoundDocument()) {
                    return DocumentSnapshot.b(this.f30237b, mutableDocument, false, false);
                }
                if (mutableDocument.isNoDocument()) {
                    return DocumentSnapshot.c(this.f30237b, mutableDocument.getKey(), false);
                }
                throw Assert.fail("BatchGetDocumentsRequest returned unexpected document type: " + MutableDocument.class.getCanonicalName(), new Object[0]);
            }
            throw Assert.fail("Mismatch in docs returned from document lookup.", new Object[0]);
        }
        throw task.getException();
    }

    private Transaction d(@NonNull DocumentReference documentReference, @NonNull UserData.ParsedUpdateData parsedUpdateData) {
        this.f30237b.v(documentReference);
        this.f30236a.update(documentReference.g(), parsedUpdateData);
        return this;
    }

    @NonNull
    public Transaction delete(@NonNull DocumentReference documentReference) {
        this.f30237b.v(documentReference);
        this.f30236a.delete(documentReference.g());
        return this;
    }

    @NonNull
    public DocumentSnapshot get(@NonNull DocumentReference documentReference) throws FirebaseFirestoreException {
        this.f30237b.v(documentReference);
        try {
            return (DocumentSnapshot) Tasks.await(b(documentReference));
        } catch (InterruptedException e4) {
            throw new RuntimeException(e4);
        } catch (ExecutionException e5) {
            if (e5.getCause() instanceof FirebaseFirestoreException) {
                throw ((FirebaseFirestoreException) e5.getCause());
            }
            throw new RuntimeException(e5.getCause());
        }
    }

    @NonNull
    public Transaction set(@NonNull DocumentReference documentReference, @NonNull Object obj) {
        return set(documentReference, obj, SetOptions.f30229c);
    }

    @NonNull
    public Transaction update(@NonNull DocumentReference documentReference, @NonNull Map<String, Object> map) {
        return d(documentReference, this.f30237b.l().parseUpdateData(map));
    }

    @NonNull
    public Transaction set(@NonNull DocumentReference documentReference, @NonNull Object obj, @NonNull SetOptions setOptions) {
        UserData.ParsedSetData parseSetData;
        this.f30237b.v(documentReference);
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions, "Provided options must not be null.");
        if (setOptions.a()) {
            parseSetData = this.f30237b.l().parseMergeData(obj, setOptions.getFieldMask());
        } else {
            parseSetData = this.f30237b.l().parseSetData(obj);
        }
        this.f30236a.set(documentReference.g(), parseSetData);
        return this;
    }

    @NonNull
    public Transaction update(@NonNull DocumentReference documentReference, @NonNull String str, @Nullable Object obj, Object... objArr) {
        return d(documentReference, this.f30237b.l().parseUpdateData(Util.collectUpdateArguments(1, str, obj, objArr)));
    }

    @NonNull
    public Transaction update(@NonNull DocumentReference documentReference, @NonNull FieldPath fieldPath, @Nullable Object obj, Object... objArr) {
        return d(documentReference, this.f30237b.l().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, obj, objArr)));
    }
}
