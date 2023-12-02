package com.google.firebase.functions;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.functions.dagger.internal.DaggerGenerated;
import com.google.firebase.functions.dagger.internal.Factory;
import com.google.firebase.functions.dagger.internal.Preconditions;
import com.google.firebase.functions.dagger.internal.QualifierMetadata;
import com.google.firebase.functions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@QualifierMetadata({"javax.inject.Named"})
@DaggerGenerated
@ScopeMetadata
/* loaded from: classes5.dex */
public final class FunctionsComponent_MainModule_BindProjectIdFactory implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FirebaseOptions> f31377a;

    public FunctionsComponent_MainModule_BindProjectIdFactory(Provider<FirebaseOptions> provider) {
        this.f31377a = provider;
    }

    public static String bindProjectId(FirebaseOptions firebaseOptions) {
        return (String) Preconditions.checkNotNullFromProvides(k.a(firebaseOptions));
    }

    public static FunctionsComponent_MainModule_BindProjectIdFactory create(Provider<FirebaseOptions> provider) {
        return new FunctionsComponent_MainModule_BindProjectIdFactory(provider);
    }

    @Override // javax.inject.Provider
    public String get() {
        return bindProjectId(this.f31377a.get());
    }
}
