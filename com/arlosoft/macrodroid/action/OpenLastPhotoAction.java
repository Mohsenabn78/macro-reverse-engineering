package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.OpenLastPhotoActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenLastPhotoAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class OpenLastPhotoAction extends Action {
    @NotNull
    private String appName;
    @NotNull
    private String packageName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<OpenLastPhotoAction> CREATOR = new Parcelable.Creator<OpenLastPhotoAction>() { // from class: com.arlosoft.macrodroid.action.OpenLastPhotoAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OpenLastPhotoAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OpenLastPhotoAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OpenLastPhotoAction[] newArray(int i4) {
            return new OpenLastPhotoAction[i4];
        }
    };

    public /* synthetic */ OpenLastPhotoAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(OpenLastPhotoAction this$0, List list, String[] apps, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(apps, "$apps");
        String str = ((ResolveInfo) list.get(i4)).activityInfo.packageName;
        Intrinsics.checkNotNullExpressionValue(str, "list[item].activityInfo.packageName");
        this$0.packageName = str;
        String str2 = apps[i4];
        Intrinsics.checkNotNull(str2);
        this$0.appName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(OpenLastPhotoAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(OpenLastPhotoAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(OpenLastPhotoAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.appName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return OpenLastPhotoActionInfo.Companion.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            return new String[]{"android.permission.READ_MEDIA_IMAGES"};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String str;
        super.onItemSelected();
        PackageManager packageManager = getContext().getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri lastPhoto = Util.getLastPhoto(getContext());
        if (lastPhoto != null) {
            intent.setData(lastPhoto);
        } else {
            intent.setType(ImageUtils.MIME_TYPE_IMAGE_WILDCARD);
        }
        final List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, 0)");
        if (queryIntentActivities.size() == 0) {
            Util.displayErrorDialog(getActivity(), "Cannot Open File", "No applications have been found that can open the specified file.");
            return;
        }
        Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
        final String[] strArr = new String[queryIntentActivities.size()];
        int i4 = 0;
        int i5 = 0;
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            CharSequence loadLabel = resolveInfo.loadLabel(packageManager);
            String str2 = resolveInfo.activityInfo.targetActivity;
            if (str2 != null) {
                str = " (" + str2 + ")";
            } else {
                str = "";
            }
            String str3 = ((Object) loadLabel) + str;
            strArr[i5] = str3;
            if (Intrinsics.areEqual(str3, this.appName)) {
                i4 = i5;
            }
            i5++;
        }
        if (i4 == 0) {
            String str4 = queryIntentActivities.get(i4).activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str4, "list[selectedIndex].activityInfo.packageName");
            this.packageName = str4;
            String str5 = strArr[0];
            Intrinsics.checkNotNull(str5);
            this.appName = str5;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(R.string.select_application);
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kd
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                OpenLastPhotoAction.Q(OpenLastPhotoAction.this, queryIntentActivities, strArr, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ld
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                OpenLastPhotoAction.R(OpenLastPhotoAction.this, dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.md
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                OpenLastPhotoAction.S(OpenLastPhotoAction.this, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.nd
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                OpenLastPhotoAction.T(OpenLastPhotoAction.this, dialogInterface);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        Uri lastPhoto = Util.getLastPhoto(getContext());
        if (lastPhoto != null) {
            Intent intent = new Intent("android.intent.action.VIEW", lastPhoto);
            intent.addFlags(268435456);
            intent.setPackage(this.packageName);
            getContext().startActivity(Intent.createChooser(intent, SelectableItem.r(R.string.action_open_last_photo)).addFlags(268435456));
            return;
        }
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("No photos found on device", macroGuid.longValue());
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.packageName);
        out.writeString(this.appName);
    }

    public OpenLastPhotoAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public OpenLastPhotoAction() {
        this.appName = "";
        this.packageName = "";
    }

    private OpenLastPhotoAction(Parcel parcel) {
        super(parcel);
        this.appName = "";
        this.packageName = "";
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        this.packageName = readString;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        this.appName = readString2;
    }

    /* compiled from: OpenLastPhotoAction.kt */
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
