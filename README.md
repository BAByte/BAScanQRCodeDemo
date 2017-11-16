# BAScanQRCodeDemo

使用Zxing实现二维码扫描

先说两句

这里就讲讲怎么用，一般都是用官方的Zxing，主要是好不容易找到个简单的，而且就是精简下谷歌的Zxing而已

权限

    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.CAMERA"/>

---

用到的jar

在笔记的文件夹有，其实就是https://github.com/zxing/zxing项目的core文件夹里面的东西。

也可以直接去这里下载jar包http://mvnrepository.com/

要自己添加的文件夹

在笔记文件夹也有,这里就说说有什么用

- activity：用来放那个拍二维码Activity的文件夹
- camera：用来处理相机参数的class文件的文件夹
- encoding： 生成二维码class的文件夹
- uitls： 我就不知道了
- res目录下的文件夹，就是自定义扫描的时候的布局啦

使用方法

    //启动扫描二维码的界面
     Intent openCameraIntent = new Intent(MainActivity.this, CaptureActivity.class);
     startActivityForResult(openCameraIntent, requestCode);

    //回调处理
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode==RESULT_OK){
                Bundle bundle = data.getExtras();
                String scanResult = bundle.getString("result");
            }
        }


