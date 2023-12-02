package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class ByteArrayContent extends AbstractInputStreamContent {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f25754c;

    /* renamed from: d  reason: collision with root package name */
    private final int f25755d;

    /* renamed from: e  reason: collision with root package name */
    private final int f25756e;

    public ByteArrayContent(String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }

    public static ByteArrayContent fromString(String str, String str2) {
        return new ByteArrayContent(str, StringUtils.getBytesUtf8(str2));
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f25754c, this.f25755d, this.f25756e);
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        return this.f25756e;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return true;
    }

    public ByteArrayContent(String str, byte[] bArr, int i4, int i5) {
        super(str);
        this.f25754c = (byte[]) Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(i4 >= 0 && i5 >= 0 && i4 + i5 <= bArr.length, "offset %s, length %s, array length %s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(bArr.length));
        this.f25755d = i4;
        this.f25756e = i5;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public ByteArrayContent setCloseInputStream(boolean z3) {
        return (ByteArrayContent) super.setCloseInputStream(z3);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public ByteArrayContent setType(String str) {
        return (ByteArrayContent) super.setType(str);
    }
}
