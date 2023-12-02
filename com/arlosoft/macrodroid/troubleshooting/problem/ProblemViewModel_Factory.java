package com.arlosoft.macrodroid.troubleshooting.problem;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProblemViewModel_Factory implements Factory<ProblemViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f15843a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PermissionChecker> f15844b;

    public ProblemViewModel_Factory(Provider<Context> provider, Provider<PermissionChecker> provider2) {
        this.f15843a = provider;
        this.f15844b = provider2;
    }

    public static ProblemViewModel_Factory create(Provider<Context> provider, Provider<PermissionChecker> provider2) {
        return new ProblemViewModel_Factory(provider, provider2);
    }

    public static ProblemViewModel newProblemViewModel(Context context, PermissionChecker permissionChecker) {
        return new ProblemViewModel(context, permissionChecker);
    }

    public static ProblemViewModel provideInstance(Provider<Context> provider, Provider<PermissionChecker> provider2) {
        return new ProblemViewModel(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public ProblemViewModel get() {
        return provideInstance(this.f15843a, this.f15844b);
    }
}
