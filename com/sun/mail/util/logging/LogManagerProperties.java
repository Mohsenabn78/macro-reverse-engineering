package com.sun.mail.util.logging;

import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectStreamException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes6.dex */
final class LogManagerProperties extends Properties {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object LOG_MANAGER;
    private static final Method LR_GET_INSTANT;
    private static final Method LR_GET_LONG_TID;
    private static volatile String[] REFLECT_NAMES = null;
    private static final Method ZDT_OF_INSTANT;
    private static final Method ZI_SYSTEM_DEFAULT;
    private static final long serialVersionUID = -2239983349056806252L;
    private final String prefix;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a0, code lost:
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b6, code lost:
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b9, code lost:
        r3 = r1;
     */
    static {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.LogManagerProperties.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogManagerProperties(Properties properties, String str) {
        super(properties);
        if (properties != null && str != null) {
            this.prefix = str;
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkLogManagerAccess() {
        Object obj = LOG_MANAGER;
        boolean z3 = false;
        if (obj != null) {
            try {
                if (obj instanceof LogManager) {
                    z3 = true;
                    ((LogManager) obj).checkAccess();
                }
            } catch (LinkageError | RuntimeException unused) {
            } catch (SecurityException e4) {
                if (z3) {
                    throw e4;
                }
            }
        }
        if (!z3) {
            checkLoggingAccess();
        }
    }

    private static void checkLoggingAccess() {
        SecurityManager securityManager;
        Logger logger = Logger.getLogger(HelperCommandsKt.HELPER_SETTING_TYPE_GLOBAL);
        boolean z3 = false;
        try {
            if (Logger.class == logger.getClass()) {
                logger.removeHandler(null);
                z3 = true;
            }
        } catch (NullPointerException unused) {
        }
        if (!z3 && (securityManager = System.getSecurityManager()) != null) {
            securityManager.checkPermission(new LoggingPermission("control", null));
        }
    }

    private Properties exportCopy(Properties properties) {
        Thread.holdsLock(this);
        Properties properties2 = new Properties(properties);
        properties2.putAll(this);
        return properties2;
    }

    private static Class<?> findClass(String str) throws ClassNotFoundException {
        ClassLoader[] classLoaders = getClassLoaders();
        ClassLoader classLoader = classLoaders[0];
        if (classLoader != null) {
            try {
                return Class.forName(str, false, classLoader);
            } catch (ClassNotFoundException unused) {
                return tryLoad(str, classLoaders[1]);
            }
        }
        return tryLoad(str, classLoaders[1]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String fromLogManager(String str) {
        str.getClass();
        Object obj = LOG_MANAGER;
        try {
            if (obj instanceof Properties) {
                return ((Properties) obj).getProperty(str);
            }
        } catch (RuntimeException unused) {
        }
        if (obj != null) {
            try {
                if (obj instanceof LogManager) {
                    return ((LogManager) obj).getProperty(str);
                }
                return null;
            } catch (LinkageError | RuntimeException unused2) {
                return null;
            }
        }
        return null;
    }

    private static ClassLoader[] getClassLoaders() {
        return (ClassLoader[]) AccessController.doPrivileged(new PrivilegedAction<ClassLoader[]>() { // from class: com.sun.mail.util.logging.LogManagerProperties.1
            @Override // java.security.PrivilegedAction
            public ClassLoader[] run() {
                ClassLoader[] classLoaderArr = new ClassLoader[2];
                try {
                    classLoaderArr[0] = ClassLoader.getSystemClassLoader();
                } catch (SecurityException unused) {
                    classLoaderArr[0] = null;
                }
                try {
                    classLoaderArr[1] = Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused2) {
                    classLoaderArr[1] = null;
                }
                return classLoaderArr;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getLocalHost(Object obj) throws Exception {
        try {
            Method method = obj.getClass().getMethod("getLocalHost", new Class[0]);
            if (!Modifier.isStatic(method.getModifiers()) && method.getReturnType() == String.class) {
                return (String) method.invoke(obj, new Object[0]);
            }
            throw new NoSuchMethodException(method.toString());
        } catch (ExceptionInInitializerError e4) {
            throw wrapOrThrow(e4);
        } catch (InvocationTargetException e5) {
            throw paramOrError(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Long getLongThreadID(LogRecord logRecord) {
        logRecord.getClass();
        Method method = LR_GET_LONG_TID;
        if (method != null) {
            try {
                return (Long) method.invoke(logRecord, new Object[0]);
            } catch (RuntimeException | Exception unused) {
                return null;
            } catch (InvocationTargetException e4) {
                Throwable cause = e4.getCause();
                if (!(cause instanceof Error)) {
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    }
                    throw new UndeclaredThrowableException(e4);
                }
                throw ((Error) cause);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Comparable<?> getZonedDateTime(LogRecord logRecord) {
        logRecord.getClass();
        Method method = ZDT_OF_INSTANT;
        if (method != null) {
            try {
                return (Comparable) method.invoke(null, LR_GET_INSTANT.invoke(logRecord, new Object[0]), ZI_SYSTEM_DEFAULT.invoke(null, new Object[0]));
            } catch (RuntimeException | Exception unused) {
            } catch (InvocationTargetException e4) {
                Throwable cause = e4.getCause();
                if (!(cause instanceof Error)) {
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    }
                    throw new UndeclaredThrowableException(e4);
                }
                throw ((Error) cause);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasLogManager() {
        Object obj = LOG_MANAGER;
        if (obj != null && !(obj instanceof Properties)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isReflectionClass(String str) throws Exception {
        String[] strArr = REFLECT_NAMES;
        if (strArr == null) {
            strArr = reflectionClassNames();
            REFLECT_NAMES = strArr;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        findClass(str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isStaticUtilityClass(String str) throws Exception {
        Class<?> findClass = findClass(str);
        if (findClass == Object.class) {
            return false;
        }
        Method[] methods = findClass.getMethods();
        if (methods.length == 0) {
            return false;
        }
        for (Method method : methods) {
            if (method.getDeclaringClass() != Object.class && !Modifier.isStatic(method.getModifiers())) {
                return false;
            }
        }
        return true;
    }

    private static Object loadLogManager() {
        try {
            return LogManager.getLogManager();
        } catch (LinkageError unused) {
            return readConfiguration();
        } catch (RuntimeException unused2) {
            return readConfiguration();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Comparator<? super LogRecord> newComparator(String str) throws Exception {
        return (Comparator) newObjectFrom(str, Comparator.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ErrorManager newErrorManager(String str) throws Exception {
        return (ErrorManager) newObjectFrom(str, ErrorManager.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Filter newFilter(String str) throws Exception {
        return (Filter) newObjectFrom(str, Filter.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Formatter newFormatter(String str) throws Exception {
        return (Formatter) newObjectFrom(str, Formatter.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T newObjectFrom(String str, Class<T> cls) throws Exception {
        try {
            Class<?> findClass = findClass(str);
            if (cls.isAssignableFrom(findClass)) {
                try {
                    return cls.cast(findClass.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (InvocationTargetException e4) {
                    throw paramOrError(e4);
                }
            }
            throw new ClassCastException(findClass.getName() + " cannot be cast to " + cls.getName());
        } catch (ExceptionInInitializerError e5) {
            throw wrapOrThrow(e5);
        } catch (NoClassDefFoundError e6) {
            throw new ClassNotFoundException(e6.toString(), e6);
        }
    }

    private static Exception paramOrError(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null && ((cause instanceof VirtualMachineError) | (cause instanceof ThreadDeath))) {
            throw ((Error) cause);
        }
        return invocationTargetException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long parseDurationToMillis(CharSequence charSequence) throws Exception {
        charSequence.getClass();
        try {
            Class<?> findClass = findClass("java.time.Duration");
            Method method = findClass.getMethod("parse", CharSequence.class);
            if (findClass.isAssignableFrom(method.getReturnType()) && Modifier.isStatic(method.getModifiers())) {
                Method method2 = findClass.getMethod("toMillis", new Class[0]);
                if (Long.TYPE.isAssignableFrom(method2.getReturnType()) && !Modifier.isStatic(method2.getModifiers())) {
                    return ((Long) method2.invoke(method.invoke(null, charSequence), new Object[0])).longValue();
                }
                throw new NoSuchMethodException(method2.toString());
            }
            throw new NoSuchMethodException(method.toString());
        } catch (ExceptionInInitializerError e4) {
            throw wrapOrThrow(e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (cause instanceof ArithmeticException) {
                throw ((ArithmeticException) cause);
            }
            throw paramOrError(e5);
        }
    }

    private Object preWrite(Object obj) {
        return get(obj);
    }

    private static Properties readConfiguration() {
        Properties properties = new Properties();
        try {
            String property = System.getProperty("java.util.logging.config.file");
            if (property != null) {
                FileInputStream fileInputStream = new FileInputStream(new File(property).getCanonicalFile());
                properties.load(fileInputStream);
                fileInputStream.close();
            }
        } catch (RuntimeException | Exception | LinkageError unused) {
        }
        return properties;
    }

    private static String[] reflectionClassNames() throws Exception {
        StackTraceElement[] stackTrace;
        StackTraceElement[] stackTrace2;
        try {
            HashSet hashSet = new HashSet();
            Throwable th = (Throwable) Throwable.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (LogManagerProperties.class.getName().equals(stackTraceElement.getClassName())) {
                    break;
                }
                hashSet.add(stackTraceElement.getClassName());
            }
            Throwable.class.getMethod("fillInStackTrace", new Class[0]).invoke(th, new Object[0]);
            for (StackTraceElement stackTraceElement2 : th.getStackTrace()) {
                if (LogManagerProperties.class.getName().equals(stackTraceElement2.getClassName())) {
                    break;
                }
                hashSet.add(stackTraceElement2.getClassName());
            }
            return (String[]) hashSet.toArray(new String[hashSet.size()]);
        } catch (InvocationTargetException e4) {
            throw paramOrError(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Comparator<T> reverseOrder(Comparator<T> comparator) {
        comparator.getClass();
        Comparator<T> comparator2 = null;
        try {
            try {
                Method method = comparator.getClass().getMethod("reversed", new Class[0]);
                if (!Modifier.isStatic(method.getModifiers()) && Comparator.class.isAssignableFrom(method.getReturnType())) {
                    try {
                        comparator2 = (Comparator) method.invoke(comparator, new Object[0]);
                    } catch (ExceptionInInitializerError e4) {
                        throw wrapOrThrow(e4);
                    }
                }
            } catch (ReflectiveOperationException | RuntimeException unused) {
            }
        } catch (InvocationTargetException e5) {
            paramOrError(e5);
        }
        if (comparator2 == null) {
            return Collections.reverseOrder(comparator);
        }
        return comparator2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toLanguageTag(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        char[] cArr = new char[language.length() + country.length() + variant.length() + 2];
        int length = language.length();
        language.getChars(0, length, cArr, 0);
        if (country.length() != 0 || (language.length() != 0 && variant.length() != 0)) {
            cArr[length] = SignatureVisitor.SUPER;
            int i4 = length + 1;
            country.getChars(0, country.length(), cArr, i4);
            length = i4 + country.length();
        }
        if (variant.length() != 0 && (language.length() != 0 || country.length() != 0)) {
            cArr[length] = SignatureVisitor.SUPER;
            int i5 = length + 1;
            variant.getChars(0, variant.length(), cArr, i5);
            length = i5 + variant.length();
        }
        return String.valueOf(cArr, 0, length);
    }

    private static Class<?> tryLoad(String str, ClassLoader classLoader) throws ClassNotFoundException {
        if (classLoader != null) {
            return Class.forName(str, false, classLoader);
        }
        return Class.forName(str);
    }

    private static InvocationTargetException wrapOrThrow(ExceptionInInitializerError exceptionInInitializerError) {
        if (!(exceptionInInitializerError.getCause() instanceof Error)) {
            return new InvocationTargetException(exceptionInInitializerError);
        }
        throw exceptionInInitializerError;
    }

    private synchronized Object writeReplace() throws ObjectStreamException {
        return exportCopy((Properties) ((Properties) this).defaults.clone());
    }

    @Override // java.util.Hashtable
    public synchronized Object clone() {
        return exportCopy(((Properties) this).defaults);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean containsKey(Object obj) {
        boolean z3;
        boolean z4 = true;
        if ((obj instanceof String) && getProperty((String) obj) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (!((Properties) this).defaults.containsKey(obj)) {
                if (!super.containsKey(obj)) {
                    z4 = false;
                }
            }
            z3 = z4;
        }
        return z3;
    }

    @Override // java.util.Hashtable, java.util.Map
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Properties)) {
            return false;
        }
        return super.equals(obj);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object get(Object obj) {
        Object obj2;
        if (obj instanceof String) {
            obj2 = getProperty((String) obj);
        } else {
            obj2 = null;
        }
        if (obj2 == null && (obj2 = ((Properties) this).defaults.get(obj)) == null && !((Properties) this).defaults.containsKey(obj)) {
            obj2 = super.get(obj);
        }
        return obj2;
    }

    @Override // java.util.Properties
    public synchronized String getProperty(String str) {
        String property;
        property = ((Properties) this).defaults.getProperty(str);
        if (property == null) {
            if (str.length() > 0) {
                property = fromLogManager(this.prefix + '.' + str);
            }
            if (property == null) {
                property = fromLogManager(str);
            }
            if (property != null) {
                super.put(str, property);
            } else {
                Object obj = super.get(str);
                property = obj instanceof String ? (String) obj : null;
            }
        }
        return property;
    }

    @Override // java.util.Hashtable, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.Properties
    public Enumeration<?> propertyNames() {
        return super.propertyNames();
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object put(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof String)) {
            Object preWrite = preWrite(obj);
            Object put = super.put(obj, obj2);
            if (put != null) {
                preWrite = put;
            }
            return preWrite;
        }
        return super.put(obj, obj2);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object remove(Object obj) {
        Object preWrite;
        preWrite = preWrite(obj);
        Object remove = super.remove(obj);
        if (remove != null) {
            preWrite = remove;
        }
        return preWrite;
    }

    @Override // java.util.Properties
    public Object setProperty(String str, String str2) {
        return put(str, str2);
    }

    @Override // java.util.Properties
    public String getProperty(String str, String str2) {
        String property = getProperty(str);
        return property == null ? str2 : property;
    }
}
