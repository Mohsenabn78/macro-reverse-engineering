package com.google.android.gms.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class MediationUtils {
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cb A[ADDED_TO_REGION, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.ads.AdSize findClosestSize(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull com.google.android.gms.ads.AdSize r11, @androidx.annotation.NonNull java.util.List<com.google.android.gms.ads.AdSize> r12) {
        /*
            r0 = 0
            if (r12 == 0) goto Lce
            if (r11 != 0) goto L7
            goto Lce
        L7:
            boolean r1 = r11.h()
            if (r1 != 0) goto L36
            boolean r1 = r11.i()
            if (r1 != 0) goto L36
            android.content.res.Resources r1 = r10.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            int r2 = r11.getWidthInPixels(r10)
            float r2 = (float) r2
            float r2 = r2 / r1
            int r2 = java.lang.Math.round(r2)
            int r10 = r11.getHeightInPixels(r10)
            float r10 = (float) r10
            float r10 = r10 / r1
            int r10 = java.lang.Math.round(r10)
            com.google.android.gms.ads.AdSize r11 = new com.google.android.gms.ads.AdSize
            r11.<init>(r2, r10)
        L36:
            java.util.Iterator r10 = r12.iterator()
        L3a:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto Lce
            java.lang.Object r12 = r10.next()
            com.google.android.gms.ads.AdSize r12 = (com.google.android.gms.ads.AdSize) r12
            if (r12 == 0) goto L3a
            int r1 = r11.getWidth()
            int r2 = r12.getWidth()
            int r3 = r11.getHeight()
            double r4 = (double) r1
            r6 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r4 = r4 * r6
            double r6 = (double) r2
            int r8 = r12.getHeight()
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 > 0) goto L3a
            if (r1 < r2) goto L3a
            boolean r1 = r11.i()
            if (r1 == 0) goto L95
            int r1 = r11.a()
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzhu
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 > r2) goto L3a
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zzhv
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 > r8) goto L3a
            if (r1 < r8) goto L3a
            goto Lb2
        L95:
            boolean r1 = r11.h()
            if (r1 == 0) goto La2
            int r1 = r11.b()
            if (r1 < r8) goto L3a
            goto Lb2
        La2:
            double r1 = (double) r3
            r4 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r1 = r1 * r4
            double r4 = (double) r8
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L3a
            if (r3 >= r8) goto Lb2
            goto L3a
        Lb2:
            if (r0 != 0) goto Lb5
            goto Lcb
        Lb5:
            int r1 = r0.getWidth()
            int r2 = r0.getHeight()
            int r1 = r1 * r2
            int r2 = r12.getWidth()
            int r3 = r12.getHeight()
            int r2 = r2 * r3
            if (r1 > r2) goto L3a
        Lcb:
            r0 = r12
            goto L3a
        Lce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.MediationUtils.findClosestSize(android.content.Context, com.google.android.gms.ads.AdSize, java.util.List):com.google.android.gms.ads.AdSize");
    }
}
