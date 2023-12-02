package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class ObjectKey implements Key {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17559a;

    public ObjectKey(@NonNull Object obj) {
        this.f17559a = Preconditions.checkNotNull(obj);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f17559a.equals(((ObjectKey) obj).f17559a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f17559a.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f17559a + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f17559a.toString().getBytes(Key.CHARSET));
    }
}
