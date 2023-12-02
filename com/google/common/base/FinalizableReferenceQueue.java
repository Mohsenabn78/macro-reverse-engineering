package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.internal.Finalizer;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import net.bytebuddy.dynamic.ClassFileLocator;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class FinalizableReferenceQueue implements Closeable {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f26316d = Logger.getLogger(FinalizableReferenceQueue.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private static final Method f26317e = d(e(new SystemLoader(), new DecoupledLoader(), new DirectLoader()));

    /* renamed from: a  reason: collision with root package name */
    final ReferenceQueue<Object> f26318a;

    /* renamed from: b  reason: collision with root package name */
    final PhantomReference<Object> f26319b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f26320c;

    /* loaded from: classes5.dex */
    static class DecoupledLoader implements FinalizerLoader {
        DecoupledLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @CheckForNull
        public Class<?> a() {
            try {
                return c(b()).loadClass("com.google.common.base.internal.Finalizer");
            } catch (Exception e4) {
                FinalizableReferenceQueue.f26316d.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", (Throwable) e4);
                return null;
            }
        }

        URL b() throws IOException {
            String str = "com.google.common.base.internal.Finalizer".replace('.', '/') + ClassFileLocator.CLASS_FILE_EXTENSION;
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource != null) {
                String url = resource.toString();
                if (url.endsWith(str)) {
                    return new URL(resource, url.substring(0, url.length() - str.length()));
                }
                throw new IOException("Unsupported path style: " + url);
            }
            throw new FileNotFoundException(str);
        }

        URLClassLoader c(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    /* loaded from: classes5.dex */
    static class DirectLoader implements FinalizerLoader {
        DirectLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class<?> a() {
            try {
                int i4 = Finalizer.f26405g;
                return Finalizer.class;
            } catch (ClassNotFoundException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface FinalizerLoader {
        @CheckForNull
        Class<?> a();
    }

    /* loaded from: classes5.dex */
    static class SystemLoader implements FinalizerLoader {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        static boolean f26321a;

        SystemLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @CheckForNull
        public Class<?> a() {
            if (f26321a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.f26316d.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public FinalizableReferenceQueue() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f26318a = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.f26319b = phantomReference;
        boolean z3 = false;
        try {
            f26317e.invoke(null, FinalizableReference.class, referenceQueue, phantomReference);
            z3 = true;
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        } catch (Throwable th) {
            f26316d.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
        }
        this.f26320c = z3;
    }

    static Method d(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e4) {
            throw new AssertionError(e4);
        }
    }

    private static Class<?> e(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader finalizerLoader : finalizerLoaderArr) {
            Class<?> a4 = finalizerLoader.a();
            if (a4 != null) {
                return a4;
            }
        }
        throw new AssertionError();
    }

    void c() {
        if (this.f26320c) {
            return;
        }
        while (true) {
            Reference<? extends Object> poll = this.f26318a.poll();
            if (poll != null) {
                poll.clear();
                try {
                    ((FinalizableReference) poll).finalizeReferent();
                } catch (Throwable th) {
                    f26316d.log(Level.SEVERE, "Error cleaning up after reference.", th);
                }
            } else {
                return;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f26319b.enqueue();
        c();
    }
}
