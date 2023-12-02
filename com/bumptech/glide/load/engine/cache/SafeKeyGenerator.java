package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class SafeKeyGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<Key, String> f16917a = new LruCache<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<b> f16918b = FactoryPools.threadSafe(10, new a());

    /* loaded from: classes3.dex */
    class a implements FactoryPools.Factory<b> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* renamed from: a */
        public b create() {
            try {
                return new b(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256));
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements FactoryPools.Poolable {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f16920a;

        /* renamed from: b  reason: collision with root package name */
        private final StateVerifier f16921b = StateVerifier.newInstance();

        b(MessageDigest messageDigest) {
            this.f16920a = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        @NonNull
        public StateVerifier getVerifier() {
            return this.f16921b;
        }
    }

    private String a(Key key) {
        b bVar = (b) Preconditions.checkNotNull(this.f16918b.acquire());
        try {
            key.updateDiskCacheKey(bVar.f16920a);
            return Util.sha256BytesToHex(bVar.f16920a.digest());
        } finally {
            this.f16918b.release(bVar);
        }
    }

    public String getSafeKey(Key key) {
        String str;
        synchronized (this.f16917a) {
            str = this.f16917a.get(key);
        }
        if (str == null) {
            str = a(key);
        }
        synchronized (this.f16917a) {
            this.f16917a.put(key, str);
        }
        return str;
    }
}
