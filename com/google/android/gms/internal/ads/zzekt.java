package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.triggers.activities.LocationChooserActivity;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzekt implements zzeqx {
    final zzfai zza;
    private final long zzb;

    public zzekt(zzfai zzfaiVar, long j4) {
        Preconditions.checkNotNull(zzfaiVar, "the targeting must not be null");
        this.zza = zzfaiVar;
        this.zzb = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Bundle bundle = (Bundle) obj;
        com.google.android.gms.ads.internal.client.zzl zzlVar = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzlVar.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i4 = this.zza.zzo.zza;
        int i5 = i4 - 1;
        if (i4 != 0) {
            boolean z9 = true;
            if (i5 != 1) {
                if (i5 == 2) {
                    bundle.putBoolean("is_rewarded_interstitial", true);
                }
            } else {
                bundle.putBoolean("is_new_rewarded", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            String format = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzlVar.zzb));
            if (zzlVar.zzb != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzfat.zzf(bundle, "cust_age", format, z3);
            zzfat.zzb(bundle, "extras", zzlVar.zzc);
            int i6 = zzlVar.zzd;
            if (i6 != -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            zzfat.zze(bundle, "cust_gender", i6, z4);
            zzfat.zzd(bundle, "kw", zzlVar.zze);
            int i7 = zzlVar.zzg;
            if (i7 != -1) {
                z5 = true;
            } else {
                z5 = false;
            }
            zzfat.zze(bundle, "tag_for_child_directed_treatment", i7, z5);
            if (zzlVar.zzf) {
                bundle.putBoolean("test_request", true);
            }
            if (zzlVar.zza >= 2 && zzlVar.zzh) {
                z6 = true;
            } else {
                z6 = false;
            }
            zzfat.zze(bundle, "d_imp_hdr", 1, z6);
            String str = zzlVar.zzi;
            if (zzlVar.zza >= 2 && !TextUtils.isEmpty(str)) {
                z7 = true;
            } else {
                z7 = false;
            }
            zzfat.zzf(bundle, "ppid", str, z7);
            Location location = zzlVar.zzk;
            if (location != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", location.getAccuracy() * 1000.0f);
                bundle2.putLong(LocationChooserActivity.EXTRA_LAT, (long) (location.getLatitude() * 1.0E7d));
                bundle2.putLong(HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_LONG, (long) (1.0E7d * location.getLongitude()));
                bundle2.putLong("time", location.getTime() * 1000);
                bundle.putBundle("uule", bundle2);
            }
            zzfat.zzc(bundle, ImagesContract.URL, zzlVar.zzl);
            zzfat.zzd(bundle, "neighboring_content_urls", zzlVar.zzv);
            zzfat.zzb(bundle, "custom_targeting", zzlVar.zzn);
            zzfat.zzd(bundle, "category_exclusions", zzlVar.zzo);
            zzfat.zzc(bundle, "request_agent", zzlVar.zzp);
            zzfat.zzc(bundle, "request_pkg", zzlVar.zzq);
            boolean z10 = zzlVar.zzr;
            if (zzlVar.zza >= 7) {
                z8 = true;
            } else {
                z8 = false;
            }
            zzfat.zzg(bundle, "is_designed_for_families", z10, z8);
            if (zzlVar.zza >= 8) {
                int i8 = zzlVar.zzt;
                if (i8 == -1) {
                    z9 = false;
                }
                zzfat.zze(bundle, "tag_for_under_age_of_consent", i8, z9);
                zzfat.zzc(bundle, "max_ad_content_rating", zzlVar.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
