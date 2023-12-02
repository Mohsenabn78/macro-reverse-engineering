package com.arlosoft.macrodroid.templatestore.ui.profile;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class ProfileImageProvider_Factory implements Factory<ProfileImageProvider> {

    /* renamed from: a  reason: collision with root package name */
    private static final ProfileImageProvider_Factory f13816a = new ProfileImageProvider_Factory();

    public static ProfileImageProvider_Factory create() {
        return f13816a;
    }

    public static ProfileImageProvider newProfileImageProvider() {
        return new ProfileImageProvider();
    }

    public static ProfileImageProvider provideInstance() {
        return new ProfileImageProvider();
    }

    @Override // javax.inject.Provider
    public ProfileImageProvider get() {
        return provideInstance();
    }
}
