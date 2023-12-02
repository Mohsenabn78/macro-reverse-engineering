package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.android.dx.rop.code.RegisterSpec;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.sun.mail.imap.IMAPStore;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzffd {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzffd(Context context, zzbzx zzbzxVar) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzbzxVar.zza;
    }

    public final void zza(Map map) {
        Object obj;
        map.put("s", "gmob_sdk");
        map.put(RegisterSpec.PREFIX, ExifInterface.GPS_MEASUREMENT_3D);
        map.put(IMAPStore.ID_OS, Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzt.zzp();
        map.put("device", com.google.android.gms.ads.internal.util.zzs.zzp());
        map.put("app", this.zzb);
        com.google.android.gms.ads.internal.zzt.zzp();
        String str = "0";
        if (true != com.google.android.gms.ads.internal.util.zzs.zzA(this.zza)) {
            obj = "0";
        } else {
            obj = "1";
        }
        map.put("is_lite_sdk", obj);
        zzbbe zzbbeVar = zzbbm.zza;
        List zzb = com.google.android.gms.ads.internal.client.zzba.zza().zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgH)).booleanValue()) {
            zzb.addAll(com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzd());
        }
        map.put("e", TextUtils.join(",", zzb));
        map.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjN)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (true == com.google.android.gms.ads.internal.util.zzs.zzx(this.zza)) {
                str = "1";
            }
            map.put("is_bstar", str);
        }
    }
}
