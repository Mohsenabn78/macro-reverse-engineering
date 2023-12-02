package com.arlosoft.macrodroid.templatestore.ui.upload;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.mvp.Presenter;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.model.UploadMacroBody;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.google.gson.Gson;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: TemplateUploadPresenter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateUploadPresenter extends Presenter<TemplateUploadViewContract> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final TemplateStoreApi f14148b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final UserProvider f14149c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Gson f14150d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Context f14151e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final TemplateRefreshNotifier f14152f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final CategoriesHelper f14153g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final ActionBlockStore f14154h;

    /* renamed from: i  reason: collision with root package name */
    private CompositeDisposable f14155i;

    /* renamed from: j  reason: collision with root package name */
    private int f14156j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private String f14157k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f14158l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateUploadPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Throwable, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if ((th instanceof HttpException) && ((HttpException) th).code() == 403) {
                TemplateUploadViewContract view = TemplateUploadPresenter.this.getView();
                if (view != null) {
                    view.hideTemplatePreviewDialog();
                }
                TemplateUploadViewContract view2 = TemplateUploadPresenter.this.getView();
                if (view2 != null) {
                    view2.showDuplicateError();
                    return;
                }
                return;
            }
            SystemLog.logError("Template upload failed: " + th);
            TemplateUploadViewContract view3 = TemplateUploadPresenter.this.getView();
            if (view3 != null) {
                view3.showUploadFailedError();
            }
            TemplateUploadViewContract view4 = TemplateUploadPresenter.this.getView();
            if (view4 != null) {
                view4.setUploadingState(false);
            }
        }
    }

    @Inject
    public TemplateUploadPresenter(@NotNull TemplateStoreApi api, @NotNull UserProvider userProvider, @NotNull Gson gson, @ApplicationContext @NotNull Context context, @NotNull TemplateRefreshNotifier templateRefreshNotifier, @NotNull CategoriesHelper categoriesHelper, @NotNull ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRefreshNotifier, "templateRefreshNotifier");
        Intrinsics.checkNotNullParameter(categoriesHelper, "categoriesHelper");
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        this.f14148b = api;
        this.f14149c = userProvider;
        this.f14150d = gson;
        this.f14151e = context;
        this.f14152f = templateRefreshNotifier;
        this.f14153g = categoriesHelper;
        this.f14154h = actionBlockStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Macro macro, String str, String str2) {
        Intrinsics.checkNotNullParameter(macro, "$macro");
        macro.setName(str);
        macro.setDescription(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TemplateUploadPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateUploadViewContract view = this$0.getView();
        if (view != null) {
            view.hideTemplatePreviewDialog();
        }
        TemplateUploadViewContract view2 = this$0.getView();
        if (view2 != null) {
            view2.closeUploadScreen();
        }
        TemplateUploadViewContract view3 = this$0.getView();
        if (view3 != null) {
            view3.showUploadedOk();
        }
        this$0.f14152f.notifyRefreshRequired();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Completable i(String str, UploadMacroBody uploadMacroBody, boolean z3, int i4) {
        if (z3 && i4 > 0) {
            TemplateStoreApi templateStoreApi = this.f14148b;
            return templateStoreApi.updateMacro(StringExtensionsKt.sha256(TemplateStoreApiKt.TEMPLATE_API_SALT + i4), i4, uploadMacroBody);
        }
        return this.f14148b.uploadMacro(str, uploadMacroBody);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void a() {
        CompositeDisposable compositeDisposable = this.f14155i;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void b() {
        this.f14155i = new CompositeDisposable();
    }

    public final void handleMacroToUpdate(@NotNull Macro macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        onMacroSelected(macro);
    }

    public final void onDetailsSubmitted(@NotNull String name, @NotNull String description, @NotNull Macro macro, @NotNull String languageCode, int i4, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        if (name.length() >= 5 && name.length() <= 100 && description.length() >= 20 && description.length() <= 2000) {
            if (i4 == 0) {
                TemplateUploadViewContract view = getView();
                if (view != null) {
                    view.showSelectCategory();
                    return;
                }
                return;
            }
            TemplateUploadViewContract view2 = getView();
            if (view2 != null) {
                view2.dismissCategoryAndDescriptionDialog();
            }
            macro.setDescription(description);
            macro.setName(name);
            macro.configureForExport();
            macro.initialiseExportedActionBlocks(this.f14154h);
            String encodedJSON = URLEncoder.encode(this.f14150d.toJson(macro), "UTF-8");
            User user = this.f14149c.getUser();
            macro.clearExportedActionBlocks();
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                next.setMacro(macro);
                next.anonymizeForTemplate();
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                Action next2 = it2.next();
                next2.setMacro(macro);
                next2.anonymizeForTemplate();
            }
            for (Constraint constraint : macro.getConstraints()) {
                constraint.setMacro(macro);
                constraint.anonymizeForTemplate();
            }
            String name2 = macro.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "macro.name");
            String username = user.getUsername();
            String description2 = macro.getDescription();
            Intrinsics.checkNotNullExpressionValue(description2, "macro.description");
            Intrinsics.checkNotNullExpressionValue(encodedJSON, "encodedJSON");
            MacroTemplate macroTemplate = new MacroTemplate(name2, null, username, description2, null, "", encodedJSON, languageCode, 0, System.currentTimeMillis(), user.getImage(), 0, user.getUserId(), 0, 0, 0, false, macro, false, false, 0, 0L, 3932160, null);
            TemplateUploadViewContract view3 = getView();
            if (view3 != null) {
                view3.displayTemplatePreviewDialog(macroTemplate, i4, z3);
                return;
            }
            return;
        }
        TemplateUploadViewContract view4 = getView();
        if (view4 != null) {
            view4.showInvalidDataError();
        }
    }

    public final void onMacroSelected(@NotNull Macro macro) {
        boolean z3;
        Intrinsics.checkNotNullParameter(macro, "macro");
        CategoriesHelper categoriesHelper = this.f14153g;
        String category = macro.getCategory();
        Intrinsics.checkNotNullExpressionValue(category, "macro.category");
        int categoryIdFromName = categoriesHelper.categoryIdFromName(category);
        TemplateUploadViewContract view = getView();
        if (view != null) {
            Macro cloneMacro = macro.cloneMacro(false, false);
            Intrinsics.checkNotNullExpressionValue(cloneMacro, "macro.cloneMacro(false, false)");
            if (this.f14156j > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            view.displayCategoryAndDescriptionDialog(cloneMacro, categoryIdFromName, z3, this.f14157k, this.f14158l);
        }
    }

    public final void setUpdatingMacroDetails(int i4, @Nullable String str, @Nullable String str2) {
        this.f14156j = i4;
        this.f14157k = str;
        this.f14158l = str2;
    }

    public final void uploadMacro(@NotNull final Macro macro, @NotNull String language, int i4, boolean z3) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(language, "language");
        TemplateUploadViewContract view = getView();
        if (view != null) {
            view.setUploadingState(true);
        }
        final String description = macro.getDescription();
        final String name = macro.getName();
        macro.setDescription("");
        macro.setName("");
        macro.initialiseExportedActionBlocks(this.f14154h);
        Iterator<Action> it = macro.getActions().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            if (next instanceof ParentAction) {
                ((ParentAction) next).setChildrenCollapsed(false);
            }
        }
        String json = URLEncoder.encode(this.f14150d.toJson(macro), "UTF-8");
        macro.clearExportedActionBlocks();
        int userId = this.f14149c.getUser().getUserId();
        String sha256 = StringExtensionsKt.sha256(i4 + name + TemplateStoreApiKt.TEMPLATE_API_SALT + userId);
        CompositeDisposable compositeDisposable = this.f14155i;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        CompositeDisposable compositeDisposable2 = compositeDisposable;
        int userId2 = this.f14149c.getUser().getUserId();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        Intrinsics.checkNotNullExpressionValue(description, "description");
        Intrinsics.checkNotNullExpressionValue(json, "json");
        Completable doFinally = Completable.mergeArray(Completable.timer(2L, TimeUnit.SECONDS), i(sha256, new UploadMacroBody(userId2, name, description, json, i4, language, 9999), z3, this.f14156j)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new io.reactivex.functions.Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.j
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateUploadPresenter.f(Macro.this, name, description);
            }
        });
        io.reactivex.functions.Action action = new io.reactivex.functions.Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.k
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateUploadPresenter.g(TemplateUploadPresenter.this);
            }
        };
        final a aVar = new a();
        compositeDisposable2.add(doFinally.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateUploadPresenter.h(Function1.this, obj);
            }
        }));
    }
}
