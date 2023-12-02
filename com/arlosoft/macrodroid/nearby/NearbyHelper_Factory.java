package com.arlosoft.macrodroid.nearby;

import android.content.Context;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class NearbyHelper_Factory implements Factory<NearbyHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f13009a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ActionBlockStore> f13010b;

    public NearbyHelper_Factory(Provider<Context> provider, Provider<ActionBlockStore> provider2) {
        this.f13009a = provider;
        this.f13010b = provider2;
    }

    public static NearbyHelper_Factory create(Provider<Context> provider, Provider<ActionBlockStore> provider2) {
        return new NearbyHelper_Factory(provider, provider2);
    }

    public static NearbyHelper newNearbyHelper(Context context, ActionBlockStore actionBlockStore) {
        return new NearbyHelper(context, actionBlockStore);
    }

    public static NearbyHelper provideInstance(Provider<Context> provider, Provider<ActionBlockStore> provider2) {
        return new NearbyHelper(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public NearbyHelper get() {
        return provideInstance(this.f13009a, this.f13010b);
    }
}
