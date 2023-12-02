package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes5.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f29262a = new Lazy<>(new Provider() { // from class: com.google.firebase.concurrent.t
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService p4;
            p4 = ExecutorsRegistrar.p();
            return p4;
        }
    });

    /* renamed from: b  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f29263b = new Lazy<>(new Provider() { // from class: com.google.firebase.concurrent.u
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService q4;
            q4 = ExecutorsRegistrar.q();
            return q4;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f29264c = new Lazy<>(new Provider() { // from class: com.google.firebase.concurrent.v
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService r4;
            r4 = ExecutorsRegistrar.r();
            return r4;
        }
    });

    /* renamed from: d  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f29265d = new Lazy<>(new Provider() { // from class: com.google.firebase.concurrent.w
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService s3;
            s3 = ExecutorsRegistrar.s();
            return s3;
        }
    });

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            detectNetwork.detectResourceMismatches();
            if (i4 >= 26) {
                detectNetwork.detectUnbufferedIo();
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i4) {
        return new CustomThreadFactory(str, i4, null);
    }

    private static ThreadFactory k(String str, int i4, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i4, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService l(ComponentContainer componentContainer) {
        return f29262a.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService m(ComponentContainer componentContainer) {
        return f29264c.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService n(ComponentContainer componentContainer) {
        return f29263b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Executor o(ComponentContainer componentContainer) {
        return UiExecutor.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    private static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    private static ScheduledExecutorService u(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, f29265d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(Qualified.qualified(Background.class, ScheduledExecutorService.class), Qualified.qualified(Background.class, ExecutorService.class), Qualified.qualified(Background.class, Executor.class)).factory(new ComponentFactory() { // from class: com.google.firebase.concurrent.p
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                ScheduledExecutorService l4;
                l4 = ExecutorsRegistrar.l(componentContainer);
                return l4;
            }
        }).build(), Component.builder(Qualified.qualified(Blocking.class, ScheduledExecutorService.class), Qualified.qualified(Blocking.class, ExecutorService.class), Qualified.qualified(Blocking.class, Executor.class)).factory(new ComponentFactory() { // from class: com.google.firebase.concurrent.q
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                ScheduledExecutorService m4;
                m4 = ExecutorsRegistrar.m(componentContainer);
                return m4;
            }
        }).build(), Component.builder(Qualified.qualified(Lightweight.class, ScheduledExecutorService.class), Qualified.qualified(Lightweight.class, ExecutorService.class), Qualified.qualified(Lightweight.class, Executor.class)).factory(new ComponentFactory() { // from class: com.google.firebase.concurrent.r
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                ScheduledExecutorService n4;
                n4 = ExecutorsRegistrar.n(componentContainer);
                return n4;
            }
        }).build(), Component.builder(Qualified.qualified(UiThread.class, Executor.class)).factory(new ComponentFactory() { // from class: com.google.firebase.concurrent.s
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                Executor o4;
                o4 = ExecutorsRegistrar.o(componentContainer);
                return o4;
            }
        }).build());
    }
}
