package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.android.dx.rop.code.RegisterSpec;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfd {

    /* renamed from: a  reason: collision with root package name */
    private final String f21572a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f21573b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f21574c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzfi f21575d;

    public zzfd(zzfi zzfiVar, String str, Bundle bundle) {
        this.f21575d = zzfiVar;
        Preconditions.checkNotEmpty("default_event_parameters");
        this.f21572a = "default_event_parameters";
        this.f21573b = new Bundle();
    }

    @WorkerThread
    public final Bundle zza() {
        char c4;
        if (this.f21574c == null) {
            String string = this.f21575d.d().getString(this.f21572a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i4);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode == 115 && string3.equals("s")) {
                                        c4 = 0;
                                    }
                                    c4 = 65535;
                                } else {
                                    if (string3.equals("l")) {
                                        c4 = 2;
                                    }
                                    c4 = 65535;
                                }
                            } else {
                                if (string3.equals("d")) {
                                    c4 = 1;
                                }
                                c4 = 65535;
                            }
                            if (c4 != 0) {
                                if (c4 != 1) {
                                    if (c4 != 2) {
                                        this.f21575d.f21734a.zzaA().zzd().zzb("Unrecognized persisted bundle type. Type", string3);
                                    } else {
                                        bundle.putLong(string2, Long.parseLong(jSONObject.getString(RegisterSpec.PREFIX)));
                                    }
                                } else {
                                    bundle.putDouble(string2, Double.parseDouble(jSONObject.getString(RegisterSpec.PREFIX)));
                                }
                            } else {
                                bundle.putString(string2, jSONObject.getString(RegisterSpec.PREFIX));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f21575d.f21734a.zzaA().zzd().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f21574c = bundle;
                } catch (JSONException unused2) {
                    this.f21575d.f21734a.zzaA().zzd().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f21574c == null) {
                this.f21574c = this.f21573b;
            }
        }
        return this.f21574c;
    }

    @WorkerThread
    public final void zzb(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f21575d.d().edit();
        if (bundle.size() == 0) {
            edit.remove(this.f21572a);
        } else {
            String str = this.f21572a;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put(RegisterSpec.PREFIX, obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.f21575d.f21734a.zzaA().zzd().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e4) {
                        this.f21575d.f21734a.zzaA().zzd().zzb("Cannot serialize bundle value to SharedPreferences", e4);
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.f21574c = bundle;
    }
}
