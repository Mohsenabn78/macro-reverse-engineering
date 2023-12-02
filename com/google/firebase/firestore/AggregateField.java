package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Objects;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public abstract class AggregateField {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final FieldPath f30123a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f30124b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f30125c;

    /* loaded from: classes5.dex */
    public static class AverageAggregateField extends AggregateField {
        private AverageAggregateField(@NonNull FieldPath fieldPath) {
            super(fieldPath, "average");
        }
    }

    /* loaded from: classes5.dex */
    public static class CountAggregateField extends AggregateField {
        private CountAggregateField() {
            super(null, "count");
        }
    }

    /* loaded from: classes5.dex */
    public static class SumAggregateField extends AggregateField {
        private SumAggregateField(@NonNull FieldPath fieldPath) {
            super(fieldPath, "sum");
        }
    }

    @NonNull
    public static AverageAggregateField average(@NonNull String str) {
        return new AverageAggregateField(FieldPath.a(str));
    }

    @NonNull
    public static CountAggregateField count() {
        return new CountAggregateField();
    }

    @NonNull
    public static SumAggregateField sum(@NonNull String str) {
        return new SumAggregateField(FieldPath.a(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregateField)) {
            return false;
        }
        AggregateField aggregateField = (AggregateField) obj;
        FieldPath fieldPath = this.f30123a;
        if (fieldPath != null && aggregateField.f30123a != null) {
            if (this.f30124b.equals(aggregateField.getOperator()) && getFieldPath().equals(aggregateField.getFieldPath())) {
                return true;
            }
            return false;
        } else if (fieldPath == null && aggregateField.f30123a == null) {
            return true;
        } else {
            return false;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getAlias() {
        return this.f30125c;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getFieldPath() {
        FieldPath fieldPath = this.f30123a;
        if (fieldPath == null) {
            return "";
        }
        return fieldPath.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getOperator() {
        return this.f30124b;
    }

    public int hashCode() {
        return Objects.hash(getOperator(), getFieldPath());
    }

    private AggregateField(@Nullable FieldPath fieldPath, @NonNull String str) {
        String str2;
        this.f30123a = fieldPath;
        this.f30124b = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (fieldPath == null) {
            str2 = "";
        } else {
            str2 = "_" + fieldPath;
        }
        sb.append(str2);
        this.f30125c = sb.toString();
    }

    @NonNull
    public static AverageAggregateField average(@NonNull FieldPath fieldPath) {
        return new AverageAggregateField(fieldPath);
    }

    @NonNull
    public static SumAggregateField sum(@NonNull FieldPath fieldPath) {
        return new SumAggregateField(fieldPath);
    }
}
