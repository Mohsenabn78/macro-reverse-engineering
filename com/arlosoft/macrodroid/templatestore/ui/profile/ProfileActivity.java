package com.arlosoft.macrodroid.templatestore.ui.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCase;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseBuilder;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseListener;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseSequence;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.databinding.ActivityMyProfileBinding;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.google.android.material.snackbar.SnackbarAnimate;
import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.Response;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.CustomMaxSize;
import com.yalantis.ucrop.UCrop;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nProfileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProfileActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/profile/ProfileActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ContextUtils.kt\norg/jetbrains/anko/ContextUtilsKt\n*L\n1#1,413:1\n262#2,2:414\n262#2,2:426\n262#2,2:428\n72#3,10:416\n*S KotlinDebug\n*F\n+ 1 ProfileActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/profile/ProfileActivity\n*L\n166#1:414,2\n353#1:426,2\n355#1:428,2\n246#1:416,10\n*E\n"})
/* loaded from: classes3.dex */
public final class ProfileActivity extends MacroDroidDaggerBaseActivity implements ProfileViewContract {

    /* renamed from: f  reason: collision with root package name */
    private boolean f13804f;

    /* renamed from: g  reason: collision with root package name */
    private String f13805g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13806h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private String f13807i = "";

    /* renamed from: j  reason: collision with root package name */
    private ActivityMyProfileBinding f13808j;
    @Inject
    public ProfilePresenter presenter;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ProfileActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, boolean z3, @NotNull String personalIdentifier, boolean z4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(personalIdentifier, "personalIdentifier");
            Intent intent = new Intent(context, ProfileActivity.class);
            intent.putExtra("createProfile", z3);
            intent.putExtra("personalIdentifier", personalIdentifier);
            intent.putExtra("showSignOut", z4);
            return intent;
        }
    }

    /* compiled from: ProfileActivity.kt */
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
                ProfileActivity.this.y();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ProfileActivity.kt */
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
                ProfileActivity.this.z();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ProfileActivity.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<String, Unit> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            ProfileActivity.this.J(text);
        }
    }

    /* compiled from: ProfileActivity.kt */
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
                ProfileActivity.this.F();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfileActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<Response<ProfileActivity, FileData>, Unit> {
        e() {
            super(1);
        }

        public final void a(Response<ProfileActivity, FileData> response) {
            if (response.resultCode() == -1) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeFile(response.data().getFile().getAbsolutePath(), options);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 256, 256, true);
                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(bitmap, 256, 256, true)");
                File u3 = ProfileActivity.this.u();
                u3.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(u3);
                createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                ProfileImageProvider profileImageProvider = ProfileActivity.this.getProfileImageProvider();
                ActivityMyProfileBinding activityMyProfileBinding = ProfileActivity.this.f13808j;
                ActivityMyProfileBinding activityMyProfileBinding2 = null;
                if (activityMyProfileBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityMyProfileBinding = null;
                }
                AvatarView avatarView = activityMyProfileBinding.avatarImage;
                Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                ActivityMyProfileBinding activityMyProfileBinding3 = ProfileActivity.this.f13808j;
                if (activityMyProfileBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMyProfileBinding2 = activityMyProfileBinding3;
                }
                profileImageProvider.loadImageFromBitmap(avatarView, bitmap, String.valueOf(activityMyProfileBinding2.usernameEdit.getText()));
                ProfileActivity.this.f13806h = true;
                ProfileActivity.this.K();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Response<ProfileActivity, FileData> response) {
            a(response);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfileActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements Function1<Throwable, Unit> {
        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Context applicationContext = ProfileActivity.this.getApplicationContext();
            String string = ProfileActivity.this.getString(R.string.error);
            ToastCompat.makeText(applicationContext, (CharSequence) (string + ": " + th), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfileActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ EditText $descriptionEditText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(EditText editText) {
            super(1);
            this.$descriptionEditText = editText;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (this.$descriptionEditText.getLayout().getLineCount() > 10) {
                this.$descriptionEditText.getText().delete(this.$descriptionEditText.getText().length() - 1, this.$descriptionEditText.getText().length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfileActivity.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $descriptionEditText;
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(EditText editText, AppCompatDialog appCompatDialog, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$descriptionEditText = editText;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$descriptionEditText, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityMyProfileBinding activityMyProfileBinding = ProfileActivity.this.f13808j;
                if (activityMyProfileBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityMyProfileBinding = null;
                }
                activityMyProfileBinding.description.setText(this.$descriptionEditText.getText().toString());
                this.$dialog.dismiss();
                ProfileActivity.this.K();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfileActivity.kt */
    /* loaded from: classes3.dex */
    public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AppCompatDialog appCompatDialog, Continuation<? super i> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ProfileActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        ActivityMyProfileBinding activityMyProfileBinding2 = null;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        activityMyProfileBinding.usernameEdit.requestFocus();
        ActivityMyProfileBinding activityMyProfileBinding3 = this.f13808j;
        if (activityMyProfileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMyProfileBinding2 = activityMyProfileBinding3;
        }
        AppCompatEditText appCompatEditText = activityMyProfileBinding2.usernameEdit;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.usernameEdit");
        ViewExtensionsKt.showKeyboard(appCompatEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ProfileActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPresenter().signOut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.dialog_enter_description);
        appCompatDialog.setTitle(R.string.description);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.descriptionEditText);
        Intrinsics.checkNotNull(findViewById);
        EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById3);
        Button button2 = (Button) findViewById3;
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        editText.setText(activityMyProfileBinding.description.getText().toString());
        ViewExtensionsKt.afterTextChanged(editText, new g(editText));
        ViewExtensionsKt.onClick$default(button, null, new h(editText, appCompatDialog, null), 1, null);
        ViewExtensionsKt.onClick$default(button2, null, new i(appCompatDialog, null), 1, null);
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(4);
        }
        appCompatDialog.show();
    }

    private final void G(int i4) {
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
        SnackbarAnimate make = SnackbarAnimate.make(view, i4, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(this.contentView!!,…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.show();
    }

    private final void H(String str) {
        SnackbarAnimate make = SnackbarAnimate.make(findViewById(R.id.coordinatorLayout), str, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(findViewById(R.id.c…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        make.show();
    }

    private final void I() {
        BubbleShowCaseBuilder bubbleShowCaseBuilder = new BubbleShowCaseBuilder(this);
        String string = getString(R.string.username);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.username)");
        BubbleShowCaseBuilder title = bubbleShowCaseBuilder.title(string);
        String string2 = getString(R.string.enter_username_hint);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.enter_username_hint)");
        BubbleShowCaseBuilder description = title.description(string2);
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        ActivityMyProfileBinding activityMyProfileBinding2 = null;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        AppCompatEditText appCompatEditText = activityMyProfileBinding.usernameEdit;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.usernameEdit");
        BubbleShowCaseBuilder backgroundColor = description.targetView(appCompatEditText).backgroundColor(ContextCompat.getColor(this, R.color.primary_dark));
        BubbleShowCaseBuilder bubbleShowCaseBuilder2 = new BubbleShowCaseBuilder(this);
        String string3 = getString(R.string.image);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.image)");
        BubbleShowCaseBuilder title2 = bubbleShowCaseBuilder2.title(string3);
        String string4 = getString(R.string.avatar_image_hint);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.avatar_image_hint)");
        BubbleShowCaseBuilder description2 = title2.description(string4);
        ActivityMyProfileBinding activityMyProfileBinding3 = this.f13808j;
        if (activityMyProfileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding3 = null;
        }
        FrameLayout frameLayout = activityMyProfileBinding3.avatarFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarFrame");
        BubbleShowCaseBuilder backgroundColor2 = description2.targetView(frameLayout).backgroundColor(ContextCompat.getColor(this, R.color.primary_dark));
        BubbleShowCaseBuilder bubbleShowCaseBuilder3 = new BubbleShowCaseBuilder(this);
        String string5 = getString(R.string.description);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.description)");
        BubbleShowCaseBuilder title3 = bubbleShowCaseBuilder3.title(string5);
        String string6 = getString(R.string.profile_description_hint);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.profile_description_hint)");
        BubbleShowCaseBuilder description3 = title3.description(string6);
        ActivityMyProfileBinding activityMyProfileBinding4 = this.f13808j;
        if (activityMyProfileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMyProfileBinding2 = activityMyProfileBinding4;
        }
        ImageView imageView = activityMyProfileBinding2.editDescriptionButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.editDescriptionButton");
        new BubbleShowCaseSequence().addShowCase(backgroundColor).addShowCase(backgroundColor2).addShowCase(description3.targetView(imageView).listener(new BubbleShowCaseListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.ProfileActivity$showHelpForNewSignUp$descriptionShowCase$1
            @Override // com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseListener
            public void onBackgroundDimClick(@NotNull BubbleShowCase bubbleShowCase) {
                Intrinsics.checkNotNullParameter(bubbleShowCase, "bubbleShowCase");
                ProfileActivity.this.D();
            }

            @Override // com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseListener
            public void onBubbleClick(@NotNull BubbleShowCase bubbleShowCase) {
                Intrinsics.checkNotNullParameter(bubbleShowCase, "bubbleShowCase");
            }

            @Override // com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseListener
            public void onCloseActionImageClick(@NotNull BubbleShowCase bubbleShowCase) {
                Intrinsics.checkNotNullParameter(bubbleShowCase, "bubbleShowCase");
                ProfileActivity.this.D();
            }

            @Override // com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseListener
            public void onTargetClick(@NotNull BubbleShowCase bubbleShowCase) {
                Intrinsics.checkNotNullParameter(bubbleShowCase, "bubbleShowCase");
                ProfileActivity.this.D();
            }
        }).backgroundColor(ContextCompat.getColor(this, R.color.primary_dark))).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String str) {
        if (!this.f13806h) {
            ProfileImageProvider profileImageProvider = getProfileImageProvider();
            ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
            if (activityMyProfileBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMyProfileBinding = null;
            }
            AvatarView avatarView = activityMyProfileBinding.avatarImage;
            Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
            profileImageProvider.loadImageFromUrl(avatarView, "", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        int i4 = 0;
        ActivityMyProfileBinding activityMyProfileBinding = null;
        if (this.f13804f) {
            ActivityMyProfileBinding activityMyProfileBinding2 = this.f13808j;
            if (activityMyProfileBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMyProfileBinding = activityMyProfileBinding2;
            }
            AppCompatButton appCompatButton = activityMyProfileBinding.saveButton;
            Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.saveButton");
            appCompatButton.setVisibility(0);
            return;
        }
        ActivityMyProfileBinding activityMyProfileBinding3 = this.f13808j;
        if (activityMyProfileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMyProfileBinding = activityMyProfileBinding3;
        }
        AppCompatButton appCompatButton2 = activityMyProfileBinding.saveButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton2, "binding.saveButton");
        if (!x()) {
            i4 = 8;
        }
        appCompatButton2.setVisibility(i4);
    }

    private final void r() {
        try {
            FileUtils.deleteDirectory(new File(Environment.getExternalStorageDirectory(), Constants.RX_PAPARAZZO_DIRECTORY));
        } catch (IOException unused) {
        }
        try {
            FileUtils.deleteDirectory(new File(getExternalFilesDir(null), Constants.RX_PAPARAZZO_DIRECTORY));
        } catch (IOException unused2) {
        }
    }

    private final void s() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template);
        builder.setTitle(getString(R.string.delete_profile));
        builder.setMessage(R.string.delete_profile_confirm);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ProfileActivity.t(ProfileActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ProfileActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPresenter().deleteProfile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File u() {
        File userIconDir = com.arlosoft.macrodroid.utils.FileUtils.getUserIconDir(this);
        if (!userIconDir.exists()) {
            userIconDir.mkdirs();
        }
        return new File(userIconDir, Constants.AVATAR_ICON_FILE);
    }

    private final void v() {
        ProfileImageProvider profileImageProvider = getProfileImageProvider();
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        AvatarView avatarView = activityMyProfileBinding.avatarImage;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
        profileImageProvider.loadImageFromUrl(avatarView, "", TypeDescription.Generic.OfWildcardType.SYMBOL);
    }

    private final void w() {
        User user = getUserProvider().getUser();
        ProfileImageProvider profileImageProvider = getProfileImageProvider();
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        ActivityMyProfileBinding activityMyProfileBinding2 = null;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        AvatarView avatarView = activityMyProfileBinding.avatarImage;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
        profileImageProvider.loadImageFromUrl(avatarView, user.getImage(), user.getUsername());
        ActivityMyProfileBinding activityMyProfileBinding3 = this.f13808j;
        if (activityMyProfileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding3 = null;
        }
        activityMyProfileBinding3.usernameEdit.setText(user.getUsername());
        ActivityMyProfileBinding activityMyProfileBinding4 = this.f13808j;
        if (activityMyProfileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding4 = null;
        }
        activityMyProfileBinding4.usernameEdit.setEnabled(false);
        ActivityMyProfileBinding activityMyProfileBinding5 = this.f13808j;
        if (activityMyProfileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMyProfileBinding2 = activityMyProfileBinding5;
        }
        activityMyProfileBinding2.description.setText(user.getDescription());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x() {
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        if (Intrinsics.areEqual(activityMyProfileBinding.description.getText().toString(), this.f13807i) && !this.f13806h) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        CharSequence trim;
        CharSequence trim2;
        File file;
        ProfilePresenter presenter = getPresenter();
        boolean z3 = this.f13804f;
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        trim = StringsKt__StringsKt.trim(String.valueOf(activityMyProfileBinding.usernameEdit.getText()));
        String obj = trim.toString();
        String str = this.f13805g;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personalIdentifier");
            str = null;
        }
        ActivityMyProfileBinding activityMyProfileBinding2 = this.f13808j;
        if (activityMyProfileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding2 = null;
        }
        trim2 = StringsKt__StringsKt.trim(activityMyProfileBinding2.description.getText().toString());
        String obj2 = trim2.toString();
        if (this.f13806h) {
            file = u();
        } else {
            file = null;
        }
        presenter.saveProfileData(z3, obj, str, obj2, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        UCrop.Options options = new UCrop.Options();
        options.withAspectRatio(1.0f, 1.0f);
        options.setCompressionFormat(Bitmap.CompressFormat.PNG);
        options.setCircleDimmedLayer(true);
        options.setToolbarTitle(getString(R.string.edit_image));
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Observable doFinally = ((RxPaparazzo.SingleSelectionBuilder) ((RxPaparazzo.SingleSelectionBuilder) ((RxPaparazzo.SingleSelectionBuilder) RxPaparazzo.single(this).crop(options)).size(new CustomMaxSize(point.x / 2))).useInternalStorage()).usingGallery().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                ProfileActivity.A(ProfileActivity.this);
            }
        });
        final e eVar = new e();
        Consumer consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProfileActivity.B(Function1.this, obj);
            }
        };
        final f fVar = new f();
        doFinally.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProfileActivity.C(Function1.this, obj);
            }
        });
    }

    @NotNull
    public final ProfilePresenter getPresenter() {
        ProfilePresenter profilePresenter = this.presenter;
        if (profilePresenter != null) {
            return profilePresenter;
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
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
        return null;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.profile.ProfileViewContract
    public void hideKeyboard() {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        inputMethodManager.hideSoftInputFromWindow(activityMyProfileBinding.description.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int i4;
        super.onCreate(bundle);
        setTheme(R.style.Theme_App_NoActionBar_Plugins);
        ActivityMyProfileBinding inflate = ActivityMyProfileBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13808j = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        setSupportActionBar(activityMyProfileBinding.toolbar);
        getPresenter().takeView(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        String stringExtra = getIntent().getStringExtra("personalIdentifier");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f13805g = stringExtra;
        boolean booleanExtra = getIntent().getBooleanExtra("createProfile", false);
        this.f13804f = booleanExtra;
        if (booleanExtra) {
            i4 = R.string.create_profile;
        } else {
            i4 = R.string.my_profile;
        }
        setTitle(i4);
        if (this.f13804f) {
            v();
            I();
        } else {
            w();
            this.f13807i = getUserProvider().getUser().getDescription();
        }
        K();
        ActivityMyProfileBinding activityMyProfileBinding2 = this.f13808j;
        if (activityMyProfileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding2 = null;
        }
        AppCompatButton appCompatButton = activityMyProfileBinding2.saveButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.saveButton");
        ViewExtensionsKt.onClick$default(appCompatButton, null, new a(null), 1, null);
        ActivityMyProfileBinding activityMyProfileBinding3 = this.f13808j;
        if (activityMyProfileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding3 = null;
        }
        AvatarView avatarView = activityMyProfileBinding3.avatarImage;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
        ViewExtensionsKt.onClick$default(avatarView, null, new b(null), 1, null);
        ActivityMyProfileBinding activityMyProfileBinding4 = this.f13808j;
        if (activityMyProfileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding4 = null;
        }
        AppCompatEditText appCompatEditText = activityMyProfileBinding4.usernameEdit;
        if (appCompatEditText != null) {
            ViewExtensionsKt.afterTextChanged(appCompatEditText, new c());
        }
        ActivityMyProfileBinding activityMyProfileBinding5 = this.f13808j;
        if (activityMyProfileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding5 = null;
        }
        ImageView imageView = activityMyProfileBinding5.editDescriptionButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.editDescriptionButton");
        ViewExtensionsKt.onClick$default(imageView, null, new d(null), 1, null);
        getOnBackPressedDispatcher().addCallback(this, new ProfileActivity$onCreate$5(this));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (!this.f13804f) {
            getMenuInflater().inflate(R.menu.user_profile_menu, menu);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getPresenter().dropView();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.delete_profile) {
                if (itemId == R.id.sign_out) {
                    getPresenter().signOut();
                }
            } else {
                s();
            }
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.profile.ProfileViewContract
    public void setLoadingState(boolean z3) {
        int i4;
        ActivityMyProfileBinding activityMyProfileBinding = this.f13808j;
        if (activityMyProfileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyProfileBinding = null;
        }
        FrameLayout frameLayout = activityMyProfileBinding.loadingView;
        if (frameLayout != null) {
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            frameLayout.setVisibility(i4);
        }
    }

    public final void setPresenter(@NotNull ProfilePresenter profilePresenter) {
        Intrinsics.checkNotNullParameter(profilePresenter, "<set-?>");
        this.presenter = profilePresenter;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.profile.ProfileViewContract
    public void showConfirmSignOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template);
        builder.setTitle(getString(R.string.sign_out));
        builder.setMessage(R.string.are_you_sure_sign_out);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ProfileActivity.E(ProfileActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.profile.ProfileViewContract
    public void showDeleteFailed() {
        String string = getString(R.string.delete_failed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.delete_failed)");
        H(string);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.profile.ProfileViewContract
    public void showGenericError() {
        G(R.string.check_connection_try_again);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.profile.ProfileViewContract
    public void showInvalidUsername() {
        ToastCompat.makeText(this, (int) R.string.invalid_username, 0).show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.profile.ProfileViewContract
    public void showUsernameTaken() {
        G(R.string.username_already_taken_message);
    }
}
