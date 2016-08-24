# NdkUser
使用Ndk开发 C提供String java端显示

##主要参考：
ndk生成so文件

http://blog.csdn.net/krubo1/article/details/50547681

android studio 生成jar包

http://blog.csdn.net/ta893115871/article/details/46955791

- 首先创建一个new project

project中默认有app module，再创建一个ndklib module用来生成so文件和调用native的jar

app引用ndklib

- 在ndklib中编写NdkUserInterface，使用单例模式避免重复loadLibrary

 public native String getNdkString();//c/c++方法


- 生成jni文件夹

build- - >make project 在module的build文件中会生成相应的.class


- 生成.h头文件命令 lib module 的main路径下执行

javah - d jni - classpath F:\android- sdk\platforms\android- 22\android.jar;..\..\build\intermediates\classes\debug com.zhj.crazy.ndklib.NdkUserInterface


在终端中执行命令生成.h 头文件

此时lib module的main文件夹下会有jni文件夹生成

在此文件夹下写C/C++代码（include interface，并实现interface中的方法）

##配置
- 在gradle.properties文件中加入android.useDeprecatedNdk=true

- 在ndklib的build.gradle中加入
```groovy
 ndk{
    moduleName "crazyFredNdk"         //生成的so名字
    abiFilters "armeabi", "armeabi- v7a", "x86"  //输出指定三种abi体系结构下的so库。目前可有可无。
    }
```
    位置 android.defaultConfig.ndk
```groovy
  task makeJar(type: Copy) {
        delete 'build/libs/crazyFredNdk.jar'
        from('build/intermediates/bundles/release/')
        into('build/libs/')
        include('classes.jar')
        rename ('classes.jar', 'crazyFredNdk.jar')
    }
    makeJar.dependsOn(build)
```
    位置 android.task

##生成jar包
生成jar包命令 project根目录下执行,jar包位置ndklib.build.libs

gradlew makeJar

执行终端命令生成jar包。copy- >save


##生成so文件
同步 Tools- >Android- >Sync Project with Gradle Files

重建 project Build - >Rebuild Project

在ndklib\build\intermediates\ndk\debug\lib文件夹下会生成so文件 copy- >save


此时ndklib中的内容已生成相应的jar和so文件了

断开ndklib的引用，将jar和so放入app module的libs文件夹下，并创建jniLibs文件夹

在app的build.gradle中加入
```groovy
 sourceSets {
        main {
            jniLibs.srcDirs = ['libs']
        }
    }
```
 位置 android.sourceSets

Build- >Make Project


