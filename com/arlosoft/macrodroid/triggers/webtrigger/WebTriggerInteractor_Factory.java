package com.arlosoft.macrodroid.triggers.webtrigger;

import com.arlosoft.macrodroid.triggers.webtrigger.api.WebTriggerApi;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class WebTriggerInteractor_Factory implements Factory<WebTriggerInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WebTriggerApi> f15720a;

    public WebTriggerInteractor_Factory(Provider<WebTriggerApi> provider) {
        this.f15720a = provider;
    }

    public static WebTriggerInteractor_Factory create(Provider<WebTriggerApi> provider) {
        return new WebTriggerInteractor_Factory(provider);
    }

    public static WebTriggerInteractor newWebTriggerInteractor(WebTriggerApi webTriggerApi) {
        return new WebTriggerInteractor(webTriggerApi);
    }

    public static WebTriggerInteractor provideInstance(Provider<WebTriggerApi> provider) {
        return new WebTriggerInteractor(provider.get());
    }

    @Override // javax.inject.Provider
    public WebTriggerInteractor get() {
        return provideInstance(this.f15720a);
    }
}
