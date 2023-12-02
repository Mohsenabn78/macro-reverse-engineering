package com.google.android.recaptcha.internal;

import android.content.Context;
import android.webkit.WebView;
import com.google.android.recaptcha.RecaptchaAction;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcw extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ RecaptchaAction zze;
    final /* synthetic */ zzda zzf;
    final /* synthetic */ String zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(RecaptchaAction recaptchaAction, zzda zzdaVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zze = recaptchaAction;
        this.zzf = zzdaVar;
        this.zzg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzcw(this.zze, this.zzf, this.zzg, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public final /* bridge */ /* synthetic */ Object mo1invoke(Object obj, Object obj2) {
        return ((zzcw) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Map map;
        String str;
        String str2;
        Context context;
        zzr zzrVar;
        Object coroutine_suspended2;
        coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i4 = this.zzd;
        ResultKt.throwOnFailure(obj);
        if (i4 == 0) {
            zzda zzdaVar = this.zzf;
            String str3 = this.zzg;
            RecaptchaAction recaptchaAction = this.zze;
            this.zza = zzdaVar;
            this.zzb = str3;
            this.zzc = recaptchaAction;
            this.zzd = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            map = zzdaVar.zzk;
            map.put(str3, cancellableContinuationImpl);
            zzma zzf = zzmb.zzf();
            zzf.zze(str3);
            zzf.zzd(recaptchaAction.getAction());
            byte[] zzd = ((zzmb) zzf.zzj()).zzd();
            String zzi = zzeb.zzh().zzi(zzd, 0, zzd.length);
            zzai zzaiVar = zzai.zza;
            zzkw zzkwVar = zzkw.EXECUTE_NATIVE;
            str = zzdaVar.zzg;
            str2 = zzdaVar.zzh;
            zzaf zzafVar = new zzaf(zzkwVar, str, str2, str3, null);
            context = zzdaVar.zze;
            zzrVar = zzdaVar.zzf;
            zzai.zzc(zzafVar, context, zzrVar);
            WebView zzb = zzdaVar.zzb();
            zzb.evaluateJavascript("recaptcha.m.Main.execute(\"" + zzi + "\")", null);
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = a.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
