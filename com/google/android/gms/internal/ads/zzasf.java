package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasf extends zzath {
    public zzasf(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5) {
        super(zzartVar, "W3XZxcuCkVWMGpB7rckmrrZNc8kIRKZXHq2IDWH2bOmQhacxUDxUUq9zi2tOIl+6", "TZLhLjkSWa88s5Ub32Va4FnAdRMP/dTQp+jLbB+9PU0=", zzanqVar, i4, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzaa(3);
        try {
            int i4 = 1;
            boolean booleanValue = ((Boolean) this.zzf.invoke(null, this.zzb.zzb())).booleanValue();
            zzanq zzanqVar = this.zze;
            if (true == booleanValue) {
                i4 = 2;
            }
            zzanqVar.zzaa(i4);
        } catch (InvocationTargetException e4) {
            if (e4.getTargetException() instanceof Settings.SettingNotFoundException) {
                return;
            }
            throw e4;
        }
    }
}
