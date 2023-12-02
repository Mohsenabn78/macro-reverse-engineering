package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes3.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* loaded from: classes3.dex */
    class a implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16899a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16900b;

        a(Context context, String str) {
            this.f16899a = context;
            this.f16900b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File cacheDir = this.f16899a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.f16900b != null) {
                return new File(cacheDir, this.f16900b);
            }
            return cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public InternalCacheDiskCacheFactory(Context context, long j4) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j4);
    }

    public InternalCacheDiskCacheFactory(Context context, String str, long j4) {
        super(new a(context, str), j4);
    }
}
