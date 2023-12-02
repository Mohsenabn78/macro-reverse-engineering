package com.sun.mail.util.logging;

import androidx.work.PeriodicWorkRequest;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/* loaded from: classes6.dex */
public class DurationFilter implements Filter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long count;
    private final long duration;
    private long peak;
    private final long records;
    private long start;

    public DurationFilter() {
        this.records = checkRecords(initLong(".records"));
        this.duration = checkDuration(initLong(".duration"));
    }

    private synchronized boolean accept(long j4) {
        boolean z3;
        long j5 = this.count;
        z3 = false;
        if (j5 > 0) {
            if (j4 - this.peak > 0) {
                this.peak = j4;
            }
            if (j5 != this.records) {
                this.count = j5 + 1;
            } else {
                long j6 = this.peak;
                long j7 = this.duration;
                if (j6 - this.start >= j7) {
                    this.count = 1L;
                    this.start = j6;
                } else {
                    this.count = -1L;
                    this.start = j6 + j7;
                }
            }
            z3 = true;
        } else if (j4 - this.start >= 0 || j5 == 0) {
            this.count = 1L;
            this.start = j4;
            this.peak = j4;
            z3 = true;
        }
        return z3;
    }

    private static long checkDuration(long j4) {
        if (j4 <= 0) {
            return PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        }
        return j4;
    }

    private static long checkRecords(long j4) {
        if (j4 <= 0) {
            return 1000L;
        }
        return j4;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long initLong(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.Class r0 = r9.getClass()
            java.lang.String r0 = r0.getName()
            java.lang.String r0 = r0.concat(r10)
            java.lang.String r0 = com.sun.mail.util.logging.LogManagerProperties.fromLogManager(r0)
            r1 = -9223372036854775808
            if (r0 == 0) goto L66
            int r3 = r0.length()
            if (r3 == 0) goto L66
            java.lang.String r0 = r0.trim()
            boolean r10 = r9.isTimeEntry(r10, r0)
            r3 = 0
            if (r10 == 0) goto L2c
            long r5 = com.sun.mail.util.logging.LogManagerProperties.parseDurationToMillis(r0)     // Catch: java.lang.Throwable -> L2b
            goto L2d
        L2b:
        L2c:
            r5 = r3
        L2d:
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 != 0) goto L65
            java.lang.String[] r10 = tokenizeLongs(r0)     // Catch: java.lang.RuntimeException -> L66
            int r0 = r10.length     // Catch: java.lang.RuntimeException -> L66
            r3 = 0
            r4 = 1
            r6 = 0
        L3a:
            if (r6 >= r0) goto L63
            r7 = r10[r6]     // Catch: java.lang.RuntimeException -> L66
            java.lang.String r8 = "L"
            boolean r8 = r7.endsWith(r8)     // Catch: java.lang.RuntimeException -> L66
            if (r8 != 0) goto L4e
            java.lang.String r8 = "l"
            boolean r8 = r7.endsWith(r8)     // Catch: java.lang.RuntimeException -> L66
            if (r8 == 0) goto L58
        L4e:
            int r8 = r7.length()     // Catch: java.lang.RuntimeException -> L66
            int r8 = r8 + (-1)
            java.lang.String r7 = r7.substring(r3, r8)     // Catch: java.lang.RuntimeException -> L66
        L58:
            long r7 = java.lang.Long.parseLong(r7)     // Catch: java.lang.RuntimeException -> L66
            long r4 = multiplyExact(r4, r7)     // Catch: java.lang.RuntimeException -> L66
            int r6 = r6 + 1
            goto L3a
        L63:
            r1 = r4
            goto L66
        L65:
            r1 = r5
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.DurationFilter.initLong(java.lang.String):long");
    }

    private boolean isTimeEntry(String str, String str2) {
        if ((str2.charAt(0) != 'P' && str2.charAt(0) != 'p') || !str.equals(".duration")) {
            return false;
        }
        return true;
    }

    private static long multiplyExact(long j4, long j5) {
        long j6 = j4 * j5;
        if (((Math.abs(j4) | Math.abs(j5)) >>> 31) != 0 && ((j5 != 0 && j6 / j5 != j4) || (j4 == Long.MIN_VALUE && j5 == -1))) {
            throw new ArithmeticException();
        }
        return j6;
    }

    private boolean test(long j4, long j5) {
        long j6;
        long j7;
        synchronized (this) {
            j6 = this.count;
            j7 = this.start;
        }
        int i4 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (i4 > 0) {
            if (j5 - j7 >= this.duration || j6 < j4) {
                return true;
            }
            return false;
        } else if (j5 - j7 >= 0 || i4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static String[] tokenizeLongs(String str) {
        int indexOf = str.indexOf(42);
        if (indexOf > -1) {
            String[] split = str.split("\\s*\\*\\s*");
            if (split.length != 0) {
                if (indexOf != 0 && str.charAt(str.length() - 1) != '*') {
                    if (split.length == 1) {
                        throw new NumberFormatException(split[0]);
                    }
                    return split;
                }
                throw new NumberFormatException(str);
            }
        }
        return new String[]{str};
    }

    public boolean equals(Object obj) {
        long j4;
        long j5;
        long j6;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DurationFilter durationFilter = (DurationFilter) obj;
        if (this.records != durationFilter.records || this.duration != durationFilter.duration) {
            return false;
        }
        synchronized (this) {
            j4 = this.count;
            j5 = this.peak;
            j6 = this.start;
        }
        synchronized (durationFilter) {
            if (j4 == durationFilter.count && j5 == durationFilter.peak && j6 == durationFilter.start) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        long j4 = this.records;
        long j5 = this.duration;
        return ((267 + ((int) (j4 ^ (j4 >>> 32)))) * 89) + ((int) ((j5 >>> 32) ^ j5));
    }

    public boolean isIdle() {
        return test(0L, System.currentTimeMillis());
    }

    @Override // java.util.logging.Filter
    public boolean isLoggable(LogRecord logRecord) {
        return accept(logRecord.getMillis());
    }

    public String toString() {
        boolean test;
        boolean test2;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            test = test(0L, currentTimeMillis);
            test2 = test(this.records, currentTimeMillis);
        }
        return getClass().getName() + "{records=" + this.records + ", duration=" + this.duration + ", idle=" + test + ", loggable=" + test2 + '}';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public DurationFilter m4180clone() throws CloneNotSupportedException {
        DurationFilter durationFilter = (DurationFilter) super.clone();
        durationFilter.count = 0L;
        durationFilter.peak = 0L;
        durationFilter.start = 0L;
        return durationFilter;
    }

    public boolean isLoggable() {
        return test(this.records, System.currentTimeMillis());
    }

    public DurationFilter(long j4, long j5) {
        this.records = checkRecords(j4);
        this.duration = checkDuration(j5);
    }
}
