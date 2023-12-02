package com.google.mlkit.nl.translate;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_translate.zzqt;
import com.google.android.gms.internal.mlkit_translate.zzv;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.sdkinternal.CloseGuard;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.nl.translate.internal.TranslatorImpl;
import com.google.mlkit.nl.translate.internal.zzaa;
import com.google.mlkit.nl.translate.internal.zzae;
import com.google.mlkit.nl.translate.internal.zzaf;
import com.google.mlkit.nl.translate.internal.zzan;
import com.google.mlkit.nl.translate.internal.zzq;
import com.google.mlkit.nl.translate.internal.zzr;
import com.google.mlkit.nl.translate.internal.zzz;
import java.util.List;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
@KeepForSdk
/* loaded from: classes5.dex */
public class NaturalLanguageTranslateRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public final List getComponents() {
        return zzv.zzo(Component.builder(zzan.class).add(Dependency.required(zzaa.class)).add(Dependency.required(zzq.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zza
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzan((zzaa) componentContainer.get(zzaa.class), (zzq) componentContainer.get(zzq.class));
            }
        }).build(), Component.intoSetBuilder(RemoteModelManager.RemoteModelManagerRegistration.class).add(Dependency.requiredProvider(zzan.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzb
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new RemoteModelManager.RemoteModelManagerRegistration(TranslateRemoteModel.class, componentContainer.getProvider(zzan.class));
            }
        }).build(), Component.builder(zzq.class).add(Dependency.required(Context.class)).add(Dependency.required(ModelFileHelper.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                zzq zzqVar = new zzq((Context) componentContainer.get(Context.class), (ModelFileHelper) componentContainer.get(ModelFileHelper.class));
                zzqVar.start();
                return zzqVar;
            }
        }).alwaysEager().build(), Component.builder(com.google.mlkit.nl.translate.internal.zzj.class).add(Dependency.required(zzaf.class)).add(Dependency.required(ModelFileHelper.class)).add(Dependency.required(zzr.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzd
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new com.google.mlkit.nl.translate.internal.zzj((zzaf) componentContainer.get(zzaf.class), (ModelFileHelper) componentContainer.get(ModelFileHelper.class), (zzr) componentContainer.get(zzr.class));
            }
        }).build(), Component.builder(TranslatorImpl.Factory.class).add(Dependency.requiredProvider(zzaa.class)).add(Dependency.required(com.google.mlkit.nl.translate.internal.zzj.class)).add(Dependency.required(zzr.class)).add(Dependency.required(zzaf.class)).add(Dependency.required(ExecutorSelector.class)).add(Dependency.required(zzq.class)).add(Dependency.required(CloseGuard.Factory.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zze
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new TranslatorImpl.Factory(componentContainer.getProvider(zzaa.class), (com.google.mlkit.nl.translate.internal.zzj) componentContainer.get(com.google.mlkit.nl.translate.internal.zzj.class), (zzr) componentContainer.get(zzr.class), (zzaf) componentContainer.get(zzaf.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class), (zzq) componentContainer.get(zzq.class), (CloseGuard.Factory) componentContainer.get(CloseGuard.Factory.class));
            }
        }).build(), Component.builder(zzr.class).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzf
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzr();
            }
        }).build(), Component.builder(zzaf.class).add(Dependency.required(Context.class)).add(Dependency.required(zzr.class)).add(Dependency.required(ModelFileHelper.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzg
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzaf(zzqt.zze((Context) componentContainer.get(Context.class)), new zzae(zzqt.zze((Context) componentContainer.get(Context.class))), (zzr) componentContainer.get(zzr.class), (ModelFileHelper) componentContainer.get(ModelFileHelper.class), null);
            }
        }).build(), Component.builder(zzz.class).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzh
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzz();
            }
        }).build(), Component.builder(com.google.mlkit.nl.translate.internal.zzh.class).add(Dependency.required(MlKitContext.class)).add(Dependency.required(Context.class)).add(Dependency.required(zzr.class)).add(Dependency.required(zzaf.class)).add(Dependency.required(ModelFileHelper.class)).add(Dependency.required(SharedPrefManager.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzi
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new com.google.mlkit.nl.translate.internal.zzh((MlKitContext) componentContainer.get(MlKitContext.class), (Context) componentContainer.get(Context.class), (zzr) componentContainer.get(zzr.class), (zzaf) componentContainer.get(zzaf.class), (ModelFileHelper) componentContainer.get(ModelFileHelper.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class));
            }
        }).build(), Component.builder(zzaa.class).add(Dependency.required(com.google.mlkit.nl.translate.internal.zzh.class)).add(Dependency.required(zzz.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.nl.translate.zzj
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzaa((zzz) componentContainer.get(zzz.class), (com.google.mlkit.nl.translate.internal.zzh) componentContainer.get(com.google.mlkit.nl.translate.internal.zzh.class));
            }
        }).build());
    }
}
