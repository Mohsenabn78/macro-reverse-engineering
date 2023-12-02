package com.google.android.gms.internal.ads;

import com.getpebble.android.kit.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzams implements zzamt {
    private static final Logger zzb = Logger.getLogger(zzams.class.getName());
    final ThreadLocal zza = new zzamr(this);

    public abstract zzamw zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzamt
    public final zzamw zzb(zzgvq zzgvqVar, zzamx zzamxVar) throws IOException {
        int zza;
        long j4;
        String str;
        long zzb2 = zzgvqVar.zzb();
        ((ByteBuffer) this.zza.get()).rewind().limit(8);
        do {
            zza = zzgvqVar.zza((ByteBuffer) this.zza.get());
            if (zza == 8) {
                ((ByteBuffer) this.zza.get()).rewind();
                long zze = zzamv.zze((ByteBuffer) this.zza.get());
                byte[] bArr = null;
                if (zze < 8 && zze > 1) {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zze);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                byte[] bArr2 = new byte[4];
                ((ByteBuffer) this.zza.get()).get(bArr2);
                try {
                    String str2 = new String(bArr2, "ISO-8859-1");
                    if (zze == 1) {
                        ((ByteBuffer) this.zza.get()).limit(16);
                        zzgvqVar.zza((ByteBuffer) this.zza.get());
                        ((ByteBuffer) this.zza.get()).position(8);
                        j4 = zzamv.zzf((ByteBuffer) this.zza.get()) - 16;
                    } else if (zze == 0) {
                        j4 = zzgvqVar.zzc() - zzgvqVar.zzb();
                    } else {
                        j4 = zze - 8;
                    }
                    if (Constants.APP_UUID.equals(str2)) {
                        ((ByteBuffer) this.zza.get()).limit(((ByteBuffer) this.zza.get()).limit() + 16);
                        zzgvqVar.zza((ByteBuffer) this.zza.get());
                        bArr = new byte[16];
                        for (int position = ((ByteBuffer) this.zza.get()).position() - 16; position < ((ByteBuffer) this.zza.get()).position(); position++) {
                            bArr[position - (((ByteBuffer) this.zza.get()).position() - 16)] = ((ByteBuffer) this.zza.get()).get(position);
                        }
                        j4 -= 16;
                    }
                    long j5 = j4;
                    if (zzamxVar instanceof zzamw) {
                        str = ((zzamw) zzamxVar).zza();
                    } else {
                        str = "";
                    }
                    zzamw zza2 = zza(str2, bArr, str);
                    zza2.zzc(zzamxVar);
                    ((ByteBuffer) this.zza.get()).rewind();
                    zza2.zzb(zzgvqVar, (ByteBuffer) this.zza.get(), j5, this);
                    return zza2;
                } catch (UnsupportedEncodingException e4) {
                    throw new RuntimeException(e4);
                }
            }
        } while (zza >= 0);
        zzgvqVar.zze(zzb2);
        throw new EOFException();
    }
}
