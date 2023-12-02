package com.arlosoft.macrodroid.templatestore.ui.search;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateSearchActivity_MembersInjector implements MembersInjector<TemplateSearchActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13855a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f13856b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SignInHelper> f13857c;

    public TemplateSearchActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<SignInHelper> provider3) {
        this.f13855a = provider;
        this.f13856b = provider2;
        this.f13857c = provider3;
    }

    public static MembersInjector<TemplateSearchActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<SignInHelper> provider3) {
        return new TemplateSearchActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectRoomDatabase(TemplateSearchActivity templateSearchActivity, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        templateSearchActivity.roomDatabase = macroDroidRoomDatabase;
    }

    public static void injectSignInHelper(TemplateSearchActivity templateSearchActivity, SignInHelper signInHelper) {
        templateSearchActivity.signInHelper = signInHelper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TemplateSearchActivity templateSearchActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(templateSearchActivity, this.f13855a.get());
        injectRoomDatabase(templateSearchActivity, this.f13856b.get());
        injectSignInHelper(templateSearchActivity, this.f13857c.get());
    }
}
