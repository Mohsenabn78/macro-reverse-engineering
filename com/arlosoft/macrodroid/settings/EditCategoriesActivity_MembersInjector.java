package com.arlosoft.macrodroid.settings;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class EditCategoriesActivity_MembersInjector implements MembersInjector<EditCategoriesActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13411a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CategoriesHelper> f13412b;

    public EditCategoriesActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<CategoriesHelper> provider2) {
        this.f13411a = provider;
        this.f13412b = provider2;
    }

    public static MembersInjector<EditCategoriesActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<CategoriesHelper> provider2) {
        return new EditCategoriesActivity_MembersInjector(provider, provider2);
    }

    public static void injectCategoriesHelper(EditCategoriesActivity editCategoriesActivity, CategoriesHelper categoriesHelper) {
        editCategoriesActivity.f13399k = categoriesHelper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(EditCategoriesActivity editCategoriesActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(editCategoriesActivity, this.f13411a.get());
        injectCategoriesHelper(editCategoriesActivity, this.f13412b.get());
    }
}
