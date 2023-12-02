package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;

/* loaded from: classes3.dex */
public final class IOContext {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f17724a;

    /* renamed from: b  reason: collision with root package name */
    protected JsonEncoding f17725b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f17726c;

    /* renamed from: d  reason: collision with root package name */
    protected final BufferRecycler f17727d;

    /* renamed from: e  reason: collision with root package name */
    protected byte[] f17728e = null;

    /* renamed from: f  reason: collision with root package name */
    protected byte[] f17729f = null;

    /* renamed from: g  reason: collision with root package name */
    protected byte[] f17730g = null;

    /* renamed from: h  reason: collision with root package name */
    protected char[] f17731h = null;

    /* renamed from: i  reason: collision with root package name */
    protected char[] f17732i = null;

    /* renamed from: j  reason: collision with root package name */
    protected char[] f17733j = null;

    public IOContext(BufferRecycler bufferRecycler, Object obj, boolean z3) {
        this.f17727d = bufferRecycler;
        this.f17724a = obj;
        this.f17726c = z3;
    }

    public byte[] allocBase64Buffer() {
        if (this.f17730g == null) {
            byte[] allocByteBuffer = this.f17727d.allocByteBuffer(BufferRecycler.ByteBufferType.BASE64_CODEC_BUFFER);
            this.f17730g = allocByteBuffer;
            return allocByteBuffer;
        }
        throw new IllegalStateException("Trying to call allocBase64Buffer() second time");
    }

    public char[] allocConcatBuffer() {
        if (this.f17732i == null) {
            char[] allocCharBuffer = this.f17727d.allocCharBuffer(BufferRecycler.CharBufferType.CONCAT_BUFFER);
            this.f17732i = allocCharBuffer;
            return allocCharBuffer;
        }
        throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
    }

    public char[] allocNameCopyBuffer(int i4) {
        if (this.f17733j == null) {
            char[] allocCharBuffer = this.f17727d.allocCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, i4);
            this.f17733j = allocCharBuffer;
            return allocCharBuffer;
        }
        throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
    }

    public byte[] allocReadIOBuffer() {
        if (this.f17728e == null) {
            byte[] allocByteBuffer = this.f17727d.allocByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER);
            this.f17728e = allocByteBuffer;
            return allocByteBuffer;
        }
        throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
    }

    public char[] allocTokenBuffer() {
        if (this.f17731h == null) {
            char[] allocCharBuffer = this.f17727d.allocCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER);
            this.f17731h = allocCharBuffer;
            return allocCharBuffer;
        }
        throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
    }

    public byte[] allocWriteEncodingBuffer() {
        if (this.f17729f == null) {
            byte[] allocByteBuffer = this.f17727d.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER);
            this.f17729f = allocByteBuffer;
            return allocByteBuffer;
        }
        throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
    }

    public TextBuffer constructTextBuffer() {
        return new TextBuffer(this.f17727d);
    }

    public JsonEncoding getEncoding() {
        return this.f17725b;
    }

    public Object getSourceReference() {
        return this.f17724a;
    }

    public boolean isResourceManaged() {
        return this.f17726c;
    }

    public void releaseBase64Buffer(byte[] bArr) {
        if (bArr != null) {
            if (bArr == this.f17730g) {
                this.f17730g = null;
                this.f17727d.releaseByteBuffer(BufferRecycler.ByteBufferType.BASE64_CODEC_BUFFER, bArr);
                return;
            }
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
    }

    public void releaseConcatBuffer(char[] cArr) {
        if (cArr != null) {
            if (cArr == this.f17732i) {
                this.f17732i = null;
                this.f17727d.releaseCharBuffer(BufferRecycler.CharBufferType.CONCAT_BUFFER, cArr);
                return;
            }
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
    }

    public void releaseNameCopyBuffer(char[] cArr) {
        if (cArr != null) {
            if (cArr == this.f17733j) {
                this.f17733j = null;
                this.f17727d.releaseCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, cArr);
                return;
            }
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
    }

    public void releaseReadIOBuffer(byte[] bArr) {
        if (bArr != null) {
            if (bArr == this.f17728e) {
                this.f17728e = null;
                this.f17727d.releaseByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER, bArr);
                return;
            }
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
    }

    public void releaseTokenBuffer(char[] cArr) {
        if (cArr != null) {
            if (cArr == this.f17731h) {
                this.f17731h = null;
                this.f17727d.releaseCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER, cArr);
                return;
            }
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
    }

    public void releaseWriteEncodingBuffer(byte[] bArr) {
        if (bArr != null) {
            if (bArr == this.f17729f) {
                this.f17729f = null;
                this.f17727d.releaseByteBuffer(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER, bArr);
                return;
            }
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
    }

    public void setEncoding(JsonEncoding jsonEncoding) {
        this.f17725b = jsonEncoding;
    }
}
