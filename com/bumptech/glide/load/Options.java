package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class Options implements Key {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap<Option<?>, Object> f16745a = new CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f16745a.equals(((Options) obj).f16745a);
        }
        return false;
    }

    @Nullable
    public <T> T get(@NonNull Option<T> option) {
        if (this.f16745a.containsKey(option)) {
            return (T) this.f16745a.get(option);
        }
        return option.getDefaultValue();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f16745a.hashCode();
    }

    public void putAll(@NonNull Options options) {
        this.f16745a.putAll((SimpleArrayMap<? extends Option<?>, ? extends Object>) options.f16745a);
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> option, @NonNull T t3) {
        this.f16745a.put(option, t3);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.f16745a + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i4 = 0; i4 < this.f16745a.size(); i4++) {
            a(this.f16745a.keyAt(i4), this.f16745a.valueAt(i4), messageDigest);
        }
    }
}
