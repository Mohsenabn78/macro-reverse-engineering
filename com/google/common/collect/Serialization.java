package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.Multiset;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class Serialization {

    /* loaded from: classes5.dex */
    static final class FieldSetter<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Field f27376a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(T t3, int i4) {
            try {
                this.f27376a.set(t3, Integer.valueOf(i4));
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(T t3, Object obj) {
            try {
                this.f27376a.set(t3, obj);
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            }
        }

        private FieldSetter(Field field) {
            this.f27376a = field;
            field.setAccessible(true);
        }
    }

    private Serialization() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> FieldSetter<T> a(Class<T> cls, String str) {
        try {
            return new FieldSetter<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e4) {
            throw new AssertionError(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i4) throws IOException, ClassNotFoundException {
        for (int i5 = 0; i5 < i4; i5++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void d(Multimap<K, V> multimap, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(multimap, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(Multimap<K, V> multimap, ObjectInputStream objectInputStream, int i4) throws IOException, ClassNotFoundException {
        for (int i5 = 0; i5 < i4; i5++) {
            Collection collection = multimap.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i6 = 0; i6 < readInt; i6++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void f(Multiset<E> multiset, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(multiset, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(Multiset<E> multiset, ObjectInputStream objectInputStream, int i4) throws IOException, ClassNotFoundException {
        for (int i5 = 0; i5 < i4; i5++) {
            multiset.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void j(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multimap.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            for (V v3 : entry.getValue()) {
                objectOutputStream.writeObject(v3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void k(Multiset<E> multiset, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (Multiset.Entry<E> entry : multiset.entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }
}
