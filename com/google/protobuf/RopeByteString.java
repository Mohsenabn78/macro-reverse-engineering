package com.google.protobuf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class RopeByteString extends ByteString {

    /* renamed from: c  reason: collision with root package name */
    static final int[] f33524c = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Balancer {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<ByteString> f33528a;

        private Balancer() {
            this.f33528a = new ArrayDeque<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.f33528a.pop();
            while (!this.f33528a.isEmpty()) {
                pop = new RopeByteString(this.f33528a.pop(), pop);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.l()) {
                e(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.left);
                c(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int d(int i4) {
            int binarySearch = Arrays.binarySearch(RopeByteString.f33524c, i4);
            if (binarySearch < 0) {
                return (-(binarySearch + 1)) - 1;
            }
            return binarySearch;
        }

        private void e(ByteString byteString) {
            int d4 = d(byteString.size());
            int E = RopeByteString.E(d4 + 1);
            if (!this.f33528a.isEmpty() && this.f33528a.peek().size() < E) {
                int E2 = RopeByteString.E(d4);
                ByteString pop = this.f33528a.pop();
                while (!this.f33528a.isEmpty() && this.f33528a.peek().size() < E2) {
                    pop = new RopeByteString(this.f33528a.pop(), pop);
                }
                RopeByteString ropeByteString = new RopeByteString(pop, byteString);
                while (!this.f33528a.isEmpty()) {
                    if (this.f33528a.peek().size() >= RopeByteString.E(d(ropeByteString.size()) + 1)) {
                        break;
                    }
                    ropeByteString = new RopeByteString(this.f33528a.pop(), ropeByteString);
                }
                this.f33528a.push(ropeByteString);
                return;
            }
            this.f33528a.push(byteString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class PieceIterator implements Iterator<ByteString.LeafByteString> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<RopeByteString> f33529a;

        /* renamed from: b  reason: collision with root package name */
        private ByteString.LeafByteString f33530b;

        private ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f33529a.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString b() {
            ByteString.LeafByteString a4;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.f33529a;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    a4 = a(this.f33529a.pop().right);
                } else {
                    return null;
                }
            } while (a4.isEmpty());
            return a4;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f33530b;
            if (leafByteString != null) {
                this.f33530b = b();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f33530b != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.h());
                this.f33529a = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.f33530b = a(ropeByteString.left);
                return;
            }
            this.f33529a = null;
            this.f33530b = (ByteString.LeafByteString) byteString;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString B(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return C(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, C(ropeByteString.right, byteString2));
            } else if (ropeByteString.left.h() > ropeByteString.right.h() && ropeByteString.h() > byteString2.h()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size < E(Math.max(byteString.h(), byteString2.h()) + 1)) {
            return new Balancer().b(byteString, byteString2);
        }
        return new RopeByteString(byteString, byteString2);
    }

    private static ByteString C(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.v(bArr);
    }

    private boolean D(ByteString byteString) {
        boolean z3;
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString next = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString next2 = pieceIterator2.next();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int size = next.size() - i4;
            int size2 = next2.size() - i5;
            int min = Math.min(size, size2);
            if (i4 == 0) {
                z3 = next.z(next2, i5, min);
            } else {
                z3 = next2.z(next, i4, min);
            }
            if (!z3) {
                return false;
            }
            i6 += min;
            int i7 = this.totalLength;
            if (i6 >= i7) {
                if (i6 == i7) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                i4 = 0;
                next = pieceIterator.next();
            } else {
                i4 += min;
                next = next;
            }
            if (min == size2) {
                next2 = pieceIterator2.next();
                i5 = 0;
            } else {
                i5 += min;
            }
        }
    }

    static int E(int i4) {
        int[] iArr = f33524c;
        if (i4 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i4];
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i4) {
        ByteString.c(i4, this.totalLength);
        return j(i4);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int p4 = p();
        int p5 = byteString.p();
        if (p4 != 0 && p5 != 0 && p4 != p5) {
            return false;
        }
        return D(byteString);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public void f(byte[] bArr, int i4, int i5, int i6) {
        int i7 = i4 + i6;
        int i8 = this.leftLength;
        if (i7 <= i8) {
            this.left.f(bArr, i4, i5, i6);
        } else if (i4 >= i8) {
            this.right.f(bArr, i4 - i8, i5, i6);
        } else {
            int i9 = i8 - i4;
            this.left.f(bArr, i4, i5, i9);
            this.right.f(bArr, 0, i5 + i9, i6 - i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int h() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int o4 = this.left.o(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.o(o4, 0, byteString.size()) != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public byte j(int i4) {
        int i5 = this.leftLength;
        if (i4 < i5) {
            return this.left.j(i4);
        }
        return this.right.j(i4 - i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public boolean l() {
        if (this.totalLength >= E(this.treeDepth)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int n(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.leftLength;
        if (i7 <= i8) {
            return this.left.n(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.right.n(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.right.n(this.left.n(i4, i5, i9), 0, i6 - i9);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.a(asReadOnlyByteBufferList(), true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int o(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.leftLength;
        if (i7 <= i8) {
            return this.left.o(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.right.o(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.right.o(this.left.o(i4, i5, i9), 0, i6 - i9);
    }

    @Override // com.google.protobuf.ByteString
    protected String s(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i4, int i5) {
        int e4 = ByteString.e(i4, i5, this.totalLength);
        if (e4 == 0) {
            return ByteString.EMPTY;
        }
        if (e4 == this.totalLength) {
            return this;
        }
        int i6 = this.leftLength;
        if (i5 <= i6) {
            return this.left.substring(i4, i5);
        }
        if (i4 >= i6) {
            return this.right.substring(i4 - i6, i5 - i6);
        }
        return new RopeByteString(this.left.substring(i4), this.right.substring(0, i5 - this.leftLength));
    }

    Object writeReplace() {
        return ByteString.v(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void x(ByteOutput byteOutput) throws IOException {
        this.left.x(byteOutput);
        this.right.x(byteOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void y(ByteOutput byteOutput) throws IOException {
        this.right.y(byteOutput);
        this.left.y(byteOutput);
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.h(), byteString2.h()) + 1;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new ByteString.AbstractByteIterator() { // from class: com.google.protobuf.RopeByteString.1

            /* renamed from: a  reason: collision with root package name */
            final PieceIterator f33525a;

            /* renamed from: b  reason: collision with root package name */
            ByteString.ByteIterator f33526b = b();

            {
                this.f33525a = new PieceIterator(RopeByteString.this);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.google.protobuf.ByteString$ByteIterator] */
            private ByteString.ByteIterator b() {
                if (this.f33525a.hasNext()) {
                    return this.f33525a.next().iterator2();
                }
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f33526b != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                ByteString.ByteIterator byteIterator = this.f33526b;
                if (byteIterator != null) {
                    byte nextByte = byteIterator.nextByte();
                    if (!this.f33526b.hasNext()) {
                        this.f33526b = b();
                    }
                    return nextByte;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* loaded from: classes6.dex */
    private class RopeInputStream extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private PieceIterator f33531a;

        /* renamed from: b  reason: collision with root package name */
        private ByteString.LeafByteString f33532b;

        /* renamed from: c  reason: collision with root package name */
        private int f33533c;

        /* renamed from: d  reason: collision with root package name */
        private int f33534d;

        /* renamed from: e  reason: collision with root package name */
        private int f33535e;

        /* renamed from: f  reason: collision with root package name */
        private int f33536f;

        public RopeInputStream() {
            d();
        }

        private void b() {
            if (this.f33532b != null) {
                int i4 = this.f33534d;
                int i5 = this.f33533c;
                if (i4 == i5) {
                    this.f33535e += i5;
                    this.f33534d = 0;
                    if (this.f33531a.hasNext()) {
                        ByteString.LeafByteString next = this.f33531a.next();
                        this.f33532b = next;
                        this.f33533c = next.size();
                        return;
                    }
                    this.f33532b = null;
                    this.f33533c = 0;
                }
            }
        }

        private int c() {
            return RopeByteString.this.size() - (this.f33535e + this.f33534d);
        }

        private void d() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.f33531a = pieceIterator;
            ByteString.LeafByteString next = pieceIterator.next();
            this.f33532b = next;
            this.f33533c = next.size();
            this.f33534d = 0;
            this.f33535e = 0;
        }

        private int e(byte[] bArr, int i4, int i5) {
            int i6 = i5;
            while (i6 > 0) {
                b();
                if (this.f33532b == null) {
                    break;
                }
                int min = Math.min(this.f33533c - this.f33534d, i6);
                if (bArr != null) {
                    this.f33532b.copyTo(bArr, this.f33534d, i4, min);
                    i4 += min;
                }
                this.f33534d += min;
                i6 -= min;
            }
            return i5 - i6;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return c();
        }

        @Override // java.io.InputStream
        public void mark(int i4) {
            this.f33536f = this.f33535e + this.f33534d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) {
            bArr.getClass();
            if (i4 >= 0 && i5 >= 0 && i5 <= bArr.length - i4) {
                int e4 = e(bArr, i4, i5);
                if (e4 == 0) {
                    if (i5 > 0 || c() == 0) {
                        return -1;
                    }
                    return e4;
                }
                return e4;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            d();
            e(null, 0, this.f33536f);
        }

        @Override // java.io.InputStream
        public long skip(long j4) {
            if (j4 >= 0) {
                if (j4 > 2147483647L) {
                    j4 = 2147483647L;
                }
                return e(null, 0, (int) j4);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            b();
            ByteString.LeafByteString leafByteString = this.f33532b;
            if (leafByteString == null) {
                return -1;
            }
            int i4 = this.f33534d;
            this.f33534d = i4 + 1;
            return leafByteString.byteAt(i4) & 255;
        }
    }
}
