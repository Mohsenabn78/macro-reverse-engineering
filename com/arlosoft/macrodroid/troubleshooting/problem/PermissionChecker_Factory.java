package com.arlosoft.macrodroid.troubleshooting.problem;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PermissionChecker_Factory implements Factory<PermissionChecker> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f15825a;

    public PermissionChecker_Factory(Provider<Context> provider) {
        this.f15825a = provider;
    }

    public static PermissionChecker_Factory create(Provider<Context> provider) {
        return new PermissionChecker_Factory(provider);
    }

    public static PermissionChecker newPermissionChecker(Context context) {
        return new PermissionChecker(context);
    }

    public static PermissionChecker provideInstance(Provider<Context> provider) {
        return new PermissionChecker(provider.get());
    }

    @Override // javax.inject.Provider
    public PermissionChecker get() {
        return provideInstance(this.f15825a);
    }
}
