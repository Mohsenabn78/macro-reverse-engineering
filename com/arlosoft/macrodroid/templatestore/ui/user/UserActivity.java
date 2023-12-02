package com.arlosoft.macrodroid.templatestore.ui.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.databinding.ActivityUserBinding;
import com.arlosoft.macrodroid.extensions.AppCompatActivityExtensionsKt;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment;
import com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.SnackbarAnimate;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUserActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/user/UserActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ContextUtils.kt\norg/jetbrains/anko/ContextUtilsKt\n*L\n1#1,365:1\n262#2,2:366\n262#2,2:368\n262#2,2:370\n262#2,2:372\n262#2,2:394\n262#2,2:396\n262#2,2:398\n262#2,2:400\n262#2,2:402\n262#2,2:404\n262#2,2:406\n262#2,2:408\n262#2,2:410\n262#2,2:412\n262#2,2:414\n72#3,10:374\n72#3,10:384\n72#3,10:416\n72#3,10:426\n*S KotlinDebug\n*F\n+ 1 UserActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/user/UserActivity\n*L\n113#1:366,2\n114#1:368,2\n116#1:370,2\n117#1:372,2\n152#1:394,2\n156#1:396,2\n173#1:398,2\n197#1:400,2\n198#1:402,2\n200#1:404,2\n201#1:406,2\n208#1:408,2\n209#1:410,2\n219#1:412,2\n220#1:414,2\n125#1:374,10\n139#1:384,10\n283#1:416,10\n325#1:426,10\n*E\n"})
/* loaded from: classes3.dex */
public final class UserActivity extends MacroDroidDaggerBaseActivity implements UserViewContract {

    /* renamed from: f  reason: collision with root package name */
    private CompositeDisposable f14184f;

    /* renamed from: g  reason: collision with root package name */
    private int f14185g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14186h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private AppCompatDialog f14187i;

