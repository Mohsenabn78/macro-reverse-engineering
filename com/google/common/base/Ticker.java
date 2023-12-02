package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class Ticker {

    /* renamed from: a  reason: collision with root package name */
    private static final Ticker f26401a = new Ticker() { // from class: com.google.common.base.Ticker.1
        @Override // com.google.common.base.Ticker
        public long read() {
            return System.nanoTime();
        }
    };

    public static Ticker systemTicker() {
        return f26401a;
    }

    public abstract long read();
}
