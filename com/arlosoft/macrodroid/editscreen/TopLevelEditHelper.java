package com.arlosoft.macrodroid.editscreen;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.LoopAction;
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.CopyHelper;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: TopLevelEditHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTopLevelEditHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopLevelEditHelper.kt\ncom/arlosoft/macrodroid/editscreen/TopLevelEditHelper\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n262#2,2:123\n1549#3:125\n1620#3,3:126\n*S KotlinDebug\n*F\n+ 1 TopLevelEditHelper.kt\ncom/arlosoft/macrodroid/editscreen/TopLevelEditHelper\n*L\n61#1:123,2\n117#1:125\n117#1:126,3\n*E\n"})
/* loaded from: classes3.dex */
public final class TopLevelEditHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f11865a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Boolean, Unit> f11866b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f11867c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f11868d;

    /* JADX WARN: Multi-variable type inference failed */
    public TopLevelEditHelper(@NotNull Activity activity, @NotNull Function1<? super Boolean, Unit> setHasEdited, @NotNull Function0<Unit> refresh, @NotNull Function0<Unit> refreshActions) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(setHasEdited, "setHasEdited");
        Intrinsics.checkNotNullParameter(refresh, "refresh");
        Intrinsics.checkNotNullParameter(refreshActions, "refreshActions");
        this.f11865a = activity;
        this.f11866b = setHasEdited;
        this.f11867c = refresh;
        this.f11868d = refreshActions;
    }

    private final void e(AppCompatDialog appCompatDialog, SelectableItem selectableItem, EditText editText) {
        Editable editable;
        selectableItem.setHasCommentEdited(true);
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        selectableItem.setComment(String.valueOf(editable));
        appCompatDialog.dismiss();
        this.f11866b.invoke(Boolean.TRUE);
        this.f11867c.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(TopLevelEditHelper this$0, AppCompatDialog dialog, SelectableItem item, EditText editText, TextView textView, int i4, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (i4 == 6) {
            this$0.e(dialog, item, editText);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(EditText editText, View view) {
        if (editText != null) {
            editText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TopLevelEditHelper this$0, AppCompatDialog dialog, SelectableItem item, EditText editText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.e(dialog, item, editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    public final void copyParentAction(@NotNull ParentAction parentAction, @NotNull Macro macro) {
        int i4;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(parentAction, "parentAction");
        Intrinsics.checkNotNullParameter(macro, "macro");
        ArrayList<Action> actions = macro.getActions();
        int indexOf = actions.indexOf(parentAction);
        if (parentAction instanceof IfConditionAction) {
            i4 = MacroListUtils.getEndIfIndex(actions, indexOf);
        } else if (parentAction instanceof LoopAction) {
            i4 = MacroListUtils.getEndLoopIndex(actions, indexOf);
        } else {
            i4 = 0;
        }
        IntRange intRange = new IntRange(indexOf, i4);
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(actions.get(((IntIterator) it).nextInt()));
        }
        CopyHelper.setCopiedItemList(arrayList);
    }

    public final void displayCommentDialog(@NotNull final SelectableItem item, @NotNull String title, boolean z3) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(title, "title");
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this.f11865a, getInvertDialogStyle(item));
        appCompatDialog.setContentView(R.layout.dialog_comment);
        appCompatDialog.setTitle(title);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, this.f11865a.getResources().getDimensionPixelOffset(R.dimen.margin_medium));
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        ImageButton imageButton = (ImageButton) appCompatDialog.findViewById(R.id.clear_button);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_comment_text);
        if (editText != null) {
            editText.setText(item.getComment());
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        if (z3 && imageButton != null) {
            imageButton.setVisibility(8);
        }
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.arlosoft.macrodroid.editscreen.d1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                    boolean f4;
                    f4 = TopLevelEditHelper.f(TopLevelEditHelper.this, appCompatDialog, item, editText, textView, i4, keyEvent);
                    return f4;
                }
            });
        }
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TopLevelEditHelper.g(editText, view);
                }
            });
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.f1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TopLevelEditHelper.h(TopLevelEditHelper.this, appCompatDialog, item, editText, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.g1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TopLevelEditHelper.i(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    public final void expandOrCollapseParentAction(@NotNull SelectableItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ParentAction parentAction = (ParentAction) item;
        parentAction.setChildrenCollapsed(!parentAction.getChildrenCollapsed());
        this.f11868d.invoke();
    }

    public final int getInvertDialogStyle(@NotNull SelectableItem selectableItem) {
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        if (selectableItem instanceof Trigger) {
            return R.style.Theme_App_Dialog_Invert_Trigger;
        }
        if (selectableItem instanceof Action) {
            return R.style.Theme_App_Dialog_Invert_Action;
        }
        return R.style.Theme_App_Dialog_Invert_Constraint;
    }

    public final void showHelpInfoDialog(@NotNull SelectableItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f11865a, getInvertDialogStyle(item));
        builder.setTitle(item.getName());
        if (item.getInfo().supportsAdbHack()) {
            builder.setMessage(Util.appendAdbHackInfo(this.f11865a, item.getHelpInfo()));
        } else {
            builder.setMessage(item.getHelpInfo());
        }
        builder.setNegativeButton(17039370, (DialogInterface.OnClickListener) null);
        Util.linkifyDialogText(builder.show());
    }
}
