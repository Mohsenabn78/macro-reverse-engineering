package com.jakewharton.rxbinding2.internal;

import androidx.annotation.RestrictTo;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public final class Functions {
    public static final Callable<Boolean> CALLABLE_ALWAYS_TRUE;
    public static final Predicate<Object> PREDICATE_ALWAYS_TRUE;

    /* renamed from: a  reason: collision with root package name */
    private static final a f34164a;

    /* loaded from: classes6.dex */
    private static final class a implements Callable<Boolean>, Predicate<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Boolean f34165a;

        a(Boolean bool) {
            this.f34165a = bool;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            return this.f34165a;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) throws Exception {
            return this.f34165a.booleanValue();
        }
    }

    static {
        a aVar = new a(Boolean.TRUE);
        f34164a = aVar;
        CALLABLE_ALWAYS_TRUE = aVar;
        PREDICATE_ALWAYS_TRUE = aVar;
    }

    private Functions() {
        throw new AssertionError("No instances.");
    }
}
