package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzq implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzr f20581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzq(zzr zzrVar, zzp zzpVar) {
        this.f20581a = zzrVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i4 = message.what;
        if (i4 == 0) {
            hashMap = this.f20581a.f20582f;
            synchronized (hashMap) {
                zzn zznVar = (zzn) message.obj;
                hashMap2 = this.f20581a.f20582f;
                zzo zzoVar = (zzo) hashMap2.get(zznVar);
                if (zzoVar != null && zzoVar.i()) {
                    if (zzoVar.j()) {
                        zzoVar.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.f20581a.f20582f;
                    hashMap3.remove(zznVar);
                }
            }
            return true;
        } else if (i4 == 1) {
            hashMap4 = this.f20581a.f20582f;
            synchronized (hashMap4) {
                zzn zznVar2 = (zzn) message.obj;
                hashMap5 = this.f20581a.f20582f;
                zzo zzoVar2 = (zzo) hashMap5.get(zznVar2);
                if (zzoVar2 != null && zzoVar2.a() == 3) {
                    String valueOf = String.valueOf(zznVar2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                    ComponentName b4 = zzoVar2.b();
                    if (b4 == null) {
                        b4 = zznVar2.zzb();
                    }
                    if (b4 == null) {
                        String zzd = zznVar2.zzd();
                        Preconditions.checkNotNull(zzd);
                        b4 = new ComponentName(zzd, EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    zzoVar2.onServiceDisconnected(b4);
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
