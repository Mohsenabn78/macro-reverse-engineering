package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetWallpaperActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.io.IOException;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetWallpaperAction extends Action {
    public static final Parcelable.Creator<SetWallpaperAction> CREATOR = new a();
    public static final String EXTRA_ENCRYPTION_PASSWORD = "7K6HaF6h1zZLcQL1EAZQYUNkKnbLYafL";
    private static final int OPTION_HOME_AND_LOCK_SCREEN = 2;
    private static final int OPTION_HOME_SCREEN = 0;
    private static final int OPTION_IMAGE = 0;
    private static final int OPTION_LIVE_WALLPAPER = 1;
    private static final int OPTION_LOCK_SCREEN = 1;
    private static final int PHOTO_PICKER_ID = 1;
    private String m_imageName;
    private String m_liveWallpaperClassName;
    private String m_liveWallpaperName;
    private String m_liveWallpaperPackage;
    private int m_option;
    private int m_screenOption;
    private String m_wallpaperUriString;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetWallpaperAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetWallpaperAction createFromParcel(Parcel parcel) {
            return new SetWallpaperAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetWallpaperAction[] newArray(int i4) {
            return new SetWallpaperAction[i4];
        }
    }

    /* synthetic */ SetWallpaperAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static int T(BitmapFactory.Options options, int i4, int i5) {
        int i6 = options.outHeight;
        int i7 = options.outWidth;
        int i8 = 1;
        if (i6 > i5 || i7 > i4) {
            int i9 = i6 / 2;
            int i10 = i7 / 2;
            while (i9 / i8 > i5 && i10 / i8 > i4) {
                i8 *= 2;
            }
        }
        return i8;
    }

    private List<ResolveInfo> U() {
        List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent("android.service.wallpaper.WallpaperService"), 128);
        for (int i4 = 0; i4 < queryIntentServices.size(); i4++) {
            Log.i("TEST", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + queryIntentServices.get(i4).toString());
        }
        return queryIntentServices;
    }

    @RequiresApi(api = 24)
    private int V() {
        int i4 = this.m_screenOption;
        if (i4 == 0) {
            return 1;
        }
        if (i4 != 1) {
            return 3;
        }
        return 2;
    }

    private String[] W() {
        return new String[]{SelectableItem.r(R.string.home_screen), SelectableItem.r(R.string.lock_screen), SelectableItem.r(R.string.home_and_lock_screen)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(String[] strArr, String[] strArr2, String[] strArr3, DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        this.m_liveWallpaperPackage = strArr[checkedItemPosition];
        this.m_liveWallpaperName = strArr2[checkedItemPosition];
        this.m_liveWallpaperClassName = strArr3[checkedItemPosition];
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        e0(U());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i4) {
        this.m_screenOption = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (this.m_option == 0) {
            f0();
        } else {
            j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private void e0(List<ResolveInfo> list) {
        if (list.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_live_wallpapers_found, 0).show();
            return;
        }
        final String[] strArr = new String[list.size()];
        final String[] strArr2 = new String[list.size()];
        final String[] strArr3 = new String[list.size()];
        int size = list.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = list.get(i5);
            if (resolveInfo.serviceInfo != null) {
                strArr[i5] = resolveInfo.loadLabel(getContext().getPackageManager()).toString();
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                strArr2[i5] = serviceInfo.packageName;
                strArr3[i5] = serviceInfo.name;
                String str = this.m_liveWallpaperPackage;
                if (str != null && str.equals(strArr2[i5])) {
                    i4 = i5;
                }
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.em
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SetWallpaperAction.this.Y(strArr2, strArr, strArr3, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.fm
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SetWallpaperAction.this.Z(dialogInterface);
            }
        });
    }

    private void f0() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType(ImageUtils.MIME_TYPE_IMAGE_WILDCARD);
        try {
            getActivity().startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_app_available, 0).show();
        }
    }

    private Bitmap g0(Bitmap bitmap, int i4) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i4);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.image), SelectableItem.r(R.string.live_wallpaper)};
    }

    @RequiresApi(api = 24)
    private Bitmap h0(Bitmap bitmap, Uri uri) throws IOException {
        int attributeInt = new ExifInterface(getContext().getContentResolver().openInputStream(uri)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                if (attributeInt != 8) {
                    return bitmap;
                }
                return g0(bitmap, 270);
            }
            return g0(bitmap, 90);
        }
        return g0(bitmap, 180);
    }

    private Bitmap i0(Bitmap bitmap, String str) throws IOException {
        int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                if (attributeInt != 8) {
                    return bitmap;
                }
                return g0(bitmap, 270);
            }
            return g0(bitmap, 90);
        }
        return g0(bitmap, 180);
    }

    private void j0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.live_wallpaper_warning).setTitle(R.string.action_set_wallpaper).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.cm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetWallpaperAction.this.a0(dialogInterface, i4);
            }
        });
        builder.show();
    }

    private void k0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(W(), this.m_screenOption, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zl
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetWallpaperAction.this.b0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.am
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetWallpaperAction.this.c0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.bm
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SetWallpaperAction.this.d0(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_option;
        if (i4 == 0) {
            String str = this.m_wallpaperUriString;
            if (str != null) {
                int lastIndexOf = str.lastIndexOf("//");
                if (lastIndexOf == -1) {
                    return this.m_wallpaperUriString;
                }
                return this.m_wallpaperUriString.substring(lastIndexOf + 2);
            }
            return "";
        } else if (i4 == 1) {
            return this.m_liveWallpaperName;
        } else {
            return "";
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetWallpaperActionInfo.getInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleActivityResult(android.app.Activity r4, int r5, int r6, android.content.Intent r7) {
        /*
            r3 = this;
            r3.setActivity(r4)
            r0 = 1
            if (r5 != r0) goto Lb9
            r5 = -1
            if (r6 != r5) goto Lb9
            android.net.Uri r6 = r7.getData()
            java.lang.String r6 = r6.toString()
            r3.m_wallpaperUriString = r6
            java.util.UUID r6 = java.util.UUID.randomUUID()
            long r6 = r6.getLeastSignificantBits()
            long r6 = java.lang.Math.abs(r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r3.m_imageName = r6
            r6 = 0
            r7 = 0
            android.content.Context r0 = r3.getContext()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.lang.String r1 = r3.m_wallpaperUriString     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.io.InputStream r0 = r0.openInputStream(r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.lang.String r1 = r3.m_imageName     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.io.FileOutputStream r6 = r4.openFileOutput(r1, r7)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
        L43:
            int r1 = r0.read(r4)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r1 == r5) goto L4d
            r6.write(r4, r7, r1)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            goto L43
        L4d:
            if (r6 == 0) goto L52
            r6.close()     // Catch: java.lang.Exception -> L52
        L52:
            r0.close()     // Catch: java.lang.Exception -> La5
            goto La5
        L56:
            r4 = move-exception
            goto Lac
        L58:
            r4 = move-exception
            r5 = r6
            r6 = r0
            goto L61
        L5c:
            r4 = move-exception
            r0 = r6
            goto Lac
        L5f:
            r4 = move-exception
            r5 = r6
        L61:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La9
            r0.<init>()     // Catch: java.lang.Throwable -> La9
            java.lang.String r1 = "Failed to set wallpaper: "
            r0.append(r1)     // Catch: java.lang.Throwable -> La9
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> La9
            r0.append(r1)     // Catch: java.lang.Throwable -> La9
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La9
            java.lang.Long r1 = r3.getMacroGuid()     // Catch: java.lang.Throwable -> La9
            long r1 = r1.longValue()     // Catch: java.lang.Throwable -> La9
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r0, r1)     // Catch: java.lang.Throwable -> La9
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r4)     // Catch: java.lang.Throwable -> La9
            android.content.Context r4 = r3.getContext()     // Catch: java.lang.Throwable -> La9
            r0 = 2131952277(0x7f130295, float:1.9540992E38)
            java.lang.String r0 = com.arlosoft.macrodroid.common.SelectableItem.r(r0)     // Catch: java.lang.Throwable -> La9
            r1 = 2131952279(0x7f130297, float:1.9540996E38)
            java.lang.String r1 = com.arlosoft.macrodroid.common.SelectableItem.r(r1)     // Catch: java.lang.Throwable -> La9
            com.arlosoft.macrodroid.common.Util.displayNotification(r4, r0, r1, r7)     // Catch: java.lang.Throwable -> La9
            if (r5 == 0) goto La0
            r5.close()     // Catch: java.lang.Exception -> L9f
            goto La0
        L9f:
        La0:
            if (r6 == 0) goto La5
            r6.close()     // Catch: java.lang.Exception -> La5
        La5:
            r3.itemComplete()
            goto Lb9
        La9:
            r4 = move-exception
            r0 = r6
            r6 = r5
        Lac:
            if (r6 == 0) goto Lb3
            r6.close()     // Catch: java.lang.Exception -> Lb2
            goto Lb3
        Lb2:
        Lb3:
            if (r0 == 0) goto Lb8
            r0.close()     // Catch: java.lang.Exception -> Lb8
        Lb8:
            throw r4
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetWallpaperAction.handleActivityResult(android.app.Activity, int, int, android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        super.handleItemSelected();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01a8 A[Catch: Exception -> 0x0235, FileNotFoundException -> 0x0257, TryCatch #5 {FileNotFoundException -> 0x0257, Exception -> 0x0235, blocks: (B:13:0x006b, B:15:0x0080, B:43:0x01d4, B:45:0x01fa, B:47:0x0204, B:49:0x0219, B:50:0x021d, B:51:0x0225, B:53:0x0229, B:54:0x022d, B:16:0x00c9, B:19:0x00dd, B:21:0x00e5, B:27:0x0122, B:40:0x01a8, B:38:0x017a, B:22:0x00fc, B:24:0x0104, B:26:0x010c), top: B:67:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d3  */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r13) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetWallpaperAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (Build.VERSION.SDK_INT >= 24 && this.m_option == 0) {
            k0();
        } else if (this.m_option == 0) {
            f0();
        } else {
            j0();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_wallpaperUriString);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_screenOption);
        parcel.writeString(this.m_liveWallpaperName);
        parcel.writeString(this.m_liveWallpaperPackage);
        parcel.writeString(this.m_liveWallpaperClassName);
        parcel.writeString(this.m_imageName);
    }

    public SetWallpaperAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetWallpaperAction() {
    }

    private SetWallpaperAction(Parcel parcel) {
        super(parcel);
        this.m_wallpaperUriString = parcel.readString();
        this.m_option = parcel.readInt();
        this.m_screenOption = parcel.readInt();
        this.m_liveWallpaperName = parcel.readString();
        this.m_liveWallpaperPackage = parcel.readString();
        this.m_liveWallpaperClassName = parcel.readString();
        this.m_imageName = parcel.readString();
    }
}
