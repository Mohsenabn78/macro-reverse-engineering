package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgb extends zzfy {
    private final ContentResolver zza;
    @Nullable
    private Uri zzb;
    @Nullable
    private AssetFileDescriptor zzc;
    @Nullable
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzgb(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws zzga {
        if (i5 == 0) {
            return 0;
        }
        long j4 = this.zze;
        if (j4 == 0) {
            return -1;
        }
        if (j4 != -1) {
            try {
                i5 = (int) Math.min(j4, i5);
            } catch (IOException e4) {
                throw new zzga(e4, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i6 = zzfj.zza;
        int read = fileInputStream.read(bArr, i4, i5);
        if (read == -1) {
            return -1;
        }
        long j5 = this.zze;
        if (j5 != -1) {
            this.zze = j5 - read;
        }
        zzg(read);
        return read;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws zzga {
        int i4;
        AssetFileDescriptor openAssetFileDescriptor;
        long j4;
        try {
            try {
                Uri normalizeScheme = zzgjVar.zza.normalizeScheme();
                this.zzb = normalizeScheme;
                zzi(zzgjVar);
                if (FirebaseAnalytics.Param.CONTENT.equals(normalizeScheme.getScheme())) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    openAssetFileDescriptor = this.zza.openTypedAssetFileDescriptor(normalizeScheme, "*/*", bundle);
                } else {
                    openAssetFileDescriptor = this.zza.openAssetFileDescriptor(normalizeScheme, "r");
                }
                this.zzc = openAssetFileDescriptor;
                if (openAssetFileDescriptor != null) {
                    long length = openAssetFileDescriptor.getLength();
                    FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                    this.zzd = fileInputStream;
                    int i5 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
                    if (i5 != 0 && zzgjVar.zzf > length) {
                        throw new zzga(null, 2008);
                    }
                    long startOffset = openAssetFileDescriptor.getStartOffset();
                    long skip = fileInputStream.skip(zzgjVar.zzf + startOffset) - startOffset;
                    if (skip == zzgjVar.zzf) {
                        if (i5 == 0) {
                            FileChannel channel = fileInputStream.getChannel();
                            long size = channel.size();
                            if (size == 0) {
                                this.zze = -1L;
                                j4 = -1;
                            } else {
                                j4 = size - channel.position();
                                this.zze = j4;
                                if (j4 < 0) {
                                    throw new zzga(null, 2008);
                                }
                            }
                        } else {
                            j4 = length - skip;
                            this.zze = j4;
                            if (j4 < 0) {
                                throw new zzga(null, 2008);
                            }
                        }
                        long j5 = zzgjVar.zzg;
                        if (j5 != -1) {
                            if (j4 != -1) {
                                j5 = Math.min(j4, j5);
                            }
                            this.zze = j5;
                        }
                        this.zzf = true;
                        zzj(zzgjVar);
                        long j6 = zzgjVar.zzg;
                        if (j6 != -1) {
                            return j6;
                        }
                        return this.zze;
                    }
                    throw new zzga(null, 2008);
                }
                i4 = 2000;
                try {
                    throw new zzga(new IOException("Could not open file descriptor for: " + String.valueOf(normalizeScheme)), 2000);
                } catch (IOException e4) {
                    e = e4;
                    if (true == (e instanceof FileNotFoundException)) {
                        i4 = SamsungIrisUnlockModule.IRIS_REQUEST_IR_PREVIEW_ENABLE;
                    }
                    throw new zzga(e, i4);
                }
            } catch (IOException e5) {
                e = e5;
                i4 = 2000;
            }
        } catch (zzga e6) {
            throw e6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws zzga {
        this.zzb = null;
        try {
            try {
                FileInputStream fileInputStream = this.zzd;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.zzd = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.zzc;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e4) {
                        throw new zzga(e4, 2000);
                    }
                } finally {
                    this.zzc = null;
                    if (this.zzf) {
                        this.zzf = false;
                        zzh();
                    }
                }
            } catch (Throwable th) {
                this.zzd = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzh();
                        }
                        throw th;
                    } catch (Throwable th2) {
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzh();
                        }
                        throw th2;
                    }
                } catch (IOException e5) {
                    throw new zzga(e5, 2000);
                }
            }
        } catch (IOException e6) {
            throw new zzga(e6, 2000);
        }
    }
}
