package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes6.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final LazyStringList f33593a;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f33593a = lazyStringList;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.f33593a.asByteArrayList());
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.f33593a.asByteStringList());
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int i4) {
        return this.f33593a.getByteArray(i4);
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int i4) {
        return this.f33593a.getByteString(i4);
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int i4) {
        return this.f33593a.getRaw(i4);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.f33593a.getUnderlyingElements();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: com.google.protobuf.UnmodifiableLazyStringList.2

            /* renamed from: a  reason: collision with root package name */
            Iterator<String> f33597a;

            {
                this.f33597a = UnmodifiableLazyStringList.this.f33593a.iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public String next() {
                return this.f33597a.next();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f33597a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i4) {
        return new ListIterator<String>(i4) { // from class: com.google.protobuf.UnmodifiableLazyStringList.1

            /* renamed from: a  reason: collision with root package name */
            ListIterator<String> f33594a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f33595b;

            {
                this.f33595b = i4;
                this.f33594a = UnmodifiableLazyStringList.this.f33593a.listIterator(i4);
            }

            @Override // java.util.ListIterator
            /* renamed from: a */
            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            /* renamed from: b */
            public String next() {
                return this.f33594a.next();
            }

            @Override // java.util.ListIterator
            /* renamed from: c */
            public String previous() {
                return this.f33594a.previous();
            }

            @Override // java.util.ListIterator
            /* renamed from: d */
            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f33594a.hasNext();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f33594a.hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f33594a.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f33594a.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i4, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33593a.size();
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i4) {
        return this.f33593a.get(i4);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i4, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }
}
