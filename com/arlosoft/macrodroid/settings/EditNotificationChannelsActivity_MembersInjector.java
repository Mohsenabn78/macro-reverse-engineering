package com.arlosoft.macrodroid.settings;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class EditNotificationChannelsActivity_MembersInjector implements MembersInjector<EditNotificationChannelsActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13429a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NotificationChannelUtil> f13430b;

    public EditNotificationChannelsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<NotificationChannelUtil> provider2) {
        this.f13429a = provider;
        this.f13430b = provider2;
    }

    public static MembersInjector<EditNotificationChannelsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<NotificationChannelUtil> provider2) {
        return new EditNotificationChannelsActivity_MembersInjector(provider, provider2);
    }

    public static void injectNotificationChannelUtil(EditNotificationChannelsActivity editNotificationChannelsActivity, NotificationChannelUtil notificationChannelUtil) {
        editNotificationChannelsActivity.notificationChannelUtil = notificationChannelUtil;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(EditNotificationChannelsActivity editNotificationChannelsActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(editNotificationChannelsActivity, this.f13429a.get());
        injectNotificationChannelUtil(editNotificationChannelsActivity, this.f13430b.get());
    }
}
