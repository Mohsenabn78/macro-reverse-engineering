package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: WriteTimeoutSocket.java */
/* loaded from: classes6.dex */
class TimeoutOutputStream extends OutputStream {

    /* renamed from: b1  reason: collision with root package name */
    private byte[] f37955b1;
    private final OutputStream os;
    private final ScheduledExecutorService ses;
    private final int timeout;
    private final Callable<Object> timeoutTask = new Callable<Object>() { // from class: com.sun.mail.util.TimeoutOutputStream.1
        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            TimeoutOutputStream.this.os.close();
            return null;
        }
    };

    public TimeoutOutputStream(OutputStream outputStream, ScheduledExecutorService scheduledExecutorService, int i4) throws IOException {
        this.os = outputStream;
        this.ses = scheduledExecutorService;
        this.timeout = i4;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.os.close();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i4) throws IOException {
        if (this.f37955b1 == null) {
            this.f37955b1 = new byte[1];
        }
        byte[] bArr = this.f37955b1;
        bArr[0] = (byte) i4;
        write(bArr);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i4, int i5) throws IOException {
        int i6;
        if (i4 >= 0) {
            if (i4 <= bArr.length && i5 >= 0 && (i6 = i4 + i5) <= bArr.length && i6 >= 0) {
                if (i5 == 0) {
                    return;
                }
                ScheduledFuture scheduledFuture = null;
                try {
                    int i7 = this.timeout;
                    if (i7 > 0) {
                        scheduledFuture = this.ses.schedule(this.timeoutTask, i7, TimeUnit.MILLISECONDS);
                    }
                } catch (RejectedExecutionException unused) {
                }
                this.os.write(bArr, i4, i5);
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
