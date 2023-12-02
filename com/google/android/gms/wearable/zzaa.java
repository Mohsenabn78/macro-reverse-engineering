package com.google.android.gms.wearable;

import android.content.ComponentName;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.internal.zzao;
import com.google.android.gms.wearable.internal.zzbf;
import com.google.android.gms.wearable.internal.zzev;
import com.google.android.gms.wearable.internal.zzez;
import com.google.android.gms.wearable.internal.zzfx;
import com.google.android.gms.wearable.internal.zzgm;
import com.google.android.gms.wearable.internal.zziu;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzaa extends zzez {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f22865a = -1;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ WearableListenerService f22866b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaa(WearableListenerService wearableListenerService, zzz zzzVar) {
        this.f22866b = wearableListenerService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void b(zzev zzevVar, Task task) {
        if (task.isSuccessful()) {
            d(zzevVar, true, (byte[]) task.getResult());
            return;
        }
        Log.e("WearableLS", "Failed to resolve future, sending null response", task.getException());
        d(zzevVar, false, null);
    }

    private final boolean c(Runnable runnable, String str, Object obj) {
        Object obj2;
        boolean z3;
        zzn zznVar;
        ComponentName componentName;
        if (Log.isLoggable("WearableLS", 3)) {
            componentName = this.f22866b.f22649a;
            String.format("%s: %s %s", str, componentName.toString(), obj);
        }
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f22865a) {
            if (zziu.zza(this.f22866b).zzb("com.google.android.wearable.app.cn") && UidVerifier.uidHasPackageName(this.f22866b, callingUid, "com.google.android.wearable.app.cn")) {
                this.f22865a = callingUid;
            } else if (UidVerifier.isGooglePlayServicesUid(this.f22866b, callingUid)) {
                this.f22865a = callingUid;
            } else {
                Log.e("WearableLS", "Caller is not GooglePlayServices; caller UID: " + callingUid);
                return false;
            }
        }
        obj2 = this.f22866b.f22654f;
        synchronized (obj2) {
            WearableListenerService wearableListenerService = this.f22866b;
            z3 = wearableListenerService.f22655g;
            if (!z3) {
                zznVar = wearableListenerService.f22650b;
                zznVar.post(runnable);
                return true;
            }
            return false;
        }
    }

    private static final void d(zzev zzevVar, boolean z3, byte[] bArr) {
        try {
            zzevVar.zzd(z3, bArr);
        } catch (RemoteException e4) {
            Log.e("WearableLS", "Failed to send a response back", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzfx zzfxVar, final zzev zzevVar) {
        Task<byte[]> onRequest = this.f22866b.onRequest(zzfxVar.getSourceNodeId(), zzfxVar.getPath(), zzfxVar.getData());
        if (onRequest == null) {
            d(zzevVar, false, null);
        } else {
            onRequest.addOnCompleteListener(new OnCompleteListener(zzevVar, null) { // from class: com.google.android.gms.wearable.zzo
                public final /* synthetic */ zzev zzb;

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzaa.b(this.zzb, task);
                }
            });
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzb(zzbf zzbfVar) {
        c(new zzy(this, zzbfVar), "onChannelEvent", zzbfVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzc(zzao zzaoVar) {
        c(new zzv(this, zzaoVar), "onConnectedCapabilityChanged", zzaoVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzd(List list) {
        c(new zzu(this, list), "onConnectedNodes", list);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zze(DataHolder dataHolder) {
        zzq zzqVar = new zzq(this, dataHolder);
        try {
            String valueOf = String.valueOf(dataHolder);
            int count = dataHolder.getCount();
            if (!c(zzqVar, "onDataItemChanged", valueOf + ", rows=" + count)) {
            }
        } finally {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzf(com.google.android.gms.wearable.internal.zzi zziVar) {
        c(new zzx(this, zziVar), "onEntityUpdate", zziVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzg(zzfx zzfxVar) {
        c(new zzr(this, zzfxVar), "onMessageReceived", zzfxVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzh(com.google.android.gms.wearable.internal.zzl zzlVar) {
        c(new zzw(this, zzlVar), "onNotificationReceived", zzlVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzi(zzgm zzgmVar) {
        c(new zzs(this, zzgmVar), "onPeerConnected", zzgmVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzj(zzgm zzgmVar) {
        c(new zzt(this, zzgmVar), "onPeerDisconnected", zzgmVar);
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzl(final zzfx zzfxVar, final zzev zzevVar) {
        c(new Runnable(zzfxVar, zzevVar, null) { // from class: com.google.android.gms.wearable.zzp
            public final /* synthetic */ zzfx zzb;
            public final /* synthetic */ zzev zzc;

            @Override // java.lang.Runnable
            public final void run() {
                zzaa.this.a(this.zzb, this.zzc);
            }
        }, "onRequestReceived", zzfxVar);
    }
}
