package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzjy implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f21968a;

    /* renamed from: b  reason: collision with root package name */
    private volatile zzep f21969b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzjz f21970c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjy(zzjz zzjzVar) {
        this.f21970c = zzjzVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.f21969b);
                this.f21970c.f21734a.zzaB().zzp(new zzjv(this, (zzej) this.f21969b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f21969b = null;
                this.f21968a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzet zzl = this.f21970c.f21734a.zzl();
        if (zzl != null) {
            zzl.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f21968a = false;
            this.f21969b = null;
        }
        this.f21970c.f21734a.zzaB().zzp(new zzjx(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnectionSuspended(int i4) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.f21970c.f21734a.zzaA().zzc().zza("Service connection suspended");
        this.f21970c.f21734a.zzaB().zzp(new zzjw(this));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzjy zzjyVar;
        zzej zzehVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f21968a = false;
                this.f21970c.f21734a.zzaA().zzd().zza("Service connected with null binder");
                return;
            }
            zzej zzejVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof zzej) {
                        zzehVar = (zzej) queryLocalInterface;
                    } else {
                        zzehVar = new zzeh(iBinder);
                    }
                    zzejVar = zzehVar;
                    this.f21970c.f21734a.zzaA().zzj().zza("Bound to IMeasurementService interface");
                } else {
                    this.f21970c.f21734a.zzaA().zzd().zzb("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f21970c.f21734a.zzaA().zzd().zza("Service connect failed to get IMeasurementService");
            }
            if (zzejVar == null) {
                this.f21968a = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    Context zzaw = this.f21970c.f21734a.zzaw();
                    zzjyVar = this.f21970c.f21971c;
                    connectionTracker.unbindService(zzaw, zzjyVar);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f21970c.f21734a.zzaB().zzp(new zzjt(this, zzejVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.f21970c.f21734a.zzaA().zzc().zza("Service disconnected");
        this.f21970c.f21734a.zzaB().zzp(new zzju(this, componentName));
    }

    @WorkerThread
    public final void zzb(Intent intent) {
        zzjy zzjyVar;
        this.f21970c.zzg();
        Context zzaw = this.f21970c.f21734a.zzaw();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.f21968a) {
                this.f21970c.f21734a.zzaA().zzj().zza("Connection attempt already in progress");
                return;
            }
            this.f21970c.f21734a.zzaA().zzj().zza("Using local app measurement service");
            this.f21968a = true;
            zzjyVar = this.f21970c.f21971c;
            connectionTracker.bindService(zzaw, intent, zzjyVar, 129);
        }
    }

    @WorkerThread
    public final void zzc() {
        this.f21970c.zzg();
        Context zzaw = this.f21970c.f21734a.zzaw();
        synchronized (this) {
            if (this.f21968a) {
                this.f21970c.f21734a.zzaA().zzj().zza("Connection attempt already in progress");
            } else if (this.f21969b != null && (this.f21969b.isConnecting() || this.f21969b.isConnected())) {
                this.f21970c.f21734a.zzaA().zzj().zza("Already awaiting connection attempt");
            } else {
                this.f21969b = new zzep(zzaw, Looper.getMainLooper(), this, this);
                this.f21970c.f21734a.zzaA().zzj().zza("Connecting to remote service");
                this.f21968a = true;
                Preconditions.checkNotNull(this.f21969b);
                this.f21969b.checkAvailabilityAndConnect();
            }
        }
    }

    @WorkerThread
    public final void zzd() {
        if (this.f21969b != null && (this.f21969b.isConnected() || this.f21969b.isConnecting())) {
            this.f21969b.disconnect();
        }
        this.f21969b = null;
    }
}
