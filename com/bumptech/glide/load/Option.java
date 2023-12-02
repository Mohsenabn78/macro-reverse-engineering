package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class Option<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final CacheKeyUpdater<Object> f16740e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final T f16741a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheKeyUpdater<T> f16742b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16743c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f16744d;

    /* loaded from: classes3.dex */
    public interface CacheKeyUpdater<T> {
        void update(@NonNull byte[] bArr, @NonNull T t3, @NonNull MessageDigest messageDigest);
    }

    private Option(@NonNull String str, @Nullable T t3, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        this.f16743c = Preconditions.checkNotEmpty(str);
        this.f16741a = t3;
        this.f16742b = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater);
    }

    @NonNull
    private static <T> CacheKeyUpdater<T> a() {
        return (CacheKeyUpdater<T>) f16740e;
    }

    @NonNull
    private byte[] b() {
        if (this.f16744d == null) {
            this.f16744d = this.f16743c.getBytes(Key.CHARSET);
        }
        return this.f16744d;
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, null, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str) {
        return new Option<>(str, null, a());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f16743c.equals(((Option) obj).f16743c);
        }
        return false;
    }

    @Nullable
    public T getDefaultValue() {
        return this.f16741a;
    }

    public int hashCode() {
        return this.f16743c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f16743c + "'}";
    }

    public void update(@NonNull T t3, @NonNull MessageDigest messageDigest) {
        this.f16742b.update(b(), t3, messageDigest);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @Nullable T t3, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t3, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str, @NonNull T t3) {
        return new Option<>(str, t3, a());
    }

    /* loaded from: classes3.dex */
    class a implements CacheKeyUpdater<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }
}
