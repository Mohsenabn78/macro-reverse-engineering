package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
final class LongAddables {

    /* renamed from: a  reason: collision with root package name */
    private static final Supplier<LongAddable> f26577a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public void a() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long j4) {
            getAndAdd(j4);
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.1
                @Override // com.google.common.base.Supplier
                /* renamed from: a */
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.2
                @Override // com.google.common.base.Supplier
                /* renamed from: a */
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        f26577a = supplier;
    }

    LongAddables() {
    }

    public static LongAddable a() {
        return f26577a.get();
    }
}
