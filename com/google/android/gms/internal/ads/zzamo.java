package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzamo extends zzalk {
    private final Object zza;
    @Nullable
    @GuardedBy("mLock")
    private final zzalp zzb;

    public zzamo(int i4, String str, zzalp zzalpVar, @Nullable zzalo zzaloVar) {
        super(i4, str, zzaloVar);
        this.zza = new Object();
        this.zzb = zzalpVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzalk
    public final zzalq zzh(zzalg zzalgVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzalgVar.zzb;
            Map map = zzalgVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] split = str2.split(";", 0);
                int i4 = 1;
                while (true) {
                    if (i4 >= split.length) {
                        break;
                    }
                    String[] split2 = split[i4].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str3 = split2[1];
                        break;
                    }
                    i4++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzalgVar.zzb);
        }
        return zzalq.zzb(str, zzamh.zzb(zzalgVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzalk
    /* renamed from: zzz */
    public void zzo(String str) {
        zzalp zzalpVar;
        synchronized (this.zza) {
            zzalpVar = this.zzb;
        }
        zzalpVar.zza(str);
    }
}
