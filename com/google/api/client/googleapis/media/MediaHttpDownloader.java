package com.google.api.client.googleapis.media;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class MediaHttpDownloader {
    public static final int MAXIMUM_CHUNK_SIZE = 33554432;

    /* renamed from: a  reason: collision with root package name */
    private final HttpRequestFactory f25646a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpTransport f25647b;

    /* renamed from: d  reason: collision with root package name */
    private MediaHttpDownloaderProgressListener f25649d;

    /* renamed from: f  reason: collision with root package name */
    private long f25651f;

    /* renamed from: h  reason: collision with root package name */
    private long f25653h;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25648c = false;

    /* renamed from: e  reason: collision with root package name */
    private int f25650e = 33554432;

    /* renamed from: g  reason: collision with root package name */
    private DownloadState f25652g = DownloadState.NOT_STARTED;

    /* renamed from: i  reason: collision with root package name */
    private long f25654i = -1;

    /* loaded from: classes5.dex */
    public enum DownloadState {
        NOT_STARTED,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public MediaHttpDownloader(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        HttpRequestFactory createRequestFactory;
        this.f25647b = (HttpTransport) Preconditions.checkNotNull(httpTransport);
        if (httpRequestInitializer == null) {
            createRequestFactory = httpTransport.createRequestFactory();
        } else {
            createRequestFactory = httpTransport.createRequestFactory(httpRequestInitializer);
        }
        this.f25646a = createRequestFactory;
    }

    private HttpResponse a(long j4, GenericUrl genericUrl, HttpHeaders httpHeaders, OutputStream outputStream) throws IOException {
        HttpRequest buildGetRequest = this.f25646a.buildGetRequest(genericUrl);
        if (httpHeaders != null) {
            buildGetRequest.getHeaders().putAll(httpHeaders);
        }
        if (this.f25653h != 0 || j4 != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(this.f25653h);
            sb.append("-");
            if (j4 != -1) {
                sb.append(j4);
            }
            buildGetRequest.getHeaders().setRange(sb.toString());
        }
        HttpResponse execute = buildGetRequest.execute();
        try {
            IOUtils.copy(execute.getContent(), outputStream);
            return execute;
        } finally {
            execute.disconnect();
        }
    }

    private long b(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1, str.indexOf(47))) + 1;
    }

    private void c(String str) {
        if (str != null && this.f25651f == 0) {
            this.f25651f = Long.parseLong(str.substring(str.indexOf(47) + 1));
        }
    }

    private void d(DownloadState downloadState) throws IOException {
        this.f25652g = downloadState;
        MediaHttpDownloaderProgressListener mediaHttpDownloaderProgressListener = this.f25649d;
        if (mediaHttpDownloaderProgressListener != null) {
            mediaHttpDownloaderProgressListener.progressChanged(this);
        }
    }

    public void download(GenericUrl genericUrl, OutputStream outputStream) throws IOException {
        download(genericUrl, null, outputStream);
    }

    public int getChunkSize() {
        return this.f25650e;
    }

    public DownloadState getDownloadState() {
        return this.f25652g;
    }

    public long getLastBytePosition() {
        return this.f25654i;
    }

    public long getNumBytesDownloaded() {
        return this.f25653h;
    }

    public double getProgress() {
        long j4 = this.f25651f;
        if (j4 == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return this.f25653h / j4;
    }

    public MediaHttpDownloaderProgressListener getProgressListener() {
        return this.f25649d;
    }

    public HttpTransport getTransport() {
        return this.f25647b;
    }

    public boolean isDirectDownloadEnabled() {
        return this.f25648c;
    }

    public MediaHttpDownloader setBytesDownloaded(long j4) {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f25653h = j4;
        return this;
    }

    public MediaHttpDownloader setChunkSize(int i4) {
        boolean z3;
        if (i4 > 0 && i4 <= 33554432) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f25650e = i4;
        return this;
    }

    public MediaHttpDownloader setContentRange(long j4, int i4) {
        boolean z3;
        long j5 = i4;
        if (j5 >= j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        setBytesDownloaded(j4);
        this.f25654i = j5;
        return this;
    }

    public MediaHttpDownloader setDirectDownloadEnabled(boolean z3) {
        this.f25648c = z3;
        return this;
    }

    public MediaHttpDownloader setProgressListener(MediaHttpDownloaderProgressListener mediaHttpDownloaderProgressListener) {
        this.f25649d = mediaHttpDownloaderProgressListener;
        return this;
    }

    public void download(GenericUrl genericUrl, HttpHeaders httpHeaders, OutputStream outputStream) throws IOException {
        Preconditions.checkArgument(this.f25652g == DownloadState.NOT_STARTED);
        genericUrl.put("alt", "media");
        if (this.f25648c) {
            d(DownloadState.MEDIA_IN_PROGRESS);
            long longValue = a(this.f25654i, genericUrl, httpHeaders, outputStream).getHeaders().getContentLength().longValue();
            this.f25651f = longValue;
            this.f25653h = longValue;
            d(DownloadState.MEDIA_COMPLETE);
            return;
        }
        while (true) {
            long j4 = (this.f25653h + this.f25650e) - 1;
            long j5 = this.f25654i;
            if (j5 != -1) {
                j4 = Math.min(j5, j4);
            }
            String contentRange = a(j4, genericUrl, httpHeaders, outputStream).getHeaders().getContentRange();
            long b4 = b(contentRange);
            c(contentRange);
            long j6 = this.f25651f;
            if (j6 <= b4) {
                this.f25653h = j6;
                d(DownloadState.MEDIA_COMPLETE);
                return;
            }
            this.f25653h = b4;
            d(DownloadState.MEDIA_IN_PROGRESS);
        }
    }
}
