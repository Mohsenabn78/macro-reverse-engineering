package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.Util;

/* loaded from: classes6.dex */
public class ChunkedInputFilter extends FilteredDataEmitter {

    /* renamed from: h  reason: collision with root package name */
    private int f35260h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f35261i = 0;

    /* renamed from: j  reason: collision with root package name */
    private b f35262j = b.CHUNK_LEN;

    /* renamed from: k  reason: collision with root package name */
    ByteBufferList f35263k = new ByteBufferList();

    /* loaded from: classes6.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35264a;

        static {
            int[] iArr = new int[b.values().length];
            f35264a = iArr;
            try {
                iArr[b.CHUNK_LEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35264a[b.CHUNK_LEN_CR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35264a[b.CHUNK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35264a[b.CHUNK_CR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35264a[b.CHUNK_CRLF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35264a[b.COMPLETE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum b {
        CHUNK_LEN,
        CHUNK_LEN_CR,
        CHUNK_LEN_CRLF,
        CHUNK,
        CHUNK_CR,
        CHUNK_CRLF,
        COMPLETE
    }

    private boolean b(char c4, char c5) {
        if (c4 != c5) {
            a(new ChunkedDataException(c5 + " was expected, got " + c4));
            return false;
        }
        return true;
    }

    private boolean c(char c4) {
        return b(c4, '\r');
    }

    private boolean d(char c4) {
        return b(c4, '\n');
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.DataEmitterBase
    public void a(Exception exc) {
        if (exc == null && this.f35262j != b.COMPLETE) {
            exc = new ChunkedDataException("chunked input ended before final chunk");
        }
        super.a(exc);
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        while (byteBufferList.remaining() > 0) {
            try {
                switch (a.f35264a[this.f35262j.ordinal()]) {
                    case 1:
                        char byteChar = byteBufferList.getByteChar();
                        if (byteChar == '\r') {
                            this.f35262j = b.CHUNK_LEN_CR;
                        } else {
                            int i4 = this.f35260h * 16;
                            this.f35260h = i4;
                            if (byteChar >= 'a' && byteChar <= 'f') {
                                this.f35260h = i4 + (byteChar - 'a') + 10;
                            } else if (byteChar >= '0' && byteChar <= '9') {
                                this.f35260h = i4 + (byteChar - '0');
                            } else if (byteChar >= 'A' && byteChar <= 'F') {
                                this.f35260h = i4 + (byteChar - 'A') + 10;
                            } else {
                                a(new ChunkedDataException("invalid chunk length: " + byteChar));
                                return;
                            }
                        }
                        this.f35261i = this.f35260h;
                        break;
                    case 2:
                        if (!d(byteBufferList.getByteChar())) {
                            return;
                        }
                        this.f35262j = b.CHUNK;
                        break;
                    case 3:
                        int min = Math.min(this.f35261i, byteBufferList.remaining());
                        int i5 = this.f35261i - min;
                        this.f35261i = i5;
                        if (i5 == 0) {
                            this.f35262j = b.CHUNK_CR;
                        }
                        if (min != 0) {
                            byteBufferList.get(this.f35263k, min);
                            Util.emitAllData(this, this.f35263k);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (!c(byteBufferList.getByteChar())) {
                            return;
                        }
                        this.f35262j = b.CHUNK_CRLF;
                        break;
                    case 5:
                        if (!d(byteBufferList.getByteChar())) {
                            return;
                        }
                        if (this.f35260h > 0) {
                            this.f35262j = b.CHUNK_LEN;
                        } else {
                            this.f35262j = b.COMPLETE;
                            a(null);
                        }
                        this.f35260h = 0;
                        break;
                    case 6:
                        return;
                }
            } catch (Exception e4) {
                a(e4);
                return;
            }
        }
    }
}
