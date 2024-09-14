# [JavaFX Project]**MagicEncoding**(English)

[**中文说明**](README_ZH.md)

---

Website:

[[JavaFX Project]MagicEncoding_EN | ZZHow](https://www.zzhow.com/MagicEncodingEN)

Source Code:

https://github.com/ZZHow1024/MagicEncoding

Releases:

https://github.com/ZZHow1024/MagicEncoding/releases

---

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

---

## **Instructions for use**

- Determine the operating system you are using.
    - Linux:
        - Select .deb installation package/ .rpm installation package.
    - macOS:
        - Determine the chipset of your Mac (Apple Silicon / Intel).
        - Select .dmg disk image/ .pkg installation package.
    - Windows:
        - Select .zip package/.exe installation package/.msi installation package.
- Download the corresponding file.
- Linux and macOS users need to perform the installation operation before running. Windows users can directly run the .exe executable program in the .zip compressed package or select the .exe installation package and .msi installation package to perform the installation operation.
- Start MagicEncoding.
- You can select the language in the lower right corner of MagicEncoding's main interface.
    - Currently supports Chinese (Simplified / Traditional) and English.
- You can select the function category (Character file / Character text / Unix timestamp) above MagicEncoding.
    - Character file
        - Drag the folder or file to get the path, fill in the suffix name to be filtered (multiple suffix names are separated by "&"), and click "Find files".
        - Choose whether to overwrite the original file.
        - Select the original encoding and the target encoding, and click "Start conversion".
    - Character text
        - Continue to select Unicode / URL.
            - Unicode
                - Fill in the text content to be encoded in the text box above, click "**↓**", and the encoded text will be displayed in the text box below.
                - Fill in the text content to be decoded in the text box below, click "**↑**", and the decoded text will be displayed in the text box above.
            - URL
                - Fill in the text content to be encoded in the text box above, select the character set of the original text, click "**↓**", and the encoded text will be displayed in the text box below.
                - Fill in the text content to be decoded in the text box below, select the character set of the original text, click "**↑**", and the decoded text will be displayed in the text box above.
    - Unix timestamp
        - Basic functions
            - When entering this module, the current timestamp will be automatically obtained, but it will not be updated in real time. Click "Refresh" to re-obtain the current timestamp.
            - Fill in the timestamp to be converted in the left text box, select the timestamp unit (seconds / milliseconds), click "-->", and the converted time will be displayed in the right text box.
            - Fill in the time to be converted in the right text box, select the timestamp unit (seconds / milliseconds), click "<--", and the converted timestamp will be displayed in the left text box.
        - Quick operations
            - Fill in the timestamp or time. If you fill in both, the operation will be based on the time (the content in the right text box).
            - Select the operation type (Move forward / Move backward).
            - Fill in the year, month, day, hour, minute and second (only Arabic numerals are supported), click "Operate", and the timestamp and time after the operation will overwrite the original content.
- Click "Reset" to clear the filled content.

---

## Function Introduction

- MagicEncoding4.0.0
    - Unicode encoding and decoding of character text.
    - URL encoding and decoding of character text.
    - Unix timestamp.
        - Supports conversion between timestamp and time
        - Supports time shortcut operations
- MagicEncoding3.0.0
    - Automatic encoding recognition.
    - Single file conversion.
    - Support multiple languages.
        - Chinese (Simplified/Traditional)
        - English
- MagicEncoding2.0.0
    - Drag the folder to get the path.
    - Search for multiple suffixes.
    - Support overwriting original files.
- MagicEncoding1.0.0
    - Encoding conversion between "GBK" and "UTF-8”.
    - Find files by path.
    - Support filtering files based on file extensions.

---

## **Renderings**

![MagicEncoding4.0.0_EN](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fbec5cc32-9058-45d2-baeb-3b24dfc55b96%2FMagicEncoding4.0.0_EN.png?table=block&id=100e64bd-e40f-8088-9b6a-ce06348c8739&t=100e64bd-e40f-8088-9b6a-ce06348c8739&width=1624&cache=v2)

MagicEncoding4.0.0_EN

![MagicEncoding3.0.0_EN](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fa48f9fb0-5ca9-4b3e-aa65-5c0b9b8f53a4%2FMagicEncoding3.0.0_EN.png?table=block&id=e473a771-1ea7-42ab-9cc2-b124f8610072&t=e473a771-1ea7-42ab-9cc2-b124f8610072&width=1624&cache=v2)

MagicEncoding3.0.0_EN

![MagicEncoding2.0.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fbf42de01-57d9-4f5d-bb7c-3490b0db7ee1%2FMagicEncoding2.0.0.png?table=block&id=7ce8da63-3633-47ff-848c-94492101089c&t=7ce8da63-3633-47ff-848c-94492101089c&width=1624&cache=v2)

MagicEncoding2.0.0

![MagicEncoding1.0.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fa91b3a7d-672f-4ea2-b167-4657fef038dc%2FMagicEncoding1.0.0.png?table=block&id=ed5e4ef9-7816-4961-9740-d423c5681168&t=ed5e4ef9-7816-4961-9740-d423c5681168&width=1624&cache=v2)

MagicEncoding1.0.0
