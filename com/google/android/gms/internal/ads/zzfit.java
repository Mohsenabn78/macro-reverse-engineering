package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfit extends zzfio {
    public zzfit(zzfih zzfihVar, HashSet hashSet, JSONObject jSONObject, long j4) {
        super(zzfihVar, hashSet, jSONObject, j4);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzfib.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfip, android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfip
    public final void zza(String str) {
        zzfhl zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfhl.zza()) != null) {
            for (zzfha zzfhaVar : zza.zzc()) {
                if (((zzfio) this).zza.contains(zzfhaVar.zzh())) {
                    zzfhaVar.zzg().zze(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
