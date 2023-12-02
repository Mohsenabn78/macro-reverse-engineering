package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzduw;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzak implements zzfvj {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f19547a;

    /* renamed from: b  reason: collision with root package name */
    private final zzduw f19548b;

    public zzak(Executor executor, zzduw zzduwVar) {
        this.f19547a = executor;
        this.f19548b = zzduwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvj
    public final /* bridge */ /* synthetic */ zzfwm zza(Object obj) throws Exception {
        final zzbue zzbueVar = (zzbue) obj;
        return zzfwc.zzm(this.f19548b.zzb(zzbueVar), new zzfvj() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaj
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj2) {
                zzbue zzbueVar2 = zzbue.this;
                zzam zzamVar = new zzam(new JsonReader(new InputStreamReader((InputStream) obj2)));
                try {
                    zzamVar.zzb = zzay.zzb().zzh(zzbueVar2.zza).toString();
                } catch (JSONException unused) {
                    zzamVar.zzb = "{}";
                }
                return zzfwc.zzh(zzamVar);
            }
        }, this.f19547a);
    }
}
