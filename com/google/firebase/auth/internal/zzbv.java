package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.p002firebaseauthapi.zzadu;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbv {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f29044a;

    /* renamed from: b  reason: collision with root package name */
    private final zzam f29045b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f29046c;

    public zzbv(FirebaseApp firebaseApp) {
        Context applicationContext = firebaseApp.getApplicationContext();
        zzam zzamVar = new zzam(firebaseApp);
        this.f29046c = false;
        this.f29044a = 0;
        this.f29045b = zzamVar;
        BackgroundDetector.initialize((Application) applicationContext.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzbu(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d() {
        if (this.f29044a > 0 && !this.f29046c) {
            return true;
        }
        return false;
    }

    public final void zzc() {
        this.f29045b.zzb();
    }

    public final void zzd(int i4) {
        if (i4 > 0 && this.f29044a == 0) {
            this.f29044a = i4;
            if (d()) {
                this.f29045b.zzc();
            }
        } else if (i4 == 0 && this.f29044a != 0) {
            this.f29045b.zzb();
        }
        this.f29044a = i4;
    }

    public final void zze(zzadu zzaduVar) {
        if (zzaduVar == null) {
            return;
        }
        long zzb = zzaduVar.zzb();
        if (zzb <= 0) {
            zzb = 3600;
        }
        zzam zzamVar = this.f29045b;
        zzamVar.f28986b = zzaduVar.zzc() + (zzb * 1000);
        zzamVar.f28987c = -1L;
        if (d()) {
            this.f29045b.zzc();
        }
    }
}
