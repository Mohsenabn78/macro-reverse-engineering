package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzezp {
    private String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzezp(JsonReader jsonReader) throws IOException {
        char c4;
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != -1724546052) {
                if (hashCode == 3059181 && nextName.equals("code")) {
                    c4 = 0;
                }
                c4 = 65535;
            } else {
                if (nextName.equals("description")) {
                    c4 = 1;
                }
                c4 = 65535;
            }
            if (c4 != 0) {
                if (c4 != 1) {
                    jsonReader.skipValue();
                } else {
                    str = jsonReader.nextString();
                }
            } else {
                jsonReader.nextInt();
            }
        }
        jsonReader.endObject();
        this.zza = str;
    }

    public final String zza() {
        return this.zza;
    }
}
