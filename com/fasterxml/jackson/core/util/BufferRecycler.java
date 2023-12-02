package com.fasterxml.jackson.core.util;

import com.google.android.gms.wearable.WearableStatusCodes;

/* loaded from: classes3.dex */
public class BufferRecycler {
    public static final int DEFAULT_WRITE_CONCAT_BUFFER_LEN = 2000;

    /* renamed from: a  reason: collision with root package name */
    protected final byte[][] f17878a = new byte[ByteBufferType.values().length];

    /* renamed from: b  reason: collision with root package name */
    protected final char[][] f17879b = new char[CharBufferType.values().length];

    /* loaded from: classes3.dex */
    public enum ByteBufferType {
        READ_IO_BUFFER(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED),
        WRITE_ENCODING_BUFFER(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED),
        WRITE_CONCAT_BUFFER(2000),
        BASE64_CODEC_BUFFER(2000);
        
        protected final int size;

        ByteBufferType(int i4) {
            this.size = i4;
        }
    }

    /* loaded from: classes3.dex */
    public enum CharBufferType {
        TOKEN_BUFFER(2000),
        CONCAT_BUFFER(2000),
        TEXT_BUFFER(200),
        NAME_COPY_BUFFER(200);
        
        protected final int size;

        CharBufferType(int i4) {
            this.size = i4;
        }
    }

    private byte[] a(int i4) {
        return new byte[i4];
    }

    private char[] b(int i4) {
        return new char[i4];
    }

    public final byte[] allocByteBuffer(ByteBufferType byteBufferType) {
        int ordinal = byteBufferType.ordinal();
        byte[][] bArr = this.f17878a;
        byte[] bArr2 = bArr[ordinal];
        if (bArr2 == null) {
            return a(byteBufferType.size);
        }
        bArr[ordinal] = null;
        return bArr2;
    }

    public final char[] allocCharBuffer(CharBufferType charBufferType) {
        return allocCharBuffer(charBufferType, 0);
    }

    public final void releaseByteBuffer(ByteBufferType byteBufferType, byte[] bArr) {
        this.f17878a[byteBufferType.ordinal()] = bArr;
    }

    public final void releaseCharBuffer(CharBufferType charBufferType, char[] cArr) {
        this.f17879b[charBufferType.ordinal()] = cArr;
    }

    public final char[] allocCharBuffer(CharBufferType charBufferType, int i4) {
        int i5 = charBufferType.size;
        if (i5 > i4) {
            i4 = i5;
        }
        int ordinal = charBufferType.ordinal();
        char[][] cArr = this.f17879b;
        char[] cArr2 = cArr[ordinal];
        if (cArr2 != null && cArr2.length >= i4) {
            cArr[ordinal] = null;
            return cArr2;
        }
        return b(i4);
    }
}
