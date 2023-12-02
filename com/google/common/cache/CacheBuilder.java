package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: q  reason: collision with root package name */
    static final Supplier<? extends AbstractCache.StatsCounter> f26415q = Suppliers.ofInstance(new AbstractCache.StatsCounter() { // from class: com.google.common.cache.CacheBuilder.1
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return CacheBuilder.f26416r;
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i4) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j4) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j4) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i4) {
        }
    });

    /* renamed from: r  reason: collision with root package name */
    static final CacheStats f26416r = new CacheStats(0, 0, 0, 0, 0, 0);

    /* renamed from: s  reason: collision with root package name */
    static final Supplier<AbstractCache.StatsCounter> f26417s = new Supplier() { // from class: com.google.common.cache.a
        @Override // com.google.common.base.Supplier
        public final Object get() {
            AbstractCache.StatsCounter s3;
            s3 = CacheBuilder.s();
            return s3;
        }
    };

    /* renamed from: t  reason: collision with root package name */
    static final Ticker f26418t = new Ticker() { // from class: com.google.common.cache.CacheBuilder.2
        @Override // com.google.common.base.Ticker
        public long read() {
            return 0L;
        }
    };

    /* renamed from: u  reason: collision with root package name */
    private static final Logger f26419u = Logger.getLogger(CacheBuilder.class.getName());
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    Weigher<? super K, ? super V> f26425f;
    @CheckForNull

    /* renamed from: g  reason: collision with root package name */
    LocalCache.Strength f26426g;
    @CheckForNull

    /* renamed from: h  reason: collision with root package name */
    LocalCache.Strength f26427h;
    @CheckForNull

    /* renamed from: l  reason: collision with root package name */
    Equivalence<Object> f26431l;
    @CheckForNull

    /* renamed from: m  reason: collision with root package name */
    Equivalence<Object> f26432m;
    @CheckForNull

    /* renamed from: n  reason: collision with root package name */
    RemovalListener<? super K, ? super V> f26433n;
    @CheckForNull

    /* renamed from: o  reason: collision with root package name */
    Ticker f26434o;

    /* renamed from: a  reason: collision with root package name */
    boolean f26420a = true;

    /* renamed from: b  reason: collision with root package name */
    int f26421b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f26422c = -1;

    /* renamed from: d  reason: collision with root package name */
    long f26423d = -1;

    /* renamed from: e  reason: collision with root package name */
    long f26424e = -1;

    /* renamed from: i  reason: collision with root package name */
    long f26428i = -1;

    /* renamed from: j  reason: collision with root package name */
    long f26429j = -1;

    /* renamed from: k  reason: collision with root package name */
    long f26430k = -1;

    /* renamed from: p  reason: collision with root package name */
    Supplier<? extends AbstractCache.StatsCounter> f26435p = f26415q;

    /* loaded from: classes5.dex */
    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void b() {
        boolean z3;
        if (this.f26430k == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "refreshAfterWrite requires a LoadingCache");
    }

    private void c() {
        boolean z3 = true;
        if (this.f26425f == null) {
            if (this.f26424e != -1) {
                z3 = false;
            }
            Preconditions.checkState(z3, "maximumWeight requires weigher");
        } else if (this.f26420a) {
            if (this.f26424e == -1) {
                z3 = false;
            }
            Preconditions.checkState(z3, "weigher requires maximumWeight");
        } else if (this.f26424e == -1) {
            f26419u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.d().t();
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AbstractCache.StatsCounter s() {
        return new AbstractCache.SimpleStatsCounter();
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        c();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> concurrencyLevel(int i4) {
        boolean z3;
        int i5 = this.f26422c;
        boolean z4 = true;
        if (i5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "concurrency level was already set to %s", i5);
        if (i4 <= 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        this.f26422c = i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        int i4 = this.f26422c;
        if (i4 == -1) {
            return 4;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long e() {
        long j4 = this.f26429j;
        if (j4 == -1) {
            return 0L;
        }
        return j4;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> expireAfterAccess(long j4, TimeUnit timeUnit) {
        boolean z3;
        long j5 = this.f26429j;
        boolean z4 = true;
        if (j5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "expireAfterAccess was already set to %s ns", j5);
        if (j4 < 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "duration cannot be negative: %s %s", j4, timeUnit);
        this.f26429j = timeUnit.toNanos(j4);
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> expireAfterWrite(long j4, TimeUnit timeUnit) {
        boolean z3;
        long j5 = this.f26428i;
        boolean z4 = true;
        if (j5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "expireAfterWrite was already set to %s ns", j5);
        if (j4 < 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "duration cannot be negative: %s %s", j4, timeUnit);
        this.f26428i = timeUnit.toNanos(j4);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f() {
        long j4 = this.f26428i;
        if (j4 == -1) {
            return 0L;
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        int i4 = this.f26421b;
        if (i4 == -1) {
            return 16;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> h() {
        return (Equivalence) MoreObjects.firstNonNull(this.f26431l, i().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength i() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.f26426g, LocalCache.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> initialCapacity(int i4) {
        boolean z3;
        int i5 = this.f26421b;
        boolean z4 = true;
        if (i5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "initial capacity was already set to %s", i5);
        if (i4 < 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        this.f26421b = i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j() {
        if (this.f26428i == 0 || this.f26429j == 0) {
            return 0L;
        }
        if (this.f26425f == null) {
            return this.f26423d;
        }
        return this.f26424e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long k() {
        long j4 = this.f26430k;
        if (j4 == -1) {
            return 0L;
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> l() {
        return (RemovalListener) MoreObjects.firstNonNull(this.f26433n, NullListener.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache.StatsCounter> m() {
        return this.f26435p;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> maximumSize(long j4) {
        boolean z3;
        boolean z4;
        boolean z5;
        long j5 = this.f26423d;
        boolean z6 = true;
        if (j5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "maximum size was already set to %s", j5);
        long j6 = this.f26424e;
        if (j6 == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4, "maximum weight was already set to %s", j6);
        if (this.f26425f == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "maximum size can not be combined with weigher");
        if (j4 < 0) {
            z6 = false;
        }
        Preconditions.checkArgument(z6, "maximum size must not be negative");
        this.f26423d = j4;
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j4) {
        boolean z3;
        boolean z4;
        long j5 = this.f26424e;
        boolean z5 = true;
        if (j5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "maximum weight was already set to %s", j5);
        long j6 = this.f26423d;
        if (j6 == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4, "maximum size was already set to %s", j6);
        if (j4 < 0) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "maximum weight must not be negative");
        this.f26424e = j4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ticker n(boolean z3) {
        Ticker ticker = this.f26434o;
        if (ticker != null) {
            return ticker;
        }
        if (z3) {
            return Ticker.systemTicker();
        }
        return f26418t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> o() {
        return (Equivalence) MoreObjects.firstNonNull(this.f26432m, p().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength p() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.f26427h, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> q() {
        return (Weigher) MoreObjects.firstNonNull(this.f26425f, OneWeigher.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public CacheBuilder<K, V> r(Equivalence<Object> equivalence) {
        boolean z3;
        Equivalence<Object> equivalence2 = this.f26431l;
        if (equivalence2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "key equivalence was already set to %s", equivalence2);
        this.f26431l = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> recordStats() {
        this.f26435p = f26417s;
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j4, TimeUnit timeUnit) {
        boolean z3;
        Preconditions.checkNotNull(timeUnit);
        long j5 = this.f26430k;
        boolean z4 = true;
        if (j5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "refresh was already set to %s ns", j5);
        if (j4 <= 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "duration must be positive: %s %s", j4, timeUnit);
        this.f26430k = timeUnit.toNanos(j4);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener) {
        boolean z3;
        if (this.f26433n == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        this.f26433n = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        return v(LocalCache.Strength.SOFT);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    CacheBuilder<K, V> t() {
        this.f26420a = false;
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> ticker(Ticker ticker) {
        boolean z3;
        if (this.f26434o == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        this.f26434o = (Ticker) Preconditions.checkNotNull(ticker);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i4 = this.f26421b;
        if (i4 != -1) {
            stringHelper.add("initialCapacity", i4);
        }
        int i5 = this.f26422c;
        if (i5 != -1) {
            stringHelper.add("concurrencyLevel", i5);
        }
        long j4 = this.f26423d;
        if (j4 != -1) {
            stringHelper.add("maximumSize", j4);
        }
        long j5 = this.f26424e;
        if (j5 != -1) {
            stringHelper.add("maximumWeight", j5);
        }
        if (this.f26428i != -1) {
            stringHelper.add("expireAfterWrite", this.f26428i + "ns");
        }
        if (this.f26429j != -1) {
            stringHelper.add("expireAfterAccess", this.f26429j + "ns");
        }
        LocalCache.Strength strength = this.f26426g;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f26427h;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.f26431l != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.f26432m != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.f26433n != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> u(LocalCache.Strength strength) {
        boolean z3;
        LocalCache.Strength strength2 = this.f26426g;
        if (strength2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Key strength was already set to %s", strength2);
        this.f26426g = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> v(LocalCache.Strength strength) {
        boolean z3;
        LocalCache.Strength strength2 = this.f26427h;
        if (strength2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Value strength was already set to %s", strength2);
        this.f26427h = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public CacheBuilder<K, V> w(Equivalence<Object> equivalence) {
        boolean z3;
        Equivalence<Object> equivalence2 = this.f26432m;
        if (equivalence2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "value equivalence was already set to %s", equivalence2);
        this.f26432m = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        return u(LocalCache.Strength.WEAK);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        return v(LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher) {
        boolean z3;
        boolean z4 = true;
        if (this.f26425f == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (this.f26420a) {
            long j4 = this.f26423d;
            if (j4 != -1) {
                z4 = false;
            }
            Preconditions.checkState(z4, "weigher can not be combined with maximum size (%s provided)", j4);
        }
        this.f26425f = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        c();
        b();
        return new LocalCache.LocalManualCache(this);
    }

    /* loaded from: classes5.dex */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }
}
