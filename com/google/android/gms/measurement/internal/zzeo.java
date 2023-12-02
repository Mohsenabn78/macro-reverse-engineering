package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzeo {

    /* renamed from: b  reason: collision with root package name */
    protected static final AtomicReference f21522b = new AtomicReference();

    /* renamed from: c  reason: collision with root package name */
    protected static final AtomicReference f21523c = new AtomicReference();

    /* renamed from: d  reason: collision with root package name */
    protected static final AtomicReference f21524d = new AtomicReference();

    /* renamed from: a  reason: collision with root package name */
    private final zzen f21525a;

    public zzeo(zzen zzenVar) {
        this.f21525a = zzenVar;
    }

    private static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z3;
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        if (strArr.length == strArr2.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str3 = strArr[i4];
            if (str == str3 || str.equals(str3)) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    str2 = strArr3[i4];
                    if (str2 == null) {
                        str2 = strArr2[i4] + "(" + strArr[i4] + ")";
                        strArr3[i4] = str2;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    protected final String a(Object[] objArr) {
        String valueOf;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                valueOf = b((Bundle) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            if (valueOf != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(valueOf);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(Bundle bundle) {
        String valueOf;
        if (bundle == null) {
            return null;
        }
        if (!this.f21525a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(e(str));
            sb.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                valueOf = a(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                valueOf = a((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                valueOf = a(((ArrayList) obj).toArray());
            } else {
                valueOf = String.valueOf(obj);
            }
            sb.append(valueOf);
        }
        sb.append("}]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String c(zzau zzauVar) {
        String b4;
        if (!this.f21525a.zza()) {
            return zzauVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzauVar.zzc);
        sb.append(",name=");
        sb.append(d(zzauVar.zza));
        sb.append(",params=");
        zzas zzasVar = zzauVar.zzb;
        if (zzasVar == null) {
            b4 = null;
        } else if (!this.f21525a.zza()) {
            b4 = zzasVar.toString();
        } else {
            b4 = b(zzasVar.zzc());
        }
        sb.append(b4);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String d(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f21525a.zza()) {
            return str;
        }
        return g(str, zzhc.zzc, zzhc.zza, f21522b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String e(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f21525a.zza()) {
            return str;
        }
        return g(str, zzhd.zzb, zzhd.zza, f21523c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f21525a.zza()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return "experiment_id(" + str + ")";
        }
        return g(str, zzhe.zzb, zzhe.zza, f21524d);
    }
}
