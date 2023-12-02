package com.google.firebase.firestore;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseException;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;

/* loaded from: classes5.dex */
public class FirebaseFirestoreException extends FirebaseException {
    @NonNull
    private final Code code;

    /* loaded from: classes5.dex */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        

        /* renamed from: a  reason: collision with root package name */
        private static final SparseArray<Code> f30173a = a();
        private final int value;

        Code(int i4) {
            this.value = i4;
        }

        private static SparseArray<Code> a() {
            Code[] values;
            SparseArray<Code> sparseArray = new SparseArray<>();
            for (Code code : values()) {
                Code code2 = sparseArray.get(code.value());
                if (code2 == null) {
                    sparseArray.put(code.value(), code);
                } else {
                    throw new IllegalStateException("Code value duplication between " + code2 + "&" + code.name());
                }
            }
            return sparseArray;
        }

        @NonNull
        public static Code fromValue(int i4) {
            return f30173a.get(i4, UNKNOWN);
        }

        public int value() {
            return this.value;
        }
    }

    public FirebaseFirestoreException(@NonNull String str, @NonNull Code code) {
        super(str);
        Preconditions.checkNotNull(str, "Provided message must not be null.");
        Assert.hardAssert(code != Code.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.code = (Code) Preconditions.checkNotNull(code, "Provided code must not be null.");
    }

    @NonNull
    public Code getCode() {
        return this.code;
    }

    public FirebaseFirestoreException(@NonNull String str, @NonNull Code code, @Nullable Throwable th) {
        super(str, th);
        Preconditions.checkNotNull(str, "Provided message must not be null.");
        Assert.hardAssert(code != Code.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.code = (Code) Preconditions.checkNotNull(code, "Provided code must not be null.");
    }
}
