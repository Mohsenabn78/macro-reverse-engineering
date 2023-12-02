package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private JsonValueObjectEncoderContext f30087a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30088b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f30089c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f30090d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f30091e;

    /* renamed from: f  reason: collision with root package name */
    private final ObjectEncoder<Object> f30092f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f30093g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonValueObjectEncoderContext(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z3) {
        this.f30089c = new JsonWriter(writer);
        this.f30090d = map;
        this.f30091e = map2;
        this.f30092f = objectEncoder;
        this.f30093g = z3;
    }

    private boolean n(Object obj) {
        if (obj != null && !obj.getClass().isArray() && !(obj instanceof Collection) && !(obj instanceof Date) && !(obj instanceof Enum) && !(obj instanceof Number)) {
            return false;
        }
        return true;
    }

    private JsonValueObjectEncoderContext q(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        s();
        this.f30089c.name(str);
        if (obj == null) {
            this.f30089c.nullValue();
            return this;
        }
        return e(obj, false);
    }

    private JsonValueObjectEncoderContext r(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        if (obj == null) {
            return this;
        }
        s();
        this.f30089c.name(str);
        return e(obj, false);
    }

    private void s() throws IOException {
        if (this.f30088b) {
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.f30087a;
            if (jsonValueObjectEncoderContext != null) {
                jsonValueObjectEncoderContext.s();
                this.f30087a.f30088b = false;
                this.f30087a = null;
                this.f30089c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: a */
    public JsonValueObjectEncoderContext add(double d4) throws IOException {
        s();
        this.f30089c.value(d4);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: b */
    public JsonValueObjectEncoderContext add(float f4) throws IOException {
        s();
        this.f30089c.value(f4);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: c */
    public JsonValueObjectEncoderContext add(int i4) throws IOException {
        s();
        this.f30089c.value(i4);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: d */
    public JsonValueObjectEncoderContext add(long j4) throws IOException {
        s();
        this.f30089c.value(j4);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public JsonValueObjectEncoderContext e(@Nullable Object obj, boolean z3) throws IOException {
        int[] iArr;
        Class<?> cls;
        int i4 = 0;
        if (z3 && n(obj)) {
            Object[] objArr = new Object[1];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            objArr[0] = cls;
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        } else if (obj == null) {
            this.f30089c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f30089c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return add((byte[]) obj);
            }
            this.f30089c.beginArray();
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i4 < length) {
                    this.f30089c.value(iArr[i4]);
                    i4++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i4 < length2) {
                    add(jArr[i4]);
                    i4++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i4 < length3) {
                    this.f30089c.value(dArr[i4]);
                    i4++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i4 < length4) {
                    this.f30089c.value(zArr[i4]);
                    i4++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    e(number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    e(obj2, false);
                }
            }
            this.f30089c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f30089c.beginArray();
            for (Object obj3 : (Collection) obj) {
                e(obj3, false);
            }
            this.f30089c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f30089c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add((String) key, entry.getValue());
                } catch (ClassCastException e4) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e4);
                }
            }
            this.f30089c.endObject();
            return this;
        } else {
            ObjectEncoder<?> objectEncoder = this.f30090d.get(obj.getClass());
            if (objectEncoder != null) {
                return p(objectEncoder, obj, z3);
            }
            ValueEncoder<?> valueEncoder = this.f30091e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                if (obj instanceof NumberedEnum) {
                    add(((NumberedEnum) obj).getNumber());
                } else {
                    add(((Enum) obj).name());
                }
                return this;
            } else {
                return p(this.f30092f, obj, z3);
            }
        }
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: f */
    public JsonValueObjectEncoderContext add(@Nullable String str) throws IOException {
        s();
        this.f30089c.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: g */
    public JsonValueObjectEncoderContext add(@NonNull String str, double d4) throws IOException {
        s();
        this.f30089c.name(str);
        return add(d4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: h */
    public JsonValueObjectEncoderContext add(@NonNull String str, int i4) throws IOException {
        s();
        this.f30089c.name(str);
        return add(i4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: i */
    public JsonValueObjectEncoderContext add(@NonNull String str, long j4) throws IOException {
        s();
        this.f30089c.name(str);
        return add(j4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        return e(obj, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: j */
    public JsonValueObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException {
        if (this.f30093g) {
            return r(str, obj);
        }
        return q(str, obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: k */
    public JsonValueObjectEncoderContext add(@NonNull String str, boolean z3) throws IOException {
        s();
        this.f30089c.name(str);
        return add(z3);
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: l */
    public JsonValueObjectEncoderContext add(boolean z3) throws IOException {
        s();
        this.f30089c.value(z3);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: m */
    public JsonValueObjectEncoderContext add(@Nullable byte[] bArr) throws IOException {
        s();
        if (bArr == null) {
            this.f30089c.nullValue();
        } else {
            this.f30089c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext nested(@NonNull String str) throws IOException {
        s();
        this.f30087a = new JsonValueObjectEncoderContext(this);
        this.f30089c.name(str);
        this.f30089c.beginObject();
        return this.f30087a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() throws IOException {
        s();
        this.f30089c.flush();
    }

    JsonValueObjectEncoderContext p(ObjectEncoder<Object> objectEncoder, Object obj, boolean z3) throws IOException {
        if (!z3) {
            this.f30089c.beginObject();
        }
        objectEncoder.encode(obj, this);
        if (!z3) {
            this.f30089c.endObject();
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        return nested(fieldDescriptor.getName());
    }

    private JsonValueObjectEncoderContext(JsonValueObjectEncoderContext jsonValueObjectEncoderContext) {
        this.f30089c = jsonValueObjectEncoderContext.f30089c;
        this.f30090d = jsonValueObjectEncoderContext.f30090d;
        this.f30091e = jsonValueObjectEncoderContext.f30091e;
        this.f30092f = jsonValueObjectEncoderContext.f30092f;
        this.f30093g = jsonValueObjectEncoderContext.f30093g;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        return add(fieldDescriptor.getName(), obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f4) throws IOException {
        return add(fieldDescriptor.getName(), f4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d4) throws IOException {
        return add(fieldDescriptor.getName(), d4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i4) throws IOException {
        return add(fieldDescriptor.getName(), i4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j4) throws IOException {
        return add(fieldDescriptor.getName(), j4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z3) throws IOException {
        return add(fieldDescriptor.getName(), z3);
    }
}
