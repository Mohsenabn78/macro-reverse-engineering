package com.google.firebase.functions;

import android.content.Context;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.functions.dagger.Binds;
import com.google.firebase.functions.dagger.BindsInstance;
import com.google.firebase.functions.dagger.Component;
import com.google.firebase.functions.dagger.Module;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;
import javax.inject.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
@Component(modules = {MainModule.class})
@Singleton
/* loaded from: classes5.dex */
public interface FunctionsComponent {

    @Component.Builder
    /* loaded from: classes5.dex */
    public interface Builder {
        FunctionsComponent build();

        @BindsInstance
        Builder setAppCheck(Deferred<InteropAppCheckTokenProvider> deferred);

        @BindsInstance
        Builder setApplicationContext(Context context);

        @BindsInstance
        Builder setAuth(Provider<InternalAuthProvider> provider);

        @BindsInstance
        Builder setFirebaseOptions(FirebaseOptions firebaseOptions);

        @BindsInstance
        Builder setIid(Provider<FirebaseInstanceIdInternal> provider);

        @BindsInstance
        Builder setLiteExecutor(@Lightweight Executor executor);

        @BindsInstance
        Builder setUiExecutor(@UiThread Executor executor);
    }

    @Module
    /* loaded from: classes5.dex */
    public interface MainModule {
        @Binds
        ContextProvider contextProvider(FirebaseContextProvider firebaseContextProvider);
    }

    FunctionsMultiResourceComponent a();
}
