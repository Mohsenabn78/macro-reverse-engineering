package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.arlosoft.macrodroid.common.Util;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeap {
    private final zzawz zza;
    private final Context zzb;
    private final zzdzt zzc;
    private final zzbzx zzd;
    private final String zze;
    private final zzfev zzf;
    private final com.google.android.gms.ads.internal.util.zzg zzg = com.google.android.gms.ads.internal.zzt.zzo().zzh();

    public zzeap(Context context, zzbzx zzbzxVar, zzawz zzawzVar, zzdzt zzdztVar, String str, zzfev zzfevVar) {
        this.zzb = context;
        this.zzd = zzbzxVar;
        this.zza = zzawzVar;
        this.zzc = zzdztVar;
        this.zze = str;
        this.zzf = zzfevVar;
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList arrayList) {
        int size = arrayList.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            zzazi zzaziVar = (zzazi) arrayList.get(i4);
            if (zzaziVar.zzw() == 2 && zzaziVar.zze() > j4) {
                j4 = zzaziVar.zze();
            }
        }
        if (j4 != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j4));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z3, SQLiteDatabase sQLiteDatabase) throws Exception {
        String str;
        String str2;
        String str3;
        if (z3) {
            this.zzb.deleteDatabase("OfflineUpload.db");
            return null;
        }
        int i4 = 2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            zzfeu zzb = zzfeu.zzb("oa_upload");
            zzb.zza("oa_failed_reqs", String.valueOf(zzeai.zza(sQLiteDatabase, 0)));
            zzb.zza("oa_total_reqs", String.valueOf(zzeai.zza(sQLiteDatabase, 1)));
            zzb.zza("oa_upload_time", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzb.zza("oa_last_successful_time", String.valueOf(zzeai.zzb(sQLiteDatabase, 2)));
            if (this.zzg.zzP()) {
                str = "";
            } else {
                str = this.zze;
            }
            zzb.zza("oa_session_id", str);
            this.zzf.zzb(zzb);
            ArrayList zzc = zzeai.zzc(sQLiteDatabase);
            zzc(sQLiteDatabase, zzc);
            int size = zzc.size();
            for (int i5 = 0; i5 < size; i5++) {
                zzazi zzaziVar = (zzazi) zzc.get(i5);
                zzfeu zzb2 = zzfeu.zzb("oa_signals");
                if (this.zzg.zzP()) {
                    str2 = "";
                } else {
                    str2 = this.zze;
                }
                zzb2.zza("oa_session_id", str2);
                zzazd zzf = zzaziVar.zzf();
                if (zzf.zzf()) {
                    str3 = String.valueOf(zzf.zzh() - 1);
                } else {
                    str3 = Util.ANY_CONTACT_ID;
                }
                String obj = zzfsq.zzb(zzaziVar.zzk(), new zzfov() { // from class: com.google.android.gms.internal.ads.zzeao
                    @Override // com.google.android.gms.internal.ads.zzfov
                    public final Object apply(Object obj2) {
                        return ((zzaxx) obj2).name();
                    }
                }).toString();
                zzb2.zza("oa_sig_ts", String.valueOf(zzaziVar.zze()));
                zzb2.zza("oa_sig_status", String.valueOf(zzaziVar.zzw() - 1));
                zzb2.zza("oa_sig_resp_lat", String.valueOf(zzaziVar.zzd()));
                zzb2.zza("oa_sig_render_lat", String.valueOf(zzaziVar.zzc()));
                zzb2.zza("oa_sig_formats", obj);
                zzb2.zza("oa_sig_nw_type", str3);
                zzb2.zza("oa_sig_wifi", String.valueOf(zzaziVar.zzx() - 1));
                zzb2.zza("oa_sig_airplane", String.valueOf(zzaziVar.zzt() - 1));
                zzb2.zza("oa_sig_data", String.valueOf(zzaziVar.zzu() - 1));
                zzb2.zza("oa_sig_nw_resp", String.valueOf(zzaziVar.zza()));
                zzb2.zza("oa_sig_offline", String.valueOf(zzaziVar.zzv() - 1));
                zzb2.zza("oa_sig_nw_state", String.valueOf(zzaziVar.zzj().zza()));
                if (zzf.zze() && zzf.zzf() && zzf.zzh() == 2) {
                    zzb2.zza("oa_sig_cell_type", String.valueOf(zzf.zzg() - 1));
                }
                this.zzf.zzb(zzb2);
            }
        } else {
            ArrayList zzc2 = zzeai.zzc(sQLiteDatabase);
            zzazj zza = zzazn.zza();
            zza.zzb(this.zzb.getPackageName());
            zza.zzd(Build.MODEL);
            zza.zze(zzeai.zza(sQLiteDatabase, 0));
            zza.zza(zzc2);
            zza.zzg(zzeai.zza(sQLiteDatabase, 1));
            zza.zzc(zzeai.zza(sQLiteDatabase, 3));
            zza.zzh(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
            zza.zzf(zzeai.zzb(sQLiteDatabase, 2));
            final zzazn zzaznVar = (zzazn) zza.zzal();
            zzc(sQLiteDatabase, zzc2);
            this.zza.zzb(new zzawy() { // from class: com.google.android.gms.internal.ads.zzeam
                @Override // com.google.android.gms.internal.ads.zzawy
                public final void zza(zzayo zzayoVar) {
                    zzayoVar.zzi(zzazn.this);
                }
            });
            zzazy zza2 = zzazz.zza();
            zza2.zza(this.zzd.zzb);
            zza2.zzc(this.zzd.zzc);
            if (true == this.zzd.zzd) {
                i4 = 0;
            }
            zza2.zzb(i4);
            final zzazz zzazzVar = (zzazz) zza2.zzal();
            this.zza.zzb(new zzawy() { // from class: com.google.android.gms.internal.ads.zzean
                @Override // com.google.android.gms.internal.ads.zzawy
                public final void zza(zzayo zzayoVar) {
                    zzazz zzazzVar2 = zzazz.this;
                    zzayg zzaygVar = (zzayg) zzayoVar.zzb().zzaB();
                    zzaygVar.zzb(zzazzVar2);
                    zzayoVar.zzg(zzaygVar);
                }
            });
            this.zza.zzc(SamsungIrisUnlockModule.IRIS_ACQUIRED_CAPTURE_IRIS_LEAVE);
        }
        zzeai.zzf(sQLiteDatabase);
        return null;
    }

    public final void zzb(final boolean z3) {
        try {
            this.zzc.zza(new zzfdo() { // from class: com.google.android.gms.internal.ads.zzeal
                @Override // com.google.android.gms.internal.ads.zzfdo
                public final Object zza(Object obj) {
                    zzeap.this.zza(z3, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e4) {
            zzbzr.zzg("Error in offline signals database startup: ".concat(String.valueOf(e4.getMessage())));
        }
    }
}
