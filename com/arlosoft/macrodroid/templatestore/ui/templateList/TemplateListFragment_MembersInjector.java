package com.arlosoft.macrodroid.templatestore.ui.templateList;

import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsDataRepository;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateListFragment_MembersInjector implements MembersInjector<TemplateListFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TemplateListPresenter> f13987a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13988b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LocalTemplateOverrideStore> f13989c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f13990d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FlagProvider> f13991e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<TemplateCommentsDataRepository> f13992f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ScreenLoader> f13993g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<TemplatesTranslationHelper> f13994h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f13995i;

    public TemplateListFragment_MembersInjector(Provider<TemplateListPresenter> provider, Provider<ProfileImageProvider> provider2, Provider<LocalTemplateOverrideStore> provider3, Provider<UserProvider> provider4, Provider<FlagProvider> provider5, Provider<TemplateCommentsDataRepository> provider6, Provider<ScreenLoader> provider7, Provider<TemplatesTranslationHelper> provider8, Provider<MacroDroidRoomDatabase> provider9) {
        this.f13987a = provider;
        this.f13988b = provider2;
        this.f13989c = provider3;
        this.f13990d = provider4;
        this.f13991e = provider5;
        this.f13992f = provider6;
        this.f13993g = provider7;
        this.f13994h = provider8;
        this.f13995i = provider9;
    }

    public static MembersInjector<TemplateListFragment> create(Provider<TemplateListPresenter> provider, Provider<ProfileImageProvider> provider2, Provider<LocalTemplateOverrideStore> provider3, Provider<UserProvider> provider4, Provider<FlagProvider> provider5, Provider<TemplateCommentsDataRepository> provider6, Provider<ScreenLoader> provider7, Provider<TemplatesTranslationHelper> provider8, Provider<MacroDroidRoomDatabase> provider9) {
        return new TemplateListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static void injectFlagProvider(TemplateListFragment templateListFragment, FlagProvider flagProvider) {
        templateListFragment.flagProvider = flagProvider;
    }

    public static void injectLocalTemplateOverrideStore(TemplateListFragment templateListFragment, LocalTemplateOverrideStore localTemplateOverrideStore) {
        templateListFragment.localTemplateOverrideStore = localTemplateOverrideStore;
    }

    public static void injectPresenter(TemplateListFragment templateListFragment, TemplateListPresenter templateListPresenter) {
        templateListFragment.presenter = templateListPresenter;
    }

    public static void injectProfileImageProvider(TemplateListFragment templateListFragment, ProfileImageProvider profileImageProvider) {
        templateListFragment.profileImageProvider = profileImageProvider;
    }

    public static void injectRoomDatabase(TemplateListFragment templateListFragment, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        templateListFragment.roomDatabase = macroDroidRoomDatabase;
    }

    public static void injectScreenLoader(TemplateListFragment templateListFragment, ScreenLoader screenLoader) {
        templateListFragment.screenLoader = screenLoader;
    }

    public static void injectTemplateCommentsDataRepository(TemplateListFragment templateListFragment, TemplateCommentsDataRepository templateCommentsDataRepository) {
        templateListFragment.templateCommentsDataRepository = templateCommentsDataRepository;
    }

    public static void injectTranslationHelper(TemplateListFragment templateListFragment, TemplatesTranslationHelper templatesTranslationHelper) {
        templateListFragment.translationHelper = templatesTranslationHelper;
    }

    public static void injectUserProvider(TemplateListFragment templateListFragment, UserProvider userProvider) {
        templateListFragment.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TemplateListFragment templateListFragment) {
        injectPresenter(templateListFragment, this.f13987a.get());
        injectProfileImageProvider(templateListFragment, this.f13988b.get());
        injectLocalTemplateOverrideStore(templateListFragment, this.f13989c.get());
        injectUserProvider(templateListFragment, this.f13990d.get());
        injectFlagProvider(templateListFragment, this.f13991e.get());
        injectTemplateCommentsDataRepository(templateListFragment, this.f13992f.get());
        injectScreenLoader(templateListFragment, this.f13993g.get());
        injectTranslationHelper(templateListFragment, this.f13994h.get());
        injectRoomDatabase(templateListFragment, this.f13995i.get());
    }
}
