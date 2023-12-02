package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.util.Preconditions;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes5.dex */
public final class SetOptions {

    /* renamed from: c  reason: collision with root package name */
    static final SetOptions f30229c = new SetOptions(false, null);

    /* renamed from: d  reason: collision with root package name */
    private static final SetOptions f30230d = new SetOptions(true, null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30231a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final FieldMask f30232b;

    private SetOptions(boolean z3, @Nullable FieldMask fieldMask) {
        boolean z4;
        if (fieldMask != null && !z3) {
            z4 = false;
        } else {
            z4 = true;
        }
        Preconditions.checkArgument(z4, "Cannot specify a fieldMask for non-merge sets()", new Object[0]);
        this.f30231a = z3;
        this.f30232b = fieldMask;
    }

    @NonNull
    public static SetOptions merge() {
        return f30230d;
    }

    @NonNull
    public static SetOptions mergeFieldPaths(@NonNull List<FieldPath> list) {
        HashSet hashSet = new HashSet();
        for (FieldPath fieldPath : list) {
            hashSet.add(fieldPath.b());
        }
        return new SetOptions(true, FieldMask.fromSet(hashSet));
    }

    @NonNull
    public static SetOptions mergeFields(@NonNull List<String> list) {
        HashSet hashSet = new HashSet();
        for (String str : list) {
            hashSet.add(FieldPath.a(str).b());
        }
        return new SetOptions(true, FieldMask.fromSet(hashSet));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f30231a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SetOptions.class != obj.getClass()) {
            return false;
        }
        SetOptions setOptions = (SetOptions) obj;
        if (this.f30231a != setOptions.f30231a) {
            return false;
        }
        FieldMask fieldMask = this.f30232b;
        FieldMask fieldMask2 = setOptions.f30232b;
        if (fieldMask != null) {
            return fieldMask.equals(fieldMask2);
        }
        if (fieldMask2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FieldMask getFieldMask() {
        return this.f30232b;
    }

    public int hashCode() {
        int i4;
        int i5 = (this.f30231a ? 1 : 0) * 31;
        FieldMask fieldMask = this.f30232b;
        if (fieldMask != null) {
            i4 = fieldMask.hashCode();
        } else {
            i4 = 0;
        }
        return i5 + i4;
    }

    @NonNull
    public static SetOptions mergeFields(String... strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(FieldPath.a(str).b());
        }
        return new SetOptions(true, FieldMask.fromSet(hashSet));
    }
}
