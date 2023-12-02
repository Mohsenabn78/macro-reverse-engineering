package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.firebase.sessions.settings.RemoteSettings;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfx extends zzfy {
    private final AssetManager zza;
    @Nullable
    private Uri zzb;
    @Nullable
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzfx(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws zzfw {
        if (i5 == 0) {
            return 0;
        }
        long j4 = this.zzd;
        if (j4 == 0) {
            return -1;
        }
        if (j4 != -1) {
            try {
                i5 = (int) Math.min(j4, i5);
            } catch (IOException e4) {
                throw new zzfw(e4, 2000);
            }
        }
        InputStream inputStream = this.zzc;
        int i6 = zzfj.zza;
        int read = inputStream.read(bArr, i4, i5);
        if (read == -1) {
            return -1;
        }
        long j5 = this.zzd;
        if (j5 != -1) {
            this.zzd = j5 - read;
        }
        zzg(read);
        return read;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws zzfw {
        int i4;
        try {
            Uri uri = zzgjVar.zza;
            this.zzb = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                path = path.substring(1);
            }
            zzi(zzgjVar);
            InputStream open = this.zza.open(path, 1);
            this.zzc = open;
            if (open.skip(zzgjVar.zzf) >= zzgjVar.zzf) {
                long j4 = zzgjVar.zzg;
                if (j4 != -1) {
                    this.zzd = j4;
                } else {
                    long available = this.zzc.available();
                    this.zzd = available;
                    if (available == 2147483647L) {
                        this.zzd = -1L;
                    }
                }
                this.zze = true;
                zzj(zzgjVar);
                return this.zzd;
            }
            throw new zzfw(null, 2008);
        } catch (zzfw e4) {
            throw e4;
        } catch (IOException e5) {
            if (true != (e5 instanceof FileNotFoundException)) {
                i4 = 2000;
            } else {
                i4 = SamsungIrisUnlockModule.IRIS_REQUEST_IR_PREVIEW_ENABLE;
            }
            throw new zzfw(e5, i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws zzfw {
        this.zzb = null;
        try {
            try {
                InputStream inputStream = this.zzc;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.zzc = null;
                if (this.zze) {
                    this.zze = false;
                    zzh();
                }
            } catch (IOException e4) {
                throw new zzfw(e4, 2000);
            }
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
            throw th;
        }
    }
}
