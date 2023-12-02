package com.airbnb.lottie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

/* loaded from: classes2.dex */
public class LottieConfig {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    final LottieNetworkFetcher f1295a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    final LottieNetworkCacheProvider f1296b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f1297c;

    /* loaded from: classes2.dex */
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private LottieNetworkFetcher f1298a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private LottieNetworkCacheProvider f1299b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1300c = false;

        /* loaded from: classes2.dex */
        class a implements LottieNetworkCacheProvider {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ File f1301a;

            a(File file) {
                this.f1301a = file;
            }

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            @NonNull
            public File getCacheDir() {
                if (this.f1301a.isDirectory()) {
                    return this.f1301a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* loaded from: classes2.dex */
        class b implements LottieNetworkCacheProvider {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LottieNetworkCacheProvider f1303a;

            b(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
                this.f1303a = lottieNetworkCacheProvider;
            }

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            @NonNull
            public File getCacheDir() {
                File cacheDir = this.f1303a.getCacheDir();
                if (cacheDir.isDirectory()) {
                    return cacheDir;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        public LottieConfig build() {
            return new LottieConfig(this.f1298a, this.f1299b, this.f1300c);
        }

        @NonNull
        public Builder setEnableSystraceMarkers(boolean z3) {
            this.f1300c = z3;
            return this;
        }

        @NonNull
        public Builder setNetworkCacheDir(@NonNull File file) {
            if (this.f1299b == null) {
                this.f1299b = new a(file);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public Builder setNetworkCacheProvider(@NonNull LottieNetworkCacheProvider lottieNetworkCacheProvider) {
            if (this.f1299b == null) {
                this.f1299b = new b(lottieNetworkCacheProvider);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public Builder setNetworkFetcher(@NonNull LottieNetworkFetcher lottieNetworkFetcher) {
            this.f1298a = lottieNetworkFetcher;
            return this;
        }
    }

    private LottieConfig(@Nullable LottieNetworkFetcher lottieNetworkFetcher, @Nullable LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean z3) {
        this.f1295a = lottieNetworkFetcher;
        this.f1296b = lottieNetworkCacheProvider;
        this.f1297c = z3;
    }
}
