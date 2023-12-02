package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzaa extends zzku {

    /* renamed from: d  reason: collision with root package name */
    private String f21427d;

    /* renamed from: e  reason: collision with root package name */
    private Set f21428e;

    /* renamed from: f  reason: collision with root package name */
    private Map f21429f;

    /* renamed from: g  reason: collision with root package name */
    private Long f21430g;

    /* renamed from: h  reason: collision with root package name */
    private Long f21431h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzlh zzlhVar) {
        super(zzlhVar);
    }

    private final zzu e(Integer num) {
        if (this.f21429f.containsKey(num)) {
            return (zzu) this.f21429f.get(num);
        }
        zzu zzuVar = new zzu(this, this.f21427d, null);
        this.f21429f.put(num, zzuVar);
        return zzuVar;
    }

    private final boolean f(int i4, int i5) {
        zzu zzuVar = (zzu) this.f21429f.get(Integer.valueOf(i4));
        if (zzuVar == null) {
            return false;
        }
        return zzu.b(zzuVar).get(i5);
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean c() {
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:351:0x08ef
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @androidx.annotation.WorkerThread
    final java.util.List d(java.lang.String r65, java.util.List r66, java.util.List r67, java.lang.Long r68, java.lang.Long r69) {
        /*
            Method dump skipped, instructions count: 2817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.d(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
