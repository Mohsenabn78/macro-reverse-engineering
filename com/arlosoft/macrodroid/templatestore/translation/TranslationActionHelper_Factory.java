package com.arlosoft.macrodroid.templatestore.translation;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TranslationActionHelper_Factory implements Factory<TranslationActionHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f13697a;

    public TranslationActionHelper_Factory(Provider<Context> provider) {
        this.f13697a = provider;
    }

    public static TranslationActionHelper_Factory create(Provider<Context> provider) {
        return new TranslationActionHelper_Factory(provider);
    }

    public static TranslationActionHelper newTranslationActionHelper(Context context) {
        return new TranslationActionHelper(context);
    }

    public static TranslationActionHelper provideInstance(Provider<Context> provider) {
        return new TranslationActionHelper(provider.get());
    }

    @Override // javax.inject.Provider
    public TranslationActionHelper get() {
        return provideInstance(this.f13697a);
    }
}
