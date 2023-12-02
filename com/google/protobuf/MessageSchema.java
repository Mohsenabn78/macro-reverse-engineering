package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public final class MessageSchema<T> implements Schema<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f33477r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f33478s = UnsafeUtil.I();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f33479a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f33480b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33481c;

    /* renamed from: d  reason: collision with root package name */
    private final int f33482d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f33483e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f33484f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f33485g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f33486h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f33487i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f33488j;

    /* renamed from: k  reason: collision with root package name */
    private final int f33489k;

    /* renamed from: l  reason: collision with root package name */
    private final int f33490l;

    /* renamed from: m  reason: collision with root package name */
    private final NewInstanceSchema f33491m;

    /* renamed from: n  reason: collision with root package name */
    private final ListFieldSchema f33492n;

    /* renamed from: o  reason: collision with root package name */
    private final UnknownFieldSchema<?, ?> f33493o;

    /* renamed from: p  reason: collision with root package name */
    private final ExtensionSchema<?> f33494p;

    /* renamed from: q  reason: collision with root package name */
    private final MapFieldSchema f33495q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.MessageSchema$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33496a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33496a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33496a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33496a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33496a[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33496a[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33496a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33496a[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33496a[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33496a[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33496a[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33496a[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33496a[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33496a[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33496a[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f33496a[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f33496a[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f33496a[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i4, int i5, MessageLite messageLite, boolean z3, boolean z4, int[] iArr2, int i6, int i7, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        boolean z5;
        this.f33479a = iArr;
        this.f33480b = objArr;
        this.f33481c = i4;
        this.f33482d = i5;
        this.f33485g = messageLite instanceof GeneratedMessageLite;
        this.f33486h = z3;
        if (extensionSchema != null && extensionSchema.e(messageLite)) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f33484f = z5;
        this.f33487i = z4;
        this.f33488j = iArr2;
        this.f33489k = i6;
        this.f33490l = i7;
        this.f33491m = newInstanceSchema;
        this.f33492n = listFieldSchema;
        this.f33493o = unknownFieldSchema;
        this.f33494p = extensionSchema;
        this.f33483e = messageLite;
        this.f33495q = mapFieldSchema;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.Schema] */
    private boolean A(T t3, int i4, int i5) {
        Map<?, ?> forMapData = this.f33495q.forMapData(UnsafeUtil.H(t3, S(i4)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.f33495q.forMapMetadata(o(i5)).f33471c.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<T> schema = 0;
        for (Object obj : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.a().c(obj.getClass());
            }
            boolean isInitialized = schema.isInitialized(obj);
            schema = schema;
            if (!isInitialized) {
                return false;
            }
        }
        return true;
    }

    private static boolean B(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).E();
        }
        return true;
    }

    private boolean C(T t3, T t4, int i4) {
        long f02 = f0(i4) & 1048575;
        if (UnsafeUtil.D(t3, f02) == UnsafeUtil.D(t4, f02)) {
            return true;
        }
        return false;
    }

    private boolean D(T t3, int i4, int i5) {
        if (UnsafeUtil.D(t3, f0(i5) & 1048575) == i4) {
            return true;
        }
        return false;
    }

    private static boolean E(int i4) {
        if ((i4 & 268435456) != 0) {
            return true;
        }
        return false;
    }

    private static List<?> F(Object obj, long j4) {
        return (List) UnsafeUtil.H(obj, j4);
    }

    private static <T> long G(T t3, long j4) {
        return UnsafeUtil.F(t3, j4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0649 A[Catch: all -> 0x06a1, TRY_LEAVE, TryCatch #0 {all -> 0x06a1, blocks: (B:158:0x061a, B:169:0x0643, B:171:0x0649, B:181:0x0671, B:182:0x0676), top: B:210:0x061a }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x06b3 A[LOOP:2: B:201:0x06af->B:203:0x06b3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x06c8  */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.google.protobuf.UnknownFieldSchema] */
    /* JADX WARN: Type inference failed for: r14v62 */
    /* JADX WARN: Type inference failed for: r1v139, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.protobuf.Reader] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void H(com.google.protobuf.UnknownFieldSchema<UT, UB> r19, com.google.protobuf.ExtensionSchema<ET> r20, T r21, com.google.protobuf.Reader r22, com.google.protobuf.ExtensionRegistryLite r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1882
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.H(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void I(Object obj, int i4, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long S = S(s0(i4));
        Object H = UnsafeUtil.H(obj, S);
        if (H == null) {
            H = this.f33495q.newMapField(obj2);
            UnsafeUtil.Y(obj, S, H);
        } else if (this.f33495q.isImmutable(H)) {
            Object newMapField = this.f33495q.newMapField(obj2);
            this.f33495q.mergeFrom(newMapField, H);
            UnsafeUtil.Y(obj, S, newMapField);
            H = newMapField;
        }
        reader.a(this.f33495q.forMutableMapData(H), this.f33495q.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void J(T t3, T t4, int i4) {
        if (!w(t4, i4)) {
            return;
        }
        long S = S(s0(i4));
        Unsafe unsafe = f33478s;
        Object object = unsafe.getObject(t4, S);
        if (object != null) {
            Schema p4 = p(i4);
            if (!w(t3, i4)) {
                if (!B(object)) {
                    unsafe.putObject(t3, S, object);
                } else {
                    Object newInstance = p4.newInstance();
                    p4.mergeFrom(newInstance, object);
                    unsafe.putObject(t3, S, newInstance);
                }
                l0(t3, i4);
                return;
            }
            Object object2 = unsafe.getObject(t3, S);
            if (!B(object2)) {
                Object newInstance2 = p4.newInstance();
                p4.mergeFrom(newInstance2, object2);
                unsafe.putObject(t3, S, newInstance2);
                object2 = newInstance2;
            }
            p4.mergeFrom(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + R(i4) + " is present but null: " + t4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K(T t3, T t4, int i4) {
        int R = R(i4);
        if (!D(t4, R, i4)) {
            return;
        }
        long S = S(s0(i4));
        Unsafe unsafe = f33478s;
        Object object = unsafe.getObject(t4, S);
        if (object != null) {
            Schema p4 = p(i4);
            if (!D(t3, R, i4)) {
                if (!B(object)) {
                    unsafe.putObject(t3, S, object);
                } else {
                    Object newInstance = p4.newInstance();
                    p4.mergeFrom(newInstance, object);
                    unsafe.putObject(t3, S, newInstance);
                }
                m0(t3, R, i4);
                return;
            }
            Object object2 = unsafe.getObject(t3, S);
            if (!B(object2)) {
                Object newInstance2 = p4.newInstance();
                p4.mergeFrom(newInstance2, object2);
                unsafe.putObject(t3, S, newInstance2);
                object2 = newInstance2;
            }
            p4.mergeFrom(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + R(i4) + " is present but null: " + t4);
    }

    private void L(T t3, T t4, int i4) {
        int s02 = s0(i4);
        long S = S(s02);
        int R = R(i4);
        switch (r0(s02)) {
            case 0:
                if (w(t4, i4)) {
                    UnsafeUtil.U(t3, S, UnsafeUtil.B(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 1:
                if (w(t4, i4)) {
                    UnsafeUtil.V(t3, S, UnsafeUtil.C(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 2:
                if (w(t4, i4)) {
                    UnsafeUtil.X(t3, S, UnsafeUtil.F(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 3:
                if (w(t4, i4)) {
                    UnsafeUtil.X(t3, S, UnsafeUtil.F(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 4:
                if (w(t4, i4)) {
                    UnsafeUtil.W(t3, S, UnsafeUtil.D(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 5:
                if (w(t4, i4)) {
                    UnsafeUtil.X(t3, S, UnsafeUtil.F(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 6:
                if (w(t4, i4)) {
                    UnsafeUtil.W(t3, S, UnsafeUtil.D(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 7:
                if (w(t4, i4)) {
                    UnsafeUtil.N(t3, S, UnsafeUtil.u(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 8:
                if (w(t4, i4)) {
                    UnsafeUtil.Y(t3, S, UnsafeUtil.H(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 9:
                J(t3, t4, i4);
                return;
            case 10:
                if (w(t4, i4)) {
                    UnsafeUtil.Y(t3, S, UnsafeUtil.H(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 11:
                if (w(t4, i4)) {
                    UnsafeUtil.W(t3, S, UnsafeUtil.D(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 12:
                if (w(t4, i4)) {
                    UnsafeUtil.W(t3, S, UnsafeUtil.D(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 13:
                if (w(t4, i4)) {
                    UnsafeUtil.W(t3, S, UnsafeUtil.D(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 14:
                if (w(t4, i4)) {
                    UnsafeUtil.X(t3, S, UnsafeUtil.F(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 15:
                if (w(t4, i4)) {
                    UnsafeUtil.W(t3, S, UnsafeUtil.D(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 16:
                if (w(t4, i4)) {
                    UnsafeUtil.X(t3, S, UnsafeUtil.F(t4, S));
                    l0(t3, i4);
                    return;
                }
                return;
            case 17:
                J(t3, t4, i4);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f33492n.d(t3, t4, S);
                return;
            case 50:
                SchemaUtil.F(this.f33495q, t3, t4, S);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (D(t4, R, i4)) {
                    UnsafeUtil.Y(t3, S, UnsafeUtil.H(t4, S));
                    m0(t3, R, i4);
                    return;
                }
                return;
            case 60:
                K(t3, t4, i4);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (D(t4, R, i4)) {
                    UnsafeUtil.Y(t3, S, UnsafeUtil.H(t4, S));
                    m0(t3, R, i4);
                    return;
                }
                return;
            case 68:
                K(t3, t4, i4);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object M(T t3, int i4) {
        Schema p4 = p(i4);
        long S = S(s0(i4));
        if (!w(t3, i4)) {
            return p4.newInstance();
        }
        Object object = f33478s.getObject(t3, S);
        if (B(object)) {
            return object;
        }
        Object newInstance = p4.newInstance();
        if (object != null) {
            p4.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object N(T t3, int i4, int i5) {
        Schema p4 = p(i5);
        if (!D(t3, i4, i5)) {
            return p4.newInstance();
        }
        Object object = f33478s.getObject(t3, S(s0(i5)));
        if (B(object)) {
            return object;
        }
        Object newInstance = p4.newInstance();
        if (object != null) {
            p4.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSchema<T> O(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return Q((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return P((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> P(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        boolean z3;
        int n4;
        int n5;
        int[] iArr;
        int i4;
        if (structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3) {
            z3 = true;
        } else {
            z3 = false;
        }
        FieldInfo[] b4 = structuralMessageInfo.b();
        if (b4.length == 0) {
            n4 = 0;
            n5 = 0;
        } else {
            n4 = b4[0].n();
            n5 = b4[b4.length - 1].n();
        }
        int length = b4.length;
        int[] iArr2 = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i5 = 0;
        int i6 = 0;
        for (FieldInfo fieldInfo : b4) {
            if (fieldInfo.t() == FieldType.MAP) {
                i5++;
            } else if (fieldInfo.t().id() >= 18 && fieldInfo.t().id() <= 49) {
                i6++;
            }
        }
        int[] iArr3 = null;
        if (i5 > 0) {
            iArr = new int[i5];
        } else {
            iArr = null;
        }
        if (i6 > 0) {
            iArr3 = new int[i6];
        }
        int[] a4 = structuralMessageInfo.a();
        if (a4 == null) {
            a4 = f33477r;
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i7 < b4.length) {
            FieldInfo fieldInfo2 = b4[i7];
            int n6 = fieldInfo2.n();
            o0(fieldInfo2, iArr2, i8, objArr);
            if (i9 < a4.length && a4[i9] == n6) {
                a4[i9] = i8;
                i9++;
            }
            if (fieldInfo2.t() == FieldType.MAP) {
                iArr[i10] = i8;
                i10++;
            } else if (fieldInfo2.t().id() >= 18 && fieldInfo2.t().id() <= 49) {
                i4 = i8;
                iArr3[i11] = (int) UnsafeUtil.M(fieldInfo2.m());
                i11++;
                i7++;
                i8 = i4 + 3;
            }
            i4 = i8;
            i7++;
            i8 = i4 + 3;
        }
        if (iArr == null) {
            iArr = f33477r;
        }
        if (iArr3 == null) {
            iArr3 = f33477r;
        }
        int[] iArr4 = new int[a4.length + iArr.length + iArr3.length];
        System.arraycopy(a4, 0, iArr4, 0, a4.length);
        System.arraycopy(iArr, 0, iArr4, a4.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, a4.length + iArr.length, iArr3.length);
        return new MessageSchema<>(iArr2, objArr, n4, n5, structuralMessageInfo.getDefaultInstance(), z3, true, iArr4, a4.length, a4.length + iArr.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x037c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.protobuf.MessageSchema<T> Q(com.google.protobuf.RawMessageInfo r34, com.google.protobuf.NewInstanceSchema r35, com.google.protobuf.ListFieldSchema r36, com.google.protobuf.UnknownFieldSchema<?, ?> r37, com.google.protobuf.ExtensionSchema<?> r38, com.google.protobuf.MapFieldSchema r39) {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.Q(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    private int R(int i4) {
        return this.f33479a[i4];
    }

    private static long S(int i4) {
        return i4 & 1048575;
    }

    private static <T> boolean T(T t3, long j4) {
        return ((Boolean) UnsafeUtil.H(t3, j4)).booleanValue();
    }

    private static <T> double U(T t3, long j4) {
        return ((Double) UnsafeUtil.H(t3, j4)).doubleValue();
    }

    private static <T> float V(T t3, long j4) {
        return ((Float) UnsafeUtil.H(t3, j4)).floatValue();
    }

    private static <T> int W(T t3, long j4) {
        return ((Integer) UnsafeUtil.H(t3, j4)).intValue();
    }

    private static <T> long X(T t3, long j4) {
        return ((Long) UnsafeUtil.H(t3, j4)).longValue();
    }

    private <K, V> int Y(T t3, byte[] bArr, int i4, int i5, int i6, long j4, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f33478s;
        Object o4 = o(i6);
        Object object = unsafe.getObject(t3, j4);
        if (this.f33495q.isImmutable(object)) {
            Object newMapField = this.f33495q.newMapField(o4);
            this.f33495q.mergeFrom(newMapField, object);
            unsafe.putObject(t3, j4, newMapField);
            object = newMapField;
        }
        return g(bArr, i4, i5, this.f33495q.forMapMetadata(o4), this.f33495q.forMutableMapData(object), registers);
    }

    private int Z(T t3, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, int i11, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f33478s;
        long j5 = this.f33479a[i11 + 2] & 1048575;
        switch (i10) {
            case 51:
                if (i8 == 1) {
                    unsafe.putObject(t3, j4, Double.valueOf(ArrayDecoders.d(bArr, i4)));
                    int i12 = i4 + 8;
                    unsafe.putInt(t3, j5, i7);
                    return i12;
                }
                break;
            case 52:
                if (i8 == 5) {
                    unsafe.putObject(t3, j4, Float.valueOf(ArrayDecoders.l(bArr, i4)));
                    int i13 = i4 + 4;
                    unsafe.putInt(t3, j5, i7);
                    return i13;
                }
                break;
            case 53:
            case 54:
                if (i8 == 0) {
                    int L = ArrayDecoders.L(bArr, i4, registers);
                    unsafe.putObject(t3, j4, Long.valueOf(registers.f33157b));
                    unsafe.putInt(t3, j5, i7);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i8 == 0) {
                    int I = ArrayDecoders.I(bArr, i4, registers);
                    unsafe.putObject(t3, j4, Integer.valueOf(registers.f33156a));
                    unsafe.putInt(t3, j5, i7);
                    return I;
                }
                break;
            case 56:
            case 65:
                if (i8 == 1) {
                    unsafe.putObject(t3, j4, Long.valueOf(ArrayDecoders.j(bArr, i4)));
                    int i14 = i4 + 8;
                    unsafe.putInt(t3, j5, i7);
                    return i14;
                }
                break;
            case 57:
            case 64:
                if (i8 == 5) {
                    unsafe.putObject(t3, j4, Integer.valueOf(ArrayDecoders.h(bArr, i4)));
                    int i15 = i4 + 4;
                    unsafe.putInt(t3, j5, i7);
                    return i15;
                }
                break;
            case 58:
                if (i8 == 0) {
                    int L2 = ArrayDecoders.L(bArr, i4, registers);
                    unsafe.putObject(t3, j4, Boolean.valueOf(registers.f33157b != 0));
                    unsafe.putInt(t3, j5, i7);
                    return L2;
                }
                break;
            case 59:
                if (i8 == 2) {
                    int I2 = ArrayDecoders.I(bArr, i4, registers);
                    int i16 = registers.f33156a;
                    if (i16 == 0) {
                        unsafe.putObject(t3, j4, "");
                    } else if ((i9 & 536870912) != 0 && !Utf8.u(bArr, I2, I2 + i16)) {
                        throw InvalidProtocolBufferException.e();
                    } else {
                        unsafe.putObject(t3, j4, new String(bArr, I2, i16, Internal.f33419b));
                        I2 += i16;
                    }
                    unsafe.putInt(t3, j5, i7);
                    return I2;
                }
                break;
            case 60:
                if (i8 == 2) {
                    Object N = N(t3, i7, i11);
                    int O = ArrayDecoders.O(N, p(i11), bArr, i4, i5, registers);
                    q0(t3, i7, i11, N);
                    return O;
                }
                break;
            case 61:
                if (i8 == 2) {
                    int b4 = ArrayDecoders.b(bArr, i4, registers);
                    unsafe.putObject(t3, j4, registers.f33158c);
                    unsafe.putInt(t3, j5, i7);
                    return b4;
                }
                break;
            case 63:
                if (i8 == 0) {
                    int I3 = ArrayDecoders.I(bArr, i4, registers);
                    int i17 = registers.f33156a;
                    Internal.EnumVerifier n4 = n(i11);
                    if (n4 != null && !n4.isInRange(i17)) {
                        q(t3).j(i6, Long.valueOf(i17));
                    } else {
                        unsafe.putObject(t3, j4, Integer.valueOf(i17));
                        unsafe.putInt(t3, j5, i7);
                    }
                    return I3;
                }
                break;
            case 66:
                if (i8 == 0) {
                    int I4 = ArrayDecoders.I(bArr, i4, registers);
                    unsafe.putObject(t3, j4, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.f33156a)));
                    unsafe.putInt(t3, j5, i7);
                    return I4;
                }
                break;
            case 67:
                if (i8 == 0) {
                    int L3 = ArrayDecoders.L(bArr, i4, registers);
                    unsafe.putObject(t3, j4, Long.valueOf(CodedInputStream.decodeZigZag64(registers.f33157b)));
                    unsafe.putInt(t3, j5, i7);
                    return L3;
                }
                break;
            case 68:
                if (i8 == 3) {
                    Object N2 = N(t3, i7, i11);
                    int N3 = ArrayDecoders.N(N2, p(i11), bArr, i4, i5, (i6 & (-8)) | 4, registers);
                    q0(t3, i7, i11, N2);
                    return N3;
                }
                break;
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0298, code lost:
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r1 = r18;
        r2 = r19;
        r7 = r22;
        r6 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02db, code lost:
        if (r0 != r15) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02fe, code lost:
        if (r0 != r15) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0301, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0296, code lost:
        if (r0 != r10) goto L103;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    @com.google.protobuf.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b0(T r30, byte[] r31, int r32, int r33, com.google.protobuf.ArrayDecoders.Registers r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.b0(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    private int c0(T t3, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, long j4, int i10, long j5, ArrayDecoders.Registers registers) throws IOException {
        int J;
        Unsafe unsafe = f33478s;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t3, j5);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t3, j5, protobufList);
        }
        switch (i10) {
            case 18:
            case 35:
                if (i8 == 2) {
                    return ArrayDecoders.s(bArr, i4, protobufList, registers);
                }
                if (i8 == 1) {
                    return ArrayDecoders.e(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i8 == 2) {
                    return ArrayDecoders.v(bArr, i4, protobufList, registers);
                }
                if (i8 == 5) {
                    return ArrayDecoders.m(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i8 == 2) {
                    return ArrayDecoders.z(bArr, i4, protobufList, registers);
                }
                if (i8 == 0) {
                    return ArrayDecoders.M(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i8 == 2) {
                    return ArrayDecoders.y(bArr, i4, protobufList, registers);
                }
                if (i8 == 0) {
                    return ArrayDecoders.J(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i8 == 2) {
                    return ArrayDecoders.u(bArr, i4, protobufList, registers);
                }
                if (i8 == 1) {
                    return ArrayDecoders.k(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i8 == 2) {
                    return ArrayDecoders.t(bArr, i4, protobufList, registers);
                }
                if (i8 == 5) {
                    return ArrayDecoders.i(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i8 == 2) {
                    return ArrayDecoders.r(bArr, i4, protobufList, registers);
                }
                if (i8 == 0) {
                    return ArrayDecoders.a(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 26:
                if (i8 == 2) {
                    if ((j4 & 536870912) == 0) {
                        return ArrayDecoders.D(i6, bArr, i4, i5, protobufList, registers);
                    }
                    return ArrayDecoders.E(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 27:
                if (i8 == 2) {
                    return ArrayDecoders.q(p(i9), i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 28:
                if (i8 == 2) {
                    return ArrayDecoders.c(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i8 == 2) {
                    J = ArrayDecoders.y(bArr, i4, protobufList, registers);
                } else if (i8 == 0) {
                    J = ArrayDecoders.J(i6, bArr, i4, i5, protobufList, registers);
                }
                SchemaUtil.A(t3, i7, protobufList, n(i9), null, this.f33493o);
                return J;
            case 33:
            case 47:
                if (i8 == 2) {
                    return ArrayDecoders.w(bArr, i4, protobufList, registers);
                }
                if (i8 == 0) {
                    return ArrayDecoders.A(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i8 == 2) {
                    return ArrayDecoders.x(bArr, i4, protobufList, registers);
                }
                if (i8 == 0) {
                    return ArrayDecoders.B(i6, bArr, i4, i5, protobufList, registers);
                }
                break;
            case 49:
                if (i8 == 3) {
                    return ArrayDecoders.o(p(i9), i6, bArr, i4, i5, protobufList, registers);
                }
                break;
        }
        return i4;
    }

    private boolean d(T t3, T t4, int i4) {
        if (w(t3, i4) == w(t4, i4)) {
            return true;
        }
        return false;
    }

    private int d0(int i4) {
        if (i4 >= this.f33481c && i4 <= this.f33482d) {
            return n0(i4, 0);
        }
        return -1;
    }

    private static <T> boolean e(T t3, long j4) {
        return UnsafeUtil.u(t3, j4);
    }

    private int e0(int i4, int i5) {
        if (i4 >= this.f33481c && i4 <= this.f33482d) {
            return n0(i4, i5);
        }
        return -1;
    }

    private static void f(Object obj) {
        if (B(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private int f0(int i4) {
        return this.f33479a[i4 + 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int g(byte[] bArr, int i4, int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int i6;
        int I = ArrayDecoders.I(bArr, i4, registers);
        int i7 = registers.f33156a;
        if (i7 >= 0 && i7 <= i5 - I) {
            int i8 = I + i7;
            K k4 = metadata.f33470b;
            V v3 = metadata.f33472d;
            while (I < i8) {
                int i9 = I + 1;
                byte b4 = bArr[I];
                if (b4 < 0) {
                    i6 = ArrayDecoders.H(b4, bArr, i9, registers);
                    b4 = registers.f33156a;
                } else {
                    i6 = i9;
                }
                int i10 = b4 >>> 3;
                int i11 = b4 & 7;
                if (i10 != 1) {
                    if (i10 == 2 && i11 == metadata.f33471c.getWireType()) {
                        I = h(bArr, i6, i5, metadata.f33471c, metadata.f33472d.getClass(), registers);
                        v3 = registers.f33158c;
                    }
                    I = ArrayDecoders.P(b4, bArr, i6, i5, registers);
                } else if (i11 == metadata.f33469a.getWireType()) {
                    I = h(bArr, i6, i5, metadata.f33469a, null, registers);
                    k4 = registers.f33158c;
                } else {
                    I = ArrayDecoders.P(b4, bArr, i6, i5, registers);
                }
            }
            if (I == i8) {
                map.put(k4, v3);
                return i8;
            }
            throw InvalidProtocolBufferException.i();
        }
        throw InvalidProtocolBufferException.n();
    }

    private <E> void g0(Object obj, long j4, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.d(this.f33492n.e(obj, j4), schema, extensionRegistryLite);
    }

    private int h(byte[] bArr, int i4, int i5, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        boolean z3;
        switch (AnonymousClass1.f33496a[fieldType.ordinal()]) {
            case 1:
                int L = ArrayDecoders.L(bArr, i4, registers);
                if (registers.f33157b != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                registers.f33158c = Boolean.valueOf(z3);
                return L;
            case 2:
                return ArrayDecoders.b(bArr, i4, registers);
            case 3:
                registers.f33158c = Double.valueOf(ArrayDecoders.d(bArr, i4));
                return i4 + 8;
            case 4:
            case 5:
                registers.f33158c = Integer.valueOf(ArrayDecoders.h(bArr, i4));
                return i4 + 4;
            case 6:
            case 7:
                registers.f33158c = Long.valueOf(ArrayDecoders.j(bArr, i4));
                return i4 + 8;
            case 8:
                registers.f33158c = Float.valueOf(ArrayDecoders.l(bArr, i4));
                return i4 + 4;
            case 9:
            case 10:
            case 11:
                int I = ArrayDecoders.I(bArr, i4, registers);
                registers.f33158c = Integer.valueOf(registers.f33156a);
                return I;
            case 12:
            case 13:
                int L2 = ArrayDecoders.L(bArr, i4, registers);
                registers.f33158c = Long.valueOf(registers.f33157b);
                return L2;
            case 14:
                return ArrayDecoders.p(Protobuf.a().c(cls), bArr, i4, i5, registers);
            case 15:
                int I2 = ArrayDecoders.I(bArr, i4, registers);
                registers.f33158c = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.f33156a));
                return I2;
            case 16:
                int L3 = ArrayDecoders.L(bArr, i4, registers);
                registers.f33158c = Long.valueOf(CodedInputStream.decodeZigZag64(registers.f33157b));
                return L3;
            case 17:
                return ArrayDecoders.F(bArr, i4, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private <E> void h0(Object obj, int i4, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.e(this.f33492n.e(obj, S(i4)), schema, extensionRegistryLite);
    }

    private static <T> double i(T t3, long j4) {
        return UnsafeUtil.B(t3, j4);
    }

    private void i0(Object obj, int i4, Reader reader) throws IOException {
        if (v(i4)) {
            UnsafeUtil.Y(obj, S(i4), reader.readStringRequireUtf8());
        } else if (this.f33485g) {
            UnsafeUtil.Y(obj, S(i4), reader.readString());
        } else {
            UnsafeUtil.Y(obj, S(i4), reader.readBytes());
        }
    }

    private boolean j(T t3, T t4, int i4) {
        int s02 = s0(i4);
        long S = S(s02);
        switch (r0(s02)) {
            case 0:
                if (!d(t3, t4, i4) || Double.doubleToLongBits(UnsafeUtil.B(t3, S)) != Double.doubleToLongBits(UnsafeUtil.B(t4, S))) {
                    return false;
                }
                return true;
            case 1:
                if (!d(t3, t4, i4) || Float.floatToIntBits(UnsafeUtil.C(t3, S)) != Float.floatToIntBits(UnsafeUtil.C(t4, S))) {
                    return false;
                }
                return true;
            case 2:
                if (!d(t3, t4, i4) || UnsafeUtil.F(t3, S) != UnsafeUtil.F(t4, S)) {
                    return false;
                }
                return true;
            case 3:
                if (!d(t3, t4, i4) || UnsafeUtil.F(t3, S) != UnsafeUtil.F(t4, S)) {
                    return false;
                }
                return true;
            case 4:
                if (!d(t3, t4, i4) || UnsafeUtil.D(t3, S) != UnsafeUtil.D(t4, S)) {
                    return false;
                }
                return true;
            case 5:
                if (!d(t3, t4, i4) || UnsafeUtil.F(t3, S) != UnsafeUtil.F(t4, S)) {
                    return false;
                }
                return true;
            case 6:
                if (!d(t3, t4, i4) || UnsafeUtil.D(t3, S) != UnsafeUtil.D(t4, S)) {
                    return false;
                }
                return true;
            case 7:
                if (!d(t3, t4, i4) || UnsafeUtil.u(t3, S) != UnsafeUtil.u(t4, S)) {
                    return false;
                }
                return true;
            case 8:
                if (!d(t3, t4, i4) || !SchemaUtil.K(UnsafeUtil.H(t3, S), UnsafeUtil.H(t4, S))) {
                    return false;
                }
                return true;
            case 9:
                if (!d(t3, t4, i4) || !SchemaUtil.K(UnsafeUtil.H(t3, S), UnsafeUtil.H(t4, S))) {
                    return false;
                }
                return true;
            case 10:
                if (!d(t3, t4, i4) || !SchemaUtil.K(UnsafeUtil.H(t3, S), UnsafeUtil.H(t4, S))) {
                    return false;
                }
                return true;
            case 11:
                if (!d(t3, t4, i4) || UnsafeUtil.D(t3, S) != UnsafeUtil.D(t4, S)) {
                    return false;
                }
                return true;
            case 12:
                if (!d(t3, t4, i4) || UnsafeUtil.D(t3, S) != UnsafeUtil.D(t4, S)) {
                    return false;
                }
                return true;
            case 13:
                if (!d(t3, t4, i4) || UnsafeUtil.D(t3, S) != UnsafeUtil.D(t4, S)) {
                    return false;
                }
                return true;
            case 14:
                if (!d(t3, t4, i4) || UnsafeUtil.F(t3, S) != UnsafeUtil.F(t4, S)) {
                    return false;
                }
                return true;
            case 15:
                if (!d(t3, t4, i4) || UnsafeUtil.D(t3, S) != UnsafeUtil.D(t4, S)) {
                    return false;
                }
                return true;
            case 16:
                if (!d(t3, t4, i4) || UnsafeUtil.F(t3, S) != UnsafeUtil.F(t4, S)) {
                    return false;
                }
                return true;
            case 17:
                if (!d(t3, t4, i4) || !SchemaUtil.K(UnsafeUtil.H(t3, S), UnsafeUtil.H(t4, S))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.K(UnsafeUtil.H(t3, S), UnsafeUtil.H(t4, S));
            case 50:
                return SchemaUtil.K(UnsafeUtil.H(t3, S), UnsafeUtil.H(t4, S));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!C(t3, t4, i4) || !SchemaUtil.K(UnsafeUtil.H(t3, S), UnsafeUtil.H(t4, S))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private void j0(Object obj, int i4, Reader reader) throws IOException {
        if (v(i4)) {
            reader.readStringListRequireUtf8(this.f33492n.e(obj, S(i4)));
        } else {
            reader.readStringList(this.f33492n.e(obj, S(i4)));
        }
    }

    private <UT, UB> UB k(Object obj, int i4, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        int R = R(i4);
        Object H = UnsafeUtil.H(obj, S(s0(i4)));
        if (H == null) {
            return ub;
        }
        Internal.EnumVerifier n4 = n(i4);
        if (n4 == null) {
            return ub;
        }
        return (UB) l(i4, R, this.f33495q.forMutableMapData(H), n4, ub, unknownFieldSchema, obj2);
    }

    private static java.lang.reflect.Field k0(Class<?> cls, String str) {
        java.lang.reflect.Field[] declaredFields;
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private <K, V, UT, UB> UB l(int i4, int i5, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.f33495q.forMapMetadata(o(i4));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.f(obj);
                }
                ByteString.CodedBuilder m4 = ByteString.m(MapEntryLite.a(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.e(m4.b(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.d(ub, i5, m4.a());
                    it.remove();
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            }
        }
        return ub;
    }

    private void l0(T t3, int i4) {
        int f02 = f0(i4);
        long j4 = 1048575 & f02;
        if (j4 == 1048575) {
            return;
        }
        UnsafeUtil.W(t3, j4, (1 << (f02 >>> 20)) | UnsafeUtil.D(t3, j4));
    }

    private static <T> float m(T t3, long j4) {
        return UnsafeUtil.C(t3, j4);
    }

    private void m0(T t3, int i4, int i5) {
        UnsafeUtil.W(t3, f0(i5) & 1048575, i4);
    }

    private Internal.EnumVerifier n(int i4) {
        return (Internal.EnumVerifier) this.f33480b[((i4 / 3) * 2) + 1];
    }

    private int n0(int i4, int i5) {
        int length = (this.f33479a.length / 3) - 1;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i7 = i6 * 3;
            int R = R(i7);
            if (i4 == R) {
                return i7;
            }
            if (i4 < R) {
                length = i6 - 1;
            } else {
                i5 = i6 + 1;
            }
        }
        return -1;
    }

    private Object o(int i4) {
        return this.f33480b[(i4 / 3) * 2];
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void o0(com.google.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            com.google.protobuf.OneofInfo r0 = r8.q()
            r1 = 0
            if (r0 == 0) goto L25
            com.google.protobuf.FieldType r2 = r8.t()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.b()
            long r3 = com.google.protobuf.UnsafeUtil.M(r3)
            int r4 = (int) r3
            java.lang.reflect.Field r0 = r0.a()
            long r5 = com.google.protobuf.UnsafeUtil.M(r0)
        L22:
            int r0 = (int) r5
        L23:
            r3 = 0
            goto L6b
        L25:
            com.google.protobuf.FieldType r0 = r8.t()
            java.lang.reflect.Field r2 = r8.m()
            long r2 = com.google.protobuf.UnsafeUtil.M(r2)
            int r4 = (int) r2
            int r2 = r0.id()
            boolean r3 = r0.isList()
            if (r3 != 0) goto L5a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L5a
            java.lang.reflect.Field r0 = r8.r()
            if (r0 != 0) goto L4c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L51
        L4c:
            long r5 = com.google.protobuf.UnsafeUtil.M(r0)
            int r0 = (int) r5
        L51:
            int r3 = r8.s()
            int r3 = java.lang.Integer.numberOfTrailingZeros(r3)
            goto L6b
        L5a:
            java.lang.reflect.Field r0 = r8.k()
            if (r0 != 0) goto L62
            r0 = 0
            goto L23
        L62:
            java.lang.reflect.Field r0 = r8.k()
            long r5 = com.google.protobuf.UnsafeUtil.M(r0)
            goto L22
        L6b:
            int r5 = r8.n()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.u()
            if (r6 == 0) goto L7c
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L7d
        L7c:
            r6 = 0
        L7d:
            boolean r7 = r8.w()
            if (r7 == 0) goto L85
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L85:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r4
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r3 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.p()
            java.lang.Object r0 = r8.o()
            if (r0 == 0) goto Lbd
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.o()
            r11[r10] = r0
            if (r9 == 0) goto Lae
            int r10 = r10 + 1
            r11[r10] = r9
            goto Lda
        Lae:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.l()
            if (r9 == 0) goto Lda
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.l()
            r11[r10] = r8
            goto Lda
        Lbd:
            if (r9 == 0) goto Lc8
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            goto Lda
        Lc8:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.l()
            if (r9 == 0) goto Lda
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.l()
            r11[r10] = r8
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.o0(com.google.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private Schema p(int i4) {
        int i5 = (i4 / 3) * 2;
        Schema schema = (Schema) this.f33480b[i5];
        if (schema != null) {
            return schema;
        }
        Schema<T> c4 = Protobuf.a().c((Class) this.f33480b[i5 + 1]);
        this.f33480b[i5] = c4;
        return c4;
    }

    private void p0(T t3, int i4, Object obj) {
        f33478s.putObject(t3, S(s0(i4)), obj);
        l0(t3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite q(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
            UnknownFieldSetLite g4 = UnknownFieldSetLite.g();
            generatedMessageLite.unknownFields = g4;
            return g4;
        }
        return unknownFieldSetLite;
    }

    private void q0(T t3, int i4, int i5, Object obj) {
        f33478s.putObject(t3, S(s0(i5)), obj);
        m0(t3, i4, i5);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int r(T t3) {
        int i4;
        int i5;
        int computeDoubleSize;
        int computeBoolSize;
        int computeSFixed32Size;
        int i6;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = f33478s;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        int i11 = 0;
        while (i8 < this.f33479a.length) {
            int s02 = s0(i8);
            int R = R(i8);
            int r02 = r0(s02);
            if (r02 <= 17) {
                i4 = this.f33479a[i8 + 2];
                int i12 = i4 & i7;
                i5 = 1 << (i4 >>> 20);
                if (i12 != i10) {
                    i11 = unsafe.getInt(t3, i12);
                    i10 = i12;
                }
            } else {
                if (this.f33487i && r02 >= FieldType.DOUBLE_LIST_PACKED.id() && r02 <= FieldType.SINT64_LIST_PACKED.id()) {
                    i4 = this.f33479a[i8 + 2] & i7;
                } else {
                    i4 = 0;
                }
                i5 = 0;
            }
            long S = S(s02);
            switch (r02) {
                case 0:
                    if ((i11 & i5) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(R, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i9 += computeDoubleSize;
                        break;
                    }
                case 1:
                    if ((i11 & i5) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(R, 0.0f);
                        i9 += computeDoubleSize;
                        break;
                    }
                case 2:
                    if ((i11 & i5) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(R, unsafe.getLong(t3, S));
                        i9 += computeDoubleSize;
                        break;
                    }
                case 3:
                    if ((i11 & i5) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(R, unsafe.getLong(t3, S));
                        i9 += computeDoubleSize;
                        break;
                    }
                case 4:
                    if ((i11 & i5) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(R, unsafe.getInt(t3, S));
                        i9 += computeDoubleSize;
                        break;
                    }
                case 5:
                    if ((i11 & i5) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(R, 0L);
                        i9 += computeDoubleSize;
                        break;
                    }
                case 6:
                    if ((i11 & i5) != 0) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(R, 0);
                        i9 += computeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(R, true);
                        i9 += computeBoolSize;
                    }
                    break;
                case 8:
                    if ((i11 & i5) != 0) {
                        Object object = unsafe.getObject(t3, S);
                        if (object instanceof ByteString) {
                            computeBoolSize = CodedOutputStream.computeBytesSize(R, (ByteString) object);
                        } else {
                            computeBoolSize = CodedOutputStream.computeStringSize(R, (String) object);
                        }
                        i9 += computeBoolSize;
                    }
                    break;
                case 9:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = SchemaUtil.o(R, unsafe.getObject(t3, S), p(i8));
                        i9 += computeBoolSize;
                    }
                    break;
                case 10:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(R, (ByteString) unsafe.getObject(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 11:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(R, unsafe.getInt(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 12:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(R, unsafe.getInt(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 13:
                    if ((i11 & i5) != 0) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(R, 0);
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 14:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(R, 0L);
                        i9 += computeBoolSize;
                    }
                    break;
                case 15:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(R, unsafe.getInt(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 16:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(R, unsafe.getLong(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 17:
                    if ((i11 & i5) != 0) {
                        computeBoolSize = CodedOutputStream.g(R, (MessageLite) unsafe.getObject(t3, S), p(i8));
                        i9 += computeBoolSize;
                    }
                    break;
                case 18:
                    computeBoolSize = SchemaUtil.h(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 19:
                    computeBoolSize = SchemaUtil.f(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 20:
                    computeBoolSize = SchemaUtil.m(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 21:
                    computeBoolSize = SchemaUtil.x(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 22:
                    computeBoolSize = SchemaUtil.k(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 23:
                    computeBoolSize = SchemaUtil.h(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 24:
                    computeBoolSize = SchemaUtil.f(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 25:
                    computeBoolSize = SchemaUtil.a(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 26:
                    computeBoolSize = SchemaUtil.u(R, (List) unsafe.getObject(t3, S));
                    i9 += computeBoolSize;
                    break;
                case 27:
                    computeBoolSize = SchemaUtil.p(R, (List) unsafe.getObject(t3, S), p(i8));
                    i9 += computeBoolSize;
                    break;
                case 28:
                    computeBoolSize = SchemaUtil.c(R, (List) unsafe.getObject(t3, S));
                    i9 += computeBoolSize;
                    break;
                case 29:
                    computeBoolSize = SchemaUtil.v(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 30:
                    computeBoolSize = SchemaUtil.d(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 31:
                    computeBoolSize = SchemaUtil.f(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 32:
                    computeBoolSize = SchemaUtil.h(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 33:
                    computeBoolSize = SchemaUtil.q(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 34:
                    computeBoolSize = SchemaUtil.s(R, (List) unsafe.getObject(t3, S), false);
                    i9 += computeBoolSize;
                    break;
                case 35:
                    i6 = SchemaUtil.i((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 36:
                    i6 = SchemaUtil.g((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 37:
                    i6 = SchemaUtil.n((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 38:
                    i6 = SchemaUtil.y((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 39:
                    i6 = SchemaUtil.l((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 40:
                    i6 = SchemaUtil.i((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 41:
                    i6 = SchemaUtil.g((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 42:
                    i6 = SchemaUtil.b((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 43:
                    i6 = SchemaUtil.w((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 44:
                    i6 = SchemaUtil.e((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 45:
                    i6 = SchemaUtil.g((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 46:
                    i6 = SchemaUtil.i((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 47:
                    i6 = SchemaUtil.r((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 48:
                    i6 = SchemaUtil.t((List) unsafe.getObject(t3, S));
                    if (i6 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i6);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i6);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i6;
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 49:
                    computeBoolSize = SchemaUtil.j(R, (List) unsafe.getObject(t3, S), p(i8));
                    i9 += computeBoolSize;
                    break;
                case 50:
                    computeBoolSize = this.f33495q.getSerializedSize(R, unsafe.getObject(t3, S), o(i8));
                    i9 += computeBoolSize;
                    break;
                case 51:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeDoubleSize(R, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i9 += computeBoolSize;
                    }
                    break;
                case 52:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeFloatSize(R, 0.0f);
                        i9 += computeBoolSize;
                    }
                    break;
                case 53:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeInt64Size(R, X(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 54:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeUInt64Size(R, X(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 55:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeInt32Size(R, W(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 56:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeFixed64Size(R, 0L);
                        i9 += computeBoolSize;
                    }
                    break;
                case 57:
                    if (D(t3, R, i8)) {
                        computeSFixed32Size = CodedOutputStream.computeFixed32Size(R, 0);
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 58:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(R, true);
                        i9 += computeBoolSize;
                    }
                    break;
                case 59:
                    if (D(t3, R, i8)) {
                        Object object2 = unsafe.getObject(t3, S);
                        if (object2 instanceof ByteString) {
                            computeBoolSize = CodedOutputStream.computeBytesSize(R, (ByteString) object2);
                        } else {
                            computeBoolSize = CodedOutputStream.computeStringSize(R, (String) object2);
                        }
                        i9 += computeBoolSize;
                    }
                    break;
                case 60:
                    if (D(t3, R, i8)) {
                        computeBoolSize = SchemaUtil.o(R, unsafe.getObject(t3, S), p(i8));
                        i9 += computeBoolSize;
                    }
                    break;
                case 61:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(R, (ByteString) unsafe.getObject(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 62:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(R, W(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 63:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(R, W(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 64:
                    if (D(t3, R, i8)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(R, 0);
                        i9 += computeSFixed32Size;
                    }
                    break;
                case 65:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(R, 0L);
                        i9 += computeBoolSize;
                    }
                    break;
                case 66:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(R, W(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 67:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(R, X(t3, S));
                        i9 += computeBoolSize;
                    }
                    break;
                case 68:
                    if (D(t3, R, i8)) {
                        computeBoolSize = CodedOutputStream.g(R, (MessageLite) unsafe.getObject(t3, S), p(i8));
                        i9 += computeBoolSize;
                    }
                    break;
            }
            i8 += 3;
            i7 = 1048575;
        }
        int t4 = i9 + t(this.f33493o, t3);
        if (this.f33484f) {
            return t4 + this.f33494p.c(t3).o();
        }
        return t4;
    }

    private static int r0(int i4) {
        return (i4 & 267386880) >>> 20;
    }

    private int s(T t3) {
        int i4;
        int computeDoubleSize;
        int i5;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = f33478s;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f33479a.length; i7 += 3) {
            int s02 = s0(i7);
            int r02 = r0(s02);
            int R = R(i7);
            long S = S(s02);
            if (r02 >= FieldType.DOUBLE_LIST_PACKED.id() && r02 <= FieldType.SINT64_LIST_PACKED.id()) {
                i4 = this.f33479a[i7 + 2] & 1048575;
            } else {
                i4 = 0;
            }
            switch (r02) {
                case 0:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(R, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(R, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(R, UnsafeUtil.F(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(R, UnsafeUtil.F(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(R, UnsafeUtil.D(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(R, true);
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (w(t3, i7)) {
                        Object H = UnsafeUtil.H(t3, S);
                        if (H instanceof ByteString) {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(R, (ByteString) H);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeStringSize(R, (String) H);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if (w(t3, i7)) {
                        computeDoubleSize = SchemaUtil.o(R, UnsafeUtil.H(t3, S), p(i7));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(R, (ByteString) UnsafeUtil.H(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 11:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(R, UnsafeUtil.D(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 12:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(R, UnsafeUtil.D(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(R, UnsafeUtil.D(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(R, UnsafeUtil.F(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if (w(t3, i7)) {
                        computeDoubleSize = CodedOutputStream.g(R, (MessageLite) UnsafeUtil.H(t3, S), p(i7));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    computeDoubleSize = SchemaUtil.h(R, F(t3, S), false);
                    break;
                case 19:
                    computeDoubleSize = SchemaUtil.f(R, F(t3, S), false);
                    break;
                case 20:
                    computeDoubleSize = SchemaUtil.m(R, F(t3, S), false);
                    break;
                case 21:
                    computeDoubleSize = SchemaUtil.x(R, F(t3, S), false);
                    break;
                case 22:
                    computeDoubleSize = SchemaUtil.k(R, F(t3, S), false);
                    break;
                case 23:
                    computeDoubleSize = SchemaUtil.h(R, F(t3, S), false);
                    break;
                case 24:
                    computeDoubleSize = SchemaUtil.f(R, F(t3, S), false);
                    break;
                case 25:
                    computeDoubleSize = SchemaUtil.a(R, F(t3, S), false);
                    break;
                case 26:
                    computeDoubleSize = SchemaUtil.u(R, F(t3, S));
                    break;
                case 27:
                    computeDoubleSize = SchemaUtil.p(R, F(t3, S), p(i7));
                    break;
                case 28:
                    computeDoubleSize = SchemaUtil.c(R, F(t3, S));
                    break;
                case 29:
                    computeDoubleSize = SchemaUtil.v(R, F(t3, S), false);
                    break;
                case 30:
                    computeDoubleSize = SchemaUtil.d(R, F(t3, S), false);
                    break;
                case 31:
                    computeDoubleSize = SchemaUtil.f(R, F(t3, S), false);
                    break;
                case 32:
                    computeDoubleSize = SchemaUtil.h(R, F(t3, S), false);
                    break;
                case 33:
                    computeDoubleSize = SchemaUtil.q(R, F(t3, S), false);
                    break;
                case 34:
                    computeDoubleSize = SchemaUtil.s(R, F(t3, S), false);
                    break;
                case 35:
                    i5 = SchemaUtil.i((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 36:
                    i5 = SchemaUtil.g((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 37:
                    i5 = SchemaUtil.n((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 38:
                    i5 = SchemaUtil.y((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 39:
                    i5 = SchemaUtil.l((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 40:
                    i5 = SchemaUtil.i((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 41:
                    i5 = SchemaUtil.g((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 42:
                    i5 = SchemaUtil.b((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 43:
                    i5 = SchemaUtil.w((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 44:
                    i5 = SchemaUtil.e((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 45:
                    i5 = SchemaUtil.g((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 46:
                    i5 = SchemaUtil.i((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 47:
                    i5 = SchemaUtil.r((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 48:
                    i5 = SchemaUtil.t((List) unsafe.getObject(t3, S));
                    if (i5 > 0) {
                        if (this.f33487i) {
                            unsafe.putInt(t3, i4, i5);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(R);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i5);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i5;
                        break;
                    } else {
                        continue;
                    }
                case 49:
                    computeDoubleSize = SchemaUtil.j(R, F(t3, S), p(i7));
                    break;
                case 50:
                    computeDoubleSize = this.f33495q.getSerializedSize(R, UnsafeUtil.H(t3, S), o(i7));
                    break;
                case 51:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(R, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(R, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(R, X(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(R, X(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(R, W(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 56:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(R, true);
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (D(t3, R, i7)) {
                        Object H2 = UnsafeUtil.H(t3, S);
                        if (H2 instanceof ByteString) {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(R, (ByteString) H2);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeStringSize(R, (String) H2);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = SchemaUtil.o(R, UnsafeUtil.H(t3, S), p(i7));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(R, (ByteString) UnsafeUtil.H(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 62:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(R, W(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 63:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(R, W(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 64:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(R, W(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 67:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(R, X(t3, S));
                        break;
                    } else {
                        continue;
                    }
                case 68:
                    if (D(t3, R, i7)) {
                        computeDoubleSize = CodedOutputStream.g(R, (MessageLite) UnsafeUtil.H(t3, S), p(i7));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i6 += computeDoubleSize;
        }
        return i6 + t(this.f33493o, t3);
    }

    private int s0(int i4) {
        return this.f33479a[i4 + 1];
    }

    private <UT, UB> int t(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3) {
        return unknownFieldSchema.h(unknownFieldSchema.g(t3));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0491  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t0(T r18, com.google.protobuf.Writer r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.t0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private static <T> int u(T t3, long j4) {
        return UnsafeUtil.D(t3, j4);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0588  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void u0(T r13, com.google.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.u0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private static boolean v(int i4) {
        if ((i4 & 536870912) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x058e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v0(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.v0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private boolean w(T t3, int i4) {
        int f02 = f0(i4);
        long j4 = 1048575 & f02;
        if (j4 == 1048575) {
            int s02 = s0(i4);
            long S = S(s02);
            switch (r0(s02)) {
                case 0:
                    if (Double.doubleToRawLongBits(UnsafeUtil.B(t3, S)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(UnsafeUtil.C(t3, S)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (UnsafeUtil.F(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (UnsafeUtil.F(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (UnsafeUtil.D(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (UnsafeUtil.F(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (UnsafeUtil.D(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return UnsafeUtil.u(t3, S);
                case 8:
                    Object H = UnsafeUtil.H(t3, S);
                    if (H instanceof String) {
                        return !((String) H).isEmpty();
                    }
                    if (H instanceof ByteString) {
                        return !ByteString.EMPTY.equals(H);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.H(t3, S) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.H(t3, S));
                case 11:
                    if (UnsafeUtil.D(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (UnsafeUtil.D(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (UnsafeUtil.D(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (UnsafeUtil.F(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (UnsafeUtil.D(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (UnsafeUtil.F(t3, S) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (UnsafeUtil.H(t3, S) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((UnsafeUtil.D(t3, j4) & (1 << (f02 >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private <K, V> void w0(Writer writer, int i4, Object obj, int i5) throws IOException {
        if (obj != null) {
            writer.a(i4, this.f33495q.forMapMetadata(o(i5)), this.f33495q.forMapData(obj));
        }
    }

    private boolean x(T t3, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return w(t3, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private void x0(int i4, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i4, (String) obj);
        } else {
            writer.writeBytes(i4, (ByteString) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean y(Object obj, int i4, Schema schema) {
        return schema.isInitialized(UnsafeUtil.H(obj, S(i4)));
    }

    private <UT, UB> void y0(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3, Writer writer) throws IOException {
        unknownFieldSchema.t(unknownFieldSchema.g(t3), writer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean z(Object obj, int i4, int i5) {
        List list = (List) UnsafeUtil.H(obj, S(i4));
        if (list.isEmpty()) {
            return true;
        }
        Schema p4 = p(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (!p4.isInitialized(list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public void a(T t3, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            v0(t3, writer);
        } else if (this.f33486h) {
            u0(t3, writer);
        } else {
            t0(t3, writer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int a0(T t3, byte[] bArr, int i4, int i5, int i6, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i7;
        MessageSchema<T> messageSchema;
        int i8;
        int i9;
        int i10;
        int i11;
        T t4;
        byte b4;
        int d02;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        byte[] bArr2;
        int L;
        int i22;
        int i23;
        MessageSchema<T> messageSchema2 = this;
        T t5 = t3;
        byte[] bArr3 = bArr;
        int i24 = i5;
        int i25 = i6;
        ArrayDecoders.Registers registers2 = registers;
        f(t3);
        Unsafe unsafe2 = f33478s;
        int i26 = i4;
        int i27 = -1;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 1048575;
        while (true) {
            if (i26 < i24) {
                int i32 = i26 + 1;
                byte b5 = bArr3[i26];
                if (b5 < 0) {
                    int H = ArrayDecoders.H(b5, bArr3, i32, registers2);
                    b4 = registers2.f33156a;
                    i32 = H;
                } else {
                    b4 = b5;
                }
                int i33 = b4 >>> 3;
                int i34 = b4 & 7;
                if (i33 > i27) {
                    d02 = messageSchema2.e0(i33, i28 / 3);
                } else {
                    d02 = messageSchema2.d0(i33);
                }
                int i35 = d02;
                if (i35 == -1) {
                    i12 = i33;
                    i13 = i32;
                    i9 = b4;
                    i14 = i30;
                    i15 = i31;
                    unsafe = unsafe2;
                    i7 = i25;
                    i16 = 0;
                } else {
                    int i36 = messageSchema2.f33479a[i35 + 1];
                    int r02 = r0(i36);
                    long S = S(i36);
                    int i37 = b4;
                    if (r02 <= 17) {
                        int i38 = messageSchema2.f33479a[i35 + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = i38 & 1048575;
                        if (i40 != i31) {
                            if (i31 != 1048575) {
                                unsafe2.putInt(t5, i31, i30);
                            }
                            i18 = i40;
                            i17 = unsafe2.getInt(t5, i40);
                        } else {
                            i17 = i30;
                            i18 = i31;
                        }
                        switch (r02) {
                            case 0:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 1) {
                                    UnsafeUtil.U(t5, S, ArrayDecoders.d(bArr2, i32));
                                    i26 = i32 + 8;
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 1:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 5) {
                                    UnsafeUtil.V(t5, S, ArrayDecoders.l(bArr2, i32));
                                    i26 = i32 + 4;
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 2:
                            case 3:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 0) {
                                    L = ArrayDecoders.L(bArr2, i32, registers2);
                                    unsafe2.putLong(t3, S, registers2.f33157b);
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i26 = L;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.I(bArr2, i32, registers2);
                                    unsafe2.putInt(t5, S, registers2.f33156a);
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 1) {
                                    unsafe2.putLong(t3, S, ArrayDecoders.j(bArr2, i32));
                                    i26 = i32 + 8;
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 5) {
                                    unsafe2.putInt(t5, S, ArrayDecoders.h(bArr2, i32));
                                    i26 = i32 + 4;
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 7:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.L(bArr2, i32, registers2);
                                    UnsafeUtil.N(t5, S, registers2.f33157b != 0);
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 8:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 2) {
                                    if ((536870912 & i36) == 0) {
                                        i26 = ArrayDecoders.C(bArr2, i32, registers2);
                                    } else {
                                        i26 = ArrayDecoders.F(bArr2, i32, registers2);
                                    }
                                    unsafe2.putObject(t5, S, registers2.f33158c);
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 9:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 2) {
                                    Object M = messageSchema2.M(t5, i21);
                                    i26 = ArrayDecoders.O(M, messageSchema2.p(i21), bArr, i32, i5, registers);
                                    messageSchema2.p0(t5, i21, M);
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 10:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 2) {
                                    i26 = ArrayDecoders.b(bArr2, i32, registers2);
                                    unsafe2.putObject(t5, S, registers2.f33158c);
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 12:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.I(bArr2, i32, registers2);
                                    int i41 = registers2.f33156a;
                                    Internal.EnumVerifier n4 = messageSchema2.n(i21);
                                    if (n4 != null && !n4.isInRange(i41)) {
                                        q(t3).j(i20, Long.valueOf(i41));
                                        i28 = i21;
                                        i30 = i17;
                                        i29 = i20;
                                        i27 = i12;
                                        i31 = i19;
                                        i25 = i6;
                                        bArr3 = bArr2;
                                    } else {
                                        unsafe2.putInt(t5, S, i41);
                                        i30 = i17 | i39;
                                        i25 = i6;
                                        i28 = i21;
                                        i29 = i20;
                                        i27 = i12;
                                        i31 = i19;
                                        bArr3 = bArr2;
                                        break;
                                    }
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.I(bArr2, i32, registers2);
                                    unsafe2.putInt(t5, S, CodedInputStream.decodeZigZag32(registers2.f33156a));
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 16:
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 0) {
                                    L = ArrayDecoders.L(bArr2, i32, registers2);
                                    unsafe2.putLong(t3, S, CodedInputStream.decodeZigZag64(registers2.f33157b));
                                    i30 = i17 | i39;
                                    i25 = i6;
                                    i28 = i21;
                                    i26 = L;
                                    i29 = i20;
                                    i27 = i12;
                                    i31 = i19;
                                    bArr3 = bArr2;
                                    break;
                                } else {
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            case 17:
                                if (i34 == 3) {
                                    Object M2 = messageSchema2.M(t5, i35);
                                    i26 = ArrayDecoders.N(M2, messageSchema2.p(i35), bArr, i32, i5, (i33 << 3) | 4, registers);
                                    messageSchema2.p0(t5, i35, M2);
                                    i30 = i17 | i39;
                                    i31 = i18;
                                    i25 = i6;
                                    i28 = i35;
                                    i29 = i37;
                                    i27 = i33;
                                    bArr3 = bArr;
                                    break;
                                } else {
                                    i12 = i33;
                                    i19 = i18;
                                    i20 = i37;
                                    i21 = i35;
                                    i15 = i19;
                                    i7 = i6;
                                    i13 = i32;
                                    i16 = i21;
                                    unsafe = unsafe2;
                                    i14 = i17;
                                    i9 = i20;
                                    break;
                                }
                            default:
                                i12 = i33;
                                i21 = i35;
                                i19 = i18;
                                i20 = i37;
                                i15 = i19;
                                i7 = i6;
                                i13 = i32;
                                i16 = i21;
                                unsafe = unsafe2;
                                i14 = i17;
                                i9 = i20;
                                break;
                        }
                    } else {
                        i12 = i33;
                        i15 = i31;
                        i14 = i30;
                        if (r02 == 27) {
                            if (i34 == 2) {
                                Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t5, S);
                                if (!protobufList.isModifiable()) {
                                    int size = protobufList.size();
                                    protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                                    unsafe2.putObject(t5, S, protobufList);
                                }
                                i26 = ArrayDecoders.q(messageSchema2.p(i35), i37, bArr, i32, i5, protobufList, registers);
                                i28 = i35;
                                i29 = i37;
                                i31 = i15;
                                i30 = i14;
                                i27 = i12;
                                bArr3 = bArr;
                                i25 = i6;
                            } else {
                                i22 = i32;
                                unsafe = unsafe2;
                                i16 = i35;
                                i23 = i37;
                                i7 = i6;
                                i13 = i22;
                            }
                        } else if (r02 <= 49) {
                            int i42 = i32;
                            unsafe = unsafe2;
                            i16 = i35;
                            i23 = i37;
                            i26 = c0(t3, bArr, i32, i5, i37, i12, i34, i35, i36, r02, S, registers);
                            if (i26 != i42) {
                                messageSchema2 = this;
                                t5 = t3;
                                bArr3 = bArr;
                                i24 = i5;
                                i25 = i6;
                                registers2 = registers;
                                i31 = i15;
                                i30 = i14;
                                i28 = i16;
                                i29 = i23;
                                i27 = i12;
                                unsafe2 = unsafe;
                            } else {
                                i7 = i6;
                                i13 = i26;
                            }
                        } else {
                            i22 = i32;
                            unsafe = unsafe2;
                            i16 = i35;
                            i23 = i37;
                            if (r02 != 50) {
                                i26 = Z(t3, bArr, i22, i5, i23, i12, i34, i36, r02, S, i16, registers);
                                if (i26 != i22) {
                                    messageSchema2 = this;
                                    t5 = t3;
                                    bArr3 = bArr;
                                    i24 = i5;
                                    i25 = i6;
                                    registers2 = registers;
                                    i31 = i15;
                                    i30 = i14;
                                    i28 = i16;
                                    i29 = i23;
                                    i27 = i12;
                                    unsafe2 = unsafe;
                                } else {
                                    i7 = i6;
                                    i13 = i26;
                                }
                            } else if (i34 == 2) {
                                i26 = Y(t3, bArr, i22, i5, i16, S, registers);
                                if (i26 != i22) {
                                    messageSchema2 = this;
                                    t5 = t3;
                                    bArr3 = bArr;
                                    i24 = i5;
                                    i25 = i6;
                                    registers2 = registers;
                                    i31 = i15;
                                    i30 = i14;
                                    i28 = i16;
                                    i29 = i23;
                                    i27 = i12;
                                    unsafe2 = unsafe;
                                } else {
                                    i7 = i6;
                                    i13 = i26;
                                }
                            } else {
                                i7 = i6;
                                i13 = i22;
                            }
                        }
                        i9 = i23;
                    }
                }
                if (i9 != i7 || i7 == 0) {
                    if (this.f33484f && registers.f33159d != ExtensionRegistryLite.getEmptyRegistry()) {
                        i26 = ArrayDecoders.g(i9, bArr, i13, i5, t3, this.f33483e, this.f33493o, registers);
                    } else {
                        i26 = ArrayDecoders.G(i9, bArr, i13, i5, q(t3), registers);
                    }
                    t5 = t3;
                    bArr3 = bArr;
                    i24 = i5;
                    i29 = i9;
                    messageSchema2 = this;
                    registers2 = registers;
                    i31 = i15;
                    i30 = i14;
                    i28 = i16;
                    i27 = i12;
                    unsafe2 = unsafe;
                    i25 = i7;
                } else {
                    i11 = 1048575;
                    messageSchema = this;
                    i8 = i13;
                    i10 = i15;
                    i30 = i14;
                }
            } else {
                int i43 = i31;
                unsafe = unsafe2;
                i7 = i25;
                messageSchema = messageSchema2;
                i8 = i26;
                i9 = i29;
                i10 = i43;
                i11 = 1048575;
            }
        }
        if (i10 != i11) {
            t4 = t3;
            unsafe.putInt(t4, i10, i30);
        } else {
            t4 = t3;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i44 = messageSchema.f33489k; i44 < messageSchema.f33490l; i44++) {
            unknownFieldSetLite = (UnknownFieldSetLite) k(t3, messageSchema.f33488j[i44], unknownFieldSetLite, messageSchema.f33493o, t3);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.f33493o.o(t4, unknownFieldSetLite);
        }
        if (i7 == 0) {
            if (i8 != i5) {
                throw InvalidProtocolBufferException.i();
            }
        } else if (i8 > i5 || i9 != i7) {
            throw InvalidProtocolBufferException.i();
        }
        return i8;
    }

    @Override // com.google.protobuf.Schema
    public void b(T t3, byte[] bArr, int i4, int i5, ArrayDecoders.Registers registers) throws IOException {
        if (this.f33486h) {
            b0(t3, bArr, i4, i5, registers);
        } else {
            a0(t3, bArr, i4, i5, 0, registers);
        }
    }

    @Override // com.google.protobuf.Schema
    public void c(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        f(t3);
        H(this.f33493o, this.f33494p, t3, reader, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t3, T t4) {
        int length = this.f33479a.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            if (!j(t3, t4, i4)) {
                return false;
            }
        }
        if (!this.f33493o.g(t3).equals(this.f33493o.g(t4))) {
            return false;
        }
        if (this.f33484f) {
            return this.f33494p.c(t3).equals(this.f33494p.c(t4));
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t3) {
        if (this.f33486h) {
            return s(t3);
        }
        return r(t3);
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t3) {
        int i4;
        int hashLong;
        int length = this.f33479a.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int s02 = s0(i6);
            int R = R(i6);
            long S = S(s02);
            int i7 = 37;
            switch (r0(s02)) {
                case 0:
                    i4 = i5 * 53;
                    hashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.B(t3, S)));
                    i5 = i4 + hashLong;
                    break;
                case 1:
                    i4 = i5 * 53;
                    hashLong = Float.floatToIntBits(UnsafeUtil.C(t3, S));
                    i5 = i4 + hashLong;
                    break;
                case 2:
                    i4 = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.F(t3, S));
                    i5 = i4 + hashLong;
                    break;
                case 3:
                    i4 = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.F(t3, S));
                    i5 = i4 + hashLong;
                    break;
                case 4:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.D(t3, S);
                    i5 = i4 + hashLong;
                    break;
                case 5:
                    i4 = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.F(t3, S));
                    i5 = i4 + hashLong;
                    break;
                case 6:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.D(t3, S);
                    i5 = i4 + hashLong;
                    break;
                case 7:
                    i4 = i5 * 53;
                    hashLong = Internal.hashBoolean(UnsafeUtil.u(t3, S));
                    i5 = i4 + hashLong;
                    break;
                case 8:
                    i4 = i5 * 53;
                    hashLong = ((String) UnsafeUtil.H(t3, S)).hashCode();
                    i5 = i4 + hashLong;
                    break;
                case 9:
                    Object H = UnsafeUtil.H(t3, S);
                    if (H != null) {
                        i7 = H.hashCode();
                    }
                    i5 = (i5 * 53) + i7;
                    break;
                case 10:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.H(t3, S).hashCode();
                    i5 = i4 + hashLong;
                    break;
                case 11:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.D(t3, S);
                    i5 = i4 + hashLong;
                    break;
                case 12:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.D(t3, S);
                    i5 = i4 + hashLong;
                    break;
                case 13:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.D(t3, S);
                    i5 = i4 + hashLong;
                    break;
                case 14:
                    i4 = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.F(t3, S));
                    i5 = i4 + hashLong;
                    break;
                case 15:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.D(t3, S);
                    i5 = i4 + hashLong;
                    break;
                case 16:
                    i4 = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.F(t3, S));
                    i5 = i4 + hashLong;
                    break;
                case 17:
                    Object H2 = UnsafeUtil.H(t3, S);
                    if (H2 != null) {
                        i7 = H2.hashCode();
                    }
                    i5 = (i5 * 53) + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.H(t3, S).hashCode();
                    i5 = i4 + hashLong;
                    break;
                case 50:
                    i4 = i5 * 53;
                    hashLong = UnsafeUtil.H(t3, S).hashCode();
                    i5 = i4 + hashLong;
                    break;
                case 51:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Internal.hashLong(Double.doubleToLongBits(U(t3, S)));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Float.floatToIntBits(V(t3, S));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Internal.hashLong(X(t3, S));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Internal.hashLong(X(t3, S));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = W(t3, S);
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Internal.hashLong(X(t3, S));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = W(t3, S);
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Internal.hashBoolean(T(t3, S));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = ((String) UnsafeUtil.H(t3, S)).hashCode();
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = UnsafeUtil.H(t3, S).hashCode();
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = UnsafeUtil.H(t3, S).hashCode();
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = W(t3, S);
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = W(t3, S);
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = W(t3, S);
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Internal.hashLong(X(t3, S));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = W(t3, S);
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = Internal.hashLong(X(t3, S));
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (D(t3, R, i6)) {
                        i4 = i5 * 53;
                        hashLong = UnsafeUtil.H(t3, S).hashCode();
                        i5 = i4 + hashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i5 * 53) + this.f33493o.g(t3).hashCode();
        if (this.f33484f) {
            return (hashCode * 53) + this.f33494p.c(t3).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t3) {
        int i4;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.f33489k) {
            int i9 = this.f33488j[i8];
            int R = R(i9);
            int s02 = s0(i9);
            int i10 = this.f33479a[i9 + 2];
            int i11 = i10 & 1048575;
            int i12 = 1 << (i10 >>> 20);
            if (i11 != i6) {
                if (i11 != 1048575) {
                    i7 = f33478s.getInt(t3, i11);
                }
                i5 = i7;
                i4 = i11;
            } else {
                i4 = i6;
                i5 = i7;
            }
            if (E(s02) && !x(t3, i9, i4, i5, i12)) {
                return false;
            }
            int r02 = r0(s02);
            if (r02 != 9 && r02 != 17) {
                if (r02 != 27) {
                    if (r02 != 60 && r02 != 68) {
                        if (r02 != 49) {
                            if (r02 == 50 && !A(t3, s02, i9)) {
                                return false;
                            }
                        }
                    } else if (D(t3, R, i9) && !y(t3, s02, p(i9))) {
                        return false;
                    }
                }
                if (!z(t3, s02, i9)) {
                    return false;
                }
            } else if (x(t3, i9, i4, i5, i12) && !y(t3, s02, p(i9))) {
                return false;
            }
            i8++;
            i6 = i4;
            i7 = i5;
        }
        if (this.f33484f && !this.f33494p.c(t3).t()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t3) {
        if (!B(t3)) {
            return;
        }
        if (t3 instanceof GeneratedMessageLite) {
            GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t3;
            generatedMessageLite.n();
            generatedMessageLite.m();
            generatedMessageLite.G();
        }
        int length = this.f33479a.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int s02 = s0(i4);
            long S = S(s02);
            int r02 = r0(s02);
            if (r02 != 9) {
                switch (r02) {
                    case 17:
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.f33492n.c(t3, S);
                        continue;
                    case 50:
                        Unsafe unsafe = f33478s;
                        Object object = unsafe.getObject(t3, S);
                        if (object != null) {
                            unsafe.putObject(t3, S, this.f33495q.toImmutable(object));
                        } else {
                            continue;
                        }
                    default:
                }
            }
            if (w(t3, i4)) {
                p(i4).makeImmutable(f33478s.getObject(t3, S));
            }
        }
        this.f33493o.j(t3);
        if (this.f33484f) {
            this.f33494p.f(t3);
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t3, T t4) {
        f(t3);
        t4.getClass();
        for (int i4 = 0; i4 < this.f33479a.length; i4 += 3) {
            L(t3, t4, i4);
        }
        SchemaUtil.G(this.f33493o, t3, t4);
        if (this.f33484f) {
            SchemaUtil.E(this.f33494p, t3, t4);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.f33491m.newInstance(this.f33483e);
    }
}
