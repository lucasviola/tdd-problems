import org.junit.Before;
import org.junit.Test;
import urlSplitter.URLSplitter;

import java.net.URL;

import static org.junit.Assert.*;

public class URLSplitterTest {

    URLSplitter splitter;

    @Before
    public void setUp() throws Exception {

        String url = "http://website.domain.name.com/path-to-file.html";
        URL parser = new URL(url);
        splitter = new URLSplitter(parser);
    }

    @Test
    public void shouldReturnProtocolGivenURL() throws Exception {

        String result = splitter.getProtocol();

        assertEquals("HTTP", result);
    }

    @Test
    public void shouldReturnDomainGivenURL() throws Exception {

        String result = splitter.getDomain();

        assertEquals("website.domain.name.com", result);
    }

    @Test
    public void shouldReturnPathGivenURL() throws Exception {

        String result = splitter.getPath();

        assertEquals("path-to-file.html", result);

    }
}
