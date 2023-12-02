package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.common.net.HttpHeaders;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class FileDownloadTask extends StorageTask<TaskSnapshot> {

    /* renamed from: l  reason: collision with root package name */
    private final Uri f32185l;

    /* renamed from: m  reason: collision with root package name */
    private long f32186m;

    /* renamed from: n  reason: collision with root package name */
    private StorageReference f32187n;

    /* renamed from: o  reason: collision with root package name */
    private ExponentialBackoffSender f32188o;

    /* renamed from: p  reason: collision with root package name */
    private long f32189p = -1;

    /* renamed from: q  reason: collision with root package name */
    private String f32190q = null;

    /* renamed from: r  reason: collision with root package name */
    private volatile Exception f32191r = null;

    /* renamed from: s  reason: collision with root package name */
    private long f32192s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f32193t;

    /* loaded from: classes5.dex */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {

        /* renamed from: c  reason: collision with root package name */
        private final long f32194c;

        TaskSnapshot(Exception exc, long j4) {
            super(exc);
            this.f32194c = j4;
        }

        public long getBytesTransferred() {
            return this.f32194c;
        }

        public long getTotalByteCount() {
            return FileDownloadTask.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDownloadTask(@NonNull StorageReference storageReference, @NonNull Uri uri) {
        this.f32187n = storageReference;
        this.f32185l = uri;
        FirebaseStorage storage = storageReference.getStorage();
        this.f32188o = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.b(), storage.a(), storage.getMaxDownloadRetryTimeMillis());
    }

    private int P(InputStream inputStream, byte[] bArr) {
        int read;
        int i4 = 0;
        boolean z3 = false;
        while (i4 != bArr.length && (read = inputStream.read(bArr, i4, bArr.length - i4)) != -1) {
            try {
                i4 += read;
                z3 = true;
            } catch (IOException e4) {
                this.f32191r = e4;
            }
        }
        if (!z3) {
            return -1;
        }
        return i4;
    }

    private boolean R(int i4) {
        if (i4 != 308 && (i4 < 200 || i4 >= 300)) {
            return false;
        }
        return true;
    }

    private boolean S(NetworkRequest networkRequest) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream stream = networkRequest.getStream();
        if (stream != null) {
            File file = new File(this.f32185l.getPath());
            if (!file.exists()) {
                if (this.f32192s <= 0) {
                    if (!file.createNewFile()) {
                        Log.w("FileDownloadTask", "unable to create file:" + file.getAbsolutePath());
                    }
                } else {
                    throw new IOException("The file to download to has been deleted.");
                }
            }
            boolean z3 = true;
            if (this.f32192s > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Resuming download file ");
                sb.append(file.getAbsolutePath());
                sb.append(" at ");
                sb.append(this.f32192s);
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
            }
            try {
                byte[] bArr = new byte[262144];
                while (z3) {
                    int P = P(stream, bArr);
                    if (P == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, P);
                    this.f32186m += P;
                    if (this.f32191r != null) {
                        this.f32191r = null;
                        z3 = false;
                    }
                    if (!N(4, false)) {
                        z3 = false;
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                stream.close();
                return z3;
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                stream.close();
                throw th;
            }
        }
        this.f32191r = new IllegalStateException("Unable to open Firebase Storage stream.");
        return false;
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void A() {
        this.f32188o.cancel();
        this.f32191r = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
    }

    @Override // com.google.firebase.storage.StorageTask
    void I() {
        Exception exc;
        boolean z3;
        String str;
        if (this.f32191r != null) {
            N(64, false);
        } else if (!N(4, false)) {
        } else {
            do {
                this.f32186m = 0L;
                this.f32191r = null;
                this.f32188o.reset();
                GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.f32187n.c(), this.f32187n.b(), this.f32192s);
                this.f32188o.sendWithExponentialBackoff(getNetworkRequest, false);
                this.f32193t = getNetworkRequest.getResultCode();
                if (getNetworkRequest.getException() != null) {
                    exc = getNetworkRequest.getException();
                } else {
                    exc = this.f32191r;
                }
                this.f32191r = exc;
                boolean z4 = true;
                if (R(this.f32193t) && this.f32191r == null && m() == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    this.f32189p = getNetworkRequest.getResultingContentLength() + this.f32192s;
                    String resultString = getNetworkRequest.getResultString(HttpHeaders.ETAG);
                    if (!TextUtils.isEmpty(resultString) && (str = this.f32190q) != null && !str.equals(resultString)) {
                        Log.w("FileDownloadTask", "The file at the server has changed.  Restarting from the beginning.");
                        this.f32192s = 0L;
                        this.f32190q = null;
                        getNetworkRequest.performRequestEnd();
                        J();
                        return;
                    }
                    this.f32190q = resultString;
                    try {
                        z3 = S(getNetworkRequest);
                    } catch (IOException e4) {
                        Log.e("FileDownloadTask", "Exception occurred during file write.  Aborting.", e4);
                        this.f32191r = e4;
                    }
                }
                getNetworkRequest.performRequestEnd();
                if ((z3 && this.f32191r == null && m() == 4) ? false : false) {
                    N(128, false);
                    return;
                }
                File file = new File(this.f32185l.getPath());
                if (file.exists()) {
                    this.f32192s = file.length();
                } else {
                    this.f32192s = 0L;
                }
                if (m() == 8) {
                    N(16, false);
                    return;
                } else if (m() == 32) {
                    if (!N(256, false)) {
                        Log.w("FileDownloadTask", "Unable to change download task to final state from " + m());
                        return;
                    }
                    return;
                }
            } while (this.f32186m > 0);
            N(64, false);
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void J() {
        StorageTaskScheduler.getInstance().scheduleDownload(n());
    }

    long Q() {
        return this.f32189p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    @NonNull
    /* renamed from: T */
    public TaskSnapshot L() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.f32191r, this.f32193t), this.f32186m + this.f32192s);
    }

    @Override // com.google.firebase.storage.StorageTask
    @NonNull
    StorageReference q() {
        return this.f32187n;
    }
}
