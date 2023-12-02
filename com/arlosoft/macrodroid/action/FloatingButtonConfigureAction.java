package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.FloatingButtonConfigureActionInfo;
import com.arlosoft.macrodroid.categories.HasMacroNames;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.FloatingButtonsUpdateEvent;
import com.arlosoft.macrodroid.interfaces.SupportsUserImages;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.FloatingButtonTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.textfield.TextInputLayout;
import com.melnykov.fab.FloatingActionButton;
import com.thebluealliance.spectrum.SpectrumDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingButtonConfigureAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFloatingButtonConfigureAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingButtonConfigureAction.kt\ncom/arlosoft/macrodroid/action/FloatingButtonConfigureAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,709:1\n350#2,7:710\n350#2,7:717\n1549#2:724\n1620#2,3:725\n800#2,11:731\n800#2,11:742\n1360#2:753\n1446#2,2:754\n800#2,11:756\n1448#2,3:767\n1747#2,3:771\n1559#2:774\n1590#2,4:775\n766#2:781\n857#2:782\n800#2,11:783\n800#2,11:794\n1747#2,2:805\n800#2,11:807\n1749#2:818\n858#2:819\n37#3,2:728\n37#3,2:779\n26#4:730\n1#5:770\n262#6,2:820\n262#6,2:822\n262#6,2:824\n262#6,2:826\n*S KotlinDebug\n*F\n+ 1 FloatingButtonConfigureAction.kt\ncom/arlosoft/macrodroid/action/FloatingButtonConfigureAction\n*L\n230#1:710,7\n232#1:717,7\n266#1:724\n266#1:725,3\n306#1:731,11\n307#1:742,11\n307#1:753\n307#1:754,2\n307#1:756,11\n307#1:767,3\n325#1:771,3\n349#1:774\n349#1:775,4\n385#1:781\n385#1:782\n386#1:783,11\n387#1:794,11\n387#1:805,2\n387#1:807,11\n387#1:818\n385#1:819\n272#1:728,2\n349#1:779,2\n276#1:730\n434#1:820,2\n437#1:822,2\n438#1:824,2\n441#1:826,2\n*E\n"})
/* loaded from: classes2.dex */
public final class FloatingButtonConfigureAction extends Action implements HasMacroNames, SupportsUserImages {
    @NotNull
    private static final String CONSTANT_THIS_MACRO_STRING = "this_macro";
    private static final int ENABLE_OPTION_DISABLE = 2;
    private static final int ENABLE_OPTION_DONT_CHANGE = 0;
    private static final int ENABLE_OPTION_ENABLE = 1;
    private static final long GUID_THIS_MACRO = -1;
    private static final int REQUEST_CODE_ICON_SELECT = 249232;
    private int alpha;
    private int enableOption;
    @Nullable
    private transient WeakReference<FloatingActionButton> fabRef;
    private int iconBgColor;
    @NotNull
    private String identifier;
    @Nullable
    private String imagePackageName;
    private int imageResourceId;
    @Nullable
    private String imageResourceName;
    @Nullable
    private String imageUri;
    private boolean isInitialised;
    private long macroGuid;
    @NotNull
    private String macroName;
    private transient boolean normalSizeSelected;
    private int padding;
    @Nullable
    private transient WeakReference<SeekBar> paddingSeekBarRef;
    private int size;
    private boolean transparentBackground;
    private long triggerGuid;
    private boolean updateLocation;
    private boolean usePercentForLocation;
    private int xLocation;
    private int yLocation;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FloatingButtonConfigureAction> CREATOR = new Parcelable.Creator<FloatingButtonConfigureAction>() { // from class: com.arlosoft.macrodroid.action.FloatingButtonConfigureAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FloatingButtonConfigureAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FloatingButtonConfigureAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FloatingButtonConfigureAction[] newArray(int i4) {
            return new FloatingButtonConfigureAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingButtonConfigureAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<Macro, Boolean> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(Macro macro) {
            boolean z3;
            long guid = macro.getGUID();
            Long macroGuid = FloatingButtonConfigureAction.this.getMacroGuid();
            if (macroGuid != null && guid == macroGuid.longValue()) {
                z3 = true;
            } else {
                z3 = false;
            }
            return Boolean.valueOf(z3);
        }
    }

