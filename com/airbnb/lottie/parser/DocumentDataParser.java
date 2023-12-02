package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DocumentDataParser implements u<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f1791a = JsonReader.Options.of("t", "f", "s", "j", TranslateLanguage.TURKISH, "lh", "ls", "fc", "sc", TranslateLanguage.SWAHILI, "of");

    private DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.u
    public DocumentData parse(JsonReader jsonReader, float f4) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f5 = 0.0f;
        int i4 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        float f8 = 0.0f;
        boolean z3 = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(f1791a)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    f5 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    justification2 = DocumentData.Justification.CENTER;
                    if (nextInt <= justification2.ordinal() && nextInt >= 0) {
                        justification2 = DocumentData.Justification.values()[nextInt];
                        break;
                    }
                    break;
                case 4:
                    i4 = jsonReader.nextInt();
                    break;
                case 5:
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    f7 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    i5 = g.d(jsonReader);
                    break;
                case 8:
                    i6 = g.d(jsonReader);
                    break;
                case 9:
                    f8 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z3 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(str, str2, f5, justification2, i4, f6, f7, i5, i6, f8, z3);
    }
}
