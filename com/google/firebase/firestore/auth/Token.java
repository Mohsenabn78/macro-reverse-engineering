package com.google.firebase.firestore.auth;

import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public final class Token {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f30259a;

    /* renamed from: b  reason: collision with root package name */
    private final User f30260b;

    public Token(@Nullable String str, User user) {
        this.f30259a = str;
        this.f30260b = user;
    }

    public User getUser() {
        return this.f30260b;
    }

    @Nullable
    public String getValue() {
        return this.f30259a;
    }
}
