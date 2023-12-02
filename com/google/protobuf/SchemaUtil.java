package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public final class SchemaUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f33538a = B();

    /* renamed from: b  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f33539b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f33540c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f33541d = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static <UT, UB> UB A(Object obj, int i4, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int intValue = list.get(i6).intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i6 != i5) {
                        list.set(i5, Integer.valueOf(intValue));
                    }
                    i5++;
                } else {
                    ub = (UB) L(obj, i4, intValue, ub, unknownFieldSchema);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = (UB) L(obj, i4, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static UnknownFieldSchema<?, ?> C(boolean z3) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (UnknownFieldSchema) D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z3));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void E(ExtensionSchema<FT> extensionSchema, T t3, T t4) {
        FieldSet<FT> c4 = extensionSchema.c(t4);
        if (!c4.r()) {
            extensionSchema.d(t3).z(c4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void F(MapFieldSchema mapFieldSchema, T t3, T t4, long j4) {
        UnsafeUtil.Y(t3, j4, mapFieldSchema.mergeFrom(UnsafeUtil.H(t3, j4), UnsafeUtil.H(t4, j4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void G(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3, T t4) {
        unknownFieldSchema.p(t3, unknownFieldSchema.k(unknownFieldSchema.g(t3), unknownFieldSchema.g(t4)));
    }

    public static UnknownFieldSchema<?, ?> H() {
        return f33539b;
    }

    public static UnknownFieldSchema<?, ?> I() {
        return f33540c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f33538a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static <UT, UB> UB L(Object obj, int i4, int i5, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.f(obj);
        }
        unknownFieldSchema.e(ub, i4, i5);
        return ub;
    }

    public static UnknownFieldSchema<?, ?> M() {
        return f33541d;
    }

    public static void N(int i4, List<Boolean> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i4, list, z3);
        }
    }

    public static void O(int i4, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i4, list);
        }
    }

    public static void P(int i4, List<Double> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i4, list, z3);
        }
    }

    public static void Q(int i4, List<Integer> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i4, list, z3);
        }
    }

    public static void R(int i4, List<Integer> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i4, list, z3);
        }
    }

    public static void S(int i4, List<Long> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i4, list, z3);
        }
    }

    public static void T(int i4, List<Float> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i4, list, z3);
        }
    }

    public static void U(int i4, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.d(i4, list, schema);
        }
    }

    public static void V(int i4, List<Integer> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i4, list, z3);
        }
    }

    public static void W(int i4, List<Long> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i4, list, z3);
        }
    }

    public static void X(int i4, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.b(i4, list, schema);
        }
    }

    public static void Y(int i4, List<Integer> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i4, list, z3);
        }
    }

    public static void Z(int i4, List<Long> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(size);
        }
        return size * CodedOutputStream.computeBoolSize(i4, true);
    }

    public static void a0(int i4, List<Integer> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i4, List<Long> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i4, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i5));
        }
        return computeTagSize;
    }

    public static void c0(int i4, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i4, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e4 = e(list);
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(e4);
        }
        return e4 + (size * CodedOutputStream.computeTagSize(i4));
    }

    public static void d0(int i4, List<Integer> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeEnumSizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    public static void e0(int i4, List<Long> list, Writer writer, boolean z3) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i4, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i4, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i4, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i4, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i4, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += CodedOutputStream.g(i4, list.get(i6), schema);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l4 = l(list);
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(l4);
        }
        return l4 + (size * CodedOutputStream.computeTagSize(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i4, List<Long> list, boolean z3) {
        if (list.size() == 0) {
            return 0;
        }
        int n4 = n(list);
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(n4);
        }
        return n4 + (list.size() * CodedOutputStream.computeTagSize(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i4, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i4, (LazyFieldLite) obj);
        }
        return CodedOutputStream.j(i4, (MessageLite) obj, schema);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i4, List<?> list, Schema schema) {
        int k4;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof LazyFieldLite) {
                k4 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                k4 = CodedOutputStream.k((MessageLite) obj, schema);
            }
            computeTagSize += k4;
        }
        return computeTagSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r4 = r(list);
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(r4);
        }
        return r4 + (size * CodedOutputStream.computeTagSize(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i4, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t3 = t(list);
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(t3);
        }
        return t3 + (size * CodedOutputStream.computeTagSize(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i4, List<?> list) {
        int computeStringSizeNoTag;
        int computeStringSizeNoTag2;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i4) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i5 < size) {
                Object raw = lazyStringList.getRaw(i5);
                if (raw instanceof ByteString) {
                    computeStringSizeNoTag2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    computeStringSizeNoTag2 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += computeStringSizeNoTag2;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof ByteString) {
                    computeStringSizeNoTag = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    computeStringSizeNoTag = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += computeStringSizeNoTag;
                i5++;
            }
        }
        return computeTagSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i4, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w3 = w(list);
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(w3);
        }
        return w3 + (size * CodedOutputStream.computeTagSize(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List<Integer> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(int i4, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y3 = y(list);
        if (z3) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(y3);
        }
        return y3 + (size * CodedOutputStream.computeTagSize(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List<Long> list) {
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
        } else {
            i4 = 0;
            while (i5 < size) {
                i4 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static <UT, UB> UB z(Object obj, int i4, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int intValue = list.get(i6).intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i6 != i5) {
                        list.set(i5, Integer.valueOf(intValue));
                    }
                    i5++;
                } else {
                    ub = (UB) L(obj, i4, intValue, ub, unknownFieldSchema);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    ub = (UB) L(obj, i4, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
