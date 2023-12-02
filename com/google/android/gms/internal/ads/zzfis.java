package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfis extends zzfio {
    public zzfis(zzfih zzfihVar, HashSet hashSet, JSONObject jSONObject, long j4) {
        super(zzfihVar, hashSet, jSONObject, j4);
    }

    private final void zzc(String str) {
        zzfhl zza = zzfhl.zza();
        if (zza != null) {
            for (zzfha zzfhaVar : zza.zzc()) {
                if (((zzfio) this).zza.contains(zzfhaVar.zzh())) {
                    zzfhaVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfip, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfip
    public final void zza(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
