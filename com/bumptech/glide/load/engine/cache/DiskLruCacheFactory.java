package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes3.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final long f16884a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheDirectoryGetter f16885b;

    /* loaded from: classes3.dex */
    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    /* loaded from: classes3.dex */
    class a implements CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16886a;

        a(String str) {
            this.f16886a = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(this.f16886a);
        }
    }

    /* loaded from: classes3.dex */
    class b implements CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16887a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16888b;

        b(String str, String str2) {
            this.f16887a = str;
            this.f16888b = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(this.f16887a, this.f16888b);
        }
    }

    public DiskLruCacheFactory(String str, long j4) {
        this(new a(str), j4);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.f16885b.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (!cacheDirectory.mkdirs() && (!cacheDirectory.exists() || !cacheDirectory.isDirectory())) {
            return null;
        }
        return DiskLruCacheWrapper.create(cacheDirectory, this.f16884a);
    }

    public DiskLruCacheFactory(String str, String str2, long j4) {
        this(new b(str, str2), j4);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j4) {
        this.f16884a = j4;
        this.f16885b = cacheDirectoryGetter;
    }
}
