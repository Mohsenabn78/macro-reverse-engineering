package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdhz implements zzbee {
    final /* synthetic */ zzdiw zza;
    final /* synthetic */ ViewGroup zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhz(zzdiw zzdiwVar, ViewGroup viewGroup) {
        this.zza = zzdiwVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final JSONObject zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final void zzc() {
        zzdiw zzdiwVar = this.zza;
        zzfsc zzfscVar = zzdhw.zza;
        Map zzm = zzdiwVar.zzm();
        if (zzm != null) {
            int size = zzfscVar.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = zzm.get((String) zzfscVar.get(i4));
                i4++;
                if (obj != null) {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }
}
