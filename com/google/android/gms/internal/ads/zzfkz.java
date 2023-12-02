package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.wearable.WearableStatusCodes;
import dalvik.system.DexClassLoader;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfkz {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfla zzc;
    private final zzfjb zzd;
    private final zzfiw zze;
    @Nullable
    private zzfko zzf;
    private final Object zzg = new Object();

    public zzfkz(@NonNull Context context, @NonNull zzfla zzflaVar, @NonNull zzfjb zzfjbVar, @NonNull zzfiw zzfiwVar) {
        this.zzb = context;
        this.zzc = zzflaVar;
        this.zzd = zzfjbVar;
        this.zze = zzfiwVar;
    }

    private final synchronized Class zzd(@NonNull zzfkp zzfkpVar) throws zzfky {
        String zzk = zzfkpVar.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfkpVar.zzc())) {
                try {
                    File zzb = zzfkpVar.zzb();
                    if (!zzb.exists()) {
                        zzb.mkdirs();
                    }
                    Class<?> loadClass = new DexClassLoader(zzfkpVar.zzc().getAbsolutePath(), zzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    hashMap.put(zzk, loadClass);
                    return loadClass;
                } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e4) {
                    throw new zzfky(2008, e4);
                }
            }
            throw new zzfky(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e5) {
            throw new zzfky(2026, e5);
        }
    }

    @Nullable
    public final zzfje zza() {
        zzfko zzfkoVar;
        synchronized (this.zzg) {
            zzfkoVar = this.zzf;
        }
        return zzfkoVar;
    }

    @Nullable
    public final zzfkp zzb() {
        synchronized (this.zzg) {
            zzfko zzfkoVar = this.zzf;
            if (zzfkoVar != null) {
                return zzfkoVar.zzf();
            }
            return null;
        }
    }

    public final boolean zzc(@NonNull zzfkp zzfkpVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfko zzfkoVar = new zzfko(zzd(zzfkpVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfkpVar.zze(), null, new Bundle(), 2), zzfkpVar, this.zzc, this.zzd);
                if (zzfkoVar.zzh()) {
                    int zze = zzfkoVar.zze();
                    if (zze == 0) {
                        synchronized (this.zzg) {
                            zzfko zzfkoVar2 = this.zzf;
                            if (zzfkoVar2 != null) {
                                try {
                                    zzfkoVar2.zzg();
                                } catch (zzfky e4) {
                                    this.zzd.zzc(e4.zza(), -1L, e4);
                                }
                            }
                            this.zzf = zzfkoVar;
                        }
                        this.zzd.zzd(3000, System.currentTimeMillis() - currentTimeMillis);
                        return true;
                    }
                    throw new zzfky((int) WearableStatusCodes.DUPLICATE_LISTENER, "ci: " + zze);
                }
                throw new zzfky((int) WearableStatusCodes.TARGET_NODE_NOT_CONNECTED, "init failed");
            } catch (Exception e5) {
                throw new zzfky((int) SamsungIrisUnlockModule.IRIS_REQUEST_FACTORY_TEST_CAMERA_VERSION, e5);
            }
        } catch (zzfky e6) {
            this.zzd.zzc(e6.zza(), System.currentTimeMillis() - currentTimeMillis, e6);
            return false;
        } catch (Exception e7) {
            this.zzd.zzc(WearableStatusCodes.ACCOUNT_KEY_CREATION_FAILED, System.currentTimeMillis() - currentTimeMillis, e7);
            return false;
        }
    }
}
