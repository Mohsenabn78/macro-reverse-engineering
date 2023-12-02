package com.google.android.recaptcha.internal;

import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcz extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzda zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcz(zzda zzdaVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzdaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzcz(this.zzb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public final /* bridge */ /* synthetic */ Object mo1invoke(Object obj, Object obj2) {
        return ((zzcz) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Context context;
        String str;
        Context context2;
        String str2;
        String str3;
        String str4;
        String str5;
        Context context3;
        zzr zzrVar;
        String str6;
        String str7;
        String str8;
        String str9;
        zzdk zzdkVar;
        zzdk zzdkVar2;
        zzr zzrVar2;
        coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i4 = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i4 == 0) {
            zzu zzuVar = zzu.zza;
            context = this.zzb.zze;
            String zza = zzu.zza(context);
            str = this.zzb.zzd;
            context2 = this.zzb.zze;
            String packageName = context2.getPackageName();
            str2 = this.zzb.zzh;
            int i5 = Build.VERSION.SDK_INT;
            String encode = URLEncoder.encode(str, "UTF-8");
            String encode2 = URLEncoder.encode(packageName, "UTF-8");
            String encode3 = URLEncoder.encode(zza, "UTF-8");
            String encode4 = URLEncoder.encode("18.1.2", "UTF-8");
            String encode5 = URLEncoder.encode(str2, "UTF-8");
            byte[] bytes = ("k=" + encode + "&pk=" + encode2 + "&mst=" + encode3 + "&msv=" + encode4 + "&msi=" + encode5 + "&mov=" + i5).getBytes(Charset.forName("UTF-8"));
            zzai zzaiVar = zzai.zza;
            zzkw zzkwVar = zzkw.INIT_NATIVE;
            str3 = this.zzb.zzg;
            str4 = this.zzb.zzh;
            str5 = this.zzb.zzh;
            zzaf zzafVar = new zzaf(zzkwVar, str3, str4, str5, null);
            context3 = this.zzb.zze;
            zzrVar = this.zzb.zzf;
            zzai.zzc(zzafVar, context3, zzrVar);
            zzkw zzkwVar2 = zzkw.INIT_NETWORK;
            str6 = this.zzb.zzg;
            str7 = this.zzb.zzh;
            str8 = this.zzb.zzh;
            zzaf zzafVar2 = new zzaf(zzkwVar2, str6, str7, str8, null);
            str9 = this.zzb.zzd;
            zzai.zzb(zzafVar2, str9, new zzs());
            e.e(zzp.zza(), null, null, new zzcy(this.zzb, zza, null), 3, null);
            zzdkVar = this.zzb.zzn;
            zzdkVar.zzd();
            zzdkVar2 = this.zzb.zzn;
            zzdkVar2.zze();
            zzda zzdaVar = this.zzb;
            WebView zzb = zzdaVar.zzb();
            zzrVar2 = zzdaVar.zzf;
            zzb.postUrl(zzrVar2.zza(), bytes);
            Boxing.boxInt(this.zzb.zzm().hashCode());
            CompletableDeferred zzm = this.zzb.zzm();
            this.zza = 1;
            if (zzm.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m4187boximpl(Result.m4188constructorimpl(Unit.INSTANCE));
    }
}
