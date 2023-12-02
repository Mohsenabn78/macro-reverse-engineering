package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
/* loaded from: classes3.dex */
class j implements Key {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17037a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17038b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17039c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f17040d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f17041e;

    /* renamed from: f  reason: collision with root package name */
    private final Key f17042f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Class<?>, Transformation<?>> f17043g;

    /* renamed from: h  reason: collision with root package name */
    private final Options f17044h;

    /* renamed from: i  reason: collision with root package name */
    private int f17045i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Object obj, Key key, int i4, int i5, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f17037a = Preconditions.checkNotNull(obj);
        this.f17042f = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.f17038b = i4;
        this.f17039c = i5;
        this.f17043g = (Map) Preconditions.checkNotNull(map);
        this.f17040d = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.f17041e = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.f17044h = (Options) Preconditions.checkNotNull(options);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.f17037a.equals(jVar.f17037a) || !this.f17042f.equals(jVar.f17042f) || this.f17039c != jVar.f17039c || this.f17038b != jVar.f17038b || !this.f17043g.equals(jVar.f17043g) || !this.f17040d.equals(jVar.f17040d) || !this.f17041e.equals(jVar.f17041e) || !this.f17044h.equals(jVar.f17044h)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f17045i == 0) {
            int hashCode = this.f17037a.hashCode();
            this.f17045i = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f17042f.hashCode()) * 31) + this.f17038b) * 31) + this.f17039c;
            this.f17045i = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f17043g.hashCode();
            this.f17045i = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f17040d.hashCode();
            this.f17045i = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f17041e.hashCode();
            this.f17045i = hashCode5;
            this.f17045i = (hashCode5 * 31) + this.f17044h.hashCode();
        }
        return this.f17045i;
    }

    public String toString() {
        return "EngineKey{model=" + this.f17037a + ", width=" + this.f17038b + ", height=" + this.f17039c + ", resourceClass=" + this.f17040d + ", transcodeClass=" + this.f17041e + ", signature=" + this.f17042f + ", hashCode=" + this.f17045i + ", transformations=" + this.f17043g + ", options=" + this.f17044h + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
