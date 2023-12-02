package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* loaded from: classes2.dex */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static LottieLogger f1854a = new LogcatLogger();

    public static void debug(String str) {
        f1854a.debug(str);
    }

    public static void error(String str, Throwable th) {
        f1854a.error(str, th);
    }

    public static void setInstance(LottieLogger lottieLogger) {
        f1854a = lottieLogger;
    }

    public static void warning(String str) {
        f1854a.warning(str);
    }

    public static void debug(String str, Throwable th) {
        f1854a.debug(str, th);
    }

    public static void warning(String str, Throwable th) {
        f1854a.warning(str, th);
    }
}
