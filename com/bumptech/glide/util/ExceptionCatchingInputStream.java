package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes3.dex */
public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final Queue<ExceptionCatchingInputStream> f17569c = Util.createQueue(0);

    /* renamed from: a  reason: collision with root package name */
    private InputStream f17570a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f17571b;

    ExceptionCatchingInputStream() {
    }

    @NonNull
    public static ExceptionCatchingInputStream obtain(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        Queue<ExceptionCatchingInputStream> queue = f17569c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.b(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f17570a.available();
    }

    void b(@NonNull InputStream inputStream) {
        this.f17570a = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f17570a.close();
    }

    @Nullable
    public IOException getException() {
        return this.f17571b;
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        this.f17570a.mark(i4);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f17570a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f17570a.read(bArr);
        } catch (IOException e4) {
            this.f17571b = e4;
            return -1;
        }
    }

    public void release() {
        this.f17571b = null;
        this.f17570a = null;
        Queue<ExceptionCatchingInputStream> queue = f17569c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f17570a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j4) {
        try {
            return this.f17570a.skip(j4);
        } catch (IOException e4) {
            this.f17571b = e4;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        try {
            return this.f17570a.read(bArr, i4, i5);
        } catch (IOException e4) {
            this.f17571b = e4;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f17570a.read();
        } catch (IOException e4) {
            this.f17571b = e4;
            return -1;
        }
    }
}
