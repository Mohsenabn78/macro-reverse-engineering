package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: f  reason: collision with root package name */
    private static DiskLruCacheWrapper f16889f;

    /* renamed from: b  reason: collision with root package name */
    private final File f16891b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16892c;

    /* renamed from: e  reason: collision with root package name */
    private DiskLruCache f16894e;

    /* renamed from: d  reason: collision with root package name */
    private final a f16893d = new a();

    /* renamed from: a  reason: collision with root package name */
    private final SafeKeyGenerator f16890a = new SafeKeyGenerator();

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j4) {
        this.f16891b = file;
        this.f16892c = j4;
    }

    private synchronized DiskLruCache a() throws IOException {
        if (this.f16894e == null) {
            this.f16894e = DiskLruCache.open(this.f16891b, 1, 1, this.f16892c);
        }
        return this.f16894e;
    }

    private synchronized void b() {
        this.f16894e = null;
    }

    public static DiskCache create(File file, long j4) {
        return new DiskLruCacheWrapper(file, j4);
    }

    @Deprecated
    public static synchronized DiskCache get(File file, long j4) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (f16889f == null) {
                f16889f = new DiskLruCacheWrapper(file, j4);
            }
            diskLruCacheWrapper = f16889f;
        }
        return diskLruCacheWrapper;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            a().delete();
        } catch (IOException e4) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e4);
            }
        }
        b();
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            a().remove(this.f16890a.getSafeKey(key));
        } catch (IOException e4) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e4);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache a4;
        String safeKey = this.f16890a.getSafeKey(key);
        this.f16893d.a(safeKey);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Put: Obtained: ");
                sb.append(safeKey);
                sb.append(" for for Key: ");
                sb.append(key);
            }
            try {
                a4 = a();
            } catch (IOException e4) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e4);
                }
            }
            if (a4.get(safeKey) != null) {
                return;
            }
            DiskLruCache.Editor edit = a4.edit(safeKey);
            if (edit != null) {
                try {
                    if (writer.write(edit.getFile(0))) {
                        edit.commit();
                    }
                    edit.abortUnlessCommitted();
                    return;
                } catch (Throwable th) {
                    edit.abortUnlessCommitted();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
        } finally {
            this.f16893d.b(safeKey);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        String safeKey = this.f16890a.getSafeKey(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get: Obtained: ");
            sb.append(safeKey);
            sb.append(" for for Key: ");
            sb.append(key);
        }
        try {
            DiskLruCache.Value value = a().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e4) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e4);
                return null;
            }
            return null;
        }
    }
}
