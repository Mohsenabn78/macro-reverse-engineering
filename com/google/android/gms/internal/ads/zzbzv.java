package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbzv {
    public static Context zza(Context context) throws zzbzu {
        return zzc(context).getModuleContext();
    }

    public static Object zzb(Context context, String str, zzbzt zzbztVar) throws zzbzu {
        try {
            return zzbztVar.zza(zzc(context).instantiate(str));
        } catch (Exception e4) {
            throw new zzbzu(e4);
        }
    }

    private static DynamiteModule zzc(Context context) throws zzbzu {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e4) {
            throw new zzbzu(e4);
        }
    }
}
