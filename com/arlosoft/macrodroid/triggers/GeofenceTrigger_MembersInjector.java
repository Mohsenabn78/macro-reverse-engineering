package com.arlosoft.macrodroid.triggers;

import com.arlosoft.macrodroid.geofences.GeofenceManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class GeofenceTrigger_MembersInjector implements MembersInjector<GeofenceTrigger> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeofenceManager> f14369a;

    public GeofenceTrigger_MembersInjector(Provider<GeofenceManager> provider) {
        this.f14369a = provider;
    }

    public static MembersInjector<GeofenceTrigger> create(Provider<GeofenceManager> provider) {
        return new GeofenceTrigger_MembersInjector(provider);
    }

    public static void injectGeofenceManager(GeofenceTrigger geofenceTrigger, GeofenceManager geofenceManager) {
        geofenceTrigger.f14366c = geofenceManager;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(GeofenceTrigger geofenceTrigger) {
        injectGeofenceManager(geofenceTrigger, this.f14369a.get());
    }
}
