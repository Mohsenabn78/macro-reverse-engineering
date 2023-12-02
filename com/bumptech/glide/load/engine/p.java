package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey.java */
/* loaded from: classes3.dex */
final class p implements Key {

    /* renamed from: i  reason: collision with root package name */
    private static final LruCache<Class<?>, byte[]> f17070i = new LruCache<>(50);

    /* renamed from: a  reason: collision with root package name */
    private final ArrayPool f17071a;

    /* renamed from: b  reason: collision with root package name */
    private final Key f17072b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f17073c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17074d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17075e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f17076f;

    /* renamed from: g  reason: collision with root package name */
    private final Options f17077g;

    /* renamed from: h  reason: collision with root package name */
    private final Transformation<?> f17078h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ArrayPool arrayPool, Key key, Key key2, int i4, int i5, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f17071a = arrayPool;
        this.f17072b = key;
        this.f17073c = key2;
        this.f17074d = i4;
        this.f17075e = i5;
        this.f17078h = transformation;
        this.f17076f = cls;
        this.f17077g = options;
    }

    private byte[] a() {
        LruCache<Class<?>, byte[]> lruCache = f17070i;
        byte[] bArr = lruCache.get(this.f17076f);
        if (bArr == null) {
            byte[] bytes = this.f17076f.getName().getBytes(Key.CHARSET);
            lruCache.put(this.f17076f, bytes);
            return bytes;
        }
        return bArr;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f17075e != pVar.f17075e || this.f17074d != pVar.f17074d || !Util.bothNullOrEqual(this.f17078h, pVar.f17078h) || !this.f17076f.equals(pVar.f17076f) || !this.f17072b.equals(pVar.f17072b) || !this.f17073c.equals(pVar.f17073c) || !this.f17077g.equals(pVar.f17077g)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = (((((this.f17072b.hashCode() * 31) + this.f17073c.hashCode()) * 31) + this.f17074d) * 31) + this.f17075e;
        Transformation<?> transformation = this.f17078h;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f17076f.hashCode()) * 31) + this.f17077g.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f17072b + ", signature=" + this.f17073c + ", width=" + this.f17074d + ", height=" + this.f17075e + ", decodedResourceClass=" + this.f17076f + ", transformation='" + this.f17078h + "', options=" + this.f17077g + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f17071a.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f17074d).putInt(this.f17075e).array();
        this.f17073c.updateDiskCacheKey(messageDigest);
        this.f17072b.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f17078h;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.f17077g.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f17071a.put(bArr);
    }
}
