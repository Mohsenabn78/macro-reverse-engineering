package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class ByteArrayStreamingContent implements StreamingContent {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f26072a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26073b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26074c;

    public ByteArrayStreamingContent(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.f26072a, this.f26073b, this.f26074c);
        outputStream.flush();
    }

    public ByteArrayStreamingContent(byte[] bArr, int i4, int i5) {
        this.f26072a = (byte[]) Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(i4 >= 0 && i5 >= 0 && i4 + i5 <= bArr.length);
        this.f26073b = i4;
        this.f26074c = i5;
    }
}
