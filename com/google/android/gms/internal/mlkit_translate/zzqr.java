package com.google.android.gms.internal.mlkit_translate;

import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzqr implements Iterable {
    public final /* synthetic */ JSONObject zza;

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        JSONObject jSONObject = this.zza;
        int i4 = zzqt.f20867a;
        return jSONObject.keys();
    }
}
