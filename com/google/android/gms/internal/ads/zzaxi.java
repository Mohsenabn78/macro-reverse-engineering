package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaxi implements zzgpq {
    static final zzgpq zza = new zzaxi();

    private zzaxi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgpq
    public final boolean zza(int i4) {
        zzaxj zzaxjVar;
        zzaxj zzaxjVar2 = zzaxj.AD_INITIATER_UNSPECIFIED;
        switch (i4) {
            case 0:
                zzaxjVar = zzaxj.AD_INITIATER_UNSPECIFIED;
                break;
            case 1:
                zzaxjVar = zzaxj.BANNER;
                break;
            case 2:
                zzaxjVar = zzaxj.DFP_BANNER;
                break;
            case 3:
                zzaxjVar = zzaxj.INTERSTITIAL;
                break;
            case 4:
                zzaxjVar = zzaxj.DFP_INTERSTITIAL;
                break;
            case 5:
                zzaxjVar = zzaxj.NATIVE_EXPRESS;
                break;
            case 6:
                zzaxjVar = zzaxj.AD_LOADER;
                break;
            case 7:
                zzaxjVar = zzaxj.REWARD_BASED_VIDEO_AD;
                break;
            case 8:
                zzaxjVar = zzaxj.BANNER_SEARCH_ADS;
                break;
            case 9:
                zzaxjVar = zzaxj.GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                break;
            case 10:
                zzaxjVar = zzaxj.APP_OPEN;
                break;
            case 11:
                zzaxjVar = zzaxj.REWARDED_INTERSTITIAL;
                break;
            default:
                zzaxjVar = null;
                break;
        }
        if (zzaxjVar != null) {
            return true;
        }
        return false;
    }
}
