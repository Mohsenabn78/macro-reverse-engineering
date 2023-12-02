package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes4.dex */
final class zzi implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(zzj zzjVar, Task task) {
        this.zzb = zzjVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCompleteListener onCompleteListener;
        OnCompleteListener onCompleteListener2;
        obj = this.zzb.zzb;
        synchronized (obj) {
            zzj zzjVar = this.zzb;
            onCompleteListener = zzjVar.zzc;
            if (onCompleteListener != null) {
                onCompleteListener2 = zzjVar.zzc;
                onCompleteListener2.onComplete(this.zza);
            }
        }
    }
}
