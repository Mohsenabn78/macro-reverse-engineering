package com.arlosoft.macrodroid.constraint;

import com.arlosoft.macrodroid.geofences.GeofenceManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class GeofenceConstraint_MembersInjector implements MembersInjector<GeofenceConstraint> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeofenceManager> f10190a;

    public GeofenceConstraint_MembersInjector(Provider<GeofenceManager> provider) {
        this.f10190a = provider;
    }

    public static MembersInjector<GeofenceConstraint> create(Provider<GeofenceManager> provider) {
        return new GeofenceConstraint_MembersInjector(provider);
    }

    public static void injectGeofenceManager(GeofenceConstraint geofenceConstraint, GeofenceManager geofenceManager) {
        geofenceConstraint.geofenceManager = geofenceManager;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(GeofenceConstraint geofenceConstraint) {
        injectGeofenceManager(geofenceConstraint, this.f10190a.get());
    }
}
