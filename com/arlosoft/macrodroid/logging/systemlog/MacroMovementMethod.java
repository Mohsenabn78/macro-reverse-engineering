package com.arlosoft.macrodroid.logging.systemlog;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.URLDecoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: MacroMovementMethod.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MacroMovementMethod extends LinkMovementMethod {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f12676a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12677b;

    public MacroMovementMethod(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12676a = activity;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(@NotNull TextView widget, @NotNull Spannable buffer, @NotNull MotionEvent event) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(event, "event");
        int x3 = ((int) event.getX()) - widget.getTotalPaddingLeft();
        int y3 = ((int) event.getY()) - widget.getTotalPaddingTop();
        int scrollX = x3 + widget.getScrollX();
        int scrollY = y3 + widget.getScrollY();
        Layout layout = widget.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        URLSpan[] uRLSpanArr = (URLSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, URLSpan.class);
        if (uRLSpanArr.length > 0) {
            final Uri parse = Uri.parse(uRLSpanArr[0].getURL());
            String uri = parse.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) uri, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null);
            String substring = uri.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            try {
                substring = URLDecoder.decode(substring);
            } catch (Exception unused) {
            }
            Macro macroByName = MacroStore.getInstance().getMacroByName(substring);
            if (macroByName != null) {
                String categoryName = macroByName.getCategory();
                Cache cache = MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE);
                CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
                if (categoryList != null) {
                    Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
                    Category categoryByName = categoryList.getCategoryByName(categoryName);
                    if (categoryByName != null && categoryByName.isLocked() && !this.f12677b) {
                        if (event.getAction() == 1) {
                            CategoryPasswordHelper categoryPasswordHelper = new CategoryPasswordHelper(cache, null);
                            Activity activity = this.f12676a;
                            categoryPasswordHelper.promptForCategoryPassword(activity, activity.getString(R.string.enter_category_lock_password), categoryName, Settings.getLockedCategoryPassword(this.f12676a), 0, new CategoryPasswordHelper.PasswordListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.MacroMovementMethod$onTouchEvent$1
                                @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                                public void passwordCorrect() {
                                    Activity activity2;
                                    activity2 = MacroMovementMethod.this.f12676a;
                                    activity2.startActivity(new Intent("android.intent.action.VIEW", parse));
                                    MacroMovementMethod.this.f12677b = true;
                                }

                                @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                                public void passwordCancelled() {
                                }
                            });
                        }
                        return false;
                    }
                }
            }
        }
        return super.onTouchEvent(widget, buffer, event);
    }
}
