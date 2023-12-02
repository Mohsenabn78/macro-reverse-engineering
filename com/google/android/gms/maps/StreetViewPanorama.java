package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import net.bytebuddy.implementation.MethodDelegation;

/* loaded from: classes4.dex */
public class StreetViewPanorama {

    /* renamed from: a  reason: collision with root package name */
    private final IStreetViewPanoramaDelegate f21237a;

    /* loaded from: classes4.dex */
    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    /* loaded from: classes4.dex */
    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    /* loaded from: classes4.dex */
    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    /* loaded from: classes4.dex */
    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public StreetViewPanorama(@NonNull IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f21237a = (IStreetViewPanoramaDelegate) Preconditions.checkNotNull(iStreetViewPanoramaDelegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    }

    public void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j4) {
        try {
            this.f21237a.animateTo(streetViewPanoramaCamera, j4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.f21237a.getStreetViewPanoramaLocation();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.f21237a.getPanoramaCamera();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.f21237a.isPanningGesturesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.f21237a.isStreetNamesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.f21237a.isUserNavigationEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.f21237a.isZoomGesturesEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            IObjectWrapper orientationToPoint = this.f21237a.orientationToPoint(streetViewPanoramaOrientation);
            if (orientationToPoint == null) {
                return null;
            }
            return (Point) ObjectWrapper.unwrap(orientationToPoint);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.f21237a.pointToOrientation(ObjectWrapper.wrap(point));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        try {
            if (onStreetViewPanoramaCameraChangeListener == null) {
                this.f21237a.setOnStreetViewPanoramaCameraChangeListener(null);
            } else {
                this.f21237a.setOnStreetViewPanoramaCameraChangeListener(new zzae(this, onStreetViewPanoramaCameraChangeListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        try {
            if (onStreetViewPanoramaChangeListener == null) {
                this.f21237a.setOnStreetViewPanoramaChangeListener(null);
            } else {
                this.f21237a.setOnStreetViewPanoramaChangeListener(new zzad(this, onStreetViewPanoramaChangeListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        try {
            if (onStreetViewPanoramaClickListener == null) {
                this.f21237a.setOnStreetViewPanoramaClickListener(null);
            } else {
                this.f21237a.setOnStreetViewPanoramaClickListener(new zzaf(this, onStreetViewPanoramaClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        try {
            if (onStreetViewPanoramaLongClickListener == null) {
                this.f21237a.setOnStreetViewPanoramaLongClickListener(null);
            } else {
                this.f21237a.setOnStreetViewPanoramaLongClickListener(new zzag(this, onStreetViewPanoramaLongClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setPanningGesturesEnabled(boolean z3) {
        try {
            this.f21237a.enablePanning(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setPosition(String str) {
        try {
            this.f21237a.setPositionWithID(str);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setStreetNamesEnabled(boolean z3) {
        try {
            this.f21237a.enableStreetNames(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setUserNavigationEnabled(boolean z3) {
        try {
            this.f21237a.enableUserNavigation(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setZoomGesturesEnabled(boolean z3) {
        try {
            this.f21237a.enableZoom(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f21237a.setPosition(latLng);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setPosition(LatLng latLng, int i4) {
        try {
            this.f21237a.setPositionWithRadius(latLng, i4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setPosition(LatLng latLng, StreetViewSource streetViewSource) {
        try {
            this.f21237a.setPositionWithSource(latLng, streetViewSource);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public void setPosition(LatLng latLng, int i4, StreetViewSource streetViewSource) {
        try {
            this.f21237a.setPositionWithRadiusAndSource(latLng, i4, streetViewSource);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
