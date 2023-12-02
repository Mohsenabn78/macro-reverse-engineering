package com.firebase.ui.auth.util.ui;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class PreambleHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18235a;

    /* renamed from: b  reason: collision with root package name */
    private final FlowParameters f18236b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18237c;

    /* renamed from: d  reason: collision with root package name */
    private final ForegroundColorSpan f18238d;

    /* renamed from: e  reason: collision with root package name */
    private SpannableStringBuilder f18239e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class CustomTabsSpan extends URLSpan {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Context> f18240a;

        /* renamed from: b  reason: collision with root package name */
        private final String f18241b;

        /* renamed from: c  reason: collision with root package name */
        private final CustomTabsIntent f18242c;

        public CustomTabsSpan(Context context, String str) {
            super(str);
            this.f18240a = new WeakReference<>(context);
            this.f18241b = str;
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            this.f18242c = new CustomTabsIntent.Builder().setToolbarColor(typedValue.data).setShowTitle(true).build();
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            Context context = this.f18240a.get();
            if (context != null) {
                this.f18242c.launchUrl(context, Uri.parse(this.f18241b));
            }
        }
    }

    private PreambleHandler(Context context, FlowParameters flowParameters, @StringRes int i4) {
        this.f18235a = context;
        this.f18236b = flowParameters;
        this.f18237c = i4;
        this.f18238d = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.fui_linkColor));
    }

    @Nullable
    private String a(@StringRes int i4, boolean z3) {
        boolean z4 = !TextUtils.isEmpty(this.f18236b.termsOfServiceUrl);
        boolean z5 = !TextUtils.isEmpty(this.f18236b.privacyPolicyUrl);
        if (z4 && z5) {
            return this.f18235a.getString(i4, z3 ? new Object[]{"%BTN%", "%TOS%", "%PP%"} : new Object[]{"%TOS%", "%PP%"});
        }
        return null;
    }

    private void b(@StringRes int i4) {
        boolean z3;
        if (this.f18237c != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        String a4 = a(i4, z3);
        if (a4 == null) {
            return;
        }
        this.f18239e = new SpannableStringBuilder(a4);
        c("%BTN%", this.f18237c);
        d("%TOS%", R.string.fui_terms_of_service, this.f18236b.termsOfServiceUrl);
        d("%PP%", R.string.fui_privacy_policy, this.f18236b.privacyPolicyUrl);
    }

    private void c(String str, @StringRes int i4) {
        int indexOf = this.f18239e.toString().indexOf(str);
        if (indexOf != -1) {
            this.f18239e.replace(indexOf, str.length() + indexOf, (CharSequence) this.f18235a.getString(i4));
        }
    }

    private void d(String str, @StringRes int i4, String str2) {
        int indexOf = this.f18239e.toString().indexOf(str);
        if (indexOf != -1) {
            String string = this.f18235a.getString(i4);
            this.f18239e.replace(indexOf, str.length() + indexOf, (CharSequence) string);
            int length = string.length() + indexOf;
            this.f18239e.setSpan(this.f18238d, indexOf, length, 0);
            this.f18239e.setSpan(new CustomTabsSpan(this.f18235a, str2), indexOf, length, 0);
        }
    }

    private void e(TextView textView) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(this.f18239e);
    }

    public static void setup(Context context, FlowParameters flowParameters, @StringRes int i4, TextView textView) {
        setup(context, flowParameters, -1, i4, textView);
    }

    public static void setup(Context context, FlowParameters flowParameters, @StringRes int i4, @StringRes int i5, TextView textView) {
        PreambleHandler preambleHandler = new PreambleHandler(context, flowParameters, i4);
        preambleHandler.b(i5);
        preambleHandler.e(textView);
    }
}
