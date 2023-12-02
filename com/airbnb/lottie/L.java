package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import java.io.File;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class L {
    public static boolean DBG = false;
    public static final String TAG = "LOTTIE";

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1207a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f1208b;

    /* renamed from: c  reason: collision with root package name */
    private static long[] f1209c;

    /* renamed from: d  reason: collision with root package name */
    private static int f1210d;

    /* renamed from: e  reason: collision with root package name */
    private static int f1211e;

    /* renamed from: f  reason: collision with root package name */
    private static LottieNetworkFetcher f1212f;

    /* renamed from: g  reason: collision with root package name */
    private static LottieNetworkCacheProvider f1213g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile NetworkFetcher f1214h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile NetworkCache f1215i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements LottieNetworkCacheProvider {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f1216a;

        a(Context context) {
            this.f1216a = context;
        }

        @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
        @NonNull
        public File getCacheDir() {
            return new File(this.f1216a.getCacheDir(), "lottie_network_cache");
        }
    }

    private L() {
    }

    public static void beginSection(String str) {
        if (!f1207a) {
            return;
        }
        int i4 = f1210d;
        if (i4 == 20) {
            f1211e++;
            return;
        }
        f1208b[i4] = str;
        f1209c[i4] = System.nanoTime();
        TraceCompat.beginSection(str);
        f1210d++;
    }

    public static float endSection(String str) {
        int i4 = f1211e;
        if (i4 > 0) {
            f1211e = i4 - 1;
            return 0.0f;
        } else if (!f1207a) {
            return 0.0f;
        } else {
            int i5 = f1210d - 1;
            f1210d = i5;
            if (i5 != -1) {
                if (str.equals(f1208b[i5])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f1209c[f1210d])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f1208b[f1210d] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
    }

    @NonNull
    public static NetworkCache networkCache(@NonNull Context context) {
        NetworkCache networkCache = f1215i;
        if (networkCache == null) {
            synchronized (NetworkCache.class) {
                networkCache = f1215i;
                if (networkCache == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = f1213g;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new a(context);
                    }
                    networkCache = new NetworkCache(lottieNetworkCacheProvider);
                    f1215i = networkCache;
                }
            }
        }
        return networkCache;
    }

    @NonNull
    public static NetworkFetcher networkFetcher(@NonNull Context context) {
        NetworkFetcher networkFetcher = f1214h;
        if (networkFetcher == null) {
            synchronized (NetworkFetcher.class) {
                networkFetcher = f1214h;
                if (networkFetcher == null) {
                    NetworkCache networkCache = networkCache(context);
                    LottieNetworkFetcher lottieNetworkFetcher = f1212f;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new DefaultLottieNetworkFetcher();
                    }
                    networkFetcher = new NetworkFetcher(networkCache, lottieNetworkFetcher);
                    f1214h = networkFetcher;
                }
            }
        }
        return networkFetcher;
    }

    public static void setCacheProvider(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        f1213g = lottieNetworkCacheProvider;
    }

    public static void setFetcher(LottieNetworkFetcher lottieNetworkFetcher) {
        f1212f = lottieNetworkFetcher;
    }

    public static void setTraceEnabled(boolean z3) {
        if (f1207a == z3) {
            return;
        }
        f1207a = z3;
        if (z3) {
            f1208b = new String[20];
            f1209c = new long[20];
        }
    }
}
