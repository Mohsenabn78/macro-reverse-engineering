package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.3.0 */
/* loaded from: classes5.dex */
public final class zze implements zza {

    /* renamed from: a  reason: collision with root package name */
    final Set f28760a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticsConnector.AnalyticsConnectorListener f28761b;

    /* renamed from: c  reason: collision with root package name */
    private final AppMeasurementSdk f28762c;

    /* renamed from: d  reason: collision with root package name */
    private final zzd f28763d;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f28761b = analyticsConnectorListener;
        this.f28762c = appMeasurementSdk;
        zzd zzdVar = new zzd(this);
        this.f28763d = zzdVar;
        appMeasurementSdk.registerOnMeasurementEventListener(zzdVar);
        this.f28760a = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.f28761b;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0010 A[SYNTHETIC] */
    @Override // com.google.firebase.analytics.connector.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(java.util.Set r10) {
        /*
            r9 = this;
            java.util.Set r0 = r9.f28760a
            r0.clear()
            java.util.Set r0 = r9.f28760a
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Iterator r10 = r10.iterator()
        L10:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto La1
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r1.size()
            r4 = 50
            if (r3 < r4) goto L26
            goto La1
        L26:
            int r3 = com.google.firebase.analytics.connector.internal.zzc.zza
            r3 = 95
            r4 = 0
            if (r2 != 0) goto L2f
        L2d:
            r5 = 0
            goto L63
        L2f:
            int r5 = r2.length()
            if (r5 != 0) goto L36
            goto L2d
        L36:
            int r5 = r2.codePointAt(r4)
            boolean r6 = java.lang.Character.isLetter(r5)
            if (r6 != 0) goto L45
            if (r5 == r3) goto L43
            goto L2d
        L43:
            r5 = 95
        L45:
            int r6 = r2.length()
            int r5 = java.lang.Character.charCount(r5)
        L4d:
            if (r5 >= r6) goto L62
            int r7 = r2.codePointAt(r5)
            if (r7 == r3) goto L5c
            boolean r8 = java.lang.Character.isLetterOrDigit(r7)
            if (r8 != 0) goto L5c
            goto L2d
        L5c:
            int r7 = java.lang.Character.charCount(r7)
            int r5 = r5 + r7
            goto L4d
        L62:
            r5 = 1
        L63:
            if (r5 == 0) goto L10
            int r5 = r2.length()
            if (r5 == 0) goto L10
            int r4 = r2.codePointAt(r4)
            boolean r5 = java.lang.Character.isLetter(r4)
            if (r5 == 0) goto L10
            int r5 = r2.length()
            int r4 = java.lang.Character.charCount(r4)
        L7d:
            if (r4 >= r5) goto L91
            int r6 = r2.codePointAt(r4)
            if (r6 == r3) goto L8b
            boolean r7 = java.lang.Character.isLetterOrDigit(r6)
            if (r7 == 0) goto L10
        L8b:
            int r6 = java.lang.Character.charCount(r6)
            int r4 = r4 + r6
            goto L7d
        L91:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzhc.zzb(r2)
            if (r3 != 0) goto L98
            goto L99
        L98:
            r2 = r3
        L99:
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            r1.add(r2)
            goto L10
        La1:
            r0.addAll(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.internal.zze.zzb(java.util.Set):void");
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
        this.f28760a.clear();
    }
}
