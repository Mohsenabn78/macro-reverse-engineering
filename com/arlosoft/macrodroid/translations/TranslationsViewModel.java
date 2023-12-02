package com.arlosoft.macrodroid.translations;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.translations.data.LanguageIdMapping;
import com.arlosoft.macrodroid.translations.data.Translation;
import com.arlosoft.macrodroid.translations.data.TranslationDataRepository;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: TranslationsViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TranslationsViewModel extends ViewModel implements LanguageClickedListener {
    @NotNull
    public static final String ONE_SKY_APP_LINK_LANGUAGE = "http://macrodroid.oneskyapp.com/collaboration/translate/project/project/28964/language/";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TranslationDataRepository f14296a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<List<Translation>> f14297b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LiveData<List<Translation>> f14298c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SingleLiveEvent<String> f14299d;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TranslationsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TranslationsViewModel(@NotNull TranslationDataRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.f14296a = repository;
        MutableLiveData<List<Translation>> mutableLiveData = new MutableLiveData<>();
        this.f14297b = mutableLiveData;
        this.f14298c = mutableLiveData;
        this.f14299d = new SingleLiveEvent<>();
        a();
    }

    private final void a() {
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new TranslationsViewModel$requestTranslationData$1(this, null), 2, null);
    }

    @NotNull
    public final SingleLiveEvent<String> getOpenLinkEvent() {
        return this.f14299d;
    }

    @NotNull
    public final LiveData<List<Translation>> getTranslation() {
        return this.f14298c;
    }

    @Override // com.arlosoft.macrodroid.translations.LanguageClickedListener
    public void onLanguageClicked(@NotNull String languageCode) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        SingleLiveEvent<String> singleLiveEvent = this.f14299d;
        Integer num = LanguageIdMapping.INSTANCE.getLanguageCodeMap().get(languageCode);
        singleLiveEvent.postValue(ONE_SKY_APP_LINK_LANGUAGE + num);
    }
}
