package com.sun.mail.util.logging;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.Date;
import java.util.Formattable;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import javax.mail.UIDFolder;

/* loaded from: classes6.dex */
public class CompactFormatter extends Formatter {
    private final String fmt;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class Alternate implements Formattable {
        private final String left;
        private final String right;

        Alternate(String str, String str2) {
            this.left = String.valueOf(str);
            this.right = String.valueOf(str2);
        }

        private int minCodePointCount(String str, int i4) {
            int length = str.length();
            if (length - i4 >= i4) {
                return i4;
            }
            return Math.min(str.codePointCount(0, length), i4);
        }

        private String pad(int i4, String str, int i5) {
            StringBuilder sb = new StringBuilder(Math.max(str.length() + i5, i5));
            int i6 = 0;
            if ((i4 & 1) == 1) {
                while (i6 < i5) {
                    sb.append(' ');
                    i6++;
                }
                sb.append(str);
            } else {
                sb.append(str);
                while (i6 < i5) {
                    sb.append(' ');
                    i6++;
                }
            }
            return sb.toString();
        }

        @Override // java.util.Formattable
        public void formatTo(java.util.Formatter formatter, int i4, int i5, int i6) {
            int i7;
            int i8;
            String str = this.left;
            String str2 = this.right;
            if ((i4 & 2) == 2) {
                str = str.toUpperCase(formatter.locale());
                str2 = str2.toUpperCase(formatter.locale());
            }
            if ((i4 & 4) == 4) {
                str = CompactFormatter.this.toAlternate(str);
                str2 = CompactFormatter.this.toAlternate(str2);
            }
            if (i6 >= 0) {
                i7 = minCodePointCount(str, i6);
                int minCodePointCount = minCodePointCount(str2, i6);
                if (i7 > (i6 >> 1)) {
                    i7 = Math.max(i7 - minCodePointCount, i7 >> 1);
                }
                i8 = Math.min(i6 - i7, minCodePointCount);
                str = str.substring(0, str.offsetByCodePoints(0, i7));
                str2 = str2.substring(0, str2.offsetByCodePoints(0, i8));
            } else {
                i7 = 0;
                i8 = 0;
            }
            if (i5 > 0) {
                if (i6 < 0) {
                    i7 = minCodePointCount(str, i5);
                    i8 = minCodePointCount(str2, i5);
                }
                int i9 = i5 >> 1;
                if (i7 < i9) {
                    str = pad(i4, str, i9 - i7);
                }
                if (i8 < i9) {
                    str2 = pad(i4, str2, i9 - i8);
                }
            }
            formatter.format(str, new Object[0]);
            if (!str.isEmpty() && !str2.isEmpty()) {
                formatter.format("|", new Object[0]);
            }
            formatter.format(str2, new Object[0]);
        }
    }

    static {
        loadDeclaredClasses();
    }

    public CompactFormatter() {
        this.fmt = initFormat(getClass().getName());
    }

    private boolean defaultIgnore(StackTraceElement stackTraceElement) {
        if (!isSynthetic(stackTraceElement) && !isStaticUtility(stackTraceElement) && !isReflection(stackTraceElement)) {
            return false;
        }
        return true;
    }

    private String findAndFormat(StackTraceElement[] stackTraceElementArr) {
        String str;
        int length = stackTraceElementArr.length;
        int i4 = 0;
        while (true) {
            if (i4 < length) {
                StackTraceElement stackTraceElement = stackTraceElementArr[i4];
                if (!ignore(stackTraceElement)) {
                    str = formatStackTraceElement(stackTraceElement);
                    break;
                }
                i4++;
            } else {
                str = "";
                break;
            }
        }
        if (isNullOrSpaces(str)) {
            for (StackTraceElement stackTraceElement2 : stackTraceElementArr) {
                if (!defaultIgnore(stackTraceElement2)) {
                    return formatStackTraceElement(stackTraceElement2);
                }
            }
            return str;
        }
        return str;
    }

    private String formatStackTraceElement(StackTraceElement stackTraceElement) {
        String replace = stackTraceElement.toString().replace(stackTraceElement.getClassName(), simpleClassName(stackTraceElement.getClassName()));
        String simpleFileName = simpleFileName(stackTraceElement.getFileName());
        if (simpleFileName != null && replace.startsWith(simpleFileName)) {
            return replace.replace(stackTraceElement.getFileName(), "");
        }
        return replace;
    }

    private Comparable<?> formatZonedDateTime(LogRecord logRecord) {
        Comparable<?> zonedDateTime = LogManagerProperties.getZonedDateTime(logRecord);
        if (zonedDateTime == null) {
            return new Date(logRecord.getMillis());
        }
        return zonedDateTime;
    }

