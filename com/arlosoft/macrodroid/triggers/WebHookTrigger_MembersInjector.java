package com.arlosoft.macrodroid.triggers;

import com.arlosoft.macrodroid.triggers.webtrigger.WebTriggerInteractor;
import com.arlosoft.macrodroid.triggers.webtrigger.api.TinyUrlApi;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class WebHookTrigger_MembersInjector implements MembersInjector<WebHookTrigger> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WebTriggerInteractor> f14469a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TinyUrlApi> f14470b;

    public WebHookTrigger_MembersInjector(Provider<WebTriggerInteractor> provider, Provider<TinyUrlApi> provider2) {
        this.f14469a = provider;
        this.f14470b = provider2;
    }

    public static MembersInjector<WebHookTrigger> create(Provider<WebTriggerInteractor> provider, Provider<TinyUrlApi> provider2) {
        return new WebHookTrigger_MembersInjector(provider, provider2);
    }

    public static void injectTinyUrlApi(WebHookTrigger webHookTrigger, TinyUrlApi tinyUrlApi) {
        webHookTrigger.tinyUrlApi = tinyUrlApi;
    }

    public static void injectWebTriggerInteractor(WebHookTrigger webHookTrigger, WebTriggerInteractor webTriggerInteractor) {
        webHookTrigger.webTriggerInteractor = webTriggerInteractor;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(WebHookTrigger webHookTrigger) {
        injectWebTriggerInteractor(webHookTrigger, this.f14469a.get());
        injectTinyUrlApi(webHookTrigger, this.f14470b.get());
    }
}
