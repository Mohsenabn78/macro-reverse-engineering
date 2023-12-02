package com.arlosoft.macrodroid.templatestore.ui.upload;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.SerialCalculator;
import com.arlosoft.macrodroid.databinding.ActivityUploadTemplateBinding;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.language.LanguageAdapter;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macrolist.HeadingColorMapper;
import com.arlosoft.macrodroid.macrolist.MacroListCategoryHeader;
import com.arlosoft.macrodroid.macrolist.MacroListItem;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.model.TemplateCategory;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateItemViewHolder;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateUploadActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTemplateUploadActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateUploadActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/upload/TemplateUploadActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n262#2,2:415\n1549#3:417\n1620#3,3:418\n*S KotlinDebug\n*F\n+ 1 TemplateUploadActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/upload/TemplateUploadActivity\n*L\n190#1:415,2\n199#1:417\n199#1:418,3\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplateUploadActivity extends MacroDroidDaggerBaseActivity implements TemplateUploadViewContract {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private AppCompatDialog f14134f;
    @Inject
    public FlagProvider flagProvider;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private AppCompatDialog f14135g;

    /* renamed from: h  reason: collision with root package name */
    private FlexibleAdapter<MacroListCategoryHeader> f14136h;
    @Inject
    public HeadingColorMapper headingColorMapper;

    /* renamed from: i  reason: collision with root package name */
    private CategoryList f14137i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final HashSet<String> f14138j = new HashSet<>();
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final HashSet<String> f14139k = new HashSet<>();

    /* renamed from: l  reason: collision with root package name */
    private ActivityUploadTemplateBinding f14140l;
    @Inject
    public TemplateUploadPresenter presenter;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public TemplatesTranslationHelper translationHelper;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TemplateUploadActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, Integer num, Macro macro, String str, String str2, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                num = 0;
            }
            Integer num2 = num;
            if ((i4 & 4) != 0) {
                macro = null;
            }
            return companion.createIntent(context, num2, macro, str, str2);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @Nullable Integer num, @Nullable Macro macro, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, TemplateUploadActivity.class);
            intent.putExtra("macro", macro != null ? macro.getGUID() : 0L);
            intent.putExtra("default_category", str2);
            intent.putExtra("default_description", str);
            intent.putExtra("updating_macro_id", num);
            return intent;
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, Integer num, String str, String str2, String str3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                num = 0;
            }
            return companion.createIntent(context, num, str, str2, str3);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @Nullable Integer num, @NotNull String macroName, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(macroName, "macroName");
            Intent intent = new Intent(context, TemplateUploadActivity.class);
            intent.putExtra(HelperCommandsKt.HELPER_EXTRA_MACRO_NAME, macroName);
            intent.putExtra("default_category", str2);
            intent.putExtra("default_description", str);
            intent.putExtra("updating_macro_id", num);
            return intent;
        }
    }

    /* compiled from: TemplateUploadActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<TemplateCategory> $categories;
        final /* synthetic */ Spinner $categorySpinner;
        final /* synthetic */ EditText $descriptionText;
        final /* synthetic */ String[] $languageCodes;
        final /* synthetic */ Spinner $languageSpinner;
        final /* synthetic */ Macro $macro;
        final /* synthetic */ TextView $nameText;
        final /* synthetic */ boolean $updatingMacro;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(TextView textView, EditText editText, Macro macro, String[] strArr, Spinner spinner, List<TemplateCategory> list, Spinner spinner2, boolean z3, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$nameText = textView;
            this.$descriptionText = editText;
            this.$macro = macro;
            this.$languageCodes = strArr;
            this.$languageSpinner = spinner;
            this.$categories = list;
            this.$categorySpinner = spinner2;
            this.$updatingMacro = z3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$nameText, this.$descriptionText, this.$macro, this.$languageCodes, this.$languageSpinner, this.$categories, this.$categorySpinner, this.$updatingMacro, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            CharSequence charSequence;
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateUploadPresenter presenter = TemplateUploadActivity.this.getPresenter();
                TextView textView = this.$nameText;
                Editable editable = null;
                if (textView != null) {
                    charSequence = textView.getText();
                } else {
                    charSequence = null;
                }
                String valueOf = String.valueOf(charSequence);
                EditText editText = this.$descriptionText;
                if (editText != null) {
                    editable = editText.getText();
                }
                String valueOf2 = String.valueOf(editable);
                Macro macro = this.$macro;
                String[] strArr = this.$languageCodes;
                Spinner spinner = this.$languageSpinner;
                int i5 = 0;
                if (spinner != null) {
                    i4 = spinner.getSelectedItemPosition();
                } else {
                    i4 = 0;
                }
                String str = strArr[i4];
                Intrinsics.checkNotNullExpressionValue(str, "languageCodes[languageSp…                    ?: 0]");
                List<TemplateCategory> list = this.$categories;
                Spinner spinner2 = this.$categorySpinner;
                if (spinner2 != null) {
                    i5 = spinner2.getSelectedItemPosition();
                }
                presenter.onDetailsSubmitted(valueOf, valueOf2, macro, str, list.get(i5).getId(), this.$updatingMacro);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateUploadActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $updatingMacro;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z3, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$updatingMacro = z3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$updatingMacro, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AppCompatDialog appCompatDialog = TemplateUploadActivity.this.f14135g;
                if (appCompatDialog != null) {
                    appCompatDialog.dismiss();
                }
                if (this.$updatingMacro) {
                    TemplateUploadActivity.this.finish();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateUploadActivity.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $categoryId;
        final /* synthetic */ MacroTemplate $macroTemplate;
        final /* synthetic */ boolean $updatingMacro;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MacroTemplate macroTemplate, int i4, boolean z3, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$macroTemplate = macroTemplate;
            this.$categoryId = i4;
            this.$updatingMacro = z3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$macroTemplate, this.$categoryId, this.$updatingMacro, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateUploadPresenter presenter = TemplateUploadActivity.this.getPresenter();
                Macro macro = this.$macroTemplate.getMacro();
                Intrinsics.checkNotNull(macro);
                presenter.uploadMacro(macro, this.$macroTemplate.getLanguage(), this.$categoryId, this.$updatingMacro);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateUploadActivity.kt */
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $updatingMacro;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(boolean z3, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$updatingMacro = z3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$updatingMacro, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AppCompatDialog appCompatDialog = TemplateUploadActivity.this.f14134f;
                if (appCompatDialog != null) {
                    appCompatDialog.dismiss();
                }
                if (this.$updatingMacro) {
                    TemplateUploadActivity.this.finish();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(TemplateUploadActivity this$0, MacroListCategoryHeader it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.w(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int B(Collator collator, Macro macro, Macro macro2) {
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(TemplateUploadActivity this$0, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateUploadPresenter presenter = this$0.getPresenter();
        Intrinsics.checkNotNullExpressionValue(macro, "macro");
        presenter.onMacroSelected(macro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(View view) {
        return true;
    }

    private final void F(String str, final String str2, final String str3, final MacroListCategoryHeader macroListCategoryHeader) {
        String str4;
        CategoryList categoryList = this.f14137i;
        if (categoryList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            str4 = str2;
            categoryList = null;
        } else {
            str4 = str2;
        }
        final Category categoryByName = categoryList.getCategoryByName(str4);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.passwordEntry);
        Button button = (Button) inflate.findViewById(R.id.okButton);
        Button button2 = (Button) inflate.findViewById(R.id.cancelButton);
        builder.setTitle(str);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "alert.create()");
        Window window = create.getWindow();
        if (window != null) {
            window.clearFlags(131080);
        }
        Window window2 = create.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(5);
        }
        create.show();
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateUploadActivity.G(TemplateUploadActivity.this, editText, str3, str2, macroListCategoryHeader, categoryByName, create, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateUploadActivity.H(create, view);
            }
        });
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(TemplateUploadActivity this$0, EditText editText, String str, String categoryName, MacroListCategoryHeader categoryHeader, Category category, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(categoryName, "$categoryName");
        Intrinsics.checkNotNullParameter(categoryHeader, "$categoryHeader");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (Intrinsics.areEqual(this$0.v(editText.getText().toString()), str)) {
            this$0.f14138j.add(categoryName);
            categoryHeader.setHasUnlocked(true);
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter = this$0.f14136h;
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter2 = null;
            if (flexibleAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter = null;
            }
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter3 = this$0.f14136h;
            if (flexibleAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter3 = null;
            }
            flexibleAdapter.notifyItemChanged(flexibleAdapter3.getGlobalPositionOf(categoryHeader));
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter4 = this$0.f14136h;
            if (flexibleAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter4 = null;
            }
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter5 = this$0.f14136h;
            if (flexibleAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                flexibleAdapter2 = flexibleAdapter5;
            }
            flexibleAdapter4.expand(flexibleAdapter2.getGlobalPositionOf(categoryHeader));
            HashSet<String> hashSet = this$0.f14139k;
            Intrinsics.checkNotNull(category);
            hashSet.add(category.getName());
            dialog.dismiss();
            return;
        }
        ToastCompat.makeText(this$0, (int) R.string.invalid_password, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    private final String v(String str) {
        String calculateSerialCode = SerialCalculator.calculateSerialCode(str, 24);
        Intrinsics.checkNotNullExpressionValue(calculateSerialCode, "calculateSerialCode(password, 24)");
        return calculateSerialCode;
    }

    private final void w(MacroListCategoryHeader macroListCategoryHeader) {
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter = this.f14136h;
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter2 = null;
        if (flexibleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter = null;
        }
        int globalPositionOf = flexibleAdapter.getGlobalPositionOf(macroListCategoryHeader);
        CategoryList categoryList = this.f14137i;
        if (categoryList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            categoryList = null;
        }
        Category categoryByName = categoryList.getCategoryByName(macroListCategoryHeader.category().getName());
        boolean z3 = true;
        if (!macroListCategoryHeader.isExpanded()) {
            if ((categoryByName == null || !categoryByName.isLocked() || this.f14138j.contains(categoryByName.getName())) ? false : false) {
                String string = getString(R.string.unlock_category);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.unlock_category)");
                F(string, macroListCategoryHeader.category().getName(), Settings.getLockedCategoryPassword(this), macroListCategoryHeader);
                return;
            }
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter3 = this.f14136h;
            if (flexibleAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                flexibleAdapter2 = flexibleAdapter3;
            }
            flexibleAdapter2.expand(globalPositionOf);
            return;
        }
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter4 = this.f14136h;
        if (flexibleAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            flexibleAdapter2 = flexibleAdapter4;
        }
        flexibleAdapter2.collapse(globalPositionOf, true);
        if (categoryByName != null && this.f14139k.contains(categoryByName.getName())) {
            this.f14139k.remove(categoryByName.getName());
        }
    }

    private final void x() {
        ActivityUploadTemplateBinding activityUploadTemplateBinding;
        int i4;
        boolean z3;
        CategoryList categoryList = null;
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter = new FlexibleAdapter<>(new ArrayList(), null, true);
        this.f14136h = flexibleAdapter;
        flexibleAdapter.addListener(new FlexibleAdapter.OnItemClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.a
            @Override // eu.davidea.flexibleadapter.FlexibleAdapter.OnItemClickListener
            public final boolean onItemClick(View view, int i5) {
                boolean y3;
                y3 = TemplateUploadActivity.y(view, i5);
                return y3;
            }
        });
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter2 = this.f14136h;
        if (flexibleAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter2 = null;
        }
        flexibleAdapter2.setAnimateToLimit(Integer.MAX_VALUE);
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter3 = this.f14136h;
        if (flexibleAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter3 = null;
        }
        flexibleAdapter3.setAutoScrollOnExpand(true);
        ActivityUploadTemplateBinding activityUploadTemplateBinding2 = this.f14140l;
        if (activityUploadTemplateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding2 = null;
        }
        activityUploadTemplateBinding2.recyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        ActivityUploadTemplateBinding activityUploadTemplateBinding3 = this.f14140l;
        if (activityUploadTemplateBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding3 = null;
        }
        RecyclerView recyclerView = activityUploadTemplateBinding3.recyclerView;
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter4 = this.f14136h;
        if (flexibleAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter4 = null;
        }
        recyclerView.setAdapter(flexibleAdapter4);
        ActivityUploadTemplateBinding activityUploadTemplateBinding4 = this.f14140l;
        if (activityUploadTemplateBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding4 = null;
        }
        activityUploadTemplateBinding4.recyclerView.setHasFixedSize(true);
        ActivityUploadTemplateBinding activityUploadTemplateBinding5 = this.f14140l;
        if (activityUploadTemplateBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding5 = null;
        }
        boolean z4 = false;
        activityUploadTemplateBinding5.recyclerView.addItemDecoration(new FlexibleItemDecoration(this).addItemViewType(R.layout.macro_list_row, 0, 3, 0, 0).withEdge(true).withBottomEdge(false).withSectionGapOffset(0));
        HashMap<String, List<Macro>> categoryMap = MacroStore.getInstance().getCategoryMap();
        ArrayList arrayList = new ArrayList();
        final Collator collator = Collator.getInstance(Settings.getLocale(this));
        collator.setStrength(0);
        ArrayList arrayList2 = new ArrayList(categoryMap.keySet());
        kotlin.collections.h.sortWith(arrayList2, new Comparator() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int z5;
                z5 = TemplateUploadActivity.z(collator, (String) obj, (String) obj2);
                return z5;
            }
        });
        CategoryList categoryList2 = (CategoryList) MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE).get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList2 == null) {
            categoryList2 = new CategoryList(new ArrayList());
        }
        this.f14137i = categoryList2;
        Iterator it = arrayList2.iterator();
        int i5 = 0;
        int i6 = AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
        while (it.hasNext()) {
            String categoryName = (String) it.next();
            CategoryList categoryList3 = this.f14137i;
            if (categoryList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryList");
                categoryList3 = categoryList;
            }
            Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
            Category categoryByName = categoryList3.getCategoryByName(categoryName);
            if (categoryByName == null) {
                categoryByName = new Category(categoryName, ContextCompat.getColor(this, R.color.default_macro_tile_color), z4, z4);
            }
            Category category = categoryByName;
            int i7 = i6 + 1;
            MacroListCategoryHeader macroListCategoryHeader = new MacroListCategoryHeader(category, i6, true, false, false, new MacroListCategoryHeader.OnCategoryClickedListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.c
                @Override // com.arlosoft.macrodroid.macrolist.MacroListCategoryHeader.OnCategoryClickedListener
                public final void onClick(MacroListCategoryHeader macroListCategoryHeader2) {
                    TemplateUploadActivity.A(TemplateUploadActivity.this, macroListCategoryHeader2);
                }
            }, null, getHeadingColorMapper());
            List<Macro> list = categoryMap.get(categoryName);
            if (list != null) {
                kotlin.collections.h.sortWith(list, new Comparator() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.d
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int B;
                        B = TemplateUploadActivity.B(collator, (Macro) obj, (Macro) obj2);
                        return B;
                    }
                });
            }
            Intrinsics.checkNotNull(list);
            int i8 = i5;
            int i9 = 0;
            for (final Macro macro : list) {
                int i10 = i9 + 1;
                int i11 = i8 + 1;
                if (i9 == list.size() - 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                macroListCategoryHeader.addSubItem(new MacroListItem(macroListCategoryHeader, i8, macro, category, 0L, false, 0L, false, false, z3, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TemplateUploadActivity.C(TemplateUploadActivity.this, macro, view);
                    }
                }, new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.f
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean D;
                        D = TemplateUploadActivity.D(view);
                        return D;
                    }
                }, new MacroListItem.FavouriteRemovedListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.g
                    @Override // com.arlosoft.macrodroid.macrolist.MacroListItem.FavouriteRemovedListener
                    public final void favouriteRemoved(MacroListItem macroListItem) {
                        TemplateUploadActivity.E(macroListItem);
                    }
                }, false, getHeadingColorMapper(), true, this.f14138j));
                i9 = i10;
                i8 = i11;
            }
            arrayList.add(macroListCategoryHeader);
            i5 = i8;
            i6 = i7;
            categoryList = null;
            z4 = false;
        }
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter5 = this.f14136h;
        if (flexibleAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter5 = null;
        }
        flexibleAdapter5.updateDataSet(arrayList);
        ActivityUploadTemplateBinding activityUploadTemplateBinding6 = this.f14140l;
        if (activityUploadTemplateBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding = null;
        } else {
            activityUploadTemplateBinding = activityUploadTemplateBinding6;
        }
        LinearLayout linearLayout = activityUploadTemplateBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        if (arrayList.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(View view, int i4) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int z(Collator collator, String str, String str2) {
        return collator.compare(str, str2);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void closeUploadScreen() {
        finish();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void dismissCategoryAndDescriptionDialog() {
        AppCompatDialog appCompatDialog = this.f14135g;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void displayCategoryAndDescriptionDialog(@NotNull Macro macro, int i4, boolean z3, @Nullable String str, @Nullable String str2) {
        List mutableList;
        int collectionSizeOrDefault;
        Iterable withIndex;
        Button button;
        Button button2;
        String description;
        Intrinsics.checkNotNullParameter(macro, "macro");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) TemplateCategory.Companion.getAllCategories(this, false));
        if (i4 == 0) {
            String string = getString(R.string.select_category);
            mutableList.add(0, new TemplateCategory("< " + string + " >", 0));
        }
        List<TemplateCategory> list = mutableList;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TemplateCategory templateCategory : list) {
            arrayList.add(templateCategory.getName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Template);
        this.f14135g = appCompatDialog;
        appCompatDialog.setCancelable(false);
        AppCompatDialog appCompatDialog2 = this.f14135g;
        if (appCompatDialog2 != null) {
            appCompatDialog2.setContentView(R.layout.dialog_upload_details);
        }
        AppCompatDialog appCompatDialog3 = this.f14135g;
        if (appCompatDialog3 != null) {
            appCompatDialog3.setTitle(getString(z3 ? R.string.update_template : R.string.upload_as_template));
        }
        AppCompatDialog appCompatDialog4 = this.f14135g;
        if (appCompatDialog4 != null) {
            DialogExtensionsKt.setWidthToParent$default(appCompatDialog4, 0, 1, null);
        }
        AppCompatDialog appCompatDialog5 = this.f14135g;
        EditText editText = appCompatDialog5 != null ? (EditText) appCompatDialog5.findViewById(R.id.descriptionText) : null;
        AppCompatDialog appCompatDialog6 = this.f14135g;
        Spinner spinner = appCompatDialog6 != null ? (Spinner) appCompatDialog6.findViewById(R.id.catgorySpinner) : null;
        AppCompatDialog appCompatDialog7 = this.f14135g;
        Spinner spinner2 = appCompatDialog7 != null ? (Spinner) appCompatDialog7.findViewById(R.id.languageSpinner) : null;
        AppCompatDialog appCompatDialog8 = this.f14135g;
        TextView textView = appCompatDialog8 != null ? (TextView) appCompatDialog8.findViewById(R.id.nameText) : null;
        if (textView != null) {
            textView.setText(macro.getName());
        }
        if (editText != null) {
            String description2 = macro.getDescription();
            if (description2 == null || description2.length() == 0) {
                description = str == null ? "" : str;
            } else {
                description = macro.getDescription();
            }
            editText.setText(description);
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        String language = Locale.getDefault().getLanguage();
        String[] stringArray = getResources().getStringArray(R.array.languages_codes);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.languages_codes)");
        String[] stringArray2 = getResources().getStringArray(R.array.languages);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "resources.getStringArray(R.array.languages)");
        LanguageAdapter languageAdapter = new LanguageAdapter(this, stringArray2, stringArray, getFlagProvider());
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) languageAdapter);
        }
        int length = stringArray.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (!Intrinsics.areEqual(language, stringArray[i5])) {
                i5++;
            } else if (spinner2 != null) {
                spinner2.setSelection(i5);
            }
        }
        String category = str2 == null ? macro.getCategory() : str2;
        withIndex = CollectionsKt___CollectionsKt.withIndex(list);
        Iterator it = withIndex.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IndexedValue indexedValue = (IndexedValue) it.next();
            if (Intrinsics.areEqual(((TemplateCategory) indexedValue.getValue()).getName(), category)) {
                if (spinner != null) {
                    spinner.setSelection(indexedValue.getIndex());
                }
            }
        }
        AppCompatDialog appCompatDialog9 = this.f14135g;
        if (appCompatDialog9 != null && (button2 = (Button) appCompatDialog9.findViewById(R.id.okButton)) != null) {
            ViewExtensionsKt.onClick$default(button2, null, new a(textView, editText, macro, stringArray, spinner2, mutableList, spinner, z3, null), 1, null);
        }
        AppCompatDialog appCompatDialog10 = this.f14135g;
        if (appCompatDialog10 != null && (button = (Button) appCompatDialog10.findViewById(R.id.cancelButton)) != null) {
            ViewExtensionsKt.onClick$default(button, null, new b(z3, null), 1, null);
        }
        AppCompatDialog appCompatDialog11 = this.f14135g;
        if (appCompatDialog11 != null) {
            appCompatDialog11.show();
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void displayTemplatePreviewDialog(@NotNull MacroTemplate macroTemplate, int i4, boolean z3) {
        View view;
        Button button;
        Button button2;
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        new ArrayAdapter(this, 17367048, Settings.getCategories(this)).setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Template);
        this.f14134f = appCompatDialog;
        appCompatDialog.setCancelable(false);
        AppCompatDialog appCompatDialog2 = this.f14134f;
        if (appCompatDialog2 != null) {
            appCompatDialog2.setContentView(R.layout.dialog_template_preview);
        }
        AppCompatDialog appCompatDialog3 = this.f14134f;
        if (appCompatDialog3 != null) {
            appCompatDialog3.setTitle(getString(R.string.preview));
        }
        AppCompatDialog appCompatDialog4 = this.f14134f;
        if (appCompatDialog4 != null) {
            DialogExtensionsKt.setWidthToParent$default(appCompatDialog4, 0, 1, null);
        }
        AppCompatDialog appCompatDialog5 = this.f14134f;
        if (appCompatDialog5 != null) {
            view = appCompatDialog5.findViewById(R.id.cardView);
        } else {
            view = null;
        }
        Intrinsics.checkNotNull(view);
        new TemplateItemViewHolder(view, new TemplateItemPresenter() { // from class: com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadActivity$displayTemplatePreviewDialog$viewHolder$1
            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void commentsClicked(@NotNull MacroTemplate macroTemplate2) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
            }

            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void flagClicked(@NotNull MacroTemplate macroTemplate2) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
            }

            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void menuClicked(@NotNull MacroTemplate macroTemplate2) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
            }

            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void reportClicked(@NotNull MacroTemplate macroTemplate2) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
            }

            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void starClicked(@NotNull MacroTemplate macroTemplate2) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
            }

            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void subscribeMacroClicked(@NotNull MacroTemplate macroTemplate2, boolean z4) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
            }

            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void templateClicked(@NotNull MacroTemplate macroTemplate2) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
            }

            @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
            public void usernameClicked(@NotNull MacroTemplate macroTemplate2, @NotNull AvatarView avatarImage) {
                Intrinsics.checkNotNullParameter(macroTemplate2, "macroTemplate");
                Intrinsics.checkNotNullParameter(avatarImage, "avatarImage");
            }
        }, getProfileImageProvider(), getUserProvider(), getFlagProvider(), false, new ArrayList(), false, false, getTranslationHelper()).bind(macroTemplate, false, false, false);
        AppCompatDialog appCompatDialog6 = this.f14134f;
        if (appCompatDialog6 != null) {
            button = (Button) appCompatDialog6.findViewById(R.id.uploadButton);
        } else {
            button = null;
        }
        if (z3 && button != null) {
            button.setText(R.string.update_template);
        }
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, null, new c(macroTemplate, i4, z3, null), 1, null);
        }
        AppCompatDialog appCompatDialog7 = this.f14134f;
        if (appCompatDialog7 != null && (button2 = (Button) appCompatDialog7.findViewById(R.id.cancelButton)) != null) {
            ViewExtensionsKt.onClick$default(button2, null, new d(z3, null), 1, null);
        }
        AppCompatDialog appCompatDialog8 = this.f14134f;
        if (appCompatDialog8 != null) {
            appCompatDialog8.show();
        }
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
    public final HeadingColorMapper getHeadingColorMapper() {
        HeadingColorMapper headingColorMapper = this.headingColorMapper;
        if (headingColorMapper != null) {
            return headingColorMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("headingColorMapper");
        return null;
    }

    @NotNull
    public final TemplateUploadPresenter getPresenter() {
        TemplateUploadPresenter templateUploadPresenter = this.presenter;
        if (templateUploadPresenter != null) {
            return templateUploadPresenter;
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

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void hideTemplatePreviewDialog() {
        AppCompatDialog appCompatDialog = this.f14134f;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        ActionBar supportActionBar;
        super.onCreate(bundle);
        ActivityUploadTemplateBinding inflate = ActivityUploadTemplateBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f14140l = inflate;
        ActivityUploadTemplateBinding activityUploadTemplateBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityUploadTemplateBinding activityUploadTemplateBinding2 = this.f14140l;
        if (activityUploadTemplateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUploadTemplateBinding = activityUploadTemplateBinding2;
        }
        setSupportActionBar(activityUploadTemplateBinding.toolbar);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        getPresenter().takeView(this);
        getPresenter().setUpdatingMacroDetails(getIntent().getIntExtra("updating_macro_id", 0), getIntent().getStringExtra("default_description"), getIntent().getStringExtra("default_category"));
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(getIntent().getLongExtra("macro", 0L));
        if (macroByGUID != null) {
            getPresenter().handleMacroToUpdate(macroByGUID);
        }
        String stringExtra = getIntent().getStringExtra(HelperCommandsKt.HELPER_EXTRA_MACRO_NAME);
        setTitle(R.string.select_macro);
        if (stringExtra != null && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.setSubtitle(stringExtra);
        }
        x();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public final void setFlagProvider(@NotNull FlagProvider flagProvider) {
        Intrinsics.checkNotNullParameter(flagProvider, "<set-?>");
        this.flagProvider = flagProvider;
    }

    public final void setHeadingColorMapper(@NotNull HeadingColorMapper headingColorMapper) {
        Intrinsics.checkNotNullParameter(headingColorMapper, "<set-?>");
        this.headingColorMapper = headingColorMapper;
    }

    public final void setPresenter(@NotNull TemplateUploadPresenter templateUploadPresenter) {
        Intrinsics.checkNotNullParameter(templateUploadPresenter, "<set-?>");
        this.presenter = templateUploadPresenter;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setTranslationHelper(@NotNull TemplatesTranslationHelper templatesTranslationHelper) {
        Intrinsics.checkNotNullParameter(templatesTranslationHelper, "<set-?>");
        this.translationHelper = templatesTranslationHelper;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void setUploadingState(boolean z3) {
        ViewFlipper viewFlipper;
        AppCompatDialog appCompatDialog = this.f14134f;
        if (appCompatDialog != null) {
            viewFlipper = (ViewFlipper) appCompatDialog.findViewById(R.id.bottomViewFlipper);
        } else {
            viewFlipper = null;
        }
        if (viewFlipper != null) {
            viewFlipper.setDisplayedChild(z3 ? 1 : 0);
        }
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void showDuplicateError() {
        ToastCompat.makeText(getApplicationContext(), (int) R.string.duplicate_template_error, 1).show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void showInvalidDataError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template);
        builder.setTitle(R.string.invalid_value);
        builder.setMessage(R.string.invalid_macro_name_or_description).setCancelable(true).setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void showSelectCategory() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template);
        builder.setTitle(R.string.invalid_value);
        builder.setMessage(R.string.please_select_a_category).setCancelable(true).setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void showUploadFailedError() {
        ToastCompat.makeText(getApplicationContext(), (int) R.string.upload_failed, 1).show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadViewContract
    public void showUploadedOk() {
        ToastCompat.makeText(getApplicationContext(), (int) R.string.template_uploaded, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(MacroListItem macroListItem) {
    }
}
