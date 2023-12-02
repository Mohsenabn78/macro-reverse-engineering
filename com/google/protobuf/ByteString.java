package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.slf4j.Marker;

@CheckReturnValue
/* loaded from: classes6.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);

    /* renamed from: a  reason: collision with root package name */
    private static final ByteArrayCopier f33201a;

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<ByteString> f33202b;
    private int hash = 0;

    /* loaded from: classes6.dex */
    static abstract class AbstractByteIterator implements ByteIterator {
        @Override // java.util.Iterator
        /* renamed from: a */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i4, int i5) {
            return Arrays.copyOfRange(bArr, i4, i5 + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i4, int i5) {
            super(bArr);
            ByteString.e(i4, i4 + i5, bArr.length);
            this.bytesOffset = i4;
            this.bytesLength = i5;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        protected int A() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int i4) {
            ByteString.c(i4, size());
            return this.bytes[this.bytesOffset + i4];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        protected void f(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.bytes, A() + i4, bArr, i5, i6);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        byte j(int i4) {
            return this.bytes[this.bytesOffset + i4];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        Object writeReplace() {
            return ByteString.v(toByteArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i4, int i5);
    }

    /* loaded from: classes6.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* loaded from: classes6.dex */
    static final class CodedBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final CodedOutputStream f33206a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f33207b;

        public ByteString a() {
            this.f33206a.checkNoSpaceLeft();
            return new LiteralByteString(this.f33207b);
        }

        public CodedOutputStream b() {
            return this.f33206a;
        }

        private CodedBuilder(int i4) {
            byte[] bArr = new byte[i4];
            this.f33207b = bArr;
            this.f33206a = CodedOutputStream.newInstance(bArr);
        }
    }

    /* loaded from: classes6.dex */
    static abstract class LeafByteString extends ByteString {
        @Override // com.google.protobuf.ByteString
        protected final int h() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // com.google.protobuf.ByteString
        protected final boolean l() {
            return true;
        }

        @Override // com.google.protobuf.ByteString
        void y(ByteOutput byteOutput) throws IOException {
            x(byteOutput);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean z(ByteString byteString, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        protected int A() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, A(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int i4) {
            return this.bytes[i4];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, A(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof LiteralByteString) {
                LiteralByteString literalByteString = (LiteralByteString) obj;
                int p4 = p();
                int p5 = literalByteString.p();
                if (p4 != 0 && p5 != 0 && p4 != p5) {
                    return false;
                }
                return z(literalByteString, 0, size());
            }
            return obj.equals(this);
        }

        @Override // com.google.protobuf.ByteString
        protected void f(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.bytes, i4, bArr, i5, i6);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int A = A();
            return Utf8.u(this.bytes, A, size() + A);
        }

        @Override // com.google.protobuf.ByteString
        byte j(int i4) {
            return this.bytes[i4];
        }

        @Override // com.google.protobuf.ByteString
        protected final int n(int i4, int i5, int i6) {
            return Internal.e(i4, this.bytes, A() + i5, i6);
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.c(this.bytes, A(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, A(), size());
        }

        @Override // com.google.protobuf.ByteString
        protected final int o(int i4, int i5, int i6) {
            int A = A() + i5;
            return Utf8.w(i4, this.bytes, A, i6 + A);
        }

        @Override // com.google.protobuf.ByteString
        protected final String s(Charset charset) {
            return new String(this.bytes, A(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int i4, int i5) {
            int e4 = ByteString.e(i4, i5, size());
            if (e4 == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, A() + i4, e4);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        final void x(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.bytes, A(), size());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean z(ByteString byteString, int i4, int i5) {
            if (i5 <= byteString.size()) {
                int i6 = i4 + i5;
                if (i6 <= byteString.size()) {
                    if (byteString instanceof LiteralByteString) {
                        LiteralByteString literalByteString = (LiteralByteString) byteString;
                        byte[] bArr = this.bytes;
                        byte[] bArr2 = literalByteString.bytes;
                        int A = A() + i5;
                        int A2 = A();
                        int A3 = literalByteString.A() + i4;
                        while (A2 < A) {
                            if (bArr[A2] != bArr2[A3]) {
                                return false;
                            }
                            A2++;
                            A3++;
                        }
                        return true;
                    }
                    return byteString.substring(i4, i6).equals(substring(0, i5));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i4 + ", " + i5 + ", " + byteString.size());
            }
            throw new IllegalArgumentException("Length too large: " + i5 + size());
        }
    }

    /* loaded from: classes6.dex */
    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i4, int i5) {
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, i4, bArr2, 0, i5);
            return bArr2;
        }
    }

    static {
        ByteArrayCopier arraysByteArrayCopier;
        if (Android.c()) {
            arraysByteArrayCopier = new SystemByteArrayCopier();
        } else {
            arraysByteArrayCopier = new ArraysByteArrayCopier();
        }
        f33201a = arraysByteArrayCopier;
        f33202b = new Comparator<ByteString>() { // from class: com.google.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Iterator, com.google.protobuf.ByteString$ByteIterator] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Iterator, com.google.protobuf.ByteString$ByteIterator] */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? iterator2 = byteString.iterator2();
                ?? iterator22 = byteString2.iterator2();
                while (iterator2.hasNext() && iterator22.hasNext()) {
                    int compareTo = Integer.valueOf(ByteString.r(iterator2.nextByte())).compareTo(Integer.valueOf(ByteString.r(iterator22.nextByte())));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    private static ByteString b(Iterator<ByteString> it, int i4) {
        if (i4 >= 1) {
            if (i4 == 1) {
                return it.next();
            }
            int i5 = i4 >>> 1;
            return b(it, i5).concat(b(it, i4 - i5));
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(int i4, int i5) {
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i4, int i5) {
        e(i4, i4 + i5, bArr.length);
        return new LiteralByteString(f33201a.copyFrom(bArr, i4, i5));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.f33419b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int e(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) < 0) {
            if (i4 >= 0) {
                if (i5 < i4) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i4 + ", " + i5);
                }
                throw new IndexOutOfBoundsException("End index: " + i5 + " >= " + i6);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i4 + " < 0");
        }
        return i7;
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    public static ByteString fromHex(@CompileTimeConstant String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 2;
                bArr[i4] = (byte) (g(str, i5 + 1) | (g(str, i5) << 4));
            }
            return new LiteralByteString(bArr);
        }
        throw new NumberFormatException("Invalid hexString " + str + " of length " + str.length() + " must be even.");
    }

    private static int g(String str, int i4) {
        int i5 = i(str.charAt(i4));
        if (i5 != -1) {
            return i5;
        }
        throw new NumberFormatException("Invalid hexString " + str + " must only contain [0-9a-fA-F] but contained " + str.charAt(i4) + " at index " + i4);
    }

    private static int i(char c4) {
        if (c4 >= '0' && c4 <= '9') {
            return c4 - '0';
        }
        char c5 = 'A';
        if (c4 < 'A' || c4 > 'F') {
            c5 = 'a';
            if (c4 < 'a' || c4 > 'f') {
                return -1;
            }
        }
        return (c4 - c5) + 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedBuilder m(int i4) {
        return new CodedBuilder(i4);
    }

    public static Output newOutput(int i4) {
        return new Output(i4);
    }

    private static ByteString q(InputStream inputStream, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            int read = inputStream.read(bArr, i5, i4 - i5);
            if (read == -1) {
                break;
            }
            i5 += read;
        }
        if (i5 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(byte b4) {
        return b4 & 255;
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    private String t() {
        if (size() <= 50) {
            return TextFormatEscaper.a(this);
        }
        return TextFormatEscaper.a(substring(0, 47)) + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString u(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return w(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new NioByteString(byteBuffer);
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return f33202b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString v(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString w(byte[] bArr, int i4, int i5) {
        return new BoundedByteString(bArr, i4, i5);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i4);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.B(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + Marker.ANY_NON_NULL_MARKER + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i4) {
        copyTo(bArr, 0, i4, size());
    }

    public final boolean endsWith(ByteString byteString) {
        if (size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString)) {
            return true;
        }
        return false;
    }

    public abstract boolean equals(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void f(byte[] bArr, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int h();

    public final int hashCode() {
        int i4 = this.hash;
        if (i4 == 0) {
            int size = size();
            i4 = n(size, 0, size);
            if (i4 == 0) {
                i4 = 1;
            }
            this.hash = i4;
        }
        return i4;
    }

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public abstract boolean isValidUtf8();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte j(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean l();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int n(int i4, int i5, int i6);

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int o(int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int p() {
        return this.hash;
    }

    protected abstract String s(Charset charset);

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(0, byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public final ByteString substring(int i4) {
        return substring(i4, size());
    }

    public abstract ByteString substring(int i4, int i5);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        f(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e4) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e4);
            throw unsupportedEncodingException;
        }
    }

    public final String toStringUtf8() {
        return toString(Internal.f33419b);
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void x(ByteOutput byteOutput) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void y(ByteOutput byteOutput) throws IOException;

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i4) throws IOException {
        return readFrom(inputStream, i4, i4);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i4, int i5, int i6) {
        e(i4, i4 + i6, size());
        e(i5, i5 + i6, bArr.length);
        if (i6 > 0) {
            f(bArr, i4, i5, i6);
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new AbstractByteIterator() { // from class: com.google.protobuf.ByteString.1

            /* renamed from: a  reason: collision with root package name */
            private int f33203a = 0;

            /* renamed from: b  reason: collision with root package name */
            private final int f33204b;

            {
                this.f33204b = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f33203a < this.f33204b) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i4 = this.f33203a;
                if (i4 < this.f33204b) {
                    this.f33203a = i4 + 1;
                    return ByteString.this.j(i4);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i4, int i5) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString q4 = q(inputStream, i4);
            if (q4 == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(q4);
            i4 = Math.min(i4 * 2, i5);
        }
    }

    /* loaded from: classes6.dex */
    public static final class Output extends OutputStream {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f33208f = new byte[0];

        /* renamed from: a  reason: collision with root package name */
        private final int f33209a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<ByteString> f33210b;

        /* renamed from: c  reason: collision with root package name */
        private int f33211c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f33212d;

        /* renamed from: e  reason: collision with root package name */
        private int f33213e;

        Output(int i4) {
            if (i4 >= 0) {
                this.f33209a = i4;
                this.f33210b = new ArrayList<>();
                this.f33212d = new byte[i4];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] b(byte[] bArr, int i4) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i4));
            return bArr2;
        }

        private void c(int i4) {
            this.f33210b.add(new LiteralByteString(this.f33212d));
            int length = this.f33211c + this.f33212d.length;
            this.f33211c = length;
            this.f33212d = new byte[Math.max(this.f33209a, Math.max(i4, length >>> 1))];
            this.f33213e = 0;
        }

        private void d() {
            int i4 = this.f33213e;
            byte[] bArr = this.f33212d;
            if (i4 < bArr.length) {
                if (i4 > 0) {
                    this.f33210b.add(new LiteralByteString(b(bArr, i4)));
                }
            } else {
                this.f33210b.add(new LiteralByteString(this.f33212d));
                this.f33212d = f33208f;
            }
            this.f33211c += this.f33213e;
            this.f33213e = 0;
        }

        public synchronized void reset() {
            this.f33210b.clear();
            this.f33211c = 0;
            this.f33213e = 0;
        }

        public synchronized int size() {
            return this.f33211c + this.f33213e;
        }

        public synchronized ByteString toByteString() {
            d();
            return ByteString.copyFrom(this.f33210b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i4) {
            if (this.f33213e == this.f33212d.length) {
                c(1);
            }
            byte[] bArr = this.f33212d;
            int i5 = this.f33213e;
            this.f33213e = i5 + 1;
            bArr[i5] = (byte) i4;
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i4;
            synchronized (this) {
                ArrayList<ByteString> arrayList = this.f33210b;
                byteStringArr = (ByteString[]) arrayList.toArray(new ByteString[arrayList.size()]);
                bArr = this.f33212d;
                i4 = this.f33213e;
            }
            for (ByteString byteString : byteStringArr) {
                byteString.writeTo(outputStream);
            }
            outputStream.write(b(bArr, i4));
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i4, int i5) {
            byte[] bArr2 = this.f33212d;
            int length = bArr2.length;
            int i6 = this.f33213e;
            if (i5 <= length - i6) {
                System.arraycopy(bArr, i4, bArr2, i6, i5);
                this.f33213e += i5;
            } else {
                int length2 = bArr2.length - i6;
                System.arraycopy(bArr, i4, bArr2, i6, length2);
                int i7 = i5 - length2;
                c(i7);
                System.arraycopy(bArr, i4 + length2, this.f33212d, 0, i7);
                this.f33213e = i7;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i4) {
        e(0, i4, byteBuffer.remaining());
        byte[] bArr = new byte[i4];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : s(charset);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), t());
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return EMPTY;
        }
        return b(iterable.iterator(), size);
    }
}
