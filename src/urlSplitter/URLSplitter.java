package urlSplitter;

import java.net.MalformedURLException;
import java.net.URL;

public class URLSplitter {

    private URL parser;

    public URLSplitter( URL parser) {
        this.parser = parser;
    }

    public String getProtocol() throws MalformedURLException {

        return parser.getProtocol().toUpperCase();
    }

    public String getDomain() throws MalformedURLException {

        return parser.getHost().toLowerCase();
    }

    public String getPath() {

        return parser.getPath().substring(1).toLowerCase();
    }
}
