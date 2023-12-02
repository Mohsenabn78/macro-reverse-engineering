package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzjt implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzzr, zzot, zzvq, zzso, zzhw, zzhs, zzii {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzjx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjt(zzjx zzjxVar, zzjs zzjsVar) {
        this.zza = zzjxVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        zzjx.zzP(this.zza, surfaceTexture);
        zzjx.zzN(this.zza, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzjx.zzQ(this.zza, null);
        zzjx.zzN(this.zza, 0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        zzjx.zzN(this.zza, i4, i5);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        zzjx.zzN(this.zza, i5, i6);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        zzjx.zzN(this.zza, 0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(boolean z3) {
        zzjx.zzS(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzb(Exception exc) {
        zzjx.zzF(this.zza).zzv(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzc(String str, long j4, long j5) {
        zzjx.zzF(this.zza).zzw(str, j4, j5);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzd(String str) {
        zzjx.zzF(this.zza).zzx(str);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zze(zzhz zzhzVar) {
        zzjx.zzF(this.zza).zzy(zzhzVar);
        zzjx.zzI(this.zza, null);
        zzjx.zzH(this.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzf(zzhz zzhzVar) {
        zzjx.zzH(this.zza, zzhzVar);
        zzjx.zzF(this.zza).zzz(zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzg(zzam zzamVar, @Nullable zzia zziaVar) {
        zzjx.zzI(this.zza, zzamVar);
        zzjx.zzF(this.zza).zzA(zzamVar, zziaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzh(long j4) {
        zzjx.zzF(this.zza).zzB(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzi(Exception exc) {
        zzjx.zzF(this.zza).zzC(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzj(int i4, long j4, long j5) {
        zzjx.zzF(this.zza).zzD(i4, j4, j5);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzk(int i4, long j4) {
        zzjx.zzF(this.zza).zzE(i4, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzl(Object obj, long j4) {
        zzjx.zzF(this.zza).zzF(obj, j4);
        zzjx zzjxVar = this.zza;
        if (zzjx.zzG(zzjxVar) == obj) {
            zzeo zzD = zzjx.zzD(zzjxVar);
            zzD.zzd(26, new zzel() { // from class: com.google.android.gms.internal.ads.zzjp
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj2) {
                    zzcm zzcmVar = (zzcm) obj2;
                }
            });
            zzD.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final void zzm(final boolean z3) {
        zzjx zzjxVar = this.zza;
        if (zzjx.zzW(zzjxVar) == z3) {
            return;
        }
        zzjx.zzJ(zzjxVar, z3);
        zzeo zzD = zzjx.zzD(this.zza);
        zzD.zzd(23, new zzel() { // from class: com.google.android.gms.internal.ads.zzjq
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzcm) obj).zzn(z3);
            }
        });
        zzD.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzn(Exception exc) {
        zzjx.zzF(this.zza).zzG(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzo(String str, long j4, long j5) {
        zzjx.zzF(this.zza).zzH(str, j4, j5);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzp(String str) {
        zzjx.zzF(this.zza).zzI(str);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzq(zzhz zzhzVar) {
        zzjx.zzF(this.zza).zzJ(zzhzVar);
        zzjx.zzL(this.zza, null);
        zzjx.zzK(this.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzr(zzhz zzhzVar) {
        zzjx.zzK(this.zza, zzhzVar);
        zzjx.zzF(this.zza).zzK(zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzs(long j4, int i4) {
        zzjx.zzF(this.zza).zzL(j4, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzt(zzam zzamVar, @Nullable zzia zziaVar) {
        zzjx.zzL(this.zza, zzamVar);
        zzjx.zzF(this.zza).zzM(zzamVar, zziaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzr
    public final void zzu(final zzdn zzdnVar) {
        zzjx.zzM(this.zza, zzdnVar);
        zzeo zzD = zzjx.zzD(this.zza);
        zzD.zzd(25, new zzel() { // from class: com.google.android.gms.internal.ads.zzjr
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzcm) obj).zzr(zzdn.this);
            }
        });
        zzD.zzc();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }
}
