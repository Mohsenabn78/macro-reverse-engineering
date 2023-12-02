package com.facebook.stetho.server.http;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class RegexpPathMatcher implements PathMatcher {
    private final Pattern mPattern;

    public RegexpPathMatcher(Pattern pattern) {
        this.mPattern = pattern;
    }

    @Override // com.facebook.stetho.server.http.PathMatcher
    public boolean match(String str) {
        return this.mPattern.matcher(str).matches();
    }
}
