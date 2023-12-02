package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
@WorkerThread
/* loaded from: classes4.dex */
public final class zzey implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f21555a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f21556b;

    /* renamed from: c  reason: collision with root package name */
    private final zzev f21557c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21558d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f21559e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzez f21560f;

    public zzey(zzez zzezVar, String str, URL url, byte[] bArr, Map map, zzev zzevVar) {
        this.f21560f = zzezVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzevVar);
        this.f21555a = url;
        this.f21556b = bArr;
        this.f21557c = zzevVar;
        this.f21558d = str;
        this.f21559e = map;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00fa: MOVE  (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:42:0x00f8 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0100: MOVE  (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:44:0x00fd */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzey.run():void");
    }
}
