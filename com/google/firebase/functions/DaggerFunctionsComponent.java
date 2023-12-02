package com.google.firebase.functions;

import android.content.Context;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.functions.FunctionsComponent;
import com.google.firebase.functions.FunctionsMultiResourceComponent;
import com.google.firebase.functions.dagger.internal.DaggerGenerated;
import com.google.firebase.functions.dagger.internal.DoubleCheck;
import com.google.firebase.functions.dagger.internal.Factory;
import com.google.firebase.functions.dagger.internal.InstanceFactory;
import com.google.firebase.functions.dagger.internal.Preconditions;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
@DaggerGenerated
/* loaded from: classes5.dex */
public final class DaggerFunctionsComponent {

    /* loaded from: classes5.dex */
    private static final class Builder implements FunctionsComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f31328a;

        /* renamed from: b  reason: collision with root package name */
        private FirebaseOptions f31329b;

        /* renamed from: c  reason: collision with root package name */
        private Executor f31330c;

        /* renamed from: d  reason: collision with root package name */
        private Executor f31331d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<InternalAuthProvider> f31332e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<FirebaseInstanceIdInternal> f31333f;

        /* renamed from: g  reason: collision with root package name */
        private Deferred<InteropAppCheckTokenProvider> f31334g;

        private Builder() {
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        /* renamed from: a */
        public Builder setAppCheck(Deferred<InteropAppCheckTokenProvider> deferred) {
            this.f31334g = (Deferred) Preconditions.checkNotNull(deferred);
            return this;
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        /* renamed from: b */
        public Builder setApplicationContext(Context context) {
            this.f31328a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        public FunctionsComponent build() {
            Preconditions.checkBuilderRequirement(this.f31328a, Context.class);
            Preconditions.checkBuilderRequirement(this.f31329b, FirebaseOptions.class);
            Preconditions.checkBuilderRequirement(this.f31330c, Executor.class);
            Preconditions.checkBuilderRequirement(this.f31331d, Executor.class);
            Preconditions.checkBuilderRequirement(this.f31332e, Provider.class);
            Preconditions.checkBuilderRequirement(this.f31333f, Provider.class);
            Preconditions.checkBuilderRequirement(this.f31334g, Deferred.class);
            return new FunctionsComponentImpl(this.f31328a, this.f31329b, this.f31330c, this.f31331d, this.f31332e, this.f31333f, this.f31334g);
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        /* renamed from: c */
        public Builder setAuth(Provider<InternalAuthProvider> provider) {
            this.f31332e = (Provider) Preconditions.checkNotNull(provider);
            return this;
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        /* renamed from: d */
        public Builder setFirebaseOptions(FirebaseOptions firebaseOptions) {
            this.f31329b = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
            return this;
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        /* renamed from: e */
        public Builder setIid(Provider<FirebaseInstanceIdInternal> provider) {
            this.f31333f = (Provider) Preconditions.checkNotNull(provider);
            return this;
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        /* renamed from: f */
        public Builder setLiteExecutor(Executor executor) {
            this.f31330c = (Executor) Preconditions.checkNotNull(executor);
            return this;
        }

        @Override // com.google.firebase.functions.FunctionsComponent.Builder
        /* renamed from: g */
        public Builder setUiExecutor(Executor executor) {
            this.f31331d = (Executor) Preconditions.checkNotNull(executor);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class FunctionsComponentImpl implements FunctionsComponent {

        /* renamed from: a  reason: collision with root package name */
        private final FunctionsComponentImpl f31335a;

        /* renamed from: b  reason: collision with root package name */
        private javax.inject.Provider<Context> f31336b;

        /* renamed from: c  reason: collision with root package name */
        private javax.inject.Provider<FirebaseOptions> f31337c;

        /* renamed from: d  reason: collision with root package name */
        private javax.inject.Provider<String> f31338d;

        /* renamed from: e  reason: collision with root package name */
        private javax.inject.Provider<Provider<InternalAuthProvider>> f31339e;

        /* renamed from: f  reason: collision with root package name */
        private javax.inject.Provider<Provider<FirebaseInstanceIdInternal>> f31340f;

        /* renamed from: g  reason: collision with root package name */
        private javax.inject.Provider<Deferred<InteropAppCheckTokenProvider>> f31341g;

        /* renamed from: h  reason: collision with root package name */
        private javax.inject.Provider<Executor> f31342h;

        /* renamed from: i  reason: collision with root package name */
        private javax.inject.Provider<FirebaseContextProvider> f31343i;

        /* renamed from: j  reason: collision with root package name */
        private javax.inject.Provider<Executor> f31344j;

        /* renamed from: k  reason: collision with root package name */
        private FirebaseFunctions_Factory f31345k;

        /* renamed from: l  reason: collision with root package name */
        private javax.inject.Provider<FunctionsMultiResourceComponent.FirebaseFunctionsFactory> f31346l;

        /* renamed from: m  reason: collision with root package name */
        private javax.inject.Provider<FunctionsMultiResourceComponent> f31347m;

        private void b(Context context, FirebaseOptions firebaseOptions, Executor executor, Executor executor2, Provider<InternalAuthProvider> provider, Provider<FirebaseInstanceIdInternal> provider2, Deferred<InteropAppCheckTokenProvider> deferred) {
            this.f31336b = InstanceFactory.create(context);
            Factory create = InstanceFactory.create(firebaseOptions);
            this.f31337c = create;
            this.f31338d = FunctionsComponent_MainModule_BindProjectIdFactory.create(create);
            this.f31339e = InstanceFactory.create(provider);
            this.f31340f = InstanceFactory.create(provider2);
            this.f31341g = InstanceFactory.create(deferred);
            Factory create2 = InstanceFactory.create(executor);
            this.f31342h = create2;
            this.f31343i = DoubleCheck.provider(FirebaseContextProvider_Factory.create(this.f31339e, this.f31340f, this.f31341g, create2));
            Factory create3 = InstanceFactory.create(executor2);
            this.f31344j = create3;
            FirebaseFunctions_Factory create4 = FirebaseFunctions_Factory.create(this.f31336b, this.f31338d, this.f31343i, this.f31342h, create3);
            this.f31345k = create4;
            javax.inject.Provider<FunctionsMultiResourceComponent.FirebaseFunctionsFactory> create5 = FunctionsMultiResourceComponent_FirebaseFunctionsFactory_Impl.create(create4);
            this.f31346l = create5;
            this.f31347m = DoubleCheck.provider(FunctionsMultiResourceComponent_Factory.create(create5));
        }

        @Override // com.google.firebase.functions.FunctionsComponent
        public FunctionsMultiResourceComponent a() {
            return this.f31347m.get();
        }

        private FunctionsComponentImpl(Context context, FirebaseOptions firebaseOptions, Executor executor, Executor executor2, Provider<InternalAuthProvider> provider, Provider<FirebaseInstanceIdInternal> provider2, Deferred<InteropAppCheckTokenProvider> deferred) {
            this.f31335a = this;
            b(context, firebaseOptions, executor, executor2, provider, provider2, deferred);
        }
    }

    private DaggerFunctionsComponent() {
    }

    public static FunctionsComponent.Builder a() {
        return new Builder();
    }
}
