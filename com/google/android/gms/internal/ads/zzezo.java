package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzezo {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzezo(int i4, int i5, boolean z3) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zza(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i4 = 0;
            int i5 = 0;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i4 = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i5 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z3 = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzezo(i4, i5, z3));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
