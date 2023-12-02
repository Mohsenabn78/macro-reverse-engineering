package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.List;
import java.util.Timer;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzao implements zzaj {
    @NotNull
    public static final zzak zza = new zzak(null);
    @Nullable
    private static Timer zzb;
    @NotNull
    private final zzap zzc;
    @NotNull
    private final CoroutineScope zzd;
    @NotNull
    private final zzad zze;

    public /* synthetic */ zzao(Context context, zzap zzapVar, CoroutineScope coroutineScope, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        zzad zzadVar;
        CoroutineScope zza2 = zzp.zza();
        this.zzc = zzapVar;
        this.zzd = zza2;
        zzadVar = zzad.zzb;
        zzadVar = zzadVar == null ? new zzad(context, null) : zzadVar;
        zzad.zzb = zzadVar;
        this.zze = zzadVar;
        zzh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        List<List> windowed;
        windowed = CollectionsKt___CollectionsKt.windowed(this.zze.zzd(), 20, 20, true);
        for (List<zzae> list : windowed) {
            zzkz zzf = zzla.zzf();
            for (zzae zzaeVar : list) {
                zzf.zzd(zzkx.zzG(zzeb.zzg().zzj(zzaeVar.zzc())));
            }
            if (this.zzc.zza(((zzla) zzf.zzj()).zzd())) {
                for (zzae zzaeVar2 : list) {
                    this.zze.zzf(zzaeVar2);
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            timer.schedule(new zzal(this), 120000L, 120000L);
        }
    }

    public final void zzf(@NotNull zzkx zzkxVar) {
        e.e(this.zzd, null, null, new zzan(zzkxVar, this, null), 3, null);
        zzh();
    }
}
