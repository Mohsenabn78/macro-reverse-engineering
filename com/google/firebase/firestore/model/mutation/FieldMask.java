package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.FieldPath;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class FieldMask {
    public static FieldMask EMPTY = fromSet(new HashSet());

    /* renamed from: a  reason: collision with root package name */
    private final Set<FieldPath> f30981a;

    private FieldMask(Set<FieldPath> set) {
        this.f30981a = set;
    }

    public static FieldMask fromSet(Set<FieldPath> set) {
        return new FieldMask(set);
    }

    public boolean covers(FieldPath fieldPath) {
        for (FieldPath fieldPath2 : this.f30981a) {
            if (fieldPath2.isPrefixOf(fieldPath)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FieldMask.class == obj.getClass()) {
            return this.f30981a.equals(((FieldMask) obj).f30981a);
        }
        return false;
    }

    public Set<FieldPath> getMask() {
        return this.f30981a;
    }

    public int hashCode() {
        return this.f30981a.hashCode();
    }

    public String toString() {
        return "FieldMask{mask=" + this.f30981a.toString() + "}";
    }
}
