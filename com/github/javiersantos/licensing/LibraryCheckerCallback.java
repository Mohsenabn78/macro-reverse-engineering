package com.github.javiersantos.licensing;

/* loaded from: classes3.dex */
public interface LibraryCheckerCallback {
    public static final int ERROR_CHECK_IN_PROGRESS = 4;
    public static final int ERROR_INVALID_PACKAGE_NAME = 1;
    public static final int ERROR_INVALID_PUBLIC_KEY = 5;
    public static final int ERROR_MISSING_PERMISSION = 6;
    public static final int ERROR_NON_MATCHING_UID = 2;
    public static final int ERROR_NOT_MARKET_MANAGED = 3;

    void allow(int i4);

    void applicationError(int i4);

    void dontAllow(int i4);
}
