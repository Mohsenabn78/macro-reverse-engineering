package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Predicate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcfo extends FrameLayout implements zzcez {
    private final zzcez zza;
    private final zzcbp zzb;
    private final AtomicBoolean zzc;

    public zzcfo(zzcez zzcezVar) {
        super(zzcezVar.getContext());
        this.zzc = new AtomicBoolean();
        this.zza = zzcezVar;
        this.zzb = new zzcbp(zzcezVar.zzE(), this, this);
        addView((View) zzcezVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void destroy() {
        final zzfgw zzQ = zzQ();
        if (zzQ != null) {
            zzfmd zzfmdVar = com.google.android.gms.ads.internal.util.zzs.zza;
            zzfmdVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfm
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzt.zzA().zzg(zzfgw.this);
                }
            });
            final zzcez zzcezVar = this.zza;
            zzcezVar.getClass();
            zzfmdVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfn
                @Override // java.lang.Runnable
                public final void run() {
                    zzcez.this.destroy();
                }
            }, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeN)).intValue());
            return;
        }
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void goBack() {
        this.zza.goBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcez zzcezVar = this.zza;
        if (zzcezVar != null) {
            zzcezVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void onResume() {
        this.zza.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcez
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcez
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzA(int i4) {
        this.zza.zzA(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzB(int i4) {
        this.zzb.zzg(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final void zzC(zzcfv zzcfvVar) {
        this.zza.zzC(zzcfvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzceq
    public final zzezn zzD() {
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final Context zzE() {
        return this.zza.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final WebView zzG() {
        return (WebView) this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgh
    public final zzaqs zzI() {
        return this.zza.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final zzavn zzJ() {
        return this.zza.zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    @Nullable
    public final zzbee zzK() {
        return this.zza.zzK();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final com.google.android.gms.ads.internal.overlay.zzl zzL() {
        return this.zza.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final com.google.android.gms.ads.internal.overlay.zzl zzM() {
        return this.zza.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final zzcgm zzN() {
        return ((zzcfs) this.zza).zzaJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgg
    public final zzcgo zzO() {
        return this.zza.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcfw
    public final zzezq zzP() {
        return this.zza.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final zzfgw zzQ() {
        return this.zza.zzQ();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final zzfwm zzR() {
        return this.zza.zzR();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final String zzS() {
        return this.zza.zzS();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzT(zzezn zzeznVar, zzezq zzezqVar) {
        this.zza.zzT(zzeznVar, zzezqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzU() {
        this.zzb.zze();
        this.zza.zzU();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzV() {
        this.zza.zzV();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzW(int i4) {
        this.zza.zzW(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzX() {
        this.zza.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzY() {
        zzcez zzcezVar = this.zza;
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzt.zzr().zze()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzt.zzr().zza()));
        zzcfs zzcfsVar = (zzcfs) zzcezVar;
        hashMap.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzab.zzb(zzcfsVar.getContext())));
        zzcfsVar.zzd("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzZ(boolean z3) {
        this.zza.zzZ(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final void zza(String str) {
        ((zzcfs) this.zza).zzaO(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzaA() {
        return this.zza.zzaA();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzaB() {
        return this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaD(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z3) {
        this.zza.zzaD(zzcVar, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaE(com.google.android.gms.ads.internal.util.zzbr zzbrVar, String str, String str2, int i4) {
        this.zza.zzaE(zzbrVar, str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaF(boolean z3, int i4, boolean z4) {
        this.zza.zzaF(z3, i4, z4);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaG(boolean z3, int i4, String str, boolean z4) {
        this.zza.zzaG(z3, i4, str, z4);
    }

    @Override // com.google.android.gms.internal.ads.zzcge
    public final void zzaH(boolean z3, int i4, String str, String str2, boolean z4) {
        this.zza.zzaH(z3, i4, str, str2, z4);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzaa() {
        this.zza.zzaa();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzab(String str, String str2, @Nullable String str3) {
        this.zza.zzab(str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzac() {
        this.zza.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzad(String str, zzbij zzbijVar) {
        this.zza.zzad(str, zzbijVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzae() {
        TextView textView = new TextView(getContext());
        com.google.android.gms.ads.internal.zzt.zzp();
        textView.setText(com.google.android.gms.ads.internal.util.zzs.zzu());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzaf(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zza.zzaf(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzag(zzcgo zzcgoVar) {
        this.zza.zzag(zzcgoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzah(zzavn zzavnVar) {
        this.zza.zzah(zzavnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzai(boolean z3) {
        this.zza.zzai(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzaj() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzak(Context context) {
        this.zza.zzak(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzal(boolean z3) {
        this.zza.zzal(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzam(zzbec zzbecVar) {
        this.zza.zzam(zzbecVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzan(boolean z3) {
        this.zza.zzan(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzao(@Nullable zzbee zzbeeVar) {
        this.zza.zzao(zzbeeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzap(zzfgw zzfgwVar) {
        this.zza.zzap(zzfgwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzaq(int i4) {
        this.zza.zzaq(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzar(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zza.zzar(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzas(boolean z3) {
        this.zza.zzas(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzat(boolean z3) {
        this.zza.zzat(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzau(String str, zzbij zzbijVar) {
        this.zza.zzau(str, zzbijVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final void zzav(String str, Predicate predicate) {
        this.zza.zzav(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzaw() {
        return this.zza.zzaw();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzax() {
        return this.zza.zzax();
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzay(boolean z3, int i4) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaI)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzay(z3, i4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcez
    public final boolean zzaz() {
        return this.zza.zzaz();
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final void zzbj() {
        this.zza.zzbj();
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final void zzbk() {
        this.zza.zzbk();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final String zzbl() {
        return this.zza.zzbl();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final String zzbm() {
        return this.zza.zzbm();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzc(zzatz zzatzVar) {
        this.zza.zzc(zzatzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final int zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final int zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdB)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final int zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdB)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcga, com.google.android.gms.internal.ads.zzcca
    @Nullable
    public final Activity zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final zzbcb zzk() {
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final void zzl(String str, JSONObject jSONObject) {
        ((zzcfs) this.zza).zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final zzbcc zzm() {
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgi, com.google.android.gms.internal.ads.zzcca
    public final zzbzx zzn() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final zzcbp zzo() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final zzcdl zzp(String str) {
        return this.zza.zzp(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final zzcfv zzq() {
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzr() {
        zzcez zzcezVar = this.zza;
        if (zzcezVar != null) {
            zzcezVar.zzr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzs() {
        zzcez zzcezVar = this.zza;
        if (zzcezVar != null) {
            zzcezVar.zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcca
    public final void zzt(String str, zzcdl zzcdlVar) {
        this.zza.zzt(str, zzcdlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzu() {
        this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzv(boolean z3, long j4) {
        this.zza.zzv(z3, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzw() {
        this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzz(boolean z3) {
        this.zza.zzz(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcez, com.google.android.gms.internal.ads.zzcgj
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzx(int i4) {
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzy(int i4) {
    }
}
