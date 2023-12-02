package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzk extends com.google.android.gms.ads.internal.util.zzb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzl f19220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzk(zzl zzlVar, zzj zzjVar) {
        this.f19220a = zzlVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        final BitmapDrawable bitmapDrawable;
        Bitmap zza = com.google.android.gms.ads.internal.zzt.zzu().zza(Integer.valueOf(this.f19220a.f19223b.zzo.zzf));
        if (zza != null) {
            com.google.android.gms.ads.internal.zzt.zzp();
            zzl zzlVar = this.f19220a;
            Activity activity = zzlVar.f19222a;
            com.google.android.gms.ads.internal.zzj zzjVar = zzlVar.f19223b.zzo;
            boolean z3 = zzjVar.zzd;
            float f4 = zzjVar.zze;
            if (z3 && f4 > 0.0f && f4 <= 25.0f) {
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(zza, zza.getWidth(), zza.getHeight(), false);
                    Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                    RenderScript create = RenderScript.create(activity);
                    ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                    Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                    create2.setRadius(f4);
                    create2.setInput(createFromBitmap);
                    create2.forEach(createFromBitmap2);
                    createFromBitmap2.copyTo(createBitmap);
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), createBitmap);
                } catch (RuntimeException unused) {
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), zza);
                }
            } else {
                bitmapDrawable = new BitmapDrawable(activity.getResources(), zza);
            }
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzi
                @Override // java.lang.Runnable
                public final void run() {
                    zzk zzkVar = zzk.this;
                    zzkVar.f19220a.f19222a.getWindow().setBackgroundDrawable(bitmapDrawable);
                }
            });
        }
    }
}
