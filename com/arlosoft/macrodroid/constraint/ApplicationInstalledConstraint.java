package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.ApplicationInstalledConstraintInfo;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApplicationInstalledConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nApplicationInstalledConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApplicationInstalledConstraint.kt\ncom/arlosoft/macrodroid/constraint/ApplicationInstalledConstraint\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,214:1\n65#2,16:215\n93#2,3:231\n*S KotlinDebug\n*F\n+ 1 ApplicationInstalledConstraint.kt\ncom/arlosoft/macrodroid/constraint/ApplicationInstalledConstraint\n*L\n138#1:215,16\n138#1:231,3\n*E\n"})
/* loaded from: classes3.dex */
public final class ApplicationInstalledConstraint extends Constraint implements SupportsMagicText, GetAppListTask.AppListListener {
    @NotNull
    private String packageName;
    @Nullable
    private transient WeakReference<EditText> textBoxRef;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ApplicationInstalledConstraint> CREATOR = new Parcelable.Creator<ApplicationInstalledConstraint>() { // from class: com.arlosoft.macrodroid.constraint.ApplicationInstalledConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ApplicationInstalledConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ApplicationInstalledConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ApplicationInstalledConstraint[] newArray(int i4) {
            return new ApplicationInstalledConstraint[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApplicationInstalledConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<AppInfo, Unit> {
        final /* synthetic */ AppCompatDialog $dialog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AppCompatDialog appCompatDialog) {
            super(1);
            this.$dialog = appCompatDialog;
        }

        public final void a(@NotNull AppInfo appInfo) {
            EditText editText;
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            ApplicationInstalledConstraint applicationInstalledConstraint = ApplicationInstalledConstraint.this;
            String str = appInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "appInfo.packageName");
            applicationInstalledConstraint.packageName = str;
            WeakReference weakReference = ApplicationInstalledConstraint.this.textBoxRef;
            if (weakReference != null && (editText = (EditText) weakReference.get()) != null) {
                editText.setText(ApplicationInstalledConstraint.this.packageName);
            }
            this.$dialog.dismiss();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppInfo appInfo) {
            a(appInfo);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ApplicationInstalledConstraint.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$activity, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ApplicationInstalledConstraint applicationInstalledConstraint = ApplicationInstalledConstraint.this;
                new GetAppListTask(applicationInstalledConstraint, this.$activity, true, false, ContextCompat.getColor(applicationInstalledConstraint.getContext(), R.color.actions_accent)).execute(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ ApplicationInstalledConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void T(List<? extends AppInfo> list) {
        List mutableList;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_app_chooser);
        appCompatDialog.setTitle(R.string.select_application);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.button_bar);
        ListView listView = (ListView) appCompatDialog.findViewById(R.id.application_list);
        SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        final a aVar = new a(appCompatDialog);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        for (AppInfo appInfo : list) {
            if (Intrinsics.areEqual(appInfo.packageName, this.packageName)) {
                mutableList.add(0, appInfo);
            }
        }
        ApplicationAdapter.AppSelectionListener appSelectionListener = new ApplicationAdapter.AppSelectionListener() { // from class: com.arlosoft.macrodroid.constraint.l
            @Override // com.arlosoft.macrodroid.applications.ApplicationAdapter.AppSelectionListener
            public final void appSelected(AppInfo appInfo2) {
                ApplicationInstalledConstraint.U(Function1.this, appInfo2);
            }
        };
        WindowManager.LayoutParams layoutParams = null;
        final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, mutableList, null, appSelectionListener);
        Intrinsics.checkNotNull(listView);
        listView.setAdapter((ListAdapter) applicationAdapter);
        Intrinsics.checkNotNull(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.constraint.ApplicationInstalledConstraint$displayApplicationChooser$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@NotNull String newText) {
                Intrinsics.checkNotNullParameter(newText, "newText");
                ApplicationAdapter.this.getFilter().filter((CharSequence) newText, true);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@NotNull String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return false;
            }
        });
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        appCompatDialog.show();
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(appInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ApplicationInstalledConstraint this$0, EditText editText, AppCompatDialog dialog, View view) {
        Editable editable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        this$0.packageName = String.valueOf(editable);
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Activity activity, MagicText.MagicTextListener magicTextListener, ApplicationInstalledConstraint this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(@NotNull List<? extends AppInfo> appInfoList, boolean z3) {
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        if (checkActivityAlive() && z3) {
            T(appInfoList);
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        return ApplicationChecker.isAppInstalled(MagicText.replaceMagicText(getContext(), this.packageName, triggerContextInfo, getMacro()));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.packageName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ApplicationInstalledConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String truncateIfRequired = MDTextUtils.truncateIfRequired(getExtendedDetail(), 20);
        return configuredName + " (" + truncateIfRequired + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.packageName};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getSystemLogEntryName(@Nullable TriggerContextInfo triggerContextInfo) {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        WindowManager.LayoutParams layoutParams;
        boolean z3;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_select_app_package);
        appCompatDialog.setTitle(R.string.constraint_application_installed);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.packageName);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.packageNameMagicTextButton);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.selectAppButton);
        if (editText != null) {
            editText.setText(this.packageName);
        }
        if (editText != null) {
            editText.setSelection(editText.length());
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplicationInstalledConstraint.V(ApplicationInstalledConstraint.this, editText, appCompatDialog, view);
                }
            });
        }
        if (button != null) {
            if (this.packageName.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }
        this.textBoxRef = new WeakReference<>(editText);
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplicationInstalledConstraint.W(AppCompatDialog.this, view);
                }
            });
        }
        if (button4 != null) {
            ViewExtensionsKt.onClick$default(button4, null, new b(activity, null), 1, null);
        }
        if (editText != null) {
            final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.o
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    ApplicationInstalledConstraint.X(editText, magicTextPair);
                }
            };
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ApplicationInstalledConstraint.Y(activity, magicTextListener, this, view);
                    }
                });
            }
            editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.constraint.ApplicationInstalledConstraint$handleItemSelected$lambda$5$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable editable) {
                    Button button5 = button;
                    if (button5 != null) {
                        boolean z4 = false;
                        if (editable != null && editable.length() > 0) {
                            z4 = true;
                        }
                        button5.setEnabled(z4);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
                }
            });
        }
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.packageName = magicText[0];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.packageName);
    }

    public ApplicationInstalledConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ApplicationInstalledConstraint() {
        this.packageName = "";
    }

    private ApplicationInstalledConstraint(Parcel parcel) {
        super(parcel);
        this.packageName = "";
        String readString = parcel.readString();
        this.packageName = readString != null ? readString : "";
    }

    /* compiled from: ApplicationInstalledConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
