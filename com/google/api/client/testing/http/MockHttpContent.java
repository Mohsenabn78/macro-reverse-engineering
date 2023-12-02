package com.google.api.client.testing.http;

import com.google.api.client.http.HttpContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

@Beta
/* loaded from: classes5.dex */
public class MockHttpContent implements HttpContent {

    /* renamed from: b  reason: collision with root package name */
    private String f26015b;

    /* renamed from: a  reason: collision with root package name */
    private long f26014a = -1;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f26016c = new byte[0];

    public final byte[] getContent() {
        return this.f26016c;
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() throws IOException {
        return this.f26014a;
    }

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        return this.f26015b;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return true;
    }

    public MockHttpContent setContent(byte[] bArr) {
        this.f26016c = (byte[]) Preconditions.checkNotNull(bArr);
        return this;
    }

    public MockHttpContent setLength(long j4) {
        boolean z3;
        if (j4 >= -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f26014a = j4;
        return this;
    }

    public MockHttpContent setType(String str) {
        this.f26015b = str;
        return this;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.f26016c);
        outputStream.flush();
    }
}
