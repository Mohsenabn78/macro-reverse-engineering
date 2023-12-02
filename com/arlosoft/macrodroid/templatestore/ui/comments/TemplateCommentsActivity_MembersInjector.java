package com.arlosoft.macrodroid.templatestore.ui.comments;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.comments.presenter.TemplateCommentsPresenter;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateCommentsActivity_MembersInjector implements MembersInjector<TemplateCommentsActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13741a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f13742b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TemplateCommentsPresenter> f13743c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13744d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UserProvider> f13745e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f13746f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<TemplateCommentsDataRepository> f13747g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f13748h;

    public TemplateCommentsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<TemplateStoreApi> provider2, Provider<TemplateCommentsPresenter> provider3, Provider<ProfileImageProvider> provider4, Provider<UserProvider> provider5, Provider<PremiumStatusHandler> provider6, Provider<TemplateCommentsDataRepository> provider7, Provider<MacroDroidRoomDatabase> provider8) {
        this.f13741a = provider;
        this.f13742b = provider2;
        this.f13743c = provider3;
        this.f13744d = provider4;
        this.f13745e = provider5;
        this.f13746f = provider6;
        this.f13747g = provider7;
        this.f13748h = provider8;
    }

    public static MembersInjector<TemplateCommentsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<TemplateStoreApi> provider2, Provider<TemplateCommentsPresenter> provider3, Provider<ProfileImageProvider> provider4, Provider<UserProvider> provider5, Provider<PremiumStatusHandler> provider6, Provider<TemplateCommentsDataRepository> provider7, Provider<MacroDroidRoomDatabase> provider8) {
        return new TemplateCommentsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static void injectApi(TemplateCommentsActivity templateCommentsActivity, TemplateStoreApi templateStoreApi) {
        templateCommentsActivity.api = templateStoreApi;
    }

    public static void injectPremiumStatusHandler(TemplateCommentsActivity templateCommentsActivity, PremiumStatusHandler premiumStatusHandler) {
        templateCommentsActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectPresenter(TemplateCommentsActivity templateCommentsActivity, TemplateCommentsPresenter templateCommentsPresenter) {
        templateCommentsActivity.presenter = templateCommentsPresenter;
    }

    public static void injectProfileImageProvider(TemplateCommentsActivity templateCommentsActivity, ProfileImageProvider profileImageProvider) {
        templateCommentsActivity.profileImageProvider = profileImageProvider;
    }

    public static void injectRoomDatabase(TemplateCommentsActivity templateCommentsActivity, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        templateCommentsActivity.roomDatabase = macroDroidRoomDatabase;
    }

    public static void injectTemplateCommentsDataRepository(TemplateCommentsActivity templateCommentsActivity, TemplateCommentsDataRepository templateCommentsDataRepository) {
        templateCommentsActivity.templateCommentsDataRepository = templateCommentsDataRepository;
    }

    public static void injectUserProvider(TemplateCommentsActivity templateCommentsActivity, UserProvider userProvider) {
        templateCommentsActivity.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TemplateCommentsActivity templateCommentsActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(templateCommentsActivity, this.f13741a.get());
        injectApi(templateCommentsActivity, this.f13742b.get());
        injectPresenter(templateCommentsActivity, this.f13743c.get());
        injectProfileImageProvider(templateCommentsActivity, this.f13744d.get());
        injectUserProvider(templateCommentsActivity, this.f13745e.get());
        injectPremiumStatusHandler(templateCommentsActivity, this.f13746f.get());
        injectTemplateCommentsDataRepository(templateCommentsActivity, this.f13747g.get());
        injectRoomDatabase(templateCommentsActivity, this.f13748h.get());
    }
}
