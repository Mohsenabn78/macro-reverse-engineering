package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
final class ReaderInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final Reader f28035a;

    /* renamed from: b  reason: collision with root package name */
    private final CharsetEncoder f28036b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f28037c;

    /* renamed from: d  reason: collision with root package name */
    private CharBuffer f28038d;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f28039e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28040f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28041g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f28042h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderInputStream(Reader reader, Charset charset, int i4) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i4);
    }

    private static int b(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    private int c(byte[] bArr, int i4, int i5) {
        int min = Math.min(i5, this.f28039e.remaining());
        this.f28039e.get(bArr, i4, min);
        return min;
    }

    private static CharBuffer d(CharBuffer charBuffer) {
        CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        Java8Compatibility.d(wrap, charBuffer.position());
        Java8Compatibility.c(wrap, charBuffer.limit());
        return wrap;
    }

    private void e() throws IOException {
        if (b(this.f28038d) == 0) {
            if (this.f28038d.position() > 0) {
                Java8Compatibility.b(this.f28038d.compact());
            } else {
                this.f28038d = d(this.f28038d);
            }
        }
        int limit = this.f28038d.limit();
        int read = this.f28035a.read(this.f28038d.array(), limit, b(this.f28038d));
        if (read == -1) {
            this.f28040f = true;
        } else {
            Java8Compatibility.c(this.f28038d, limit + read);
        }
    }

    private void f(boolean z3) {
        Java8Compatibility.b(this.f28039e);
        if (z3 && this.f28039e.remaining() == 0) {
            this.f28039e = ByteBuffer.allocate(this.f28039e.capacity() * 2);
        } else {
            this.f28041g = true;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28035a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f28037c) == 1) {
            return UnsignedBytes.toInt(this.f28037c[0]);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r2 <= 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return r2;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r8, int r9, int r10) throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r9 + r10
            int r1 = r8.length
            com.google.common.base.Preconditions.checkPositionIndexes(r9, r0, r1)
            r0 = 0
            if (r10 != 0) goto La
            return r0
        La:
            boolean r1 = r7.f28040f
            r2 = 0
        Ld:
            boolean r3 = r7.f28041g
            if (r3 == 0) goto L2e
            int r3 = r9 + r2
            int r4 = r10 - r2
            int r3 = r7.c(r8, r3, r4)
            int r2 = r2 + r3
            if (r2 == r10) goto L29
            boolean r3 = r7.f28042h
            if (r3 == 0) goto L21
            goto L29
        L21:
            r7.f28041g = r0
            java.nio.ByteBuffer r3 = r7.f28039e
            com.google.common.io.Java8Compatibility.a(r3)
            goto L2e
        L29:
            if (r2 <= 0) goto L2c
            goto L2d
        L2c:
            r2 = -1
        L2d:
            return r2
        L2e:
            boolean r3 = r7.f28042h
            if (r3 == 0) goto L35
            java.nio.charset.CoderResult r3 = java.nio.charset.CoderResult.UNDERFLOW
            goto L4c
        L35:
            if (r1 == 0) goto L40
            java.nio.charset.CharsetEncoder r3 = r7.f28036b
            java.nio.ByteBuffer r4 = r7.f28039e
            java.nio.charset.CoderResult r3 = r3.flush(r4)
            goto L4c
        L40:
            java.nio.charset.CharsetEncoder r3 = r7.f28036b
            java.nio.CharBuffer r4 = r7.f28038d
            java.nio.ByteBuffer r5 = r7.f28039e
            boolean r6 = r7.f28040f
            java.nio.charset.CoderResult r3 = r3.encode(r4, r5, r6)
        L4c:
            boolean r4 = r3.isOverflow()
            r5 = 1
            if (r4 == 0) goto L57
            r7.f(r5)
            goto Ld
        L57:
            boolean r4 = r3.isUnderflow()
            if (r4 == 0) goto L6f
            if (r1 == 0) goto L65
            r7.f28042h = r5
            r7.f(r0)
            goto Ld
        L65:
            boolean r3 = r7.f28040f
            if (r3 == 0) goto L6b
            r1 = 1
            goto L2e
        L6b:
            r7.e()
            goto L2e
        L6f:
            boolean r4 = r3.isError()
            if (r4 == 0) goto L2e
            r3.throwException()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.ReaderInputStream.read(byte[], int, int):int");
    }

    ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder, int i4) {
        this.f28037c = new byte[1];
        this.f28035a = (Reader) Preconditions.checkNotNull(reader);
        this.f28036b = (CharsetEncoder) Preconditions.checkNotNull(charsetEncoder);
        Preconditions.checkArgument(i4 > 0, "bufferSize must be positive: %s", i4);
        charsetEncoder.reset();
        CharBuffer allocate = CharBuffer.allocate(i4);
        this.f28038d = allocate;
        Java8Compatibility.b(allocate);
        this.f28039e = ByteBuffer.allocate(i4);
    }
}
