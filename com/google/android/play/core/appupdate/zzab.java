package com.google.android.play.core.appupdate;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzab {

    /* renamed from: a  reason: collision with root package name */
    private zzi f25225a;

    private zzab() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzab(zzaa zzaaVar) {
    }

    public final zza zza() {
        zzi zziVar = this.f25225a;
        if (zziVar != null) {
            return new zzz(zziVar, null);
        }
        throw new IllegalStateException(String.valueOf(zzi.class.getCanonicalName()).concat(" must be set"));
    }

    public final zzab zzb(zzi zziVar) {
        this.f25225a = zziVar;
        return this;
    }
}
