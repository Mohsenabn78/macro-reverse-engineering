package com.arlosoft.macrodroid.geofences;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class GeofenceManager_Factory implements Factory<GeofenceManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12214a;

    public GeofenceManager_Factory(Provider<Context> provider) {
        this.f12214a = provider;
    }

    public static GeofenceManager_Factory create(Provider<Context> provider) {
        return new GeofenceManager_Factory(provider);
    }

    public static GeofenceManager newGeofenceManager(Context context) {
        return new GeofenceManager(context);
    }

    public static GeofenceManager provideInstance(Provider<Context> provider) {
        return new GeofenceManager(provider.get());
    }

    @Override // javax.inject.Provider
    public GeofenceManager get() {
        return provideInstance(this.f12214a);
    }
}
