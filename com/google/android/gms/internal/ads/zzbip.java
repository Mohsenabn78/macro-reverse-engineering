package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbip implements zzbij {
    static final Map zza = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zzb zzb;
    private final zzbqq zzc;
    private final zzbqx zzd;

    public zzbip(com.google.android.gms.ads.internal.zzb zzbVar, zzbqq zzbqqVar, zzbqx zzbqxVar) {
        this.zzb = zzbVar;
        this.zzc = zzbqqVar;
        this.zzd = zzbqxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        int intValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i4 = 6;
        boolean z3 = true;
        if (intValue != 5) {
            if (intValue != 7) {
                if (this.zzb.zzc()) {
                    if (intValue != 1) {
                        if (intValue != 3) {
                            if (intValue != 4) {
                                if (intValue != 5) {
                                    if (intValue != 6) {
                                        if (intValue != 7) {
                                            zzbzr.zzi("Unknown MRAID command called.");
                                            return;
                                        }
                                    } else {
                                        this.zzc.zza(true);
                                        return;
                                    }
                                }
                            } else {
                                new zzbqo(zzcezVar, map).zzc();
                                return;
                            }
                        } else {
                            new zzbqt(zzcezVar, map).zzb();
                            return;
                        }
                    } else {
                        this.zzc.zzb(map);
                        return;
                    }
                } else {
                    this.zzb.zzb(null);
                    return;
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            z3 = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        }
        if (zzcezVar == null) {
            zzbzr.zzj("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i4 = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            if (z3) {
                i4 = -1;
            } else {
                i4 = 14;
            }
        }
        zzcezVar.zzaq(i4);
    }
}
