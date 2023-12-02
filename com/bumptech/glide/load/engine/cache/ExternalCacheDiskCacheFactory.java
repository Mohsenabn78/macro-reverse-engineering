package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
/* loaded from: classes3.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* loaded from: classes3.dex */
    class a implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16895a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16896b;

        a(Context context, String str) {
            this.f16895a = context;
            this.f16896b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File externalCacheDir = this.f16895a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            if (this.f16896b != null) {
                return new File(externalCacheDir, this.f16896b);
            }
            return externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i4) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i4);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i4) {
        super(new a(context, str), i4);
    }
}
