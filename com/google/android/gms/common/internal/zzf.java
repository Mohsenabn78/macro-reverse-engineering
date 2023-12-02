package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzf extends zza {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20562e;
    @Nullable
    public final IBinder zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzf(BaseGmsClient baseGmsClient, @Nullable int i4, @Nullable IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i4, bundle);
        this.f20562e = baseGmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final void c(ConnectionResult connectionResult) {
        if (this.f20562e.zzx != null) {
            this.f20562e.zzx.onConnectionFailed(connectionResult);
        }
        this.f20562e.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final boolean d() {
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks;
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks2;
        try {
            IBinder iBinder = this.zze;
            Preconditions.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f20562e.getServiceDescriptor().equals(interfaceDescriptor)) {
                String serviceDescriptor = this.f20562e.getServiceDescriptor();
                Log.w("GmsClient", "service descriptor mismatch: " + serviceDescriptor + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface createServiceInterface = this.f20562e.createServiceInterface(this.zze);
            if (createServiceInterface != null && (BaseGmsClient.zzn(this.f20562e, 2, 4, createServiceInterface) || BaseGmsClient.zzn(this.f20562e, 3, 4, createServiceInterface))) {
                this.f20562e.zzB = null;
                Bundle connectionHint = this.f20562e.getConnectionHint();
                BaseGmsClient baseGmsClient = this.f20562e;
                baseConnectionCallbacks = baseGmsClient.zzw;
                if (baseConnectionCallbacks != null) {
                    baseConnectionCallbacks2 = baseGmsClient.zzw;
                    baseConnectionCallbacks2.onConnected(connectionHint);
                    return true;
                }
                return true;
            }
            return false;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
