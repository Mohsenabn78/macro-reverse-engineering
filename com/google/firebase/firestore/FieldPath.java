package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class FieldPath {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f30146b = Pattern.compile("[~*/\\[\\]]");

    /* renamed from: c  reason: collision with root package name */
    private static final FieldPath f30147c = new FieldPath(com.google.firebase.firestore.model.FieldPath.KEY_PATH);

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.firestore.model.FieldPath f30148a;

    private FieldPath(List<String> list) {
        this.f30148a = com.google.firebase.firestore.model.FieldPath.fromSegments(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FieldPath a(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkArgument(!f30146b.matcher(str).find(), "Use FieldPath.of() for field names containing '~*/[]'.", new Object[0]);
        try {
            return of(str.split("\\.", -1));
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
        }
    }

    @NonNull
    public static FieldPath documentId() {
        return f30147c;
    }

    @NonNull
    public static FieldPath of(String... strArr) {
        boolean z3;
        boolean z4;
        if (strArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Invalid field path. Provided path must not be empty.", new Object[0]);
        int i4 = 0;
        while (i4 < strArr.length) {
            String str = strArr[i4];
            if (str != null && !str.isEmpty()) {
                z4 = true;
            } else {
                z4 = false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid field name at argument ");
            i4++;
            sb.append(i4);
            sb.append(". Field names must not be null or empty.");
            Preconditions.checkArgument(z4, sb.toString(), new Object[0]);
        }
        return new FieldPath(Arrays.asList(strArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.firestore.model.FieldPath b() {
        return this.f30148a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FieldPath.class == obj.getClass()) {
            return this.f30148a.equals(((FieldPath) obj).f30148a);
        }
        return false;
    }

    public int hashCode() {
        return this.f30148a.hashCode();
    }

    public String toString() {
        return this.f30148a.toString();
    }

    private FieldPath(com.google.firebase.firestore.model.FieldPath fieldPath) {
        this.f30148a = fieldPath;
    }
}
