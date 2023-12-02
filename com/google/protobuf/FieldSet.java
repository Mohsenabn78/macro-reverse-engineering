package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final FieldSet f33373d = new FieldSet(true);

    /* renamed from: a  reason: collision with root package name */
    private final SmallSortedMap<T, Object> f33374a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f33375b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33376c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.FieldSet$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33377a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33378b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33378b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33378b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33378b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33378b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33378b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33378b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33378b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33378b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33378b[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33378b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33378b[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33378b[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33378b[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33378b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f33378b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f33378b[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f33378b[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f33378b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f33377a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f33377a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f33377a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f33377a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f33377a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f33377a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f33377a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f33377a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f33377a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class Builder<T extends FieldDescriptorLite<T>> {

        /* renamed from: a  reason: collision with root package name */
        private SmallSortedMap<T, Object> f33379a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f33380b;

        private Builder() {
            this(SmallSortedMap.r(16));
        }

        private Builder(SmallSortedMap<T, Object> smallSortedMap) {
            this.f33379a = smallSortedMap;
            this.f33380b = true;
        }
    }

    /* loaded from: classes6.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
        this.f33374a = SmallSortedMap.r(16);
    }

    private void A(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (key.isRepeated()) {
            Object j4 = j(key);
            if (j4 == null) {
                j4 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) j4).add(d(obj));
            }
            this.f33374a.put(key, j4);
        } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object j5 = j(key);
            if (j5 == null) {
                this.f33374a.put(key, d(value));
                return;
            }
            this.f33374a.put(key, key.internalMergeFrom(((MessageLite) j5).toBuilder(), (MessageLite) value).build());
        } else {
            this.f33374a.put(key, d(value));
        }
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> B() {
        return new FieldSet<>();
    }

    public static Object C(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z3) throws IOException {
        if (z3) {
            return WireFormat.b(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT);
        }
        return WireFormat.b(codedInputStream, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    private void F(T t3, Object obj) {
        if (w(t3.getLiteType(), obj)) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t3.getNumber()), t3.getLiteType().getJavaType(), obj.getClass().getName()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void G(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i4, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i4, (MessageLite) obj);
            return;
        }
        codedOutputStream.writeTag(i4, p(fieldType, false));
        H(codedOutputStream, fieldType, obj);
    }

    static void H(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.f33378b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeStringNoTag((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void I(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(number, 2);
                int i4 = 0;
                for (Object obj2 : list) {
                    i4 += f(liteType, obj2);
                }
                codedOutputStream.writeUInt32NoTag(i4);
                for (Object obj3 : list) {
                    H(codedOutputStream, liteType, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                G(codedOutputStream, liteType, number, obj4);
            }
        } else if (obj instanceof LazyField) {
            G(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
        } else {
            G(codedOutputStream, liteType, number, obj);
        }
    }

    private static Object d(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(WireFormat.FieldType fieldType, int i4, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i4);
        if (fieldType == WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + f(fieldType, obj);
    }

    static int f(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f33378b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int g(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            int i4 = 0;
            if (fieldDescriptorLite.isPacked()) {
                for (Object obj2 : (List) obj) {
                    i4 += f(liteType, obj2);
                }
                return CodedOutputStream.computeTagSize(number) + i4 + CodedOutputStream.computeUInt32SizeNoTag(i4);
            }
            for (Object obj3 : (List) obj) {
                i4 += e(liteType, number, obj3);
            }
            return i4;
        }
        return e(liteType, number, obj);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> i() {
        return f33373d;
    }

    private int l(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            if (value instanceof LazyField) {
                return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value);
            }
            return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
        }
        return g(key, value);
    }

    static int p(WireFormat.FieldType fieldType, boolean z3) {
        if (z3) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private static <T extends FieldDescriptorLite<T>> boolean u(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                for (Object obj : (List) entry.getValue()) {
                    if (!v(obj)) {
                        return false;
                    }
                }
                return true;
            }
            return v(entry.getValue());
        }
        return true;
    }

    private static boolean v(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean w(WireFormat.FieldType fieldType, Object obj) {
        Internal.a(obj);
        switch (AnonymousClass1.f33377a[fieldType.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                    return true;
                }
                return false;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public void D(T t3, Object obj) {
        if (t3.isRepeated()) {
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    F(t3, obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            F(t3, obj);
        }
        if (obj instanceof LazyField) {
            this.f33376c = true;
        }
        this.f33374a.put(t3, obj);
    }

    public void E(T t3, int i4, Object obj) {
        if (t3.isRepeated()) {
            Object j4 = j(t3);
            if (j4 != null) {
                F(t3, obj);
                ((List) j4).set(i4, obj);
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void a(T t3, Object obj) {
        List list;
        if (t3.isRepeated()) {
            F(t3, obj);
            Object j4 = j(t3);
            if (j4 == null) {
                list = new ArrayList();
                this.f33374a.put(t3, list);
            } else {
                list = (List) j4;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void b(T t3) {
        this.f33374a.remove(t3);
        if (this.f33374a.isEmpty()) {
            this.f33376c = false;
        }
    }

    /* renamed from: c */
    public FieldSet<T> clone() {
        FieldSet<T> B = B();
        for (int i4 = 0; i4 < this.f33374a.l(); i4++) {
            Map.Entry<T, Object> k4 = this.f33374a.k(i4);
            B.D(k4.getKey(), k4.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f33374a.n()) {
            B.D(entry.getKey(), entry.getValue());
        }
        B.f33376c = this.f33376c;
        return B;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.f33374a.equals(((FieldSet) obj).f33374a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> h() {
        if (this.f33376c) {
            return new LazyField.LazyIterator(this.f33374a.i().iterator());
        }
        return this.f33374a.i().iterator();
    }

    public int hashCode() {
        return this.f33374a.hashCode();
    }

    public Object j(T t3) {
        Object obj = this.f33374a.get(t3);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).getValue();
        }
        return obj;
    }

    public int k() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.f33374a.l(); i5++) {
            i4 += l(this.f33374a.k(i5));
        }
        for (Map.Entry<T, Object> entry : this.f33374a.n()) {
            i4 += l(entry);
        }
        return i4;
    }

    public Object m(T t3, int i4) {
        if (t3.isRepeated()) {
            Object j4 = j(t3);
            if (j4 != null) {
                return ((List) j4).get(i4);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int n(T t3) {
        if (t3.isRepeated()) {
            Object j4 = j(t3);
            if (j4 == null) {
                return 0;
            }
            return ((List) j4).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int o() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.f33374a.l(); i5++) {
            Map.Entry<T, Object> k4 = this.f33374a.k(i5);
            i4 += g(k4.getKey(), k4.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f33374a.n()) {
            i4 += g(entry.getKey(), entry.getValue());
        }
        return i4;
    }

    public boolean q(T t3) {
        if (!t3.isRepeated()) {
            if (this.f33374a.get(t3) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f33374a.isEmpty();
    }

    public boolean s() {
        return this.f33375b;
    }

    public boolean t() {
        for (int i4 = 0; i4 < this.f33374a.l(); i4++) {
            if (!u(this.f33374a.k(i4))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f33374a.n()) {
            if (!u(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> x() {
        if (this.f33376c) {
            return new LazyField.LazyIterator(this.f33374a.entrySet().iterator());
        }
        return this.f33374a.entrySet().iterator();
    }

    public void y() {
        if (this.f33375b) {
            return;
        }
        for (int i4 = 0; i4 < this.f33374a.l(); i4++) {
            Map.Entry<T, Object> k4 = this.f33374a.k(i4);
            if (k4.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) k4.getValue()).F();
            }
        }
        this.f33374a.q();
        this.f33375b = true;
    }

    public void z(FieldSet<T> fieldSet) {
        for (int i4 = 0; i4 < fieldSet.f33374a.l(); i4++) {
            A(fieldSet.f33374a.k(i4));
        }
        for (Map.Entry<T, Object> entry : fieldSet.f33374a.n()) {
            A(entry);
        }
    }

    private FieldSet(boolean z3) {
        this(SmallSortedMap.r(0));
        y();
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.f33374a = smallSortedMap;
        y();
    }
}
