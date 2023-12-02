package com.arlosoft.macrodroid.templatestore.ui.upload;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.macrolist.HeadingColorMapper;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateUploadActivity_MembersInjector implements MembersInjector<TemplateUploadActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f14141a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TemplateUploadPresenter> f14142b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f14143c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f14144d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FlagProvider> f14145e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<HeadingColorMapper> f14146f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<TemplatesTranslationHelper> f14147g;

    public TemplateUploadActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<TemplateUploadPresenter> provider2, Provider<ProfileImageProvider> provider3, Provider<UserProvider> provider4, Provider<FlagProvider> provider5, Provider<HeadingColorMapper> provider6, Provider<TemplatesTranslationHelper> provider7) {
        this.f14141a = provider;
        this.f14142b = provider2;
        this.f14143c = provider3;
        this.f14144d = provider4;
        this.f14145e = provider5;
        this.f14146f = provider6;
        this.f14147g = provider7;
    }

    public static MembersInjector<TemplateUploadActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<TemplateUploadPresenter> provider2, Provider<ProfileImageProvider> provider3, Provider<UserProvider> provider4, Provider<FlagProvider> provider5, Provider<HeadingColorMapper> provider6, Provider<TemplatesTranslationHelper> provider7) {
        return new TemplateUploadActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static void injectFlagProvider(TemplateUploadActivity templateUploadActivity, FlagProvider flagProvider) {
        templateUploadActivity.flagProvider = flagProvider;
    }

    public static void injectHeadingColorMapper(TemplateUploadActivity templateUploadActivity, HeadingColorMapper headingColorMapper) {
        templateUploadActivity.headingColorMapper = headingColorMapper;
    }

    public static void injectPresenter(TemplateUploadActivity templateUploadActivity, TemplateUploadPresenter templateUploadPresenter) {
        templateUploadActivity.presenter = templateUploadPresenter;
    }

    public static void injectProfileImageProvider(TemplateUploadActivity templateUploadActivity, ProfileImageProvider profileImageProvider) {
        templateUploadActivity.profileImageProvider = profileImageProvider;
    }

    public static void injectTranslationHelper(TemplateUploadActivity templateUploadActivity, TemplatesTranslationHelper templatesTranslationHelper) {
        templateUploadActivity.translationHelper = templatesTranslationHelper;
    }

    public static void injectUserProvider(TemplateUploadActivity templateUploadActivity, UserProvider userProvider) {
        templateUploadActivity.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TemplateUploadActivity templateUploadActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(templateUploadActivity, this.f14141a.get());
        injectPresenter(templateUploadActivity, this.f14142b.get());
        injectProfileImageProvider(templateUploadActivity, this.f14143c.get());
        injectUserProvider(templateUploadActivity, this.f14144d.get());
        injectFlagProvider(templateUploadActivity, this.f14145e.get());
        injectHeadingColorMapper(templateUploadActivity, this.f14146f.get());
        injectTranslationHelper(templateUploadActivity, this.f14147g.get());
    }
}
