# [JavaFX 项目]神奇编码_**MagicEncoding**（中文说明）

[**English**](README.md)

---

Website:

[[JavaFX 项目]神奇编码_MagicEncoding | ZZHow](https://www.zzhow.com/MagicEncoding)

Source Code:

https://github.com/ZZHow1024/MagicEncoding

Releases:

https://github.com/ZZHow1024/MagicEncoding/releases

---

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

---

## 使用说明

- 确定您使用的操作系统。
    - Linux：
        - 选择 .deb安装包 / .rpm安装包。
    - macOS：
        - 确定您使用的 Mac 的芯片(Apple Silicon / Intel)。
        - 选择 .dmg磁盘镜像 / .pkg安装包。
    - Windows：
        - 选择 .zip压缩包 / .exe安装包 / .msi安装包。
- 下载对应的文件。
- Linux 和 macOS 需要执行安装操作后再运行，Windows 可直接运行 .zip 压缩包中的 .exe 可执行程序或选择 .exe 安装包与 .msi 安装包执行安装操作。
- 启动 MagicEncoding。
- 在 MagicEncoding 的主界面右下方可以选择语言。
    - 当前支持中文（简体 / 繁体）与英文。
- 在 MagicEncoding 的上方可以选择功能分类（字符文件 / 字符文本 / Unix 时间戳）。
    - 字符文件
        - 拖拽文件夹或文件获取路径，填入需要筛选的后缀名（多种后缀名用“&”分隔），单击“查找文件”。
        - 选择是否覆盖原文件。
        - 选择原始编码与目标编码，单击“开始转换”。
    - 字符文本
        - 继续选择 Unicode / URL。
            - Unicode
                - 将待编码的文本内容填入上方文本框中，单击“**↓**”，编码后的文本将显示在下方文本框中。
                - 将待解码的文本内容填入下方文本框中，单击“**↑**”，解码后的文本将显示在上方文本框中。
            - URL
                - 将待编码的文本内容填入上方文本框中，选择原文本的字符集，单击“**↓**”，编码后的文本将显示在下方文本框中。
                - 将待解码的文本内容填入下方文本框中，选择原文本的字符集，单击“**↑**”，解码后的文本将显示在上方文本框中。
    - Unix时间戳
        - 基础功能
            - 当进入此模块时会自动获取当前的时间戳，但这不会实时更新，单击“刷新”可以重新获取当前的时间戳。
            - 将待转换的时间戳填入左方文本框中，选择时间戳的单位（秒 / 毫秒），单击“-->”，转换后的时间将显示在右方文本框中。
            - 将待转换的时间填入右方文本框中，选择时间戳的单位（秒 / 毫秒），单击“<--”，转换后的时间戳将显示在左方文本框中。
        - 快捷操作
            - 填写时间戳或时间，若同时填写将在时间（右方文本框中的内容）的基础上进行操作。
            - 选择操作类型（向前 / 向后）。
            - 分别填入年、月、日、时、分和秒（仅支持阿拉伯数字），单击“操作”，操作后的时间戳和时间将会覆盖原始内容。
- 单击“重置”可清空填写的内容。

---

## 功能介绍

- MagicEncoding4.0.0
    - 字符文本的 Unicode 编解码。
    - 字符文本的 URL 编解码。
    - Unix 时间戳。
        - 时间戳与时间相互转换
        - 时间快捷操作
- MagicEncoding3.0.0
    - 自动识别编码。
    - 单文件转换。
    - 支持多语言。
        - 中文（简体/繁体）
        - 英文
- MagicEncoding2.0.0
    - 拖拽文件夹获取路径。
    - 查找多种后缀名。
    - 支持覆盖原文件。
- MagicEncoding1.0.0
    - "GBK" 与 "UTF-8" 之间的编码转换。
    - 根据路径查找文件。
    - 支持根据文件后缀名筛选文件。

---

## **效果图**

![MagicEncoding4.0.0_ZH](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fb10a48cd-ee7f-49bd-a5c9-1a337b93b79a%2FMagicEncoding4.0.0_ZH.png?table=block&id=100e64bd-e40f-806d-8cd1-dd4538d217ba&t=100e64bd-e40f-806d-8cd1-dd4538d217ba&width=1624&cache=v2)

MagicEncoding4.0.0_ZH

![MagicEncoding3.0.0_ZH](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2F59e24efe-e112-48a3-8ca6-fa721270fca0%2FMagicEncoding3.0.0_ZH.png?table=block&id=63c5eb8e-9288-4418-a76b-627ee422a9c5&t=63c5eb8e-9288-4418-a76b-627ee422a9c5&width=1624&cache=v2)

MagicEncoding3.0.0_ZH

![MagicEncoding2.0.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fcea3d468-2198-4819-a5c3-cb4f3f287dfa%2FMagicEncoding2.0.0.png?table=block&id=34817b71-f9d4-42b9-91e9-a477ad85b262&t=34817b71-f9d4-42b9-91e9-a477ad85b262&width=1624&cache=v2)

MagicEncoding2.0.0

![MagicEncoding1.0.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2F94657332-79a5-4e54-b697-8979784a6da3%2FMagicEncoding1.0.0.png?table=block&id=c8dd391f-0e31-455c-8dc3-2b154b44605f&t=c8dd391f-0e31-455c-8dc3-2b154b44605f&width=1624&cache=v2)

MagicEncoding1.0.0
