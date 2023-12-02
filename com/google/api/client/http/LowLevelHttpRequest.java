package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class LowLevelHttpRequest {

    /* renamed from: a  reason: collision with root package name */
    private long f25838a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f25839b;

    /* renamed from: c  reason: collision with root package name */
    private String f25840c;

    /* renamed from: d  reason: collision with root package name */
    private StreamingContent f25841d;

    public abstract void addHeader(String str, String str2) throws IOException;

    public abstract LowLevelHttpResponse execute() throws IOException;

    public final String getContentEncoding() {
        return this.f25839b;
    }

    public final long getContentLength() {
        return this.f25838a;
    }

    public final String getContentType() {
        return this.f25840c;
    }

    public final StreamingContent getStreamingContent() {
        return this.f25841d;
    }

    public final void setContentEncoding(String str) throws IOException {
        this.f25839b = str;
    }

    public final void setContentLength(long j4) throws IOException {
        this.f25838a = j4;
    }

    public final void setContentType(String str) throws IOException {
        this.f25840c = str;
    }

    public final void setStreamingContent(StreamingContent streamingContent) throws IOException {
        this.f25841d = streamingContent;
    }

    public void setTimeout(int i4, int i5) throws IOException {
    }
}
