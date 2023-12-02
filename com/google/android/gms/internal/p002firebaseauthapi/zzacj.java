package com.google.android.gms.internal.p002firebaseauthapi;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.HashMap;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacj  reason: invalid package */
/* loaded from: classes4.dex */
final class zzacj extends zzaaq {
    final /* synthetic */ zzacm zza;
    private final String zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzacj(zzacm zzacmVar, zzaaq zzaaqVar, String str) {
        super(zzaaqVar);
        this.zza = zzacmVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaaq
    public final void zzb(String str) {
        Logger logger;
        HashMap hashMap;
        logger = zzacm.zza;
        logger.d("onCodeSent", new Object[0]);
        hashMap = this.zza.zzd;
        zzacl zzaclVar = (zzacl) hashMap.get(this.zzb);
        if (zzaclVar == null) {
            return;
        }
        for (zzaaq zzaaqVar : zzaclVar.zzb) {
            zzaaqVar.zzb(str);
        }
        zzaclVar.zzg = true;
        zzaclVar.zzd = str;
        if (zzaclVar.zza <= 0) {
            this.zza.zzg(this.zzb);
        } else if (!zzaclVar.zzc) {
            this.zza.zzm(this.zzb);
        } else if (!zzac.zzd(zzaclVar.zze)) {
            zzacm.zzd(this.zza, this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaaq
    public final void zzh(Status status) {
        Logger logger;
        HashMap hashMap;
        logger = zzacm.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        String statusMessage = status.getStatusMessage();
        logger.e("SMS verification code request failed: " + statusCodeString + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + statusMessage, new Object[0]);
        hashMap = this.zza.zzd;
        zzacl zzaclVar = (zzacl) hashMap.get(this.zzb);
        if (zzaclVar == null) {
            return;
        }
        for (zzaaq zzaaqVar : zzaclVar.zzb) {
            zzaaqVar.zzh(status);
        }
        this.zza.zzi(this.zzb);
    }
}
