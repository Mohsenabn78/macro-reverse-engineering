package com.sun.mail.handlers;

import com.koushikdutta.async.http.body.DocumentBody;
import java.io.IOException;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataSource;
import javax.mail.internet.ContentType;
import javax.mail.internet.ParseException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* loaded from: classes6.dex */
public class text_xml extends text_plain {
    private static final ActivationDataFlavor[] flavors = {new ActivationDataFlavor(String.class, "text/xml", "XML String"), new ActivationDataFlavor(String.class, DocumentBody.CONTENT_TYPE, "XML String"), new ActivationDataFlavor(StreamSource.class, "text/xml", "XML"), new ActivationDataFlavor(StreamSource.class, DocumentBody.CONTENT_TYPE, "XML")};

    private boolean isXmlType(String str) {
        try {
            ContentType contentType = new ContentType(str);
            if (!contentType.getSubType().equals("xml")) {
                return false;
            }
            if (!contentType.getPrimaryType().equals("text")) {
                if (!contentType.getPrimaryType().equals("application")) {
                    return false;
                }
            }
            return true;
        } catch (RuntimeException | ParseException unused) {
            return false;
        }
    }

    @Override // com.sun.mail.handlers.handler_base
    protected Object getData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        if (activationDataFlavor.getRepresentationClass() == String.class) {
            return super.getContent(dataSource);
        }
        if (activationDataFlavor.getRepresentationClass() == StreamSource.class) {
            return new StreamSource(dataSource.getInputStream());
        }
        return null;
    }

    @Override // com.sun.mail.handlers.text_plain, com.sun.mail.handlers.handler_base
    protected ActivationDataFlavor[] getDataFlavors() {
        return flavors;
    }

    @Override // com.sun.mail.handlers.text_plain, javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (isXmlType(str)) {
            if (obj instanceof String) {
                super.writeTo(obj, str, outputStream);
                return;
            } else if (!(obj instanceof DataSource) && !(obj instanceof Source)) {
                throw new IOException("Invalid Object type = " + obj.getClass() + ". XmlDCH can only convert DataSource or Source to XML.");
            } else {
                try {
                    Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                    StreamResult streamResult = new StreamResult(outputStream);
                    if (obj instanceof DataSource) {
                        newTransformer.transform(new StreamSource(((DataSource) obj).getInputStream()), streamResult);
                        return;
                    } else {
                        newTransformer.transform((Source) obj, streamResult);
                        return;
                    }
                } catch (RuntimeException e4) {
                    IOException iOException = new IOException("Unable to run the JAXP transformer on a stream " + e4.getMessage());
                    iOException.initCause(e4);
                    throw iOException;
                } catch (TransformerException e5) {
                    IOException iOException2 = new IOException("Unable to run the JAXP transformer on a stream " + e5.getMessage());
                    iOException2.initCause(e5);
                    throw iOException2;
                }
            }
        }
        throw new IOException("Invalid content type \"" + str + "\" for text/xml DCH");
    }
}