    public /* synthetic */ FloatingButtonConfigureAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void X(FloatingButtonTrigger floatingButtonTrigger) {
        boolean z3;
        int i4;
        boolean z4;
        int backgroundColor;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_floating_button);
        appCompatDialog.setTitle(getName());
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
        View findViewById3 = appCompatDialog.findViewById(R.id.floating_button_change_background);
        Intrinsics.checkNotNull(findViewById3);
        Button button3 = (Button) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.floating_button_change_icon);
        Intrinsics.checkNotNull(findViewById4);
        Button button4 = (Button) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.floating_button_alpha_seekbar);
        Intrinsics.checkNotNull(findViewById5);
        final SeekBar seekBar = (SeekBar) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.padding_seekbar);
        Intrinsics.checkNotNull(findViewById6);
        final SeekBar seekBar2 = (SeekBar) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.alpha_percent_text);
        Intrinsics.checkNotNull(findViewById7);
        final TextView textView = (TextView) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.normal_size);
        Intrinsics.checkNotNull(findViewById8);
        final RadioButton radioButton = (RadioButton) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.mini_size);
        Intrinsics.checkNotNull(findViewById9);
        RadioButton radioButton2 = (RadioButton) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.show_on_lock_screen);
        Intrinsics.checkNotNull(findViewById10);
        CheckBox checkBox = (CheckBox) findViewById10;
        View findViewById11 = appCompatDialog.findViewById(R.id.floating_button_image);
        Intrinsics.checkNotNull(findViewById11);
        ImageView imageView = (ImageView) findViewById11;
        View findViewById12 = appCompatDialog.findViewById(R.id.fab);
        Intrinsics.checkNotNull(findViewById12);
        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById12;
        View findViewById13 = appCompatDialog.findViewById(R.id.transparent_background_checkbox);
        Intrinsics.checkNotNull(findViewById13);
        final CheckBox checkBox2 = (CheckBox) findViewById13;
        View findViewById14 = appCompatDialog.findViewById(R.id.force_location_on_enable);
        Intrinsics.checkNotNull(findViewById14);
        final CheckBox checkBox3 = (CheckBox) findViewById14;
        View findViewById15 = appCompatDialog.findViewById(R.id.x_location);
        Intrinsics.checkNotNull(findViewById15);
        final EditText editText = (EditText) findViewById15;
        View findViewById16 = appCompatDialog.findViewById(R.id.y_location);
        Intrinsics.checkNotNull(findViewById16);
        final EditText editText2 = (EditText) findViewById16;
        View findViewById17 = appCompatDialog.findViewById(R.id.editable_identifier);
        Intrinsics.checkNotNull(findViewById17);
        View findViewById18 = appCompatDialog.findViewById(R.id.static_identifier);
        Intrinsics.checkNotNull(findViewById18);
        TextView textView2 = (TextView) findViewById18;
        View findViewById19 = appCompatDialog.findViewById(R.id.enabled_state_options);
        Intrinsics.checkNotNull(findViewById19);
        final Spinner spinner = (Spinner) findViewById19;
        View findViewById20 = appCompatDialog.findViewById(R.id.radioButtonPixels);
        Intrinsics.checkNotNull(findViewById20);
        final RadioButton radioButton3 = (RadioButton) findViewById20;
        View findViewById21 = appCompatDialog.findViewById(R.id.radioButtonPercent);
        Intrinsics.checkNotNull(findViewById21);
        final RadioButton radioButton4 = (RadioButton) findViewById21;
        radioButton3.setChecked(!this.usePercentForLocation);
        radioButton4.setChecked(this.usePercentForLocation);
        spinner.setVisibility(0);
        spinner.setSelection(this.enableOption);
        ((TextInputLayout) findViewById17).setVisibility(8);
        textView2.setVisibility(0);
        String r4 = SelectableItem.r(R.string.web_url_identifier);
        String str = this.identifier;
        textView2.setText(r4 + ": " + str);
        Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.disable_options_spinner);
        if (spinner2 != null) {
            spinner2.setVisibility(8);
        }
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.l6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                FloatingButtonConfigureAction.Y(editText, editText2, radioButton3, radioButton4, compoundButton, z5);
            }
        });
        checkBox3.setText(R.string.floating_button_update_location_option);
        editText.setEnabled(this.updateLocation);
        editText2.setEnabled(this.updateLocation);
        radioButton3.setEnabled(this.updateLocation);
        radioButton4.setEnabled(this.updateLocation);
        editText.setText(String.valueOf(this.xLocation));
        editText2.setText(String.valueOf(this.yLocation));
        checkBox3.setChecked(this.updateLocation);
        this.fabRef = new WeakReference<>(floatingActionButton);
        this.paddingSeekBarRef = new WeakReference<>(seekBar2);
        int i5 = this.size;
        if (i5 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.normalSizeSelected = z3;
        if (i5 == 0) {
            radioButton.setChecked(true);
            floatingActionButton.setType(0);
        } else {
            radioButton2.setChecked(true);
            floatingActionButton.setType(1);
        }
        checkBox2.setChecked(this.transparentBackground);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.n6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                FloatingButtonConfigureAction.Z(FloatingActionButton.this, this, compoundButton, z5);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingButtonConfigureAction.a0(FloatingButtonConfigureAction.this, activity, floatingActionButton, view);
            }
        });
        seekBar2.setMax(28);
        seekBar2.setProgress(this.padding);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.arlosoft.macrodroid.action.FloatingButtonConfigureAction$configureFloatingButton$4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(@NotNull SeekBar seekBar3, int i6, boolean z5) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
                FloatingButtonConfigureAction.this.n0(floatingActionButton, seekBar2.getProgress());
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(@NotNull SeekBar seekBar3) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(@NotNull SeekBar seekBar3) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
            }
        });
        seekBar.setProgress(this.alpha);
        int i6 = this.alpha;
        textView.setText(i6 + "%");
        imageView.setAlpha(((float) this.alpha) / 100.0f);
        checkBox.setVisibility(8);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.arlosoft.macrodroid.action.FloatingButtonConfigureAction$configureFloatingButton$5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(@NotNull SeekBar seekBar3, int i7, boolean z5) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
                if (z5) {
                    TextView textView3 = textView;
                    textView3.setText(i7 + "%");
                    floatingActionButton.setAlpha(((float) i7) / 100.0f);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(@NotNull SeekBar seekBar3) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(@NotNull SeekBar seekBar3) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.p6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                FloatingButtonConfigureAction.c0(FloatingActionButton.this, this, seekBar2, compoundButton, z5);
            }
        });
        if (this.transparentBackground) {
            i4 = 0;
        } else {
            i4 = this.iconBgColor;
        }
        floatingActionButton.setColorNormal(i4);
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingButtonConfigureAction.d0(activity, view);
            }
        });
        if (!this.isInitialised) {
            checkBox2.setChecked(floatingButtonTrigger.getTransparentBackground());
            if (floatingButtonTrigger.getSize() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            radioButton2.setChecked(z4);
            seekBar2.setProgress(floatingButtonTrigger.getPadding());
            seekBar.setProgress(floatingButtonTrigger.getAlpha());
            int alpha = floatingButtonTrigger.getAlpha();
            textView.setText(alpha + "%");
            if (floatingButtonTrigger.getSize() == 0) {
                radioButton.setChecked(true);
                floatingActionButton.setType(0);
            } else {
                radioButton2.setChecked(true);
                floatingActionButton.setType(1);
            }
            this.iconBgColor = floatingButtonTrigger.getBackgroundColor();
            if (floatingButtonTrigger.getTransparentBackground()) {
                backgroundColor = 0;
            } else {
                backgroundColor = floatingButtonTrigger.getBackgroundColor();
            }
            floatingActionButton.setColorNormal(backgroundColor);
            n0(floatingActionButton, floatingButtonTrigger.getPadding());
            this.imageUri = floatingButtonTrigger.getImageUri();
            this.imagePackageName = floatingButtonTrigger.getImagePackageName();
            this.imageResourceName = floatingButtonTrigger.getImageResourceName();
            this.imageResourceId = floatingButtonTrigger.getImageResourceId();
        }
        n0(floatingActionButton, this.padding);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingButtonConfigureAction.e0(AppCompatDialog.this, this, seekBar, seekBar2, radioButton, checkBox2, checkBox3, radioButton4, editText, editText2, spinner, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.s6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingButtonConfigureAction.f0(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText xLocationBox, EditText yLocationBox, RadioButton radioButtonPixels, RadioButton radioButtonPercent, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(xLocationBox, "$xLocationBox");
        Intrinsics.checkNotNullParameter(yLocationBox, "$yLocationBox");
        Intrinsics.checkNotNullParameter(radioButtonPixels, "$radioButtonPixels");
        Intrinsics.checkNotNullParameter(radioButtonPercent, "$radioButtonPercent");
        xLocationBox.setEnabled(z3);
        yLocationBox.setEnabled(z3);
        radioButtonPixels.setEnabled(z3);
        radioButtonPercent.setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(FloatingActionButton fab, FloatingButtonConfigureAction this$0, CompoundButton compoundButton, boolean z3) {
        int i4;
        Intrinsics.checkNotNullParameter(fab, "$fab");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z3) {
            i4 = 0;
        } else {
            i4 = this$0.iconBgColor;
        }
        fab.setColorNormal(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(final FloatingButtonConfigureAction this$0, Activity activity, final FloatingActionButton fab, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fab, "$fab");
        SpectrumDialog build = new SpectrumDialog.Builder(this$0.getContext()).setTitle(R.string.select_color).setColors(R.array.notification_colors).setSelectedColor(this$0.iconBgColor).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.action.m6
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                FloatingButtonConfigureAction.b0(FloatingButtonConfigureAction.this, fab, z3, i4);
            }
        }).build();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        build.show(((AppCompatActivity) activity).getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(FloatingButtonConfigureAction this$0, FloatingActionButton fab, boolean z3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fab, "$fab");
        if (z3) {
            this$0.iconBgColor = i4;
            fab.setColorNormal(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(FloatingActionButton fab, FloatingButtonConfigureAction this$0, SeekBar iconPaddingSeekBar, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(fab, "$fab");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iconPaddingSeekBar, "$iconPaddingSeekBar");
        fab.setPadding(0, 0, 0, 0);
        fab.setType(z3 ? 1 : 0);
        int m02 = (int) this$0.m0(iconPaddingSeekBar.getProgress());
        fab.setPadding(m02, m02, m02, m02);
        this$0.normalSizeSelected = !z3 ? 1 : 0;
        this$0.n0(fab, iconPaddingSeekBar.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Activity activity, View view) {
        Intent intent = new Intent(activity, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, true);
        activity.startActivityForResult(intent, REQUEST_CODE_ICON_SELECT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(AppCompatDialog dialog, FloatingButtonConfigureAction this$0, SeekBar alphaSeekBar, SeekBar iconPaddingSeekBar, RadioButton normalSize, CheckBox transparentBgCheckbox, CheckBox forceLocationCb, RadioButton radioButtonPercent, EditText xLocationBox, EditText yLocationBox, Spinner enableOptionsSpinner, View view) {
        int intValue;
        int intValue2;
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(alphaSeekBar, "$alphaSeekBar");
        Intrinsics.checkNotNullParameter(iconPaddingSeekBar, "$iconPaddingSeekBar");
        Intrinsics.checkNotNullParameter(normalSize, "$normalSize");
        Intrinsics.checkNotNullParameter(transparentBgCheckbox, "$transparentBgCheckbox");
        Intrinsics.checkNotNullParameter(forceLocationCb, "$forceLocationCb");
        Intrinsics.checkNotNullParameter(radioButtonPercent, "$radioButtonPercent");
        Intrinsics.checkNotNullParameter(xLocationBox, "$xLocationBox");
        Intrinsics.checkNotNullParameter(yLocationBox, "$yLocationBox");
        Intrinsics.checkNotNullParameter(enableOptionsSpinner, "$enableOptionsSpinner");
        dialog.dismiss();
        this$0.alpha = alphaSeekBar.getProgress();
        this$0.padding = iconPaddingSeekBar.getProgress();
        this$0.size = !normalSize.isChecked();
        this$0.transparentBackground = transparentBgCheckbox.isChecked();
        this$0.updateLocation = forceLocationCb.isChecked();
        this$0.usePercentForLocation = radioButtonPercent.isChecked();
        try {
            if (TextUtils.isEmpty(xLocationBox.getText().toString())) {
                intValue2 = 0;
            } else {
                Integer valueOf = Integer.valueOf(xLocationBox.getText().toString());
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(xLocationBox.text.toString())");
                intValue2 = valueOf.intValue();
            }
            this$0.xLocation = intValue2;
        } catch (Exception unused) {
            this$0.xLocation = 0;
        }
        try {
            if (TextUtils.isEmpty(yLocationBox.getText().toString())) {
                intValue = 0;
            } else {
                Integer valueOf2 = Integer.valueOf(yLocationBox.getText().toString());
                Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(yLocationBox.text.toString())");
                intValue = valueOf2.intValue();
            }
            this$0.yLocation = intValue;
        } catch (Exception unused2) {
            this$0.yLocation = 0;
        }
        this$0.enableOption = enableOptionsSpinner.getSelectedItemPosition();
        this$0.isInitialised = true;
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final List<Macro> g0() {
        boolean z3;
        List<Macro> allMacros = MacroStore.getInstance().getAllCompletedMacrosSorted(false);
        Intrinsics.checkNotNullExpressionValue(allMacros, "allMacros");
        kotlin.collections.i.removeAll((List) allMacros, (Function1) new a());
        allMacros.add(0, getMacro());
        ArrayList arrayList = new ArrayList();
        for (Object obj : allMacros) {
            Macro macro = (Macro) obj;
            ArrayList<Trigger> triggerList = macro.getTriggerList();
            Intrinsics.checkNotNullExpressionValue(triggerList, "macro.triggerList");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : triggerList) {
                if (obj2 instanceof FloatingButtonTrigger) {
                    arrayList2.add(obj2);
                }
            }
            boolean isEmpty = arrayList2.isEmpty();
            boolean z4 = true;
            if (!(!isEmpty)) {
                ArrayList<Action> actions = macro.getActions();
                Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
                ArrayList<WaitUntilTriggerAction> arrayList3 = new ArrayList();
                for (Object obj3 : actions) {
                    if (obj3 instanceof WaitUntilTriggerAction) {
                        arrayList3.add(obj3);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    for (WaitUntilTriggerAction waitUntilTriggerAction : arrayList3) {
                        ArrayList<Trigger> triggersToWaitFor = waitUntilTriggerAction.getTriggersToWaitFor();
                        ArrayList arrayList4 = new ArrayList();
                        for (Object obj4 : triggersToWaitFor) {
                            if (obj4 instanceof FloatingButtonTrigger) {
                                arrayList4.add(obj4);
                            }
                        }
                        if (!arrayList4.isEmpty()) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                if (!z3) {
                    z4 = false;
                }
            }
            if (z4) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int h0() {
        if (this.normalSizeSelected) {
            return 20;
        }
        return 16;
    }

    private final String i0(FloatingButtonTrigger floatingButtonTrigger, int i4) {
        boolean z3;
        String identifier = floatingButtonTrigger.getIdentifier();
        if (identifier != null && identifier.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            return String.valueOf(floatingButtonTrigger.getIdentifier());
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String r4 = SelectableItem.r(R.string.floating_button_number_id);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.floating_button_number_id)");
            String format = String.format(r4, Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } catch (Exception unused) {
            Macro macro = floatingButtonTrigger.getMacro();
            Intrinsics.checkNotNullExpressionValue(macro, "fbTrigger.macro");
            String l02 = l0(macro);
            return l02 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (i4 + 1);
        }
    }

    private final Macro j0(String str) {
        boolean z3;
        boolean z4;
        boolean z5;
        if (str.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Object obj = null;
        if (z3) {
            return null;
        }
        Iterator<T> it = g0().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ArrayList<Trigger> triggerList = ((Macro) next).getTriggerList();
            Intrinsics.checkNotNullExpressionValue(triggerList, "macro.triggerList");
            if (!(triggerList instanceof Collection) || !triggerList.isEmpty()) {
                for (Trigger trigger : triggerList) {
                    if ((trigger instanceof FloatingButtonTrigger) && Intrinsics.areEqual(((FloatingButtonTrigger) trigger).getIdentifier(), str)) {
                        z4 = true;
                        continue;
                    } else {
                        z4 = false;
                        continue;
                    }
                    if (z4) {
                        z5 = true;
                        continue;
                        break;
                    }
                }
            }
            z5 = false;
            continue;
            if (z5) {
                obj = next;
                break;
            }
        }
        Macro macro = (Macro) obj;
        if (macro != null) {
            String str2 = this.macroName;
            String name = macro.getName();
            SystemLog.logWarning(str2 + " not found. Using floating button id: " + str + " from macro: " + name);
        }
        return macro;
    }

    private final Macro k0(String str) {
        if (Intrinsics.areEqual(str, CONSTANT_THIS_MACRO_STRING)) {
            return getMacro();
        }
        return MacroStore.getInstance().getMacroByName(this.macroName);
    }

    private final String l0(Macro macro) {
        if (Intrinsics.areEqual(macro.getName(), CONSTANT_THIS_MACRO_STRING)) {
            String r4 = SelectableItem.r(R.string.constraint_last_run_time_this_macro);
            Intrinsics.checkNotNullExpressionValue(r4, "{\n            getString(…ime_this_macro)\n        }");
            return r4;
        }
        String name = macro.getName();
        Intrinsics.checkNotNullExpressionValue(name, "{\n            macro.name\n        }");
        return name;
    }

    private final float m0(float f4) {
        return f4 * getContext().getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(FloatingActionButton floatingActionButton, int i4) {
        int i5;
        int m02 = (int) m0(i4 - 8);
        floatingActionButton.setPadding(m02, m02, m02, m02);
        String str = this.imageUri;
        if (str != null) {
            floatingActionButton.setImageURI(Uri.parse(str));
            return;
        }
        String str2 = this.imagePackageName;
        if (str2 == null) {
            if (this.imageResourceName != null) {
                i5 = Util.getResId(getContext(), this.imageResourceName);
            } else {
                i5 = -1;
            }
            if (i5 != -1) {
                floatingActionButton.setImageResource(i5);
                return;
            }
            int i6 = this.imageResourceId;
            if (i6 == 0) {
                floatingActionButton.setImageResource(R.drawable.not_icon_setup);
            } else {
                floatingActionButton.setImageResource(i6);
            }
        } else if (Intrinsics.areEqual(str2, Constants.USER_ICON_OPTION_PACKAGE)) {
            Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(this.imageResourceName);
            if (decodeBitmapFromUserIconFile != null) {
                floatingActionButton.setImageBitmap(decodeBitmapFromUserIconFile);
            } else {
                floatingActionButton.setImageResource(R.drawable.launcher_no_border);
            }
        } else {
            Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(getContext(), this.imagePackageName, this.imageResourceName);
            if (drawableFromPackageWithName == null) {
                drawableFromPackageWithName = Util.getDrawableFromPackage(getContext(), this.imagePackageName, this.imageResourceId);
            }
            if (drawableFromPackageWithName != null) {
                floatingActionButton.setImageDrawable(drawableFromPackageWithName);
            } else {
                floatingActionButton.setImageResource(R.drawable.not_icon_setup);
            }
        }
    }

    private final void o0(FloatingButtonTrigger floatingButtonTrigger, int i4, int i5) {
        int dimensionPixelSize;
        int i6;
        int i7;
        int i8;
        float f4;
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        if (this.size == 0) {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.floating_button_size);
        } else {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.floating_button_size_mini);
        }
        if (this.usePercentForLocation) {
            i6 = ((i4 * width) / 100) - (width / 2);
            i5 = (i5 * height) / 100;
            i7 = height / 2;
        } else {
            i6 = i4 - (width / 2);
            i7 = height / 2;
        }
        int i9 = i5 - i7;
        int i10 = width / 2;
        float abs = Math.abs(i6) / i10;
        int i11 = height / 2;
        float abs2 = Math.abs(i9) / i11;
        if (i6 < 0) {
            i8 = dimensionPixelSize / 2;
        } else {
            i8 = (-dimensionPixelSize) / 2;
        }
        int i12 = i6 + ((int) (i8 * abs));
        if (i9 < 0) {
            f4 = (dimensionPixelSize / 2) * abs;
        } else {
            f4 = abs2 * ((-dimensionPixelSize) / 2);
        }
        int i13 = i9 + ((int) f4);
        int i14 = dimensionPixelSize / 2;
        int i15 = ((-width) / 2) + i14;
        if (i12 < i15) {
            i12 = i15;
        } else {
            int i16 = i10 - i14;
            if (i12 > i16) {
                i12 = i16;
            }
        }
        int i17 = ((-height) / 2) + i14;
        if (i13 < i17) {
            i13 = i17;
        } else {
            int i18 = i11 - i14;
            if (i13 > i18) {
                i13 = i18;
            }
        }
        if (width < height) {
            Database.getInstance().setLocationOfFloatingButtonPortrait(floatingButtonTrigger.getSIGUID(), i12, i13);
        } else {
            Database.getInstance().setLocationOfFloatingButtonLandscape(floatingButtonTrigger.getSIGUID(), i12, i13);
        }
    }

    private final void p0(Macro macro) {
        long guid = macro.getGUID();
        Long macroGuid = getMacroGuid();
        if (macroGuid != null && guid == macroGuid.longValue()) {
            this.macroName = CONSTANT_THIS_MACRO_STRING;
            this.macroGuid = -1L;
            return;
        }
        String name = macro.getName();
        Intrinsics.checkNotNullExpressionValue(name, "selectedMacro.name");
        this.macroName = name;
        this.macroGuid = macro.getGUID();
    }

    private final void q0(final List<? extends FloatingButtonTrigger> list) {
        int collectionSizeOrDefault;
        int indexOf;
        int coerceAtLeast;
        List<? extends FloatingButtonTrigger> list2 = list;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i4 = 0;
        for (Object obj : list2) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(i0((FloatingButtonTrigger) obj, i4));
            i4 = i5;
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        indexOf = ArraysKt___ArraysKt.indexOf(strArr, this.identifier);
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(indexOf, 0);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_trigger);
        builder.setSingleChoiceItems(strArr, coerceAtLeast, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.t6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                FloatingButtonConfigureAction.r0(FloatingButtonConfigureAction.this, dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.u6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                FloatingButtonConfigureAction.s0(FloatingButtonConfigureAction.this, list, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.v6
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FloatingButtonConfigureAction.t0(FloatingButtonConfigureAction.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(FloatingButtonConfigureAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(FloatingButtonConfigureAction this$0, List fbTriggers, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fbTriggers, "$fbTriggers");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        this$0.triggerGuid = ((FloatingButtonTrigger) fbTriggers.get(checkedItemPosition)).getSIGUID();
        this$0.identifier = this$0.i0((FloatingButtonTrigger) fbTriggers.get(checkedItemPosition), checkedItemPosition);
        this$0.X((FloatingButtonTrigger) fbTriggers.get(checkedItemPosition));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(FloatingButtonConfigureAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        p0(g0().get(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        boolean z3;
        long j4 = this.macroGuid;
        if (j4 == 0 || j4 == -1) {
            return 0;
        }
        List<Macro> g02 = g0();
        Iterator<Macro> it = g02.iterator();
        int i4 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getGUID() == this.macroGuid) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 == -1) {
            Iterator<Macro> it2 = g02.iterator();
            int i5 = 0;
            while (true) {
                if (it2.hasNext()) {
                    if (Intrinsics.areEqual(it2.next().getName(), this.macroName)) {
                        break;
                    }
                    i5++;
                } else {
                    i5 = -1;
                    break;
                }
            }
            i4 = kotlin.ranges.h.coerceAtLeast(i5, 0);
        }
        if (i4 == -1) {
            p0(g02.get(0));
            return 0;
        }
        return i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.identifier;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsUserImages
    @Nullable
    public List<String> getImagePaths() {
        String str;
        List<String> listOf;
        if (Intrinsics.areEqual(this.imagePackageName, Constants.USER_ICON_OPTION_PACKAGE) && (str = this.imageResourceName) != null) {
            listOf = kotlin.collections.e.listOf(str);
            return listOf;
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return FloatingButtonConfigureActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    @NotNull
    public List<String> getMacroNames() {
        List<String> listOf;
        listOf = kotlin.collections.e.listOf(this.macroName);
        return listOf;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        WeakReference<FloatingActionButton> weakReference;
        FloatingActionButton floatingActionButton;
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i4 == REQUEST_CODE_ICON_SELECT && i5 != 0 && (weakReference = this.fabRef) != null && intent != null) {
            SeekBar seekBar = null;
            if (weakReference != null) {
                floatingActionButton = weakReference.get();
            } else {
                floatingActionButton = null;
            }
            WeakReference<SeekBar> weakReference2 = this.paddingSeekBarRef;
            if (weakReference2 != null) {
                seekBar = weakReference2.get();
            }
            if (floatingActionButton != null && seekBar != null) {
                this.imageResourceId = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
                this.imageResourceName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
                this.imagePackageName = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
                Uri data = intent.getData();
                if (data != null) {
                    this.imageUri = data.toString();
                }
                this.padding = h0();
                seekBar.setProgress(h0());
                n0(floatingActionButton, this.padding);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (!g0().isEmpty()) {
            k();
        } else {
            ToastCompat.makeText(getContext(), (int) R.string.action_floating_button_configure_no_floating_button_trigger_found, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean z3;
        Trigger trigger;
        Macro k02 = k0(this.macroName);
        if (k02 == null) {
            k02 = MacroStore.getInstance().getMacroByGUID(this.macroGuid);
        }
        if (k02 == null) {
            k02 = j0(this.identifier);
        }
        if (k02 != null) {
            String str = this.identifier;
            if (str != null && str.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                Iterator<Trigger> it = k02.getTriggerList().iterator();
                while (it.hasNext()) {
                    trigger = it.next();
                    if ((trigger instanceof FloatingButtonTrigger) && Intrinsics.areEqual(((FloatingButtonTrigger) trigger).getIdentifier(), this.identifier)) {
                        break;
                    }
                }
            }
            trigger = null;
            if (trigger == null) {
                Iterator<Action> it2 = k02.getActions().iterator();
                while (it2.hasNext()) {
                    Action next = it2.next();
                    if (next instanceof WaitUntilTriggerAction) {
                        Iterator<Trigger> it3 = ((WaitUntilTriggerAction) next).getTriggersToWaitFor().iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                Trigger next2 = it3.next();
                                if ((next2 instanceof FloatingButtonTrigger) && Intrinsics.areEqual(((FloatingButtonTrigger) next2).getIdentifier(), this.identifier)) {
                                    trigger = next2;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (trigger == null) {
                trigger = k02.findChildByGUID(this.triggerGuid);
            }
            if (trigger != null) {
                FloatingButtonTrigger floatingButtonTrigger = (FloatingButtonTrigger) trigger;
                floatingButtonTrigger.setTransparentBackground(this.transparentBackground);
                floatingButtonTrigger.setBackgroundColor(this.iconBgColor);
                floatingButtonTrigger.setSize(this.size);
                floatingButtonTrigger.setAlpha(this.alpha);
                floatingButtonTrigger.setImageData(this.imagePackageName, this.imageResourceName, this.imageResourceId, this.imageUri);
                floatingButtonTrigger.setPadding(this.padding);
                if (this.updateLocation) {
                    o0(floatingButtonTrigger, this.xLocation, this.yLocation);
                    floatingButtonTrigger.setUsePercentForLocation(this.usePercentForLocation);
                    floatingButtonTrigger.setXYLocation(this.xLocation, this.yLocation);
                }
                int i4 = this.enableOption;
                if (i4 == 1) {
                    floatingButtonTrigger.setEnabled(true);
                    floatingButtonTrigger.enableTriggerThreadSafe();
                } else if (i4 == 2) {
                    floatingButtonTrigger.setEnabled(false);
                    floatingButtonTrigger.disableTriggerThreadSafe();
                }
                MacroStore.getInstance().persistMacro(k02);
                EventBusUtils.getEventBus().post(new FloatingButtonsUpdateEvent());
                return;
            }
            String str2 = this.macroName;
            SystemLog.logError("Could not find floating button in macro: " + str2);
            return;
        }
        String str3 = this.macroName;
        SystemLog.logError("Could not find macro: " + str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        int collectionSizeOrDefault;
        boolean z3;
        String l02;
        List<Macro> g02 = g0();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(g02, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Macro macro : g02) {
            long guid = macro.getGUID();
            Long macroGuid = getMacroGuid();
            if (macroGuid != null && guid == macroGuid.longValue()) {
                l02 = SelectableItem.r(R.string.constraint_last_run_time_this_macro);
            } else {
                l02 = l0(macro);
            }
            arrayList.add(l02);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (strArr.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(getContext(), (int) R.string.no_triggers, 0).show();
            return new String[0];
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String p() {
        String string = getContext().getString(R.string.select_macro);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.select_macro)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        boolean z3;
        Long l4;
        List<? extends FloatingButtonTrigger> plus;
        String str = this.macroName;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 || this.macroGuid == 0) {
            p0(g0().get(0));
        }
        Macro k02 = k0(this.macroName);
        if (k02 == null) {
            k02 = MacroStore.getInstance().getMacroByGUID(this.macroGuid);
        }
        if (k02 == null) {
            k02 = j0(this.identifier);
        }
        if (k02 != null) {
            l4 = Long.valueOf(k02.getGUID());
        } else {
            l4 = null;
        }
        if (Intrinsics.areEqual(l4, getMacroGuid())) {
            this.macroName = CONSTANT_THIS_MACRO_STRING;
            this.macroGuid = -1L;
        }
        if (k02 != null) {
            ArrayList<Trigger> triggerList = k02.getTriggerList();
            Intrinsics.checkNotNullExpressionValue(triggerList, "macro.triggerList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : triggerList) {
                if (obj instanceof FloatingButtonTrigger) {
                    arrayList.add(obj);
                }
            }
            ArrayList<Action> actions = k02.getActions();
            Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
            ArrayList<WaitUntilTriggerAction> arrayList2 = new ArrayList();
            for (Object obj2 : actions) {
                if (obj2 instanceof WaitUntilTriggerAction) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (WaitUntilTriggerAction waitUntilTriggerAction : arrayList2) {
                ArrayList<Trigger> triggersToWaitFor = waitUntilTriggerAction.getTriggersToWaitFor();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : triggersToWaitFor) {
                    if (obj3 instanceof FloatingButtonTrigger) {
                        arrayList4.add(obj3);
                    }
                }
                kotlin.collections.i.addAll(arrayList3, arrayList4);
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList3);
            if (plus.size() == 1) {
                this.triggerGuid = plus.get(0).getSIGUID();
                this.identifier = i0(plus.get(0), 0);
                X(plus.get(0));
                return;
            }
            q0(plus);
            return;
        }
        ToastCompat.makeText(getContext(), (CharSequence) SelectableItem.r(R.string.error), 0).show();
        String str2 = this.macroName;
        SystemLog.logError("Macro: " + str2 + " was not found");
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    public void setMacroNames(@NotNull List<String> macroNames) {
        Intrinsics.checkNotNullParameter(macroNames, "macroNames");
        if (macroNames.size() == 1) {
            this.macroName = macroNames.get(0);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.enableOption);
        out.writeLong(this.triggerGuid);
        out.writeLong(this.macroGuid);
        out.writeString(this.macroName);
        out.writeInt(this.iconBgColor);
        out.writeInt(this.alpha);
        out.writeInt(this.size);
        out.writeInt(this.transparentBackground ? 1 : 0);
        out.writeInt(this.updateLocation ? 1 : 0);
        out.writeInt(this.xLocation);
        out.writeInt(this.yLocation);
        out.writeInt(this.padding);
        out.writeString(this.identifier);
        out.writeInt(this.isInitialised ? 1 : 0);
        out.writeInt(this.imageResourceId);
        out.writeString(this.imageResourceName);
        out.writeString(this.imagePackageName);
        out.writeString(this.imageUri);
        out.writeInt(this.usePercentForLocation ? 1 : 0);
    }

    public FloatingButtonConfigureAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public FloatingButtonConfigureAction() {
        this.identifier = "";
        this.macroName = "";
        this.padding = 20;
        this.normalSizeSelected = true;
    }

    private FloatingButtonConfigureAction(Parcel parcel) {
        super(parcel);
        this.identifier = "";
        this.macroName = "";
        this.padding = 20;
        this.normalSizeSelected = true;
        this.enableOption = parcel.readInt();
        this.triggerGuid = parcel.readLong();
        this.macroGuid = parcel.readLong();
        String readString = parcel.readString();
        this.macroName = readString == null ? "" : readString;
        this.iconBgColor = parcel.readInt();
        this.alpha = parcel.readInt();
        this.size = parcel.readInt();
        this.transparentBackground = parcel.readInt() != 0;
        this.updateLocation = parcel.readInt() != 0;
        this.xLocation = parcel.readInt();
        this.yLocation = parcel.readInt();
        this.padding = parcel.readInt();
        String readString2 = parcel.readString();
        this.identifier = readString2 != null ? readString2 : "";
        this.isInitialised = parcel.readInt() != 0;
        this.imageResourceId = parcel.readInt();
        this.imageResourceName = parcel.readString();
        this.imagePackageName = parcel.readString();
        this.imageUri = parcel.readString();
        this.usePercentForLocation = parcel.readInt() != 0;
    }

    /* compiled from: FloatingButtonConfigureAction.kt */
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
