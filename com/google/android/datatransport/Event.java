package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i4, T t3) {
        return new AutoValue_Event(Integer.valueOf(i4), t3, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(int i4, T t3) {
        return new AutoValue_Event(Integer.valueOf(i4), t3, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(int i4, T t3) {
        return new AutoValue_Event(Integer.valueOf(i4), t3, Priority.HIGHEST);
    }

    @Nullable
    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public static <T> Event<T> ofData(T t3) {
        return new AutoValue_Event(null, t3, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(T t3) {
        return new AutoValue_Event(null, t3, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(T t3) {
        return new AutoValue_Event(null, t3, Priority.HIGHEST);
    }
}
