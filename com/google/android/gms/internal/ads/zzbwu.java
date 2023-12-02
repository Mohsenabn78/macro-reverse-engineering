package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.arlosoft.macrodroid.common.Util;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbwu implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzbxw zzd;
    private String zze = Util.ANY_CONTACT_ID;
    private int zzf = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbwu(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbxw zzbxwVar) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzgVar;
        this.zza = context;
        this.zzd = zzbxwVar;
    }

    private final void zzb(String str, int i4) {
        Context context;
        boolean z3 = false;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaw)).booleanValue() ? str.isEmpty() || str.charAt(0) != '1' : i4 == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals(Util.ANY_CONTACT_ID))) {
            z3 = true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzau)).booleanValue()) {
            this.zzc.zzH(z3);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && z3 && (context = this.zza) != null) {
                context.deleteDatabase("OfflineUpload.db");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzap)).booleanValue()) {
            this.zzd.zzt();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        char c4;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzay)).booleanValue()) {
            if (zzbwt.zza(str, "gad_has_consent_for_cookies")) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaw)).booleanValue()) {
                    return;
                }
                int i4 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
                if (i4 != this.zzc.zzb()) {
                    this.zzc.zzH(true);
                }
                this.zzc.zzE(i4);
                return;
            } else if (zzbwt.zza(str, "IABTCF_gdprApplies") || zzbwt.zza(str, "IABTCF_TCString") || zzbwt.zza(str, "IABTCF_PurposeConsents")) {
                String string = sharedPreferences.getString(str, Util.ANY_CONTACT_ID);
                if (string != null && !string.equals(this.zzc.zzn(str))) {
                    this.zzc.zzH(true);
                }
                this.zzc.zzF(str, string);
                return;
            } else {
                return;
            }
        }
        String string2 = sharedPreferences.getString("IABTCF_PurposeConsents", Util.ANY_CONTACT_ID);
        int i5 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
        String valueOf = String.valueOf(str);
        int hashCode = valueOf.hashCode();
        if (hashCode != -2004976699) {
            if (hashCode == -527267622 && valueOf.equals("gad_has_consent_for_cookies")) {
                c4 = 1;
            }
            c4 = 65535;
        } else {
            if (valueOf.equals("IABTCF_PurposeConsents")) {
                c4 = 0;
            }
            c4 = 65535;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaw)).booleanValue() && i5 != -1 && this.zzf != i5) {
                this.zzf = i5;
                zzb(string2, i5);
            }
        } else if (!string2.equals(Util.ANY_CONTACT_ID) && !this.zze.equals(string2)) {
            this.zze = string2;
            zzb(string2, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzay)).booleanValue()) {
            onSharedPreferenceChanged(this.zzb, "IABTCF_gdprApplies");
            onSharedPreferenceChanged(this.zzb, "IABTCF_TCString");
            return;
        }
        onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
    }
}
