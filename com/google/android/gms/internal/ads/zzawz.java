package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawz {
    private final zzaxf zza;
    private final zzayo zzb;
    private final boolean zzc;

    private zzawz() {
        this.zzb = zzayp.zzd();
        this.zzc = false;
        this.zza = new zzaxf();
    }

    public static zzawz zza() {
        return new zzawz();
    }

    private final synchronized String zzd(int i4) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzb.zzk(), Long.valueOf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime()), Integer.valueOf(i4 - 1), Base64.encodeToString(((zzayp) this.zzb.zzal()).zzax(), 3));
    }

    private final synchronized void zze(int i4) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(zzd(i4).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    com.google.android.gms.ads.internal.util.zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            com.google.android.gms.ads.internal.util.zze.zza("Could not find file for Clearcut");
        }
    }

    private final synchronized void zzf(int i4) {
        zzayo zzayoVar = this.zzb;
        zzayoVar.zzd();
        zzayoVar.zzc(com.google.android.gms.ads.internal.util.zzs.zzd());
        zzaxe zzaxeVar = new zzaxe(this.zza, ((zzayp) this.zzb.zzal()).zzax(), null);
        int i5 = i4 - 1;
        zzaxeVar.zza(i5);
        zzaxeVar.zzc();
        com.google.android.gms.ads.internal.util.zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i5, 10))));
    }

    public final synchronized void zzb(zzawy zzawyVar) {
        if (this.zzc) {
            try {
                zzawyVar.zza(this.zzb);
            } catch (NullPointerException e4) {
                com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i4) {
        if (!this.zzc) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeH)).booleanValue()) {
            zze(i4);
        } else {
            zzf(i4);
        }
    }

    public zzawz(zzaxf zzaxfVar) {
        this.zzb = zzayp.zzd();
        this.zza = zzaxfVar;
        this.zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeG)).booleanValue();
    }
}
