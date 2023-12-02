package com.google.firebase.firestore.index;

import com.google.auto.value.AutoValue;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Util;

@AutoValue
/* loaded from: classes5.dex */
public abstract class IndexEntry implements Comparable<IndexEntry> {
    public static IndexEntry create(int i4, DocumentKey documentKey, byte[] bArr, byte[] bArr2) {
        return new AutoValue_IndexEntry(i4, documentKey, bArr, bArr2);
    }

    public abstract byte[] getArrayValue();

    public abstract byte[] getDirectionalValue();

    public abstract DocumentKey getDocumentKey();

    public abstract int getIndexId();

    @Override // java.lang.Comparable
    public int compareTo(IndexEntry indexEntry) {
        int compare = Integer.compare(getIndexId(), indexEntry.getIndexId());
        if (compare != 0) {
            return compare;
        }
        int compareTo = getDocumentKey().compareTo(indexEntry.getDocumentKey());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareByteArrays = Util.compareByteArrays(getArrayValue(), indexEntry.getArrayValue());
        return compareByteArrays != 0 ? compareByteArrays : Util.compareByteArrays(getDirectionalValue(), indexEntry.getDirectionalValue());
    }
}
