package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzaz extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzba zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzn zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaz(zzba zzbaVar, String str, zzn zznVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzbaVar;
        this.zzd = str;
        this.zze = zznVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzaz(this.zzc, this.zzd, this.zze, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public final /* bridge */ /* synthetic */ Object mo1invoke(Object obj, Object obj2) {
        return ((zzaz) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object zzu;
        zzmh zzy;
        Object zzt;
        coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        ?? r12 = this.zzb;
        try {
        } catch (Exception e4) {
            zzba zzbaVar = this.zzc;
            zzn zznVar = this.zze;
            this.zza = null;
            this.zzb = 2;
            zzu = zzbaVar.zzu(e4, "recaptcha.m.Main.rge", zznVar, r12, 0, this);
            if (zzu == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (r12 != 0) {
            if (r12 != 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            Object obj2 = this.zza;
            ResultKt.throwOnFailure(obj);
            r12 = obj2;
        } else {
            ResultKt.throwOnFailure(obj);
            zzn zznVar2 = new zzn();
            zzmp zzg = zzmp.zzg(zzeb.zzh().zzj(this.zzd));
            zzdk zzb = zzdk.zzb();
            zzba zzbaVar2 = this.zzc;
            zzy = zzba.zzy(zzg.zzi(), zzg.zzj());
            zzb.zzf();
            long zza = zzb.zza(TimeUnit.MICROSECONDS);
            zzj zzjVar = zzj.zza;
            zzj.zza(zzl.zzm.zza(), zza);
            zzba zzbaVar3 = this.zzc;
            List zzi = zzy.zzi();
            zzn zznVar3 = this.zze;
            this.zza = zznVar2;
            this.zzb = 1;
            zzt = zzbaVar3.zzt(zzi, zznVar3, zznVar2, this);
            r12 = zznVar2;
            if (zzt == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
