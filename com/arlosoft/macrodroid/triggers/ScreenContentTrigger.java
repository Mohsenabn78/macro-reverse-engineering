package com.arlosoft.macrodroid.triggers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.PreferencesActivity;
import com.arlosoft.macrodroid.triggers.info.ScreenContentTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.QueryUiService;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScreenContentTrigger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nScreenContentTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenContentTrigger.kt\ncom/arlosoft/macrodroid/triggers/ScreenContentTrigger\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,440:1\n262#2,2:441\n*S KotlinDebug\n*F\n+ 1 ScreenContentTrigger.kt\ncom/arlosoft/macrodroid/triggers/ScreenContentTrigger\n*L\n193#1:441,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ScreenContentTrigger extends Trigger implements SupportsMagicText, GetAppListTask.AppListListener {
    public static final int MATCH_OPTION_TEXT_CONTENT = 0;
    public static final int MATCH_OPTION_VIEW_ID = 1;
    private static int triggerCount;
    @Nullable
    private transient TextView allAppsWarning;
    @NotNull
    private ArrayList<String> appNameList;
    @Nullable
    private transient TextView applicationsText;
    private transient boolean canTrigger;
    private boolean enableRegex;
    private boolean ignoreCase;
    private boolean includeOverlays;
    private boolean isOffScreen;
    private int matchOption;
    @NotNull
    private ArrayList<String> packageNameList;
    @Inject
    public transient PremiumStatusHandler premiumStatusHandler;
    @Nullable
    private String textToMatch;
    @NotNull
    private transient ArrayList<String> workingAppNameList;
    @NotNull
    private transient ArrayList<String> workingPackageNameList;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ScreenContentTrigger> CREATOR = new Parcelable.Creator<ScreenContentTrigger>() { // from class: com.arlosoft.macrodroid.triggers.ScreenContentTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ScreenContentTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ScreenContentTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ScreenContentTrigger[] newArray(int i4) {
            return new ScreenContentTrigger[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScreenContentTrigger.kt */
    @SourceDebugExtension({"SMAP\nScreenContentTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenContentTrigger.kt\ncom/arlosoft/macrodroid/triggers/ScreenContentTrigger$displayApplicationChooser$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,440:1\n1#2:441\n262#3,2:442\n*S KotlinDebug\n*F\n+ 1 ScreenContentTrigger.kt\ncom/arlosoft/macrodroid/triggers/ScreenContentTrigger$displayApplicationChooser$4\n*L\n356#1:442,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApplicationAdapter $adapter;
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ApplicationAdapter applicationAdapter, AppCompatDialog appCompatDialog, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$adapter = applicationAdapter;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$adapter, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ScreenContentTrigger.this.workingPackageNameList = new ArrayList();
                ScreenContentTrigger.this.workingAppNameList = new ArrayList();
                List<AppInfo> checkedItems = this.$adapter.getCheckedItems();
                int size = checkedItems.size();
                int i4 = 0;
                boolean z3 = false;
                while (i4 < size) {
                    AppInfo appInfo = checkedItems.get(i4);
                    ScreenContentTrigger.this.workingPackageNameList.add(appInfo.packageName);
                    ScreenContentTrigger.this.workingAppNameList.add(appInfo.applicationName);
                    TextView applicationsText = ScreenContentTrigger.this.getApplicationsText();
                    if (applicationsText != null) {
                        ScreenContentTrigger screenContentTrigger = ScreenContentTrigger.this;
                        screenContentTrigger.b0(applicationsText, screenContentTrigger.workingAppNameList);
                    }
                    TextView allAppsWarning = ScreenContentTrigger.this.getAllAppsWarning();
                    if (allAppsWarning != null) {
                        allAppsWarning.setVisibility(8);
                    }
                    i4++;
                    z3 = true;
                }
                if (z3) {
                    this.$dialog.dismiss();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScreenContentTrigger.kt */
    @SourceDebugExtension({"SMAP\nScreenContentTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenContentTrigger.kt\ncom/arlosoft/macrodroid/triggers/ScreenContentTrigger$displayApplicationChooser$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,440:1\n1#2:441\n262#3,2:442\n*S KotlinDebug\n*F\n+ 1 ScreenContentTrigger.kt\ncom/arlosoft/macrodroid/triggers/ScreenContentTrigger$displayApplicationChooser$5\n*L\n367#1:442,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AppCompatDialog appCompatDialog, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ScreenContentTrigger.this.workingPackageNameList = new ArrayList();
                ScreenContentTrigger.this.workingAppNameList = new ArrayList();
                TextView applicationsText = ScreenContentTrigger.this.getApplicationsText();
                if (applicationsText != null) {
                    ScreenContentTrigger screenContentTrigger = ScreenContentTrigger.this;
                    screenContentTrigger.b0(applicationsText, screenContentTrigger.workingAppNameList);
                }
                TextView allAppsWarning = ScreenContentTrigger.this.getAllAppsWarning();
                if (allAppsWarning != null) {
                    allAppsWarning.setVisibility(0);
                }
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ScreenContentTrigger.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextInputLayout $textToMatchLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(TextInputLayout textInputLayout, Continuation<? super c> continuation) {
            super(4, continuation);
            this.$textToMatchLayout = textInputLayout;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            c cVar = new c(this.$textToMatchLayout, continuation);
            cVar.Z$0 = z3;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z3 = this.Z$0;
                TextInputLayout textInputLayout = this.$textToMatchLayout;
                if (z3) {
                    i4 = R.string.text_to_match;
                } else {
                    i4 = R.string.view_id_to_match;
                }
                textInputLayout.setHint(SelectableItem.r(i4));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ScreenContentTrigger.kt */
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MagicText.MagicTextListener magicTextListener, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$magicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(ScreenContentTrigger.this.getActivity(), this.$magicTextListener, ScreenContentTrigger.this.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ScreenContentTrigger.kt */
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
                ScreenContentTrigger screenContentTrigger = ScreenContentTrigger.this;
                new GetAppListTask(screenContentTrigger, screenContentTrigger.getActivity(), true, false, ContextCompat.getColor(ScreenContentTrigger.this.getContext(), R.color.actions_accent)).execute(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ ScreenContentTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void T(List<? extends AppInfo> list) {
        List<AppInfo> reorderSelectedAppsToTop = AppUtils.reorderSelectedAppsToTop(list, this.packageNameList);
        ArrayList arrayList = new ArrayList(reorderSelectedAppsToTop.size());
        int size = reorderSelectedAppsToTop.size();
        int i4 = 0;
        while (true) {
            boolean z3 = true;
            if (i4 < size) {
                int size2 = this.packageNameList.size();
                int i5 = 0;
                while (true) {
                    if (i5 < size2) {
                        if (Intrinsics.areEqual(this.packageNameList.get(i5), reorderSelectedAppsToTop.get(i4).packageName)) {
                            break;
                        }
                        i5++;
                    } else {
                        z3 = false;
                        break;
                    }
                }
                arrayList.add(Boolean.valueOf(z3));
                i4++;
            } else {
                Activity activity = getActivity();
                final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
                appCompatDialog.setContentView(R.layout.dialog_app_chooser);
                appCompatDialog.setTitle(R.string.select_applications);
                View findViewById = appCompatDialog.findViewById(R.id.application_list);
                Intrinsics.checkNotNull(findViewById);
                View findViewById2 = appCompatDialog.findViewById(R.id.okButton);
                Intrinsics.checkNotNull(findViewById2);
                View findViewById3 = appCompatDialog.findViewById(R.id.cancelButton);
                Intrinsics.checkNotNull(findViewById3);
                View findViewById4 = appCompatDialog.findViewById(R.id.include_exclude_options);
                Intrinsics.checkNotNull(findViewById4);
                View findViewById5 = appCompatDialog.findViewById(R.id.radio_options);
                Intrinsics.checkNotNull(findViewById5);
                View findViewById6 = appCompatDialog.findViewById(R.id.non_launchable_checkbox);
                Intrinsics.checkNotNull(findViewById6);
                final CheckBox checkBox = (CheckBox) findViewById6;
                View findViewById7 = appCompatDialog.findViewById(R.id.searchView);
                Intrinsics.checkNotNull(findViewById7);
                final SearchView searchView = (SearchView) findViewById7;
                View findViewById8 = appCompatDialog.findViewById(R.id.allAppsButton);
                Intrinsics.checkNotNull(findViewById8);
                Button button = (Button) findViewById8;
                button.setVisibility(0);
                ((ViewGroup) findViewById4).setVisibility(0);
                ((ViewGroup) findViewById5).setVisibility(8);
                checkBox.setVisibility(0);
                final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, reorderSelectedAppsToTop, arrayList, null);
                ((ListView) findViewById).setAdapter((ListAdapter) applicationAdapter);
                applicationAdapter.getFilter().filter((CharSequence) "", false);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.f7
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        ScreenContentTrigger.U(ApplicationAdapter.this, searchView, compoundButton, z4);
                    }
                });
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.triggers.ScreenContentTrigger$displayApplicationChooser$2
                    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                    public boolean onQueryTextChange(@NotNull String newText) {
                        Intrinsics.checkNotNullParameter(newText, "newText");
                        ApplicationAdapter.this.getFilter().filter(newText, checkBox.isChecked());
                        return false;
                    }

                    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                    public boolean onQueryTextSubmit(@NotNull String query) {
                        Intrinsics.checkNotNullParameter(query, "query");
                        return false;
                    }
                });
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = appCompatDialog.getWindow();
                Intrinsics.checkNotNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                ((Button) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.g7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ScreenContentTrigger.V(AppCompatDialog.this, view);
                    }
                });
                ViewExtensionsKt.onClick$default((Button) findViewById2, null, new a(applicationAdapter, appCompatDialog, null), 1, null);
                ViewExtensionsKt.onClick$default(button, null, new b(appCompatDialog, null), 1, null);
                appCompatDialog.show();
                Window window2 = appCompatDialog.getWindow();
                Intrinsics.checkNotNull(window2);
                window2.setAttributes(layoutParams);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ApplicationAdapter adapter, SearchView searchView, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(searchView, "$searchView");
        adapter.getFilter().filter(searchView.getQuery().toString(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(CheckBox ignoreCaseCheckBox, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(ignoreCaseCheckBox, "$ignoreCaseCheckBox");
        ignoreCaseCheckBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(EditText textToMatchView, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        Intrinsics.checkNotNullParameter(textToMatchView, "$textToMatchView");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(textToMatchView.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(textToMatchView.getSelectionEnd(), 0);
        Editable text = textToMatchView.getText();
        if (text != null) {
            int min = Math.min(coerceAtLeast, coerceAtLeast2);
            int max = Math.max(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(min, max, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ScreenContentTrigger this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getActivity(), PreferencesActivity.class);
        intent.putExtra(PreferencesActivity.EXTRA_SHORTCUT, 5);
        this$0.getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(EditText textToMatchView, ScreenContentTrigger this$0, CheckBox includeOverlaysCheckBox, CheckBox enableRegexCheckBox, CheckBox ignoreCaseCheckBox, RadioButton screenOffRadioButton, RadioButton matchTextContentRadioButton, AppCompatDialog dialog, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(textToMatchView, "$textToMatchView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(includeOverlaysCheckBox, "$includeOverlaysCheckBox");
        Intrinsics.checkNotNullParameter(enableRegexCheckBox, "$enableRegexCheckBox");
        Intrinsics.checkNotNullParameter(ignoreCaseCheckBox, "$ignoreCaseCheckBox");
        Intrinsics.checkNotNullParameter(screenOffRadioButton, "$screenOffRadioButton");
        Intrinsics.checkNotNullParameter(matchTextContentRadioButton, "$matchTextContentRadioButton");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Editable text = textToMatchView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "textToMatchView.text");
        if (text.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.enter_text_to_match, 0).show();
        } else if (includeOverlaysCheckBox.isChecked() && !this$0.getPremiumStatusHandler().getPremiumStatus().isPro()) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.pro_version_required, 1).show();
        } else {
            this$0.textToMatch = textToMatchView.getText().toString();
            this$0.enableRegex = enableRegexCheckBox.isChecked();
            this$0.ignoreCase = ignoreCaseCheckBox.isChecked();
            this$0.packageNameList = this$0.workingPackageNameList;
            this$0.appNameList = this$0.workingAppNameList;
            this$0.includeOverlays = includeOverlaysCheckBox.isChecked();
            this$0.isOffScreen = screenOffRadioButton.isChecked();
            this$0.matchOption = !matchTextContentRadioButton.isChecked();
            this$0.itemComplete();
            dialog.dismiss();
            this$0.applicationsText = null;
            this$0.allAppsWarning = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(AppCompatDialog dialog, ScreenContentTrigger this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.applicationsText = null;
        this$0.allAppsWarning = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(TextView textView, List<String> list) {
        List sorted;
        String replace$default;
        String replace$default2;
        if (!list.isEmpty()) {
            sorted = CollectionsKt___CollectionsKt.sorted(list);
            replace$default = kotlin.text.m.replace$default(sorted.toString(), "[", "", false, 4, (Object) null);
            replace$default2 = kotlin.text.m.replace$default(replace$default, "]", "", false, 4, (Object) null);
            textView.setText(replace$default2);
            return;
        }
        textView.setText(SelectableItem.r(R.string.all_applications));
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(@NotNull List<? extends AppInfo> appInfoList, boolean z3) {
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        if (checkActivityAlive() && z3) {
            T(appInfoList);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = triggerCount - 1;
        triggerCount = i4;
        if (i4 == 0) {
            getContext().stopService(new Intent(getContext(), QueryUiService.class));
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            getContext().startService(new Intent(getContext(), QueryUiService.class));
        }
        triggerCount++;
    }

    @Nullable
    public final TextView getAllAppsWarning() {
        return this.allAppsWarning;
    }

    @Nullable
    public final TextView getApplicationsText() {
        return this.applicationsText;
    }

    public final boolean getCanTrigger() {
        return this.canTrigger;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        int i4;
        String name = super.getName();
        if (this.isOffScreen) {
            i4 = R.string.trigger_screen_content_off_screen;
        } else {
            i4 = R.string.trigger_screen_content_on_screen;
        }
        String r4 = SelectableItem.r(i4);
        return name + " (" + r4 + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro() && this.includeOverlays) {
            return String.valueOf(SelectableItem.r(R.string.using_screen_overlays_requires_pro_version));
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        List sorted;
        String replace$default;
        String replace$default2;
        if (this.appNameList.isEmpty()) {
            String str = this.textToMatch;
            String r4 = SelectableItem.r(R.string.all_applications);
            return str + ": " + r4;
        }
        String str2 = this.textToMatch;
        sorted = CollectionsKt___CollectionsKt.sorted(this.appNameList);
        replace$default = kotlin.text.m.replace$default(sorted.toString(), "[", "", false, 4, (Object) null);
        replace$default2 = kotlin.text.m.replace$default(replace$default, "]", "", false, 4, (Object) null);
        return str2 + ": " + replace$default2;
    }

    public final boolean getIncludeOveralys() {
        return this.includeOverlays;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ScreenContentTriggerInfo.Companion.getInstance();
    }

    public final boolean getIsOffScreen() {
        return this.isOffScreen;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " [" + extendedDetail + "]";
    }

    public final int getMatchOption() {
        return this.matchOption;
    }

    @NotNull
    public final ArrayList<String> getPackageList() {
        return this.packageNameList;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        String[] strArr = new String[1];
        String str = this.textToMatch;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        return strArr;
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

    @Nullable
    public final String getTextToMatch() {
        if (this.textToMatch == null) {
            return null;
        }
        return MagicText.replaceMagicText(getContext().getApplicationContext(), this.textToMatch, null, getMacro());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @SuppressLint({"CheckResult"})
    public void handleItemSelected() {
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_ui_query_config);
        appCompatDialog.setTitle(R.string.trigger_screen_content);
        this.workingPackageNameList = this.packageNameList;
        this.workingAppNameList = this.appNameList;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.textToMatch);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.textToMatchLayout);
        Intrinsics.checkNotNull(findViewById4);
        TextInputLayout textInputLayout = (TextInputLayout) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.magicTextButton);
        Intrinsics.checkNotNull(findViewById5);
        Button button3 = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.enableRegexCheckbox);
        Intrinsics.checkNotNull(findViewById6);
        final CheckBox checkBox = (CheckBox) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.selectAppsButton);
        Intrinsics.checkNotNull(findViewById7);
        ImageButton imageButton = (ImageButton) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.ignoreCaseCheckbox);
        Intrinsics.checkNotNull(findViewById8);
        final CheckBox checkBox2 = (CheckBox) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.updateRateLink);
        Intrinsics.checkNotNull(findViewById9);
        TextView textView = (TextView) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.radio_button_on_screen);
        Intrinsics.checkNotNull(findViewById10);
        RadioButton radioButton = (RadioButton) findViewById10;
        View findViewById11 = appCompatDialog.findViewById(R.id.radio_button_off_screen);
        Intrinsics.checkNotNull(findViewById11);
        final RadioButton radioButton2 = (RadioButton) findViewById11;
        View findViewById12 = appCompatDialog.findViewById(R.id.radio_button_match_text);
        Intrinsics.checkNotNull(findViewById12);
        final RadioButton radioButton3 = (RadioButton) findViewById12;
        View findViewById13 = appCompatDialog.findViewById(R.id.radio_button_match_view_id);
        Intrinsics.checkNotNull(findViewById13);
        RadioButton radioButton4 = (RadioButton) findViewById13;
        View findViewById14 = appCompatDialog.findViewById(R.id.allAppsWarning);
        Intrinsics.checkNotNull(findViewById14);
        this.allAppsWarning = (TextView) findViewById14;
        View findViewById15 = appCompatDialog.findViewById(R.id.applicationsText);
        Intrinsics.checkNotNull(findViewById15);
        this.applicationsText = (TextView) findViewById15;
        View findViewById16 = appCompatDialog.findViewById(R.id.include_overlays_checkbox);
        Intrinsics.checkNotNull(findViewById16);
        final CheckBox checkBox3 = (CheckBox) findViewById16;
        checkBox3.setChecked(this.includeOverlays);
        String r4 = SelectableItem.r(R.string.screen_content_include_overlays);
        String r5 = SelectableItem.r(R.string.pro_version_only_short);
        checkBox3.setText(r4 + " (" + r5 + ")");
        TextView textView2 = this.allAppsWarning;
        if (textView2 != null) {
            if (this.workingAppNameList.isEmpty()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textView2.setVisibility(i5);
        }
        TextView textView3 = this.applicationsText;
        Intrinsics.checkNotNull(textView3);
        b0(textView3, this.appNameList);
        radioButton.setChecked(!this.isOffScreen);
        radioButton2.setChecked(this.isOffScreen);
        if (this.matchOption == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton3.setChecked(z3);
        if (this.matchOption == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton4.setChecked(z4);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton3, (CoroutineContext) null, new c(textInputLayout, null), 1, (Object) null);
        if (this.matchOption == 0) {
            i4 = R.string.text_to_match;
        } else {
            i4 = R.string.view_id_to_match;
        }
        textInputLayout.setHint(i4);
        editText.setText(this.textToMatch);
        checkBox.setChecked(this.enableRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox2.setEnabled(!this.enableRegex);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.h7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                ScreenContentTrigger.W(checkBox2, compoundButton, z5);
            }
        });
        ViewExtensionsKt.onClick$default(button3, null, new d(new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.i7
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ScreenContentTrigger.X(editText, magicTextPair);
            }
        }, null), 1, null);
        ViewExtensionsKt.onClick$default(imageButton, null, new e(null), 1, null);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.j7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenContentTrigger.Y(ScreenContentTrigger.this, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.k7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenContentTrigger.Z(editText, this, checkBox3, checkBox, checkBox2, radioButton2, radioButton3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenContentTrigger.a0(AppCompatDialog.this, this, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.animateInUpgradeSceen(activity);
    }

    public final boolean isIgnoreCase() {
        return this.ignoreCase;
    }

    public final boolean isRegexEnabled() {
        return this.enableRegex;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUIInteractionAccessibility() {
        return true;
    }

    public final void setAllAppsWarning(@Nullable TextView textView) {
        this.allAppsWarning = textView;
    }

    public final void setApplicationsText(@Nullable TextView textView) {
        this.applicationsText = textView;
    }

    public final void setCanTrigger(boolean z3) {
        this.canTrigger = z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        if (r4.length == 1) goto L5;
     */
    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPossibleMagicText(@org.jetbrains.annotations.Nullable java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L8
            int r1 = r4.length
            r2 = 1
            if (r1 != r2) goto L8
            goto L9
        L8:
            r2 = 0
        L9:
            if (r2 == 0) goto Lf
            r4 = r4[r0]
            r3.textToMatch = r4
        Lf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.ScreenContentTrigger.setPossibleMagicText(java.lang.String[]):void");
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.textToMatch);
        out.writeInt(this.ignoreCase ? 1 : 0);
        out.writeInt(this.enableRegex ? 1 : 0);
        out.writeInt(this.isOffScreen ? 1 : 0);
        out.writeStringList(this.packageNameList);
        out.writeStringList(this.appNameList);
        out.writeInt(this.matchOption);
        out.writeInt(this.includeOverlays ? 1 : 0);
    }

    public ScreenContentTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ScreenContentTrigger() {
        this.packageNameList = new ArrayList<>();
        this.appNameList = new ArrayList<>();
        this.ignoreCase = true;
        this.workingPackageNameList = new ArrayList<>();
        this.workingAppNameList = new ArrayList<>();
        this.canTrigger = true;
        init();
    }

    private ScreenContentTrigger(Parcel parcel) {
        super(parcel);
        this.packageNameList = new ArrayList<>();
        this.appNameList = new ArrayList<>();
        this.ignoreCase = true;
        this.workingPackageNameList = new ArrayList<>();
        this.workingAppNameList = new ArrayList<>();
        this.canTrigger = true;
        init();
        this.textToMatch = parcel.readString();
        this.ignoreCase = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.isOffScreen = parcel.readInt() != 0;
        this.packageNameList = new ArrayList<>();
        this.appNameList = new ArrayList<>();
        parcel.readStringList(this.packageNameList);
        parcel.readStringList(this.appNameList);
        this.matchOption = parcel.readInt();
        this.includeOverlays = parcel.readInt() != 0;
    }

    /* compiled from: ScreenContentTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTriggerCount() {
            return ScreenContentTrigger.triggerCount;
        }

        public final boolean isEnabled() {
            if (getTriggerCount() > 0) {
                return true;
            }
            return false;
        }

        public final void setTriggerCount(int i4) {
            ScreenContentTrigger.triggerCount = i4;
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
