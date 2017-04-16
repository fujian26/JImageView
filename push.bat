
adb shell rm -rf mnt/sdcard/OsMobile
adb shell mkdir mnt/sdcard/OsMobile
cd pics
adb push . mnt/sdcard/OsMobile/
cd ..