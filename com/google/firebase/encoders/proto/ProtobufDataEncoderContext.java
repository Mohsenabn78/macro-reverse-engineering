package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ProtobufDataEncoderContext implements ObjectEncoderContext {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f30100f = Charset.forName("UTF-8");

    /* renamed from: g  reason: collision with root package name */
    private static final FieldDescriptor f30101g = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();

    /* renamed from: h  reason: collision with root package name */
    private static final FieldDescriptor f30102h = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();

    /* renamed from: i  reason: collision with root package name */
    private static final ObjectEncoder<Map.Entry<Object, Object>> f30103i = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.a
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ProtobufDataEncoderContext.r((Map.Entry) obj, (ObjectEncoderContext) obj2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f30104a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f30105b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f30106c;

    /* renamed from: d  reason: collision with root package name */
    private final ObjectEncoder<Object> f30107d;

    /* renamed from: e  reason: collision with root package name */
    private final ProtobufValueEncoderContext f30108e = new ProtobufValueEncoderContext(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30109a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f30109a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30109a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30109a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f30104a = outputStream;
        this.f30105b = map;
        this.f30106c = map2;
        this.f30107d = objectEncoder;
    }

    private static ByteBuffer k(int i4) {
        return ByteBuffer.allocate(i4).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long l(ObjectEncoder<T> objectEncoder, T t3) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            OutputStream outputStream = this.f30104a;
            this.f30104a = lengthCountingOutputStream;
            objectEncoder.encode(t3, this);
            this.f30104a = outputStream;
            long b4 = lengthCountingOutputStream.b();
            lengthCountingOutputStream.close();
            return b4;
        } catch (Throwable th) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private <T> ProtobufDataEncoderContext m(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t3, boolean z3) throws IOException {
        long l4 = l(objectEncoder, t3);
        if (z3 && l4 == 0) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 2);
        t(l4);
        objectEncoder.encode(t3, this);
        return this;
    }

    private <T> ProtobufDataEncoderContext n(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t3, boolean z3) throws IOException {
        this.f30108e.b(fieldDescriptor, z3);
        valueEncoder.encode(t3, this.f30108e);
        return this;
    }

    private static Protobuf p(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int q(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(f30101g, entry.getKey());
        objectEncoderContext.add(f30102h, entry.getValue());
    }

    private void s(int i4) throws IOException {
        while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
            this.f30104a.write((i4 & 127) | 128);
            i4 >>>= 7;
        }
        this.f30104a.write(i4 & 127);
    }

    private void t(long j4) throws IOException {
        while (((-128) & j4) != 0) {
            this.f30104a.write((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        this.f30104a.write(((int) j4) & 127);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, double d4, boolean z3) throws IOException {
        if (z3 && d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 1);
        this.f30104a.write(k(8).putDouble(d4).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, float f4, boolean z3) throws IOException {
        if (z3 && f4 == 0.0f) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 5);
        this.f30104a.write(k(4).putFloat(f4).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectEncoderContext d(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj, boolean z3) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z3 && charSequence.length() == 0) {
                return this;
            }
            s((q(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f30100f);
            s(bytes.length);
            this.f30104a.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                d(fieldDescriptor, obj2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                m(f30103i, fieldDescriptor, entry, false);
            }
            return this;
        } else if (obj instanceof Double) {
            return b(fieldDescriptor, ((Double) obj).doubleValue(), z3);
        } else {
            if (obj instanceof Float) {
                return c(fieldDescriptor, ((Float) obj).floatValue(), z3);
            }
            if (obj instanceof Number) {
                return h(fieldDescriptor, ((Number) obj).longValue(), z3);
            }
            if (obj instanceof Boolean) {
                return j(fieldDescriptor, ((Boolean) obj).booleanValue(), z3);
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (z3 && bArr.length == 0) {
                    return this;
                }
                s((q(fieldDescriptor) << 3) | 2);
                s(bArr.length);
                this.f30104a.write(bArr);
                return this;
            }
            ObjectEncoder<?> objectEncoder = this.f30105b.get(obj.getClass());
            if (objectEncoder != null) {
                return m(objectEncoder, fieldDescriptor, obj, z3);
            }
            ValueEncoder<?> valueEncoder = this.f30106c.get(obj.getClass());
            if (valueEncoder != null) {
                return n(valueEncoder, fieldDescriptor, obj, z3);
            }
            if (obj instanceof ProtoEnum) {
                return add(fieldDescriptor, ((ProtoEnum) obj).getNumber());
            }
            if (obj instanceof Enum) {
                return add(fieldDescriptor, ((Enum) obj).ordinal());
            }
            return m(this.f30107d, fieldDescriptor, obj, z3);
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: e */
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i4) throws IOException {
        return f(fieldDescriptor, i4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext f(@NonNull FieldDescriptor fieldDescriptor, int i4, boolean z3) throws IOException {
        if (z3 && i4 == 0) {
            return this;
        }
        Protobuf p4 = p(fieldDescriptor);
        int i5 = AnonymousClass1.f30109a[p4.intEncoding().ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    s((p4.tag() << 3) | 5);
                    this.f30104a.write(k(4).putInt(i4).array());
                }
            } else {
                s(p4.tag() << 3);
                s((i4 << 1) ^ (i4 >> 31));
            }
        } else {
            s(p4.tag() << 3);
            s(i4);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: g */
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j4) throws IOException {
        return h(fieldDescriptor, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext h(@NonNull FieldDescriptor fieldDescriptor, long j4, boolean z3) throws IOException {
        if (z3 && j4 == 0) {
            return this;
        }
        Protobuf p4 = p(fieldDescriptor);
        int i4 = AnonymousClass1.f30109a[p4.intEncoding().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    s((p4.tag() << 3) | 1);
                    this.f30104a.write(k(8).putLong(j4).array());
                }
            } else {
                s(p4.tag() << 3);
                t((j4 >> 63) ^ (j4 << 1));
            }
        } else {
            s(p4.tag() << 3);
            t(j4);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: i */
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z3) throws IOException {
        return j(fieldDescriptor, z3, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        return o(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext j(@NonNull FieldDescriptor fieldDescriptor, boolean z3, boolean z4) throws IOException {
        return f(fieldDescriptor, z3 ? 1 : 0, z4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext nested(@NonNull String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext o(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.f30105b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException {
        return add(FieldDescriptor.of(str), obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, double d4) throws IOException {
        return add(FieldDescriptor.of(str), d4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, int i4) throws IOException {
        return add(FieldDescriptor.of(str), i4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, long j4) throws IOException {
        return add(FieldDescriptor.of(str), j4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, boolean z3) throws IOException {
        return add(FieldDescriptor.of(str), z3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        return d(fieldDescriptor, obj, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d4) throws IOException {
        return b(fieldDescriptor, d4, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f4) throws IOException {
        return c(fieldDescriptor, f4, true);
    }
}
