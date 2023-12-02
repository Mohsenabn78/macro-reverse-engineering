package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzex extends BroadcastReceiver {
    final /* synthetic */ zzey zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzex(zzey zzeyVar, zzew zzewVar) {
        this.zza = zzeyVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Executor mainExecutor;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i4 = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 4 && type != 5) {
                                if (type != 6) {
                                    i4 = type != 9 ? 8 : 7;
                                }
                                i4 = 5;
                            }
                        }
                        i4 = 2;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                            i4 = 3;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            i4 = 4;
                            break;
                        case 13:
                            i4 = 5;
                            break;
                        case 16:
                        case 19:
                        default:
                            i4 = 6;
                            break;
                        case 18:
                            i4 = 2;
                            break;
                        case 20:
                            if (zzfj.zza >= 29) {
                                i4 = 9;
                                break;
                            }
                            break;
                    }
                } else {
                    i4 = 1;
                }
            } catch (SecurityException unused) {
            }
        }
        if (zzfj.zza >= 31 && i4 == 5) {
            zzey zzeyVar = this.zza;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                telephonyManager.getClass();
                zzev zzevVar = new zzev(zzeyVar);
                mainExecutor = context.getMainExecutor();
                telephonyManager.registerTelephonyCallback(mainExecutor, zzevVar);
                telephonyManager.unregisterTelephonyCallback(zzevVar);
                return;
            } catch (RuntimeException unused2) {
                zzey.zzc(zzeyVar, 5);
                return;
            }
        }
        zzey.zzc(this.zza, i4);
    }
}
