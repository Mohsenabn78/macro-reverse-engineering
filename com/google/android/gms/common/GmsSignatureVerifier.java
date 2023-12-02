package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes4.dex */
public class GmsSignatureVerifier {

    /* renamed from: a  reason: collision with root package name */
    private static final zzab f19963a;

    /* renamed from: b  reason: collision with root package name */
    private static final zzab f19964b;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap f19965c;

    static {
        zzz zzzVar = new zzz();
        zzzVar.d("com.google.android.gms");
        zzzVar.a(204200000L);
        zzl zzlVar = zzn.f20780d;
        zzzVar.c(zzag.zzn(zzlVar.b(), zzn.f20778b.b()));
        zzl zzlVar2 = zzn.f20779c;
        zzzVar.b(zzag.zzn(zzlVar2.b(), zzn.f20777a.b()));
        f19963a = zzzVar.e();
        zzz zzzVar2 = new zzz();
        zzzVar2.d("com.android.vending");
        zzzVar2.a(82240000L);
        zzzVar2.c(zzag.zzm(zzlVar.b()));
        zzzVar2.b(zzag.zzm(zzlVar2.b()));
        f19964b = zzzVar2.e();
        f19965c = new HashMap();
    }
}
