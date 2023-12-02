package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.udojava.evalex.Expression;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ExpressionUtils {
    private static BigDecimal a(String str) {
        return new Expression(str, MathContext.DECIMAL128).eval();
    }

    public static void addExpressions(Context context, LinearLayout linearLayout) {
        List<String> expressions = getExpressions();
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.margin_tiny);
        for (String str : expressions) {
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextColor(ContextCompat.getColor(context, R.color.default_text_color));
            textView.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            linearLayout.addView(textView);
        }
    }

    public static double calculateExpression(Context context, Macro macro, String str, TriggerContextInfo triggerContextInfo) throws IllegalArgumentException {
        BigDecimal calculateExpressionBigDecimal = calculateExpressionBigDecimal(context, macro, str, triggerContextInfo);
        if (calculateExpressionBigDecimal == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return calculateExpressionBigDecimal.doubleValue();
    }

    public static BigDecimal calculateExpressionBigDecimal(Context context, Macro macro, String str, TriggerContextInfo triggerContextInfo) throws IllegalArgumentException {
        try {
            return a(MagicText.replaceMagicText(context, str, triggerContextInfo, false, macro, true, Locale.US, false));
        } catch (ArithmeticException unused) {
            return BigDecimal.ZERO;
        } catch (Exception e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static long calculateExpressionLong(Context context, Macro macro, String str, TriggerContextInfo triggerContextInfo) throws IllegalArgumentException {
        BigDecimal calculateExpressionBigDecimal = calculateExpressionBigDecimal(context, macro, str, triggerContextInfo);
        if (calculateExpressionBigDecimal == null) {
            return 0L;
        }
        return calculateExpressionBigDecimal.longValue();
    }

    public static List<String> getExpressions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("NOT(val)");
        arrayList.add("MIN(val1,val2,..)");
        arrayList.add("MAX(val1,val2,..)");
        arrayList.add("ABS(val)");
        arrayList.add("ROUND(val,dps)");
        arrayList.add("RANDOM()");
        arrayList.add("FLOOR(val)");
        arrayList.add("CEILING(val)");
        arrayList.add("LOG(val)");
        arrayList.add("LOG10(val)");
        arrayList.add("SQRT(val)");
        arrayList.add("SIN(val)");
        arrayList.add("SINR(val)");
        arrayList.add("COS(val)");
        arrayList.add("COSR(val)");
        arrayList.add("TAN(val)");
        arrayList.add("TANR(val)");
        arrayList.add("COTR(val)");
        arrayList.add("SECR(val)");
        arrayList.add("CSCR(val)");
        arrayList.add("ASIN(val)");
        arrayList.add("ASINR(val)");
        arrayList.add("ACOS(val)");
        arrayList.add("ACOSR(val)");
        arrayList.add("ATAN(val)");
        arrayList.add("ATANR(val)");
        arrayList.add("ACOTR(val)");
        arrayList.add("SINH(val)");
        arrayList.add("COSH(val)");
        arrayList.add("TANH(val)");
        arrayList.add("RAD(val)");
        arrayList.add("DEG(val)");
        arrayList.add("PI");
        arrayList.add("FACT(val)");
        return arrayList;
    }

    public static boolean isValidExpression(Context context, Macro macro, String str, TriggerContextInfo triggerContextInfo) {
        try {
            calculateExpression(context, macro, str, triggerContextInfo);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
