package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzaxj;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzae {

    /* renamed from: a  reason: collision with root package name */
    private final String f19540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzae(zzac zzacVar, zzad zzadVar) {
        String str;
        str = zzacVar.f19539a;
        this.f19540a = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final zzaxj zza() {
        char c4;
        String str = this.f19540a;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 != 2) {
                    if (c4 != 3) {
                        return zzaxj.AD_INITIATER_UNSPECIFIED;
                    }
                    return zzaxj.REWARD_BASED_VIDEO_AD;
                }
                return zzaxj.AD_LOADER;
            }
            return zzaxj.INTERSTITIAL;
        }
        return zzaxj.BANNER;
    }

    public final String zzb() {
        return this.f19540a.toLowerCase(Locale.ROOT);
    }

    public final Set zzc() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.f19540a.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
