package com.airbnb.lottie;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class Lottie {
    private Lottie() {
    }

    public static void initialize(@NonNull LottieConfig lottieConfig) {
        L.setFetcher(lottieConfig.f1295a);
        L.setCacheProvider(lottieConfig.f1296b);
        L.setTraceEnabled(lottieConfig.f1297c);
    }
}
