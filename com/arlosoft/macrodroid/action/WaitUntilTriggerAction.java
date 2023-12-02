package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.WaitUntilTriggerActionInfo;
import com.arlosoft.macrodroid.action.receivers.WaitUntilTriggerTimeoutReceiver;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.selectableitemlist.AddTriggerActivity;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.Sdk27ServicesKt;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: WaitUntilTriggerAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nWaitUntilTriggerAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WaitUntilTriggerAction.kt\ncom/arlosoft/macrodroid/action/WaitUntilTriggerAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,466:1\n1#2:467\n262#3,2:468\n262#3,2:470\n*S KotlinDebug\n*F\n+ 1 WaitUntilTriggerAction.kt\ncom/arlosoft/macrodroid/action/WaitUntilTriggerAction\n*L\n256#1:468,2\n261#1:470,2\n*E\n"})
/* loaded from: classes2.dex */
public final class WaitUntilTriggerAction extends Action implements BlockingAction {
    private static final int REQUEST_CODE_ADD_TRIGGER = 4291;
    private static final int REQUEST_CODE_TIMEOUT = 6629;
    private boolean continueOnTimeout;
    @Nullable
    private transient ArrayList<Trigger> originalTriggerList;
    @Nullable
    private transient ResumeMacroInfo resumeMacroInfo;
    @Nullable
    private transient Trigger selectedTrigger;
    @NotNull
    private transient Stack<Integer> skipEndIfIndexStack;
    private boolean timeoutEnabled;
    @Nullable
    private transient PendingIntent timeoutPendingIntent;
    private int timeoutSeconds;
    @Nullable
    private transient AppCompatDialog triggerConfigDialog;
    private ArrayList<Trigger> triggersToWaitFor;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<WaitUntilTriggerAction> CREATOR = new Parcelable.Creator<WaitUntilTriggerAction>() { // from class: com.arlosoft.macrodroid.action.WaitUntilTriggerAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WaitUntilTriggerAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WaitUntilTriggerAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WaitUntilTriggerAction[] newArray(int i4) {
            return new WaitUntilTriggerAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WaitUntilTriggerAction.kt */
    @SourceDebugExtension({"SMAP\nWaitUntilTriggerAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WaitUntilTriggerAction.kt\ncom/arlosoft/macrodroid/action/WaitUntilTriggerAction$displayTriggerDialog$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,466:1\n262#2,2:467\n*S KotlinDebug\n*F\n+ 1 WaitUntilTriggerAction.kt\ncom/arlosoft/macrodroid/action/WaitUntilTriggerAction$displayTriggerDialog$2\n*L\n265#1:467,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $timePickerLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ViewGroup viewGroup, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$timePickerLayout = viewGroup;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$timePickerLayout, continuation);
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
                ViewGroup viewGroup = this.$timePickerLayout;
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

    public /* synthetic */ WaitUntilTriggerAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.LinearLayout, android.view.ViewGroup] */
    private final void S() {
        boolean z3;
        if (this.triggerConfigDialog != null && checkActivityAlive()) {
            AppCompatDialog appCompatDialog = this.triggerConfigDialog;
            Intrinsics.checkNotNull(appCompatDialog);
            View findViewById = appCompatDialog.findViewById(R.id.okButton);
            Intrinsics.checkNotNull(findViewById);
            Button button = (Button) findViewById;
            View findViewById2 = appCompatDialog.findViewById(R.id.triggers_layout);
            Intrinsics.checkNotNull(findViewById2);
            ?? r12 = (LinearLayout) findViewById2;
            r12.removeAllViews();
            ArrayList<Trigger> arrayList = this.triggersToWaitFor;
            ViewGroup viewGroup = null;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                arrayList = null;
            }
            int i4 = 1;
            if (arrayList.size() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
            Activity activity = getActivity();
            ArrayList<Trigger> arrayList2 = this.triggersToWaitFor;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                arrayList2 = null;
            }
            int size = arrayList2.size();
            int i5 = R.id.macro_edit_entry_icon;
            int i6 = R.id.macro_edit_entry_detail;
            int i7 = R.id.macro_edit_entry_name;
            int i8 = R.layout.macro_edit_entry;
            if (size == 0) {
                View inflate = activity.getLayoutInflater().inflate(R.layout.macro_edit_entry, (ViewGroup) null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
                MaterialCardView materialCardView = (MaterialCardView) inflate;
                materialCardView.setCardBackgroundColor(activity.getResources().getColor(R.color.trigger_primary));
                TextView textView = (TextView) materialCardView.findViewById(R.id.macro_edit_entry_name);
                textView.setText("[" + SelectableItem.r(R.string.no_triggers) + "]");
                textView.setGravity(17);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.no_constraints_padding);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                ((ImageView) materialCardView.findViewById(R.id.macro_edit_entry_icon)).setVisibility(8);
                ((TextView) materialCardView.findViewById(R.id.macro_edit_entry_detail)).setVisibility(8);
                r12.addView(materialCardView);
                return;
            }
            ArrayList<Trigger> arrayList3 = this.triggersToWaitFor;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                arrayList3 = null;
            }
            int size2 = arrayList3.size();
            final int i9 = 0;
            while (i9 < size2) {
                View inflate2 = activity.getLayoutInflater().inflate(i8, viewGroup);
                Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
                MaterialCardView materialCardView2 = (MaterialCardView) inflate2;
                materialCardView2.setCardBackgroundColor(activity.getResources().getColor(R.color.trigger_primary));
                TextView textView2 = (TextView) materialCardView2.findViewById(i7);
                TextView textView3 = (TextView) materialCardView2.findViewById(i6);
                ImageView imageView = (ImageView) materialCardView2.findViewById(i5);
                if (i9 >= i4) {
                    materialCardView2.addView(activity.getLayoutInflater().inflate(R.layout.divider, viewGroup));
                }
                ImageView imageView2 = (ImageView) materialCardView2.findViewById(R.id.macro_edit_warning_icon);
                ArrayList<Trigger> arrayList4 = this.triggersToWaitFor;
                ArrayList<Trigger> arrayList5 = arrayList4;
                if (arrayList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                    arrayList5 = viewGroup;
                }
                materialCardView2.setTag(arrayList5.get(i9));
                imageView.setBackgroundResource(R.drawable.circular_icon_background_trigger_dark);
                Resources resources = activity.getResources();
                ArrayList<Trigger> arrayList6 = this.triggersToWaitFor;
                if (arrayList6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                    arrayList6 = null;
                }
                imageView.setImageDrawable(resources.getDrawable(arrayList6.get(i9).getIcon()));
                imageView.setVisibility(0);
                ArrayList<Trigger> arrayList7 = this.triggersToWaitFor;
                if (arrayList7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                    arrayList7 = null;
                }
                textView2.setText(arrayList7.get(i9).getEditMacroConfiguredName());
                textView2.setGravity(8388627);
                ArrayList<Trigger> arrayList8 = this.triggersToWaitFor;
                if (arrayList8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                    arrayList8 = null;
                }
                Trigger trigger = arrayList8.get(i9);
                Intrinsics.checkNotNullExpressionValue(trigger, "triggersToWaitFor[i]");
                Trigger trigger2 = trigger;
                materialCardView2.setTag(trigger2);
                if (trigger2.isValid()) {
                    imageView2.setVisibility(8);
                } else {
                    imageView2.setVisibility(0);
                }
                if (trigger2.getExtendedDetail() != null && trigger2.getExtendedDetail().length() > 0) {
                    textView3.setVisibility(0);
                    ArrayList<Trigger> arrayList9 = this.triggersToWaitFor;
                    if (arrayList9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                        arrayList9 = null;
                    }
                    textView3.setText(arrayList9.get(i9).getExtendedDetail());
                } else {
                    textView3.setVisibility(8);
                }
                materialCardView2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.eu
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WaitUntilTriggerAction.T(WaitUntilTriggerAction.this, i9, view);
                    }
                });
                r12.addView(materialCardView2);
                i9++;
                viewGroup = null;
                i4 = 1;
                i5 = R.id.macro_edit_entry_icon;
                i6 = R.id.macro_edit_entry_detail;
                i7 = R.id.macro_edit_entry_name;
                i8 = R.layout.macro_edit_entry;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(WaitUntilTriggerAction this$0, int i4, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<Trigger> arrayList = this$0.triggersToWaitFor;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
            arrayList = null;
        }
        Trigger trigger = arrayList.get(i4);
        Intrinsics.checkNotNullExpressionValue(trigger, "triggersToWaitFor[i]");
        this$0.a0(trigger);
    }

    private final void U(boolean z3) {
        boolean z4;
        WindowManager.LayoutParams layoutParams;
        int i4;
        final Activity activity = getActivity();
        if (z3 && this.originalTriggerList == null) {
            ArrayList<Trigger> arrayList = new ArrayList<>();
            ArrayList<Trigger> arrayList2 = this.triggersToWaitFor;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                arrayList2 = null;
            }
            arrayList.addAll(arrayList2);
            this.originalTriggerList = arrayList;
        }
        if (!checkActivityAlive()) {
            return;
        }
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(this);
        }
        AppCompatDialog appCompatDialog = this.triggerConfigDialog;
        if (appCompatDialog != null && appCompatDialog.isShowing()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            try {
                AppCompatDialog appCompatDialog2 = this.triggerConfigDialog;
                if (appCompatDialog2 != null) {
                    appCompatDialog2.dismiss();
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        AppCompatDialog appCompatDialog3 = new AppCompatDialog(activity, getDialogTheme());
        this.triggerConfigDialog = appCompatDialog3;
        Intrinsics.checkNotNull(appCompatDialog3);
        appCompatDialog3.setContentView(R.layout.dialog_wait_until_trigger_configure);
        appCompatDialog3.setTitle(getName());
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog3.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog3.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        View findViewById = appCompatDialog3.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog3.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog3.findViewById(R.id.add_trigger_button);
        Intrinsics.checkNotNull(findViewById3);
        ImageButton imageButton = (ImageButton) findViewById3;
        ArrayList arrayList3 = new ArrayList();
        View findViewById4 = appCompatDialog3.findViewById(R.id.radio_no_timeout);
        Intrinsics.checkNotNull(findViewById4);
        final RadioButton radioButton = (RadioButton) findViewById4;
        View findViewById5 = appCompatDialog3.findViewById(R.id.radio_cancel_timeout);
        Intrinsics.checkNotNull(findViewById5);
        RadioButton radioButton2 = (RadioButton) findViewById5;
        View findViewById6 = appCompatDialog3.findViewById(R.id.radio_continue_timeout);
        Intrinsics.checkNotNull(findViewById6);
        final RadioButton radioButton3 = (RadioButton) findViewById6;
        View findViewById7 = appCompatDialog3.findViewById(R.id.timepicker_layout);
        Intrinsics.checkNotNull(findViewById7);
        ViewGroup viewGroup = (ViewGroup) findViewById7;
        View findViewById8 = appCompatDialog3.findViewById(R.id.hour_picker);
        Intrinsics.checkNotNull(findViewById8);
        final NumberPicker numberPicker = (NumberPicker) findViewById8;
        View findViewById9 = appCompatDialog3.findViewById(R.id.minute_picker);
        Intrinsics.checkNotNull(findViewById9);
        final NumberPicker numberPicker2 = (NumberPicker) findViewById9;
        View findViewById10 = appCompatDialog3.findViewById(R.id.second_picker);
        Intrinsics.checkNotNull(findViewById10);
        final NumberPicker numberPicker3 = (NumberPicker) findViewById10;
        numberPicker3.setValue(this.timeoutSeconds % 60);
        numberPicker3.setMinimum(0);
        numberPicker3.setMaximum(59);
        numberPicker2.setValue((this.timeoutSeconds / 60) % 60);
        numberPicker2.setMinimum(0);
        numberPicker2.setMaximum(59);
        numberPicker.setValue(this.timeoutSeconds / 3600);
        numberPicker.setMinimum(0);
        numberPicker.setMaximum(999);
        String r4 = SelectableItem.r(R.string.and);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.and)");
        arrayList3.add(r4);
        String r5 = SelectableItem.r(R.string.or);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.or)");
        arrayList3.add(r5);
        new ArrayAdapter(getActivity(), (int) R.layout.simple_spinner_item_white_text, arrayList3).setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        S();
        if (this.timeoutEnabled) {
            radioButton.setChecked(false);
            i4 = 1;
            radioButton2.setChecked(!this.continueOnTimeout);
            radioButton3.setChecked(this.continueOnTimeout);
            viewGroup.setVisibility(0);
        } else {
            i4 = 1;
            radioButton.setChecked(true);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
            viewGroup.setVisibility(8);
        }
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton, (CoroutineContext) null, new a(viewGroup, null), i4, (Object) null);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WaitUntilTriggerAction.V(radioButton, numberPicker3, numberPicker2, numberPicker, this, radioButton3, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WaitUntilTriggerAction.W(WaitUntilTriggerAction.this, view);
            }
        });
        appCompatDialog3.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.cu
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                WaitUntilTriggerAction.X(WaitUntilTriggerAction.this, dialogInterface);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.du
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WaitUntilTriggerAction.Y(WaitUntilTriggerAction.this, activity, view);
            }
        });
        appCompatDialog3.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(RadioButton noTimeoutRadioButton, NumberPicker secondPicker, NumberPicker minutePicker, NumberPicker hourPicker, WaitUntilTriggerAction this$0, RadioButton continueTimeoutRadioButton, View view) {
        Intrinsics.checkNotNullParameter(noTimeoutRadioButton, "$noTimeoutRadioButton");
        Intrinsics.checkNotNullParameter(secondPicker, "$secondPicker");
        Intrinsics.checkNotNullParameter(minutePicker, "$minutePicker");
        Intrinsics.checkNotNullParameter(hourPicker, "$hourPicker");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(continueTimeoutRadioButton, "$continueTimeoutRadioButton");
        if (!noTimeoutRadioButton.isChecked() && secondPicker.getValue() == 0 && minutePicker.getValue() == 0 && hourPicker.getValue() == 0) {
            ToastCompat.makeText(this$0.getContext(), (CharSequence) SelectableItem.r(R.string.invalid_value), 0).show();
            return;
        }
        AppCompatDialog appCompatDialog = this$0.triggerConfigDialog;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
        this$0.originalTriggerList = null;
        this$0.triggerConfigDialog = null;
        this$0.timeoutSeconds = secondPicker.getValue() + (minutePicker.getValue() * 60) + (hourPicker.getValue() * 3600);
        this$0.timeoutEnabled = !noTimeoutRadioButton.isChecked();
        this$0.continueOnTimeout = continueTimeoutRadioButton.isChecked();
        this$0.itemComplete();
        Macro macro = this$0.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(WaitUntilTriggerAction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<Trigger> arrayList = this$0.originalTriggerList;
        if (arrayList != null) {
            this$0.triggersToWaitFor = arrayList;
        }
        this$0.originalTriggerList = null;
        AppCompatDialog appCompatDialog = this$0.triggerConfigDialog;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
        this$0.triggerConfigDialog = null;
        Macro macro = this$0.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(WaitUntilTriggerAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<Trigger> arrayList = this$0.originalTriggerList;
        if (arrayList != null) {
            this$0.triggersToWaitFor = arrayList;
        }
        this$0.originalTriggerList = null;
        Macro macro = this$0.m_macro;
        if (macro != null) {
            macro.setActionBeingConfigured(null);
        }
        this$0.triggerConfigDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(WaitUntilTriggerAction this$0, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppCompatDialog appCompatDialog = this$0.triggerConfigDialog;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
        this$0.triggerConfigDialog = null;
        if (activity != null) {
            MacroStore macroStore = MacroStore.getInstance();
            Long macroGuid = this$0.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            if (macroStore.getMacroByGUID(macroGuid.longValue()) == null) {
                this$0.m_macro.setCompleted(false);
                MacroStore.getInstance().addMacro(this$0.m_macro, false);
            }
            Intent intent = new Intent(activity, AddTriggerActivity.class);
            intent.putExtra("MacroId", this$0.m_macro.getId());
            intent.putExtra(Constants.EXTRA_PARENT_GUID, this$0.getSIGUID());
            activity.startActivityForResult(intent, REQUEST_CODE_ADD_TRIGGER);
        }
    }

    private final void Z() {
        ArrayList<Trigger> arrayList = this.triggersToWaitFor;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
            arrayList = null;
        }
        Iterator<Trigger> it = arrayList.iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.setMacro(this.m_macro);
            next.enableTriggerThreadSafe();
        }
    }

    private final void a0(final Trigger trigger) {
        if (!checkActivityAlive()) {
            return;
        }
        this.selectedTrigger = null;
        final String[] strArr = {SelectableItem.r(R.string.configure), SelectableItem.r(R.string.delete), SelectableItem.r(R.string.help)};
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(trigger.getEditMacroConfiguredName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fu
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                WaitUntilTriggerAction.b0(strArr, trigger, this, activity, dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(String[] options, Trigger trigger, WaitUntilTriggerAction this$0, Activity activity, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(trigger, "$trigger");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = options[i4];
        Intrinsics.checkNotNullExpressionValue(str, "options[index]");
        if (Intrinsics.areEqual(str, SelectableItem.r(R.string.configure))) {
            trigger.setMacro(this$0.m_macro);
            trigger.setActivity(activity);
            trigger.onItemSelected();
            this$0.selectedTrigger = trigger;
            return;
        }
        ArrayList<Trigger> arrayList = null;
        if (Intrinsics.areEqual(str, SelectableItem.r(R.string.help))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(trigger.getName());
            if (trigger.getInfo().supportsAdbHack()) {
                builder.setMessage(Util.appendAdbHackInfo(this$0.getContext(), this$0.getContext().getString(trigger.getInfo().getHelpInfo())));
            } else {
                builder.setMessage(trigger.getHelpInfo());
            }
            builder.setNegativeButton(17039370, (DialogInterface.OnClickListener) null);
            builder.show();
        } else if (Intrinsics.areEqual(str, SelectableItem.r(R.string.delete))) {
            ArrayList<Trigger> arrayList2 = this$0.triggersToWaitFor;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                arrayList2 = null;
            }
            if (arrayList2.contains(trigger)) {
                ArrayList<Trigger> arrayList3 = this$0.triggersToWaitFor;
                if (arrayList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                } else {
                    arrayList = arrayList3;
                }
                arrayList.remove(trigger);
            }
            this$0.S();
        }
    }

    private final void init() {
        this.triggersToWaitFor = new ArrayList<>();
    }

    public final void addTrigger(@NotNull Trigger trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        ArrayList<Trigger> arrayList = this.triggersToWaitFor;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
            arrayList = null;
        }
        arrayList.add(trigger);
    }

    public final void disableTriggers() {
        PendingIntent pendingIntent = this.timeoutPendingIntent;
        ArrayList<Trigger> arrayList = null;
        if (pendingIntent != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Sdk27ServicesKt.getAlarmManager(context).cancel(pendingIntent);
            this.timeoutPendingIntent = null;
        }
        ArrayList<Trigger> arrayList2 = this.triggersToWaitFor;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
        } else {
            arrayList = arrayList2;
        }
        Iterator<Trigger> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().disableTriggerThreadSafe();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doDisable() {
        disableTriggers();
    }

    public final boolean getContinueOnTimeout() {
        return this.continueOnTimeout;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 5; i4++) {
            ArrayList<Trigger> arrayList = this.triggersToWaitFor;
            ArrayList<Trigger> arrayList2 = null;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                arrayList = null;
            }
            if (arrayList.size() > i4) {
                ArrayList<Trigger> arrayList3 = this.triggersToWaitFor;
                if (arrayList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                    arrayList3 = null;
                }
                Trigger trigger = arrayList3.get(i4);
                Intrinsics.checkNotNullExpressionValue(trigger, "triggersToWaitFor[i]");
                sb.append(trigger.getConfiguredNameFlowControl());
                ArrayList<Trigger> arrayList4 = this.triggersToWaitFor;
                if (arrayList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
                } else {
                    arrayList2 = arrayList4;
                }
                if (i4 < arrayList2.size() - 1 && i4 < 4) {
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb.append(SelectableItem.r(R.string.or));
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "triggersList.toString()");
        return sb2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return WaitUntilTriggerActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    @Nullable
    public final ResumeMacroInfo getResumeMacroInfo() {
        return this.resumeMacroInfo;
    }

    @NotNull
    public final Stack<Integer> getSkipEndifIndexStack() {
        return this.skipEndIfIndexStack;
    }

    @NotNull
    public final ArrayList<Trigger> getTriggersToWaitFor() {
        ArrayList<Trigger> arrayList = this.triggersToWaitFor;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
            return null;
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@Nullable Activity activity, int i4, int i5, @Nullable Intent intent) {
        Trigger trigger = this.selectedTrigger;
        if (trigger != null) {
            trigger.handleActivityResult(activity, i4, i5, intent);
        }
        setActivity(activity);
        U(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        U(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        if (!getMacro().isEnabled()) {
            Timber.w("Wait for trigger action can only function correctly if the macro is enabled.", new Object[0]);
            getMacro().setIsRunning(false);
            return;
        }
        ArrayList<Trigger> arrayList = this.triggersToWaitFor;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
            arrayList = null;
        }
        Iterator<Trigger> it = arrayList.iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.setMacro(this.m_macro);
            next.enableTriggerThreadSafe();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void refresh() {
        if (this.triggerConfigDialog != null) {
            U(false);
        }
    }

    public final void refreshTrigger(@NotNull Trigger trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        S();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return this.timeoutEnabled;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        List list;
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        ArrayList<Trigger> arrayList = this.triggersToWaitFor;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("triggersToWaitFor");
            arrayList = null;
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        out.writeList(list);
        out.writeInt(this.timeoutSeconds);
        out.writeInt(this.timeoutEnabled ? 1 : 0);
        out.writeInt(this.continueOnTimeout ? 1 : 0);
    }

    public WaitUntilTriggerAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        init();
    }

    public WaitUntilTriggerAction() {
        this.skipEndIfIndexStack = new Stack<>();
        init();
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndIfIndexSt, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndIfIndexSt, "skipEndIfIndexSt");
        if (!getMacro().isEnabled()) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logWarning("Wait for trigger action can only function correctly if the macro is enabled.", macroGuid.longValue());
            getMacro().setIsRunning(false);
            return;
        }
        this.skipEndIfIndexStack = skipEndIfIndexSt;
        this.resumeMacroInfo = resumeMacroInfo;
        getMacro().setWaitForTriggerActive(this);
        getMacro().setOriginalTriggerContextInfo(triggerContextInfo);
        Z();
        if (!this.timeoutEnabled || this.timeoutSeconds <= 0) {
            return;
        }
        Intent intent = new Intent(getContext(), WaitUntilTriggerTimeoutReceiver.class);
        Long macroGuid2 = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
        intent.putExtra(Constants.EXTRA_MACRO_GUID, macroGuid2.longValue());
        intent.putExtra(Constants.EXTRA_SELECTABLE_ITEM_ID, getSIGUID());
        intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, skipEndIfIndexSt);
        intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
        intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
        this.timeoutPendingIntent = PendingIntent.getBroadcast(getContext(), REQUEST_CODE_TIMEOUT, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        long currentTimeMillis = System.currentTimeMillis() + (this.timeoutSeconds * 1000);
        PendingIntent pendingIntent = this.timeoutPendingIntent;
        Intrinsics.checkNotNull(pendingIntent);
        AlarmHelper.scheduleExactRTCWithAlarmOption(true, currentTimeMillis, pendingIntent);
    }

    private WaitUntilTriggerAction(Parcel parcel) {
        super(parcel);
        this.skipEndIfIndexStack = new Stack<>();
        init();
        ArrayList<Trigger> readArrayList = parcel.readArrayList(Constraint.class.getClassLoader());
        Intrinsics.checkNotNull(readArrayList, "null cannot be cast to non-null type java.util.ArrayList<com.arlosoft.macrodroid.triggers.Trigger>");
        this.triggersToWaitFor = readArrayList;
        this.timeoutSeconds = parcel.readInt();
        this.timeoutEnabled = parcel.readInt() != 0;
        this.continueOnTimeout = parcel.readInt() != 0;
    }

    /* compiled from: WaitUntilTriggerAction.kt */
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
