//
// Created by Fred Zhao on 2016/8/24.
//
#include "com_zhj_crazy_ndklib_NdkUserInterface.h"

JNIEXPORT jstring JNICALL Java_com_zhj_crazy_ndklib_NdkUserInterface_getNdkString
        (JNIEnv * env, jobject obj){
    return (*env)->NewStringUTF(env,"NDK 测试成功");
}
