package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public final class LoggingStreamingContent implements StreamingContent {

    /* renamed from: a  reason: collision with root package name */
    private final StreamingContent f26136a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26137b;

    /* renamed from: c  reason: collision with root package name */
    private final Level f26138c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f26139d;

    public LoggingStreamingContent(StreamingContent streamingContent, Logger logger, Level level, int i4) {
        this.f26136a = streamingContent;
        this.f26139d = logger;
        this.f26138c = level;
        this.f26137b = i4;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        LoggingOutputStream loggingOutputStream = new LoggingOutputStream(outputStream, this.f26139d, this.f26138c, this.f26137b);
        try {
            this.f26136a.writeTo(loggingOutputStream);
            loggingOutputStream.getLogStream().close();
            outputStream.flush();
        } catch (Throwable th) {
            loggingOutputStream.getLogStream().close();
            throw th;
        }
    }
}
