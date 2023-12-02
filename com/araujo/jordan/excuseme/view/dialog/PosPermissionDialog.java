package com.araujo.jordan.excuseme.view.dialog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import com.araujo.jordan.excuseme.R;
import com.araujo.jordan.excuseme.utils.DesignUtils;
import com.araujo.jordan.excuseme.view.InvisibleActivity;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PosPermissionDialog.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b$\u0010%B)\b\u0016\u0012\u0006\u0010&\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b$\u0010(B>\b\u0016\u00123\u0010)\u001a/\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b$\u0010*J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007RE\u0010\u0014\u001a1\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/araujo/jordan/excuseme/view/dialog/PosPermissionDialog;", "Lcom/araujo/jordan/excuseme/view/dialog/ExcuseMeDialog;", "Lcom/araujo/jordan/excuseme/view/InvisibleActivity;", "act", "", "showDialogForPermission", "(Lcom/araujo/jordan/excuseme/view/InvisibleActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "denied", "", "setPermissions", "Lkotlin/Function2;", "Lcom/araujo/jordan/excuseme/view/dialog/DialogType;", "Lkotlin/ParameterName;", "name", "type", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function2;", "customRequest", "g", "Ljava/lang/String;", "titleShowSettings", "h", "reasonShowSettings", "i", "Ljava/util/List;", "deniedPermissions", "j", "Lcom/araujo/jordan/excuseme/view/dialog/DialogType;", "getDialogType", "()Lcom/araujo/jordan/excuseme/view/dialog/DialogType;", "setDialogType", "(Lcom/araujo/jordan/excuseme/view/dialog/DialogType;)V", "dialogType", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "titleAskAgain", "reasonAskAgain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "customDialogRequest", "(Lkotlin/jvm/functions/Function2;)V", "excuseme_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class PosPermissionDialog extends ExcuseMeDialog {

    /* renamed from: f  reason: collision with root package name */
    private Function2<? super DialogType, ? super Function1<? super Boolean, Unit>, Unit> f1931f;

    /* renamed from: g  reason: collision with root package name */
    private String f1932g;

    /* renamed from: h  reason: collision with root package name */
    private String f1933h;

    /* renamed from: i  reason: collision with root package name */
    private List<String> f1934i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private DialogType f1935j;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DialogType.values().length];
            $EnumSwitchMapping$0 = iArr;
            DialogType dialogType = DialogType.EXPLAIN_AGAIN;
            iArr[dialogType.ordinal()] = 1;
            DialogType dialogType2 = DialogType.SHOW_SETTINGS;
            iArr[dialogType2.ordinal()] = 2;
            int[] iArr2 = new int[DialogType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[dialogType.ordinal()] = 1;
            iArr2[dialogType2.ordinal()] = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PosPermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "", "invoke"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            PosPermissionDialog.this.a(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PosPermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PosPermissionDialog.this.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PosPermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PosPermissionDialog.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PosPermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            PosPermissionDialog.this.a(false);
        }
    }

    public PosPermissionDialog() {
        super(false);
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f1934i = emptyList;
        this.f1935j = DialogType.EXPLAIN_AGAIN;
    }

    @NotNull
    public final DialogType getDialogType() {
        return this.f1935j;
    }

    public final void setDialogType(@NotNull DialogType dialogType) {
        Intrinsics.checkParameterIsNotNull(dialogType, "<set-?>");
        this.f1935j = dialogType;
    }

    public final void setPermissions(@NotNull List<String> denied) {
        Intrinsics.checkParameterIsNotNull(denied, "denied");
        this.f1934i = denied;
    }

    @Override // com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog
    @SuppressLint({"InflateParams"})
    @Nullable
    public Object showDialogForPermission(@NotNull InvisibleActivity invisibleActivity, @NotNull Continuation<? super Boolean> continuation) {
        Object obj;
        DialogType dialogType;
        String c4;
        String d4;
        Iterator<T> it = this.f1934i.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Boxing.boxBoolean(ActivityCompat.shouldShowRequestPermissionRationale(invisibleActivity, (String) obj)).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj instanceof String) {
            dialogType = DialogType.EXPLAIN_AGAIN;
        } else {
            dialogType = DialogType.SHOW_SETTINGS;
        }
        this.f1935j = dialogType;
        Function2<? super DialogType, ? super Function1<? super Boolean, Unit>, Unit> function2 = this.f1931f;
        if (function2 != null) {
            if (function2 != null) {
                function2.mo1invoke(dialogType, new a());
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(invisibleActivity);
            View v3 = invisibleActivity.getLayoutInflater().inflate(R.layout.dialog_gently_ask, (ViewGroup) null);
            Intrinsics.checkExpressionValueIsNotNull(v3, "v");
            int i4 = R.id.excuseMeGentlyTitle;
            TextView textView = (TextView) v3.findViewById(i4);
            if (textView != null) {
                int i5 = WhenMappings.$EnumSwitchMapping$0[this.f1935j.ordinal()];
                if (i5 != 1) {
                    if (i5 == 2) {
                        d4 = this.f1932g;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    d4 = d();
                }
                textView.setText(d4);
            }
            int i6 = R.id.excuseMeGentlyDescriptionText;
            TextView textView2 = (TextView) v3.findViewById(i6);
            if (textView2 != null) {
                int i7 = WhenMappings.$EnumSwitchMapping$1[this.f1935j.ordinal()];
                if (i7 != 1) {
                    if (i7 == 2) {
                        c4 = this.f1933h;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    c4 = c();
                }
                textView2.setText(c4);
            }
            int i8 = R.id.excuseMeGentlyYesBtn;
            Button button = (Button) v3.findViewById(i8);
            if (button != null) {
                button.setOnClickListener(new b());
            }
            Button button2 = (Button) v3.findViewById(i8);
            if (button2 != null) {
                button2.setTextColor(DesignUtils.Companion.resolveColor(invisibleActivity, "colorPrimaryDark"));
            }
            int i9 = R.id.excuseMeGentlyNoBtn;
            Button button3 = (Button) v3.findViewById(i9);
            if (button3 != null) {
                button3.setTextColor(DesignUtils.Companion.resolveColor(invisibleActivity, "colorPrimaryDark"));
            }
            TextView textView3 = (TextView) v3.findViewById(i4);
            if (textView3 != null) {
                textView3.setBackgroundColor(DesignUtils.Companion.resolveColor(invisibleActivity, "colorPrimary"));
            }
            TextView textView4 = (TextView) v3.findViewById(i6);
            if (textView4 != null) {
                textView4.setTextColor(DesignUtils.Companion.resolveColor(invisibleActivity, "#0c0c0c"));
            }
            Button button4 = (Button) v3.findViewById(i9);
            if (button4 != null) {
                button4.setOnClickListener(new c());
            }
            builder.setOnCancelListener(new d());
            builder.setView(v3);
            builder.setCancelable(false);
            e(builder.show());
        }
        return super.showDialogForPermission(invisibleActivity, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PosPermissionDialog(@NotNull String titleAskAgain, @NotNull String reasonAskAgain, @NotNull String titleShowSettings, @NotNull String reasonShowSettings) {
        super(titleAskAgain, reasonAskAgain);
        List<String> emptyList;
        Intrinsics.checkParameterIsNotNull(titleAskAgain, "titleAskAgain");
        Intrinsics.checkParameterIsNotNull(reasonAskAgain, "reasonAskAgain");
        Intrinsics.checkParameterIsNotNull(titleShowSettings, "titleShowSettings");
        Intrinsics.checkParameterIsNotNull(reasonShowSettings, "reasonShowSettings");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f1934i = emptyList;
        this.f1935j = DialogType.EXPLAIN_AGAIN;
        this.f1932g = titleShowSettings;
        this.f1933h = reasonShowSettings;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PosPermissionDialog(@NotNull Function2<? super DialogType, ? super Function1<? super Boolean, Unit>, Unit> customDialogRequest) {
        super(true);
        List<String> emptyList;
        Intrinsics.checkParameterIsNotNull(customDialogRequest, "customDialogRequest");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f1934i = emptyList;
        this.f1935j = DialogType.EXPLAIN_AGAIN;
        this.f1931f = customDialogRequest;
    }
}
