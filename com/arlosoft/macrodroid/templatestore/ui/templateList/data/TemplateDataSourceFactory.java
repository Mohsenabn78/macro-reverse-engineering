package com.arlosoft.macrodroid.templatestore.ui.templateList.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.database.room.BlockedMacro;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.settings.AppPreferences;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.google.gson.Gson;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TemplateDataSourceFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateDataSourceFactory extends DataSource.Factory<Integer, MacroTemplate> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Gson f14008a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final TemplateStoreApi f14009b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CompositeDisposable f14010c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14011d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14012e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14013f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14014g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final String f14015h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final AppPreferences f14016i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final CategoriesHelper f14017j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final String f14018k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final List<BlockedUser> f14019l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final List<BlockedMacro> f14020m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<TemplatesDataSource> f14021n;

    public TemplateDataSourceFactory(@NotNull Gson gson, @NotNull TemplateStoreApi api, @NotNull CompositeDisposable compositeDisposable, int i4, int i5, int i6, int i7, @NotNull String searchTerm, @NotNull AppPreferences appPreferences, @NotNull CategoriesHelper categoriesHelper, @NotNull String language, @NotNull List<BlockedUser> blockedUsers, @NotNull List<BlockedMacro> blockedMacros) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        Intrinsics.checkNotNullParameter(appPreferences, "appPreferences");
        Intrinsics.checkNotNullParameter(categoriesHelper, "categoriesHelper");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        Intrinsics.checkNotNullParameter(blockedMacros, "blockedMacros");
        this.f14008a = gson;
        this.f14009b = api;
        this.f14010c = compositeDisposable;
        this.f14011d = i4;
        this.f14012e = i5;
        this.f14013f = i6;
        this.f14014g = i7;
        this.f14015h = searchTerm;
        this.f14016i = appPreferences;
        this.f14017j = categoriesHelper;
        this.f14018k = language;
        this.f14019l = blockedUsers;
        this.f14020m = blockedMacros;
        this.f14021n = new MutableLiveData<>();
    }

    @Override // androidx.paging.DataSource.Factory
    @NotNull
    public DataSource<Integer, MacroTemplate> create() {
        TemplatesDataSource templatesDataSource = new TemplatesDataSource(this.f14008a, this.f14009b, this.f14010c, this.f14011d, this.f14012e, this.f14013f, this.f14014g, this.f14015h, this.f14016i, this.f14017j, this.f14018k, this.f14019l, this.f14020m);
        this.f14021n.postValue(templatesDataSource);
        return templatesDataSource;
    }

    @NotNull
    public final MutableLiveData<TemplatesDataSource> getTemplateDataSourceLiveData() {
        return this.f14021n;
    }
}
