package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class InputStreamContent extends AbstractInputStreamContent {

    /* renamed from: c  reason: collision with root package name */
    private long f25835c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25836d;

    /* renamed from: e  reason: collision with root package name */
    private final InputStream f25837e;

    public InputStreamContent(String str, InputStream inputStream) {
        super(str);
        this.f25835c = -1L;
        this.f25837e = (InputStream) Preconditions.checkNotNull(inputStream);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream getInputStream() {
        return this.f25837e;
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        return this.f25835c;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return this.f25836d;
    }

    public InputStreamContent setLength(long j4) {
        this.f25835c = j4;
        return this;
    }

    public InputStreamContent setRetrySupported(boolean z3) {
        this.f25836d = z3;
        return this;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStreamContent setCloseInputStream(boolean z3) {
        return (InputStreamContent) super.setCloseInputStream(z3);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStreamContent setType(String str) {
        return (InputStreamContent) super.setType(str);
    }
}
