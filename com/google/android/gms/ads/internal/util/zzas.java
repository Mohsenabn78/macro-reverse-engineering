package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.common.Constants;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzdst;
import com.google.android.gms.internal.ads.zzdsx;
import com.google.android.gms.internal.ads.zzfwn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.protocol.HTTP;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzas {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19260a;

    /* renamed from: b  reason: collision with root package name */
    private final zzdsx f19261b;

    /* renamed from: c  reason: collision with root package name */
    private String f19262c;

    /* renamed from: d  reason: collision with root package name */
    private String f19263d;

    /* renamed from: e  reason: collision with root package name */
    private String f19264e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f19265f;

    /* renamed from: g  reason: collision with root package name */
    private int f19266g;

    /* renamed from: h  reason: collision with root package name */
    private int f19267h;

    /* renamed from: i  reason: collision with root package name */
    private PointF f19268i;

    /* renamed from: j  reason: collision with root package name */
    private PointF f19269j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f19270k;

    /* renamed from: l  reason: collision with root package name */
    private Runnable f19271l;

    public zzas(Context context) {
        this.f19266g = 0;
        this.f19271l = new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzar
            @Override // java.lang.Runnable
            public final void run() {
                zzas.this.g();
            }
        };
        this.f19260a = context;
        this.f19267h = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzt.zzt().zzb();
        this.f19270k = com.google.android.gms.ads.internal.zzt.zzt().zza();
        this.f19261b = com.google.android.gms.ads.internal.zzt.zzs().zza();
    }

    private final void m(Context context) {
        final int i4;
        ArrayList arrayList = new ArrayList();
        int o4 = o(arrayList, Constants.RINGTONE_NONE, true);
        final int o5 = o(arrayList, "Shake", true);
        final int o6 = o(arrayList, "Flick", true);
        zzdst zzdstVar = zzdst.NONE;
        int ordinal = this.f19261b.zza().ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                i4 = o4;
            } else {
                i4 = o6;
            }
        } else {
            i4 = o5;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i4);
        zzG.setTitle("Setup gesture");
        zzG.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i4, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzaj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                atomicInteger.set(i5);
            }
        });
        zzG.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzak
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                zzas.this.zzr();
            }
        });
        zzG.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzal
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                zzas.this.h(atomicInteger, i4, o5, o6, dialogInterface, i5);
            }
        });
        zzG.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.ads.internal.util.zzam
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                zzas.this.zzr();
            }
        });
        zzG.create().show();
    }

    private final boolean n(float f4, float f5, float f6, float f7) {
        if (Math.abs(this.f19268i.x - f4) < this.f19267h && Math.abs(this.f19268i.y - f5) < this.f19267h && Math.abs(this.f19269j.x - f6) < this.f19267h && Math.abs(this.f19269j.y - f7) < this.f19267h) {
            return true;
        }
        return false;
    }

    private static final int o(List list, String str, boolean z3) {
        if (!z3) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        m(this.f19260a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        m(this.f19260a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(zzfwn zzfwnVar) {
        if (!com.google.android.gms.ads.internal.zzt.zzs().zzj(this.f19260a, this.f19263d, this.f19264e)) {
            com.google.android.gms.ads.internal.zzt.zzs().zzd(this.f19260a, this.f19263d, this.f19264e);
        } else {
            zzfwnVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaf
                @Override // java.lang.Runnable
                public final void run() {
                    zzas.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(zzfwn zzfwnVar) {
        if (!com.google.android.gms.ads.internal.zzt.zzs().zzj(this.f19260a, this.f19263d, this.f19264e)) {
            com.google.android.gms.ads.internal.zzt.zzs().zzd(this.f19260a, this.f19263d, this.f19264e);
        } else {
            zzfwnVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaq
                @Override // java.lang.Runnable
                public final void run() {
                    zzas.this.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        com.google.android.gms.ads.internal.zzt.zzs().zzc(this.f19260a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f() {
        com.google.android.gms.ads.internal.zzt.zzs().zzc(this.f19260a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void g() {
        this.f19266g = 4;
        zzr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(AtomicInteger atomicInteger, int i4, int i5, int i6, DialogInterface dialogInterface, int i7) {
        if (atomicInteger.get() != i4) {
            if (atomicInteger.get() == i5) {
                this.f19261b.zzk(zzdst.SHAKE);
            } else if (atomicInteger.get() == i6) {
                this.f19261b.zzk(zzdst.FLICK);
            } else {
                this.f19261b.zzk(zzdst.NONE);
            }
        }
        zzr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(String str, DialogInterface dialogInterface, int i4) {
        com.google.android.gms.ads.internal.zzt.zzp();
        zzs.zzP(this.f19260a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j(int i4, int i5, int i6, int i7, int i8, DialogInterface dialogInterface, int i9) {
        if (i9 == i4) {
            if (!(this.f19260a instanceof Activity)) {
                zzbzr.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = this.f19262c;
            final String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                com.google.android.gms.ads.internal.zzt.zzp();
                Map zzL = zzs.zzL(build);
                for (String str3 : zzL.keySet()) {
                    sb.append(str3);
                    sb.append(" = ");
                    sb.append((String) zzL.get(str3));
                    sb.append("\n\n");
                }
                String trim = sb.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(this.f19260a);
            zzG.setMessage(str2);
            zzG.setTitle("Ad Information");
            zzG.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzad
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i10) {
                    zzas.this.i(str2, dialogInterface2, i10);
                }
            });
            zzG.setNegativeButton(HTTP.CONN_CLOSE, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzae
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i10) {
                }
            });
            zzG.create().show();
        } else if (i9 == i5) {
            zzbzr.zze("Debug mode [Creative Preview] selected.");
            zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzac
                @Override // java.lang.Runnable
                public final void run() {
                    zzas.this.l();
                }
            });
        } else if (i9 == i6) {
            zzbzr.zze("Debug mode [Troubleshooting] selected.");
            zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzag
                @Override // java.lang.Runnable
                public final void run() {
                    zzas.this.k();
                }
            });
        } else if (i9 == i7) {
            final zzfwn zzfwnVar = zzcae.zze;
            zzfwn zzfwnVar2 = zzcae.zza;
            if (this.f19261b.zzo()) {
                zzfwnVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzan
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzas.this.e();
                    }
                });
            } else {
                zzfwnVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzao
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzas.this.d(zzfwnVar);
                    }
                });
            }
        } else if (i9 == i8) {
            final zzfwn zzfwnVar3 = zzcae.zze;
            zzfwn zzfwnVar4 = zzcae.zza;
            if (this.f19261b.zzo()) {
                zzfwnVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzah
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzas.this.a();
                    }
                });
            } else {
                zzfwnVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzai
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzas.this.c(zzfwnVar3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k() {
        zzaw zzs = com.google.android.gms.ads.internal.zzt.zzs();
        Context context = this.f19260a;
        String str = this.f19263d;
        String str2 = this.f19264e;
        String str3 = this.f19265f;
        boolean zzm = zzs.zzm();
        zzs.zzh(zzs.zzj(context, str, str2));
        if (zzs.zzm()) {
            if (!zzm && !TextUtils.isEmpty(str3)) {
                zzs.zze(context, str2, str3, str);
            }
            zzbzr.zze("Device is linked for debug signals.");
            zzs.a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzs.zzd(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void l() {
        zzaw zzs = com.google.android.gms.ads.internal.zzt.zzs();
        Context context = this.f19260a;
        String str = this.f19263d;
        String str2 = this.f19264e;
        if (!zzs.b(context, str, str2)) {
            zzs.a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(zzs.f19284f)) {
            zzbzr.zze("Creative is not pushed for this device.");
            zzs.a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzs.f19284f)) {
            zzbzr.zze("The app is not linked for creative preview.");
            zzs.zzd(context, str, str2);
        } else if ("0".equals(zzs.f19284f)) {
            zzbzr.zze("Device is linked for in app preview.");
            zzs.a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.f19262c);
        sb.append(",DebugSignal: ");
        sb.append(this.f19265f);
        sb.append(",AFMA Version: ");
        sb.append(this.f19264e);
        sb.append(",Ad Unit ID: ");
        sb.append(this.f19263d);
        sb.append("}");
        return sb.toString();
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.f19266g = 0;
            this.f19268i = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i4 = this.f19266g;
        if (i4 == -1) {
            return;
        }
        if (i4 == 0) {
            if (actionMasked == 5) {
                this.f19266g = 5;
                this.f19269j = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.f19270k.postDelayed(this.f19271l, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzet)).longValue());
            }
        } else if (i4 == 5) {
            if (pointerCount == 2) {
                if (actionMasked == 2) {
                    boolean z3 = false;
                    for (int i5 = 0; i5 < historySize; i5++) {
                        z3 |= !n(motionEvent.getHistoricalX(0, i5), motionEvent.getHistoricalY(0, i5), motionEvent.getHistoricalX(1, i5), motionEvent.getHistoricalY(1, i5));
                    }
                    if (n(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z3) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f19266g = -1;
            this.f19270k.removeCallbacks(this.f19271l);
        }
    }

    public final void zzn(String str) {
        this.f19263d = str;
    }

    public final void zzo(String str) {
        this.f19264e = str;
    }

    public final void zzp(String str) {
        this.f19262c = str;
    }

    public final void zzq(String str) {
        this.f19265f = str;
    }

    public final void zzr() {
        try {
            if (!(this.f19260a instanceof Activity)) {
                zzbzr.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(com.google.android.gms.ads.internal.zzt.zzs().zzb())) {
                str = "Creative preview";
            }
            String str2 = "Troubleshooting (enabled)";
            if (true != com.google.android.gms.ads.internal.zzt.zzs().zzm()) {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            final int o4 = o(arrayList, "Ad information", true);
            final int o5 = o(arrayList, str, true);
            final int o6 = o(arrayList, str2, true);
            boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue();
            final int o7 = o(arrayList, "Open ad inspector", booleanValue);
            final int o8 = o(arrayList, "Ad inspector settings", booleanValue);
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(this.f19260a);
            zzG.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzap
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    zzas.this.j(o4, o5, o6, o7, o8, dialogInterface, i4);
                }
            });
            zzG.create().show();
        } catch (WindowManager.BadTokenException e4) {
            zze.zzb("", e4);
        }
    }

    public zzas(Context context, String str) {
        this(context);
        this.f19262c = str;
    }
}
