package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f18906a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<String> f18907b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Integer> f18908c;

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f18906a = provider;
        this.f18907b = provider2;
        this.f18908c = provider3;
    }

    public static SchemaManager_Factory create(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager newInstance(Context context, String str, int i4) {
        return new SchemaManager(context, str, i4);
    }

    @Override // javax.inject.Provider
    public SchemaManager get() {
        return newInstance(this.f18906a.get(), this.f18907b.get(), this.f18908c.get().intValue());
    }
}
