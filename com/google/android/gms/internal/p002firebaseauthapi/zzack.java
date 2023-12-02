package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzack extends BroadcastReceiver {
    final /* synthetic */ zzacm zza;
    private final String zzb;

    public zzack(zzacm zzacmVar, String str) {
        this.zza = zzacmVar;
        this.zzb = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        HashMap hashMap;
        String str;
        Logger logger;
        Logger logger2;
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str2 = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                hashMap = this.zza.zzd;
                zzacl zzaclVar = (zzacl) hashMap.get(this.zzb);
                if (zzaclVar == null) {
                    logger2 = zzacm.zza;
                    logger2.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
                    if (matcher.find()) {
                        str = matcher.group();
                    } else {
                        str = null;
                    }
                    zzaclVar.zze = str;
                    if (str == null) {
                        logger = zzacm.zza;
                        logger.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzac.zzd(zzaclVar.zzd)) {
                        zzacm.zzd(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
