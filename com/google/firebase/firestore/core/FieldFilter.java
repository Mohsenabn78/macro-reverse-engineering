package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class FieldFilter extends Filter {

    /* renamed from: a  reason: collision with root package name */
    private final Operator f30343a;

    /* renamed from: b  reason: collision with root package name */
    private final Value f30344b;

    /* renamed from: c  reason: collision with root package name */
    private final FieldPath f30345c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.core.FieldFilter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30346a;

        static {
            int[] iArr = new int[Operator.values().length];
            f30346a = iArr;
            try {
                iArr[Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30346a[Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30346a[Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30346a[Operator.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30346a[Operator.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30346a[Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Operator {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        NOT_EQUAL("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in"),
        NOT_IN("not_in");
        
        private final String text;

        Operator(String str) {
            this.text = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.text;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldFilter(FieldPath fieldPath, Operator operator, Value value) {
        this.f30345c = fieldPath;
        this.f30343a = operator;
        this.f30344b = value;
    }

    public static FieldFilter create(FieldPath fieldPath, Operator operator, Value value) {
        boolean z3;
        if (fieldPath.isKeyField()) {
            if (operator == Operator.IN) {
                return new KeyFieldInFilter(fieldPath, value);
            }
            if (operator == Operator.NOT_IN) {
                return new KeyFieldNotInFilter(fieldPath, value);
            }
            if (operator != Operator.ARRAY_CONTAINS && operator != Operator.ARRAY_CONTAINS_ANY) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, operator.toString() + "queries don't make sense on document keys", new Object[0]);
            return new KeyFieldFilter(fieldPath, operator, value);
        } else if (operator == Operator.ARRAY_CONTAINS) {
            return new ArrayContainsFilter(fieldPath, value);
        } else {
            if (operator == Operator.IN) {
                return new InFilter(fieldPath, value);
            }
            if (operator == Operator.ARRAY_CONTAINS_ANY) {
                return new ArrayContainsAnyFilter(fieldPath, value);
            }
            if (operator == Operator.NOT_IN) {
                return new NotInFilter(fieldPath, value);
            }
            return new FieldFilter(fieldPath, operator, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i4) {
        switch (AnonymousClass1.f30346a[this.f30343a.ordinal()]) {
            case 1:
                if (i4 >= 0) {
                    return false;
                }
                return true;
            case 2:
                if (i4 > 0) {
                    return false;
                }
                return true;
            case 3:
                if (i4 != 0) {
                    return false;
                }
                return true;
            case 4:
                if (i4 == 0) {
                    return false;
                }
                return true;
            case 5:
                if (i4 <= 0) {
                    return false;
                }
                return true;
            case 6:
                if (i4 < 0) {
                    return false;
                }
                return true;
            default:
                throw Assert.fail("Unknown FieldFilter operator: %s", this.f30343a);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FieldFilter)) {
            return false;
        }
        FieldFilter fieldFilter = (FieldFilter) obj;
        if (this.f30343a != fieldFilter.f30343a || !this.f30345c.equals(fieldFilter.f30345c) || !this.f30344b.equals(fieldFilter.f30344b)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public String getCanonicalId() {
        return getField().canonicalString() + getOperator().toString() + Values.canonicalId(getValue());
    }

    public FieldPath getField() {
        return this.f30345c;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public List<Filter> getFilters() {
        return Collections.singletonList(this);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public FieldPath getFirstInequalityField() {
        if (isInequality()) {
            return getField();
        }
        return null;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public List<FieldFilter> getFlattenedFilters() {
        return Collections.singletonList(this);
    }

    public Operator getOperator() {
        return this.f30343a;
    }

    public Value getValue() {
        return this.f30344b;
    }

    public int hashCode() {
        return ((((1147 + this.f30343a.hashCode()) * 31) + this.f30345c.hashCode()) * 31) + this.f30344b.hashCode();
    }

    public boolean isInequality() {
        return Arrays.asList(Operator.LESS_THAN, Operator.LESS_THAN_OR_EQUAL, Operator.GREATER_THAN, Operator.GREATER_THAN_OR_EQUAL, Operator.NOT_EQUAL, Operator.NOT_IN).contains(this.f30343a);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        Value field = document.getField(this.f30345c);
        if (this.f30343a == Operator.NOT_EQUAL) {
            if (field != null && a(Values.compare(field, this.f30344b))) {
                return true;
            }
            return false;
        } else if (field != null && Values.typeOrder(field) == Values.typeOrder(this.f30344b) && a(Values.compare(field, this.f30344b))) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return getCanonicalId();
    }
}
