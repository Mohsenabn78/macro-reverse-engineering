package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfhw implements zzfht {
    private final int[] zza = new int[2];

    @Override // com.google.android.gms.internal.ads.zzfht
    public final JSONObject zza(View view) {
        if (view == null) {
            return zzfib.zza(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.zza);
        int[] iArr = this.zza;
        return zzfib.zza(iArr[0], iArr[1], width, height);
    }

    @Override // com.google.android.gms.internal.ads.zzfht
    public final void zzb(View view, JSONObject jSONObject, zzfhs zzfhsVar, boolean z3, boolean z4) {
        int i4;
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (z3) {
            HashMap hashMap = new HashMap();
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i5);
                ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i6 = 0;
            while (i6 < size) {
                ArrayList arrayList3 = (ArrayList) hashMap.get((Float) arrayList2.get(i6));
                int size2 = arrayList3.size();
                int i7 = 0;
                while (true) {
                    i4 = i6 + 1;
                    if (i7 < size2) {
                        zzfhsVar.zza((View) arrayList3.get(i7), this, jSONObject, z4);
                        i7++;
                    }
                }
                i6 = i4;
            }
            return;
        }
        for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
            zzfhsVar.zza(viewGroup.getChildAt(i8), this, jSONObject, z4);
        }
    }
}
