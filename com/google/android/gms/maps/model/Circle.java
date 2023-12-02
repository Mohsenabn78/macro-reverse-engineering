package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* loaded from: classes4.dex */
public final class Circle {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzh f21292a;

    public Circle(com.google.android.gms.internal.maps.zzh zzhVar) {
        this.f21292a = (com.google.android.gms.internal.maps.zzh) Preconditions.checkNotNull(zzhVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.f21292a.zzb(((Circle) obj).f21292a);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final LatLng getCenter() {
        try {
            return this.f21292a.getCenter();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getFillColor() {
        try {
            return this.f21292a.getFillColor();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final String getId() {
        try {
            return this.f21292a.getId();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final double getRadius() {
        try {
            return this.f21292a.getRadius();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getStrokeColor() {
        try {
            return this.f21292a.getStrokeColor();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.b(this.f21292a.getStrokePattern());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getStrokeWidth() {
        try {
            return this.f21292a.getStrokeWidth();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Nullable
    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f21292a.zzk());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getZIndex() {
        try {
            return this.f21292a.getZIndex();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int hashCode() {
        try {
            return this.f21292a.zzj();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isClickable() {
        try {
            return this.f21292a.isClickable();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isVisible() {
        try {
            return this.f21292a.isVisible();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void remove() {
        try {
            this.f21292a.remove();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setCenter(LatLng latLng) {
        try {
            this.f21292a.setCenter(latLng);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setClickable(boolean z3) {
        try {
            this.f21292a.setClickable(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setFillColor(int i4) {
        try {
            this.f21292a.setFillColor(i4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setRadius(double d4) {
        try {
            this.f21292a.setRadius(d4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setStrokeColor(int i4) {
        try {
            this.f21292a.setStrokeColor(i4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setStrokePattern(@Nullable List<PatternItem> list) {
        try {
            this.f21292a.setStrokePattern(list);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setStrokeWidth(float f4) {
        try {
            this.f21292a.setStrokeWidth(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTag(@Nullable Object obj) {
        try {
            this.f21292a.zze(ObjectWrapper.wrap(obj));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setVisible(boolean z3) {
        try {
            this.f21292a.setVisible(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setZIndex(float f4) {
        try {
            this.f21292a.setZIndex(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
