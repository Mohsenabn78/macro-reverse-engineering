package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.aa;
import com.google.android.play.integrity.internal.ab;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.z;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class j {

    /* renamed from: a  reason: collision with root package name */
    private final j f25289a = this;

    /* renamed from: b  reason: collision with root package name */
    private final ac f25290b;

    /* renamed from: c  reason: collision with root package name */
    private final ac f25291c;

    /* renamed from: d  reason: collision with root package name */
    private final ac f25292d;

    /* renamed from: e  reason: collision with root package name */
    private final ac f25293e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(Context context, i iVar) {
        p pVar;
        aa b4 = ab.b(context);
        this.f25290b = b4;
        pVar = o.f25299a;
        ac b5 = z.b(pVar);
        this.f25291c = b5;
        ac b6 = z.b(new v(b4, b5));
        this.f25292d = b6;
        this.f25293e = z.b(new n(b6));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f25293e.a();
    }
}
