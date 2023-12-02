package com.google.api.client.util;

/* loaded from: classes5.dex */
public final class Joiner {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.api.client.repackaged.com.google.common.base.Joiner f26128a;

    private Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner joiner) {
        this.f26128a = joiner;
    }

    public static Joiner on(char c4) {
        return new Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner.on(c4));
    }

    public final String join(Iterable<?> iterable) {
        return this.f26128a.join(iterable);
    }
}
