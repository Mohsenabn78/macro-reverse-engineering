package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes3.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* loaded from: classes3.dex */
    class a implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16897a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16898b;

        a(Context context, String str) {
            this.f16897a = context;
            this.f16898b = str;
        }

        @Nullable
        private File a() {
            File cacheDir = this.f16897a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.f16898b != null) {
                return new File(cacheDir, this.f16898b);
            }
            return cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File a4 = a();
            if (a4 != null && a4.exists()) {
                return a4;
            }
            File externalCacheDir = this.f16897a.getExternalCacheDir();
            if (externalCacheDir != null && externalCacheDir.canWrite()) {
                if (this.f16898b != null) {
                    return new File(externalCacheDir, this.f16898b);
                }
                return externalCacheDir;
            }
            return a4;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j4) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j4);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j4) {
        super(new a(context, str), j4);
    }
}
