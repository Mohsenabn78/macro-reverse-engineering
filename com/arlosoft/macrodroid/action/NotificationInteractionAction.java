package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.NotificationInteractionActionInfo;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotificationInteractionAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nNotificationInteractionAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationInteractionAction.kt\ncom/arlosoft/macrodroid/action/NotificationInteractionAction\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,416:1\n262#2,2:417\n262#2,2:419\n*S KotlinDebug\n*F\n+ 1 NotificationInteractionAction.kt\ncom/arlosoft/macrodroid/action/NotificationInteractionAction\n*L\n243#1:417,2\n244#1:419,2\n*E\n"})
/* loaded from: classes2.dex */
public final class NotificationInteractionAction extends Action implements SupportsMagicText, GetAppListTask.AppListListener {
    private int actionsOption;
    @NotNull
    private String applicationName;
    private boolean enableRegex;
    private boolean excludesApps;
    private boolean ignoreCase;
    private int matchOption;
    @NotNull
    private String matchText;
    @NotNull
    private String packageName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<NotificationInteractionAction> CREATOR = new Parcelable.Creator<NotificationInteractionAction>() { // from class: com.arlosoft.macrodroid.action.NotificationInteractionAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NotificationInteractionAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NotificationInteractionAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NotificationInteractionAction[] newArray(int i4) {
            return new NotificationInteractionAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NotificationInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<AppInfo, Unit> {
        final /* synthetic */ AppCompatDialog $dialog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AppCompatDialog appCompatDialog) {
            super(1);
            this.$dialog = appCompatDialog;
        }

        public final void a(@NotNull AppInfo appInfo) {
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            NotificationInteractionAction notificationInteractionAction = NotificationInteractionAction.this;
            String str = appInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "appInfo.packageName");
            notificationInteractionAction.packageName = str;
            NotificationInteractionAction notificationInteractionAction2 = NotificationInteractionAction.this;
            String str2 = appInfo.applicationName;
            Intrinsics.checkNotNullExpressionValue(str2, "appInfo.applicationName");
            notificationInteractionAction2.applicationName = str2;
            NotificationInteractionAction.this.X();
            this.$dialog.dismiss();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppInfo appInfo) {
            a(appInfo);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NotificationInteractionAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ CheckBox $ignoreCaseCheckBox;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CheckBox checkBox, Continuation<? super b> continuation) {
            super(4, continuation);
            this.$ignoreCaseCheckBox = checkBox;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            b bVar = new b(this.$ignoreCaseCheckBox, continuation);
            bVar.Z$0 = z3;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$ignoreCaseCheckBox.setEnabled(!this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ NotificationInteractionAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void V(List<? extends AppInfo> list) {
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
        ApplicationAdapter.AppSelectionListener appSelectionListener = new ApplicationAdapter.AppSelectionListener() { // from class: com.arlosoft.macrodroid.action.hc
            @Override // com.arlosoft.macrodroid.applications.ApplicationAdapter.AppSelectionListener
            public final void appSelected(AppInfo appInfo2) {
                NotificationInteractionAction.W(Function1.this, appInfo2);
            }
        };
        WindowManager.LayoutParams layoutParams = null;
        final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, mutableList, null, appSelectionListener);
        Intrinsics.checkNotNull(listView);
        listView.setAdapter((ListAdapter) applicationAdapter);
        Intrinsics.checkNotNull(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.action.NotificationInteractionAction$displayApplicationChooser$1
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
    public static final void W(Function1 tmp0, AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(appInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        WindowManager.LayoutParams layoutParams;
        List mutableListOf;
        final Button button;
        Spinner spinner;
        CheckBox checkBox;
        RadioButton radioButton;
        Button button2;
        CheckBox checkBox2;
        final RadioButton radioButton2;
        RadioButton radioButton3;
        final EditText editText;
        final AppCompatDialog appCompatDialog;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        final Activity activity = getActivity();
        AppCompatDialog appCompatDialog2 = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog2.setContentView(R.layout.notification_text_dialog);
        appCompatDialog2.setTitle(R.string.action_notification_interaction);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog2.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog2.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        Button button3 = (Button) appCompatDialog2.findViewById(R.id.okButton);
        Button button4 = (Button) appCompatDialog2.findViewById(R.id.cancelButton);
        final EditText editText2 = (EditText) appCompatDialog2.findViewById(R.id.notification_text_dialog_text_content);
        final RadioButton radioButton4 = (RadioButton) appCompatDialog2.findViewById(R.id.notification_text_dialog_any_radio_button);
        final RadioButton radioButton5 = (RadioButton) appCompatDialog2.findViewById(R.id.notification_text_dialog_matches_radio_button);
        final RadioButton radioButton6 = (RadioButton) appCompatDialog2.findViewById(R.id.notification_text_dialog_contains_radio_button);
        final RadioButton radioButton7 = (RadioButton) appCompatDialog2.findViewById(R.id.notification_text_dialog_excludes_radio_button);
        View findViewById = appCompatDialog2.findViewById(R.id.ignore_case);
        Intrinsics.checkNotNull(findViewById);
        CheckBox checkBox3 = (CheckBox) findViewById;
        CheckBox checkBox4 = (CheckBox) appCompatDialog2.findViewById(R.id.enable_regex);
        CheckBox checkBox5 = (CheckBox) appCompatDialog2.findViewById(R.id.notification_text_dialog_exclude_ongoing);
        Button button5 = (Button) appCompatDialog2.findViewById(R.id.magic_text_button);
        CheckBox checkBox6 = (CheckBox) appCompatDialog2.findViewById(R.id.notification_text_dialog_supress_multiples);
        if (checkBox6 != null) {
            checkBox6.setVisibility(8);
        }
        ViewGroup viewGroup = (ViewGroup) appCompatDialog2.findViewById(R.id.actions_container);
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        Spinner spinner2 = (Spinner) appCompatDialog2.findViewById(R.id.notification_actions_spinner);
        String r4 = SelectableItem.r(R.string.action_notification_interaction_action_click_content);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.actio…ion_action_click_content)");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(r4);
        int i4 = 1;
        while (i4 < 6) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String r5 = SelectableItem.r(R.string.action_notification_interaction_action_click_action_number);
            AppCompatDialog appCompatDialog3 = appCompatDialog2;
            Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.actio…tion_click_action_number)");
            String format = String.format(r5, Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            mutableListOf.add(format);
            i4++;
            appCompatDialog2 = appCompatDialog3;
            button3 = button3;
        }
        final AppCompatDialog appCompatDialog4 = appCompatDialog2;
        Button button6 = button3;
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367048, mutableListOf);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        if (spinner2 != null) {
            spinner2.setSelection(this.actionsOption, false);
        }
        if (checkBox5 != null) {
            checkBox5.setVisibility(8);
        }
        if (editText2 != null) {
            editText2.setText(this.matchText);
        }
        checkBox3.setEnabled(!this.enableRegex);
        checkBox3.setChecked(this.ignoreCase);
        if (checkBox4 != null) {
            checkBox4.setChecked(this.enableRegex);
        }
        if (checkBox4 != null) {
            Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox4, (CoroutineContext) null, new b(checkBox3, null), 1, (Object) null);
        }
        if (radioButton5 != null) {
            radioButton5.setChecked(false);
        }
        if (radioButton6 != null) {
            radioButton6.setChecked(false);
        }
        if (radioButton7 != null) {
            radioButton7.setChecked(false);
        }
        if (radioButton4 != null) {
            radioButton4.setChecked(false);
        }
        int i5 = this.matchOption;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        if (radioButton7 != null) {
                            radioButton7.setChecked(true);
                        }
                        if (editText2 != null) {
                            editText2.setEnabled(true);
                        }
                        if (button6 != null) {
                            Intrinsics.checkNotNull(editText2);
                            button = button6;
                            if (editText2.length() > 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            button.setEnabled(z6);
                        }
                    }
                    button = button6;
                } else {
                    button = button6;
                    if (radioButton6 != null) {
                        radioButton6.setChecked(true);
                    }
                    if (editText2 != null) {
                        editText2.setEnabled(true);
                    }
                    Intrinsics.checkNotNull(button);
                    Intrinsics.checkNotNull(editText2);
                    if (editText2.length() > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    button.setEnabled(z5);
                }
            } else {
                button = button6;
                if (radioButton5 != null) {
                    radioButton5.setChecked(true);
                }
                if (editText2 != null) {
                    editText2.setEnabled(true);
                }
                if (button != null) {
                    Intrinsics.checkNotNull(editText2);
                    if (editText2.length() > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    button.setEnabled(z4);
                }
            }
        } else {
            button = button6;
            if (radioButton4 != null) {
                radioButton4.setChecked(true);
            }
            if (editText2 != null) {
                editText2.setEnabled(false);
            }
            if (button != null) {
                button.setEnabled(false);
            }
        }
        if (radioButton4 != null) {
            spinner = spinner2;
            button2 = button5;
            final Button button7 = button;
            checkBox = checkBox4;
            checkBox2 = checkBox3;
            radioButton = radioButton7;
            radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.ic
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                    NotificationInteractionAction.Y(editText2, button7, radioButton5, radioButton6, radioButton7, compoundButton, z7);
                }
            });
        } else {
            spinner = spinner2;
            checkBox = checkBox4;
            radioButton = radioButton7;
            button2 = button5;
            checkBox2 = checkBox3;
        }
        if (radioButton5 != null) {
            radioButton2 = radioButton;
            radioButton5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.jc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                    NotificationInteractionAction.Z(radioButton4, radioButton6, radioButton2, compoundButton, z7);
                }
            });
        } else {
            radioButton2 = radioButton;
        }
        if (radioButton6 != null) {
            radioButton6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.kc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                    NotificationInteractionAction.a0(radioButton5, radioButton4, radioButton2, compoundButton, z7);
                }
            });
        }
        if (radioButton2 != null) {
            radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.lc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                    NotificationInteractionAction.b0(radioButton5, radioButton6, radioButton4, compoundButton, z7);
                }
            });
        }
        if (editText2 != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.NotificationInteractionAction$displayContentDialog$6
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s3) {
                    boolean z7;
                    Intrinsics.checkNotNullParameter(s3, "s");
                    Button button8 = button;
                    if (button8 != null) {
                        Editable text = editText2.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "textContent.text");
                        if (text.length() > 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        button8.setEnabled(z7);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@NotNull CharSequence s3, int i6, int i7, int i8) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@NotNull CharSequence s3, int i6, int i7, int i8) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }
            });
        }
        if (button != null) {
            final Spinner spinner3 = spinner;
            final CheckBox checkBox7 = checkBox;
            radioButton3 = radioButton4;
            final CheckBox checkBox8 = checkBox2;
            editText = editText2;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationInteractionAction.c0(radioButton4, this, radioButton5, radioButton6, radioButton2, spinner3, editText2, checkBox7, checkBox8, appCompatDialog4, view);
                }
            });
        } else {
            radioButton3 = radioButton4;
            editText = editText2;
        }
        if (button != null) {
            if (this.matchOption != 0) {
                Intrinsics.checkNotNull(radioButton3);
                if (radioButton3.length() <= 0) {
                    z3 = false;
                    button.setEnabled(z3);
                }
            }
            z3 = true;
            button.setEnabled(z3);
        }
        if (button4 != null) {
            appCompatDialog = appCompatDialog4;
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.nc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationInteractionAction.d0(AppCompatDialog.this, view);
                }
            });
        } else {
            appCompatDialog = appCompatDialog4;
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.oc
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationInteractionAction.e0(editText, magicTextPair);
            }
        };
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationInteractionAction.f0(activity, magicTextListener, this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText editText, Button button, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (editText != null) {
            editText.setEnabled(!z3);
        }
        boolean z4 = true;
        if (!z3) {
            if (button != null) {
                Intrinsics.checkNotNull(editText);
                Editable text = editText.getText();
                Intrinsics.checkNotNull(text);
                if (text.length() <= 0) {
                    z4 = false;
                }
                button.setEnabled(z4);
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(button);
        button.setEnabled(true);
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
        }
        if (radioButton3 != null) {
            radioButton3.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            if (radioButton3 != null) {
                radioButton3.setChecked(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            if (radioButton3 != null) {
                radioButton3.setChecked(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            if (radioButton3 != null) {
                radioButton3.setChecked(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(RadioButton radioButton, NotificationInteractionAction this$0, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, Spinner spinner, EditText editText, CheckBox checkBox, CheckBox ignoreCaseCheckBox, AppCompatDialog dialog, View view) {
        boolean z3;
        boolean z4;
        boolean z5;
        Editable editable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ignoreCaseCheckBox, "$ignoreCaseCheckBox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        boolean z6 = true;
        int i4 = 0;
        if (radioButton != null && radioButton.isChecked()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            this$0.matchOption = 0;
        } else {
            if (radioButton2 != null && radioButton2.isChecked()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                this$0.matchOption = 1;
            } else {
                if (radioButton3 != null && radioButton3.isChecked()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    this$0.matchOption = 2;
                } else {
                    if ((radioButton4 == null || !radioButton4.isChecked()) ? false : false) {
                        this$0.matchOption = 3;
                    }
                }
            }
        }
        if (spinner != null) {
            i4 = spinner.getSelectedItemPosition();
        }
        this$0.actionsOption = i4;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        this$0.matchText = String.valueOf(editable);
        Intrinsics.checkNotNull(checkBox);
        this$0.enableRegex = checkBox.isChecked();
        this$0.ignoreCase = ignoreCaseCheckBox.isChecked();
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNull(editText);
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Activity activity, MagicText.MagicTextListener magicTextListener, NotificationInteractionAction this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    private final boolean g0(NotificationService.NotificationInfo notificationInfo) {
        if (!Intrinsics.areEqual(notificationInfo.packageName, this.packageName)) {
            return false;
        }
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.matchText, null, getMacro());
        String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, this.enableRegex, this.ignoreCase);
        String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, this.enableRegex, this.ignoreCase);
        int i4 = this.matchOption;
        if (i4 == 0) {
            return true;
        }
        if (i4 == 1) {
            if (WildCardHelper.matches(notificationInfo.title, regexPattern, this.enableRegex, this.ignoreCase) || WildCardHelper.matches(notificationInfo.text, regexPattern, this.enableRegex, this.ignoreCase)) {
                return true;
            }
        } else if (i4 == 2) {
            if (WildCardHelper.matches(notificationInfo.title, regexContainsPattern, this.enableRegex, this.ignoreCase) || WildCardHelper.matches(notificationInfo.text, regexContainsPattern, this.enableRegex, this.ignoreCase)) {
                return true;
            }
        } else if (i4 == 3 && !WildCardHelper.matches(notificationInfo.title, regexContainsPattern, this.enableRegex, this.ignoreCase) && !WildCardHelper.matches(notificationInfo.text, regexContainsPattern, this.enableRegex, this.ignoreCase)) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(@NotNull List<? extends AppInfo> appInfoList, boolean z3) {
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        if (checkActivityAlive() && z3) {
            V(appInfoList);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String format;
        if (this.actionsOption == 0) {
            format = SelectableItem.r(R.string.action_notification_interaction_action_click_content);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String r4 = SelectableItem.r(R.string.action_notification_interaction_action_click_action_number);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.actio…tion_click_action_number)");
            format = String.format(r4, Arrays.copyOf(new Object[]{Integer.valueOf(this.actionsOption)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        Intrinsics.checkNotNullExpressionValue(format, "if (actionsOption == 0) … actionsOption)\n        }");
        int i4 = this.matchOption;
        if (i4 == 0) {
            String r5 = SelectableItem.r(R.string.trigger_notification_any_content);
            String str = this.applicationName;
            return r5 + " (" + str + ") - " + format;
        } else if (i4 == 3) {
            String r6 = SelectableItem.r(R.string.trigger_notification_excludes);
            String str2 = this.matchText;
            String str3 = this.applicationName;
            return r6 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2 + " (" + str3 + ") - " + format;
        } else if (i4 == 1) {
            String r7 = SelectableItem.r(R.string.trigger_notification_matches);
            String str4 = this.matchText;
            String str5 = this.applicationName;
            return r7 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str4 + " (" + str5 + ") - " + format;
        } else {
            String r8 = SelectableItem.r(R.string.trigger_notification_contains);
            String str6 = this.matchText;
            String str7 = this.applicationName;
            return r8 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str6 + " (" + str7 + ") - " + format;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return NotificationInteractionActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.matchText};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        new GetAppListTask(this, getActivity(), true, false, ContextCompat.getColor(getContext(), R.color.actions_accent)).execute(null);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean z3;
        StatusBarNotification[] statusBarNotifications = NotificationService.getStatusBarNotifications();
        if (statusBarNotifications == null) {
            return;
        }
        for (StatusBarNotification statusBarNotification : statusBarNotifications) {
            NotificationService.NotificationInfo notificationInfo = NotificationService.parseNotification(statusBarNotification);
            Notification.Action[] actionArr = statusBarNotification.getNotification().actions;
            boolean z4 = true;
            if (actionArr != null) {
                if (actionArr.length == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    z4 = false;
                }
            }
            if (!z4 || statusBarNotification.getNotification().contentIntent != null) {
                Intrinsics.checkNotNullExpressionValue(notificationInfo, "notificationInfo");
                if (g0(notificationInfo)) {
                    if (this.actionsOption == 0) {
                        try {
                            PendingIntent pendingIntent = statusBarNotification.getNotification().contentIntent;
                            if (pendingIntent != null) {
                                pendingIntent.send();
                            }
                        } catch (PendingIntent.CanceledException e4) {
                            Long macroGuid = getMacroGuid();
                            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                            SystemLog.logError("Unable to invoke notification, perhaps it's already been invoked once and cannot be again?: " + e4, macroGuid.longValue());
                        }
                    } else {
                        Notification.Action[] actionArr2 = statusBarNotification.getNotification().actions;
                        int i4 = this.actionsOption;
                        int i5 = i4 - 1;
                        if (actionArr2 != null) {
                            if (actionArr2.length < i5) {
                                String str = "Cannot invoke action " + i4 + " Notification has " + actionArr2.length + " actions";
                                Long macroGuid2 = getMacroGuid();
                                Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                                SystemLog.logAction(str, macroGuid2.longValue());
                            } else {
                                try {
                                    PendingIntent pendingIntent2 = actionArr2[i5].actionIntent;
                                    if (pendingIntent2 != null) {
                                        pendingIntent2.send();
                                    }
                                } catch (Exception e5) {
                                    String str2 = "Cannot invoke action " + this.actionsOption + ": " + e5;
                                    Long macroGuid3 = getMacroGuid();
                                    Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
                                    SystemLog.logAction(str2, macroGuid3.longValue());
                                }
                            }
                        } else {
                            String str3 = "Cannot invoke action " + i4 + " Notification has no actions";
                            Long macroGuid4 = getMacroGuid();
                            Intrinsics.checkNotNullExpressionValue(macroGuid4, "macroGuid");
                            SystemLog.logAction(str3, macroGuid4.longValue());
                        }
                    }
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresNotificationAccess() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.matchText = magicText[0];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.packageName);
        out.writeString(this.applicationName);
        out.writeInt(this.matchOption);
        out.writeString(this.matchText);
        out.writeInt(this.excludesApps ? 1 : 0);
        out.writeInt(this.enableRegex ? 1 : 0);
        out.writeInt(this.actionsOption);
        out.writeInt(this.ignoreCase ? 1 : 0);
    }

    public NotificationInteractionAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private NotificationInteractionAction() {
        this.packageName = "";
        this.applicationName = "";
        this.matchText = "";
        this.ignoreCase = true;
    }

    private NotificationInteractionAction(Parcel parcel) {
        super(parcel);
        this.packageName = "";
        this.applicationName = "";
        this.matchText = "";
        this.ignoreCase = true;
        String readString = parcel.readString();
        this.packageName = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.applicationName = readString2 == null ? "" : readString2;
        this.matchOption = parcel.readInt();
        String readString3 = parcel.readString();
        this.matchText = readString3 != null ? readString3 : "";
        this.excludesApps = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.actionsOption = parcel.readInt();
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* compiled from: NotificationInteractionAction.kt */
    /* loaded from: classes2.dex */
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
