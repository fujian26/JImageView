# JImageView
用于查看存储空间图片的应用，支持传参[path]，含义是内部存储根目录下的某个目录的图片
如果不传参数，则默认把内部存储的所有子目录显示出来，供选择

am 传参启动方式
adb shell am start -n com.jacob.imageview/com.jacob.imageview.MainActivity --es path "xxx"

push.bat
将pics目录下的图片拷贝到内部存储的指定位置

open.bat
将上述拷贝的位置中的图片的路径当做启动参数传给MainActivity并启动应用
