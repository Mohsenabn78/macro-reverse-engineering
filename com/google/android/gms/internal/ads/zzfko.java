package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.mlkit.nl.translate.TranslateLanguage;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfko implements zzfje {
    private final Object zza;
    private final zzfkp zzb;
    private final zzfla zzc;
    private final zzfjb zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfko(@NonNull Object obj, @NonNull zzfkp zzfkpVar, @NonNull zzfla zzflaVar, @NonNull zzfjb zzfjbVar) {
        this.zza = obj;
        this.zzb = zzfkpVar;
        this.zzc = zzflaVar;
        this.zzd = zzfjbVar;
    }

    @Nullable
    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzaoz zza = zzapa.zza();
        zza.zzc(5);
        zza.zza(zzgoe.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzapa) zza.zzal()).zzax(), 11);
    }

    @Nullable
    private final synchronized byte[] zzj(Map map, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e4) {
            this.zzd.zzc(2007, System.currentTimeMillis() - currentTimeMillis, e4);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zza, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfje
    @Nullable
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map zza;
        zza = this.zzc.zza();
        zza.put("f", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT);
        zza.put("ctx", context);
        zza.put(TranslateLanguage.CZECH, str2);
        zza.put("aid", null);
        zza.put("view", view);
        zza.put("act", activity);
        return zzi(zzj(null, zza));
    }

    @Override // com.google.android.gms.internal.ads.zzfje
    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map zzc;
        zzc = this.zzc.zzc();
        zzc.put("f", RegisterSpec.PREFIX);
        zzc.put("ctx", context);
        zzc.put("aid", null);
        zzc.put("view", view);
        zzc.put("act", activity);
        return zzi(zzj(null, zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfje
    @Nullable
    public final synchronized String zzc(Context context, String str) {
        Map zzb;
        zzb = this.zzc.zzb();
        zzb.put("f", "q");
        zzb.put("ctx", context);
        zzb.put("aid", null);
        return zzi(zzj(null, zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzfje
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfky {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", null);
            hashMap.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod(TranslateLanguage.HEBREW, Map.class).invoke(this.zza, hashMap);
            this.zzd.zzd(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e4) {
            throw new zzfky((int) SamsungIrisUnlockModule.IRIS_REQUEST_IR_PREVIEW_ENABLE, e4);
        }
    }

    public final synchronized int zze() throws zzfky {
        try {
        } catch (Exception e4) {
            throw new zzfky(2006, e4);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfkp zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfky {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzd(AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e4) {
            throw new zzfky(2003, e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zzh() throws zzfky {
        try {
        } catch (Exception e4) {
            throw new zzfky(2001, e4);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }
}
