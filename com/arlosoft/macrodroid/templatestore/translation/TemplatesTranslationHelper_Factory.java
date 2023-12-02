package com.arlosoft.macrodroid.templatestore.translation;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplatesTranslationHelper_Factory implements Factory<TemplatesTranslationHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f13695a;

    public TemplatesTranslationHelper_Factory(Provider<Context> provider) {
        this.f13695a = provider;
    }

    public static TemplatesTranslationHelper_Factory create(Provider<Context> provider) {
        return new TemplatesTranslationHelper_Factory(provider);
    }

    public static TemplatesTranslationHelper newTemplatesTranslationHelper(Context context) {
        return new TemplatesTranslationHelper(context);
    }

    public static TemplatesTranslationHelper provideInstance(Provider<Context> provider) {
        return new TemplatesTranslationHelper(provider.get());
    }

    @Override // javax.inject.Provider
    public TemplatesTranslationHelper get() {
        return provideInstance(this.f13695a);
    }
}
