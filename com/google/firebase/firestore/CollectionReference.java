package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;

/* loaded from: classes5.dex */
public class CollectionReference extends Query {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CollectionReference(ResourcePath resourcePath, FirebaseFirestore firebaseFirestore) {
        super(com.google.firebase.firestore.core.Query.atPath(resourcePath), firebaseFirestore);
        if (resourcePath.length() % 2 == 1) {
            return;
        }
        throw new IllegalArgumentException("Invalid collection reference. Collection references must have an odd number of segments, but " + resourcePath.canonicalString() + " has " + resourcePath.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DocumentReference z(DocumentReference documentReference, Task task) throws Exception {
        task.getResult();
        return documentReference;
    }

    @NonNull
    public Task<DocumentReference> add(@NonNull Object obj) {
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        final DocumentReference document = document();
        return document.set(obj).continueWith(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.b
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                DocumentReference z3;
                z3 = CollectionReference.z(DocumentReference.this, task);
                return z3;
            }
        });
    }

    @NonNull
    public DocumentReference document() {
        return document(Util.autoId());
    }

    @NonNull
    public String getId() {
        return this.f30217a.getPath().getLastSegment();
    }

    @Nullable
    public DocumentReference getParent() {
        ResourcePath popLast = this.f30217a.getPath().popLast();
        if (popLast.isEmpty()) {
            return null;
        }
        return new DocumentReference(DocumentKey.fromPath(popLast), this.f30218b);
    }

    @NonNull
    public String getPath() {
        return this.f30217a.getPath().canonicalString();
    }

    @NonNull
    public DocumentReference document(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided document path must not be null.");
        return DocumentReference.f(this.f30217a.getPath().append(ResourcePath.fromString(str)), this.f30218b);
    }
}
