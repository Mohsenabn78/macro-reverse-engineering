package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class Marker {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzt f21324a;

    public Marker(com.google.android.gms.internal.maps.zzt zztVar) {
        this.f21324a = (com.google.android.gms.internal.maps.zzt) Preconditions.checkNotNull(zztVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.f21324a.zzj(((Marker) obj).f21324a);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getAlpha() {
        try {
            return this.f21324a.getAlpha();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final String getId() {
        try {
            return this.f21324a.getId();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final LatLng getPosition() {
        try {
            return this.f21324a.getPosition();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getRotation() {
        try {
            return this.f21324a.getRotation();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final String getSnippet() {
        try {
            return this.f21324a.getSnippet();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Nullable
    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f21324a.zzk());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final String getTitle() {
        try {
            return this.f21324a.getTitle();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getZIndex() {
        try {
            return this.f21324a.getZIndex();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int hashCode() {
        try {
            return this.f21324a.zzj();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void hideInfoWindow() {
        try {
            this.f21324a.hideInfoWindow();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isDraggable() {
        try {
            return this.f21324a.isDraggable();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isFlat() {
        try {
            return this.f21324a.isFlat();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isInfoWindowShown() {
        try {
            return this.f21324a.isInfoWindowShown();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isVisible() {
        try {
            return this.f21324a.isVisible();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void remove() {
        try {
            this.f21324a.remove();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setAlpha(float f4) {
        try {
            this.f21324a.setAlpha(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setAnchor(float f4, float f5) {
        try {
            this.f21324a.setAnchor(f4, f5);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setDraggable(boolean z3) {
        try {
            this.f21324a.setDraggable(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setFlat(boolean z3) {
        try {
            this.f21324a.setFlat(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setIcon(@Nullable BitmapDescriptor bitmapDescriptor) {
        try {
            if (bitmapDescriptor == null) {
                this.f21324a.zzg(null);
                return;
            }
            this.f21324a.zzg(bitmapDescriptor.zzb());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setInfoWindowAnchor(float f4, float f5) {
        try {
            this.f21324a.setInfoWindowAnchor(f4, f5);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setPosition(@NonNull LatLng latLng) {
        if (latLng != null) {
            try {
                this.f21324a.setPosition(latLng);
                return;
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    public final void setRotation(float f4) {
        try {
            this.f21324a.setRotation(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setSnippet(@Nullable String str) {
        try {
            this.f21324a.setSnippet(str);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTag(@Nullable Object obj) {
        try {
            this.f21324a.zze(ObjectWrapper.wrap(obj));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTitle(@Nullable String str) {
        try {
            this.f21324a.setTitle(str);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setVisible(boolean z3) {
        try {
            this.f21324a.setVisible(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setZIndex(float f4) {
        try {
            this.f21324a.setZIndex(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void showInfoWindow() {
        try {
            this.f21324a.showInfoWindow();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
