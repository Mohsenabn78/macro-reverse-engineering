package com.arlosoft.macrodroid.homescreen.favourites;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.databinding.DialogFavouritesBinding;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.arlosoft.macrodroid.widget.SquareMinDimensionMaterialCardView;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FavouritesDialogActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFavouritesDialogActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FavouritesDialogActivity.kt\ncom/arlosoft/macrodroid/homescreen/favourites/FavouritesDialogActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,146:1\n68#2,4:147\n40#2:151\n56#2:152\n75#2:153\n262#2,2:154\n262#2,2:156\n*S KotlinDebug\n*F\n+ 1 FavouritesDialogActivity.kt\ncom/arlosoft/macrodroid/homescreen/favourites/FavouritesDialogActivity\n*L\n60#1:147,4\n60#1:151\n60#1:152\n60#1:153\n139#1:154,2\n142#1:156,2\n*E\n"})
/* loaded from: classes3.dex */
public final class FavouritesDialogActivity extends MacroDroidBaseActivity {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private DialogFavouritesBinding f12340f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final FavouritesDialogActivity$backCallback$1 f12341g = new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.homescreen.favourites.FavouritesDialogActivity$backCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            FavouritesDialogActivity.this.n();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavouritesDialogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FavouritesDialogActivity.this.n();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        DialogFavouritesBinding dialogFavouritesBinding = this.f12340f;
        DialogFavouritesBinding dialogFavouritesBinding2 = null;
        if (dialogFavouritesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding = null;
        }
        dialogFavouritesBinding.title.animate().alpha(0.0f).setDuration(100L);
        DialogFavouritesBinding dialogFavouritesBinding3 = this.f12340f;
        if (dialogFavouritesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding3 = null;
        }
        dialogFavouritesBinding3.emptyText.animate().alpha(0.0f).setDuration(100L);
        DialogFavouritesBinding dialogFavouritesBinding4 = this.f12340f;
        if (dialogFavouritesBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogFavouritesBinding2 = dialogFavouritesBinding4;
        }
        dialogFavouritesBinding2.macroGrid.animate().alpha(0.0f).setDuration(100L);
        new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.homescreen.favourites.a
            @Override // java.lang.Runnable
            public final void run() {
                FavouritesDialogActivity.o(FavouritesDialogActivity.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FavouritesDialogActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f12341g.remove();
            super.onBackPressed();
        } catch (Exception unused) {
        }
    }

