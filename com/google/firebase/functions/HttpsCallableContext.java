package com.google.firebase.functions;

import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
class HttpsCallableContext {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f31386a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f31387b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f31388c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallableContext(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f31386a = str;
        this.f31387b = str2;
        this.f31388c = str3;
    }

    @Nullable
    public String a() {
        return this.f31388c;
    }

    @Nullable
    public String b() {
        return this.f31386a;
    }

    @Nullable
    public String c() {
        return this.f31387b;
    }
}
