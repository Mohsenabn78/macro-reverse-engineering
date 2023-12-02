package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class FieldValue {

    /* renamed from: a  reason: collision with root package name */
    private static final DeleteFieldValue f30149a = new DeleteFieldValue();

    /* renamed from: b  reason: collision with root package name */
    private static final ServerTimestampFieldValue f30150b = new ServerTimestampFieldValue();

    /* loaded from: classes5.dex */
    static class ArrayRemoveFieldValue extends FieldValue {

        /* renamed from: c  reason: collision with root package name */
        private final List<Object> f30151c;

        ArrayRemoveFieldValue(List<Object> list) {
            this.f30151c = list;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.arrayRemove";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Object> b() {
            return this.f30151c;
        }
    }

    /* loaded from: classes5.dex */
    static class ArrayUnionFieldValue extends FieldValue {

        /* renamed from: c  reason: collision with root package name */
        private final List<Object> f30152c;

        ArrayUnionFieldValue(List<Object> list) {
            this.f30152c = list;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.arrayUnion";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Object> b() {
            return this.f30152c;
        }
    }

    /* loaded from: classes5.dex */
    static class DeleteFieldValue extends FieldValue {
        DeleteFieldValue() {
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.delete";
        }
    }

    /* loaded from: classes5.dex */
    static class NumericIncrementFieldValue extends FieldValue {

        /* renamed from: c  reason: collision with root package name */
        private final Number f30153c;

        NumericIncrementFieldValue(Number number) {
            this.f30153c = number;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.increment";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Number b() {
            return this.f30153c;
        }
    }

    /* loaded from: classes5.dex */
    static class ServerTimestampFieldValue extends FieldValue {
        ServerTimestampFieldValue() {
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.serverTimestamp";
        }
    }

    FieldValue() {
    }

    @NonNull
    public static FieldValue arrayRemove(Object... objArr) {
        return new ArrayRemoveFieldValue(Arrays.asList(objArr));
    }

    @NonNull
    public static FieldValue arrayUnion(Object... objArr) {
        return new ArrayUnionFieldValue(Arrays.asList(objArr));
    }

    @NonNull
    public static FieldValue delete() {
        return f30149a;
    }

    @NonNull
    public static FieldValue increment(long j4) {
        return new NumericIncrementFieldValue(Long.valueOf(j4));
    }

    @NonNull
    public static FieldValue serverTimestamp() {
        return f30150b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String a();

    @NonNull
    public static FieldValue increment(double d4) {
        return new NumericIncrementFieldValue(Double.valueOf(d4));
    }
}
