package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfio extends zzfip {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfio(zzfih zzfihVar, HashSet hashSet, JSONObject jSONObject, long j4) {
        super(zzfihVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j4;
    }
}
