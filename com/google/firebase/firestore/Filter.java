package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.core.CompositeFilter;
import com.google.firebase.firestore.core.FieldFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class Filter {

    /* loaded from: classes5.dex */
    static class CompositeFilter extends Filter {

        /* renamed from: a  reason: collision with root package name */
        private final List<Filter> f30154a;

        /* renamed from: b  reason: collision with root package name */
        private final CompositeFilter.Operator f30155b;

        public CompositeFilter(@NonNull List<Filter> list, CompositeFilter.Operator operator) {
            this.f30154a = list;
            this.f30155b = operator;
        }

        public List<Filter> a() {
            return this.f30154a;
        }

        public CompositeFilter.Operator b() {
            return this.f30155b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CompositeFilter compositeFilter = (CompositeFilter) obj;
            if (this.f30155b == compositeFilter.f30155b && Objects.equals(this.f30154a, compositeFilter.f30154a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            List<Filter> list = this.f30154a;
            int i5 = 0;
            if (list != null) {
                i4 = list.hashCode();
            } else {
                i4 = 0;
            }
            int i6 = i4 * 31;
            CompositeFilter.Operator operator = this.f30155b;
            if (operator != null) {
                i5 = operator.hashCode();
            }
            return i6 + i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class UnaryFilter extends Filter {

        /* renamed from: a  reason: collision with root package name */
        private final FieldPath f30156a;

        /* renamed from: b  reason: collision with root package name */
        private final FieldFilter.Operator f30157b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f30158c;

        public UnaryFilter(FieldPath fieldPath, FieldFilter.Operator operator, @Nullable Object obj) {
            this.f30156a = fieldPath;
            this.f30157b = operator;
            this.f30158c = obj;
        }

        public FieldPath a() {
            return this.f30156a;
        }

        public FieldFilter.Operator b() {
            return this.f30157b;
        }

        @Nullable
        public Object c() {
            return this.f30158c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UnaryFilter unaryFilter = (UnaryFilter) obj;
            if (this.f30157b == unaryFilter.f30157b && Objects.equals(this.f30156a, unaryFilter.f30156a) && Objects.equals(this.f30158c, unaryFilter.f30158c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            int i5;
            FieldPath fieldPath = this.f30156a;
            int i6 = 0;
            if (fieldPath != null) {
                i4 = fieldPath.hashCode();
            } else {
                i4 = 0;
            }
            int i7 = i4 * 31;
            FieldFilter.Operator operator = this.f30157b;
            if (operator != null) {
                i5 = operator.hashCode();
            } else {
                i5 = 0;
            }
            int i8 = (i7 + i5) * 31;
            Object obj = this.f30158c;
            if (obj != null) {
                i6 = obj.hashCode();
            }
            return i8 + i6;
        }
    }

    @NonNull
    public static Filter and(Filter... filterArr) {
        return new CompositeFilter(Arrays.asList(filterArr), CompositeFilter.Operator.AND);
    }

    @NonNull
    public static Filter arrayContains(@NonNull String str, @Nullable Object obj) {
        return arrayContains(FieldPath.a(str), obj);
    }

    @NonNull
    public static Filter arrayContainsAny(@NonNull String str, @NonNull List<? extends Object> list) {
        return arrayContainsAny(FieldPath.a(str), list);
    }

    @NonNull
    public static Filter equalTo(@NonNull String str, @Nullable Object obj) {
        return equalTo(FieldPath.a(str), obj);
    }

    @NonNull
    public static Filter greaterThan(@NonNull String str, @Nullable Object obj) {
        return greaterThan(FieldPath.a(str), obj);
    }

    @NonNull
    public static Filter greaterThanOrEqualTo(@NonNull String str, @Nullable Object obj) {
        return greaterThanOrEqualTo(FieldPath.a(str), obj);
    }

    @NonNull
    public static Filter inArray(@NonNull String str, @NonNull List<? extends Object> list) {
        return inArray(FieldPath.a(str), list);
    }

    @NonNull
    public static Filter lessThan(@NonNull String str, @Nullable Object obj) {
        return lessThan(FieldPath.a(str), obj);
    }

    @NonNull
    public static Filter lessThanOrEqualTo(@NonNull String str, @Nullable Object obj) {
        return lessThanOrEqualTo(FieldPath.a(str), obj);
    }

    @NonNull
    public static Filter notEqualTo(@NonNull String str, @Nullable Object obj) {
        return notEqualTo(FieldPath.a(str), obj);
    }

    @NonNull
    public static Filter notInArray(@NonNull String str, @NonNull List<? extends Object> list) {
        return notInArray(FieldPath.a(str), list);
    }

    @NonNull
    public static Filter or(Filter... filterArr) {
        return new CompositeFilter(Arrays.asList(filterArr), CompositeFilter.Operator.OR);
    }

    @NonNull
    public static Filter arrayContains(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.ARRAY_CONTAINS, obj);
    }

    @NonNull
    public static Filter arrayContainsAny(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.ARRAY_CONTAINS_ANY, list);
    }

    @NonNull
    public static Filter equalTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.EQUAL, obj);
    }

    @NonNull
    public static Filter greaterThan(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.GREATER_THAN, obj);
    }

    @NonNull
    public static Filter greaterThanOrEqualTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.GREATER_THAN_OR_EQUAL, obj);
    }

    @NonNull
    public static Filter inArray(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.IN, list);
    }

    @NonNull
    public static Filter lessThan(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.LESS_THAN, obj);
    }

    @NonNull
    public static Filter lessThanOrEqualTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.LESS_THAN_OR_EQUAL, obj);
    }

    @NonNull
    public static Filter notEqualTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.NOT_EQUAL, obj);
    }

    @NonNull
    public static Filter notInArray(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return new UnaryFilter(fieldPath, FieldFilter.Operator.NOT_IN, list);
    }
}
