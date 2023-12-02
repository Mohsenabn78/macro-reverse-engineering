package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Map;

/* loaded from: classes5.dex */
public class QueryDocumentSnapshot extends DocumentSnapshot {
    private QueryDocumentSnapshot(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, @Nullable Document document, boolean z3, boolean z4) {
        super(firebaseFirestore, documentKey, document, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static QueryDocumentSnapshot g(FirebaseFirestore firebaseFirestore, Document document, boolean z3, boolean z4) {
        return new QueryDocumentSnapshot(firebaseFirestore, document.getKey(), document, z3, z4);
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    @NonNull
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        Assert.hardAssert(data != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return data;
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    @NonNull
    public <T> T toObject(@NonNull Class<T> cls) {
        T t3 = (T) super.toObject(cls);
        Assert.hardAssert(t3 != null, "Object in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return t3;
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    @NonNull
    public Map<String, Object> getData(@NonNull DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Map<String, Object> data = super.getData(serverTimestampBehavior);
        Assert.hardAssert(data != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return data;
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    @NonNull
    public <T> T toObject(@NonNull Class<T> cls, @NonNull DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        T t3 = (T) super.toObject(cls, serverTimestampBehavior);
        Assert.hardAssert(t3 != null, "Object in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return t3;
    }
}
