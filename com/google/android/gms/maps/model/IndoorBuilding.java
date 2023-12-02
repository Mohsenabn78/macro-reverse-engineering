package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.implementation.MethodDelegation;

/* loaded from: classes4.dex */
public final class IndoorBuilding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzn f21315a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final zza f21316b;

    @VisibleForTesting
    /* loaded from: classes4.dex */
    static class zza {

        /* renamed from: a  reason: collision with root package name */
        public static final zza f21317a = new zza();

        private zza() {
        }

        @NonNull
        public static com.google.android.gms.internal.maps.zzq a(IBinder iBinder) {
            return com.google.android.gms.internal.maps.zzr.zzf(iBinder);
        }

        @NonNull
        public static IndoorLevel b(@NonNull com.google.android.gms.internal.maps.zzq zzqVar) {
            return new IndoorLevel(zzqVar);
        }
    }

    public IndoorBuilding(@NonNull com.google.android.gms.internal.maps.zzn zznVar) {
        this(zznVar, zza.f21317a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.f21315a.zzb(((IndoorBuilding) obj).f21315a);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getActiveLevelIndex() {
        try {
            return this.f21315a.getActiveLevelIndex();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getDefaultLevelIndex() {
        try {
            return this.f21315a.getDefaultLevelIndex();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.f21315a.getLevels();
            ArrayList arrayList = new ArrayList(levels.size());
            for (IBinder iBinder : levels) {
                arrayList.add(zza.b(zza.a(iBinder)));
            }
            return arrayList;
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int hashCode() {
        try {
            return this.f21315a.zzj();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isUnderground() {
        try {
            return this.f21315a.isUnderground();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @VisibleForTesting
    private IndoorBuilding(@NonNull com.google.android.gms.internal.maps.zzn zznVar, @NonNull zza zzaVar) {
        this.f21315a = (com.google.android.gms.internal.maps.zzn) Preconditions.checkNotNull(zznVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f21316b = (zza) Preconditions.checkNotNull(zzaVar, "shim");
    }
}
