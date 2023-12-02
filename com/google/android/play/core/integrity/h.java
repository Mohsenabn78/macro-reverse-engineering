package com.google.android.play.core.integrity;

import android.content.Context;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class h implements k {

    /* renamed from: a  reason: collision with root package name */
    private Context f25288a;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(g gVar) {
    }

    public final h a(Context context) {
        context.getClass();
        this.f25288a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.k
    public final j b() {
        Context context = this.f25288a;
        if (context != null) {
            return new j(context, null);
        }
        throw new IllegalStateException(String.valueOf(Context.class.getCanonicalName()).concat(" must be set"));
    }
}
