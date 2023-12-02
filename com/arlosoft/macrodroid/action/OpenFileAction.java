package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.OpenFileActionInfo;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MimeTypes;
import com.arlosoft.macrodroid.utils.UriHelper;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.util.Collections;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenFileAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class OpenFileAction extends FileSelectionAction {
    private static final int PICKER_ID_FILE = 2;
    private static final int PICKER_ID_FOLDER = 1;
    @Nullable
    private transient TextView dirText;
    @Nullable
    private String dynamicPathUri;
    @Nullable
    private String m_appName;
    @Nullable
    private String m_className;
    @Nullable
    private String m_fileDisplayName;
    @Nullable
    private String m_fileUri;
    @Nullable
    private transient MimeTypes m_mimeTypes;
    @Nullable
    private String m_packageName;
    @Nullable
    private String pathName;
    @Nullable
    private transient TextView staticFilenameText;
    @Nullable
    private transient String tempAppName;
    @Nullable
    private transient String temporaryPathName;
    private boolean useStaticFilename;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<OpenFileAction> CREATOR = new Parcelable.Creator<OpenFileAction>() { // from class: com.arlosoft.macrodroid.action.OpenFileAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OpenFileAction createFromParcel(@NotNull Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new OpenFileAction(in, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OpenFileAction[] newArray(int i4) {
            return new OpenFileAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OpenFileAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $filenameEditText;
        final /* synthetic */ Button $okButton;
        final /* synthetic */ RadioButton $radioButtonStatic;
        final /* synthetic */ ViewFlipper $viewFlipper;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ OpenFileAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ViewFlipper viewFlipper, OpenFileAction openFileAction, Button button, RadioButton radioButton, EditText editText, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$viewFlipper = viewFlipper;
            this.this$0 = openFileAction;
            this.$okButton = button;
            this.$radioButtonStatic = radioButton;
            this.$filenameEditText = editText;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$viewFlipper, this.this$0, this.$okButton, this.$radioButtonStatic, this.$filenameEditText, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x005c, code lost:
            if (r0.length() > 0) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x005f, code lost:
            r1 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
            r5.setEnabled(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0047, code lost:
            if (r2.length() > 0) goto L8;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r4.label
                if (r0 != 0) goto L66
                kotlin.ResultKt.throwOnFailure(r5)
                boolean r5 = r4.Z$0
                android.widget.ViewFlipper r0 = r4.$viewFlipper
                r1 = 1
                r5 = r5 ^ r1
                r0.setDisplayedChild(r5)
                com.arlosoft.macrodroid.action.OpenFileAction r5 = r4.this$0
                android.widget.TextView r5 = com.arlosoft.macrodroid.action.OpenFileAction.access$getStaticFilenameText$p(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                java.lang.CharSequence r5 = r5.getText()
                java.lang.String r0 = "staticFilenameText!!.text"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                r5.length()
                android.widget.Button r5 = r4.$okButton
                android.widget.RadioButton r2 = r4.$radioButtonStatic
                boolean r2 = r2.isChecked()
                r3 = 0
                if (r2 == 0) goto L4a
                com.arlosoft.macrodroid.action.OpenFileAction r2 = r4.this$0
                android.widget.TextView r2 = com.arlosoft.macrodroid.action.OpenFileAction.access$getStaticFilenameText$p(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                java.lang.CharSequence r2 = r2.getText()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                int r0 = r2.length()
                if (r0 <= 0) goto L5f
                goto L60
            L4a:
                android.widget.EditText r0 = r4.$filenameEditText
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                android.text.Editable r0 = r0.getText()
                java.lang.String r2 = "filenameEditText!!.text"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                int r0 = r0.length()
                if (r0 <= 0) goto L5f
                goto L60
            L5f:
                r1 = 0
            L60:
                r5.setEnabled(r1)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L66:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.OpenFileAction.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OpenFileAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $appNameText;
        final /* synthetic */ EditText $filenameEditText;
        final /* synthetic */ RadioButton $radioButtonDynamic;
        final /* synthetic */ RadioButton $radioButtonStatic;
        int label;
        final /* synthetic */ OpenFileAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RadioButton radioButton, OpenFileAction openFileAction, EditText editText, RadioButton radioButton2, TextView textView, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$radioButtonStatic = radioButton;
            this.this$0 = openFileAction;
            this.$filenameEditText = editText;
            this.$radioButtonDynamic = radioButton2;
            this.$appNameText = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$radioButtonStatic, this.this$0, this.$filenameEditText, this.$radioButtonDynamic, this.$appNameText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String obj2;
            boolean z3;
            CharSequence charSequence;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$radioButtonStatic.isChecked()) {
                    TextView textView = this.this$0.staticFilenameText;
                    Intrinsics.checkNotNull(textView);
                    obj2 = textView.getText().toString();
                } else {
                    obj2 = this.$filenameEditText.getText().toString();
                }
                if (obj2.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    ToastCompat.makeText(this.this$0.getContext(), (int) R.string.select_filename_before_choosing_app, 1).show();
                } else {
                    if (this.$radioButtonDynamic.isChecked()) {
                        TextView textView2 = this.this$0.dirText;
                        if (textView2 != null) {
                            charSequence = textView2.getText();
                        } else {
                            charSequence = null;
                        }
                        String r4 = SelectableItem.r(R.string.action_write_to_file_select_folder);
                        if (Intrinsics.areEqual(charSequence, "<" + r4 + ">")) {
                            ToastCompat.makeText(this.this$0.getContext(), (int) R.string.action_write_to_file_select_folder, 1).show();
                        }
                    }
                    this.this$0.h0(this.$appNameText, this.$radioButtonStatic.isChecked(), obj2);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ OpenFileAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void W() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.setType("*/*");
            getActivity().startActivityForResult(intent, 2);
            Context applicationContext = getContext().getApplicationContext();
            String r4 = SelectableItem.r(R.string.select_file);
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + r4 + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            String r5 = SelectableItem.r(R.string.not_supported);
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT" + r5), 0).show();
        }
    }

    private final void X() {
        try {
            getActivity().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 1);
            Context applicationContext = getContext().getApplicationContext();
            String r4 = SelectableItem.r(R.string.action_write_to_file_select_folder);
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + r4 + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            String r5 = SelectableItem.r(R.string.not_supported);
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT_TREE " + r5), 0).show();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x01db, code lost:
        if (r0.length() > 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01eb, code lost:
        if (r0.length() > 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01ed, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x01ef, code lost:
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void Y() {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.OpenFileAction.Y():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(OpenFileAction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(OpenFileAction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(OpenFileAction this$0, RadioButton radioButtonStatic, AppCompatDialog dialog, EditText filenameEditText, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioButtonStatic, "$radioButtonStatic");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(filenameEditText, "$filenameEditText");
        String str = this$0.tempAppName;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.select_application, 1).show();
            return;
        }
        if (!radioButtonStatic.isChecked() && this$0.temporaryPathName == null) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.action_write_to_file_select_folder, 1).show();
        } else {
            this$0.pathName = this$0.temporaryPathName;
            dialog.dismiss();
            if (radioButtonStatic.isChecked()) {
                TextView textView = this$0.staticFilenameText;
                Intrinsics.checkNotNull(textView);
                this$0.m_fileDisplayName = textView.getText().toString();
            } else {
                this$0.m_fileDisplayName = filenameEditText.getText().toString();
            }
            this$0.useStaticFilename = radioButtonStatic.isChecked();
            this$0.itemComplete();
        }
        this$0.dirText = null;
        this$0.temporaryPathName = null;
        this$0.staticFilenameText = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(OpenFileAction this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.dirText = null;
        this$0.temporaryPathName = null;
        this$0.staticFilenameText = null;
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(OpenFileAction this$0, AppCompatDialog dialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.dirText = null;
        this$0.temporaryPathName = null;
        this$0.staticFilenameText = null;
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(EditText filenameEditText, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(filenameEditText, "$filenameEditText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(filenameEditText.getSelectionStart(), 0);
        int max2 = Math.max(filenameEditText.getSelectionEnd(), 0);
        Editable text = filenameEditText.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Activity activity, MagicText.MagicTextListener filenameMagicTextListener, OpenFileAction this$0, View view) {
        Intrinsics.checkNotNullParameter(filenameMagicTextListener, "$filenameMagicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, filenameMagicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    private final Intent g0(boolean z3, TriggerContextInfo triggerContextInfo) {
        String str;
        DocumentFile findFile;
        String str2;
        String replaceMagicText;
        StringBuilder sb;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (z3) {
            String str3 = this.m_packageName;
            Intrinsics.checkNotNull(str3);
            String str4 = this.m_className;
            Intrinsics.checkNotNull(str4);
            intent.setClassName(str3, str4);
        } else {
            intent.setPackage(this.m_packageName);
        }
        if (this.m_filePath != null) {
            File file = new File(this.m_filePath);
            MimeTypes mimeTypes = this.m_mimeTypes;
            Intrinsics.checkNotNull(mimeTypes);
            intent.setDataAndType(Uri.fromFile(file), mimeTypes.getMimeType(this.m_filePath));
        } else {
            if (this.useStaticFilename) {
                str = this.m_fileUri;
            } else {
                str = this.dynamicPathUri;
            }
            Uri parse = Uri.parse(str);
            if (this.useStaticFilename) {
                findFile = DocumentFile.fromSingleUri(getContext(), parse);
            } else {
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), parse);
                String replaceMagicText2 = MagicText.replaceMagicText(getContext(), this.m_fileDisplayName, triggerContextInfo, getMacro());
                Intrinsics.checkNotNull(fromTreeUri);
                findFile = fromTreeUri.findFile(replaceMagicText2);
            }
            if (findFile != null && findFile.exists()) {
                MimeTypes mimeTypes2 = this.m_mimeTypes;
                Intrinsics.checkNotNull(mimeTypes2);
                intent.setDataAndType(findFile.getUri(), mimeTypes2.getMimeType(findFile.getUri()));
                intent.setData(findFile.getUri());
                intent.addFlags(1);
            } else {
                if (this.useStaticFilename) {
                    str2 = this.pathName;
                    replaceMagicText = this.m_fileDisplayName;
                    sb = new StringBuilder();
                } else {
                    str2 = this.pathName;
                    replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_fileDisplayName, triggerContextInfo, getMacro());
                    sb = new StringBuilder();
                }
                sb.append(str2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(replaceMagicText);
                String sb2 = sb.toString();
                Util.displayNotification(getContext(), "Open File Failed", "Could not launch " + sb2, false);
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("File not found: " + sb2, macroGuid.longValue());
                return null;
            }
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List, T, java.lang.Object] */
    public final void h0(final TextView textView, boolean z3, String str) {
        String str2;
        DocumentFile findFile;
        String str3;
        PackageManager packageManager = getContext().getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        if (z3) {
            str2 = this.m_fileUri;
        } else {
            str2 = this.dynamicPathUri;
        }
        Uri parse = Uri.parse(str2);
        if (z3) {
            findFile = DocumentFile.fromSingleUri(getContext(), parse);
        } else {
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), parse);
            String replaceMagicText = MagicText.replaceMagicText(getContext(), str, null, getMacro());
            Intrinsics.checkNotNull(fromTreeUri);
            findFile = fromTreeUri.findFile(replaceMagicText);
        }
        if (findFile != null) {
            intent.setData(Uri.parse(findFile.getUri().toString()));
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int i4 = 0;
        ?? queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, 0)");
        objectRef.element = queryIntentActivities;
        if (queryIntentActivities == 0 || ((List) queryIntentActivities).size() == 0) {
            intent.setData(null);
            ?? queryIntentActivities2 = packageManager.queryIntentActivities(intent, 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities2, "packageManager.queryIntentActivities(intent, 0)");
            objectRef.element = queryIntentActivities2;
            if (queryIntentActivities2 == 0 || ((List) queryIntentActivities2).size() == 0) {
                Util.displayErrorDialog(getActivity(), "Cannot Open File", "No applications have been found that can open the specified file.");
                return;
            }
        }
        Collections.sort((List) objectRef.element, new ResolveInfo.DisplayNameComparator(packageManager));
        final String[] strArr = new String[((List) objectRef.element).size()];
        int i5 = 0;
        for (ResolveInfo resolveInfo : (List) objectRef.element) {
            CharSequence loadLabel = resolveInfo.loadLabel(packageManager);
            String str4 = resolveInfo.activityInfo.targetActivity;
            if (str4 != null) {
                str3 = " (" + str4 + ")";
            } else {
                str3 = "";
            }
            String str5 = ((Object) loadLabel) + str3;
            strArr[i5] = str5;
            if (Intrinsics.areEqual(str5, this.m_appName)) {
                i4 = i5;
            }
            i5++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_application);
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.hd
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                OpenFileAction.i0(OpenFileAction.this, dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.id
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                OpenFileAction.j0(OpenFileAction.this, objectRef, strArr, textView, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.jd
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                OpenFileAction.k0(OpenFileAction.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(OpenFileAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    private final void init() {
        this.m_mimeTypes = new MimeTypes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(OpenFileAction this$0, Ref.ObjectRef list, String[] apps, TextView appNameText, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(apps, "$apps");
        Intrinsics.checkNotNullParameter(appNameText, "$appNameText");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        this$0.m_packageName = ((ResolveInfo) ((List) list.element).get(checkedItemPosition)).activityInfo.packageName;
        this$0.m_className = ((ResolveInfo) ((List) list.element).get(checkedItemPosition)).activityInfo.name;
        String str = apps[checkedItemPosition];
        this$0.m_appName = str;
        appNameText.setText(str);
        this$0.tempAppName = this$0.m_appName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(OpenFileAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        boolean contains$default;
        int lastIndexOf$default;
        String str = this.m_fileDisplayName;
        if (!TextUtils.isEmpty(str)) {
            String r4 = SelectableItem.r(R.string.action_open_file);
            return r4 + ": " + str;
        } else if (this.m_fileUri != null) {
            String r5 = SelectableItem.r(R.string.action_open_file);
            String str2 = this.m_fileUri;
            return r5 + ": " + str2;
        } else {
            String m_filePath = this.m_filePath;
            if (m_filePath == null) {
                String r6 = SelectableItem.r(R.string.error);
                Intrinsics.checkNotNullExpressionValue(r6, "{\n            getString(R.string.error)\n        }");
                return r6;
            }
            Intrinsics.checkNotNullExpressionValue(m_filePath, "m_filePath");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) m_filePath, (CharSequence) RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null);
            if (contains$default) {
                String r7 = SelectableItem.r(R.string.action_open_file);
                String m_filePath2 = this.m_filePath;
                Intrinsics.checkNotNullExpressionValue(m_filePath2, "m_filePath");
                String m_filePath3 = this.m_filePath;
                Intrinsics.checkNotNullExpressionValue(m_filePath3, "m_filePath");
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) m_filePath3, '/', 0, false, 6, (Object) null);
                String substring = m_filePath2.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return r7 + ": " + substring;
            }
            String r8 = SelectableItem.r(R.string.action_open_file);
            String str3 = this.m_filePath;
            return r8 + ": " + str3;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.m_appName;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo openFileActionInfo = OpenFileActionInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(openFileActionInfo, "getInstance()");
        return openFileActionInfo;
    }

    @Override // com.arlosoft.macrodroid.action.FileSelectionAction, com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i5 == -1) {
            Uri uri = null;
            if (i4 != 1) {
                if (i4 == 2) {
                    Intrinsics.checkNotNull(intent);
                    Uri data = intent.getData();
                    try {
                        ContentResolver contentResolver = getContext().getContentResolver();
                        Intrinsics.checkNotNull(data);
                        contentResolver.takePersistableUriPermission(data, 3);
                    } catch (Throwable unused) {
                    }
                    this.m_fileUri = String.valueOf(data);
                    this.m_filePath = null;
                    String displayNameFromUri = UriHelper.getDisplayNameFromUri(getContext(), data);
                    this.m_fileDisplayName = displayNameFromUri;
                    TextView textView = this.staticFilenameText;
                    if (textView != null) {
                        textView.setText(displayNameFromUri);
                        return;
                    }
                    return;
                }
                return;
            }
            if (intent != null) {
                uri = intent.getData();
            }
            this.m_fileUri = String.valueOf(uri);
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNull(uri);
            contentResolver2.takePersistableUriPermission(uri, 1);
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), uri);
            Intrinsics.checkNotNull(fromTreeUri);
            DocumentFile parentFile = fromTreeUri.getParentFile();
            this.dynamicPathUri = uri.toString();
            if (parentFile != null) {
                str = parentFile.getName();
            } else {
                str = "";
            }
            String str2 = str + RemoteSettings.FORWARD_SLASH_STRING + fromTreeUri.getName();
            this.temporaryPathName = str2;
            TextView textView2 = this.dirText;
            if (textView2 != null) {
                textView2.setText(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Y();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        try {
            Intent g02 = g0(true, triggerContextInfo);
            if (g02 != null) {
                getContext().startActivity(g02);
            }
        } catch (Exception unused) {
            try {
                Intent g03 = g0(false, triggerContextInfo);
                if (g03 != null) {
                    getContext().startActivity(g03);
                }
            } catch (Exception e4) {
                String str = "Open File Failed, could not launch " + this.m_appName + ": " + e4;
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError(str, macroGuid.longValue());
                Util.displayNotification(getContext(), "Open File Failed", "Could not launch " + this.m_appName, false);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.m_appName != null && this.m_className != null && this.m_fileDisplayName != null && (this.m_fileUri != null || this.m_filePath != null || this.dynamicPathUri != null)) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.m_filePath);
        out.writeString(this.m_packageName);
        out.writeString(this.m_className);
        out.writeString(this.m_appName);
        out.writeString(this.m_fileUri);
        out.writeString(this.m_fileDisplayName);
        out.writeString(this.dynamicPathUri);
        out.writeString(this.pathName);
        out.writeInt(this.useStaticFilename ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpenFileAction(@Nullable Activity activity, @NotNull Macro macro) {
        this();
        Intrinsics.checkNotNullParameter(macro, "macro");
        setActivity(activity);
        this.m_macro = macro;
    }

    private OpenFileAction() {
        this.useStaticFilename = true;
        init();
    }

    private OpenFileAction(Parcel parcel) {
        super(parcel);
        this.useStaticFilename = true;
        init();
        this.m_filePath = parcel.readString();
        this.m_packageName = parcel.readString();
        this.m_className = parcel.readString();
        this.m_appName = parcel.readString();
        this.m_fileUri = parcel.readString();
        this.m_fileDisplayName = parcel.readString();
        this.dynamicPathUri = parcel.readString();
        this.pathName = parcel.readString();
        this.useStaticFilename = parcel.readInt() != 0;
    }

    /* compiled from: OpenFileAction.kt */
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
