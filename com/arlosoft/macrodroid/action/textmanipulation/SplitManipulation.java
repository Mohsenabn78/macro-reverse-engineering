package com.arlosoft.macrodroid.action.textmanipulation;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.textmanipulation.TextManipulation;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.regex.Pattern;

@DontObfuscate
/* loaded from: classes2.dex */
public class SplitManipulation extends TextManipulation {
    public static final Parcelable.Creator<SplitManipulation> CREATOR = new a();
    private static final int OPTION_VAR_TYPE_BOOLEAN = 3;
    private static final int OPTION_VAR_TYPE_DECIMAL = 2;
    private static final int OPTION_VAR_TYPE_INTEGER = 1;
    private static final int OPTION_VAR_TYPE_STRING = 0;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SplitManipulation> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SplitManipulation createFromParcel(Parcel parcel) {
            return new SplitManipulation(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SplitManipulation[] newArray(int i4) {
            return new SplitManipulation[i4];
        }
    }

    /* synthetic */ SplitManipulation(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public VariableValue.Dictionary applyArray(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        int i4;
        double d4;
        String[] split = str.split(Pattern.quote(MagicText.replaceMagicText(MacroDroidApplication.getInstance(), this.params.get(0), triggerContextInfo, macro).replace("\\n", "\n")));
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < split.length; i5++) {
            int intValue = Integer.valueOf(this.params.get(1)).intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue == 3) {
                            arrayList.add(new VariableValue.DictionaryEntry(String.valueOf(i5), new VariableValue.BooleanValue(split[i5].equalsIgnoreCase("true"), null), null));
                        }
                    } else {
                        try {
                            d4 = Double.valueOf(split[i5]).doubleValue();
                        } catch (Exception unused) {
                            d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                        arrayList.add(new VariableValue.DictionaryEntry(String.valueOf(i5), new VariableValue.DecimalValue(d4, null), null));
                    }
                } else {
                    try {
                        i4 = Integer.valueOf(split[i5]).intValue();
                    } catch (Exception unused2) {
                        i4 = 0;
                    }
                    arrayList.add(new VariableValue.DictionaryEntry(String.valueOf(i5), new VariableValue.IntegerValue(i4, null), null));
                }
            } else {
                arrayList.add(new VariableValue.DictionaryEntry(String.valueOf(i5), new VariableValue.StringValue(split[i5], null), null));
            }
        }
        return new VariableValue.Dictionary(arrayList, true, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getDescription() {
        return R.string.text_manipulation_split_to_array_description;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getEnumNames(int i4) {
        if (i4 == 1) {
            return new int[]{R.string.string, R.string.integer, R.string.decimal, R.string.bool};
        }
        return super.getEnumNames(i4);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String getExtendedInfo(String str) {
        if (str.length() > 28) {
            str = str.substring(0, 28) + "..";
        }
        return getString(getName()) + " (" + str + ")";
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getName() {
        return R.string.text_manipulation_split_to_array;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getParamNames() {
        return new int[]{R.string.text_manipulation_string_delimiter, R.string.text_manipulation_split_to_variable_type};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public TextManipulation.ParamType[] getParamTypes() {
        return new TextManipulation.ParamType[]{TextManipulation.ParamType.STRING_OPTIONAL, TextManipulation.ParamType.ENUM};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public boolean isArray() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public SplitManipulation() {
    }

    private SplitManipulation(Parcel parcel) {
        super(parcel);
    }
}
