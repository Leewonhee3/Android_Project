package com.leewonhee.web;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private WebView webs;
    private Button btn1;
    ValueCallback mFilePathCallback;
   // Dialog dialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.button);
        webs = (WebView)findViewById(R.id.webs);
        webs.getSettings().setJavaScriptEnabled(true);
        webs.getSettings().setBuiltInZoomControls(true);
        webs.getSettings().setSupportMultipleWindows(true);
        webs.getSettings().setSaveFormData(true);
        webs.getSettings().setLoadsImagesAutomatically(true);
        webs.getSettings().setUseWideViewPort(false);
        webs.getSettings().setDomStorageEnabled(true);
        webs.getSettings().setAppCacheEnabled(true);
        webs.getSettings().setAllowFileAccess(true);
        webs.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
       //webs.setWebViewClient(new mvc());
        webs.setWebChromeClient(new hwc());
        webs.loadUrl("https://www.sungkyul.ac.kr/portalLogin/skukr/portalLoginForm.do");

      btn1.setOnClickListener(new Button.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      webs.getSettings().setJavaScriptEnabled(true);
                                      webs.getSettings().setBuiltInZoomControls(true);
                                      webs.getSettings().setSupportMultipleWindows(true);
                                      webs.getSettings().setSaveFormData(true);
                                      webs.getSettings().setLoadsImagesAutomatically(true);
                                      webs.getSettings().setUseWideViewPort(false);
                                      webs.getSettings().setDomStorageEnabled(true);
                                      webs.getSettings().setAppCacheEnabled(true);
                                      webs.getSettings().setAllowFileAccess(true);
                                      webs.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                                      //webs.setWebViewClient(new mvc());
                                      webs.setWebChromeClient(new hwc());
                                      webs.loadUrl("https://sky.sungkyul.ac.kr:444/websquare/websquare.html?w2xPath=/scr/system/main.xml");
                                  }
                              });}

    public class hwc extends WebChromeClient{
        @Override
        public boolean onCreateWindow(final WebView view, boolean dialog,
                                                     boolean userGesture, Message resultMsg)
        {
            WebView newWebView = new WebView(MainActivity.this);
            WebSettings webSettings = newWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            final Dialog dialog1 = new Dialog(MainActivity.this);
            dialog1.setContentView(newWebView);
            dialog1.show();
            newWebView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onCloseWindow(WebView window) {
                    dialog1.dismiss();
                }
            }
            );
            ((WebView.WebViewTransport)resultMsg.obj).setWebView(newWebView); resultMsg.sendToTarget(); return true;
        }
    }
}



            /*
            WebView newWebView = new WebView(webs.getContext());
            WebSettings websettings = newWebView.getSettings();
            dialog1 = new Dialog(webs.getContext());
            dialog1.setContentView(newWebView);

            ViewGroup.LayoutParams params = dialog1.getWindow().getAttributes();
            params.width=ViewGroup.LayoutParams.MATCH_PARENT;
            params.height=ViewGroup.LayoutParams.MATCH_PARENT;
            dialog1.getWindow().setAttributes((WindowManager.LayoutParams)params);
            dialog1.show();
            newWebView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onCloseWindow(WebView window){

                }
            });
            ((WebView.WebViewTransport)resultMsg.obj).setWebView(newWebView);
            resultMsg.sendToTarget();
            return true;
        }
    }



}
*/


      /*
      webs.setWebChromeClient(new WebChromeClient() {
                                                             @Override
                                                             WebView newWebView = new WebView(MainActivity.this);
                                                             newWebView.getSettings().setJavaScriptEnabled(true);
                                                             newWebView.getSettings().setSupportZoom(true);
                                                             newWebView.getSettings().setBuiltInZoomControls(true);
                                                             newWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
                                                             newWebView.getSettings().setSupportMultipleWindows(true);
                                                             view.addView(newWebView);
                                                             WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                                                             transport.setWebView(newWebView);
                                                             resultMsg.sendToTarget();

                                                                         newWebView.setWebChromeClient(new WebChromeClient() {
                                                                             @Override
                                                                             public boolean onShowFileChooser(WebView webView, ValueCallback filePathCallback, FileChooserParams fileChooserParams) {
                                                                                 mFilePathCallback = filePathCallback;

                                                                                 Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                                                                 intent.addCategory(Intent.CATEGORY_OPENABLE);
                                                                                 intent.setType("image/*");

                                                                                 startActivityForResult(intent, 0);

                                                                                 webs.setWebViewClient(new WebViewClient() {
                                                                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                                                                         view.getSettings().setUserAgentString("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)");
                                                                                         view.loadUrl(url);
                                                                                         return true;


                                                                                     }
                                                                                 });
                                                                                 return true;
                                                                             }

                                                                         });
                                                                         return true;

                                                             }
                                                         });
    }
}





*/







/*
    private class mcc extends WebChromeClient{
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback filePathCallback, FileChooserParams fileChooserParams) {
            mFilePathCallback = filePathCallback;

            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");

            startActivityForResult(intent, 0);
            return true;


        }

    }


 webs.setWebChromeClient(new WebChromeClient(){
                    @Override
                    public boolean onCreateWindow(final WebView view, boolean dialog,
                                                  boolean userGesture, Message resultMsg)
                    {
                        WebView newWebView = new WebView(MainActivity.this);
                        WebView.WebViewTransport transport
                                = (WebView.WebViewTransport) resultMsg.obj;
                        transport.setWebView(newWebView);
                        resultMsg.sendToTarget();

                        newWebView.setWebViewClient(new WebViewClient() {
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                                browserIntent.setData(Uri.parse(url));
                                startActivity(browserIntent);
                                return true;
                            }
*/


