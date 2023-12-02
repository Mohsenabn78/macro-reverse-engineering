package com.bumptech.glide.request;

/* loaded from: classes3.dex */
public interface Request {
    void begin();

    void clear();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(Request request);

    boolean isFailed();

    boolean isResourceSet();

    boolean isRunning();

    void recycle();
}
