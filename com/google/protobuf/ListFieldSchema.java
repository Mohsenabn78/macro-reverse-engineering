package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CheckReturnValue
/* loaded from: classes6.dex */
abstract class ListFieldSchema {

    /* renamed from: a  reason: collision with root package name */
    private static final ListFieldSchema f33455a = new ListFieldSchemaFull();

    /* renamed from: b  reason: collision with root package name */
    private static final ListFieldSchema f33456b = new ListFieldSchemaLite();

    /* loaded from: classes6.dex */
    private static final class ListFieldSchemaFull extends ListFieldSchema {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?> f33457c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> f(Object obj, long j4) {
            return (List) UnsafeUtil.H(obj, j4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> g(Object obj, long j4, int i4) {
            LazyStringArrayList lazyStringArrayList;
            List<L> arrayList;
            List<L> f4 = f(obj, j4);
            if (f4.isEmpty()) {
                if (f4 instanceof LazyStringList) {
                    arrayList = new LazyStringArrayList(i4);
                } else if ((f4 instanceof PrimitiveNonBoxingCollection) && (f4 instanceof Internal.ProtobufList)) {
                    arrayList = ((Internal.ProtobufList) f4).mutableCopyWithCapacity(i4);
                } else {
                    arrayList = new ArrayList<>(i4);
                }
                UnsafeUtil.Y(obj, j4, arrayList);
                return arrayList;
            }
            if (f33457c.isAssignableFrom(f4.getClass())) {
                ArrayList arrayList2 = new ArrayList(f4.size() + i4);
                arrayList2.addAll(f4);
                UnsafeUtil.Y(obj, j4, arrayList2);
                lazyStringArrayList = arrayList2;
            } else if (f4 instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(f4.size() + i4);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) f4);
                UnsafeUtil.Y(obj, j4, lazyStringArrayList2);
                lazyStringArrayList = lazyStringArrayList2;
            } else if ((f4 instanceof PrimitiveNonBoxingCollection) && (f4 instanceof Internal.ProtobufList)) {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) f4;
                if (!protobufList.isModifiable()) {
                    Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(f4.size() + i4);
                    UnsafeUtil.Y(obj, j4, mutableCopyWithCapacity);
                    return mutableCopyWithCapacity;
                }
                return f4;
            } else {
                return f4;
            }
            return lazyStringArrayList;
        }

        @Override // com.google.protobuf.ListFieldSchema
        void c(Object obj, long j4) {
            Object unmodifiableList;
            List list = (List) UnsafeUtil.H(obj, j4);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else if (f33457c.isAssignableFrom(list.getClass())) {
                return;
            } else {
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.Y(obj, j4, unmodifiableList);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void d(Object obj, Object obj2, long j4) {
            List f4 = f(obj2, j4);
            List g4 = g(obj, j4, f4.size());
            int size = g4.size();
            int size2 = f4.size();
            if (size > 0 && size2 > 0) {
                g4.addAll(f4);
            }
            if (size > 0) {
                f4 = g4;
            }
            UnsafeUtil.Y(obj, j4, f4);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> e(Object obj, long j4) {
            return g(obj, j4, 10);
        }
    }

    /* loaded from: classes6.dex */
    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> f(Object obj, long j4) {
            return (Internal.ProtobufList) UnsafeUtil.H(obj, j4);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void c(Object obj, long j4) {
            f(obj, j4).makeImmutable();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
        @Override // com.google.protobuf.ListFieldSchema
        <E> void d(Object obj, Object obj2, long j4) {
            Internal.ProtobufList<E> f4 = f(obj, j4);
            Internal.ProtobufList<E> f5 = f(obj2, j4);
            int size = f4.size();
            int size2 = f5.size();
            Internal.ProtobufList<E> protobufList = f4;
            protobufList = f4;
            if (size > 0 && size2 > 0) {
                boolean isModifiable = f4.isModifiable();
                Internal.ProtobufList<E> protobufList2 = f4;
                if (!isModifiable) {
                    protobufList2 = f4.mutableCopyWithCapacity(size2 + size);
                }
                protobufList2.addAll(f5);
                protobufList = protobufList2;
            }
            if (size > 0) {
                f5 = protobufList;
            }
            UnsafeUtil.Y(obj, j4, f5);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> e(Object obj, long j4) {
            int i4;
            Internal.ProtobufList f4 = f(obj, j4);
            if (!f4.isModifiable()) {
                int size = f4.size();
                if (size == 0) {
                    i4 = 10;
                } else {
                    i4 = size * 2;
                }
                Internal.ProtobufList mutableCopyWithCapacity = f4.mutableCopyWithCapacity(i4);
                UnsafeUtil.Y(obj, j4, mutableCopyWithCapacity);
                return mutableCopyWithCapacity;
            }
            return f4;
        }
    }

    private ListFieldSchema() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema a() {
        return f33455a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema b() {
        return f33456b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Object obj, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j4);
}
