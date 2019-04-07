# PluginDemo
插件化demo：可以加载插件中类、资源、Activity。

# 方案步骤
step1：通过反射把插件dex和宿主dexElements合并成一个新的dex数组，替换宿主之前的dexElements字段；

step2：通过修改过的aapt程序把插件中的资源修id改为不是以0x7f开头的常量（避免与宿主资源冲突）；

step3：在宿主app中通过反射调用addAssetPath()方法把宿主及插件的资源都加载进来，并最终生成一个包含所有资源的Resources；

step4：对ActivityManagerNative的getDefault()方法进行Hook，把TargetActivity替换为StubActivity；

step5：对H类的mCallback字段进行Hook，拦截它的handleMessage()方法，把StubActivity再替换回TargetActivity。

# 同样只适配到API25
更多适配见

[Android插件化的兼容性（上）：Android O的适配](https://www.cnblogs.com/Jax/p/9521298.html)

[Android插件化的兼容性（中）：Android P的适配](https://www.cnblogs.com/Jax/p/9521305.html)

[Android插件化的兼容性（下）：突破Android P中灰黑名单的限制](https://www.cnblogs.com/Jax/p/9521335.html)
