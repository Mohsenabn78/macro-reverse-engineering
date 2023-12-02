package com.facebook.stetho.server.http;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class HandlerRegistry {
    private final ArrayList<PathMatcher> mPathMatchers = new ArrayList<>();
    private final ArrayList<HttpHandler> mHttpHandlers = new ArrayList<>();

    @Nullable
    public synchronized HttpHandler lookup(String str) {
        int size = this.mPathMatchers.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.mPathMatchers.get(i4).match(str)) {
                return this.mHttpHandlers.get(i4);
            }
        }
        return null;
    }

    public synchronized void register(PathMatcher pathMatcher, HttpHandler httpHandler) {
        this.mPathMatchers.add(pathMatcher);
        this.mHttpHandlers.add(httpHandler);
    }

    public synchronized boolean unregister(PathMatcher pathMatcher, HttpHandler httpHandler) {
        int indexOf = this.mPathMatchers.indexOf(pathMatcher);
        if (indexOf >= 0 && httpHandler == this.mHttpHandlers.get(indexOf)) {
            this.mPathMatchers.remove(indexOf);
            this.mHttpHandlers.remove(indexOf);
            return true;
        }
        return false;
    }
}
