package com.google.api.client.googleapis.media;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ByteStreams;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class MediaHttpUploader {
    public static final String CONTENT_LENGTH_HEADER = "X-Upload-Content-Length";
    public static final String CONTENT_TYPE_HEADER = "X-Upload-Content-Type";
    public static final int DEFAULT_CHUNK_SIZE = 10485760;
    public static final int MINIMUM_CHUNK_SIZE = 262144;

    /* renamed from: b  reason: collision with root package name */
    private final AbstractInputStreamContent f25657b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpRequestFactory f25658c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpTransport f25659d;

    /* renamed from: e  reason: collision with root package name */
    private HttpContent f25660e;

    /* renamed from: f  reason: collision with root package name */
    private long f25661f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25662g;

    /* renamed from: j  reason: collision with root package name */
    private HttpRequest f25665j;

    /* renamed from: k  reason: collision with root package name */
    private InputStream f25666k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f25667l;

    /* renamed from: m  reason: collision with root package name */
    private MediaHttpUploaderProgressListener f25668m;

    /* renamed from: o  reason: collision with root package name */
    private long f25670o;

    /* renamed from: q  reason: collision with root package name */
    private Byte f25672q;

    /* renamed from: r  reason: collision with root package name */
    private long f25673r;

    /* renamed from: s  reason: collision with root package name */
    private int f25674s;

    /* renamed from: t  reason: collision with root package name */
    private byte[] f25675t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f25676u;

    /* renamed from: a  reason: collision with root package name */
    private UploadState f25656a = UploadState.NOT_STARTED;

    /* renamed from: h  reason: collision with root package name */
    private String f25663h = "POST";

    /* renamed from: i  reason: collision with root package name */
    private HttpHeaders f25664i = new HttpHeaders();

    /* renamed from: n  reason: collision with root package name */
    String f25669n = "*";

    /* renamed from: p  reason: collision with root package name */
    private int f25671p = DEFAULT_CHUNK_SIZE;

    /* renamed from: v  reason: collision with root package name */
    Sleeper f25677v = Sleeper.DEFAULT;

    /* loaded from: classes5.dex */
    public enum UploadState {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public MediaHttpUploader(AbstractInputStreamContent abstractInputStreamContent, HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        HttpRequestFactory createRequestFactory;
        this.f25657b = (AbstractInputStreamContent) Preconditions.checkNotNull(abstractInputStreamContent);
        this.f25659d = (HttpTransport) Preconditions.checkNotNull(httpTransport);
        if (httpRequestInitializer == null) {
            createRequestFactory = httpTransport.createRequestFactory();
        } else {
            createRequestFactory = httpTransport.createRequestFactory(httpRequestInitializer);
        }
        this.f25658c = createRequestFactory;
    }

    private HttpResponse a(GenericUrl genericUrl) throws IOException {
        k(UploadState.MEDIA_IN_PROGRESS);
        HttpContent httpContent = this.f25657b;
        if (this.f25660e != null) {
            httpContent = new MultipartContent().setContentParts(Arrays.asList(this.f25660e, this.f25657b));
            genericUrl.put("uploadType", "multipart");
        } else {
            genericUrl.put("uploadType", "media");
        }
        HttpRequest buildRequest = this.f25658c.buildRequest(this.f25663h, genericUrl, httpContent);
        buildRequest.getHeaders().putAll(this.f25664i);
        HttpResponse b4 = b(buildRequest);
        try {
            if (g()) {
                this.f25670o = e();
            }
            k(UploadState.MEDIA_COMPLETE);
            return b4;
        } catch (Throwable th) {
            b4.disconnect();
            throw th;
        }
    }

    private HttpResponse b(HttpRequest httpRequest) throws IOException {
        if (!this.f25676u && !(httpRequest.getContent() instanceof EmptyContent)) {
            httpRequest.setEncoding(new GZipEncoding());
        }
        return c(httpRequest);
    }

    private HttpResponse c(HttpRequest httpRequest) throws IOException {
        new MethodOverride().intercept(httpRequest);
        httpRequest.setThrowExceptionOnExecuteError(false);
        return httpRequest.execute();
    }

    private HttpResponse d(GenericUrl genericUrl) throws IOException {
        k(UploadState.INITIATION_STARTED);
        genericUrl.put("uploadType", "resumable");
        HttpContent httpContent = this.f25660e;
        if (httpContent == null) {
            httpContent = new EmptyContent();
        }
        HttpRequest buildRequest = this.f25658c.buildRequest(this.f25663h, genericUrl, httpContent);
        this.f25664i.set(CONTENT_TYPE_HEADER, (Object) this.f25657b.getType());
        if (g()) {
            this.f25664i.set(CONTENT_LENGTH_HEADER, (Object) Long.valueOf(e()));
        }
        buildRequest.getHeaders().putAll(this.f25664i);
        HttpResponse b4 = b(buildRequest);
        try {
            k(UploadState.INITIATION_COMPLETE);
            return b4;
        } catch (Throwable th) {
            b4.disconnect();
            throw th;
        }
    }

    private long e() throws IOException {
        if (!this.f25662g) {
            this.f25661f = this.f25657b.getLength();
            this.f25662g = true;
        }
        return this.f25661f;
    }

    private long f(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1)) + 1;
    }

    private boolean g() throws IOException {
        if (e() >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
        r13.f25670o = e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
        if (r13.f25657b.getCloseInputStream() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
        r13.f25666k.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
        k(com.google.api.client.googleapis.media.MediaHttpUploader.UploadState.MEDIA_COMPLETE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
        return r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.api.client.http.HttpResponse h(com.google.api.client.http.GenericUrl r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.media.MediaHttpUploader.h(com.google.api.client.http.GenericUrl):com.google.api.client.http.HttpResponse");
    }

    private void j() throws IOException {
        int i4;
        int i5;
        int i6;
        HttpContent byteArrayContent;
        String str;
        if (g()) {
            i4 = (int) Math.min(this.f25671p, e() - this.f25670o);
        } else {
            i4 = this.f25671p;
        }
        if (g()) {
            this.f25666k.mark(i4);
            long j4 = i4;
            byteArrayContent = new InputStreamContent(this.f25657b.getType(), ByteStreams.limit(this.f25666k, j4)).setRetrySupported(true).setLength(j4).setCloseInputStream(false);
            this.f25669n = String.valueOf(e());
        } else {
            byte[] bArr = this.f25675t;
            if (bArr == null) {
                Byte b4 = this.f25672q;
                if (b4 == null) {
                    i6 = i4 + 1;
                } else {
                    i6 = i4;
                }
                byte[] bArr2 = new byte[i4 + 1];
                this.f25675t = bArr2;
                if (b4 != null) {
                    bArr2[0] = b4.byteValue();
                }
                i5 = 0;
            } else {
                i5 = (int) (this.f25673r - this.f25670o);
                System.arraycopy(bArr, this.f25674s - i5, bArr, 0, i5);
                Byte b5 = this.f25672q;
                if (b5 != null) {
                    this.f25675t[i5] = b5.byteValue();
                }
                i6 = i4 - i5;
            }
            int read = ByteStreams.read(this.f25666k, this.f25675t, (i4 + 1) - i6, i6);
            if (read < i6) {
                int max = i5 + Math.max(0, read);
                if (this.f25672q != null) {
                    max++;
                    this.f25672q = null;
                }
                if (this.f25669n.equals("*")) {
                    this.f25669n = String.valueOf(this.f25670o + max);
                }
                i4 = max;
            } else {
                this.f25672q = Byte.valueOf(this.f25675t[i4]);
            }
            byteArrayContent = new ByteArrayContent(this.f25657b.getType(), this.f25675t, 0, i4);
            this.f25673r = this.f25670o + i4;
        }
        this.f25674s = i4;
        this.f25665j.setContent(byteArrayContent);
        if (i4 == 0) {
            HttpHeaders headers = this.f25665j.getHeaders();
            String valueOf = String.valueOf(this.f25669n);
            if (valueOf.length() != 0) {
                str = "bytes */".concat(valueOf);
            } else {
                str = new String("bytes */");
            }
            headers.setContentRange(str);
            return;
        }
        HttpHeaders headers2 = this.f25665j.getHeaders();
        long j5 = this.f25670o;
        String valueOf2 = String.valueOf(this.f25669n);
        StringBuilder sb = new StringBuilder(valueOf2.length() + 48);
        sb.append("bytes ");
        sb.append(j5);
        sb.append("-");
        sb.append((i4 + j5) - 1);
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(valueOf2);
        headers2.setContentRange(sb.toString());
    }

    private void k(UploadState uploadState) throws IOException {
        this.f25656a = uploadState;
        MediaHttpUploaderProgressListener mediaHttpUploaderProgressListener = this.f25668m;
        if (mediaHttpUploaderProgressListener != null) {
            mediaHttpUploaderProgressListener.progressChanged(this);
        }
    }

    public int getChunkSize() {
        return this.f25671p;
    }

    public boolean getDisableGZipContent() {
        return this.f25676u;
    }

    public HttpHeaders getInitiationHeaders() {
        return this.f25664i;
    }

    public String getInitiationRequestMethod() {
        return this.f25663h;
    }

    public HttpContent getMediaContent() {
        return this.f25657b;
    }

    public HttpContent getMetadata() {
        return this.f25660e;
    }

    public long getNumBytesUploaded() {
        return this.f25670o;
    }

    public double getProgress() throws IOException {
        Preconditions.checkArgument(g(), "Cannot call getProgress() if the specified AbstractInputStreamContent has no content length. Use  getNumBytesUploaded() to denote progress instead.");
        if (e() == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return this.f25670o / e();
    }

    public MediaHttpUploaderProgressListener getProgressListener() {
        return this.f25668m;
    }

    public Sleeper getSleeper() {
        return this.f25677v;
    }

    public HttpTransport getTransport() {
        return this.f25659d;
    }

    public UploadState getUploadState() {
        return this.f25656a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Beta
    public void i() throws IOException {
        String str;
        Preconditions.checkNotNull(this.f25665j, "The current request should not be null");
        this.f25665j.setContent(new EmptyContent());
        HttpHeaders headers = this.f25665j.getHeaders();
        String valueOf = String.valueOf(this.f25669n);
        if (valueOf.length() != 0) {
            str = "bytes */".concat(valueOf);
        } else {
            str = new String("bytes */");
        }
        headers.setContentRange(str);
    }

    public boolean isDirectUploadEnabled() {
        return this.f25667l;
    }

    public MediaHttpUploader setChunkSize(int i4) {
        boolean z3;
        if (i4 > 0 && i4 % 262144 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "chunkSize must be a positive multiple of 262144.");
        this.f25671p = i4;
        return this;
    }

    public MediaHttpUploader setDirectUploadEnabled(boolean z3) {
        this.f25667l = z3;
        return this;
    }

    public MediaHttpUploader setDisableGZipContent(boolean z3) {
        this.f25676u = z3;
        return this;
    }

    public MediaHttpUploader setInitiationHeaders(HttpHeaders httpHeaders) {
        this.f25664i = httpHeaders;
        return this;
    }

    public MediaHttpUploader setInitiationRequestMethod(String str) {
        boolean z3;
        if (!str.equals("POST") && !str.equals("PUT") && !str.equals(HttpMethods.PATCH)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        this.f25663h = str;
        return this;
    }

    public MediaHttpUploader setMetadata(HttpContent httpContent) {
        this.f25660e = httpContent;
        return this;
    }

    public MediaHttpUploader setProgressListener(MediaHttpUploaderProgressListener mediaHttpUploaderProgressListener) {
        this.f25668m = mediaHttpUploaderProgressListener;
        return this;
    }

    public MediaHttpUploader setSleeper(Sleeper sleeper) {
        this.f25677v = sleeper;
        return this;
    }

    public HttpResponse upload(GenericUrl genericUrl) throws IOException {
        boolean z3;
        if (this.f25656a == UploadState.NOT_STARTED) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (this.f25667l) {
            return a(genericUrl);
        }
        return h(genericUrl);
    }
}
