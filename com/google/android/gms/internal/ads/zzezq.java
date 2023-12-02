package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzezq {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final long zzf;
    public final boolean zzg;
    public final String zzh;
    @Nullable
    public final zzezp zzi;
    public final Bundle zzj;
    public final String zzk;
    public final String zzl;
    public final String zzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzezq(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List emptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        jsonReader.beginObject();
        String str = "";
        String str2 = "";
        String str3 = str2;
        zzezp zzezpVar = null;
        long j4 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str7 = str3;
            if ("nofill_urls".equals(nextName)) {
                emptyList = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i4 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z3 = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i5 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j4 = jsonReader.nextLong();
            } else {
                String str8 = str6;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhQ)).booleanValue() && "public_error".equals(nextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzezpVar = new zzezp(jsonReader);
                } else if ("bidding_data".equals(nextName)) {
                    str4 = jsonReader.nextString();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzej)).booleanValue() && (nextName == "topics_should_record_observation" || (nextName != null && nextName.equals("topics_should_record_observation")))) {
                        jsonReader.nextBoolean();
                    } else if ("adapter_response_replacement_key".equals(nextName)) {
                        str3 = jsonReader.nextString();
                        str6 = str8;
                    } else if ("response_info_extras".equals(nextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgD)).booleanValue()) {
                            try {
                                Bundle zza = com.google.android.gms.ads.internal.util.zzbu.zza(com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader));
                                if (zza != null) {
                                    bundle = zza;
                                }
                            } catch (IOException | JSONException unused) {
                            } catch (IllegalStateException unused2) {
                                jsonReader.skipValue();
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestPostBody".equals(nextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziN)).booleanValue()) {
                            str6 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestUrl".equals(nextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziN)).booleanValue()) {
                            str5 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                str3 = str7;
                str6 = str8;
            }
            str3 = str7;
        }
        jsonReader.endObject();
        this.zza = emptyList;
        this.zzc = i4;
        this.zzb = str;
        this.zzd = str2;
        this.zze = i5;
        this.zzf = j4;
        this.zzi = zzezpVar;
        this.zzg = z3;
        this.zzh = str4;
        this.zzj = bundle;
        this.zzk = str5;
        this.zzl = str6;
        this.zzm = str3;
    }
}
