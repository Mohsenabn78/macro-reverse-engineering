package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class IndoorLevel {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzq f21318a;

    public IndoorLevel(com.google.android.gms.internal.maps.zzq zzqVar) {
        this.f21318a = (com.google.android.gms.internal.maps.zzq) Preconditions.checkNotNull(zzqVar);
    }

    public final void activate() {
        try {
            this.f21318a.activate();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.f21318a.zzb(((IndoorLevel) obj).f21318a);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @NonNull
    public final String getName() {
        try {
            return this.f21318a.getName();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @NonNull
    public final String getShortName() {
        try {
            return this.f21318a.getShortName();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int hashCode() {
        try {
            return this.f21318a.zzj();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
