package com.google.common.base;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Stopwatch {

    /* renamed from: a  reason: collision with root package name */
    private final Ticker f26383a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26384b;

    /* renamed from: c  reason: collision with root package name */
    private long f26385c;

    /* renamed from: d  reason: collision with root package name */
    private long f26386d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.base.Stopwatch$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26387a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f26387a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26387a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26387a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26387a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26387a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26387a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26387a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    Stopwatch() {
        this.f26383a = Ticker.systemTicker();
    }

    private static String a(TimeUnit timeUnit) {
        switch (AnonymousClass1.f26387a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return TranslateLanguage.MALAY;
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private static TimeUnit b(long j4) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j4, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j4, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j4, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j4, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j4, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        if (timeUnit7.convert(j4, timeUnit2) > 0) {
            return timeUnit7;
        }
        return timeUnit2;
    }

    private long c() {
        if (this.f26384b) {
            return (this.f26383a.read() - this.f26386d) + this.f26385c;
        }
        return this.f26385c;
    }

    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    public long elapsed(TimeUnit timeUnit) {
        return timeUnit.convert(c(), TimeUnit.NANOSECONDS);
    }

    public boolean isRunning() {
        return this.f26384b;
    }

    @CanIgnoreReturnValue
    public Stopwatch reset() {
        this.f26385c = 0L;
        this.f26384b = false;
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch start() {
        Preconditions.checkState(!this.f26384b, "This stopwatch is already running.");
        this.f26384b = true;
        this.f26386d = this.f26383a.read();
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch stop() {
        long read = this.f26383a.read();
        Preconditions.checkState(this.f26384b, "This stopwatch is already stopped.");
        this.f26384b = false;
        this.f26385c += read - this.f26386d;
        return this;
    }

    public String toString() {
        long c4 = c();
        TimeUnit b4 = b(c4);
        double convert = c4 / TimeUnit.NANOSECONDS.convert(1L, b4);
        return Platform.c(convert) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + a(b4);
    }

    public static Stopwatch createStarted(Ticker ticker) {
        return new Stopwatch(ticker).start();
    }

    public static Stopwatch createUnstarted(Ticker ticker) {
        return new Stopwatch(ticker);
    }

    Stopwatch(Ticker ticker) {
        this.f26383a = (Ticker) Preconditions.checkNotNull(ticker, "ticker");
    }
}
