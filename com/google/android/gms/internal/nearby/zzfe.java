package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzfe implements OnFailureListener {
    final /* synthetic */ GoogleApi zza;
    final /* synthetic */ ListenerHolder.ListenerKey zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzfg zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfe(zzfg zzfgVar, GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, boolean z3) {
        this.zzd = zzfgVar;
        this.zza = googleApi;
        this.zzb = listenerKey;
        this.zzc = z3;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        int statusCode;
        Set set;
        synchronized (this.zzd) {
            if ((exc instanceof ApiException) && ((statusCode = ((ApiException) exc).getStatusCode()) == 8001 || statusCode == 8002)) {
                if (this.zzc) {
                    set = this.zzd.zzc;
                    set.remove(this.zzb);
                }
            }
            this.zzd.zzg(this.zza, this.zzb);
        }
    }
}
