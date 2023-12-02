package com.arlosoft.macrodroid.commercial;

import android.content.Context;
import com.arlosoft.macrodroid.commercial.api.CommercialApi;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CommercialTools_Factory implements Factory<CommercialTools> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f9821a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CommercialApi> f9822b;

    public CommercialTools_Factory(Provider<Context> provider, Provider<CommercialApi> provider2) {
        this.f9821a = provider;
        this.f9822b = provider2;
    }

    public static CommercialTools_Factory create(Provider<Context> provider, Provider<CommercialApi> provider2) {
        return new CommercialTools_Factory(provider, provider2);
    }

    public static CommercialTools newCommercialTools(Context context, CommercialApi commercialApi) {
        return new CommercialTools(context, commercialApi);
    }

    public static CommercialTools provideInstance(Provider<Context> provider, Provider<CommercialApi> provider2) {
        return new CommercialTools(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public CommercialTools get() {
        return provideInstance(this.f9821a, this.f9822b);
    }
}
