package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdk implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzcdl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdk(zzcdl zzcdlVar, String str, String str2, String str3, String str4) {
        this.zze = zzcdlVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.lang.Runnable
    public final void run() {
        char c4;
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            hashMap.put("cachedSrc", this.zzb);
        }
        String str = this.zzc;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c4 = 11;
                    break;
                }
                c4 = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 96784904:
                if (str.equals(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        String str2 = "internal";
        switch (c4) {
            case 6:
            case 7:
                str2 = "io";
                break;
            case '\b':
            case '\t':
                str2 = "network";
                break;
            case '\n':
            case 11:
                str2 = "policy";
                break;
        }
        hashMap.put("type", str2);
        hashMap.put("reason", this.zzc);
        if (!TextUtils.isEmpty(this.zzd)) {
            hashMap.put("message", this.zzd);
        }
        zzcdl.zze(this.zze, "onPrecacheEvent", hashMap);
    }
}
