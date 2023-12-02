package com.google.api.client.json;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class JsonGenerator {
    private void a(boolean z3, Object obj) throws IOException {
        boolean z4;
        ClassInfo of;
        boolean z5;
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (Data.isNull(obj)) {
            writeNull();
        } else if (obj instanceof String) {
            writeString((String) obj);
        } else {
            boolean z6 = true;
            if (obj instanceof Number) {
                if (z3) {
                    writeString(obj.toString());
                } else if (obj instanceof BigDecimal) {
                    writeNumber((BigDecimal) obj);
                } else if (obj instanceof BigInteger) {
                    writeNumber((BigInteger) obj);
                } else if (obj instanceof Long) {
                    writeNumber(((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    float floatValue = ((Number) obj).floatValue();
                    Preconditions.checkArgument((Float.isInfinite(floatValue) || Float.isNaN(floatValue)) ? false : false);
                    writeNumber(floatValue);
                } else if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
                    double doubleValue = ((Number) obj).doubleValue();
                    Preconditions.checkArgument((Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) ? false : false);
                    writeNumber(doubleValue);
                } else {
                    writeNumber(((Number) obj).intValue());
                }
            } else if (obj instanceof Boolean) {
                writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof DateTime) {
                writeString(((DateTime) obj).toStringRfc3339());
            } else if (!(obj instanceof Iterable) && !cls.isArray()) {
                if (cls.isEnum()) {
                    String name = FieldInfo.of((Enum) obj).getName();
                    if (name == null) {
                        writeNull();
                        return;
                    } else {
                        writeString(name);
                        return;
                    }
                }
                writeStartObject();
                if ((obj instanceof Map) && !(obj instanceof GenericData)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    of = null;
                } else {
                    of = ClassInfo.of(cls);
                }
                for (Map.Entry<String, Object> entry : Data.mapOf(obj).entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        String key = entry.getKey();
                        if (z4) {
                            z5 = z3;
                        } else {
                            Field field = of.getField(key);
                            if (field != null && field.getAnnotation(JsonString.class) != null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                        writeFieldName(key);
                        a(z5, value);
                    }
                }
                writeEndObject();
            } else {
                writeStartArray();
                for (Object obj2 : Types.iterableOf(obj)) {
                    a(z3, obj2);
                }
                writeEndArray();
            }
        }
    }

    public abstract void close() throws IOException;

    public abstract void flush() throws IOException;

    public abstract JsonFactory getFactory();

    public final void serialize(Object obj) throws IOException {
        a(false, obj);
    }

    public abstract void writeBoolean(boolean z3) throws IOException;

    public abstract void writeEndArray() throws IOException;

    public abstract void writeEndObject() throws IOException;

    public abstract void writeFieldName(String str) throws IOException;

    public abstract void writeNull() throws IOException;

    public abstract void writeNumber(double d4) throws IOException;

    public abstract void writeNumber(float f4) throws IOException;

    public abstract void writeNumber(int i4) throws IOException;

    public abstract void writeNumber(long j4) throws IOException;

    public abstract void writeNumber(String str) throws IOException;

    public abstract void writeNumber(BigDecimal bigDecimal) throws IOException;

    public abstract void writeNumber(BigInteger bigInteger) throws IOException;

    public abstract void writeStartArray() throws IOException;

    public abstract void writeStartObject() throws IOException;

    public abstract void writeString(String str) throws IOException;

    public void enablePrettyPrint() throws IOException {
    }
}
