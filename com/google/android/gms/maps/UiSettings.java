package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private final IUiSettingsDelegate f21278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.f21278a = iUiSettingsDelegate;
    }

    public final boolean isCompassEnabled() {
        try {
            return this.f21278a.isCompassEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isIndoorLevelPickerEnabled() {
        try {
            return this.f21278a.isIndoorLevelPickerEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isMapToolbarEnabled() {
        try {
            return this.f21278a.isMapToolbarEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.f21278a.isMyLocationButtonEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isRotateGesturesEnabled() {
        try {
            return this.f21278a.isRotateGesturesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.f21278a.isScrollGesturesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isScrollGesturesEnabledDuringRotateOrZoom() {
        try {
            return this.f21278a.isScrollGesturesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isTiltGesturesEnabled() {
        try {
            return this.f21278a.isTiltGesturesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.f21278a.isZoomControlsEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.f21278a.isZoomGesturesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setAllGesturesEnabled(boolean z3) {
        try {
            this.f21278a.setAllGesturesEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setCompassEnabled(boolean z3) {
        try {
            this.f21278a.setCompassEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setIndoorLevelPickerEnabled(boolean z3) {
        try {
            this.f21278a.setIndoorLevelPickerEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setMapToolbarEnabled(boolean z3) {
        try {
            this.f21278a.setMapToolbarEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setMyLocationButtonEnabled(boolean z3) {
        try {
            this.f21278a.setMyLocationButtonEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setRotateGesturesEnabled(boolean z3) {
        try {
            this.f21278a.setRotateGesturesEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setScrollGesturesEnabled(boolean z3) {
        try {
            this.f21278a.setScrollGesturesEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean z3) {
        try {
            this.f21278a.setScrollGesturesEnabledDuringRotateOrZoom(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTiltGesturesEnabled(boolean z3) {
        try {
            this.f21278a.setTiltGesturesEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setZoomControlsEnabled(boolean z3) {
        try {
            this.f21278a.setZoomControlsEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setZoomGesturesEnabled(boolean z3) {
        try {
            this.f21278a.setZoomGesturesEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
