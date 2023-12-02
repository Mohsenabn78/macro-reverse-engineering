package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzax extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzba zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ zzn zze;
    private /* synthetic */ Object zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(zzba zzbaVar, List list, zzn zznVar, zzn zznVar2, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzbaVar;
        this.zzc = list;
        this.zzd = zznVar;
        this.zze = zznVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        zzax zzaxVar = new zzax(this.zzb, this.zzc, this.zzd, this.zze, continuation);
        zzaxVar.zzf = obj;
        return zzaxVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public final /* bridge */ /* synthetic */ Object mo1invoke(Object obj, Object obj2) {
        return ((zzax) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object zzu;
        boolean zzw;
        coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i4 = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i4 == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.zzf;
            zzbl zzblVar = new zzbl(this.zzb.zzb());
            zzdk zzb = zzdk.zzb();
            while (zzblVar.zzb() >= 0 && zzblVar.zzb() < this.zzc.size() && CoroutineScopeKt.isActive(coroutineScope)) {
                zzmv zzmvVar = (zzmv) this.zzc.get(zzblVar.zzb());
                try {
                    int zzk = zzmvVar.zzk();
                    int zzg = zzmvVar.zzg();
                    List zzj = zzmvVar.zzj();
                    zzw = this.zzb.zzw(zzmvVar, zzblVar);
                    if (!zzw) {
                        zzdk zzb2 = zzdk.zzb();
                        int i5 = zzk - 2;
                        if (i5 != 7) {
                            if (i5 != 15) {
                                if (i5 != 30) {
                                    if (i5 != 40) {
                                        switch (i5) {
                                            case 10:
                                                zzba.zzm(this.zzb, zzg, zzj);
                                                break;
                                            case 11:
                                                zzba.zzn(this.zzb, zzg, zzj);
                                                break;
                                            case 12:
                                                zzba.zzp(this.zzb, zzj);
                                                break;
                                            case 13:
                                                zzba.zzq(this.zzb, zzj);
                                                break;
                                            default:
                                                switch (i5) {
                                                    case 18:
                                                        zzba.zzk(this.zzb, zzg, zzj);
                                                        break;
                                                    case 19:
                                                        zzba.zzl(this.zzb, zzg, zzj);
                                                        break;
                                                    case 20:
                                                        zzba.zzj(this.zzb, zzj);
                                                        break;
                                                    default:
                                                        throw new zzt(5, 2, null);
                                                }
                                        }
                                    } else {
                                        zzba.zzr(this.zzb, this.zzd, zzg, zzj);
                                    }
                                } else {
                                    zzba.zzh(this.zzb, zzg, zzj);
                                }
                            } else {
                                zzba.zzi(this.zzb, zzj);
                            }
                        } else {
                            zzba.zzo(this.zzb, zzg, zzj);
                        }
                        zzb2.zzf();
                        long zza = zzb2.zza(TimeUnit.MICROSECONDS);
                        zzj zzjVar = zzj.zza;
                        zzj.zza(zzms.zza(zzk), zza);
                        Boxing.boxLong(zza);
                        Boxing.boxInt(zzg);
                        CollectionsKt___CollectionsKt.joinToString$default(zzj, null, null, null, 0, null, new zzaw(this.zzb), 31, null);
                        zzblVar.zzg(zzblVar.zzb() + 1);
                    }
                } catch (Exception e4) {
                    zzba zzbaVar = this.zzb;
                    String zzd = zzblVar.zzd();
                    zzn zznVar = this.zzd;
                    zzn zznVar2 = this.zze;
                    int zzb3 = zzblVar.zzb();
                    this.zza = 1;
                    zzu = zzbaVar.zzu(e4, zzd, zznVar, zznVar2, zzb3, this);
                    if (zzu == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            zzb.zzf();
            Boxing.boxLong(zzb.zza(TimeUnit.MICROSECONDS));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
