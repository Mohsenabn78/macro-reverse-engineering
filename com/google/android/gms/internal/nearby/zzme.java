package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzme {
    @Nullable
    private static File zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Payload zza(Context context, zzmc zzmcVar) {
        byte[] zzv;
        long zzb = zzmcVar.zzb();
        int zza2 = zzmcVar.zza();
        if (zza2 != 1) {
            if (zza2 != 2) {
                if (zza2 != 3) {
                    Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(zzmcVar.zzb()), Integer.valueOf(zzmcVar.zza())));
                    return null;
                }
                ParcelFileDescriptor zze = zzmcVar.zze();
                zzsj.zzc(zze, "Data ParcelFileDescriptor cannot be null for type STREAM");
                return Payload.zzc(Payload.Stream.zzb(zze), zzb);
            }
            String zzh = zzmcVar.zzh();
            Uri zzd = zzmcVar.zzd();
            if (zzh != null && zzd != null) {
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(zzd, "r");
                    if (openFileDescriptor == null) {
                        Log.w("NearbyConnections", String.format("Failed to get ParcelFileDescriptor for %s", zzd));
                        return null;
                    }
                    return Payload.zzb(Payload.File.zza(new File(zzh), openFileDescriptor, zzmcVar.zzc(), zzd), zzb);
                } catch (FileNotFoundException e4) {
                    Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", zzd, zzh), e4);
                    return null;
                } catch (SecurityException e5) {
                    Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", zzd, zzh), e5);
                    return null;
                }
            }
            ParcelFileDescriptor zze2 = zzmcVar.zze();
            zzsj.zzc(zze2, "Data ParcelFileDescriptor cannot be null for type FILE");
            return Payload.zzb(Payload.File.zzb(zze2), zzb);
        }
        zzly zzg = zzmcVar.zzg();
        if (zzg != null) {
            zzv = zzg.zzc();
        } else {
            zzv = zzmcVar.zzv();
        }
        zzsj.zzc(zzv, "Payload bytes cannot be null if type is BYTES.");
        return Payload.zza(zzv, zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static File zzb() {
        return zza;
    }

    public static void zzc(File file) {
        if (file == null) {
            Log.e("NearbyConnections", "Cannot set null temp directory");
        } else {
            zza = file;
        }
    }
}
