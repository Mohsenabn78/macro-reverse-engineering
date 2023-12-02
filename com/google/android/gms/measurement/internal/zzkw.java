package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzrd;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkw extends zzkt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzlh zzlhVar) {
        super(zzlhVar);
    }

    private final String a(String str) {
        String n4 = this.f22016b.zzm().n(str);
        if (!TextUtils.isEmpty(n4)) {
            Uri parse = Uri.parse((String) zzeg.zzq.zza(null));
            Uri.Builder buildUpon = parse.buildUpon();
            String authority = parse.getAuthority();
            buildUpon.authority(n4 + "." + authority);
            return buildUpon.build().toString();
        }
        return (String) zzeg.zzq.zza(null);
    }

    public final zzkv zza(String str) {
        String str2;
        zzrd.zzc();
        zzkv zzkvVar = null;
        if (this.f21734a.zzf().zzs(null, zzeg.zzaq)) {
            this.f21734a.zzaA().zzj().zza("sgtm feature flag enabled.");
            zzh I = this.f22016b.zzh().I(str);
            if (I == null) {
                return new zzkv(a(str));
            }
            if (I.Q()) {
                this.f21734a.zzaA().zzj().zza("sgtm upload enabled in manifest.");
                com.google.android.gms.internal.measurement.zzff k4 = this.f22016b.zzm().k(I.l0());
                if (k4 != null) {
                    String zzj = k4.zzj();
                    if (!TextUtils.isEmpty(zzj)) {
                        String zzi = k4.zzi();
                        zzer zzj2 = this.f21734a.zzaA().zzj();
                        if (true != TextUtils.isEmpty(zzi)) {
                            str2 = "N";
                        } else {
                            str2 = "Y";
                        }
                        zzj2.zzc("sgtm configured with upload_url, server_info", zzj, str2);
                        if (TextUtils.isEmpty(zzi)) {
                            this.f21734a.zzay();
                            zzkvVar = new zzkv(zzj);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("x-google-sgtm-server-info", zzi);
                            zzkvVar = new zzkv(zzj, hashMap);
                        }
                    }
                }
            }
            if (zzkvVar != null) {
                return zzkvVar;
            }
        }
        return new zzkv(a(str));
    }
}
