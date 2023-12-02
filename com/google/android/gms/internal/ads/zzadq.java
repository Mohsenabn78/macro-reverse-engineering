package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzadq {
    private final ByteArrayOutputStream zza;
    private final DataOutputStream zzb;

    public zzadq() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.zza = byteArrayOutputStream;
        this.zzb = new DataOutputStream(byteArrayOutputStream);
    }

    private static void zzb(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public final byte[] zza(zzadp zzadpVar) {
        this.zza.reset();
        try {
            zzb(this.zzb, zzadpVar.zza);
            String str = zzadpVar.zzb;
            if (str == null) {
                str = "";
            }
            zzb(this.zzb, str);
            this.zzb.writeLong(zzadpVar.zzc);
            this.zzb.writeLong(zzadpVar.zzd);
            this.zzb.write(zzadpVar.zze);
            this.zzb.flush();
            return this.zza.toByteArray();
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }
}
