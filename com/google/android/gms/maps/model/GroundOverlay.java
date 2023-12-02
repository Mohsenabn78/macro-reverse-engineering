package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class GroundOverlay {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzk f21302a;

    public GroundOverlay(com.google.android.gms.internal.maps.zzk zzkVar) {
        this.f21302a = (com.google.android.gms.internal.maps.zzk) Preconditions.checkNotNull(zzkVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.f21302a.zzb(((GroundOverlay) obj).f21302a);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getBearing() {
        try {
            return this.f21302a.getBearing();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final LatLngBounds getBounds() {
        try {
            return this.f21302a.getBounds();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getHeight() {
        try {
            return this.f21302a.getHeight();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final String getId() {
        try {
            return this.f21302a.getId();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final LatLng getPosition() {
        try {
            return this.f21302a.getPosition();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Nullable
    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f21302a.zzk());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getTransparency() {
        try {
            return this.f21302a.getTransparency();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getWidth() {
        try {
            return this.f21302a.getWidth();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getZIndex() {
        try {
            return this.f21302a.getZIndex();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int hashCode() {
        try {
            return this.f21302a.zzj();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isClickable() {
        try {
            return this.f21302a.isClickable();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isVisible() {
        try {
            return this.f21302a.isVisible();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void remove() {
        try {
            this.f21302a.remove();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setBearing(float f4) {
        try {
            this.f21302a.setBearing(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setClickable(boolean z3) {
        try {
            this.f21302a.setClickable(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setDimensions(float f4) {
        try {
            this.f21302a.setDimensions(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setImage(@NonNull BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        try {
            this.f21302a.zzf(bitmapDescriptor.zzb());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setPosition(LatLng latLng) {
        try {
            this.f21302a.setPosition(latLng);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.f21302a.setPositionFromBounds(latLngBounds);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTag(@Nullable Object obj) {
        try {
            this.f21302a.zze(ObjectWrapper.wrap(obj));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTransparency(float f4) {
        try {
            this.f21302a.setTransparency(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setVisible(boolean z3) {
        try {
            this.f21302a.setVisible(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setZIndex(float f4) {
        try {
            this.f21302a.setZIndex(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setDimensions(float f4, float f5) {
        try {
            this.f21302a.zza(f4, f5);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
