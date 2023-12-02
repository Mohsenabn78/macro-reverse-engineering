package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes6.dex */
public final class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;

    /* renamed from: a  reason: collision with root package name */
    static final Charset f33418a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f33419b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    static final Charset f33420c = Charset.forName("ISO-8859-1");

    /* loaded from: classes6.dex */
    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z3);

        boolean getBoolean(int i4);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int i4);

        boolean setBoolean(int i4, boolean z3);
    }

    /* loaded from: classes6.dex */
    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d4);

        double getDouble(int i4);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int i4);

        double setDouble(int i4, double d4);
    }

    /* loaded from: classes6.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes6.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i4);
    }

    /* loaded from: classes6.dex */
    public interface EnumVerifier {
        boolean isInRange(int i4);
    }

    /* loaded from: classes6.dex */
    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f4);

        float getFloat(int i4);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int i4);

        float setFloat(int i4, float f4);
    }

    /* loaded from: classes6.dex */
    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i4);

        int getInt(int i4);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int i4);

        int setInt(int i4, int i5);
    }

    /* loaded from: classes6.dex */
    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<F> f33421a;

        /* renamed from: b  reason: collision with root package name */
        private final Converter<F, T> f33422b;

        /* loaded from: classes6.dex */
        public interface Converter<F, T> {
            T convert(F f4);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter) {
            this.f33421a = list;
            this.f33422b = converter;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i4) {
            return this.f33422b.convert(this.f33421a.get(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f33421a.size();
        }
    }

    /* loaded from: classes6.dex */
    public interface LongList extends ProtobufList<Long> {
        void addLong(long j4);

        long getLong(int i4);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int i4);

        long setLong(int i4, long j4);
    }

    /* loaded from: classes6.dex */
    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<K, RealValue> f33423a;

        /* renamed from: b  reason: collision with root package name */
        private final Converter<RealValue, V> f33424b;

        /* loaded from: classes6.dex */
        public interface Converter<A, B> {
            A doBackward(B b4);

            B doForward(A a4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes6.dex */
        public class EntryAdapter implements Map.Entry<K, V> {

            /* renamed from: a  reason: collision with root package name */
            private final Map.Entry<K, RealValue> f33427a;

            public EntryAdapter(Map.Entry<K, RealValue> entry) {
                this.f33427a = entry;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if ((obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue())) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.f33427a.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.this.f33424b.doForward(this.f33427a.getValue());
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.f33427a.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public V setValue(V v3) {
                Object value = this.f33427a.setValue(MapAdapter.this.f33424b.doBackward(v3));
                if (value == null) {
                    return null;
                }
                return (V) MapAdapter.this.f33424b.doForward(value);
            }
        }

        /* loaded from: classes6.dex */
        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private final Iterator<Map.Entry<K, RealValue>> f33429a;

            public IteratorAdapter(Iterator<Map.Entry<K, RealValue>> it) {
                this.f33429a = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.f33429a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f33429a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f33429a.remove();
            }
        }

        /* loaded from: classes6.dex */
        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private final Set<Map.Entry<K, RealValue>> f33431a;

            public SetAdapter(Set<Map.Entry<K, RealValue>> set) {
                this.f33431a = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.f33431a.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f33431a.size();
            }
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.f33423a = map;
            this.f33424b = converter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> enumLiteMap, final T t3) {
            return (Converter<Integer, T>) new Converter<Integer, T>() { // from class: com.google.protobuf.Internal.MapAdapter.1
                /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Integer; */
                @Override // com.google.protobuf.Internal.MapAdapter.Converter
                /* renamed from: a */
                public Integer doBackward(EnumLite enumLite) {
                    return Integer.valueOf(enumLite.getNumber());
                }

                /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Integer;)TT; */
                @Override // com.google.protobuf.Internal.MapAdapter.Converter
                /* renamed from: b */
                public EnumLite doForward(Integer num) {
                    EnumLite findValueByNumber = EnumLiteMap.this.findValueByNumber(num.intValue());
                    if (findValueByNumber == null) {
                        return t3;
                    }
                    return findValueByNumber;
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this.f33423a.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            RealValue realvalue = this.f33423a.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.f33424b.doForward(realvalue);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k4, V v3) {
            RealValue put = this.f33423a.put(k4, this.f33424b.doBackward(v3));
            if (put == null) {
                return null;
            }
            return this.f33424b.doForward(put);
        }
    }

    /* loaded from: classes6.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i4);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    private Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t3) {
        t3.getClass();
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T b(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(f33420c);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(f33420c));
    }

    static int c(byte[] bArr, int i4, int i5) {
        int e4 = e(i5, bArr, i4, i5);
        if (e4 == 0) {
            return 1;
        }
        return e4;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + bArr[i7];
        }
        return i4;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!Arrays.equals(list.get(i4), list2.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            java.lang.reflect.Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            return (T) method.invoke(method, new Object[0]);
        } catch (Exception e4) {
            throw new RuntimeException("Failed to get default instance for " + cls, e4);
        }
    }

    public static int hashBoolean(boolean z3) {
        if (z3) {
            return 1231;
        }
        return 1237;
    }

    public static int hashCode(List<byte[]> list) {
        int i4 = 1;
        for (byte[] bArr : list) {
            i4 = (i4 * 31) + hashCode(bArr);
        }
        return i4;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i4 = 1;
        for (ByteBuffer byteBuffer : list) {
            i4 = (i4 * 31) + hashCodeByteBuffer(byteBuffer);
        }
        return i4;
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i4 = 1;
        for (EnumLite enumLite : list) {
            i4 = (i4 * 31) + hashEnum(enumLite);
        }
        return i4;
    }

    public static int hashLong(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(f33420c), f33419b);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(f33419b);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, f33419b);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.t(bArr);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!equalsByteBuffer(list.get(i4), list2.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int e4 = e(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (e4 == 0) {
                return 1;
            }
            return e4;
        }
        int capacity = byteBuffer.capacity() <= 4096 ? byteBuffer.capacity() : 4096;
        byte[] bArr = new byte[capacity];
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        int capacity2 = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= capacity ? duplicate.remaining() : capacity;
            duplicate.get(bArr, 0, remaining);
            capacity2 = e(capacity2, bArr, 0, remaining);
        }
        if (capacity2 == 0) {
            return 1;
        }
        return capacity2;
    }
}
