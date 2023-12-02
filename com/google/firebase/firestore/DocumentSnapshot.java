package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firestore.v1.Value;
import java.util.Date;
import java.util.Map;

/* loaded from: classes5.dex */
public class DocumentSnapshot {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFirestore f30140a;

    /* renamed from: b  reason: collision with root package name */
    private final DocumentKey f30141b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Document f30142c;

    /* renamed from: d  reason: collision with root package name */
    private final SnapshotMetadata f30143d;

    /* loaded from: classes5.dex */
    public enum ServerTimestampBehavior {
        NONE,
        ESTIMATE,
        PREVIOUS;
        

        /* renamed from: a  reason: collision with root package name */
        static final ServerTimestampBehavior f30144a = NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentSnapshot(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, @Nullable Document document, boolean z3, boolean z4) {
        this.f30140a = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
        this.f30141b = (DocumentKey) Preconditions.checkNotNull(documentKey);
        this.f30142c = document;
        this.f30143d = new SnapshotMetadata(z4, z3);
    }

    @Nullable
    private <T> T a(Object obj, String str, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RuntimeException("Field '" + str + "' is not a " + cls.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DocumentSnapshot b(FirebaseFirestore firebaseFirestore, Document document, boolean z3, boolean z4) {
        return new DocumentSnapshot(firebaseFirestore, document.getKey(), document, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DocumentSnapshot c(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, boolean z3) {
        return new DocumentSnapshot(firebaseFirestore, documentKey, null, z3, false);
    }

    @Nullable
    private Object e(@NonNull com.google.firebase.firestore.model.FieldPath fieldPath, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Value field;
        Document document = this.f30142c;
        if (document != null && (field = document.getField(fieldPath)) != null) {
            return new UserDataWriter(this.f30140a, serverTimestampBehavior).convertValue(field);
        }
        return null;
    }

    @Nullable
    private <T> T f(String str, Class<T> cls) {
        Preconditions.checkNotNull(str, "Provided field must not be null.");
        return (T) a(get(str, ServerTimestampBehavior.f30144a), str, cls);
    }

    public boolean contains(@NonNull String str) {
        return contains(FieldPath.a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Document d() {
        return this.f30142c;
    }

    public boolean equals(@Nullable Object obj) {
        Document document;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentSnapshot)) {
            return false;
        }
        DocumentSnapshot documentSnapshot = (DocumentSnapshot) obj;
        if (this.f30140a.equals(documentSnapshot.f30140a) && this.f30141b.equals(documentSnapshot.f30141b) && ((document = this.f30142c) != null ? document.equals(documentSnapshot.f30142c) : documentSnapshot.f30142c == null) && this.f30143d.equals(documentSnapshot.f30143d)) {
            return true;
        }
        return false;
    }

    public boolean exists() {
        if (this.f30142c != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public Object get(@NonNull String str) {
        return get(FieldPath.a(str), ServerTimestampBehavior.f30144a);
    }

    @Nullable
    public Blob getBlob(@NonNull String str) {
        return (Blob) f(str, Blob.class);
    }

    @Nullable
    public Boolean getBoolean(@NonNull String str) {
        return (Boolean) f(str, Boolean.class);
    }

    @Nullable
    public Map<String, Object> getData() {
        return getData(ServerTimestampBehavior.f30144a);
    }

    @Nullable
    public Date getDate(@NonNull String str) {
        return getDate(str, ServerTimestampBehavior.f30144a);
    }

    @Nullable
    public DocumentReference getDocumentReference(@NonNull String str) {
        return (DocumentReference) f(str, DocumentReference.class);
    }

    @Nullable
    public Double getDouble(@NonNull String str) {
        Number number = (Number) f(str, Number.class);
        if (number != null) {
            return Double.valueOf(number.doubleValue());
        }
        return null;
    }

    @Nullable
    public GeoPoint getGeoPoint(@NonNull String str) {
        return (GeoPoint) f(str, GeoPoint.class);
    }

    @NonNull
    public String getId() {
        return this.f30141b.getDocumentId();
    }

    @Nullable
    public Long getLong(@NonNull String str) {
        Number number = (Number) f(str, Number.class);
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    @NonNull
    public SnapshotMetadata getMetadata() {
        return this.f30143d;
    }

    @NonNull
    public DocumentReference getReference() {
        return new DocumentReference(this.f30141b, this.f30140a);
    }

    @Nullable
    public String getString(@NonNull String str) {
        return (String) f(str, String.class);
    }

    @Nullable
    public Timestamp getTimestamp(@NonNull String str) {
        return getTimestamp(str, ServerTimestampBehavior.f30144a);
    }

    public int hashCode() {
        int i4;
        int hashCode = ((this.f30140a.hashCode() * 31) + this.f30141b.hashCode()) * 31;
        Document document = this.f30142c;
        int i5 = 0;
        if (document != null) {
            i4 = document.getKey().hashCode();
        } else {
            i4 = 0;
        }
        int i6 = (hashCode + i4) * 31;
        Document document2 = this.f30142c;
        if (document2 != null) {
            i5 = document2.getData().hashCode();
        }
        return ((i6 + i5) * 31) + this.f30143d.hashCode();
    }

    @Nullable
    public <T> T toObject(@NonNull Class<T> cls) {
        return (T) toObject(cls, ServerTimestampBehavior.f30144a);
    }

    public String toString() {
        return "DocumentSnapshot{key=" + this.f30141b + ", metadata=" + this.f30143d + ", doc=" + this.f30142c + '}';
    }

    public boolean contains(@NonNull FieldPath fieldPath) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Document document = this.f30142c;
        return (document == null || document.getField(fieldPath.b()) == null) ? false : true;
    }

    @Nullable
    public Object get(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        return get(FieldPath.a(str), serverTimestampBehavior);
    }

    @Nullable
    public Map<String, Object> getData(@NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        UserDataWriter userDataWriter = new UserDataWriter(this.f30140a, serverTimestampBehavior);
        Document document = this.f30142c;
        if (document == null) {
            return null;
        }
        return userDataWriter.b(document.getData().getFieldsMap());
    }

    @Nullable
    public Date getDate(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Timestamp timestamp = getTimestamp(str, serverTimestampBehavior);
        if (timestamp != null) {
            return timestamp.toDate();
        }
        return null;
    }

    @Nullable
    public Timestamp getTimestamp(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return (Timestamp) a(e(FieldPath.a(str).b(), serverTimestampBehavior), str, Timestamp.class);
    }

    @Nullable
    public <T> T toObject(@NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(cls, "Provided POJO type must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Map<String, Object> data = getData(serverTimestampBehavior);
        if (data == null) {
            return null;
        }
        return (T) CustomClassMapper.convertToCustomClass(data, cls, getReference());
    }

    @Nullable
    public Object get(@NonNull FieldPath fieldPath) {
        return get(fieldPath, ServerTimestampBehavior.f30144a);
    }

    @Nullable
    public Object get(@NonNull FieldPath fieldPath, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return e(fieldPath.b(), serverTimestampBehavior);
    }

    @Nullable
    public <T> T get(@NonNull String str, @NonNull Class<T> cls) {
        return (T) get(FieldPath.a(str), cls, ServerTimestampBehavior.f30144a);
    }

    @Nullable
    public <T> T get(@NonNull String str, @NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        return (T) get(FieldPath.a(str), cls, serverTimestampBehavior);
    }

    @Nullable
    public <T> T get(@NonNull FieldPath fieldPath, @NonNull Class<T> cls) {
        return (T) get(fieldPath, cls, ServerTimestampBehavior.f30144a);
    }

    @Nullable
    public <T> T get(@NonNull FieldPath fieldPath, @NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Object obj = get(fieldPath, serverTimestampBehavior);
        if (obj == null) {
            return null;
        }
        return (T) CustomClassMapper.convertToCustomClass(obj, cls, getReference());
    }
}
