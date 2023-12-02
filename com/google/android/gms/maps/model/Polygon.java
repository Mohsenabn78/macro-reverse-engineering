package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzw;
import java.util.List;

/* loaded from: classes4.dex */
public final class Polygon {

    /* renamed from: a  reason: collision with root package name */
    private final zzw f21342a;

    public Polygon(zzw zzwVar) {
        this.f21342a = (zzw) Preconditions.checkNotNull(zzwVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.f21342a.zzb(((Polygon) obj).f21342a);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getFillColor() {
        try {
            return this.f21342a.getFillColor();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final List<List<LatLng>> getHoles() {
        try {
            return this.f21342a.getHoles();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final String getId() {
        try {
            return this.f21342a.getId();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final List<LatLng> getPoints() {
        try {
            return this.f21342a.getPoints();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getStrokeColor() {
        try {
            return this.f21342a.getStrokeColor();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getStrokeJointType() {
        try {
            return this.f21342a.getStrokeJointType();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.b(this.f21342a.getStrokePattern());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getStrokeWidth() {
        try {
            return this.f21342a.getStrokeWidth();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Nullable
    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f21342a.zzk());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getZIndex() {
        try {
            return this.f21342a.getZIndex();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int hashCode() {
        try {
            return this.f21342a.zzj();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isClickable() {
        try {
            return this.f21342a.isClickable();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isGeodesic() {
        try {
            return this.f21342a.isGeodesic();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isVisible() {
        try {
            return this.f21342a.isVisible();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void remove() {
        try {
            this.f21342a.remove();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setClickable(boolean z3) {
        try {
            this.f21342a.setClickable(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setFillColor(int i4) {
        try {
            this.f21342a.setFillColor(i4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setGeodesic(boolean z3) {
        try {
            this.f21342a.setGeodesic(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setHoles(List<? extends List<LatLng>> list) {
        try {
            this.f21342a.setHoles(list);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setPoints(List<LatLng> list) {
        try {
            this.f21342a.setPoints(list);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setStrokeColor(int i4) {
        try {
            this.f21342a.setStrokeColor(i4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setStrokeJointType(int i4) {
        try {
            this.f21342a.setStrokeJointType(i4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setStrokePattern(@Nullable List<PatternItem> list) {
        try {
            this.f21342a.setStrokePattern(list);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setStrokeWidth(float f4) {
        try {
            this.f21342a.setStrokeWidth(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTag(@Nullable Object obj) {
        try {
            this.f21342a.zze(ObjectWrapper.wrap(obj));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setVisible(boolean z3) {
        try {
            this.f21342a.setVisible(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setZIndex(float f4) {
        try {
            this.f21342a.setZIndex(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
