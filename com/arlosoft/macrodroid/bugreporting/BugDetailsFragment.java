package com.arlosoft.macrodroid.bugreporting;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.bumptech.glide.Glide;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.apmem.tools.layouts.FlowLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BugDetailsFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BugDetailsFragment extends Fragment {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Uri> f9555b = new ArrayList<>();
    @BindView(R.id.description_text)
    public EditText descriptionText;
    @BindView(R.id.screenshotsContainer)
    public FlowLayout screenshotsContainer;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: BugDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BugDetailsFragment newInstance() {
            return new BugDetailsFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BugDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Uri uri, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$uri = uri;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$uri, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BugDetailsFragment.this.f9555b.remove(this.$uri);
                BugDetailsFragment.this.d();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BugDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                BugDetailsFragment.this.c();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(getString(R.string.error));
        builder.setMessage(R.string.please_enter_a_detailed_description);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        try {
            try {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(ImageUtils.MIME_TYPE_IMAGE_WILDCARD);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.setType(ImageUtils.MIME_TYPE_IMAGE_WILDCARD);
                startActivityForResult(intent2, 0);
            }
        } catch (Exception unused2) {
            ToastCompat.makeText(requireContext(), (int) R.string.no_app_available, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        getScreenshotsContainer().removeAllViews();
        Iterator<Uri> it = this.f9555b.iterator();
        while (it.hasNext()) {
            Uri next = it.next();
            View screenshotButton = getLayoutInflater().inflate(R.layout.view_report_bug_screenshot, (ViewGroup) getScreenshotsContainer(), false);
            Glide.with(requireContext()).m4157load(next).into((ImageView) screenshotButton.findViewById(R.id.screenshotImage));
            Intrinsics.checkNotNullExpressionValue(screenshotButton, "screenshotButton");
            ViewExtensionsKt.onClick$default(screenshotButton, null, new a(next, null), 1, null);
            getScreenshotsContainer().addView(screenshotButton);
        }
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setLayoutParams(new LinearLayout.LayoutParams(IntExtensionsKt.getPx(56), IntExtensionsKt.getPx(56)));
        imageButton.setImageResource(R.drawable.ic_plus_white_24dp);
        ViewExtensionsKt.onClick$default(imageButton, null, new b(null), 1, null);
        getScreenshotsContainer().addView(imageButton);
    }

    @NotNull
    public final EditText getDescriptionText() {
        EditText editText = this.descriptionText;
        if (editText != null) {
            return editText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("descriptionText");
        return null;
    }

    @NotNull
    public final FlowLayout getScreenshotsContainer() {
        FlowLayout flowLayout = this.screenshotsContainer;
        if (flowLayout != null) {
            return flowLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenshotsContainer");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        Uri uri;
        super.onActivityResult(i4, i5, intent);
        if (i5 == -1) {
            if (intent != null) {
                uri = intent.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                this.f9555b.add(uri);
                d();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_bug_detail, viewGroup, false);
        ButterKnife.bind(this, inflate);
        d();
        return inflate;
    }

    @OnClick({R.id.continueButton})
    public final void onFabClicked() {
        if (getDescriptionText().length() < 50) {
            b();
            return;
        }
        ReportBugActivity reportBugActivity = (ReportBugActivity) getActivity();
        Intrinsics.checkNotNull(reportBugActivity);
        reportBugActivity.detailsEntered(getDescriptionText().getText().toString(), this.f9555b);
    }

    public final void setDescriptionText(@NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.descriptionText = editText;
    }

    public final void setScreenshotsContainer(@NotNull FlowLayout flowLayout) {
        Intrinsics.checkNotNullParameter(flowLayout, "<set-?>");
        this.screenshotsContainer = flowLayout;
    }
}