    private final void p() {
        List mutableList;
        DialogFavouritesBinding dialogFavouritesBinding = this.f12340f;
        DialogFavouritesBinding dialogFavouritesBinding2 = null;
        if (dialogFavouritesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding = null;
        }
        SquareMinDimensionMaterialCardView squareMinDimensionMaterialCardView = dialogFavouritesBinding.tileContainer;
        Intrinsics.checkNotNullExpressionValue(squareMinDimensionMaterialCardView, "binding.tileContainer");
        if (ViewCompat.isLaidOut(squareMinDimensionMaterialCardView) && !squareMinDimensionMaterialCardView.isLayoutRequested()) {
            DialogFavouritesBinding dialogFavouritesBinding3 = this.f12340f;
            if (dialogFavouritesBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFavouritesBinding3 = null;
            }
            ViewGroup.LayoutParams layoutParams = dialogFavouritesBinding3.topLevelContainer.getLayoutParams();
            DialogFavouritesBinding dialogFavouritesBinding4 = this.f12340f;
            if (dialogFavouritesBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFavouritesBinding4 = null;
            }
            layoutParams.width = dialogFavouritesBinding4.tileContainer.getWidth();
            DialogFavouritesBinding dialogFavouritesBinding5 = this.f12340f;
            if (dialogFavouritesBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFavouritesBinding5 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = dialogFavouritesBinding5.topLevelContainer.getLayoutParams();
            DialogFavouritesBinding dialogFavouritesBinding6 = this.f12340f;
            if (dialogFavouritesBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFavouritesBinding6 = null;
            }
            layoutParams2.height = dialogFavouritesBinding6.tileContainer.getHeight();
        } else {
            squareMinDimensionMaterialCardView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.homescreen.favourites.FavouritesDialogActivity$configureUi$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    DialogFavouritesBinding dialogFavouritesBinding7 = FavouritesDialogActivity.this.f12340f;
                    DialogFavouritesBinding dialogFavouritesBinding8 = null;
                    if (dialogFavouritesBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogFavouritesBinding7 = null;
                    }
                    ViewGroup.LayoutParams layoutParams3 = dialogFavouritesBinding7.topLevelContainer.getLayoutParams();
                    DialogFavouritesBinding dialogFavouritesBinding9 = FavouritesDialogActivity.this.f12340f;
                    if (dialogFavouritesBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogFavouritesBinding9 = null;
                    }
                    layoutParams3.width = dialogFavouritesBinding9.tileContainer.getWidth();
                    DialogFavouritesBinding dialogFavouritesBinding10 = FavouritesDialogActivity.this.f12340f;
                    if (dialogFavouritesBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogFavouritesBinding10 = null;
                    }
                    ViewGroup.LayoutParams layoutParams4 = dialogFavouritesBinding10.topLevelContainer.getLayoutParams();
                    DialogFavouritesBinding dialogFavouritesBinding11 = FavouritesDialogActivity.this.f12340f;
                    if (dialogFavouritesBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        dialogFavouritesBinding8 = dialogFavouritesBinding11;
                    }
                    layoutParams4.height = dialogFavouritesBinding8.tileContainer.getHeight();
                }
            });
        }
        DialogFavouritesBinding dialogFavouritesBinding7 = this.f12340f;
        if (dialogFavouritesBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding7 = null;
        }
        FrameLayout frameLayout = dialogFavouritesBinding7.mainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
        ViewExtensionsKt.onClick$default(frameLayout, null, new a(null), 1, null);
        DialogFavouritesBinding dialogFavouritesBinding8 = this.f12340f;
        if (dialogFavouritesBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding8 = null;
        }
        dialogFavouritesBinding8.macroGrid.setLayoutManager(new GridLayoutManager(this, 2));
        List<Macro> macros = MacroStore.getInstance().getFavouriteMacros();
        Intrinsics.checkNotNullExpressionValue(macros, "macros");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) macros);
        FavouritesAdapter favouritesAdapter = new FavouritesAdapter(mutableList);
        favouritesAdapter.setMacroSelectedListener(new MacroSelectionListener() { // from class: com.arlosoft.macrodroid.homescreen.favourites.FavouritesDialogActivity$configureUi$3
            @Override // com.arlosoft.macrodroid.homescreen.favourites.MacroSelectionListener
            public void onMacroSelected(@NotNull final Macro macro) {
                Intrinsics.checkNotNullParameter(macro, "macro");
                String categoryName = macro.getCategory();
                Cache cache = MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE);
                CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
                if (categoryList != null) {
                    Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
                    Category categoryByName = categoryList.getCategoryByName(categoryName);
                    if (categoryByName != null && categoryByName.isLocked()) {
                        CategoryPasswordHelper categoryPasswordHelper = new CategoryPasswordHelper(cache, null);
                        FavouritesDialogActivity favouritesDialogActivity = FavouritesDialogActivity.this;
                        String string = favouritesDialogActivity.getString(R.string.enter_category_lock_password);
                        String lockedCategoryPassword = Settings.getLockedCategoryPassword(FavouritesDialogActivity.this);
                        final FavouritesDialogActivity favouritesDialogActivity2 = FavouritesDialogActivity.this;
                        categoryPasswordHelper.promptForCategoryPassword(favouritesDialogActivity, string, categoryName, lockedCategoryPassword, R.style.Theme_App_Dialog, new CategoryPasswordHelper.PasswordListener() { // from class: com.arlosoft.macrodroid.homescreen.favourites.FavouritesDialogActivity$configureUi$3$onMacroSelected$1
                            @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                            public void passwordCorrect() {
                                Intent intent = new Intent(FavouritesDialogActivity.this, EditMacroActivity.class);
                                intent.putExtra("MacroId", macro.getId());
                                FavouritesDialogActivity.this.startActivity(intent);
                                FavouritesDialogActivity.this.finish();
                            }

                            @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                            public void passwordCancelled() {
                            }
                        });
                        return;
                    }
                    Intent intent = new Intent(FavouritesDialogActivity.this, EditMacroActivity.class);
                    intent.putExtra("MacroId", macro.getId());
                    FavouritesDialogActivity.this.startActivity(intent);
                    FavouritesDialogActivity.this.finish();
                    return;
                }
                Intent intent2 = new Intent(FavouritesDialogActivity.this, EditMacroActivity.class);
                intent2.putExtra("MacroId", macro.getId());
                FavouritesDialogActivity.this.startActivity(intent2);
                FavouritesDialogActivity.this.finish();
            }
        });
        q(macros, macros.isEmpty());
        DialogFavouritesBinding dialogFavouritesBinding9 = this.f12340f;
        if (dialogFavouritesBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding9 = null;
        }
        dialogFavouritesBinding9.macroGrid.setAdapter(favouritesAdapter);
        DialogFavouritesBinding dialogFavouritesBinding10 = this.f12340f;
        if (dialogFavouritesBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding10 = null;
        }
        dialogFavouritesBinding10.title.animate().alpha(1.0f).setDuration(500L);
        DialogFavouritesBinding dialogFavouritesBinding11 = this.f12340f;
        if (dialogFavouritesBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding11 = null;
        }
        dialogFavouritesBinding11.emptyText.animate().alpha(1.0f).setDuration(500L);
        DialogFavouritesBinding dialogFavouritesBinding12 = this.f12340f;
        if (dialogFavouritesBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding12 = null;
        }
        dialogFavouritesBinding12.macroGrid.animate().alpha(1.0f).setDuration(500L);
        DialogFavouritesBinding dialogFavouritesBinding13 = this.f12340f;
        if (dialogFavouritesBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogFavouritesBinding2 = dialogFavouritesBinding13;
        }
        RecyclerView.ItemAnimator itemAnimator = dialogFavouritesBinding2.macroGrid.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
    }

    private final void q(List<? extends Macro> list, boolean z3) {
        int i4;
        int i5 = 4;
        DialogFavouritesBinding dialogFavouritesBinding = null;
        if (z3) {
            DialogFavouritesBinding dialogFavouritesBinding2 = this.f12340f;
            if (dialogFavouritesBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFavouritesBinding2 = null;
            }
            TextView textView = dialogFavouritesBinding2.emptyText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.emptyText");
            textView.setVisibility(0);
            DialogFavouritesBinding dialogFavouritesBinding3 = this.f12340f;
            if (dialogFavouritesBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogFavouritesBinding = dialogFavouritesBinding3;
            }
            dialogFavouritesBinding.macroGrid.setVisibility(4);
            return;
        }
        DialogFavouritesBinding dialogFavouritesBinding4 = this.f12340f;
        if (dialogFavouritesBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFavouritesBinding4 = null;
        }
        TextView textView2 = dialogFavouritesBinding4.emptyText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.emptyText");
        if (list.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView2.setVisibility(i4);
        DialogFavouritesBinding dialogFavouritesBinding5 = this.f12340f;
        if (dialogFavouritesBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogFavouritesBinding = dialogFavouritesBinding5;
        }
        RecyclerView recyclerView = dialogFavouritesBinding.macroGrid;
        if (!list.isEmpty()) {
            i5 = 0;
        }
        recyclerView.setVisibility(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DialogFavouritesBinding inflate = DialogFavouritesBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12340f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        getOnBackPressedDispatcher().addCallback(this.f12341g);
        p();
    }
}
