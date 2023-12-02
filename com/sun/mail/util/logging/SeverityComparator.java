package com.sun.mail.util.logging;

import java.io.Serializable;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes6.dex */
public class SeverityComparator implements Comparator<LogRecord>, Serializable {
    private static final Comparator<LogRecord> INSTANCE = new SeverityComparator();
    private static final long serialVersionUID = -2620442245251791965L;

    private int compare(long j4, long j5) {
        int i4 = (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
        if (i4 < 0) {
            return -1;
        }
        return i4 > 0 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SeverityComparator getInstance() {
        return (SeverityComparator) INSTANCE;
    }

    private static String toString(Object obj, Object obj2) {
        return obj + ", " + obj2;
    }

    public Throwable apply(Throwable th) {
        Throwable th2 = th;
        Throwable th3 = null;
        Throwable th4 = null;
        int i4 = 0;
        while (true) {
            if (th != null) {
                if (isNormal(th)) {
                    th3 = th;
                }
                if (th3 == null && (th instanceof Error)) {
                    th4 = th;
                }
                i4++;
                if (i4 == 65536) {
                    break;
                }
                th2 = th;
                th = th.getCause();
            } else {
                th = th2;
                break;
            }
        }
        if (th4 != null) {
            return th4;
        }
        if (th3 != null) {
            return th3;
        }
        return th;
    }

    public final int applyThenCompare(Throwable th, Throwable th2) {
        if (th == th2) {
            return 0;
        }
        return compareThrowable(apply(th), apply(th2));
    }

    public int compareThrowable(Throwable th, Throwable th2) {
        if (th == th2) {
            return 0;
        }
        if (th == null) {
            if (isNormal(th2)) {
                return 1;
            }
            return -1;
        } else if (th2 == null) {
            if (!isNormal(th)) {
                return 1;
            }
            return -1;
        } else if (th.getClass() == th2.getClass()) {
            return 0;
        } else {
            if (isNormal(th)) {
                if (isNormal(th2)) {
                    return 0;
                }
                return -1;
            } else if (isNormal(th2)) {
                return 1;
            } else {
                if (th instanceof Error) {
                    return !(th2 instanceof Error) ? 1 : 0;
                }
                if (th instanceof RuntimeException) {
                    if (th2 instanceof Error) {
                        return -1;
                    }
                    if (th2 instanceof RuntimeException) {
                        return 0;
                    }
                    return 1;
                } else if (!(th2 instanceof Error) && !(th2 instanceof RuntimeException)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getClass().hashCode() * 31;
    }

    public boolean isNormal(Throwable th) {
        if (th == null) {
            return false;
        }
        for (Class<?> cls = th.getClass(); cls != Throwable.class; cls = cls.getSuperclass()) {
            if (Error.class.isAssignableFrom(cls)) {
                if (cls.getName().equals("java.lang.ThreadDeath")) {
                    return true;
                }
            } else if (cls.getName().contains("Interrupt")) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Comparator
    public int compare(LogRecord logRecord, LogRecord logRecord2) {
        if (logRecord == null || logRecord2 == null) {
            throw new NullPointerException(toString(logRecord, logRecord2));
        }
        if (logRecord == logRecord2) {
            return 0;
        }
        int compare = compare(logRecord.getLevel(), logRecord2.getLevel());
        if (compare == 0) {
            int applyThenCompare = applyThenCompare(logRecord.getThrown(), logRecord2.getThrown());
            if (applyThenCompare == 0) {
                int compare2 = compare(logRecord.getSequenceNumber(), logRecord2.getSequenceNumber());
                return compare2 == 0 ? compare(logRecord.getMillis(), logRecord2.getMillis()) : compare2;
            }
            return applyThenCompare;
        }
        return compare;
    }

    private int compare(Level level, Level level2) {
        if (level == level2) {
            return 0;
        }
        return compare(level.intValue(), level2.intValue());
    }
}
