package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public final class MutableDocument implements Document {

    /* renamed from: a  reason: collision with root package name */
    private final DocumentKey f30953a;

    /* renamed from: b  reason: collision with root package name */
    private DocumentType f30954b;

    /* renamed from: c  reason: collision with root package name */
    private SnapshotVersion f30955c;

    /* renamed from: d  reason: collision with root package name */
    private SnapshotVersion f30956d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectValue f30957e;

    /* renamed from: f  reason: collision with root package name */
    private DocumentState f30958f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum DocumentState {
        HAS_LOCAL_MUTATIONS,
        HAS_COMMITTED_MUTATIONS,
        SYNCED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum DocumentType {
        INVALID,
        FOUND_DOCUMENT,
        NO_DOCUMENT,
        UNKNOWN_DOCUMENT
    }

    private MutableDocument(DocumentKey documentKey) {
        this.f30953a = documentKey;
        this.f30956d = SnapshotVersion.NONE;
    }

    public static MutableDocument newFoundDocument(DocumentKey documentKey, SnapshotVersion snapshotVersion, ObjectValue objectValue) {
        return new MutableDocument(documentKey).convertToFoundDocument(snapshotVersion, objectValue);
    }

    public static MutableDocument newInvalidDocument(DocumentKey documentKey) {
        DocumentType documentType = DocumentType.INVALID;
        SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
        return new MutableDocument(documentKey, documentType, snapshotVersion, snapshotVersion, new ObjectValue(), DocumentState.SYNCED);
    }

    public static MutableDocument newNoDocument(DocumentKey documentKey, SnapshotVersion snapshotVersion) {
        return new MutableDocument(documentKey).convertToNoDocument(snapshotVersion);
    }

    public static MutableDocument newUnknownDocument(DocumentKey documentKey, SnapshotVersion snapshotVersion) {
        return new MutableDocument(documentKey).convertToUnknownDocument(snapshotVersion);
    }

    public MutableDocument convertToFoundDocument(SnapshotVersion snapshotVersion, ObjectValue objectValue) {
        this.f30955c = snapshotVersion;
        this.f30954b = DocumentType.FOUND_DOCUMENT;
        this.f30957e = objectValue;
        this.f30958f = DocumentState.SYNCED;
        return this;
    }

    public MutableDocument convertToNoDocument(SnapshotVersion snapshotVersion) {
        this.f30955c = snapshotVersion;
        this.f30954b = DocumentType.NO_DOCUMENT;
        this.f30957e = new ObjectValue();
        this.f30958f = DocumentState.SYNCED;
        return this;
    }

    public MutableDocument convertToUnknownDocument(SnapshotVersion snapshotVersion) {
        this.f30955c = snapshotVersion;
        this.f30954b = DocumentType.UNKNOWN_DOCUMENT;
        this.f30957e = new ObjectValue();
        this.f30958f = DocumentState.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MutableDocument.class != obj.getClass()) {
            return false;
        }
        MutableDocument mutableDocument = (MutableDocument) obj;
        if (!this.f30953a.equals(mutableDocument.f30953a) || !this.f30955c.equals(mutableDocument.f30955c) || !this.f30954b.equals(mutableDocument.f30954b) || !this.f30958f.equals(mutableDocument.f30958f)) {
            return false;
        }
        return this.f30957e.equals(mutableDocument.f30957e);
    }

    @Override // com.google.firebase.firestore.model.Document
    public ObjectValue getData() {
        return this.f30957e;
    }

    @Override // com.google.firebase.firestore.model.Document
    public Value getField(FieldPath fieldPath) {
        return getData().get(fieldPath);
    }

    @Override // com.google.firebase.firestore.model.Document
    public DocumentKey getKey() {
        return this.f30953a;
    }

    @Override // com.google.firebase.firestore.model.Document
    public SnapshotVersion getReadTime() {
        return this.f30956d;
    }

    @Override // com.google.firebase.firestore.model.Document
    public SnapshotVersion getVersion() {
        return this.f30955c;
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean hasCommittedMutations() {
        return this.f30958f.equals(DocumentState.HAS_COMMITTED_MUTATIONS);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean hasLocalMutations() {
        return this.f30958f.equals(DocumentState.HAS_LOCAL_MUTATIONS);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean hasPendingWrites() {
        if (!hasLocalMutations() && !hasCommittedMutations()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f30953a.hashCode();
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isFoundDocument() {
        return this.f30954b.equals(DocumentType.FOUND_DOCUMENT);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isNoDocument() {
        return this.f30954b.equals(DocumentType.NO_DOCUMENT);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isUnknownDocument() {
        return this.f30954b.equals(DocumentType.UNKNOWN_DOCUMENT);
    }

    @Override // com.google.firebase.firestore.model.Document
    public boolean isValidDocument() {
        return !this.f30954b.equals(DocumentType.INVALID);
    }

    @Override // com.google.firebase.firestore.model.Document
    @NonNull
    public MutableDocument mutableCopy() {
        return new MutableDocument(this.f30953a, this.f30954b, this.f30955c, this.f30956d, this.f30957e.m4168clone(), this.f30958f);
    }

    public MutableDocument setHasCommittedMutations() {
        this.f30958f = DocumentState.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public MutableDocument setHasLocalMutations() {
        this.f30958f = DocumentState.HAS_LOCAL_MUTATIONS;
        this.f30955c = SnapshotVersion.NONE;
        return this;
    }

    public MutableDocument setReadTime(SnapshotVersion snapshotVersion) {
        this.f30956d = snapshotVersion;
        return this;
    }

    public String toString() {
        return "Document{key=" + this.f30953a + ", version=" + this.f30955c + ", readTime=" + this.f30956d + ", type=" + this.f30954b + ", documentState=" + this.f30958f + ", value=" + this.f30957e + '}';
    }

    private MutableDocument(DocumentKey documentKey, DocumentType documentType, SnapshotVersion snapshotVersion, SnapshotVersion snapshotVersion2, ObjectValue objectValue, DocumentState documentState) {
        this.f30953a = documentKey;
        this.f30955c = snapshotVersion;
        this.f30956d = snapshotVersion2;
        this.f30954b = documentType;
        this.f30958f = documentState;
        this.f30957e = objectValue;
    }
}
