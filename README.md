# NotoCJK Provider

在绝大部分的 Android 系统中 CJK 字体只提供了一个字重，而默认的英语字体 (Roboto) 却提供了多达 7 个字重，
这就是为什么我们会发现在英语环境下，如对话框的按钮、AppBar 标题等要相对粗一些，而 CJK 语言下都是细细的。

因此我们提供了这个应用，为其他应用提供常用字重的 Noto CJK 字体，包含 NotoSans (Medium, Light) 和 NotoSerif (Regular, Medium, Light)。

## 对普通用户
在安装我们提供的应用后，若使用的应用适配了 NotoCJK Provider，就能看到界面“原本的样子”。

## 对应用开发者

### 如何适配 NotoCJK Provider

1. 加入依赖（稍后会发布），如果使用 3.0.0 之前的 gradle 插件需要将 `implementation` 替换为 `compile`
   
   `implementation 'moe.shizuku.notocjk.provider:api:1.0.0'`
   
2. 在合适的地方（如 `Application.onCreate` 调用 `TypefaceReplacer.init(Context context, String[] requestFonts)` 。

3. 在需要的地方只需按原本的方式使用即可，比如在 layout xml 中 `android:fontFamily="sans-serif-medium"` 
或是直接创建 `Typeface` 实例 `Typeface.create("sans-serif-medium", )`。

#### 目前支持的 fontFamily

`sans-serif-light`, `sans-serif-medium`, `serif-light`, `serif`, `serif-medium`

### 技术细节

调用 `TypefaceReplacer.init` 后将通过绑定服务向 NotoCJK Provider 的 `FontProviderService` 索要字体文件的 `FileDescriptor`，
之后将通过反射使用私有 API 创建对应的 `Typeface`，并替换 `Typeface` 中的对应缓存，因此对应用开发者几乎透明。

由于绑定服务需要时间，因此在完成前已经创建的 `Typeface` 将不会被替换。
