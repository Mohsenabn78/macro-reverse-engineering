package com.google.firebase.firestore.model;

import androidx.annotation.Nullable;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.Timestamp;

/* loaded from: classes5.dex */
public final class ServerTimestamps {
    private ServerTimestamps() {
    }

    public static Timestamp getLocalWriteTime(Value value) {
        return value.getMapValue().getFieldsOrThrow("__local_write_time__").getTimestampValue();
    }

    @Nullable
    public static Value getPreviousValue(Value value) {
        Value fieldsOrDefault = value.getMapValue().getFieldsOrDefault("__previous_value__", null);
        if (isServerTimestamp(fieldsOrDefault)) {
            return getPreviousValue(fieldsOrDefault);
        }
        return fieldsOrDefault;
    }

    public static boolean isServerTimestamp(@Nullable Value value) {
        Value value2 = null;
        if (value != null) {
            value2 = value.getMapValue().getFieldsOrDefault("__type__", null);
        }
        if (value2 != null && "server_timestamp".equals(value2.getStringValue())) {
            return true;
        }
        return false;
    }

    public static Value valueOf(com.google.firebase.Timestamp timestamp, @Nullable Value value) {
        MapValue.Builder putFields = MapValue.newBuilder().putFields("__type__", Value.newBuilder().setStringValue("server_timestamp").build()).putFields("__local_write_time__", Value.newBuilder().setTimestampValue(Timestamp.newBuilder().setSeconds(timestamp.getSeconds()).setNanos(timestamp.getNanoseconds())).build());
        if (isServerTimestamp(value)) {
            value = getPreviousValue(value);
        }
        if (value != null) {
            putFields.putFields("__previous_value__", value);
        }
        return Value.newBuilder().setMapValue(putFields).build();
    }
}
