package com.arlosoft.macrodroid.templatestore.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.databinding.ActivityTemplateSearchBinding;
import com.arlosoft.macrodroid.extensions.AppCompatActivityExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermListener;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.SnackbarAnimate;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateSearchActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTemplateSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateSearchActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/search/TemplateSearchActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ContextUtils.kt\norg/jetbrains/anko/ContextUtilsKt\n*L\n1#1,241:1\n262#2,2:242\n72#3,10:244\n*S KotlinDebug\n*F\n+ 1 TemplateSearchActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/search/TemplateSearchActivity\n*L\n235#1:242,2\n236#1:244,10\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplateSearchActivity extends MacroDroidDaggerBaseActivity implements SearchTermProvider {
    @NotNull
    public static final String EXTRA_CLEAR_UPDATE_SUBSCRIPTION_ID = "clear_update_subscription_id";
    @NotNull
    public static final String EXTRA_INITIAL_SEARCH_TEXT = "search_text";

    /* renamed from: g  reason: collision with root package name */
    private boolean f13846g;

    /* renamed from: h  reason: collision with root package name */
    private TemplateListFragment f13847h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private SearchView f13848i;

    /* renamed from: k  reason: collision with root package name */
    private CompositeDisposable f13850k;

    /* renamed from: l  reason: collision with root package name */
    private ActivityTemplateSearchBinding f13851l;
    @Inject
    public MacroDroidRoomDatabase roomDatabase;
    @Inject
    public SignInHelper signInHelper;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private String f13845f = "";
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<SearchTermListener> f13849j = new ArrayList<>();

    /* compiled from: TemplateSearchActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, String str, int i4, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                i4 = 0;
            }
            return companion.createIntent(context, str, i4);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String searchText, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            Intent intent = new Intent(context, TemplateSearchActivity.class);
            intent.putExtra(TemplateSearchActivity.EXTRA_INITIAL_SEARCH_TEXT, searchText);
            intent.putExtra("clear_update_subscription_id", i4);
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateSearchActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $idToClear;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$idToClear = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$idToClear, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TemplateSearchActivity.this.getRoomDatabase().subscriptionUpdateItemDao().deleteSubscriptionUpdateItem(this.$idToClear, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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

    private final void m(int i4) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(i4, null), 2, null);
    }

    private final void n(Intent intent) {
        boolean contains$default;
        int lastIndexOf$default;
        if (intent != null) {
            String action = intent.getAction();
            String dataString = intent.getDataString();
            if (Intrinsics.areEqual("android.intent.action.VIEW", action) && dataString != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) dataString, (CharSequence) "id=", false, 2, (Object) null);
                if (contains$default) {
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) dataString, "id=", 0, false, 6, (Object) null);
                    String substring = dataString.substring(lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    this.f13845f = substring;
                    this.f13846g = true;
                    Iterator<SearchTermListener> it = this.f13849j.iterator();
                    while (it.hasNext()) {
                        it.next().onSearchTermUpdated(getSearchTerm());
                    }
                }
            } else {
                String stringExtra = intent.getStringExtra(EXTRA_INITIAL_SEARCH_TEXT);
                if (stringExtra == null) {
                    stringExtra = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EX…NITIAL_SEARCH_TEXT) ?: \"\"");
                }
                this.f13845f = stringExtra;
                this.f13846g = false;
                Iterator<SearchTermListener> it2 = this.f13849j.iterator();
                while (it2.hasNext()) {
                    it2.next().onSearchTermUpdated(getSearchTerm());
                }
            }
            SearchView searchView = this.f13848i;
            if (searchView != null) {
                searchView.setQuery(getSearchTerm(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(User user) {
        try {
            String string = getString(R.string.templates_signed_in_popup, user.getUsername());
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…_in_popup, user.username)");
            ToastCompat.makeText((Context) this, (CharSequence) string, 1).show();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        ActivityTemplateSearchBinding activityTemplateSearchBinding = this.f13851l;
        View view = null;
        if (activityTemplateSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateSearchBinding = null;
        }
        FrameLayout frameLayout = activityTemplateSearchBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        View findViewById = findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            findViewById = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        if (viewGroup != null) {
            view = viewGroup.getChildAt(0);
        }
        Intrinsics.checkNotNull(view);
        SnackbarAnimate make = SnackbarAnimate.make(view, (int) R.string.could_not_sign_in, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(contentView!!, R.st…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    public void addSearchTermListener(@NotNull SearchTermListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f13849j.add(listener);
    }

    @NotNull
    public final MacroDroidRoomDatabase getRoomDatabase() {
        MacroDroidRoomDatabase macroDroidRoomDatabase = this.roomDatabase;
        if (macroDroidRoomDatabase != null) {
            return macroDroidRoomDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roomDatabase");
        return null;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    @NotNull
    public String getSearchTerm() {
        return this.f13845f;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        CompositeDisposable compositeDisposable;
        super.onActivityResult(i4, i5, intent);
        IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
        if (i4 == 9729) {
            Integer num = null;
            if (i5 == -1) {
                SignInHelper signInHelper = getSignInHelper();
                CompositeDisposable compositeDisposable2 = this.f13850k;
                if (compositeDisposable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
                    compositeDisposable = null;
                } else {
                    compositeDisposable = compositeDisposable2;
                }
                SignInHelper.handleSignInResult$default(signInHelper, fromResultIntent, compositeDisposable, new SignInHelper.SignInCallbackHandler() { // from class: com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity$onActivityResult$1
                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInError() {
                        TemplateSearchActivity.this.p();
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInStarted() {
                        ActivityTemplateSearchBinding activityTemplateSearchBinding;
                        activityTemplateSearchBinding = TemplateSearchActivity.this.f13851l;
                        if (activityTemplateSearchBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateSearchBinding = null;
                        }
                        FrameLayout frameLayout = activityTemplateSearchBinding.loadingBlocker;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
                        frameLayout.setVisibility(0);
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignedIn(@NotNull User user) {
                        Intrinsics.checkNotNullParameter(user, "user");
                        TemplateSearchActivity.this.o(user);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTemplateSearchBinding inflate = ActivityTemplateSearchBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13851l = inflate;
        TemplateListFragment templateListFragment = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        this.f13850k = new CompositeDisposable();
        ActivityTemplateSearchBinding activityTemplateSearchBinding = this.f13851l;
        if (activityTemplateSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateSearchBinding = null;
        }
        setSupportActionBar(activityTemplateSearchBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayShowTitleEnabled(false);
        }
        this.f13845f = "";
        n(getIntent());
        TemplateListFragment newInstance$default = TemplateListFragment.Companion.newInstance$default(TemplateListFragment.Companion, 0, 0, false, false, false, false, 56, null);
        this.f13847h = newInstance$default;
        if (newInstance$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateListFragment");
        } else {
            templateListFragment = newInstance$default;
        }
        AppCompatActivityExtensionsKt.addFragment(this, templateListFragment, R.id.templateListContainer);
        int intExtra = getIntent().getIntExtra("clear_update_subscription_id", 0);
        if (intExtra > 0) {
            m(intExtra);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        SearchView searchView;
        boolean z3;
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.templates_search_menu, menu);
        View actionView = MenuItemCompat.getActionView(menu.findItem(R.id.menu_search));
        Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        final SearchView searchView2 = (SearchView) actionView;
        this.f13848i = searchView2;
        boolean z4 = false;
        if (searchView2 != null) {
            searchView2.onActionViewExpanded();
            searchView2.setQuery(getSearchTerm(), false);
            if (this.f13845f.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                searchView2.clearFocus();
            }
            searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity$onCreateOptionsMenu$1$1
                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(@NotNull String newText) {
                    Intrinsics.checkNotNullParameter(newText, "newText");
                    return false;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(@NotNull String query) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(query, "query");
                    TemplateSearchActivity.this.f13846g = false;
                    TemplateSearchActivity.this.f13845f = query;
                    arrayList = TemplateSearchActivity.this.f13849j;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((SearchTermListener) it.next()).onSearchTermUpdated(query);
                    }
                    searchView2.clearFocus();
                    return true;
                }
            });
        }
        String stringExtra = getIntent().getStringExtra(EXTRA_INITIAL_SEARCH_TEXT);
        if (!((stringExtra == null || stringExtra.length() == 0) ? true : true) && (searchView = this.f13848i) != null) {
            searchView.setQuery(stringExtra, true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CompositeDisposable compositeDisposable = this.f13850k;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        n(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    public void removeSearchTermListener(@NotNull SearchTermListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f13849j.remove(listener);
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    public final void setSignInHelper(@NotNull SignInHelper signInHelper) {
        Intrinsics.checkNotNullParameter(signInHelper, "<set-?>");
        this.signInHelper = signInHelper;
    }

    public final void signIn() {
        getSignInHelper().signIn(this);
    }
}
