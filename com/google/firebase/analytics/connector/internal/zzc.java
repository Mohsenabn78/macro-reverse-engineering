package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzjb;
import com.google.android.gms.measurement.internal.zzhe;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.3.0 */
/* loaded from: classes5.dex */
public final class zzc {

    /* renamed from: a  reason: collision with root package name */
    private static final zzjb f28753a = zzjb.zzi("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* renamed from: b  reason: collision with root package name */
    private static final zzja f28754b = zzja.zzj("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c  reason: collision with root package name */
    private static final zzja f28755c = zzja.zzi(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "app", "am");

    /* renamed from: d  reason: collision with root package name */
    private static final zzja f28756d = zzja.zzh("_r", "_dbg");

    /* renamed from: e  reason: collision with root package name */
    private static final zzja f28757e;

    /* renamed from: f  reason: collision with root package name */
    private static final zzja f28758f;
    public static final /* synthetic */ int zza = 0;

    static {
        zzix zzixVar = new zzix();
        zzixVar.zza(zzhe.zza);
        zzixVar.zza(zzhe.zzb);
        f28757e = zzixVar.zzb();
        f28758f = zzja.zzh("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean zza(String str, String str2, Bundle bundle) {
        char c4;
        if (!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2)) {
            return true;
        }
        if (!zzd(str) || bundle == null) {
            return false;
        }
        zzja zzjaVar = f28756d;
        int size = zzjaVar.size();
        int i4 = 0;
        while (i4 < size) {
            boolean containsKey = bundle.containsKey((String) zzjaVar.get(i4));
            i4++;
            if (containsKey) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c4 = 2;
                }
                c4 = 65535;
            } else {
                if (str.equals("fdl")) {
                    c4 = 1;
                }
                c4 = 65535;
            }
        } else {
            if (str.equals("fcm")) {
                c4 = 0;
            }
            c4 = 65535;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 != 2) {
                    return false;
                }
                bundle.putString("_cis", "fiam_integration");
                return true;
            }
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        bundle.putString("_cis", "fcm_integration");
        return true;
    }

    public static boolean zzb(String str, Bundle bundle) {
        if (f28754b.contains(str)) {
            return false;
        }
        if (bundle != null) {
            zzja zzjaVar = f28756d;
            int size = zzjaVar.size();
            int i4 = 0;
            while (i4 < size) {
                boolean containsKey = bundle.containsKey((String) zzjaVar.get(i4));
                i4++;
                if (containsKey) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean zzc(String str) {
        if (!f28753a.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean zzd(String str) {
        if (!f28755c.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean zze(String str, String str2) {
        if (!"_ce1".equals(str2) && !"_ce2".equals(str2)) {
            if (Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION.equals(str2)) {
                if (str.equals("fcm") || str.equals("fiam")) {
                    return true;
                }
                return false;
            } else if (f28757e.contains(str2)) {
                return false;
            } else {
                zzja zzjaVar = f28758f;
                int size = zzjaVar.size();
                int i4 = 0;
                while (i4 < size) {
                    boolean matches = str2.matches((String) zzjaVar.get(i4));
                    i4++;
                    if (matches) {
                        return false;
                    }
                }
                return true;
            }
        } else if (str.equals("fcm") || str.equals(FirebaseABTesting.OriginService.REMOTE_CONFIG)) {
            return true;
        } else {
            return false;
        }
    }
}
