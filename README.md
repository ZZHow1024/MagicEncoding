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

## What is it?

MagicEncoding is a cross-platform encoding processing tool that supports character set conversion of character files, encoding and decoding of character text (Unicode and URL) and Unix timestamps (conversion between timestamps and time and shortcut operations on time).

---

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

---

## **Instructions for use**

Download address: https://github.com/ZZHow1024/MagicEncoding/releases

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

## Supported file character sets

- Supported file character sets for conversion: Big5, Big5-HKSCS, CESU-8, EUC-JP, EUC-KR, GB18030, GB2312, GBK, IBM-Thai, IBM00858, IBM01140, IBM01141, IBM01142, IBM01143, IBM01144, IBM01145, IBM01146, IBM01147, IBM01148, IBM01149, IBM037, IBM1026, IBM1047, IBM273, IBM277, IBM278, IBM280, IBM284, IBM285, IBM290, IBM297, IBM420, IBM424, IBM437, IBM500, IBM775, IBM850, IBM852, IBM855, IBM857, IBM860, IBM861, IBM862, IBM863, IBM864, IBM865, IBM866, IBM868, IBM869, IBM870, IBM871, IBM918, ISO-2022-CN, ISO-2022-JP, ISO-2022-JP-2, ISO-2022-KR, ISO-8859-1, ISO-8859-13, ISO-8859-15, ISO-8859-16, ISO-8859-2, ISO-8859-3, ISO-8859-4, ISO-8859-5, ISO-8859-6, ISO-8859-7, ISO-8859-8, ISO-8859-9, JIS_X0201, JIS_X0212-1990, KOI8-R, KOI8-U, Shift_JIS, TIS-620, US-ASCII, UTF-16, UTF-16BE, UTF-16LE, UTF-32, UTF-32BE, UTF-32LE, UTF-8, windows-1250, windows-1251, windows-1252, windows-1253, windows-1254, windows-1255, windows-1256, windows-1257, windows-1258, windows-31j, x-Big5-HKSCS-2001, x-Big5-Solaris, x-euc-jp-linux, x-EUC-TW, x-eucJP-Open, x-IBM1006, x-IBM1025, x-IBM1046, x-IBM1097, x-IBM1098, x-IBM1112, x-IBM1122, x-IBM1123, x-IBM1124, x-IBM1129, x-IBM1166, x-IBM1364, x-IBM1381, x-IBM1383, x-IBM29626C, x-IBM300, x-IBM33722, x-IBM737, x-IBM833, x-IBM834, x-IBM856, x-IBM874, x-IBM875, x-IBM921, x-IBM922, x-IBM930, x-IBM933, x-IBM935, x-IBM937, x-IBM939, x-IBM942, x-IBM942C, x-IBM943, x-IBM943C, x-IBM948, x-IBM949, x-IBM949C, x-IBM950, x-IBM964, x-IBM970, x-ISCII91, x-ISO-2022-CN-CNS, x-ISO-2022-CN-GB, x-iso-8859-11, x-JIS0208, x-JISAutoDetect, x-Johab, x-MacArabic, x-MacCentralEurope, x-MacCroatian, x-MacCyrillic, x-MacDingbat, x-MacGreek, x-MacHebrew, x-MacIceland, x-MacRoman, x-MacRomania, x-MacSymbol, x-MacThai, x-MacTurkish, x-MacUkraine, x-MS932_0213, x-MS950-HKSCS, x-MS950-HKSCS-XP, x-mswin-936, x-PCK, x-SJIS_0213, x-UTF-16LE-BOM, X-UTF-32BE-BOM, X-UTF-32LE-BOM, x-windows-50220, x-windows-50221, x-windows-874, x-windows-949, x-windows-950, x-windows-iso2022jp.
- Supports automatic identification of file character sets:[Encodings that can be detected](https://github.com/albfernandez/juniversalchardet?tab=readme-ov-file#encodings-that-can-be-detected).

---

## Dependencies

This project requires the following libraries:

- [**juniversalchardet**](https://github.com/albfernandez/juniversalchardet): Used for character encoding detection.
- [**OpenJFX**](https://openjfx.io/): JavaFX library for building the graphical user interface.

---

## Functional introduction of each version

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

## Main interface of each version

![MagicEncoding4.0.0_EN](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fbec5cc32-9058-45d2-baeb-3b24dfc55b96%2FMagicEncoding4.0.0_EN.png?table=block&id=100e64bd-e40f-8088-9b6a-ce06348c8739&t=100e64bd-e40f-8088-9b6a-ce06348c8739&width=1624&cache=v2)

MagicEncoding4.0.0_EN

![MagicEncoding3.0.0_EN](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fa48f9fb0-5ca9-4b3e-aa65-5c0b9b8f53a4%2FMagicEncoding3.0.0_EN.png?table=block&id=e473a771-1ea7-42ab-9cc2-b124f8610072&t=e473a771-1ea7-42ab-9cc2-b124f8610072&width=1624&cache=v2)

MagicEncoding3.0.0_EN

![MagicEncoding2.0.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fbf42de01-57d9-4f5d-bb7c-3490b0db7ee1%2FMagicEncoding2.0.0.png?table=block&id=7ce8da63-3633-47ff-848c-94492101089c&t=7ce8da63-3633-47ff-848c-94492101089c&width=1624&cache=v2)

MagicEncoding2.0.0

![MagicEncoding1.0.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2Fa91b3a7d-672f-4ea2-b167-4657fef038dc%2FMagicEncoding1.0.0.png?table=block&id=ed5e4ef9-7816-4961-9740-d423c5681168&t=ed5e4ef9-7816-4961-9740-d423c5681168&width=1624&cache=v2)

MagicEncoding1.0.0
