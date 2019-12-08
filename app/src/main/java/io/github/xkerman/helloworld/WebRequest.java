package io.github.xkerman.helloworld;

import android.os.AsyncTask;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class WebRequest extends AsyncTask<String, Integer, String> {
    interface Listener {
        void onSuccess(String title);
    }
    private Listener listener;

    public WebRequest(Listener listener) {
        super();
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... urls) {
        try (final WebClient webClient = new WebClient()) {
            WebClientOptions options = webClient.getOptions();
            options.setThrowExceptionOnScriptError(false);

            final HtmlPage page = webClient.getPage(urls[0]);

            return page.getTitleText();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String title) {
        if (title != null) {
            this.listener.onSuccess(title);
        } else {
            this.listener.onSuccess("null!!!!");
        }
    }
}