    /* renamed from: j  reason: collision with root package name */
    private ActivityUserBinding f14188j;
    @Inject
    public UserPresenter presenter;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public SignInHelper signInHelper;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: UserActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String username, @NotNull String userImage, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(userImage, "userImage");
            Intent intent = new Intent(context, UserActivity.class);
            intent.putExtra(HintConstants.AUTOFILL_HINT_USERNAME, username);
            intent.putExtra("user_image", userImage);
            intent.putExtra("user_id", i4);
            return intent;
        }
    }

    /* compiled from: UserActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                UserActivity.this.onBackPressed();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UserActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UserActivity.this.getPresenter().subscribeUserClicked();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UserActivity.kt */
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
                UserActivity.this.w();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UserActivity.kt */
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UserActivity.this.t();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;
        final /* synthetic */ UserActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AppCompatDialog appCompatDialog, UserActivity userActivity, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
            this.this$0 = userActivity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$dialog, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            Editable editable;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditText editText = (EditText) this.$dialog.findViewById(R.id.justificationText);
                RadioGroup radioGroup = (RadioGroup) this.$dialog.findViewById(R.id.radioGroup);
                int i5 = 0;
                if (radioGroup != null) {
                    i4 = radioGroup.indexOfChild(this.$dialog.findViewById(radioGroup.getCheckedRadioButtonId()));
                } else {
                    i4 = 0;
                }
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 == 2) {
                            i5 = 4;
                        }
                    } else {
                        i5 = 3;
                    }
                }
                if (editText != null) {
                    editable = editText.getText();
                } else {
                    editable = null;
                }
                String valueOf = String.valueOf(editable);
                if (editText != null) {
                    ViewExtensionsKt.hideKeyboard(editText);
                }
                this.this$0.getPresenter().reportUser(this.this$0.f14185g, i5, valueOf);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AppCompatDialog appCompatDialog, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void A(String str, int i4, View view) {
        SnackbarAnimate make = SnackbarAnimate.make(view, str, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(parentView, text, S…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(i4);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.show();
    }

    static /* synthetic */ void B(UserActivity userActivity, String str, int i4, View view, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            View findViewById = userActivity.findViewById(16908290);
            if (!(findViewById instanceof ViewGroup)) {
                findViewById = null;
            }
            ViewGroup viewGroup = (ViewGroup) findViewById;
            if (viewGroup != null) {
                view = viewGroup.getChildAt(0);
            } else {
                view = null;
            }
            Intrinsics.checkNotNull(view);
        }
        userActivity.A(str, i4, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(UserActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, UpgradeActivity2.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(UserActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSignInHelper().signIn(this$0);
    }

    private final void r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template);
        builder.setTitle(R.string.template_store_block_user);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.template_store_block_user_description_with_username);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…escription_with_username)");
        Object[] objArr = new Object[1];
        ActivityUserBinding activityUserBinding = this.f14188j;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        objArr[0] = activityUserBinding.usernameText.getText();
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        builder.setMessage(format);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                UserActivity.s(UserActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(UserActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UserPresenter presenter = this$0.getPresenter();
        int i5 = this$0.f14185g;
        ActivityUserBinding activityUserBinding = this$0.f14188j;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        presenter.blockUser(i5, activityUserBinding.usernameText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template);
        builder.setTitle(R.string.template_store_unblock_user);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.template_store_unblock_user_confirm_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…ock_user_confirm_message)");
        Object[] objArr = new Object[1];
        ActivityUserBinding activityUserBinding = this.f14188j;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        objArr[0] = activityUserBinding.usernameText.getText();
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        builder.setMessage(format);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                UserActivity.u(UserActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(UserActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPresenter().unblockUser(this$0.f14185g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(User user) {
        try {
            String string = getString(R.string.templates_signed_in_popup, user.getUsername());
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…_in_popup, user.username)");
            ToastCompat.makeText((Context) this, (CharSequence) string, 1).show();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        int i4;
        ActivityUserBinding activityUserBinding = this.f14188j;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        PopupMenu popupMenu = new PopupMenu(this, activityUserBinding.menuButton);
        popupMenu.inflate(R.menu.user_activity_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.b
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean x3;
                x3 = UserActivity.x(UserActivity.this, menuItem);
                return x3;
            }
        });
        try {
            popupMenu.show();
            MenuItem findItem = popupMenu.getMenu().findItem(R.id.block_user);
            if (this.f14186h) {
                i4 = R.string.template_store_unblock_user;
            } else {
                i4 = R.string.template_store_block_user;
            }
            findItem.setTitle(i4);
        } catch (Exception e4) {
            SystemLog.logError("Failed to display popupmenu: " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(UserActivity this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int itemId = menuItem.getItemId();
        if (itemId != R.id.block_user) {
            if (itemId == R.id.report_user) {
                this$0.y();
                return true;
            }
            return true;
        } else if (this$0.f14186h) {
            this$0.t();
            return true;
        } else {
            this$0.r();
            return true;
        }
    }

    private final void y() {
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Template);
        this.f14187i = appCompatDialog;
        appCompatDialog.setContentView(R.layout.dialog_report_user);
        appCompatDialog.setTitle(R.string.template_store_report_user);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, getResources().getDimensionPixelSize(R.dimen.margin_medium));
        appCompatDialog.setCanceledOnTouchOutside(false);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        if (button != null) {
            button.setText(getString(R.string.template_store_report_user));
        }
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        if (button2 != null) {
            Intrinsics.checkNotNullExpressionValue(button2, "findViewById<Button>(R.id.okButton)");
            ViewExtensionsKt.onClick$default(button2, null, new e(appCompatDialog, this, null), 1, null);
        }
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        if (button3 != null) {
            Intrinsics.checkNotNullExpressionValue(button3, "findViewById<Button>(R.id.cancelButton)");
            ViewExtensionsKt.onClick$default(button3, null, new f(appCompatDialog, null), 1, null);
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        View findViewById = findViewById(16908290);
        View view = null;
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

    @NotNull
    public final UserPresenter getPresenter() {
        UserPresenter userPresenter = this.presenter;
        if (userPresenter != null) {
            return userPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    @NotNull
    public final ProfileImageProvider getProfileImageProvider() {
        ProfileImageProvider profileImageProvider = this.profileImageProvider;
        if (profileImageProvider != null) {
            return profileImageProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("profileImageProvider");
        return null;
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
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
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
                CompositeDisposable compositeDisposable2 = this.f14184f;
                if (compositeDisposable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
                    compositeDisposable = null;
                } else {
                    compositeDisposable = compositeDisposable2;
                }
                SignInHelper.handleSignInResult$default(signInHelper, fromResultIntent, compositeDisposable, new SignInHelper.SignInCallbackHandler() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.UserActivity$onActivityResult$1
                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInError() {
                        UserActivity.this.z();
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignedIn(@NotNull User user) {
                        Intrinsics.checkNotNullParameter(user, "user");
                        UserActivity.this.v(user);
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInStarted() {
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
        ActivityUserBinding inflate = ActivityUserBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f14188j = inflate;
        ActivityUserBinding activityUserBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        String stringExtra = getIntent().getStringExtra(HintConstants.AUTOFILL_HINT_USERNAME);
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra("user_image");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.f14185g = getIntent().getIntExtra("user_id", 0);
        this.f14184f = new CompositeDisposable();
        ActivityUserBinding activityUserBinding2 = this.f14188j;
        if (activityUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding2 = null;
        }
        activityUserBinding2.usernameText.setText(stringExtra);
        ActivityUserBinding activityUserBinding3 = this.f14188j;
        if (activityUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding3 = null;
        }
        setSupportActionBar(activityUserBinding3.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        AppCompatActivityExtensionsKt.addFragment(this, TemplateListFragment.Companion.newInstance$default(TemplateListFragment.Companion, 0, this.f14185g, false, false, false, true, 24, null), R.id.templateListContainer);
        getPresenter().setUserBeingShownId(this.f14185g, stringExtra, str);
        getPresenter().takeView(this);
        if (Intrinsics.areEqual(getUserProvider().getUser().getUsername(), stringExtra)) {
            ActivityUserBinding activityUserBinding4 = this.f14188j;
            if (activityUserBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityUserBinding4 = null;
            }
            activityUserBinding4.subscribeButton.setVisibility(4);
        }
        ActivityUserBinding activityUserBinding5 = this.f14188j;
        if (activityUserBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding5 = null;
        }
        if (activityUserBinding5.userHeader.avatarImage != null) {
            ProfileImageProvider profileImageProvider = getProfileImageProvider();
            ActivityUserBinding activityUserBinding6 = this.f14188j;
            if (activityUserBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityUserBinding6 = null;
            }
            AvatarView avatarView = activityUserBinding6.userHeader.avatarImage;
            Intrinsics.checkNotNullExpressionValue(avatarView, "binding.userHeader.avatarImage");
            profileImageProvider.loadImageFromUrl(avatarView, str, stringExtra);
        }
        ActivityUserBinding activityUserBinding7 = this.f14188j;
        if (activityUserBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding7 = null;
        }
        ImageButton imageButton = activityUserBinding7.backButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.backButton");
        ViewExtensionsKt.onClick$default(imageButton, null, new a(null), 1, null);
        ActivityUserBinding activityUserBinding8 = this.f14188j;
        if (activityUserBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding8 = null;
        }
        ImageView imageView = activityUserBinding8.subscribeButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.subscribeButton");
        ViewExtensionsKt.onClick$default(imageView, null, new b(null), 1, null);
        if (this.f14185g == getUserProvider().getUser().getUserId()) {
            ActivityUserBinding activityUserBinding9 = this.f14188j;
            if (activityUserBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityUserBinding9 = null;
            }
            ImageView imageView2 = activityUserBinding9.menuButton;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.menuButton");
            imageView2.setVisibility(8);
            ActivityUserBinding activityUserBinding10 = this.f14188j;
            if (activityUserBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityUserBinding = activityUserBinding10;
            }
            View view = activityUserBinding.spaceFiller;
            Intrinsics.checkNotNullExpressionValue(view, "binding.spaceFiller");
            view.setVisibility(8);
            return;
        }
        ActivityUserBinding activityUserBinding11 = this.f14188j;
        if (activityUserBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding11 = null;
        }
        ImageView imageView3 = activityUserBinding11.menuButton;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.menuButton");
        imageView3.setVisibility(0);
        ActivityUserBinding activityUserBinding12 = this.f14188j;
        if (activityUserBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding12 = null;
        }
        View view2 = activityUserBinding12.spaceFiller;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.spaceFiller");
        view2.setVisibility(0);
        ActivityUserBinding activityUserBinding13 = this.f14188j;
        if (activityUserBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding13 = null;
        }
        ImageView imageView4 = activityUserBinding13.menuButton;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.menuButton");
        ViewExtensionsKt.onClick$default(imageView4, null, new c(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getPresenter().dropView();
        CompositeDisposable compositeDisposable = this.f14184f;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void refreshMacros() {
        AppCompatActivityExtensionsKt.replaceFragment(this, TemplateListFragment.Companion.newInstance$default(TemplateListFragment.Companion, 0, this.f14185g, false, false, false, false, 56, null), R.id.templateListContainer);
    }

    public final void setPresenter(@NotNull UserPresenter userPresenter) {
        Intrinsics.checkNotNullParameter(userPresenter, "<set-?>");
        this.presenter = userPresenter;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setSignInHelper(@NotNull SignInHelper signInHelper) {
        Intrinsics.checkNotNullParameter(signInHelper, "<set-?>");
        this.signInHelper = signInHelper;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void setUserBlocked() {
        ActivityUserBinding activityUserBinding = this.f14188j;
        ActivityUserBinding activityUserBinding2 = null;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        activityUserBinding.usernameText.setPaintFlags(16);
        ActivityUserBinding activityUserBinding3 = this.f14188j;
        if (activityUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding3 = null;
        }
        activityUserBinding3.userHeader.description.setText(getString(R.string.blocked_user_description));
        ActivityUserBinding activityUserBinding4 = this.f14188j;
        if (activityUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding4 = null;
        }
        FrameLayout frameLayout = activityUserBinding4.templateListContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.templateListContainer");
        frameLayout.setVisibility(8);
        ActivityUserBinding activityUserBinding5 = this.f14188j;
        if (activityUserBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding5 = null;
        }
        FrameLayout frameLayout2 = activityUserBinding5.blockedContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.blockedContainer");
        frameLayout2.setVisibility(0);
        ActivityUserBinding activityUserBinding6 = this.f14188j;
        if (activityUserBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding6 = null;
        }
        activityUserBinding6.subscribeButton.setVisibility(4);
        ActivityUserBinding activityUserBinding7 = this.f14188j;
        if (activityUserBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding7 = null;
        }
        Button button = activityUserBinding7.unblockUserButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.unblockUserButton");
        ViewExtensionsKt.onClick$default(button, null, new d(null), 1, null);
        ActivityUserBinding activityUserBinding8 = this.f14188j;
        if (activityUserBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUserBinding2 = activityUserBinding8;
        }
        activityUserBinding2.appBarLayout.setExpanded(true);
        this.f14186h = true;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void setUserDetails(@NotNull User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        ActivityUserBinding activityUserBinding = this.f14188j;
        ActivityUserBinding activityUserBinding2 = null;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        activityUserBinding.userHeader.description.setText(user.getDescription());
        ActivityUserBinding activityUserBinding3 = this.f14188j;
        if (activityUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding3 = null;
        }
        activityUserBinding3.userHeader.starRating.setText(String.valueOf(user.getRating()));
        ActivityUserBinding activityUserBinding4 = this.f14188j;
        if (activityUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding4 = null;
        }
        activityUserBinding4.userHeader.numMacros.setText(String.valueOf(user.getNumMacros()));
        ActivityUserBinding activityUserBinding5 = this.f14188j;
        if (activityUserBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding5 = null;
        }
        activityUserBinding5.userHeader.userRank.setText(user.getUserRank() + " / " + user.getTotalUsers());
        ActivityUserBinding activityUserBinding6 = this.f14188j;
        if (activityUserBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding6 = null;
        }
        LinearLayout linearLayout = activityUserBinding6.userHeader.userStatsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.userHeader.userStatsLayout");
        linearLayout.setVisibility(0);
        ActivityUserBinding activityUserBinding7 = this.f14188j;
        if (activityUserBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding7 = null;
        }
        LinearLayout linearLayout2 = activityUserBinding7.userHeader.userRankContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.userHeader.userRankContainer");
        linearLayout2.setVisibility(0);
        ActivityUserBinding activityUserBinding8 = this.f14188j;
        if (activityUserBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding8 = null;
        }
        activityUserBinding8.usernameText.setPaintFlags(1);
        ActivityUserBinding activityUserBinding9 = this.f14188j;
        if (activityUserBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding9 = null;
        }
        FrameLayout frameLayout = activityUserBinding9.templateListContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.templateListContainer");
        frameLayout.setVisibility(0);
        ActivityUserBinding activityUserBinding10 = this.f14188j;
        if (activityUserBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding10 = null;
        }
        FrameLayout frameLayout2 = activityUserBinding10.blockedContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.blockedContainer");
        frameLayout2.setVisibility(8);
        ActivityUserBinding activityUserBinding11 = this.f14188j;
        if (activityUserBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUserBinding2 = activityUserBinding11;
        }
        activityUserBinding2.subscribeButton.setVisibility(0);
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void setUserUnblocked() {
        ActivityUserBinding activityUserBinding = this.f14188j;
        ActivityUserBinding activityUserBinding2 = null;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        FrameLayout frameLayout = activityUserBinding.templateListContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.templateListContainer");
        frameLayout.setVisibility(0);
        ActivityUserBinding activityUserBinding3 = this.f14188j;
        if (activityUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUserBinding2 = activityUserBinding3;
        }
        FrameLayout frameLayout2 = activityUserBinding2.blockedContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.blockedContainer");
        frameLayout2.setVisibility(8);
        this.f14186h = false;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void showReportFailed() {
        View view;
        AppCompatDialog appCompatDialog = this.f14187i;
        if (appCompatDialog != null) {
            view = appCompatDialog.findViewById(R.id.scrollView);
        } else {
            view = null;
        }
        if (view != null) {
            String string = getString(R.string.upload_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.upload_failed)");
            A(string, R.color.snack_bar_error, view);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void showReportUploading(boolean z3) {
        ViewFlipper viewFlipper;
        AppCompatDialog appCompatDialog = this.f14187i;
        if (appCompatDialog != null) {
            viewFlipper = (ViewFlipper) appCompatDialog.findViewById(R.id.viewFlipper);
        } else {
            viewFlipper = null;
        }
        if (viewFlipper != null) {
            viewFlipper.setDisplayedChild(z3 ? 1 : 0);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void showReported() {
        AppCompatDialog appCompatDialog = this.f14187i;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
        String string = getString(R.string.report_submitted);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.report_submitted)");
        B(this, string, R.color.md_green_500, null, 4, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void showSubscriptionInProgress() {
        ActivityUserBinding activityUserBinding = this.f14188j;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        ProgressBar progressBar = activityUserBinding.subscribingProgress;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.subscribingProgress");
        progressBar.setVisibility(0);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void showSubscriptionProOnly() {
        View findViewById = findViewById(16908290);
        View view = null;
        if (!(findViewById instanceof ViewGroup)) {
            findViewById = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        if (viewGroup != null) {
            view = viewGroup.getChildAt(0);
        }
        Intrinsics.checkNotNull(view);
        SnackbarAnimate make = SnackbarAnimate.make(view, (int) R.string.template_store_sorry_subsribe_users_pro_only, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(contentView!!, R.st…ibe_users_pro_only, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        View findViewById3 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById3).setTextColor(-1);
        make.setAction(R.string.upgrade, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserActivity.C(UserActivity.this, view2);
            }
        });
        make.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void showSubscriptionSignedInOnly() {
        View findViewById = findViewById(16908290);
        View view = null;
        if (!(findViewById instanceof ViewGroup)) {
            findViewById = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        if (viewGroup != null) {
            view = viewGroup.getChildAt(0);
        }
        Intrinsics.checkNotNull(view);
        SnackbarAnimate make = SnackbarAnimate.make(view, (int) R.string.template_store_sorry_subsribe_users_must_sign_in, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(contentView!!, R.st…users_must_sign_in, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        View findViewById3 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById3).setTextColor(-1);
        make.setAction(R.string.sign_in, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserActivity.D(UserActivity.this, view2);
            }
        });
        make.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void subscriptionUpdateFailed(boolean z3) {
        int i4;
        ActivityUserBinding activityUserBinding = this.f14188j;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        ProgressBar progressBar = activityUserBinding.subscribingProgress;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.subscribingProgress");
        progressBar.setVisibility(8);
        if (z3) {
            i4 = R.string.template_store_subscription_failed;
        } else {
            i4 = R.string.template_store_unsubscribe_failed;
        }
        String string = getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(if (triedToSub…bscribe_failed\n        })");
        ToastCompat.makeText((Context) this, (CharSequence) string, 0).show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract
    public void updateSubscribedState(boolean z3, boolean z4) {
        int i4;
        int i5;
        String format;
        ActivityUserBinding activityUserBinding = this.f14188j;
        ActivityUserBinding activityUserBinding2 = null;
        if (activityUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding = null;
        }
        ProgressBar progressBar = activityUserBinding.subscribingProgress;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.subscribingProgress");
        progressBar.setVisibility(8);
        ActivityUserBinding activityUserBinding3 = this.f14188j;
        if (activityUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding3 = null;
        }
        ImageView imageView = activityUserBinding3.subscribeButton;
        if (z3) {
            i4 = R.color.subscribed_indicator_color;
        } else {
            i4 = R.color.white;
        }
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(this, i4)));
        ActivityUserBinding activityUserBinding4 = this.f14188j;
        if (activityUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUserBinding4 = null;
        }
        ImageView imageView2 = activityUserBinding4.subscribeButton;
        if (z3) {
            i5 = R.drawable.ic_bell_ring_white_24dp;
        } else {
            i5 = R.drawable.ic_bell;
        }
        imageView2.setImageResource(i5);
        if (z4) {
            if (z3) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.template_store_subscribed_to);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.template_store_subscribed_to)");
                Object[] objArr = new Object[1];
                ActivityUserBinding activityUserBinding5 = this.f14188j;
                if (activityUserBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityUserBinding2 = activityUserBinding5;
                }
                objArr[0] = activityUserBinding2.usernameText.getText();
                format = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = getString(R.string.template_store_unsubscribed_from);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.templ…_store_unsubscribed_from)");
                Object[] objArr2 = new Object[1];
                ActivityUserBinding activityUserBinding6 = this.f14188j;
                if (activityUserBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityUserBinding2 = activityUserBinding6;
                }
                objArr2[0] = activityUserBinding2.usernameText.getText();
                format = String.format(string2, Arrays.copyOf(objArr2, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            ToastCompat.makeText((Context) this, (CharSequence) format, 0).show();
        }
    }
}
