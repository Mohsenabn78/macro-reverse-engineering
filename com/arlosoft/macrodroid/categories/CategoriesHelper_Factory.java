package com.arlosoft.macrodroid.categories;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CategoriesHelper_Factory implements Factory<CategoriesHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f9606a;

    public CategoriesHelper_Factory(Provider<Context> provider) {
        this.f9606a = provider;
    }

    public static CategoriesHelper_Factory create(Provider<Context> provider) {
        return new CategoriesHelper_Factory(provider);
    }

    public static CategoriesHelper newCategoriesHelper(Context context) {
        return new CategoriesHelper(context);
    }

    public static CategoriesHelper provideInstance(Provider<Context> provider) {
        return new CategoriesHelper(provider.get());
    }

    @Override // javax.inject.Provider
    public CategoriesHelper get() {
        return provideInstance(this.f9606a);
    }
}
