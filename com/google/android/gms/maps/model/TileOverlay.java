package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzac;

/* loaded from: classes4.dex */
public final class TileOverlay {

    /* renamed from: a  reason: collision with root package name */
    private final zzac f21368a;

    public TileOverlay(zzac zzacVar) {
        this.f21368a = (zzac) Preconditions.checkNotNull(zzacVar);
    }

    public final void clearTileCache() {
        try {
            this.f21368a.clearTileCache();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.f21368a.zza(((TileOverlay) obj).f21368a);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean getFadeIn() {
        try {
            return this.f21368a.getFadeIn();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final String getId() {
        try {
            return this.f21368a.getId();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getTransparency() {
        try {
            return this.f21368a.getTransparency();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getZIndex() {
        try {
            return this.f21368a.getZIndex();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int hashCode() {
        try {
            return this.f21368a.zzj();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isVisible() {
        try {
            return this.f21368a.isVisible();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void remove() {
        try {
            this.f21368a.remove();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setFadeIn(boolean z3) {
        try {
            this.f21368a.setFadeIn(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTransparency(float f4) {
        try {
            this.f21368a.setTransparency(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setVisible(boolean z3) {
        try {
            this.f21368a.setVisible(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setZIndex(float f4) {
        try {
            this.f21368a.setZIndex(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
