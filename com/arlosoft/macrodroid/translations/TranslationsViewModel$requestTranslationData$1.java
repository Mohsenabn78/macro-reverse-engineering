package com.arlosoft.macrodroid.translations;

import androidx.lifecycle.MutableLiveData;
import com.arlosoft.macrodroid.translations.data.Translation;
import com.arlosoft.macrodroid.translations.data.TranslationDataRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.f;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.m;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranslationsViewModel.kt */
@SourceDebugExtension({"SMAP\nTranslationsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslationsViewModel.kt\ncom/arlosoft/macrodroid/translations/TranslationsViewModel$requestTranslationData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n766#2:46\n857#2,2:47\n1054#2:49\n*S KotlinDebug\n*F\n+ 1 TranslationsViewModel.kt\ncom/arlosoft/macrodroid/translations/TranslationsViewModel$requestTranslationData$1\n*L\n38#1:46\n38#1:47,2\n38#1:49\n*E\n"})
/* loaded from: classes3.dex */
public final class TranslationsViewModel$requestTranslationData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TranslationsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranslationsViewModel$requestTranslationData$1(TranslationsViewModel translationsViewModel, Continuation<? super TranslationsViewModel$requestTranslationData$1> continuation) {
        super(2, continuation);
        this.this$0 = translationsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslationsViewModel$requestTranslationData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        TranslationDataRepository translationDataRepository;
        MutableLiveData mutableLiveData2;
        boolean startsWith$default;
        coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 != 0) {
            if (i4 == 1) {
                mutableLiveData2 = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0.f14297b;
            translationDataRepository = this.this$0.f14296a;
            this.L$0 = mutableLiveData;
            this.label = 1;
            Object translationData = translationDataRepository.getTranslationData(this);
            if (translationData == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData2 = mutableLiveData;
            obj = translationData;
        }
        List list = (List) obj;
        List list2 = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                startsWith$default = m.startsWith$default(((Translation) obj2).getLanguageCode(), "en", false, 2, null);
                if (!startsWith$default) {
                    arrayList.add(obj2);
                }
            }
            list2 = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.translations.TranslationsViewModel$requestTranslationData$1$invokeSuspend$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = f.compareValues(Integer.valueOf(((Translation) t4).getProgress().getTranslated()), Integer.valueOf(((Translation) t3).getProgress().getTranslated()));
                    return compareValues;
                }
            });
        }
        mutableLiveData2.postValue(list2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslationsViewModel$requestTranslationData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
