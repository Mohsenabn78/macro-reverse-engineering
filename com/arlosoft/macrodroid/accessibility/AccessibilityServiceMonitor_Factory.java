package com.arlosoft.macrodroid.accessibility;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AccessibilityServiceMonitor_Factory implements Factory<AccessibilityServiceMonitor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f2047a;

    public AccessibilityServiceMonitor_Factory(Provider<Context> provider) {
        this.f2047a = provider;
    }

    public static AccessibilityServiceMonitor_Factory create(Provider<Context> provider) {
        return new AccessibilityServiceMonitor_Factory(provider);
    }

    public static AccessibilityServiceMonitor newAccessibilityServiceMonitor(Context context) {
        return new AccessibilityServiceMonitor(context);
    }

    public static AccessibilityServiceMonitor provideInstance(Provider<Context> provider) {
        return new AccessibilityServiceMonitor(provider.get());
    }

    @Override // javax.inject.Provider
    public AccessibilityServiceMonitor get() {
        return provideInstance(this.f2047a);
    }
}
