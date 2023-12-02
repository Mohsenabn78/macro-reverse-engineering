package com.google.firebase.functions;

import android.content.Context;
import com.google.firebase.functions.dagger.internal.DaggerGenerated;
import com.google.firebase.functions.dagger.internal.QualifierMetadata;
import com.google.firebase.functions.dagger.internal.ScopeMetadata;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@QualifierMetadata({"javax.inject.Named", "com.google.firebase.annotations.concurrent.Lightweight", "com.google.firebase.annotations.concurrent.UiThread"})
@DaggerGenerated
@ScopeMetadata
/* loaded from: classes5.dex */
public final class FirebaseFunctions_Factory {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f31372a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<String> f31373b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ContextProvider> f31374c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Executor> f31375d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Executor> f31376e;

    public FirebaseFunctions_Factory(Provider<Context> provider, Provider<String> provider2, Provider<ContextProvider> provider3, Provider<Executor> provider4, Provider<Executor> provider5) {
        this.f31372a = provider;
        this.f31373b = provider2;
        this.f31374c = provider3;
        this.f31375d = provider4;
        this.f31376e = provider5;
    }

    public static FirebaseFunctions_Factory create(Provider<Context> provider, Provider<String> provider2, Provider<ContextProvider> provider3, Provider<Executor> provider4, Provider<Executor> provider5) {
        return new FirebaseFunctions_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FirebaseFunctions newInstance(Context context, String str, String str2, Object obj, Executor executor, Executor executor2) {
        return new FirebaseFunctions(context, str, str2, (ContextProvider) obj, executor, executor2);
    }

    public FirebaseFunctions get(String str) {
        return newInstance(this.f31372a.get(), this.f31373b.get(), str, this.f31374c.get(), this.f31375d.get(), this.f31376e.get());
    }
}
