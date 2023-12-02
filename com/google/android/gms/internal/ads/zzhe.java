package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzhe extends zzfy {
    private final Resources zza;
    private final String zzb;
    @Nullable
    private Uri zzc;
    @Nullable
    private AssetFileDescriptor zzd;
    @Nullable
    private InputStream zze;
    private long zzf;
    private boolean zzg;

    public zzhe(Context context) {
        super(false);
        this.zza = context.getResources();
        this.zzb = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i4) {
        return Uri.parse("rawresource:///" + i4);
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws zzhd {
        if (i5 == 0) {
            return 0;
        }
        long j4 = this.zzf;
        if (j4 == 0) {
            return -1;
        }
        if (j4 != -1) {
            try {
                i5 = (int) Math.min(j4, i5);
            } catch (IOException e4) {
                throw new zzhd(null, e4, 2000);
            }
        }
        InputStream inputStream = this.zze;
        int i6 = zzfj.zza;
        int read = inputStream.read(bArr, i4, i5);
        if (read == -1) {
            if (this.zzf == -1) {
                return -1;
            }
            throw new zzhd("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j5 = this.zzf;
        if (j5 != -1) {
            this.zzf = j5 - read;
        }
        zzg(read);
        return read;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0041, code lost:
        if (r3.matches("\\d+") != false) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0172  */
    @Override // com.google.android.gms.internal.ads.zzge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzb(com.google.android.gms.internal.ads.zzgj r18) throws com.google.android.gms.internal.ads.zzhd {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhe.zzb(com.google.android.gms.internal.ads.zzgj):long");
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws zzhd {
        this.zzc = null;
        try {
            try {
                InputStream inputStream = this.zze;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.zze = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.zzd;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e4) {
                        throw new zzhd(null, e4, 2000);
                    }
                } finally {
                    this.zzd = null;
                    if (this.zzg) {
                        this.zzg = false;
                        zzh();
                    }
                }
            } catch (Throwable th) {
                this.zze = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.zzd;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.zzd = null;
                        if (this.zzg) {
                            this.zzg = false;
                            zzh();
                        }
                        throw th;
                    } catch (Throwable th2) {
                        this.zzd = null;
                        if (this.zzg) {
                            this.zzg = false;
                            zzh();
                        }
                        throw th2;
                    }
                } catch (IOException e5) {
                    throw new zzhd(null, e5, 2000);
                }
            }
        } catch (IOException e6) {
            throw new zzhd(null, e6, 2000);
        }
    }
}
