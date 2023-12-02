package com.arlosoft.macrodroid.templatestore.ui.templateList.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.database.room.BlockedMacro;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.settings.AppPreferences;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.google.gson.Gson;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private LiveData<PagedList<MacroTemplate>> f14022a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f14023b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final TemplateDataSourceFactory f14024c;

    /* compiled from: TemplateViewModel.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<TemplatesDataSource, LiveData<LoadState>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f14025d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        /* renamed from: a */
        public final LiveData<LoadState> invoke(TemplatesDataSource templatesDataSource) {
            return templatesDataSource.getLoadState();
        }
    }

    public TemplateViewModel(@NotNull Gson gson, @NotNull TemplateStoreApi api, int i4, int i5, int i6, int i7, @NotNull String searchTerm, @NotNull AppPreferences appPreferences, @NotNull CategoriesHelper categoriesHelper, @NotNull String language, @NotNull List<BlockedUser> blockedUsers, @NotNull List<BlockedMacro> blockedMacros) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        Intrinsics.checkNotNullParameter(appPreferences, "appPreferences");
        Intrinsics.checkNotNullParameter(categoriesHelper, "categoriesHelper");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        Intrinsics.checkNotNullParameter(blockedMacros, "blockedMacros");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f14023b = compositeDisposable;
        TemplateDataSourceFactory templateDataSourceFactory = new TemplateDataSourceFactory(gson, api, compositeDisposable, i4, i5, i6, i7, searchTerm, appPreferences, categoriesHelper, language, blockedUsers, blockedMacros);
        this.f14024c = templateDataSourceFactory;
        this.f14022a = new LivePagedListBuilder(templateDataSourceFactory, new PagedList.Config.Builder().setPageSize(10).setInitialLoadSizeHint(20).setEnablePlaceholders(false).build()).build();
    }

    @NotNull
    public final LiveData<LoadState> getLoadState() {
        return Transformations.switchMap(this.f14024c.getTemplateDataSourceLiveData(), a.f14025d);
    }

    @NotNull
    public final LiveData<PagedList<MacroTemplate>> getTemplateList() {
        return this.f14022a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f14023b.dispose();
    }

    public final void setTemplateList(@NotNull LiveData<PagedList<MacroTemplate>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.f14022a = liveData;
    }
}
