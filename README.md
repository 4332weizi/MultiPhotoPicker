#MultiPhotoPicker

Android仿微信多图片选择器

##ScreenShots

![Alt text](/screenshots/device-2015-03-04-164457.png)
![Alt text](/screenshots/device-2015-03-04-164605.png)
![Alt text](/screenshots/device-2015-03-04-184645.png)
![Alt text](/screenshots/device-2015-03-04-164842.png)

##如何使用
将工程clone在你的工作目录中，并导入至项目工程中。</br>
###启动选择页面
####返回一张图片
```java
Intent intent = new Intent();
intent.setAction("funol.intent.action.PICK_PHOTO");
startActivityForResult(intent, REQUEST_CODE);
```
####返回多张图片
```java
Intent intent = new Intent();
intent.setAction("funol.intent.action.PICK_MULTI_PHOTO");
startActivityForResult(intent, REQUEST_CODE);
```
####返回指定最大张数图片
如：返回最多20张图片

```java
Intent intent = new Intent();
intent.setData(Uri.parse("pick://images.funol.net/number/20"));
startActivityForResult(intent, REQUEST_CODE);
```
###接收返回的图片
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
	if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
		// 取出图片的Uri
        List<Uri> uris = data.getParcelableArrayListExtra("photos");
    }
}
```