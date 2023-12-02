package com.google.firebase.auth.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.p002firebaseauthapi.zzadt;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbr {

    /* renamed from: a  reason: collision with root package name */
    final Map f29034a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private zzadt f29035b;

    /* renamed from: c  reason: collision with root package name */
    final FirebaseApp f29036c;

    /* renamed from: d  reason: collision with root package name */
    final FirebaseAuth f29037d;

    /* renamed from: e  reason: collision with root package name */
    final zzbm f29038e;

    public zzbr(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        zzbn zzbnVar = new zzbn();
        this.f29034a = new HashMap();
        this.f29036c = firebaseApp;
        this.f29037d = firebaseAuth;
        this.f29038e = zzbnVar;
    }

    @Nullable
    private final Task b(String str) {
        return (Task) this.f29034a.get(str);
    }

    private static String c(@Nullable String str) {
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzd(str)) {
            return "*";
        }
        return str;
    }

    public final Task zza(@Nullable String str, Boolean bool, RecaptchaAction recaptchaAction) {
        try {
            zzd();
            String c4 = c(str);
            Task b4 = b(c4);
            if (bool.booleanValue() || b4 == null) {
                b4 = zzb(c4, bool);
            }
            return b4.continueWithTask(new zzbq(this, recaptchaAction));
        } catch (zzbs e4) {
            return Tasks.forException(e4);
        }
    }

    public final Task zzb(@Nullable String str, Boolean bool) {
        Task b4;
        try {
            zzd();
            String c4 = c(str);
            if (!bool.booleanValue() && (b4 = b(c4)) != null) {
                return b4;
            }
            return this.f29037d.zze("RECAPTCHA_ENTERPRISE").continueWithTask(new zzbp(this, c4));
        } catch (zzbs e4) {
            return Tasks.forException(e4);
        }
    }

    public final boolean zze() {
        zzadt zzadtVar = this.f29035b;
        if (zzadtVar != null && zzadtVar.zzc()) {
            return true;
        }
        return false;
    }

    public static void zzd() throws zzbs {
    }
}
