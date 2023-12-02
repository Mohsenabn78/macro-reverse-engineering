package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes3.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    static final b f16761g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final GlideUrl f16762a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16763b;

    /* renamed from: c  reason: collision with root package name */
    private final b f16764c;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f16765d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f16766e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f16767f;

    /* loaded from: classes3.dex */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i4) {
        this(glideUrl, i4, f16761g);
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f16766e = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got non empty content encoding: ");
                sb.append(httpURLConnection.getContentEncoding());
            }
            this.f16766e = httpURLConnection.getInputStream();
        }
        return this.f16766e;
    }

    private static boolean b(int i4) {
        if (i4 / 100 == 2) {
            return true;
        }
        return false;
    }

    private static boolean c(int i4) {
        if (i4 / 100 == 3) {
            return true;
        }
        return false;
    }

    private InputStream d(URL url, int i4, URL url2, Map<String, String> map) throws IOException {
        if (i4 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f16765d = this.f16764c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f16765d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f16765d.setConnectTimeout(this.f16763b);
            this.f16765d.setReadTimeout(this.f16763b);
            this.f16765d.setUseCaches(false);
            this.f16765d.setDoInput(true);
            this.f16765d.setInstanceFollowRedirects(false);
            this.f16765d.connect();
            this.f16766e = this.f16765d.getInputStream();
            if (this.f16767f) {
                return null;
            }
            int responseCode = this.f16765d.getResponseCode();
            if (b(responseCode)) {
                return a(this.f16765d);
            }
            if (c(responseCode)) {
                String headerField = this.f16765d.getHeaderField(HttpHeaders.LOCATION);
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    cleanup();
                    return d(url3, i4 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f16765d.getResponseMessage(), responseCode);
            }
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.f16767f = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.f16766e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f16765d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f16765d = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long logTime = LogTime.getLogTime();
        try {
            try {
                dataCallback.onDataReady(d(this.f16762a.toURL(), 0, null, this.f16762a.getHeaders()));
            } catch (IOException e4) {
                Log.isLoggable("HttpUrlFetcher", 3);
                dataCallback.onLoadFailed(e4);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder();
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.getElapsedMillis(logTime));
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }

    @VisibleForTesting
    HttpUrlFetcher(GlideUrl glideUrl, int i4, b bVar) {
        this.f16762a = glideUrl;
        this.f16763b = i4;
        this.f16764c = bVar;
    }
}