    private String initFormat(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".format"));
        if (isNullOrSpaces(fromLogManager)) {
            return "%7$#.160s%n";
        }
        return fromLogManager;
    }

    private static boolean isNullOrSpaces(String str) {
        if (str != null && !str.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isReflection(StackTraceElement stackTraceElement) {
        try {
            return LogManagerProperties.isReflectionClass(stackTraceElement.getClassName());
        } catch (RuntimeException | Exception | LinkageError unused) {
            if (!stackTraceElement.getClassName().startsWith("java.lang.reflect.") && !stackTraceElement.getClassName().startsWith("sun.reflect.")) {
                return false;
            }
            return true;
        }
    }

    private boolean isStaticUtility(StackTraceElement stackTraceElement) {
        try {
            return LogManagerProperties.isStaticUtilityClass(stackTraceElement.getClassName());
        } catch (RuntimeException | Exception | LinkageError unused) {
            String className = stackTraceElement.getClassName();
            if ((!className.endsWith("s") || className.endsWith(TranslateLanguage.SPANISH)) && !className.contains("Util") && !className.endsWith("Throwables")) {
                return false;
            }
            return true;
        }
    }

    private boolean isSynthetic(StackTraceElement stackTraceElement) {
        if (stackTraceElement.getMethodName().indexOf(36) > -1) {
            return true;
        }
        return false;
    }

    private boolean isUnknown(StackTraceElement stackTraceElement) {
        if (stackTraceElement.getLineNumber() < 0) {
            return true;
        }
        return false;
    }

    private static Class<?>[] loadDeclaredClasses() {
        return new Class[]{Alternate.class};
    }

    private static String replaceClassName(String str, Throwable th) {
        if (!isNullOrSpaces(str)) {
            int i4 = 0;
            while (th != null) {
                Class<?> cls = th.getClass();
                str = str.replace(cls.getName(), simpleClassName(cls));
                i4++;
                if (i4 == 65536) {
                    break;
                }
                th = th.getCause();
            }
        }
        return str;
    }

    private static String simpleClassName(Class<?> cls) {
        try {
            return cls.getSimpleName();
        } catch (InternalError unused) {
            return simpleClassName(cls.getName());
        }
    }

    private static String simpleFileName(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(46)) > -1) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    protected Throwable apply(Throwable th) {
        return SeverityComparator.getInstance().apply(th);
    }

    @Override // java.util.logging.Formatter
    public String format(LogRecord logRecord) {
        Locale locale;
        ResourceBundle resourceBundle = logRecord.getResourceBundle();
        if (resourceBundle == null) {
            locale = null;
        } else {
            locale = resourceBundle.getLocale();
        }
        String formatMessage = formatMessage(logRecord);
        String formatThrown = formatThrown(logRecord);
        String formatError = formatError(logRecord);
        Object[] objArr = {formatZonedDateTime(logRecord), formatSource(logRecord), formatLoggerName(logRecord), formatLevel(logRecord), formatMessage, formatThrown, new Alternate(formatMessage, formatThrown), new Alternate(formatThrown, formatMessage), Long.valueOf(logRecord.getSequenceNumber()), formatThreadID(logRecord), formatError, new Alternate(formatMessage, formatError), new Alternate(formatError, formatMessage), formatBackTrace(logRecord), logRecord.getResourceBundleName(), logRecord.getMessage()};
        if (locale == null) {
            return String.format(this.fmt, objArr);
        }
        return String.format(locale, this.fmt, objArr);
    }

    public String formatBackTrace(LogRecord logRecord) {
        Throwable thrown = logRecord.getThrown();
        if (thrown != null) {
            StackTraceElement[] stackTrace = apply(thrown).getStackTrace();
            String findAndFormat = findAndFormat(stackTrace);
            if (isNullOrSpaces(findAndFormat)) {
                int i4 = 0;
                while (thrown != null) {
                    StackTraceElement[] stackTrace2 = thrown.getStackTrace();
                    String findAndFormat2 = findAndFormat(stackTrace2);
                    if (isNullOrSpaces(findAndFormat2)) {
                        if (stackTrace.length == 0) {
                            stackTrace = stackTrace2;
                        }
                        i4++;
                        if (i4 != 65536) {
                            thrown = thrown.getCause();
                            findAndFormat = findAndFormat2;
                        }
                    }
                    findAndFormat = findAndFormat2;
                    break;
                }
                if (isNullOrSpaces(findAndFormat) && stackTrace.length != 0) {
                    return formatStackTraceElement(stackTrace[0]);
                }
                return findAndFormat;
            }
            return findAndFormat;
        }
        return "";
    }

    public String formatError(LogRecord logRecord) {
        return formatMessage(logRecord.getThrown());
    }

    public String formatLevel(LogRecord logRecord) {
        return logRecord.getLevel().getLocalizedName();
    }

    public String formatLoggerName(LogRecord logRecord) {
        return simpleClassName(logRecord.getLoggerName());
    }

    @Override // java.util.logging.Formatter
    public String formatMessage(LogRecord logRecord) {
        return replaceClassName(replaceClassName(super.formatMessage(logRecord), logRecord.getThrown()), logRecord.getParameters());
    }

    public String formatSource(LogRecord logRecord) {
        String sourceClassName = logRecord.getSourceClassName();
        if (sourceClassName != null) {
            if (logRecord.getSourceMethodName() != null) {
                return simpleClassName(sourceClassName) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + logRecord.getSourceMethodName();
            }
            return simpleClassName(sourceClassName);
        }
        return simpleClassName(logRecord.getLoggerName());
    }

    public Number formatThreadID(LogRecord logRecord) {
        Long longThreadID = LogManagerProperties.getLongThreadID(logRecord);
        if (longThreadID == null) {
            return Long.valueOf(logRecord.getThreadID() & UIDFolder.MAXUID);
        }
        return longThreadID;
    }

    public String formatThrown(LogRecord logRecord) {
        Throwable thrown = logRecord.getThrown();
        String str = "";
        if (thrown == null) {
            return "";
        }
        String formatBackTrace = formatBackTrace(logRecord);
        StringBuilder sb = new StringBuilder();
        sb.append(formatMessage(thrown));
        if (!isNullOrSpaces(formatBackTrace)) {
            str = ' ' + formatBackTrace;
        }
        sb.append(str);
        return sb.toString();
    }

    protected boolean ignore(StackTraceElement stackTraceElement) {
        if (!isUnknown(stackTraceElement) && !defaultIgnore(stackTraceElement)) {
            return false;
        }
        return true;
    }

    protected String toAlternate(String str) {
        if (str != null) {
            return str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
        if (r2 <= (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r2 >= r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
        if (r4 >= r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
        if (r4 <= r2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
        return r7.substring(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String simpleClassName(java.lang.String r7) {
        /*
            if (r7 == 0) goto L47
            r0 = -1
            r1 = 0
            r2 = -1
            r3 = -1
            r4 = -1
        L7:
            int r5 = r7.length()
            if (r1 >= r5) goto L36
            int r5 = r7.codePointAt(r1)
            boolean r6 = java.lang.Character.isJavaIdentifierPart(r5)
            if (r6 != 0) goto L2b
            r6 = 46
            if (r5 != r6) goto L25
            int r3 = r2 + 1
            if (r3 == r1) goto L24
            if (r3 == r4) goto L24
            r3 = r2
            r2 = r1
            goto L30
        L24:
            return r7
        L25:
            int r5 = r2 + 1
            if (r5 != r1) goto L36
            r2 = r3
            goto L36
        L2b:
            r6 = 36
            if (r5 != r6) goto L30
            r4 = r1
        L30:
            int r5 = java.lang.Character.charCount(r5)
            int r1 = r1 + r5
            goto L7
        L36:
            if (r2 <= r0) goto L47
            int r2 = r2 + 1
            if (r2 >= r1) goto L47
            int r4 = r4 + 1
            if (r4 >= r1) goto L47
            if (r4 <= r2) goto L43
            r2 = r4
        L43:
            java.lang.String r7 = r7.substring(r2)
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.CompactFormatter.simpleClassName(java.lang.String):java.lang.String");
    }

    public CompactFormatter(String str) {
        this.fmt = str == null ? initFormat(getClass().getName()) : str;
    }

    public String formatMessage(Throwable th) {
        String replaceClassName;
        if (th != null) {
            Throwable apply = apply(th);
            String localizedMessage = apply.getLocalizedMessage();
            String th2 = apply.toString();
            String simpleClassName = simpleClassName(apply.getClass());
            if (!isNullOrSpaces(localizedMessage)) {
                if (th2.contains(localizedMessage)) {
                    if (!th2.startsWith(apply.getClass().getName()) && !th2.startsWith(simpleClassName)) {
                        replaceClassName = replaceClassName(simpleClassName(th2), th);
                    } else {
                        replaceClassName = replaceClassName(localizedMessage, th);
                    }
                } else {
                    replaceClassName = replaceClassName(simpleClassName(th2) + ": " + localizedMessage, th);
                }
            } else {
                replaceClassName = replaceClassName(simpleClassName(th2), th);
            }
            if (replaceClassName.contains(simpleClassName)) {
                return replaceClassName;
            }
            return simpleClassName + ": " + replaceClassName;
        }
        return "";
    }

    private static String replaceClassName(String str, Object[] objArr) {
        if (!isNullOrSpaces(str) && objArr != null) {
            for (Object obj : objArr) {
                if (obj != null) {
                    Class<?> cls = obj.getClass();
                    str = str.replace(cls.getName(), simpleClassName(cls));
                }
            }
        }
        return str;
    }
}
