package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfip extends AsyncTask {
    private zzfiq zza;
    protected final zzfih zzd;

    public zzfip(zzfih zzfihVar) {
        this.zzd = zzfihVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzfiq zzfiqVar = this.zza;
        if (zzfiqVar != null) {
            zzfiqVar.zza(this);
        }
    }

    public final void zzb(zzfiq zzfiqVar) {
        this.zza = zzfiqVar;
    }
}
