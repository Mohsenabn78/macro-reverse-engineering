package com.arlosoft.macrodroid.templatestore.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import androidx.viewpager.widget.ViewPager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.databinding.FragmentTemplateStoreBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.model.TemplateCategory;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileActivity;
import com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity;
import com.arlosoft.macrodroid.templatestore.ui.subscription.MySubscriptionsActivity;
import com.arlosoft.macrodroid.templatestore.ui.subscription.TemplateUpdatesFragment;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateCategoryManager;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadActivity;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.arlosoft.macrodroid.utils.transformations.CubeInRotationTransformation;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.SnackbarAnimate;
import com.google.android.material.tabs.TabLayout;
import com.google.mlkit.nl.translate.TranslateLanguage;
import es.dmoral.toasty.Toasty;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateStoreFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTemplateStoreFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateStoreFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/TemplateStoreFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,496:1\n262#2,2:497\n260#2:507\n262#2,2:508\n1549#3:499\n1620#3,3:500\n1549#3:503\n1620#3,3:504\n*S KotlinDebug\n*F\n+ 1 TemplateStoreFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/TemplateStoreFragment\n*L\n156#1:497,2\n236#1:507\n490#1:508,2\n204#1:499\n204#1:500,3\n212#1:503\n212#1:504,3\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplateStoreFragment extends MacroDroidDaggerBaseFragment implements SearchTermProvider {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final List<String> f13709i;

    /* renamed from: b  reason: collision with root package name */
    private PageAdapter f13710b;
    @Inject
    public TemplateCategoryManager categoryManager;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private MenuItem f13712d;

    /* renamed from: f  reason: collision with root package name */
    private CompositeDisposable f13714f;

    /* renamed from: h  reason: collision with root package name */
    private FragmentTemplateStoreBinding f13716h;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public RemoteConfig remoteConfig;
    @Inject
    public ScreenLoader screenLoader;
    @Inject
    public SignInHelper signInHelper;
    @Inject
    public TemplatesTranslationHelper translationHelper;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private String f13711c = "";
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<SearchTermListener> f13713e = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private boolean f13715g = true;

    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public final class PageAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f13717a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f13718b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private TemplateStoreList f13719c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TemplateStoreFragment f13720d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageAdapter(@NotNull TemplateStoreFragment templateStoreFragment, FragmentManager fm, boolean z3, boolean z4) {
            super(fm);
            Intrinsics.checkNotNullParameter(fm, "fm");
            this.f13720d = templateStoreFragment;
            this.f13717a = z3;
            this.f13718b = z4;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return (this.f13717a ? 1 : 0) + 4 + (this.f13718b ? 1 : 0);
        }

        @Nullable
        public final TemplateStoreList getCurrentFragment() {
            return this.f13719c;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int i4) {
            boolean z3 = this.f13718b;
            if (z3 && i4 == 0) {
                return TemplateUpdatesFragment.Companion.newInstance();
            }
            if (i4 == z3) {
                return TemplateListFragment.Companion.newInstance$default(TemplateListFragment.Companion, 2, 0, false, this.f13717a, false, false, 54, null);
            }
            if (i4 == (z3 ? 1 : 0) + 1) {
                return TemplateListFragment.Companion.newInstance$default(TemplateListFragment.Companion, 0, 0, false, this.f13717a, false, false, 54, null);
            }
            if (i4 == (z3 ? 1 : 0) + 2) {
                return TemplateListFragment.Companion.newInstance$default(TemplateListFragment.Companion, 1, 0, false, this.f13717a, false, false, 54, null);
            }
            if (i4 == (z3 ? 1 : 0) + 3) {
                return UserListFragment.Companion.newInstance();
            }
            if (i4 == (z3 ? 1 : 0) + 4) {
                return TemplateListFragment.Companion.newInstance$default(TemplateListFragment.Companion, 3, 0, false, true, true, false, 38, null);
            }
            return UserListFragment.Companion.newInstance();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i4) {
            boolean z3 = this.f13718b;
            if (z3 && i4 == 0) {
                return this.f13720d.getString(R.string.template_store_updates);
            }
            if (i4 == z3) {
                return this.f13720d.getString(R.string.template_store_top_new);
            }
            if (i4 == (z3 ? 1 : 0) + 1) {
                return this.f13720d.getString(R.string.template_store_top_rated);
            }
            if (i4 == (z3 ? 1 : 0) + 2) {
                return this.f13720d.getString(R.string.template_store_latest);
            }
            if (i4 == (z3 ? 1 : 0) + 3) {
                return this.f13720d.getString(R.string.template_store_top_users);
            }
            if (i4 == (z3 ? 1 : 0) + 4) {
                return this.f13720d.getString(R.string.template_store_most_reported);
            }
            return "????";
        }

        public final void setCurrentFragment(@Nullable TemplateStoreList templateStoreList) {
            this.f13719c = templateStoreList;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NotNull ViewGroup container, int i4, @NotNull Object item) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.f13719c != item) {
                this.f13719c = (TemplateStoreList) item;
            }
            super.setPrimaryItem(container, i4, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $language;
        final /* synthetic */ MenuItem $menuItem;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateStoreFragment.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0113a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $language;
            final /* synthetic */ MenuItem $menuItem;
            int label;
            final /* synthetic */ TemplateStoreFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateStoreFragment.kt */
            @SourceDebugExtension({"SMAP\nTemplateStoreFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateStoreFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/TemplateStoreFragment$enableAutoTranslate$1$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,496:1\n262#2,2:497\n*S KotlinDebug\n*F\n+ 1 TemplateStoreFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/TemplateStoreFragment$enableAutoTranslate$1$1$1\n*L\n305#1:497,2\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0114a extends Lambda implements Function0<Unit> {
                final /* synthetic */ String $language;
                final /* synthetic */ MenuItem $menuItem;
                final /* synthetic */ TemplateStoreFragment this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TemplateStoreFragment.kt */
                @SourceDebugExtension({"SMAP\nTemplateStoreFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateStoreFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/TemplateStoreFragment$enableAutoTranslate$1$1$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,496:1\n262#2,2:497\n*S KotlinDebug\n*F\n+ 1 TemplateStoreFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/TemplateStoreFragment$enableAutoTranslate$1$1$1$1\n*L\n307#1:497,2\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C0115a extends Lambda implements Function1<Boolean, Unit> {
                    final /* synthetic */ String $language;
                    final /* synthetic */ MenuItem $menuItem;
                    final /* synthetic */ TemplateStoreFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0115a(TemplateStoreFragment templateStoreFragment, String str, MenuItem menuItem) {
                        super(1);
                        this.this$0 = templateStoreFragment;
                        this.$language = str;
                        this.$menuItem = menuItem;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z3) {
                        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.this$0.f13716h;
                        if (fragmentTemplateStoreBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            fragmentTemplateStoreBinding = null;
                        }
                        FrameLayout frameLayout = fragmentTemplateStoreBinding.loadingBlocker;
                        if (frameLayout != null) {
                            frameLayout.setVisibility(8);
                        }
                        if (z3) {
                            Settings.setTemplateStoreAutoTranslateLanguage(MacroDroidApplication.Companion.getInstance(), this.$language);
                            if (!this.this$0.isAdded() || this.this$0.getContext() == null) {
                                return;
                            }
                            MenuItem menuItem = this.$menuItem;
                            if (menuItem != null) {
                                menuItem.setChecked(true);
                            }
                            this.this$0.m();
                            return;
                        }
                        Context context = this.this$0.getContext();
                        if (context != null) {
                            ToastCompat.makeText(context, (CharSequence) context.getString(R.string.error), 1).show();
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0114a(TemplateStoreFragment templateStoreFragment, String str, MenuItem menuItem) {
                    super(0);
                    this.this$0 = templateStoreFragment;
                    this.$language = str;
                    this.$menuItem = menuItem;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.this$0.f13716h;
                    if (fragmentTemplateStoreBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentTemplateStoreBinding = null;
                    }
                    FrameLayout frameLayout = fragmentTemplateStoreBinding.loadingBlocker;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                    TemplatesTranslationHelper translationHelper = this.this$0.getTranslationHelper();
                    String language = this.$language;
                    Intrinsics.checkNotNullExpressionValue(language, "language");
                    translationHelper.enableTranslation(language, new C0115a(this.this$0, this.$language, this.$menuItem));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0113a(TemplateStoreFragment templateStoreFragment, String str, MenuItem menuItem, Continuation<? super C0113a> continuation) {
                super(2, continuation);
                this.this$0 = templateStoreFragment;
                this.$language = str;
                this.$menuItem = menuItem;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0113a(this.this$0, this.$language, this.$menuItem, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TemplatesTranslationHelper translationHelper = this.this$0.getTranslationHelper();
                    FragmentActivity requireActivity = this.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    String displayLanguage = Locale.getDefault().getDisplayLanguage();
                    Intrinsics.checkNotNullExpressionValue(displayLanguage, "getDefault().displayLanguage");
                    translationHelper.displayModelDownloadDialog(requireActivity, displayLanguage, new C0114a(this.this$0, this.$language, this.$menuItem));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0113a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateStoreFragment.kt */
        /* loaded from: classes3.dex */
        public static final class b extends Lambda implements Function1<Boolean, Unit> {
            final /* synthetic */ String $language;
            final /* synthetic */ MenuItem $menuItem;
            final /* synthetic */ TemplateStoreFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(MenuItem menuItem, TemplateStoreFragment templateStoreFragment, String str) {
                super(1);
                this.$menuItem = menuItem;
                this.this$0 = templateStoreFragment;
                this.$language = str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z3) {
                if (z3) {
                    MenuItem menuItem = this.$menuItem;
                    if (menuItem != null) {
                        menuItem.setChecked(true);
                    }
                    Settings.setTemplateStoreAutoTranslateLanguage(this.this$0.requireContext(), this.$language);
                    this.this$0.m();
                    return;
                }
                Context context = this.this$0.getContext();
                if (context != null) {
                    ToastCompat.makeText(context, (CharSequence) context.getString(R.string.error), 1).show();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, MenuItem menuItem, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$language = str;
            this.$menuItem = menuItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$language, this.$menuItem, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                TemplatesTranslationHelper translationHelper = TemplateStoreFragment.this.getTranslationHelper();
                String language = this.$language;
                Intrinsics.checkNotNullExpressionValue(language, "language");
                this.label = 1;
                obj = translationHelper.isModelAvailable(language, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!((Boolean) obj).booleanValue()) {
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C0113a c0113a = new C0113a(TemplateStoreFragment.this, this.$language, this.$menuItem, null);
                this.label = 2;
                if (BuildersKt.withContext(main, c0113a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                TemplatesTranslationHelper translationHelper2 = TemplateStoreFragment.this.getTranslationHelper();
                String language2 = this.$language;
                Intrinsics.checkNotNullExpressionValue(language2, "language");
                translationHelper2.enableTranslation(language2, new b(this.$menuItem, TemplateStoreFragment.this, this.$language));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function0<Unit> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TemplateStoreFragment.this.getScreenLoader().loadUpgradeScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function0<Unit> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TemplateStoreFragment.this.signIn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ List<TemplateCategory> $categories;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List<TemplateCategory> list) {
            super(1);
            this.$categories = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i4) {
            if (TemplateStoreFragment.this.f13715g) {
                TemplateStoreFragment.this.f13715g = false;
                return;
            }
            TemplateStoreFragment.this.getCategoryManager().setLastChosenCategoryId(Integer.valueOf(this.$categories.get(i4).getId()));
            TemplateStoreFragment.this.l(this.$categories.get(i4).getId());
        }
    }

    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateStoreFragment.this.startActivity(new Intent(TemplateStoreFragment.this.requireActivity(), TemplateSearchActivity.class));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function0<Unit> {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FirebaseAnalyticsEventLogger.logAnonymousSignInFailed();
            FragmentTemplateStoreBinding fragmentTemplateStoreBinding = TemplateStoreFragment.this.f13716h;
            if (fragmentTemplateStoreBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreBinding = null;
            }
            fragmentTemplateStoreBinding.viewFlipper.setDisplayedChild(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        g(Continuation<? super g> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FragmentTemplateStoreBinding fragmentTemplateStoreBinding = TemplateStoreFragment.this.f13716h;
                if (fragmentTemplateStoreBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentTemplateStoreBinding = null;
                }
                fragmentTemplateStoreBinding.infoBar.collapse();
                Settings.setShowAutoTranslatePopup(TemplateStoreFragment.this.requireContext(), false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateStoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        h(Continuation<? super h> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateStoreFragment templateStoreFragment = TemplateStoreFragment.this;
                templateStoreFragment.f(templateStoreFragment.f13712d);
                FragmentTemplateStoreBinding fragmentTemplateStoreBinding = TemplateStoreFragment.this.f13716h;
                if (fragmentTemplateStoreBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentTemplateStoreBinding = null;
                }
                fragmentTemplateStoreBinding.infoBar.collapse();
                Settings.setShowAutoTranslatePopup(TemplateStoreFragment.this.requireContext(), false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"en", TranslateLanguage.SPANISH, "jp"});
        f13709i = listOf;
    }

    private final void d() {
        boolean z3;
        boolean z4;
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.f13716h;
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding2 = null;
        if (fragmentTemplateStoreBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding = null;
        }
        MenuItem findItem = fragmentTemplateStoreBinding.toolbar.getMenu().findItem(R.id.menu_upload);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding3 = this.f13716h;
        if (fragmentTemplateStoreBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding3 = null;
        }
        MenuItem findItem2 = fragmentTemplateStoreBinding3.toolbar.getMenu().findItem(R.id.menu_my_profile);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding4 = this.f13716h;
        if (fragmentTemplateStoreBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding4 = null;
        }
        MenuItem findItem3 = fragmentTemplateStoreBinding4.toolbar.getMenu().findItem(R.id.menu_sign_in);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding5 = this.f13716h;
        if (fragmentTemplateStoreBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding5 = null;
        }
        MenuItem findItem4 = fragmentTemplateStoreBinding5.toolbar.getMenu().findItem(R.id.menu_my_subscriptions);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding6 = this.f13716h;
        if (fragmentTemplateStoreBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding6 = null;
        }
        Spinner spinner = fragmentTemplateStoreBinding6.categoriesSpinner;
        Intrinsics.checkNotNullExpressionValue(spinner, "binding.categoriesSpinner");
        boolean z5 = true;
        if (spinner.getVisibility() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        findItem.setVisible(z3);
        if (z3 && !getUserProvider().getUser().isGuest()) {
            z4 = true;
        } else {
            z4 = false;
        }
        findItem2.setVisible(z4);
        findItem3.setVisible(!findItem2.isVisible());
        findItem4.setVisible((!z3 || getUserProvider().getUser().isGuest()) ? false : false);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding7 = this.f13716h;
        if (fragmentTemplateStoreBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding7 = null;
        }
        fragmentTemplateStoreBinding7.toolbar.getMenu().findItem(R.id.menu_compact_mode).setChecked(Settings.getTemplateStoreCompactMode(requireContext()));
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding8 = this.f13716h;
        if (fragmentTemplateStoreBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding8 = null;
        }
        this.f13712d = fragmentTemplateStoreBinding8.toolbar.getMenu().findItem(R.id.auto_translate);
        if (f13709i.contains(Locale.getDefault().getLanguage())) {
            MenuItem menuItem = this.f13712d;
            Intrinsics.checkNotNull(menuItem);
            menuItem.setVisible(false);
        } else {
            String language = Locale.getDefault().getLanguage();
            MenuItem menuItem2 = this.f13712d;
            Intrinsics.checkNotNull(menuItem2);
            menuItem2.setChecked(Intrinsics.areEqual(Settings.getTemplateStoreAutoTranslateLanguage(requireContext()), language));
        }
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding9 = this.f13716h;
        if (fragmentTemplateStoreBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreBinding2 = fragmentTemplateStoreBinding9;
        }
        fragmentTemplateStoreBinding2.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.a
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem3) {
                boolean e4;
                e4 = TemplateStoreFragment.e(TemplateStoreFragment.this, menuItem3);
                return e4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(TemplateStoreFragment this$0, MenuItem it) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            num = Integer.valueOf(it.getItemId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.menu_my_profile) {
            this$0.g();
        } else if (num != null && num.intValue() == R.id.menu_my_subscriptions) {
            this$0.h();
        } else if (num != null && num.intValue() == R.id.menu_upload) {
            this$0.i();
        } else if (num != null && num.intValue() == R.id.menu_sign_in) {
            this$0.signIn();
        } else if (num != null && num.intValue() == R.id.menu_compact_mode) {
            it.setChecked(!it.isChecked());
            Settings.setTemplateStoreCompactMode(this$0.requireContext(), it.isChecked());
            this$0.m();
        } else if (num != null && num.intValue() == R.id.auto_translate) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.r(it);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MenuItem menuItem) {
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(Locale.getDefault().getLanguage(), menuItem, null), 2, null);
    }

    private final void g() {
        ProfileActivity.Companion companion = ProfileActivity.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        startActivity(companion.createIntent(requireActivity, false, "", true));
    }

    private final void h() {
        MySubscriptionsActivity.Companion companion = MySubscriptionsActivity.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.launchScreen(requireActivity);
    }

    private final void i() {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            if (getRemoteConfig().shouldAutoShowUpgradeScreen()) {
                Toasty.Config.getInstance().setTextColor(-1).apply();
                Toast custom = Toasty.custom((Context) requireActivity(), (CharSequence) getString(R.string.sorry_pro_users_only_upload_templates), (int) R.drawable.ic_error_outline_white_24dp, -16777216, 1, true, true);
                custom.setGravity(17, 0, 0);
                custom.show();
                UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                companion.animateInUpgradeSceen(requireActivity);
                return;
            }
            String string = getString(R.string.sorry_pro_users_only_upload_templates);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sorry…rs_only_upload_templates)");
            String string2 = getString(R.string.upgrade);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.upgrade)");
            n(string, string2, new b());
        } else if (getUserProvider().getUser().isGuest()) {
            String string3 = getString(R.string.please_sign_in_template_store);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.please_sign_in_template_store)");
            String string4 = getString(R.string.sign_in);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.sign_in)");
            n(string3, string4, new c());
        } else {
            startActivity(new Intent(requireActivity(), TemplateUploadActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(User user) {
        d();
        try {
            String string = getString(R.string.templates_signed_in_popup, user.getUsername());
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…_in_popup, user.username)");
            ToastCompat.makeText(requireContext(), (CharSequence) string, 1).show();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    private final void k() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        TemplateCategory.Companion companion = TemplateCategory.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = null;
        List allCategories$default = TemplateCategory.Companion.getAllCategories$default(companion, requireContext, false, 2, null);
        List<TemplateCategory> list = allCategories$default;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TemplateCategory templateCategory : list) {
            arrayList.add(templateCategory.getName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), (int) R.layout.simple_spinner_item_title_white_text, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding2 = this.f13716h;
        if (fragmentTemplateStoreBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding2 = null;
        }
        fragmentTemplateStoreBinding2.categoriesSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        if (getCategoryManager().getLastChosenCategoryId() != null) {
            Integer lastChosenCategoryId = getCategoryManager().getLastChosenCategoryId();
            if (lastChosenCategoryId != null) {
                int intValue = lastChosenCategoryId.intValue();
                collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                for (TemplateCategory templateCategory2 : list) {
                    arrayList2.add(Integer.valueOf(templateCategory2.getId()));
                }
                int indexOf = arrayList2.indexOf(Integer.valueOf(intValue));
                FragmentTemplateStoreBinding fragmentTemplateStoreBinding3 = this.f13716h;
                if (fragmentTemplateStoreBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentTemplateStoreBinding3 = null;
                }
                fragmentTemplateStoreBinding3.categoriesSpinner.setSelection(indexOf);
            }
        } else {
            FragmentTemplateStoreBinding fragmentTemplateStoreBinding4 = this.f13716h;
            if (fragmentTemplateStoreBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreBinding4 = null;
            }
            fragmentTemplateStoreBinding4.categoriesSpinner.setSelection(arrayList.indexOf(getString(R.string.all_categories)));
        }
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding5 = this.f13716h;
        if (fragmentTemplateStoreBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreBinding = fragmentTemplateStoreBinding5;
        }
        Spinner spinner = fragmentTemplateStoreBinding.categoriesSpinner;
        Intrinsics.checkNotNullExpressionValue(spinner, "binding.categoriesSpinner");
        ViewExtensionsKt.itemSelected(spinner, new d(allCategories$default));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int i4) {
        getCategoryManager().setCategory(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        boolean z3 = !getUserProvider().getUser().isGuest();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this.childFragmentManager");
        this.f13710b = new PageAdapter(this, childFragmentManager, getUserProvider().getUser().isModerator(), z3);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.f13716h;
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding2 = null;
        if (fragmentTemplateStoreBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding = null;
        }
        ViewPager viewPager = fragmentTemplateStoreBinding.viewPager;
        PageAdapter pageAdapter = this.f13710b;
        if (pageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vpAdapter");
            pageAdapter = null;
        }
        viewPager.setAdapter(pageAdapter);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding3 = this.f13716h;
        if (fragmentTemplateStoreBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding3 = null;
        }
        fragmentTemplateStoreBinding3.viewPager.setOffscreenPageLimit(4);
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding4 = this.f13716h;
        if (fragmentTemplateStoreBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding4 = null;
        }
        fragmentTemplateStoreBinding4.viewPager.setPageTransformer(true, new CubeInRotationTransformation());
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding5 = this.f13716h;
        if (fragmentTemplateStoreBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding5 = null;
        }
        TabLayout tabLayout = fragmentTemplateStoreBinding5.tabBar;
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding6 = this.f13716h;
        if (fragmentTemplateStoreBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding6 = null;
        }
        tabLayout.setupWithViewPager(fragmentTemplateStoreBinding6.viewPager);
        if (z3) {
            FragmentTemplateStoreBinding fragmentTemplateStoreBinding7 = this.f13716h;
            if (fragmentTemplateStoreBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreBinding7 = null;
            }
            fragmentTemplateStoreBinding7.viewPager.setCurrentItem(1, false);
        }
        if (Settings.getAppLaunchCount(requireContext()) < 2) {
            FragmentTemplateStoreBinding fragmentTemplateStoreBinding8 = this.f13716h;
            if (fragmentTemplateStoreBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreBinding8 = null;
            }
            fragmentTemplateStoreBinding8.viewPager.setCurrentItem(1);
        }
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding9 = this.f13716h;
        if (fragmentTemplateStoreBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreBinding2 = fragmentTemplateStoreBinding9;
        }
        fragmentTemplateStoreBinding2.tabBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment$setupViewPager$1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(@Nullable TabLayout.Tab tab) {
                TemplateStoreFragment.PageAdapter pageAdapter2;
                pageAdapter2 = TemplateStoreFragment.this.f13710b;
                if (pageAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vpAdapter");
                    pageAdapter2 = null;
                }
                TemplateStoreList currentFragment = pageAdapter2.getCurrentFragment();
                if (currentFragment != null) {
                    currentFragment.scrollToTop();
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@Nullable TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(@Nullable TabLayout.Tab tab) {
            }
        });
    }

    private final void n(String str, String str2, final Function0<Unit> function0) {
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.f13716h;
        if (fragmentTemplateStoreBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding = null;
        }
        SnackbarAnimate make = SnackbarAnimate.make(fragmentTemplateStoreBinding.coordinatorLayout, str, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(binding.coordinator…yout, errorMessage, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.setAction(str2, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateStoreFragment.o(Function0.this, view);
            }
        });
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 action, View view) {
        Intrinsics.checkNotNullParameter(action, "$action");
        action.invoke();
    }

    private final void p() {
        if (!f13709i.contains(Locale.getDefault().getLanguage()) && Settings.getShowAutoTranslatePopup(requireContext())) {
            FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.f13716h;
            if (fragmentTemplateStoreBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreBinding = null;
            }
            fragmentTemplateStoreBinding.infoBar.expand();
            FragmentTemplateStoreBinding fragmentTemplateStoreBinding2 = this.f13716h;
            if (fragmentTemplateStoreBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreBinding2 = null;
            }
            ImageView imageView = fragmentTemplateStoreBinding2.infoBarDismissButton;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.infoBarDismissButton");
            ViewExtensionsKt.onClick$default(imageView, null, new g(null), 1, null);
            FragmentTemplateStoreBinding fragmentTemplateStoreBinding3 = this.f13716h;
            if (fragmentTemplateStoreBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreBinding3 = null;
            }
            Button button = fragmentTemplateStoreBinding3.infoBarButton;
            Intrinsics.checkNotNullExpressionValue(button, "binding.infoBarButton");
            ViewExtensionsKt.onClick$default(button, null, new h(null), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.f13716h;
        if (fragmentTemplateStoreBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding = null;
        }
        FrameLayout frameLayout = fragmentTemplateStoreBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        View view = getView();
        Intrinsics.checkNotNull(view);
        SnackbarAnimate make = SnackbarAnimate.make(view, (int) R.string.could_not_sign_in, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(view!!, R.string.co…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        make.show();
    }

    private final void r(MenuItem menuItem) {
        boolean z3;
        if (Settings.getTemplateStoreAutoTranslateLanguage(requireContext()) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            Settings.setTemplateStoreAutoTranslateLanguage(requireContext(), null);
            menuItem.setChecked(false);
            m();
            return;
        }
        f(menuItem);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    public void addSearchTermListener(@NotNull SearchTermListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f13713e.add(listener);
    }

    @NotNull
    public final TemplateCategoryManager getCategoryManager() {
        TemplateCategoryManager templateCategoryManager = this.categoryManager;
        if (templateCategoryManager != null) {
            return templateCategoryManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("categoryManager");
        return null;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig != null) {
            return remoteConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
        return null;
    }

    @NotNull
    public final ScreenLoader getScreenLoader() {
        ScreenLoader screenLoader = this.screenLoader;
        if (screenLoader != null) {
            return screenLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenLoader");
        return null;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    @NotNull
    public String getSearchTerm() {
        return this.f13711c;
    }

    @NotNull
    public final SignInHelper getSignInHelper() {
        SignInHelper signInHelper = this.signInHelper;
        if (signInHelper != null) {
            return signInHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("signInHelper");
        return null;
    }

    @NotNull
    public final TemplatesTranslationHelper getTranslationHelper() {
        TemplatesTranslationHelper templatesTranslationHelper = this.translationHelper;
        if (templatesTranslationHelper != null) {
            return templatesTranslationHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("translationHelper");
        return null;
    }

    @NotNull
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FirebaseAnalyticsEventLogger.logScreenView(requireActivity, "TemplateStoreFragment");
        Integer lastChosenCategoryId = getCategoryManager().getLastChosenCategoryId();
        if (lastChosenCategoryId != null) {
            getCategoryManager().setCategory(lastChosenCategoryId.intValue());
        }
        m();
        k();
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.f13716h;
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding2 = null;
        if (fragmentTemplateStoreBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding = null;
        }
        ImageView imageView = fragmentTemplateStoreBinding.searchButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchButton");
        ViewExtensionsKt.onClick$default(imageView, null, new e(null), 1, null);
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment$onActivityCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                FragmentKt.findNavController(TemplateStoreFragment.this).popBackStack(R.id.navigation_home, false);
            }
        });
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding3 = this.f13716h;
        if (fragmentTemplateStoreBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreBinding2 = fragmentTemplateStoreBinding3;
        }
        fragmentTemplateStoreBinding2.toolbar.inflateMenu(R.menu.templates_menu);
        p();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
        PageAdapter pageAdapter = null;
        CompositeDisposable compositeDisposable = null;
        Integer num = null;
        if (i4 != 222) {
            if (i4 == 9729) {
                if (i5 == -1) {
                    SignInHelper signInHelper = getSignInHelper();
                    CompositeDisposable compositeDisposable2 = this.f13714f;
                    if (compositeDisposable2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
                    } else {
                        compositeDisposable = compositeDisposable2;
                    }
                    SignInHelper.handleSignInResult$default(signInHelper, fromResultIntent, compositeDisposable, new SignInHelper.SignInCallbackHandler() { // from class: com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment$onActivityResult$1
                        @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                        public void onSignInError() {
                            TemplateStoreFragment.this.q();
                        }

                        @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                        public void onSignInStarted() {
                            FragmentTemplateStoreBinding fragmentTemplateStoreBinding = TemplateStoreFragment.this.f13716h;
                            if (fragmentTemplateStoreBinding == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                fragmentTemplateStoreBinding = null;
                            }
                            FrameLayout frameLayout = fragmentTemplateStoreBinding.loadingBlocker;
                            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
                            frameLayout.setVisibility(0);
                        }

                        @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                        public void onSignedIn(@NotNull User user) {
                            Intrinsics.checkNotNullParameter(user, "user");
                            TemplateStoreFragment.this.j(user);
                        }

                        @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                        public void onSignedInNoUser() {
                        }
                    }, false, 8, null);
                } else if (fromResultIntent != null) {
                    FirebaseUiException error = fromResultIntent.getError();
                    if (error != null) {
                        num = Integer.valueOf(error.getErrorCode());
                    }
                    SystemLog.logError("Sign in error: " + num);
                }
            }
        } else if (i5 == -1) {
            PageAdapter pageAdapter2 = this.f13710b;
            if (pageAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vpAdapter");
            } else {
                pageAdapter = pageAdapter2;
            }
            pageAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f13714f = new CompositeDisposable();
        setHasOptionsMenu(true);
        getSignInHelper().signInAnonymouslyIfNotSignedIn(new f());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentTemplateStoreBinding inflate = FragmentTemplateStoreBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f13716h = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CompositeDisposable compositeDisposable = this.f13714f;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentTemplateStoreBinding fragmentTemplateStoreBinding = this.f13716h;
        if (fragmentTemplateStoreBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreBinding = null;
        }
        FrameLayout frameLayout = fragmentTemplateStoreBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        d();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    public void removeSearchTermListener(@NotNull SearchTermListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f13713e.remove(listener);
    }

    public final void setCategoryManager(@NotNull TemplateCategoryManager templateCategoryManager) {
        Intrinsics.checkNotNullParameter(templateCategoryManager, "<set-?>");
        this.categoryManager = templateCategoryManager;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }

    public final void setScreenLoader(@NotNull ScreenLoader screenLoader) {
        Intrinsics.checkNotNullParameter(screenLoader, "<set-?>");
        this.screenLoader = screenLoader;
    }

    public final void setSignInHelper(@NotNull SignInHelper signInHelper) {
        Intrinsics.checkNotNullParameter(signInHelper, "<set-?>");
        this.signInHelper = signInHelper;
    }

    public final void setTranslationHelper(@NotNull TemplatesTranslationHelper templatesTranslationHelper) {
        Intrinsics.checkNotNullParameter(templatesTranslationHelper, "<set-?>");
        this.translationHelper = templatesTranslationHelper;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    public final void signIn() {
        getSignInHelper().signIn(this);
    }
}
