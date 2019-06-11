package com.example.administrator.myapplication.xutilsdemo;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.util.Map;

public class ShiXutils {
    private Handler handler;
    private ShiXutils(){
        handler = new Handler(Looper.getMainLooper());
    }
    private static final String BASE_URL="https://www.baidu.com/";
    public static void get(String url, Map<String, Object> parms, final GetDataCallback callback){
        RequestParams params = new RequestParams(BASE_URL + url);

        if(parms!=null){
            for (String key : parms.keySet()) {
                params.addParameter(key, parms.get(key));
            }
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.success(result);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.failed();
            }
            @Override
            public void onCancelled(CancelledException cex) {}
            @Override
            public void onFinished() {}
        });
    }
    public static void post(String url,Map<String,Object> parms,final GetDataCallback callback){
    RequestParams params=new RequestParams(BASE_URL+url);
        params.addBodyParameter("name","张三");
        params.addBodyParameter("age","18");
       if (params!=null){
            for (String key:parms.keySet()){
              params.addParameter(key,parms.get(key));
            }
       }
       x.http().post(params, new Callback.CommonCallback<String>() {
           @Override
           public void onSuccess(String result) {
               if(callback!=null){
                   callback.success(result);
               }
           }

           @Override
           public void onError(Throwable ex, boolean isOnCallback) {
               if(callback!=null){
                   callback.failed();
               }
           }

           @Override
           public void onCancelled(CancelledException cex) {

           }

           @Override
           public void onFinished() {

           }
       });
    }
    /**
     * 下载文件
     * @param url
     * @param filePath
     * @param callback
     */
    public void downFile(String url, String filePath, final XDownLoadCallBack callback){
        RequestParams params = new RequestParams(url);
        params.setSaveFilePath(filePath);
        params.setAutoRename(true);
        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(final File result) {
                //下载完成会走该方法
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback!=null){
                            callback.onSuccess(result);
                        }
                    }
                });
            }
            @Override
            public void onError(final Throwable ex, boolean isOnCallback) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (null != callback){
                            callback.onFail(ex.getMessage());
                        }
                    }
                });
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback!=null){
                            callback.onFinished();
                        }
                    }
                });
            }
            //网络请求之前回调
            @Override
            public void onWaiting() {
            }
            //网络请求开始的时候回调
            @Override
            public void onStarted() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (null != callback){
                            callback.onstart();
                        }
                    }
                });
            }
            //下载的时候不断回调的方法
            @Override
            public void onLoading(final long total, final long current, final boolean isDownloading) {
                //当前进度和文件总大小
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback!=null){
                            callback.onLoading(total,current,isDownloading);
                        }
                    }
                });
            }
        });
    }
    public void upLoadFile(String url,Map<String,String>maps,Map<String,File>file,final  XCallBack callback){
        RequestParams params=new RequestParams(url);
        if (maps!=null &&!maps.isEmpty()){
            for (Map.Entry<String,String>entry:maps.entrySet()){
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }
        if (file!=null){
            for (Map.Entry<String, File> entry : file.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue().getAbsoluteFile());
            }
        }
        // 有上传文件时使用multipart表单, 否则上传原始文件流.
        params.setMultipart(true);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
               // onSuccessResponse(result, callback);
                Log.e("onSuccess", "onSuccess: ");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    public void tuPian(){
       /*    ImageOptions imageOptions=new ImageOptions.Builder()
                //ImageOptions.Builder()的一些其他属性：
                .setCircular(true) //设置图片显示为圆形
                .setSquare(true) //设置图片显示为正方形
                .setCrop(true).setSize(200,200) //设置大小
             .setAnimation(animation) //设置动画
                .setFailureDrawable(Drawable failureDrawable) //设置加载失败的动画
                .setFailureDrawableId(int failureDrawable) //以资源id设置加载失败的动画
            	.setLoadingDrawable(Drawable loadingDrawable) //设置加载中的动画
                .setLoadingDrawableId(int loadingDrawable) //以资源id设置加载中的动画
	            .setIgnoreGif(false) //忽略Gif图片
                .setParamsBuilder(ParamsBuilder paramsBuilder) //在网络请求中添加一些参数
                .setRaduis(int raduis) //设置拐角弧度
	            .setUseMemCache(true) //设置使用MemCache，默认true
                .build();
        x.image().bind(imageView, url, imageOptions);
// assets file
        x.image().bind(imageView, "assets://test.gif", imageOptions);
// local file
        x.image().bind(imageView, new File("/sdcard/test.gif").toURI().toString(), imageOptions);
        x.image().bind(imageView, "/sdcard/test.gif", imageOptions);
        x.image().bind(imageView, "file:///sdcard/test.gif", imageOptions);
        x.image().bind(imageView, "file:/sdcard/test.gif", imageOptions);
        x.image().bind(imageView, url, imageOptions, new Callback.CommonCallback<Drawable>() {
                    @Override
                    public void onSuccess(Drawable result) {
                    }
                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                    }
                    @Override
                    public void onCancelled(CancelledException cex) {
                    }
                    @Override
                    public void onFinished() {
                    }
x.image().loadDrawable(url, imageOptions, new Callback.CommonCallback<Drawable>() {...});
// 用来获取缓存文件
x.image().loadFile(url, imageOptions, new Callback.CommonCallback<File>() {...});
*/
    }
    /**回调接口*/
    public interface GetDataCallback {
        void success(String result);
        void failed(String... args);
    }
    //接口回调
    public interface XCallBack{
        void onResponse(String result);
        void onFail(String result);
    }
    //下载的接口回调
    public interface XDownLoadCallBack{
        void onstart();
        void onLoading(long total,long current,boolean isDownloading);
        void onSuccess(File result);
        void onFail(String result);
        void onFinished();
    }
}
