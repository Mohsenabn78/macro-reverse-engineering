package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* loaded from: classes3.dex */
final class d implements Key {

    /* renamed from: a  reason: collision with root package name */
    private final Key f16927a;

    /* renamed from: b  reason: collision with root package name */
    private final Key f16928b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Key key, Key key2) {
        this.f16927a = key;
        this.f16928b = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f16927a.equals(dVar.f16927a) || !this.f16928b.equals(dVar.f16928b)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f16927a.hashCode() * 31) + this.f16928b.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f16927a + ", signature=" + this.f16928b + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f16927a.updateDiskCacheKey(messageDigest);
        this.f16928b.updateDiskCacheKey(messageDigest);
    }
}
