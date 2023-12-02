package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzn {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f20568f = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").build();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f20569a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f20570b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f20571c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20572d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20573e;

    public zzn(ComponentName componentName, int i4) {
        this.f20569a = null;
        this.f20570b = null;
        Preconditions.checkNotNull(componentName);
        this.f20571c = componentName;
        this.f20572d = i4;
        this.f20573e = false;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        if (Objects.equal(this.f20569a, zznVar.f20569a) && Objects.equal(this.f20570b, zznVar.f20570b) && Objects.equal(this.f20571c, zznVar.f20571c) && this.f20572d == zznVar.f20572d && this.f20573e == zznVar.f20573e) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f20569a, this.f20570b, this.f20571c, Integer.valueOf(this.f20572d), Boolean.valueOf(this.f20573e));
    }

    public final String toString() {
        String str = this.f20569a;
        if (str == null) {
            Preconditions.checkNotNull(this.f20571c);
            return this.f20571c.flattenToString();
        }
        return str;
    }

    public final int zza() {
        return this.f20572d;
    }

    @Nullable
    public final ComponentName zzb() {
        return this.f20571c;
    }

    public final Intent zzc(Context context) {
        Bundle bundle;
        if (this.f20569a != null) {
            Intent intent = null;
            if (this.f20573e) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", this.f20569a);
                try {
                    bundle = context.getContentResolver().call(f20568f, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e4) {
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e4.toString()));
                    bundle = null;
                }
                if (bundle != null) {
                    intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f20569a)));
                }
            }
            if (intent == null) {
                return new Intent(this.f20569a).setPackage(this.f20570b);
            }
            return intent;
        }
        return new Intent().setComponent(this.f20571c);
    }

    @Nullable
    public final String zzd() {
        return this.f20570b;
    }

    public zzn(String str, int i4, boolean z3) {
        this(str, "com.google.android.gms", i4, false);
    }

    public zzn(String str, String str2, int i4, boolean z3) {
        Preconditions.checkNotEmpty(str);
        this.f20569a = str;
        Preconditions.checkNotEmpty(str2);
        this.f20570b = str2;
        this.f20571c = null;
        this.f20572d = i4;
        this.f20573e = z3;
    }
}
