package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.Predicate;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public interface zzcez extends com.google.android.gms.ads.internal.client.zza, zzdcu, zzceq, zzblc, zzcfw, zzcga, zzblp, zzaua, zzcge, com.google.android.gms.ads.internal.zzl, zzcgh, zzcgi, zzcca, zzcgj {
    boolean canGoBack();

    void destroy();

    @Override // com.google.android.gms.internal.ads.zzcga, com.google.android.gms.internal.ads.zzcca
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i4, int i5);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzcca
    void setBackgroundColor(int i4);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    @Override // com.google.android.gms.internal.ads.zzcca
    void zzC(zzcfv zzcfvVar);

    @Override // com.google.android.gms.internal.ads.zzceq
    zzezn zzD();

    Context zzE();

    @Override // com.google.android.gms.internal.ads.zzcgj
    View zzF();

    WebView zzG();

    WebViewClient zzH();

    @Override // com.google.android.gms.internal.ads.zzcgh
    zzaqs zzI();

    zzavn zzJ();

    zzbee zzK();

    com.google.android.gms.ads.internal.overlay.zzl zzL();

    com.google.android.gms.ads.internal.overlay.zzl zzM();

    zzcgm zzN();

    @Override // com.google.android.gms.internal.ads.zzcgg
    zzcgo zzO();

    @Override // com.google.android.gms.internal.ads.zzcfw
    zzezq zzP();

    zzfgw zzQ();

    zzfwm zzR();

    String zzS();

    void zzT(zzezn zzeznVar, zzezq zzezqVar);

    void zzU();

    void zzV();

    void zzW(int i4);

    void zzX();

    void zzY();

    void zzZ(boolean z3);

    boolean zzaA();

    boolean zzaB();

    boolean zzaC();

    void zzaa();

    void zzab(String str, String str2, String str3);

    void zzac();

    void zzad(String str, zzbij zzbijVar);

    void zzae();

    void zzaf(com.google.android.gms.ads.internal.overlay.zzl zzlVar);

    void zzag(zzcgo zzcgoVar);

    void zzah(zzavn zzavnVar);

    void zzai(boolean z3);

    void zzaj();

    void zzak(Context context);

    void zzal(boolean z3);

    void zzam(zzbec zzbecVar);

    void zzan(boolean z3);

    void zzao(zzbee zzbeeVar);

    void zzap(zzfgw zzfgwVar);

    void zzaq(int i4);

    void zzar(com.google.android.gms.ads.internal.overlay.zzl zzlVar);

    void zzas(boolean z3);

    void zzat(boolean z3);

    void zzau(String str, zzbij zzbijVar);

    void zzav(String str, Predicate predicate);

    boolean zzaw();

    boolean zzax();

    boolean zzay(boolean z3, int i4);

    boolean zzaz();

    @Override // com.google.android.gms.internal.ads.zzcga, com.google.android.gms.internal.ads.zzcca
    Activity zzi();

    @Override // com.google.android.gms.internal.ads.zzcca
    com.google.android.gms.ads.internal.zza zzj();

    @Override // com.google.android.gms.internal.ads.zzcca
    zzbcc zzm();

    @Override // com.google.android.gms.internal.ads.zzcgi, com.google.android.gms.internal.ads.zzcca
    zzbzx zzn();

    @Override // com.google.android.gms.internal.ads.zzcca
    zzcfv zzq();

    @Override // com.google.android.gms.internal.ads.zzcca
    void zzt(String str, zzcdl zzcdlVar);
}
