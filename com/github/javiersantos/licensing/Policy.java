package com.github.javiersantos.licensing;

/* loaded from: classes3.dex */
public interface Policy {
    public static final int LICENSED = 2954;
    public static final int NOT_LICENSED = 435;
    public static final int RETRY = 3144;

    boolean allowAccess();

    void processServerResponse(int i4, ResponseData responseData);
}
