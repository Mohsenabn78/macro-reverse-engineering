package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzb {
    @Nullable
    @GuardedBy("DynamiteLoaderV2ClassLoader.class")

    /* renamed from: a  reason: collision with root package name */
    private static volatile ClassLoader f20841a;
    @Nullable
    @GuardedBy("DynamiteLoaderV2ClassLoader.class")

    /* renamed from: b  reason: collision with root package name */
    private static volatile Thread f20842b;

    @Nullable
    private static synchronized ClassLoader a() {
        synchronized (zzb.class) {
            ClassLoader classLoader = null;
            if (f20842b == null) {
                f20842b = b();
                if (f20842b == null) {
                    return null;
                }
            }
            synchronized (f20842b) {
                try {
                    classLoader = f20842b.getContextClassLoader();
                } catch (SecurityException e4) {
                    String message = e4.getMessage();
                    Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + message);
                }
            }
            return classLoader;
        }
    }

    @Nullable
    private static synchronized Thread b() {
        SecurityException e4;
        zza zzaVar;
        zza zzaVar2;
        ThreadGroup threadGroup;
        synchronized (zzb.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i5 < activeGroupCount) {
                            threadGroup = threadGroupArr[i5];
                            if ("dynamiteLoader".equals(threadGroup.getName())) {
                                break;
                            }
                            i5++;
                        } else {
                            threadGroup = null;
                            break;
                        }
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i4 < activeCount) {
                            zzaVar2 = threadArr[i4];
                            if ("GmsDynamite".equals(zzaVar2.getName())) {
                                break;
                            }
                            i4++;
                        } else {
                            zzaVar2 = null;
                            break;
                        }
                    }
                } catch (SecurityException e5) {
                    e4 = e5;
                    zzaVar = null;
                }
                if (zzaVar2 == null) {
                    try {
                        zzaVar = new zza(threadGroup, "GmsDynamite");
                    } catch (SecurityException e6) {
                        e4 = e6;
                        zzaVar = zzaVar2;
                    }
                    try {
                        zzaVar.setContextClassLoader(null);
                        zzaVar.start();
                    } catch (SecurityException e7) {
                        e4 = e7;
                        Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e4.getMessage());
                        zzaVar2 = zzaVar;
                        return zzaVar2;
                    }
                    zzaVar2 = zzaVar;
                }
            }
            return zzaVar2;
        }
    }

    @Nullable
    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        synchronized (zzb.class) {
            if (f20841a == null) {
                f20841a = a();
            }
            classLoader = f20841a;
        }
        return classLoader;
    }
}
