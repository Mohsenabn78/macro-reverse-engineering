package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firestore.v1.Value;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;

/* loaded from: classes5.dex */
public class AggregateQuerySnapshot {
    @Nonnull

    /* renamed from: a  reason: collision with root package name */
    private final AggregateQuery f30128a;
    @Nonnull

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Value> f30129b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AggregateQuerySnapshot(@NonNull AggregateQuery aggregateQuery, @NonNull Map<String, Value> map) {
        Preconditions.checkNotNull(aggregateQuery);
        this.f30128a = aggregateQuery;
        this.f30129b = map;
    }

    @Nullable
    private <T> T a(Object obj, @Nonnull AggregateField aggregateField, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RuntimeException("AggregateField '" + aggregateField.getAlias() + "' is not a " + cls.getName());
    }

    @Nullable
    private Object b(@Nonnull AggregateField aggregateField) {
        if (this.f30129b.containsKey(aggregateField.getAlias())) {
            return new UserDataWriter(this.f30128a.getQuery().f30218b, DocumentSnapshot.ServerTimestampBehavior.f30144a).convertValue(this.f30129b.get(aggregateField.getAlias()));
        }
        throw new IllegalArgumentException("'" + aggregateField.getOperator() + "(" + aggregateField.getFieldPath() + ")' was not requested in the aggregation query.");
    }

    @Nullable
    private <T> T c(@Nonnull AggregateField aggregateField, Class<T> cls) {
        return (T) a(b(aggregateField), aggregateField, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregateQuerySnapshot)) {
            return false;
        }
        AggregateQuerySnapshot aggregateQuerySnapshot = (AggregateQuerySnapshot) obj;
        if (this.f30128a.equals(aggregateQuerySnapshot.f30128a) && this.f30129b.equals(aggregateQuerySnapshot.f30129b)) {
            return true;
        }
        return false;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Object get(@Nonnull AggregateField aggregateField) {
        return b(aggregateField);
    }

    public long getCount() {
        return get(AggregateField.count());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Double getDouble(@Nonnull AggregateField aggregateField) {
        Number number = (Number) c(aggregateField, Number.class);
        if (number != null) {
            return Double.valueOf(number.doubleValue());
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getLong(@Nonnull AggregateField aggregateField) {
        Number number = (Number) c(aggregateField, Number.class);
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    @NonNull
    public AggregateQuery getQuery() {
        return this.f30128a;
    }

    public int hashCode() {
        return Objects.hash(this.f30128a, this.f30129b);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long get(@Nonnull AggregateField.CountAggregateField countAggregateField) {
        Long l4 = getLong(countAggregateField);
        if (l4 != null) {
            return l4.longValue();
        }
        throw new IllegalArgumentException("RunAggregationQueryResponse alias " + countAggregateField.getAlias() + " is null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Double get(@Nonnull AggregateField.AverageAggregateField averageAggregateField) {
        return getDouble(averageAggregateField);
    }
}
