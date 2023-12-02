package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetNotificationBarIconActionInfo;
import com.arlosoft.macrodroid.common.NotificationButton;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.utils.IconUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SetNotificationBarIconAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SetNotificationBarIconAction extends Action {
    public static final int REQUEST_CODE_SELECT_ICON = 1;
    private int buttonNumber;
    @Nullable
    private transient WeakReference<ImageView> iconImageRef;
    private int imageId;
    @Nullable
    private String imageName;
    @Nullable
    private String imagePackageName;
    @Nullable
    private String imageUri;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SetNotificationBarIconAction> CREATOR = new Parcelable.Creator<SetNotificationBarIconAction>() { // from class: com.arlosoft.macrodroid.action.SetNotificationBarIconAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SetNotificationBarIconAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SetNotificationBarIconAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SetNotificationBarIconAction[] newArray(int i4) {
            return new SetNotificationBarIconAction[i4];
        }
    };

    /* compiled from: SetNotificationBarIconAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$activity, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$activity.startActivityForResult(new Intent(this.$activity, IconSelectActivity.class), 1);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SetNotificationBarIconAction.kt */
    /* loaded from: classes2.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Spinner $buttonNumberSpinner;
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Spinner spinner, AppCompatDialog appCompatDialog, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$buttonNumberSpinner = spinner;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$buttonNumberSpinner, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SetNotificationBarIconAction.this.buttonNumber = this.$buttonNumberSpinner.getSelectedItemPosition() + 1;
                SetNotificationBarIconAction.this.itemComplete();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SetNotificationBarIconAction.kt */
    /* loaded from: classes2.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AppCompatDialog appCompatDialog, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* compiled from: SetNotificationBarIconAction.kt */
    /* loaded from: classes2.dex */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MacroDroidService.Companion companion = MacroDroidService.Companion;
                Context context = SetNotificationBarIconAction.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                MacroDroidService.Companion.updateNotification$default(companion, context, true, false, 4, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ SetNotificationBarIconAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(ImageView imageView, int i4, List<? extends NotificationButton> list) {
        if (i4 < list.size()) {
            NotificationButton notificationButton = list.get(i4);
            if (notificationButton.getImageUri() == null && notificationButton.getImageResourcePackage() == null) {
                imageView.setImageTintList(ColorStateList.valueOf(Settings.getButtonBarIconTint(getContext())));
            } else {
                imageView.setImageTintList(null);
            }
            IconUtils.setImageOnImageView(getContext(), imageView, notificationButton.getImageResourceName(), notificationButton.getImageResourcePackage(), notificationButton.getImageResourceId(), notificationButton.getImageUri(), null);
            return;
        }
        imageView.setImageResource(R.drawable.no_image_placeholder);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String r4 = SelectableItem.r(R.string.button);
        int i4 = this.buttonNumber;
        return r4 + " (" + i4 + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo setNotificationBarIconActionInfo = SetNotificationBarIconActionInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(setNotificationBarIconActionInfo, "getInstance()");
        return setNotificationBarIconActionInfo;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        String str;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i4 == 1 && i5 != 0 && intent != null) {
            this.imageName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.imagePackageName = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.imageName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.imageId = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            Uri data = intent.getData();
            if (data != null) {
                str = data.toString();
            } else {
                str = null;
            }
            this.imageUri = str;
            WeakReference<ImageView> weakReference = this.iconImageRef;
            if (weakReference != null) {
                imageView = weakReference.get();
            } else {
                imageView = null;
            }
            if (imageView != null) {
                if (this.imageUri == null && (Intrinsics.areEqual(this.imagePackageName, BuildConfig.APPLICATION_ID) || this.imagePackageName == null)) {
                    imageView.setImageTintList(ColorStateList.valueOf(Settings.getButtonBarIconTint(getContext())));
                } else {
                    imageView.setImageTintList(null);
                }
                IconUtils.setImageOnImageView(getContext(), imageView, this.imageName, this.imagePackageName, this.imageId, this.imageUri);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int i4;
        Activity activity = getActivity();
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_notification_bar_button_icon);
        appCompatDialog.setTitle(R.string.action_set_notification_button_icon);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final ImageView imageView = (ImageView) appCompatDialog.findViewById(R.id.existingImage);
        ImageView imageView2 = (ImageView) appCompatDialog.findViewById(R.id.newImage);
        ImageView imageView3 = (ImageView) appCompatDialog.findViewById(R.id.editImage);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.newImageFrame);
        View findViewById = appCompatDialog.findViewById(R.id.buttonNumberSpinner);
        Intrinsics.checkNotNull(findViewById);
        Spinner spinner = (Spinner) findViewById;
        final List<NotificationButton> notificationButtonList = Settings.getNotificationButtons(getContext());
        this.iconImageRef = new WeakReference<>(imageView2);
        Intrinsics.checkNotNull(imageView);
        Intrinsics.checkNotNullExpressionValue(notificationButtonList, "notificationButtonList");
        M(imageView, this.buttonNumber - 1, notificationButtonList);
        boolean buttonBarBlackBg = Settings.getButtonBarBlackBg(getContext());
        int i5 = -16777216;
        if (buttonBarBlackBg) {
            i4 = -16777216;
        } else {
            i4 = 0;
        }
        imageView.setBackgroundColor(i4);
        if (imageView2 != null) {
            if (!buttonBarBlackBg) {
                i5 = 0;
            }
            imageView2.setBackgroundColor(i5);
        }
        if (!buttonBarBlackBg && imageView3 != null) {
            imageView3.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.default_text_color)));
        }
        if (this.imageUri == null && this.imagePackageName == null) {
            int buttonBarIconTint = Settings.getButtonBarIconTint(getContext());
            if (imageView2 != null) {
                imageView2.setImageTintList(ColorStateList.valueOf(buttonBarIconTint));
            }
        } else if (imageView2 != null) {
            imageView2.setImageTintList(null);
        }
        IconUtils.setImageOnImageView(getContext(), imageView2, this.imageName, this.imagePackageName, this.imageId, this.imageUri);
        spinner.setSelection(this.buttonNumber - 1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.action.SetNotificationBarIconAction$handleItemSelected$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@NotNull AdapterView<?> parent, @Nullable View view, int i6, long j4) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                SetNotificationBarIconAction setNotificationBarIconAction = SetNotificationBarIconAction.this;
                ImageView imageView4 = imageView;
                List<NotificationButton> notificationButtonList2 = notificationButtonList;
                Intrinsics.checkNotNullExpressionValue(notificationButtonList2, "notificationButtonList");
                setNotificationBarIconAction.M(imageView4, i6, notificationButtonList2);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@NotNull AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        if (viewGroup != null) {
            ViewExtensionsKt.onClick$default(viewGroup, null, new a(activity, null), 1, null);
        }
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, null, new b(spinner, appCompatDialog, null), 1, null);
        }
        if (button2 != null) {
            ViewExtensionsKt.onClick$default(button2, null, new c(appCompatDialog, null), 1, null);
        }
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        Uri uri;
        List<NotificationButton> notificationButtons = Settings.getNotificationButtons(getContext());
        int size = notificationButtons.size();
        int i4 = this.buttonNumber;
        if (size >= i4) {
            NotificationButton notificationButton = notificationButtons.get(i4 - 1);
            String str = this.imageUri;
            if (str != null) {
                uri = Uri.parse(str);
            } else {
                uri = null;
            }
            notificationButton.setImageUri(uri);
            notificationButton.setImageResourceId(this.imageId);
            notificationButton.setImageResourceName(this.imageName);
            notificationButton.setImageResourcePackage(this.imagePackageName);
            Settings.setNotificationButtons(getContext(), notificationButtons);
            kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new d(null), 2, null);
            return;
        }
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Cannot set button image as notification button " + i4 + " is not configured", macroGuid.longValue());
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.buttonNumber);
        out.writeInt(this.imageId);
        out.writeString(this.imageName);
        out.writeString(this.imagePackageName);
        out.writeString(this.imageUri);
    }

    public SetNotificationBarIconAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetNotificationBarIconAction() {
        this.buttonNumber = 1;
    }

    private SetNotificationBarIconAction(Parcel parcel) {
        super(parcel);
        this.buttonNumber = 1;
        this.buttonNumber = parcel.readInt();
        this.imageId = parcel.readInt();
        this.imageName = parcel.readString();
        this.imagePackageName = parcel.readString();
        this.imageUri = parcel.readString();
    }

    /* compiled from: SetNotificationBarIconAction.kt */
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
