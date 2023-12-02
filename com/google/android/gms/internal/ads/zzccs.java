package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzccs extends zzcbg implements TextureView.SurfaceTextureListener, zzcbq {
    private final zzcca zzc;
    private final zzccb zzd;
    private final zzcbz zze;
    private zzcbf zzf;
    private Surface zzg;
    private zzcbr zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl;
    private zzcby zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzccs(Context context, zzccb zzccbVar, zzcca zzccaVar, boolean z3, boolean z4, zzcbz zzcbzVar) {
        super(context);
        this.zzl = 1;
        this.zzc = zzccaVar;
        this.zzd = zzccbVar;
        this.zzn = z3;
        this.zze = zzcbzVar;
        setSurfaceTextureListener(this);
        zzccbVar.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + RemoteSettings.FORWARD_SLASH_STRING + canonicalName + ":" + message;
    }

    private final void zzU() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            zzcbrVar.zzQ(true);
        }
    }

    private final void zzV() {
        if (this.zzo) {
            return;
        }
        this.zzo = true;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccn
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzI();
            }
        });
        zzn();
        this.zzd.zzb();
        if (this.zzp) {
            zzp();
        }
    }

    private final void zzW(boolean z3, @Nullable Integer num) {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null && !z3) {
            zzcbrVar.zzP(num);
        } else if (this.zzi != null && this.zzg != null) {
            if (z3) {
                if (zzad()) {
                    zzcbrVar.zzU();
                    zzY();
                } else {
                    zzbzr.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzi.startsWith("cache:")) {
                zzcdl zzp = this.zzc.zzp(this.zzi);
                if (zzp instanceof zzcdu) {
                    zzcbr zza = ((zzcdu) zzp).zza();
                    this.zzh = zza;
                    zza.zzP(num);
                    if (!this.zzh.zzV()) {
                        zzbzr.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzp instanceof zzcdr) {
                    zzcdr zzcdrVar = (zzcdr) zzp;
                    String zzF = zzF();
                    ByteBuffer zzk = zzcdrVar.zzk();
                    boolean zzl = zzcdrVar.zzl();
                    String zzi = zzcdrVar.zzi();
                    if (zzi == null) {
                        zzbzr.zzj("Stream cache URL is null.");
                        return;
                    }
                    zzcbr zzE = zzE(num);
                    this.zzh = zzE;
                    zzE.zzG(new Uri[]{Uri.parse(zzi)}, zzF, zzk, zzl);
                } else {
                    zzbzr.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
            } else {
                this.zzh = zzE(num);
                String zzF2 = zzF();
                Uri[] uriArr = new Uri[this.zzj.length];
                int i4 = 0;
                while (true) {
                    String[] strArr = this.zzj;
                    if (i4 >= strArr.length) {
                        break;
                    }
                    uriArr[i4] = Uri.parse(strArr[i4]);
                    i4++;
                }
                this.zzh.zzF(uriArr, zzF2);
            }
            this.zzh.zzL(this);
            zzZ(this.zzg, false);
            if (this.zzh.zzV()) {
                int zzt = this.zzh.zzt();
                this.zzl = zzt;
                if (zzt == 3) {
                    zzV();
                }
            }
        }
    }

    private final void zzX() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            zzcbrVar.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ(null, true);
            zzcbr zzcbrVar = this.zzh;
            if (zzcbrVar != null) {
                zzcbrVar.zzL(null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z3) {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            try {
                zzcbrVar.zzS(surface, z3);
                return;
            } catch (IOException e4) {
                zzbzr.zzk("", e4);
                return;
            }
        }
        zzbzr.zzj("Trying to set surface before player is initialized.");
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i4, int i5) {
        float f4;
        if (i5 > 0) {
            f4 = i4 / i5;
        } else {
            f4 = 1.0f;
        }
        if (this.zzs != f4) {
            this.zzs = f4;
            requestLayout();
        }
    }

    private final boolean zzac() {
        if (zzad() && this.zzl != 1) {
            return true;
        }
        return false;
    }

    private final boolean zzad() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null && zzcbrVar.zzV() && !this.zzk) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f4 = this.zzs;
        if (f4 != 0.0f && this.zzm == null) {
            float f5 = measuredWidth;
            float f6 = f5 / measuredHeight;
            if (f4 > f6) {
                measuredHeight = (int) (f5 / f4);
            }
            if (f4 < f6) {
                measuredWidth = (int) (measuredHeight * f4);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcby zzcbyVar = this.zzm;
        if (zzcbyVar != null) {
            zzcbyVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        if (this.zzn) {
            zzcby zzcbyVar = new zzcby(getContext());
            this.zzm = zzcbyVar;
            zzcbyVar.zzd(surfaceTexture, i4, i5);
            this.zzm.start();
            SurfaceTexture zzb = this.zzm.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq != 0 && this.zzr != 0) {
            zzaa();
        } else {
            zzab(i4, i5);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccm
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcby zzcbyVar = this.zzm;
        if (zzcbyVar != null) {
            zzcbyVar.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccq
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzN();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i4, final int i5) {
        zzcby zzcbyVar = this.zzm;
        if (zzcbyVar != null) {
            zzcbyVar.zzc(i4, i5);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccg
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzO(i4, i5);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i4) {
        com.google.android.gms.ads.internal.util.zze.zza("AdExoPlayerView3 window visibility changed to " + i4);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccp
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzQ(i4);
            }
        });
        super.onWindowVisibilityChanged(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzA(int i4) {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            zzcbrVar.zzN(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzB(int i4) {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            zzcbrVar.zzR(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzC(@Nullable String str, @Nullable String[] strArr, @Nullable Integer num) {
        if (str == null) {
            return;
        }
        boolean z3 = true;
        if (strArr == null) {
            this.zzj = new String[]{str};
        } else {
            this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzi;
        z3 = (!this.zze.zzl || str2 == null || str.equals(str2) || this.zzl != 4) ? false : false;
        this.zzi = str;
        zzW(z3, num);
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzD(int i4, int i5) {
        this.zzq = i4;
        this.zzr = i5;
        zzaa();
    }

    final zzcbr zzE(@Nullable Integer num) {
        zzcem zzcemVar = new zzcem(this.zzc.getContext(), this.zze, this.zzc, num);
        zzbzr.zzi("ExoPlayerAdapter initialized.");
        return zzcemVar;
    }

    final String zzF() {
        return com.google.android.gms.ads.internal.zzt.zzp().zzc(this.zzc.getContext(), this.zzc.zzn().zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(String str) {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzb("ExoPlayerAdapter error", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzI() {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(boolean z3, long j4) {
        this.zzc.zzv(z3, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(String str) {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzc("ExoPlayerAdapter exception", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzN() {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(int i4, int i5) {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzj(i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzP() {
        float zza = this.zzb.zza();
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            try {
                zzcbrVar.zzT(zza, false);
                return;
            } catch (IOException e4) {
                zzbzr.zzk("", e4);
                return;
            }
        }
        zzbzr.zzj("Trying to set volume before player is initialized.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(int i4) {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.onWindowVisibilityChanged(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzS() {
        zzcbf zzcbfVar = this.zzf;
        if (zzcbfVar != null) {
            zzcbfVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final int zzb() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            return zzcbrVar.zzr();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final int zzd() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final int zze() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final long zzf() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            return zzcbrVar.zzx();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final long zzg() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            return zzcbrVar.zzA();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final long zzh() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            return zzcbrVar.zzB();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzi(final boolean z3, final long j4) {
        if (this.zzc != null) {
            zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcco
                @Override // java.lang.Runnable
                public final void run() {
                    zzccs.this.zzJ(z3, j4);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final String zzj() {
        String str;
        if (true != this.zzn) {
            str = "";
        } else {
            str = " spherical";
        }
        return "ExoPlayer/2".concat(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzk(String str, Exception exc) {
        final String zzT = zzT(str, exc);
        zzbzr.zzj("ExoPlayerAdapter error: ".concat(zzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccf
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzG(zzT);
            }
        });
        com.google.android.gms.ads.internal.zzt.zzo().zzt(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzl(String str, Exception exc) {
        final String zzT = zzT("onLoadException", exc);
        zzbzr.zzj("ExoPlayerAdapter exception: ".concat(zzT));
        com.google.android.gms.ads.internal.zzt.zzo().zzt(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcci
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzK(zzT);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzm(int i4) {
        if (this.zzl != i4) {
            this.zzl = i4;
            if (i4 != 3) {
                if (i4 == 4) {
                    if (this.zze.zza) {
                        zzX();
                    }
                    this.zzd.zze();
                    this.zzb.zzc();
                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccl
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzccs.this.zzH();
                        }
                    });
                    return;
                }
                return;
            }
            zzV();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg, com.google.android.gms.internal.ads.zzccd
    public final void zzn() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccj
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzP();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcck
                @Override // java.lang.Runnable
                public final void run() {
                    zzccs.this.zzR();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzp() {
        if (zzac()) {
            if (this.zze.zza) {
                zzU();
            }
            this.zzh.zzO(true);
            this.zzd.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcch
                @Override // java.lang.Runnable
                public final void run() {
                    zzccs.this.zzS();
                }
            });
            return;
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzq(int i4) {
        if (zzac()) {
            this.zzh.zzI(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzr(zzcbf zzcbfVar) {
        this.zzf = zzcbfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzs(@Nullable String str) {
        if (str != null) {
            zzC(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzu(float f4, float f5) {
        zzcby zzcbyVar = this.zzm;
        if (zzcbyVar != null) {
            zzcbyVar.zzf(f4, f5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzv() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccr
            @Override // java.lang.Runnable
            public final void run() {
                zzccs.this.zzL();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    @Nullable
    public final Integer zzw() {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            return zzcbrVar.zzC();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzx(int i4) {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            zzcbrVar.zzJ(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzy(int i4) {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            zzcbrVar.zzK(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzz(int i4) {
        zzcbr zzcbrVar = this.zzh;
        if (zzcbrVar != null) {
            zzcbrVar.zzM(i4);
        }
    }
}
