package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcbo extends FrameLayout implements zzcbf {
    @VisibleForTesting
    final zzccc zza;
    private final zzcca zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbce zze;
    private final long zzf;
    @Nullable
    private final zzcbg zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcbo(Context context, zzcca zzccaVar, int i4, boolean z3, zzbce zzbceVar, zzcbz zzcbzVar) {
        super(context);
        zzcbg zzcbeVar;
        String str;
        this.zzb = zzccaVar;
        this.zze = zzbceVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzccaVar.zzj());
        zzcbh zzcbhVar = zzccaVar.zzj().zza;
        zzccb zzccbVar = new zzccb(context, zzccaVar.zzn(), zzccaVar.zzbm(), zzbceVar, zzccaVar.zzk());
        if (i4 == 2) {
            zzcbeVar = new zzccs(context, zzccbVar, zzccaVar, z3, zzcbh.zza(zzccaVar), zzcbzVar);
        } else {
            zzcbeVar = new zzcbe(context, zzccaVar, z3, zzcbh.zza(zzccaVar), zzcbzVar, new zzccb(context, zzccaVar.zzn(), zzccaVar.zzbm(), zzbceVar, zzccaVar.zzk()));
        }
        this.zzg = zzcbeVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcbeVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzF)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzC)).booleanValue()) {
            zzn();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzI)).longValue();
        boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzE)).booleanValue();
        this.zzk = booleanValue;
        if (zzbceVar != null) {
            if (true != booleanValue) {
                str = "0";
            } else {
                str = "1";
            }
            zzbceVar.zzd("spinner_used", str);
        }
        this.zza = new zzccc(this);
        zzcbeVar.zzr(this);
    }

    private final void zzJ() {
        if (this.zzb.zzi() != null && this.zzi && !this.zzj) {
            this.zzb.zzi().getWindow().clearFlags(128);
            this.zzi = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        Integer zzl = zzl();
        if (zzl != null) {
            hashMap.put("playerId", zzl.toString());
        }
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", hashMap);
    }

    private final boolean zzL() {
        if (this.zzq.getParent() != null) {
            return true;
        }
        return false;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcbg zzcbgVar = this.zzg;
            if (zzcbgVar != null) {
                zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbi
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcbg.this.zzt();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z3) {
        super.onWindowFocusChanged(z3);
        if (z3) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbj
            @Override // java.lang.Runnable
            public final void run() {
                zzcbo.this.zzq(z3);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcbf
    public final void onWindowVisibilityChanged(int i4) {
        boolean z3;
        super.onWindowVisibilityChanged(i4);
        if (i4 == 0) {
            this.zza.zzb();
            z3 = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z3 = false;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbn(this, z3));
    }

    public final void zzA(int i4) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzz(i4);
    }

    public final void zzB(int i4) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzA(i4);
    }

    public final void zzC(int i4) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzF)).booleanValue()) {
            this.zzc.setBackgroundColor(i4);
            this.zzd.setBackgroundColor(i4);
        }
    }

    public final void zzD(int i4) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzB(i4);
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i4, int i5, int i6, int i7) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Set video bounds to x:" + i4 + ";y:" + i5 + ";w:" + i6 + ";h:" + i7);
        }
        if (i6 != 0 && i7 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
            layoutParams.setMargins(i4, i5, 0, 0);
            this.zzc.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzG(float f4) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzb.zze(f4);
        zzcbgVar.zzn();
    }

    public final void zzH(float f4, float f5) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzu(f4, f5);
        }
    }

    public final void zzI() {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzb.zzd(false);
        zzcbgVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbL)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzb(String str, @Nullable String str2) {
        zzK(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzc(String str, @Nullable String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zze() {
        boolean z3;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbL)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            if ((this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.zzj = z3;
            if (!z3) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzf() {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar != null && this.zzm == 0) {
            zzK("canplaythrough", "duration", String.valueOf(zzcbgVar.zzc() / 1000.0f), "videoWidth", String.valueOf(this.zzg.zze()), "videoHeight", String.valueOf(this.zzg.zzd()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzg() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbk
            @Override // java.lang.Runnable
            public final void run() {
                zzcbo.this.zzp();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzh() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbl(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbm(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzj(int i4, int i5) {
        if (this.zzk) {
            zzbbe zzbbeVar = zzbbm.zzH;
            int max = Math.max(i4 / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).intValue(), 1);
            int max2 = Math.max(i5 / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == max && this.zzp.getHeight() == max2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbf
    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg != null && this.zzp != null) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            if (this.zzg.getBitmap(this.zzp) != null) {
                this.zzr = true;
            }
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime;
            if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                com.google.android.gms.ads.internal.util.zze.zza("Spinner frame grab took " + elapsedRealtime2 + TranslateLanguage.MALAY);
            }
            if (elapsedRealtime2 > this.zzf) {
                zzbzr.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzk = false;
                this.zzp = null;
                zzbce zzbceVar = this.zze;
                if (zzbceVar != null) {
                    zzbceVar.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    @Nullable
    public final Integer zzl() {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar != null) {
            return zzcbgVar.zzw();
        }
        return null;
    }

    public final void zzn() {
        String string;
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        TextView textView = new TextView(zzcbgVar.getContext());
        Resources zzd = com.google.android.gms.ads.internal.zzt.zzo().zzd();
        if (zzd == null) {
            string = "AdMob - ";
        } else {
            string = zzd.getString(R.string.watermark_label_prefix);
        }
        textView.setText(String.valueOf(string).concat(this.zzg.zzj()));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzc.bringChildToFront(textView);
    }

    public final void zzo() {
        this.zza.zza();
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzt();
        }
        zzJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(boolean z3) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z3));
    }

    public final void zzr(Integer num) {
        if (this.zzg == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.zzn)) {
            this.zzg.zzC(this.zzn, this.zzo, num);
        } else {
            zzK("no_src", new String[0]);
        }
    }

    public final void zzs() {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzb.zzd(true);
        zzcbgVar.zzn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt() {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        long zza = zzcbgVar.zza();
        if (this.zzl != zza && zza > 0) {
            float f4 = ((float) zza) / 1000.0f;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue()) {
                zzK("timeupdate", "time", String.valueOf(f4), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            } else {
                zzK("timeupdate", "time", String.valueOf(f4));
            }
            this.zzl = zza;
        }
    }

    public final void zzu() {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzo();
    }

    public final void zzv() {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzp();
    }

    public final void zzw(int i4) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzq(i4);
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzy(int i4) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzx(i4);
    }

    public final void zzz(int i4) {
        zzcbg zzcbgVar = this.zzg;
        if (zzcbgVar == null) {
            return;
        }
        zzcbgVar.zzy(i4);
    }
}
