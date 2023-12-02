package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Throwables {
    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible

    /* renamed from: a  reason: collision with root package name */
    private static final Object f26397a;
    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible

    /* renamed from: b  reason: collision with root package name */
    private static final Method f26398b;
    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible

    /* renamed from: c  reason: collision with root package name */
    private static final Method f26399c;

    static {
        Method e4;
        Object f4 = f();
        f26397a = f4;
        Method method = null;
        if (f4 == null) {
            e4 = null;
        } else {
            e4 = e();
        }
        f26398b = e4;
        if (f4 != null) {
            method = h(f4);
        }
        f26399c = method;
    }

    private Throwables() {
    }

    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible
    private static Method e() {
        return g("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible
    private static Object f() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e4) {
            throw e4;
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    private static Method g(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e4) {
            throw e4;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<Throwable> getCausalChain(Throwable th) {
        Preconditions.checkNotNull(th);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(th);
        boolean z3 = false;
        Throwable th2 = th;
        while (true) {
            th = th.getCause();
            if (th != null) {
                arrayList.add(th);
                if (th != th2) {
                    if (z3) {
                        th2 = th2.getCause();
                    }
                    z3 = !z3;
                } else {
                    throw new IllegalArgumentException("Loop in causal chain detected.", th);
                }
            } else {
                return Collections.unmodifiableList(arrayList);
            }
        }
    }

    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible
    public static <X extends Throwable> X getCauseAs(Throwable th, Class<X> cls) {
        try {
            return cls.cast(th.getCause());
        } catch (ClassCastException e4) {
            e4.initCause(th);
            throw e4;
        }
    }

    public static Throwable getRootCause(Throwable th) {
        boolean z3 = false;
        Throwable th2 = th;
        while (true) {
            Throwable cause = th.getCause();
            if (cause != null) {
                if (cause != th2) {
                    if (z3) {
                        th2 = th2.getCause();
                    }
                    z3 = !z3;
                    th = cause;
                } else {
                    throw new IllegalArgumentException("Loop in causal chain detected.", cause);
                }
            } else {
                return th;
            }
        }
    }

    @GwtIncompatible
    public static String getStackTraceAsString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible
    private static Method h(Object obj) {
        try {
            Method g4 = g("getStackTraceDepth", Throwable.class);
            if (g4 == null) {
                return null;
            }
            g4.invoke(obj, new Throwable());
            return g4;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @J2ktIncompatible
    @GwtIncompatible
    public static Object i(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw propagate(e5.getCause());
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    private static List<StackTraceElement> j(final Throwable th) {
        Preconditions.checkNotNull(th);
        return new AbstractList<StackTraceElement>() { // from class: com.google.common.base.Throwables.1
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a */
            public StackTraceElement get(int i4) {
                Method method = Throwables.f26398b;
                java.util.Objects.requireNonNull(method);
                Object obj = Throwables.f26397a;
                java.util.Objects.requireNonNull(obj);
                return (StackTraceElement) Throwables.i(method, obj, th, Integer.valueOf(i4));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                Method method = Throwables.f26399c;
                java.util.Objects.requireNonNull(method);
                Object obj = Throwables.f26397a;
                java.util.Objects.requireNonNull(obj);
                return ((Integer) Throwables.i(method, obj, th)).intValue();
            }
        };
    }

    @J2ktIncompatible
    @GwtIncompatible
    @Deprecated
    public static List<StackTraceElement> lazyStackTrace(Throwable th) {
        if (lazyStackTraceIsLazy()) {
            return j(th);
        }
        return Collections.unmodifiableList(Arrays.asList(th.getStackTrace()));
    }

    @J2ktIncompatible
    @GwtIncompatible
    @Deprecated
    public static boolean lazyStackTraceIsLazy() {
        if (f26398b != null && f26399c != null) {
            return true;
        }
        return false;
    }

    @GwtIncompatible
    @Deprecated
    @CanIgnoreReturnValue
    @J2ktIncompatible
    public static RuntimeException propagate(Throwable th) {
        throwIfUnchecked(th);
        throw new RuntimeException(th);
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static <X extends Throwable> void propagateIfInstanceOf(@CheckForNull Throwable th, Class<X> cls) throws Throwable {
        if (th != null) {
            throwIfInstanceOf(th, cls);
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    @Deprecated
    public static void propagateIfPossible(@CheckForNull Throwable th) {
        if (th != null) {
            throwIfUnchecked(th);
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <X extends Throwable> void throwIfInstanceOf(Throwable th, Class<X> cls) throws Throwable {
        Preconditions.checkNotNull(th);
        if (!cls.isInstance(th)) {
            return;
        }
        throw cls.cast(th);
    }

    public static void throwIfUnchecked(Throwable th) {
        Preconditions.checkNotNull(th);
        if (!(th instanceof RuntimeException)) {
            if (!(th instanceof Error)) {
                return;
            }
            throw ((Error) th);
        }
        throw ((RuntimeException) th);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <X extends Throwable> void propagateIfPossible(@CheckForNull Throwable th, Class<X> cls) throws Throwable {
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@CheckForNull Throwable th, Class<X1> cls, Class<X2> cls2) throws Throwable, Throwable {
        Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th, cls2);
    }
}
