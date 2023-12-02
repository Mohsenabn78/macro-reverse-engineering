package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.aa;
import com.google.android.play.integrity.internal.ac;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class v implements aa {

    /* renamed from: a  reason: collision with root package name */
    private final ac f25313a;

    /* renamed from: b  reason: collision with root package name */
    private final ac f25314b;

    public v(ac acVar, ac acVar2) {
        this.f25313a = acVar;
        this.f25314b = acVar2;
    }

    @Override // com.google.android.play.integrity.internal.ac
    public final /* bridge */ /* synthetic */ Object a() {
        return new t((Context) this.f25313a.a(), (com.google.android.play.integrity.internal.k) this.f25314b.a());
    }
}
