package com.arlosoft.macrodroid.translations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ViewTranslationEntryBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.translations.data.Translation;
import com.jsramraj.flags.Flags;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TranslationsAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TranslationsAdapter extends RecyclerView.Adapter<TranslationViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<Translation> f14290a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final FlagProvider f14291b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LanguageClickedListener f14292c;

    /* compiled from: TranslationsAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class TranslationViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ViewTranslationEntryBinding f14293a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final FlagProvider f14294b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final LanguageClickedListener f14295c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TranslationsAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ Translation $translation;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Translation translation, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$translation = translation;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$translation, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TranslationViewHolder.this.f14295c.onLanguageClicked(this.$translation.getLanguageCode());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TranslationViewHolder(@NotNull ViewTranslationEntryBinding binding, @NotNull FlagProvider flagProvider, @NotNull LanguageClickedListener languageClickedListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(flagProvider, "flagProvider");
            Intrinsics.checkNotNullParameter(languageClickedListener, "languageClickedListener");
            this.f14293a = binding;
            this.f14294b = flagProvider;
            this.f14295c = languageClickedListener;
        }

        public final void bind(@NotNull Translation translation) {
            Intrinsics.checkNotNullParameter(translation, "translation");
            ConstraintLayout constraintLayout = this.f14293a.languageContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.languageContainer");
            Unit unit = null;
            ViewExtensionsKt.onClick$default(constraintLayout, null, new a(translation, null), 1, null);
            Integer flagResourceFromLanguage = this.f14294b.getFlagResourceFromLanguage(translation.getLanguageCode());
            if (flagResourceFromLanguage != null) {
                this.f14293a.flagImage.setImageResource(flagResourceFromLanguage.intValue());
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Flags.init(this.f14293a.getRoot().getContext().getApplicationContext());
                try {
                    this.f14293a.flagImage.setImageBitmap(Flags.forCountry(translation.getLanguageCode()).getBitmap());
                } catch (Exception unused) {
                    this.f14293a.flagImage.setImageResource(17170445);
                }
            }
            this.f14293a.languageEnglish.setText(translation.getName());
            this.f14293a.languageName.setText(Locale.forLanguageTag(translation.getLanguageCode()).getDisplayLanguage(Locale.forLanguageTag(translation.getLanguageCode())));
            if (translation.getProgress().getWords() > 0 && translation.getProgress().getWords() == translation.getProgress().getTranslated()) {
                this.f14293a.percentComplete.setText("100%");
                TextView textView = this.f14293a.percentComplete;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.percentComplete");
                Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(this.f14293a.getRoot().getContext(), R.color.translation_complete));
                return;
            }
            TextView textView2 = this.f14293a.percentComplete;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf((translation.getProgress().getTranslated() / (translation.getProgress().getTranslated() + translation.getProgress().getUntranslated())) * 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView2.setText(format);
        }
    }

    public TranslationsAdapter(@NotNull List<Translation> translations, @NotNull FlagProvider flagProvider, @NotNull LanguageClickedListener languageClickedListener) {
        Intrinsics.checkNotNullParameter(translations, "translations");
        Intrinsics.checkNotNullParameter(flagProvider, "flagProvider");
        Intrinsics.checkNotNullParameter(languageClickedListener, "languageClickedListener");
        this.f14290a = translations;
        this.f14291b = flagProvider;
        this.f14292c = languageClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14290a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull TranslationViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f14290a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public TranslationViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewTranslationEntryBinding inflate = ViewTranslationEntryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new TranslationViewHolder(inflate, this.f14291b, this.f14292c);
    }
}
