package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class CacheBuilderSpec {

    /* renamed from: o  reason: collision with root package name */
    private static final Splitter f26440o = Splitter.on(',').trimResults();

    /* renamed from: p  reason: collision with root package name */
    private static final Splitter f26441p = Splitter.on((char) SignatureVisitor.INSTANCEOF).trimResults();

    /* renamed from: q  reason: collision with root package name */
    private static final ImmutableMap<String, ValueParser> f26442q;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    Integer f26443a;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    Long f26444b;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    Long f26445c;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    Integer f26446d;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    LocalCache.Strength f26447e;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    LocalCache.Strength f26448f;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: g  reason: collision with root package name */
    Boolean f26449g;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    long f26450h;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: i  reason: collision with root package name */
    TimeUnit f26451i;
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    long f26452j;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: k  reason: collision with root package name */
    TimeUnit f26453k;
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    long f26454l;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: m  reason: collision with root package name */
    TimeUnit f26455m;

    /* renamed from: n  reason: collision with root package name */
    private final String f26456n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.cache.CacheBuilderSpec$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26457a;

        static {
            int[] iArr = new int[LocalCache.Strength.values().length];
            f26457a = iArr;
            try {
                iArr[LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26457a[LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    static class AccessDurationParser extends DurationParser {
        AccessDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void b(CacheBuilderSpec cacheBuilderSpec, long j4, TimeUnit timeUnit) {
            boolean z3;
            if (cacheBuilderSpec.f26453k == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "expireAfterAccess already set");
            cacheBuilderSpec.f26452j = j4;
            cacheBuilderSpec.f26453k = timeUnit;
        }
    }

    /* loaded from: classes5.dex */
    static class ConcurrencyLevelParser extends IntegerParser {
        ConcurrencyLevelParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void b(CacheBuilderSpec cacheBuilderSpec, int i4) {
            boolean z3;
            Integer num = cacheBuilderSpec.f26446d;
            if (num == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "concurrency level was already set to %s", num);
            cacheBuilderSpec.f26446d = Integer.valueOf(i4);
        }
    }

    /* loaded from: classes5.dex */
    static abstract class DurationParser implements ValueParser {
        DurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            TimeUnit timeUnit;
            if (!Strings.isNullOrEmpty(str2)) {
                try {
                    char charAt = str2.charAt(str2.length() - 1);
                    if (charAt != 'd') {
                        if (charAt != 'h') {
                            if (charAt != 'm') {
                                if (charAt == 's') {
                                    timeUnit = TimeUnit.SECONDS;
                                } else {
                                    throw new IllegalArgumentException(CacheBuilderSpec.c("key %s invalid unit: was %s, must end with one of [dhms]", str, str2));
                                }
                            } else {
                                timeUnit = TimeUnit.MINUTES;
                            }
                        } else {
                            timeUnit = TimeUnit.HOURS;
                        }
                    } else {
                        timeUnit = TimeUnit.DAYS;
                    }
                    b(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
                    return;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException(CacheBuilderSpec.c("key %s value set to %s, must be integer", str, str2));
                }
            }
            throw new IllegalArgumentException("value of key " + str + " omitted");
        }

        protected abstract void b(CacheBuilderSpec cacheBuilderSpec, long j4, TimeUnit timeUnit);
    }

    /* loaded from: classes5.dex */
    static class InitialCapacityParser extends IntegerParser {
        InitialCapacityParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void b(CacheBuilderSpec cacheBuilderSpec, int i4) {
            boolean z3;
            Integer num = cacheBuilderSpec.f26443a;
            if (num == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "initial capacity was already set to %s", num);
            cacheBuilderSpec.f26443a = Integer.valueOf(i4);
        }
    }

    /* loaded from: classes5.dex */
    static abstract class IntegerParser implements ValueParser {
        IntegerParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!Strings.isNullOrEmpty(str2)) {
                try {
                    b(cacheBuilderSpec, Integer.parseInt(str2));
                    return;
                } catch (NumberFormatException e4) {
                    throw new IllegalArgumentException(CacheBuilderSpec.c("key %s value set to %s, must be integer", str, str2), e4);
                }
            }
            throw new IllegalArgumentException("value of key " + str + " omitted");
        }

        protected abstract void b(CacheBuilderSpec cacheBuilderSpec, int i4);
    }

    /* loaded from: classes5.dex */
    static class KeyStrengthParser implements ValueParser {

        /* renamed from: a  reason: collision with root package name */
        private final LocalCache.Strength f26458a;

        public KeyStrengthParser(LocalCache.Strength strength) {
            this.f26458a = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            boolean z3;
            boolean z4 = true;
            if (str2 == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.f26447e;
            if (strength != null) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "%s was already set to %s", str, strength);
            cacheBuilderSpec.f26447e = this.f26458a;
        }
    }

    /* loaded from: classes5.dex */
    static abstract class LongParser implements ValueParser {
        LongParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!Strings.isNullOrEmpty(str2)) {
                try {
                    b(cacheBuilderSpec, Long.parseLong(str2));
                    return;
                } catch (NumberFormatException e4) {
                    throw new IllegalArgumentException(CacheBuilderSpec.c("key %s value set to %s, must be integer", str, str2), e4);
                }
            }
            throw new IllegalArgumentException("value of key " + str + " omitted");
        }

        protected abstract void b(CacheBuilderSpec cacheBuilderSpec, long j4);
    }

    /* loaded from: classes5.dex */
    static class MaximumSizeParser extends LongParser {
        MaximumSizeParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void b(CacheBuilderSpec cacheBuilderSpec, long j4) {
            boolean z3;
            Long l4 = cacheBuilderSpec.f26444b;
            boolean z4 = true;
            if (l4 == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maximum size was already set to %s", l4);
            Long l5 = cacheBuilderSpec.f26445c;
            if (l5 != null) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "maximum weight was already set to %s", l5);
            cacheBuilderSpec.f26444b = Long.valueOf(j4);
        }
    }

    /* loaded from: classes5.dex */
    static class MaximumWeightParser extends LongParser {
        MaximumWeightParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void b(CacheBuilderSpec cacheBuilderSpec, long j4) {
            boolean z3;
            Long l4 = cacheBuilderSpec.f26445c;
            boolean z4 = true;
            if (l4 == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maximum weight was already set to %s", l4);
            Long l5 = cacheBuilderSpec.f26444b;
            if (l5 != null) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "maximum size was already set to %s", l5);
            cacheBuilderSpec.f26445c = Long.valueOf(j4);
        }
    }

    /* loaded from: classes5.dex */
    static class RecordStatsParser implements ValueParser {
        RecordStatsParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            boolean z3;
            boolean z4 = true;
            if (str2 == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "recordStats does not take values");
            if (cacheBuilderSpec.f26449g != null) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "recordStats already set");
            cacheBuilderSpec.f26449g = Boolean.TRUE;
        }
    }

    /* loaded from: classes5.dex */
    static class RefreshDurationParser extends DurationParser {
        RefreshDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void b(CacheBuilderSpec cacheBuilderSpec, long j4, TimeUnit timeUnit) {
            boolean z3;
            if (cacheBuilderSpec.f26455m == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "refreshAfterWrite already set");
            cacheBuilderSpec.f26454l = j4;
            cacheBuilderSpec.f26455m = timeUnit;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface ValueParser {
        void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2);
    }

    /* loaded from: classes5.dex */
    static class ValueStrengthParser implements ValueParser {

        /* renamed from: a  reason: collision with root package name */
        private final LocalCache.Strength f26459a;

        public ValueStrengthParser(LocalCache.Strength strength) {
            this.f26459a = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            boolean z3;
            boolean z4 = true;
            if (str2 == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.f26448f;
            if (strength != null) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "%s was already set to %s", str, strength);
            cacheBuilderSpec.f26448f = this.f26459a;
        }
    }

    /* loaded from: classes5.dex */
    static class WriteDurationParser extends DurationParser {
        WriteDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void b(CacheBuilderSpec cacheBuilderSpec, long j4, TimeUnit timeUnit) {
            boolean z3;
            if (cacheBuilderSpec.f26451i == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "expireAfterWrite already set");
            cacheBuilderSpec.f26450h = j4;
            cacheBuilderSpec.f26451i = timeUnit;
        }
    }

    static {
        ImmutableMap.Builder put = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        f26442q = put.put("weakKeys", new KeyStrengthParser(strength)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(strength)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).buildOrThrow();
    }

    private CacheBuilderSpec(String str) {
        this.f26456n = str;
    }

    @CheckForNull
    private static Long b(long j4, @CheckForNull TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    public static CacheBuilderSpec parse(String str) {
        boolean z3;
        String str2;
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String str3 : f26440o.split(str)) {
                ImmutableList copyOf = ImmutableList.copyOf(f26441p.split(str3));
                Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                boolean z4 = false;
                if (copyOf.size() <= 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "key-value pair %s with more than one equals sign", str3);
                String str4 = (String) copyOf.get(0);
                ValueParser valueParser = f26442q.get(str4);
                if (valueParser != null) {
                    z4 = true;
                }
                Preconditions.checkArgument(z4, "unknown key %s", str4);
                if (copyOf.size() == 1) {
                    str2 = null;
                } else {
                    str2 = (String) copyOf.get(1);
                }
                valueParser.a(cacheBuilderSpec, str4, str2);
            }
        }
        return cacheBuilderSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<Object, Object> d() {
        CacheBuilder<Object, Object> newBuilder = CacheBuilder.newBuilder();
        Integer num = this.f26443a;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        Long l4 = this.f26444b;
        if (l4 != null) {
            newBuilder.maximumSize(l4.longValue());
        }
        Long l5 = this.f26445c;
        if (l5 != null) {
            newBuilder.maximumWeight(l5.longValue());
        }
        Integer num2 = this.f26446d;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        LocalCache.Strength strength = this.f26447e;
        if (strength != null) {
            if (AnonymousClass1.f26457a[strength.ordinal()] == 1) {
                newBuilder.weakKeys();
            } else {
                throw new AssertionError();
            }
        }
        LocalCache.Strength strength2 = this.f26448f;
        if (strength2 != null) {
            int i4 = AnonymousClass1.f26457a[strength2.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    newBuilder.softValues();
                } else {
                    throw new AssertionError();
                }
            } else {
                newBuilder.weakValues();
            }
        }
        Boolean bool = this.f26449g;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        TimeUnit timeUnit = this.f26451i;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(this.f26450h, timeUnit);
        }
        TimeUnit timeUnit2 = this.f26453k;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(this.f26452j, timeUnit2);
        }
        TimeUnit timeUnit3 = this.f26455m;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(this.f26454l, timeUnit3);
        }
        return newBuilder;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        if (Objects.equal(this.f26443a, cacheBuilderSpec.f26443a) && Objects.equal(this.f26444b, cacheBuilderSpec.f26444b) && Objects.equal(this.f26445c, cacheBuilderSpec.f26445c) && Objects.equal(this.f26446d, cacheBuilderSpec.f26446d) && Objects.equal(this.f26447e, cacheBuilderSpec.f26447e) && Objects.equal(this.f26448f, cacheBuilderSpec.f26448f) && Objects.equal(this.f26449g, cacheBuilderSpec.f26449g) && Objects.equal(b(this.f26450h, this.f26451i), b(cacheBuilderSpec.f26450h, cacheBuilderSpec.f26451i)) && Objects.equal(b(this.f26452j, this.f26453k), b(cacheBuilderSpec.f26452j, cacheBuilderSpec.f26453k)) && Objects.equal(b(this.f26454l, this.f26455m), b(cacheBuilderSpec.f26454l, cacheBuilderSpec.f26455m))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f26443a, this.f26444b, this.f26445c, this.f26446d, this.f26447e, this.f26448f, this.f26449g, b(this.f26450h, this.f26451i), b(this.f26452j, this.f26453k), b(this.f26454l, this.f26455m));
    }

    public String toParsableString() {
        return this.f26456n;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
