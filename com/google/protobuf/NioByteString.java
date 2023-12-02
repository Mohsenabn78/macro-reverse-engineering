package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NioByteString(ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer B(int i4, int i5) {
        if (i4 >= this.buffer.position() && i5 <= this.buffer.limit() && i4 <= i5) {
            ByteBuffer slice = this.buffer.slice();
            slice.position(i4 - this.buffer.position());
            slice.limit(i5 - this.buffer.position());
            return slice;
        }
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i4) {
        try {
            return this.buffer.get(i4);
        } catch (ArrayIndexOutOfBoundsException e4) {
            throw e4;
        } catch (IndexOutOfBoundsException e5) {
            throw new ArrayIndexOutOfBoundsException(e5.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
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
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public void f(byte[] bArr, int i4, int i5, int i6) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i4);
        slice.get(bArr, i5, i6);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.s(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public byte j(int i4) {
        return byteAt(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int n(int i4, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + this.buffer.get(i7);
        }
        return i4;
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.b(this.buffer, true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new InputStream() { // from class: com.google.protobuf.NioByteString.1

            /* renamed from: a  reason: collision with root package name */
            private final ByteBuffer f33505a;

            {
                this.f33505a = NioByteString.this.buffer.slice();
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                return this.f33505a.remaining();
            }

            @Override // java.io.InputStream
            public void mark(int i4) {
                this.f33505a.mark();
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (this.f33505a.hasRemaining()) {
                    return this.f33505a.get() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public void reset() throws IOException {
                try {
                    this.f33505a.reset();
                } catch (InvalidMarkException e4) {
                    throw new IOException(e4);
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i4, int i5) throws IOException {
                if (this.f33505a.hasRemaining()) {
                    int min = Math.min(i5, this.f33505a.remaining());
                    this.f33505a.get(bArr, i4, min);
                    return min;
                }
                return -1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int o(int i4, int i5, int i6) {
        return Utf8.v(i4, this.buffer, i5, i6 + i5);
    }

    @Override // com.google.protobuf.ByteString
    protected String s(Charset charset) {
        byte[] byteArray;
        int length;
        int i4;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            i4 = this.buffer.arrayOffset() + this.buffer.position();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            length = byteArray.length;
            i4 = 0;
        }
        return new String(byteArray, i4, length, charset);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i4, int i5) {
        try {
            return new NioByteString(B(i4, i5));
        } catch (ArrayIndexOutOfBoundsException e4) {
            throw e4;
        } catch (IndexOutOfBoundsException e5) {
            throw new ArrayIndexOutOfBoundsException(e5.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void x(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString.LeafByteString
    public boolean z(ByteString byteString, int i4, int i5) {
        return substring(0, i5).equals(byteString.substring(i4, i5 + i4));
    }
}
