package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzay extends SuspendLambda implements Function2 {
    final /* synthetic */ Exception zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzn zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ zzba zzf;
    private /* synthetic */ Object zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzay(Exception exc, int i4, zzn zznVar, zzn zznVar2, String str, zzba zzbaVar, Continuation continuation) {
        super(2, continuation);
        this.zza = exc;
        this.zzb = i4;
        this.zzc = zznVar;
        this.zzd = zznVar2;
        this.zze = str;
        this.zzf = zzbaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        zzay zzayVar = new zzay(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, continuation);
        zzayVar.zzg = obj;
        return zzayVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public final /* bridge */ /* synthetic */ Object mo1invoke(Object obj, Object obj2) {
        return ((zzay) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        zzmi zzf;
        a.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.zzg;
        Exception exc = this.zza;
        if (exc instanceof zzt) {
            zzf = ((zzt) exc).zza();
            zzf.zzd(this.zzb);
        } else {
            zzf = zzmj.zzf();
            zzf.zzd(this.zzb);
            zzf.zzp(2);
            zzf.zze(2);
        }
        zzmj zzmjVar = (zzmj) zzf.zzj();
        zzmjVar.zzk();
        zzmjVar.zzj();
        Reflection.getOrCreateKotlinClass(this.zza.getClass()).getSimpleName();
        this.zza.getMessage();
        zzlg zza = zzar.zza(this.zzc, this.zzd);
        String str = this.zze;
        if (str.length() == 0) {
            str = "recaptcha.m.Main.rge";
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            zzba zzbaVar = this.zzf;
            zzeb zzh = zzeb.zzh();
            byte[] zzd = zzmjVar.zzd();
            zzeb zzh2 = zzeb.zzh();
            byte[] zzd2 = zza.zzd();
            zzbaVar.zzv(str, zzh.zzi(zzd, 0, zzd.length), zzh2.zzi(zzd2, 0, zzd2.length));
        }
        return Unit.INSTANCE;
    }
}
