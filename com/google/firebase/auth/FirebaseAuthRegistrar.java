package com.google.firebase.auth;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@Keep
@KeepForSdk
/* loaded from: classes5.dex */
public class FirebaseAuthRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ FirebaseAuth lambda$getComponents$0(Qualified qualified, Qualified qualified2, Qualified qualified3, Qualified qualified4, Qualified qualified5, ComponentContainer componentContainer) {
        return new com.google.firebase.auth.internal.zzv((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(InteropAppCheckTokenProvider.class), componentContainer.getProvider(HeartBeatController.class), (Executor) componentContainer.get(qualified), (Executor) componentContainer.get(qualified2), (Executor) componentContainer.get(qualified3), (ScheduledExecutorService) componentContainer.get(qualified4), (Executor) componentContainer.get(qualified5));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    @Keep
    public List<Component<?>> getComponents() {
        final Qualified qualified = Qualified.qualified(Background.class, Executor.class);
        final Qualified qualified2 = Qualified.qualified(Blocking.class, Executor.class);
        final Qualified qualified3 = Qualified.qualified(Lightweight.class, Executor.class);
        final Qualified qualified4 = Qualified.qualified(Lightweight.class, ScheduledExecutorService.class);
        final Qualified qualified5 = Qualified.qualified(UiThread.class, Executor.class);
        return Arrays.asList(Component.builder(FirebaseAuth.class, InternalAuthProvider.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.requiredProvider(HeartBeatController.class)).add(Dependency.required(qualified)).add(Dependency.required(qualified2)).add(Dependency.required(qualified3)).add(Dependency.required(qualified4)).add(Dependency.required(qualified5)).add(Dependency.optionalProvider(InteropAppCheckTokenProvider.class)).factory(new ComponentFactory() { // from class: com.google.firebase.auth.zzah
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return FirebaseAuthRegistrar.lambda$getComponents$0(Qualified.this, qualified2, qualified3, qualified4, qualified5, componentContainer);
            }
        }).build(), HeartBeatConsumerComponent.create(), LibraryVersionComponent.create("fire-auth", "22.1.1"));
    }
}
