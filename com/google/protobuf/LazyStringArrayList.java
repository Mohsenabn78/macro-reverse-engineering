package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes6.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY;

    /* renamed from: c  reason: collision with root package name */
    private static final LazyStringArrayList f33451c;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f33452b;

    /* loaded from: classes6.dex */
    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        private final LazyStringArrayList f33453a;

        ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
            this.f33453a = lazyStringArrayList;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public void add(int i4, byte[] bArr) {
            this.f33453a.i(i4, bArr);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public byte[] get(int i4) {
            return this.f33453a.getByteArray(i4);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: c */
        public byte[] remove(int i4) {
            String remove = this.f33453a.remove(i4);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.j(remove);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: d */
        public byte[] set(int i4, byte[] bArr) {
            Object n4 = this.f33453a.n(i4, bArr);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.j(n4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f33453a.size();
        }
    }

    /* loaded from: classes6.dex */
    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        private final LazyStringArrayList f33454a;

        ByteStringListView(LazyStringArrayList lazyStringArrayList) {
            this.f33454a = lazyStringArrayList;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public void add(int i4, ByteString byteString) {
            this.f33454a.h(i4, byteString);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public ByteString get(int i4) {
            return this.f33454a.getByteString(i4);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: c */
        public ByteString remove(int i4) {
            String remove = this.f33454a.remove(i4);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.k(remove);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: d */
        public ByteString set(int i4, ByteString byteString) {
            Object m4 = this.f33454a.m(i4, byteString);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.k(m4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f33454a.size();
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        f33451c = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
        EMPTY = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i4, ByteString byteString) {
        a();
        this.f33452b.add(i4, byteString);
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i4, byte[] bArr) {
        a();
        this.f33452b.add(i4, bArr);
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] j(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.toByteArray((String) obj);
        }
        return ((ByteString) obj).toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString k(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    private static String l(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object m(int i4, ByteString byteString) {
        a();
        return this.f33452b.set(i4, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object n(int i4, byte[] bArr) {
        a();
        return this.f33452b.set(i4, bArr);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        a();
        boolean addAll = this.f33452b.addAll(collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        a();
        boolean addAll = this.f33452b.addAll(collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f33452b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int i4) {
        Object obj = this.f33452b.get(i4);
        byte[] j4 = j(obj);
        if (j4 != obj) {
            this.f33452b.set(i4, j4);
        }
        return j4;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int i4) {
        Object obj = this.f33452b.get(i4);
        ByteString k4 = k(obj);
        if (k4 != obj) {
            this.f33452b.set(i4, k4);
        }
        return k4;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int i4) {
        return this.f33452b.get(i4);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f33452b);
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable()) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.AbstractProtobufList, com.google.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        a();
        for (Object obj : lazyStringList.getUnderlyingElements()) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                this.f33452b.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.f33452b.add(obj);
            }
        }
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33452b.size();
    }

    public LazyStringArrayList(int i4) {
        this((ArrayList<Object>) new ArrayList(i4));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i4, String str) {
        a();
        this.f33452b.add(i4, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int i4, Collection<? extends String> collection) {
        a();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.f33452b.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i4) {
        Object obj = this.f33452b.get(i4);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f33452b.set(i4, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.f33452b.set(i4, stringUtf82);
        }
        return stringUtf82;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int i4) {
        if (i4 >= size()) {
            ArrayList arrayList = new ArrayList(i4);
            arrayList.addAll(this.f33452b);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String set(int i4, String str) {
        a();
        return l(this.f33452b.set(i4, str));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f33452b = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int i4) {
        a();
        Object remove = this.f33452b.remove(i4);
        ((AbstractList) this).modCount++;
        return l(remove);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString byteString) {
        a();
        this.f33452b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i4, ByteString byteString) {
        m(i4, byteString);
    }

    public LazyStringArrayList(List<String> list) {
        this((ArrayList<Object>) new ArrayList(list));
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i4, byte[] bArr) {
        n(i4, bArr);
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.f33452b = arrayList;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] bArr) {
        a();
        this.f33452b.add(bArr);
        ((AbstractList) this).modCount++;
    }
}
