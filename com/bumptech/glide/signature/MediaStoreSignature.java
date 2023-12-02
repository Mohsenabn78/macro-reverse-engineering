package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class MediaStoreSignature implements Key {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f17556a;

    /* renamed from: b  reason: collision with root package name */
    private final long f17557b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17558c;

    public MediaStoreSignature(@Nullable String str, long j4, int i4) {
        this.f17556a = str == null ? "" : str;
        this.f17557b = j4;
        this.f17558c = i4;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        if (this.f17557b == mediaStoreSignature.f17557b && this.f17558c == mediaStoreSignature.f17558c && this.f17556a.equals(mediaStoreSignature.f17556a)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        long j4 = this.f17557b;
        return (((this.f17556a.hashCode() * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f17558c;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f17557b).putInt(this.f17558c).array());
        messageDigest.update(this.f17556a.getBytes(Key.CHARSET));
    }
}
