package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class MapMaker {

    /* renamed from: a  reason: collision with root package name */
    boolean f27097a;

    /* renamed from: b  reason: collision with root package name */
    int f27098b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f27099c = -1;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    MapMakerInternalMap.Strength f27100d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    MapMakerInternalMap.Strength f27101e;
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    Equivalence<Object> f27102f;

    /* loaded from: classes5.dex */
    enum Dummy {
        VALUE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i4 = this.f27099c;
        if (i4 == -1) {
            return 4;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i4 = this.f27098b;
        if (i4 == -1) {
            return 16;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> c() {
        return (Equivalence) MoreObjects.firstNonNull(this.f27102f, d().b());
    }

    @CanIgnoreReturnValue
    public MapMaker concurrencyLevel(int i4) {
        boolean z3;
        int i5 = this.f27099c;
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
        this.f27099c = i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength d() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.f27100d, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.f27101e, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker f(Equivalence<Object> equivalence) {
        boolean z3;
        Equivalence<Object> equivalence2 = this.f27102f;
        if (equivalence2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "key equivalence was already set to %s", equivalence2);
        this.f27102f = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.f27097a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker g(MapMakerInternalMap.Strength strength) {
        boolean z3;
        MapMakerInternalMap.Strength strength2 = this.f27100d;
        if (strength2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Key strength was already set to %s", strength2);
        this.f27100d = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f27097a = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker h(MapMakerInternalMap.Strength strength) {
        boolean z3;
        MapMakerInternalMap.Strength strength2 = this.f27101e;
        if (strength2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Value strength was already set to %s", strength2);
        this.f27101e = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f27097a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public MapMaker initialCapacity(int i4) {
        boolean z3;
        int i5 = this.f27098b;
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
        this.f27098b = i4;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.f27097a) {
            return new ConcurrentHashMap(b(), 0.75f, a());
        }
        return MapMakerInternalMap.c(this);
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i4 = this.f27098b;
        if (i4 != -1) {
            stringHelper.add("initialCapacity", i4);
        }
        int i5 = this.f27099c;
        if (i5 != -1) {
            stringHelper.add("concurrencyLevel", i5);
        }
        MapMakerInternalMap.Strength strength = this.f27100d;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f27101e;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.f27102f != null) {
            stringHelper.addValue("keyEquivalence");
        }
        return stringHelper.toString();
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakKeys() {
        return g(MapMakerInternalMap.Strength.WEAK);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakValues() {
        return h(MapMakerInternalMap.Strength.WEAK);
    }
}
