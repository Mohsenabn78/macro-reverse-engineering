package com.arlosoft.macrodroid.freeversion;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AddDaysActivity_MembersInjector implements MembersInjector<AddDaysActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12172a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f12173b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f12174c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PermissionChecker> f12175d;

    public AddDaysActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<FreeVersionHelper> provider3, Provider<PermissionChecker> provider4) {
        this.f12172a = provider;
        this.f12173b = provider2;
        this.f12174c = provider3;
        this.f12175d = provider4;
    }

    public static MembersInjector<AddDaysActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<FreeVersionHelper> provider3, Provider<PermissionChecker> provider4) {
        return new AddDaysActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectFreeVersionHelper(AddDaysActivity addDaysActivity, FreeVersionHelper freeVersionHelper) {
        addDaysActivity.freeVersionHelper = freeVersionHelper;
    }

    public static void injectPermissionChecker(AddDaysActivity addDaysActivity, PermissionChecker permissionChecker) {
        addDaysActivity.permissionChecker = permissionChecker;
    }

    public static void injectRemoteConfig(AddDaysActivity addDaysActivity, RemoteConfig remoteConfig) {
        addDaysActivity.remoteConfig = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AddDaysActivity addDaysActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(addDaysActivity, this.f12172a.get());
        injectRemoteConfig(addDaysActivity, this.f12173b.get());
        injectFreeVersionHelper(addDaysActivity, this.f12174c.get());
        injectPermissionChecker(addDaysActivity, this.f12175d.get());
    }
}
