package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.ads.zzcar;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzci {

    /* renamed from: a  reason: collision with root package name */
    private final View f19329a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f19330b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19331c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19332d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19333e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f19334f;

    public zzci(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f19330b = activity;
        this.f19329a = view;
        this.f19334f = onGlobalLayoutListener;
    }

    private static ViewTreeObserver a(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void b() {
        if (!this.f19331c) {
            Activity activity = this.f19330b;
            if (activity != null) {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f19334f;
                ViewTreeObserver a4 = a(activity);
                if (a4 != null) {
                    a4.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
            }
            com.google.android.gms.ads.internal.zzt.zzx();
            zzcar.zza(this.f19329a, this.f19334f);
            this.f19331c = true;
        }
    }

    private final void c() {
        Activity activity = this.f19330b;
        if (activity != null && this.f19331c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f19334f;
            ViewTreeObserver a4 = a(activity);
            if (a4 != null) {
                a4.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.f19331c = false;
        }
    }

    public final void zza() {
        this.f19333e = false;
        c();
    }

    public final void zzb() {
        this.f19333e = true;
        if (this.f19332d) {
            b();
        }
    }

    public final void zzc() {
        this.f19332d = true;
        if (this.f19333e) {
            b();
        }
    }

    public final void zzd() {
        this.f19332d = false;
        c();
    }

    public final void zze(Activity activity) {
        this.f19330b = activity;
    }
}
