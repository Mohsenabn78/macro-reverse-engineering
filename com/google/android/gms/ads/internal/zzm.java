package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzfbi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzm extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzs f19395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzs zzsVar) {
        this.f19395a = zzsVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzbh zzbhVar;
        zzbh zzbhVar2;
        zzbh zzbhVar3;
        zzbh zzbhVar4;
        zzs zzsVar = this.f19395a;
        zzbhVar = zzsVar.f19411g;
        if (zzbhVar != null) {
            try {
                zzbhVar2 = zzsVar.f19411g;
                zzbhVar2.zzf(zzfbi.zzd(1, null, null));
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
        zzs zzsVar2 = this.f19395a;
        zzbhVar3 = zzsVar2.f19411g;
        if (zzbhVar3 != null) {
            try {
                zzbhVar4 = zzsVar2.f19411g;
                zzbhVar4.zze(0);
            } catch (RemoteException e5) {
                zzbzr.zzl("#007 Could not call remote method.", e5);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzbh zzbhVar;
        zzbh zzbhVar2;
        zzbh zzbhVar3;
        zzbh zzbhVar4;
        zzbh zzbhVar5;
        zzbh zzbhVar6;
        zzbh zzbhVar7;
        zzbh zzbhVar8;
        zzbh zzbhVar9;
        zzbh zzbhVar10;
        zzbh zzbhVar11;
        zzbh zzbhVar12;
        zzbh zzbhVar13;
        if (str.startsWith(this.f19395a.zzq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzs zzsVar = this.f19395a;
            zzbhVar10 = zzsVar.f19411g;
            if (zzbhVar10 != null) {
                try {
                    zzbhVar11 = zzsVar.f19411g;
                    zzbhVar11.zzf(zzfbi.zzd(3, null, null));
                } catch (RemoteException e4) {
                    zzbzr.zzl("#007 Could not call remote method.", e4);
                }
            }
            zzs zzsVar2 = this.f19395a;
            zzbhVar12 = zzsVar2.f19411g;
            if (zzbhVar12 != null) {
                try {
                    zzbhVar13 = zzsVar2.f19411g;
                    zzbhVar13.zze(3);
                } catch (RemoteException e5) {
                    zzbzr.zzl("#007 Could not call remote method.", e5);
                }
            }
            this.f19395a.a(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzs zzsVar3 = this.f19395a;
            zzbhVar6 = zzsVar3.f19411g;
            if (zzbhVar6 != null) {
                try {
                    zzbhVar7 = zzsVar3.f19411g;
                    zzbhVar7.zzf(zzfbi.zzd(1, null, null));
                } catch (RemoteException e6) {
                    zzbzr.zzl("#007 Could not call remote method.", e6);
                }
            }
            zzs zzsVar4 = this.f19395a;
            zzbhVar8 = zzsVar4.f19411g;
            if (zzbhVar8 != null) {
                try {
                    zzbhVar9 = zzsVar4.f19411g;
                    zzbhVar9.zze(0);
                } catch (RemoteException e7) {
                    zzbzr.zzl("#007 Could not call remote method.", e7);
                }
            }
            this.f19395a.a(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            zzs zzsVar5 = this.f19395a;
            zzbhVar4 = zzsVar5.f19411g;
            if (zzbhVar4 != null) {
                try {
                    zzbhVar5 = zzsVar5.f19411g;
                    zzbhVar5.zzi();
                } catch (RemoteException e8) {
                    zzbzr.zzl("#007 Could not call remote method.", e8);
                }
            }
            this.f19395a.a(this.f19395a.zzb(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            zzs zzsVar6 = this.f19395a;
            zzbhVar = zzsVar6.f19411g;
            if (zzbhVar != null) {
                try {
                    zzbhVar2 = zzsVar6.f19411g;
                    zzbhVar2.zzc();
                    zzbhVar3 = this.f19395a.f19411g;
                    zzbhVar3.zzh();
                } catch (RemoteException e9) {
                    zzbzr.zzl("#007 Could not call remote method.", e9);
                }
            }
            zzs.j(this.f19395a, zzs.g(this.f19395a, str));
            return true;
        }
    }
}
