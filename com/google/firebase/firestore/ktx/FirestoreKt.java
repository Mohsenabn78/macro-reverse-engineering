package com.google.firebase.firestore.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.MemoryEagerGcSettings;
import com.google.firebase.firestore.MemoryLruGcSettings;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.PersistentCacheSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Firestore.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r\u001a\u001f\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r\u001a\u001f\u0010\u0011\u001a\u00020\u00122\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r\u001a\u001f\u0010\u0014\u001a\u00020\u00152\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r\u001a\u001f\u0010\u0017\u001a\u00020\u00182\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r\u001a+\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0\u001b\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001d*\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0086\b\u001a/\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0!0\u001b\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001d*\u00020\"2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0086\b\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010#\u001a\u00020$\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010%\u001a\u00020\u0001\u001a$\u0010&\u001a\u0004\u0018\u0001H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020'2\u0006\u0010(\u001a\u00020)H\u0086\b¢\u0006\u0002\u0010*\u001a,\u0010&\u001a\u0004\u0018\u0001H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0086\b¢\u0006\u0002\u0010-\u001a$\u0010&\u001a\u0004\u0018\u0001H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020'2\u0006\u0010.\u001a\u00020\u0001H\u0086\b¢\u0006\u0002\u0010/\u001a,\u0010&\u001a\u0004\u0018\u0001H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020'2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,H\u0086\b¢\u0006\u0002\u00100\u001a\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020'0\u001b*\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001b*\u00020\"2\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u001c\u00103\u001a\u0004\u0018\u0001H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020'H\u0086\b¢\u0006\u0002\u00104\u001a$\u00103\u001a\u0004\u0018\u0001H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020'2\u0006\u0010+\u001a\u00020,H\u0086\b¢\u0006\u0002\u00105\u001a\u001e\u00103\u001a\u0002H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001d*\u000206H\u0086\b¢\u0006\u0002\u00107\u001a&\u00103\u001a\u0002H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001d*\u0002062\u0006\u0010+\u001a\u00020,H\u0086\b¢\u0006\u0002\u00108\u001a\u001f\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001c0!\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001d*\u000202H\u0086\b\u001a'\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001c0!\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001d*\u0002022\u0006\u0010+\u001a\u00020,H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006:"}, d2 = {"LIBRARY_NAME", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "Lcom/google/firebase/ktx/Firebase;", "getFirestore", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/firestore/FirebaseFirestore;", "firestoreSettings", "Lcom/google/firebase/firestore/FirebaseFirestoreSettings;", "init", "Lkotlin/Function1;", "Lcom/google/firebase/firestore/FirebaseFirestoreSettings$Builder;", "", "Lkotlin/ExtensionFunctionType;", "memoryCacheSettings", "Lcom/google/firebase/firestore/MemoryCacheSettings;", "Lcom/google/firebase/firestore/MemoryCacheSettings$Builder;", "memoryEagerGcSettings", "Lcom/google/firebase/firestore/MemoryEagerGcSettings;", "Lcom/google/firebase/firestore/MemoryEagerGcSettings$Builder;", "memoryLruGcSettings", "Lcom/google/firebase/firestore/MemoryLruGcSettings;", "Lcom/google/firebase/firestore/MemoryLruGcSettings$Builder;", "persistentCacheSettings", "Lcom/google/firebase/firestore/PersistentCacheSettings;", "Lcom/google/firebase/firestore/PersistentCacheSettings$Builder;", "dataObjects", "Lkotlinx/coroutines/flow/Flow;", "T", "", "Lcom/google/firebase/firestore/DocumentReference;", "metadataChanges", "Lcom/google/firebase/firestore/MetadataChanges;", "", "Lcom/google/firebase/firestore/Query;", "app", "Lcom/google/firebase/FirebaseApp;", "database", "getField", "Lcom/google/firebase/firestore/DocumentSnapshot;", "fieldPath", "Lcom/google/firebase/firestore/FieldPath;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/FieldPath;)Ljava/lang/Object;", "serverTimestampBehavior", "Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/FieldPath;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "field", "(Lcom/google/firebase/firestore/DocumentSnapshot;Ljava/lang/String;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Ljava/lang/String;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "snapshots", "Lcom/google/firebase/firestore/QuerySnapshot;", "toObject", "(Lcom/google/firebase/firestore/DocumentSnapshot;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "Lcom/google/firebase/firestore/QueryDocumentSnapshot;", "(Lcom/google/firebase/firestore/QueryDocumentSnapshot;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/QueryDocumentSnapshot;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "toObjects", "com.google.firebase-firebase-firestore-ktx"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class FirestoreKt {
    @NotNull
    public static final String LIBRARY_NAME = "fire-fst-ktx";

    public static final /* synthetic */ <T> Flow<List<T>> dataObjects(Query query, MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(query, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<QuerySnapshot> snapshots = snapshots(query, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$1(snapshots);
    }

    public static /* synthetic */ Flow dataObjects$default(Query query, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        Intrinsics.checkNotNullParameter(query, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<QuerySnapshot> snapshots = snapshots(query, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$1(snapshots);
    }

    @NotNull
    public static final FirebaseFirestore firestore(@NotNull Firebase firebase2, @NotNull FirebaseApp app) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app, "app");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app);
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance(app)");
        return firebaseFirestore;
    }

    @NotNull
    public static final FirebaseFirestoreSettings firestoreSettings(@NotNull Function1<? super FirebaseFirestoreSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        init.invoke(builder);
        FirebaseFirestoreSettings build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) documentSnapshot.get(field, Object.class);
    }

    @NotNull
    public static final FirebaseFirestore getFirestore(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance()");
        return firebaseFirestore;
    }

    @NotNull
    public static final MemoryCacheSettings memoryCacheSettings(@NotNull Function1<? super MemoryCacheSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        MemoryCacheSettings.Builder newBuilder = MemoryCacheSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        MemoryCacheSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @NotNull
    public static final MemoryEagerGcSettings memoryEagerGcSettings(@NotNull Function1<? super MemoryEagerGcSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        MemoryEagerGcSettings.Builder newBuilder = MemoryEagerGcSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        MemoryEagerGcSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @NotNull
    public static final MemoryLruGcSettings memoryLruGcSettings(@NotNull Function1<? super MemoryLruGcSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        MemoryLruGcSettings.Builder newBuilder = MemoryLruGcSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        MemoryLruGcSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @NotNull
    public static final PersistentCacheSettings persistentCacheSettings(@NotNull Function1<? super PersistentCacheSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        PersistentCacheSettings.Builder newBuilder = PersistentCacheSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        PersistentCacheSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @NotNull
    public static final Flow<DocumentSnapshot> snapshots(@NotNull DocumentReference documentReference, @NotNull MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(documentReference, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        return FlowKt.callbackFlow(new FirestoreKt$snapshots$1(documentReference, metadataChanges, null));
    }

    public static /* synthetic */ Flow snapshots$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(documentReference, metadataChanges);
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) documentSnapshot.toObject(Object.class);
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot) {
        Intrinsics.checkNotNullParameter(querySnapshot, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        List<T> objects = querySnapshot.toObjects(Object.class);
        Intrinsics.checkNotNullExpressionValue(objects, "toObjects(T::class.java)");
        return objects;
    }

    @NotNull
    public static final FirebaseFirestore firestore(@NotNull Firebase firebase2, @NotNull FirebaseApp app, @NotNull String database) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app, database);
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance(app, database)");
        return firebaseFirestore;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) documentSnapshot.get(field, Object.class, serverTimestampBehavior);
    }

    @NotNull
    public static final Flow<QuerySnapshot> snapshots(@NotNull Query query, @NotNull MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(query, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        return FlowKt.callbackFlow(new FirestoreKt$snapshots$2(query, metadataChanges, null));
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) documentSnapshot.toObject(Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(querySnapshot, "<this>");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, "T");
        List<T> objects = querySnapshot.toObjects(Object.class, serverTimestampBehavior);
        Intrinsics.checkNotNullExpressionValue(objects, "toObjects(T::class.java, serverTimestampBehavior)");
        return objects;
    }

    public static final /* synthetic */ <T> Flow<T> dataObjects(DocumentReference documentReference, MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(documentReference, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<DocumentSnapshot> snapshots = snapshots(documentReference, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$2(snapshots);
    }

    @NotNull
    public static final FirebaseFirestore firestore(@NotNull Firebase firebase2, @NotNull String database) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(database);
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance(database)");
        return firebaseFirestore;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(fieldPath, "fieldPath");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) documentSnapshot.get(fieldPath, Object.class);
    }

    public static /* synthetic */ Flow snapshots$default(Query query, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(query, metadataChanges);
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot) {
        Intrinsics.checkNotNullParameter(queryDocumentSnapshot, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        T t3 = (T) queryDocumentSnapshot.toObject(Object.class);
        Intrinsics.checkNotNullExpressionValue(t3, "toObject(T::class.java)");
        return t3;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(fieldPath, "fieldPath");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) documentSnapshot.get(fieldPath, Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(queryDocumentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, "T");
        T t3 = (T) queryDocumentSnapshot.toObject(Object.class, serverTimestampBehavior);
        Intrinsics.checkNotNullExpressionValue(t3, "toObject(T::class.java, serverTimestampBehavior)");
        return t3;
    }

    public static /* synthetic */ Flow dataObjects$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        Intrinsics.checkNotNullParameter(documentReference, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<DocumentSnapshot> snapshots = snapshots(documentReference, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$2(snapshots);
    }
}
