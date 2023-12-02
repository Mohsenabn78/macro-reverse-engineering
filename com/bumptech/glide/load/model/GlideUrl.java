package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes3.dex */
public class GlideUrl implements Key {

    /* renamed from: a  reason: collision with root package name */
    private final Headers f17138a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final URL f17139b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f17140c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f17141d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private URL f17142e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private volatile byte[] f17143f;

    /* renamed from: g  reason: collision with root package name */
    private int f17144g;

    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
    }

    private byte[] a() {
        if (this.f17143f == null) {
            this.f17143f = getCacheKey().getBytes(Key.CHARSET);
        }
        return this.f17143f;
    }

    private String b() {
        if (TextUtils.isEmpty(this.f17141d)) {
            String str = this.f17140c;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.checkNotNull(this.f17139b)).toString();
            }
            this.f17141d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f17141d;
    }

    private URL c() throws MalformedURLException {
        if (this.f17142e == null) {
            this.f17142e = new URL(b());
        }
        return this.f17142e;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!getCacheKey().equals(glideUrl.getCacheKey()) || !this.f17138a.equals(glideUrl.f17138a)) {
            return false;
        }
        return true;
    }

    public String getCacheKey() {
        String str = this.f17140c;
        if (str == null) {
            return ((URL) Preconditions.checkNotNull(this.f17139b)).toString();
        }
        return str;
    }

    public Map<String, String> getHeaders() {
        return this.f17138a.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f17144g == 0) {
            int hashCode = getCacheKey().hashCode();
            this.f17144g = hashCode;
            this.f17144g = (hashCode * 31) + this.f17138a.hashCode();
        }
        return this.f17144g;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return b();
    }

    public URL toURL() throws MalformedURLException {
        return c();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(a());
    }

    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f17139b = (URL) Preconditions.checkNotNull(url);
        this.f17140c = null;
        this.f17138a = (Headers) Preconditions.checkNotNull(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f17139b = null;
        this.f17140c = Preconditions.checkNotEmpty(str);
        this.f17138a = (Headers) Preconditions.checkNotNull(headers);
    }
}
