package com.google.firebase.firestore.index;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.Arrays;

/* loaded from: classes5.dex */
final class AutoValue_IndexEntry extends IndexEntry {

    /* renamed from: a  reason: collision with root package name */
    private final int f30557a;

    /* renamed from: b  reason: collision with root package name */
    private final DocumentKey f30558b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f30559c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f30560d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_IndexEntry(int i4, DocumentKey documentKey, byte[] bArr, byte[] bArr2) {
        this.f30557a = i4;
        if (documentKey != null) {
            this.f30558b = documentKey;
            if (bArr != null) {
                this.f30559c = bArr;
                if (bArr2 != null) {
                    this.f30560d = bArr2;
                    return;
                }
                throw new NullPointerException("Null directionalValue");
            }
            throw new NullPointerException("Null arrayValue");
        }
        throw new NullPointerException("Null documentKey");
    }

    public boolean equals(Object obj) {
        byte[] arrayValue;
        byte[] directionalValue;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexEntry)) {
            return false;
        }
        IndexEntry indexEntry = (IndexEntry) obj;
        if (this.f30557a == indexEntry.getIndexId() && this.f30558b.equals(indexEntry.getDocumentKey())) {
            byte[] bArr = this.f30559c;
            boolean z3 = indexEntry instanceof AutoValue_IndexEntry;
            if (z3) {
                arrayValue = ((AutoValue_IndexEntry) indexEntry).f30559c;
            } else {
                arrayValue = indexEntry.getArrayValue();
            }
            if (Arrays.equals(bArr, arrayValue)) {
                byte[] bArr2 = this.f30560d;
                if (z3) {
                    directionalValue = ((AutoValue_IndexEntry) indexEntry).f30560d;
                } else {
                    directionalValue = indexEntry.getDirectionalValue();
                }
                if (Arrays.equals(bArr2, directionalValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.index.IndexEntry
    public byte[] getArrayValue() {
        return this.f30559c;
    }

    @Override // com.google.firebase.firestore.index.IndexEntry
    public byte[] getDirectionalValue() {
        return this.f30560d;
    }

    @Override // com.google.firebase.firestore.index.IndexEntry
    public DocumentKey getDocumentKey() {
        return this.f30558b;
    }

    @Override // com.google.firebase.firestore.index.IndexEntry
    public int getIndexId() {
        return this.f30557a;
    }

    public int hashCode() {
        return ((((((this.f30557a ^ 1000003) * 1000003) ^ this.f30558b.hashCode()) * 1000003) ^ Arrays.hashCode(this.f30559c)) * 1000003) ^ Arrays.hashCode(this.f30560d);
    }

    public String toString() {
        return "IndexEntry{indexId=" + this.f30557a + ", documentKey=" + this.f30558b + ", arrayValue=" + Arrays.toString(this.f30559c) + ", directionalValue=" + Arrays.toString(this.f30560d) + "}";
    }
}
