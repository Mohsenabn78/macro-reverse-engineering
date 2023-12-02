package com.arlosoft.macrodroid.videos;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class VideosActivity_MembersInjector implements MembersInjector<VideosActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f16425a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VideosViewModel> f16426b;

    public VideosActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<VideosViewModel> provider2) {
        this.f16425a = provider;
        this.f16426b = provider2;
    }

    public static MembersInjector<VideosActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<VideosViewModel> provider2) {
        return new VideosActivity_MembersInjector(provider, provider2);
    }

    public static void injectViewModel(VideosActivity videosActivity, VideosViewModel videosViewModel) {
        videosActivity.viewModel = videosViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(VideosActivity videosActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(videosActivity, this.f16425a.get());
        injectViewModel(videosActivity, this.f16426b.get());
    }
}
