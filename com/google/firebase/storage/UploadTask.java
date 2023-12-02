package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.AdaptiveStreamBuffer;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.Sleeper;
import com.google.firebase.storage.internal.SleeperImpl;
import com.google.firebase.storage.internal.StorageReferenceUri;
import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.ResumableUploadByteRequest;
import com.google.firebase.storage.network.ResumableUploadCancelRequest;
import com.google.firebase.storage.network.ResumableUploadQueryRequest;
import com.google.firebase.storage.network.ResumableUploadStartRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class UploadTask extends StorageTask<TaskSnapshot> {
    private static final Random E = new Random();
    static Sleeper F = new SleeperImpl();
    static Clock G = DefaultClock.getInstance();
    private volatile String A;
    private volatile long B;
    private int C;
    private final int D;

    /* renamed from: l  reason: collision with root package name */
    private final StorageReference f32311l;

    /* renamed from: m  reason: collision with root package name */
    private final Uri f32312m;

    /* renamed from: n  reason: collision with root package name */
    private final long f32313n;

    /* renamed from: o  reason: collision with root package name */
    private final AdaptiveStreamBuffer f32314o;

    /* renamed from: p  reason: collision with root package name */
    private final AtomicLong f32315p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private final InternalAuthProvider f32316q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private final InteropAppCheckTokenProvider f32317r;

    /* renamed from: s  reason: collision with root package name */
    private int f32318s;

    /* renamed from: t  reason: collision with root package name */
    private ExponentialBackoffSender f32319t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f32320u;

    /* renamed from: v  reason: collision with root package name */
    private volatile StorageMetadata f32321v;

    /* renamed from: w  reason: collision with root package name */
    private volatile Uri f32322w;

    /* renamed from: x  reason: collision with root package name */
    private volatile Exception f32323x;

    /* renamed from: y  reason: collision with root package name */
    private volatile Exception f32324y;

    /* renamed from: z  reason: collision with root package name */
    private volatile int f32325z;

    /* loaded from: classes5.dex */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {

        /* renamed from: c  reason: collision with root package name */
        private final long f32328c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f32329d;

        /* renamed from: e  reason: collision with root package name */
        private final StorageMetadata f32330e;

        TaskSnapshot(Exception exc, long j4, Uri uri, StorageMetadata storageMetadata) {
            super(exc);
            this.f32328c = j4;
            this.f32329d = uri;
            this.f32330e = storageMetadata;
        }

        public long getBytesTransferred() {
            return this.f32328c;
        }

        @Nullable
        public StorageMetadata getMetadata() {
            return this.f32330e;
        }

        public long getTotalByteCount() {
            return UploadTask.this.U();
        }

        @Nullable
        public Uri getUploadSessionUri() {
            return this.f32329d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        this.f32315p = new AtomicLong(0L);
        this.f32318s = 262144;
        this.f32322w = null;
        this.f32323x = null;
        this.f32324y = null;
        this.f32325z = 0;
        this.C = 0;
        this.D = 1000;
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(bArr);
        FirebaseStorage storage = storageReference.getStorage();
        this.f32313n = bArr.length;
        this.f32311l = storageReference;
        this.f32321v = storageMetadata;
        InternalAuthProvider b4 = storage.b();
        this.f32316q = b4;
        InteropAppCheckTokenProvider a4 = storage.a();
        this.f32317r = a4;
        this.f32312m = null;
        this.f32314o = new AdaptiveStreamBuffer(new ByteArrayInputStream(bArr), 262144);
        this.f32320u = true;
        this.B = storage.getMaxChunkUploadRetry();
        this.f32319t = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), b4, a4, storage.getMaxDownloadRetryTimeMillis());
    }

    private void S() {
        String str;
        JSONObject jSONObject = null;
        if (this.f32321v != null) {
            str = this.f32321v.getContentType();
        } else {
            str = null;
        }
        if (this.f32312m != null && TextUtils.isEmpty(str)) {
            str = this.f32311l.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.f32312m);
        }
        if (TextUtils.isEmpty(str)) {
            str = "application/octet-stream";
        }
        StorageReferenceUri c4 = this.f32311l.c();
        FirebaseApp b4 = this.f32311l.b();
        if (this.f32321v != null) {
            jSONObject = this.f32321v.v();
        }
        ResumableUploadStartRequest resumableUploadStartRequest = new ResumableUploadStartRequest(c4, b4, jSONObject, str);
        if (!Z(resumableUploadStartRequest)) {
            return;
        }
        String resultString = resumableUploadStartRequest.getResultString("X-Goog-Upload-URL");
        if (!TextUtils.isEmpty(resultString)) {
            this.f32322w = Uri.parse(resultString);
        }
    }

    private boolean T(NetworkRequest networkRequest) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Waiting ");
            sb.append(this.C);
            sb.append(" milliseconds");
            F.sleep(this.C + E.nextInt(250));
            boolean Y = Y(networkRequest);
            if (Y) {
                this.C = 0;
            }
            return Y;
        } catch (InterruptedException e4) {
            Log.w("UploadTask", "thread interrupted during exponential backoff.");
            Thread.currentThread().interrupt();
            this.f32324y = e4;
            return false;
        }
    }

    private boolean V(int i4) {
        if (i4 != 308 && (i4 < 200 || i4 >= 300)) {
            return false;
        }
        return true;
    }

    private boolean W(NetworkRequest networkRequest) {
        int resultCode = networkRequest.getResultCode();
        if (this.f32319t.isRetryableError(resultCode)) {
            resultCode = -2;
        }
        this.f32325z = resultCode;
        this.f32324y = networkRequest.getException();
        this.A = networkRequest.getResultString("X-Goog-Upload-Status");
        if (V(this.f32325z) && this.f32324y == null) {
            return true;
        }
        return false;
    }

    private boolean X(boolean z3) {
        long j4;
        ResumableUploadQueryRequest resumableUploadQueryRequest = new ResumableUploadQueryRequest(this.f32311l.c(), this.f32311l.b(), this.f32322w);
        if ("final".equals(this.A)) {
            return false;
        }
        if (z3) {
            if (!Z(resumableUploadQueryRequest)) {
                return false;
            }
        } else if (!Y(resumableUploadQueryRequest)) {
            return false;
        }
        if ("final".equals(resumableUploadQueryRequest.getResultString("X-Goog-Upload-Status"))) {
            this.f32323x = new IOException("The server has terminated the upload session");
            return false;
        }
        String resultString = resumableUploadQueryRequest.getResultString("X-Goog-Upload-Size-Received");
        if (!TextUtils.isEmpty(resultString)) {
            j4 = Long.parseLong(resultString);
        } else {
            j4 = 0;
        }
        long j5 = this.f32315p.get();
        int i4 = (j5 > j4 ? 1 : (j5 == j4 ? 0 : -1));
        if (i4 > 0) {
            this.f32323x = new IOException("Unexpected error. The server lost a chunk update.");
            return false;
        } else if (i4 < 0) {
            try {
                long j6 = j4 - j5;
                if (this.f32314o.advance((int) j6) != j6) {
                    this.f32323x = new IOException("Unexpected end of stream encountered.");
                    return false;
                } else if (!this.f32315p.compareAndSet(j5, j4)) {
                    Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                    this.f32323x = new IllegalStateException("uploaded bytes changed unexpectedly.");
                    return false;
                } else {
                    return true;
                }
            } catch (IOException e4) {
                Log.e("UploadTask", "Unable to recover position in Stream during resumable upload", e4);
                this.f32323x = e4;
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean Y(NetworkRequest networkRequest) {
        networkRequest.performRequest(Util.getCurrentAuthToken(this.f32316q), Util.getCurrentAppCheckToken(this.f32317r), this.f32311l.b().getApplicationContext());
        return W(networkRequest);
    }

    private boolean Z(NetworkRequest networkRequest) {
        this.f32319t.sendWithExponentialBackoff(networkRequest);
        return W(networkRequest);
    }

    private boolean a0() {
        if ("final".equals(this.A)) {
            if (this.f32323x == null) {
                this.f32323x = new IOException("The server has terminated the upload session", this.f32324y);
            }
            N(64, false);
            return false;
        }
        return true;
    }

    private boolean b0() {
        boolean z3;
        if (m() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.f32323x = new InterruptedException();
            N(64, false);
            return false;
        } else if (m() == 32) {
            N(256, false);
            return false;
        } else if (m() == 8) {
            N(16, false);
            return false;
        } else if (!a0()) {
            return false;
        } else {
            if (this.f32322w == null) {
                if (this.f32323x == null) {
                    this.f32323x = new IllegalStateException("Unable to obtain an upload URL.");
                }
                N(64, false);
                return false;
            } else if (this.f32323x != null) {
                N(64, false);
                return false;
            } else {
                if (this.f32324y == null && this.f32325z >= 200 && this.f32325z < 300) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                long elapsedRealtime = G.elapsedRealtime() + this.B;
                long elapsedRealtime2 = G.elapsedRealtime() + this.C;
                if (z3) {
                    if (elapsedRealtime2 <= elapsedRealtime && X(true)) {
                        this.C = Math.max(this.C * 2, 1000);
                    } else {
                        if (a0()) {
                            N(64, false);
                        }
                        return false;
                    }
                }
                return true;
            }
        }
    }

    private void d0() {
        try {
            this.f32314o.fill(this.f32318s);
            int min = Math.min(this.f32318s, this.f32314o.available());
            ResumableUploadByteRequest resumableUploadByteRequest = new ResumableUploadByteRequest(this.f32311l.c(), this.f32311l.b(), this.f32322w, this.f32314o.get(), this.f32315p.get(), min, this.f32314o.isFinished());
            if (!T(resumableUploadByteRequest)) {
                this.f32318s = 262144;
                StringBuilder sb = new StringBuilder();
                sb.append("Resetting chunk size to ");
                sb.append(this.f32318s);
                return;
            }
            this.f32315p.getAndAdd(min);
            if (!this.f32314o.isFinished()) {
                this.f32314o.advance(min);
                int i4 = this.f32318s;
                if (i4 < 33554432) {
                    this.f32318s = i4 * 2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Increasing chunk size to ");
                    sb2.append(this.f32318s);
                    return;
                }
                return;
            }
            try {
                this.f32321v = new StorageMetadata.Builder(resumableUploadByteRequest.getResultBody(), this.f32311l).build();
                N(4, false);
                N(128, false);
            } catch (JSONException e4) {
                Log.e("UploadTask", "Unable to parse resulting metadata from upload:" + resumableUploadByteRequest.getRawResult(), e4);
                this.f32323x = e4;
            }
        } catch (IOException e5) {
            Log.e("UploadTask", "Unable to read bytes for uploading", e5);
            this.f32323x = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.storage.StorageTask
    public void A() {
        final ResumableUploadCancelRequest resumableUploadCancelRequest;
        this.f32319t.cancel();
        if (this.f32322w != null) {
            resumableUploadCancelRequest = new ResumableUploadCancelRequest(this.f32311l.c(), this.f32311l.b(), this.f32322w);
        } else {
            resumableUploadCancelRequest = null;
        }
        if (resumableUploadCancelRequest != null) {
            StorageTaskScheduler.getInstance().scheduleCommand(new Runnable() { // from class: com.google.firebase.storage.UploadTask.1
                @Override // java.lang.Runnable
                public void run() {
                    resumableUploadCancelRequest.performRequest(Util.getCurrentAuthToken(UploadTask.this.f32316q), Util.getCurrentAppCheckToken(UploadTask.this.f32317r), UploadTask.this.f32311l.b().getApplicationContext());
                }
            });
        }
        this.f32323x = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
        super.A();
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void H() {
        this.f32323x = null;
        this.f32324y = null;
        this.f32325z = 0;
        this.A = null;
    }

    @Override // com.google.firebase.storage.StorageTask
    void I() {
        this.f32319t.reset();
        if (!N(4, false)) {
            return;
        }
        if (this.f32311l.getParent() == null) {
            this.f32323x = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
        }
        if (this.f32323x != null) {
            return;
        }
        if (this.f32322w == null) {
            S();
        } else {
            X(false);
        }
        boolean b02 = b0();
        while (b02) {
            d0();
            b02 = b0();
            if (b02) {
                N(4, false);
            }
        }
        if (this.f32320u && m() != 16) {
            try {
                this.f32314o.close();
            } catch (IOException e4) {
                Log.e("UploadTask", "Unable to close stream.", e4);
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void J() {
        StorageTaskScheduler.getInstance().scheduleUpload(n());
    }

    long U() {
        return this.f32313n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    @NonNull
    /* renamed from: c0 */
    public TaskSnapshot L() {
        Exception exc;
        if (this.f32323x != null) {
            exc = this.f32323x;
        } else {
            exc = this.f32324y;
        }
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(exc, this.f32325z), this.f32315p.get(), this.f32322w, this.f32321v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    public StorageReference q() {
        return this.f32311l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [long] */
    /* JADX WARN: Type inference failed for: r5v9, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UploadTask(com.google.firebase.storage.StorageReference r11, com.google.firebase.storage.StorageMetadata r12, android.net.Uri r13, android.net.Uri r14) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.UploadTask.<init>(com.google.firebase.storage.StorageReference, com.google.firebase.storage.StorageMetadata, android.net.Uri, android.net.Uri):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, InputStream inputStream) {
        this.f32315p = new AtomicLong(0L);
        this.f32318s = 262144;
        this.f32322w = null;
        this.f32323x = null;
        this.f32324y = null;
        this.f32325z = 0;
        this.C = 0;
        this.D = 1000;
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(inputStream);
        FirebaseStorage storage = storageReference.getStorage();
        this.f32313n = -1L;
        this.f32311l = storageReference;
        this.f32321v = storageMetadata;
        InternalAuthProvider b4 = storage.b();
        this.f32316q = b4;
        InteropAppCheckTokenProvider a4 = storage.a();
        this.f32317r = a4;
        this.f32314o = new AdaptiveStreamBuffer(inputStream, 262144);
        this.f32320u = false;
        this.f32312m = null;
        this.B = storage.getMaxChunkUploadRetry();
        this.f32319t = new ExponentialBackoffSender(storageReference.b().getApplicationContext(), b4, a4, storage.getMaxUploadRetryTimeMillis());
    }
}
