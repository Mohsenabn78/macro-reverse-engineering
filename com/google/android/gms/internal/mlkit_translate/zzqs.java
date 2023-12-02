package com.google.android.gms.internal.mlkit_translate;

import android.util.Log;
import java.net.HttpURLConnection;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqs implements zzrc {
    final /* synthetic */ zzqt zza;
    private final String zzb;
    private final Date zzc;
    private final zzox zzd;
    private zzy zze;
    private zzqk zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqs(zzqt zzqtVar, String str, Date date, zzox zzoxVar) {
        this.zza = zzqtVar;
        this.zzb = str;
        this.zzc = date;
        this.zzd = zzoxVar;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzrc
    public final boolean zza() throws zzqv {
        zzql zzqlVar;
        zzql zzqlVar2;
        zzov zzovVar;
        zzy zzj;
        try {
            zzqlVar = this.zza.zzi;
            HttpURLConnection zzb = zzqlVar.zzb();
            zzqt zzqtVar = this.zza;
            zzqlVar2 = zzqtVar.zzi;
            zzovVar = zzqtVar.zzh;
            zzqk zza = zzqlVar2.zza(zzb, zzovVar.zza().zza(), this.zzb, zzy.zzc(), null, zzy.zzc(), this.zzc, "o:a:mlkit:1.0.0", null, this.zzd).zza();
            this.zzf = zza;
            JSONObject zzd = zza.zzd();
            try {
                zzj = zzqt.zzj(zzd);
                this.zze = zzj;
                return true;
            } catch (JSONException e4) {
                this.zzd.zzb(zznk.RPC_RETURNED_MALFORMED_RESULT);
                Log.e("MLKit RemoteConfigRestC", "Fetched remote config setting has invalid format: ".concat(String.valueOf(zzd)), e4);
                return false;
            }
        } catch (zzqv e5) {
            Log.e("MLKit RemoteConfigRestC", "Creating HTTP connection to remote config service failed", e5);
            this.zzd.zzb(zznk.NO_CONNECTION);
            return false;
        }
    }

    public final zzy zzb() {
        return this.zze;
    }

    public final zzqk zzc() {
        return this.zzf;
    }
}
