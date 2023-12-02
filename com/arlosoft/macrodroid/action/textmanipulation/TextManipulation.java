package com.arlosoft.macrodroid.action.textmanipulation;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.ExpressionUtils;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

@DontObfuscate
/* loaded from: classes2.dex */
public abstract class TextManipulation implements Parcelable {
    public static final int EXTENDED_INFO_TEXT_CHAR_LIMIT = 28;
    @SerializedName(alternate = {"a"}, value = "params")
    protected List<String> params;

    /* loaded from: classes2.dex */
    public enum ParamType {
        STRING,
        INTEGER,
        ENUM,
        STRING_OPTIONAL
    }

    public TextManipulation() {
        this.params = new ArrayList();
    }

    private int calculateExpression(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        try {
            return (int) ExpressionUtils.calculateExpression(MacroDroidApplication.getInstance(), macro, str, triggerContextInfo);
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public static List<TextManipulation> getAllTextManipulations() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SubstringManipulation());
        arrayList.add(new ReplaceAllManipulation());
        arrayList.add(new ExtractTextManipulation());
        arrayList.add(new UpperCaseManipulation());
        arrayList.add(new LowerCaseManipulation());
        arrayList.add(new TrimManipulation());
        arrayList.add(new SplitManipulation());
        arrayList.add(new RemoveTextManipulation());
        return arrayList;
    }

    @Nullable
    public VariableValue.Dictionary applyArray(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        return null;
    }

    @StringRes
    public abstract int getDescription();

    public int[] getEnumNames(int i4) {
        return new int[0];
    }

    public abstract String getExtendedInfo(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getIntValue(int i4, Macro macro, TriggerContextInfo triggerContextInfo) {
        if (i4 >= this.params.size()) {
            SystemLog.logError("Attempted to get value for illegal parameter - index = " + i4 + ", params size = " + this.params.size());
            return 0;
        }
        return calculateExpression(this.params.get(i4), macro, triggerContextInfo);
    }

    @StringRes
    public abstract int getName();

    public abstract int[] getParamNames();

    public abstract ParamType[] getParamTypes();

    public List<String> getParams() {
        return this.params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(int i4) {
        return MacroDroidApplication.getInstance().getString(i4);
    }

    public boolean isArray() {
        return false;
    }

    public void setParams(List<String> list) {
        this.params = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeStringList(this.params);
    }

    public TextManipulation(Parcel parcel) {
        this.params = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.params = arrayList;
        parcel.readStringList(arrayList);
    }

    public String apply(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        return str;
    }
}
