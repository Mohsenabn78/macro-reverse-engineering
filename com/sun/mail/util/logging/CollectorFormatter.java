package com.sun.mail.util.logging;

import java.lang.reflect.UndeclaredThrowableException;
import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* loaded from: classes6.dex */
public class CollectorFormatter extends Formatter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long INIT_TIME = System.currentTimeMillis();
    private final Comparator<? super LogRecord> comparator;
    private long count;
    private final String fmt;
    private final Formatter formatter;
    private LogRecord last;
    private long thrown;
    private long generation = 1;
    private long minMillis = INIT_TIME;
    private long maxMillis = Long.MIN_VALUE;

    public CollectorFormatter() {
        String name = getClass().getName();
        this.fmt = initFormat(name);
        this.formatter = initFormatter(name);
        this.comparator = initComparator(name);
    }

    private synchronized boolean accept(LogRecord logRecord, LogRecord logRecord2) {
        long millis = logRecord2.getMillis();
        Throwable thrown = logRecord2.getThrown();
        if (this.last == logRecord) {
            long j4 = this.count + 1;
            this.count = j4;
            if (j4 != 1) {
                this.minMillis = Math.min(this.minMillis, millis);
            } else {
                this.minMillis = millis;
            }
            this.maxMillis = Math.max(this.maxMillis, millis);
            if (thrown != null) {
                this.thrown++;
            }
            return true;
        }
        return false;
    }

    private synchronized boolean acceptAndUpdate(LogRecord logRecord, LogRecord logRecord2) {
        if (accept(logRecord, logRecord2)) {
            this.last = logRecord2;
            return true;
        }
        return false;
    }

    private String formatRecord(Handler handler, boolean z3) {
        LogRecord logRecord;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long currentTimeMillis;
        String str;
        String str2;
        String str3;
        String str4;
        MessageFormat messageFormat;
        long j9;
        ResourceBundle resourceBundle;
        synchronized (this) {
            logRecord = this.last;
            j4 = this.count;
            j5 = this.generation;
            j6 = this.thrown;
            j7 = this.minMillis;
            j8 = this.maxMillis;
            currentTimeMillis = System.currentTimeMillis();
            if (j4 == 0) {
                j8 = currentTimeMillis;
            }
            if (z3) {
                reset(j8);
            }
        }
        Formatter formatter = this.formatter;
        if (formatter != null) {
            synchronized (formatter) {
                str = formatter.getHead(handler);
                if (logRecord != null) {
                    str3 = formatter.format(logRecord);
                } else {
                    str3 = "";
                }
                str4 = formatter.getTail(handler);
            }
        } else {
            str = "";
            if (logRecord != null) {
                str2 = formatMessage(logRecord);
            } else {
                str2 = "";
            }
            str3 = str2;
            str4 = "";
        }
        String str5 = str;
        String str6 = str3;
        Locale locale = null;
        if (logRecord != null && (resourceBundle = logRecord.getResourceBundle()) != null) {
            locale = resourceBundle.getLocale();
        }
        if (locale == null) {
            messageFormat = new MessageFormat(this.fmt);
            j9 = currentTimeMillis;
        } else {
            j9 = currentTimeMillis;
            messageFormat = new MessageFormat(this.fmt, locale);
        }
        long j10 = INIT_TIME;
        return messageFormat.format(new Object[]{finish(str5), finish(str6), finish(str4), Long.valueOf(j4), Long.valueOf(j4 - 1), Long.valueOf(j6), Long.valueOf(j4 - j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j8 - j7), Long.valueOf(j10), Long.valueOf(j9), Long.valueOf(j9 - j10), Long.valueOf(j5)});
    }

    private Comparator<? super LogRecord> initComparator(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".comparator"));
        String fromLogManager2 = LogManagerProperties.fromLogManager(str.concat(".comparator.reverse"));
        if (fromLogManager != null) {
            try {
                if (fromLogManager.length() != 0) {
                    if (!"null".equalsIgnoreCase(fromLogManager)) {
                        Comparator<? super LogRecord> newComparator = LogManagerProperties.newComparator(fromLogManager);
                        if (Boolean.parseBoolean(fromLogManager2)) {
                            return LogManagerProperties.reverseOrder(newComparator);
                        }
                        return newComparator;
                    } else if (fromLogManager2 == null) {
                        return null;
                    } else {
                        throw new IllegalArgumentException("No comparator to reverse.");
                    }
                }
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception e5) {
                throw new UndeclaredThrowableException(e5);
            }
        }
        if (fromLogManager2 == null) {
            return (Comparator) Comparator.class.cast(SeverityComparator.getInstance());
        }
        throw new IllegalArgumentException("No comparator to reverse.");
    }

    private String initFormat(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".format"));
        if (fromLogManager == null || fromLogManager.length() == 0) {
            return "{0}{1}{2}{4,choice,-1#|0#|0<... {4,number,integer} more}\n";
        }
        return fromLogManager;
    }

    private Formatter initFormatter(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".formatter"));
        if (fromLogManager != null && fromLogManager.length() != 0) {
            if (!"null".equalsIgnoreCase(fromLogManager)) {
                try {
                    return LogManagerProperties.newFormatter(fromLogManager);
                } catch (RuntimeException e4) {
                    throw e4;
                } catch (Exception e5) {
                    throw new UndeclaredThrowableException(e5);
                }
            }
            return null;
        }
        return (Formatter) Formatter.class.cast(new CompactFormatter());
    }

    private synchronized LogRecord peek() {
        return this.last;
    }

    private synchronized void reset(long j4) {
        if (this.last != null) {
            this.last = null;
            this.generation++;
        }
        this.count = 0L;
        this.thrown = 0L;
        this.minMillis = j4;
        this.maxMillis = Long.MIN_VALUE;
    }

    protected LogRecord apply(LogRecord logRecord, LogRecord logRecord2) {
        if (logRecord != null && logRecord2 != null) {
            Comparator<? super LogRecord> comparator = this.comparator;
            if (comparator != null) {
                if (comparator.compare(logRecord, logRecord2) < 0) {
                    return logRecord2;
                }
                return logRecord;
            }
            return logRecord2;
        }
        throw null;
    }

    protected String finish(String str) {
        return str.trim();
    }

    @Override // java.util.logging.Formatter
    public String format(LogRecord logRecord) {
        LogRecord logRecord2;
        boolean accept;
        logRecord.getClass();
        do {
            LogRecord peek = peek();
            if (peek != null) {
                logRecord2 = peek;
            } else {
                logRecord2 = logRecord;
            }
            LogRecord apply = apply(logRecord2, logRecord);
            if (peek != apply) {
                apply.getSourceMethodName();
                accept = acceptAndUpdate(peek, apply);
                continue;
            } else {
                accept = accept(peek, logRecord);
                continue;
            }
        } while (!accept);
        return "";
    }

    @Override // java.util.logging.Formatter
    public String getTail(Handler handler) {
        super.getTail(handler);
        return formatRecord(handler, true);
    }

    public String toString() {
        try {
            return formatRecord(null, false);
        } catch (RuntimeException unused) {
            return super.toString();
        }
    }

    public CollectorFormatter(String str) {
        String name = getClass().getName();
        this.fmt = str == null ? initFormat(name) : str;
        this.formatter = initFormatter(name);
        this.comparator = initComparator(name);
    }

    public CollectorFormatter(String str, Formatter formatter, Comparator<? super LogRecord> comparator) {
        this.fmt = str == null ? initFormat(getClass().getName()) : str;
        this.formatter = formatter;
        this.comparator = comparator;
    }
}
