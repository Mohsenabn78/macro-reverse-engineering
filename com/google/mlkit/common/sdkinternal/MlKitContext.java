package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class MlKitContext {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f32963b = new Object();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static MlKitContext f32964c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private ComponentRuntime f32965a;

    private MlKitContext() {
    }

    private static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        return context;
    }

    @NonNull
    @KeepForSdk
    public static MlKitContext getInstance() {
        boolean z3;
        MlKitContext mlKitContext;
        synchronized (f32963b) {
            if (f32964c != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MlKitContext has not been initialized");
            mlKitContext = (MlKitContext) Preconditions.checkNotNull(f32964c);
        }
        return mlKitContext;
    }

    @NonNull
    @KeepForSdk
    public static MlKitContext initialize(@NonNull Context context, @NonNull List<ComponentRegistrar> list) {
        boolean z3;
        MlKitContext mlKitContext;
        synchronized (f32963b) {
            if (f32964c == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MlKitContext is already initialized");
            MlKitContext mlKitContext2 = new MlKitContext();
            f32964c = mlKitContext2;
            ComponentRuntime componentRuntime = new ComponentRuntime(TaskExecutors.MAIN_THREAD, list, Component.of(a(context), Context.class, new Class[0]), Component.of(mlKitContext2, MlKitContext.class, new Class[0]));
            mlKitContext2.f32965a = componentRuntime;
            componentRuntime.initializeEagerComponents(true);
            mlKitContext = f32964c;
        }
        return mlKitContext;
    }

    @NonNull
    @KeepForSdk
    public static MlKitContext initializeIfNeeded(@NonNull Context context) {
        MlKitContext mlKitContext;
        synchronized (f32963b) {
            mlKitContext = f32964c;
            if (mlKitContext == null) {
                mlKitContext = zza(context);
            }
        }
        return mlKitContext;
    }

    @NonNull
    public static MlKitContext zza(@NonNull Context context) {
        boolean z3;
        MlKitContext mlKitContext;
        synchronized (f32963b) {
            if (f32964c == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MlKitContext is already initialized");
            MlKitContext mlKitContext2 = new MlKitContext();
            f32964c = mlKitContext2;
            Context a4 = a(context);
            ComponentRuntime build = ComponentRuntime.builder(TaskExecutors.MAIN_THREAD).addLazyComponentRegistrars(ComponentDiscovery.forContext(a4, MlKitComponentDiscoveryService.class).discoverLazy()).addComponent(Component.of(a4, Context.class, new Class[0])).addComponent(Component.of(mlKitContext2, MlKitContext.class, new Class[0])).build();
            mlKitContext2.f32965a = build;
            build.initializeEagerComponents(true);
            mlKitContext = f32964c;
        }
        return mlKitContext;
    }

    @NonNull
    @KeepForSdk
    public <T> T get(@NonNull Class<T> cls) {
        boolean z3;
        if (f32964c == this) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "MlKitContext has been deleted");
        Preconditions.checkNotNull(this.f32965a);
        return (T) this.f32965a.get(cls);
    }

    @NonNull
    @KeepForSdk
    public Context getApplicationContext() {
        return (Context) get(Context.class);
    }
}
