package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbmw {
    private static final Charset zzc = Charset.forName("UTF-8");
    public static final zzbmt zza = new zzbmv();
    public static final zzbmr zzb = new zzbmr() { // from class: com.google.android.gms.internal.ads.zzbmu
        @Override // com.google.android.gms.internal.ads.zzbmr
        public final Object zza(JSONObject jSONObject) {
            return zzbmw.zza(jSONObject);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
