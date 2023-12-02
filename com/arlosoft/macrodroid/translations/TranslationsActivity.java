package com.arlosoft.macrodroid.translations;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityTranslationsBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.translations.data.Translation;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.f;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TranslationsActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTranslationsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslationsActivity.kt\ncom/arlosoft/macrodroid/translations/TranslationsActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,82:1\n1045#2:83\n262#3,2:84\n262#3,2:86\n262#3,2:88\n*S KotlinDebug\n*F\n+ 1 TranslationsActivity.kt\ncom/arlosoft/macrodroid/translations/TranslationsActivity\n*L\n63#1:83\n67#1:84,2\n68#1:86,2\n70#1:88,2\n*E\n"})
/* loaded from: classes3.dex */
public final class TranslationsActivity extends MacroDroidDaggerBaseActivity implements TranslationsView {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private ActivityTranslationsBinding f14283f;
    @Inject
    public FlagProvider flagProvider;
    @Inject
    public TranslationsViewModel viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslationsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<List<? extends Translation>, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Translation> list) {
            invoke2((List<Translation>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable List<Translation> list) {
            TranslationsActivity.this.n(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslationsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<String, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f14285d = new b();

        b() {
            super(1);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable String str) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TranslationsActivity.kt */
    @SourceDebugExtension({"SMAP\nTranslationsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslationsActivity.kt\ncom/arlosoft/macrodroid/translations/TranslationsActivity$onCreate$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,82:1\n262#2,2:83\n*S KotlinDebug\n*F\n+ 1 TranslationsActivity.kt\ncom/arlosoft/macrodroid/translations/TranslationsActivity$onCreate$1\n*L\n45#1:83,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityTranslationsBinding activityTranslationsBinding = TranslationsActivity.this.f14283f;
                if (activityTranslationsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityTranslationsBinding = null;
                }
                TextView textView = activityTranslationsBinding.requestTranslationText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.requestTranslationText");
                textView.setVisibility(0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslationsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f14286a;

        d(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f14286a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f14286a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f14286a.invoke(obj);
        }
    }

    private final void m() {
        getViewModel().getTranslation().observe(this, new d(new a()));
        getViewModel().getOpenLinkEvent().observe(this, new d(b.f14285d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(List<Translation> list) {
        List sortedWith;
        ActivityTranslationsBinding activityTranslationsBinding = null;
        if (list != null) {
            Locale locale = Settings.getLocale(this);
            Intrinsics.checkNotNullExpressionValue(locale, "getLocale(this)");
            final String language = locale.getLanguage();
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.arlosoft.macrodroid.translations.TranslationsActivity$handleTranslations$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int i4;
                    int compareValues;
                    int i5 = -1;
                    if (Intrinsics.areEqual(((Translation) t3).getLanguageCode(), language)) {
                        i4 = -1;
                    } else {
                        i4 = 1;
                    }
                    Integer valueOf = Integer.valueOf(i4);
                    if (!Intrinsics.areEqual(((Translation) t4).getLanguageCode(), language)) {
                        i5 = 1;
                    }
                    compareValues = f.compareValues(valueOf, Integer.valueOf(i5));
                    return compareValues;
                }
            });
            ActivityTranslationsBinding activityTranslationsBinding2 = this.f14283f;
            if (activityTranslationsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTranslationsBinding2 = null;
            }
            activityTranslationsBinding2.languageEntries.setLayoutManager(new GridLayoutManager(this, 3));
            ActivityTranslationsBinding activityTranslationsBinding3 = this.f14283f;
            if (activityTranslationsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTranslationsBinding3 = null;
            }
            activityTranslationsBinding3.languageEntries.setAdapter(new TranslationsAdapter(sortedWith, getFlagProvider(), getViewModel()));
            ActivityTranslationsBinding activityTranslationsBinding4 = this.f14283f;
            if (activityTranslationsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTranslationsBinding4 = null;
            }
            FrameLayout frameLayout = activityTranslationsBinding4.loadingView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingView");
            frameLayout.setVisibility(8);
            ActivityTranslationsBinding activityTranslationsBinding5 = this.f14283f;
            if (activityTranslationsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityTranslationsBinding = activityTranslationsBinding5;
            }
            RecyclerView recyclerView = activityTranslationsBinding.languageEntries;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.languageEntries");
            recyclerView.setVisibility(0);
            return;
        }
        ActivityTranslationsBinding activityTranslationsBinding6 = this.f14283f;
        if (activityTranslationsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranslationsBinding = activityTranslationsBinding6;
        }
        FrameLayout frameLayout2 = activityTranslationsBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.loadingView");
        frameLayout2.setVisibility(8);
    }

    @NotNull
    public final FlagProvider getFlagProvider() {
        FlagProvider flagProvider = this.flagProvider;
        if (flagProvider != null) {
            return flagProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flagProvider");
        return null;
    }

    @NotNull
    public final TranslationsViewModel getViewModel() {
        TranslationsViewModel translationsViewModel = this.viewModel;
        if (translationsViewModel != null) {
            return translationsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranslationsBinding inflate = ActivityTranslationsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f14283f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setTitle(R.string.translations);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        m();
        ActivityTranslationsBinding activityTranslationsBinding = this.f14283f;
        if (activityTranslationsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranslationsBinding = null;
        }
        Button button = activityTranslationsBinding.requestTranslationAccessButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.requestTranslationAccessButton");
        ViewExtensionsKt.onClick$default(button, null, new c(null), 1, null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return true;
    }

    public final void setFlagProvider(@NotNull FlagProvider flagProvider) {
        Intrinsics.checkNotNullParameter(flagProvider, "<set-?>");
        this.flagProvider = flagProvider;
    }

    public final void setViewModel(@NotNull TranslationsViewModel translationsViewModel) {
        Intrinsics.checkNotNullParameter(translationsViewModel, "<set-?>");
        this.viewModel = translationsViewModel;
    }
}
