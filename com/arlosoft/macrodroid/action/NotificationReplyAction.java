package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.NotificationReplyActionInfo;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.NotificationContextInfo;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.notification.model.NotifAction;
import com.arlosoft.macrodroid.triggers.NotificationTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
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
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotificationReplyAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nNotificationReplyAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationReplyAction.kt\ncom/arlosoft/macrodroid/action/NotificationReplyAction\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,495:1\n13309#2,2:496\n1#3:498\n262#4,2:499\n262#4,2:501\n262#4,2:503\n*S KotlinDebug\n*F\n+ 1 NotificationReplyAction.kt\ncom/arlosoft/macrodroid/action/NotificationReplyAction\n*L\n126#1:496,2\n296#1:499,2\n301#1:501,2\n302#1:503,2\n*E\n"})
/* loaded from: classes2.dex */
public final class NotificationReplyAction extends Action implements SupportsMagicText, GetAppListTask.AppListListener {
    @NotNull
    private String applicationName;
    @Nullable
    private transient TextView applicationNameText;
    private boolean enableRegex;
    private boolean ignoreCase;
    private int matchOption;
    @NotNull
    private String matchText;
    @NotNull
    private String packageName;
    @NotNull
    private String replyText;
    private boolean useNotificationTrigger;
    @NotNull
    private transient String workingApplicationName;
    @NotNull
    private transient String workingPackageName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<NotificationReplyAction> CREATOR = new Parcelable.Creator<NotificationReplyAction>() { // from class: com.arlosoft.macrodroid.action.NotificationReplyAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NotificationReplyAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NotificationReplyAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NotificationReplyAction[] newArray(int i4) {
            return new NotificationReplyAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NotificationReplyAction.kt */
    @SourceDebugExtension({"SMAP\nNotificationReplyAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationReplyAction.kt\ncom/arlosoft/macrodroid/action/NotificationReplyAction$displayContentDialog$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,495:1\n262#2,2:496\n*S KotlinDebug\n*F\n+ 1 NotificationReplyAction.kt\ncom/arlosoft/macrodroid/action/NotificationReplyAction$displayContentDialog$2\n*L\n298#1:496,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $defineManuallyLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ViewGroup viewGroup, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$defineManuallyLayout = viewGroup;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$defineManuallyLayout, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
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
                ViewGroup viewGroup = this.$defineManuallyLayout;
                if (!z3) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                viewGroup.setVisibility(i4);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NotificationReplyAction.kt */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NotificationReplyAction.kt */
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Activity activity, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$activity, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NotificationReplyAction notificationReplyAction = NotificationReplyAction.this;
                new GetAppListTask(notificationReplyAction, this.$activity, true, false, ContextCompat.getColor(notificationReplyAction.getContext(), R.color.actions_accent)).execute(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ NotificationReplyAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void W(List<? extends AppInfo> list) {
        List mutableList;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_app_chooser);
        appCompatDialog.setTitle(R.string.select_application);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.button_bar);
        ListView listView = (ListView) appCompatDialog.findViewById(R.id.application_list);
        SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ApplicationAdapter.AppSelectionListener appSelectionListener = new ApplicationAdapter.AppSelectionListener() { // from class: com.arlosoft.macrodroid.action.NotificationReplyAction$displayApplicationChooser$appSelectionListener$1
            @Override // com.arlosoft.macrodroid.applications.ApplicationAdapter.AppSelectionListener
            public void appSelected(@NotNull AppInfo appInfo) {
                Intrinsics.checkNotNullParameter(appInfo, "appInfo");
                TextView applicationNameText = NotificationReplyAction.this.getApplicationNameText();
                if (applicationNameText != null) {
                    applicationNameText.setText(appInfo.applicationName);
                }
                NotificationReplyAction notificationReplyAction = NotificationReplyAction.this;
                String str = appInfo.packageName;
                Intrinsics.checkNotNullExpressionValue(str, "appInfo.packageName");
                notificationReplyAction.workingPackageName = str;
                NotificationReplyAction notificationReplyAction2 = NotificationReplyAction.this;
                String str2 = appInfo.applicationName;
                Intrinsics.checkNotNullExpressionValue(str2, "appInfo.applicationName");
                notificationReplyAction2.workingApplicationName = str2;
                appCompatDialog.dismiss();
            }
        };
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        for (AppInfo appInfo : list) {
            if (Intrinsics.areEqual(appInfo.packageName, this.packageName)) {
                mutableList.add(0, appInfo);
            }
        }
        WindowManager.LayoutParams layoutParams = null;
        final ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, mutableList, null, appSelectionListener);
        Intrinsics.checkNotNull(listView);
        listView.setAdapter((ListAdapter) applicationAdapter);
        Intrinsics.checkNotNull(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.action.NotificationReplyAction$displayApplicationChooser$1
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

    private final void X() {
        WindowManager.LayoutParams layoutParams;
        boolean z3;
        Activity activity;
        int i4;
        final Button button;
        CheckBox checkBox;
        CheckBox checkBox2;
        final RadioButton radioButton;
        RadioButton radioButton2;
        Activity activity2;
        final RadioButton radioButton3;
        final RadioButton radioButton4;
        final RadioButton radioButton5;
        RadioButton radioButton6;
        EditText editText;
        Button button2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Activity activity3 = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity3, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_notification_reply);
        appCompatDialog.setTitle(R.string.action_notification_reply);
        this.workingPackageName = this.packageName;
        this.workingApplicationName = this.applicationName;
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
        Button button3 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        View findViewById = appCompatDialog.findViewById(R.id.use_notification_trigger_radio_button);
        Intrinsics.checkNotNull(findViewById);
        final RadioButton radioButton7 = (RadioButton) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.define_manually_layout);
        Intrinsics.checkNotNull(findViewById2);
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.define_manually_radio_button);
        Intrinsics.checkNotNull(findViewById3);
        RadioButton radioButton8 = (RadioButton) findViewById3;
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.notification_text_dialog_text_content);
        View findViewById4 = appCompatDialog.findViewById(R.id.notification_text_dialog_any_radio_button);
        Intrinsics.checkNotNull(findViewById4);
        final RadioButton radioButton9 = (RadioButton) findViewById4;
        final RadioButton radioButton10 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_matches_radio_button);
        final RadioButton radioButton11 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_contains_radio_button);
        RadioButton radioButton12 = (RadioButton) appCompatDialog.findViewById(R.id.notification_text_dialog_excludes_radio_button);
        View findViewById5 = appCompatDialog.findViewById(R.id.ignore_case);
        Intrinsics.checkNotNull(findViewById5);
        CheckBox checkBox3 = (CheckBox) findViewById5;
        CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        CheckBox checkBox5 = (CheckBox) appCompatDialog.findViewById(R.id.notification_text_dialog_exclude_ongoing);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        View findViewById6 = appCompatDialog.findViewById(R.id.text_to_reply);
        Intrinsics.checkNotNull(findViewById6);
        final EditText editText3 = (EditText) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.text_to_reply_magic_text_button);
        Intrinsics.checkNotNull(findViewById7);
        Button button6 = (Button) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.selectAppButton);
        Intrinsics.checkNotNull(findViewById8);
        ImageButton imageButton = (ImageButton) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.applicationNameText);
        Intrinsics.checkNotNull(findViewById9);
        TextView textView = (TextView) findViewById9;
        this.applicationNameText = textView;
        if (textView == null) {
            activity = activity3;
        } else {
            String str = this.applicationName;
            if (str.length() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                str = SelectableItem.r(R.string.none);
                activity = activity3;
                Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.none)");
            } else {
                activity = activity3;
            }
            textView.setText(str);
        }
        radioButton7.setChecked(this.useNotificationTrigger);
        radioButton8.setChecked(!this.useNotificationTrigger);
        if (!this.useNotificationTrigger) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton7, (CoroutineContext) null, new a(viewGroup, null), 1, (Object) null);
        CheckBox checkBox6 = (CheckBox) appCompatDialog.findViewById(R.id.notification_text_dialog_supress_multiples);
        if (checkBox6 != null) {
            checkBox6.setVisibility(8);
        }
        ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.actions_container);
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
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
        if (radioButton10 != null) {
            radioButton10.setChecked(false);
        }
        if (radioButton11 != null) {
            radioButton11.setChecked(false);
        }
        if (radioButton12 != null) {
            radioButton12.setChecked(false);
        }
        if (radioButton9 != null) {
            radioButton9.setChecked(false);
        }
        final Activity activity4 = activity;
        ViewExtensionsKt.onClick$default(imageButton, null, new c(activity4, null), 1, null);
        editText3.setText(this.replyText);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.qc
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationReplyAction.b0(editText3, magicTextPair);
            }
        };
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationReplyAction.c0(activity4, magicTextListener, this, view);
            }
        });
        int i5 = this.matchOption;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        if (radioButton12 != null) {
                            radioButton12.setChecked(true);
                        }
                        if (editText2 != null) {
                            editText2.setEnabled(true);
                        }
                        if (button3 != null) {
                            Intrinsics.checkNotNull(editText2);
                            button = button3;
                            if (editText2.length() > 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            button.setEnabled(z7);
                        }
                    }
                    button = button3;
                } else {
                    button = button3;
                    if (radioButton11 != null) {
                        radioButton11.setChecked(true);
                    }
                    if (editText2 != null) {
                        editText2.setEnabled(true);
                    }
                    Intrinsics.checkNotNull(button);
                    Intrinsics.checkNotNull(editText2);
                    if (editText2.length() > 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    button.setEnabled(z6);
                }
            } else {
                button = button3;
                if (radioButton10 != null) {
                    radioButton10.setChecked(true);
                }
                if (editText2 != null) {
                    editText2.setEnabled(true);
                }
                if (button != null) {
                    Intrinsics.checkNotNull(editText2);
                    if (editText2.length() > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    button.setEnabled(z5);
                }
            }
        } else {
            button = button3;
            if (radioButton9 != null) {
                radioButton9.setChecked(true);
            }
            if (editText2 != null) {
                editText2.setEnabled(false);
            }
            if (button != null) {
                button.setEnabled(false);
            }
        }
        if (radioButton9 != null) {
            checkBox = checkBox4;
            checkBox2 = checkBox3;
            final Button button7 = button;
            radioButton = radioButton12;
            radioButton2 = radioButton11;
            activity2 = activity4;
            radioButton3 = radioButton10;
            radioButton9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.sc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
                    NotificationReplyAction.d0(editText2, button7, radioButton10, radioButton11, radioButton, compoundButton, z8);
                }
            });
        } else {
            checkBox = checkBox4;
            checkBox2 = checkBox3;
            radioButton = radioButton12;
            radioButton2 = radioButton11;
            activity2 = activity4;
            radioButton3 = radioButton10;
        }
        if (radioButton3 != null) {
            radioButton4 = radioButton;
            radioButton5 = radioButton2;
            radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.tc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
                    NotificationReplyAction.e0(radioButton9, radioButton5, radioButton4, compoundButton, z8);
                }
            });
        } else {
            radioButton4 = radioButton;
            radioButton5 = radioButton2;
        }
        if (radioButton5 != null) {
            radioButton5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.uc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
                    NotificationReplyAction.f0(radioButton3, radioButton9, radioButton4, compoundButton, z8);
                }
            });
        }
        if (radioButton4 != null) {
            radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.vc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
                    NotificationReplyAction.g0(radioButton3, radioButton5, radioButton9, compoundButton, z8);
                }
            });
        }
        if (editText2 != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.NotificationReplyAction$displayContentDialog$10
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s3) {
                    boolean z8;
                    Intrinsics.checkNotNullParameter(s3, "s");
                    Button button8 = button;
                    if (button8 != null) {
                        Editable text = editText2.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "textContent.text");
                        if (text.length() > 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        button8.setEnabled(z8);
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
            final RadioButton radioButton13 = radioButton3;
            radioButton6 = radioButton9;
            final CheckBox checkBox7 = checkBox;
            final CheckBox checkBox8 = checkBox2;
            editText = editText2;
            button2 = button4;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationReplyAction.h0(radioButton7, this, editText3, radioButton9, radioButton13, radioButton5, radioButton4, editText2, checkBox7, checkBox8, appCompatDialog, view);
                }
            });
        } else {
            radioButton6 = radioButton9;
            editText = editText2;
            button2 = button4;
        }
        if (button != null) {
            if (this.matchOption != 0) {
                Intrinsics.checkNotNull(radioButton6);
                if (radioButton6.length() <= 0) {
                    z4 = false;
                    button.setEnabled(z4);
                }
            }
            z4 = true;
            button.setEnabled(z4);
        }
        Button button8 = button2;
        if (button8 != null) {
            button8.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationReplyAction.Y(AppCompatDialog.this, this, view);
                }
            });
        }
        final EditText editText4 = editText;
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.yc
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                NotificationReplyAction.Z(editText4, magicTextPair);
            }
        };
        Intrinsics.checkNotNull(button5);
        final Activity activity5 = activity2;
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationReplyAction.a0(activity5, magicTextListener2, this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(AppCompatDialog dialog, NotificationReplyAction this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.cancel();
        this$0.applicationNameText = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(EditText editText, MagicText.MagicTextPair magicTextPair) {
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
    public static final void a0(Activity activity, MagicText.MagicTextListener magicTextListener, NotificationReplyAction this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(EditText textToReply, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(textToReply, "$textToReply");
        int max = Math.max(textToReply.getSelectionStart(), 0);
        int max2 = Math.max(textToReply.getSelectionEnd(), 0);
        Editable text = textToReply.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Activity activity, MagicText.MagicTextListener replyMagicTextListener, NotificationReplyAction this$0, View view) {
        Intrinsics.checkNotNullParameter(replyMagicTextListener, "$replyMagicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, replyMagicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(EditText editText, Button button, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
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
    public static final void e0(RadioButton anyText, RadioButton radioButton, RadioButton radioButton2, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(anyText, "$anyText");
        if (z3) {
            anyText.setChecked(false);
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(RadioButton radioButton, RadioButton anyText, RadioButton radioButton2, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(anyText, "$anyText");
        if (z3) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            anyText.setChecked(false);
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(RadioButton radioButton, RadioButton radioButton2, RadioButton anyText, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(anyText, "$anyText");
        if (z3) {
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            anyText.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(RadioButton useNotificationTriggerRadioButton, NotificationReplyAction this$0, EditText textToReply, RadioButton anyText, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, EditText editText, CheckBox checkBox, CheckBox ignoreCaseCheckBox, AppCompatDialog dialog, View view) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Editable editable;
        boolean z7;
        Intrinsics.checkNotNullParameter(useNotificationTriggerRadioButton, "$useNotificationTriggerRadioButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(textToReply, "$textToReply");
        Intrinsics.checkNotNullParameter(anyText, "$anyText");
        Intrinsics.checkNotNullParameter(ignoreCaseCheckBox, "$ignoreCaseCheckBox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        boolean z8 = true;
        if (!useNotificationTriggerRadioButton.isChecked()) {
            if (this$0.workingApplicationName.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                ToastCompat.makeText(this$0.getContext(), (CharSequence) SelectableItem.r(R.string.select_application), 0).show();
                return;
            }
        }
        Editable text = textToReply.getText();
        Intrinsics.checkNotNullExpressionValue(text, "textToReply.text");
        if (text.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(this$0.getContext(), (CharSequence) SelectableItem.r(R.string.reply_text_required), 0).show();
            return;
        }
        if (anyText.isChecked()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            this$0.matchOption = 0;
        } else {
            if (radioButton != null && radioButton.isChecked()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                this$0.matchOption = 1;
            } else {
                if (radioButton2 != null && radioButton2.isChecked()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    this$0.matchOption = 2;
                } else {
                    if ((radioButton3 == null || !radioButton3.isChecked()) ? false : false) {
                        this$0.matchOption = 3;
                    }
                }
            }
        }
        this$0.applicationName = this$0.workingApplicationName;
        this$0.packageName = this$0.workingPackageName;
        this$0.useNotificationTrigger = useNotificationTriggerRadioButton.isChecked();
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        this$0.matchText = String.valueOf(editable);
        Intrinsics.checkNotNull(checkBox);
        this$0.enableRegex = checkBox.isChecked();
        this$0.ignoreCase = ignoreCaseCheckBox.isChecked();
        this$0.replyText = textToReply.getText().toString();
        dialog.dismiss();
        this$0.itemComplete();
        this$0.applicationNameText = null;
    }

    private final NotifAction i0(Notification notification) {
        RemoteInput[] remoteInputs;
        int actionCount = NotificationCompat.getActionCount(notification);
        for (int i4 = 0; i4 < actionCount; i4++) {
            NotificationCompat.Action action = NotificationCompat.getAction(notification, i4);
            if (action != null && (remoteInputs = action.getRemoteInputs()) != null) {
                Intrinsics.checkNotNullExpressionValue(remoteInputs, "remoteInputs");
                for (RemoteInput remoteInput : remoteInputs) {
                    String resultKey = remoteInput.getResultKey();
                    Intrinsics.checkNotNullExpressionValue(resultKey, "remoteInput.resultKey");
                    if (j0(resultKey)) {
                        return new NotifAction(action, this.packageName, true);
                    }
                }
                continue;
            }
        }
        return null;
    }

    private final boolean j0(String str) {
        String[] strArr;
        boolean contains$default;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        strArr = NotificationReplyActionKt.f2355a;
        for (String str2 : strArr) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str2, false, 2, (Object) null);
            if (contains$default) {
                return true;
            }
        }
        return false;
    }

    private final boolean k0(NotificationService.NotificationInfo notificationInfo) {
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
            W(appInfoList);
        }
    }

    @Nullable
    public final TextView getApplicationNameText() {
        return this.applicationNameText;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str;
        if (this.useNotificationTrigger) {
            str = SelectableItem.r(R.string.trigger_notification_incoming_notification);
        } else {
            str = this.applicationName;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (useNotificationTrigg…applicationName\n        }");
        String str2 = this.replyText;
        return str + ": " + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return NotificationReplyActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.matchText, this.replyText};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        X();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        Trigger trigger;
        String str;
        StatusBarNotification[] statusBarNotifications = NotificationService.getStatusBarNotifications();
        if (statusBarNotifications == null) {
            return;
        }
        int i4 = 0;
        if (this.useNotificationTrigger) {
            if (triggerContextInfo != null) {
                trigger = triggerContextInfo.getTrigger();
            } else {
                trigger = null;
            }
            if (!(trigger instanceof NotificationTrigger)) {
                SystemLog.logError("NotificationReplyAction failed - trigger that invoked was not NotificationTrigger");
                return;
            }
            int length = statusBarNotifications.length;
            while (i4 < length) {
                StatusBarNotification statusBarNotification = statusBarNotifications[i4];
                String key = statusBarNotification.getKey();
                NotificationContextInfo notificationContextInfoData = triggerContextInfo.getNotificationContextInfoData();
                if (notificationContextInfoData != null) {
                    str = notificationContextInfoData.getKey();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(key, str)) {
                    Notification notification = statusBarNotification.getNotification();
                    Intrinsics.checkNotNullExpressionValue(notification, "sbNotification.notification");
                    NotifAction i02 = i0(notification);
                    if (i02 != null) {
                        String g4 = g(this.replyText, triggerContextInfo);
                        i02.sendReply(getContext(), g4);
                        Long macroGuid = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                        SystemLog.logWarning("Replied with: " + g4, macroGuid.longValue());
                        return;
                    }
                }
                i4++;
            }
            Long macroGuid2 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
            SystemLog.logVerbose("This notification does not support the ability to reply", macroGuid2.longValue());
            return;
        }
        int length2 = statusBarNotifications.length;
        while (i4 < length2) {
            StatusBarNotification statusBarNotification2 = statusBarNotifications[i4];
            NotificationService.NotificationInfo notificationInfo = NotificationService.parseNotification(statusBarNotification2);
            Intrinsics.checkNotNullExpressionValue(notificationInfo, "notificationInfo");
            if (k0(notificationInfo)) {
                Notification notification2 = statusBarNotification2.getNotification();
                Intrinsics.checkNotNullExpressionValue(notification2, "sbNotification.notification");
                NotifAction i03 = i0(notification2);
                if (i03 != null) {
                    String g5 = g(this.replyText, triggerContextInfo);
                    i03.sendReply(getContext(), g5);
                    Long macroGuid3 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
                    SystemLog.logWarning("Replied with: " + g5, macroGuid3.longValue());
                    return;
                }
            }
            i4++;
        }
        Long macroGuid4 = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid4, "macroGuid");
        SystemLog.logVerbose("This notification does not support the ability to reply", macroGuid4.longValue());
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresNotificationAccess() {
        return true;
    }

    public final void setApplicationNameText(@Nullable TextView textView) {
        this.applicationNameText = textView;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 2) {
            this.matchText = magicText[0];
            this.replyText = magicText[1];
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
        out.writeInt(this.enableRegex ? 1 : 0);
        out.writeString(this.replyText);
        out.writeInt(this.useNotificationTrigger ? 1 : 0);
        out.writeInt(this.ignoreCase ? 1 : 0);
    }

    public NotificationReplyAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private NotificationReplyAction() {
        this.packageName = "";
        this.applicationName = "";
        this.matchText = "";
        this.ignoreCase = true;
        this.replyText = "";
        this.useNotificationTrigger = true;
        this.workingPackageName = "";
        this.workingApplicationName = "";
    }

    private NotificationReplyAction(Parcel parcel) {
        super(parcel);
        this.packageName = "";
        this.applicationName = "";
        this.matchText = "";
        this.ignoreCase = true;
        this.replyText = "";
        this.useNotificationTrigger = true;
        this.workingPackageName = "";
        this.workingApplicationName = "";
        String readString = parcel.readString();
        this.packageName = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.applicationName = readString2 == null ? "" : readString2;
        this.matchOption = parcel.readInt();
        String readString3 = parcel.readString();
        this.matchText = readString3 == null ? "" : readString3;
        this.enableRegex = parcel.readInt() != 0;
        String readString4 = parcel.readString();
        this.replyText = readString4 != null ? readString4 : "";
        this.useNotificationTrigger = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* compiled from: NotificationReplyAction.kt */
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
