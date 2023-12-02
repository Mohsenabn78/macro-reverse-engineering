package com.google.firebase.storage;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public class StreamDownloadTask extends StorageTask<TaskSnapshot> {

    /* renamed from: l  reason: collision with root package name */
    private StorageReference f32280l;

    /* renamed from: m  reason: collision with root package name */
    private ExponentialBackoffSender f32281m;

    /* renamed from: p  reason: collision with root package name */
    private StreamProcessor f32284p;

    /* renamed from: r  reason: collision with root package name */
    private long f32286r;

    /* renamed from: s  reason: collision with root package name */
    private long f32287s;

    /* renamed from: t  reason: collision with root package name */
    private InputStream f32288t;

    /* renamed from: u  reason: collision with root package name */
    private NetworkRequest f32289u;

    /* renamed from: v  reason: collision with root package name */
    private String f32290v;

    /* renamed from: n  reason: collision with root package name */
    private volatile Exception f32282n = null;

    /* renamed from: o  reason: collision with root package name */
    private volatile int f32283o = 0;

    /* renamed from: q  reason: collision with root package name */
    private long f32285q = -1;

    /* loaded from: classes5.dex */
    public interface StreamProcessor {
        void doInBackground(@NonNull TaskSnapshot taskSnapshot, @NonNull InputStream inputStream) throws IOException;
    }

    /* loaded from: classes5.dex */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {

        /* renamed from: c  reason: collision with root package name */
        private final long f32299c;

        TaskSnapshot(Exception exc, long j4) {
            super(exc);
            this.f32299c = j4;
        }

        public long getBytesTransferred() {
            return this.f32299c;
        }

        @NonNull
        public InputStream getStream() {
            return StreamDownloadTask.this.f32288t;
        }

        public long getTotalByteCount() {
            return StreamDownloadTask.this.U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamDownloadTask(@NonNull StorageReference storageReference) {
        this.f32280l = storageReference;
        FirebaseStorage storage = storageReference.getStorage();
        this.f32281m = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.b(), storage.a(), storage.getMaxDownloadRetryTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream T() throws Exception {
        Exception exc;
        String str;
        this.f32281m.reset();
        NetworkRequest networkRequest = this.f32289u;
        if (networkRequest != null) {
            networkRequest.performRequestEnd();
        }
        GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.f32280l.c(), this.f32280l.b(), this.f32286r);
        this.f32289u = getNetworkRequest;
        boolean z3 = false;
        this.f32281m.sendWithExponentialBackoff(getNetworkRequest, false);
        this.f32283o = this.f32289u.getResultCode();
        if (this.f32289u.getException() != null) {
            exc = this.f32289u.getException();
        } else {
            exc = this.f32282n;
        }
        this.f32282n = exc;
        if (V(this.f32283o) && this.f32282n == null && m() == 4) {
            z3 = true;
        }
        if (z3) {
            String resultString = this.f32289u.getResultString(HttpHeaders.ETAG);
            if (!TextUtils.isEmpty(resultString) && (str = this.f32290v) != null && !str.equals(resultString)) {
                this.f32283o = 409;
                throw new IOException("The ETag on the server changed.");
            }
            this.f32290v = resultString;
            this.f32285q = this.f32289u.getResultingContentLength() + this.f32286r;
            return this.f32289u.getStream();
        }
        throw new IOException("Could not open resulting stream.");
    }

    private boolean V(int i4) {
        if (i4 != 308 && (i4 < 200 || i4 >= 300)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.storage.StorageTask
    public void A() {
        this.f32281m.cancel();
        this.f32282n = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void D() {
        this.f32287s = this.f32286r;
    }

    @Override // com.google.firebase.storage.StorageTask
    void I() {
        boolean z3;
        int i4 = 64;
        if (this.f32282n != null) {
            N(64, false);
        } else if (!N(4, false)) {
        } else {
            StreamProgressWrapper streamProgressWrapper = new StreamProgressWrapper(new Callable<InputStream>() { // from class: com.google.firebase.storage.StreamDownloadTask.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public InputStream call() throws Exception {
                    return StreamDownloadTask.this.T();
                }
            }, this);
            this.f32288t = new BufferedInputStream(streamProgressWrapper);
            try {
                streamProgressWrapper.d();
                StreamProcessor streamProcessor = this.f32284p;
                if (streamProcessor != null) {
                    try {
                        streamProcessor.doInBackground(K(), this.f32288t);
                    } catch (Exception e4) {
                        Log.w("StreamDownloadTask", "Exception occurred calling doInBackground.", e4);
                        this.f32282n = e4;
                    }
                }
            } catch (IOException e5) {
                this.f32282n = e5;
            }
            if (this.f32288t == null) {
                this.f32289u.performRequestEnd();
                this.f32289u = null;
            }
            if (this.f32282n == null && m() == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                N(4, false);
                N(128, false);
                return;
            }
            if (m() == 32) {
                i4 = 256;
            }
            if (!N(i4, false)) {
                Log.w("StreamDownloadTask", "Unable to change download task to final state from " + m());
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void J() {
        StorageTaskScheduler.getInstance().scheduleDownload(n());
    }

    long U() {
        return this.f32285q;
    }

    void W(long j4) {
        long j5 = this.f32286r + j4;
        this.f32286r = j5;
        if (this.f32287s + PlaybackStateCompat.ACTION_SET_REPEAT_MODE <= j5) {
            if (m() == 4) {
                N(4, false);
            } else {
                this.f32287s = this.f32286r;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamDownloadTask X(@NonNull StreamProcessor streamProcessor) {
        boolean z3;
        Preconditions.checkNotNull(streamProcessor);
        if (this.f32284p == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        this.f32284p = streamProcessor;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    @NonNull
    /* renamed from: Y */
    public TaskSnapshot L() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.f32282n, this.f32283o), this.f32287s);
    }

    @Override // com.google.firebase.storage.StorageTask, com.google.firebase.storage.ControllableTask
    public boolean pause() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    @NonNull
    public StorageReference q() {
        return this.f32280l;
    }

    @Override // com.google.firebase.storage.StorageTask, com.google.firebase.storage.ControllableTask
    public boolean resume() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    /* loaded from: classes5.dex */
    static class StreamProgressWrapper extends InputStream {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private StreamDownloadTask f32292a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private InputStream f32293b;

        /* renamed from: c  reason: collision with root package name */
        private Callable<InputStream> f32294c;

        /* renamed from: d  reason: collision with root package name */
        private IOException f32295d;

        /* renamed from: e  reason: collision with root package name */
        private long f32296e;

        /* renamed from: f  reason: collision with root package name */
        private long f32297f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f32298g;

        StreamProgressWrapper(@NonNull Callable<InputStream> callable, @Nullable StreamDownloadTask streamDownloadTask) {
            this.f32292a = streamDownloadTask;
            this.f32294c = callable;
        }

        private void c() throws IOException {
            StreamDownloadTask streamDownloadTask = this.f32292a;
            if (streamDownloadTask != null && streamDownloadTask.m() == 32) {
                throw new CancelException();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() throws IOException {
            c();
            if (this.f32295d != null) {
                try {
                    InputStream inputStream = this.f32293b;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException unused) {
                }
                this.f32293b = null;
                if (this.f32297f == this.f32296e) {
                    Log.i("StreamDownloadTask", "Encountered exception during stream operation. Aborting.", this.f32295d);
                    return false;
                }
                Log.i("StreamDownloadTask", "Encountered exception during stream operation. Retrying at " + this.f32296e, this.f32295d);
                this.f32297f = this.f32296e;
                this.f32295d = null;
            }
            if (!this.f32298g) {
                if (this.f32293b == null) {
                    try {
                        this.f32293b = this.f32294c.call();
                        return true;
                    } catch (Exception e4) {
                        if (e4 instanceof IOException) {
                            throw ((IOException) e4);
                        }
                        throw new IOException("Unable to open stream", e4);
                    }
                }
                return true;
            }
            throw new IOException("Can't perform operation on closed stream");
        }

        private void e(long j4) {
            StreamDownloadTask streamDownloadTask = this.f32292a;
            if (streamDownloadTask != null) {
                streamDownloadTask.W(j4);
            }
            this.f32296e += j4;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            while (d()) {
                try {
                    return this.f32293b.available();
                } catch (IOException e4) {
                    this.f32295d = e4;
                }
            }
            throw this.f32295d;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.f32293b;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f32298g = true;
            StreamDownloadTask streamDownloadTask = this.f32292a;
            if (streamDownloadTask != null && streamDownloadTask.f32289u != null) {
                this.f32292a.f32289u.performRequestEnd();
                this.f32292a.f32289u = null;
            }
            c();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            while (d()) {
                try {
                    int read = this.f32293b.read();
                    if (read != -1) {
                        e(1L);
                    }
                    return read;
                } catch (IOException e4) {
                    this.f32295d = e4;
                }
            }
            throw this.f32295d;
        }

        @Override // java.io.InputStream
        public long skip(long j4) throws IOException {
            long j5 = 0;
            while (d()) {
                while (j4 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    try {
                        long skip = this.f32293b.skip(PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
                        if (skip < 0) {
                            if (j5 == 0) {
                                return -1L;
                            }
                            return j5;
                        }
                        j5 += skip;
                        j4 -= skip;
                        e(skip);
                        c();
                    } catch (IOException e4) {
                        this.f32295d = e4;
                    }
                }
                if (j4 > 0) {
                    long skip2 = this.f32293b.skip(j4);
                    if (skip2 < 0) {
                        if (j5 == 0) {
                            return -1L;
                        }
                        return j5;
                    }
                    j5 += skip2;
                    j4 -= skip2;
                    e(skip2);
                }
                if (j4 == 0) {
                    return j5;
                }
            }
            throw this.f32295d;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
            int i6 = 0;
            while (d()) {
                while (i5 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    try {
                        int read = this.f32293b.read(bArr, i4, 262144);
                        if (read == -1) {
                            if (i6 == 0) {
                                return -1;
                            }
                            return i6;
                        }
                        i6 += read;
                        i4 += read;
                        i5 -= read;
                        e(read);
                        c();
                    } catch (IOException e4) {
                        this.f32295d = e4;
                    }
                }
                if (i5 > 0) {
                    int read2 = this.f32293b.read(bArr, i4, i5);
                    if (read2 == -1) {
                        if (i6 == 0) {
                            return -1;
                        }
                        return i6;
                    }
                    i4 += read2;
                    i6 += read2;
                    i5 -= read2;
                    e(read2);
                }
                if (i5 == 0) {
                    return i6;
                }
            }
            throw this.f32295d;
        }

        @Override // java.io.InputStream
        public void mark(int i4) {
        }
    }
}
