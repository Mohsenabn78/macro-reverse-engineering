package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzefh implements zzecc {
    private static Bundle zzd(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        return new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final zzfwm zza(zzezz zzezzVar, zzezn zzeznVar) {
        String optString = zzeznVar.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfai zzfaiVar = zzezzVar.zza.zza;
        zzfag zzfagVar = new zzfag();
        zzfagVar.zzp(zzfaiVar);
        zzfagVar.zzs(optString);
        Bundle zzd = zzd(zzfaiVar.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzeznVar.zzw.optString("mad_hac", null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzeznVar.zzw.optString("adJson", null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzeznVar.zzE.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzeznVar.zzE.optString(next, null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzfaiVar.zzd;
        zzfagVar.zzE(new com.google.android.gms.ads.internal.client.zzl(zzlVar.zza, zzlVar.zzb, zzd2, zzlVar.zzd, zzlVar.zze, zzlVar.zzf, zzlVar.zzg, zzlVar.zzh, zzlVar.zzi, zzlVar.zzj, zzlVar.zzk, zzlVar.zzl, zzd, zzlVar.zzn, zzlVar.zzo, zzlVar.zzp, zzlVar.zzq, zzlVar.zzr, zzlVar.zzs, zzlVar.zzt, zzlVar.zzu, zzlVar.zzv, zzlVar.zzw, zzlVar.zzx));
        zzfai zzG = zzfagVar.zzG();
        Bundle bundle = new Bundle();
        zzezq zzezqVar = zzezzVar.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzezqVar.zza));
        bundle2.putInt("refresh_interval", zzezqVar.zzc);
        bundle2.putString("gws_query_id", zzezqVar.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzezzVar.zza.zza.zzf;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzeznVar.zzx);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzeznVar.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzeznVar.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzeznVar.zzq));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzeznVar.zzn));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzeznVar.zzh));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzeznVar.zzi));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzeznVar.zzj));
        bundle3.putString("transaction_id", zzeznVar.zzk);
        bundle3.putString("valid_from_timestamp", zzeznVar.zzl);
        bundle3.putBoolean("is_closable_area_disabled", zzeznVar.zzQ);
        bundle3.putString("recursive_server_response_data", zzeznVar.zzap);
        if (zzeznVar.zzm != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzeznVar.zzm.zzb);
            bundle4.putString("rb_type", zzeznVar.zzm.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzG, bundle, zzeznVar, zzezzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final boolean zzb(zzezz zzezzVar, zzezn zzeznVar) {
        if (!TextUtils.isEmpty(zzeznVar.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""))) {
            return true;
        }
        return false;
    }

    protected abstract zzfwm zzc(zzfai zzfaiVar, Bundle bundle, zzezn zzeznVar, zzezz zzezzVar);
}
