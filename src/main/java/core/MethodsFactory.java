package core;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/**
 * Created by Alex Astakhov on 31.10.2016.
 */
public class MethodsFactory {

    public static StringBuilder cutStringBuilder(StringBuilder source, String begin, String end){
        int beginIndex = source.indexOf(begin) + begin.length();
        source = new StringBuilder(source.substring(beginIndex));
        int endIndex = source.indexOf(end);
        return new StringBuilder(source.substring(0, endIndex));
    }

    public static StringBuilder cutStringBuilder(StringBuilder source, String begin){
        int beginIndex = source.indexOf(begin) + begin.length();
        return new StringBuilder(source.substring(beginIndex));
    }

    public static Header[] cookieNameSubst(Header[] cookieHeaders){
        Header[] newHeader = new Header[cookieHeaders.length];
        int i = 0;
        for (Header h: cookieHeaders) {
            newHeader[i++] = new BasicHeader("Cookie", h.getValue());
        }
        return newHeader;
    }
}
