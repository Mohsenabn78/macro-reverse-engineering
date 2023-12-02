package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbf {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f19290a;

    /* renamed from: b  reason: collision with root package name */
    private final double[] f19291b;

    /* renamed from: c  reason: collision with root package name */
    private final double[] f19292c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f19293d;

    /* renamed from: e  reason: collision with root package name */
    private int f19294e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbf(zzbd zzbdVar, zzbe zzbeVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzbdVar.f19288b;
        int size = list.size();
        list2 = zzbdVar.f19287a;
        this.f19290a = (String[]) list2.toArray(new String[size]);
        list3 = zzbdVar.f19288b;
        this.f19291b = a(list3);
        list4 = zzbdVar.f19289c;
        this.f19292c = a(list4);
        this.f19293d = new int[size];
        this.f19294e = 0;
    }

    private static final double[] a(List list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i4 = 0; i4 < size; i4++) {
            dArr[i4] = ((Double) list.get(i4)).doubleValue();
        }
        return dArr;
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList(this.f19290a.length);
        int i4 = 0;
        while (true) {
            String[] strArr = this.f19290a;
            if (i4 < strArr.length) {
                String str = strArr[i4];
                double d4 = this.f19292c[i4];
                double d5 = this.f19291b[i4];
                int i5 = this.f19293d[i4];
                arrayList.add(new zzbc(str, d4, d5, i5 / this.f19294e, i5));
                i4++;
            } else {
                return arrayList;
            }
        }
    }

    public final void zzb(double d4) {
        this.f19294e++;
        int i4 = 0;
        while (true) {
            double[] dArr = this.f19292c;
            if (i4 < dArr.length) {
                double d5 = dArr[i4];
                if (d5 <= d4 && d4 < this.f19291b[i4]) {
                    int[] iArr = this.f19293d;
                    iArr[i4] = iArr[i4] + 1;
                }
                if (d4 >= d5) {
                    i4++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
