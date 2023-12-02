package com.arlosoft.macrodroid.app.navigation;

import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsDataRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ScreenLoader_MembersInjector implements MembersInjector<ScreenLoader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TemplateCommentsDataRepository> f9299a;

    public ScreenLoader_MembersInjector(Provider<TemplateCommentsDataRepository> provider) {
        this.f9299a = provider;
    }

    public static MembersInjector<ScreenLoader> create(Provider<TemplateCommentsDataRepository> provider) {
        return new ScreenLoader_MembersInjector(provider);
    }

    public static void injectTemplateCommentsDataRepository(ScreenLoader screenLoader, TemplateCommentsDataRepository templateCommentsDataRepository) {
        screenLoader.templateCommentsDataRepository = templateCommentsDataRepository;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ScreenLoader screenLoader) {
        injectTemplateCommentsDataRepository(screenLoader, this.f9299a.get());
    }
}
