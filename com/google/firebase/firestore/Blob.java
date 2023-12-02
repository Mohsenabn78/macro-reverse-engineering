package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;

/* loaded from: classes5.dex */
public class Blob implements Comparable<Blob> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteString f30131a;

    private Blob(ByteString byteString) {
        this.f30131a = byteString;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Blob fromByteString(@NonNull ByteString byteString) {
        Preconditions.checkNotNull(byteString, "Provided ByteString must not be null.");
        return new Blob(byteString);
    }

    @NonNull
    public static Blob fromBytes(@NonNull byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Provided bytes array must not be null.");
        return new Blob(ByteString.copyFrom(bArr));
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof Blob) && this.f30131a.equals(((Blob) obj).f30131a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f30131a.hashCode();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ByteString toByteString() {
        return this.f30131a;
    }

    @NonNull
    public byte[] toBytes() {
        return this.f30131a.toByteArray();
    }

    @NonNull
    public String toString() {
        return "Blob { bytes=" + Util.toDebugString(this.f30131a) + " }";
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Blob blob) {
        return Util.compareByteStrings(this.f30131a, blob.f30131a);
    }
}
