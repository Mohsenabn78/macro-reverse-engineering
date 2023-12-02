package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class CacheStats {

    /* renamed from: a  reason: collision with root package name */
    private final long f26462a;

    /* renamed from: b  reason: collision with root package name */
    private final long f26463b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26464c;

    /* renamed from: d  reason: collision with root package name */
    private final long f26465d;

    /* renamed from: e  reason: collision with root package name */
    private final long f26466e;

    /* renamed from: f  reason: collision with root package name */
    private final long f26467f;

    public CacheStats(long j4, long j5, long j6, long j7, long j8, long j9) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (j5 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        if (j6 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        if (j7 >= 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkArgument(z6);
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7);
        Preconditions.checkArgument(j9 >= 0);
        this.f26462a = j4;
        this.f26463b = j5;
        this.f26464c = j6;
        this.f26465d = j7;
        this.f26466e = j8;
        this.f26467f = j9;
    }

    public double averageLoadPenalty() {
        long saturatedAdd = LongMath.saturatedAdd(this.f26464c, this.f26465d);
        if (saturatedAdd == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return this.f26466e / saturatedAdd;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        if (this.f26462a != cacheStats.f26462a || this.f26463b != cacheStats.f26463b || this.f26464c != cacheStats.f26464c || this.f26465d != cacheStats.f26465d || this.f26466e != cacheStats.f26466e || this.f26467f != cacheStats.f26467f) {
            return false;
        }
        return true;
    }

    public long evictionCount() {
        return this.f26467f;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f26462a), Long.valueOf(this.f26463b), Long.valueOf(this.f26464c), Long.valueOf(this.f26465d), Long.valueOf(this.f26466e), Long.valueOf(this.f26467f));
    }

    public long hitCount() {
        return this.f26462a;
    }

    public double hitRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        return this.f26462a / requestCount;
    }

    public long loadCount() {
        return LongMath.saturatedAdd(this.f26464c, this.f26465d);
    }

    public long loadExceptionCount() {
        return this.f26465d;
    }

    public double loadExceptionRate() {
        long saturatedAdd = LongMath.saturatedAdd(this.f26464c, this.f26465d);
        if (saturatedAdd == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return this.f26465d / saturatedAdd;
    }

    public long loadSuccessCount() {
        return this.f26464c;
    }

    public CacheStats minus(CacheStats cacheStats) {
        return new CacheStats(Math.max(0L, LongMath.saturatedSubtract(this.f26462a, cacheStats.f26462a)), Math.max(0L, LongMath.saturatedSubtract(this.f26463b, cacheStats.f26463b)), Math.max(0L, LongMath.saturatedSubtract(this.f26464c, cacheStats.f26464c)), Math.max(0L, LongMath.saturatedSubtract(this.f26465d, cacheStats.f26465d)), Math.max(0L, LongMath.saturatedSubtract(this.f26466e, cacheStats.f26466e)), Math.max(0L, LongMath.saturatedSubtract(this.f26467f, cacheStats.f26467f)));
    }

    public long missCount() {
        return this.f26463b;
    }

    public double missRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return this.f26463b / requestCount;
    }

    public CacheStats plus(CacheStats cacheStats) {
        return new CacheStats(LongMath.saturatedAdd(this.f26462a, cacheStats.f26462a), LongMath.saturatedAdd(this.f26463b, cacheStats.f26463b), LongMath.saturatedAdd(this.f26464c, cacheStats.f26464c), LongMath.saturatedAdd(this.f26465d, cacheStats.f26465d), LongMath.saturatedAdd(this.f26466e, cacheStats.f26466e), LongMath.saturatedAdd(this.f26467f, cacheStats.f26467f));
    }

    public long requestCount() {
        return LongMath.saturatedAdd(this.f26462a, this.f26463b);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("hitCount", this.f26462a).add("missCount", this.f26463b).add("loadSuccessCount", this.f26464c).add("loadExceptionCount", this.f26465d).add("totalLoadTime", this.f26466e).add("evictionCount", this.f26467f).toString();
    }

    public long totalLoadTime() {
        return this.f26466e;
    }
}
