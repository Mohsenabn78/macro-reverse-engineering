package com.facebook.stetho.server.http;

/* loaded from: classes3.dex */
public class ExactPathMatcher implements PathMatcher {
    private final String mPath;

    public ExactPathMatcher(String str) {
        this.mPath = str;
    }

    @Override // com.facebook.stetho.server.http.PathMatcher
    public boolean match(String str) {
        return this.mPath.equals(str);
    }
}
